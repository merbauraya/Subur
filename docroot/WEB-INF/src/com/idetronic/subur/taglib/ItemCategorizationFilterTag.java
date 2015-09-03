package com.idetronic.subur.taglib;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;

public class ItemCategorizationFilterTag extends IncludeTag {
	
	
	final String _PAGE = "/html/taglib/subur/item_categorization_filter.jsp";
	
	private String assetType;
	private PortletURL portletURL; 
	private PortletURL actionURL = null;
	
	public void setAssetType(String assetType)
	{
		this.assetType = assetType;
	}
	public void setPortletURL(PortletURL portletURL)
	{
		this.portletURL = portletURL;
	}
	public void setActionURL(PortletURL actionURL)
	{
		this.actionURL = actionURL;
	}
	public PortletURL getActionURL()
	{
		if (Validator.isNull(actionURL))
		return portletURL;
			else
		return actionURL;
	}
	public String getAssetType()
	{
		return assetType;
	}
	public PortletURL getPortletURL()
	{
		return portletURL;
	}
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:item-categorization-filter:portletURL", getPortletURL());
		request.setAttribute("subur:item-categorization-filter:assetType", getAssetType());
		request.setAttribute("subur:item-categorization-filter:actionURL", getActionURL());
	}
	
	@Override
	protected String getPage() {
		return _PAGE;
	}
	
	private static Log logger = LogFactoryUtil.getLog(ItemCategorizationFilterTag.class);
}
