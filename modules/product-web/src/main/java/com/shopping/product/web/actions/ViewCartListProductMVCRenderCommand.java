package com.shopping.product.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.CartList;
import com.onlineshopping.product.service.model.CartListProduct;
import com.onlineshopping.product.service.service.CartListLocalServiceUtil;
import com.onlineshopping.product.service.service.CartListProductLocalServiceUtil;
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
                "mvc.command.name=" + MVCCommandNames.VIEW_CART_LIST_PRODUCT
        },
        service = MVCRenderCommand.class
)
public class ViewCartListProductMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        getUserCartListProducts(renderRequest, renderResponse);
        return "/cart-list-products.jsp";
    }

    public void getUserCartListProducts(RenderRequest renderRequest, RenderResponse renderResponse) {
        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(renderRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(renderRequest, "user-not-found");
            return;
        }

        CartList cartList = CartListLocalServiceUtil.getCartListByUserId(user.getUserId());
        List<CartListProduct> cartListProducts = CartListProductLocalServiceUtil.getUserCartListProducts(Validator.isNotNull(cartList) ? cartList.getId() : 0L);

        List<JSONObject> productsList;
        if (Validator.isNull(cartListProducts) || cartListProducts.isEmpty()) {
            SessionErrors.add(renderRequest, "no-products-exists");
            return;
        }

        productsList = OnlineShoppingUtility.getJsonProductsList(cartListProducts);

        renderRequest.setAttribute("cartListProducts", productsList);
        renderRequest.setAttribute("cartListId", cartList.getId());
        renderRequest.setAttribute("productsCount", productsList.size());
        String currentURL = PortalUtil.getCurrentURL(renderRequest);
        renderRequest.setAttribute("redirectURL", currentURL);
    }

    private static final Log _log = LogFactoryUtil.getLog(ViewCartListProductMVCRenderCommand.class);

}
