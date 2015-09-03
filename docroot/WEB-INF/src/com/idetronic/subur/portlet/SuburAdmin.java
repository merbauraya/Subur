package com.idetronic.subur.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.idetronic.subur.NoSuchConfigException;
import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;
import com.idetronic.subur.service.SuburConfigLocalServiceUtil;
import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.idetronic.subur.util.SuburConfiguration;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SuburAdmin
 */
public class SuburAdmin extends MVCPortlet {
 
	public void editItemType(ActionRequest request,ActionResponse response) throws PortalException, SystemException, IOException
	{
		String cmd = ParamUtil.getString(request, "cmd");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
		ItemType itemType = null;
		String redirect = ParamUtil.getString(request, "redirect");
		if (cmd.equalsIgnoreCase(Constants.UPDATE))
			itemType = ItemTypeLocalServiceUtil.getItemType(itemTypeId);
		
		String typeName = ParamUtil.getString(request, "itemTypeName");
		
		if (cmd.equalsIgnoreCase(Constants.ADD))
		{
			itemType = ItemTypeLocalServiceUtil.add(typeName);
		}else
		{
			itemType  = ItemTypeLocalServiceUtil.getItemType(itemTypeId);
			itemType.setItemTypeName(typeName);
			ItemTypeLocalServiceUtil.updateItemType(itemType);
		}
		response.sendRedirect(redirect);
	}
	
	
	public void saveConfig(ActionRequest request, ActionResponse response) throws SystemException
	{
		String authorSalutation = ParamUtil.getString(request, "authorSalutation");
		String authorSite = ParamUtil.getString(request, "authorSite");
		String itemIdentifier = ParamUtil.getString(request, "itemIdentifier");
		
		Map<String,String> authorSalutationMap = new HashMap<String,String>();
		authorSalutationMap.put(SuburConfiguration.AUTHOR_SALUTATION, authorSalutation);
		
		Map<String,String> authorSiteMap = new HashMap<String,String>();
		authorSiteMap.put(SuburConfiguration.AUTHOR_SITES, authorSite);
		
		Map<String,String> itemIdentifierMap = new HashMap<String,String>();
		itemIdentifierMap.put(SuburConfiguration.ITEM_IDENTIFIERS, itemIdentifier);
		
		SuburConfigLocalServiceUtil.updateConfig(authorSalutationMap, SuburConfiguration.AUTHOR_SALUTATION);
		SuburConfigLocalServiceUtil.updateConfig(authorSiteMap, SuburConfiguration.AUTHOR_SITES);
		SuburConfigLocalServiceUtil.updateConfig(itemIdentifierMap, SuburConfiguration.ITEM_IDENTIFIERS);
		
	}
	
	public void updateStats(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		ViewSummaryLocalServiceUtil.updateStats();
		DownloadSummaryLocalServiceUtil.updateStats();
	}
	
	private static Log _log = LogFactoryUtil.getLog(SuburAdmin.class);
}
