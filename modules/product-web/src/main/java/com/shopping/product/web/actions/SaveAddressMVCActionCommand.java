package com.shopping.product.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import com.onlineshopping.product.service.service.helper.AddressService;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB, "mvc.command.name=" + MVCCommandNames.SAVE_ADDRESS}, service = MVCActionCommand.class)
public class SaveAddressMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        processAddress(actionRequest, actionResponse);
    }

    public void processAddress(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletModeException {

        boolean deleteAddress = ParamUtil.getBoolean(actionRequest, ShoppingContants.DELETE_ADDRESS);
        long addressId = ParamUtil.getLong(actionRequest, ShoppingContants.ADDRESS_ID);

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(actionRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }

        if (Validator.isNull(user)) {
            SessionErrors.add(actionRequest, "user-not-found");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", "address.jsp");
            return;
        }

        if (deleteAddress) {
            Address userAddress = AddressLocalServiceUtil.fetchAddress(addressId);
            if (Validator.isNull(userAddress) || (Validator.isNotNull(userAddress) && userAddress.getUserId() != user.getUserId())) {
                SessionErrors.add(actionRequest, "user-address-not-found");
                PortalUtil.copyRequestParameters(actionRequest, actionResponse);
                actionResponse.setRenderParameter("jspPage", "address.jsp");
                return;
            }
            AddressService.deleteUserAddress(addressId);
            SessionMessages.add(actionRequest, "address-deleted");
        } else {
            String name = ParamUtil.getString(actionRequest, ShoppingContants.NAME);
            String phone = ParamUtil.getString(actionRequest, ShoppingContants.PHONE);
            String address = ParamUtil.getString(actionRequest, ShoppingContants.ADDRESS);
            int pinCode = ParamUtil.getInteger(actionRequest, ShoppingContants.PINCODE);
            String city = ParamUtil.getString(actionRequest, ShoppingContants.CITY);
            String state = ParamUtil.getString(actionRequest, ShoppingContants.STATE);

            AddressService.addOrUpdateAddress(addressId, user.getUserId(), name, phone, address, pinCode, city, state);
        }
        actionResponse.sendRedirect( ParamUtil.getString(actionRequest,"redirectURL"));
    }

    private static final Log _log = LogFactoryUtil.getLog(SaveAddressMVCActionCommand.class);
}
