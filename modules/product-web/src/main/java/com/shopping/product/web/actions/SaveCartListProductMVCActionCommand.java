package com.shopping.product.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
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
import com.onlineshopping.product.service.model.Wishlist;
import com.onlineshopping.product.service.service.CartListLocalServiceUtil;
import com.onlineshopping.product.service.service.CartListProductLocalServiceUtil;
import com.onlineshopping.product.service.service.WishlistLocalServiceUtil;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.onlineshopping.product.service.service.validation.ProductValidator;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.omg.CORBA.portable.ValueOutputStream;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.SAVE_CART_LIST_PRODUCT
        },
        service = MVCActionCommand.class
)
public class SaveCartListProductMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        processProductToCartList(actionRequest, actionResponse);
    }

    public void processProductToCartList(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletModeException {

        long productId = ParamUtil.getLong(actionRequest, ShoppingContants.PRODUCT_ID);
        String size = ParamUtil.getString(actionRequest, ShoppingContants.PRODUCT_SIZE);
        int quantity = ParamUtil.getInteger(actionRequest, ShoppingContants.QUANTITY, 1);
        String jspPage = ParamUtil.getString(actionRequest, ShoppingContants.JSP_PAGE);

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(actionRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(actionRequest, "user-not-found");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", jspPage);
            return;
        }

        if (!ProductValidator.isProductPresent(productId)) {
            SessionErrors.add(actionRequest, "no-product-exists");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", jspPage);
            return;
        }

        CartList cartList = CartListLocalServiceUtil.addOrGetUserCartList(user.getUserId());
        CartListProduct cartListProduct = CartListProductLocalServiceUtil.getUserCartListProduct(cartList.getId(), productId, size);
        if (Validator.isNull(cartListProduct)){
            CartListProductLocalServiceUtil.addCartListProduct(cartList.getId(), productId, size, quantity);
            SessionMessages.add(actionRequest, "added-to-bag");
        } else {
            SessionMessages.add(actionRequest, "already-added-to-bag");
        }

        PortletSession session = actionRequest.getPortletSession();
        session.setAttribute("selectedSize", size);
        actionResponse.sendRedirect( ParamUtil.getString(actionRequest,"redirectURL"));

    }

    private static final Log _log = LogFactoryUtil.getLog(SaveCartListProductMVCActionCommand.class);
}
