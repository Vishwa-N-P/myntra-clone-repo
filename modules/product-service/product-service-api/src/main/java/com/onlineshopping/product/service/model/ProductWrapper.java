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
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductWrapper implements ModelWrapper<Product>, Product {

	public ProductWrapper(Product product) {
		_product = product;
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("productName", getProductName());
		attributes.put("productInfo", getProductInfo());
		attributes.put("color", getColor());
		attributes.put("ratingCount", getRatingCount());
		attributes.put("rating", getRating());
		attributes.put("price", getPrice());
		attributes.put("discount", getDiscount());
		attributes.put("discountPercentage", getDiscountPercentage());
		attributes.put("finalPrice", getFinalPrice());
		attributes.put("gender", getGender());
		attributes.put("brandId", getBrandId());
		attributes.put("highlightsId", getHighlightsId());
		attributes.put("productCount", getProductCount());
		attributes.put("status", getStatus());
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

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String productInfo = (String)attributes.get("productInfo");

		if (productInfo != null) {
			setProductInfo(productInfo);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Long ratingCount = (Long)attributes.get("ratingCount");

		if (ratingCount != null) {
			setRatingCount(ratingCount);
		}

		Double rating = (Double)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Long discount = (Long)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Integer discountPercentage = (Integer)attributes.get(
			"discountPercentage");

		if (discountPercentage != null) {
			setDiscountPercentage(discountPercentage);
		}

		Long finalPrice = (Long)attributes.get("finalPrice");

		if (finalPrice != null) {
			setFinalPrice(finalPrice);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long highlightsId = (Long)attributes.get("highlightsId");

		if (highlightsId != null) {
			setHighlightsId(highlightsId);
		}

		Integer productCount = (Integer)attributes.get("productCount");

		if (productCount != null) {
			setProductCount(productCount);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(Product product) {
		return _product.compareTo(product);
	}

	/**
	 * Returns the brand ID of this product.
	 *
	 * @return the brand ID of this product
	 */
	@Override
	public long getBrandId() {
		return _product.getBrandId();
	}

	/**
	 * Returns the color of this product.
	 *
	 * @return the color of this product
	 */
	@Override
	public String getColor() {
		return _product.getColor();
	}

	/**
	 * Returns the create date of this product.
	 *
	 * @return the create date of this product
	 */
	@Override
	public Date getCreateDate() {
		return _product.getCreateDate();
	}

	/**
	 * Returns the discount of this product.
	 *
	 * @return the discount of this product
	 */
	@Override
	public long getDiscount() {
		return _product.getDiscount();
	}

	/**
	 * Returns the discount percentage of this product.
	 *
	 * @return the discount percentage of this product
	 */
	@Override
	public int getDiscountPercentage() {
		return _product.getDiscountPercentage();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	/**
	 * Returns the final price of this product.
	 *
	 * @return the final price of this product
	 */
	@Override
	public long getFinalPrice() {
		return _product.getFinalPrice();
	}

	/**
	 * Returns the gender of this product.
	 *
	 * @return the gender of this product
	 */
	@Override
	public String getGender() {
		return _product.getGender();
	}

	/**
	 * Returns the highlights ID of this product.
	 *
	 * @return the highlights ID of this product
	 */
	@Override
	public long getHighlightsId() {
		return _product.getHighlightsId();
	}

	/**
	 * Returns the ID of this product.
	 *
	 * @return the ID of this product
	 */
	@Override
	public long getId() {
		return _product.getId();
	}

	/**
	 * Returns the modified date of this product.
	 *
	 * @return the modified date of this product
	 */
	@Override
	public Date getModifiedDate() {
		return _product.getModifiedDate();
	}

	/**
	 * Returns the price of this product.
	 *
	 * @return the price of this product
	 */
	@Override
	public long getPrice() {
		return _product.getPrice();
	}

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	/**
	 * Returns the product count of this product.
	 *
	 * @return the product count of this product
	 */
	@Override
	public int getProductCount() {
		return _product.getProductCount();
	}

	/**
	 * Returns the product info of this product.
	 *
	 * @return the product info of this product
	 */
	@Override
	public String getProductInfo() {
		return _product.getProductInfo();
	}

	/**
	 * Returns the product name of this product.
	 *
	 * @return the product name of this product
	 */
	@Override
	public String getProductName() {
		return _product.getProductName();
	}

	/**
	 * Returns the rating of this product.
	 *
	 * @return the rating of this product
	 */
	@Override
	public double getRating() {
		return _product.getRating();
	}

	/**
	 * Returns the rating count of this product.
	 *
	 * @return the rating count of this product
	 */
	@Override
	public long getRatingCount() {
		return _product.getRatingCount();
	}

	/**
	 * Returns the status of this product.
	 *
	 * @return the status of this product
	 */
	@Override
	public int getStatus() {
		return _product.getStatus();
	}

	/**
	 * Returns the uuid of this product.
	 *
	 * @return the uuid of this product
	 */
	@Override
	public String getUuid() {
		return _product.getUuid();
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void persist() {
		_product.persist();
	}

	/**
	 * Sets the brand ID of this product.
	 *
	 * @param brandId the brand ID of this product
	 */
	@Override
	public void setBrandId(long brandId) {
		_product.setBrandId(brandId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	/**
	 * Sets the color of this product.
	 *
	 * @param color the color of this product
	 */
	@Override
	public void setColor(String color) {
		_product.setColor(color);
	}

	/**
	 * Sets the create date of this product.
	 *
	 * @param createDate the create date of this product
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_product.setCreateDate(createDate);
	}

	/**
	 * Sets the discount of this product.
	 *
	 * @param discount the discount of this product
	 */
	@Override
	public void setDiscount(long discount) {
		_product.setDiscount(discount);
	}

	/**
	 * Sets the discount percentage of this product.
	 *
	 * @param discountPercentage the discount percentage of this product
	 */
	@Override
	public void setDiscountPercentage(int discountPercentage) {
		_product.setDiscountPercentage(discountPercentage);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the final price of this product.
	 *
	 * @param finalPrice the final price of this product
	 */
	@Override
	public void setFinalPrice(long finalPrice) {
		_product.setFinalPrice(finalPrice);
	}

	/**
	 * Sets the gender of this product.
	 *
	 * @param gender the gender of this product
	 */
	@Override
	public void setGender(String gender) {
		_product.setGender(gender);
	}

	/**
	 * Sets the highlights ID of this product.
	 *
	 * @param highlightsId the highlights ID of this product
	 */
	@Override
	public void setHighlightsId(long highlightsId) {
		_product.setHighlightsId(highlightsId);
	}

	/**
	 * Sets the ID of this product.
	 *
	 * @param id the ID of this product
	 */
	@Override
	public void setId(long id) {
		_product.setId(id);
	}

	/**
	 * Sets the modified date of this product.
	 *
	 * @param modifiedDate the modified date of this product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_product.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	/**
	 * Sets the price of this product.
	 *
	 * @param price the price of this product
	 */
	@Override
	public void setPrice(long price) {
		_product.setPrice(price);
	}

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the product count of this product.
	 *
	 * @param productCount the product count of this product
	 */
	@Override
	public void setProductCount(int productCount) {
		_product.setProductCount(productCount);
	}

	/**
	 * Sets the product info of this product.
	 *
	 * @param productInfo the product info of this product
	 */
	@Override
	public void setProductInfo(String productInfo) {
		_product.setProductInfo(productInfo);
	}

	/**
	 * Sets the product name of this product.
	 *
	 * @param productName the product name of this product
	 */
	@Override
	public void setProductName(String productName) {
		_product.setProductName(productName);
	}

	/**
	 * Sets the rating of this product.
	 *
	 * @param rating the rating of this product
	 */
	@Override
	public void setRating(double rating) {
		_product.setRating(rating);
	}

	/**
	 * Sets the rating count of this product.
	 *
	 * @param ratingCount the rating count of this product
	 */
	@Override
	public void setRatingCount(long ratingCount) {
		_product.setRatingCount(ratingCount);
	}

	/**
	 * Sets the status of this product.
	 *
	 * @param status the status of this product
	 */
	@Override
	public void setStatus(int status) {
		_product.setStatus(status);
	}

	/**
	 * Sets the uuid of this product.
	 *
	 * @param uuid the uuid of this product
	 */
	@Override
	public void setUuid(String uuid) {
		_product.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public String toString() {
		return _product.toString();
	}

	@Override
	public Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)object;

		if (Objects.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _product.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _product.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private final Product _product;

}