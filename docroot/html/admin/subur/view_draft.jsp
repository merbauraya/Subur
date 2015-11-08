<%@ include file="/html/subur/init.jsp"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil"%>


<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>







<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/subur/admin/view_pending_feedback.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:search-container emptyResultsMessage="there-are-no-items"
	headerNames="Title,Status"
	iteratorURL="<%=iteratorURL %>"
	delta="10"
	deltaConfigurable="true">
	
	
<liferay-ui:search-container-results>
<%
	
	List<SuburItem> itemList = SuburItemLocalServiceUtil.findByGroupAndStatus(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),WorkflowConstants.STATUS_DRAFT,
		searchContainer.getStart(),searchContainer.getEnd());
	total = SuburItemLocalServiceUtil.countByGroupStatus(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),WorkflowConstants.STATUS_DRAFT);
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
</liferay-ui:search-container-row>
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>"/>
</liferay-ui:search-container>