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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.onlineshopping.product.service.exception.NoSuchHighlightsException;
import com.onlineshopping.product.service.model.Highlights;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the highlights service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HighlightsUtil
 * @generated
 */
@ProviderType
public interface HighlightsPersistence extends BasePersistence<Highlights> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HighlightsUtil} to access the highlights persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Highlights> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the highlightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching highlightses
	 */
	public java.util.List<Highlights> findByUuid(String uuid);

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
	public java.util.List<Highlights> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Highlights> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Highlights>
			orderByComparator);

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
	public java.util.List<Highlights> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Highlights>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	public Highlights findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Highlights>
				orderByComparator)
		throws NoSuchHighlightsException;

	/**
	 * Returns the first highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public Highlights fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Highlights>
			orderByComparator);

	/**
	 * Returns the last highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	public Highlights findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Highlights>
				orderByComparator)
		throws NoSuchHighlightsException;

	/**
	 * Returns the last highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public Highlights fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Highlights>
			orderByComparator);

	/**
	 * Returns the highlightses before and after the current highlights in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current highlights
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next highlights
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	public Highlights[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Highlights>
				orderByComparator)
		throws NoSuchHighlightsException;

	/**
	 * Removes all the highlightses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of highlightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching highlightses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or throws a <code>NoSuchHighlightsException</code> if it could not be found.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	public Highlights findByFeaturesAndSize(String features, String size)
		throws NoSuchHighlightsException;

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public Highlights fetchByFeaturesAndSize(String features, String size);

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param features the features
	 * @param size the size
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	public Highlights fetchByFeaturesAndSize(
		String features, String size, boolean useFinderCache);

	/**
	 * Removes the highlights where features = &#63; and size = &#63; from the database.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the highlights that was removed
	 */
	public Highlights removeByFeaturesAndSize(String features, String size)
		throws NoSuchHighlightsException;

	/**
	 * Returns the number of highlightses where features = &#63; and size = &#63;.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the number of matching highlightses
	 */
	public int countByFeaturesAndSize(String features, String size);

	/**
	 * Caches the highlights in the entity cache if it is enabled.
	 *
	 * @param highlights the highlights
	 */
	public void cacheResult(Highlights highlights);

	/**
	 * Caches the highlightses in the entity cache if it is enabled.
	 *
	 * @param highlightses the highlightses
	 */
	public void cacheResult(java.util.List<Highlights> highlightses);

	/**
	 * Creates a new highlights with the primary key. Does not add the highlights to the database.
	 *
	 * @param id the primary key for the new highlights
	 * @return the new highlights
	 */
	public Highlights create(long id);

	/**
	 * Removes the highlights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights that was removed
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	public Highlights remove(long id) throws NoSuchHighlightsException;

	public Highlights updateImpl(Highlights highlights);

	/**
	 * Returns the highlights with the primary key or throws a <code>NoSuchHighlightsException</code> if it could not be found.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	public Highlights findByPrimaryKey(long id)
		throws NoSuchHighlightsException;

	/**
	 * Returns the highlights with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights, or <code>null</code> if a highlights with the primary key could not be found
	 */
	public Highlights fetchByPrimaryKey(long id);

	/**
	 * Returns all the highlightses.
	 *
	 * @return the highlightses
	 */
	public java.util.List<Highlights> findAll();

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
	public java.util.List<Highlights> findAll(int start, int end);

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
	public java.util.List<Highlights> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Highlights>
			orderByComparator);

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
	public java.util.List<Highlights> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Highlights>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the highlightses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of highlightses.
	 *
	 * @return the number of highlightses
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}