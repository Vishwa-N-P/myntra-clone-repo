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
 * Provides a wrapper for {@link ProductOrderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductOrderLocalService
 * @generated
 */
public class ProductOrderLocalServiceWrapper
	implements ProductOrderLocalService,
			   ServiceWrapper<ProductOrderLocalService> {

	public ProductOrderLocalServiceWrapper(
		ProductOrderLocalService productOrderLocalService) {

		_productOrderLocalService = productOrderLocalService;
	}

	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		addProductOrder(
			long productId, String size, int quantity, long cost, long userId,
			long addressId) {

		return _productOrderLocalService.addProductOrder(
			productId, size, quantity, cost, userId, addressId);
	}

	/**
	 * Adds the product order to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productOrder the product order
	 * @return the product order that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		addProductOrder(
			com.onlineshopping.product.service.model.ProductOrder
				productOrder) {

		return _productOrderLocalService.addProductOrder(productOrder);
	}

	/**
	 * Creates a new product order with the primary key. Does not add the product order to the database.
	 *
	 * @param id the primary key for the new product order
	 * @return the new product order
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		createProductOrder(long id) {

		return _productOrderLocalService.createProductOrder(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productOrderLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the product order
	 * @return the product order that was removed
	 * @throws PortalException if a product order with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductOrder
			deleteProductOrder(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productOrderLocalService.deleteProductOrder(id);
	}

	/**
	 * Deletes the product order from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productOrder the product order
	 * @return the product order that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		deleteProductOrder(
			com.onlineshopping.product.service.model.ProductOrder
				productOrder) {

		return _productOrderLocalService.deleteProductOrder(productOrder);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productOrderLocalService.dynamicQuery();
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

		return _productOrderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductOrderModelImpl</code>.
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

		return _productOrderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductOrderModelImpl</code>.
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

		return _productOrderLocalService.dynamicQuery(
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

		return _productOrderLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productOrderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		fetchProductOrder(long id) {

		return _productOrderLocalService.fetchProductOrder(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productOrderLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productOrderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productOrderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productOrderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product order with the primary key.
	 *
	 * @param id the primary key of the product order
	 * @return the product order
	 * @throws PortalException if a product order with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductOrder
			getProductOrder(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productOrderLocalService.getProductOrder(id);
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.ProductOrder>
		getProductOrderList(long userId) {

		return _productOrderLocalService.getProductOrderList(userId);
	}

	/**
	 * Returns a range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @return the range of product orders
	 */
	@Override
	public java.util.List<com.onlineshopping.product.service.model.ProductOrder>
		getProductOrders(int start, int end) {

		return _productOrderLocalService.getProductOrders(start, end);
	}

	/**
	 * Returns the number of product orders.
	 *
	 * @return the number of product orders
	 */
	@Override
	public int getProductOrdersCount() {
		return _productOrderLocalService.getProductOrdersCount();
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.Product>
		getUserOrderedProducts(java.util.List<Long> productIds) {

		return _productOrderLocalService.getUserOrderedProducts(productIds);
	}

	/**
	 * Updates the product order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductOrderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productOrder the product order
	 * @return the product order that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductOrder
		updateProductOrder(
			com.onlineshopping.product.service.model.ProductOrder
				productOrder) {

		return _productOrderLocalService.updateProductOrder(productOrder);
	}

	@Override
	public ProductOrderLocalService getWrappedService() {
		return _productOrderLocalService;
	}

	@Override
	public void setWrappedService(
		ProductOrderLocalService productOrderLocalService) {

		_productOrderLocalService = productOrderLocalService;
	}

	private ProductOrderLocalService _productOrderLocalService;

}