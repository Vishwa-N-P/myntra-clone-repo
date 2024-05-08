package com.shopping.product.web.actions;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.Brand;
import com.onlineshopping.product.service.model.Image;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.model.ProductOrder;
import com.onlineshopping.product.service.service.BrandLocalServiceUtil;
import com.onlineshopping.product.service.service.ImageLocalServiceUtil;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;
import com.onlineshopping.product.service.service.ProductOrderLocalServiceUtil;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.VIEW_PRODUCT_ORDER
        },
        service = MVCRenderCommand.class
)
public class ViewProductOrderMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        getUserProductOrders(renderRequest, renderResponse);
        return "/product-order.jsp";
    }

    public void getUserProductOrders(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(renderRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(renderRequest, "user-not-found");
            return;
        }

        List<ProductOrder> productOrderList = ProductOrderLocalServiceUtil.getProductOrderList(user.getUserId());
        if (Validator.isNull(productOrderList) || productOrderList.isEmpty()) {
            SessionErrors.add(renderRequest, "no-ordered-products-exists");
            return;
        }

        List<JSONObject> productsList = new ArrayList<>();
        for (ProductOrder productOrder : productOrderList) {
            Product product = ProductLocalServiceUtil.getProductById(productOrder.getProductId());
            Brand brand = BrandLocalServiceUtil.getProductBrand(product.getBrandId());
            String image = OnlineShoppingUtility.getSingleImage(product.getId());

            JSONObject jsonProduct = JSONFactoryUtil.createJSONObject();
            jsonProduct.put("productName", Validator.isNotNull(product) ? product.getProductName() : "");
            jsonProduct.put("image", image);
            jsonProduct.put("brand", Validator.isNotNull(brand) ? brand.getBrandName() : "");
            jsonProduct.put("productOrder", productOrder);

            productsList.add(jsonProduct);
        }
        renderRequest.setAttribute("productOrders", productsList);
    }

    private static final Log _log = LogFactoryUtil.getLog(ViewProductOrderMVCRenderCommand.class);

}
