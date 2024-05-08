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
 * This class is a wrapper for {@link Wishlist}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Wishlist
 * @generated
 */
public class WishlistWrapper implements ModelWrapper<Wishlist>, Wishlist {

	public WishlistWrapper(Wishlist wishlist) {
		_wishlist = wishlist;
	}

	@Override
	public Class<?> getModelClass() {
		return Wishlist.class;
	}

	@Override
	public String getModelClassName() {
		return Wishlist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
		return new WishlistWrapper((Wishlist)_wishlist.clone());
	}

	@Override
	public int compareTo(Wishlist wishlist) {
		return _wishlist.compareTo(wishlist);
	}

	/**
	 * Returns the create date of this wishlist.
	 *
	 * @return the create date of this wishlist
	 */
	@Override
	public Date getCreateDate() {
		return _wishlist.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wishlist.getExpandoBridge();
	}

	/**
	 * Returns the ID of this wishlist.
	 *
	 * @return the ID of this wishlist
	 */
	@Override
	public long getId() {
		return _wishlist.getId();
	}

	/**
	 * Returns the modified date of this wishlist.
	 *
	 * @return the modified date of this wishlist
	 */
	@Override
	public Date getModifiedDate() {
		return _wishlist.getModifiedDate();
	}

	/**
	 * Returns the primary key of this wishlist.
	 *
	 * @return the primary key of this wishlist
	 */
	@Override
	public long getPrimaryKey() {
		return _wishlist.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wishlist.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this wishlist.
	 *
	 * @return the user ID of this wishlist
	 */
	@Override
	public long getUserId() {
		return _wishlist.getUserId();
	}

	/**
	 * Returns the user uuid of this wishlist.
	 *
	 * @return the user uuid of this wishlist
	 */
	@Override
	public String getUserUuid() {
		return _wishlist.getUserUuid();
	}

	/**
	 * Returns the uuid of this wishlist.
	 *
	 * @return the uuid of this wishlist
	 */
	@Override
	public String getUuid() {
		return _wishlist.getUuid();
	}

	@Override
	public int hashCode() {
		return _wishlist.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _wishlist.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _wishlist.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _wishlist.isNew();
	}

	@Override
	public void persist() {
		_wishlist.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wishlist.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this wishlist.
	 *
	 * @param createDate the create date of this wishlist
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_wishlist.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_wishlist.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wishlist.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wishlist.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this wishlist.
	 *
	 * @param id the ID of this wishlist
	 */
	@Override
	public void setId(long id) {
		_wishlist.setId(id);
	}

	/**
	 * Sets the modified date of this wishlist.
	 *
	 * @param modifiedDate the modified date of this wishlist
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wishlist.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wishlist.setNew(n);
	}

	/**
	 * Sets the primary key of this wishlist.
	 *
	 * @param primaryKey the primary key of this wishlist
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wishlist.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wishlist.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this wishlist.
	 *
	 * @param userId the user ID of this wishlist
	 */
	@Override
	public void setUserId(long userId) {
		_wishlist.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this wishlist.
	 *
	 * @param userUuid the user uuid of this wishlist
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_wishlist.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this wishlist.
	 *
	 * @param uuid the uuid of this wishlist
	 */
	@Override
	public void setUuid(String uuid) {
		_wishlist.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Wishlist> toCacheModel() {
		return _wishlist.toCacheModel();
	}

	@Override
	public Wishlist toEscapedModel() {
		return new WishlistWrapper(_wishlist.toEscapedModel());
	}

	@Override
	public String toString() {
		return _wishlist.toString();
	}

	@Override
	public Wishlist toUnescapedModel() {
		return new WishlistWrapper(_wishlist.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _wishlist.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WishlistWrapper)) {
			return false;
		}

		WishlistWrapper wishlistWrapper = (WishlistWrapper)object;

		if (Objects.equals(_wishlist, wishlistWrapper._wishlist)) {
			return true;
		}

		return false;
	}

	@Override
	public Wishlist getWrappedModel() {
		return _wishlist;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wishlist.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wishlist.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wishlist.resetOriginalValues();
	}

	private final Wishlist _wishlist;

}