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

import com.onlineshopping.product.service.model.ProductOrder;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product order service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.ProductOrderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductOrderPersistence
 * @generated
 */
public class ProductOrderUtil {

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
	public static void clearCache(ProductOrder productOrder) {
		getPersistence().clearCache(productOrder);
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
	public static Map<Serializable, ProductOrder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductOrder> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductOrder update(ProductOrder productOrder) {
		return getPersistence().update(productOrder);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductOrder update(
		ProductOrder productOrder, ServiceContext serviceContext) {

		return getPersistence().update(productOrder, serviceContext);
	}

	/**
	 * Returns all the product orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product orders
	 */
	public static List<ProductOrder> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @return the range of matching product orders
	 */
	public static List<ProductOrder> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product orders
	 */
	public static List<ProductOrder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductOrder> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product orders
	 */
	public static List<ProductOrder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductOrder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product order
	 * @throws NoSuchOrderException if a matching product order could not be found
	 */
	public static ProductOrder findByUuid_First(
			String uuid, OrderByComparator<ProductOrder> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchOrderException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product order, or <code>null</code> if a matching product order could not be found
	 */
	public static ProductOrder fetchByUuid_First(
		String uuid, OrderByComparator<ProductOrder> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product order
	 * @throws NoSuchOrderException if a matching product order could not be found
	 */
	public static ProductOrder findByUuid_Last(
			String uuid, OrderByComparator<ProductOrder> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchOrderException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product order, or <code>null</code> if a matching product order could not be found
	 */
	public static ProductOrder fetchByUuid_Last(
		String uuid, OrderByComparator<ProductOrder> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product orders before and after the current product order in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current product order
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	public static ProductOrder[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ProductOrder> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchOrderException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the product orders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product orders
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the product order in the entity cache if it is enabled.
	 *
	 * @param productOrder the product order
	 */
	public static void cacheResult(ProductOrder productOrder) {
		getPersistence().cacheResult(productOrder);
	}

	/**
	 * Caches the product orders in the entity cache if it is enabled.
	 *
	 * @param productOrders the product orders
	 */
	public static void cacheResult(List<ProductOrder> productOrders) {
		getPersistence().cacheResult(productOrders);
	}

	/**
	 * Creates a new product order with the primary key. Does not add the product order to the database.
	 *
	 * @param id the primary key for the new product order
	 * @return the new product order
	 */
	public static ProductOrder create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the product order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the product order
	 * @return the product order that was removed
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	public static ProductOrder remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchOrderException {

		return getPersistence().remove(id);
	}

	public static ProductOrder updateImpl(ProductOrder productOrder) {
		return getPersistence().updateImpl(productOrder);
	}

	/**
	 * Returns the product order with the primary key or throws a <code>NoSuchOrderException</code> if it could not be found.
	 *
	 * @param id the primary key of the product order
	 * @return the product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	public static ProductOrder findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchOrderException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the product order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the product order
	 * @return the product order, or <code>null</code> if a product order with the primary key could not be found
	 */
	public static ProductOrder fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the product orders.
	 *
	 * @return the product orders
	 */
	public static List<ProductOrder> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @return the range of product orders
	 */
	public static List<ProductOrder> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product orders
	 */
	public static List<ProductOrder> findAll(
		int start, int end, OrderByComparator<ProductOrder> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product orders
	 */
	public static List<ProductOrder> findAll(
		int start, int end, OrderByComparator<ProductOrder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product orders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product orders.
	 *
	 * @return the number of product orders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProductOrderPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductOrderPersistence _persistence;

}