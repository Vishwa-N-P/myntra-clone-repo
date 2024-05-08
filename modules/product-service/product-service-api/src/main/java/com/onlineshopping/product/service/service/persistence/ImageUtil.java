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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.onlineshopping.product.service.model.Image;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the image service. This utility wraps <code>com.onlineshopping.product.service.service.persistence.impl.ImagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImagePersistence
 * @generated
 */
public class ImageUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Image image) {
		getPersistence().clearCache(image);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Image> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Image> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Image> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Image> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Image update(Image image) {
		return getPersistence().update(image);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Image update(Image image, ServiceContext serviceContext) {
		return getPersistence().update(image, serviceContext);
	}

	/**
	 * Returns all the images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching images
	 */
	public static List<Image> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Image> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Image> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Image> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByUuid_First(
			String uuid, OrderByComparator<Image> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByUuid_First(
		String uuid, OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByUuid_Last(
			String uuid, OrderByComparator<Image> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByUuid_Last(
		String uuid, OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the images before and after the current image in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current image
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Image> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching images
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the images where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching images
	 */
	public static List<Image> findByProductId(long productId) {
		return getPersistence().findByProductId(productId);
	}

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
	public static List<Image> findByProductId(
		long productId, int start, int end) {

		return getPersistence().findByProductId(productId, start, end);
	}

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
	public static List<Image> findByProductId(
		long productId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findByProductId(
			productId, start, end, orderByComparator);
	}

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
	public static List<Image> findByProductId(
		long productId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProductId(
			productId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByProductId_First(
			long productId, OrderByComparator<Image> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByProductId_First(
			productId, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByProductId_First(
		long productId, OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByProductId_First(
			productId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByProductId_Last(
			long productId, OrderByComparator<Image> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByProductId_Last(
			productId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByProductId_Last(
		long productId, OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByProductId_Last(
			productId, orderByComparator);
	}

	/**
	 * Returns the images before and after the current image in the ordered set where productId = &#63;.
	 *
	 * @param id the primary key of the current image
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image[] findByProductId_PrevAndNext(
			long id, long productId, OrderByComparator<Image> orderByComparator)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByProductId_PrevAndNext(
			id, productId, orderByComparator);
	}

	/**
	 * Removes all the images where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 */
	public static void removeByProductId(long productId) {
		getPersistence().removeByProductId(productId);
	}

	/**
	 * Returns the number of images where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching images
	 */
	public static int countByProductId(long productId) {
		return getPersistence().countByProductId(productId);
	}

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByImageUrlProductId(String imageUrl, long productId)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByImageUrlProductId(imageUrl, productId);
	}

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByImageUrlProductId(
		String imageUrl, long productId) {

		return getPersistence().fetchByImageUrlProductId(imageUrl, productId);
	}

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByImageUrlProductId(
		String imageUrl, long productId, boolean useFinderCache) {

		return getPersistence().fetchByImageUrlProductId(
			imageUrl, productId, useFinderCache);
	}

	/**
	 * Removes the image where imageUrl = &#63; and productId = &#63; from the database.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the image that was removed
	 */
	public static Image removeByImageUrlProductId(
			String imageUrl, long productId)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().removeByImageUrlProductId(imageUrl, productId);
	}

	/**
	 * Returns the number of images where imageUrl = &#63; and productId = &#63;.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the number of matching images
	 */
	public static int countByImageUrlProductId(
		String imageUrl, long productId) {

		return getPersistence().countByImageUrlProductId(imageUrl, productId);
	}

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	public static void cacheResult(Image image) {
		getPersistence().cacheResult(image);
	}

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	public static void cacheResult(List<Image> images) {
		getPersistence().cacheResult(images);
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param id the primary key for the new image
	 * @return the new image
	 */
	public static Image create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image remove(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().remove(id);
	}

	public static Image updateImpl(Image image) {
		return getPersistence().updateImpl(image);
	}

	/**
	 * Returns the image with the primary key or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param id the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image findByPrimaryKey(long id)
		throws com.onlineshopping.product.service.exception.
			NoSuchImageException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	public static Image fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 */
	public static List<Image> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Image> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the images from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ImagePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ImagePersistence _persistence;

}