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
 * Provides a wrapper for {@link HighlightsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HighlightsLocalService
 * @generated
 */
public class HighlightsLocalServiceWrapper
	implements HighlightsLocalService, ServiceWrapper<HighlightsLocalService> {

	public HighlightsLocalServiceWrapper(
		HighlightsLocalService highlightsLocalService) {

		_highlightsLocalService = highlightsLocalService;
	}

	/**
	 * Adds the highlights to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighlightsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highlights the highlights
	 * @return the highlights that was added
	 */
	@Override
	public com.onlineshopping.product.service.model.Highlights addHighlights(
		com.onlineshopping.product.service.model.Highlights highlights) {

		return _highlightsLocalService.addHighlights(highlights);
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights
		addProductHighlights(String features, String size) {

		return _highlightsLocalService.addProductHighlights(features, size);
	}

	/**
	 * Creates a new highlights with the primary key. Does not add the highlights to the database.
	 *
	 * @param id the primary key for the new highlights
	 * @return the new highlights
	 */
	@Override
	public com.onlineshopping.product.service.model.Highlights createHighlights(
		long id) {

		return _highlightsLocalService.createHighlights(id);
	}

	/**
	 * Deletes the highlights from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighlightsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highlights the highlights
	 * @return the highlights that was removed
	 */
	@Override
	public com.onlineshopping.product.service.model.Highlights deleteHighlights(
		com.onlineshopping.product.service.model.Highlights highlights) {

		return _highlightsLocalService.deleteHighlights(highlights);
	}

	/**
	 * Deletes the highlights with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighlightsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights that was removed
	 * @throws PortalException if a highlights with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.Highlights deleteHighlights(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highlightsLocalService.deleteHighlights(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highlightsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _highlightsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _highlightsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _highlightsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _highlightsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _highlightsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _highlightsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights fetchHighlights(
		long id) {

		return _highlightsLocalService.fetchHighlights(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _highlightsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the highlights with the primary key.
	 *
	 * @param id the primary key of the highlights
	 * @return the highlights
	 * @throws PortalException if a highlights with the primary key could not be found
	 */
	@Override
	public com.onlineshopping.product.service.model.Highlights getHighlights(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highlightsLocalService.getHighlights(id);
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights
		getHighlightsByDetails(String features, String size) {

		return _highlightsLocalService.getHighlightsByDetails(features, size);
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights
		getHighlightsById(long highlightsId) {

		return _highlightsLocalService.getHighlightsById(highlightsId);
	}

	/**
	 * Returns a range of all the highlightses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.onlineshopping.product.service.model.impl.HighlightsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of highlightses
	 * @param end the upper bound of the range of highlightses (not inclusive)
	 * @return the range of highlightses
	 */
	@Override
	public java.util.List<com.onlineshopping.product.service.model.Highlights>
		getHighlightses(int start, int end) {

		return _highlightsLocalService.getHighlightses(start, end);
	}

	/**
	 * Returns the number of highlightses.
	 *
	 * @return the number of highlightses
	 */
	@Override
	public int getHighlightsesCount() {
		return _highlightsLocalService.getHighlightsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _highlightsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _highlightsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highlightsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the highlights in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighlightsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highlights the highlights
	 * @return the highlights that was updated
	 */
	@Override
	public com.onlineshopping.product.service.model.Highlights updateHighlights(
		com.onlineshopping.product.service.model.Highlights highlights) {

		return _highlightsLocalService.updateHighlights(highlights);
	}

	@Override
	public com.onlineshopping.product.service.model.Highlights updateHighlights(
		long highlightsId, String features, String size) {

		return _highlightsLocalService.updateHighlights(
			highlightsId, features, size);
	}

	@Override
	public HighlightsLocalService getWrappedService() {
		return _highlightsLocalService;
	}

	@Override
	public void setWrappedService(
		HighlightsLocalService highlightsLocalService) {

		_highlightsLocalService = highlightsLocalService;
	}

	private HighlightsLocalService _highlightsLocalService;

}