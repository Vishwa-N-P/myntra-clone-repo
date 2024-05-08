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
 * Provides a wrapper for {@link ProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @generated
 */
public class ProductServiceWrapper
	implements ProductService, ServiceWrapper<ProductService> {

	public ProductServiceWrapper(ProductService productService) {
		_productService = productService;
	}

	@Override
	public com.onlineshopping.product.service.model.Product addProduct(
		String productName, String productInfo, String color, long ratingCount,
		double rating, long price, long discount, int discountPercentage,
		long finalPrice, String gender, long brandId, long highlightsId,
		int productCount) {

		return _productService.addProduct(
			productName, productInfo, color, ratingCount, rating, price,
			discount, discountPercentage, finalPrice, gender, brandId,
			highlightsId, productCount);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.Product>
		getProductsByFiltering(
			String gender, String[] brands, String[] prices,
			String[] discounts) {

		return _productService.getProductsByFiltering(
			gender, brands, prices, discounts);
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.Product>
		getProductsByGender(String gender) {

		return _productService.getProductsByGender(gender);
	}

	@Override
	public com.onlineshopping.product.service.model.Product updateProduct(
		long productId, String productName, String productInfo, String color,
		long ratingCount, double rating, long price, long discount,
		int discountPercentage, long finalPrice, int productCount) {

		return _productService.updateProduct(
			productId, productName, productInfo, color, ratingCount, rating,
			price, discount, discountPercentage, finalPrice, productCount);
	}

	@Override
	public ProductService getWrappedService() {
		return _productService;
	}

	@Override
	public void setWrappedService(ProductService productService) {
		_productService = productService;
	}

	private ProductService _productService;

}