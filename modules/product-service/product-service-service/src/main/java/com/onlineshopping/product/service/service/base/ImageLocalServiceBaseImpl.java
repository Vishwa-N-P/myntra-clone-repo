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

package com.onlineshopping.product.service.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.onlineshopping.product.service.model.Image;
import com.onlineshopping.product.service.service.ImageLocalService;
import com.onlineshopping.product.service.service.ImageLocalServiceUtil;
import com.onlineshopping.product.service.service.persistence.BrandPersistence;
import com.onlineshopping.product.service.service.persistence.CartListPersistence;
import com.onlineshopping.product.service.service.persistence.CartListProductPersistence;
import com.onlineshopping.product.service.service.persistence.HighlightsPersistence;
import com.onlineshopping.product.service.service.persistence.ImagePersistence;
import com.onlineshopping.product.service.service.persistence.ProductCategoryPersistence;
import com.onlineshopping.product.service.service.persistence.ProductOrderPersistence;
import com.onlineshopping.product.service.service.persistence.ProductPersistence;
import com.onlineshopping.product.service.service.persistence.WishlistPersistence;
import com.onlineshopping.product.service.service.persistence.WishlistProductPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the image local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.onlineshopping.product.service.service.impl.ImageLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.onlineshopping.product.service.service.impl.ImageLocalServiceImpl
 * @generated
 */
public abstract class ImageLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, ImageLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ImageLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ImageLocalServiceUtil</code>.
	 */

	/**
	 * Adds the image to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param image the image
	 * @return the image that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Image addImage(Image image) {
		image.setNew(true);

		return imagePersistence.update(image);
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param id the primary key for the new image
	 * @return the new image
	 */
	@Override
	@Transactional(enabled = false)
	public Image createImage(long id) {
		return imagePersistence.create(id);
	}

	/**
	 * Deletes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the image
	 * @return the image that was removed
	 * @throws PortalException if a image with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Image deleteImage(long id) throws PortalException {
		return imagePersistence.remove(id);
	}

	/**
	 * Deletes the image from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param image the image
	 * @return the image that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Image deleteImage(Image image) {
		return imagePersistence.remove(image);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Image.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return imagePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ImageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return imagePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ImageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return imagePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return imagePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return imagePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Image fetchImage(long id) {
		return imagePersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the image with the primary key.
	 *
	 * @param id the primary key of the image
	 * @return the image
	 * @throws PortalException if a image with the primary key could not be found
	 */
	@Override
	public Image getImage(long id) throws PortalException {
		return imagePersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(imageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Image.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(imageLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Image.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(imageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Image.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return imageLocalService.deleteImage((Image)persistedModel);
	}

	public BasePersistence<Image> getBasePersistence() {
		return imagePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return imagePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of images
	 */
	@Override
	public List<Image> getImages(int start, int end) {
		return imagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	@Override
	public int getImagesCount() {
		return imagePersistence.countAll();
	}

	/**
	 * Updates the image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param image the image
	 * @return the image that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Image updateImage(Image image) {
		return imagePersistence.update(image);
	}

	/**
	 * Returns the brand local service.
	 *
	 * @return the brand local service
	 */
	public com.onlineshopping.product.service.service.BrandLocalService
		getBrandLocalService() {

		return brandLocalService;
	}

	/**
	 * Sets the brand local service.
	 *
	 * @param brandLocalService the brand local service
	 */
	public void setBrandLocalService(
		com.onlineshopping.product.service.service.BrandLocalService
			brandLocalService) {

		this.brandLocalService = brandLocalService;
	}

	/**
	 * Returns the brand persistence.
	 *
	 * @return the brand persistence
	 */
	public BrandPersistence getBrandPersistence() {
		return brandPersistence;
	}

	/**
	 * Sets the brand persistence.
	 *
	 * @param brandPersistence the brand persistence
	 */
	public void setBrandPersistence(BrandPersistence brandPersistence) {
		this.brandPersistence = brandPersistence;
	}

	/**
	 * Returns the cart list local service.
	 *
	 * @return the cart list local service
	 */
	public com.onlineshopping.product.service.service.CartListLocalService
		getCartListLocalService() {

		return cartListLocalService;
	}

	/**
	 * Sets the cart list local service.
	 *
	 * @param cartListLocalService the cart list local service
	 */
	public void setCartListLocalService(
		com.onlineshopping.product.service.service.CartListLocalService
			cartListLocalService) {

		this.cartListLocalService = cartListLocalService;
	}

	/**
	 * Returns the cart list persistence.
	 *
	 * @return the cart list persistence
	 */
	public CartListPersistence getCartListPersistence() {
		return cartListPersistence;
	}

	/**
	 * Sets the cart list persistence.
	 *
	 * @param cartListPersistence the cart list persistence
	 */
	public void setCartListPersistence(
		CartListPersistence cartListPersistence) {

		this.cartListPersistence = cartListPersistence;
	}

	/**
	 * Returns the cart list product local service.
	 *
	 * @return the cart list product local service
	 */
	public
		com.onlineshopping.product.service.service.CartListProductLocalService
			getCartListProductLocalService() {

		return cartListProductLocalService;
	}

	/**
	 * Sets the cart list product local service.
	 *
	 * @param cartListProductLocalService the cart list product local service
	 */
	public void setCartListProductLocalService(
		com.onlineshopping.product.service.service.CartListProductLocalService
			cartListProductLocalService) {

		this.cartListProductLocalService = cartListProductLocalService;
	}

	/**
	 * Returns the cart list product persistence.
	 *
	 * @return the cart list product persistence
	 */
	public CartListProductPersistence getCartListProductPersistence() {
		return cartListProductPersistence;
	}

	/**
	 * Sets the cart list product persistence.
	 *
	 * @param cartListProductPersistence the cart list product persistence
	 */
	public void setCartListProductPersistence(
		CartListProductPersistence cartListProductPersistence) {

		this.cartListProductPersistence = cartListProductPersistence;
	}

	/**
	 * Returns the highlights local service.
	 *
	 * @return the highlights local service
	 */
	public com.onlineshopping.product.service.service.HighlightsLocalService
		getHighlightsLocalService() {

		return highlightsLocalService;
	}

	/**
	 * Sets the highlights local service.
	 *
	 * @param highlightsLocalService the highlights local service
	 */
	public void setHighlightsLocalService(
		com.onlineshopping.product.service.service.HighlightsLocalService
			highlightsLocalService) {

		this.highlightsLocalService = highlightsLocalService;
	}

	/**
	 * Returns the highlights persistence.
	 *
	 * @return the highlights persistence
	 */
	public HighlightsPersistence getHighlightsPersistence() {
		return highlightsPersistence;
	}

	/**
	 * Sets the highlights persistence.
	 *
	 * @param highlightsPersistence the highlights persistence
	 */
	public void setHighlightsPersistence(
		HighlightsPersistence highlightsPersistence) {

		this.highlightsPersistence = highlightsPersistence;
	}

	/**
	 * Returns the image local service.
	 *
	 * @return the image local service
	 */
	public ImageLocalService getImageLocalService() {
		return imageLocalService;
	}

	/**
	 * Sets the image local service.
	 *
	 * @param imageLocalService the image local service
	 */
	public void setImageLocalService(ImageLocalService imageLocalService) {
		this.imageLocalService = imageLocalService;
	}

	/**
	 * Returns the image persistence.
	 *
	 * @return the image persistence
	 */
	public ImagePersistence getImagePersistence() {
		return imagePersistence;
	}

	/**
	 * Sets the image persistence.
	 *
	 * @param imagePersistence the image persistence
	 */
	public void setImagePersistence(ImagePersistence imagePersistence) {
		this.imagePersistence = imagePersistence;
	}

	/**
	 * Returns the product local service.
	 *
	 * @return the product local service
	 */
	public com.onlineshopping.product.service.service.ProductLocalService
		getProductLocalService() {

		return productLocalService;
	}

	/**
	 * Sets the product local service.
	 *
	 * @param productLocalService the product local service
	 */
	public void setProductLocalService(
		com.onlineshopping.product.service.service.ProductLocalService
			productLocalService) {

		this.productLocalService = productLocalService;
	}

	/**
	 * Returns the product persistence.
	 *
	 * @return the product persistence
	 */
	public ProductPersistence getProductPersistence() {
		return productPersistence;
	}

	/**
	 * Sets the product persistence.
	 *
	 * @param productPersistence the product persistence
	 */
	public void setProductPersistence(ProductPersistence productPersistence) {
		this.productPersistence = productPersistence;
	}

	/**
	 * Returns the product category local service.
	 *
	 * @return the product category local service
	 */
	public
		com.onlineshopping.product.service.service.ProductCategoryLocalService
			getProductCategoryLocalService() {

		return productCategoryLocalService;
	}

	/**
	 * Sets the product category local service.
	 *
	 * @param productCategoryLocalService the product category local service
	 */
	public void setProductCategoryLocalService(
		com.onlineshopping.product.service.service.ProductCategoryLocalService
			productCategoryLocalService) {

		this.productCategoryLocalService = productCategoryLocalService;
	}

	/**
	 * Returns the product category persistence.
	 *
	 * @return the product category persistence
	 */
	public ProductCategoryPersistence getProductCategoryPersistence() {
		return productCategoryPersistence;
	}

	/**
	 * Sets the product category persistence.
	 *
	 * @param productCategoryPersistence the product category persistence
	 */
	public void setProductCategoryPersistence(
		ProductCategoryPersistence productCategoryPersistence) {

		this.productCategoryPersistence = productCategoryPersistence;
	}

	/**
	 * Returns the product order local service.
	 *
	 * @return the product order local service
	 */
	public com.onlineshopping.product.service.service.ProductOrderLocalService
		getProductOrderLocalService() {

		return productOrderLocalService;
	}

	/**
	 * Sets the product order local service.
	 *
	 * @param productOrderLocalService the product order local service
	 */
	public void setProductOrderLocalService(
		com.onlineshopping.product.service.service.ProductOrderLocalService
			productOrderLocalService) {

		this.productOrderLocalService = productOrderLocalService;
	}

	/**
	 * Returns the product order persistence.
	 *
	 * @return the product order persistence
	 */
	public ProductOrderPersistence getProductOrderPersistence() {
		return productOrderPersistence;
	}

	/**
	 * Sets the product order persistence.
	 *
	 * @param productOrderPersistence the product order persistence
	 */
	public void setProductOrderPersistence(
		ProductOrderPersistence productOrderPersistence) {

		this.productOrderPersistence = productOrderPersistence;
	}

	/**
	 * Returns the wishlist local service.
	 *
	 * @return the wishlist local service
	 */
	public com.onlineshopping.product.service.service.WishlistLocalService
		getWishlistLocalService() {

		return wishlistLocalService;
	}

	/**
	 * Sets the wishlist local service.
	 *
	 * @param wishlistLocalService the wishlist local service
	 */
	public void setWishlistLocalService(
		com.onlineshopping.product.service.service.WishlistLocalService
			wishlistLocalService) {

		this.wishlistLocalService = wishlistLocalService;
	}

	/**
	 * Returns the wishlist persistence.
	 *
	 * @return the wishlist persistence
	 */
	public WishlistPersistence getWishlistPersistence() {
		return wishlistPersistence;
	}

	/**
	 * Sets the wishlist persistence.
	 *
	 * @param wishlistPersistence the wishlist persistence
	 */
	public void setWishlistPersistence(
		WishlistPersistence wishlistPersistence) {

		this.wishlistPersistence = wishlistPersistence;
	}

	/**
	 * Returns the wishlist product local service.
	 *
	 * @return the wishlist product local service
	 */
	public
		com.onlineshopping.product.service.service.WishlistProductLocalService
			getWishlistProductLocalService() {

		return wishlistProductLocalService;
	}

	/**
	 * Sets the wishlist product local service.
	 *
	 * @param wishlistProductLocalService the wishlist product local service
	 */
	public void setWishlistProductLocalService(
		com.onlineshopping.product.service.service.WishlistProductLocalService
			wishlistProductLocalService) {

		this.wishlistProductLocalService = wishlistProductLocalService;
	}

	/**
	 * Returns the wishlist product persistence.
	 *
	 * @return the wishlist product persistence
	 */
	public WishlistProductPersistence getWishlistProductPersistence() {
		return wishlistProductPersistence;
	}

	/**
	 * Sets the wishlist product persistence.
	 *
	 * @param wishlistProductPersistence the wishlist product persistence
	 */
	public void setWishlistProductPersistence(
		WishlistProductPersistence wishlistProductPersistence) {

		this.wishlistProductPersistence = wishlistProductPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.onlineshopping.product.service.model.Image",
			imageLocalService);

		_setLocalServiceUtilService(imageLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.onlineshopping.product.service.model.Image");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ImageLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Image.class;
	}

	protected String getModelClassName() {
		return Image.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = imagePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ImageLocalService imageLocalService) {

		try {
			Field field = ImageLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, imageLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = com.onlineshopping.product.service.service.BrandLocalService.class
	)
	protected com.onlineshopping.product.service.service.BrandLocalService
		brandLocalService;

	@BeanReference(type = BrandPersistence.class)
	protected BrandPersistence brandPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.CartListLocalService.class
	)
	protected com.onlineshopping.product.service.service.CartListLocalService
		cartListLocalService;

	@BeanReference(type = CartListPersistence.class)
	protected CartListPersistence cartListPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.CartListProductLocalService.class
	)
	protected
		com.onlineshopping.product.service.service.CartListProductLocalService
			cartListProductLocalService;

	@BeanReference(type = CartListProductPersistence.class)
	protected CartListProductPersistence cartListProductPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.HighlightsLocalService.class
	)
	protected com.onlineshopping.product.service.service.HighlightsLocalService
		highlightsLocalService;

	@BeanReference(type = HighlightsPersistence.class)
	protected HighlightsPersistence highlightsPersistence;

	@BeanReference(type = ImageLocalService.class)
	protected ImageLocalService imageLocalService;

	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.ProductLocalService.class
	)
	protected com.onlineshopping.product.service.service.ProductLocalService
		productLocalService;

	@BeanReference(type = ProductPersistence.class)
	protected ProductPersistence productPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.ProductCategoryLocalService.class
	)
	protected
		com.onlineshopping.product.service.service.ProductCategoryLocalService
			productCategoryLocalService;

	@BeanReference(type = ProductCategoryPersistence.class)
	protected ProductCategoryPersistence productCategoryPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.ProductOrderLocalService.class
	)
	protected
		com.onlineshopping.product.service.service.ProductOrderLocalService
			productOrderLocalService;

	@BeanReference(type = ProductOrderPersistence.class)
	protected ProductOrderPersistence productOrderPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.WishlistLocalService.class
	)
	protected com.onlineshopping.product.service.service.WishlistLocalService
		wishlistLocalService;

	@BeanReference(type = WishlistPersistence.class)
	protected WishlistPersistence wishlistPersistence;

	@BeanReference(
		type = com.onlineshopping.product.service.service.WishlistProductLocalService.class
	)
	protected
		com.onlineshopping.product.service.service.WishlistProductLocalService
			wishlistProductLocalService;

	@BeanReference(type = WishlistProductPersistence.class)
	protected WishlistProductPersistence wishlistProductPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}