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

import com.onlineshopping.product.service.exception.NoSuchOrderException;
import com.onlineshopping.product.service.model.ProductOrder;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the product order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductOrderUtil
 * @generated
 */
@ProviderType
public interface ProductOrderPersistence extends BasePersistence<ProductOrder> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductOrderUtil} to access the product order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ProductOrder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the product orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product orders
	 */
	public java.util.List<ProductOrder> findByUuid(String uuid);

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
	public java.util.List<ProductOrder> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductOrder> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
			orderByComparator);

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
	public java.util.List<ProductOrder> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product order
	 * @throws NoSuchOrderException if a matching product order could not be found
	 */
	public ProductOrder findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
				orderByComparator)
		throws NoSuchOrderException;

	/**
	 * Returns the first product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product order, or <code>null</code> if a matching product order could not be found
	 */
	public ProductOrder fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
			orderByComparator);

	/**
	 * Returns the last product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product order
	 * @throws NoSuchOrderException if a matching product order could not be found
	 */
	public ProductOrder findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
				orderByComparator)
		throws NoSuchOrderException;

	/**
	 * Returns the last product order in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product order, or <code>null</code> if a matching product order could not be found
	 */
	public ProductOrder fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
			orderByComparator);

	/**
	 * Returns the product orders before and after the current product order in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current product order
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	public ProductOrder[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
				orderByComparator)
		throws NoSuchOrderException;

	/**
	 * Removes all the product orders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product orders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product orders
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the product order in the entity cache if it is enabled.
	 *
	 * @param productOrder the product order
	 */
	public void cacheResult(ProductOrder productOrder);

	/**
	 * Caches the product orders in the entity cache if it is enabled.
	 *
	 * @param productOrders the product orders
	 */
	public void cacheResult(java.util.List<ProductOrder> productOrders);

	/**
	 * Creates a new product order with the primary key. Does not add the product order to the database.
	 *
	 * @param id the primary key for the new product order
	 * @return the new product order
	 */
	public ProductOrder create(long id);

	/**
	 * Removes the product order with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the product order
	 * @return the product order that was removed
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	public ProductOrder remove(long id) throws NoSuchOrderException;

	public ProductOrder updateImpl(ProductOrder productOrder);

	/**
	 * Returns the product order with the primary key or throws a <code>NoSuchOrderException</code> if it could not be found.
	 *
	 * @param id the primary key of the product order
	 * @return the product order
	 * @throws NoSuchOrderException if a product order with the primary key could not be found
	 */
	public ProductOrder findByPrimaryKey(long id) throws NoSuchOrderException;

	/**
	 * Returns the product order with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the product order
	 * @return the product order, or <code>null</code> if a product order with the primary key could not be found
	 */
	public ProductOrder fetchByPrimaryKey(long id);

	/**
	 * Returns all the product orders.
	 *
	 * @return the product orders
	 */
	public java.util.List<ProductOrder> findAll();

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
	public java.util.List<ProductOrder> findAll(int start, int end);

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
	public java.util.List<ProductOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
			orderByComparator);

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
	public java.util.List<ProductOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductOrder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product orders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product orders.
	 *
	 * @return the number of product orders
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}