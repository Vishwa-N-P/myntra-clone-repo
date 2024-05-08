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
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.BrandServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrandSoap implements Serializable {

	public static BrandSoap toSoapModel(Brand model) {
		BrandSoap soapModel = new BrandSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setBrandName(model.getBrandName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static BrandSoap[] toSoapModels(Brand[] models) {
		BrandSoap[] soapModels = new BrandSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BrandSoap[][] toSoapModels(Brand[][] models) {
		BrandSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BrandSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BrandSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BrandSoap[] toSoapModels(List<Brand> models) {
		List<BrandSoap> soapModels = new ArrayList<BrandSoap>(models.size());

		for (Brand model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BrandSoap[soapModels.size()]);
	}

	public BrandSoap() {
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

	public String getBrandName() {
		return _brandName;
	}

	public void setBrandName(String brandName) {
		_brandName = brandName;
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
	private String _brandName;
	private Date _createDate;
	private Date _modifiedDate;

}