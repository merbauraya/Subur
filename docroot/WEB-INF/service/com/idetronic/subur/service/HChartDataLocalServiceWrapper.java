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
 * Provides a wrapper for {@link HChartDataLocalService}.
 *
 * @author Mazlan Mat
 * @see HChartDataLocalService
 * @generated
 */
public class HChartDataLocalServiceWrapper implements HChartDataLocalService,
	ServiceWrapper<HChartDataLocalService> {
	public HChartDataLocalServiceWrapper(
		HChartDataLocalService hChartDataLocalService) {
		_hChartDataLocalService = hChartDataLocalService;
	}

	/**
	* Adds the h chart data to the database. Also notifies the appropriate model listeners.
	*
	* @param hChartData the h chart data
	* @return the h chart data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartData addHChartData(
		com.idetronic.subur.model.HChartData hChartData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.addHChartData(hChartData);
	}

	/**
	* Creates a new h chart data with the primary key. Does not add the h chart data to the database.
	*
	* @param hChartDataId the primary key for the new h chart data
	* @return the new h chart data
	*/
	@Override
	public com.idetronic.subur.model.HChartData createHChartData(
		long hChartDataId) {
		return _hChartDataLocalService.createHChartData(hChartDataId);
	}

	/**
	* Deletes the h chart data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hChartDataId the primary key of the h chart data
	* @return the h chart data that was removed
	* @throws PortalException if a h chart data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartData deleteHChartData(
		long hChartDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.deleteHChartData(hChartDataId);
	}

	/**
	* Deletes the h chart data from the database. Also notifies the appropriate model listeners.
	*
	* @param hChartData the h chart data
	* @return the h chart data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartData deleteHChartData(
		com.idetronic.subur.model.HChartData hChartData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.deleteHChartData(hChartData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hChartDataLocalService.dynamicQuery();
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
		return _hChartDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _hChartDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _hChartDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _hChartDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _hChartDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.HChartData fetchHChartData(
		long hChartDataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.fetchHChartData(hChartDataId);
	}

	/**
	* Returns the h chart data with the primary key.
	*
	* @param hChartDataId the primary key of the h chart data
	* @return the h chart data
	* @throws PortalException if a h chart data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartData getHChartData(long hChartDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.getHChartData(hChartDataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the h chart datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of h chart datas
	* @param end the upper bound of the range of h chart datas (not inclusive)
	* @return the range of h chart datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.HChartData> getHChartDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.getHChartDatas(start, end);
	}

	/**
	* Returns the number of h chart datas.
	*
	* @return the number of h chart datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHChartDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.getHChartDatasCount();
	}

	/**
	* Updates the h chart data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hChartData the h chart data
	* @return the h chart data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.HChartData updateHChartData(
		com.idetronic.subur.model.HChartData hChartData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hChartDataLocalService.updateHChartData(hChartData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _hChartDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_hChartDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _hChartDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HChartDataLocalService getWrappedHChartDataLocalService() {
		return _hChartDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHChartDataLocalService(
		HChartDataLocalService hChartDataLocalService) {
		_hChartDataLocalService = hChartDataLocalService;
	}

	@Override
	public HChartDataLocalService getWrappedService() {
		return _hChartDataLocalService;
	}

	@Override
	public void setWrappedService(HChartDataLocalService hChartDataLocalService) {
		_hChartDataLocalService = hChartDataLocalService;
	}

	private HChartDataLocalService _hChartDataLocalService;
}