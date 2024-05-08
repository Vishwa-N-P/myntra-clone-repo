package com.shopping.product.web.actions;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.*;
import com.onlineshopping.product.service.model.Product;
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
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.VIEW_PRODUCT
        },
        service = MVCRenderCommand.class
)
public class ViewProductMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        getProduct(renderRequest, renderResponse);
        return "/product.jsp";
    }

    public void getProduct(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(renderRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(renderRequest, "user-not-found");
            return;
        }

        long productId = ParamUtil.getLong(renderRequest, ShoppingContants.PRODUCT_ID);
        boolean isWishlisted = ParamUtil.getBoolean(renderRequest, ShoppingContants.IS_WISHLISTED);

        Product product = ProductLocalServiceUtil.getProductById(productId);

        if (productId <= 0 || Validator.isNull(product)) {
            SessionErrors.add(renderRequest, "no-product-exists");
            return;
        }

        if (!isWishlisted) {
            Wishlist wishlist = WishlistLocalServiceUtil.getWishlistByUserId(user.getUserId());
            isWishlisted = Validator.isNotNull(WishlistProductLocalServiceUtil.getProductByWishlistIdProductId((Validator.isNotNull(wishlist) ? wishlist.getId() : 0L), productId)) ? ShoppingContants.TRUE : ShoppingContants.FALSE;
        }

        Brand brand = BrandLocalServiceUtil.getProductBrand(product.getBrandId());
        List<Image> images = ImageLocalServiceUtil.getProductImages(product.getId());
        Highlights highlights = HighlightsLocalServiceUtil.getHighlightsById(product.getHighlightsId());

        PortletSession session = renderRequest.getPortletSession();
        renderRequest.setAttribute("isWishlisted", isWishlisted);
        renderRequest.setAttribute("selectedSize", session.getAttribute("selectedSize"));
        session.removeAttribute("selectedSize");
        String currentURL = PortalUtil.getCurrentURL(renderRequest);
        renderRequest.setAttribute("redirectURL", currentURL);

        renderRequest.setAttribute("product", product);
        renderRequest.setAttribute("images", images);
        renderRequest.setAttribute("brand", Validator.isNotNull(brand) ? brand.getBrandName() : "");
        renderRequest.setAttribute("highlights", highlights);
        renderRequest.setAttribute("isWishlisted", isWishlisted);

    }

}
