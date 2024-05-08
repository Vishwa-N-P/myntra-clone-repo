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
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.CartListProductServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CartListProductSoap implements Serializable {

	public static CartListProductSoap toSoapModel(CartListProduct model) {
		CartListProductSoap soapModel = new CartListProductSoap();

		soapModel.setId(model.getId());
		soapModel.setCartListId(model.getCartListId());
		soapModel.setProductId(model.getProductId());
		soapModel.setSize(model.getSize());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CartListProductSoap[] toSoapModels(CartListProduct[] models) {
		CartListProductSoap[] soapModels =
			new CartListProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CartListProductSoap[][] toSoapModels(
		CartListProduct[][] models) {

		CartListProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CartListProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CartListProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CartListProductSoap[] toSoapModels(
		List<CartListProduct> models) {

		List<CartListProductSoap> soapModels =
			new ArrayList<CartListProductSoap>(models.size());

		for (CartListProduct model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CartListProductSoap[soapModels.size()]);
	}

	public CartListProductSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCartListId() {
		return _cartListId;
	}

	public void setCartListId(long cartListId) {
		_cartListId = cartListId;
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

	private long _id;
	private long _cartListId;
	private long _productId;
	private String _size;
	private int _quantity;
	private Date _createDate;
	private Date _modifiedDate;

}