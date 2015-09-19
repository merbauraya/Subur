<%@ include file="/html/author/init.jsp" %>
<%
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/html/author/filter_view.jsp");
	portletURL.setParameter("search", "true");
	pageContext.setAttribute("portletURL", portletURL);
	String portletURLString = portletURL.toString();
	
	
	String filterBy = ParamUtil.getString(request,"filterBy");
	long filterKey = ParamUtil.getLong(request, "filterKey");
	List<Author> entries = (List<Author>) request.getAttribute("entries");
	boolean canUpdate = AuthorPermission.contains(permissionChecker, scopeGroupId, "UPDATE");
	
%>

<liferay-portlet:actionURL name="search" varImpl="searchURL">
        
</liferay-portlet:actionURL>


<subur:item-categorization-filter
	assetType="author"
	actionURL="<%=searchURL %>"
	portletURL="<%= portletURL%>"
/>
<liferay-portlet:actionURL name="search" varImpl="iteratorURL">

</liferay-portlet:actionURL>

<liferay-ui:search-container iteratorURL="<%= iteratorURL %>" delta="<%=delta %>" 
	emptyResultsMessage="no-entries-were-found"
	deltaConfigurable="true">
        <liferay-ui:search-container-results
                results="<%= ListUtil.subList(entries,searchContainer.getStart(),searchContainer.getEnd()) %>"
                total="<%= entries.size() %>"
        />

        <liferay-ui:search-container-row
                className="com.idetronic.subur.model.Author"
                keyProperty="authorId" modelVar="author" escapedModel="<%=true%>">
                
				<liferay-portlet:renderURL varImpl="viewAuthorURL">
					<portlet:param name="mvcPath" value="/html/author/view_author.jsp" />
				
					<portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>" />
				
					</liferay-portlet:renderURL>
                <liferay-ui:search-container-column-text name="Name">
                	<a href="<%=viewAuthorURL %>">
                		<%=author.getDisplayName() %>
                	</a>
                
                </liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text
				name="item-count"
				value="<%= String.valueOf(author.getItemCount()) %>"
				orderable="<%= true %>"
				orderableProperty="itemCount"
		/>
		
		
                <liferay-ui:search-container-column-text name="research-interest">
                	<%List<ResearchInterest> researchInterests = AuthorLocalServiceUtil.getResearchInterests(author.getAuthorId()); 
                		for (int i = 0; i < researchInterests.size(); i ++)
                		{
                			ResearchInterest researchInterest = researchInterests.get(i);
                			String name=researchInterest.getName();
                			if (i+1 < researchInterests.size())
                			{
                				name = name + StringPool.SEMICOLON;
                			}
                	%>
                	<portlet:actionURL var="byResearchInterestURL" name="search">
						
						<portlet:param name="filterBy" value="ri" />
						<portlet:param name="filterKey" value="<%=String.valueOf(researchInterest.getResearchInterestId()) %>" />
						</portlet:actionURL>
                	
                		<a href="<%=byResearchInterestURL %>">
                			<%=name%>
                		</a>
                	<%
                		}
                	
                	
                	%>
                	
                
                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-date
				name="last-published-date"
				value="<%= author.getLastPublishedDate() %>"
				orderable="<%= false %>"
				orderableProperty="lastPublishedDate"
		/>
        <liferay-portlet:renderURL varImpl="editAuthorURL">
				<portlet:param name="mvcPath" value="/html/admin/author/edit_author.jsp" />
				
				<portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>" />
				
		</liferay-portlet:renderURL>
       
       	<c:if test="<%= canUpdate %>">
			<liferay-ui:search-container-column-text>
				
				<liferay-ui:icon image="edit" message="Edit" label="edit" url="<%= editAuthorURL.toString() %>" />
			</liferay-ui:search-container-column-text>
		</c:if>        

               
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>



<portlet:renderURL var="viewAuthorsURL">
	<portlet:param name="mvcPath" value="/html/admin/author/view.jsp" />
</portlet:renderURL>

