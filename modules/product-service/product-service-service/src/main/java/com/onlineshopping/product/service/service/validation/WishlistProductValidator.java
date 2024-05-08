package com.onlineshopping.product.service.service.validation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.WishlistProduct;
import com.onlineshopping.product.service.service.WishlistProductLocalServiceUtil;

public class WishlistProductValidator {

    public static boolean isProductExistInWishlist(long wishlistId, long productId) {
        WishlistProduct wishlistProduct = WishlistProductLocalServiceUtil.getProductByWishlistIdProductId(wishlistId, productId);
        if (Validator.isNotNull(wishlistProduct)) {
            _log.error("Product exist in wishlist");
            return true;
        }
        return false;
    }

    private static final Log _log = LogFactoryUtil.getLog(WishlistProductValidator.class);
}
