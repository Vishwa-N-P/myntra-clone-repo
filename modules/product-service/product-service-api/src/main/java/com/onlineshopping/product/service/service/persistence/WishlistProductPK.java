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

package com.onlineshopping.product.service.service.persistence;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WishlistProductPK
	implements Comparable<WishlistProductPK>, Serializable {

	public long wishlistId;
	public long productId;

	public WishlistProductPK() {
	}

	public WishlistProductPK(long wishlistId, long productId) {
		this.wishlistId = wishlistId;
		this.productId = productId;
	}

	public long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public int compareTo(WishlistProductPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (wishlistId < pk.wishlistId) {
			value = -1;
		}
		else if (wishlistId > pk.wishlistId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (productId < pk.productId) {
			value = -1;
		}
		else if (productId > pk.productId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WishlistProductPK)) {
			return false;
		}

		WishlistProductPK pk = (WishlistProductPK)object;

		if ((wishlistId == pk.wishlistId) && (productId == pk.productId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, wishlistId);
		hashCode = HashUtil.hash(hashCode, productId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("wishlistId=");

		sb.append(wishlistId);
		sb.append(", productId=");

		sb.append(productId);

		sb.append("}");

		return sb.toString();
	}

}