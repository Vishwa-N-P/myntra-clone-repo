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
 * Provides a wrapper for {@link CartListLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CartListLocalService
 * @generated
 */
public class CartListLocalServiceWrapper
	implements CartListLocalService, ServiceWrapper<CartListLocalService> {

	public CartListLocalServiceWrapper(
		CartListLocalService cartListLocalService) {

		_cartListLocalService = cartListLocalService;
	}

	/**
	 * Adds the cart list to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartList the cart list
	 * @return the cart list that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.CartList addCartList(
		com.onlineshopping.product.service.model.CartList cartList) {

		return _cartListLocalService.addCartList(cartList);
	}

	@Override
	public com.onlineshopping.product.service.model.CartList
		addOrGetUserCartList(long userId) {

		return _cartListLocalService.addOrGetUserCartList(userId);
	}

	/**
	 * Creates a new cart list with the primary key. Does not add the cart list to the database.
	 *
	 * @param id the primary key for the new cart list
	 * @return the new cart list
	 */
	@Override
	public com.onlineshopping.product.service.model.CartList createCartList(
		long id) {

		return _cartListLocalService.createCartList(id);
	}

	/**
	 * Deletes the cart list from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartList the cart list
	 * @return the cart list that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.CartList deleteCartList(
		com.onlineshopping.product.service.model.CartList cartList) {

		return _cartListLocalService.deleteCartList(cartList);
	}

	/**
	 * Deletes the cart list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list that was removed
	 * @throws PortalException if a cart list with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.CartList deleteCartList(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListLocalService.deleteCartList(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cartListLocalService.dynamicQuery();
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

		return _cartListLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.CartListModelImpl</code>.
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

		return _cartListLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.CartListModelImpl</code>.
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

		return _cartListLocalService.dynamicQuery(
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

		return _cartListLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cartListLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.CartList fetchCartList(
		long id) {

		return _cartListLocalService.fetchCartList(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cartListLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cart list with the primary key.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list
	 * @throws PortalException if a cart list with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.CartList getCartList(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListLocalService.getCartList(id);
	}

	@Override
	public com.onlineshopping.product.service.model.CartList
		getCartListByUserId(long userId) {

		return _cartListLocalService.getCartListByUserId(userId);
	}

	/**
	 * Returns a range of all the cart lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.CartListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @return the range of cart lists
	 */
	@Override
	public java.util.List<com.onlineshopping.product.service.model.CartList>
		getCartLists(int start, int end) {

		return _cartListLocalService.getCartLists(start, end);
	}

	/**
	 * Returns the number of cart lists.
	 *
	 * @return the number of cart lists
	 */
	@Override
	public int getCartListsCount() {
		return _cartListLocalService.getCartListsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cartListLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cartListLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cart list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartList the cart list
	 * @return the cart list that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.CartList updateCartList(
		com.onlineshopping.product.service.model.CartList cartList) {

		return _cartListLocalService.updateCartList(cartList);
	}

	@Override
	public CartListLocalService getWrappedService() {
		return _cartListLocalService;
	}

	@Override
	public void setWrappedService(CartListLocalService cartListLocalService) {
		_cartListLocalService = cartListLocalService;
	}

	private CartListLocalService _cartListLocalService;

}