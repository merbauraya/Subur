package com.idetronic.subur.service.permission;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class ViewSummaryPermission {
	
	public static void check(PermissionChecker permissionChecker,
			long itemId, String actionId) throws PortalException,
			SystemException {
		if (!contains(permissionChecker, itemId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long itemId, String actionId) throws PortalException,
			SystemException {
		SuburItem item = SuburItemLocalServiceUtil.getSuburItem(itemId);
		
		_log.info("itemPermissionContains"+itemId +"="+actionId);
		
		return permissionChecker
				.hasPermission(item.getGroupId(),
						SuburItem.class.getName(), item.getItemId(),
						actionId);
	}
	public static boolean contains(PermissionChecker permissionChecker,
			SuburItem suburItem, String actionId) throws PortalException,
			SystemException {
		
		return permissionChecker
				.hasPermission(suburItem.getGroupId(),
						SuburItem.class.getName(), suburItem.getItemId(),
						actionId);
	}
	
    private static final Log _log = LogFactoryUtil.getLog(ViewSummaryPermission.class);

}
