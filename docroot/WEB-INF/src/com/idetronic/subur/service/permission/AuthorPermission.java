package com.idetronic.subur.service.permission;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class AuthorPermission {
	private static String CLASS_NAME="com.idetronic.subur.model.Author";
	
	public static void check(PermissionChecker permissionChecker,
			long authorId, String actionId) throws PortalException,
			SystemException {
		if (!contains(permissionChecker, authorId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) throws PortalException,
			SystemException {
		
		return permissionChecker.hasPermission(
				groupId, CLASS_NAME, groupId, actionId);
		
	}

}
