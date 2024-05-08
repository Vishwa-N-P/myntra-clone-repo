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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchCategoryException;
import com.onlineshopping.product.service.model.ProductCategory;
import com.onlineshopping.product.service.service.ProductCategoryLocalServiceUtil;
import com.onlineshopping.product.service.service.base.ProductCategoryLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ProductCategoryLocalServiceImpl
	extends ProductCategoryLocalServiceBaseImpl {
	
	public ProductCategory addProductCategory(String categoryName) {
		ProductCategory productCategory = getProductCategoryByName(categoryName);
		if (Validator.isNotNull(productCategory)) {
			_log.info("Category exists");
			return productCategory;
		}
		productCategory = createProductCategory(counterLocalService.increment(ProductCategory.class.getName()));
		productCategory.setCategoryName(categoryName);
		return addProductCategory(productCategory);
	}

	public ProductCategory getProductCategoryByName(String categoryName) {
		ProductCategory productCategory = null;
		try {
			productCategory =productCategoryPersistence.findByCategoryName(categoryName);
		} catch (NoSuchCategoryException e) {
			_log.error(e.getMessage());
		}
		return productCategory;
	}

	public ProductCategory updateProductCategory(long categoryId, String categoryName) {

		ProductCategory productCategory = fetchProductCategory(categoryId);
		productCategory.setCategoryName(categoryName);
		return updateProductCategory(productCategory);
	}

	public ProductCategory getProductCategoryById(long productCategoryId) {
		ProductCategory productCategory = null;
		try {
			productCategory = getProductCategory(productCategoryId);
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		return productCategory;
	}
	
	public List<ProductCategory> getProductCategories() {
		DynamicQuery dynamicQuery = ProductCategoryLocalServiceUtil.dynamicQuery();
		List<ProductCategory> categoryList = ProductCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		return categoryList;
	}

	public ProductCategory deleteProductCategoryById(long categoryId) {
		ProductCategory productCategory = null;
		try {
			productCategory = deleteProductCategory(categoryId);
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		return productCategory;
	}
	
	public static Log _log = LogFactoryUtil.getLog(ProductCategoryLocalServiceImpl.class);
}