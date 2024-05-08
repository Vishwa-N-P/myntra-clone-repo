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
 * This class is a wrapper for {@link Brand}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Brand
 * @generated
 */
public class BrandWrapper implements Brand, ModelWrapper<Brand> {

	public BrandWrapper(Brand brand) {
		_brand = brand;
	}

	@Override
	public Class<?> getModelClass() {
		return Brand.class;
	}

	@Override
	public String getModelClassName() {
		return Brand.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("brandName", getBrandName());
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

		String brandName = (String)attributes.get("brandName");

		if (brandName != null) {
			setBrandName(brandName);
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
		return new BrandWrapper((Brand)_brand.clone());
	}

	@Override
	public int compareTo(Brand brand) {
		return _brand.compareTo(brand);
	}

	/**
	 * Returns the brand name of this brand.
	 *
	 * @return the brand name of this brand
	 */
	@Override
	public String getBrandName() {
		return _brand.getBrandName();
	}

	/**
	 * Returns the create date of this brand.
	 *
	 * @return the create date of this brand
	 */
	@Override
	public Date getCreateDate() {
		return _brand.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _brand.getExpandoBridge();
	}

	/**
	 * Returns the ID of this brand.
	 *
	 * @return the ID of this brand
	 */
	@Override
	public long getId() {
		return _brand.getId();
	}

	/**
	 * Returns the modified date of this brand.
	 *
	 * @return the modified date of this brand
	 */
	@Override
	public Date getModifiedDate() {
		return _brand.getModifiedDate();
	}

	/**
	 * Returns the primary key of this brand.
	 *
	 * @return the primary key of this brand
	 */
	@Override
	public long getPrimaryKey() {
		return _brand.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _brand.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this brand.
	 *
	 * @return the uuid of this brand
	 */
	@Override
	public String getUuid() {
		return _brand.getUuid();
	}

	@Override
	public int hashCode() {
		return _brand.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _brand.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _brand.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _brand.isNew();
	}

	@Override
	public void persist() {
		_brand.persist();
	}

	/**
	 * Sets the brand name of this brand.
	 *
	 * @param brandName the brand name of this brand
	 */
	@Override
	public void setBrandName(String brandName) {
		_brand.setBrandName(brandName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_brand.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this brand.
	 *
	 * @param createDate the create date of this brand
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_brand.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_brand.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_brand.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_brand.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this brand.
	 *
	 * @param id the ID of this brand
	 */
	@Override
	public void setId(long id) {
		_brand.setId(id);
	}

	/**
	 * Sets the modified date of this brand.
	 *
	 * @param modifiedDate the modified date of this brand
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_brand.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_brand.setNew(n);
	}

	/**
	 * Sets the primary key of this brand.
	 *
	 * @param primaryKey the primary key of this brand
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_brand.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_brand.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this brand.
	 *
	 * @param uuid the uuid of this brand
	 */
	@Override
	public void setUuid(String uuid) {
		_brand.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Brand> toCacheModel() {
		return _brand.toCacheModel();
	}

	@Override
	public Brand toEscapedModel() {
		return new BrandWrapper(_brand.toEscapedModel());
	}

	@Override
	public String toString() {
		return _brand.toString();
	}

	@Override
	public Brand toUnescapedModel() {
		return new BrandWrapper(_brand.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _brand.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BrandWrapper)) {
			return false;
		}

		BrandWrapper brandWrapper = (BrandWrapper)object;

		if (Objects.equals(_brand, brandWrapper._brand)) {
			return true;
		}

		return false;
	}

	@Override
	public Brand getWrappedModel() {
		return _brand;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _brand.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _brand.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_brand.resetOriginalValues();
	}

	private final Brand _brand;

}