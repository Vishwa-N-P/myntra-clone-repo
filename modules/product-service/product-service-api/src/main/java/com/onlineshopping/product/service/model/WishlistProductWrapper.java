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

package com.onlineshopping.product.service.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WishlistProduct}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishlistProduct
 * @generated
 */
public class WishlistProductWrapper
	implements ModelWrapper<WishlistProduct>, WishlistProduct {

	public WishlistProductWrapper(WishlistProduct wishlistProduct) {
		_wishlistProduct = wishlistProduct;
	}

	@Override
	public Class<?> getModelClass() {
		return WishlistProduct.class;
	}

	@Override
	public String getModelClassName() {
		return WishlistProduct.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("wishlistId", getWishlistId());
		attributes.put("productId", getProductId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long wishlistId = (Long)attributes.get("wishlistId");

		if (wishlistId != null) {
			setWishlistId(wishlistId);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new WishlistProductWrapper(
			(WishlistProduct)_wishlistProduct.clone());
	}

	@Override
	public int compareTo(WishlistProduct wishlistProduct) {
		return _wishlistProduct.compareTo(wishlistProduct);
	}

	/**
	 * Returns the create date of this wishlist product.
	 *
	 * @return the create date of this wishlist product
	 */
	@Override
	public Date getCreateDate() {
		return _wishlistProduct.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wishlistProduct.getExpandoBridge();
	}

	/**
	 * Returns the ID of this wishlist product.
	 *
	 * @return the ID of this wishlist product
	 */
	@Override
	public long getId() {
		return _wishlistProduct.getId();
	}

	/**
	 * Returns the modified date of this wishlist product.
	 *
	 * @return the modified date of this wishlist product
	 */
	@Override
	public Date getModifiedDate() {
		return _wishlistProduct.getModifiedDate();
	}

	/**
	 * Returns the primary key of this wishlist product.
	 *
	 * @return the primary key of this wishlist product
	 */
	@Override
	public long getPrimaryKey() {
		return _wishlistProduct.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wishlistProduct.getPrimaryKeyObj();
	}

	/**
	 * Returns the product ID of this wishlist product.
	 *
	 * @return the product ID of this wishlist product
	 */
	@Override
	public long getProductId() {
		return _wishlistProduct.getProductId();
	}

	/**
	 * Returns the wishlist ID of this wishlist product.
	 *
	 * @return the wishlist ID of this wishlist product
	 */
	@Override
	public long getWishlistId() {
		return _wishlistProduct.getWishlistId();
	}

	@Override
	public int hashCode() {
		return _wishlistProduct.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _wishlistProduct.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wishlistProduct.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wishlistProduct.isNew();
	}

	@Override
	public void persist() {
		_wishlistProduct.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wishlistProduct.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this wishlist product.
	 *
	 * @param createDate the create date of this wishlist product
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_wishlistProduct.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_wishlistProduct.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wishlistProduct.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wishlistProduct.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this wishlist product.
	 *
	 * @param id the ID of this wishlist product
	 */
	@Override
	public void setId(long id) {
		_wishlistProduct.setId(id);
	}

	/**
	 * Sets the modified date of this wishlist product.
	 *
	 * @param modifiedDate the modified date of this wishlist product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wishlistProduct.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wishlistProduct.setNew(n);
	}

	/**
	 * Sets the primary key of this wishlist product.
	 *
	 * @param primaryKey the primary key of this wishlist product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wishlistProduct.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wishlistProduct.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the product ID of this wishlist product.
	 *
	 * @param productId the product ID of this wishlist product
	 */
	@Override
	public void setProductId(long productId) {
		_wishlistProduct.setProductId(productId);
	}

	/**
	 * Sets the wishlist ID of this wishlist product.
	 *
	 * @param wishlistId the wishlist ID of this wishlist product
	 */
	@Override
	public void setWishlistId(long wishlistId) {
		_wishlistProduct.setWishlistId(wishlistId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WishlistProduct>
		toCacheModel() {

		return _wishlistProduct.toCacheModel();
	}

	@Override
	public WishlistProduct toEscapedModel() {
		return new WishlistProductWrapper(_wishlistProduct.toEscapedModel());
	}

	@Override
	public String toString() {
		return _wishlistProduct.toString();
	}

	@Override
	public WishlistProduct toUnescapedModel() {
		return new WishlistProductWrapper(_wishlistProduct.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _wishlistProduct.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WishlistProductWrapper)) {
			return false;
		}

		WishlistProductWrapper wishlistProductWrapper =
			(WishlistProductWrapper)object;

		if (Objects.equals(
				_wishlistProduct, wishlistProductWrapper._wishlistProduct)) {

			return true;
		}

		return false;
	}

	@Override
	public WishlistProduct getWrappedModel() {
		return _wishlistProduct;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wishlistProduct.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wishlistProduct.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wishlistProduct.resetOriginalValues();
	}

	private final WishlistProduct _wishlistProduct;

}