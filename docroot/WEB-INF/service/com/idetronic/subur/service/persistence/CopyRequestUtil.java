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

package com.idetronic.subur.service.persistence;

import com.idetronic.subur.model.CopyRequest;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the copy request service. This utility wraps {@link CopyRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CopyRequestPersistence
 * @see CopyRequestPersistenceImpl
 * @generated
 */
public class CopyRequestUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CopyRequest copyRequest) {
		getPersistence().clearCache(copyRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CopyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CopyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CopyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CopyRequest update(CopyRequest copyRequest)
		throws SystemException {
		return getPersistence().update(copyRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CopyRequest update(CopyRequest copyRequest,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(copyRequest, serviceContext);
	}

	/**
	* Returns all the copy requests where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the copy requests where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @return the range of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the copy requests where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_First(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyGroup_Last(companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns the copy requests before and after the current copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param copyRequestId the primary key of the current copy request
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest[] findByCompanyGroup_PrevAndNext(
		long copyRequestId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyGroup_PrevAndNext(copyRequestId, companyId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the copy requests where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns the number of copy requests where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyGroup(companyId, groupId);
	}

	/**
	* Returns all the copy requests where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByGroupAndStatus(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status);
	}

	/**
	* Returns a range of all the copy requests where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @return the range of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByGroupAndStatus(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupAndStatus(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the copy requests where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByGroupAndStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByGroupAndStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByGroupAndStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_First(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByGroupAndStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByGroupAndStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupAndStatus_Last(groupId, status,
			orderByComparator);
	}

	/**
	* Returns the copy requests before and after the current copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param copyRequestId the primary key of the current copy request
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest[] findByGroupAndStatus_PrevAndNext(
		long copyRequestId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupAndStatus_PrevAndNext(copyRequestId, groupId,
			status, orderByComparator);
	}

	/**
	* Removes all the copy requests where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupAndStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupAndStatus(groupId, status);
	}

	/**
	* Returns the number of copy requests where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupAndStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupAndStatus(groupId, status);
	}

	/**
	* Returns all the copy requests where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyAndStatus(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyAndStatus(companyId, status);
	}

	/**
	* Returns a range of all the copy requests where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @return the range of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyAndStatus(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, status, start, end);
	}

	/**
	* Returns an ordered range of all the copy requests where companyId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param status the status
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyAndStatus(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus(companyId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByCompanyAndStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the first copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByCompanyAndStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_First(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByCompanyAndStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the last copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByCompanyAndStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyAndStatus_Last(companyId, status,
			orderByComparator);
	}

	/**
	* Returns the copy requests before and after the current copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param copyRequestId the primary key of the current copy request
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest[] findByCompanyAndStatus_PrevAndNext(
		long copyRequestId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyAndStatus_PrevAndNext(copyRequestId,
			companyId, status, orderByComparator);
	}

	/**
	* Removes all the copy requests where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyAndStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyAndStatus(companyId, status);
	}

	/**
	* Returns the number of copy requests where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyAndStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyAndStatus(companyId, status);
	}

	/**
	* Caches the copy request in the entity cache if it is enabled.
	*
	* @param copyRequest the copy request
	*/
	public static void cacheResult(
		com.idetronic.subur.model.CopyRequest copyRequest) {
		getPersistence().cacheResult(copyRequest);
	}

	/**
	* Caches the copy requests in the entity cache if it is enabled.
	*
	* @param copyRequests the copy requests
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.CopyRequest> copyRequests) {
		getPersistence().cacheResult(copyRequests);
	}

	/**
	* Creates a new copy request with the primary key. Does not add the copy request to the database.
	*
	* @param copyRequestId the primary key for the new copy request
	* @return the new copy request
	*/
	public static com.idetronic.subur.model.CopyRequest create(
		long copyRequestId) {
		return getPersistence().create(copyRequestId);
	}

	/**
	* Removes the copy request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request that was removed
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest remove(
		long copyRequestId)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(copyRequestId);
	}

	public static com.idetronic.subur.model.CopyRequest updateImpl(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(copyRequest);
	}

	/**
	* Returns the copy request with the primary key or throws a {@link com.idetronic.subur.NoSuchCopyRequestException} if it could not be found.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest findByPrimaryKey(
		long copyRequestId)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(copyRequestId);
	}

	/**
	* Returns the copy request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request, or <code>null</code> if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.CopyRequest fetchByPrimaryKey(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(copyRequestId);
	}

	/**
	* Returns all the copy requests.
	*
	* @return the copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the copy requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of copy requests
	* @param end the upper bound of the range of copy requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.CopyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the copy requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of copy requests.
	*
	* @return the number of copy requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CopyRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CopyRequestPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					CopyRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(CopyRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CopyRequestPersistence persistence) {
	}

	private static CopyRequestPersistence _persistence;
}