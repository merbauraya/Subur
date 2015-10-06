package com.idetronic.subur.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;
import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.idetronic.subur.util.SuburUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SuburStatisticPortlet
 */
public class SuburStatisticPortlet extends MVCPortlet {
	
	public void updateStats(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ViewSummaryLocalServiceUtil.updateStats(themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());
		DownloadSummaryLocalServiceUtil.updateStats();
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException 
	{
		PrintWriter out=resourceResponse.getWriter();
		//logger.info(SuburUtil.getLineChartData1().);
		out.print(SuburUtil.getLineChartData1());
	}
 
	private static Log logger = LogFactoryUtil.getLog(SuburStatisticPortlet.class);

}
