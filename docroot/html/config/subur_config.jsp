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

<aui:form action="<%= configurationActionURL  %>" method="post" name="fm">
	<%
	String tabs2Names = "display-settings,email-from,entry-added-email,entry-updated-email";
	
	%>
	
	<liferay-ui:tabs
		names="<%= tabs2Names %>"
		param="tabs2"
		url="<%= configurationRenderURL %>"
	/>
	
	
	<aui:input value="<%= enableSocialBookmark %>" type="checkbox" label="enable-social-bookmark" name="preferences--enableSocialBookmark--" />

	<aui:fieldset label="asset-selection">
		<aui:input checked='<%= itemToShow.equals("latest") %>' id="itemToShowLatest" label="show-latest" name="preferences--itemToShow--" onChange='<%= renderResponse.getNamespace() + "chooseSelectionStyle();" %>' type="radio" value="latest" />

		<aui:input checked='<%= itemToShow.equals("popular") %>' id="itemToShowPopular" label="show-popular" name="preferences--itemToShow--" onChange='<%= renderResponse.getNamespace() + "chooseSelectionStyle();" %>' type="radio" value="popular" />
	</aui:fieldset>
	<aui:fieldset label="display-style">
		<aui:select name="preferences--displayStyle--">
			<aui:option label="list" value="list" selected='<%=displayStyle.equals("list") %>' />
			<aui:option label="table" value="table" selected='<%=displayStyle.equals("table") %>' />
			<aui:option label="abstract" value="abstract" selected='<%=displayStyle.equals("abstract") %>' />
			
		
		</aui:select>
		<aui:select helpMessage="number-of-items-to-display-help" label="number-of-items-to-display" name="preferences--delta--">
		
			<%
				int[] pageDelta = {5,10,15,20};
				for (int currentDelta : pageDelta) {
			%>
	
				<aui:option label="<%= currentDelta %>" selected="<%= (delta == currentDelta) %>" />
	
			<%
			}
			%>

		</aui:select>
		
		<aui:select name="preferences--paginationType--">
			<aui:option label="none" selected='<%= paginationType.equals("none") %>' />
			<aui:option label="simple" selected='<%= paginationType.equals("simple") %>' />
			<aui:option label="regular" selected='<%= paginationType.equals("regular") %>' />
		</aui:select>
	
	</aui:fieldset>
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="assetPublisherOrderingAndGroupingPanel" persistState="<%= true %>" title="ordering-and-grouping">
		<aui:fieldset>
			<span class="field-row">
				<aui:select inlineField="<%= true %>" inlineLabel="left" label="order-by" name="preferences--orderByColumn1--">
					
					<aui:option label="title" selected='<%= orderByColumn1.equals("title") %>' />
					<aui:option label="create-date" selected='<%= orderByColumn1.equals("createDate") %>' value="createDate" />
					<aui:option label="modified-date" selected='<%= orderByColumn1.equals("modifiedDate") %>' value="modifiedDate" />
					<aui:option label="publish-date" selected='<%= orderByColumn1.equals("publishDate") %>' value="publishDate" />
					<aui:option label="priority" selected='<%= orderByColumn1.equals("priority") %>' value="priority" />

					
				</aui:select>

				<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType1--">
					<aui:option label="ascending" selected='<%= orderByType1.equals("ASC") %>' value="ASC" />
					<aui:option label="descending" selected='<%= orderByType1.equals("DESC") %>' value="DESC" />
				</aui:select>
			</span>
			<span class="field-row">
				<aui:select inlineField="<%= true %>" inlineLabel="left" label="and-then-by" name="preferences--orderByColumn2--">
					<aui:option label="title" selected='<%= orderByColumn2.equals("title") %>' />
					<aui:option label="create-date" selected='<%= orderByColumn2.equals("createDate") %>' value="createDate" />
					<aui:option label="modified-date" selected='<%= orderByColumn2.equals("modifiedDate") %>' value="modifiedDate" />
					<aui:option label="publish-date" selected='<%= orderByColumn2.equals("publishDate") %>' value="publishDate" />
					<aui:option label="priority" selected='<%= orderByColumn2.equals("priority") %>' value="priority" />

					
				</aui:select>

				<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType2--">
					<aui:option label="ascending" selected='<%= orderByType2.equals("ASC") %>' value="ASC" />
					<aui:option label="descending" selected='<%= orderByType2.equals("DESC") %>' value="DESC" />
				</aui:select>
			</span>
		
		</aui:fieldset>
	
	
	</liferay-ui:panel>
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburItemIdentifierTypePanel" persistState="<%= true %>" title="subur-item">
			
		<aui:input value="<%= itemIdentifier %>" label="item-identifier" name="preferences--itemIdentifier--" />
				
	</liferay-ui:panel>
	
	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="suburDisplayMultipleTagCategoriesPanel" persistState="<%= true %>" title="multiple-tag-and-categories-display">
			
		<aui:input value="<%= useOrOperatorCategorySearch %>" type="checkbox" label="use-or-operator-between-category-search-instead-of-and-operator" name="preferences--useOrOperatorCategorySearch--" />
		<aui:input value="<%= useOrOperatorTagSearch%>" type="checkbox" label="use-or-operator-between-tag-search-instead-of-and-operator" name="preferences--useOrOperatorTagSearch--" />
				
	</liferay-ui:panel>
	<div class="button-holder">
		<aui:button type="submit" value="save"></aui:button>
	</div>
</aui:form>