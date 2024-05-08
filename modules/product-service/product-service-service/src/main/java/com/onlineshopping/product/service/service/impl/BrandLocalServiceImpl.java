/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.onlineshopping.product.service.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchBrandException;
import com.onlineshopping.product.service.model.Brand;
import com.onlineshopping.product.service.service.BrandLocalServiceUtil;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;
import com.onlineshopping.product.service.service.base.BrandLocalServiceBaseImpl;
import com.onlineshopping.product.service.service.constats.ShoppingContants;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class BrandLocalServiceImpl extends BrandLocalServiceBaseImpl {

    public Brand addProductBrand(String brandName) {
        Brand brand = getBrandByName(brandName);
        if (Validator.isNotNull(brand)) {
            return brand;
        }
        brand = createBrand(counterLocalService.increment(Brand.class.getName()));
        if (brandName != null) {
            brand.setBrandName(brandName);
        }
        return addBrand(brand);
    }

    public List<Long> getProductBrands(String gender) {
        DynamicQuery dynamicQuery = ProductLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(PropertyFactoryUtil.forName(ShoppingContants.GENDER).eq(gender));
        dynamicQuery.setProjection(ProjectionFactoryUtil.projectionList().add(ProjectionFactoryUtil.property(ShoppingContants.BRAND_ID)));
        List<Long> brandIds = ProductLocalServiceUtil.dynamicQuery(dynamicQuery);
        return brandIds;
    }

    public Brand getProductBrand(long brandId) {
        try {
            return BrandLocalServiceUtil.getBrand(brandId);
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
        return null;
    }

    public Brand getBrandByName(String brandName) {
        Brand brand = null;
        try {
            brand = brandPersistence.findByBrandName(brandName);
        } catch (NoSuchBrandException e) {
            _log.error(e.getMessage());
        }
        return brand;
    }

    private static final Log _log = LogFactoryUtil.getLog(BrandLocalServiceImpl.class);

}