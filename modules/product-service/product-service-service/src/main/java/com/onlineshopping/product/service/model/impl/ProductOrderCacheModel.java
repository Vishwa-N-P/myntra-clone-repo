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

import com.onlineshopping.product.service.model.ProductOrder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductOrder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductOrderCacheModel
	implements CacheModel<ProductOrder>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductOrderCacheModel)) {
			return false;
		}

		ProductOrderCacheModel productOrderCacheModel =
			(ProductOrderCacheModel)object;

		if (id == productOrderCacheModel.id) {
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
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", size=");
		sb.append(size);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductOrder toEntityModel() {
		ProductOrderImpl productOrderImpl = new ProductOrderImpl();

		if (uuid == null) {
			productOrderImpl.setUuid("");
		}
		else {
			productOrderImpl.setUuid(uuid);
		}

		productOrderImpl.setId(id);
		productOrderImpl.setProductId(productId);

		if (size == null) {
			productOrderImpl.setSize("");
		}
		else {
			productOrderImpl.setSize(size);
		}

		productOrderImpl.setQuantity(quantity);
		productOrderImpl.setCost(cost);
		productOrderImpl.setUserId(userId);
		productOrderImpl.setAddressId(addressId);

		if (createDate == Long.MIN_VALUE) {
			productOrderImpl.setCreateDate(null);
		}
		else {
			productOrderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productOrderImpl.setModifiedDate(null);
		}
		else {
			productOrderImpl.setModifiedDate(new Date(modifiedDate));
		}

		productOrderImpl.resetOriginalValues();

		return productOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		productId = objectInput.readLong();
		size = objectInput.readUTF();

		quantity = objectInput.readInt();

		cost = objectInput.readLong();

		userId = objectInput.readLong();

		addressId = objectInput.readLong();
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

		objectOutput.writeLong(productId);

		if (size == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(size);
		}

		objectOutput.writeInt(quantity);

		objectOutput.writeLong(cost);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(addressId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public long productId;
	public String size;
	public int quantity;
	public long cost;
	public long userId;
	public long addressId;
	public long createDate;
	public long modifiedDate;

}