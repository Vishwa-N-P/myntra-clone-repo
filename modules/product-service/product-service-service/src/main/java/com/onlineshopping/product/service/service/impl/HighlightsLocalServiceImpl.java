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

package com.onlineshopping.product.service.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchHighlightsException;
import com.onlineshopping.product.service.model.Highlights;
import com.onlineshopping.product.service.service.base.HighlightsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
public class HighlightsLocalServiceImpl extends HighlightsLocalServiceBaseImpl {

    public Highlights addProductHighlights(String features, String size) {

        Highlights highlights = null;
        if (features != null && size != null) {
            highlights = getHighlightsByDetails(features, size);
        }

        if (Validator.isNotNull(highlights)) {
            _log.info("Highlights already exists");
            return highlights;
        }
        highlights = createHighlights(counterLocalService.increment(Highlights.class.getName()));
        highlights.setFeatures(features);
        highlights.setSize(size);
        return addHighlights(highlights);
    }

    public Highlights getHighlightsByDetails(String features, String size) {
        Highlights highlights = null;
        try {
            highlights = highlightsPersistence.findByFeaturesAndSize(features, size);
        } catch (NoSuchHighlightsException e) {
            _log.error(e.getMessage());
        }
        return highlights;
    }

    public Highlights updateHighlights(long highlightsId, String features, String size) {
        Highlights highlights = getHighlightsById(highlightsId);
        if (highlightsId <= 0 || Validator.isNull(highlights)) {
            _log.error("Invalid highlights Id");
            return null;
        }

        if (features != null && size != null) {
            highlights = getHighlightsByDetails(features, size);
        }

        if (Validator.isNotNull(highlights)) {
            _log.error("Highlights already exists");
            return highlights;
        }

        highlights.setFeatures(features);
        highlights.setSize(size);
        return updateHighlights(highlights);
    }

    public Highlights getHighlightsById(long highlightsId) {
        Highlights highlights = null;
        try {
            highlights = getHighlights(highlightsId);
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
        return highlights;
    }

    public static final Log _log = LogFactoryUtil.getLog(HighlightsLocalServiceImpl.class);

}