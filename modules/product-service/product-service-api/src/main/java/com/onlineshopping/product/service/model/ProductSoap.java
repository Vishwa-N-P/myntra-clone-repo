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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.ProductServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductSoap implements Serializable {

	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setProductName(model.getProductName());
		soapModel.setProductInfo(model.getProductInfo());
		soapModel.setColor(model.getColor());
		soapModel.setRatingCount(model.getRatingCount());
		soapModel.setRating(model.getRating());
		soapModel.setPrice(model.getPrice());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setDiscountPercentage(model.getDiscountPercentage());
		soapModel.setFinalPrice(model.getFinalPrice());
		soapModel.setGender(model.getGender());
		soapModel.setBrandId(model.getBrandId());
		soapModel.setHighlightsId(model.getHighlightsId());
		soapModel.setProductCount(model.getProductCount());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(
			models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getProductInfo() {
		return _productInfo;
	}

	public void setProductInfo(String productInfo) {
		_productInfo = productInfo;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public long getRatingCount() {
		return _ratingCount;
	}

	public void setRatingCount(long ratingCount) {
		_ratingCount = ratingCount;
	}

	public double getRating() {
		return _rating;
	}

	public void setRating(double rating) {
		_rating = rating;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public long getDiscount() {
		return _discount;
	}

	public void setDiscount(long discount) {
		_discount = discount;
	}

	public int getDiscountPercentage() {
		return _discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		_discountPercentage = discountPercentage;
	}

	public long getFinalPrice() {
		return _finalPrice;
	}

	public void setFinalPrice(long finalPrice) {
		_finalPrice = finalPrice;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public long getBrandId() {
		return _brandId;
	}

	public void setBrandId(long brandId) {
		_brandId = brandId;
	}

	public long getHighlightsId() {
		return _highlightsId;
	}

	public void setHighlightsId(long highlightsId) {
		_highlightsId = highlightsId;
	}

	public int getProductCount() {
		return _productCount;
	}

	public void setProductCount(int productCount) {
		_productCount = productCount;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _id;
	private String _productName;
	private String _productInfo;
	private String _color;
	private long _ratingCount;
	private double _rating;
	private long _price;
	private long _discount;
	private int _discountPercentage;
	private long _finalPrice;
	private String _gender;
	private long _brandId;
	private long _highlightsId;
	private int _productCount;
	private int _status;
	private Date _createDate;
	private Date _modifiedDate;

}