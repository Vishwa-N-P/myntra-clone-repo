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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.onlineshopping.product.service.exception.NoSuchOrderException;
import com.onlineshopping.product.service.model.ProductOrder;
import com.onlineshopping.product.service.model.impl.ProductOrderImpl;
import com.onlineshopping.product.service.model.impl.ProductOrderModelImpl;
import com.onlineshopping.product.service.service.persistence.ProductOrderPersistence;
import com.onlineshopping.product.service.service.persistence.ProductOrderUtil;

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
 * The persistence implementation for the product order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductOrderPersistenceImpl
	extends BasePersistenceImpl<ProductOrder>
	implements ProductOrderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductOrderUtil</code> to access the product order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductOrderImpl.class.getName();

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
	 * Returns all the product orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product orders
	 */
	@Override
	public List<ProductOrder> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @return the range of matching product orders
	 */
	@Override
	public List<ProductOrder> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product orders
	 */
	@Override
	public List<ProductOrder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductOrder> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product orders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product orders
	 */
	@Override
	public List<ProductOrder> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductOrder> orderByComparator,
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

		List<ProductOrder> list = null;

		if (useFinderCache) {
			list = (List<ProductOrder>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductOrder productOrder : list) {
					if (!uuid.equals(productOrder.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTORDER_WHERE);

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
				sb.append(ProductOrderModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductOrder>)QueryUtil.list(
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
	 * Returns the first product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product order
	 * @throws NoSuchOrderException if a matching product order could not be found
	 */
	@Override
	public ProductOrder findByUuid_First(
			String uuid, OrderByComparator<ProductOrder> orderByComparator)
		throws NoSuchOrderException {

		ProductOrder productOrder = fetchByUuid_First(uuid, orderByComparator);

		if (productOrder != null) {
			return productOrder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOrderException(sb.toString());
	}

	/**
	 * Returns the first product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product order, or <code>null</code> if a matching product order could not be found
	 */
	@Override
	public ProductOrder fetchByUuid_First(
		String uuid, OrderByComparator<ProductOrder> orderByComparator) {

		List<ProductOrder> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product order
	 * @throws NoSuchOrderException if a matching product order could not be found
	 */
	@Override
	public ProductOrder findByUuid_Last(
			String uuid, OrderByComparator<ProductOrder> orderByComparator)
		throws NoSuchOrderException {

		ProductOrder productOrder = fetchByUuid_Last(uuid, orderByComparator);

		if (productOrder != null) {
			return productOrder;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOrderException(sb.toString());
	}

	/**
	 * Returns the last product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product order, or <code>null</code> if a matching product order could not be found
	 */
	@Override
	public ProductOrder fetchByUuid_Last(
		String uuid, OrderByComparator<ProductOrder> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductOrder> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product orders before and after the current product order in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current product order
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ProductOrder> orderByComparator)
		throws NoSuchOrderException {

		uuid = Objects.toString(uuid, "");

		ProductOrder productOrder = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ProductOrder[] array = new ProductOrderImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productOrder, uuid, orderByComparator, true);

			array[1] = productOrder;

			array[2] = getByUuid_PrevAndNext(
				session, productOrder, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductOrder getByUuid_PrevAndNext(
		Session session, ProductOrder productOrder, String uuid,
		OrderByComparator<ProductOrder> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTORDER_WHERE);

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
			sb.append(ProductOrderModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(productOrder)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductOrder> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product orders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductOrder productOrder :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productOrder);
		}
	}

	/**
	 * Returns the number of product orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product orders
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTORDER_WHERE);

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
		"productOrder.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productOrder.uuid IS NULL OR productOrder.uuid = '')";

	public ProductOrderPersistenceImpl() {
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

		setModelClass(ProductOrder.class);
	}

	/**
	 * Caches the product order in the entity cache if it is enabled.
	 *
	 * @param productOrder the product order
	 */
	@Override
	public void cacheResult(ProductOrder productOrder) {
		entityCache.putResult(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED, ProductOrderImpl.class,
			productOrder.getPrimaryKey(), productOrder);

		productOrder.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product orders in the entity cache if it is enabled.
	 *
	 * @param productOrders the product orders
	 */
	@Override
	public void cacheResult(List<ProductOrder> productOrders) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productOrders.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductOrder productOrder : productOrders) {
			if (entityCache.getResult(
					ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
					ProductOrderImpl.class, productOrder.getPrimaryKey()) ==
						null) {

				cacheResult(productOrder);
			}
			else {
				productOrder.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product orders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductOrderImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product order.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductOrder productOrder) {
		entityCache.removeResult(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED, ProductOrderImpl.class,
			productOrder.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductOrder> productOrders) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductOrder productOrder : productOrders) {
			entityCache.removeResult(
				ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
				ProductOrderImpl.class, productOrder.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
				ProductOrderImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new product order with the primary key. Does not add the product order to the database.
	 *
	 * @param id the primary key for the new product order
	 * @return the new product order
	 */
	@Override
	public ProductOrder create(long id) {
		ProductOrder productOrder = new ProductOrderImpl();

		productOrder.setNew(true);
		productOrder.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		productOrder.setUuid(uuid);

		return productOrder;
	}

	/**
	 * Removes the product order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the product order
	 * @return the product order that was removed
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder remove(long id) throws NoSuchOrderException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the product order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product order
	 * @return the product order that was removed
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder remove(Serializable primaryKey)
		throws NoSuchOrderException {

		Session session = null;

		try {
			session = openSession();

			ProductOrder productOrder = (ProductOrder)session.get(
				ProductOrderImpl.class, primaryKey);

			if (productOrder == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productOrder);
		}
		catch (NoSuchOrderException noSuchEntityException) {
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
	protected ProductOrder removeImpl(ProductOrder productOrder) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productOrder)) {
				productOrder = (ProductOrder)session.get(
					ProductOrderImpl.class, productOrder.getPrimaryKeyObj());
			}

			if (productOrder != null) {
				session.delete(productOrder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productOrder != null) {
			clearCache(productOrder);
		}

		return productOrder;
	}

	@Override
	public ProductOrder updateImpl(ProductOrder productOrder) {
		boolean isNew = productOrder.isNew();

		if (!(productOrder instanceof ProductOrderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productOrder.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productOrder);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productOrder proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductOrder implementation " +
					productOrder.getClass());
		}

		ProductOrderModelImpl productOrderModelImpl =
			(ProductOrderModelImpl)productOrder;

		if (Validator.isNull(productOrder.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			productOrder.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productOrder.getCreateDate() == null)) {
			if (serviceContext == null) {
				productOrder.setCreateDate(date);
			}
			else {
				productOrder.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!productOrderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productOrder.setModifiedDate(date);
			}
			else {
				productOrder.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productOrder);

				productOrder.setNew(false);
			}
			else {
				productOrder = (ProductOrder)session.merge(productOrder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProductOrderModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {productOrderModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((productOrderModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					productOrderModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {productOrderModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED, ProductOrderImpl.class,
			productOrder.getPrimaryKey(), productOrder, false);

		productOrder.resetOriginalValues();

		return productOrder;
	}

	/**
	 * Returns the product order with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product order
	 * @return the product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrderException {

		ProductOrder productOrder = fetchByPrimaryKey(primaryKey);

		if (productOrder == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productOrder;
	}

	/**
	 * Returns the product order with the primary key or throws a <code>NoSuchOrderException</code> if it could not be found.
	 *
	 * @param id the primary key of the product order
	 * @return the product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder findByPrimaryKey(long id) throws NoSuchOrderException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the product order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product order
	 * @return the product order, or <code>null</code> if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED, ProductOrderImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProductOrder productOrder = (ProductOrder)serializable;

		if (productOrder == null) {
			Session session = null;

			try {
				session = openSession();

				productOrder = (ProductOrder)session.get(
					ProductOrderImpl.class, primaryKey);

				if (productOrder != null) {
					cacheResult(productOrder);
				}
				else {
					entityCache.putResult(
						ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
						ProductOrderImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
					ProductOrderImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return productOrder;
	}

	/**
	 * Returns the product order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the product order
	 * @return the product order, or <code>null</code> if a product order with the primary key could not be found
	 */
	@Override
	public ProductOrder fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, ProductOrder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProductOrder> map =
			new HashMap<Serializable, ProductOrder>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProductOrder productOrder = fetchByPrimaryKey(primaryKey);

			if (productOrder != null) {
				map.put(primaryKey, productOrder);
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
				ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
				ProductOrderImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProductOrder)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_PRODUCTORDER_WHERE_PKS_IN);

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

			for (ProductOrder productOrder : (List<ProductOrder>)query.list()) {
				map.put(productOrder.getPrimaryKeyObj(), productOrder);

				cacheResult(productOrder);

				uncachedPrimaryKeys.remove(productOrder.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
					ProductOrderImpl.class, primaryKey, nullModel);
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
	 * Returns all the product orders.
	 *
	 * @return the product orders
	 */
	@Override
	public List<ProductOrder> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @return the range of product orders
	 */
	@Override
	public List<ProductOrder> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product orders
	 */
	@Override
	public List<ProductOrder> findAll(
		int start, int end, OrderByComparator<ProductOrder> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product orders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductOrderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product orders
	 * @param end the upper bound of the range of product orders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product orders
	 */
	@Override
	public List<ProductOrder> findAll(
		int start, int end, OrderByComparator<ProductOrder> orderByComparator,
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

		List<ProductOrder> list = null;

		if (useFinderCache) {
			list = (List<ProductOrder>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTORDER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTORDER;

				sql = sql.concat(ProductOrderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductOrder>)QueryUtil.list(
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
	 * Removes all the product orders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductOrder productOrder : findAll()) {
			remove(productOrder);
		}
	}

	/**
	 * Returns the number of product orders.
	 *
	 * @return the number of product orders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTORDER);

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
		return ProductOrderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product order persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProductOrderModelImpl.FINDER_CACHE_ENABLED, ProductOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProductOrderModelImpl.FINDER_CACHE_ENABLED, ProductOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProductOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProductOrderModelImpl.FINDER_CACHE_ENABLED, ProductOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProductOrderModelImpl.FINDER_CACHE_ENABLED, ProductOrderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ProductOrderModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ProductOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProductOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_setProductOrderUtilPersistence(this);
	}

	public void destroy() {
		_setProductOrderUtilPersistence(null);

		entityCache.removeCache(ProductOrderImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setProductOrderUtilPersistence(
		ProductOrderPersistence productOrderPersistence) {

		try {
			Field field = ProductOrderUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productOrderPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCTORDER =
		"SELECT productOrder FROM ProductOrder productOrder";

	private static final String _SQL_SELECT_PRODUCTORDER_WHERE_PKS_IN =
		"SELECT productOrder FROM ProductOrder productOrder WHERE id_ IN (";

	private static final String _SQL_SELECT_PRODUCTORDER_WHERE =
		"SELECT productOrder FROM ProductOrder productOrder WHERE ";

	private static final String _SQL_COUNT_PRODUCTORDER =
		"SELECT COUNT(productOrder) FROM ProductOrder productOrder";

	private static final String _SQL_COUNT_PRODUCTORDER_WHERE =
		"SELECT COUNT(productOrder) FROM ProductOrder productOrder WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productOrder.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductOrder exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductOrder exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductOrderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id", "size"});

}