package com.onlineshopping.product.service.service.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.*;
import com.onlineshopping.product.service.service.*;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Component(immediate = true)
public class OnlineShoppingUtility {

    public static void addProductsData(String filePath) {

        try {
            File file = new File(filePath);
            ObjectMapper objectMapper = getObjectMapper();

            JsonNode productsNode = objectMapper.readTree(file);

            if (productsNode.isArray()) {
                for (JsonNode productNode : productsNode) {
                    String productName = productNode.get("productName").asText();
                    String productInfo = productNode.get("additionalInfo").asText();
                    String color = productNode.get("primaryColour").asText();
                    long ratingCount = productNode.get("ratingCount").asLong();
                    double rating = productNode.get("rating").asDouble();
                    long price = productNode.get("mrp").asLong();
                    long discount = productNode.get("discount").asLong();
                    int discountPercentage = 0;
//                    try {
//                        discountPercentage = Integer.parseInt(productNode.get("discountDisplayLabel").asText().substring(1, 3));
//                    } catch (NumberFormatException e) {
//                        _log.error(e.getMessage());
//                    }
                    long finalPrice = productNode.get("price").asLong();
                    String gender = productNode.get("gender").asText();
                    String brand = productNode.get("brand").asText();
                    int productCount = ThreadLocalRandom.current().nextInt(20, 41);
                    String size = productNode.get("sizes").asText();

                    if (Validator.isNotNull(gender)) {
                        ProductCategoryLocalServiceUtil.addProductCategory(gender);
                    }

                    Brand savedBrand = BrandLocalServiceUtil.addProductBrand(brand);
                    Highlights highlights = HighlightsLocalServiceUtil.addProductHighlights("Regular fit, Made of 100% Cotton, Machine-wash Acceptable", size);

                    Product product = ProductLocalServiceUtil.addProduct(productName, productInfo, color, ratingCount, rating, price, discount, discountPercentage, finalPrice, gender, savedBrand.getId(), highlights.getId(), productCount);

                    JsonNode imagesNode = productNode.get("images");
                    if (imagesNode.isArray()) {
                        for (JsonNode imageNode : imagesNode) {
                            String view = imageNode.get("view").asText();
                            String imageUrl = imageNode.get("src").asText();
                            if (imageUrl == null || imageUrl.isEmpty()) {
                                continue;
                            }
                            ImageLocalServiceUtil.addProductImage(view, imageUrl, product.getId());
                        }
                    }

                }
            }
        } catch (IOException e) {
            _log.error(e.getMessage());
        }
    }

    public static ThemeDisplay getThemeDisplayFromRequest(PortletRequest portletRequest) {
        ServiceContext serviceContext = null;
        try {
            serviceContext = ServiceContextFactory.getInstance(portletRequest);
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }

        ThemeDisplay themeDisplay = null;
        if (Validator.isNotNull(serviceContext)) {
            themeDisplay = serviceContext.getThemeDisplay();
        }

        return themeDisplay;
    }

    public static List<JSONObject> getJsonProductsList(List<CartListProduct> cartListProducts) {
        List<JSONObject> productsList = new ArrayList<>();
        for (CartListProduct cartListProduct : cartListProducts) {
            Product product = ProductLocalServiceUtil.getProductById(cartListProduct.getProductId());
            Brand brand = BrandLocalServiceUtil.getProductBrand(product.getBrandId());
            String image = getSingleImage(product.getId());

            JSONObject jsonProduct = JSONFactoryUtil.createJSONObject();
            jsonProduct.put("product", product);
            jsonProduct.put("image", image);
            jsonProduct.put("brand", Validator.isNotNull(brand) ? brand.getBrandName() : "");
            jsonProduct.put("size", cartListProduct.getSize());

            productsList.add(jsonProduct);
        }
        return productsList;
    }

    public static List<JSONObject> getJsonWishlistProductsList(List<Long> wishlistProducts) {
        List<JSONObject> productsList = new ArrayList<>();
        for (long wishlistProductId : wishlistProducts) {
            Product product = ProductLocalServiceUtil.getProductById(wishlistProductId);
            String image = getSingleImage(product.getId());
            Highlights highlights = HighlightsLocalServiceUtil.getHighlightsById(product.getHighlightsId());

            JSONObject jsonProduct = JSONFactoryUtil.createJSONObject();
            jsonProduct.put("product", product);
            jsonProduct.put("image", image);
            jsonProduct.put("sizes", Validator.isNotNull(highlights) ? highlights.getSize() : "");

            productsList.add(jsonProduct);
        }
        return productsList;
    }

    public static PortletRequest getJsonProductsList(List<Product> products, PortletRequest portletRequest, String gender) {
        List<String> brands = new ArrayList<>();
        List<JSONObject> productsList = new ArrayList<>();

        if (Validator.isNull(products) || products.isEmpty()) {
            SessionErrors.add(portletRequest, "no-products-exists");
            portletRequest.setAttribute("gender", gender);
            return null;
        }

        for (Product product : products) {
            String brand = BrandLocalServiceUtil.getProductBrand(product.getBrandId()).getBrandName();
            String image = getSingleImage(product.getId());

            if (Validator.isNotNull(brand) && !brands.contains(brand)) {
                brands.add(brand);
            }

            JSONObject jsonProduct = JSONFactoryUtil.createJSONObject();
            jsonProduct.put("product", product);
            jsonProduct.put("image", image);
            jsonProduct.put("brand", Validator.isNotNull(brand) ? brand : "");
            productsList.add(jsonProduct);
        }
        portletRequest.setAttribute("productsList", productsList);
        portletRequest.setAttribute("brands", brands);
        portletRequest.setAttribute("gender", gender);

        return portletRequest;
    }

    public static String getSingleImage(long productId) {
        List<Image> images = ImageLocalServiceUtil.getProductImages(productId);
        return images.isEmpty() ? "" : images.get(0).getImageUrl();
    }

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper != null) {
            return objectMapper;
        }
        return new ObjectMapper();
    }

    private static final Log _log = LogFactoryUtil.getLog(OnlineShoppingUtility.class);

}

