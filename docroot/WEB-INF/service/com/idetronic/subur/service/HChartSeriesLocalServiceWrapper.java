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
 * Provides a wrapper for {@link HChartSeriesLocalService}.
 *
 * @author Mazlan Mat
 * @see HChartSeriesLocalService
 * @generated
 */
public class HChartSeriesLocalServiceWrapper implements HChartSeriesLocalService,
	ServiceWrapper<HChartSeriesLocalService> {
	public HChartSeriesLocalServiceWrapper(
		HChartSeriesLocalService hChartSeriesLocalService) {
		_hChartSeriesLocalService = hChartSeriesLocalService;
	}

	/**
	* Adds the h chart series to the database. Also notifies the appropriate model listeners.
	*
	* @param hChartSeries the h chart series
	* @return the h chart series that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartSeries addHChartSeries(
		com.idetronic.subur.model.HChartSeries hChartSeries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.addHChartSeries(hChartSeries);
	}

	/**
	* Creates a new h chart series with the primary key. Does not add the h chart series to the database.
	*
	* @param hChartSeriesId the primary key for the new h chart series
	* @return the new h chart series
	*/
	@Override
	public com.idetronic.subur.model.HChartSeries createHChartSeries(
		long hChartSeriesId) {
		return _hChartSeriesLocalService.createHChartSeries(hChartSeriesId);
	}

	/**
	* Deletes the h chart series with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hChartSeriesId the primary key of the h chart series
	* @return the h chart series that was removed
	* @throws PortalException if a h chart series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartSeries deleteHChartSeries(
		long hChartSeriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.deleteHChartSeries(hChartSeriesId);
	}

	/**
	* Deletes the h chart series from the database. Also notifies the appropriate model listeners.
	*
	* @param hChartSeries the h chart series
	* @return the h chart series that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartSeries deleteHChartSeries(
		com.idetronic.subur.model.HChartSeries hChartSeries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.deleteHChartSeries(hChartSeries);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hChartSeriesLocalService.dynamicQuery();
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
		return _hChartSeriesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _hChartSeriesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _hChartSeriesLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _hChartSeriesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _hChartSeriesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.HChartSeries fetchHChartSeries(
		long hChartSeriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.fetchHChartSeries(hChartSeriesId);
	}

	/**
	* Returns the h chart series with the primary key.
	*
	* @param hChartSeriesId the primary key of the h chart series
	* @return the h chart series
	* @throws PortalException if a h chart series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartSeries getHChartSeries(
		long hChartSeriesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.getHChartSeries(hChartSeriesId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the h chart serieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of h chart serieses
	* @param end the upper bound of the range of h chart serieses (not inclusive)
	* @return the range of h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.HChartSeries> getHChartSerieses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.getHChartSerieses(start, end);
	}

	/**
	* Returns the number of h chart serieses.
	*
	* @return the number of h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHChartSeriesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.getHChartSeriesesCount();
	}

	/**
	* Updates the h chart series in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hChartSeries the h chart series
	* @return the h chart series that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartSeries updateHChartSeries(
		com.idetronic.subur.model.HChartSeries hChartSeries)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartSeriesLocalService.updateHChartSeries(hChartSeries);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _hChartSeriesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hChartSeriesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _hChartSeriesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HChartSeriesLocalService getWrappedHChartSeriesLocalService() {
		return _hChartSeriesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHChartSeriesLocalService(
		HChartSeriesLocalService hChartSeriesLocalService) {
		_hChartSeriesLocalService = hChartSeriesLocalService;
	}

	@Override
	public HChartSeriesLocalService getWrappedService() {
		return _hChartSeriesLocalService;
	}

	@Override
	public void setWrappedService(
		HChartSeriesLocalService hChartSeriesLocalService) {
		_hChartSeriesLocalService = hChartSeriesLocalService;
	}

	private HChartSeriesLocalService _hChartSeriesLocalService;
}