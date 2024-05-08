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

package com.onlineshopping.product.service.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.onlineshopping.product.service.model.WishlistProduct;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for WishlistProduct. This utility wraps
 * <code>com.onlineshopping.product.service.service.impl.WishlistProductLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see WishlistProductLocalService
 * @generated
 */
public class WishlistProductLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.onlineshopping.product.service.service.impl.WishlistProductLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static WishlistProduct addWishlistProduct(
		long wishlistId, long productId) {

		return getService().addWishlistProduct(wishlistId, productId);
	}

	/**
	 * Adds the wishlist product to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlistProduct the wishlist product
	 * @return the wishlist product that was added
	 */
	public static WishlistProduct addWishlistProduct(
		WishlistProduct wishlistProduct) {

		return getService().addWishlistProduct(wishlistProduct);
	}

	/**
	 * Creates a new wishlist product with the primary key. Does not add the wishlist product to the database.
	 *
	 * @param id the primary key for the new wishlist product
	 * @return the new wishlist product
	 */
	public static WishlistProduct createWishlistProduct(long id) {
		return getService().createWishlistProduct(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteUserWishlistProduct(
		long wishlistId, long productId) {

		getService().deleteUserWishlistProduct(wishlistId, productId);
	}

	/**
	 * Deletes the wishlist product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product that was removed
	 * @throws PortalException if a wishlist product with the primary key could not be found
	 */
	public static WishlistProduct deleteWishlistProduct(long id)
		throws PortalException {

		return getService().deleteWishlistProduct(id);
	}

	/**
	 * Deletes the wishlist product from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlistProduct the wishlist product
	 * @return the wishlist product that was removed
	 */
	public static WishlistProduct deleteWishlistProduct(
		WishlistProduct wishlistProduct) {

		return getService().deleteWishlistProduct(wishlistProduct);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static WishlistProduct fetchWishlistProduct(long id) {
		return getService().fetchWishlistProduct(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static WishlistProduct getProductByWishlistIdProductId(
		long wishlistId, long productId) {

		return getService().getProductByWishlistIdProductId(
			wishlistId, productId);
	}

	public static List<Long> getUserWishlistProducts(long wishlistId) {
		return getService().getUserWishlistProducts(wishlistId);
	}

	/**
	 * Returns the wishlist product with the primary key.
	 *
	 * @param id the primary key of the wishlist product
	 * @return the wishlist product
	 * @throws PortalException if a wishlist product with the primary key could not be found
	 */
	public static WishlistProduct getWishlistProduct(long id)
		throws PortalException {

		return getService().getWishlistProduct(id);
	}

	/**
	 * Returns a range of all the wishlist products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of wishlist products
	 * @param end the upper bound of the range of wishlist products (not inclusive)
	 * @return the range of wishlist products
	 */
	public static List<WishlistProduct> getWishlistProducts(
		int start, int end) {

		return getService().getWishlistProducts(start, end);
	}

	/**
	 * Returns the number of wishlist products.
	 *
	 * @return the number of wishlist products
	 */
	public static int getWishlistProductsCount() {
		return getService().getWishlistProductsCount();
	}

	/**
	 * Updates the wishlist product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WishlistProductLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param wishlistProduct the wishlist product
	 * @return the wishlist product that was updated
	 */
	public static WishlistProduct updateWishlistProduct(
		WishlistProduct wishlistProduct) {

		return getService().updateWishlistProduct(wishlistProduct);
	}

	public static WishlistProductLocalService getService() {
		return _service;
	}

	private static volatile WishlistProductLocalService _service;

}