package com.onlineshopping.product.service.service.validation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.service.CartListProductLocalServiceUtil;

public class CartListProductValidator {

    public static boolean isProductExistInCartList(long cartListId, long productId, String size) {

        if (Validator.isNotNull(CartListProductLocalServiceUtil.getUserCartListProduct(cartListId, productId, size))) {
            _log.error("Product exist in cart list");
            return true;
        }
        return false;
    }

    private static final Log _log = LogFactoryUtil.getLog(CartListProductValidator.class);

}
