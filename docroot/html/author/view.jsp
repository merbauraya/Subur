<%@ include file="/html/author/init.jsp" %>

<%
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage", "/html/admin/author/view.jsp");
	pageContext.setAttribute("portletURL", portletURL);

	String portletURLString = portletURL.toString();
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	
	boolean searched = ParamUtil.getBoolean(request, "search");
	String keywords = ParamUtil.getString(request, "keywords");
	String lastName = ParamUtil.getString(request, "lastName");
	boolean advanceSearch = ParamUtil.getBoolean(request, "advancedSearch");
	String andOperator = ParamUtil.getString(request,"andOperator");
	boolean matchAll = Validator.equals(andOperator, "1");
	
	boolean showAdminAuthor = AuthorPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE);
	boolean showSearch = true;
	
	
	/*
	List<AssetVocabulary> authorVocabs = AssetVocabularyLocalServiceUtil.getGroupsVocabularies(new long[]{themeDisplay.getScopeGroupId()},
			Author.class.getName());
	
	_log.info("xx");
	*/
	
%>

<portlet:renderURL var="viewAuthorsURL">
	<portlet:param name="jspPage" value="/html/admin/author/view.jsp" />
</portlet:renderURL>

<%
/*
		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		long[] groupIds = new long[] {themeDisplay.getScopeGroupId()};
		List<AssetVocabulary> authorVocabularies = AuthorUtil.getAuthorVocabulary(groupIds);
		int vocabCount = authorVocabularies.size();
		int colWidth=33;
		if (vocabCount > 1)
			colWidth=50;
	*/	

%>
<c:if test="<%= showAdminAuthor%>">
	<aui:nav-bar>
		<c:if test="<%= showAdminAuthor %>">
			<aui:nav>
				
				<portlet:renderURL var="addAuthorURL">
					<portlet:param name="jspPage" value="/html/admin/author/edit_author.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					 
				</portlet:renderURL>
				<aui:nav-item href="<%= addAuthorURL %>" label="add-subur-author" name="addItemButton" />
				
				
				
			</aui:nav>
		</c:if>
		
			
		
		<c:if test="<%= showSearch %>">
	        <aui:nav-bar-search cssClass="pull-right">
				<liferay-ui:search-form
					page="/html/author/author_search.jsp"
					 
					 servletContext="<%= this.getServletConfig().getServletContext() %>"
				/>
			</aui:nav-bar-search>
		</c:if>
    
		
	</aui:nav-bar>


</c:if>

<c:choose>
	<c:when test="<%=searched %>">
		<jsp:include page="/html/author/filter_view.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="/html/author/default_view.jsp"/>
	</c:otherwise>

</c:choose>








<%!
private static Log _log = LogFactoryUtil.getLog("autor.html.view.jsp");
%>








