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
 * Provides a wrapper for {@link ProductCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductCategoryLocalService
 * @generated
 */
public class ProductCategoryLocalServiceWrapper
	implements ProductCategoryLocalService,
			   ServiceWrapper<ProductCategoryLocalService> {

	public ProductCategoryLocalServiceWrapper(
		ProductCategoryLocalService productCategoryLocalService) {

		_productCategoryLocalService = productCategoryLocalService;
	}

	/**
	 * Adds the product category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCategory the product category
	 * @return the product category that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		addProductCategory(
			com.onlineshopping.product.service.model.ProductCategory
				productCategory) {

		return _productCategoryLocalService.addProductCategory(productCategory);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		addProductCategory(String categoryName) {

		return _productCategoryLocalService.addProductCategory(categoryName);
	}

	/**
	 * Creates a new product category with the primary key. Does not add the product category to the database.
	 *
	 * @param id the primary key for the new product category
	 * @return the new product category
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		createProductCategory(long id) {

		return _productCategoryLocalService.createProductCategory(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the product category
	 * @return the product category that was removed
	 * @throws PortalException if a product category with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductCategory
			deleteProductCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCategoryLocalService.deleteProductCategory(id);
	}

	/**
	 * Deletes the product category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCategory the product category
	 * @return the product category that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		deleteProductCategory(
			com.onlineshopping.product.service.model.ProductCategory
				productCategory) {

		return _productCategoryLocalService.deleteProductCategory(
			productCategory);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		deleteProductCategoryById(long categoryId) {

		return _productCategoryLocalService.deleteProductCategoryById(
			categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productCategoryLocalService.dynamicQuery();
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

		return _productCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductCategoryModelImpl</code>.
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

		return _productCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductCategoryModelImpl</code>.
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

		return _productCategoryLocalService.dynamicQuery(
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

		return _productCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		fetchProductCategory(long id) {

		return _productCategoryLocalService.fetchProductCategory(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.ProductCategory>
			getProductCategories() {

		return _productCategoryLocalService.getProductCategories();
	}

	/**
	 * Returns a range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of product categories
	 */
	@Override
	public java.util.List
		<com.onlineshopping.product.service.model.ProductCategory>
			getProductCategories(int start, int end) {

		return _productCategoryLocalService.getProductCategories(start, end);
	}

	/**
	 * Returns the number of product categories.
	 *
	 * @return the number of product categories
	 */
	@Override
	public int getProductCategoriesCount() {
		return _productCategoryLocalService.getProductCategoriesCount();
	}

	/**
	 * Returns the product category with the primary key.
	 *
	 * @param id the primary key of the product category
	 * @return the product category
	 * @throws PortalException if a product category with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductCategory
			getProductCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productCategoryLocalService.getProductCategory(id);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		getProductCategoryById(long productCategoryId) {

		return _productCategoryLocalService.getProductCategoryById(
			productCategoryId);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		getProductCategoryByName(String categoryName) {

		return _productCategoryLocalService.getProductCategoryByName(
			categoryName);
	}

	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		updateProductCategory(long categoryId, String categoryName) {

		return _productCategoryLocalService.updateProductCategory(
			categoryId, categoryName);
	}

	/**
	 * Updates the product category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productCategory the product category
	 * @return the product category that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.ProductCategory
		updateProductCategory(
			com.onlineshopping.product.service.model.ProductCategory
				productCategory) {

		return _productCategoryLocalService.updateProductCategory(
			productCategory);
	}

	@Override
	public ProductCategoryLocalService getWrappedService() {
		return _productCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ProductCategoryLocalService productCategoryLocalService) {

		_productCategoryLocalService = productCategoryLocalService;
	}

	private ProductCategoryLocalService _productCategoryLocalService;

}