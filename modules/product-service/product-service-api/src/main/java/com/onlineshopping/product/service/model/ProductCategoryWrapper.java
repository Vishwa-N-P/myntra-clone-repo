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
 * This class is a wrapper for {@link ProductCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductCategory
 * @generated
 */
public class ProductCategoryWrapper
	implements ModelWrapper<ProductCategory>, ProductCategory {

	public ProductCategoryWrapper(ProductCategory productCategory) {
		_productCategory = productCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ProductCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ProductCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("categoryName", getCategoryName());
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

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
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
		return new ProductCategoryWrapper(
			(ProductCategory)_productCategory.clone());
	}

	@Override
	public int compareTo(ProductCategory productCategory) {
		return _productCategory.compareTo(productCategory);
	}

	/**
	 * Returns the category name of this product category.
	 *
	 * @return the category name of this product category
	 */
	@Override
	public String getCategoryName() {
		return _productCategory.getCategoryName();
	}

	/**
	 * Returns the create date of this product category.
	 *
	 * @return the create date of this product category
	 */
	@Override
	public Date getCreateDate() {
		return _productCategory.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _productCategory.getExpandoBridge();
	}

	/**
	 * Returns the ID of this product category.
	 *
	 * @return the ID of this product category
	 */
	@Override
	public long getId() {
		return _productCategory.getId();
	}

	/**
	 * Returns the modified date of this product category.
	 *
	 * @return the modified date of this product category
	 */
	@Override
	public Date getModifiedDate() {
		return _productCategory.getModifiedDate();
	}

	/**
	 * Returns the primary key of this product category.
	 *
	 * @return the primary key of this product category
	 */
	@Override
	public long getPrimaryKey() {
		return _productCategory.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _productCategory.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this product category.
	 *
	 * @return the uuid of this product category
	 */
	@Override
	public String getUuid() {
		return _productCategory.getUuid();
	}

	@Override
	public int hashCode() {
		return _productCategory.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _productCategory.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _productCategory.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _productCategory.isNew();
	}

	@Override
	public void persist() {
		_productCategory.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_productCategory.setCachedModel(cachedModel);
	}

	/**
	 * Sets the category name of this product category.
	 *
	 * @param categoryName the category name of this product category
	 */
	@Override
	public void setCategoryName(String categoryName) {
		_productCategory.setCategoryName(categoryName);
	}

	/**
	 * Sets the create date of this product category.
	 *
	 * @param createDate the create date of this product category
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_productCategory.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_productCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_productCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_productCategory.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this product category.
	 *
	 * @param id the ID of this product category
	 */
	@Override
	public void setId(long id) {
		_productCategory.setId(id);
	}

	/**
	 * Sets the modified date of this product category.
	 *
	 * @param modifiedDate the modified date of this product category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_productCategory.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_productCategory.setNew(n);
	}

	/**
	 * Sets the primary key of this product category.
	 *
	 * @param primaryKey the primary key of this product category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_productCategory.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_productCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this product category.
	 *
	 * @param uuid the uuid of this product category
	 */
	@Override
	public void setUuid(String uuid) {
		_productCategory.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProductCategory>
		toCacheModel() {

		return _productCategory.toCacheModel();
	}

	@Override
	public ProductCategory toEscapedModel() {
		return new ProductCategoryWrapper(_productCategory.toEscapedModel());
	}

	@Override
	public String toString() {
		return _productCategory.toString();
	}

	@Override
	public ProductCategory toUnescapedModel() {
		return new ProductCategoryWrapper(_productCategory.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _productCategory.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductCategoryWrapper)) {
			return false;
		}

		ProductCategoryWrapper productCategoryWrapper =
			(ProductCategoryWrapper)object;

		if (Objects.equals(
				_productCategory, productCategoryWrapper._productCategory)) {

			return true;
		}

		return false;
	}

	@Override
	public ProductCategory getWrappedModel() {
		return _productCategory;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _productCategory.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _productCategory.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_productCategory.resetOriginalValues();
	}

	private final ProductCategory _productCategory;

}