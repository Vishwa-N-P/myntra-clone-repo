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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WishlistProduct service. Represents a row in the &quot;Product_WishlistProduct&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.onlineshopping.product.service.model.impl.WishlistProductModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.onlineshopping.product.service.model.impl.WishlistProductImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WishlistProduct
 * @generated
 */
@ProviderType
public interface WishlistProductModel extends BaseModel<WishlistProduct> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a wishlist product model instance should use the {@link WishlistProduct} interface instead.
	 */

	/**
	 * Returns the primary key of this wishlist product.
	 *
	 * @return the primary key of this wishlist product
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this wishlist product.
	 *
	 * @param primaryKey the primary key of this wishlist product
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this wishlist product.
	 *
	 * @return the ID of this wishlist product
	 */
	public long getId();

	/**
	 * Sets the ID of this wishlist product.
	 *
	 * @param id the ID of this wishlist product
	 */
	public void setId(long id);

	/**
	 * Returns the wishlist ID of this wishlist product.
	 *
	 * @return the wishlist ID of this wishlist product
	 */
	public long getWishlistId();

	/**
	 * Sets the wishlist ID of this wishlist product.
	 *
	 * @param wishlistId the wishlist ID of this wishlist product
	 */
	public void setWishlistId(long wishlistId);

	/**
	 * Returns the product ID of this wishlist product.
	 *
	 * @return the product ID of this wishlist product
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this wishlist product.
	 *
	 * @param productId the product ID of this wishlist product
	 */
	public void setProductId(long productId);

	/**
	 * Returns the create date of this wishlist product.
	 *
	 * @return the create date of this wishlist product
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this wishlist product.
	 *
	 * @param createDate the create date of this wishlist product
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this wishlist product.
	 *
	 * @return the modified date of this wishlist product
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this wishlist product.
	 *
	 * @param modifiedDate the modified date of this wishlist product
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(WishlistProduct wishlistProduct);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WishlistProduct> toCacheModel();

	@Override
	public WishlistProduct toEscapedModel();

	@Override
	public WishlistProduct toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}