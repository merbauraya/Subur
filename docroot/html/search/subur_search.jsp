<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.search.QueryConfig" %>
<%@ page import="com.liferay.portal.kernel.search.TermQuery" %>
<%@ page import="com.liferay.portal.kernel.search.WildcardQuery" %>
<%@ page import="com.liferay.portal.kernel.search.TermQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.StringQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClause" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClauseFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Query" %>
<%@ page import="com.liferay.portal.kernel.search.SearchResultUtil" %>
<%@ page import="com.idetronic.subur.search.SuburSearchUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchResult" %>
<%@ page import="com.liferay.portal.kernel.search.Summary" %>
<%@ page import="com.liferay.util.MathUtil" %>

<%@ page import="com.idetronic.subur.search.SuburField" %>



<%
    String keywords = ParamUtil.getString(request, "keywords");
	String redirect = ParamUtil.getString(request, "redirect");
	String author = ParamUtil.getString(request,"author");
	String title = ParamUtil.getString(request,"title");
	String year = ParamUtil.getString(request,"year");
	String andOperator = ParamUtil.getString(request,"andOperator");
	boolean advanceSearch = ParamUtil.getBoolean(request, "advancedSearch");
	boolean matchAll = Validator.equals(andOperator, "1");
	String authorFirstName = ParamUtil.getString(request,"authorFirstName");
	String authorLastName = ParamUtil.getString(request,"authorLastName");
	//String assetCategoryIds = ParamUtil.getString(request, "assetCategoryIds");
	
	
	String assetTagNames = ParamUtil.getString(request, "assetTagNames");
	out.print(assetTagNames);
	
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	Map<String, String[]> parameterMap = request.getParameterMap();

	List<Long> assetCategoryIdsList = new ArrayList<Long>();

	boolean updateAssetCategoryIds = false;

	for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
		String name = entry.getKey();

		if (name.startsWith("assetCategoryIds")) {
			updateAssetCategoryIds = true;

			long[] assetVocabularyAssetCategoryIds = StringUtil.split(
				ParamUtil.getString(request, name), 0L);

			for (long assetCategoryId : assetVocabularyAssetCategoryIds) {
				assetCategoryIdsList.add(assetCategoryId);
			}
		}
	}
	
	long[] assetCategoryIds = ArrayUtil.toArray(
			assetCategoryIdsList.toArray(
				new Long[assetCategoryIdsList.size()]));
	
	
	searchContext.setAssetCategoryIds(assetCategoryIds);
	//String[] assetTagNamesArr = StringUtil.split(assetTagNames);	
	//searchContext.setAssetTagNames(assetTagNamesArr);
	
	
%>


<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/subur_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<%@ include file="/html/admin/subur/top_nav.jsp" %>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />

    
</aui:form>
<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("mvcPath", SuburConstant.PAGE_SUBUR_SEARCH);
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("keywords", keywords);
	%>

<liferay-ui:search-container
		emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>") %>'
		iteratorURL="<%= portletURL %>"
	>

<%
        
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		
	    BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
	    searchQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, SuburItem.class.getName()); 
	    
	    
	    Query stringQuery = null;
	    
	    
	    if (advanceSearch){
	    	/*
	    	
	    	if (matchAll)
	    	{
	            
	            for (int i = 0; i < assetCategoryIds.length; i++ )
	            	searchQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, assetCategoryIds[i]);
	    	}else
	    		
	    	{
	    		
	    	}
	    	
	    	stringQuery = SuburSearchUtil.buildSearchQuery(request, searchContext);
	    	BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery, BooleanClauseOccur.MUST.getName());
    		searchContext.setBooleanClauses(new BooleanClause[] {clause});
    		String keywordList;
    		StringBuilder sb = new StringBuilder();
    		if (!Validator.isBlank(title))
    			sb.append(title).append(StringPool.SPACE);
    		if (!Validator.isBlank(authorFirstName))
    			sb.append(authorFirstName).append(StringPool.SPACE);
    		if (!Validator.isBlank(authorLastName))
    			sb.append(authorLastName).append(StringPool.SPACE);
    		if (!Validator.isBlank(year))
    			sb.append(year).append(StringPool.SPACE);
    		
    		
    		searchContext.setKeywords(sb.toString());
	    	*/
	    	fullQuery = SuburSearchUtil.getSearchQuery(request, searchContext);
	    }else
	    {
	    	
		    BooleanQuery descQuery = BooleanQueryFactoryUtil.create(searchContext);
		    
		    descQuery.addTerm(SuburField.TITLE, keywords);
		    descQuery.addTerm(SuburField.DESCRIPTION, keywords);
		    descQuery.addTerm(SuburField.AUTHOR, keywords);
		    

	    	TermQuery titleQuery = TermQueryFactoryUtil.create(searchContext, SuburField.TITLE, keywords);
	    	TermQuery abstractQuery = TermQueryFactoryUtil.create(searchContext, SuburField.DESCRIPTION, keywords);
	    	TermQuery authorQuery = TermQueryFactoryUtil.create(searchContext, SuburField.AUTHOR, keywords);
	    	
	    	
	    	
	    	
	    	//searchQuery.addTerm(SuburConstant.FIELD_YEAR, keywords);
	    	
	    	//BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, searchQuery, BooleanClauseOccur.MUST.getName());
	    	
	    	//fullQuery.add(titleQuery, BooleanClauseOccur.SHOULD);
	    	//fullQuery.add(abstractQuery, BooleanClauseOccur.SHOULD);
	    	//fullQuery.add(authorQuery, BooleanClauseOccur.SHOULD);
	    	fullQuery.add(descQuery, BooleanClauseOccur.MUST);
	    	fullQuery.add(searchQuery,BooleanClauseOccur.SHOULD);
	    	//searchContext.setKeywords(keywords);
	    	
	    	//searchContext.setBooleanClauses(new BooleanClause[] {clause});
	    	
	    }
    
	    _log.info(fullQuery.toString());
	    
	    QueryConfig queryConfig = new QueryConfig();

		queryConfig.setHighlightEnabled(true);
		queryConfig.setHitsProcessingEnabled(true);
		searchContext.setQueryConfig(queryConfig);
	    
		
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());
        //_log.info(fullQuery.toString());
        Indexer indexer = IndexerRegistryUtil.getIndexer(SuburItem.class);

        //Hits hits = indexer.search(searchContext);
        Hits hits =  SearchEngineUtil.search(searchContext, fullQuery); 

        searchContainer.setTotal(hits.getLength());
        
        PortletURL hitURL = renderResponse.createRenderURL();

		hitURL.setParameter("struts_action", "/blogs/view_entry");
		hitURL.setParameter("redirect", currentURL);
		searchContainer.setTotal(hits.getLength());
		
%>
	<liferay-ui:search-container-results
			results="<%= SearchResultUtil.getSearchResults(hits, locale, hitURL) %>"
		/>
	<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.search.SearchResult"
			modelVar="searchResult"
		>
        	<%
        	
        	SuburItem entry = null;
        	long itemId = 0L;
        	String itemTitle = StringPool.BLANK;
        	String searchDescription = StringPool.BLANK;
        	Summary summary = null;
        	String itemAbstract = StringPool.BLANK;
        	try {
        		
        	
				entry = SuburItemLocalServiceUtil.getSuburItem(searchResult.getClassPK());
				itemId = entry.getItemId();
				entry = entry.toEscapedModel();
				itemTitle = entry.getTitle();
				summary = searchResult.getSummary();
				searchDescription = entry.getSearchDescription(); 
				itemAbstract = entry.getItemAbstract();
        	} catch (NoSuchItemException e)
        	{}
			%>
			<c:if test="<%= Validator.isNotNull(entry)%>">
	        	<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value="/html/renderer/item_full.jsp" />
					<portlet:param name="itemId" value="<%= String.valueOf(itemId)%>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="urlTitle" value="<%= StringPool.BLANK %>" />
				</portlet:renderURL>
				 
				
		        <liferay-ui:app-view-search-entry
						cssClass='<%= MathUtil.isEven(index) ? "search" : "search alt" %>'
						description="<%= (searchDescription  != StringPool.BLANK) ? searchDescription : itemAbstract %>"
						queryTerms="<%= hits.getQueryTerms() %>"
						thumbnailSrc="<%= StringPool.BLANK %>"
						title="<%= (summary != null) ? HtmlUtil.escape(summary.getTitle()) : itemTitle %>"
						url="<%= rowURL %>"
					/>
			</c:if>
			
		</liferay-ui:search-container-row> 

		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="more" />
	</liferay-ui:search-container>
        
		

<%
        if (Validator.isNotNull(keywords)) {
                currentURL = PortalUtil.getCurrentURL(request);
                PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
                                pageContext, "search") + ": " + keywords, currentURL);
        }
%>

<%!
        private static Log _log = LogFactoryUtil.getLog("docroot.html.search.view_search_jsp");
%>