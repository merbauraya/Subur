package com.idetronic.subur.actionhelper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.idetronic.subur.model.CopyRequest;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.portlet.Subur;
import com.idetronic.subur.service.CopyRequestLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLink;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.Company;

public class SuburActionHelper {
	
	public static void rejectRequestCopy(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, AddressException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long copyRequestId = ParamUtil.getLong(actionRequest, "copyRequestId");
		long suburItemId = ParamUtil.getLong(actionRequest, "suburItemId");
		
		
		CopyRequest copyRequest = CopyRequestLocalServiceUtil.fetchCopyRequest(copyRequestId);
		
		String toEmail = copyRequest.getFromEmailAddress();
		
		String body = "Thanks you for your request<br/>. We are sorry to inform that your request for restricted content has been rejected";
		//String fromEmail = 
		Company company = CompanyLocalServiceUtil.getCompany(themeDisplay.getCompanyId());
		Locale locale = themeDisplay.getLocale();
		String fromAddress = "no-reply@"+ company.getMx();
		InternetAddress from = new InternetAddress(fromAddress);
		InternetAddress to = new InternetAddress(toEmail);
		
		MailMessage mailMessage = new MailMessage();
		mailMessage.setHTMLFormat(true);
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject("Your request for restricted content has been rejected");
		mailMessage.setBody(body);
		
		MailServiceUtil.sendEmail(mailMessage);
			
		
		
	}
	
	public static void approveRequestCopy(ActionRequest actionRequest, ActionResponse actionResponse)
			 throws PortletException
	{
		
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long copyRequestId = ParamUtil.getLong(actionRequest, "copyRequestId");
		long suburItemId = ParamUtil.getLong(actionRequest, "suburItemId");
		
		
		try 
		{
			CopyRequest copyRequest = CopyRequestLocalServiceUtil.fetchCopyRequest(copyRequestId);
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(SuburItem.class.getName(), suburItemId);
			long assetEntryId = assetEntry.getEntryId();
			List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getDirectLinks(assetEntry.getEntryId());
			
			
			HashMap<String,File> fileAttachments = new HashMap<String,File>();
			for (AssetLink assetLink : assetLinks)
			{
				
				AssetEntry assetLinkEntry = null;

				if (assetLink.getEntryId1() == assetEntryId) {
					assetLinkEntry = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId2());
				}
				else {
					assetLinkEntry = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId1());
				}
				
				assetLinkEntry = assetLinkEntry.toEscapedModel();

				String className = PortalUtil.getClassName(assetLinkEntry.getClassNameId());
				AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
				
				if (!assetRendererFactory.isActive(themeDisplay.getCompanyId())) {
					continue;
				}
				
				AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(assetLinkEntry.getClassPK());
				
				//we only interested in File
				if (assetRenderer.getClassName().equalsIgnoreCase(DLFileEntry.class.getName()))
				{
					long fileEntryId = assetLinkEntry.getClassPK();
					
					DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryId);
					String fileVersion = fileEntry.getVersion();
					File attachment = DLFileEntryLocalServiceUtil.getFile(themeDisplay.getUserId(), 
							fileEntryId, fileVersion, false);
					
					
					fileAttachments.put(fileEntry.getTitle(), attachment);
			
				}
				
				
				
			}
			//
			String toEmail = copyRequest.getFromEmailAddress();
			
			String body = "Thanks you for your request<br/>. You may find the resources you requested in the attachment";
			//String fromEmail = 
			Company company = CompanyLocalServiceUtil.getCompany(themeDisplay.getCompanyId());
			Locale locale = themeDisplay.getLocale();
			String fromAddress = "no-reply@"+ company.getMx();
			InternetAddress from = new InternetAddress(fromAddress);
			InternetAddress to = new InternetAddress(toEmail);
			
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject("Your request for restricted content has been approved");
			mailMessage.setBody(body);
			
			for (Map.Entry<String, File> entry : fileAttachments.entrySet()) {
			    String title = entry.getKey();
			    File fileAttachment = entry.getValue();
			    mailMessage.addFileAttachment(fileAttachment,title);
	
			}
			
			
			
			MailServiceUtil.sendEmail(mailMessage);
			
			
		} catch (SystemException | PortalException | AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(SuburActionHelper.class);

}
