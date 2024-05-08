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

import com.onlineshopping.product.service.exception.NoSuchWishlistException;
import com.onlineshopping.product.service.model.Wishlist;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the wishlist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishlistUtil
 * @generated
 */
@ProviderType
public interface WishlistPersistence extends BasePersistence<Wishlist> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WishlistUtil} to access the wishlist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Wishlist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the wishlists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching wishlists
	 */
	public java.util.List<Wishlist> findByUuid(String uuid);

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
	public java.util.List<Wishlist> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Wishlist> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
			orderByComparator);

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
	public java.util.List<Wishlist> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	public Wishlist findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
				orderByComparator)
		throws NoSuchWishlistException;

	/**
	 * Returns the first wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public Wishlist fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
			orderByComparator);

	/**
	 * Returns the last wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	public Wishlist findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
				orderByComparator)
		throws NoSuchWishlistException;

	/**
	 * Returns the last wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public Wishlist fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
			orderByComparator);

	/**
	 * Returns the wishlists before and after the current wishlist in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current wishlist
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wishlist
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	public Wishlist[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
				orderByComparator)
		throws NoSuchWishlistException;

	/**
	 * Removes all the wishlists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of wishlists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching wishlists
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the wishlist where userId = &#63; or throws a <code>NoSuchWishlistException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching wishlist
	 * @throws NoSuchWishlistException if a matching wishlist could not be found
	 */
	public Wishlist findByUserId(long userId) throws NoSuchWishlistException;

	/**
	 * Returns the wishlist where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public Wishlist fetchByUserId(long userId);

	/**
	 * Returns the wishlist where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching wishlist, or <code>null</code> if a matching wishlist could not be found
	 */
	public Wishlist fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the wishlist where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the wishlist that was removed
	 */
	public Wishlist removeByUserId(long userId) throws NoSuchWishlistException;

	/**
	 * Returns the number of wishlists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching wishlists
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the wishlist in the entity cache if it is enabled.
	 *
	 * @param wishlist the wishlist
	 */
	public void cacheResult(Wishlist wishlist);

	/**
	 * Caches the wishlists in the entity cache if it is enabled.
	 *
	 * @param wishlists the wishlists
	 */
	public void cacheResult(java.util.List<Wishlist> wishlists);

	/**
	 * Creates a new wishlist with the primary key. Does not add the wishlist to the database.
	 *
	 * @param id the primary key for the new wishlist
	 * @return the new wishlist
	 */
	public Wishlist create(long id);

	/**
	 * Removes the wishlist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist that was removed
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	public Wishlist remove(long id) throws NoSuchWishlistException;

	public Wishlist updateImpl(Wishlist wishlist);

	/**
	 * Returns the wishlist with the primary key or throws a <code>NoSuchWishlistException</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist
	 * @throws NoSuchWishlistException if a wishlist with the primary key could not be found
	 */
	public Wishlist findByPrimaryKey(long id) throws NoSuchWishlistException;

	/**
	 * Returns the wishlist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the wishlist
	 * @return the wishlist, or <code>null</code> if a wishlist with the primary key could not be found
	 */
	public Wishlist fetchByPrimaryKey(long id);

	/**
	 * Returns all the wishlists.
	 *
	 * @return the wishlists
	 */
	public java.util.List<Wishlist> findAll();

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
	public java.util.List<Wishlist> findAll(int start, int end);

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
	public java.util.List<Wishlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
			orderByComparator);

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
	public java.util.List<Wishlist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Wishlist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the wishlists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of wishlists.
	 *
	 * @return the number of wishlists
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}