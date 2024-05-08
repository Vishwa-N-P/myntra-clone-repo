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

import com.onlineshopping.product.service.model.CartListProduct;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the cart list product service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.CartListProductPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartListProductPersistence
 * @generated
 */
public class CartListProductUtil {

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
	public static void clearCache(CartListProduct cartListProduct) {
		getPersistence().clearCache(cartListProduct);
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
	public static Map<Serializable, CartListProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CartListProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CartListProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CartListProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CartListProduct> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CartListProduct update(CartListProduct cartListProduct) {
		return getPersistence().update(cartListProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CartListProduct update(
		CartListProduct cartListProduct, ServiceContext serviceContext) {

		return getPersistence().update(cartListProduct, serviceContext);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the matching cart list product
	 * @throws NoSuchCartListProductException if a matching cart list product could not be found
	 */
	public static CartListProduct findByCartListIdProductId(
			long cartListId, long productId)
		throws com.onlineshopping.product.service.exception.
			NoSuchCartListProductException {

		return getPersistence().findByCartListIdProductId(
			cartListId, productId);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public static CartListProduct fetchByCartListIdProductId(
		long cartListId, long productId) {

		return getPersistence().fetchByCartListIdProductId(
			cartListId, productId);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public static CartListProduct fetchByCartListIdProductId(
		long cartListId, long productId, boolean useFinderCache) {

		return getPersistence().fetchByCartListIdProductId(
			cartListId, productId, useFinderCache);
	}

	/**
	 * Removes the cart list product where cartListId = &#63; and productId = &#63; from the database.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the cart list product that was removed
	 */
	public static CartListProduct removeByCartListIdProductId(
			long cartListId, long productId)
		throws com.onlineshopping.product.service.exception.
			NoSuchCartListProductException {

		return getPersistence().removeByCartListIdProductId(
			cartListId, productId);
	}

	/**
	 * Returns the number of cart list products where cartListId = &#63; and productId = &#63;.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the number of matching cart list products
	 */
	public static int countByCartListIdProductId(
		long cartListId, long productId) {

		return getPersistence().countByCartListIdProductId(
			cartListId, productId);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the matching cart list product
	 * @throws NoSuchCartListProductException if a matching cart list product could not be found
	 */
	public static CartListProduct findByCartListIdProductIdSize(
			long cartListId, long productId, String size)
		throws com.onlineshopping.product.service.exception.
			NoSuchCartListProductException {

		return getPersistence().findByCartListIdProductIdSize(
			cartListId, productId, size);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public static CartListProduct fetchByCartListIdProductIdSize(
		long cartListId, long productId, String size) {

		return getPersistence().fetchByCartListIdProductIdSize(
			cartListId, productId, size);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public static CartListProduct fetchByCartListIdProductIdSize(
		long cartListId, long productId, String size, boolean useFinderCache) {

		return getPersistence().fetchByCartListIdProductIdSize(
			cartListId, productId, size, useFinderCache);
	}

	/**
	 * Removes the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; from the database.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the cart list product that was removed
	 */
	public static CartListProduct removeByCartListIdProductIdSize(
			long cartListId, long productId, String size)
		throws com.onlineshopping.product.service.exception.
			NoSuchCartListProductException {

		return getPersistence().removeByCartListIdProductIdSize(
			cartListId, productId, size);
	}

	/**
	 * Returns the number of cart list products where cartListId = &#63; and productId = &#63; and size = &#63;.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the number of matching cart list products
	 */
	public static int countByCartListIdProductIdSize(
		long cartListId, long productId, String size) {

		return getPersistence().countByCartListIdProductIdSize(
			cartListId, productId, size);
	}

	/**
	 * Caches the cart list product in the entity cache if it is enabled.
	 *
	 * @param cartListProduct the cart list product
	 */
	public static void cacheResult(CartListProduct cartListProduct) {
		getPersistence().cacheResult(cartListProduct);
	}

	/**
	 * Caches the cart list products in the entity cache if it is enabled.
	 *
	 * @param cartListProducts the cart list products
	 */
	public static void cacheResult(List<CartListProduct> cartListProducts) {
		getPersistence().cacheResult(cartListProducts);
	}

	/**
	 * Creates a new cart list product with the primary key. Does not add the cart list product to the database.
	 *
	 * @param id the primary key for the new cart list product
	 * @return the new cart list product
	 */
	public static CartListProduct create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the cart list product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product that was removed
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	public static CartListProduct remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchCartListProductException {

		return getPersistence().remove(id);
	}

	public static CartListProduct updateImpl(CartListProduct cartListProduct) {
		return getPersistence().updateImpl(cartListProduct);
	}

	/**
	 * Returns the cart list product with the primary key or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	public static CartListProduct findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchCartListProductException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the cart list product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product, or <code>null</code> if a cart list product with the primary key could not be found
	 */
	public static CartListProduct fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the cart list products.
	 *
	 * @return the cart list products
	 */
	public static List<CartListProduct> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @return the range of cart list products
	 */
	public static List<CartListProduct> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cart list products
	 */
	public static List<CartListProduct> findAll(
		int start, int end,
		OrderByComparator<CartListProduct> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cart list products
	 */
	public static List<CartListProduct> findAll(
		int start, int end,
		OrderByComparator<CartListProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cart list products from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cart list products.
	 *
	 * @return the number of cart list products
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CartListProductPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CartListProductPersistence _persistence;

}