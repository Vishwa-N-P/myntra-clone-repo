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

import com.onlineshopping.product.service.model.Image;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Image in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImageCacheModel implements CacheModel<Image>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImageCacheModel)) {
			return false;
		}

		ImageCacheModel imageCacheModel = (ImageCacheModel)object;

		if (id == imageCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", view=");
		sb.append(view);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Image toEntityModel() {
		ImageImpl imageImpl = new ImageImpl();

		if (uuid == null) {
			imageImpl.setUuid("");
		}
		else {
			imageImpl.setUuid(uuid);
		}

		imageImpl.setId(id);

		if (view == null) {
			imageImpl.setView("");
		}
		else {
			imageImpl.setView(view);
		}

		if (imageUrl == null) {
			imageImpl.setImageUrl("");
		}
		else {
			imageImpl.setImageUrl(imageUrl);
		}

		imageImpl.setProductId(productId);

		if (createDate == Long.MIN_VALUE) {
			imageImpl.setCreateDate(null);
		}
		else {
			imageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			imageImpl.setModifiedDate(null);
		}
		else {
			imageImpl.setModifiedDate(new Date(modifiedDate));
		}

		imageImpl.resetOriginalValues();

		return imageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		view = objectInput.readUTF();
		imageUrl = objectInput.readUTF();

		productId = objectInput.readLong();
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

		if (view == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(view);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		objectOutput.writeLong(productId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public String view;
	public String imageUrl;
	public long productId;
	public long createDate;
	public long modifiedDate;

}