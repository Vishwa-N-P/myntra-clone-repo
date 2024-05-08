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

package com.onlineshopping.product.service.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import com.onlineshopping.product.service.model.Product;
import com.onlineshopping.product.service.model.ProductModel;
import com.onlineshopping.product.service.model.ProductSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Product service. Represents a row in the &quot;Product_Product&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProductModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductImpl
 * @generated
 */
@JSON(strict = true)
public class ProductModelImpl
	extends BaseModelImpl<Product> implements ProductModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product model instance should use the <code>Product</code> interface instead.
	 */
	public static final String TABLE_NAME = "Product_Product";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"productName", Types.VARCHAR}, {"productInfo", Types.VARCHAR},
		{"color", Types.VARCHAR}, {"ratingCount", Types.BIGINT},
		{"rating", Types.DOUBLE}, {"price", Types.BIGINT},
		{"discount", Types.BIGINT}, {"discountPercentage", Types.INTEGER},
		{"finalPrice", Types.BIGINT}, {"gender", Types.VARCHAR},
		{"brandId", Types.BIGINT}, {"highlightsId", Types.BIGINT},
		{"productCount", Types.INTEGER}, {"status", Types.INTEGER},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("productName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productInfo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("color", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ratingCount", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rating", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("price", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("discount", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("discountPercentage", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("finalPrice", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("brandId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("highlightsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("productCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Product_Product (uuid_ VARCHAR(75) null,id_ LONG not null primary key,productName VARCHAR(75) null,productInfo VARCHAR(75) null,color VARCHAR(75) null,ratingCount LONG,rating DOUBLE,price LONG,discount LONG,discountPercentage INTEGER,finalPrice LONG,gender VARCHAR(75) null,brandId LONG,highlightsId LONG,productCount INTEGER,status INTEGER,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Product_Product";

	public static final String ORDER_BY_JPQL = " ORDER BY product.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Product_Product.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.onlineshopping.product.service.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.onlineshopping.product.service.model.Product"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.onlineshopping.product.service.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.onlineshopping.product.service.model.Product"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.onlineshopping.product.service.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.onlineshopping.product.service.model.Product"),
		true);

	public static final long BRANDID_COLUMN_BITMASK = 1L;

	public static final long COLOR_COLUMN_BITMASK = 2L;

	public static final long GENDER_COLUMN_BITMASK = 4L;

	public static final long HIGHLIGHTSID_COLUMN_BITMASK = 8L;

	public static final long PRODUCTNAME_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long ID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Product toModel(ProductSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Product model = new ProductImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setProductName(soapModel.getProductName());
		model.setProductInfo(soapModel.getProductInfo());
		model.setColor(soapModel.getColor());
		model.setRatingCount(soapModel.getRatingCount());
		model.setRating(soapModel.getRating());
		model.setPrice(soapModel.getPrice());
		model.setDiscount(soapModel.getDiscount());
		model.setDiscountPercentage(soapModel.getDiscountPercentage());
		model.setFinalPrice(soapModel.getFinalPrice());
		model.setGender(soapModel.getGender());
		model.setBrandId(soapModel.getBrandId());
		model.setHighlightsId(soapModel.getHighlightsId());
		model.setProductCount(soapModel.getProductCount());
		model.setStatus(soapModel.getStatus());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Product> toModels(ProductSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Product> models = new ArrayList<Product>(soapModels.length);

		for (ProductSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.onlineshopping.product.service.service.util.ServiceProps.get(
			"lock.expiration.time.com.onlineshopping.product.service.model.Product"));

	public ProductModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Product, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Product, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Product, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Product)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Product, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Product, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Product)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Product, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Product, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Product>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Product.class.getClassLoader(), Product.class, ModelWrapper.class);

		try {
			Constructor<Product> constructor =
				(Constructor<Product>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Product, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Product, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Product, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Product, Object>>();
		Map<String, BiConsumer<Product, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Product, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object uuidObject) {
					product.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"id",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object idObject) {
					product.setId((Long)idObject);
				}

			});
		attributeGetterFunctions.put(
			"productName",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getProductName();
				}

			});
		attributeSetterBiConsumers.put(
			"productName",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object productNameObject) {
					product.setProductName((String)productNameObject);
				}

			});
		attributeGetterFunctions.put(
			"productInfo",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getProductInfo();
				}

			});
		attributeSetterBiConsumers.put(
			"productInfo",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object productInfoObject) {
					product.setProductInfo((String)productInfoObject);
				}

			});
		attributeGetterFunctions.put(
			"color",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getColor();
				}

			});
		attributeSetterBiConsumers.put(
			"color",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object colorObject) {
					product.setColor((String)colorObject);
				}

			});
		attributeGetterFunctions.put(
			"ratingCount",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getRatingCount();
				}

			});
		attributeSetterBiConsumers.put(
			"ratingCount",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object ratingCountObject) {
					product.setRatingCount((Long)ratingCountObject);
				}

			});
		attributeGetterFunctions.put(
			"rating",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getRating();
				}

			});
		attributeSetterBiConsumers.put(
			"rating",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object ratingObject) {
					product.setRating((Double)ratingObject);
				}

			});
		attributeGetterFunctions.put(
			"price",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getPrice();
				}

			});
		attributeSetterBiConsumers.put(
			"price",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object priceObject) {
					product.setPrice((Long)priceObject);
				}

			});
		attributeGetterFunctions.put(
			"discount",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getDiscount();
				}

			});
		attributeSetterBiConsumers.put(
			"discount",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object discountObject) {
					product.setDiscount((Long)discountObject);
				}

			});
		attributeGetterFunctions.put(
			"discountPercentage",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getDiscountPercentage();
				}

			});
		attributeSetterBiConsumers.put(
			"discountPercentage",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(
					Product product, Object discountPercentageObject) {

					product.setDiscountPercentage(
						(Integer)discountPercentageObject);
				}

			});
		attributeGetterFunctions.put(
			"finalPrice",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getFinalPrice();
				}

			});
		attributeSetterBiConsumers.put(
			"finalPrice",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object finalPriceObject) {
					product.setFinalPrice((Long)finalPriceObject);
				}

			});
		attributeGetterFunctions.put(
			"gender",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getGender();
				}

			});
		attributeSetterBiConsumers.put(
			"gender",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object genderObject) {
					product.setGender((String)genderObject);
				}

			});
		attributeGetterFunctions.put(
			"brandId",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getBrandId();
				}

			});
		attributeSetterBiConsumers.put(
			"brandId",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object brandIdObject) {
					product.setBrandId((Long)brandIdObject);
				}

			});
		attributeGetterFunctions.put(
			"highlightsId",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getHighlightsId();
				}

			});
		attributeSetterBiConsumers.put(
			"highlightsId",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object highlightsIdObject) {
					product.setHighlightsId((Long)highlightsIdObject);
				}

			});
		attributeGetterFunctions.put(
			"productCount",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getProductCount();
				}

			});
		attributeSetterBiConsumers.put(
			"productCount",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object productCountObject) {
					product.setProductCount((Integer)productCountObject);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object statusObject) {
					product.setStatus((Integer)statusObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object createDateObject) {
					product.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Product, Object>() {

				@Override
				public Object apply(Product product) {
					return product.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Product, Object>() {

				@Override
				public void accept(Product product, Object modifiedDateObject) {
					product.setModifiedDate((Date)modifiedDateObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	@JSON
	@Override
	public String getProductName() {
		if (_productName == null) {
			return "";
		}
		else {
			return _productName;
		}
	}

	@Override
	public void setProductName(String productName) {
		_columnBitmask |= PRODUCTNAME_COLUMN_BITMASK;

		if (_originalProductName == null) {
			_originalProductName = _productName;
		}

		_productName = productName;
	}

	public String getOriginalProductName() {
		return GetterUtil.getString(_originalProductName);
	}

	@JSON
	@Override
	public String getProductInfo() {
		if (_productInfo == null) {
			return "";
		}
		else {
			return _productInfo;
		}
	}

	@Override
	public void setProductInfo(String productInfo) {
		_productInfo = productInfo;
	}

	@JSON
	@Override
	public String getColor() {
		if (_color == null) {
			return "";
		}
		else {
			return _color;
		}
	}

	@Override
	public void setColor(String color) {
		_columnBitmask |= COLOR_COLUMN_BITMASK;

		if (_originalColor == null) {
			_originalColor = _color;
		}

		_color = color;
	}

	public String getOriginalColor() {
		return GetterUtil.getString(_originalColor);
	}

	@JSON
	@Override
	public long getRatingCount() {
		return _ratingCount;
	}

	@Override
	public void setRatingCount(long ratingCount) {
		_ratingCount = ratingCount;
	}

	@JSON
	@Override
	public double getRating() {
		return _rating;
	}

	@Override
	public void setRating(double rating) {
		_rating = rating;
	}

	@JSON
	@Override
	public long getPrice() {
		return _price;
	}

	@Override
	public void setPrice(long price) {
		_price = price;
	}

	@JSON
	@Override
	public long getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(long discount) {
		_discount = discount;
	}

	@JSON
	@Override
	public int getDiscountPercentage() {
		return _discountPercentage;
	}

	@Override
	public void setDiscountPercentage(int discountPercentage) {
		_discountPercentage = discountPercentage;
	}

	@JSON
	@Override
	public long getFinalPrice() {
		return _finalPrice;
	}

	@Override
	public void setFinalPrice(long finalPrice) {
		_finalPrice = finalPrice;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		_columnBitmask |= GENDER_COLUMN_BITMASK;

		if (_originalGender == null) {
			_originalGender = _gender;
		}

		_gender = gender;
	}

	public String getOriginalGender() {
		return GetterUtil.getString(_originalGender);
	}

	@JSON
	@Override
	public long getBrandId() {
		return _brandId;
	}

	@Override
	public void setBrandId(long brandId) {
		_columnBitmask |= BRANDID_COLUMN_BITMASK;

		if (!_setOriginalBrandId) {
			_setOriginalBrandId = true;

			_originalBrandId = _brandId;
		}

		_brandId = brandId;
	}

	public long getOriginalBrandId() {
		return _originalBrandId;
	}

	@JSON
	@Override
	public long getHighlightsId() {
		return _highlightsId;
	}

	@Override
	public void setHighlightsId(long highlightsId) {
		_columnBitmask |= HIGHLIGHTSID_COLUMN_BITMASK;

		if (!_setOriginalHighlightsId) {
			_setOriginalHighlightsId = true;

			_originalHighlightsId = _highlightsId;
		}

		_highlightsId = highlightsId;
	}

	public long getOriginalHighlightsId() {
		return _originalHighlightsId;
	}

	@JSON
	@Override
	public int getProductCount() {
		return _productCount;
	}

	@Override
	public void setProductCount(int productCount) {
		_productCount = productCount;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Product.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Product toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Product>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setUuid(getUuid());
		productImpl.setId(getId());
		productImpl.setProductName(getProductName());
		productImpl.setProductInfo(getProductInfo());
		productImpl.setColor(getColor());
		productImpl.setRatingCount(getRatingCount());
		productImpl.setRating(getRating());
		productImpl.setPrice(getPrice());
		productImpl.setDiscount(getDiscount());
		productImpl.setDiscountPercentage(getDiscountPercentage());
		productImpl.setFinalPrice(getFinalPrice());
		productImpl.setGender(getGender());
		productImpl.setBrandId(getBrandId());
		productImpl.setHighlightsId(getHighlightsId());
		productImpl.setProductCount(getProductCount());
		productImpl.setStatus(getStatus());
		productImpl.setCreateDate(getCreateDate());
		productImpl.setModifiedDate(getModifiedDate());

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public int compareTo(Product product) {
		int value = 0;

		if (getId() < product.getId()) {
			value = -1;
		}
		else if (getId() > product.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Product)) {
			return false;
		}

		Product product = (Product)object;

		long primaryKey = product.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalProductName = _productName;

		_originalColor = _color;

		_originalGender = _gender;

		_originalBrandId = _brandId;

		_setOriginalBrandId = false;

		_originalHighlightsId = _highlightsId;

		_setOriginalHighlightsId = false;

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Product> toCacheModel() {
		ProductCacheModel productCacheModel = new ProductCacheModel();

		productCacheModel.uuid = getUuid();

		String uuid = productCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			productCacheModel.uuid = null;
		}

		productCacheModel.id = getId();

		productCacheModel.productName = getProductName();

		String productName = productCacheModel.productName;

		if ((productName != null) && (productName.length() == 0)) {
			productCacheModel.productName = null;
		}

		productCacheModel.productInfo = getProductInfo();

		String productInfo = productCacheModel.productInfo;

		if ((productInfo != null) && (productInfo.length() == 0)) {
			productCacheModel.productInfo = null;
		}

		productCacheModel.color = getColor();

		String color = productCacheModel.color;

		if ((color != null) && (color.length() == 0)) {
			productCacheModel.color = null;
		}

		productCacheModel.ratingCount = getRatingCount();

		productCacheModel.rating = getRating();

		productCacheModel.price = getPrice();

		productCacheModel.discount = getDiscount();

		productCacheModel.discountPercentage = getDiscountPercentage();

		productCacheModel.finalPrice = getFinalPrice();

		productCacheModel.gender = getGender();

		String gender = productCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			productCacheModel.gender = null;
		}

		productCacheModel.brandId = getBrandId();

		productCacheModel.highlightsId = getHighlightsId();

		productCacheModel.productCount = getProductCount();

		productCacheModel.status = getStatus();

		Date createDate = getCreateDate();

		if (createDate != null) {
			productCacheModel.createDate = createDate.getTime();
		}
		else {
			productCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			productCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return productCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Product, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Product, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Product, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Product)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Product, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Product, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Product, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Product)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Product>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _productName;
	private String _originalProductName;
	private String _productInfo;
	private String _color;
	private String _originalColor;
	private long _ratingCount;
	private double _rating;
	private long _price;
	private long _discount;
	private int _discountPercentage;
	private long _finalPrice;
	private String _gender;
	private String _originalGender;
	private long _brandId;
	private long _originalBrandId;
	private boolean _setOriginalBrandId;
	private long _highlightsId;
	private long _originalHighlightsId;
	private boolean _setOriginalHighlightsId;
	private int _productCount;
	private int _status;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Product _escapedModel;

}