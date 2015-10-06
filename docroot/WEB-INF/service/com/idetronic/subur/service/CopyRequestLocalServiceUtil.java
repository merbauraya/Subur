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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CopyRequest. This utility wraps
 * {@link com.idetronic.subur.service.impl.CopyRequestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see CopyRequestLocalService
 * @see com.idetronic.subur.service.base.CopyRequestLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.CopyRequestLocalServiceImpl
 * @generated
 */
public class CopyRequestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.CopyRequestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the copy request to the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequest the copy request
	* @return the copy request that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest addCopyRequest(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCopyRequest(copyRequest);
	}

	/**
	* Creates a new copy request with the primary key. Does not add the copy request to the database.
	*
	* @param copyRequestId the primary key for the new copy request
	* @return the new copy request
	*/
	public static com.idetronic.subur.model.CopyRequest createCopyRequest(
		long copyRequestId) {
		return getService().createCopyRequest(copyRequestId);
	}

	/**
	* Deletes the copy request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request that was removed
	* @throws PortalException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest deleteCopyRequest(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCopyRequest(copyRequestId);
	}

	/**
	* Deletes the copy request from the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequest the copy request
	* @return the copy request that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest deleteCopyRequest(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCopyRequest(copyRequest);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.subur.model.CopyRequest fetchCopyRequest(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCopyRequest(copyRequestId);
	}

	/**
	* Returns the copy request with the primary key.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request
	* @throws PortalException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest getCopyRequest(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCopyRequest(copyRequestId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.subur.model.CopyRequest> getCopyRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCopyRequests(start, end);
	}

	/**
	* Returns the number of copy requests.
	*
	* @return the number of copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static int getCopyRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCopyRequestsCount();
	}

	/**
	* Updates the copy request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param copyRequest the copy request
	* @return the copy request that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest updateCopyRequest(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCopyRequest(copyRequest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.idetronic.subur.model.CopyRequest addCopyRequest(
		long suburItemId, java.lang.String requesterName,
		java.lang.String fromEmailAddress, java.lang.String organization,
		java.lang.String reason, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCopyRequest(suburItemId, requesterName,
			fromEmailAddress, organization, reason, companyId, groupId);
	}

	public static com.idetronic.subur.model.CopyRequest updateCopyRequest(
		long copyRequestId, int newStatus, int updatedBy,
		java.lang.String respondText)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCopyRequest(copyRequestId, newStatus, updatedBy,
			respondText);
	}

	public static com.idetronic.subur.model.CopyRequest approveRequest(
		long copyRequestId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().approveRequest(copyRequestId, userId);
	}

	public static com.idetronic.subur.model.CopyRequest rejectRequest(
		long copyRequestId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().rejectRequest(copyRequestId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CopyRequestLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CopyRequestLocalService.class.getName());

			if (invokableLocalService instanceof CopyRequestLocalService) {
				_service = (CopyRequestLocalService)invokableLocalService;
			}
			else {
				_service = new CopyRequestLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CopyRequestLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CopyRequestLocalService service) {
	}

	private static CopyRequestLocalService _service;
}