/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.onlineshopping.product.service.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchCartListProductException;
import com.onlineshopping.product.service.model.CartListProduct;
import com.onlineshopping.product.service.service.CartListProductLocalServiceUtil;
import com.onlineshopping.product.service.service.base.CartListProductLocalServiceBaseImpl;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.persistence.CartListProductPK;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class CartListProductLocalServiceImpl
        extends CartListProductLocalServiceBaseImpl {

    public CartListProduct addCartListProduct(long cartListId, long productId, String size, int quantity) {

        CartListProduct cartListProduct = createCartListProduct(counterLocalService.increment(CartListProduct.class.getName()));
        cartListProduct.setCartListId(cartListId);
        if (productId > 0) {
            cartListProduct.setProductId(productId);
        }
        if (size != null) {
            cartListProduct.setSize(size);
        }
        if (quantity > 0) {
            cartListProduct.setQuantity(quantity);
        }
        return addCartListProduct(cartListProduct);
    }

    public CartListProduct getCartProductByCartListIdProductId(long cartListId, long productId) {
        try {
            return cartListProductPersistence.findByCartListIdProductId(cartListId, productId);
        } catch (NoSuchCartListProductException e) {
            _log.error(e.getMessage());
        }
        return null;
    }

    public CartListProduct getUserCartListProduct(long cartListId, long productId, String size) {
        try {
            return cartListProductPersistence.findByCartListIdProductIdSize(cartListId, productId, size);
        } catch (NoSuchCartListProductException e) {
            _log.error(e.getMessage());
        }
        return null;
    }

    public List<CartListProduct> getUserCartListProducts(long cartListId) {
        DynamicQuery dynamicQuery = CartListProductLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.eq(ShoppingContants.CART_LIST_ID, cartListId));
        return CartListProductLocalServiceUtil.dynamicQuery(dynamicQuery);
    }

    public void deleteUserCartListProduct(long cartListId, long productId, String size) {
        CartListProduct cartListProduct = getUserCartListProduct(cartListId, productId, size);
        try {
            CartListProductLocalServiceUtil.deleteCartListProduct(cartListProduct.getId());
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
    }

    public static final Log _log = LogFactoryUtil.getLog(CartListProductLocalServiceImpl.class);

}