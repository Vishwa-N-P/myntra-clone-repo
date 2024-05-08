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

import com.onlineshopping.product.service.model.Highlights;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the highlights service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.HighlightsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HighlightsPersistence
 * @generated
 */
public class HighlightsUtil {

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
	public static void clearCache(Highlights highlights) {
		getPersistence().clearCache(highlights);
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
	public static Map<Serializable, Highlights> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Highlights> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Highlights> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Highlights> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Highlights> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Highlights update(Highlights highlights) {
		return getPersistence().update(highlights);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Highlights update(
		Highlights highlights, ServiceContext serviceContext) {

		return getPersistence().update(highlights, serviceContext);
	}

	/**
	 * Returns all the highlightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching highlightses
	 */
	public static List<Highlights> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the highlightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @return the range of matching highlightses
	 */
	public static List<Highlights> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the highlightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching highlightses
	 */
	public static List<Highlights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Highlights> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the highlightses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching highlightses
	 */
	public static List<Highlights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Highlights> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	public static Highlights findByUuid_First(
			String uuid, OrderByComparator<Highlights> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public static Highlights fetchByUuid_First(
		String uuid, OrderByComparator<Highlights> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	public static Highlights findByUuid_Last(
			String uuid, OrderByComparator<Highlights> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public static Highlights fetchByUuid_Last(
		String uuid, OrderByComparator<Highlights> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the highlightses before and after the current highlights in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current highlights
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next highlights
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	public static Highlights[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<Highlights> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the highlightses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of highlightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching highlightses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or throws a <code>NoSuchHighlightsException</code> if it could not be found.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	public static Highlights findByFeaturesAndSize(String features, String size)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().findByFeaturesAndSize(features, size);
	}

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public static Highlights fetchByFeaturesAndSize(
		String features, String size) {

		return getPersistence().fetchByFeaturesAndSize(features, size);
	}

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param features the features
	 * @param size the size
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public static Highlights fetchByFeaturesAndSize(
		String features, String size, boolean useFinderCache) {

		return getPersistence().fetchByFeaturesAndSize(
			features, size, useFinderCache);
	}

	/**
	 * Removes the highlights where features = &#63; and size = &#63; from the database.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the highlights that was removed
	 */
	public static Highlights removeByFeaturesAndSize(
			String features, String size)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().removeByFeaturesAndSize(features, size);
	}

	/**
	 * Returns the number of highlightses where features = &#63; and size = &#63;.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the number of matching highlightses
	 */
	public static int countByFeaturesAndSize(String features, String size) {
		return getPersistence().countByFeaturesAndSize(features, size);
	}

	/**
	 * Caches the highlights in the entity cache if it is enabled.
	 *
	 * @param highlights the highlights
	 */
	public static void cacheResult(Highlights highlights) {
		getPersistence().cacheResult(highlights);
	}

	/**
	 * Caches the highlightses in the entity cache if it is enabled.
	 *
	 * @param highlightses the highlightses
	 */
	public static void cacheResult(List<Highlights> highlightses) {
		getPersistence().cacheResult(highlightses);
	}

	/**
	 * Creates a new highlights with the primary key. Does not add the highlights to the database.
	 *
	 * @param id the primary key for the new highlights
	 * @return the new highlights
	 */
	public static Highlights create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the highlights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights that was removed
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	public static Highlights remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().remove(id);
	}

	public static Highlights updateImpl(Highlights highlights) {
		return getPersistence().updateImpl(highlights);
	}

	/**
	 * Returns the highlights with the primary key or throws a <code>NoSuchHighlightsException</code> if it could not be found.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	public static Highlights findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchHighlightsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the highlights with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights, or <code>null</code> if a highlights with the primary key could not be found
	 */
	public static Highlights fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the highlightses.
	 *
	 * @return the highlightses
	 */
	public static List<Highlights> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the highlightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @return the range of highlightses
	 */
	public static List<Highlights> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the highlightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of highlightses
	 */
	public static List<Highlights> findAll(
		int start, int end, OrderByComparator<Highlights> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the highlightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of highlightses
	 */
	public static List<Highlights> findAll(
		int start, int end, OrderByComparator<Highlights> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the highlightses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of highlightses.
	 *
	 * @return the number of highlightses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static HighlightsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HighlightsPersistence _persistence;

}