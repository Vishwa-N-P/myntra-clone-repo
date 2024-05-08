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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.onlineshopping.product.service.exception.NoSuchWishlistProductException;
import com.onlineshopping.product.service.model.WishlistProduct;
import com.onlineshopping.product.service.service.WishlistProductLocalServiceUtil;
import com.onlineshopping.product.service.service.base.WishlistProductLocalServiceBaseImpl;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.persistence.WishlistProductPK;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class WishlistProductLocalServiceImpl
        extends WishlistProductLocalServiceBaseImpl {

    public WishlistProduct addWishlistProduct(long wishlistId, long productId) {
        WishlistProduct wishlistProduct = createWishlistProduct(counterLocalService.increment(WishlistProduct.class.getName()));
        wishlistProduct.setWishlistId(wishlistId);
        wishlistProduct.setProductId(productId);
        return addWishlistProduct(wishlistProduct);
    }

    public WishlistProduct getProductByWishlistIdProductId(long wishlistId, long productId) {
        WishlistProduct wishlistProduct = null;
        try {
            wishlistProduct = wishlistProductPersistence.findByWishlistIdProductId(wishlistId, productId);
        } catch (NoSuchWishlistProductException e) {
            _log.error(e.getMessage());
        }
        return wishlistProduct;
    }

    public List<Long> getUserWishlistProducts(long wishlistId) {
        List<Long> productIds = new ArrayList<>();
        try {
            DynamicQuery dynamicQuery = WishlistProductLocalServiceUtil.dynamicQuery();
            dynamicQuery.add(PropertyFactoryUtil.forName(ShoppingContants.WISHLIST_ID).eq(wishlistId));
            dynamicQuery.setProjection(ProjectionFactoryUtil.property(ShoppingContants.PRODUCT_ID));
            productIds = WishlistProductLocalServiceUtil.dynamicQuery(dynamicQuery);
        } catch (Exception e) {
            _log.error(e.getMessage());
        }
        return productIds;
    }

    public void deleteUserWishlistProduct(long wishlistId, long productId) {
        WishlistProduct wishlistProduct = getProductByWishlistIdProductId(wishlistId, productId);
        try {
            WishlistProductLocalServiceUtil.deleteWishlistProduct(wishlistProduct.getId());
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
    }

    public static final Log _log = LogFactoryUtil.getLog(WishlistProductLocalServiceImpl.class);

}