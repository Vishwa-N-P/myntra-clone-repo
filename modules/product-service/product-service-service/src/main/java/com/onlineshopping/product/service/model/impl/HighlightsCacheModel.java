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

package com.onlineshopping.product.service.model.impl;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.onlineshopping.product.service.model.Highlights;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Highlights in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HighlightsCacheModel
	implements CacheModel<Highlights>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HighlightsCacheModel)) {
			return false;
		}

		HighlightsCacheModel highlightsCacheModel =
			(HighlightsCacheModel)object;

		if (id == highlightsCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", features=");
		sb.append(features);
		sb.append(", size=");
		sb.append(size);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Highlights toEntityModel() {
		HighlightsImpl highlightsImpl = new HighlightsImpl();

		if (uuid == null) {
			highlightsImpl.setUuid("");
		}
		else {
			highlightsImpl.setUuid(uuid);
		}

		highlightsImpl.setId(id);

		if (features == null) {
			highlightsImpl.setFeatures("");
		}
		else {
			highlightsImpl.setFeatures(features);
		}

		if (size == null) {
			highlightsImpl.setSize("");
		}
		else {
			highlightsImpl.setSize(size);
		}

		if (createDate == Long.MIN_VALUE) {
			highlightsImpl.setCreateDate(null);
		}
		else {
			highlightsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			highlightsImpl.setModifiedDate(null);
		}
		else {
			highlightsImpl.setModifiedDate(new Date(modifiedDate));
		}

		highlightsImpl.resetOriginalValues();

		return highlightsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		features = objectInput.readUTF();
		size = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (features == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(features);
		}

		if (size == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(size);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public String features;
	public String size;
	public long createDate;
	public long modifiedDate;

}