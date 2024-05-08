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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchProductException;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.model.impl.ProductImpl;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;
import com.onlineshopping.product.service.service.base.ProductLocalServiceBaseImpl;
import com.onlineshopping.product.service.service.constats.ShoppingContants;
import com.onlineshopping.product.service.service.constats.Status;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {

    public Product addProduct(String productName, String productInfo, String color, long ratingCount, double rating, long price, long discount, int discountPercentage, long finalPrice, String gender, long brandId, long highlightsId, int productCount) {
        Product product = getProductByDetails(productName, color, gender, brandId, highlightsId);
        if (Validator.isNotNull(product)) {
            _log.info("Product already exists");
            return product;
        }
        product = createProduct(counterLocalService.increment(Product.class.getName()));
        product.setProductName(productName);
        product.setProductInfo(productInfo);
        product.setColor(color);
        product.setRatingCount(ratingCount);
        product.setRating(rating);
        product.setPrice(price);
        product.setDiscount(discount);
        if (discountPercentage == 0 && discount >= 0 && price > 0) {
            double discountResult = ((double) discount / price) * 100;
            discountPercentage = (int) (Math.round(discountResult * 100.0) / 100.0);
        }
        product.setDiscountPercentage(discountPercentage);
        product.setFinalPrice(finalPrice);
        product.setGender(gender);
        product.setBrandId(brandId);
        product.setHighlightsId(highlightsId);
        if (productCount > 0) {
            product.setProductCount(productCount);
            product.setStatus(Status.AVAILABLE);
        }
        if (productCount < 0) {
            product.setProductCount(0);
            product.setStatus(Status.OUT_OF_STOCK);
        }
        _log.info("Product added to table");
        return addProduct(product);
    }

    public Product getProductByDetails(String productName, String color, String gender, long brandId, long highlightsId) {
        Product product = null;
        try {
            product = productPersistence.findByProductDetails(productName, color, gender, brandId, highlightsId);
        } catch (NoSuchProductException e) {
            _log.error(e.getMessage());
        }
        return product;
    }

    public Product updateProduct(long productId, String productName, String productInfo, String color, long ratingCount, double rating, long price, long discount, int discountPercentage, long finalPrice, int productCount) {
        Product product = fetchProduct(productId);
        product.setProductName(productName);
        product.setProductInfo(productInfo);
        product.setColor(color);
        product.setRatingCount(ratingCount);
        product.setRating(rating);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setDiscountPercentage(discountPercentage);
        product.setFinalPrice(finalPrice);
        product.setProductCount(productCount);
        product.setStatus(Status.AVAILABLE);
        return updateProduct(product);
    }

    public Product getProductById(long productId) {
        try {
            return getProduct(productId);
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
        return null;
    }


    public List<Product> getProductsByGender(String gender) {
        DynamicQuery dynamicQuery = ProductLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(PropertyFactoryUtil.forName(ShoppingContants.GENDER).eq(gender));
        List<Product> products = ProductLocalServiceUtil.dynamicQuery(dynamicQuery);
        return products;
    }

    public List<Product> getProductsByFiltering(String gender, String[] brands, String[] prices, String[] discounts) {
        Session session = productPersistence.openSession();
        SQLQuery query = session.createSQLQuery(getProductSqlQuery(gender, brands, prices, discounts));

        query.addEntity("Product", ProductImpl.class);
        return (List<Product>) query.list();
    }

    private String getProductSqlQuery(String gender, String[] brands, String[] prices, String[] discounts) {
        String query = "SELECT * FROM product_product p WHERE gender='[$INPUT$]' [$CONDITIONS$];";
        if (brands.length == 0 && prices.length == 0 && discounts.length == 0) {
            return "SELECT * FROM product_product WHERE gender LIKE '" + gender + "';";
        }
        StringBuilder conditions = new StringBuilder();
        if (brands.length != 0) {
            conditions.append("AND p.brandId IN (");
            int i = brands.length;
            for (String brand : brands) {
                conditions.append("'" + brand + "'");
                conditions.append(i > 1 ? (StringPool.COMMA + StringPool.SPACE) : StringPool.CLOSE_PARENTHESIS);
                i--;
            }
        }
        if (prices.length != 0) {
            conditions.append(" AND (p.finalPrice BETWEEN ");
            int j = prices.length;
            for (String price : prices) {
                conditions.append(price.replace(StringPool.DASH, " AND "));
                conditions.append(j > 1 ? " OR p.finalPrice BETWEEN " : StringPool.CLOSE_PARENTHESIS);
                j--;
            }
        }
        if (discounts.length != 0) {
            conditions.append(" AND (p.discountPercentage BETWEEN ");
            int k = discounts.length;
            for (String discount : discounts) {
                conditions.append(discount.replace(StringPool.DASH, " AND "));
                conditions.append(k > 1 ? " OR p.discountPercentage BETWEEN " : StringPool.CLOSE_PARENTHESIS);
                k--;
            }
        }
        query = query.replace("[$INPUT$]", gender);
        query = query.replace("[$CONDITIONS$]", conditions.toString());
        return query;

    }

    private static final Log _log = LogFactoryUtil.getLog(ProductLocalServiceImpl.class);

}