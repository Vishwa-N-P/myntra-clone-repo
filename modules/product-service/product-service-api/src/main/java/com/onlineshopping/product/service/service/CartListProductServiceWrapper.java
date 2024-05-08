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
 * Provides a wrapper for {@link CartListProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see CartListProductService
 * @generated
 */
public class CartListProductServiceWrapper
	implements CartListProductService, ServiceWrapper<CartListProductService> {

	public CartListProductServiceWrapper(
		CartListProductService cartListProductService) {

		_cartListProductService = cartListProductService;
	}

	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		addCartListProduct(
			long cartListId, long productId, String size, int quantity) {

		return _cartListProductService.addCartListProduct(
			cartListId, productId, size, quantity);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cartListProductService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.CartListProduct>
			getUserCartListProducts(long cartListId) {

		return _cartListProductService.getUserCartListProducts(cartListId);
	}

	@Override
	public CartListProductService getWrappedService() {
		return _cartListProductService;
	}

	@Override
	public void setWrappedService(
		CartListProductService cartListProductService) {

		_cartListProductService = cartListProductService;
	}

	private CartListProductService _cartListProductService;

}