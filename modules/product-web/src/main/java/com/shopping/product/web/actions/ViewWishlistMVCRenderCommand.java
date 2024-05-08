package com.shopping.product.web.actions;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.Wishlist;
import com.onlineshopping.product.service.service.WishlistLocalServiceUtil;
import com.onlineshopping.product.service.service.WishlistProductLocalServiceUtil;
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
                "mvc.command.name=" + MVCCommandNames.VIEW_WISHLIST_PRODUCT
        },
        service = MVCRenderCommand.class
)
public class ViewWishlistMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        getUserWishlistProducts(renderRequest, renderResponse);
        return "/wishlist-products.jsp";
    }

    public void getUserWishlistProducts(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(renderRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(renderRequest, "user-not-found");
            return;
        }

        Wishlist wishlist = WishlistLocalServiceUtil.getWishlistByUserId(user.getUserId());
        List<Long> wishlistProducts = WishlistProductLocalServiceUtil.getUserWishlistProducts(Validator.isNotNull(wishlist) ? wishlist.getId() : 0L);

        if (Validator.isNull(wishlistProducts) || wishlistProducts.isEmpty()) {
            SessionErrors.add(renderRequest, "'no-product-exists'");
            return;
        }
        List<JSONObject> productsList = OnlineShoppingUtility.getJsonWishlistProductsList(wishlistProducts);
        renderRequest.setAttribute("productsCount", productsList.size());

        renderRequest.setAttribute("wishlistProducts", productsList);
        renderRequest.setAttribute("wishlistId", wishlist.getId());
        String currentURL = PortalUtil.getCurrentURL(renderRequest);
        renderRequest.setAttribute("redirectURL", currentURL);
    }

    private static final Log _log = LogFactoryUtil.getLog(ViewWishlistMVCRenderCommand.class);

}
