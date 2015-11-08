<%@include file="/html/subur/init.jsp"%>


<liferay-ui:error exception="<%= NoSuchItemException.class %>" message="the-resource-could-not-be-found" />




<%
	long itemId = ParamUtil.getLong(request,"itemId");
	
	SuburItem suburItem = (SuburItem)  request.getAttribute(WebKeys.SUBUR_ITEM);   //SuburItemServiceUtil.getSuburItem(itemId);//  SuburItemLocalServiceUtil.fetchSuburItem(itemId);
	if (Validator.isNull(suburItem))
	{
		suburItem = SuburItemLocalServiceUtil.getSuburItem(itemId);
	}
%>

<%	
	suburItem = suburItem.toEscapedModel();
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(SuburItem.class.getName(), suburItem.getItemId());
	suburItem = suburItem.toEscapedModel();
	Map<String,String> serieReportNoMap = suburItem.getSeriesReportNo();
	Map<String,String> identifiers = suburItem.getIdentifiers();
	
	
	//view counter
	SuburItemLocalServiceUtil.addViewStat(suburItem.getItemId(),themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());
	boolean canUpdate = SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.UPDATE);
	boolean canDelete = SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.DELETE);
	boolean canPermission = SuburItemPermission.contains(permissionChecker, suburItem, ActionKeys.PERMISSIONS);
	
%>

<div class="item-detail">
	<div class="item-header">
	
		<h2 class="item-title"><%= suburItem.getTitle() %>
			
		</h2>
	</div>
	
	<c:if test="<%= canUpdate || canDelete || canPermission %>">
		<div class="item-permission">
			<ul class="edit-actions entry icons-container lfr-meta-actions">
				<c:if test="<%= canUpdate %>">
					
					<li class="edit-entry">
						<portlet:renderURL var="editEntryURL">
							<portlet:param name="mvcPath" value="<%= SuburConstant.PAGE_UPDATE_ITEM %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="backURL" value="<%= currentURL %>" />
							<portlet:param name="itemId" value="<%= String.valueOf(suburItem.getItemId()) %>" />
						</portlet:renderURL>
	
						<liferay-ui:icon
							image="edit"
							label="<%= true %>"
							url="<%= editEntryURL %>"
						/>
					</li>
				</c:if>
	
				<c:if test="<%= showEditEntryPermissions && canPermission %>">
					<li class="edit-entry-permissions">
						<liferay-security:permissionsURL
							modelResource="<%= SuburItem.class.getName() %>"
							modelResourceDescription="<%= suburItem.getTitle() %>"
							resourceGroupId="<%= String.valueOf(suburItem.getGroupId()) %>"
							resourcePrimKey="<%= String.valueOf(suburItem.getItemId()) %>"
							var="permissionsEntryURL"
							windowState="<%= LiferayWindowState.POP_UP.toString() %>"
						/>
	
						<liferay-ui:icon
							image="permissions"
							label="<%= true %>"
							method="get"
							url="<%= permissionsEntryURL %>"
							useDialog="<%= true %>"
						/>
					</li>
				</c:if>
	
				<c:if test="<%= canDelete %>">
					<li class="delete-entry">
						
						<portlet:actionURL var="deleteEntryURL" name="deleteItem">
							<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="itemId" value="<%= String.valueOf(suburItem.getItemId()) %>" />
						</portlet:actionURL>
	
						<liferay-ui:icon-delete
							label="<%= true %>"
							trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
							url="<%= deleteEntryURL %>"
						/>
					</li>
				</c:if>
				
			</ul>
		</div>
	</c:if>
	<c:if test='<%= enableSocialBookmark && socialBookmarksDisplayPosition.equals("top") %>'>
		<liferay-ui:social-bookmarks
		    displayStyle="<%=socialBookmarksDisplayStyle %>"
		    target="_blank"
		    
		    title="<%= suburItem.getTitle() %>"
		    url="<%= PortalUtil.getCanonicalURL((PortalUtil.getCurrentURL(request)), themeDisplay, layout) %>" 
		/>
	</c:if>
	
	
	<div class="item-date">
		<%
			
			//if (suburItem.getStatus() == SuburConstant.STATUS_DRAFT_ITEM)
		%>
		<span class="hide-accessible">Published Date</span>
			<c:if test="<%=Validator.isNotNull(suburItem.getPublishedDate()) %>">
				<%=dateFormatDate.format(suburItem.getPublishedDate()) %>
			</c:if>
	</div>
	
	<div class="item-author">
		<%
			PortletURL viewAuthorURL = renderResponse.createRenderURL();
			viewAuthorURL.setParameter("mvcPath", "/html/author/view_author.jsp");
		%>	
		<subur:item-author-display 
			itemId="<%= suburItem.getItemId()  %>" 
			viewAuthorURL ="<%=viewAuthorURL %>"	
		/>
	</div>	
	<%
		PortletURL viewItemTypeURL = renderResponse.createRenderURL();
	%>
	<subur:item-itemtype-display 
			itemId="<%= suburItem.getItemId() %>" 
			viewItemTypeURL ="<%=viewItemTypeURL %>"	
			showHeader= "<%= true %>"
		/>
	<%
		String[] otherTitles = suburItem.getOtherTitles();
		if (otherTitles != null && otherTitles.length>0)
		{
	%>
		<div>
		<h4><liferay-ui:message key="other-title"/></h4>
			<ul>
			<%for (String otherTitle : otherTitles)
			{	
			%>
				<li><%=otherTitle %></li>
		<%
			}
		%>
			</ul>
		</div>
	<%
		}
	%>
	<div class="asset-categorization-display">
		<h4>Tags</h4>
		<liferay-ui:asset-tags-summary
		    className="<%= SuburItem.class.getName() %>"
		    classPK="<%= suburItem.getItemId() %>"
		    portletURL="<%= renderResponse.createRenderURL() %>"
		/>
		<h4>Categories</h4>
		<liferay-ui:asset-categories-summary
		    className="<%= SuburItem.class.getName() %>"
		    classPK="<%= suburItem.getItemId() %>"
		    portletURL="<%= renderResponse.createRenderURL() %>"
		/>
	</div>
	<div class="item-abstract">
		<h4>Abstract</h4>
		<%=suburItem.getItemAbstract() %>
	</div>
	<div>
		<%if (serieReportNoMap != null && serieReportNoMap.size() > 0) 
		{
		%>
			<h4><liferay-ui:message key="part-of"/></h4>
				<ul>
			<%
			for (Map.Entry<String, String> serieEntry : serieReportNoMap.entrySet())
			{
			%>
					<li><%=serieEntry.getKey() %>;<%=serieEntry.getValue() %></li>
			<%} %>
			
				
				</ul>
		<%
		}
		%>
	
	</div>
	<div>
		<%if (identifiers != null && identifiers.size() > 0) 
		{
		%>
			<h4><liferay-ui:message key="item-identifier"/></h4>
				<ul>
			<%
			for (Map.Entry<String, String> identEntry : identifiers.entrySet())
			{
			%>
					<li><%=identEntry.getKey() %>; <%=identEntry.getValue() %></li>
			<%} %>
			
				
				</ul>
		<%
		}
		%>
	
	</div>
	
	<div class="item-asset-links">
		
		
		<%
			
			String nameSpace = renderResponse.getNamespace();
			
			ResourceURL rURL = renderResponse.createResourceURL();
			rURL.setResourceID(SuburConstant.RESOURCE_SERVE_FILE);
			rURL.setParameter("itemId", String.valueOf(suburItem.getItemId()));
			
			
		%>
		<c:choose>
			<c:when test="<%= themeDisplay.isSignedIn() || !suburItem.getRelatedRestricted() %>">
				<subur:item-asset-links
					assetEntryId="<%= assetEntry.getEntryId() %>"
					serveFileURL="<%= rURL %>"
					nameSpace="<%= nameSpace %>"
							
				/>
				<aui:button name="requestCopyBtn" type="button" value="request-copy" style="display:none;"/>
			
			</c:when>
			<c:otherwise>
				<div class="alert">
					<liferay-ui:message key="restricted-related-asset"></liferay-ui:message>
				</div>
				<aui:button name="requestCopyBtn" type="button" value="request-copy" />
			</c:otherwise>
		
		</c:choose>
			
		
		
		
						
		
	</div>
	
</div>
<liferay-portlet:renderURL var="requestCopyURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<liferay-portlet:param name="mvcPath" value="/html/subur/request_copy.jsp"/>
	<liferay-portlet:param name="suburItemId" value="<%= String.valueOf(suburItem.getItemId()) %>"/>
	
</liferay-portlet:renderURL>

<c:if test='<%= enableSocialBookmark && socialBookmarksDisplayPosition.equals("bottom") %>'>
	<liferay-ui:social-bookmarks
	    displayStyle="<%=socialBookmarksDisplayStyle %>"
	    target="_blank"
	    types="<%= socialBookmarksTypes %>"
	    title="<%= suburItem.getTitle() %>"
	    url="<%= PortalUtil.getCanonicalURL((PortalUtil.getCurrentURL(request)), themeDisplay, layout) %>" 
	/>
</c:if>

<aui:script use="aui-toggler,liferay-util-window">
	var A = AUI();
	
A.one('#<portlet:namespace/>requestCopyBtn').on('click', function(event) {
	Liferay.Util.selectEntity(
	{
		dialog: {
			centered: true,
			height: 600,
			modal: true,
			width: 400
		},
		id: '<portlet:namespace/>dialog',
		title: '<liferay-ui:message key="request-copy" />',
		eventName: '<portlet:namespace />doSearch',
		uri: '<%=requestCopyURL %>'
	},
	function (event)
	{
		
		<portlet:namespace />doSearch(data);
		
		
	}
	
	
	);
});

</aui:script>
