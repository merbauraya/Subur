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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ViewSummaryLocalService}.
 *
 * @author Mazlan Mat
 * @see ViewSummaryLocalService
 * @generated
 */
public class ViewSummaryLocalServiceWrapper implements ViewSummaryLocalService,
	ServiceWrapper<ViewSummaryLocalService> {
	public ViewSummaryLocalServiceWrapper(
		ViewSummaryLocalService viewSummaryLocalService) {
		_viewSummaryLocalService = viewSummaryLocalService;
	}

	/**
	* Adds the view summary to the database. Also notifies the appropriate model listeners.
	*
	* @param viewSummary the view summary
	* @return the view summary that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary addViewSummary(
		com.idetronic.subur.model.ViewSummary viewSummary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.addViewSummary(viewSummary);
	}

	/**
	* Creates a new view summary with the primary key. Does not add the view summary to the database.
	*
	* @param id the primary key for the new view summary
	* @return the new view summary
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary createViewSummary(long id) {
		return _viewSummaryLocalService.createViewSummary(id);
	}

	/**
	* Deletes the view summary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the view summary
	* @return the view summary that was removed
	* @throws PortalException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary deleteViewSummary(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.deleteViewSummary(id);
	}

	/**
	* Deletes the view summary from the database. Also notifies the appropriate model listeners.
	*
	* @param viewSummary the view summary
	* @return the view summary that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary deleteViewSummary(
		com.idetronic.subur.model.ViewSummary viewSummary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.deleteViewSummary(viewSummary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _viewSummaryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.ViewSummary fetchViewSummary(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.fetchViewSummary(id);
	}

	/**
	* Returns the view summary with the primary key.
	*
	* @param id the primary key of the view summary
	* @return the view summary
	* @throws PortalException if a view summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary getViewSummary(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.getViewSummary(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the view summaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ViewSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of view summaries
	* @param end the upper bound of the range of view summaries (not inclusive)
	* @return the range of view summaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.ViewSummary> getViewSummaries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.getViewSummaries(start, end);
	}

	/**
	* Returns the number of view summaries.
	*
	* @return the number of view summaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getViewSummariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.getViewSummariesCount();
	}

	/**
	* Updates the view summary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param viewSummary the view summary
	* @return the view summary that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary updateViewSummary(
		com.idetronic.subur.model.ViewSummary viewSummary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.updateViewSummary(viewSummary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _viewSummaryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_viewSummaryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _viewSummaryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getMonthlyStatRs(int year)
		throws java.sql.SQLException {
		return _viewSummaryLocalService.getMonthlyStatRs(year);
	}

	/**
	* Add view stats info the the entity.
	*/
	@Override
	public com.idetronic.subur.model.ViewSummary addStats(long itemId,
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _viewSummaryLocalService.addStats(itemId, companyId, groupId);
	}

	@Override
	public void updateStats(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_viewSummaryLocalService.updateStats(companyId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ViewSummaryLocalService getWrappedViewSummaryLocalService() {
		return _viewSummaryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedViewSummaryLocalService(
		ViewSummaryLocalService viewSummaryLocalService) {
		_viewSummaryLocalService = viewSummaryLocalService;
	}

	@Override
	public ViewSummaryLocalService getWrappedService() {
		return _viewSummaryLocalService;
	}

	@Override
	public void setWrappedService(
		ViewSummaryLocalService viewSummaryLocalService) {
		_viewSummaryLocalService = viewSummaryLocalService;
	}

	private ViewSummaryLocalService _viewSummaryLocalService;
}