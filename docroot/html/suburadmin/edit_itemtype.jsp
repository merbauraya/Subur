<%@ include file="/html/init.jsp" %>
<%
	long itemTypeId = ParamUtil.getLong(request, "itemTypeId");
	String nameSpace = renderResponse.getNamespace();
	String dialogId = nameSpace+ "editItemType";
	String redirect = ParamUtil.getString(request, "redirect");
	ItemType itemType = null;
	if (Validator.isNotNull(itemTypeId))
	{
		itemType = ItemTypeLocalServiceUtil.getItemType(itemTypeId);
	}

%>
<portlet:actionURL name="editItemType" var="editItemTypeURL">
		<portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="editItemType" />
	

</portlet:actionURL>
<aui:form action="#" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveItemType();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (itemType == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input type="hidden" name="itemTypeId" value="<%=itemTypeId %>"/>
	<aui:input type="hidden" name="redirect" value="<%=redirect %>"/>
	<aui:model-context bean="<%= itemType %>" model="<%= ItemType.class %>" />
	
	<aui:fieldset>
		<aui:input name="itemTypeName">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>
	
	
	<aui:button-row>
	
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	
	</aui:button-row>

</aui:form>

<aui:script>

function <portlet:namespace />saveItemType() {

	submitForm(document.<portlet:namespace />fm, "<%= editItemTypeURL%>");
}
  
  </aui:script>