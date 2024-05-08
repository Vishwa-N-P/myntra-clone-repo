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

import com.onlineshopping.product.service.exception.NoSuchCartListException;
import com.onlineshopping.product.service.model.CartList;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the cart list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartListUtil
 * @generated
 */
@ProviderType
public interface CartListPersistence extends BasePersistence<CartList> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CartListUtil} to access the cart list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CartList> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the cart lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cart lists
	 */
	public java.util.List<CartList> findByUuid(String uuid);

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
	public java.util.List<CartList> findByUuid(String uuid, int start, int end);

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
	public java.util.List<CartList> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartList>
			orderByComparator);

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
	public java.util.List<CartList> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cart list
	 * @throws NoSuchCartListException if a matching cart list could not be found
	 */
	public CartList findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CartList>
				orderByComparator)
		throws NoSuchCartListException;

	/**
	 * Returns the first cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	public CartList fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CartList>
			orderByComparator);

	/**
	 * Returns the last cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cart list
	 * @throws NoSuchCartListException if a matching cart list could not be found
	 */
	public CartList findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CartList>
				orderByComparator)
		throws NoSuchCartListException;

	/**
	 * Returns the last cart list in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	public CartList fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CartList>
			orderByComparator);

	/**
	 * Returns the cart lists before and after the current cart list in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current cart list
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cart list
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	public CartList[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CartList>
				orderByComparator)
		throws NoSuchCartListException;

	/**
	 * Removes all the cart lists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cart lists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cart lists
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cart list where userId = &#63; or throws a <code>NoSuchCartListException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching cart list
	 * @throws NoSuchCartListException if a matching cart list could not be found
	 */
	public CartList findByUserId(long userId) throws NoSuchCartListException;

	/**
	 * Returns the cart list where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	public CartList fetchByUserId(long userId);

	/**
	 * Returns the cart list where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cart list, or <code>null</code> if a matching cart list could not be found
	 */
	public CartList fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the cart list where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the cart list that was removed
	 */
	public CartList removeByUserId(long userId) throws NoSuchCartListException;

	/**
	 * Returns the number of cart lists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cart lists
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the cart list in the entity cache if it is enabled.
	 *
	 * @param cartList the cart list
	 */
	public void cacheResult(CartList cartList);

	/**
	 * Caches the cart lists in the entity cache if it is enabled.
	 *
	 * @param cartLists the cart lists
	 */
	public void cacheResult(java.util.List<CartList> cartLists);

	/**
	 * Creates a new cart list with the primary key. Does not add the cart list to the database.
	 *
	 * @param id the primary key for the new cart list
	 * @return the new cart list
	 */
	public CartList create(long id);

	/**
	 * Removes the cart list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list that was removed
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	public CartList remove(long id) throws NoSuchCartListException;

	public CartList updateImpl(CartList cartList);

	/**
	 * Returns the cart list with the primary key or throws a <code>NoSuchCartListException</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list
	 * @throws NoSuchCartListException if a cart list with the primary key could not be found
	 */
	public CartList findByPrimaryKey(long id) throws NoSuchCartListException;

	/**
	 * Returns the cart list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cart list
	 * @return the cart list, or <code>null</code> if a cart list with the primary key could not be found
	 */
	public CartList fetchByPrimaryKey(long id);

	/**
	 * Returns all the cart lists.
	 *
	 * @return the cart lists
	 */
	public java.util.List<CartList> findAll();

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
	public java.util.List<CartList> findAll(int start, int end);

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
	public java.util.List<CartList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartList>
			orderByComparator);

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
	public java.util.List<CartList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CartList>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cart lists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cart lists.
	 *
	 * @return the number of cart lists
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}