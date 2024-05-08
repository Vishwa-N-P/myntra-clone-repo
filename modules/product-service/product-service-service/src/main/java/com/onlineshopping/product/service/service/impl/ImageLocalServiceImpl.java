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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.exception.NoSuchImageException;
import com.onlineshopping.product.service.model.Image;
import com.onlineshopping.product.service.service.base.ImageLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ImageLocalServiceImpl extends ImageLocalServiceBaseImpl {

    public Image addProductImage(String view, String imageUrl, long productId) {

        Image image = null;
        if (imageUrl != null) {
            image = getImageByUrlAndProductId(imageUrl, productId);
        }

        if (Validator.isNotNull(image)) {
            _log.info("Image already exists");
            return null;
        }
        image = createImage(counterLocalService.increment(Image.class.getName()));
        image.setView(view);
        image.setImageUrl(imageUrl);
        image.setProductId(productId);
        _log.info(view + " : Image added to table");
        return addImage(image);
    }

    public List<Image> getProductImages(long productId) {
        List<Image> images = imagePersistence.findByProductId(productId);
        return images;
    }

    public Image getImageByUrlAndProductId(String imageUrl, long productId) {
        Image image = null;

            try {
                image = imagePersistence.findByImageUrlProductId(imageUrl, productId);
            } catch (com.onlineshopping.product.service.exception.NoSuchImageException e) {
                _log.error(e.getMessage());
            }

        return image;
    }

    private static final Log _log = LogFactoryUtil.getLog(ImageLocalServiceImpl.class);

}