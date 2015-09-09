<%
	SearchContainer authorSearchContainer = new AuthorSearch(renderRequest, currentURLObj);
	AuthorDisplayTerms authorDisplayTerms = (AuthorDisplayTerms)authorSearchContainer.getDisplayTerms();
	

%>


	<aui:nav-bar>
		<c:if test="<%= showAdminAuthor %>">
			<aui:nav>
				
				<portlet:renderURL var="addAuthorURL">
					<portlet:param name="mvcPath" value="/html/admin/author/edit_author.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				<aui:nav-item href="<%= addAuthorURL %>" label="add-subur-author" name="addItemButton" />
				
				
				
			</aui:nav>
		</c:if>
		
			
		
		<c:if test="<%= showSearch %>">
	        <aui:nav-bar-search cssClass="pull-right">
				<liferay-ui:search-form
					page="/html/search/author_form.jsp"
					 showAddButton="<%=true %>"
					 servletContext="<%= this.getServletConfig().getServletContext() %>"
					 searchContainer="<%= authorSearchContainer %>"
				/>
			</aui:nav-bar-search>
		</c:if>
    
		
	</aui:nav-bar>


