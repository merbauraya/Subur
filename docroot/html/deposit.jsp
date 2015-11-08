<%@ include file="/html/init.jsp" %>
<%
String itemIdString = (String)request.getAttribute("itemId");
if (Validator.isNull(itemIdString))
	itemIdString = ParamUtil.getString(request, "itemId");
long itemId = 0;
SuburItem suburItem = null;
if (Validator.isNotNull(itemIdString))
{
	itemId = Long.valueOf(itemIdString);
	suburItem = SuburItemLocalServiceUtil.getSuburItem(itemId);
	request.setAttribute("suburItem",suburItem);
}
	
	//out.print("itemId="+itemId);
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

String[] item = {"identity","author","categorization","related","license","permission"};
String[][] categorySections = {item};

%>

<portlet:actionURL name="depositItem" var="depositItemURL"/>


<aui:form method="post" action="<%=depositItemURL%>" name="fm" enctype="multipart/form-data" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
	<aui:input name="itemId" type="hidden" value="<%= suburItem.getItemId() %>"/>
	<aui:input name="redirect" value="<%= redirect%>" type="hidden" />
	<aui:model-context bean="<%=suburItem%>" model="<%=SuburItem.class%>" />
	<aui:input name="status" type="hidden" value="<%= suburItem.getStatus() %>" />
	<aui:input name="workflowAction" type="hidden" value="<%= WorkflowConstants.ACTION_PUBLISH %>" />
	
	<liferay-util:buffer var="htmlTop">
		<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>" status="<%= suburItem.getStatus() %>" />
	</liferay-util:buffer>

	<liferay-util:buffer var="htmlBottom">
		<div class="htmlBottom">
			<aui:button-row>
			<%
				boolean pending = false;

				if (suburItem != null) {
					pending = suburItem.isPending();
				}
			%>

		<c:if test="<%= pending %>">
			<div class="alert alert-info">
				<liferay-ui:message key="there-is-a-publication-workflow-in-process" />
			</div>
		</c:if>
			
			
			
			<%
			String saveButtonLabel = "save";

			if ((suburItem == null) || suburItem.isDraft() || suburItem.isApproved()) 
			{
				saveButtonLabel = "draft";
			}

			String publishButtonLabel = "publish";

			if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, SuburItem.class.getName())) {
				publishButtonLabel = "publish";
			}
			%>

			<c:if test="<%= (suburItem != null) && suburItem.isApproved() && WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(suburItem.getCompanyId(), suburItem.getGroupId(), SuburItem.class.getName()) %>">
				<div class="alert alert-info">
					<%= LanguageUtil.format(pageContext, "this-x-is-approved.-publishing-these-changes-will-cause-it-to-be-unpublished-and-go-through-the-approval-process-again", ResourceActionsUtil.getModelResource(locale, SuburItem.class.getName())) %>
				</div>
			</c:if>
		
			<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "savePublication(true);" %>' primary="<%= false %>" type="submit" value="<%= saveButtonLabel %>" />
		
			
		
			<aui:button disabled="<%= pending %>" name="publishButton" onClick='<%= renderResponse.getNamespace() + "savePublication(false);" %>' type="submit" value="<%= publishButtonLabel %>" />
		
			
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		
		</aui:button-row>				
		
		</div>
	</liferay-util:buffer>

<liferay-ui:form-navigator
	
    backURL="<%=backURL %>"
    categoryNames="<%= _CATEGORY_NAMES %>"
    categorySections="<%= categorySections %>"
    formName="fm"
    htmlBottom="<%=htmlBottom %>"
    htmlTop="<%=htmlTop %>"
    jspPath="/html/deposit/" 
    showButtons="<%=false %>"
/>

<aui:script>
	
	function <portlet:namespace />savePublication(isDraft)
	{
		var A = AUI();
		var assetCategoryIdArr = [];
		var catdIds = A.all('input[name^=<portlet:namespace/>assetCategoryIds]');
		
		catdIds.each(function(){
			assetCategoryIdArr.push(this.val());
			
			
			
		});
		A.one("#<portlet:namespace/>categoryIds").val(assetCategoryIdArr);
		
		var assetTagNames = A.one('input[name^=<portlet:namespace/>assetTagNames]').val();
		A.one("#<portlet:namespace/>tagNames").val(assetTagNames);		
		
		if (isDraft)
		{
			A.one("#<portlet:namespace/>status").val("<%= WorkflowConstants.STATUS_DRAFT %>");
			A.one("#<portlet:namespace/>workflowAction").val("<%=WorkflowConstants.ACTION_SAVE_DRAFT %>");
		}
		
		submitForm(document.<portlet:namespace />fm);
	}
		
		
		function <portlet:namespace />submitForm()
		{
			var A = AUI();
			var assetCategoryIdArr = [];
			var catdIds = A.all('input[name^=<portlet:namespace/>assetCategoryIds]');
			
			catdIds.each(function(){
				assetCategoryIdArr.push(this.val());
				
				
				
			});
			A.one("#<portlet:namespace/>categoryIds").val(assetCategoryIdArr);
			
			var assetTagNames = A.one('input[name^=<portlet:namespace/>assetTagNames]').val();
			A.one("#<portlet:namespace/>tagNames").val(assetTagNames);		
			
			submitForm(document.<portlet:namespace />fm);
		}
		
		
		
		
	

</aui:script>

</aui:form>




<%!
private static final String[] _CATEGORY_NAMES = {"publication"};
%>