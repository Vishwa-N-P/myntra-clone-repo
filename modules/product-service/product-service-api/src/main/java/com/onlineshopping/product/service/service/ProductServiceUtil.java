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

import com.onlineshopping.product.service.model.Product;

import java.util.List;

/**
 * Provides the remote service utility for Product. This utility wraps
 * <code>com.onlineshopping.product.service.service.impl.ProductServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @generated
 */
public class ProductServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.onlineshopping.product.service.service.impl.ProductServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Product addProduct(
		String productName, String productInfo, String color, long ratingCount,
		double rating, long price, long discount, int discountPercentage,
		long finalPrice, String gender, long brandId, long highlightsId,
		int productCount) {

		return getService().addProduct(
			productName, productInfo, color, ratingCount, rating, price,
			discount, discountPercentage, finalPrice, gender, brandId,
			highlightsId, productCount);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Product> getProductsByFiltering(
		String gender, String[] brands, String[] prices, String[] discounts) {

		return getService().getProductsByFiltering(
			gender, brands, prices, discounts);
	}

	public static List<Product> getProductsByGender(String gender) {
		return getService().getProductsByGender(gender);
	}

	public static Product updateProduct(
		long productId, String productName, String productInfo, String color,
		long ratingCount, double rating, long price, long discount,
		int discountPercentage, long finalPrice, int productCount) {

		return getService().updateProduct(
			productId, productName, productInfo, color, ratingCount, rating,
			price, discount, discountPercentage, finalPrice, productCount);
	}

	public static ProductService getService() {
		return _service;
	}

	private static volatile ProductService _service;

}