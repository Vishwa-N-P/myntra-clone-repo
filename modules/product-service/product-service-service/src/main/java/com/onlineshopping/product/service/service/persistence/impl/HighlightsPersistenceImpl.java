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

package com.onlineshopping.product.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.onlineshopping.product.service.exception.NoSuchHighlightsException;
import com.onlineshopping.product.service.model.Highlights;
import com.onlineshopping.product.service.model.impl.HighlightsImpl;
import com.onlineshopping.product.service.model.impl.HighlightsModelImpl;
import com.onlineshopping.product.service.service.persistence.HighlightsPersistence;
import com.onlineshopping.product.service.service.persistence.HighlightsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the highlights service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HighlightsPersistenceImpl
	extends BasePersistenceImpl<Highlights> implements HighlightsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HighlightsUtil</code> to access the highlights persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HighlightsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the highlightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching highlightses
	 */
	@Override
	public List<Highlights> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Highlights> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Highlights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Highlights> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Highlights> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Highlights> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Highlights> list = null;

		if (useFinderCache) {
			list = (List<Highlights>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Highlights highlights : list) {
					if (!uuid.equals(highlights.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_HIGHLIGHTS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HighlightsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Highlights>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	@Override
	public Highlights findByUuid_First(
			String uuid, OrderByComparator<Highlights> orderByComparator)
		throws NoSuchHighlightsException {

		Highlights highlights = fetchByUuid_First(uuid, orderByComparator);

		if (highlights != null) {
			return highlights;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHighlightsException(sb.toString());
	}

	/**
	 * Returns the first highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	@Override
	public Highlights fetchByUuid_First(
		String uuid, OrderByComparator<Highlights> orderByComparator) {

		List<Highlights> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	@Override
	public Highlights findByUuid_Last(
			String uuid, OrderByComparator<Highlights> orderByComparator)
		throws NoSuchHighlightsException {

		Highlights highlights = fetchByUuid_Last(uuid, orderByComparator);

		if (highlights != null) {
			return highlights;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHighlightsException(sb.toString());
	}

	/**
	 * Returns the last highlights in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	@Override
	public Highlights fetchByUuid_Last(
		String uuid, OrderByComparator<Highlights> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Highlights> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Highlights[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<Highlights> orderByComparator)
		throws NoSuchHighlightsException {

		uuid = Objects.toString(uuid, "");

		Highlights highlights = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Highlights[] array = new HighlightsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, highlights, uuid, orderByComparator, true);

			array[1] = highlights;

			array[2] = getByUuid_PrevAndNext(
				session, highlights, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Highlights getByUuid_PrevAndNext(
		Session session, Highlights highlights, String uuid,
		OrderByComparator<Highlights> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HIGHLIGHTS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(HighlightsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(highlights)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Highlights> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the highlightses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Highlights highlights :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(highlights);
		}
	}

	/**
	 * Returns the number of highlightses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching highlightses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HIGHLIGHTS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"highlights.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(highlights.uuid IS NULL OR highlights.uuid = '')";

	private FinderPath _finderPathFetchByFeaturesAndSize;
	private FinderPath _finderPathCountByFeaturesAndSize;

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or throws a <code>NoSuchHighlightsException</code> if it could not be found.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the matching highlights
	 * @throws NoSuchHighlightsException if a matching highlights could not be found
	 */
	@Override
	public Highlights findByFeaturesAndSize(String features, String size)
		throws NoSuchHighlightsException {

		Highlights highlights = fetchByFeaturesAndSize(features, size);

		if (highlights == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("features=");
			sb.append(features);

			sb.append(", size=");
			sb.append(size);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHighlightsException(sb.toString());
		}

		return highlights;
	}

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	@Override
	public Highlights fetchByFeaturesAndSize(String features, String size) {
		return fetchByFeaturesAndSize(features, size, true);
	}

	/**
	 * Returns the highlights where features = &#63; and size = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param features the features
	 * @param size the size
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching highlights, or <code>null</code> if a matching highlights could not be found
	 */
	@Override
	public Highlights fetchByFeaturesAndSize(
		String features, String size, boolean useFinderCache) {

		features = Objects.toString(features, "");
		size = Objects.toString(size, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {features, size};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFeaturesAndSize, finderArgs, this);
		}

		if (result instanceof Highlights) {
			Highlights highlights = (Highlights)result;

			if (!Objects.equals(features, highlights.getFeatures()) ||
				!Objects.equals(size, highlights.getSize())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_HIGHLIGHTS_WHERE);

			boolean bindFeatures = false;

			if (features.isEmpty()) {
				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_FEATURES_3);
			}
			else {
				bindFeatures = true;

				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_FEATURES_2);
			}

			boolean bindSize = false;

			if (size.isEmpty()) {
				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_SIZE_3);
			}
			else {
				bindSize = true;

				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_SIZE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFeatures) {
					queryPos.add(features);
				}

				if (bindSize) {
					queryPos.add(size);
				}

				List<Highlights> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFeaturesAndSize, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {features, size};
							}

							_log.warn(
								"HighlightsPersistenceImpl.fetchByFeaturesAndSize(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Highlights highlights = list.get(0);

					result = highlights;

					cacheResult(highlights);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByFeaturesAndSize, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Highlights)result;
		}
	}

	/**
	 * Removes the highlights where features = &#63; and size = &#63; from the database.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the highlights that was removed
	 */
	@Override
	public Highlights removeByFeaturesAndSize(String features, String size)
		throws NoSuchHighlightsException {

		Highlights highlights = findByFeaturesAndSize(features, size);

		return remove(highlights);
	}

	/**
	 * Returns the number of highlightses where features = &#63; and size = &#63;.
	 *
	 * @param features the features
	 * @param size the size
	 * @return the number of matching highlightses
	 */
	@Override
	public int countByFeaturesAndSize(String features, String size) {
		features = Objects.toString(features, "");
		size = Objects.toString(size, "");

		FinderPath finderPath = _finderPathCountByFeaturesAndSize;

		Object[] finderArgs = new Object[] {features, size};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HIGHLIGHTS_WHERE);

			boolean bindFeatures = false;

			if (features.isEmpty()) {
				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_FEATURES_3);
			}
			else {
				bindFeatures = true;

				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_FEATURES_2);
			}

			boolean bindSize = false;

			if (size.isEmpty()) {
				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_SIZE_3);
			}
			else {
				bindSize = true;

				sb.append(_FINDER_COLUMN_FEATURESANDSIZE_SIZE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFeatures) {
					queryPos.add(features);
				}

				if (bindSize) {
					queryPos.add(size);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FEATURESANDSIZE_FEATURES_2 =
		"highlights.features = ? AND ";

	private static final String _FINDER_COLUMN_FEATURESANDSIZE_FEATURES_3 =
		"(highlights.features IS NULL OR highlights.features = '') AND ";

	private static final String _FINDER_COLUMN_FEATURESANDSIZE_SIZE_2 =
		"highlights.size = ?";

	private static final String _FINDER_COLUMN_FEATURESANDSIZE_SIZE_3 =
		"(highlights.size IS NULL OR highlights.size = '')";

	public HighlightsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");
		dbColumnNames.put("size", "size_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(Highlights.class);
	}

	/**
	 * Caches the highlights in the entity cache if it is enabled.
	 *
	 * @param highlights the highlights
	 */
	@Override
	public void cacheResult(Highlights highlights) {
		entityCache.putResult(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
			highlights.getPrimaryKey(), highlights);

		finderCache.putResult(
			_finderPathFetchByFeaturesAndSize,
			new Object[] {highlights.getFeatures(), highlights.getSize()},
			highlights);

		highlights.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the highlightses in the entity cache if it is enabled.
	 *
	 * @param highlightses the highlightses
	 */
	@Override
	public void cacheResult(List<Highlights> highlightses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (highlightses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Highlights highlights : highlightses) {
			if (entityCache.getResult(
					HighlightsModelImpl.ENTITY_CACHE_ENABLED,
					HighlightsImpl.class, highlights.getPrimaryKey()) == null) {

				cacheResult(highlights);
			}
			else {
				highlights.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all highlightses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HighlightsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the highlights.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Highlights highlights) {
		entityCache.removeResult(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
			highlights.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((HighlightsModelImpl)highlights, true);
	}

	@Override
	public void clearCache(List<Highlights> highlightses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Highlights highlights : highlightses) {
			entityCache.removeResult(
				HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
				highlights.getPrimaryKey());

			clearUniqueFindersCache((HighlightsModelImpl)highlights, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		HighlightsModelImpl highlightsModelImpl) {

		Object[] args = new Object[] {
			highlightsModelImpl.getFeatures(), highlightsModelImpl.getSize()
		};

		finderCache.putResult(
			_finderPathCountByFeaturesAndSize, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByFeaturesAndSize, args, highlightsModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		HighlightsModelImpl highlightsModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				highlightsModelImpl.getFeatures(), highlightsModelImpl.getSize()
			};

			finderCache.removeResult(_finderPathCountByFeaturesAndSize, args);
			finderCache.removeResult(_finderPathFetchByFeaturesAndSize, args);
		}

		if ((highlightsModelImpl.getColumnBitmask() &
			 _finderPathFetchByFeaturesAndSize.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				highlightsModelImpl.getOriginalFeatures(),
				highlightsModelImpl.getOriginalSize()
			};

			finderCache.removeResult(_finderPathCountByFeaturesAndSize, args);
			finderCache.removeResult(_finderPathFetchByFeaturesAndSize, args);
		}
	}

	/**
	 * Creates a new highlights with the primary key. Does not add the highlights to the database.
	 *
	 * @param id the primary key for the new highlights
	 * @return the new highlights
	 */
	@Override
	public Highlights create(long id) {
		Highlights highlights = new HighlightsImpl();

		highlights.setNew(true);
		highlights.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		highlights.setUuid(uuid);

		return highlights;
	}

	/**
	 * Removes the highlights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights that was removed
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	@Override
	public Highlights remove(long id) throws NoSuchHighlightsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the highlights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the highlights
	 * @return the highlights that was removed
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	@Override
	public Highlights remove(Serializable primaryKey)
		throws NoSuchHighlightsException {

		Session session = null;

		try {
			session = openSession();

			Highlights highlights = (Highlights)session.get(
				HighlightsImpl.class, primaryKey);

			if (highlights == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHighlightsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(highlights);
		}
		catch (NoSuchHighlightsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Highlights removeImpl(Highlights highlights) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(highlights)) {
				highlights = (Highlights)session.get(
					HighlightsImpl.class, highlights.getPrimaryKeyObj());
			}

			if (highlights != null) {
				session.delete(highlights);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (highlights != null) {
			clearCache(highlights);
		}

		return highlights;
	}

	@Override
	public Highlights updateImpl(Highlights highlights) {
		boolean isNew = highlights.isNew();

		if (!(highlights instanceof HighlightsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(highlights.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(highlights);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in highlights proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Highlights implementation " +
					highlights.getClass());
		}

		HighlightsModelImpl highlightsModelImpl =
			(HighlightsModelImpl)highlights;

		if (Validator.isNull(highlights.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			highlights.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (highlights.getCreateDate() == null)) {
			if (serviceContext == null) {
				highlights.setCreateDate(date);
			}
			else {
				highlights.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!highlightsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				highlights.setModifiedDate(date);
			}
			else {
				highlights.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(highlights);

				highlights.setNew(false);
			}
			else {
				highlights = (Highlights)session.merge(highlights);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HighlightsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {highlightsModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((highlightsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					highlightsModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {highlightsModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
			highlights.getPrimaryKey(), highlights, false);

		clearUniqueFindersCache(highlightsModelImpl, false);
		cacheUniqueFindersCache(highlightsModelImpl);

		highlights.resetOriginalValues();

		return highlights;
	}

	/**
	 * Returns the highlights with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the highlights
	 * @return the highlights
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	@Override
	public Highlights findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHighlightsException {

		Highlights highlights = fetchByPrimaryKey(primaryKey);

		if (highlights == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHighlightsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return highlights;
	}

	/**
	 * Returns the highlights with the primary key or throws a <code>NoSuchHighlightsException</code> if it could not be found.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights
	 * @throws NoSuchHighlightsException if a highlights with the primary key could not be found
	 */
	@Override
	public Highlights findByPrimaryKey(long id)
		throws NoSuchHighlightsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the highlights with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the highlights
	 * @return the highlights, or <code>null</code> if a highlights with the primary key could not be found
	 */
	@Override
	public Highlights fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Highlights highlights = (Highlights)serializable;

		if (highlights == null) {
			Session session = null;

			try {
				session = openSession();

				highlights = (Highlights)session.get(
					HighlightsImpl.class, primaryKey);

				if (highlights != null) {
					cacheResult(highlights);
				}
				else {
					entityCache.putResult(
						HighlightsModelImpl.ENTITY_CACHE_ENABLED,
						HighlightsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					HighlightsModelImpl.ENTITY_CACHE_ENABLED,
					HighlightsImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return highlights;
	}

	/**
	 * Returns the highlights with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights, or <code>null</code> if a highlights with the primary key could not be found
	 */
	@Override
	public Highlights fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Highlights> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Highlights> map =
			new HashMap<Serializable, Highlights>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Highlights highlights = fetchByPrimaryKey(primaryKey);

			if (highlights != null) {
				map.put(primaryKey, highlights);
			}

			return map;
		}

		if ((databaseInMaxParameters > 0) &&
			(primaryKeys.size() > databaseInMaxParameters)) {

			Iterator<Serializable> iterator = primaryKeys.iterator();

			while (iterator.hasNext()) {
				Set<Serializable> page = new HashSet<>();

				for (int i = 0;
					 (i < databaseInMaxParameters) && iterator.hasNext(); i++) {

					page.add(iterator.next());
				}

				map.putAll(fetchByPrimaryKeys(page));
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				HighlightsModelImpl.ENTITY_CACHE_ENABLED, HighlightsImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Highlights)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_HIGHLIGHTS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (Highlights highlights : (List<Highlights>)query.list()) {
				map.put(highlights.getPrimaryKeyObj(), highlights);

				cacheResult(highlights);

				uncachedPrimaryKeys.remove(highlights.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					HighlightsModelImpl.ENTITY_CACHE_ENABLED,
					HighlightsImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the highlightses.
	 *
	 * @return the highlightses
	 */
	@Override
	public List<Highlights> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Highlights> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Highlights> findAll(
		int start, int end, OrderByComparator<Highlights> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Highlights> findAll(
		int start, int end, OrderByComparator<Highlights> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Highlights> list = null;

		if (useFinderCache) {
			list = (List<Highlights>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HIGHLIGHTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HIGHLIGHTS;

				sql = sql.concat(HighlightsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Highlights>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the highlightses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Highlights highlights : findAll()) {
			remove(highlights);
		}
	}

	/**
	 * Returns the number of highlightses.
	 *
	 * @return the number of highlightses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HIGHLIGHTS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HighlightsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the highlights persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, HighlightsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, HighlightsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, HighlightsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, HighlightsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			HighlightsModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByFeaturesAndSize = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, HighlightsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFeaturesAndSize",
			new String[] {String.class.getName(), String.class.getName()},
			HighlightsModelImpl.FEATURES_COLUMN_BITMASK |
			HighlightsModelImpl.SIZE_COLUMN_BITMASK);

		_finderPathCountByFeaturesAndSize = new FinderPath(
			HighlightsModelImpl.ENTITY_CACHE_ENABLED,
			HighlightsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFeaturesAndSize",
			new String[] {String.class.getName(), String.class.getName()});

		_setHighlightsUtilPersistence(this);
	}

	public void destroy() {
		_setHighlightsUtilPersistence(null);

		entityCache.removeCache(HighlightsImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setHighlightsUtilPersistence(
		HighlightsPersistence highlightsPersistence) {

		try {
			Field field = HighlightsUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, highlightsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_HIGHLIGHTS =
		"SELECT highlights FROM Highlights highlights";

	private static final String _SQL_SELECT_HIGHLIGHTS_WHERE_PKS_IN =
		"SELECT highlights FROM Highlights highlights WHERE id_ IN (";

	private static final String _SQL_SELECT_HIGHLIGHTS_WHERE =
		"SELECT highlights FROM Highlights highlights WHERE ";

	private static final String _SQL_COUNT_HIGHLIGHTS =
		"SELECT COUNT(highlights) FROM Highlights highlights";

	private static final String _SQL_COUNT_HIGHLIGHTS_WHERE =
		"SELECT COUNT(highlights) FROM Highlights highlights WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "highlights.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Highlights exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Highlights exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HighlightsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id", "size"});

}