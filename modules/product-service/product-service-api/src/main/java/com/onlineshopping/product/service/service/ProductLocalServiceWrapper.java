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
 * Provides a wrapper for {@link ProductLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductLocalService
 * @generated
 */
public class ProductLocalServiceWrapper
	implements ProductLocalService, ServiceWrapper<ProductLocalService> {

	public ProductLocalServiceWrapper(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	/**
	 * Adds the product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.Product addProduct(
		com.onlineshopping.product.service.model.Product product) {

		return _productLocalService.addProduct(product);
	}

	@Override
	public com.onlineshopping.product.service.model.Product addProduct(
		String productName, String productInfo, String color, long ratingCount,
		double rating, long price, long discount, int discountPercentage,
		long finalPrice, String gender, long brandId, long highlightsId,
		int productCount) {

		return _productLocalService.addProduct(
			productName, productInfo, color, ratingCount, rating, price,
			discount, discountPercentage, finalPrice, gender, brandId,
			highlightsId, productCount);
	}

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param id the primary key for the new product
	 * @return the new product
	 */
	@Override
	public com.onlineshopping.product.service.model.Product createProduct(
		long id) {

		return _productLocalService.createProduct(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the product
	 * @return the product that was removed
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.Product deleteProduct(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deleteProduct(id);
	}

	/**
	 * Deletes the product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.Product deleteProduct(
		com.onlineshopping.product.service.model.Product product) {

		return _productLocalService.deleteProduct(product);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productLocalService.dynamicQuery();
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

		return _productLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductModelImpl</code>.
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

		return _productLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductModelImpl</code>.
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

		return _productLocalService.dynamicQuery(
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

		return _productLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.Product fetchProduct(
		long id) {

		return _productLocalService.fetchProduct(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param id the primary key of the product
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.Product getProduct(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getProduct(id);
	}

	@Override
	public com.onlineshopping.product.service.model.Product getProductByDetails(
		String productName, String color, String gender, long brandId,
		long highlightsId) {

		return _productLocalService.getProductByDetails(
			productName, color, gender, brandId, highlightsId);
	}

	@Override
	public com.onlineshopping.product.service.model.Product getProductById(
		long productId) {

		return _productLocalService.getProductById(productId);
	}

	/**
	 * Returns a range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of products
	 */
	@Override
	public java.util.List<com.onlineshopping.product.service.model.Product>
		getProducts(int start, int end) {

		return _productLocalService.getProducts(start, end);
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.Product>
		getProductsByFiltering(
			String gender, String[] brands, String[] prices,
			String[] discounts) {

		return _productLocalService.getProductsByFiltering(
			gender, brands, prices, discounts);
	}

	@Override
	public java.util.List<com.onlineshopping.product.service.model.Product>
		getProductsByGender(String gender) {

		return _productLocalService.getProductsByGender(gender);
	}

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
	 */
	@Override
	public int getProductsCount() {
		return _productLocalService.getProductsCount();
	}

	@Override
	public com.onlineshopping.product.service.model.Product updateProduct(
		long productId, String productName, String productInfo, String color,
		long ratingCount, double rating, long price, long discount,
		int discountPercentage, long finalPrice, int productCount) {

		return _productLocalService.updateProduct(
			productId, productName, productInfo, color, ratingCount, rating,
			price, discount, discountPercentage, finalPrice, productCount);
	}

	/**
	 * Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param product the product
	 * @return the product that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.Product updateProduct(
		com.onlineshopping.product.service.model.Product product) {

		return _productLocalService.updateProduct(product);
	}

	@Override
	public ProductLocalService getWrappedService() {
		return _productLocalService;
	}

	@Override
	public void setWrappedService(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	private ProductLocalService _productLocalService;

}