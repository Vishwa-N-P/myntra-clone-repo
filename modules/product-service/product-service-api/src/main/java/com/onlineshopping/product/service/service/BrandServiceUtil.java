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

import com.onlineshopping.product.service.model.Brand;

import java.util.List;

/**
 * Provides the remote service utility for Brand. This utility wraps
 * <code>com.onlineshopping.product.service.service.impl.BrandServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BrandService
 * @generated
 */
public class BrandServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.onlineshopping.product.service.service.impl.BrandServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Brand addProductBrand(String brandName) {
		return getService().addProductBrand(brandName);
	}

	public static Brand getBrandByName(String brandName) {
		return getService().getBrandByName(brandName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Long> getProductBrands(String gender) {
		return getService().getProductBrands(gender);
	}

	public static BrandService getService() {
		return _service;
	}

	private static volatile BrandService _service;

}