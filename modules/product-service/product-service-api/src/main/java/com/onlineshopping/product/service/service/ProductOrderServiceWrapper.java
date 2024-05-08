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
 * Provides a wrapper for {@link ProductOrderService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductOrderService
 * @generated
 */
public class ProductOrderServiceWrapper
	implements ProductOrderService, ServiceWrapper<ProductOrderService> {

	public ProductOrderServiceWrapper(ProductOrderService productOrderService) {
		_productOrderService = productOrderService;
	}

	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		addProductOrder(
			long productId, String size, int quantity, long cost, long userId,
			long addressId) {

		return _productOrderService.addProductOrder(
			productId, size, quantity, cost, userId, addressId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productOrderService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.ProductOrder>
		getProductOrderList(long userId) {

		return _productOrderService.getProductOrderList(userId);
	}

	@Override
	public ProductOrderService getWrappedService() {
		return _productOrderService;
	}

	@Override
	public void setWrappedService(ProductOrderService productOrderService) {
		_productOrderService = productOrderService;
	}

	private ProductOrderService _productOrderService;

}