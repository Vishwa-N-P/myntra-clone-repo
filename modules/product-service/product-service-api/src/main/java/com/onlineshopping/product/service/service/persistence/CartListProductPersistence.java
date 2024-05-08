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

import com.onlineshopping.product.service.exception.NoSuchCartListProductException;
import com.onlineshopping.product.service.model.CartListProduct;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the cart list product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartListProductUtil
 * @generated
 */
@ProviderType
public interface CartListProductPersistence
	extends BasePersistence<CartListProduct> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CartListProductUtil} to access the cart list product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CartListProduct> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the matching cart list product
	 * @throws NoSuchCartListProductException if a matching cart list product could not be found
	 */
	public CartListProduct findByCartListIdProductId(
			long cartListId, long productId)
		throws NoSuchCartListProductException;

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public CartListProduct fetchByCartListIdProductId(
		long cartListId, long productId);

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public CartListProduct fetchByCartListIdProductId(
		long cartListId, long productId, boolean useFinderCache);

	/**
	 * Removes the cart list product where cartListId = &#63; and productId = &#63; from the database.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the cart list product that was removed
	 */
	public CartListProduct removeByCartListIdProductId(
			long cartListId, long productId)
		throws NoSuchCartListProductException;

	/**
	 * Returns the number of cart list products where cartListId = &#63; and productId = &#63;.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @return the number of matching cart list products
	 */
	public int countByCartListIdProductId(long cartListId, long productId);

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the matching cart list product
	 * @throws NoSuchCartListProductException if a matching cart list product could not be found
	 */
	public CartListProduct findByCartListIdProductIdSize(
			long cartListId, long productId, String size)
		throws NoSuchCartListProductException;

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public CartListProduct fetchByCartListIdProductIdSize(
		long cartListId, long productId, String size);

	/**
	 * Returns the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list product, or <code>null</code> if a matching cart list product could not be found
	 */
	public CartListProduct fetchByCartListIdProductIdSize(
		long cartListId, long productId, String size, boolean useFinderCache);

	/**
	 * Removes the cart list product where cartListId = &#63; and productId = &#63; and size = &#63; from the database.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the cart list product that was removed
	 */
	public CartListProduct removeByCartListIdProductIdSize(
			long cartListId, long productId, String size)
		throws NoSuchCartListProductException;

	/**
	 * Returns the number of cart list products where cartListId = &#63; and productId = &#63; and size = &#63;.
	 *
	 * @param cartListId the cart list ID
	 * @param productId the product ID
	 * @param size the size
	 * @return the number of matching cart list products
	 */
	public int countByCartListIdProductIdSize(
		long cartListId, long productId, String size);

	/**
	 * Caches the cart list product in the entity cache if it is enabled.
	 *
	 * @param cartListProduct the cart list product
	 */
	public void cacheResult(CartListProduct cartListProduct);

	/**
	 * Caches the cart list products in the entity cache if it is enabled.
	 *
	 * @param cartListProducts the cart list products
	 */
	public void cacheResult(java.util.List<CartListProduct> cartListProducts);

	/**
	 * Creates a new cart list product with the primary key. Does not add the cart list product to the database.
	 *
	 * @param id the primary key for the new cart list product
	 * @return the new cart list product
	 */
	public CartListProduct create(long id);

	/**
	 * Removes the cart list product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product that was removed
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	public CartListProduct remove(long id)
		throws NoSuchCartListProductException;

	public CartListProduct updateImpl(CartListProduct cartListProduct);

	/**
	 * Returns the cart list product with the primary key or throws a <code>NoSuchCartListProductException</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product
	 * @throws NoSuchCartListProductException if a cart list product with the primary key could not be found
	 */
	public CartListProduct findByPrimaryKey(long id)
		throws NoSuchCartListProductException;

	/**
	 * Returns the cart list product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list product
	 * @return the cart list product, or <code>null</code> if a cart list product with the primary key could not be found
	 */
	public CartListProduct fetchByPrimaryKey(long id);

	/**
	 * Returns all the cart list products.
	 *
	 * @return the cart list products
	 */
	public java.util.List<CartListProduct> findAll();

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
	public java.util.List<CartListProduct> findAll(int start, int end);

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
	public java.util.List<CartListProduct> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartListProduct>
			orderByComparator);

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
	public java.util.List<CartListProduct> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartListProduct>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cart list products from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cart list products.
	 *
	 * @return the number of cart list products
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}