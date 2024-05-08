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
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.WishlistProductServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WishlistProductSoap implements Serializable {

	public static WishlistProductSoap toSoapModel(WishlistProduct model) {
		WishlistProductSoap soapModel = new WishlistProductSoap();

		soapModel.setId(model.getId());
		soapModel.setWishlistId(model.getWishlistId());
		soapModel.setProductId(model.getProductId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static WishlistProductSoap[] toSoapModels(WishlistProduct[] models) {
		WishlistProductSoap[] soapModels =
			new WishlistProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WishlistProductSoap[][] toSoapModels(
		WishlistProduct[][] models) {

		WishlistProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new WishlistProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WishlistProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WishlistProductSoap[] toSoapModels(
		List<WishlistProduct> models) {

		List<WishlistProductSoap> soapModels =
			new ArrayList<WishlistProductSoap>(models.size());

		for (WishlistProduct model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WishlistProductSoap[soapModels.size()]);
	}

	public WishlistProductSoap() {
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

	public long getWishlistId() {
		return _wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		_wishlistId = wishlistId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
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
	private long _wishlistId;
	private long _productId;
	private Date _createDate;
	private Date _modifiedDate;

}