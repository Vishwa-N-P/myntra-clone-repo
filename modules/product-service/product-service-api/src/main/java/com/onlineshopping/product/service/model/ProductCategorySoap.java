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
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.ProductCategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCategorySoap implements Serializable {

	public static ProductCategorySoap toSoapModel(ProductCategory model) {
		ProductCategorySoap soapModel = new ProductCategorySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProductCategorySoap[] toSoapModels(ProductCategory[] models) {
		ProductCategorySoap[] soapModels =
			new ProductCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductCategorySoap[][] toSoapModels(
		ProductCategory[][] models) {

		ProductCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProductCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductCategorySoap[] toSoapModels(
		List<ProductCategory> models) {

		List<ProductCategorySoap> soapModels =
			new ArrayList<ProductCategorySoap>(models.size());

		for (ProductCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductCategorySoap[soapModels.size()]);
	}

	public ProductCategorySoap() {
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

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
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
	private String _categoryName;
	private Date _createDate;
	private Date _modifiedDate;

}