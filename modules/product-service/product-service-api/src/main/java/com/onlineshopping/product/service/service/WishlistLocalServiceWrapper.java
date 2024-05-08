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
 * Provides a wrapper for {@link WishlistLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WishlistLocalService
 * @generated
 */
public class WishlistLocalServiceWrapper
	implements ServiceWrapper<WishlistLocalService>, WishlistLocalService {

	public WishlistLocalServiceWrapper(
		WishlistLocalService wishlistLocalService) {

		_wishlistLocalService = wishlistLocalService;
	}

	@Override
	public com.onlineshopping.product.service.model.Wishlist
		addOrGetUserWishlist(long userId) {

		return _wishlistLocalService.addOrGetUserWishlist(userId);
	}

	/**
	 * Adds the wishlist to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlist the wishlist
	 * @return the wishlist that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.Wishlist addWishlist(
		com.onlineshopping.product.service.model.Wishlist wishlist) {

		return _wishlistLocalService.addWishlist(wishlist);
	}

	/**
	 * Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	 *
	 * @param id the primary key for the new wishlist
	 * @return the new wishlist
	 */
	@Override
	public com.onlineshopping.product.service.model.Wishlist createWishlist(
		long id) {

		return _wishlistLocalService.createWishlist(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws PortalException if a wishlist with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.Wishlist deleteWishlist(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistLocalService.deleteWishlist(id);
	}

	/**
	 * Deletes the wishlist from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlist the wishlist
	 * @return the wishlist that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.Wishlist deleteWishlist(
		com.onlineshopping.product.service.model.Wishlist wishlist) {

		return _wishlistLocalService.deleteWishlist(wishlist);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wishlistLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _wishlistLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _wishlistLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _wishlistLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _wishlistLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _wishlistLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.Wishlist fetchWishlist(
		long id) {

		return _wishlistLocalService.fetchWishlist(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _wishlistLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _wishlistLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wishlistLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the wishlist with the primary key.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist
	 * @throws PortalException if a wishlist with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.Wishlist getWishlist(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistLocalService.getWishlist(id);
	}

	@Override
	public com.onlineshopping.product.service.model.Wishlist
		getWishlistByUserId(long userId) {

		return _wishlistLocalService.getWishlistByUserId(userId);
	}

	/**
	 * Returns a range of all the wishlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @return the range of wishlists
	 */
	@Override
	public java.util.List<com.onlineshopping.product.service.model.Wishlist>
		getWishlists(int start, int end) {

		return _wishlistLocalService.getWishlists(start, end);
	}

	/**
	 * Returns the number of wishlists.
	 *
	 * @return the number of wishlists
	 */
	@Override
	public int getWishlistsCount() {
		return _wishlistLocalService.getWishlistsCount();
	}

	/**
	 * Updates the wishlist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlist the wishlist
	 * @return the wishlist that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.Wishlist updateWishlist(
		com.onlineshopping.product.service.model.Wishlist wishlist) {

		return _wishlistLocalService.updateWishlist(wishlist);
	}

	@Override
	public WishlistLocalService getWrappedService() {
		return _wishlistLocalService;
	}

	@Override
	public void setWrappedService(WishlistLocalService wishlistLocalService) {
		_wishlistLocalService = wishlistLocalService;
	}

	private WishlistLocalService _wishlistLocalService;

}