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

import com.idetronic.subur.NoSuchItemException;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.base.SuburItemServiceBaseImpl;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;

/**
 * The implementation of the subur item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.SuburItemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.SuburItemServiceBaseImpl
 * @see com.idetronic.subur.service.SuburItemServiceUtil
 */
public class SuburItemServiceImpl extends SuburItemServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.SuburItemServiceUtil} to access the subur item remote service.
	 */
	
	public SuburItem getSuburItem(long suburItemId) throws NoSuchItemException,SystemException, PrincipalException, PortalException 
	{
		SuburItemPermission.check(getPermissionChecker(), suburItemId, ActionKeys.VIEW);
		
		return suburItemPersistence.findByPrimaryKey(suburItemId);
	}
}