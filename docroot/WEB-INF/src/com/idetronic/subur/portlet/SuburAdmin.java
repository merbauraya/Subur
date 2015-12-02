package com.idetronic.subur.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
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
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
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
			
			itemType = ItemTypeLocalServiceUtil.add(typeName,themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());
		}else
		{
			itemType  = ItemTypeLocalServiceUtil.getItemType(itemTypeId);
			itemType.setItemTypeName(typeName);
			ItemTypeLocalServiceUtil.updateItemType(itemType);
		}
		response.sendRedirect(redirect);
	}
	
	
	public void saveConfig(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, IOException
	{
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		
		String authorSalutation = ParamUtil.getString(uploadRequest, "authorSalutation");
		String authorSite = ParamUtil.getString(uploadRequest, "authorSite");
		String itemIdentifier = ParamUtil.getString(uploadRequest, "itemIdentifier");
		
		File file = uploadRequest.getFile("license");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
	    StringBuffer licenseContents = new StringBuffer();
	    String line = br.readLine();
	    while (line != null) {
	    	licenseContents.append(line);
	        line = br.readLine();
	    }
		br.close();
		
		
		SuburConfigLocalServiceUtil.updateConfig(SuburConfiguration.AUTHOR_SALUTATION, authorSalutation);
		SuburConfigLocalServiceUtil.updateConfig(SuburConfiguration.AUTHOR_SITES, authorSite);
		SuburConfigLocalServiceUtil.updateConfig(SuburConfiguration.ITEM_IDENTIFIERS, itemIdentifier);
		SuburConfigLocalServiceUtil.updateConfig(SuburConfiguration.PUBLICATION_LICENSE, licenseContents.toString());

		
		
	}
	
	public void saveNotificationRole (ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException
	{
		String notificationRoleArray[] = actionRequest.getParameterValues("notificationRole");
	
		String notificationRoles = StringUtil.merge(notificationRoleArray);
		
		
		
		SuburConfigLocalServiceUtil.updateConfig(SuburConfiguration.NOTIFICATION_ROLES, notificationRoles);
	}
	public void updateStats(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		LOGGER.info(themeDisplay.getCompanyId() + "::" + themeDisplay.getScopeGroupId());
		ViewSummaryLocalServiceUtil.updateStats(themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());
		DownloadSummaryLocalServiceUtil.updateStats();
	}
	public void importSubject (ActionRequest actionRequest,ActionResponse actionResponse) 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		
		try
		{
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					AssetCategory.class.getName(), actionRequest);
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			
			long userId = themeDisplay.getUserId();
			File file = uploadRequest.getFile("file");
			String vocabTitle = ParamUtil.getString(uploadRequest, "title");
			FileInputStream fis = new FileInputStream(file);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			HashMap categoryMap = new HashMap();
			
			//create vocab
			AssetVocabulary parentVocab = createVocabulary(vocabTitle,themeDisplay.getUserId(),serviceContext);
			
			
			String line = null;
			
			
			
			
			while ((line = br.readLine()) != null) 
			{
				//LOGGER.info(line);
				String[] subject = StringUtil.split(line, ":");
				String subjectCode = subject[0];
				String subjectName = subject[1];
				String subjectParent = subject[2];
				String subjectParentKey = subject[3];
				LOGGER.info(subjectCode +":"+ subjectName + ":"+subjectParent+":"+subjectParentKey);

				if (subjectCode.equalsIgnoreCase("subjects"))
					continue;
				
				if (subjectParent.equalsIgnoreCase("subjects"))
				{
					//level 1 subject add category here
					AssetCategory category = createParentCategory(parentVocab.getVocabularyId(),subjectName,
							userId,serviceContext);
					categoryMap.put(subjectCode, category);
				}else
				{
					//create sub category
					AssetCategory parentCategory = (AssetCategory) categoryMap.get(subjectParent);
					AssetCategory subCategory = createSubCategory(actionRequest,subjectName,userId,
							parentVocab.getVocabularyId(),parentCategory.getCategoryId(),serviceContext);
					
					categoryMap.put(subjectCode, subCategory);
				}
				
				//LOGGER.info(subjectCode +":"+ subjectName + ":"+subjectParent+":"+subjectParentKey);
				
				
				
			}
		}catch (Exception e)
		{
			LOGGER.error(e);
		}
		
		
		
		
	}
	private AssetCategory createSubCategory(ActionRequest actionRequest,String title,
			long userId,long vocabularyId,long parentCategoryId,ServiceContext serviceContext) throws PortalException, SystemException
	{
		//List<AssetCategoryProperty> categoryProperties = Collections.emptyList();
		//LOGGER.info("subCategry:"+title);
		
		
		String[] categoryProperties = new String[0];
		
		Map<Locale, String> titleMap = getLocalizationMap(
				 title);
		
		
		String[] permissions = { "VIEW" };
		serviceContext.setGuestPermissions(permissions);
		
		
		Map<Locale, String> descriptionMap = getLocalizationMap(StringPool.BLANK);
		
		return AssetCategoryLocalServiceUtil.addCategory(userId, parentCategoryId, titleMap, descriptionMap, vocabularyId, categoryProperties, serviceContext);
	}
	
	private AssetVocabulary createVocabulary(String title,long userId,ServiceContext serviceContext) throws PortalException, SystemException
	{
		AssetVocabulary vocab = null;
		String[] permissions = { "VIEW" };
		serviceContext.setGuestPermissions(permissions);
		
		vocab = AssetVocabularyLocalServiceUtil.addVocabulary(userId, title, serviceContext);
		return vocab;
	}
	private AssetCategory createParentCategory(long vocabularyId,String title,long userId,ServiceContext serviceContext) throws PortalException, SystemException
	{
		//LOGGER.info("Categry:"+title);
		String[] permissions = { "VIEW" };
		serviceContext.setGuestPermissions(permissions);
		
		return AssetCategoryLocalServiceUtil.addCategory(userId, title, vocabularyId, serviceContext);
		
	}
	private Map<Locale, String> getLocalizationMap(String parameter)
			
	{

			Locale[] locales = LanguageUtil.getAvailableLocales();

			Map<Locale, String> map = new HashMap<Locale, String>();

			for (Locale locale : locales) {
				String languageId = LocaleUtil.toLanguageId(locale);

				String localeParameter = parameter.concat(
					StringPool.UNDERLINE).concat(languageId);

				map.put(
					locale, parameter);
			}

			return map;
		}
	
	private static Log LOGGER = LogFactoryUtil.getLog(SuburAdmin.class);
}
