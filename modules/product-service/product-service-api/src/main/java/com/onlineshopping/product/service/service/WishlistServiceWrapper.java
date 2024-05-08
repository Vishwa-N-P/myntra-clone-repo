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
 * Provides a wrapper for {@link WishlistService}.
 *
 * @author Brian Wing Shun Chan
 * @see WishlistService
 * @generated
 */
public class WishlistServiceWrapper
	implements ServiceWrapper<WishlistService>, WishlistService {

	public WishlistServiceWrapper(WishlistService wishlistService) {
		_wishlistService = wishlistService;
	}

	@Override
	public com.onlineshopping.product.service.model.Wishlist
		addOrGetUserWishlist(long userId) {

		return _wishlistService.addOrGetUserWishlist(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wishlistService.getOSGiServiceIdentifier();
	}

	@Override
	public WishlistService getWrappedService() {
		return _wishlistService;
	}

	@Override
	public void setWrappedService(WishlistService wishlistService) {
		_wishlistService = wishlistService;
	}

	private WishlistService _wishlistService;

}