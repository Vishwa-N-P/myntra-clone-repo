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

import com.onlineshopping.product.service.exception.NoSuchWishlistException;
import com.onlineshopping.product.service.model.Wishlist;
import com.onlineshopping.product.service.model.impl.WishlistImpl;
import com.onlineshopping.product.service.model.impl.WishlistModelImpl;
import com.onlineshopping.product.service.service.persistence.WishlistPersistence;
import com.onlineshopping.product.service.service.persistence.WishlistUtil;

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
 * The persistence implementation for the wishlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WishlistPersistenceImpl
	extends BasePersistenceImpl<Wishlist> implements WishlistPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WishlistUtil</code> to access the wishlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WishlistImpl.class.getName();

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
	 * Returns all the wishlists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching wishlists
	 */
	@Override
	public List<Wishlist> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Wishlist> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Wishlist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Wishlist> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Wishlist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Wishlist> orderByComparator, boolean useFinderCache) {

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

		List<Wishlist> list = null;

		if (useFinderCache) {
			list = (List<Wishlist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Wishlist wishlist : list) {
					if (!uuid.equals(wishlist.getUuid())) {
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

			sb.append(_SQL_SELECT_WISHLIST_WHERE);

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
				sb.append(WishlistModelImpl.ORDER_BY_JPQL);
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

				list = (List<Wishlist>)QueryUtil.list(
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
	 * Returns the first wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	@Override
	public Wishlist findByUuid_First(
			String uuid, OrderByComparator<Wishlist> orderByComparator)
		throws NoSuchWishlistException {

		Wishlist wishlist = fetchByUuid_First(uuid, orderByComparator);

		if (wishlist != null) {
			return wishlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWishlistException(sb.toString());
	}

	/**
	 * Returns the first wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	@Override
	public Wishlist fetchByUuid_First(
		String uuid, OrderByComparator<Wishlist> orderByComparator) {

		List<Wishlist> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	@Override
	public Wishlist findByUuid_Last(
			String uuid, OrderByComparator<Wishlist> orderByComparator)
		throws NoSuchWishlistException {

		Wishlist wishlist = fetchByUuid_Last(uuid, orderByComparator);

		if (wishlist != null) {
			return wishlist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWishlistException(sb.toString());
	}

	/**
	 * Returns the last wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	@Override
	public Wishlist fetchByUuid_Last(
		String uuid, OrderByComparator<Wishlist> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Wishlist> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Wishlist[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Wishlist> orderByComparator)
		throws NoSuchWishlistException {

		uuid = Objects.toString(uuid, "");

		Wishlist wishlist = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Wishlist[] array = new WishlistImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, wishlist, uuid, orderByComparator, true);

			array[1] = wishlist;

			array[2] = getByUuid_PrevAndNext(
				session, wishlist, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Wishlist getByUuid_PrevAndNext(
		Session session, Wishlist wishlist, String uuid,
		OrderByComparator<Wishlist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WISHLIST_WHERE);

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
			sb.append(WishlistModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(wishlist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Wishlist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wishlists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Wishlist wishlist :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(wishlist);
		}
	}

	/**
	 * Returns the number of wishlists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching wishlists
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WISHLIST_WHERE);

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
		"wishlist.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(wishlist.uuid IS NULL OR wishlist.uuid = '')";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the wishlist where userId = &#63; or throws a <code>NoSuchWishlistException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	@Override
	public Wishlist findByUserId(long userId) throws NoSuchWishlistException {
		Wishlist wishlist = fetchByUserId(userId);

		if (wishlist == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchWishlistException(sb.toString());
		}

		return wishlist;
	}

	/**
	 * Returns the wishlist where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	@Override
	public Wishlist fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the wishlist where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	@Override
	public Wishlist fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs, this);
		}

		if (result instanceof Wishlist) {
			Wishlist wishlist = (Wishlist)result;

			if (userId != wishlist.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_WISHLIST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<Wishlist> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"WishlistPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Wishlist wishlist = list.get(0);

					result = wishlist;

					cacheResult(wishlist);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUserId, finderArgs);
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
			return (Wishlist)result;
		}
	}

	/**
	 * Removes the wishlist where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the wishlist that was removed
	 */
	@Override
	public Wishlist removeByUserId(long userId) throws NoSuchWishlistException {
		Wishlist wishlist = findByUserId(userId);

		return remove(wishlist);
	}

	/**
	 * Returns the number of wishlists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching wishlists
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WISHLIST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"wishlist.userId = ?";

	public WishlistPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

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

		setModelClass(Wishlist.class);
	}

	/**
	 * Caches the wishlist in the entity cache if it is enabled.
	 *
	 * @param wishlist the wishlist
	 */
	@Override
	public void cacheResult(Wishlist wishlist) {
		entityCache.putResult(
			WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
			wishlist.getPrimaryKey(), wishlist);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {wishlist.getUserId()},
			wishlist);

		wishlist.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the wishlists in the entity cache if it is enabled.
	 *
	 * @param wishlists the wishlists
	 */
	@Override
	public void cacheResult(List<Wishlist> wishlists) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (wishlists.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Wishlist wishlist : wishlists) {
			if (entityCache.getResult(
					WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
					wishlist.getPrimaryKey()) == null) {

				cacheResult(wishlist);
			}
			else {
				wishlist.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wishlists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WishlistImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wishlist.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Wishlist wishlist) {
		entityCache.removeResult(
			WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
			wishlist.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((WishlistModelImpl)wishlist, true);
	}

	@Override
	public void clearCache(List<Wishlist> wishlists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Wishlist wishlist : wishlists) {
			entityCache.removeResult(
				WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
				wishlist.getPrimaryKey());

			clearUniqueFindersCache((WishlistModelImpl)wishlist, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WishlistModelImpl wishlistModelImpl) {

		Object[] args = new Object[] {wishlistModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUserId, args, wishlistModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WishlistModelImpl wishlistModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {wishlistModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(_finderPathFetchByUserId, args);
		}

		if ((wishlistModelImpl.getColumnBitmask() &
			 _finderPathFetchByUserId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				wishlistModelImpl.getOriginalUserId()
			};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(_finderPathFetchByUserId, args);
		}
	}

	/**
	 * Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	 *
	 * @param id the primary key for the new wishlist
	 * @return the new wishlist
	 */
	@Override
	public Wishlist create(long id) {
		Wishlist wishlist = new WishlistImpl();

		wishlist.setNew(true);
		wishlist.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		wishlist.setUuid(uuid);

		return wishlist;
	}

	/**
	 * Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	@Override
	public Wishlist remove(long id) throws NoSuchWishlistException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	@Override
	public Wishlist remove(Serializable primaryKey)
		throws NoSuchWishlistException {

		Session session = null;

		try {
			session = openSession();

			Wishlist wishlist = (Wishlist)session.get(
				WishlistImpl.class, primaryKey);

			if (wishlist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWishlistException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(wishlist);
		}
		catch (NoSuchWishlistException noSuchEntityException) {
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
	protected Wishlist removeImpl(Wishlist wishlist) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wishlist)) {
				wishlist = (Wishlist)session.get(
					WishlistImpl.class, wishlist.getPrimaryKeyObj());
			}

			if (wishlist != null) {
				session.delete(wishlist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (wishlist != null) {
			clearCache(wishlist);
		}

		return wishlist;
	}

	@Override
	public Wishlist updateImpl(Wishlist wishlist) {
		boolean isNew = wishlist.isNew();

		if (!(wishlist instanceof WishlistModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(wishlist.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(wishlist);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in wishlist proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Wishlist implementation " +
					wishlist.getClass());
		}

		WishlistModelImpl wishlistModelImpl = (WishlistModelImpl)wishlist;

		if (Validator.isNull(wishlist.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			wishlist.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (wishlist.getCreateDate() == null)) {
			if (serviceContext == null) {
				wishlist.setCreateDate(date);
			}
			else {
				wishlist.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!wishlistModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wishlist.setModifiedDate(date);
			}
			else {
				wishlist.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(wishlist);

				wishlist.setNew(false);
			}
			else {
				wishlist = (Wishlist)session.merge(wishlist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WishlistModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {wishlistModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((wishlistModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					wishlistModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {wishlistModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
			wishlist.getPrimaryKey(), wishlist, false);

		clearUniqueFindersCache(wishlistModelImpl, false);
		cacheUniqueFindersCache(wishlistModelImpl);

		wishlist.resetOriginalValues();

		return wishlist;
	}

	/**
	 * Returns the wishlist with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wishlist
	 * @return the wishlist
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	@Override
	public Wishlist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWishlistException {

		Wishlist wishlist = fetchByPrimaryKey(primaryKey);

		if (wishlist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWishlistException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return wishlist;
	}

	/**
	 * Returns the wishlist with the primary key or throws a <code>NoSuchWishlistException</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	@Override
	public Wishlist findByPrimaryKey(long id) throws NoSuchWishlistException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wishlist
	 * @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	 */
	@Override
	public Wishlist fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Wishlist wishlist = (Wishlist)serializable;

		if (wishlist == null) {
			Session session = null;

			try {
				session = openSession();

				wishlist = (Wishlist)session.get(
					WishlistImpl.class, primaryKey);

				if (wishlist != null) {
					cacheResult(wishlist);
				}
				else {
					entityCache.putResult(
						WishlistModelImpl.ENTITY_CACHE_ENABLED,
						WishlistImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return wishlist;
	}

	/**
	 * Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	 */
	@Override
	public Wishlist fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Wishlist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Wishlist> map = new HashMap<Serializable, Wishlist>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Wishlist wishlist = fetchByPrimaryKey(primaryKey);

			if (wishlist != null) {
				map.put(primaryKey, wishlist);
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
				WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Wishlist)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_WISHLIST_WHERE_PKS_IN);

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

			for (Wishlist wishlist : (List<Wishlist>)query.list()) {
				map.put(wishlist.getPrimaryKeyObj(), wishlist);

				cacheResult(wishlist);

				uncachedPrimaryKeys.remove(wishlist.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					WishlistModelImpl.ENTITY_CACHE_ENABLED, WishlistImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the wishlists.
	 *
	 * @return the wishlists
	 */
	@Override
	public List<Wishlist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Wishlist> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Wishlist> findAll(
		int start, int end, OrderByComparator<Wishlist> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Wishlist> findAll(
		int start, int end, OrderByComparator<Wishlist> orderByComparator,
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

		List<Wishlist> list = null;

		if (useFinderCache) {
			list = (List<Wishlist>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WISHLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WISHLIST;

				sql = sql.concat(WishlistModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Wishlist>)QueryUtil.list(
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
	 * Removes all the wishlists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Wishlist wishlist : findAll()) {
			remove(wishlist);
		}
	}

	/**
	 * Returns the number of wishlists.
	 *
	 * @return the number of wishlists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WISHLIST);

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
		return WishlistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wishlist persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			WishlistModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUserId = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, WishlistImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()},
			WishlistModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			WishlistModelImpl.ENTITY_CACHE_ENABLED,
			WishlistModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_setWishlistUtilPersistence(this);
	}

	public void destroy() {
		_setWishlistUtilPersistence(null);

		entityCache.removeCache(WishlistImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setWishlistUtilPersistence(
		WishlistPersistence wishlistPersistence) {

		try {
			Field field = WishlistUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, wishlistPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_WISHLIST =
		"SELECT wishlist FROM Wishlist wishlist";

	private static final String _SQL_SELECT_WISHLIST_WHERE_PKS_IN =
		"SELECT wishlist FROM Wishlist wishlist WHERE id_ IN (";

	private static final String _SQL_SELECT_WISHLIST_WHERE =
		"SELECT wishlist FROM Wishlist wishlist WHERE ";

	private static final String _SQL_COUNT_WISHLIST =
		"SELECT COUNT(wishlist) FROM Wishlist wishlist";

	private static final String _SQL_COUNT_WISHLIST_WHERE =
		"SELECT COUNT(wishlist) FROM Wishlist wishlist WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "wishlist.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Wishlist exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Wishlist exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WishlistPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}