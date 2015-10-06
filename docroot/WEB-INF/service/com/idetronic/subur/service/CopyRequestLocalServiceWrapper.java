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
 * Provides a wrapper for {@link CopyRequestLocalService}.
 *
 * @author Mazlan Mat
 * @see CopyRequestLocalService
 * @generated
 */
public class CopyRequestLocalServiceWrapper implements CopyRequestLocalService,
	ServiceWrapper<CopyRequestLocalService> {
	public CopyRequestLocalServiceWrapper(
		CopyRequestLocalService copyRequestLocalService) {
		_copyRequestLocalService = copyRequestLocalService;
	}

	/**
	* Adds the copy request to the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequest the copy request
	* @return the copy request that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.CopyRequest addCopyRequest(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.addCopyRequest(copyRequest);
	}

	/**
	* Creates a new copy request with the primary key. Does not add the copy request to the database.
	*
	* @param copyRequestId the primary key for the new copy request
	* @return the new copy request
	*/
	@Override
	public com.idetronic.subur.model.CopyRequest createCopyRequest(
		long copyRequestId) {
		return _copyRequestLocalService.createCopyRequest(copyRequestId);
	}

	/**
	* Deletes the copy request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request that was removed
	* @throws PortalException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.CopyRequest deleteCopyRequest(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.deleteCopyRequest(copyRequestId);
	}

	/**
	* Deletes the copy request from the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequest the copy request
	* @return the copy request that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.CopyRequest deleteCopyRequest(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.deleteCopyRequest(copyRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _copyRequestLocalService.dynamicQuery();
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
		return _copyRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _copyRequestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _copyRequestLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _copyRequestLocalService.dynamicQueryCount(dynamicQuery);
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
		return _copyRequestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.CopyRequest fetchCopyRequest(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.fetchCopyRequest(copyRequestId);
	}

	/**
	* Returns the copy request with the primary key.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request
	* @throws PortalException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.CopyRequest getCopyRequest(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.getCopyRequest(copyRequestId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the copy requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @return the range of copy requests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.CopyRequest> getCopyRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.getCopyRequests(start, end);
	}

	/**
	* Returns the number of copy requests.
	*
	* @return the number of copy requests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCopyRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.getCopyRequestsCount();
	}

	/**
	* Updates the copy request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param copyRequest the copy request
	* @return the copy request that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.CopyRequest updateCopyRequest(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.updateCopyRequest(copyRequest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _copyRequestLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_copyRequestLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _copyRequestLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.subur.model.CopyRequest addCopyRequest(
		long suburItemId, java.lang.String requesterName,
		java.lang.String fromEmailAddress, java.lang.String organization,
		java.lang.String reason, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.addCopyRequest(suburItemId,
			requesterName, fromEmailAddress, organization, reason, companyId,
			groupId);
	}

	@Override
	public com.idetronic.subur.model.CopyRequest updateCopyRequest(
		long copyRequestId, int newStatus, int updatedBy,
		java.lang.String respondText)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.updateCopyRequest(copyRequestId,
			newStatus, updatedBy, respondText);
	}

	@Override
	public com.idetronic.subur.model.CopyRequest approveRequest(
		long copyRequestId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.approveRequest(copyRequestId, userId);
	}

	@Override
	public com.idetronic.subur.model.CopyRequest rejectRequest(
		long copyRequestId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequestLocalService.rejectRequest(copyRequestId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CopyRequestLocalService getWrappedCopyRequestLocalService() {
		return _copyRequestLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCopyRequestLocalService(
		CopyRequestLocalService copyRequestLocalService) {
		_copyRequestLocalService = copyRequestLocalService;
	}

	@Override
	public CopyRequestLocalService getWrappedService() {
		return _copyRequestLocalService;
	}

	@Override
	public void setWrappedService(
		CopyRequestLocalService copyRequestLocalService) {
		_copyRequestLocalService = copyRequestLocalService;
	}

	private CopyRequestLocalService _copyRequestLocalService;
}