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
 * This class is a wrapper for {@link ProductOrder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductOrder
 * @generated
 */
public class ProductOrderWrapper
	implements ModelWrapper<ProductOrder>, ProductOrder {

	public ProductOrderWrapper(ProductOrder productOrder) {
		_productOrder = productOrder;
	}

	@Override
	public Class<?> getModelClass() {
		return ProductOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ProductOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("productId", getProductId());
		attributes.put("size", getSize());
		attributes.put("quantity", getQuantity());
		attributes.put("cost", getCost());
		attributes.put("userId", getUserId());
		attributes.put("addressId", getAddressId());
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

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String size = (String)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Long cost = (Long)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
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
		return new ProductOrderWrapper((ProductOrder)_productOrder.clone());
	}

	@Override
	public int compareTo(ProductOrder productOrder) {
		return _productOrder.compareTo(productOrder);
	}

	/**
	 * Returns the address ID of this product order.
	 *
	 * @return the address ID of this product order
	 */
	@Override
	public long getAddressId() {
		return _productOrder.getAddressId();
	}

	/**
	 * Returns the cost of this product order.
	 *
	 * @return the cost of this product order
	 */
	@Override
	public long getCost() {
		return _productOrder.getCost();
	}

	/**
	 * Returns the create date of this product order.
	 *
	 * @return the create date of this product order
	 */
	@Override
	public Date getCreateDate() {
		return _productOrder.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _productOrder.getExpandoBridge();
	}

	/**
	 * Returns the ID of this product order.
	 *
	 * @return the ID of this product order
	 */
	@Override
	public long getId() {
		return _productOrder.getId();
	}

	/**
	 * Returns the modified date of this product order.
	 *
	 * @return the modified date of this product order
	 */
	@Override
	public Date getModifiedDate() {
		return _productOrder.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product order.
	 *
	 * @return the primary key of this product order
	 */
	@Override
	public long getPrimaryKey() {
		return _productOrder.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productOrder.getPrimaryKeyObj();
	}

	/**
	 * Returns the product ID of this product order.
	 *
	 * @return the product ID of this product order
	 */
	@Override
	public long getProductId() {
		return _productOrder.getProductId();
	}

	/**
	 * Returns the quantity of this product order.
	 *
	 * @return the quantity of this product order
	 */
	@Override
	public int getQuantity() {
		return _productOrder.getQuantity();
	}

	/**
	 * Returns the size of this product order.
	 *
	 * @return the size of this product order
	 */
	@Override
	public String getSize() {
		return _productOrder.getSize();
	}

	/**
	 * Returns the user ID of this product order.
	 *
	 * @return the user ID of this product order
	 */
	@Override
	public long getUserId() {
		return _productOrder.getUserId();
	}

	/**
	 * Returns the user uuid of this product order.
	 *
	 * @return the user uuid of this product order
	 */
	@Override
	public String getUserUuid() {
		return _productOrder.getUserUuid();
	}

	/**
	 * Returns the uuid of this product order.
	 *
	 * @return the uuid of this product order
	 */
	@Override
	public String getUuid() {
		return _productOrder.getUuid();
	}

	@Override
	public int hashCode() {
		return _productOrder.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _productOrder.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _productOrder.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _productOrder.isNew();
	}

	@Override
	public void persist() {
		_productOrder.persist();
	}

	/**
	 * Sets the address ID of this product order.
	 *
	 * @param addressId the address ID of this product order
	 */
	@Override
	public void setAddressId(long addressId) {
		_productOrder.setAddressId(addressId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_productOrder.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cost of this product order.
	 *
	 * @param cost the cost of this product order
	 */
	@Override
	public void setCost(long cost) {
		_productOrder.setCost(cost);
	}

	/**
	 * Sets the create date of this product order.
	 *
	 * @param createDate the create date of this product order
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_productOrder.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_productOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_productOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_productOrder.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this product order.
	 *
	 * @param id the ID of this product order
	 */
	@Override
	public void setId(long id) {
		_productOrder.setId(id);
	}

	/**
	 * Sets the modified date of this product order.
	 *
	 * @param modifiedDate the modified date of this product order
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_productOrder.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_productOrder.setNew(n);
	}

	/**
	 * Sets the primary key of this product order.
	 *
	 * @param primaryKey the primary key of this product order
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_productOrder.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_productOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the product ID of this product order.
	 *
	 * @param productId the product ID of this product order
	 */
	@Override
	public void setProductId(long productId) {
		_productOrder.setProductId(productId);
	}

	/**
	 * Sets the quantity of this product order.
	 *
	 * @param quantity the quantity of this product order
	 */
	@Override
	public void setQuantity(int quantity) {
		_productOrder.setQuantity(quantity);
	}

	/**
	 * Sets the size of this product order.
	 *
	 * @param size the size of this product order
	 */
	@Override
	public void setSize(String size) {
		_productOrder.setSize(size);
	}

	/**
	 * Sets the user ID of this product order.
	 *
	 * @param userId the user ID of this product order
	 */
	@Override
	public void setUserId(long userId) {
		_productOrder.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this product order.
	 *
	 * @param userUuid the user uuid of this product order
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_productOrder.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product order.
	 *
	 * @param uuid the uuid of this product order
	 */
	@Override
	public void setUuid(String uuid) {
		_productOrder.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProductOrder>
		toCacheModel() {

		return _productOrder.toCacheModel();
	}

	@Override
	public ProductOrder toEscapedModel() {
		return new ProductOrderWrapper(_productOrder.toEscapedModel());
	}

	@Override
	public String toString() {
		return _productOrder.toString();
	}

	@Override
	public ProductOrder toUnescapedModel() {
		return new ProductOrderWrapper(_productOrder.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _productOrder.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductOrderWrapper)) {
			return false;
		}

		ProductOrderWrapper productOrderWrapper = (ProductOrderWrapper)object;

		if (Objects.equals(_productOrder, productOrderWrapper._productOrder)) {
			return true;
		}

		return false;
	}

	@Override
	public ProductOrder getWrappedModel() {
		return _productOrder;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _productOrder.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _productOrder.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_productOrder.resetOriginalValues();
	}

	private final ProductOrder _productOrder;

}