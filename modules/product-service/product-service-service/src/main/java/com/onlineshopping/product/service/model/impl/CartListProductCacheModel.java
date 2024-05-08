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

import com.onlineshopping.product.service.model.CartListProduct;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CartListProduct in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CartListProductCacheModel
	implements CacheModel<CartListProduct>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CartListProductCacheModel)) {
			return false;
		}

		CartListProductCacheModel cartListProductCacheModel =
			(CartListProductCacheModel)object;

		if (id == cartListProductCacheModel.id) {
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

		sb.append("{id=");
		sb.append(id);
		sb.append(", cartListId=");
		sb.append(cartListId);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", size=");
		sb.append(size);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CartListProduct toEntityModel() {
		CartListProductImpl cartListProductImpl = new CartListProductImpl();

		cartListProductImpl.setId(id);
		cartListProductImpl.setCartListId(cartListId);
		cartListProductImpl.setProductId(productId);

		if (size == null) {
			cartListProductImpl.setSize("");
		}
		else {
			cartListProductImpl.setSize(size);
		}

		cartListProductImpl.setQuantity(quantity);

		if (createDate == Long.MIN_VALUE) {
			cartListProductImpl.setCreateDate(null);
		}
		else {
			cartListProductImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cartListProductImpl.setModifiedDate(null);
		}
		else {
			cartListProductImpl.setModifiedDate(new Date(modifiedDate));
		}

		cartListProductImpl.resetOriginalValues();

		return cartListProductImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		cartListId = objectInput.readLong();

		productId = objectInput.readLong();
		size = objectInput.readUTF();

		quantity = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(cartListId);

		objectOutput.writeLong(productId);

		if (size == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(size);
		}

		objectOutput.writeInt(quantity);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public long cartListId;
	public long productId;
	public String size;
	public int quantity;
	public long createDate;
	public long modifiedDate;

}