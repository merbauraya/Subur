<%
	boolean showAddEntry = SuburPermission.contains(permissionChecker,scopeGroupId,ActionKeys.ADD_SUBUR_PUBLICATION);
	boolean showAdminItem = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.MANAGE_PUBLICATION);
	boolean showPermission = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
	boolean showSubscribe = SuburPermission.contains(permissionChecker, scopeGroupId, ActionKeys.SUBSCRIBE);
	
	SearchContainer suburSearchContainer = new SuburSearch(renderRequest, currentURLObj);
	SuburDisplayTerms suburDisplayTerms = (SuburDisplayTerms)suburSearchContainer.getDisplayTerms();
	boolean showSearch = true;
%>

<c:if test="<%= showAddEntry || showAdminItem || showPermission ||  showSubscribe || showSearch %>">
	<aui:nav-bar>
		<c:if test="<%= showAddEntry || showAdminItem || showPermission %>">
			<aui:nav>
				<c:if test="<%= showAddEntry %>">
					<portlet:renderURL var="addItemURL">
						<portlet:param name="mvcPath" value="<%= SuburConstant.PAGE_NEW_ITEM %>" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						 
					</portlet:renderURL>
					<aui:nav-item iconCssClass="icon-plus"  
						href="<%= addItemURL %>" label="add-subur-item" 
						name="addItemButton" />
				</c:if>
				<c:if test="<%= showAdminItem %>">
					<portlet:renderURL var="adminItemURL">
						<portlet:param name="mvcPath" value="<%= SuburConstant.PAGE_ADMIN_ITEM %>" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						
					</portlet:renderURL>
					<aui:nav-item iconCssClass="icon-plus"  href="<%= adminItemURL %>" label="manage-item" name="manageItemButton" />
					
				</c:if>
				
				<c:if test="<%= showPermission %>">
					<liferay-security:permissionsURL
						modelResource="com.idetronic.subur.model"
						modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
						resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
						var="permissionsURL"
						windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					/>
					<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
					
				</c:if>
				<c:if test="<%=showAddEntry %>">
					<portlet:renderURL var="mySubmissionURL">
						<portlet:param name="mvcPath" value="/html/admin/subur/my_submission.jsp"/>
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						
					</portlet:renderURL>
					<aui:nav-item href="<%= mySubmissionURL %>" label="my-submission" name="mySubmissionBtn" />
					
				
				</c:if>
				<c:if test="<%= showSubscribe %>">
					<c:choose>
						<c:when test="<%= SubscriptionLocalServiceUtil.isSubscribed(themeDisplay.getCompanyId(),themeDisplay.getUserId(),SuburItem.class.getName(),themeDisplay.getScopeGroupId()) %>">
							<portlet:actionURL var="unsubscribeURL" name="subscribe">
								
								<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNSUBSCRIBE %>" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
							</portlet:actionURL>

							
							<aui:nav-item href="<%= unsubscribeURL %>" label="unsubscribe" name="unsubscribeBtn" />
							
						</c:when>
						<c:otherwise>
							<portlet:actionURL var="subscribeURL" name="subscribe">
								
								<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SUBSCRIBE %>" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
							</portlet:actionURL>
							<aui:nav-item href="<%= subscribeURL %>" label="subscribe" name="subscribeBtn" />
							
							
						</c:otherwise>
					</c:choose>
				
				</c:if>
				
				
				
			</aui:nav>
			
		</c:if>
		
			
		
		<c:if test="<%= showSearch %>">
	        <aui:nav-bar-search cssClass="pull-right">
				<liferay-ui:search-form
					page="/html/search/item_form.jsp"
					 searchContainer="<%= suburSearchContainer %>"
					 showAddButton="<%=true %>"
					 servletContext="<%= this.getServletConfig().getServletContext() %>"
						/>
			</aui:nav-bar-search>
		</c:if>
    </div>
		
	</aui:nav-bar>

</c:if>