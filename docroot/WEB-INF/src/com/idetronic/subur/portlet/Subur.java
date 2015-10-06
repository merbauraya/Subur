package com.idetronic.subur.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idetronic.subur.NoSuchItemException;
import com.idetronic.subur.actionhelper.SuburActionHelper;
import com.idetronic.subur.helper.GetFileActionHelper;
import com.idetronic.subur.model.CopyRequest;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.notification.SuburNotificationHandler;
import com.idetronic.subur.service.CopyRequestLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.service.SuburItemServiceUtil;
import com.idetronic.subur.service.permission.AuthorPermission;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.idetronic.subur.service.permission.SuburModelPermission;
import com.idetronic.subur.service.permission.SuburPermission;
import com.idetronic.subur.util.SuburConfiguration;
import com.idetronic.subur.util.SuburConstant;
import com.idetronic.subur.util.SuburFileUtil;
import com.idetronic.subur.util.SuburFolderUtil;
import com.idetronic.subur.util.SuburUtil;
import com.idetronic.subur.util.WebKeys;
import com.liferay.portal.NoSuchResourceException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

public class Subur extends MVCPortlet {
	private static Log logger = LogFactoryUtil.getLog(Subur.class);
	private static final String _TEMP_FOLDER_NAME_ATTACHMENT = Subur.class.getName();

	PortletRequest _request = null;
	ThemeDisplay themeDisplay;
	
	
	public void processEvent(EventRequest request,EventResponse response) throws PortletException, IOException 
	{
		
		Event event = request.getEvent();
        String value = (String) event.getValue();
        logger.info("event");
		
       // if (event.getName().equalsIgnoreCase("categoryNav"))
        //{
        response.setRenderParameter("jspPage", "/html/view.jsp");
        response.setRenderParameter("filtered", Boolean.TRUE.toString());
       // }
	}
	
	
	
	
	public void newItem(ActionRequest request,ActionResponse response) throws PortalException, SystemException 
	{
		themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		
		String title = ParamUtil.getString(request, "title");
		String[] itemTypeString = ParamUtil.getParameterValues(request, "itemType");
		String itemAbstract = ParamUtil.getString(request, "itemAbstract");
		String otherTitle = ParamUtil.getString(request, "otherTitle");
		
		
	
		
		long[] itemTypeIds = new long[itemTypeString.length];
		for (int i = 0; i < itemTypeString.length; i++)
		{
			itemTypeIds[i] = Long.valueOf(itemTypeString[i]);
			
		}
		
		ServiceContext serviceContext;
		try {
			serviceContext = ServiceContextFactory.getInstance(
			         SuburItem.class.getName(), request);
			
			SuburItem item = SuburItemLocalServiceUtil.addItem(themeDisplay.getUserId(), 
					themeDisplay.getScopeGroupId(),title, itemAbstract, itemTypeIds, serviceContext);
			
			
			request.setAttribute("itemId", String.valueOf(item.getItemId()));
			
			
			response.setRenderParameter("jspPage","/html/deposit.jsp");
			
		} catch (PortalException e) {
			logger.error(e);
			throw new PortalException(e);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new SystemException(e);
		}
		
		
		
		
		
		
		
		
	}
	/**
	 * Publish a subur item
	 * @param request
	 * @param response
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws IOException 
	 */
	public void publishItem(ActionRequest request,ActionResponse response) throws PortalException, SystemException, IOException
	{
		long itemId = ParamUtil.getLong(request, "itemId");
		String redirect = ParamUtil.getString(request, "redirect");
		SuburItemLocalServiceUtil.publishItem(itemId);
		if (Validator.isNotNull(redirect))
			response.sendRedirect(redirect);
		
	}
	/**
	 * Withdraw an item from public viewing
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException 
	 */
	public void withdrawItem(ActionRequest request,ActionResponse response) throws PortalException, SystemException, IOException
	{
		long itemId = ParamUtil.getLong(request, "itemId");
		String redirect = ParamUtil.getString(request, "redirect");
		SuburItemLocalServiceUtil.withDrawItem(itemId);
		if (Validator.isNotNull(redirect))
			response.sendRedirect(redirect);
	}
	/**
	 * delete Subur Item /or move to thrash if supported
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deleteItem(ActionRequest request,ActionResponse response) throws IOException
	{
		
		String cmd = ParamUtil.getString(request, Constants.CMD);
		logger.info(cmd);
		String redirect = ParamUtil.getString(request, "redirect");
		long itemId = ParamUtil.getLong(request, "itemId");
		if (cmd.equals(Constants.DELETE)){
			
			SuburItemLocalServiceUtil.deleteItem(itemId);
			
		}
		else if (cmd.equals(Constants.MOVE_TO_TRASH)){
			//todo process thrash
		}
		if (Validator.isNotNull(redirect))
			response.sendRedirect(redirect);
		
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException 
	 */
	public void depositItem(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException, IOException
	{
		_request = actionRequest;
		long userId = PortalUtil.getUser(actionRequest).getUserId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         SuburItem.class.getName(), actionRequest);
		
		
		themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		
		
		
		long itemId = ParamUtil.getLong(uploadRequest, "itemId");
		
		String itemTypeString = ParamUtil.getString(uploadRequest, "itemType");
		
		long[] itemTypeIds = getLongArray(uploadRequest,"itemType");
		String redirect = ParamUtil.getString(uploadRequest, "redirect");
	
		boolean relatedRestricted = ParamUtil.getBoolean(uploadRequest, "relatedRestricted");
		String title = ParamUtil.getString(uploadRequest, "title");
		String language = ParamUtil.getString(uploadRequest, "language");
		int itemStatus = ParamUtil.getInteger(uploadRequest, "itemStatus");
		
		String itemAbstract = ParamUtil.getString(uploadRequest, "itemAbstract");
		
		
		String categoryIds = ParamUtil.getString(uploadRequest, "categoryIds");
		
		categoryIds = StringUtil.replace(categoryIds, ",,",",");
		String authorIdsString = ParamUtil.getString(uploadRequest, "authorsSearchContainerPrimaryKeys");
		String assetLinkEntryIdsString = ParamUtil.getString(uploadRequest,
				"assetLinksSearchContainerPrimaryKeys");
		
		
		
		
		//selected temp file for upload
		String[] selectedFiles = uploadRequest.getParameterValues("selectUploadedFileCheckbox");
		long[] fileEntries = {};		
		if (selectedFiles != null)
			fileEntries = processTempFile(selectedFiles,actionRequest,themeDisplay);
		
		long[] assetLinkEntryIds = {};
		
		if (assetLinkEntryIdsString != null) {
			assetLinkEntryIds = StringUtil.split(
				assetLinkEntryIdsString, 0L);

			
		}
		
		assetLinkEntryIds = SuburUtil.mergeRelatedAssetWithDlFileEntry(assetLinkEntryIds, fileEntries);
		serviceContext.setAssetLinkEntryIds(assetLinkEntryIds);		
		
		long[] authorIds = StringUtil.split(GetterUtil.getString(authorIdsString), 0L);
		
		
		//handle categories
		long[] catIds = new long[]{};
		
		if (!categoryIds.isEmpty())
		{
			String[] catIdsArr = categoryIds.split(",");
			catIds= new long[catIdsArr.length];
			for (int i = 0;i < catIdsArr.length; i++)
			{
				if (catIdsArr[i].length()>0)
					catIds[i] = Long.parseLong(catIdsArr[i]);
				
			}
		}
		//fail safe remove 0 from array if any
		if (ArrayUtil.isNotEmpty(catIds))
		{
			catIds = ArrayUtil.remove(catIds, 0L);		
		}
		String tags = ParamUtil.getString(uploadRequest, "assetTagNames");
		
		String[] tagNamesArr = null;
		if (!tags.isEmpty())
		{
			tagNamesArr = tags.split(",");
		}
		
		
		//Serie / Report No
		String serieReportNoIndexesString = uploadRequest.getParameter("serieReportNoIndexes");
		int[] serieReportNoIndexes = StringUtil.split(serieReportNoIndexesString, 0);

		
		
		Map<String,String> serieReportNoMap = new HashMap<String,String>();
		for (int serieReportNoIndex : serieReportNoIndexes)
		{
			String serieName = ParamUtil.getString(uploadRequest, "serie"+serieReportNoIndex);
			String reportNo = ParamUtil.getString(uploadRequest, "reportNo"+serieReportNoIndex);
			serieReportNoMap.put(serieName, reportNo);
			
			
		}
		
		//identifier
		String identifierIndexesString = ParamUtil.getString(uploadRequest, "itemIdentifierIndexes");
		int[] identifierIndexes = StringUtil.split(identifierIndexesString, 0);
		
		Map<String,String> itemIdentifierMap = new HashMap<String,String>();
		for (int itemIdentifierIndex : identifierIndexes)
		{
			String identName = ParamUtil.getString(uploadRequest, "identName"+itemIdentifierIndex);
			String identValue = ParamUtil.getString(uploadRequest, "identValue"+itemIdentifierIndex); 
			if (Validator.isNotNull(identValue) && identValue.length() > 0)
			{
				itemIdentifierMap.put(identName, identValue);
			}
		}
		
		
		//end identifier
		
		//other titles
		String otherTitleIndexesString = uploadRequest.getParameter(
				"otherTitleIndexes");
		
		
		
		int[] otherTitleIndexes = StringUtil.split(otherTitleIndexesString, 0);
		String[] otherTitles = new String[otherTitleIndexes.length];
		int i = 0;
		for (int otherTitleIndex : otherTitleIndexes) {
			
			String otherTitle = ParamUtil.getString(uploadRequest, "otherTitle"+otherTitleIndex);
			if (Validator.isNull(otherTitle))
				continue;
			otherTitles[i] = otherTitle;
			i++;
			
		
		}
		
		//author profile photo
		
		
		try {
			SuburItem suburItem = SuburItemLocalServiceUtil.getSuburItem(itemId);
						
			suburItem.setTitle(title);
			suburItem.setLanguage(language);
			suburItem.setItemAbstract(itemAbstract);
			suburItem.setStatus(itemStatus);
			suburItem.setOtherTitle(otherTitles);
			suburItem.setSeriesReportNo(serieReportNoMap);
			suburItem.setIdentifier(itemIdentifierMap);
			suburItem.setRelatedRestricted(relatedRestricted);
			serviceContext.setAssetTagNames(tagNamesArr);
			serviceContext.setAssetCategoryIds(catIds);
			
			
			SuburItemLocalServiceUtil.updateSuburItem(suburItem, userId, itemTypeIds, authorIds, serviceContext);
			
			if (Validator.isNotNull(redirect))
				actionResponse.sendRedirect(redirect);
			
		} catch (PortalException e) {
			//SessionErrors.add(request, e.getClass().getName());
			e.printStackTrace();
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * Serve DLFileEntry for download rather than opening in DL Portlet
	 * Param given is Asset Entry id
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public void serveFile(ActionRequest actionRequest,ActionResponse actionResponse) 
	{
		
		long fileAssetId = ParamUtil.getLong(actionRequest, "fileAssetId");
		long itemId = ParamUtil.getLong(actionRequest, "itemId");
		
		HttpServletResponse response =  PortalUtil.getHttpServletResponse(actionResponse);
		HttpServletRequest request =  PortalUtil.getHttpServletRequest(actionRequest);
		
		AssetEntry assetEntry;
		try {
			assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(fileAssetId);
			long dlFileEntryId = assetEntry.getClassPK();
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(dlFileEntryId);// .getFile(userId, dlFileEntryId, version, incrementCounter);
			FileEntry fe = DLAppServiceUtil.getFileEntry(dlFileEntryId);
			String version = fe.getVersion();
			
			
			FileVersion fv = fe.getFileVersion(version);
			InputStream fis = fv.getContentStream(true);
			String fileName = fv.getTitle();
			long contentLength = fv.getSize();
			String contentType = fv.getMimeType();
			
			
			
			
			
			
			//byte[] fileContent = SuburUtil.inputStreamToByteArray(is);
			String contentDispositionType = "Content-Disposition,attachment; filename= " + fileName;
			
			//ServletResponseUtil.sendFile(request, response, fileName, fis,contentLength,contentType,contentDispositionType);
			
			ServletResponseUtil.sendFile(request, response, fileName, fis,contentLength,contentType);//,contentDispositionType);

			//set download stat
			SuburItemLocalServiceUtil.addDownloadStats(itemId);
			
			// Hide default Success Message
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);

			// Hide default Error Message
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				ServletResponseUtil.write(response, "Error serving file");
			} catch (IOException e1) {
				logger.error(e1);
				
			}
		}
		
		
	}
	
	public String fileUpload (RenderRequest request, RenderResponse response, PortletRequest portletRequest) {
			PortletSession portletSession = request.getPortletSession(false);
			long uploadFolderId = 0;
			long uploadedAttachmentId = 0;

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(portletRequest);

			
			ServiceContext serviceContext = null;
			try {
			serviceContext = ServiceContextFactory.getInstance(request);
			} catch (Exception e) {
			logger.error("Exception in fileUpload method");
			} 

	

			return "success";
			}
	
	
	
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException 
	{
		themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		//logger.info(resource);
		String resourceId = resourceRequest.getResourceID();
		
		
		
		if (Validator.equals(resourceId,SuburConstant.RESOURCE_SERVE_FILE))
		{
			HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
			GetFileActionHelper fileAction = new GetFileActionHelper();
			logger.info("inside");
			try 
			{
				
				fileAction.processRequest(request,response);
				return;
				
			}catch (Exception e)
			{
				
			}
			//getFile(long fileEntryId,name,version);
		}
		
		
		if (Validator.equals(resourceId,SuburConstant.RESOURCE_UPLOAD_FILE))
		{
			PrintWriter out=resourceResponse.getWriter();
			JSONObject jSubject = JSONFactoryUtil.createJSONObject();
			try {
				long fileEntryId = uploadFile(resourceRequest,resourceResponse);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId) ;
				
				jSubject.put("fileName", fileEntry.getTitle());// .getName());
				jSubject.put("fileSize", fileEntry.getSize());
				jSubject.put("fileId", fileEntry.getFileEntryId());
				jSubject.put("status","success");
			
			}catch (Exception e)
			{
				jSubject.put("status","failed");
			}
			out.print(jSubject.toString());
		}
		
	
		
	}
	
	/**
	 * Move selected temporary file into appropriate folder during item update
	 * @param selectedFile list of selected temporary file id
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private long[] processTempFile(String[] selectedFile,ActionRequest actionRequest, ThemeDisplay themeDisplay)
	{
		
		
		List<FileEntry> tempFileEntrys = new ArrayList<FileEntry>();
		
		long[] fileEntries = {};
		
		long folderId = SuburFolderUtil.getFolderId(actionRequest, themeDisplay,SuburFolderUtil.FOLDER_ITEM_ATTACHMENT);
		String changeLog = StringPool.BLANK;
		String description = StringPool.BLANK;
		boolean incrementCounter = false;
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		try
	    {
	        
	        long userId = themeDisplay.getUserId();
	        long groupId = themeDisplay.getScopeGroupId();
	        
	        

	        if(selectedFile != null)
	        {
	            for(int i = 0; i < selectedFile.length; ++i)
	            {
	                FileEntry tmpfile = TempFileUtil.getTempFile(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), selectedFile[i], SuburConstant.TEMP_UPLOAD_FOLDER);
	                if(tmpfile!=null && tmpfile.getTitle()!=null && (!tmpfile.getTitle().equals("")))
	                {
	                    tempFileEntrys.add(tmpfile);
	                    System.out.println("file: " + tmpfile.getTitle());
	                }
	            }
	        }
	        fileEntries = new long[tempFileEntrys.size()];
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
	        		
        	
        	serviceContext.setAddGuestPermissions(true);
        	serviceContext.setAddGroupPermissions(true);
        	long fileEntryTypeId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_ALL;
        	serviceContext.setAttribute("fileEntryTypeId", fileEntryTypeId);
        	
        	//serviceContext.setGuestPermissions(guestPermissions);
	        for (int i = 0; i < tempFileEntrys.size(); i++)  //(FileEntry tmpFileEntry : tempFileEntrys)
	        {
	        	FileEntry tmpFileEntry = tempFileEntrys.get(i);
	        	long fileEntryId = tmpFileEntry.getFileEntryId();
	        	File file = DLFileEntryLocalServiceUtil.getFile(userId, fileEntryId, tmpFileEntry.getVersion(), incrementCounter);

	        	
	        	String version = tmpFileEntry.getVersion();
	        	String sourceFileName = file.getName() + "."+ tmpFileEntry.getExtension();
	        	String title = tmpFileEntry.getTitle();
	        	String mimeType = tmpFileEntry.getMimeType();
	        	
	        	String extension = tmpFileEntry.getExtension();
	        	long repositoryId = themeDisplay.getScopeGroupId();
	        	
	        	
	        	
	    	    FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, sourceFileName, mimeType, title,
						description, changeLog, file,serviceContext);
		        
		        
		        
		        fileEntries[i] = fileEntry.getFileEntryId();
	        }
	        
	        
	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        
	    }
	    finally
	    {
	        //delete all tmp files uploaded in liferay tmp folder
	        for (FileEntry tmp : tempFileEntrys) 
	        {
	            try 
	            {
	                TempFileUtil.deleteTempFile(tmp.getFileEntryId());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return fileEntries;
	}
	
	private long uploadFile(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException {
        UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
        File file = uploadRequest.getFile("myFile");
        String fileName = uploadRequest.getFileName("myFile");
        
        themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long folderId = SuburFolderUtil.getFolderId(resourceRequest, themeDisplay,SuburFolderUtil.FOLDER_ITEM_ATTACHMENT);
		long fileEntryId = SuburFileUtil.addFile(resourceRequest, folderId, file,fileName);
		long entryType = 0;
		
		return fileEntryId;
		
		
    }
	
	public void manageTempFileUpload(ActionRequest request,ActionResponse response) throws Exception
	{
		
		
		
		//upload file in liferay tmp folder
	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
	    ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	    //long folderId = SuburFolderUtil.getFolderId(request, themeDisplay);// .xxx();  ParamUtil.getLong(uploadPortletRequest, "folderId");
	    long folderId = ParamUtil.getLong(uploadPortletRequest, "folderId");

	    String sourceFileName = uploadPortletRequest.getFileName("file");
	    long itemId=ParamUtil.getLong(request, "suburItemId");
	    
	    File file;
	    String title = sourceFileName;
	    String description = null;
	    String changeLog = StringPool.BLANK;
	    
	    InputStream inputStream = null;
	    
	    try 
	    {
	        inputStream = uploadPortletRequest.getFileAsStream("file");
	        file = uploadPortletRequest.getFile("file");
	        String mimeType = MimeTypesUtil.getContentType(file);
	        String contentType = uploadPortletRequest.getContentType("file");
	        //FileEntry fileEntry = DLAppServiceUtil.addFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName, mimeType, title, description, changeLog, file,  new ServiceContext());
	        
	        DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName,SuburConstant.TEMP_UPLOAD_FOLDER, inputStream, contentType);
	        
	        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	        jsonObject.put("name", sourceFileName);
	        jsonObject.put("title", sourceFileName);
	        writeJSON(request, response, jsonObject);
	        
	        /*
	        long fileEntryId = fileEntry.getFileEntryId();
	        //attach uploaded file to item
	        ItemFileEntryLocalServiceUtil.add(itemId, fileEntryId, 0);
	        
	        
	        //DLAppServiceUtil.addTempFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileName,_TEMP_FOLDER_NAME_ATTACHMENT, inputStream, contentType);
	        
	        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	        jsonObject.put("name", sourceFileName);
	        jsonObject.put("title", sourceFileName);
	        writeJSON(request, response, jsonObject);*/
	    }
	    catch (Exception e)
	    {
	    	
	    	UploadException uploadException =(UploadException)request.getAttribute(WebKeys.UPLOAD_EXCEPTION);
	        if ((uploadException != null) &&uploadException.isExceededSizeLimit()) 
	        {
	            throw new FileSizeException(uploadException.getCause());
	        }
	        else 
	        {
	            logger.error(e);
	        	throw e;
	        }
	    }
	    finally 
	    {
	        StreamUtil.cleanUp(inputStream);
	    }
	}
	/**
	 * Delete temp uploaded files
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void deleteTempFile(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException 
	{
	    //delete file from liferay tmp folder, before uploaded
	    ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
	    long folderId = SuburFolderUtil.getFolderId(servletRequest, themeDisplay);
	    String fileName = ParamUtil.getString(actionRequest, "fileName");
	    long itemId = ParamUtil.getLong(actionRequest, "suburItemId");
	    
	    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	    try 
	    {
	    	DLAppServiceUtil.deleteTempFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName,SuburConstant.TEMP_UPLOAD_FOLDER);
	        jsonObject.put("deleted", Boolean.TRUE);
	    }
	    catch (Exception e) 
	    {
	        String errorMessage = themeDisplay.translate("an-unexpected-error-occurred-while-deleting-the-file");
	        jsonObject.put("deleted", Boolean.FALSE);
	        jsonObject.put("errorMessage", errorMessage);
	    }
	    writeJSON(actionRequest, actionResponse, jsonObject);
	}
	/**
	 * Guest request for restricted access to related item. We create a RequestCopy entry and
	 * create notification event to portal admin.
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException 
	 */
	public void saveRequestCopy(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException, IOException
	{
	    ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    long companyId = themeDisplay.getCompanyId();
	    long groupId = themeDisplay.getScopeGroupId();
		
		String fromEmailAddress = ParamUtil.getString(actionRequest, "fromEmailAddress");
		String reason = ParamUtil.getString(actionRequest, "reason");
		String organization = ParamUtil.getString(actionRequest, "organization");
		long suburItemId = ParamUtil.getLong(actionRequest, "suburItemId");
		String requesterName = ParamUtil.getString(actionRequest, "requesterName");
		
		CopyRequest copyRequest = CopyRequestLocalServiceUtil.addCopyRequest(suburItemId, requesterName,fromEmailAddress, 
				organization, reason,companyId,groupId);
		
		//add notification to admin
		//UserNotificationEventLocalServiceUtil//
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
	    payloadJSON.put("userId", themeDisplay.getUserId());
	    payloadJSON.put("copyRequestId", copyRequest.getCopyRequestId());
	    payloadJSON.put("itemId", suburItemId);
	    
	    payloadJSON.put("additionalData", "Your notification was added!");
		
	    ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
	    
	    //who will receive the notification
	    String notificationRoleString = SuburConfiguration.getConfig(SuburConfiguration.NOTIFICATION_ROLES);
	    long[] notificationRoles = StringUtil.split(notificationRoleString, 0L);
	    
	    long[] notificationUsers = SuburUtil.getUserByRole(themeDisplay.getCompanyId(), notificationRoles);
	   
	    
	    for (long userId : notificationUsers)
	    {
		    UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId, 
		    		SuburNotificationHandler.PORTLET_ID, 
		    		(new Date()).getTime(),
		    		themeDisplay.getUserId(),
		    		payloadJSON.toString(),
		    		false, serviceContext);	
		    
		    
		    
	    }
		
		actionResponse.setRenderParameter("jspPage","/html/subur/request_copy_success.jsp");
		actionRequest.setAttribute(WebKeys.SUBUR_COPY_REQUEST, copyRequest);
		
	}
	
	public void approveRestrictedRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, SystemException 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long copyRequestId = ParamUtil.getLong(actionRequest, "copyRequestId");
		long suburItemId = ParamUtil.getLong(actionRequest, "suburItemId");
		
		
		try {
			SuburActionHelper.approveRequestCopy(actionRequest, actionResponse);
			CopyRequestLocalServiceUtil.approveRequest(copyRequestId, themeDisplay.getUserId());
		} catch (PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PortletException(e);
		}
		
		
		
	}
	
	public void rejectRestrictedRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws AddressException, SystemException, PortalException, PortletException
	{
		long copyRequestId = ParamUtil.getLong(actionRequest, "copyRequestId");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		SuburActionHelper.rejectRequestCopy(actionRequest, actionResponse);
		CopyRequestLocalServiceUtil.rejectRequest(copyRequestId,themeDisplay.getUserId());
		
	}
	
	protected long[] getLongArray(PortletRequest portletRequest, String name) {
		String value = portletRequest.getParameter(name);

		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}
	protected long[] getLongArray(UploadRequest request, String name) {
		String value = request.getParameter(name);
		logger.info(value);
		if (value == null) {
			return null;
		}

		return StringUtil.split(GetterUtil.getString(value), 0L);
	}
	protected void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (SessionErrors.contains(
				renderRequest, NoSuchResourceException.class.getName()) ||
				SessionErrors.contains(renderRequest, NoSuchItemException.class.getName()) ||
				SessionErrors.contains(	renderRequest, PrincipalException.class.getName())) 
		{
			
			
			
			include("/html/error.jsp", renderRequest, renderResponse);
		}
		else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}
	
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException,IOException
		
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		//PortletProps.set("mykey", "myvalue");
	
		
	
		SessionErrors.clear(renderRequest);
		try 
		{
			
			checkRenderPermission(renderRequest);
			getSuburItem(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchResourceException ||
				e instanceof PrincipalException ||
				e instanceof NoSuchItemException) 
			{
				
				SessionErrors.add(renderRequest, e.getClass());
				SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			}
			else 
			{
				
				throw new PortletException(e);
				
			}
		}

		super.render(renderRequest, renderResponse);
	}
	protected void getSuburItem(PortletRequest portletRequest) throws PrincipalException, 
	PortalException, SystemException,NoSuchItemException
	{
		long suburItemId = ParamUtil.getLong(portletRequest, "itemId");

		if (suburItemId <= 0) {
			return;
		}

		SuburItem suburItem = SuburItemServiceUtil.getSuburItem(suburItemId);

		portletRequest.setAttribute(WebKeys.SUBUR_ITEM, suburItem);
	}
	/**
	 * Check permission based on render request page. If adding/editing, check permissions
	 * @param renderRequest
	 * @throws PrincipalException
	 */
	protected void checkRenderPermission(RenderRequest renderRequest) throws PrincipalException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		
		
		if ((StringUtil.count(mvcPath,"new.jsp") > 0)||
				(StringUtil.count(mvcPath, "deposit.jsp") > 0))
		{
			
			if (!SuburModelPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), ActionKeys.ADD_ENTRY))
			{
				
				throw new PrincipalException();
			}
			
		}
				
				
	}
	
	protected boolean isSessionErrorException(Throwable cause) {
		
		if (
			cause instanceof NoSuchResourceException ||
			cause instanceof PrincipalException	) 
		{
			
			return true;
		}

		return false;
	}
	
	
}
