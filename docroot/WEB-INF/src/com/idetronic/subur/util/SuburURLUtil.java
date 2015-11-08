package com.idetronic.subur.util;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

public class SuburURLUtil 
{
	public static String getItemViewURL(ThemeDisplay themeDisplay,LiferayPortletRequest liferayPortletRequest,long suburItemId) throws PortalException, SystemException
	{
		
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), PORTLET_NAME);
		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, PORTLET_NAME, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/html/renderer/item_full.jsp");
		portletURL.setParameter("itemId", String.valueOf(suburItemId));
		
		return portletURL.toString();
	}
	
	public static String getItemViewURL(ThemeDisplay themeDisplay,long itemId) throws PortalException, SystemException
	{
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), PORTLET_NAME);
		
		PortletURL portletURL = PortletURLFactoryUtil.create(themeDisplay.getRequest(), PORTLET_NAME, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/html/renderer/item_full.jsp");
		portletURL.setParameter("itemId", String.valueOf(itemId));
		
		return portletURL.toString();
		
	}
	
	private static String PORTLET_NAME = "Subur_WAR_Suburportlet";
}
