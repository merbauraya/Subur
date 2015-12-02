<%@ include file="/html/subur/init.jsp" %>
<%
	
	//List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	
%>
<liferay-security:permissionsURL
    modelResource="<%= SuburItem.class.getName() %>"
    modelResourceDescription="<%= item.getTitle() %>"
    resourcePrimKey="<%= String.valueOf(item.getPrimaryKey()) %>"
    var="entryURL"
    windowState="<%= LiferayWindowState.POP_UP.toString() %>"
/>

<liferay-ui:icon 
	image="permissions" 
	url="<%= entryURL %>" 
	useDialog="<%= true %>"
	method="get"
	message="set-permission"	
	label="<%=true %>"	
/>
<c:if test="<%= !SuburUtil.isWorkflowEnabled(themeDisplay.getCompanyId()) %>">
	<aui:fieldset>
		
		
		<aui:select size="1" multiple="<%=false %>" label="item-status" name="itemStatus">
	
			<%
				int itemStatus = item.getStatus();
			%>
			
			<aui:option selected="<%=(itemStatus == WorkflowConstants.STATUS_DRAFT)  %>" value="<%= SuburConstant.STATUS_DRAFT_ITEM %>">
				<liferay-ui:message key="status-draft" />
			</aui:option>
			
			<aui:option selected="<%=(itemStatus == SuburConstant.STATUS_DRAFT_ITEM)  %>" value="<%= SuburConstant.STATUS_DRAFT_ITEM %>">
				<liferay-ui:message key="status-draft" />
			</aui:option>
			<aui:option selected="<%=(itemStatus ==WorkflowConstants.STATUS_APPROVED)  %>" value="<%= SuburConstant.STATUS_PUBLISHED_ITEM%>">
				<liferay-ui:message key="status-published" />
			</aui:option>
			<aui:option selected="<%=(itemStatus ==WorkflowConstants.STATUS_INACTIVE)  %>" value="<%= SuburConstant.STATUS_WITHDRAWN_ITEM%>">
				<liferay-ui:message key="status-inactive" />
			</aui:option>
			
		</aui:select>
		
	</aui:fieldset>
</c:if>