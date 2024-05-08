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
 * Provides a wrapper for {@link CartListProductLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CartListProductLocalService
 * @generated
 */
public class CartListProductLocalServiceWrapper
	implements CartListProductLocalService,
			   ServiceWrapper<CartListProductLocalService> {

	public CartListProductLocalServiceWrapper(
		CartListProductLocalService cartListProductLocalService) {

		_cartListProductLocalService = cartListProductLocalService;
	}

	/**
	 * Adds the cart list product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartListProduct the cart list product
	 * @return the cart list product that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		addCartListProduct(
			com.onlineshopping.product.service.model.CartListProduct
				cartListProduct) {

		return _cartListProductLocalService.addCartListProduct(cartListProduct);
	}

	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		addCartListProduct(
			long cartListId, long productId, String size, int quantity) {

		return _cartListProductLocalService.addCartListProduct(
			cartListId, productId, size, quantity);
	}

	/**
	 * Creates a new cart list product with the primary key. Does not add the cart list product to the database.
	 *
	 * @param id the primary key for the new cart list product
	 * @return the new cart list product
	 */
	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		createCartListProduct(long id) {

		return _cartListProductLocalService.createCartListProduct(id);
	}

	/**
	 * Deletes the cart list product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartListProduct the cart list product
	 * @return the cart list product that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		deleteCartListProduct(
			com.onlineshopping.product.service.model.CartListProduct
				cartListProduct) {

		return _cartListProductLocalService.deleteCartListProduct(
			cartListProduct);
	}

	/**
	 * Deletes the cart list product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product that was removed
	 * @throws PortalException if a cart list product with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.CartListProduct
			deleteCartListProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListProductLocalService.deleteCartListProduct(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListProductLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public void deleteUserCartListProduct(
		long cartListId, long productId, String size) {

		_cartListProductLocalService.deleteUserCartListProduct(
			cartListId, productId, size);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cartListProductLocalService.dynamicQuery();
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

		return _cartListProductLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.CartListProductModelImpl</code>.
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

		return _cartListProductLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.CartListProductModelImpl</code>.
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

		return _cartListProductLocalService.dynamicQuery(
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

		return _cartListProductLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cartListProductLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		fetchCartListProduct(long id) {

		return _cartListProductLocalService.fetchCartListProduct(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cartListProductLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cart list product with the primary key.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product
	 * @throws PortalException if a cart list product with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.CartListProduct
			getCartListProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListProductLocalService.getCartListProduct(id);
	}

	/**
	 * Returns a range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @return the range of cart list products
	 */
	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.CartListProduct>
			getCartListProducts(int start, int end) {

		return _cartListProductLocalService.getCartListProducts(start, end);
	}

	/**
	 * Returns the number of cart list products.
	 *
	 * @return the number of cart list products
	 */
	@Override
	public int getCartListProductsCount() {
		return _cartListProductLocalService.getCartListProductsCount();
	}

	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		getCartProductByCartListIdProductId(long cartListId, long productId) {

		return _cartListProductLocalService.getCartProductByCartListIdProductId(
			cartListId, productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cartListProductLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cartListProductLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cartListProductLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		getUserCartListProduct(long cartListId, long productId, String size) {

		return _cartListProductLocalService.getUserCartListProduct(
			cartListId, productId, size);
	}

	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.CartListProduct>
			getUserCartListProducts(long cartListId) {

		return _cartListProductLocalService.getUserCartListProducts(cartListId);
	}

	/**
	 * Updates the cart list product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CartListProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cartListProduct the cart list product
	 * @return the cart list product that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.CartListProduct
		updateCartListProduct(
			com.onlineshopping.product.service.model.CartListProduct
				cartListProduct) {

		return _cartListProductLocalService.updateCartListProduct(
			cartListProduct);
	}

	@Override
	public CartListProductLocalService getWrappedService() {
		return _cartListProductLocalService;
	}

	@Override
	public void setWrappedService(
		CartListProductLocalService cartListProductLocalService) {

		_cartListProductLocalService = cartListProductLocalService;
	}

	private CartListProductLocalService _cartListProductLocalService;

}