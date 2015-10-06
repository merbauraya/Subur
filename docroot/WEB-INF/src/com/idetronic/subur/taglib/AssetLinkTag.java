package com.idetronic.subur.taglib;

import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.portlet.Subur;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.taglib.util.IncludeTag;

public class AssetLinkTag extends IncludeTag {
	private long assetEntryId;
	private String nameSpace;
	private ResourceURL serveFileURL;
	private boolean hideTitle = false;
	final String _PAGE = "/html/taglib/subur/asset_links.jsp";
	
	
	public void setHideTitle(boolean hide)
	{
		this.hideTitle = hide;
		
	}
	public boolean getHideTitle()
	{
		return this.hideTitle;
	}
	public void setNameSpace(String nameSpace)
	{
		this.nameSpace = nameSpace;
	}
	public String getNameSpace()
	{
		return nameSpace;
	}
	public void setServeFileURL(ResourceURL serveFileURL)
	{
		this.serveFileURL = serveFileURL;
		
	}
	public ResourceURL getServeFileURL()
	{
		return serveFileURL;
	}
	public void setAssetEntryId(long  assetEntryId)
	{
		this.assetEntryId = assetEntryId;
	}
	public long getAssetEntryId()
	{
		return assetEntryId;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("subur:item-asset-links:assetEntryId", String.valueOf(getAssetEntryId()));
		request.setAttribute("subur:item-asset-links:serveFileURL", getServeFileURL());
		request.setAttribute("subur:item-asset-links:nameSpace", getNameSpace());
		request.setAttribute("subur:item-asset-links:hideTitle", String.valueOf(getHideTitle()));
	}
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected void cleanUp() {
		setAssetEntryId(0);
	}
	/*
	public int doEndTag() throws JspException {
		
		try {
			include(_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}*/
	
	@Override
	protected String getPage() {
		return _PAGE;
	}
	private static Log logger = LogFactoryUtil.getLog(AssetLinkTag.class);
}
