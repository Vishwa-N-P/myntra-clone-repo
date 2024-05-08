package com.shopping.product.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.CartListProduct;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.service.CartListLocalServiceUtil;
import com.onlineshopping.product.service.service.CartListProductLocalServiceUtil;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;
import com.onlineshopping.product.service.service.ProductOrderLocalServiceUtil;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.constats.Status;
import com.onlineshopping.product.service.service.helper.OnlineShoppingUtility;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.SAVE_PRODUCT_ORDER
        },
        service = MVCActionCommand.class
)
public class SaveProductOrderMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        processCartListProductOrder(actionRequest, actionResponse);
    }

    public void processCartListProductOrder(ActionRequest actionRequest, ActionResponse actionResponse) {

        ThemeDisplay themeDisplay = OnlineShoppingUtility.getThemeDisplayFromRequest(actionRequest);
        User user = null;
        if (Validator.isNotNull(themeDisplay)) {
            user = themeDisplay.getUser();
        }
        if (Validator.isNull(user)) {
            SessionErrors.add(actionRequest, "user-not-found");
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);
            actionResponse.setRenderParameter("jspPage", "payment.jsp");
            return;
        }

        long cartListId = CartListLocalServiceUtil.getCartListByUserId(user.getUserId()).getId();
        long addressId = ParamUtil.getLong(actionRequest, ShoppingContants.ADDRESS_ID);

        List<CartListProduct> cartListProducts = CartListProductLocalServiceUtil.getUserCartListProducts(cartListId);
        for (CartListProduct cartListProduct : cartListProducts) {
            Product product = ProductLocalServiceUtil.fetchProduct(cartListProduct.getProductId());
            int count = (product.getProductCount()-cartListProduct.getQuantity());
            product.setProductCount(count);
            if (count == 0) {
                product.setStatus(Status.OUT_OF_STOCK);
            }

            ProductLocalServiceUtil.updateProduct(product);
            int quantity = cartListProduct.getQuantity();
            ProductOrderLocalServiceUtil.addProductOrder(cartListProduct.getProductId(), cartListProduct.getSize(), quantity, ((long) quantity *product.getFinalPrice()), user.getUserId(), addressId);
            CartListProductLocalServiceUtil.deleteUserCartListProduct(cartListId, cartListProduct.getProductId(), cartListProduct.getSize());
        }

        Address address = AddressLocalServiceUtil.fetchAddress(addressId);
        actionRequest.setAttribute("address", address);
        actionResponse.setRenderParameter("jspPage", "/confirmation.jsp");

    }

    private static final Log _log = LogFactoryUtil.getLog(SaveProductOrderMVCActionCommand.class);
}
