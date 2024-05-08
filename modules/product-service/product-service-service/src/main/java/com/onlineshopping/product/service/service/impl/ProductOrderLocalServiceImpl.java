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
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.model.ProductOrder;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;
import com.onlineshopping.product.service.service.ProductOrderLocalServiceUtil;
import com.onlineshopping.product.service.service.base.ProductOrderLocalServiceBaseImpl;
import com.onlineshopping.product.service.service.constats.ShoppingContants;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ProductOrderLocalServiceImpl
        extends ProductOrderLocalServiceBaseImpl {

    public ProductOrder addProductOrder(long productId, String size, int quantity, long cost, long userId, long addressId) {
        ProductOrder productOrder = createProductOrder(counterLocalService.increment(ProductOrder.class.getName()));
        productOrder.setProductId(productId);
        if (size != null) {
            productOrder.setSize(size);
        }
        productOrder.setQuantity(quantity);
        productOrder.setCost(cost);
        productOrder.setUserId(userId);
        productOrder.setAddressId(addressId);
        return addProductOrder(productOrder);
    }

    public List<Product> getUserOrderedProducts(List<Long> productIds) {
        if (Validator.isNull(productIds) || productIds.size() == 0) {
            _log.error("User products not exist");
            return null;
        }
        List<Product> products = null;
        for (long productId : productIds) {
            products.add(ProductLocalServiceUtil.getProductById(productId));
        }
        return products;
    }

    public List<ProductOrder> getProductOrderList(long userId) {
        List<ProductOrder> productOrders = null;
        DynamicQuery dynamicQuery = ProductOrderLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(PropertyFactoryUtil.forName(ShoppingContants.USER_ID).eq(userId));
        productOrders = ProductOrderLocalServiceUtil.dynamicQuery(dynamicQuery);
        return productOrders;
    }

    public static final Log _log = LogFactoryUtil.getLog(ProductOrderLocalServiceImpl.class);

}