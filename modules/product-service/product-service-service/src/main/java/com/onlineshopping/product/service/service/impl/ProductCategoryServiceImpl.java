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

import com.onlineshopping.product.service.model.ProductCategory;
import com.onlineshopping.product.service.service.base.ProductCategoryServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ProductCategoryServiceImpl extends ProductCategoryServiceBaseImpl {
    
    public ProductCategory addProductCategory(String categoryName){
        return productCategoryLocalService.addProductCategory(categoryName);
    }
    
    public ProductCategory updateProductCategory(long categoryId, String categoryName) {
        return productCategoryLocalService.updateProductCategory(categoryId, categoryName);
    }

    public List<ProductCategory> getProductCategories() {
        return productCategoryLocalService.getProductCategories();
    }
    
}