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

import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.service.base.ProductServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ProductServiceImpl extends ProductServiceBaseImpl {

    public Product addProduct(String productName, String productInfo, String color, long ratingCount, double rating, long price, long discount, int discountPercentage, long finalPrice, String gender, long brandId, long highlightsId, int productCount) {
        return productLocalService.addProduct(productName, productInfo, color, ratingCount, rating, price, discount, discountPercentage, finalPrice, gender, brandId,highlightsId, productCount);
    }

    public Product updateProduct(long productId, String productName, String productInfo, String color, long ratingCount, double rating, long price, long discount, int discountPercentage, long finalPrice, int productCount) {
        return productLocalService.updateProduct(productId, productName, productInfo, color, ratingCount, rating, price, discount, discountPercentage, finalPrice, productCount);
    }

    public List<Product> getProductsByGender(String gender) {
        return productLocalService.getProductsByGender(gender);
    }

    public List<Product> getProductsByFiltering(String gender, String[] brands, String[] prices, String[] discounts) {
        return  productLocalService.getProductsByFiltering(gender, brands, prices, discounts);
    }
    
}