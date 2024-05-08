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
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.onlineshopping.product.service.exception.NoSuchWishlistProductException;
import com.onlineshopping.product.service.model.WishlistProduct;
import com.onlineshopping.product.service.model.impl.WishlistProductImpl;
import com.onlineshopping.product.service.model.impl.WishlistProductModelImpl;
import com.onlineshopping.product.service.service.persistence.WishlistProductPersistence;
import com.onlineshopping.product.service.service.persistence.WishlistProductUtil;

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
import java.util.Set;

/**
 * The persistence implementation for the wishlist product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WishlistProductPersistenceImpl
	extends BasePersistenceImpl<WishlistProduct>
	implements WishlistProductPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WishlistProductUtil</code> to access the wishlist product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WishlistProductImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByWishlistIdProductId;
	private FinderPath _finderPathCountByWishlistIdProductId;

	/**
	 * Returns the wishlist product where wishlistId = &#63; and productId = &#63; or throws a <code>NoSuchWishlistProductException</code> if it could not be found.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the matching wishlist product
	 * @throws NoSuchWishlistProductException if a matching wishlist product could not be found
	 */
	@Override
	public WishlistProduct findByWishlistIdProductId(
			long wishlistId, long productId)
		throws NoSuchWishlistProductException {

		WishlistProduct wishlistProduct = fetchByWishlistIdProductId(
			wishlistId, productId);

		if (wishlistProduct == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("wishlistId=");
			sb.append(wishlistId);

			sb.append(", productId=");
			sb.append(productId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchWishlistProductException(sb.toString());
		}

		return wishlistProduct;
	}

	/**
	 * Returns the wishlist product where wishlistId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the matching wishlist product, or <code>null</code> if a matching wishlist product could not be found
	 */
	@Override
	public WishlistProduct fetchByWishlistIdProductId(
		long wishlistId, long productId) {

		return fetchByWishlistIdProductId(wishlistId, productId, true);
	}

	/**
	 * Returns the wishlist product where wishlistId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wishlist product, or <code>null</code> if a matching wishlist product could not be found
	 */
	@Override
	public WishlistProduct fetchByWishlistIdProductId(
		long wishlistId, long productId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {wishlistId, productId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByWishlistIdProductId, finderArgs, this);
		}

		if (result instanceof WishlistProduct) {
			WishlistProduct wishlistProduct = (WishlistProduct)result;

			if ((wishlistId != wishlistProduct.getWishlistId()) ||
				(productId != wishlistProduct.getProductId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_WISHLISTPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_WISHLISTIDPRODUCTID_WISHLISTID_2);

			sb.append(_FINDER_COLUMN_WISHLISTIDPRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(wishlistId);

				queryPos.add(productId);

				List<WishlistProduct> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByWishlistIdProductId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									wishlistId, productId
								};
							}

							_log.warn(
								"WishlistProductPersistenceImpl.fetchByWishlistIdProductId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					WishlistProduct wishlistProduct = list.get(0);

					result = wishlistProduct;

					cacheResult(wishlistProduct);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByWishlistIdProductId, finderArgs);
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
			return (WishlistProduct)result;
		}
	}

	/**
	 * Removes the wishlist product where wishlistId = &#63; and productId = &#63; from the database.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the wishlist product that was removed
	 */
	@Override
	public WishlistProduct removeByWishlistIdProductId(
			long wishlistId, long productId)
		throws NoSuchWishlistProductException {

		WishlistProduct wishlistProduct = findByWishlistIdProductId(
			wishlistId, productId);

		return remove(wishlistProduct);
	}

	/**
	 * Returns the number of wishlist products where wishlistId = &#63; and productId = &#63;.
	 *
	 * @param wishlistId the wishlist ID
	 * @param productId the product ID
	 * @return the number of matching wishlist products
	 */
	@Override
	public int countByWishlistIdProductId(long wishlistId, long productId) {
		FinderPath finderPath = _finderPathCountByWishlistIdProductId;

		Object[] finderArgs = new Object[] {wishlistId, productId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_WISHLISTPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_WISHLISTIDPRODUCTID_WISHLISTID_2);

			sb.append(_FINDER_COLUMN_WISHLISTIDPRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(wishlistId);

				queryPos.add(productId);

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

	private static final String
		_FINDER_COLUMN_WISHLISTIDPRODUCTID_WISHLISTID_2 =
			"wishlistProduct.wishlistId = ? AND ";

	private static final String _FINDER_COLUMN_WISHLISTIDPRODUCTID_PRODUCTID_2 =
		"wishlistProduct.productId = ?";

	public WishlistProductPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

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

		setModelClass(WishlistProduct.class);
	}

	/**
	 * Caches the wishlist product in the entity cache if it is enabled.
	 *
	 * @param wishlistProduct the wishlist product
	 */
	@Override
	public void cacheResult(WishlistProduct wishlistProduct) {
		entityCache.putResult(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductImpl.class, wishlistProduct.getPrimaryKey(),
			wishlistProduct);

		finderCache.putResult(
			_finderPathFetchByWishlistIdProductId,
			new Object[] {
				wishlistProduct.getWishlistId(), wishlistProduct.getProductId()
			},
			wishlistProduct);

		wishlistProduct.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the wishlist products in the entity cache if it is enabled.
	 *
	 * @param wishlistProducts the wishlist products
	 */
	@Override
	public void cacheResult(List<WishlistProduct> wishlistProducts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (wishlistProducts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WishlistProduct wishlistProduct : wishlistProducts) {
			if (entityCache.getResult(
					WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
					WishlistProductImpl.class,
					wishlistProduct.getPrimaryKey()) == null) {

				cacheResult(wishlistProduct);
			}
			else {
				wishlistProduct.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wishlist products.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WishlistProductImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wishlist product.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WishlistProduct wishlistProduct) {
		entityCache.removeResult(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductImpl.class, wishlistProduct.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(WishlistProductModelImpl)wishlistProduct, true);
	}

	@Override
	public void clearCache(List<WishlistProduct> wishlistProducts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WishlistProduct wishlistProduct : wishlistProducts) {
			entityCache.removeResult(
				WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
				WishlistProductImpl.class, wishlistProduct.getPrimaryKey());

			clearUniqueFindersCache(
				(WishlistProductModelImpl)wishlistProduct, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
				WishlistProductImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		WishlistProductModelImpl wishlistProductModelImpl) {

		Object[] args = new Object[] {
			wishlistProductModelImpl.getWishlistId(),
			wishlistProductModelImpl.getProductId()
		};

		finderCache.putResult(
			_finderPathCountByWishlistIdProductId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByWishlistIdProductId, args,
			wishlistProductModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		WishlistProductModelImpl wishlistProductModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				wishlistProductModelImpl.getWishlistId(),
				wishlistProductModelImpl.getProductId()
			};

			finderCache.removeResult(
				_finderPathCountByWishlistIdProductId, args);
			finderCache.removeResult(
				_finderPathFetchByWishlistIdProductId, args);
		}

		if ((wishlistProductModelImpl.getColumnBitmask() &
			 _finderPathFetchByWishlistIdProductId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				wishlistProductModelImpl.getOriginalWishlistId(),
				wishlistProductModelImpl.getOriginalProductId()
			};

			finderCache.removeResult(
				_finderPathCountByWishlistIdProductId, args);
			finderCache.removeResult(
				_finderPathFetchByWishlistIdProductId, args);
		}
	}

	/**
	 * Creates a new wishlist product with the primary key. Does not add the wishlist product to the database.
	 *
	 * @param id the primary key for the new wishlist product
	 * @return the new wishlist product
	 */
	@Override
	public WishlistProduct create(long id) {
		WishlistProduct wishlistProduct = new WishlistProductImpl();

		wishlistProduct.setNew(true);
		wishlistProduct.setPrimaryKey(id);

		return wishlistProduct;
	}

	/**
	 * Removes the wishlist product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product that was removed
	 * @throws NoSuchWishlistProductException if a wishlist product with the primary key could not be found
	 */
	@Override
	public WishlistProduct remove(long id)
		throws NoSuchWishlistProductException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the wishlist product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wishlist product
	 * @return the wishlist product that was removed
	 * @throws NoSuchWishlistProductException if a wishlist product with the primary key could not be found
	 */
	@Override
	public WishlistProduct remove(Serializable primaryKey)
		throws NoSuchWishlistProductException {

		Session session = null;

		try {
			session = openSession();

			WishlistProduct wishlistProduct = (WishlistProduct)session.get(
				WishlistProductImpl.class, primaryKey);

			if (wishlistProduct == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWishlistProductException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(wishlistProduct);
		}
		catch (NoSuchWishlistProductException noSuchEntityException) {
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
	protected WishlistProduct removeImpl(WishlistProduct wishlistProduct) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wishlistProduct)) {
				wishlistProduct = (WishlistProduct)session.get(
					WishlistProductImpl.class,
					wishlistProduct.getPrimaryKeyObj());
			}

			if (wishlistProduct != null) {
				session.delete(wishlistProduct);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (wishlistProduct != null) {
			clearCache(wishlistProduct);
		}

		return wishlistProduct;
	}

	@Override
	public WishlistProduct updateImpl(WishlistProduct wishlistProduct) {
		boolean isNew = wishlistProduct.isNew();

		if (!(wishlistProduct instanceof WishlistProductModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(wishlistProduct.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					wishlistProduct);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in wishlistProduct proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WishlistProduct implementation " +
					wishlistProduct.getClass());
		}

		WishlistProductModelImpl wishlistProductModelImpl =
			(WishlistProductModelImpl)wishlistProduct;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (wishlistProduct.getCreateDate() == null)) {
			if (serviceContext == null) {
				wishlistProduct.setCreateDate(date);
			}
			else {
				wishlistProduct.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!wishlistProductModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wishlistProduct.setModifiedDate(date);
			}
			else {
				wishlistProduct.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(wishlistProduct);

				wishlistProduct.setNew(false);
			}
			else {
				wishlistProduct = (WishlistProduct)session.merge(
					wishlistProduct);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!WishlistProductModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductImpl.class, wishlistProduct.getPrimaryKey(),
			wishlistProduct, false);

		clearUniqueFindersCache(wishlistProductModelImpl, false);
		cacheUniqueFindersCache(wishlistProductModelImpl);

		wishlistProduct.resetOriginalValues();

		return wishlistProduct;
	}

	/**
	 * Returns the wishlist product with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wishlist product
	 * @return the wishlist product
	 * @throws NoSuchWishlistProductException if a wishlist product with the primary key could not be found
	 */
	@Override
	public WishlistProduct findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWishlistProductException {

		WishlistProduct wishlistProduct = fetchByPrimaryKey(primaryKey);

		if (wishlistProduct == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWishlistProductException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return wishlistProduct;
	}

	/**
	 * Returns the wishlist product with the primary key or throws a <code>NoSuchWishlistProductException</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product
	 * @throws NoSuchWishlistProductException if a wishlist product with the primary key could not be found
	 */
	@Override
	public WishlistProduct findByPrimaryKey(long id)
		throws NoSuchWishlistProductException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the wishlist product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wishlist product
	 * @return the wishlist product, or <code>null</code> if a wishlist product with the primary key could not be found
	 */
	@Override
	public WishlistProduct fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WishlistProduct wishlistProduct = (WishlistProduct)serializable;

		if (wishlistProduct == null) {
			Session session = null;

			try {
				session = openSession();

				wishlistProduct = (WishlistProduct)session.get(
					WishlistProductImpl.class, primaryKey);

				if (wishlistProduct != null) {
					cacheResult(wishlistProduct);
				}
				else {
					entityCache.putResult(
						WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
						WishlistProductImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
					WishlistProductImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return wishlistProduct;
	}

	/**
	 * Returns the wishlist product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product, or <code>null</code> if a wishlist product with the primary key could not be found
	 */
	@Override
	public WishlistProduct fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, WishlistProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WishlistProduct> map =
			new HashMap<Serializable, WishlistProduct>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WishlistProduct wishlistProduct = fetchByPrimaryKey(primaryKey);

			if (wishlistProduct != null) {
				map.put(primaryKey, wishlistProduct);
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
				WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
				WishlistProductImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WishlistProduct)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_WISHLISTPRODUCT_WHERE_PKS_IN);

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

			for (WishlistProduct wishlistProduct :
					(List<WishlistProduct>)query.list()) {

				map.put(wishlistProduct.getPrimaryKeyObj(), wishlistProduct);

				cacheResult(wishlistProduct);

				uncachedPrimaryKeys.remove(wishlistProduct.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
					WishlistProductImpl.class, primaryKey, nullModel);
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
	 * Returns all the wishlist products.
	 *
	 * @return the wishlist products
	 */
	@Override
	public List<WishlistProduct> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WishlistProduct> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<WishlistProduct> findAll(
		int start, int end,
		OrderByComparator<WishlistProduct> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<WishlistProduct> findAll(
		int start, int end,
		OrderByComparator<WishlistProduct> orderByComparator,
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

		List<WishlistProduct> list = null;

		if (useFinderCache) {
			list = (List<WishlistProduct>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WISHLISTPRODUCT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WISHLISTPRODUCT;

				sql = sql.concat(WishlistProductModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WishlistProduct>)QueryUtil.list(
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
	 * Removes all the wishlist products from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WishlistProduct wishlistProduct : findAll()) {
			remove(wishlistProduct);
		}
	}

	/**
	 * Returns the number of wishlist products.
	 *
	 * @return the number of wishlist products
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WISHLISTPRODUCT);

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
		return WishlistProductModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wishlist product persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductModelImpl.FINDER_CACHE_ENABLED,
			WishlistProductImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductModelImpl.FINDER_CACHE_ENABLED,
			WishlistProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByWishlistIdProductId = new FinderPath(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductModelImpl.FINDER_CACHE_ENABLED,
			WishlistProductImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByWishlistIdProductId",
			new String[] {Long.class.getName(), Long.class.getName()},
			WishlistProductModelImpl.WISHLISTID_COLUMN_BITMASK |
			WishlistProductModelImpl.PRODUCTID_COLUMN_BITMASK);

		_finderPathCountByWishlistIdProductId = new FinderPath(
			WishlistProductModelImpl.ENTITY_CACHE_ENABLED,
			WishlistProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByWishlistIdProductId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_setWishlistProductUtilPersistence(this);
	}

	public void destroy() {
		_setWishlistProductUtilPersistence(null);

		entityCache.removeCache(WishlistProductImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setWishlistProductUtilPersistence(
		WishlistProductPersistence wishlistProductPersistence) {

		try {
			Field field = WishlistProductUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, wishlistProductPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_WISHLISTPRODUCT =
		"SELECT wishlistProduct FROM WishlistProduct wishlistProduct";

	private static final String _SQL_SELECT_WISHLISTPRODUCT_WHERE_PKS_IN =
		"SELECT wishlistProduct FROM WishlistProduct wishlistProduct WHERE id_ IN (";

	private static final String _SQL_SELECT_WISHLISTPRODUCT_WHERE =
		"SELECT wishlistProduct FROM WishlistProduct wishlistProduct WHERE ";

	private static final String _SQL_COUNT_WISHLISTPRODUCT =
		"SELECT COUNT(wishlistProduct) FROM WishlistProduct wishlistProduct";

	private static final String _SQL_COUNT_WISHLISTPRODUCT_WHERE =
		"SELECT COUNT(wishlistProduct) FROM WishlistProduct wishlistProduct WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "wishlistProduct.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WishlistProduct exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WishlistProduct exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WishlistProductPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

}