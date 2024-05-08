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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchCartListException;
import com.onlineshopping.product.service.model.CartList;
import com.onlineshopping.product.service.service.base.CartListLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class CartListLocalServiceImpl extends CartListLocalServiceBaseImpl {

    public CartList addOrGetUserCartList(long userId) {
        if (userId <= 0 || Validator.isNull(UserLocalServiceUtil.fetchUser(userId))) {
            _log.info("Invalid user Id");
            return null;
        }

        CartList cartList = getCartListByUserId(userId);
        if (Validator.isNotNull(cartList)) {
            _log.info("Cart list exist");
            return cartList;
        }
        cartList = createCartList(counterLocalService.increment(CartList.class.getName()));
        cartList.setUserId(userId);
        return addCartList(cartList);
    }

    public CartList getCartListByUserId(long userId) {
        CartList cartList = null;
        try {
            cartList = cartListPersistence.findByUserId(userId);
        } catch (NoSuchCartListException e) {
            _log.error(e.getMessage());
        }
        return cartList;
    }

    public static final Log _log = LogFactoryUtil.getLog(CartListLocalServiceImpl.class);
}