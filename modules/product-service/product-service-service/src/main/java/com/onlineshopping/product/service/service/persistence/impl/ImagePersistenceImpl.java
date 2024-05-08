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

package com.onlineshopping.product.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.onlineshopping.product.service.exception.NoSuchImageException;
import com.onlineshopping.product.service.model.Image;
import com.onlineshopping.product.service.model.impl.ImageImpl;
import com.onlineshopping.product.service.model.impl.ImageModelImpl;
import com.onlineshopping.product.service.service.persistence.ImagePersistence;
import com.onlineshopping.product.service.service.persistence.ImageUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ImagePersistenceImpl
	extends BasePersistenceImpl<Image> implements ImagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImageUtil</code> to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImageImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching images
	 */
	@Override
	public List<Image> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	@Override
	public List<Image> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	@Override
	public List<Image> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	@Override
	public List<Image> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Image> list = null;

		if (useFinderCache) {
			list = (List<Image>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Image image : list) {
					if (!uuid.equals(image.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IMAGE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Image>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByUuid_First(
			String uuid, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByUuid_First(uuid, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchImageException(sb.toString());
	}

	/**
	 * Returns the first image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByUuid_First(
		String uuid, OrderByComparator<Image> orderByComparator) {

		List<Image> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByUuid_Last(
			String uuid, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByUuid_Last(uuid, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchImageException(sb.toString());
	}

	/**
	 * Returns the last image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByUuid_Last(
		String uuid, OrderByComparator<Image> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Image> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the images before and after the current image in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current image
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		uuid = Objects.toString(uuid, "");

		Image image = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Image[] array = new ImageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, image, uuid, orderByComparator, true);

			array[1] = image;

			array[2] = getByUuid_PrevAndNext(
				session, image, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Image getByUuid_PrevAndNext(
		Session session, Image image, String uuid,
		OrderByComparator<Image> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IMAGE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(image)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Image> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Image image :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(image);
		}
	}

	/**
	 * Returns the number of images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching images
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMAGE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "image.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(image.uuid IS NULL OR image.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByProductId;
	private FinderPath _finderPathWithoutPaginationFindByProductId;
	private FinderPath _finderPathCountByProductId;

	/**
	 * Returns all the images where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching images
	 */
	@Override
	public List<Image> findByProductId(long productId) {
		return findByProductId(
			productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the images where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	@Override
	public List<Image> findByProductId(long productId, int start, int end) {
		return findByProductId(productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the images where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	@Override
	public List<Image> findByProductId(
		long productId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return findByProductId(productId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the images where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	@Override
	public List<Image> findByProductId(
		long productId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProductId;
				finderArgs = new Object[] {productId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProductId;
			finderArgs = new Object[] {
				productId, start, end, orderByComparator
			};
		}

		List<Image> list = null;

		if (useFinderCache) {
			list = (List<Image>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Image image : list) {
					if (productId != image.getProductId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IMAGE_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productId);

				list = (List<Image>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByProductId_First(
			long productId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByProductId_First(productId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productId=");
		sb.append(productId);

		sb.append("}");

		throw new NoSuchImageException(sb.toString());
	}

	/**
	 * Returns the first image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByProductId_First(
		long productId, OrderByComparator<Image> orderByComparator) {

		List<Image> list = findByProductId(productId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByProductId_Last(
			long productId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByProductId_Last(productId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productId=");
		sb.append(productId);

		sb.append("}");

		throw new NoSuchImageException(sb.toString());
	}

	/**
	 * Returns the last image in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByProductId_Last(
		long productId, OrderByComparator<Image> orderByComparator) {

		int count = countByProductId(productId);

		if (count == 0) {
			return null;
		}

		List<Image> list = findByProductId(
			productId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the images before and after the current image in the ordered set where productId = &#63;.
	 *
	 * @param id the primary key of the current image
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image[] findByProductId_PrevAndNext(
			long id, long productId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Image[] array = new ImageImpl[3];

			array[0] = getByProductId_PrevAndNext(
				session, image, productId, orderByComparator, true);

			array[1] = image;

			array[2] = getByProductId_PrevAndNext(
				session, image, productId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Image getByProductId_PrevAndNext(
		Session session, Image image, long productId,
		OrderByComparator<Image> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IMAGE_WHERE);

		sb.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(image)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Image> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the images where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 */
	@Override
	public void removeByProductId(long productId) {
		for (Image image :
				findByProductId(
					productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(image);
		}
	}

	/**
	 * Returns the number of images where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching images
	 */
	@Override
	public int countByProductId(long productId) {
		FinderPath finderPath = _finderPathCountByProductId;

		Object[] finderArgs = new Object[] {productId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IMAGE_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCTID_PRODUCTID_2 =
		"image.productId = ?";

	private FinderPath _finderPathFetchByImageUrlProductId;
	private FinderPath _finderPathCountByImageUrlProductId;

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByImageUrlProductId(String imageUrl, long productId)
		throws NoSuchImageException {

		Image image = fetchByImageUrlProductId(imageUrl, productId);

		if (image == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("imageUrl=");
			sb.append(imageUrl);

			sb.append(", productId=");
			sb.append(productId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchImageException(sb.toString());
		}

		return image;
	}

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByImageUrlProductId(String imageUrl, long productId) {
		return fetchByImageUrlProductId(imageUrl, productId, true);
	}

	/**
	 * Returns the image where imageUrl = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByImageUrlProductId(
		String imageUrl, long productId, boolean useFinderCache) {

		imageUrl = Objects.toString(imageUrl, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {imageUrl, productId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByImageUrlProductId, finderArgs, this);
		}

		if (result instanceof Image) {
			Image image = (Image)result;

			if (!Objects.equals(imageUrl, image.getImageUrl()) ||
				(productId != image.getProductId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_IMAGE_WHERE);

			boolean bindImageUrl = false;

			if (imageUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_IMAGEURLPRODUCTID_IMAGEURL_3);
			}
			else {
				bindImageUrl = true;

				sb.append(_FINDER_COLUMN_IMAGEURLPRODUCTID_IMAGEURL_2);
			}

			sb.append(_FINDER_COLUMN_IMAGEURLPRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindImageUrl) {
					queryPos.add(imageUrl);
				}

				queryPos.add(productId);

				List<Image> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByImageUrlProductId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {imageUrl, productId};
							}

							_log.warn(
								"ImagePersistenceImpl.fetchByImageUrlProductId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Image image = list.get(0);

					result = image;

					cacheResult(image);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByImageUrlProductId, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Image)result;
		}
	}

	/**
	 * Removes the image where imageUrl = &#63; and productId = &#63; from the database.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the image that was removed
	 */
	@Override
	public Image removeByImageUrlProductId(String imageUrl, long productId)
		throws NoSuchImageException {

		Image image = findByImageUrlProductId(imageUrl, productId);

		return remove(image);
	}

	/**
	 * Returns the number of images where imageUrl = &#63; and productId = &#63;.
	 *
	 * @param imageUrl the image url
	 * @param productId the product ID
	 * @return the number of matching images
	 */
	@Override
	public int countByImageUrlProductId(String imageUrl, long productId) {
		imageUrl = Objects.toString(imageUrl, "");

		FinderPath finderPath = _finderPathCountByImageUrlProductId;

		Object[] finderArgs = new Object[] {imageUrl, productId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IMAGE_WHERE);

			boolean bindImageUrl = false;

			if (imageUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_IMAGEURLPRODUCTID_IMAGEURL_3);
			}
			else {
				bindImageUrl = true;

				sb.append(_FINDER_COLUMN_IMAGEURLPRODUCTID_IMAGEURL_2);
			}

			sb.append(_FINDER_COLUMN_IMAGEURLPRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindImageUrl) {
					queryPos.add(imageUrl);
				}

				queryPos.add(productId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IMAGEURLPRODUCTID_IMAGEURL_2 =
		"image.imageUrl = ? AND ";

	private static final String _FINDER_COLUMN_IMAGEURLPRODUCTID_IMAGEURL_3 =
		"(image.imageUrl IS NULL OR image.imageUrl = '') AND ";

	private static final String _FINDER_COLUMN_IMAGEURLPRODUCTID_PRODUCTID_2 =
		"image.productId = ?";

	public ImagePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(Image.class);
	}

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	@Override
	public void cacheResult(Image image) {
		entityCache.putResult(
			ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
			image.getPrimaryKey(), image);

		finderCache.putResult(
			_finderPathFetchByImageUrlProductId,
			new Object[] {image.getImageUrl(), image.getProductId()}, image);

		image.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	@Override
	public void cacheResult(List<Image> images) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (images.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Image image : images) {
			if (entityCache.getResult(
					ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
					image.getPrimaryKey()) == null) {

				cacheResult(image);
			}
			else {
				image.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all images.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the image.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Image image) {
		entityCache.removeResult(
			ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
			image.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImageModelImpl)image, true);
	}

	@Override
	public void clearCache(List<Image> images) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Image image : images) {
			entityCache.removeResult(
				ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
				image.getPrimaryKey());

			clearUniqueFindersCache((ImageModelImpl)image, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ImageModelImpl imageModelImpl) {
		Object[] args = new Object[] {
			imageModelImpl.getImageUrl(), imageModelImpl.getProductId()
		};

		finderCache.putResult(
			_finderPathCountByImageUrlProductId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByImageUrlProductId, args, imageModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImageModelImpl imageModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				imageModelImpl.getImageUrl(), imageModelImpl.getProductId()
			};

			finderCache.removeResult(_finderPathCountByImageUrlProductId, args);
			finderCache.removeResult(_finderPathFetchByImageUrlProductId, args);
		}

		if ((imageModelImpl.getColumnBitmask() &
			 _finderPathFetchByImageUrlProductId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				imageModelImpl.getOriginalImageUrl(),
				imageModelImpl.getOriginalProductId()
			};

			finderCache.removeResult(_finderPathCountByImageUrlProductId, args);
			finderCache.removeResult(_finderPathFetchByImageUrlProductId, args);
		}
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param id the primary key for the new image
	 * @return the new image
	 */
	@Override
	public Image create(long id) {
		Image image = new ImageImpl();

		image.setNew(true);
		image.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		image.setUuid(uuid);

		return image;
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image remove(long id) throws NoSuchImageException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image remove(Serializable primaryKey) throws NoSuchImageException {
		Session session = null;

		try {
			session = openSession();

			Image image = (Image)session.get(ImageImpl.class, primaryKey);

			if (image == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(image);
		}
		catch (NoSuchImageException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Image removeImpl(Image image) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(image)) {
				image = (Image)session.get(
					ImageImpl.class, image.getPrimaryKeyObj());
			}

			if (image != null) {
				session.delete(image);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (image != null) {
			clearCache(image);
		}

		return image;
	}

	@Override
	public Image updateImpl(Image image) {
		boolean isNew = image.isNew();

		if (!(image instanceof ImageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(image.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(image);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in image proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Image implementation " +
					image.getClass());
		}

		ImageModelImpl imageModelImpl = (ImageModelImpl)image;

		if (Validator.isNull(image.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			image.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (image.getCreateDate() == null)) {
			if (serviceContext == null) {
				image.setCreateDate(date);
			}
			else {
				image.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!imageModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				image.setModifiedDate(date);
			}
			else {
				image.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(image);

				image.setNew(false);
			}
			else {
				image = (Image)session.merge(image);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImageModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {imageModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {imageModelImpl.getProductId()};

			finderCache.removeResult(_finderPathCountByProductId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProductId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((imageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {imageModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {imageModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((imageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProductId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					imageModelImpl.getOriginalProductId()
				};

				finderCache.removeResult(_finderPathCountByProductId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProductId, args);

				args = new Object[] {imageModelImpl.getProductId()};

				finderCache.removeResult(_finderPathCountByProductId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProductId, args);
			}
		}

		entityCache.putResult(
			ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
			image.getPrimaryKey(), image, false);

		clearUniqueFindersCache(imageModelImpl, false);
		cacheUniqueFindersCache(imageModelImpl);

		image.resetOriginalValues();

		return image;
	}

	/**
	 * Returns the image with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImageException {

		Image image = fetchByPrimaryKey(primaryKey);

		if (image == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return image;
	}

	/**
	 * Returns the image with the primary key or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param id the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image findByPrimaryKey(long id) throws NoSuchImageException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	@Override
	public Image fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Image image = (Image)serializable;

		if (image == null) {
			Session session = null;

			try {
				session = openSession();

				image = (Image)session.get(ImageImpl.class, primaryKey);

				if (image != null) {
					cacheResult(image);
				}
				else {
					entityCache.putResult(
						ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return image;
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	@Override
	public Image fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Image> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Image> map = new HashMap<Serializable, Image>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Image image = fetchByPrimaryKey(primaryKey);

			if (image != null) {
				map.put(primaryKey, image);
			}

			return map;
		}

		if ((databaseInMaxParameters > 0) &&
			(primaryKeys.size() > databaseInMaxParameters)) {

			Iterator<Serializable> iterator = primaryKeys.iterator();

			while (iterator.hasNext()) {
				Set<Serializable> page = new HashSet<>();

				for (int i = 0;
					 (i < databaseInMaxParameters) && iterator.hasNext(); i++) {

					page.add(iterator.next());
				}

				map.putAll(fetchByPrimaryKeys(page));
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Image)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			(uncachedPrimaryKeys.size() * 2) + 1);

		sb.append(_SQL_SELECT_IMAGE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (Image image : (List<Image>)query.list()) {
				map.put(image.getPrimaryKeyObj(), image);

				cacheResult(image);

				uncachedPrimaryKeys.remove(image.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ImageModelImpl.ENTITY_CACHE_ENABLED, ImageImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 */
	@Override
	public List<Image> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of images
	 */
	@Override
	public List<Image> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of images
	 */
	@Override
	public List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of images
	 */
	@Override
	public List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Image> list = null;

		if (useFinderCache) {
			list = (List<Image>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IMAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IMAGE;

				sql = sql.concat(ImageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Image>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the images from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Image image : findAll()) {
			remove(image);
		}
	}

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IMAGE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ImageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the image persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ImageModelImpl.UUID_COLUMN_BITMASK |
			ImageModelImpl.PRODUCTID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByProductId = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProductId = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProductId",
			new String[] {Long.class.getName()},
			ImageModelImpl.PRODUCTID_COLUMN_BITMASK);

		_finderPathCountByProductId = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductId",
			new String[] {Long.class.getName()});

		_finderPathFetchByImageUrlProductId = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, ImageImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByImageUrlProductId",
			new String[] {String.class.getName(), Long.class.getName()},
			ImageModelImpl.IMAGEURL_COLUMN_BITMASK |
			ImageModelImpl.PRODUCTID_COLUMN_BITMASK);

		_finderPathCountByImageUrlProductId = new FinderPath(
			ImageModelImpl.ENTITY_CACHE_ENABLED,
			ImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByImageUrlProductId",
			new String[] {String.class.getName(), Long.class.getName()});

		_setImageUtilPersistence(this);
	}

	public void destroy() {
		_setImageUtilPersistence(null);

		entityCache.removeCache(ImageImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setImageUtilPersistence(ImagePersistence imagePersistence) {
		try {
			Field field = ImageUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, imagePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IMAGE =
		"SELECT image FROM Image image";

	private static final String _SQL_SELECT_IMAGE_WHERE_PKS_IN =
		"SELECT image FROM Image image WHERE id_ IN (";

	private static final String _SQL_SELECT_IMAGE_WHERE =
		"SELECT image FROM Image image WHERE ";

	private static final String _SQL_COUNT_IMAGE =
		"SELECT COUNT(image) FROM Image image";

	private static final String _SQL_COUNT_IMAGE_WHERE =
		"SELECT COUNT(image) FROM Image image WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "image.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Image exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Image exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImagePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}