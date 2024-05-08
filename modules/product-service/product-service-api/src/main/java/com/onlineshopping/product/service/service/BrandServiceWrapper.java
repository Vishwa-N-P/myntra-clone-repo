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
 * Provides a wrapper for {@link BrandService}.
 *
 * @author Brian Wing Shun Chan
 * @see BrandService
 * @generated
 */
public class BrandServiceWrapper
	implements BrandService, ServiceWrapper<BrandService> {

	public BrandServiceWrapper(BrandService brandService) {
		_brandService = brandService;
	}

	@Override
	public com.onlineshopping.product.service.model.Brand addProductBrand(
		String brandName) {

		return _brandService.addProductBrand(brandName);
	}

	@Override
	public com.onlineshopping.product.service.model.Brand getBrandByName(
		String brandName) {

		return _brandService.getBrandByName(brandName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _brandService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<Long> getProductBrands(String gender) {
		return _brandService.getProductBrands(gender);
	}

	@Override
	public BrandService getWrappedService() {
		return _brandService;
	}

	@Override
	public void setWrappedService(BrandService brandService) {
		_brandService = brandService;
	}

	private BrandService _brandService;

}