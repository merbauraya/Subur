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
 * Provides a wrapper for {@link StatDownloadTagLocalService}.
 *
 * @author Mazlan Mat
 * @see StatDownloadTagLocalService
 * @generated
 */
public class StatDownloadTagLocalServiceWrapper
	implements StatDownloadTagLocalService,
		ServiceWrapper<StatDownloadTagLocalService> {
	public StatDownloadTagLocalServiceWrapper(
		StatDownloadTagLocalService statDownloadTagLocalService) {
		_statDownloadTagLocalService = statDownloadTagLocalService;
	}

	/**
	* Adds the stat download tag to the database. Also notifies the appropriate model listeners.
	*
	* @param statDownloadTag the stat download tag
	* @return the stat download tag that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadTag addStatDownloadTag(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.addStatDownloadTag(statDownloadTag);
	}

	/**
	* Creates a new stat download tag with the primary key. Does not add the stat download tag to the database.
	*
	* @param id the primary key for the new stat download tag
	* @return the new stat download tag
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadTag createStatDownloadTag(
		long id) {
		return _statDownloadTagLocalService.createStatDownloadTag(id);
	}

	/**
	* Deletes the stat download tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download tag
	* @return the stat download tag that was removed
	* @throws PortalException if a stat download tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadTag deleteStatDownloadTag(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.deleteStatDownloadTag(id);
	}

	/**
	* Deletes the stat download tag from the database. Also notifies the appropriate model listeners.
	*
	* @param statDownloadTag the stat download tag
	* @return the stat download tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadTag deleteStatDownloadTag(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.deleteStatDownloadTag(statDownloadTag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statDownloadTagLocalService.dynamicQuery();
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
		return _statDownloadTagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statDownloadTagLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statDownloadTagLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _statDownloadTagLocalService.dynamicQueryCount(dynamicQuery);
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
		return _statDownloadTagLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.StatDownloadTag fetchStatDownloadTag(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.fetchStatDownloadTag(id);
	}

	/**
	* Returns the stat download tag with the primary key.
	*
	* @param id the primary key of the stat download tag
	* @return the stat download tag
	* @throws PortalException if a stat download tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadTag getStatDownloadTag(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.getStatDownloadTag(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the stat download tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download tags
	* @param end the upper bound of the range of stat download tags (not inclusive)
	* @return the range of stat download tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.StatDownloadTag> getStatDownloadTags(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.getStatDownloadTags(start, end);
	}

	/**
	* Returns the number of stat download tags.
	*
	* @return the number of stat download tags
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStatDownloadTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.getStatDownloadTagsCount();
	}

	/**
	* Updates the stat download tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statDownloadTag the stat download tag
	* @return the stat download tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.StatDownloadTag updateStatDownloadTag(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statDownloadTagLocalService.updateStatDownloadTag(statDownloadTag);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _statDownloadTagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statDownloadTagLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statDownloadTagLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StatDownloadTagLocalService getWrappedStatDownloadTagLocalService() {
		return _statDownloadTagLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStatDownloadTagLocalService(
		StatDownloadTagLocalService statDownloadTagLocalService) {
		_statDownloadTagLocalService = statDownloadTagLocalService;
	}

	@Override
	public StatDownloadTagLocalService getWrappedService() {
		return _statDownloadTagLocalService;
	}

	@Override
	public void setWrappedService(
		StatDownloadTagLocalService statDownloadTagLocalService) {
		_statDownloadTagLocalService = statDownloadTagLocalService;
	}

	private StatDownloadTagLocalService _statDownloadTagLocalService;
}