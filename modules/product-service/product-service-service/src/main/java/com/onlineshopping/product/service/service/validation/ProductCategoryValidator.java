package com.onlineshopping.product.service.service.validation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.ProductCategory;
import com.onlineshopping.product.service.service.ProductCategoryLocalServiceUtil;

public class ProductCategoryValidator {

    public static boolean isCategoryNameExists(String categoryName) {
        ProductCategory productCategory = ProductCategoryLocalServiceUtil.getProductCategoryByName(categoryName);
        if (Validator.isNotNull(productCategory)){
            _log.error("Product category already exists");
            return true;
        }
        return false;
    }

    public static boolean isProductCategoryPresent(long categoryId) {
        ProductCategory productCategory = ProductCategoryLocalServiceUtil.getProductCategoryById(categoryId);
        if (categoryId <= 0 || Validator.isNull(productCategory)) {
            _log.error("Invalid category Id");
            return false;
        }
        return false;
    }

    public static Log _log = LogFactoryUtil.getLog(ProductCategoryValidator.class);


}
