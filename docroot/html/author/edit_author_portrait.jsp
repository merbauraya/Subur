<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/author/init.jsp" %>

<%

long authorId = ParamUtil.getLong(request, "authorId");
		 
Author author = null;
	 
if (authorId > 0)
{
	author = AuthorLocalServiceUtil.fetchAuthor(authorId);
}

long maxFileSize = PrefsPropsUtil.getLong(PropsKeys.USERS_IMAGE_MAX_SIZE) / 1024;
%>

<c:choose>
	<c:when test='<%= SessionMessages.contains(renderRequest, "requestProcessed") %>'>
		<aui:script>
			Liferay.Util.getOpener().<portlet:namespace />changeLogo('<%= author.getPortraitURL(themeDisplay) %>');

			Liferay.Util.getWindow().hide();
		</aui:script>
	
		<img src="<%= author.getPortraitURL(themeDisplay) %>" />
	</c:when>
	
		
	
	<c:otherwise>
		<portlet:actionURL var="editPortraitURL" name="editPortrait">
		</portlet:actionURL>

		<aui:form action="<%= editPortraitURL %>" enctype="multipart/form-data" method="post" name="fm">
			<aui:input name="authorId" type="hidden" value="<%= author.getAuthorId() %>" />
			<aui:input name="cropRegion" type="hidden" />

			<liferay-ui:error exception="<%= FileSizeException.class %>">

				<%
				long fileMaxSize = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE);

				if (fileMaxSize == 0) {
					fileMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);
				}

				fileMaxSize /= 1024;
				%>

				<liferay-ui:message arguments="<%= fileMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= NoSuchFileException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />
			<liferay-ui:error exception="<%= UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />

			

			<aui:fieldset cssClass="lfr-portrait-editor">
				<aui:input autoFocus="<= windowState.equals(WindowState.MAXIMIZED) %>" label='<%= LanguageUtil.format(pageContext, "upload-images-no-larger-than-x-k", maxFileSize, false) %>' name="fileName" size="50" type="file" />

				<div class="lfr-change-logo lfr-portrait-preview" id="<portlet:namespace />portraitPreview">
					<img class="lfr-portrait-preview-img" id="<portlet:namespace />portraitPreviewImg" src="<%= HtmlUtil.escape(author.getPortraitURL(themeDisplay)) %>" />
				</div>

				<aui:button-row>
					<aui:button name="submitButton" type="submit" />

					<aui:button onClick="window.close();" type="cancel" value="close" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>

		<aui:script use="liferay-logo-editor">
			var logoEditor = new Liferay.LogoEditor(
				{
					maxFileSize: '<%= maxFileSize %>',
					namespace: '<portlet:namespace />',
					previewURL: '<portlet:resourceURL><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.GET_TEMP %>" /><portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>" /></portlet:resourceURL>',
					uploadURL: '<portlet:actionURL name="editPortrait"><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>" /></portlet:actionURL>'
				}
			);

			if (Liferay.Util.getTop() !== A.config.win) {
				var dialog = Liferay.Util.getWindow();

				if (dialog) {
					dialog.on('resize:end', logoEditor.resize, logoEditor);
					dialog.on('resize:resize', logoEditor.resize, logoEditor);
					dialog.on('resize:start', logoEditor.resize, logoEditor);
				}
			}
		</aui:script>
	</c:otherwise>
</c:choose>