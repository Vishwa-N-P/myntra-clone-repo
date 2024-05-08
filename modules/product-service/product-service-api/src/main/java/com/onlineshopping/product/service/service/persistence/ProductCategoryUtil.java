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

package com.onlineshopping.product.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.onlineshopping.product.service.model.ProductCategory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product category service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.ProductCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductCategoryPersistence
 * @generated
 */
public class ProductCategoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProductCategory productCategory) {
		getPersistence().clearCache(productCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProductCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductCategory update(ProductCategory productCategory) {
		return getPersistence().update(productCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductCategory update(
		ProductCategory productCategory, ServiceContext serviceContext) {

		return getPersistence().update(productCategory, serviceContext);
	}

	/**
	 * Returns all the product categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product categories
	 */
	public static List<ProductCategory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of matching product categories
	 */
	public static List<ProductCategory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product categories
	 */
	public static List<ProductCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductCategory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product categories
	 */
	public static List<ProductCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	public static ProductCategory findByUuid_First(
			String uuid, OrderByComparator<ProductCategory> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public static ProductCategory fetchByUuid_First(
		String uuid, OrderByComparator<ProductCategory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	public static ProductCategory findByUuid_Last(
			String uuid, OrderByComparator<ProductCategory> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public static ProductCategory fetchByUuid_Last(
		String uuid, OrderByComparator<ProductCategory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product categories before and after the current product category in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current product category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	public static ProductCategory[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ProductCategory> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the product categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product categories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product category where categoryName = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryName the category name
	 * @return the matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	public static ProductCategory findByCategoryName(String categoryName)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().findByCategoryName(categoryName);
	}

	/**
	 * Returns the product category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryName the category name
	 * @return the matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public static ProductCategory fetchByCategoryName(String categoryName) {
		return getPersistence().fetchByCategoryName(categoryName);
	}

	/**
	 * Returns the product category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryName the category name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public static ProductCategory fetchByCategoryName(
		String categoryName, boolean useFinderCache) {

		return getPersistence().fetchByCategoryName(
			categoryName, useFinderCache);
	}

	/**
	 * Removes the product category where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @return the product category that was removed
	 */
	public static ProductCategory removeByCategoryName(String categoryName)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().removeByCategoryName(categoryName);
	}

	/**
	 * Returns the number of product categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching product categories
	 */
	public static int countByCategoryName(String categoryName) {
		return getPersistence().countByCategoryName(categoryName);
	}

	/**
	 * Caches the product category in the entity cache if it is enabled.
	 *
	 * @param productCategory the product category
	 */
	public static void cacheResult(ProductCategory productCategory) {
		getPersistence().cacheResult(productCategory);
	}

	/**
	 * Caches the product categories in the entity cache if it is enabled.
	 *
	 * @param productCategories the product categories
	 */
	public static void cacheResult(List<ProductCategory> productCategories) {
		getPersistence().cacheResult(productCategories);
	}

	/**
	 * Creates a new product category with the primary key. Does not add the product category to the database.
	 *
	 * @param id the primary key for the new product category
	 * @return the new product category
	 */
	public static ProductCategory create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the product category
	 * @return the product category that was removed
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	public static ProductCategory remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().remove(id);
	}

	public static ProductCategory updateImpl(ProductCategory productCategory) {
		return getPersistence().updateImpl(productCategory);
	}

	/**
	 * Returns the product category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param id the primary key of the product category
	 * @return the product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	public static ProductCategory findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchCategoryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the product category
	 * @return the product category, or <code>null</code> if a product category with the primary key could not be found
	 */
	public static ProductCategory fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the product categories.
	 *
	 * @return the product categories
	 */
	public static List<ProductCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of product categories
	 */
	public static List<ProductCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product categories
	 */
	public static List<ProductCategory> findAll(
		int start, int end,
		OrderByComparator<ProductCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product categories
	 */
	public static List<ProductCategory> findAll(
		int start, int end,
		OrderByComparator<ProductCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product categories.
	 *
	 * @return the number of product categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProductCategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductCategoryPersistence _persistence;

}