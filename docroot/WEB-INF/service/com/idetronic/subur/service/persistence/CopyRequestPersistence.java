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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the copy request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CopyRequestPersistenceImpl
 * @see CopyRequestUtil
 * @generated
 */
public interface CopyRequestPersistence extends BasePersistence<CopyRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CopyRequestUtil} to access the copy request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the copy requests where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest[] findByCompanyGroup_PrevAndNext(
		long copyRequestId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the copy requests where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of copy requests where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the copy requests where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByGroupAndStatus(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByGroupAndStatus(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByGroupAndStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest findByGroupAndStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByGroupAndStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest findByGroupAndStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last copy request in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByGroupAndStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest[] findByGroupAndStatus_PrevAndNext(
		long copyRequestId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the copy requests where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupAndStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of copy requests where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupAndStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the copy requests where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyAndStatus(
		long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyAndStatus(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findByCompanyAndStatus(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest findByCompanyAndStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByCompanyAndStatus_First(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest findByCompanyAndStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last copy request in the ordered set where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByCompanyAndStatus_Last(
		long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.idetronic.subur.model.CopyRequest[] findByCompanyAndStatus_PrevAndNext(
		long copyRequestId, long companyId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the copy requests where companyId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyAndStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of copy requests where companyId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param status the status
	* @return the number of matching copy requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyAndStatus(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the copy request in the entity cache if it is enabled.
	*
	* @param copyRequest the copy request
	*/
	public void cacheResult(com.idetronic.subur.model.CopyRequest copyRequest);

	/**
	* Caches the copy requests in the entity cache if it is enabled.
	*
	* @param copyRequests the copy requests
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.CopyRequest> copyRequests);

	/**
	* Creates a new copy request with the primary key. Does not add the copy request to the database.
	*
	* @param copyRequestId the primary key for the new copy request
	* @return the new copy request
	*/
	public com.idetronic.subur.model.CopyRequest create(long copyRequestId);

	/**
	* Removes the copy request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request that was removed
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest remove(long copyRequestId)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.CopyRequest updateImpl(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the copy request with the primary key or throws a {@link com.idetronic.subur.NoSuchCopyRequestException} if it could not be found.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request
	* @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest findByPrimaryKey(
		long copyRequestId)
		throws com.idetronic.subur.NoSuchCopyRequestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the copy request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param copyRequestId the primary key of the copy request
	* @return the copy request, or <code>null</code> if a copy request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.CopyRequest fetchByPrimaryKey(
		long copyRequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the copy requests.
	*
	* @return the copy requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.CopyRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.CopyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the copy requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of copy requests.
	*
	* @return the number of copy requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}