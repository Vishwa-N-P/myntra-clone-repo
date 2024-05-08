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

import com.onlineshopping.product.service.model.ProductCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCategoryCacheModel
	implements CacheModel<ProductCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductCategoryCacheModel)) {
			return false;
		}

		ProductCategoryCacheModel productCategoryCacheModel =
			(ProductCategoryCacheModel)object;

		if (id == productCategoryCacheModel.id) {
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
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductCategory toEntityModel() {
		ProductCategoryImpl productCategoryImpl = new ProductCategoryImpl();

		if (uuid == null) {
			productCategoryImpl.setUuid("");
		}
		else {
			productCategoryImpl.setUuid(uuid);
		}

		productCategoryImpl.setId(id);

		if (categoryName == null) {
			productCategoryImpl.setCategoryName("");
		}
		else {
			productCategoryImpl.setCategoryName(categoryName);
		}

		if (createDate == Long.MIN_VALUE) {
			productCategoryImpl.setCreateDate(null);
		}
		else {
			productCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productCategoryImpl.setModifiedDate(null);
		}
		else {
			productCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		productCategoryImpl.resetOriginalValues();

		return productCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		categoryName = objectInput.readUTF();
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

		if (categoryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public String categoryName;
	public long createDate;
	public long modifiedDate;

}