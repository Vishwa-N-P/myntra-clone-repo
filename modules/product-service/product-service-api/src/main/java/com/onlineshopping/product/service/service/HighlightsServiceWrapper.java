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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HighlightsService}.
 *
 * @author Brian Wing Shun Chan
 * @see HighlightsService
 * @generated
 */
public class HighlightsServiceWrapper
	implements HighlightsService, ServiceWrapper<HighlightsService> {

	public HighlightsServiceWrapper(HighlightsService highlightsService) {
		_highlightsService = highlightsService;
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights
		addProductHighlights(String features, String size) {

		return _highlightsService.addProductHighlights(features, size);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _highlightsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights updateHighlights(
		long highlightsId, String features, String size) {

		return _highlightsService.updateHighlights(
			highlightsId, features, size);
	}

	@Override
	public HighlightsService getWrappedService() {
		return _highlightsService;
	}

	@Override
	public void setWrappedService(HighlightsService highlightsService) {
		_highlightsService = highlightsService;
	}

	private HighlightsService _highlightsService;

}