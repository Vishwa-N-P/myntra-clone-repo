package com.shopping.product.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.onlineshopping.product.service.model.Brand;
import com.onlineshopping.product.service.model.Image;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.model.Wishlist;
import com.onlineshopping.product.service.service.*;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.VIEW_PRODUCTS
        },
        service = MVCRenderCommand.class
)
public class ViewProductsMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        getAllProducts(renderRequest, renderResponse);
        return "/products.jsp";
    }

    public void getAllProducts(RenderRequest renderRequest, RenderResponse renderResponse) {

        boolean filter = ParamUtil.getBoolean(renderRequest, ShoppingContants.FILTER);
        String gender = ParamUtil.getString(renderRequest, ShoppingContants.GENDER);

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(renderRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(renderRequest, "user-not-found");
            return;
        }

        if (Validator.isNull(gender)) {
            SessionErrors.add(renderRequest, "no-category-found");
            return;
        }

        List<Product> products = new ArrayList<>();
        if (filter) {
            String[] checkedBrands = ParamUtil.getParameterValues(renderRequest, "selectedBrand");
            String[] checkedPrices = ParamUtil.getParameterValues(renderRequest, "selectedPrice");
            String[] checkedDiscounts = ParamUtil.getParameterValues(renderRequest, "selectedDiscount");
            products = ProductLocalServiceUtil.getProductsByFiltering(gender, checkedBrands, checkedPrices, checkedDiscounts);

            renderRequest.setAttribute("checkedBrands", checkedBrands);
            renderRequest.setAttribute("checkedPrices", checkedPrices);
            renderRequest.setAttribute("checkedDiscounts", checkedDiscounts);

        } else {
            products = ProductLocalServiceUtil.getProductsByGender(gender);
        }

        List<JSONObject> productsList = new ArrayList<>();
        if (Validator.isNull(products) || products.isEmpty()) {
            SessionErrors.add(renderRequest, "no-products-exists");
            renderRequest.setAttribute("gender", gender);
            return;
        }

        List<Long> brandIds = BrandLocalServiceUtil.getProductBrands(gender);
        List<Brand> brands = new ArrayList<>();
        if (Validator.isNotNull(brandIds)) {
            for (Long brandId : brandIds) {
                Brand brand = BrandLocalServiceUtil.getProductBrand(brandId);
                if (Validator.isNotNull(brand) && !brands.contains(brand)) {
                    brands.add(brand);
                }
            }
        }

        for (Product product : products) {
            String brand = BrandLocalServiceUtil.getProductBrand(product.getBrandId()).getBrandName();
            String image = OnlineShoppingUtility.getSingleImage(product.getId());

            JSONObject jsonProduct = JSONFactoryUtil.createJSONObject();
            jsonProduct.put("product", product);
            jsonProduct.put("image", image);
            jsonProduct.put("brand", Validator.isNotNull(brand) ? brand : "");
            productsList.add(jsonProduct);
        }

        Wishlist wishlist = WishlistLocalServiceUtil.getWishlistByUserId(user.getUserId());
        List<Long> wishlistProducts = WishlistProductLocalServiceUtil.getUserWishlistProducts(Validator.isNotNull(wishlist) ? wishlist.getId() : 0L);

        if (Validator.isNotNull(wishlistProducts) && !wishlistProducts.isEmpty()) {
            renderRequest.setAttribute("wishlistProducts", wishlistProducts);
        }

        PortletSession session = renderRequest.getPortletSession();
        session.setAttribute("productsList", productsList);
        session.setAttribute("brands", brands);
        session.setAttribute("gender", gender);
        String currentURL = PortalUtil.getCurrentURL(renderRequest);
        renderRequest.setAttribute("redirectURL", currentURL);

    }

    private static final Log _log = LogFactoryUtil.getLog(ViewProductsMVCRenderCommand.class);
}
