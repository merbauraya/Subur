<%@ include file="/html/author/init.jsp" %>

<%
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("mvcPath", "/html/admin/author/view.jsp");
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
	
	
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);

	
	
	
%>

<portlet:renderURL var="viewAuthorsURL">
	<portlet:param name="mvcPath" value="/html/admin/author/view.jsp" />
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
<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/author_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" name="fm" inlineLabel="<%= true %>">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<%@ include file="/html/author/toolbar.jsp" %>
</aui:form>


<c:if test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
	
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= paginationType %>" />
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








