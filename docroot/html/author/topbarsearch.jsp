<aui:form action="<%= portletURLString %>" method="post" name="fm">
	
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<%
	


	%>
	<aui:nav-bar>
		<aui:nav>
			

			
			<liferay-portlet:renderURL varImpl="addAuthorURL">
				<portlet:param name="mvcPath" value="/html/admin/author/edit_author.jsp" />
				<portlet:param name="redirect" value="<%= viewAuthorsURL %>" />
			</liferay-portlet:renderURL>

			 <aui:nav-item href="<%=addAuthorURL.toString() %>" iconCssClass="icon-add"
                     label="add" />
			
		</aui:nav>

		<aui:nav-bar-search cssClass="pull-right">
		<liferay-ui:search-form
					page="/html/search/author_form.jsp"
					 searchContainer="<%= authorSearch %>"
					 servletContext="<%= this.getServletConfig().getServletContext() %>"
						/>
		</aui:nav-bar-search>
	</aui:nav-bar>
	
<liferay-ui:search-container
		
		searchContainer="<%= authorSearch %>"
	>
	<%
		AuthorSearchTerms searchTerms = (AuthorSearchTerms)searchContainer.getSearchTerms();
	
	%>
	<liferay-ui:search-container-results>
		<%
		
		//total = AuthorLocalServiceUtil.getSearchCount(searchTerms.getKeywords(), 
		//		themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId());
		
		total = AuthorLocalServiceUtil.getSearchCount(searchTerms.getKeywords(), 
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
				searchTerms.getFirstName(), searchTerms.getLastName(),
				searchTerms.isAdvancedSearch(),searchTerms.isAndOperator(),
				searchContainer.getStart(),searchContainer.getEnd(),
				searchContainer.getOrderByComparator());
		
		
		List<Author> authors = AuthorLocalServiceUtil.search(searchTerms.getKeywords(), 
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
				searchTerms.getFirstName(), searchTerms.getLastName(),
				searchTerms.isAdvancedSearch(),searchTerms.isAndOperator(),
				searchContainer.getStart(),searchContainer.getEnd(),
				searchContainer.getOrderByComparator());
		
		
		//List<Author> authors = AuthorLocalServiceUtil.search(searchTerms.getKeywords(),
		//		themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId(),
		//		searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		
		
		searchContainer.setTotal(total);
		results = authors; //ListUtil.subList(authors, searchContainer.getStart(), searchContainer.getEnd());
		//out.print(total + ":"+ searchContainer.getStart() + ":"+ authors.size()+ ":"+ results.size());
		searchContainer.setResults(results);
		%>
	
	
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
			className="com.idetronic.subur.model.Author"
			keyProperty="authorId"
			modelVar="author"
		>
		
		<liferay-ui:search-container-column-text
				name="firstName"
				value="<%= HtmlUtil.escape(author.getFirstName()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
				name="lastName"
				value="<%= HtmlUtil.escape(author.getLastName()) %>"
				orderable="<%= true %>"
		/>
		<liferay-ui:search-container-column-text
				name="item-count"
				value="<%= String.valueOf(author.getItemCount()) %>"
				orderable="<%= true %>"
				orderableProperty="itemCount"
		/>
		<liferay-ui:search-container-column-date
				name="last-published-date"
				value="<%= author.getLastPublishedDate() %>"
				orderable="<%= false %>"
				orderableProperty="lastPublishedDate"
		/>
		<liferay-portlet:renderURL varImpl="editAuthorURL">
				<portlet:param name="mvcPath" value="/html/admin/author/edit_author.jsp" />
				<portlet:param name="redirect" value="<%= viewAuthorsURL %>" />
				<portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>" />
				
		</liferay-portlet:renderURL>
		<liferay-portlet:renderURL varImpl="viewAuthorURL">
				<portlet:param name="mvcPath" value="/html/author/view_author.jsp" />
				<portlet:param name="redirect" value="<%= viewAuthorsURL %>" />
				<portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>" />
				
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit" message="Edit" label="edit" url="<%= editAuthorURL.toString() %>" />
				<liferay-ui:icon image="view" message="View" label="view" url="<%= viewAuthorURL.toString() %>" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
		
			
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>

	
	
</aui:form>