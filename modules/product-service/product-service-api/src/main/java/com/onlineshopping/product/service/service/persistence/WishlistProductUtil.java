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

import com.onlineshopping.product.service.model.WishlistProduct;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the wishlist product service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.WishlistProductPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishlistProductPersistence
 * @generated
 */
public class WishlistProductUtil {

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
	public static void clearCache(WishlistProduct wishlistProduct) {
		getPersistence().clearCache(wishlistProduct);
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
	public static Map<Serializable, WishlistProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WishlistProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WishlistProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WishlistProduct> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WishlistProduct> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WishlistProduct update(WishlistProduct wishlistProduct) {
		return getPersistence().update(wishlistProduct);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WishlistProduct update(
		WishlistProduct wishlistProduct, ServiceContext serviceContext) {

		return getPersistence().update(wishlistProduct, serviceContext);
	}

	/**
	 * Returns the wishlist product where wishlistId = &#63; and productId = &#63; or throws a <code>NoSuchWishlistProductException</code> if it could not be found.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the matching wishlist product
	 * @throws NoSuchWishlistProductException if a matching wishlist product could not be found
	 */
	public static WishlistProduct findByWishlistIdProductId(
			long wishlistId, long productId)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistProductException {

		return getPersistence().findByWishlistIdProductId(
			wishlistId, productId);
	}

	/**
	 * Returns the wishlist product where wishlistId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the matching wishlist product, or <code>null</code> if a matching wishlist product could not be found
	 */
	public static WishlistProduct fetchByWishlistIdProductId(
		long wishlistId, long productId) {

		return getPersistence().fetchByWishlistIdProductId(
			wishlistId, productId);
	}

	/**
	 * Returns the wishlist product where wishlistId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wishlist product, or <code>null</code> if a matching wishlist product could not be found
	 */
	public static WishlistProduct fetchByWishlistIdProductId(
		long wishlistId, long productId, boolean useFinderCache) {

		return getPersistence().fetchByWishlistIdProductId(
			wishlistId, productId, useFinderCache);
	}

	/**
	 * Removes the wishlist product where wishlistId = &#63; and productId = &#63; from the database.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the wishlist product that was removed
	 */
	public static WishlistProduct removeByWishlistIdProductId(
			long wishlistId, long productId)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistProductException {

		return getPersistence().removeByWishlistIdProductId(
			wishlistId, productId);
	}

	/**
	 * Returns the number of wishlist products where wishlistId = &#63; and productId = &#63;.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the number of matching wishlist products
	 */
	public static int countByWishlistIdProductId(
		long wishlistId, long productId) {

		return getPersistence().countByWishlistIdProductId(
			wishlistId, productId);
	}

	/**
	 * Caches the wishlist product in the entity cache if it is enabled.
	 *
	 * @param wishlistProduct the wishlist product
	 */
	public static void cacheResult(WishlistProduct wishlistProduct) {
		getPersistence().cacheResult(wishlistProduct);
	}

	/**
	 * Caches the wishlist products in the entity cache if it is enabled.
	 *
	 * @param wishlistProducts the wishlist products
	 */
	public static void cacheResult(List<WishlistProduct> wishlistProducts) {
		getPersistence().cacheResult(wishlistProducts);
	}

	/**
	 * Creates a new wishlist product with the primary key. Does not add the wishlist product to the database.
	 *
	 * @param id the primary key for the new wishlist product
	 * @return the new wishlist product
	 */
	public static WishlistProduct create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the wishlist product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product that was removed
	 * @throws NoSuchWishlistProductException if a wishlist product with the primary key could not be found
	 */
	public static WishlistProduct remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistProductException {

		return getPersistence().remove(id);
	}

	public static WishlistProduct updateImpl(WishlistProduct wishlistProduct) {
		return getPersistence().updateImpl(wishlistProduct);
	}

	/**
	 * Returns the wishlist product with the primary key or throws a <code>NoSuchWishlistProductException</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product
	 * @throws NoSuchWishlistProductException if a wishlist product with the primary key could not be found
	 */
	public static WishlistProduct findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistProductException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the wishlist product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product, or <code>null</code> if a wishlist product with the primary key could not be found
	 */
	public static WishlistProduct fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the wishlist products.
	 *
	 * @return the wishlist products
	 */
	public static List<WishlistProduct> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the wishlist products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlist products
	 * @param end the upper bound of the range of wishlist products (not inclusive)
	 * @return the range of wishlist products
	 */
	public static List<WishlistProduct> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the wishlist products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlist products
	 * @param end the upper bound of the range of wishlist products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wishlist products
	 */
	public static List<WishlistProduct> findAll(
		int start, int end,
		OrderByComparator<WishlistProduct> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the wishlist products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlist products
	 * @param end the upper bound of the range of wishlist products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of wishlist products
	 */
	public static List<WishlistProduct> findAll(
		int start, int end,
		OrderByComparator<WishlistProduct> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the wishlist products from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of wishlist products.
	 *
	 * @return the number of wishlist products
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WishlistProductPersistence getPersistence() {
		return _persistence;
	}

	private static volatile WishlistProductPersistence _persistence;

}