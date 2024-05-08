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

import com.onlineshopping.product.service.exception.NoSuchImageException;
import com.onlineshopping.product.service.model.Image;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageUtil
 * @generated
 */
@ProviderType
public interface ImagePersistence extends BasePersistence<Image> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImageUtil} to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Image> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching images
	 */
	public java.util.List<Image> findByUuid(String uuid);

	/**
	 * Returns a range of all the images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	public java.util.List<Image> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	public java.util.List<Image> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns an ordered range of all the images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	public java.util.List<Image> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Image>
				orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the first image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns the last image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Image>
				orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the last image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns the images before and after the current image in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current image
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Image>
				orderByComparator)
		throws NoSuchImageException;

	/**
	 * Removes all the images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching images
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the images where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching images
	 */
	public java.util.List<Image> findByProductId(long productId);

	/**
	 * Returns a range of all the images where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	public java.util.List<Image> findByProductId(
		long productId, int start, int end);

	/**
	 * Returns an ordered range of all the images where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	public java.util.List<Image> findByProductId(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns an ordered range of all the images where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	public java.util.List<Image> findByProductId(
		long productId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByProductId_First(
			long productId,
			com.liferay.portal.kernel.util.OrderByComparator<Image>
				orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the first image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByProductId_First(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns the last image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByProductId_Last(
			long productId,
			com.liferay.portal.kernel.util.OrderByComparator<Image>
				orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the last image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByProductId_Last(
		long productId,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns the images before and after the current image in the ordered set where productId = &#63;.
	 *
	 * @param id the primary key of the current image
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image[] findByProductId_PrevAndNext(
			long id, long productId,
			com.liferay.portal.kernel.util.OrderByComparator<Image>
				orderByComparator)
		throws NoSuchImageException;

	/**
	 * Removes all the images where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 */
	public void removeByProductId(long productId);

	/**
	 * Returns the number of images where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching images
	 */
	public int countByProductId(long productId);

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByImageUrlProductId(String imageUrl, long productId)
		throws NoSuchImageException;

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByImageUrlProductId(String imageUrl, long productId);

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByImageUrlProductId(
		String imageUrl, long productId, boolean useFinderCache);

	/**
	 * Removes the image where imageUrl = &#63; and productId = &#63; from the database.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the image that was removed
	 */
	public Image removeByImageUrlProductId(String imageUrl, long productId)
		throws NoSuchImageException;

	/**
	 * Returns the number of images where imageUrl = &#63; and productId = &#63;.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the number of matching images
	 */
	public int countByImageUrlProductId(String imageUrl, long productId);

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	public void cacheResult(Image image);

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	public void cacheResult(java.util.List<Image> images);

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param id the primary key for the new image
	 * @return the new image
	 */
	public Image create(long id);

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image remove(long id) throws NoSuchImageException;

	public Image updateImpl(Image image);

	/**
	 * Returns the image with the primary key or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param id the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image findByPrimaryKey(long id) throws NoSuchImageException;

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	public Image fetchByPrimaryKey(long id);

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 */
	public java.util.List<Image> findAll();

	/**
	 * Returns a range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of images
	 */
	public java.util.List<Image> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of images
	 */
	public java.util.List<Image> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator);

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of images
	 */
	public java.util.List<Image> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Image>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the images from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}