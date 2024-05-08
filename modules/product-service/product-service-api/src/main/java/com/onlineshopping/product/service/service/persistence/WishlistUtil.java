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

import com.onlineshopping.product.service.model.Wishlist;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the wishlist service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.WishlistPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishlistPersistence
 * @generated
 */
public class WishlistUtil {

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
	public static void clearCache(Wishlist wishlist) {
		getPersistence().clearCache(wishlist);
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
	public static Map<Serializable, Wishlist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Wishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Wishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Wishlist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Wishlist> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Wishlist update(Wishlist wishlist) {
		return getPersistence().update(wishlist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Wishlist update(
		Wishlist wishlist, ServiceContext serviceContext) {

		return getPersistence().update(wishlist, serviceContext);
	}

	/**
	 * Returns all the wishlists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching wishlists
	 */
	public static List<Wishlist> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the wishlists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @return the range of matching wishlists
	 */
	public static List<Wishlist> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the wishlists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wishlists
	 */
	public static List<Wishlist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Wishlist> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the wishlists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching wishlists
	 */
	public static List<Wishlist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Wishlist> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	public static Wishlist findByUuid_First(
			String uuid, OrderByComparator<Wishlist> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public static Wishlist fetchByUuid_First(
		String uuid, OrderByComparator<Wishlist> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	public static Wishlist findByUuid_Last(
			String uuid, OrderByComparator<Wishlist> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public static Wishlist fetchByUuid_Last(
		String uuid, OrderByComparator<Wishlist> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the wishlists before and after the current wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current wishlist
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wishlist
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	public static Wishlist[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Wishlist> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the wishlists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of wishlists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching wishlists
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the wishlist where userId = &#63; or throws a <code>NoSuchWishlistException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	public static Wishlist findByUserId(long userId)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the wishlist where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public static Wishlist fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the wishlist where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public static Wishlist fetchByUserId(long userId, boolean useFinderCache) {
		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the wishlist where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the wishlist that was removed
	 */
	public static Wishlist removeByUserId(long userId)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of wishlists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching wishlists
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the wishlist in the entity cache if it is enabled.
	 *
	 * @param wishlist the wishlist
	 */
	public static void cacheResult(Wishlist wishlist) {
		getPersistence().cacheResult(wishlist);
	}

	/**
	 * Caches the wishlists in the entity cache if it is enabled.
	 *
	 * @param wishlists the wishlists
	 */
	public static void cacheResult(List<Wishlist> wishlists) {
		getPersistence().cacheResult(wishlists);
	}

	/**
	 * Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	 *
	 * @param id the primary key for the new wishlist
	 * @return the new wishlist
	 */
	public static Wishlist create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	public static Wishlist remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().remove(id);
	}

	public static Wishlist updateImpl(Wishlist wishlist) {
		return getPersistence().updateImpl(wishlist);
	}

	/**
	 * Returns the wishlist with the primary key or throws a <code>NoSuchWishlistException</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	public static Wishlist findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchWishlistException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	 */
	public static Wishlist fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the wishlists.
	 *
	 * @return the wishlists
	 */
	public static List<Wishlist> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the wishlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @return the range of wishlists
	 */
	public static List<Wishlist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the wishlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wishlists
	 */
	public static List<Wishlist> findAll(
		int start, int end, OrderByComparator<Wishlist> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the wishlists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WishlistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlists
	 * @param end the upper bound of the range of wishlists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of wishlists
	 */
	public static List<Wishlist> findAll(
		int start, int end, OrderByComparator<Wishlist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the wishlists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of wishlists.
	 *
	 * @return the number of wishlists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WishlistPersistence getPersistence() {
		return _persistence;
	}

	private static volatile WishlistPersistence _persistence;

}