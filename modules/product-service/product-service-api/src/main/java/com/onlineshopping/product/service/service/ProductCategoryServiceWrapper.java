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

package com.onlineshopping.product.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductCategoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductCategoryService
 * @generated
 */
public class ProductCategoryServiceWrapper
	implements ProductCategoryService, ServiceWrapper<ProductCategoryService> {

	public ProductCategoryServiceWrapper(
		ProductCategoryService productCategoryService) {

		_productCategoryService = productCategoryService;
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		addProductCategory(String categoryName) {

		return _productCategoryService.addProductCategory(categoryName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productCategoryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.ProductCategory>
			getProductCategories() {

		return _productCategoryService.getProductCategories();
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		updateProductCategory(long categoryId, String categoryName) {

		return _productCategoryService.updateProductCategory(
			categoryId, categoryName);
	}

	@Override
	public ProductCategoryService getWrappedService() {
		return _productCategoryService;
	}

	@Override
	public void setWrappedService(
		ProductCategoryService productCategoryService) {

		_productCategoryService = productCategoryService;
	}

	private ProductCategoryService _productCategoryService;

}