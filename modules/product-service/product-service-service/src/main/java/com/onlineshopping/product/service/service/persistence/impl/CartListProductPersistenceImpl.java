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

import com.onlineshopping.product.service.exception.NoSuchCartListProductException;
import com.onlineshopping.product.service.model.CartListProduct;
import com.onlineshopping.product.service.model.impl.CartListProductImpl;
import com.onlineshopping.product.service.model.impl.CartListProductModelImpl;
import com.onlineshopping.product.service.service.persistence.CartListProductPersistence;
import com.onlineshopping.product.service.service.persistence.CartListProductUtil;

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
 * The persistence implementation for the cart list product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CartListProductPersistenceImpl
	extends BasePersistenceImpl<CartListProduct>
	implements CartListProductPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CartListProductUtil</code> to access the cart list product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CartListProductImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCartListIdProductId;
	private FinderPath _finderPathCountByCartListIdProductId;

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the matching cart list product
	 * @throws NoSuchCartListProductException if a matching cart list product could not be found
	 */
	@Override
	public CartListProduct findByCartListIdProductId(
			long cartListId, long productId)
		throws NoSuchCartListProductException {

		CartListProduct cartListProduct = fetchByCartListIdProductId(
			cartListId, productId);

		if (cartListProduct == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("cartListId=");
			sb.append(cartListId);

			sb.append(", productId=");
			sb.append(productId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCartListProductException(sb.toString());
		}

		return cartListProduct;
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	@Override
	public CartListProduct fetchByCartListIdProductId(
		long cartListId, long productId) {

		return fetchByCartListIdProductId(cartListId, productId, true);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	@Override
	public CartListProduct fetchByCartListIdProductId(
		long cartListId, long productId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {cartListId, productId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCartListIdProductId, finderArgs, this);
		}

		if (result instanceof CartListProduct) {
			CartListProduct cartListProduct = (CartListProduct)result;

			if ((cartListId != cartListProduct.getCartListId()) ||
				(productId != cartListProduct.getProductId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CARTLISTPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTID_CARTLISTID_2);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cartListId);

				queryPos.add(productId);

				List<CartListProduct> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCartListIdProductId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									cartListId, productId
								};
							}

							_log.warn(
								"CartListProductPersistenceImpl.fetchByCartListIdProductId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CartListProduct cartListProduct = list.get(0);

					result = cartListProduct;

					cacheResult(cartListProduct);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByCartListIdProductId, finderArgs);
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
			return (CartListProduct)result;
		}
	}

	/**
	 * Removes the cart list product where cartListId = &#63; and productId = &#63; from the database.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the cart list product that was removed
	 */
	@Override
	public CartListProduct removeByCartListIdProductId(
			long cartListId, long productId)
		throws NoSuchCartListProductException {

		CartListProduct cartListProduct = findByCartListIdProductId(
			cartListId, productId);

		return remove(cartListProduct);
	}

	/**
	 * Returns the number of cart list products where cartListId = &#63; and productId = &#63;.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the number of matching cart list products
	 */
	@Override
	public int countByCartListIdProductId(long cartListId, long productId) {
		FinderPath finderPath = _finderPathCountByCartListIdProductId;

		Object[] finderArgs = new Object[] {cartListId, productId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CARTLISTPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTID_CARTLISTID_2);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cartListId);

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
		_FINDER_COLUMN_CARTLISTIDPRODUCTID_CARTLISTID_2 =
			"cartListProduct.cartListId = ? AND ";

	private static final String _FINDER_COLUMN_CARTLISTIDPRODUCTID_PRODUCTID_2 =
		"cartListProduct.productId = ?";

	private FinderPath _finderPathFetchByCartListIdProductIdSize;
	private FinderPath _finderPathCountByCartListIdProductIdSize;

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the matching cart list product
	 * @throws NoSuchCartListProductException if a matching cart list product could not be found
	 */
	@Override
	public CartListProduct findByCartListIdProductIdSize(
			long cartListId, long productId, String size)
		throws NoSuchCartListProductException {

		CartListProduct cartListProduct = fetchByCartListIdProductIdSize(
			cartListId, productId, size);

		if (cartListProduct == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("cartListId=");
			sb.append(cartListId);

			sb.append(", productId=");
			sb.append(productId);

			sb.append(", size=");
			sb.append(size);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCartListProductException(sb.toString());
		}

		return cartListProduct;
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	@Override
	public CartListProduct fetchByCartListIdProductIdSize(
		long cartListId, long productId, String size) {

		return fetchByCartListIdProductIdSize(
			cartListId, productId, size, true);
	}

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	@Override
	public CartListProduct fetchByCartListIdProductIdSize(
		long cartListId, long productId, String size, boolean useFinderCache) {

		size = Objects.toString(size, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {cartListId, productId, size};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCartListIdProductIdSize, finderArgs, this);
		}

		if (result instanceof CartListProduct) {
			CartListProduct cartListProduct = (CartListProduct)result;

			if ((cartListId != cartListProduct.getCartListId()) ||
				(productId != cartListProduct.getProductId()) ||
				!Objects.equals(size, cartListProduct.getSize())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_CARTLISTPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_CARTLISTID_2);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_PRODUCTID_2);

			boolean bindSize = false;

			if (size.isEmpty()) {
				sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_SIZE_3);
			}
			else {
				bindSize = true;

				sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_SIZE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cartListId);

				queryPos.add(productId);

				if (bindSize) {
					queryPos.add(size);
				}

				List<CartListProduct> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCartListIdProductIdSize,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									cartListId, productId, size
								};
							}

							_log.warn(
								"CartListProductPersistenceImpl.fetchByCartListIdProductIdSize(long, long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CartListProduct cartListProduct = list.get(0);

					result = cartListProduct;

					cacheResult(cartListProduct);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByCartListIdProductIdSize, finderArgs);
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
			return (CartListProduct)result;
		}
	}

	/**
	 * Removes the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; from the database.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the cart list product that was removed
	 */
	@Override
	public CartListProduct removeByCartListIdProductIdSize(
			long cartListId, long productId, String size)
		throws NoSuchCartListProductException {

		CartListProduct cartListProduct = findByCartListIdProductIdSize(
			cartListId, productId, size);

		return remove(cartListProduct);
	}

	/**
	 * Returns the number of cart list products where cartListId = &#63; and productId = &#63; and size = &#63;.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the number of matching cart list products
	 */
	@Override
	public int countByCartListIdProductIdSize(
		long cartListId, long productId, String size) {

		size = Objects.toString(size, "");

		FinderPath finderPath = _finderPathCountByCartListIdProductIdSize;

		Object[] finderArgs = new Object[] {cartListId, productId, size};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CARTLISTPRODUCT_WHERE);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_CARTLISTID_2);

			sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_PRODUCTID_2);

			boolean bindSize = false;

			if (size.isEmpty()) {
				sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_SIZE_3);
			}
			else {
				bindSize = true;

				sb.append(_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_SIZE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cartListId);

				queryPos.add(productId);

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

	private static final String
		_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_CARTLISTID_2 =
			"cartListProduct.cartListId = ? AND ";

	private static final String
		_FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_PRODUCTID_2 =
			"cartListProduct.productId = ? AND ";

	private static final String _FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_SIZE_2 =
		"cartListProduct.size = ?";

	private static final String _FINDER_COLUMN_CARTLISTIDPRODUCTIDSIZE_SIZE_3 =
		"(cartListProduct.size IS NULL OR cartListProduct.size = '')";

	public CartListProductPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

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

		setModelClass(CartListProduct.class);
	}

	/**
	 * Caches the cart list product in the entity cache if it is enabled.
	 *
	 * @param cartListProduct the cart list product
	 */
	@Override
	public void cacheResult(CartListProduct cartListProduct) {
		entityCache.putResult(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductImpl.class, cartListProduct.getPrimaryKey(),
			cartListProduct);

		finderCache.putResult(
			_finderPathFetchByCartListIdProductId,
			new Object[] {
				cartListProduct.getCartListId(), cartListProduct.getProductId()
			},
			cartListProduct);

		finderCache.putResult(
			_finderPathFetchByCartListIdProductIdSize,
			new Object[] {
				cartListProduct.getCartListId(), cartListProduct.getProductId(),
				cartListProduct.getSize()
			},
			cartListProduct);

		cartListProduct.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cart list products in the entity cache if it is enabled.
	 *
	 * @param cartListProducts the cart list products
	 */
	@Override
	public void cacheResult(List<CartListProduct> cartListProducts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cartListProducts.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CartListProduct cartListProduct : cartListProducts) {
			if (entityCache.getResult(
					CartListProductModelImpl.ENTITY_CACHE_ENABLED,
					CartListProductImpl.class,
					cartListProduct.getPrimaryKey()) == null) {

				cacheResult(cartListProduct);
			}
			else {
				cartListProduct.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cart list products.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CartListProductImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cart list product.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CartListProduct cartListProduct) {
		entityCache.removeResult(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductImpl.class, cartListProduct.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CartListProductModelImpl)cartListProduct, true);
	}

	@Override
	public void clearCache(List<CartListProduct> cartListProducts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CartListProduct cartListProduct : cartListProducts) {
			entityCache.removeResult(
				CartListProductModelImpl.ENTITY_CACHE_ENABLED,
				CartListProductImpl.class, cartListProduct.getPrimaryKey());

			clearUniqueFindersCache(
				(CartListProductModelImpl)cartListProduct, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CartListProductModelImpl.ENTITY_CACHE_ENABLED,
				CartListProductImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CartListProductModelImpl cartListProductModelImpl) {

		Object[] args = new Object[] {
			cartListProductModelImpl.getCartListId(),
			cartListProductModelImpl.getProductId()
		};

		finderCache.putResult(
			_finderPathCountByCartListIdProductId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByCartListIdProductId, args,
			cartListProductModelImpl, false);

		args = new Object[] {
			cartListProductModelImpl.getCartListId(),
			cartListProductModelImpl.getProductId(),
			cartListProductModelImpl.getSize()
		};

		finderCache.putResult(
			_finderPathCountByCartListIdProductIdSize, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByCartListIdProductIdSize, args,
			cartListProductModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CartListProductModelImpl cartListProductModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				cartListProductModelImpl.getCartListId(),
				cartListProductModelImpl.getProductId()
			};

			finderCache.removeResult(
				_finderPathCountByCartListIdProductId, args);
			finderCache.removeResult(
				_finderPathFetchByCartListIdProductId, args);
		}

		if ((cartListProductModelImpl.getColumnBitmask() &
			 _finderPathFetchByCartListIdProductId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				cartListProductModelImpl.getOriginalCartListId(),
				cartListProductModelImpl.getOriginalProductId()
			};

			finderCache.removeResult(
				_finderPathCountByCartListIdProductId, args);
			finderCache.removeResult(
				_finderPathFetchByCartListIdProductId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				cartListProductModelImpl.getCartListId(),
				cartListProductModelImpl.getProductId(),
				cartListProductModelImpl.getSize()
			};

			finderCache.removeResult(
				_finderPathCountByCartListIdProductIdSize, args);
			finderCache.removeResult(
				_finderPathFetchByCartListIdProductIdSize, args);
		}

		if ((cartListProductModelImpl.getColumnBitmask() &
			 _finderPathFetchByCartListIdProductIdSize.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				cartListProductModelImpl.getOriginalCartListId(),
				cartListProductModelImpl.getOriginalProductId(),
				cartListProductModelImpl.getOriginalSize()
			};

			finderCache.removeResult(
				_finderPathCountByCartListIdProductIdSize, args);
			finderCache.removeResult(
				_finderPathFetchByCartListIdProductIdSize, args);
		}
	}

	/**
	 * Creates a new cart list product with the primary key. Does not add the cart list product to the database.
	 *
	 * @param id the primary key for the new cart list product
	 * @return the new cart list product
	 */
	@Override
	public CartListProduct create(long id) {
		CartListProduct cartListProduct = new CartListProductImpl();

		cartListProduct.setNew(true);
		cartListProduct.setPrimaryKey(id);

		return cartListProduct;
	}

	/**
	 * Removes the cart list product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product that was removed
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	@Override
	public CartListProduct remove(long id)
		throws NoSuchCartListProductException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the cart list product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cart list product
	 * @return the cart list product that was removed
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	@Override
	public CartListProduct remove(Serializable primaryKey)
		throws NoSuchCartListProductException {

		Session session = null;

		try {
			session = openSession();

			CartListProduct cartListProduct = (CartListProduct)session.get(
				CartListProductImpl.class, primaryKey);

			if (cartListProduct == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCartListProductException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cartListProduct);
		}
		catch (NoSuchCartListProductException noSuchEntityException) {
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
	protected CartListProduct removeImpl(CartListProduct cartListProduct) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cartListProduct)) {
				cartListProduct = (CartListProduct)session.get(
					CartListProductImpl.class,
					cartListProduct.getPrimaryKeyObj());
			}

			if (cartListProduct != null) {
				session.delete(cartListProduct);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cartListProduct != null) {
			clearCache(cartListProduct);
		}

		return cartListProduct;
	}

	@Override
	public CartListProduct updateImpl(CartListProduct cartListProduct) {
		boolean isNew = cartListProduct.isNew();

		if (!(cartListProduct instanceof CartListProductModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cartListProduct.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cartListProduct);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cartListProduct proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CartListProduct implementation " +
					cartListProduct.getClass());
		}

		CartListProductModelImpl cartListProductModelImpl =
			(CartListProductModelImpl)cartListProduct;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (cartListProduct.getCreateDate() == null)) {
			if (serviceContext == null) {
				cartListProduct.setCreateDate(date);
			}
			else {
				cartListProduct.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!cartListProductModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cartListProduct.setModifiedDate(date);
			}
			else {
				cartListProduct.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cartListProduct);

				cartListProduct.setNew(false);
			}
			else {
				cartListProduct = (CartListProduct)session.merge(
					cartListProduct);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CartListProductModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductImpl.class, cartListProduct.getPrimaryKey(),
			cartListProduct, false);

		clearUniqueFindersCache(cartListProductModelImpl, false);
		cacheUniqueFindersCache(cartListProductModelImpl);

		cartListProduct.resetOriginalValues();

		return cartListProduct;
	}

	/**
	 * Returns the cart list product with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cart list product
	 * @return the cart list product
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	@Override
	public CartListProduct findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCartListProductException {

		CartListProduct cartListProduct = fetchByPrimaryKey(primaryKey);

		if (cartListProduct == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCartListProductException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cartListProduct;
	}

	/**
	 * Returns the cart list product with the primary key or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	@Override
	public CartListProduct findByPrimaryKey(long id)
		throws NoSuchCartListProductException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cart list product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cart list product
	 * @return the cart list product, or <code>null</code> if a cart list product with the primary key could not be found
	 */
	@Override
	public CartListProduct fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CartListProduct cartListProduct = (CartListProduct)serializable;

		if (cartListProduct == null) {
			Session session = null;

			try {
				session = openSession();

				cartListProduct = (CartListProduct)session.get(
					CartListProductImpl.class, primaryKey);

				if (cartListProduct != null) {
					cacheResult(cartListProduct);
				}
				else {
					entityCache.putResult(
						CartListProductModelImpl.ENTITY_CACHE_ENABLED,
						CartListProductImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					CartListProductModelImpl.ENTITY_CACHE_ENABLED,
					CartListProductImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return cartListProduct;
	}

	/**
	 * Returns the cart list product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product, or <code>null</code> if a cart list product with the primary key could not be found
	 */
	@Override
	public CartListProduct fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, CartListProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CartListProduct> map =
			new HashMap<Serializable, CartListProduct>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CartListProduct cartListProduct = fetchByPrimaryKey(primaryKey);

			if (cartListProduct != null) {
				map.put(primaryKey, cartListProduct);
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
				CartListProductModelImpl.ENTITY_CACHE_ENABLED,
				CartListProductImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CartListProduct)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_CARTLISTPRODUCT_WHERE_PKS_IN);

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

			for (CartListProduct cartListProduct :
					(List<CartListProduct>)query.list()) {

				map.put(cartListProduct.getPrimaryKeyObj(), cartListProduct);

				cacheResult(cartListProduct);

				uncachedPrimaryKeys.remove(cartListProduct.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CartListProductModelImpl.ENTITY_CACHE_ENABLED,
					CartListProductImpl.class, primaryKey, nullModel);
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
	 * Returns all the cart list products.
	 *
	 * @return the cart list products
	 */
	@Override
	public List<CartListProduct> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @return the range of cart list products
	 */
	@Override
	public List<CartListProduct> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cart list products
	 */
	@Override
	public List<CartListProduct> findAll(
		int start, int end,
		OrderByComparator<CartListProduct> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cart list products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CartListProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cart list products
	 * @param end the upper bound of the range of cart list products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cart list products
	 */
	@Override
	public List<CartListProduct> findAll(
		int start, int end,
		OrderByComparator<CartListProduct> orderByComparator,
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

		List<CartListProduct> list = null;

		if (useFinderCache) {
			list = (List<CartListProduct>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CARTLISTPRODUCT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CARTLISTPRODUCT;

				sql = sql.concat(CartListProductModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CartListProduct>)QueryUtil.list(
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
	 * Removes all the cart list products from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CartListProduct cartListProduct : findAll()) {
			remove(cartListProduct);
		}
	}

	/**
	 * Returns the number of cart list products.
	 *
	 * @return the number of cart list products
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CARTLISTPRODUCT);

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
		return CartListProductModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cart list product persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED,
			CartListProductImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED,
			CartListProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByCartListIdProductId = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED,
			CartListProductImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCartListIdProductId",
			new String[] {Long.class.getName(), Long.class.getName()},
			CartListProductModelImpl.CARTLISTID_COLUMN_BITMASK |
			CartListProductModelImpl.PRODUCTID_COLUMN_BITMASK);

		_finderPathCountByCartListIdProductId = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCartListIdProductId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByCartListIdProductIdSize = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED,
			CartListProductImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCartListIdProductIdSize",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CartListProductModelImpl.CARTLISTID_COLUMN_BITMASK |
			CartListProductModelImpl.PRODUCTID_COLUMN_BITMASK |
			CartListProductModelImpl.SIZE_COLUMN_BITMASK);

		_finderPathCountByCartListIdProductIdSize = new FinderPath(
			CartListProductModelImpl.ENTITY_CACHE_ENABLED,
			CartListProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCartListIdProductIdSize",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_setCartListProductUtilPersistence(this);
	}

	public void destroy() {
		_setCartListProductUtilPersistence(null);

		entityCache.removeCache(CartListProductImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setCartListProductUtilPersistence(
		CartListProductPersistence cartListProductPersistence) {

		try {
			Field field = CartListProductUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, cartListProductPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CARTLISTPRODUCT =
		"SELECT cartListProduct FROM CartListProduct cartListProduct";

	private static final String _SQL_SELECT_CARTLISTPRODUCT_WHERE_PKS_IN =
		"SELECT cartListProduct FROM CartListProduct cartListProduct WHERE id_ IN (";

	private static final String _SQL_SELECT_CARTLISTPRODUCT_WHERE =
		"SELECT cartListProduct FROM CartListProduct cartListProduct WHERE ";

	private static final String _SQL_COUNT_CARTLISTPRODUCT =
		"SELECT COUNT(cartListProduct) FROM CartListProduct cartListProduct";

	private static final String _SQL_COUNT_CARTLISTPRODUCT_WHERE =
		"SELECT COUNT(cartListProduct) FROM CartListProduct cartListProduct WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cartListProduct.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CartListProduct exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CartListProduct exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CartListProductPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "size"});

}