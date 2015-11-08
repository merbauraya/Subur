<%@ include file="/html/subur/init.jsp" %>
<%


	String viewTab = ParamUtil.getString(request, "tabs1", "draft");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tabs1", viewTab);
	portletURL.setParameter("mvcPath", "/html/admin/subur/my_submission.jsp");
	
%>	
	
	<aui:form action="<%=searchURL%>" name="fm" inlineLabel="<%= true %>">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<%@ include file="/html/admin/subur/toolbar.jsp" %>
	</aui:form>
	
	<liferay-ui:tabs
	names="draft,pending,approved,denied,all "
	portletURL="<%= portletURL %>"
	/>
	<%
		int status = WorkflowConstants.STATUS_ANY;
		if (viewTab.equalsIgnoreCase("draft"))
			status = WorkflowConstants.STATUS_DRAFT;
		else if (viewTab.equalsIgnoreCase("pending"))
			status = WorkflowConstants.STATUS_PENDING;
		else if (viewTab.equalsIgnoreCase("approved"))
			status = WorkflowConstants.STATUS_APPROVED;
		else if (viewTab.equalsIgnoreCase("denied"))
			status = WorkflowConstants.STATUS_DENIED;
		
	
		
	
	%>
	
	<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/subur/admin/my_submission.jsp" />
	<portlet:param name="status" value="<%=String.valueOf(status) %>"/>
</liferay-portlet:renderURL>

<liferay-ui:search-container emptyResultsMessage="there-are-no-items"
	headerNames="Title,Status"
	iteratorURL="<%=iteratorURL %>"
	delta="10"
	deltaConfigurable="true">
	
	
<liferay-ui:search-container-results>
<%
	
	List<SuburItem> itemList = SuburItemLocalServiceUtil.findByGroupAndUserAndStatus(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
			themeDisplay.getUserId(), status, 
		searchContainer.getStart(),searchContainer.getEnd());

	total = SuburItemLocalServiceUtil.countByGroupAndUserAndStatus(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 
			themeDisplay.getScopeGroupId(), status);
	
	results=itemList ;//ListUtil.subList(feedbackList,searchContainer.getStart(), searchContainer.getEnd());
	searchContainer.setTotal(total);
	searchContainer.setResults(itemList);
%>
</liferay-ui:search-container-results>
<liferay-ui:search-container-row className="SuburItem" keyProperty="itemId" modelVar="suburItem">
	<liferay-ui:search-container-column-text
		name="title" property="title" />
	
	<liferay-ui:search-container-column-text name="status">
		
				<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>" status="<%= suburItem.getStatus() %>" />

	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text
				name="createDate"
				buffer="buffer"
	>
		<%
			buffer.append(dateFormatDate.format(suburItem.getCreateDate()));
		%>
	</liferay-ui:search-container-column-text>	
	<liferay-ui:search-container-column-text
				name="status-date"
				buffer="buffer"
	>
		<%
			if (Validator.isNull(suburItem.getStatusDate()))
				buffer.append("not-set");
			else
				buffer.append(dateFormatDate.format(suburItem.getStatusDate()));
		%>
	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text>
		<portlet:renderURL var="editURL">
				<portlet:param name="mvcPath" value="<%=SuburConstant.PAGE_UPDATE_ITEM %>"/>
				<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.EDIT %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%=editURL.toString()  %>" />
	
	</liferay-ui:search-container-column-text>
		
</liferay-ui:search-container-row>
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>"/>
</liferay-ui:search-container>
	
	
	
	