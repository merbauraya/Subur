package com.idetronic.subur.social;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.idetronic.subur.util.SuburURLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.trash.util.TrashUtil;

public class SuburActivityInterpreter extends BaseSocialActivityInterpreter
{

	
	@Override
	public String[] getClassNames() 
	{
		return _CLASS_NAMES;
	}
	
	protected String getBody(
			SocialActivity activity, ServiceContext serviceContext)
		throws Exception {
		
		return null;
		/*
		SuburItem suburItem = SuburItemLocalServiceUtil.getSuburItem(
			activity.getClassPK());

		if (TrashUtil.isInTrash(
				SuburItem.class.getName(), suburItem.getItemId())) 
		{

			return StringPool.BLANK;
		}
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		
		StringBundler sb = new StringBundler(5);
		
		AssetRendererFactory assetRendererFactory =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(
				SuburItem.class.getName());

		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(
			suburItem.getItemId());
		
		
		sb.append("<a href='");
		String viewURL = SuburURLUtil.getItemViewURL(themeDisplay, activity.getClassPK());
		
		sb.append(viewURL);
		sb.append("'>");
		String title = suburItem.getTitle();
		sb.append(title);
		sb.append("</a>");
		
		
		//return sb.toString();
		 
		 */
	}
	
	@Override
	protected String getPath(
		SocialActivity activity, ServiceContext serviceContext) throws PortalException, SystemException 
	{

		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		return SuburURLUtil.getItemViewURL(themeDisplay, activity.getClassPK());
	
	}
	
	protected String getTitlePattern(
			String groupName, SocialActivity activity) 
	{
			
			int activityType = activity.getType();

			if (activityType == SuburActivityKeys.ADD_SUBUR_PUBLICATION) {
				if (Validator.isNull(groupName)) {
					return "activity-subur-add-publication";
				}
				else {
					return "activity-subur-add-publication-in";
				}
			}
			else if (activityType == SocialActivityConstants.TYPE_MOVE_TO_TRASH) {
				if (Validator.isNull(groupName)) {
					return "activity-subur-publication-move-to-trash";
				}
				else {
					return "activity-subur-publication-move-to-trash-in";
				}
			}
			else if (activityType ==
						SocialActivityConstants.TYPE_RESTORE_FROM_TRASH) {

				if (Validator.isNull(groupName)) {
					return "activity-subur-publication-restore-from-trash";
				}
				else {
					return "activity-subur-publication-restore-from-trash-in";
				}
			}
			else if (activityType == SuburActivityKeys.UPDATE_SUBUR_PUBLICATION) {
				if (Validator.isNull(groupName)) {
					return "activity-subur-update-publication";
				}
				else {
					return "activity-subur-update-publication-in";
				}
			}

			return null;
		}
	
	protected boolean hasPermissions(
			PermissionChecker permissionChecker, SocialActivity activity,
			String actionId, ServiceContext serviceContext)
		throws Exception {

		SuburItem suburItem =
			SuburItemLocalServiceUtil.getSuburItem(activity.getClassPK());

		return SuburItemPermission.contains(
			permissionChecker, suburItem, actionId);
	}

	
	private static final String[] _CLASS_NAMES = {SuburItem.class.getName()};
	private static Log LOGGER = LogFactoryUtil.getLog(SuburActivityInterpreter.class);
	private static String PORTLET_NAME = "Subur_WAR_Suburportlet";
}
