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

import com.onlineshopping.product.service.exception.NoSuchCartListException;
import com.onlineshopping.product.service.model.CartList;
import com.onlineshopping.product.service.model.impl.CartListImpl;
import com.onlineshopping.product.service.model.impl.CartListModelImpl;
import com.onlineshopping.product.service.service.persistence.CartListPersistence;
import com.onlineshopping.product.service.service.persistence.CartListUtil;

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
 * The persistence implementation for the cart list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CartListPersistenceImpl
	extends BasePersistenceImpl<CartList> implements CartListPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CartListUtil</code> to access the cart list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CartListImpl.class.getName();

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
	 * Returns all the cart lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cart lists
	 */
	@Override
	public List<CartList> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cart lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @return the range of matching cart lists
	 */
	@Override
	public List<CartList> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cart lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cart lists
	 */
	@Override
	public List<CartList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CartList> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cart lists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cart lists
	 */
	@Override
	public List<CartList> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CartList> orderByComparator, boolean useFinderCache) {

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

		List<CartList> list = null;

		if (useFinderCache) {
			list = (List<CartList>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CartList cartList : list) {
					if (!uuid.equals(cartList.getUuid())) {
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

			sb.append(_SQL_SELECT_CARTLIST_WHERE);

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
				sb.append(CartListModelImpl.ORDER_BY_JPQL);
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

				list = (List<CartList>)QueryUtil.list(
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
	 * Returns the first cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cart list
	 * @throws NoSuchCartListException if a matching cart list could not be found
	 */
	@Override
	public CartList findByUuid_First(
			String uuid, OrderByComparator<CartList> orderByComparator)
		throws NoSuchCartListException {

		CartList cartList = fetchByUuid_First(uuid, orderByComparator);

		if (cartList != null) {
			return cartList;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCartListException(sb.toString());
	}

	/**
	 * Returns the first cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	@Override
	public CartList fetchByUuid_First(
		String uuid, OrderByComparator<CartList> orderByComparator) {

		List<CartList> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cart list
	 * @throws NoSuchCartListException if a matching cart list could not be found
	 */
	@Override
	public CartList findByUuid_Last(
			String uuid, OrderByComparator<CartList> orderByComparator)
		throws NoSuchCartListException {

		CartList cartList = fetchByUuid_Last(uuid, orderByComparator);

		if (cartList != null) {
			return cartList;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCartListException(sb.toString());
	}

	/**
	 * Returns the last cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	@Override
	public CartList fetchByUuid_Last(
		String uuid, OrderByComparator<CartList> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CartList> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cart lists before and after the current cart list in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current cart list
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cart list
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	@Override
	public CartList[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<CartList> orderByComparator)
		throws NoSuchCartListException {

		uuid = Objects.toString(uuid, "");

		CartList cartList = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CartList[] array = new CartListImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cartList, uuid, orderByComparator, true);

			array[1] = cartList;

			array[2] = getByUuid_PrevAndNext(
				session, cartList, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CartList getByUuid_PrevAndNext(
		Session session, CartList cartList, String uuid,
		OrderByComparator<CartList> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CARTLIST_WHERE);

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
			sb.append(CartListModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(cartList)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CartList> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cart lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CartList cartList :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cartList);
		}
	}

	/**
	 * Returns the number of cart lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cart lists
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CARTLIST_WHERE);

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
		"cartList.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cartList.uuid IS NULL OR cartList.uuid = '')";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the cart list where userId = &#63; or throws a <code>NoSuchCartListException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching cart list
	 * @throws NoSuchCartListException if a matching cart list could not be found
	 */
	@Override
	public CartList findByUserId(long userId) throws NoSuchCartListException {
		CartList cartList = fetchByUserId(userId);

		if (cartList == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCartListException(sb.toString());
		}

		return cartList;
	}

	/**
	 * Returns the cart list where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	@Override
	public CartList fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the cart list where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	@Override
	public CartList fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs, this);
		}

		if (result instanceof CartList) {
			CartList cartList = (CartList)result;

			if (userId != cartList.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CARTLIST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<CartList> list = query.list();

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
								"CartListPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CartList cartList = list.get(0);

					result = cartList;

					cacheResult(cartList);
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
			return (CartList)result;
		}
	}

	/**
	 * Removes the cart list where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the cart list that was removed
	 */
	@Override
	public CartList removeByUserId(long userId) throws NoSuchCartListException {
		CartList cartList = findByUserId(userId);

		return remove(cartList);
	}

	/**
	 * Returns the number of cart lists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cart lists
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CARTLIST_WHERE);

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
		"cartList.userId = ?";

	public CartListPersistenceImpl() {
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

		setModelClass(CartList.class);
	}

	/**
	 * Caches the cart list in the entity cache if it is enabled.
	 *
	 * @param cartList the cart list
	 */
	@Override
	public void cacheResult(CartList cartList) {
		entityCache.putResult(
			CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
			cartList.getPrimaryKey(), cartList);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {cartList.getUserId()},
			cartList);

		cartList.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cart lists in the entity cache if it is enabled.
	 *
	 * @param cartLists the cart lists
	 */
	@Override
	public void cacheResult(List<CartList> cartLists) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cartLists.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CartList cartList : cartLists) {
			if (entityCache.getResult(
					CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
					cartList.getPrimaryKey()) == null) {

				cacheResult(cartList);
			}
			else {
				cartList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cart lists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CartListImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cart list.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CartList cartList) {
		entityCache.removeResult(
			CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
			cartList.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CartListModelImpl)cartList, true);
	}

	@Override
	public void clearCache(List<CartList> cartLists) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CartList cartList : cartLists) {
			entityCache.removeResult(
				CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
				cartList.getPrimaryKey());

			clearUniqueFindersCache((CartListModelImpl)cartList, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CartListModelImpl cartListModelImpl) {

		Object[] args = new Object[] {cartListModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUserId, args, cartListModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CartListModelImpl cartListModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {cartListModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(_finderPathFetchByUserId, args);
		}

		if ((cartListModelImpl.getColumnBitmask() &
			 _finderPathFetchByUserId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				cartListModelImpl.getOriginalUserId()
			};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(_finderPathFetchByUserId, args);
		}
	}

	/**
	 * Creates a new cart list with the primary key. Does not add the cart list to the database.
	 *
	 * @param id the primary key for the new cart list
	 * @return the new cart list
	 */
	@Override
	public CartList create(long id) {
		CartList cartList = new CartListImpl();

		cartList.setNew(true);
		cartList.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		cartList.setUuid(uuid);

		return cartList;
	}

	/**
	 * Removes the cart list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list that was removed
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	@Override
	public CartList remove(long id) throws NoSuchCartListException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cart list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cart list
	 * @return the cart list that was removed
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	@Override
	public CartList remove(Serializable primaryKey)
		throws NoSuchCartListException {

		Session session = null;

		try {
			session = openSession();

			CartList cartList = (CartList)session.get(
				CartListImpl.class, primaryKey);

			if (cartList == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCartListException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cartList);
		}
		catch (NoSuchCartListException noSuchEntityException) {
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
	protected CartList removeImpl(CartList cartList) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cartList)) {
				cartList = (CartList)session.get(
					CartListImpl.class, cartList.getPrimaryKeyObj());
			}

			if (cartList != null) {
				session.delete(cartList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cartList != null) {
			clearCache(cartList);
		}

		return cartList;
	}

	@Override
	public CartList updateImpl(CartList cartList) {
		boolean isNew = cartList.isNew();

		if (!(cartList instanceof CartListModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cartList.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cartList);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cartList proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CartList implementation " +
					cartList.getClass());
		}

		CartListModelImpl cartListModelImpl = (CartListModelImpl)cartList;

		if (Validator.isNull(cartList.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cartList.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cartList.getCreateDate() == null)) {
			if (serviceContext == null) {
				cartList.setCreateDate(date);
			}
			else {
				cartList.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!cartListModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cartList.setModifiedDate(date);
			}
			else {
				cartList.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cartList);

				cartList.setNew(false);
			}
			else {
				cartList = (CartList)session.merge(cartList);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CartListModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {cartListModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((cartListModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					cartListModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {cartListModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
			cartList.getPrimaryKey(), cartList, false);

		clearUniqueFindersCache(cartListModelImpl, false);
		cacheUniqueFindersCache(cartListModelImpl);

		cartList.resetOriginalValues();

		return cartList;
	}

	/**
	 * Returns the cart list with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cart list
	 * @return the cart list
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	@Override
	public CartList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCartListException {

		CartList cartList = fetchByPrimaryKey(primaryKey);

		if (cartList == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCartListException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cartList;
	}

	/**
	 * Returns the cart list with the primary key or throws a <code>NoSuchCartListException</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	@Override
	public CartList findByPrimaryKey(long id) throws NoSuchCartListException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cart list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cart list
	 * @return the cart list, or <code>null</code> if a cart list with the primary key could not be found
	 */
	@Override
	public CartList fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CartList cartList = (CartList)serializable;

		if (cartList == null) {
			Session session = null;

			try {
				session = openSession();

				cartList = (CartList)session.get(
					CartListImpl.class, primaryKey);

				if (cartList != null) {
					cacheResult(cartList);
				}
				else {
					entityCache.putResult(
						CartListModelImpl.ENTITY_CACHE_ENABLED,
						CartListImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return cartList;
	}

	/**
	 * Returns the cart list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list, or <code>null</code> if a cart list with the primary key could not be found
	 */
	@Override
	public CartList fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, CartList> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CartList> map = new HashMap<Serializable, CartList>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CartList cartList = fetchByPrimaryKey(primaryKey);

			if (cartList != null) {
				map.put(primaryKey, cartList);
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
				CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CartList)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_CARTLIST_WHERE_PKS_IN);

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

			for (CartList cartList : (List<CartList>)query.list()) {
				map.put(cartList.getPrimaryKeyObj(), cartList);

				cacheResult(cartList);

				uncachedPrimaryKeys.remove(cartList.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CartListModelImpl.ENTITY_CACHE_ENABLED, CartListImpl.class,
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
	 * Returns all the cart lists.
	 *
	 * @return the cart lists
	 */
	@Override
	public List<CartList> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cart lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @return the range of cart lists
	 */
	@Override
	public List<CartList> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cart lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cart lists
	 */
	@Override
	public List<CartList> findAll(
		int start, int end, OrderByComparator<CartList> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cart lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart lists
	 * @param end the upper bound of the range of cart lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cart lists
	 */
	@Override
	public List<CartList> findAll(
		int start, int end, OrderByComparator<CartList> orderByComparator,
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

		List<CartList> list = null;

		if (useFinderCache) {
			list = (List<CartList>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CARTLIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CARTLIST;

				sql = sql.concat(CartListModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CartList>)QueryUtil.list(
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
	 * Removes all the cart lists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CartList cartList : findAll()) {
			remove(cartList);
		}
	}

	/**
	 * Returns the number of cart lists.
	 *
	 * @return the number of cart lists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CARTLIST);

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
		return CartListModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cart list persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, CartListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, CartListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, CartListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, CartListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CartListModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUserId = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, CartListImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()},
			CartListModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			CartListModelImpl.ENTITY_CACHE_ENABLED,
			CartListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_setCartListUtilPersistence(this);
	}

	public void destroy() {
		_setCartListUtilPersistence(null);

		entityCache.removeCache(CartListImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setCartListUtilPersistence(
		CartListPersistence cartListPersistence) {

		try {
			Field field = CartListUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, cartListPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CARTLIST =
		"SELECT cartList FROM CartList cartList";

	private static final String _SQL_SELECT_CARTLIST_WHERE_PKS_IN =
		"SELECT cartList FROM CartList cartList WHERE id_ IN (";

	private static final String _SQL_SELECT_CARTLIST_WHERE =
		"SELECT cartList FROM CartList cartList WHERE ";

	private static final String _SQL_COUNT_CARTLIST =
		"SELECT COUNT(cartList) FROM CartList cartList";

	private static final String _SQL_COUNT_CARTLIST_WHERE =
		"SELECT COUNT(cartList) FROM CartList cartList WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cartList.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CartList exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CartList exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CartListPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}