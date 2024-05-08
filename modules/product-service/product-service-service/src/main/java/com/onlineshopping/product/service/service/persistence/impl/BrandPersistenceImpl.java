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

import com.onlineshopping.product.service.exception.NoSuchBrandException;
import com.onlineshopping.product.service.model.Brand;
import com.onlineshopping.product.service.model.impl.BrandImpl;
import com.onlineshopping.product.service.model.impl.BrandModelImpl;
import com.onlineshopping.product.service.service.persistence.BrandPersistence;
import com.onlineshopping.product.service.service.persistence.BrandUtil;

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
 * The persistence implementation for the brand service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrandPersistenceImpl
	extends BasePersistenceImpl<Brand> implements BrandPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BrandUtil</code> to access the brand persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BrandImpl.class.getName();

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
	 * Returns all the brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching brands
	 */
	@Override
	public List<Brand> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of matching brands
	 */
	@Override
	public List<Brand> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Brand> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching brands
	 */
	@Override
	public List<Brand> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Brand> orderByComparator, boolean useFinderCache) {

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

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Brand brand : list) {
					if (!uuid.equals(brand.getUuid())) {
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

			sb.append(_SQL_SELECT_BRAND_WHERE);

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
				sb.append(BrandModelImpl.ORDER_BY_JPQL);
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

				list = (List<Brand>)QueryUtil.list(
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
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUuid_First(
			String uuid, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByUuid_First(uuid, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the first brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUuid_First(
		String uuid, OrderByComparator<Brand> orderByComparator) {

		List<Brand> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByUuid_Last(
			String uuid, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		Brand brand = fetchByUuid_Last(uuid, orderByComparator);

		if (brand != null) {
			return brand;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBrandException(sb.toString());
	}

	/**
	 * Returns the last brand in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByUuid_Last(
		String uuid, OrderByComparator<Brand> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Brand> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brands before and after the current brand in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current brand
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Brand> orderByComparator)
		throws NoSuchBrandException {

		uuid = Objects.toString(uuid, "");

		Brand brand = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Brand[] array = new BrandImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, brand, uuid, orderByComparator, true);

			array[1] = brand;

			array[2] = getByUuid_PrevAndNext(
				session, brand, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Brand getByUuid_PrevAndNext(
		Session session, Brand brand, String uuid,
		OrderByComparator<Brand> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRAND_WHERE);

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
			sb.append(BrandModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(brand)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Brand> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brands where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Brand brand :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(brand);
		}
	}

	/**
	 * Returns the number of brands where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching brands
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRAND_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "brand.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(brand.uuid IS NULL OR brand.uuid = '')";

	private FinderPath _finderPathFetchByBrandName;
	private FinderPath _finderPathCountByBrandName;

	/**
	 * Returns the brand where brandName = &#63; or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param brandName the brand name
	 * @return the matching brand
	 * @throws NoSuchBrandException if a matching brand could not be found
	 */
	@Override
	public Brand findByBrandName(String brandName) throws NoSuchBrandException {
		Brand brand = fetchByBrandName(brandName);

		if (brand == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("brandName=");
			sb.append(brandName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBrandException(sb.toString());
		}

		return brand;
	}

	/**
	 * Returns the brand where brandName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param brandName the brand name
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByBrandName(String brandName) {
		return fetchByBrandName(brandName, true);
	}

	/**
	 * Returns the brand where brandName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param brandName the brand name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching brand, or <code>null</code> if a matching brand could not be found
	 */
	@Override
	public Brand fetchByBrandName(String brandName, boolean useFinderCache) {
		brandName = Objects.toString(brandName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {brandName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBrandName, finderArgs, this);
		}

		if (result instanceof Brand) {
			Brand brand = (Brand)result;

			if (!Objects.equals(brandName, brand.getBrandName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_BRAND_WHERE);

			boolean bindBrandName = false;

			if (brandName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BRANDNAME_BRANDNAME_3);
			}
			else {
				bindBrandName = true;

				sb.append(_FINDER_COLUMN_BRANDNAME_BRANDNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBrandName) {
					queryPos.add(brandName);
				}

				List<Brand> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBrandName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {brandName};
							}

							_log.warn(
								"BrandPersistenceImpl.fetchByBrandName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Brand brand = list.get(0);

					result = brand;

					cacheResult(brand);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByBrandName, finderArgs);
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
			return (Brand)result;
		}
	}

	/**
	 * Removes the brand where brandName = &#63; from the database.
	 *
	 * @param brandName the brand name
	 * @return the brand that was removed
	 */
	@Override
	public Brand removeByBrandName(String brandName)
		throws NoSuchBrandException {

		Brand brand = findByBrandName(brandName);

		return remove(brand);
	}

	/**
	 * Returns the number of brands where brandName = &#63;.
	 *
	 * @param brandName the brand name
	 * @return the number of matching brands
	 */
	@Override
	public int countByBrandName(String brandName) {
		brandName = Objects.toString(brandName, "");

		FinderPath finderPath = _finderPathCountByBrandName;

		Object[] finderArgs = new Object[] {brandName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRAND_WHERE);

			boolean bindBrandName = false;

			if (brandName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BRANDNAME_BRANDNAME_3);
			}
			else {
				bindBrandName = true;

				sb.append(_FINDER_COLUMN_BRANDNAME_BRANDNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBrandName) {
					queryPos.add(brandName);
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

	private static final String _FINDER_COLUMN_BRANDNAME_BRANDNAME_2 =
		"brand.brandName = ?";

	private static final String _FINDER_COLUMN_BRANDNAME_BRANDNAME_3 =
		"(brand.brandName IS NULL OR brand.brandName = '')";

	public BrandPersistenceImpl() {
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

		setModelClass(Brand.class);
	}

	/**
	 * Caches the brand in the entity cache if it is enabled.
	 *
	 * @param brand the brand
	 */
	@Override
	public void cacheResult(Brand brand) {
		entityCache.putResult(
			BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
			brand.getPrimaryKey(), brand);

		finderCache.putResult(
			_finderPathFetchByBrandName, new Object[] {brand.getBrandName()},
			brand);

		brand.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the brands in the entity cache if it is enabled.
	 *
	 * @param brands the brands
	 */
	@Override
	public void cacheResult(List<Brand> brands) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (brands.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Brand brand : brands) {
			if (entityCache.getResult(
					BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
					brand.getPrimaryKey()) == null) {

				cacheResult(brand);
			}
			else {
				brand.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all brands.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BrandImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the brand.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Brand brand) {
		entityCache.removeResult(
			BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
			brand.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BrandModelImpl)brand, true);
	}

	@Override
	public void clearCache(List<Brand> brands) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Brand brand : brands) {
			entityCache.removeResult(
				BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
				brand.getPrimaryKey());

			clearUniqueFindersCache((BrandModelImpl)brand, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(BrandModelImpl brandModelImpl) {
		Object[] args = new Object[] {brandModelImpl.getBrandName()};

		finderCache.putResult(
			_finderPathCountByBrandName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByBrandName, args, brandModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		BrandModelImpl brandModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {brandModelImpl.getBrandName()};

			finderCache.removeResult(_finderPathCountByBrandName, args);
			finderCache.removeResult(_finderPathFetchByBrandName, args);
		}

		if ((brandModelImpl.getColumnBitmask() &
			 _finderPathFetchByBrandName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				brandModelImpl.getOriginalBrandName()
			};

			finderCache.removeResult(_finderPathCountByBrandName, args);
			finderCache.removeResult(_finderPathFetchByBrandName, args);
		}
	}

	/**
	 * Creates a new brand with the primary key. Does not add the brand to the database.
	 *
	 * @param id the primary key for the new brand
	 * @return the new brand
	 */
	@Override
	public Brand create(long id) {
		Brand brand = new BrandImpl();

		brand.setNew(true);
		brand.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		brand.setUuid(uuid);

		return brand;
	}

	/**
	 * Removes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the brand
	 * @return the brand that was removed
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand remove(long id) throws NoSuchBrandException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the brand with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the brand
	 * @return the brand that was removed
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand remove(Serializable primaryKey) throws NoSuchBrandException {
		Session session = null;

		try {
			session = openSession();

			Brand brand = (Brand)session.get(BrandImpl.class, primaryKey);

			if (brand == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrandException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(brand);
		}
		catch (NoSuchBrandException noSuchEntityException) {
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
	protected Brand removeImpl(Brand brand) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(brand)) {
				brand = (Brand)session.get(
					BrandImpl.class, brand.getPrimaryKeyObj());
			}

			if (brand != null) {
				session.delete(brand);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (brand != null) {
			clearCache(brand);
		}

		return brand;
	}

	@Override
	public Brand updateImpl(Brand brand) {
		boolean isNew = brand.isNew();

		if (!(brand instanceof BrandModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(brand.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(brand);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in brand proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Brand implementation " +
					brand.getClass());
		}

		BrandModelImpl brandModelImpl = (BrandModelImpl)brand;

		if (Validator.isNull(brand.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			brand.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (brand.getCreateDate() == null)) {
			if (serviceContext == null) {
				brand.setCreateDate(date);
			}
			else {
				brand.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!brandModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				brand.setModifiedDate(date);
			}
			else {
				brand.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(brand);

				brand.setNew(false);
			}
			else {
				brand = (Brand)session.merge(brand);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!BrandModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {brandModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((brandModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {brandModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {brandModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
			brand.getPrimaryKey(), brand, false);

		clearUniqueFindersCache(brandModelImpl, false);
		cacheUniqueFindersCache(brandModelImpl);

		brand.resetOriginalValues();

		return brand;
	}

	/**
	 * Returns the brand with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand
	 * @return the brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrandException {

		Brand brand = fetchByPrimaryKey(primaryKey);

		if (brand == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrandException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return brand;
	}

	/**
	 * Returns the brand with the primary key or throws a <code>NoSuchBrandException</code> if it could not be found.
	 *
	 * @param id the primary key of the brand
	 * @return the brand
	 * @throws NoSuchBrandException if a brand with the primary key could not be found
	 */
	@Override
	public Brand findByPrimaryKey(long id) throws NoSuchBrandException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand
	 * @return the brand, or <code>null</code> if a brand with the primary key could not be found
	 */
	@Override
	public Brand fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Brand brand = (Brand)serializable;

		if (brand == null) {
			Session session = null;

			try {
				session = openSession();

				brand = (Brand)session.get(BrandImpl.class, primaryKey);

				if (brand != null) {
					cacheResult(brand);
				}
				else {
					entityCache.putResult(
						BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return brand;
	}

	/**
	 * Returns the brand with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the brand
	 * @return the brand, or <code>null</code> if a brand with the primary key could not be found
	 */
	@Override
	public Brand fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Brand> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Brand> map = new HashMap<Serializable, Brand>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Brand brand = fetchByPrimaryKey(primaryKey);

			if (brand != null) {
				map.put(primaryKey, brand);
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
				BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Brand)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_BRAND_WHERE_PKS_IN);

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

			for (Brand brand : (List<Brand>)query.list()) {
				map.put(brand.getPrimaryKeyObj(), brand);

				cacheResult(brand);

				uncachedPrimaryKeys.remove(brand.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					BrandModelImpl.ENTITY_CACHE_ENABLED, BrandImpl.class,
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
	 * Returns all the brands.
	 *
	 * @return the brands
	 */
	@Override
	public List<Brand> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @return the range of brands
	 */
	@Override
	public List<Brand> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brands
	 */
	@Override
	public List<Brand> findAll(
		int start, int end, OrderByComparator<Brand> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the brands.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BrandModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of brands
	 * @param end the upper bound of the range of brands (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of brands
	 */
	@Override
	public List<Brand> findAll(
		int start, int end, OrderByComparator<Brand> orderByComparator,
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

		List<Brand> list = null;

		if (useFinderCache) {
			list = (List<Brand>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BRAND);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BRAND;

				sql = sql.concat(BrandModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Brand>)QueryUtil.list(
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
	 * Removes all the brands from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Brand brand : findAll()) {
			remove(brand);
		}
	}

	/**
	 * Returns the number of brands.
	 *
	 * @return the number of brands
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BRAND);

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
		return BrandModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the brand persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, BrandImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, BrandImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, BrandImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, BrandImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			BrandModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByBrandName = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, BrandImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBrandName",
			new String[] {String.class.getName()},
			BrandModelImpl.BRANDNAME_COLUMN_BITMASK);

		_finderPathCountByBrandName = new FinderPath(
			BrandModelImpl.ENTITY_CACHE_ENABLED,
			BrandModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBrandName",
			new String[] {String.class.getName()});

		_setBrandUtilPersistence(this);
	}

	public void destroy() {
		_setBrandUtilPersistence(null);

		entityCache.removeCache(BrandImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setBrandUtilPersistence(BrandPersistence brandPersistence) {
		try {
			Field field = BrandUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, brandPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BRAND =
		"SELECT brand FROM Brand brand";

	private static final String _SQL_SELECT_BRAND_WHERE_PKS_IN =
		"SELECT brand FROM Brand brand WHERE id_ IN (";

	private static final String _SQL_SELECT_BRAND_WHERE =
		"SELECT brand FROM Brand brand WHERE ";

	private static final String _SQL_COUNT_BRAND =
		"SELECT COUNT(brand) FROM Brand brand";

	private static final String _SQL_COUNT_BRAND_WHERE =
		"SELECT COUNT(brand) FROM Brand brand WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "brand.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Brand exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Brand exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BrandPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}