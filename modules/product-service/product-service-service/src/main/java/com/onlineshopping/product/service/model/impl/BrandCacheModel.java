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

import com.onlineshopping.product.service.model.Brand;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Brand in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BrandCacheModel implements CacheModel<Brand>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BrandCacheModel)) {
			return false;
		}

		BrandCacheModel brandCacheModel = (BrandCacheModel)object;

		if (id == brandCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", brandName=");
		sb.append(brandName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Brand toEntityModel() {
		BrandImpl brandImpl = new BrandImpl();

		if (uuid == null) {
			brandImpl.setUuid("");
		}
		else {
			brandImpl.setUuid(uuid);
		}

		brandImpl.setId(id);

		if (brandName == null) {
			brandImpl.setBrandName("");
		}
		else {
			brandImpl.setBrandName(brandName);
		}

		if (createDate == Long.MIN_VALUE) {
			brandImpl.setCreateDate(null);
		}
		else {
			brandImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			brandImpl.setModifiedDate(null);
		}
		else {
			brandImpl.setModifiedDate(new Date(modifiedDate));
		}

		brandImpl.resetOriginalValues();

		return brandImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		brandName = objectInput.readUTF();
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

		if (brandName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(brandName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public String brandName;
	public long createDate;
	public long modifiedDate;

}