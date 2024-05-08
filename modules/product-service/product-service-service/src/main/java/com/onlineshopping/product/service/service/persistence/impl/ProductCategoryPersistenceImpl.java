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

import com.onlineshopping.product.service.exception.NoSuchCategoryException;
import com.onlineshopping.product.service.model.ProductCategory;
import com.onlineshopping.product.service.model.impl.ProductCategoryImpl;
import com.onlineshopping.product.service.model.impl.ProductCategoryModelImpl;
import com.onlineshopping.product.service.service.persistence.ProductCategoryPersistence;
import com.onlineshopping.product.service.service.persistence.ProductCategoryUtil;

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
 * The persistence implementation for the product category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCategoryPersistenceImpl
	extends BasePersistenceImpl<ProductCategory>
	implements ProductCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductCategoryUtil</code> to access the product category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductCategoryImpl.class.getName();

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
	 * Returns all the product categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product categories
	 */
	@Override
	public List<ProductCategory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of matching product categories
	 */
	@Override
	public List<ProductCategory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product categories
	 */
	@Override
	public List<ProductCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductCategory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product categories
	 */
	@Override
	public List<ProductCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductCategory> orderByComparator,
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

		List<ProductCategory> list = null;

		if (useFinderCache) {
			list = (List<ProductCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductCategory productCategory : list) {
					if (!uuid.equals(productCategory.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTCATEGORY_WHERE);

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
				sb.append(ProductCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductCategory>)QueryUtil.list(
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
	 * Returns the first product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	@Override
	public ProductCategory findByUuid_First(
			String uuid, OrderByComparator<ProductCategory> orderByComparator)
		throws NoSuchCategoryException {

		ProductCategory productCategory = fetchByUuid_First(
			uuid, orderByComparator);

		if (productCategory != null) {
			return productCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the first product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product category, or <code>null</code> if a matching product category could not be found
	 */
	@Override
	public ProductCategory fetchByUuid_First(
		String uuid, OrderByComparator<ProductCategory> orderByComparator) {

		List<ProductCategory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	@Override
	public ProductCategory findByUuid_Last(
			String uuid, OrderByComparator<ProductCategory> orderByComparator)
		throws NoSuchCategoryException {

		ProductCategory productCategory = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productCategory != null) {
			return productCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCategoryException(sb.toString());
	}

	/**
	 * Returns the last product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product category, or <code>null</code> if a matching product category could not be found
	 */
	@Override
	public ProductCategory fetchByUuid_Last(
		String uuid, OrderByComparator<ProductCategory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductCategory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product categories before and after the current product category in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current product category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ProductCategory> orderByComparator)
		throws NoSuchCategoryException {

		uuid = Objects.toString(uuid, "");

		ProductCategory productCategory = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ProductCategory[] array = new ProductCategoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productCategory, uuid, orderByComparator, true);

			array[1] = productCategory;

			array[2] = getByUuid_PrevAndNext(
				session, productCategory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductCategory getByUuid_PrevAndNext(
		Session session, ProductCategory productCategory, String uuid,
		OrderByComparator<ProductCategory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTCATEGORY_WHERE);

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
			sb.append(ProductCategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						productCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductCategory productCategory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productCategory);
		}
	}

	/**
	 * Returns the number of product categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product categories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTCATEGORY_WHERE);

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
		"productCategory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productCategory.uuid IS NULL OR productCategory.uuid = '')";

	private FinderPath _finderPathFetchByCategoryName;
	private FinderPath _finderPathCountByCategoryName;

	/**
	 * Returns the product category where categoryName = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryName the category name
	 * @return the matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	@Override
	public ProductCategory findByCategoryName(String categoryName)
		throws NoSuchCategoryException {

		ProductCategory productCategory = fetchByCategoryName(categoryName);

		if (productCategory == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("categoryName=");
			sb.append(categoryName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCategoryException(sb.toString());
		}

		return productCategory;
	}

	/**
	 * Returns the product category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryName the category name
	 * @return the matching product category, or <code>null</code> if a matching product category could not be found
	 */
	@Override
	public ProductCategory fetchByCategoryName(String categoryName) {
		return fetchByCategoryName(categoryName, true);
	}

	/**
	 * Returns the product category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryName the category name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product category, or <code>null</code> if a matching product category could not be found
	 */
	@Override
	public ProductCategory fetchByCategoryName(
		String categoryName, boolean useFinderCache) {

		categoryName = Objects.toString(categoryName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {categoryName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCategoryName, finderArgs, this);
		}

		if (result instanceof ProductCategory) {
			ProductCategory productCategory = (ProductCategory)result;

			if (!Objects.equals(
					categoryName, productCategory.getCategoryName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUCTCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				sb.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryName) {
					queryPos.add(categoryName);
				}

				List<ProductCategory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCategoryName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {categoryName};
							}

							_log.warn(
								"ProductCategoryPersistenceImpl.fetchByCategoryName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductCategory productCategory = list.get(0);

					result = productCategory;

					cacheResult(productCategory);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByCategoryName, finderArgs);
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
			return (ProductCategory)result;
		}
	}

	/**
	 * Removes the product category where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @return the product category that was removed
	 */
	@Override
	public ProductCategory removeByCategoryName(String categoryName)
		throws NoSuchCategoryException {

		ProductCategory productCategory = findByCategoryName(categoryName);

		return remove(productCategory);
	}

	/**
	 * Returns the number of product categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching product categories
	 */
	@Override
	public int countByCategoryName(String categoryName) {
		categoryName = Objects.toString(categoryName, "");

		FinderPath finderPath = _finderPathCountByCategoryName;

		Object[] finderArgs = new Object[] {categoryName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTCATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				sb.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryName) {
					queryPos.add(categoryName);
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

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 =
		"productCategory.categoryName = ?";

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 =
		"(productCategory.categoryName IS NULL OR productCategory.categoryName = '')";

	public ProductCategoryPersistenceImpl() {
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

		setModelClass(ProductCategory.class);
	}

	/**
	 * Caches the product category in the entity cache if it is enabled.
	 *
	 * @param productCategory the product category
	 */
	@Override
	public void cacheResult(ProductCategory productCategory) {
		entityCache.putResult(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, productCategory.getPrimaryKey(),
			productCategory);

		finderCache.putResult(
			_finderPathFetchByCategoryName,
			new Object[] {productCategory.getCategoryName()}, productCategory);

		productCategory.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product categories in the entity cache if it is enabled.
	 *
	 * @param productCategories the product categories
	 */
	@Override
	public void cacheResult(List<ProductCategory> productCategories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productCategories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductCategory productCategory : productCategories) {
			if (entityCache.getResult(
					ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ProductCategoryImpl.class,
					productCategory.getPrimaryKey()) == null) {

				cacheResult(productCategory);
			}
			else {
				productCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductCategory productCategory) {
		entityCache.removeResult(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, productCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ProductCategoryModelImpl)productCategory, true);
	}

	@Override
	public void clearCache(List<ProductCategory> productCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductCategory productCategory : productCategories) {
			entityCache.removeResult(
				ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ProductCategoryImpl.class, productCategory.getPrimaryKey());

			clearUniqueFindersCache(
				(ProductCategoryModelImpl)productCategory, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ProductCategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductCategoryModelImpl productCategoryModelImpl) {

		Object[] args = new Object[] {
			productCategoryModelImpl.getCategoryName()
		};

		finderCache.putResult(
			_finderPathCountByCategoryName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCategoryName, args, productCategoryModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		ProductCategoryModelImpl productCategoryModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				productCategoryModelImpl.getCategoryName()
			};

			finderCache.removeResult(_finderPathCountByCategoryName, args);
			finderCache.removeResult(_finderPathFetchByCategoryName, args);
		}

		if ((productCategoryModelImpl.getColumnBitmask() &
			 _finderPathFetchByCategoryName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				productCategoryModelImpl.getOriginalCategoryName()
			};

			finderCache.removeResult(_finderPathCountByCategoryName, args);
			finderCache.removeResult(_finderPathFetchByCategoryName, args);
		}
	}

	/**
	 * Creates a new product category with the primary key. Does not add the product category to the database.
	 *
	 * @param id the primary key for the new product category
	 * @return the new product category
	 */
	@Override
	public ProductCategory create(long id) {
		ProductCategory productCategory = new ProductCategoryImpl();

		productCategory.setNew(true);
		productCategory.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		productCategory.setUuid(uuid);

		return productCategory;
	}

	/**
	 * Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the product category
	 * @return the product category that was removed
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory remove(long id) throws NoSuchCategoryException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product category
	 * @return the product category that was removed
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory remove(Serializable primaryKey)
		throws NoSuchCategoryException {

		Session session = null;

		try {
			session = openSession();

			ProductCategory productCategory = (ProductCategory)session.get(
				ProductCategoryImpl.class, primaryKey);

			if (productCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productCategory);
		}
		catch (NoSuchCategoryException noSuchEntityException) {
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
	protected ProductCategory removeImpl(ProductCategory productCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productCategory)) {
				productCategory = (ProductCategory)session.get(
					ProductCategoryImpl.class,
					productCategory.getPrimaryKeyObj());
			}

			if (productCategory != null) {
				session.delete(productCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productCategory != null) {
			clearCache(productCategory);
		}

		return productCategory;
	}

	@Override
	public ProductCategory updateImpl(ProductCategory productCategory) {
		boolean isNew = productCategory.isNew();

		if (!(productCategory instanceof ProductCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductCategory implementation " +
					productCategory.getClass());
		}

		ProductCategoryModelImpl productCategoryModelImpl =
			(ProductCategoryModelImpl)productCategory;

		if (Validator.isNull(productCategory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			productCategory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				productCategory.setCreateDate(date);
			}
			else {
				productCategory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productCategory.setModifiedDate(date);
			}
			else {
				productCategory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productCategory);

				productCategory.setNew(false);
			}
			else {
				productCategory = (ProductCategory)session.merge(
					productCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProductCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {productCategoryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((productCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					productCategoryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {productCategoryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, productCategory.getPrimaryKey(),
			productCategory, false);

		clearUniqueFindersCache(productCategoryModelImpl, false);
		cacheUniqueFindersCache(productCategoryModelImpl);

		productCategory.resetOriginalValues();

		return productCategory;
	}

	/**
	 * Returns the product category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product category
	 * @return the product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException {

		ProductCategory productCategory = fetchByPrimaryKey(primaryKey);

		if (productCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productCategory;
	}

	/**
	 * Returns the product category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param id the primary key of the product category
	 * @return the product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory findByPrimaryKey(long id)
		throws NoSuchCategoryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product category
	 * @return the product category, or <code>null</code> if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProductCategory productCategory = (ProductCategory)serializable;

		if (productCategory == null) {
			Session session = null;

			try {
				session = openSession();

				productCategory = (ProductCategory)session.get(
					ProductCategoryImpl.class, primaryKey);

				if (productCategory != null) {
					cacheResult(productCategory);
				}
				else {
					entityCache.putResult(
						ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
						ProductCategoryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ProductCategoryImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return productCategory;
	}

	/**
	 * Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the product category
	 * @return the product category, or <code>null</code> if a product category with the primary key could not be found
	 */
	@Override
	public ProductCategory fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ProductCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProductCategory> map =
			new HashMap<Serializable, ProductCategory>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProductCategory productCategory = fetchByPrimaryKey(primaryKey);

			if (productCategory != null) {
				map.put(primaryKey, productCategory);
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
				ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
				ProductCategoryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProductCategory)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_PRODUCTCATEGORY_WHERE_PKS_IN);

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

			for (ProductCategory productCategory :
					(List<ProductCategory>)query.list()) {

				map.put(productCategory.getPrimaryKeyObj(), productCategory);

				cacheResult(productCategory);

				uncachedPrimaryKeys.remove(productCategory.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
					ProductCategoryImpl.class, primaryKey, nullModel);
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
	 * Returns all the product categories.
	 *
	 * @return the product categories
	 */
	@Override
	public List<ProductCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of product categories
	 */
	@Override
	public List<ProductCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product categories
	 */
	@Override
	public List<ProductCategory> findAll(
		int start, int end,
		OrderByComparator<ProductCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product categories
	 */
	@Override
	public List<ProductCategory> findAll(
		int start, int end,
		OrderByComparator<ProductCategory> orderByComparator,
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

		List<ProductCategory> list = null;

		if (useFinderCache) {
			list = (List<ProductCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTCATEGORY;

				sql = sql.concat(ProductCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductCategory>)QueryUtil.list(
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
	 * Removes all the product categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductCategory productCategory : findAll()) {
			remove(productCategory);
		}
	}

	/**
	 * Returns the number of product categories.
	 *
	 * @return the number of product categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTCATEGORY);

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
		return ProductCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product category persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ProductCategoryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByCategoryName = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED,
			ProductCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCategoryName", new String[] {String.class.getName()},
			ProductCategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK);

		_finderPathCountByCategoryName = new FinderPath(
			ProductCategoryModelImpl.ENTITY_CACHE_ENABLED,
			ProductCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] {String.class.getName()});

		_setProductCategoryUtilPersistence(this);
	}

	public void destroy() {
		_setProductCategoryUtilPersistence(null);

		entityCache.removeCache(ProductCategoryImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setProductCategoryUtilPersistence(
		ProductCategoryPersistence productCategoryPersistence) {

		try {
			Field field = ProductCategoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productCategoryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTCATEGORY =
		"SELECT productCategory FROM ProductCategory productCategory";

	private static final String _SQL_SELECT_PRODUCTCATEGORY_WHERE_PKS_IN =
		"SELECT productCategory FROM ProductCategory productCategory WHERE id_ IN (";

	private static final String _SQL_SELECT_PRODUCTCATEGORY_WHERE =
		"SELECT productCategory FROM ProductCategory productCategory WHERE ";

	private static final String _SQL_COUNT_PRODUCTCATEGORY =
		"SELECT COUNT(productCategory) FROM ProductCategory productCategory";

	private static final String _SQL_COUNT_PRODUCTCATEGORY_WHERE =
		"SELECT COUNT(productCategory) FROM ProductCategory productCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductCategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}