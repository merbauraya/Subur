package com.idetronic.subur.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.DocumentConversionUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

public class GetFileActionHelper {

	public void processRequest(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		try {
			long fileEntryId = ParamUtil.getLong(request, "fileEntryId");
			
			long folderId = ParamUtil.getLong(request, "folderId");
			String name = ParamUtil.getString(request, "name");
			String title = ParamUtil.getString(request, "title");
			String version = ParamUtil.getString(request, "version");

			long fileShortcutId = ParamUtil.getLong(request, "fileShortcutId");

			String uuid = ParamUtil.getString(request, "uuid");

			String targetExtension = ParamUtil.getString(
				request, "targetExtension");

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			long groupId = ParamUtil.getLong(
				request, "groupId", themeDisplay.getScopeGroupId());

			getFile(
				fileEntryId, folderId, name, title, version, fileShortcutId,
				uuid, groupId, targetExtension, request, response);
		}
		catch (NoSuchFileEntryException nsfee) {
			PortalUtil.sendError(
				HttpServletResponse.SC_NOT_FOUND, nsfee, request, response);
		}
		catch (PrincipalException pe) {
			processPrincipalException(pe, request, response);
		}
		catch (Exception e) {
			_log.error("exception ",e);
			PortalUtil.sendError(e, request, response);
		}
	}

	protected void getFile(
			long fileEntryId, long folderId, String name, String title,
			String version, long fileShortcutId, String uuid, long groupId,
			String targetExtension, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		
		
		if (name.startsWith("DLFE-")) {
			name = name.substring(5);
		}

		name = FileUtil.stripExtension(name);

		FileEntry fileEntry = null;

		if (Validator.isNotNull(uuid) && (groupId > 0)) {
			fileEntry = DLAppServiceUtil.getFileEntryByUuidAndGroupId(
				uuid, groupId);

			folderId = fileEntry.getFolderId();
		}
		
		if (fileEntryId > 0) {
			_log.info("getFileEntry:"+fileEntryId);
			fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			
		}else 
		{
			
			DLFileShortcut fileShortcut = DLAppServiceUtil.getFileShortcut(
				fileShortcutId);

			fileEntryId = fileShortcut.getToFileEntryId();

			fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
		}

		if (Validator.isNull(version)) {
			if ((fileEntry != null) &&
				Validator.isNotNull(fileEntry.getVersion())) {

				version = fileEntry.getVersion();
				
			}
			else {
				throw new NoSuchFileEntryException(
					"{fileEntryId=" + fileEntryId + "}");
			}
		}

		FileVersion fileVersion = fileEntry.getFileVersion(version);

		InputStream is = fileVersion.getContentStream(true);

		String fileName = fileVersion.getTitle();
		
		
		String sourceExtension = fileVersion.getExtension();

		if (Validator.isNotNull(sourceExtension) &&
			!fileName.endsWith(StringPool.PERIOD + sourceExtension)) {

			fileName += StringPool.PERIOD + sourceExtension;
		}

		long contentLength = fileVersion.getSize();
		String contentType = fileVersion.getMimeType();

		if (Validator.isNotNull(targetExtension)) {
			String id = DLUtil.getTempFileId(
				fileEntry.getFileEntryId(), version);

			File convertedFile = DocumentConversionUtil.convert(
				id, is, sourceExtension, targetExtension);

			if (convertedFile != null) {
				fileName = FileUtil.stripExtension(fileName).concat(
					StringPool.PERIOD).concat(targetExtension);
				is = new FileInputStream(convertedFile);
				contentLength = convertedFile.length();
				contentType = MimeTypesUtil.getContentType(fileName);
			}
		}
		/*
		FlashMagicBytesUtil.Result flashMagicBytesUtilResult =
			FlashMagicBytesUtil.check(is);

		if (flashMagicBytesUtilResult.isFlash()) {
			fileName = FileUtil.stripExtension(fileName) + ".swf";
		}

		is = flashMagicBytesUtilResult.getInputStream();
		*/
		
		_log.info(fileName+ ":"+ contentLength + ":"+ contentType+ ":");
		ServletResponseUtil.sendFile(
			request, response, fileName, is, contentLength, contentType);
	}

	protected void processPrincipalException(
			Throwable t, HttpServletRequest request,
			HttpServletResponse response)
		throws IOException, ServletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		User user = permissionChecker.getUser();

		if ((user != null) && !user.isDefaultUser()) {
			PortalUtil.sendError(
				HttpServletResponse.SC_UNAUTHORIZED, (Exception)t, request,
				response);

			return;
		}

		String redirect = PortalUtil.getPathMain() + "/portal/login";

		String currentURL = PortalUtil.getCurrentURL(request);

		redirect = HttpUtil.addParameter(redirect, "redirect", currentURL);

		response.sendRedirect(redirect);
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(GetFileActionHelper.class);

}