<%@ include file="/html/subur/init.jsp" %>
<%


	String viewTab = ParamUtil.getString(request, "tabs1", "draft");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tabs1", viewTab);
	portletURL.setParameter("mvcPath", "/html/admin/subur/view.jsp");
	
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
	
	<liferay-util:include page="/html/admin/subur/view_publication.jsp" servletContext="<%= application %>" >
		<liferay-util:param name="status" value="<%= String.valueOf(status) %>" />
	
	</liferay-util:include>
	
	
	
	