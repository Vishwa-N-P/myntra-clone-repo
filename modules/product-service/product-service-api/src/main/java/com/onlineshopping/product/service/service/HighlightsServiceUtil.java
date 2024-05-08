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

package com.onlineshopping.product.service.service;

import com.onlineshopping.product.service.model.Highlights;

/**
 * Provides the remote service utility for Highlights. This utility wraps
 * <code>com.onlineshopping.product.service.service.impl.HighlightsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see HighlightsService
 * @generated
 */
public class HighlightsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.onlineshopping.product.service.service.impl.HighlightsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Highlights addProductHighlights(
		String features, String size) {

		return getService().addProductHighlights(features, size);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Highlights updateHighlights(
		long highlightsId, String features, String size) {

		return getService().updateHighlights(highlightsId, features, size);
	}

	public static HighlightsService getService() {
		return _service;
	}

	private static volatile HighlightsService _service;

}