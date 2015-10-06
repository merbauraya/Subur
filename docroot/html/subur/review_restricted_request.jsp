<%@ include file="/html/subur/init.jsp" %>
<%@ page import="com.idetronic.subur.model.CopyRequest" %>
<%@ page import="com.idetronic.subur.service.CopyRequestLocalServiceUtil" %>

<%
	long copyRequestId = ParamUtil.getLong(request,"copyRequestId");
	
	CopyRequest copyRequest = CopyRequestLocalServiceUtil.fetchCopyRequest(copyRequestId);
	SuburItem suburItem = (SuburItem)  request.getAttribute(WebKeys.SUBUR_ITEM);   //SuburItemServiceUtil.getSuburItem(itemId);//  SuburItemLocalServiceUtil.fetchSuburItem(itemId);
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(SuburItem.class.getName(), suburItem.getItemId());
	String tabNames = "request-detail,item-detail";
			
	
%>
<h2><liferay-ui:message key="review-restricted-request"></liferay-ui:message>
</h2>

<liferay-ui:tabs
	names="<%= tabNames %>"
	refresh="<%= false %>"
	>
	<liferay-ui:section>
			<table class="table table-condensed table-hover">
    			<thead>
    				<tr>
    					<th> </th>
    					<th></th>
    				
    				</tr>
    			</thead>
    			<tbody>
    				<tr>
    					<td>Requester Name</td>
    					<td><%= copyRequest.getRequesterName() %></td>
    				
    				</tr>
    				
    				<tr>
    					<td>Requester Email</td>
    					<td><%= copyRequest.getFromEmailAddress() %></td>
    				
    				</tr>
    				<tr>
    					<td>Request Reason</td>
    					<td><%= copyRequest.getReason() %></td>
    				
    				</tr>
    				<tr>
    					<td>Request Date</td>
    					<td><%=dateFormatDate.format(copyRequest.getDateCreated()) %></td>
    				
    				</tr>
    				<tr>
    					<td>Item Title</td>
    					<td><%= suburItem.getTitle() %></td>
    				
    				</tr>
    				<tr>
    					<td>Resource Requested</td>
    					<td>
    					<%
    					String nameSpace = renderResponse.getNamespace();
    					
    					ResourceURL rURL = renderResponse.createResourceURL();
    					rURL.setResourceID(SuburConstant.RESOURCE_SERVE_FILE);
    					rURL.setParameter("itemId", String.valueOf(suburItem.getItemId()));
    					
    					%>
    					
    					
    					<subur:item-asset-links
					assetEntryId="<%= assetEntry.getEntryId() %>"
					serveFileURL="<%= rURL %>"
					nameSpace="<%= nameSpace %>"
					hideTitle="<%= true %>"
							
				/>
    					
    					
    					</td>
    					
    				</tr>
    	
    		
    				<tr>
    					<td> </td>
    					<td>
    					<portlet:actionURL name="approveRestrictedRequest" var="approveURL">
    						<portlet:param name="copyRequestId" value="<%= String.valueOf(copyRequest.getCopyRequestId()) %>"/>
    						<portlet:param name="suburItemId" value="<%= String.valueOf(suburItem.getItemId()) %>"/>
    					</portlet:actionURL>
    					
    					<portlet:actionURL name="rejectRestrictedRequest" var="rejectURL">
    						<portlet:param name="copyRequestId" value="<%= String.valueOf(copyRequest.getCopyRequestId()) %>"/>
    						<portlet:param name="suburItemId" value="<%= String.valueOf(suburItem.getItemId()) %>"/>
    					</portlet:actionURL>
    					
    				
    					
    					
    						<aui:a href="<%= approveURL %>" label="approve" cssClass="btn btn-success"></aui:a>
    						<aui:a href="<%= rejectURL %>" label="reject" cssClass="btn btn-warning"></aui:a>
    					
    					
    					</td>
    				
    				</tr>
    			</tbody>
    		</table>
		
		
	</liferay-ui:section>
		
	<liferay-ui:section>
		<liferay-util:include page="/html/renderer/item_full.jsp" servletContext="<%= application %>" />
	</liferay-ui:section>
	
	
	

</liferay-ui:tabs>	



