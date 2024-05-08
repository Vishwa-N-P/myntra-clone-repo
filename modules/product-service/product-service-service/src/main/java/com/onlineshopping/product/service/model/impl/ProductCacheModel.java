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

import com.onlineshopping.product.service.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductCacheModel)) {
			return false;
		}

		ProductCacheModel productCacheModel = (ProductCacheModel)object;

		if (id == productCacheModel.id) {
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
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", productInfo=");
		sb.append(productInfo);
		sb.append(", color=");
		sb.append(color);
		sb.append(", ratingCount=");
		sb.append(ratingCount);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", price=");
		sb.append(price);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", discountPercentage=");
		sb.append(discountPercentage);
		sb.append(", finalPrice=");
		sb.append(finalPrice);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", brandId=");
		sb.append(brandId);
		sb.append(", highlightsId=");
		sb.append(highlightsId);
		sb.append(", productCount=");
		sb.append(productCount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		if (uuid == null) {
			productImpl.setUuid("");
		}
		else {
			productImpl.setUuid(uuid);
		}

		productImpl.setId(id);

		if (productName == null) {
			productImpl.setProductName("");
		}
		else {
			productImpl.setProductName(productName);
		}

		if (productInfo == null) {
			productImpl.setProductInfo("");
		}
		else {
			productImpl.setProductInfo(productInfo);
		}

		if (color == null) {
			productImpl.setColor("");
		}
		else {
			productImpl.setColor(color);
		}

		productImpl.setRatingCount(ratingCount);
		productImpl.setRating(rating);
		productImpl.setPrice(price);
		productImpl.setDiscount(discount);
		productImpl.setDiscountPercentage(discountPercentage);
		productImpl.setFinalPrice(finalPrice);

		if (gender == null) {
			productImpl.setGender("");
		}
		else {
			productImpl.setGender(gender);
		}

		productImpl.setBrandId(brandId);
		productImpl.setHighlightsId(highlightsId);
		productImpl.setProductCount(productCount);
		productImpl.setStatus(status);

		if (createDate == Long.MIN_VALUE) {
			productImpl.setCreateDate(null);
		}
		else {
			productImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productImpl.setModifiedDate(null);
		}
		else {
			productImpl.setModifiedDate(new Date(modifiedDate));
		}

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		productName = objectInput.readUTF();
		productInfo = objectInput.readUTF();
		color = objectInput.readUTF();

		ratingCount = objectInput.readLong();

		rating = objectInput.readDouble();

		price = objectInput.readLong();

		discount = objectInput.readLong();

		discountPercentage = objectInput.readInt();

		finalPrice = objectInput.readLong();
		gender = objectInput.readUTF();

		brandId = objectInput.readLong();

		highlightsId = objectInput.readLong();

		productCount = objectInput.readInt();

		status = objectInput.readInt();
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

		if (productName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (productInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productInfo);
		}

		if (color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(color);
		}

		objectOutput.writeLong(ratingCount);

		objectOutput.writeDouble(rating);

		objectOutput.writeLong(price);

		objectOutput.writeLong(discount);

		objectOutput.writeInt(discountPercentage);

		objectOutput.writeLong(finalPrice);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(brandId);

		objectOutput.writeLong(highlightsId);

		objectOutput.writeInt(productCount);

		objectOutput.writeInt(status);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public String productName;
	public String productInfo;
	public String color;
	public long ratingCount;
	public double rating;
	public long price;
	public long discount;
	public int discountPercentage;
	public long finalPrice;
	public String gender;
	public long brandId;
	public long highlightsId;
	public int productCount;
	public int status;
	public long createDate;
	public long modifiedDate;

}