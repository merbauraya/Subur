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

package com.idetronic.subur.service.impl;

import java.util.Date;

import com.idetronic.subur.NoSuchCopyRequestException;
import com.idetronic.subur.model.CopyRequest;
import com.idetronic.subur.model.impl.CopyRequestImpl;
import com.idetronic.subur.service.base.CopyRequestLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the copy request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.CopyRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.CopyRequestLocalServiceBaseImpl
 * @see com.idetronic.subur.service.CopyRequestLocalServiceUtil
 */
public class CopyRequestLocalServiceImpl extends CopyRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.CopyRequestLocalServiceUtil} to access the copy request local service.
	 */
	
	public CopyRequest addCopyRequest(long suburItemId,String requesterName,String fromEmailAddress,
			String organization,String reason,long companyId,long groupId) throws SystemException
	{
		long copyRequestId = CounterLocalServiceUtil.increment(CopyRequest.class.getName());
		
		CopyRequest copyRequest = copyRequestPersistence.create(copyRequestId);
		
		copyRequest.setSuburItemId(suburItemId);
		copyRequest.setRequesterName(requesterName);
		copyRequest.setFromEmailAddress(fromEmailAddress);
		copyRequest.setOrganization(organization);
		copyRequest.setReason(reason);
		copyRequest.setStatus(CopyRequestImpl.STATUS_NEW);
		copyRequest.setDateCreated(new Date());
		copyRequest.setCompanyId(companyId);
		copyRequest.setGroupId(groupId);
		return copyRequestPersistence.update(copyRequest);
	}
	
	public CopyRequest updateCopyRequest(long copyRequestId,int newStatus,int updatedBy,String respondText) throws NoSuchCopyRequestException, SystemException
	{
		CopyRequest copyRequest = copyRequestPersistence.findByPrimaryKey(copyRequestId);
		
		copyRequest.setStatus(newStatus);
		copyRequest.setResponsedByUserId(updatedBy);
		copyRequest.setRespondText(respondText);
		copyRequest.setDateResponsed(new Date());
		
		return copyRequestPersistence.update(copyRequest); 
		
	}
	public CopyRequest approveRequest(long copyRequestId,long userId) throws SystemException
	{
		CopyRequest copyRequest = copyRequestPersistence.fetchByPrimaryKey(copyRequestId);
		copyRequest.setStatus(CopyRequestImpl.STATUC_APPROVED);
		copyRequest.setResponsedByUserId(userId);
		copyRequest.setDateResponsed(new Date());
		return copyRequestPersistence.update(copyRequest);
		
	}
	public CopyRequest rejectRequest(long copyRequestId, long userId) throws SystemException
	{
		CopyRequest copyRequest = copyRequestPersistence.fetchByPrimaryKey(copyRequestId);
		copyRequest.setStatus(CopyRequestImpl.STATUS_REJECTED);
		copyRequest.setResponsedByUserId(userId);
		copyRequest.setDateResponsed(new Date());
		return copyRequestPersistence.update(copyRequest);
	}
	
}