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
 * This class is a wrapper for {@link Highlights}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Highlights
 * @generated
 */
public class HighlightsWrapper implements Highlights, ModelWrapper<Highlights> {

	public HighlightsWrapper(Highlights highlights) {
		_highlights = highlights;
	}

	@Override
	public Class<?> getModelClass() {
		return Highlights.class;
	}

	@Override
	public String getModelClassName() {
		return Highlights.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("features", getFeatures());
		attributes.put("size", getSize());
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

		String features = (String)attributes.get("features");

		if (features != null) {
			setFeatures(features);
		}

		String size = (String)attributes.get("size");

		if (size != null) {
			setSize(size);
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
		return new HighlightsWrapper((Highlights)_highlights.clone());
	}

	@Override
	public int compareTo(Highlights highlights) {
		return _highlights.compareTo(highlights);
	}

	/**
	 * Returns the create date of this highlights.
	 *
	 * @return the create date of this highlights
	 */
	@Override
	public Date getCreateDate() {
		return _highlights.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _highlights.getExpandoBridge();
	}

	/**
	 * Returns the features of this highlights.
	 *
	 * @return the features of this highlights
	 */
	@Override
	public String getFeatures() {
		return _highlights.getFeatures();
	}

	/**
	 * Returns the ID of this highlights.
	 *
	 * @return the ID of this highlights
	 */
	@Override
	public long getId() {
		return _highlights.getId();
	}

	/**
	 * Returns the modified date of this highlights.
	 *
	 * @return the modified date of this highlights
	 */
	@Override
	public Date getModifiedDate() {
		return _highlights.getModifiedDate();
	}

	/**
	 * Returns the primary key of this highlights.
	 *
	 * @return the primary key of this highlights
	 */
	@Override
	public long getPrimaryKey() {
		return _highlights.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _highlights.getPrimaryKeyObj();
	}

	/**
	 * Returns the size of this highlights.
	 *
	 * @return the size of this highlights
	 */
	@Override
	public String getSize() {
		return _highlights.getSize();
	}

	/**
	 * Returns the uuid of this highlights.
	 *
	 * @return the uuid of this highlights
	 */
	@Override
	public String getUuid() {
		return _highlights.getUuid();
	}

	@Override
	public int hashCode() {
		return _highlights.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _highlights.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _highlights.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _highlights.isNew();
	}

	@Override
	public void persist() {
		_highlights.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_highlights.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this highlights.
	 *
	 * @param createDate the create date of this highlights
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_highlights.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_highlights.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_highlights.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_highlights.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the features of this highlights.
	 *
	 * @param features the features of this highlights
	 */
	@Override
	public void setFeatures(String features) {
		_highlights.setFeatures(features);
	}

	/**
	 * Sets the ID of this highlights.
	 *
	 * @param id the ID of this highlights
	 */
	@Override
	public void setId(long id) {
		_highlights.setId(id);
	}

	/**
	 * Sets the modified date of this highlights.
	 *
	 * @param modifiedDate the modified date of this highlights
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_highlights.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_highlights.setNew(n);
	}

	/**
	 * Sets the primary key of this highlights.
	 *
	 * @param primaryKey the primary key of this highlights
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_highlights.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_highlights.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the size of this highlights.
	 *
	 * @param size the size of this highlights
	 */
	@Override
	public void setSize(String size) {
		_highlights.setSize(size);
	}

	/**
	 * Sets the uuid of this highlights.
	 *
	 * @param uuid the uuid of this highlights
	 */
	@Override
	public void setUuid(String uuid) {
		_highlights.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Highlights>
		toCacheModel() {

		return _highlights.toCacheModel();
	}

	@Override
	public Highlights toEscapedModel() {
		return new HighlightsWrapper(_highlights.toEscapedModel());
	}

	@Override
	public String toString() {
		return _highlights.toString();
	}

	@Override
	public Highlights toUnescapedModel() {
		return new HighlightsWrapper(_highlights.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _highlights.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HighlightsWrapper)) {
			return false;
		}

		HighlightsWrapper highlightsWrapper = (HighlightsWrapper)object;

		if (Objects.equals(_highlights, highlightsWrapper._highlights)) {
			return true;
		}

		return false;
	}

	@Override
	public Highlights getWrappedModel() {
		return _highlights;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _highlights.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _highlights.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_highlights.resetOriginalValues();
	}

	private final Highlights _highlights;

}