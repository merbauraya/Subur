<%@ include file="/html/init.jsp" %>
<%
	//List<Item> suburItems = ItemLocalServiceUtil.getDraftItems();	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/html/admin/subur/view.jsp");
	portletURL.setParameter("tabs1","all");
	portletURL.setWindowState(WindowState.NORMAL);
	int status = ParamUtil.getInteger(request, "status");
/*
	PortletURL addItemURL = renderResponse.createRenderURL();
	addItemURL.setParameter("mvcPath", "/html/deposit/new.jsp");
	addItemURL.setParameter(Constants.CMD, Constants.ADD);
*/
	String catMsg="";

	

	
	
	PortletURL editEntryURL = renderResponse.createActionURL();
	editEntryURL.setParameter("mvcPath", SuburConstant.PAGE_UPDATE_ITEM);
	editEntryURL.setParameter(Constants.CMD, Constants.EDIT);
	editEntryURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	

%>



<liferay-ui:search-container
	emptyResultsMessage="no-item-were-found"
	iteratorURL="<%=portletURL %>"
	total="<%= SuburItemLocalServiceUtil.getItemCount(status) %>"
>
	<liferay-ui:search-container-results
		results="<%= SuburItemLocalServiceUtil.getSuburItems(searchContainer.getStart(), searchContainer.getEnd(), status)  %>"
	/>
	<liferay-ui:search-container-row
		className="com.idetronic.subur.model.SuburItem"
		escapedModel="<%= true %>"
		keyProperty="itemId"
		modelVar="suburItem"
	>
	<%
		String statusText="status-"+ suburItem.getStatus();
	%>
	<liferay-ui:search-container-column-text
				name="title"
				title="<%= suburItem.getTitle() %>"
	/>
	
	<liferay-ui:search-container-column-text
				name="createDate"
				buffer="buffer"
	>
		<%
			buffer.append(dateFormatDate.format(suburItem.getCreateDate()));
		%>
	</liferay-ui:search-container-column-text>	
	<liferay-ui:search-container-column-text
		name="Last Modified"
		buffer="buffer"
	>
		<%
			buffer.append(timeFormatDate.format(suburItem.getModifiedDate()));
		%>
	</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-text
		name="status">
		
		<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>" status="<%= suburItem.getStatus() %>" />
		
		
		
		
	</liferay-ui:search-container-column-text>
	
	<liferay-ui:search-container-column-text name="Action">		
		<liferay-ui:icon-menu>
			
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
				<portlet:param name="mvcPath" value="<%=SuburConstant.PAGE_UPDATE_ITEM %>"/>
				<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.EDIT %>" />
			</portlet:renderURL>
			
			<portlet:actionURL var="deleteItemURL" name="deleteItem">
				<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			</portlet:actionURL>
			
			<portlet:actionURL var="publishItemURL" name="publishItem">
				<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
			</portlet:actionURL>
			
			<portlet:actionURL var="withdrawItemURL" name="withdrawItem">
				<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>" />
				<portlet:param name="redirect" value="<%=portletURL.toString() %>"/>
			</portlet:actionURL>
			
			
				<%
				
				
				
				
				
				%>
				<liferay-ui:icon image="edit" url="<%=editURL.toString()  %>" />
				<liferay-ui:icon-delete url="<%=deleteItemURL.toString()  %>" />
				<c:if test="<%= (suburItem.getStatus() == SuburConstant.STATUS_DRAFT_ITEM) %>">
					<liferay-ui:icon image="publish" url="<%=publishItemURL.toString()  %>" />	
				</c:if>
				
				<c:if test="<%= (suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM) %>">
					<liferay-ui:icon image="withdraw" url="<%=withdrawItemURL.toString()  %>" />	
				</c:if>
		
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>