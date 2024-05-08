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
 * Provides a wrapper for {@link WishlistProductLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WishlistProductLocalService
 * @generated
 */
public class WishlistProductLocalServiceWrapper
	implements ServiceWrapper<WishlistProductLocalService>,
			   WishlistProductLocalService {

	public WishlistProductLocalServiceWrapper(
		WishlistProductLocalService wishlistProductLocalService) {

		_wishlistProductLocalService = wishlistProductLocalService;
	}

	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		addWishlistProduct(long wishlistId, long productId) {

		return _wishlistProductLocalService.addWishlistProduct(
			wishlistId, productId);
	}

	/**
	 * Adds the wishlist product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlistProduct the wishlist product
	 * @return the wishlist product that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		addWishlistProduct(
			com.onlineshopping.product.service.model.WishlistProduct
				wishlistProduct) {

		return _wishlistProductLocalService.addWishlistProduct(wishlistProduct);
	}

	/**
	 * Creates a new wishlist product with the primary key. Does not add the wishlist product to the database.
	 *
	 * @param id the primary key for the new wishlist product
	 * @return the new wishlist product
	 */
	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		createWishlistProduct(long id) {

		return _wishlistProductLocalService.createWishlistProduct(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistProductLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public void deleteUserWishlistProduct(long wishlistId, long productId) {
		_wishlistProductLocalService.deleteUserWishlistProduct(
			wishlistId, productId);
	}

	/**
	 * Deletes the wishlist product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product that was removed
	 * @throws PortalException if a wishlist product with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
			deleteWishlistProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistProductLocalService.deleteWishlistProduct(id);
	}

	/**
	 * Deletes the wishlist product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlistProduct the wishlist product
	 * @return the wishlist product that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		deleteWishlistProduct(
			com.onlineshopping.product.service.model.WishlistProduct
				wishlistProduct) {

		return _wishlistProductLocalService.deleteWishlistProduct(
			wishlistProduct);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wishlistProductLocalService.dynamicQuery();
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

		return _wishlistProductLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code>.
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

		return _wishlistProductLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code>.
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

		return _wishlistProductLocalService.dynamicQuery(
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

		return _wishlistProductLocalService.dynamicQueryCount(dynamicQuery);
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

		return _wishlistProductLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		fetchWishlistProduct(long id) {

		return _wishlistProductLocalService.fetchWishlistProduct(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _wishlistProductLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _wishlistProductLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _wishlistProductLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistProductLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		getProductByWishlistIdProductId(long wishlistId, long productId) {

		return _wishlistProductLocalService.getProductByWishlistIdProductId(
			wishlistId, productId);
	}

	@Override
	public java.util.List<Long> getUserWishlistProducts(long wishlistId) {
		return _wishlistProductLocalService.getUserWishlistProducts(wishlistId);
	}

	/**
	 * Returns the wishlist product with the primary key.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product
	 * @throws PortalException if a wishlist product with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
			getWishlistProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _wishlistProductLocalService.getWishlistProduct(id);
	}

	/**
	 * Returns a range of all the wishlist products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlist products
	 * @param end the upper bound of the range of wishlist products (not inclusive)
	 * @return the range of wishlist products
	 */
	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.WishlistProduct>
			getWishlistProducts(int start, int end) {

		return _wishlistProductLocalService.getWishlistProducts(start, end);
	}

	/**
	 * Returns the number of wishlist products.
	 *
	 * @return the number of wishlist products
	 */
	@Override
	public int getWishlistProductsCount() {
		return _wishlistProductLocalService.getWishlistProductsCount();
	}

	/**
	 * Updates the wishlist product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlistProduct the wishlist product
	 * @return the wishlist product that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.WishlistProduct
		updateWishlistProduct(
			com.onlineshopping.product.service.model.WishlistProduct
				wishlistProduct) {

		return _wishlistProductLocalService.updateWishlistProduct(
			wishlistProduct);
	}

	@Override
	public WishlistProductLocalService getWrappedService() {
		return _wishlistProductLocalService;
	}

	@Override
	public void setWrappedService(
		WishlistProductLocalService wishlistProductLocalService) {

		_wishlistProductLocalService = wishlistProductLocalService;
	}

	private WishlistProductLocalService _wishlistProductLocalService;

}