package com.shopping.product.web.actions;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.model.Wishlist;
import com.onlineshopping.product.service.model.WishlistProduct;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;
import com.onlineshopping.product.service.service.WishlistLocalServiceUtil;
import com.onlineshopping.product.service.service.WishlistProductLocalServiceUtil;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.onlineshopping.product.service.service.validation.ProductValidator;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.SAVE_WISHLIST_PRODUCT
        },
        service = MVCActionCommand.class
)
public class SaveWishlistMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        addProductToWishlist(actionRequest, actionResponse);
    }

    public void addProductToWishlist(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletModeException {

        long productId = ParamUtil.getLong(actionRequest, ShoppingContants.PRODUCT_ID);
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

        Wishlist wishlist = WishlistLocalServiceUtil.addOrGetUserWishlist(user.getUserId());
        WishlistProduct draftWishlistProduct = WishlistProductLocalServiceUtil.getProductByWishlistIdProductId(wishlist.getId(), productId);
        if (Validator.isNull(draftWishlistProduct)) {
            WishlistProductLocalServiceUtil.addWishlistProduct(wishlist.getId(), productId);
        }
        SessionMessages.add(actionRequest, "added-to-wishlist");

        actionResponse.sendRedirect( ParamUtil.getString(actionRequest,"redirectURL"));

    }

    private static final Log _log = LogFactoryUtil.getLog(SaveWishlistMVCActionCommand.class);

}
