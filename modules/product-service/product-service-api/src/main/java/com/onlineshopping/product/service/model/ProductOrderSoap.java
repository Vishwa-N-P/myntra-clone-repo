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
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.ProductOrderServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductOrderSoap implements Serializable {

	public static ProductOrderSoap toSoapModel(ProductOrder model) {
		ProductOrderSoap soapModel = new ProductOrderSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setProductId(model.getProductId());
		soapModel.setSize(model.getSize());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setCost(model.getCost());
		soapModel.setUserId(model.getUserId());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProductOrderSoap[] toSoapModels(ProductOrder[] models) {
		ProductOrderSoap[] soapModels = new ProductOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductOrderSoap[][] toSoapModels(ProductOrder[][] models) {
		ProductOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductOrderSoap[] toSoapModels(List<ProductOrder> models) {
		List<ProductOrderSoap> soapModels = new ArrayList<ProductOrderSoap>(
			models.size());

		for (ProductOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductOrderSoap[soapModels.size()]);
	}

	public ProductOrderSoap() {
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

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getSize() {
		return _size;
	}

	public void setSize(String size) {
		_size = size;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getCost() {
		return _cost;
	}

	public void setCost(long cost) {
		_cost = cost;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
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
	private long _productId;
	private String _size;
	private int _quantity;
	private long _cost;
	private long _userId;
	private long _addressId;
	private Date _createDate;
	private Date _modifiedDate;

}