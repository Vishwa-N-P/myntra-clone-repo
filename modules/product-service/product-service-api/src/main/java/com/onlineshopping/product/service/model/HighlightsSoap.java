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
 * This class is used by SOAP remote services, specifically {@link com.onlineshopping.product.service.service.http.HighlightsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HighlightsSoap implements Serializable {

	public static HighlightsSoap toSoapModel(Highlights model) {
		HighlightsSoap soapModel = new HighlightsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setFeatures(model.getFeatures());
		soapModel.setSize(model.getSize());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static HighlightsSoap[] toSoapModels(Highlights[] models) {
		HighlightsSoap[] soapModels = new HighlightsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HighlightsSoap[][] toSoapModels(Highlights[][] models) {
		HighlightsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HighlightsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HighlightsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HighlightsSoap[] toSoapModels(List<Highlights> models) {
		List<HighlightsSoap> soapModels = new ArrayList<HighlightsSoap>(
			models.size());

		for (Highlights model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HighlightsSoap[soapModels.size()]);
	}

	public HighlightsSoap() {
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

	public String getFeatures() {
		return _features;
	}

	public void setFeatures(String features) {
		_features = features;
	}

	public String getSize() {
		return _size;
	}

	public void setSize(String size) {
		_size = size;
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
	private String _features;
	private String _size;
	private Date _createDate;
	private Date _modifiedDate;

}