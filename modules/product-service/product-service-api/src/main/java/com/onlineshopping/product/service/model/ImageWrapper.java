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
 * This class is a wrapper for {@link Image}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Image
 * @generated
 */
public class ImageWrapper implements Image, ModelWrapper<Image> {

	public ImageWrapper(Image image) {
		_image = image;
	}

	@Override
	public Class<?> getModelClass() {
		return Image.class;
	}

	@Override
	public String getModelClassName() {
		return Image.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("view", getView());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("productId", getProductId());
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

		String view = (String)attributes.get("view");

		if (view != null) {
			setView(view);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
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
		return new ImageWrapper((Image)_image.clone());
	}

	@Override
	public int compareTo(Image image) {
		return _image.compareTo(image);
	}

	/**
	 * Returns the create date of this image.
	 *
	 * @return the create date of this image
	 */
	@Override
	public Date getCreateDate() {
		return _image.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _image.getExpandoBridge();
	}

	/**
	 * Returns the ID of this image.
	 *
	 * @return the ID of this image
	 */
	@Override
	public long getId() {
		return _image.getId();
	}

	/**
	 * Returns the image url of this image.
	 *
	 * @return the image url of this image
	 */
	@Override
	public String getImageUrl() {
		return _image.getImageUrl();
	}

	/**
	 * Returns the modified date of this image.
	 *
	 * @return the modified date of this image
	 */
	@Override
	public Date getModifiedDate() {
		return _image.getModifiedDate();
	}

	/**
	 * Returns the primary key of this image.
	 *
	 * @return the primary key of this image
	 */
	@Override
	public long getPrimaryKey() {
		return _image.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _image.getPrimaryKeyObj();
	}

	/**
	 * Returns the product ID of this image.
	 *
	 * @return the product ID of this image
	 */
	@Override
	public long getProductId() {
		return _image.getProductId();
	}

	/**
	 * Returns the uuid of this image.
	 *
	 * @return the uuid of this image
	 */
	@Override
	public String getUuid() {
		return _image.getUuid();
	}

	/**
	 * Returns the view of this image.
	 *
	 * @return the view of this image
	 */
	@Override
	public String getView() {
		return _image.getView();
	}

	@Override
	public int hashCode() {
		return _image.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _image.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _image.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _image.isNew();
	}

	@Override
	public void persist() {
		_image.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_image.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this image.
	 *
	 * @param createDate the create date of this image
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_image.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_image.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_image.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_image.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this image.
	 *
	 * @param id the ID of this image
	 */
	@Override
	public void setId(long id) {
		_image.setId(id);
	}

	/**
	 * Sets the image url of this image.
	 *
	 * @param imageUrl the image url of this image
	 */
	@Override
	public void setImageUrl(String imageUrl) {
		_image.setImageUrl(imageUrl);
	}

	/**
	 * Sets the modified date of this image.
	 *
	 * @param modifiedDate the modified date of this image
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_image.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_image.setNew(n);
	}

	/**
	 * Sets the primary key of this image.
	 *
	 * @param primaryKey the primary key of this image
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_image.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_image.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the product ID of this image.
	 *
	 * @param productId the product ID of this image
	 */
	@Override
	public void setProductId(long productId) {
		_image.setProductId(productId);
	}

	/**
	 * Sets the uuid of this image.
	 *
	 * @param uuid the uuid of this image
	 */
	@Override
	public void setUuid(String uuid) {
		_image.setUuid(uuid);
	}

	/**
	 * Sets the view of this image.
	 *
	 * @param view the view of this image
	 */
	@Override
	public void setView(String view) {
		_image.setView(view);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Image> toCacheModel() {
		return _image.toCacheModel();
	}

	@Override
	public Image toEscapedModel() {
		return new ImageWrapper(_image.toEscapedModel());
	}

	@Override
	public String toString() {
		return _image.toString();
	}

	@Override
	public Image toUnescapedModel() {
		return new ImageWrapper(_image.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _image.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImageWrapper)) {
			return false;
		}

		ImageWrapper imageWrapper = (ImageWrapper)object;

		if (Objects.equals(_image, imageWrapper._image)) {
			return true;
		}

		return false;
	}

	@Override
	public Image getWrappedModel() {
		return _image;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _image.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _image.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_image.resetOriginalValues();
	}

	private final Image _image;

}