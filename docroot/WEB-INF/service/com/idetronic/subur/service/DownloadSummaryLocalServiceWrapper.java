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
 * Provides a wrapper for {@link DownloadSummaryLocalService}.
 *
 * @author Mazlan Mat
 * @see DownloadSummaryLocalService
 * @generated
 */
public class DownloadSummaryLocalServiceWrapper
	implements DownloadSummaryLocalService,
		ServiceWrapper<DownloadSummaryLocalService> {
	public DownloadSummaryLocalServiceWrapper(
		DownloadSummaryLocalService downloadSummaryLocalService) {
		_downloadSummaryLocalService = downloadSummaryLocalService;
	}

	/**
	* Adds the download summary to the database. Also notifies the appropriate model listeners.
	*
	* @param downloadSummary the download summary
	* @return the download summary that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.DownloadSummary addDownloadSummary(
		com.idetronic.subur.model.DownloadSummary downloadSummary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.addDownloadSummary(downloadSummary);
	}

	/**
	* Creates a new download summary with the primary key. Does not add the download summary to the database.
	*
	* @param id the primary key for the new download summary
	* @return the new download summary
	*/
	@Override
	public com.idetronic.subur.model.DownloadSummary createDownloadSummary(
		long id) {
		return _downloadSummaryLocalService.createDownloadSummary(id);
	}

	/**
	* Deletes the download summary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the download summary
	* @return the download summary that was removed
	* @throws PortalException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.DownloadSummary deleteDownloadSummary(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.deleteDownloadSummary(id);
	}

	/**
	* Deletes the download summary from the database. Also notifies the appropriate model listeners.
	*
	* @param downloadSummary the download summary
	* @return the download summary that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.DownloadSummary deleteDownloadSummary(
		com.idetronic.subur.model.DownloadSummary downloadSummary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.deleteDownloadSummary(downloadSummary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _downloadSummaryLocalService.dynamicQuery();
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
		return _downloadSummaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _downloadSummaryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _downloadSummaryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _downloadSummaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _downloadSummaryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.DownloadSummary fetchDownloadSummary(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.fetchDownloadSummary(id);
	}

	/**
	* Returns the download summary with the primary key.
	*
	* @param id the primary key of the download summary
	* @return the download summary
	* @throws PortalException if a download summary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.DownloadSummary getDownloadSummary(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.getDownloadSummary(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the download summaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DownloadSummaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of download summaries
	* @param end the upper bound of the range of download summaries (not inclusive)
	* @return the range of download summaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.DownloadSummary> getDownloadSummaries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.getDownloadSummaries(start, end);
	}

	/**
	* Returns the number of download summaries.
	*
	* @return the number of download summaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDownloadSummariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.getDownloadSummariesCount();
	}

	/**
	* Updates the download summary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param downloadSummary the download summary
	* @return the download summary that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.DownloadSummary updateDownloadSummary(
		com.idetronic.subur.model.DownloadSummary downloadSummary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.updateDownloadSummary(downloadSummary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _downloadSummaryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_downloadSummaryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _downloadSummaryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.subur.model.DownloadSummary addStats(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _downloadSummaryLocalService.addStats(itemId);
	}

	/**
	* Update stats info into their corresponding model entry
	* This is very resource extensive operation
	*
	* @throws SystemException
	*/
	@Override
	public void updateStats()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_downloadSummaryLocalService.updateStats();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DownloadSummaryLocalService getWrappedDownloadSummaryLocalService() {
		return _downloadSummaryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDownloadSummaryLocalService(
		DownloadSummaryLocalService downloadSummaryLocalService) {
		_downloadSummaryLocalService = downloadSummaryLocalService;
	}

	@Override
	public DownloadSummaryLocalService getWrappedService() {
		return _downloadSummaryLocalService;
	}

	@Override
	public void setWrappedService(
		DownloadSummaryLocalService downloadSummaryLocalService) {
		_downloadSummaryLocalService = downloadSummaryLocalService;
	}

	private DownloadSummaryLocalService _downloadSummaryLocalService;
}