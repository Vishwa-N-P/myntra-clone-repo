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

import com.onlineshopping.product.service.model.WishlistProduct;
import com.onlineshopping.product.service.service.base.WishlistProductServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class WishlistProductServiceImpl extends WishlistProductServiceBaseImpl {

    public WishlistProduct addWishlistProduct(long wishlistId, long productId) {
        return wishlistProductLocalService.addWishlistProduct(wishlistId, productId);
    }

    public List<Long> getUserWishlistProducts(long wishlistId) {
        return wishlistProductLocalService.getUserWishlistProducts(wishlistId);
    }

}