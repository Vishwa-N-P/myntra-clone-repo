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

import com.onlineshopping.product.service.model.WishlistProduct;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WishlistProduct in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WishlistProductCacheModel
	implements CacheModel<WishlistProduct>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WishlistProductCacheModel)) {
			return false;
		}

		WishlistProductCacheModel wishlistProductCacheModel =
			(WishlistProductCacheModel)object;

		if (id == wishlistProductCacheModel.id) {
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

		sb.append("{id=");
		sb.append(id);
		sb.append(", wishlistId=");
		sb.append(wishlistId);
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
	public WishlistProduct toEntityModel() {
		WishlistProductImpl wishlistProductImpl = new WishlistProductImpl();

		wishlistProductImpl.setId(id);
		wishlistProductImpl.setWishlistId(wishlistId);
		wishlistProductImpl.setProductId(productId);

		if (createDate == Long.MIN_VALUE) {
			wishlistProductImpl.setCreateDate(null);
		}
		else {
			wishlistProductImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wishlistProductImpl.setModifiedDate(null);
		}
		else {
			wishlistProductImpl.setModifiedDate(new Date(modifiedDate));
		}

		wishlistProductImpl.resetOriginalValues();

		return wishlistProductImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		wishlistId = objectInput.readLong();

		productId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(wishlistId);

		objectOutput.writeLong(productId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public long wishlistId;
	public long productId;
	public long createDate;
	public long modifiedDate;

}