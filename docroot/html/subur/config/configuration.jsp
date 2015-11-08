<%@include file="/html/subur/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String tabs2 = ParamUtil.getString(request, "tabs2", "display-settings");
	String emailFromName = ParamUtil.getString(request, "preferences--emailFromName--", SuburUtil.getEmailFromName(portletPreferences, company.getCompanyId()));
	String emailFromAddress = ParamUtil.getString(request, "preferences--emailFromAddress--", SuburUtil.getEmailFromAddress(portletPreferences, company.getCompanyId()));

	boolean emailEntryAddedEnabled = ParamUtil.getBoolean(request, "preferences--emailEntryAddedEnabled--", SuburUtil.getEmailEntryAddedEnabled(portletPreferences));
	boolean emailEntryUpdatedEnabled = ParamUtil.getBoolean(request, "preferences--emailEntryUpdatedEnabled--", SuburUtil.getEmailEntryUpdatedEnabled(portletPreferences));

	String emailParam = StringPool.BLANK;
	String defaultEmailSubject = StringPool.BLANK;
	String defaultEmailBody = StringPool.BLANK;
	 

	if (tabs2.equals("entry-added-email")) {
		emailParam = "emailEntryAdded";
		defaultEmailSubject =  PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_ADDED_SUBJECT);
		defaultEmailBody = PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_ADDED_BODY); 
	}
	else if (tabs2.equals("entry-updated-email")) {
		emailParam = "emailEntryUpdated";
		defaultEmailSubject = PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_UPDATED_SUBJECT);
		defaultEmailBody = PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_UPDATED_BODY);
	}

	String currentLanguageId = LanguageUtil.getLanguageId(request);
	
	String emailSubjectParam = emailParam + "Subject_" + currentLanguageId;
	String emailBodyParam = emailParam + "Body_" + currentLanguageId;
	 
	String emailSubject = PrefsParamUtil.getString(portletPreferences, request, emailSubjectParam, defaultEmailSubject);
	String emailBody = PrefsParamUtil.getString(portletPreferences, request, emailBodyParam, defaultEmailBody);
	String[] socialBookmarksTypesArray = StringUtil.split(portletPreferences.getValue("socialBookmarksTypes", PortletProps.get(PropsKeys.SOCIAL_BOOKMARK_TYPES)));

%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL">
	<portlet:param name="tabs2" value="<%= tabs2 %>" />
</liferay-portlet:renderURL>

<aui:form action="<%= configurationActionURL  %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="tabs2" type="hidden" value="<%= tabs2 %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
	
	<%
	String tabs2Names = "display-settings,email-from,entry-added-email,entry-updated-email";
	
	%>
	
	<liferay-ui:tabs
		names="<%= tabs2Names %>"
		param="tabs2"
		url="<%= configurationRenderURL %>"
	/>
	
	<c:choose>
		<c:when test='<%= tabs2.equals("email-from") %>'>
			<aui:fieldset>
				<aui:input cssClass="lfr-input-text-container" label="name" name="preferences--emailFromName--" value="<%= emailFromName %>" />

				<aui:input cssClass="lfr-input-text-container" label="address" name="preferences--emailFromAddress--" value="<%= emailFromAddress %>" />
			</aui:fieldset>

			<div class="definition-of-terms">
				<h4><liferay-ui:message key="definition-of-terms" /></h4>

				<dl>
					<dt>
						[$PUBLICATION_STATUS_USER_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-user-who-updated-the-publication" />
					</dd>
					<dt>
						[$PUBLICATION_USER_ADDRESS$]
					</dt>
					<dd>
						<liferay-ui:message key="the-email-address-of-the-user-who-added-the-publication" />
					</dd>
					<dt>
						[$PUBLICATION_USER_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-user-who-added-the-publication" />
					</dd>
					<dt>
						[$COMPANY_ID$]
					</dt>
					<dd>
						<liferay-ui:message key="the-company-id-associated-with-the-publication" />
					</dd>
					<dt>
						[$COMPANY_MX$]
					</dt>
					<dd>
						<liferay-ui:message key="the-company-mx-associated-with-the-publication" />
					</dd>
					<dt>
						[$COMPANY_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-company-name-associated-with-the-publication" />
					</dd>
					<dt>
						[$PORTLET_NAME$]
					</dt>
					<dd>
						<%= HtmlUtil.escape(PortalUtil.getPortletTitle(renderResponse)) %>
					</dd>
					<dt>
						[$SITE_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-site-name-associated-with-the-publication" />
					</dd>
				</dl>
			</div>
		</c:when>
		<c:when test='<%= tabs2.startsWith("entry-") %>'>
			<aui:fieldset>
				<c:choose>
					<c:when test='<%= tabs2.equals("entry-added-email") %>'>
						<aui:input label="enabled" name="preferences--emailEntryAddedEnabled--" type="checkbox" value="<%= emailEntryAddedEnabled %>" />
					</c:when>
					<c:when test='<%= tabs2.equals("entry-updated-email") %>'>
						<aui:input label="enabled" name="preferences--emailEntryUpdatedEnabled--" type="checkbox" value="<%= emailEntryUpdatedEnabled %>" />
					</c:when>
				</c:choose>

				<aui:select label="language" name="languageId" onChange='<%= renderResponse.getNamespace() + "updateLanguage(this);" %>'>

					<%
					Locale[] locales = LanguageUtil.getAvailableLocales(themeDisplay.getSiteGroupId());

					for (int i = 0; i < locales.length; i++) {
						String style = StringPool.BLANK;

						if (Validator.isNotNull(portletPreferences.getValue(emailParam + "Subject_" + LocaleUtil.toLanguageId(locales[i]), StringPool.BLANK)) ||
							Validator.isNotNull(portletPreferences.getValue(emailParam + "Body_" + LocaleUtil.toLanguageId(locales[i]), StringPool.BLANK))) {

							style = "font-weight: bold;";
						}
					%>

						<aui:option label="<%= locales[i].getDisplayName(locale) %>" selected="<%= currentLanguageId.equals(LocaleUtil.toLanguageId(locales[i])) %>" style="<%= style %>" value="<%= LocaleUtil.toLanguageId(locales[i]) %>" />

					<%
					}
					%>

				</aui:select>

				<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "preferences--" + emailSubjectParam + "--" %>' value="<%= emailSubject %>" />

				<aui:field-wrapper label="body">
					<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />

					<aui:input name='<%= "preferences--" + emailBodyParam + "--" %>' type="hidden" />
				</aui:field-wrapper>
			</aui:fieldset>

			<div class="definition-of-terms">
				<h4><liferay-ui:message key="definition-of-terms" /></h4>
				
				<dl>
	
					
					<dt>
						[$PUBLICATION_USER_ADDRESS$]
					</dt>
					<dd>
						<liferay-ui:message key="the-email-address-of-the-user-who-added-the-publication" />
					</dd>
					<dt>
						[$PUBLICATION_USER_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-user-who-added-the-publication" />
					</dd>
					<dt>
						[$PUBLICATION_URL$]
					</dt>
					<dd>
						<liferay-ui:message key="the-publication-url" />
					</dd>
					<dt>
						[$COMPANY_ID$]
					</dt>
					<dd>
						<liferay-ui:message key="the-company-id-associated-with-the-publication" />
					</dd>
					<dt>
						[$COMPANY_MX$]
					</dt>
					<dd>
						<liferay-ui:message key="the-company-mx-associated-with-the-publication" />
					</dd>
					<dt>
						[$COMPANY_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-company-name-associated-with-the-publication" />
					</dd>
					<dt>
						[$FROM_ADDRESS$]
					</dt>
					<dd>
						<%= HtmlUtil.escape(emailFromAddress) %>
					</dd>
					<dt>
						[$FROM_NAME$]
					</dt>
					<dd>
						<%= HtmlUtil.escape(emailFromName) %>
					</dd>
					<dt>
						[$PORTAL_URL$]
					</dt>
					<dd>
						<%= company.getVirtualHostname() %>
					</dd>
					<dt>
						[$PORTLET_NAME$]
					</dt>
					<dd>
						<%= HtmlUtil.escape(PortalUtil.getPortletTitle(renderResponse)) %>
					</dd>
					<dt>
						[$SITE_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-site-name-associated-with-the-publication" />
					</dd>
					<dt>
						[$TO_ADDRESS$]
					</dt>
					<dd>
						<liferay-ui:message key="the-address-of-the-email-recipient" />
					</dd>
					<dt>
						[$TO_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-name-of-the-email-recipient" />
					</dd>
				</dl>
			</div>

		</c:when>
		<c:when test='<%= tabs2.equals("display-settings") %>'>
			<%@ include file="/html/subur/config/display_settings.jspf" %>
		</c:when>
		<c:when test='<%= tabs2.equals("rss") %>'>
			<liferay-ui:rss-settings
				delta="<%= rssDelta %>"
				displayStyle="<%= rssDisplayStyle %>"
				enabled="<%= enableRSS %>"
				feedType="<%= rssFeedType %>"
			/>
		</c:when>
	</c:choose>
	
	
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>
<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(emailBody) %>";
	}

	function <portlet:namespace />updateLanguage() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = '';

		submitForm(document.<portlet:namespace />fm);
	}

	Liferay.provide(
		window,
		'<portlet:namespace />saveConfiguration',
		function() {
			<c:if test='<%= tabs2.startsWith("entry-") %>'>
				document.<portlet:namespace />fm.<portlet:namespace /><%= emailBodyParam %>.value = window.<portlet:namespace />editor.getHTML();
			</c:if>

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);

	Liferay.Util.toggleBoxes('<portlet:namespace />enableSocialBookmarksCheckbox','<portlet:namespace />socialBookmarksOptions');
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.subur.configuration.jsp";
%>