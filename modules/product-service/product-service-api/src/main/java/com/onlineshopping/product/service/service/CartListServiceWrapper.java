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
 * Provides a wrapper for {@link CartListService}.
 *
 * @author Brian Wing Shun Chan
 * @see CartListService
 * @generated
 */
public class CartListServiceWrapper
	implements CartListService, ServiceWrapper<CartListService> {

	public CartListServiceWrapper(CartListService cartListService) {
		_cartListService = cartListService;
	}

	@Override
	public com.onlineshopping.product.service.model.CartList
		addOrGetUserCartList(long customerId) {

		return _cartListService.addOrGetUserCartList(customerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cartListService.getOSGiServiceIdentifier();
	}

	@Override
	public CartListService getWrappedService() {
		return _cartListService;
	}

	@Override
	public void setWrappedService(CartListService cartListService) {
		_cartListService = cartListService;
	}

	private CartListService _cartListService;

}