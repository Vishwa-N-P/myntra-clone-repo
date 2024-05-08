/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.onlineshopping.product.service.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchWishlistException;
import com.onlineshopping.product.service.model.Wishlist;
import com.onlineshopping.product.service.service.base.WishlistLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true)
public class WishlistLocalServiceImpl extends WishlistLocalServiceBaseImpl {

    public Wishlist addOrGetUserWishlist(long userId) {
        Wishlist wishlist = getWishlistByUserId(userId);
        if (Validator.isNotNull(wishlist)) {
            _log.info("Wishlist exist");
            return wishlist;
        }
        wishlist = createWishlist(counterLocalService.increment(Wishlist.class.getName()));
        wishlist.setUserId(userId);
        return addWishlist(wishlist);
    }

    public Wishlist getWishlistByUserId(long userId) {
        try {
            return wishlistPersistence.findByUserId(userId);
        } catch (NoSuchWishlistException e) {
            _log.error(e.getMessage());
        }
        return null;
    }

    public static final Log _log = LogFactoryUtil.getLog(WishlistLocalServiceImpl.class);
}