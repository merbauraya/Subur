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

import java.io.IOException;
import java.util.Date;

import com.idetronic.subur.NoSuchConfigException;
import com.idetronic.subur.NoSuchCopyRequestException;
import com.idetronic.subur.model.CopyRequest;
import com.idetronic.subur.model.impl.CopyRequestImpl;
import com.idetronic.subur.notification.SuburNotificationHandler;
import com.idetronic.subur.service.base.CopyRequestLocalServiceBaseImpl;
import com.idetronic.subur.util.SuburConfiguration;
import com.idetronic.subur.util.SuburUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;

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
			String organization,String reason,long companyId,long groupId,
			long userId,ServiceContext serviceContext) throws SystemException, IOException, PortalException
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
		
		//
		
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
	    payloadJSON.put("userId", userId);
	    payloadJSON.put("copyRequestId", copyRequest.getCopyRequestId());
	    payloadJSON.put("itemId", suburItemId);
	    
	    payloadJSON.put("additionalData", "Your notification was added!");
		
		//who will receive the notification
	    String notificationRoleString = SuburConfiguration.getConfig(SuburConfiguration.NOTIFICATION_ROLES);
	    long[] notificationRoles = StringUtil.split(notificationRoleString, 0L);
	    
	    long[] notificationUsers = SuburUtil.getUserByRole(companyId, notificationRoles);
	   
	    
	    for (long recepientUserId : notificationUsers)
	    {
		    UserNotificationEventLocalServiceUtil.addUserNotificationEvent(recepientUserId, 
		    		SuburNotificationHandler.NOTIFICATION_REQUEST_RESTRICTED_COPY, 
		    		(new Date()).getTime(),
		    		userId,
		    		payloadJSON.toString(),
		    		false, serviceContext);	
		    
		    
		    
		    
	    }
		
		
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