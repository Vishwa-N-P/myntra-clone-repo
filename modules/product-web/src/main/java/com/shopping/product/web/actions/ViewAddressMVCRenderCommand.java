package com.shopping.product.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.helper.AddressService;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.VIEW_ADDRESS
        },
        service = MVCRenderCommand.class
)
public class ViewAddressMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String jspPage = getUserAddress(renderRequest, renderResponse);
        return jspPage;
    }

    public String getUserAddress(RenderRequest renderRequest, RenderResponse renderResponse) {

        boolean addAddress = ParamUtil.getBoolean(renderRequest, "addNewAddress");
        if (addAddress) {
            return "/add-address.jsp";
        }

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(renderRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(renderRequest, "user-not-found");
            return "/cart-list-products.jsp";
        }

        List<Address> addressList = AddressService.getAddressByUserId(user.getUserId());
        if (Validator.isNotNull(addressList) && !addressList.isEmpty()) {
            renderRequest.setAttribute("addressList", addressList);
            renderRequest.getPortletSession().setAttribute("redirectURL", PortalUtil.getCurrentURL(renderRequest));
            return ShoppingContants.ADDRESS_JSP;
        }
        return ShoppingContants.ADD_ADDRESS_JSP;
    }

    public static final Log _log = LogFactoryUtil.getLog(ViewAddressMVCRenderCommand.class);
}
