<%@ include file="/html/init.jsp" %>

<%
	String pageName = StringPool.BLANK;
	String notificationRoleString = SuburConfiguration.getConfig(SuburConfiguration.NOTIFICATION_ROLES);
	
	long[] notificationRoles = StringUtil.split(notificationRoleString, 0L);
	
%>

<%@ include file="/html/suburadmin/nav.jsp" %>

<portlet:actionURL name="saveNotificationRole" var="saveNotificationgURL">

</portlet:actionURL>

<aui:form method="post" action="<%=saveNotificationgURL%>">
	
	<%
		List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
		
	%>

	<aui:select name="notificationRole" multiple="true" size="10">
<%
	for (Role role : roles)
	{
		boolean addToList = (role.getType() == 1) && !role.getName().equalsIgnoreCase("User")
				&& !role.getName().equalsIgnoreCase("Guest")
				&& !role.getName().equalsIgnoreCase("Owner");
		
		boolean selected = false;
		for (long roleId : notificationRoles)
		{
			if (roleId == role.getRoleId())
			{
				selected = true;
				break;
			}
		}
%>
	
	<c:if test="<%= addToList %>">
		<aui:option value="<%=role.getRoleId() %>" selected="<%= selected %>">
			<%= role.getName() %>
		</aui:option>
	</c:if>
<%
	}
%>
	
	</aui:select>
	

	
	
	<aui:button-row>
	
		<aui:button type="submit" />

		
	
	</aui:button-row>

</aui:form>