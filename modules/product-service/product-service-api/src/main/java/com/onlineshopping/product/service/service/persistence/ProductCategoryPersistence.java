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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.onlineshopping.product.service.exception.NoSuchCategoryException;
import com.onlineshopping.product.service.model.ProductCategory;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the product category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductCategoryUtil
 * @generated
 */
@ProviderType
public interface ProductCategoryPersistence
	extends BasePersistence<ProductCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductCategoryUtil} to access the product category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ProductCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the product categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product categories
	 */
	public java.util.List<ProductCategory> findByUuid(String uuid);

	/**
	 * Returns a range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of matching product categories
	 */
	public java.util.List<ProductCategory> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product categories
	 */
	public java.util.List<ProductCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product categories
	 */
	public java.util.List<ProductCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	public ProductCategory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public ProductCategory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
			orderByComparator);

	/**
	 * Returns the last product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	public ProductCategory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last product category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public ProductCategory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
			orderByComparator);

	/**
	 * Returns the product categories before and after the current product category in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current product category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	public ProductCategory[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
				orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the product categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product categories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product category where categoryName = &#63; or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryName the category name
	 * @return the matching product category
	 * @throws NoSuchCategoryException if a matching product category could not be found
	 */
	public ProductCategory findByCategoryName(String categoryName)
		throws NoSuchCategoryException;

	/**
	 * Returns the product category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryName the category name
	 * @return the matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public ProductCategory fetchByCategoryName(String categoryName);

	/**
	 * Returns the product category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryName the category name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product category, or <code>null</code> if a matching product category could not be found
	 */
	public ProductCategory fetchByCategoryName(
		String categoryName, boolean useFinderCache);

	/**
	 * Removes the product category where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @return the product category that was removed
	 */
	public ProductCategory removeByCategoryName(String categoryName)
		throws NoSuchCategoryException;

	/**
	 * Returns the number of product categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching product categories
	 */
	public int countByCategoryName(String categoryName);

	/**
	 * Caches the product category in the entity cache if it is enabled.
	 *
	 * @param productCategory the product category
	 */
	public void cacheResult(ProductCategory productCategory);

	/**
	 * Caches the product categories in the entity cache if it is enabled.
	 *
	 * @param productCategories the product categories
	 */
	public void cacheResult(java.util.List<ProductCategory> productCategories);

	/**
	 * Creates a new product category with the primary key. Does not add the product category to the database.
	 *
	 * @param id the primary key for the new product category
	 * @return the new product category
	 */
	public ProductCategory create(long id);

	/**
	 * Removes the product category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the product category
	 * @return the product category that was removed
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	public ProductCategory remove(long id) throws NoSuchCategoryException;

	public ProductCategory updateImpl(ProductCategory productCategory);

	/**
	 * Returns the product category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param id the primary key of the product category
	 * @return the product category
	 * @throws NoSuchCategoryException if a product category with the primary key could not be found
	 */
	public ProductCategory findByPrimaryKey(long id)
		throws NoSuchCategoryException;

	/**
	 * Returns the product category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the product category
	 * @return the product category, or <code>null</code> if a product category with the primary key could not be found
	 */
	public ProductCategory fetchByPrimaryKey(long id);

	/**
	 * Returns all the product categories.
	 *
	 * @return the product categories
	 */
	public java.util.List<ProductCategory> findAll();

	/**
	 * Returns a range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @return the range of product categories
	 */
	public java.util.List<ProductCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product categories
	 */
	public java.util.List<ProductCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product categories
	 * @param end the upper bound of the range of product categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product categories
	 */
	public java.util.List<ProductCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product categories.
	 *
	 * @return the number of product categories
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}