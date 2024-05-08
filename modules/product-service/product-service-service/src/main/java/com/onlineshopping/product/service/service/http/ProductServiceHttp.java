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

package com.onlineshopping.product.service.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.onlineshopping.product.service.service.ProductServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ProductServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductServiceSoap
 * @generated
 */
public class ProductServiceHttp {

	public static com.onlineshopping.product.service.model.Product addProduct(
		HttpPrincipal httpPrincipal, String productName, String productInfo,
		String color, long ratingCount, double rating, long price,
		long discount, int discountPercentage, long finalPrice, String gender,
		long brandId, long highlightsId, int productCount) {

		try {
			MethodKey methodKey = new MethodKey(
				ProductServiceUtil.class, "addProduct",
				_addProductParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productName, productInfo, color, ratingCount, rating,
				price, discount, discountPercentage, finalPrice, gender,
				brandId, highlightsId, productCount);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.onlineshopping.product.service.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.onlineshopping.product.service.model.Product
		updateProduct(
			HttpPrincipal httpPrincipal, long productId, String productName,
			String productInfo, String color, long ratingCount, double rating,
			long price, long discount, int discountPercentage, long finalPrice,
			int productCount) {

		try {
			MethodKey methodKey = new MethodKey(
				ProductServiceUtil.class, "updateProduct",
				_updateProductParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, productId, productName, productInfo, color,
				ratingCount, rating, price, discount, discountPercentage,
				finalPrice, productCount);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.onlineshopping.product.service.model.Product)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.onlineshopping.product.service.model.Product> getProductsByGender(
			HttpPrincipal httpPrincipal, String gender) {

		try {
			MethodKey methodKey = new MethodKey(
				ProductServiceUtil.class, "getProductsByGender",
				_getProductsByGenderParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, gender);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.onlineshopping.product.service.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.onlineshopping.product.service.model.Product>
			getProductsByFiltering(
				HttpPrincipal httpPrincipal, String gender, String[] brands,
				String[] prices, String[] discounts) {

		try {
			MethodKey methodKey = new MethodKey(
				ProductServiceUtil.class, "getProductsByFiltering",
				_getProductsByFilteringParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, gender, brands, prices, discounts);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.onlineshopping.product.service.model.Product>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProductServiceHttp.class);

	private static final Class<?>[] _addProductParameterTypes0 = new Class[] {
		String.class, String.class, String.class, long.class, double.class,
		long.class, long.class, int.class, long.class, String.class, long.class,
		long.class, int.class
	};
	private static final Class<?>[] _updateProductParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, String.class, long.class,
			double.class, long.class, long.class, int.class, long.class,
			int.class
		};
	private static final Class<?>[] _getProductsByGenderParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _getProductsByFilteringParameterTypes3 =
		new Class[] {
			String.class, String[].class, String[].class, String[].class
		};

}