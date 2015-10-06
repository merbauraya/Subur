package com.idetronic.subur.notification;


import javax.portlet.ActionRequest;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import com.idetronic.subur.portlet.Subur;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

public class SuburNotificationHandler extends BaseUserNotificationHandler 

{
	public static final String PORTLET_ID = "Subur_WAR_Suburportlet";

	
	public SuburNotificationHandler() 
	{
		 
		setPortletId(PORTLET_ID);
 
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
 
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject(userNotificationEvent.getPayload());
 
		long copyRequestId = jsonObject
				.getLong("copyRequestId");
 
		String title = "Visitor has requested access to restricted content ";
				
 
		String bodyText = StringPool.BLANK;// "Some other text.";
 
		LiferayPortletResponse liferayPortletResponse = serviceContext
				.getLiferayPortletResponse();
 
		PortletURL confirmURL = liferayPortletResponse.createActionURL(PORTLET_ID);
 
		confirmURL.setParameter(ActionRequest.ACTION_NAME, "approveRestrictedAccess");
		confirmURL.setParameter("redirect", serviceContext.getLayoutFullURL());
		confirmURL.setParameter("copyRequest", String.valueOf(copyRequestId));
		confirmURL.setParameter("userNotificationEventId", String.valueOf(userNotificationEvent.getUserNotificationEventId()));
		confirmURL.setWindowState(WindowState.NORMAL);
 
		
		
		
		PortletURL ignoreURL = liferayPortletResponse.createActionURL(PORTLET_ID);
		ignoreURL.setParameter(ActionRequest.ACTION_NAME, "denyRestrictedAccess");
		ignoreURL.setParameter("redirect", serviceContext.getLayoutFullURL());
		ignoreURL.setParameter("copyRequestId", String.valueOf(copyRequestId));
		ignoreURL.setParameter("userNotificationEventId", String.valueOf(userNotificationEvent.getUserNotificationEventId()));
		ignoreURL.setWindowState(WindowState.NORMAL);
		
		
		
		PortletURL reviewURL = liferayPortletResponse.createActionURL(PORTLET_ID);
		reviewURL.setParameter(ActionRequest.ACTION_NAME, "viewRequetForRestricted");
		reviewURL.setParameter("mvcPath", "/html/subur/review_restricted_request.jsp");
		reviewURL.setParameter("redirect", serviceContext.getLayoutFullURL());
		reviewURL.setParameter("copyRequestId", String.valueOf(copyRequestId));
		reviewURL.setParameter("userNotificationEventId", String.valueOf(userNotificationEvent.getUserNotificationEventId()));
		reviewURL.setWindowState(WindowState.NORMAL);
		
		String body = StringUtil.replace(getBodyTemplate(), new String[] {
				"[$CONFIRM$]", "[$CONFIRM_URL$]", 
				"[$REVIEW$]", "[$REVIEW_URL$]", 
				"[$IGNORE$]","[$IGNORE_URL$]", 
				"[$TITLE$]", "[$BODY_TEXT$]" }, new String[] {
				serviceContext.translate("approve"), confirmURL.toString(),
				serviceContext.translate("review"), reviewURL.toString(),
				serviceContext.translate("reject"), ignoreURL.toString(),
				title, bodyText });
		
		
		logger.info("not_getbody");
		return body;
	}
 
	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
 
		JSONObject jsonObject = JSONFactoryUtil
				.createJSONObject(userNotificationEvent.getPayload());
 
		long copyRequestId = jsonObject
				.getLong("copyRequestId");
		
		long itemId = jsonObject.getLong("itemId");
		
		LiferayPortletResponse liferayPortletResponse = serviceContext
				.getLiferayPortletResponse();		
 
		PortletURL viewURL = liferayPortletResponse.createRenderURL(PORTLET_ID);// .createActionURL(PORTLET_ID);
		
		viewURL.setParameter(ActionRequest.ACTION_NAME, "showDetails");
		viewURL.setParameter("redirect", serviceContext.getLayoutFullURL());
		viewURL.setParameter("mvcPath", "/html/subur/review_restricted_request.jsp");
		viewURL.setParameter("copyRequestId", String.valueOf(copyRequestId));
		viewURL.setParameter("userNotificationEventId", String.valueOf(userNotificationEvent.getUserNotificationEventId()));
		viewURL.setWindowState(WindowState.NORMAL);
		
		LiferayPortletRequest liferayPortletRequest = serviceContext.getLiferayPortletRequest();
		
		//PortletConfig portletConfig = (PortletConfig) liferayPortletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		ThemeDisplay themeDisplay= (ThemeDisplay)liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//String portletName = portletConfig.getPortletName();
		
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), PORTLET_ID);
		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, PORTLET_ID, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/html/subur/review_restricted_request.jsp");
		portletURL.setParameter("copyRequestId", String.valueOf(copyRequestId));
		portletURL.setParameter("itemId", String.valueOf(itemId));
		
		
		logger.info(portletURL.toString());
		return portletURL.toString();
	}
 
	protected String getBodyTemplate() throws Exception {
		StringBundler sb = new StringBundler(5);
		sb.append("<div class=\"title\">[$TITLE$]</div><div ");
		sb.append("class=\"body\">[$BODY_TEXT$]<a class=\"btn btn-action ");
		sb.append("btn-success\" href=\"[$CONFIRM_URL$]\">[$CONFIRM$]</a>");
		sb.append("<a class=\"btn btn-action btn-info\" href=\"");
		sb.append("[$REVIEW_URL$]\">[$REVIEW$]</a>");
		sb.append("<a class=\"btn btn-action btn-warning\" href=\"");
		sb.append("[$IGNORE_URL$]\">[$IGNORE$]</a></div>");
		
		logger.info(sb.toString());
		return sb.toString();
	}
	
	private static Log logger = LogFactoryUtil.getLog(SuburNotificationHandler.class);
}
