package com.shopping.product.web.actions;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.CartList;
import com.onlineshopping.product.service.model.CartListProduct;
import com.onlineshopping.product.service.service.CartListLocalServiceUtil;
import com.onlineshopping.product.service.service.CartListProductLocalServiceUtil;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.onlineshopping.product.service.service.validation.ProductValidator;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.DELETE_CART_LIST_PRODUCT
        },
        service = MVCActionCommand.class
)
public class DeleteCartListProductMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        deleteCartListProduct(actionRequest, actionResponse);
    }

    public void deleteCartListProduct(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(actionRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(actionRequest, "user-not-found");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", "/cart-list-products.jsp");
            return;
        }

        long productId = ParamUtil.getLong(actionRequest, ShoppingContants.PRODUCT_ID);
        long cartListId = ParamUtil.getLong(actionRequest, ShoppingContants.CART_LIST_ID);
        String size = ParamUtil.getString(actionRequest, ShoppingContants.PRODUCT_SIZE);

        if (!ProductValidator.isProductPresent(productId)) {
            SessionErrors.add(actionRequest, "no-product-exists");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", "/cart-list-products.jsp");
            return;
        }

        CartList userCartList = CartListLocalServiceUtil.getCartListByUserId(user.getUserId());
        if (Validator.isNull(userCartList) || cartListId != userCartList.getId()) {
            SessionErrors.add(actionRequest, "no-user-cart-exists");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", "/cart-list-products.jsp");
            return;
        }

        CartListProductLocalServiceUtil.deleteUserCartListProduct(cartListId, productId, size);
        SessionMessages.add(actionRequest, "deleted-from-bag");
        List<CartListProduct> cartListProducts = CartListProductLocalServiceUtil.getUserCartListProducts(userCartList.getId());

        if (Validator.isNull(cartListProducts) || cartListProducts.isEmpty()) {
            SessionErrors.add(actionRequest, "no-products-exists");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", "/cart-list-products.jsp");
            return;
        }

        actionResponse.sendRedirect( ParamUtil.getString(actionRequest,"redirectURL"));
    }

    private static final Log _log = LogFactoryUtil.getLog(DeleteCartListProductMVCActionCommand.class);
}
