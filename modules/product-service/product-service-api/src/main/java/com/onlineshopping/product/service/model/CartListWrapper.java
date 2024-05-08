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
 * This class is a wrapper for {@link CartList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartList
 * @generated
 */
public class CartListWrapper implements CartList, ModelWrapper<CartList> {

	public CartListWrapper(CartList cartList) {
		_cartList = cartList;
	}

	@Override
	public Class<?> getModelClass() {
		return CartList.class;
	}

	@Override
	public String getModelClassName() {
		return CartList.class.getName();
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
		return new CartListWrapper((CartList)_cartList.clone());
	}

	@Override
	public int compareTo(CartList cartList) {
		return _cartList.compareTo(cartList);
	}

	/**
	 * Returns the create date of this cart list.
	 *
	 * @return the create date of this cart list
	 */
	@Override
	public Date getCreateDate() {
		return _cartList.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cartList.getExpandoBridge();
	}

	/**
	 * Returns the ID of this cart list.
	 *
	 * @return the ID of this cart list
	 */
	@Override
	public long getId() {
		return _cartList.getId();
	}

	/**
	 * Returns the modified date of this cart list.
	 *
	 * @return the modified date of this cart list
	 */
	@Override
	public Date getModifiedDate() {
		return _cartList.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cart list.
	 *
	 * @return the primary key of this cart list
	 */
	@Override
	public long getPrimaryKey() {
		return _cartList.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cartList.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this cart list.
	 *
	 * @return the user ID of this cart list
	 */
	@Override
	public long getUserId() {
		return _cartList.getUserId();
	}

	/**
	 * Returns the user uuid of this cart list.
	 *
	 * @return the user uuid of this cart list
	 */
	@Override
	public String getUserUuid() {
		return _cartList.getUserUuid();
	}

	/**
	 * Returns the uuid of this cart list.
	 *
	 * @return the uuid of this cart list
	 */
	@Override
	public String getUuid() {
		return _cartList.getUuid();
	}

	@Override
	public int hashCode() {
		return _cartList.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cartList.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cartList.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cartList.isNew();
	}

	@Override
	public void persist() {
		_cartList.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cartList.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this cart list.
	 *
	 * @param createDate the create date of this cart list
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_cartList.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_cartList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cartList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cartList.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this cart list.
	 *
	 * @param id the ID of this cart list
	 */
	@Override
	public void setId(long id) {
		_cartList.setId(id);
	}

	/**
	 * Sets the modified date of this cart list.
	 *
	 * @param modifiedDate the modified date of this cart list
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cartList.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_cartList.setNew(n);
	}

	/**
	 * Sets the primary key of this cart list.
	 *
	 * @param primaryKey the primary key of this cart list
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cartList.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cartList.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this cart list.
	 *
	 * @param userId the user ID of this cart list
	 */
	@Override
	public void setUserId(long userId) {
		_cartList.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this cart list.
	 *
	 * @param userUuid the user uuid of this cart list
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_cartList.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this cart list.
	 *
	 * @param uuid the uuid of this cart list
	 */
	@Override
	public void setUuid(String uuid) {
		_cartList.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CartList> toCacheModel() {
		return _cartList.toCacheModel();
	}

	@Override
	public CartList toEscapedModel() {
		return new CartListWrapper(_cartList.toEscapedModel());
	}

	@Override
	public String toString() {
		return _cartList.toString();
	}

	@Override
	public CartList toUnescapedModel() {
		return new CartListWrapper(_cartList.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _cartList.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CartListWrapper)) {
			return false;
		}

		CartListWrapper cartListWrapper = (CartListWrapper)object;

		if (Objects.equals(_cartList, cartListWrapper._cartList)) {
			return true;
		}

		return false;
	}

	@Override
	public CartList getWrappedModel() {
		return _cartList;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cartList.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cartList.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cartList.resetOriginalValues();
	}

	private final CartList _cartList;

}