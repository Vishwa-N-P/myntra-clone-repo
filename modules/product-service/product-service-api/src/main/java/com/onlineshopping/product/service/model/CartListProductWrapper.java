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
 * This class is a wrapper for {@link CartListProduct}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CartListProduct
 * @generated
 */
public class CartListProductWrapper
	implements CartListProduct, ModelWrapper<CartListProduct> {

	public CartListProductWrapper(CartListProduct cartListProduct) {
		_cartListProduct = cartListProduct;
	}

	@Override
	public Class<?> getModelClass() {
		return CartListProduct.class;
	}

	@Override
	public String getModelClassName() {
		return CartListProduct.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("cartListId", getCartListId());
		attributes.put("productId", getProductId());
		attributes.put("size", getSize());
		attributes.put("quantity", getQuantity());
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

		Long cartListId = (Long)attributes.get("cartListId");

		if (cartListId != null) {
			setCartListId(cartListId);
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
		return new CartListProductWrapper(
			(CartListProduct)_cartListProduct.clone());
	}

	@Override
	public int compareTo(CartListProduct cartListProduct) {
		return _cartListProduct.compareTo(cartListProduct);
	}

	/**
	 * Returns the cart list ID of this cart list product.
	 *
	 * @return the cart list ID of this cart list product
	 */
	@Override
	public long getCartListId() {
		return _cartListProduct.getCartListId();
	}

	/**
	 * Returns the create date of this cart list product.
	 *
	 * @return the create date of this cart list product
	 */
	@Override
	public Date getCreateDate() {
		return _cartListProduct.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cartListProduct.getExpandoBridge();
	}

	/**
	 * Returns the ID of this cart list product.
	 *
	 * @return the ID of this cart list product
	 */
	@Override
	public long getId() {
		return _cartListProduct.getId();
	}

	/**
	 * Returns the modified date of this cart list product.
	 *
	 * @return the modified date of this cart list product
	 */
	@Override
	public Date getModifiedDate() {
		return _cartListProduct.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cart list product.
	 *
	 * @return the primary key of this cart list product
	 */
	@Override
	public long getPrimaryKey() {
		return _cartListProduct.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cartListProduct.getPrimaryKeyObj();
	}

	/**
	 * Returns the product ID of this cart list product.
	 *
	 * @return the product ID of this cart list product
	 */
	@Override
	public long getProductId() {
		return _cartListProduct.getProductId();
	}

	/**
	 * Returns the quantity of this cart list product.
	 *
	 * @return the quantity of this cart list product
	 */
	@Override
	public int getQuantity() {
		return _cartListProduct.getQuantity();
	}

	/**
	 * Returns the size of this cart list product.
	 *
	 * @return the size of this cart list product
	 */
	@Override
	public String getSize() {
		return _cartListProduct.getSize();
	}

	@Override
	public int hashCode() {
		return _cartListProduct.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cartListProduct.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cartListProduct.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cartListProduct.isNew();
	}

	@Override
	public void persist() {
		_cartListProduct.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cartListProduct.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cart list ID of this cart list product.
	 *
	 * @param cartListId the cart list ID of this cart list product
	 */
	@Override
	public void setCartListId(long cartListId) {
		_cartListProduct.setCartListId(cartListId);
	}

	/**
	 * Sets the create date of this cart list product.
	 *
	 * @param createDate the create date of this cart list product
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_cartListProduct.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_cartListProduct.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cartListProduct.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cartListProduct.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this cart list product.
	 *
	 * @param id the ID of this cart list product
	 */
	@Override
	public void setId(long id) {
		_cartListProduct.setId(id);
	}

	/**
	 * Sets the modified date of this cart list product.
	 *
	 * @param modifiedDate the modified date of this cart list product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cartListProduct.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_cartListProduct.setNew(n);
	}

	/**
	 * Sets the primary key of this cart list product.
	 *
	 * @param primaryKey the primary key of this cart list product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cartListProduct.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cartListProduct.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the product ID of this cart list product.
	 *
	 * @param productId the product ID of this cart list product
	 */
	@Override
	public void setProductId(long productId) {
		_cartListProduct.setProductId(productId);
	}

	/**
	 * Sets the quantity of this cart list product.
	 *
	 * @param quantity the quantity of this cart list product
	 */
	@Override
	public void setQuantity(int quantity) {
		_cartListProduct.setQuantity(quantity);
	}

	/**
	 * Sets the size of this cart list product.
	 *
	 * @param size the size of this cart list product
	 */
	@Override
	public void setSize(String size) {
		_cartListProduct.setSize(size);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CartListProduct>
		toCacheModel() {

		return _cartListProduct.toCacheModel();
	}

	@Override
	public CartListProduct toEscapedModel() {
		return new CartListProductWrapper(_cartListProduct.toEscapedModel());
	}

	@Override
	public String toString() {
		return _cartListProduct.toString();
	}

	@Override
	public CartListProduct toUnescapedModel() {
		return new CartListProductWrapper(_cartListProduct.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _cartListProduct.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CartListProductWrapper)) {
			return false;
		}

		CartListProductWrapper cartListProductWrapper =
			(CartListProductWrapper)object;

		if (Objects.equals(
				_cartListProduct, cartListProductWrapper._cartListProduct)) {

			return true;
		}

		return false;
	}

	@Override
	public CartListProduct getWrappedModel() {
		return _cartListProduct;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cartListProduct.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cartListProduct.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cartListProduct.resetOriginalValues();
	}

	private final CartListProduct _cartListProduct;

}