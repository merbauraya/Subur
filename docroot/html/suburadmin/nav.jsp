

<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="manageItemTypeURL">
			<portlet:param name="mvcPath" value="/html/suburadmin/item_type.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			 
		</portlet:renderURL>
		<aui:nav-item href="<%= manageItemTypeURL %>" label="manage-item-type" name="manageItemTypeButton" />
	</aui:nav>
	<aui:nav>
		<portlet:renderURL var="manageNotificationURL">
			<portlet:param name="mvcPath" value="/html/suburadmin/notification.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			 
		</portlet:renderURL>
		<aui:nav-item href="<%= manageNotificationURL %>" label="manage-notification" name="manageItemTypeButton" />
		
	</aui:nav>
	
	<aui:nav>
		<portlet:actionURL var="updateStatsURL" name="updateStats">
			
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			 
		</portlet:actionURL>
		<aui:nav-item href="<%= updateStatsURL %>" label="update-stats" name="updateStatsButton" />
	</aui:nav>
	
	
	
	
	<c:if test="<%=pageName.equalsIgnoreCase(\"itemType\")%>">
		<aui:nav>
		<portlet:renderURL var="newItemTypeURL">
			<portlet:param name="mvcPath" value="/html/suburadmin/edit_itemtype.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
				 
		</portlet:renderURL>
			
			<aui:nav-item href="<%= newItemTypeURL %>" label="add-item-type" />
			
		</aui:nav>
	
	</c:if>
	
	<aui:nav>
		<portlet:renderURL var="importSubjectURL">
			<portlet:param name="mvcPath" value="/html/suburadmin/import_subject.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
				 
		</portlet:renderURL>
		<aui:nav-item href="<%= importSubjectURL %>" label="import-subject" />
	</aui:nav>
	
</aui:nav-bar>