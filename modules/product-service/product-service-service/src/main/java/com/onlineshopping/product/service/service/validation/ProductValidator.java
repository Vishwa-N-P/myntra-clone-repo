package com.onlineshopping.product.service.service.validation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.service.ProductLocalServiceUtil;

public class ProductValidator {

    public static boolean isProductPresent(long productId) {
        Product product = ProductLocalServiceUtil.getProductById(productId);
        if (productId <= 0 || Validator.isNull(product)) {
            _log.error("Invalid product Id");
            return false;
        }
        return true;
    }

    public static boolean isProductExists(String productName, String color, String gender,  long brandId, long highlightsId) {
        Product product = ProductLocalServiceUtil.getProductByDetails(productName, color, gender, brandId, highlightsId);
        if (Validator.isNotNull(product)) {
            _log.error("Product already exists");
            return true;
        }
        return false;
    }

    private static final Log _log = LogFactoryUtil.getLog(ProductValidator.class);


}
