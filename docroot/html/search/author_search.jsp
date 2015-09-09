<%@include file="/html/author/init.jsp"%>
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
	
	
	String andOperator = ParamUtil.getString(request,"andOperator");
	boolean advanceSearch = ParamUtil.getBoolean(request, "advancedSearch");
	boolean matchAll = Validator.equals(andOperator, "1");
	String authorFirstName = ParamUtil.getString(request,SuburField.AUTHOR_FIRST_NAME);
	String authorLastName = ParamUtil.getString(request,SuburField.AUTHOR_LAST_NAME);
	//String assetCategoryIds = ParamUtil.getString(request, "assetCategoryIds");
	
	String expertiseName = ParamUtil.getString(request, SuburField.EXPERTISE_NAMES);
	String researchInterestName = ParamUtil.getString(request, SuburField.RESEARCH_INTEREST_NAMES);
	String assetTagNames = ParamUtil.getString(request, "assetTagNames");
	
	
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
        <portlet:param name="mvcPath" value="/html/search/author_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/author/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<%@ include file="/html/author/toolbar.jsp" %>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    
    
</aui:form>
<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("mvcPath", "/html/search/author_search.jsp");
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("keywords", keywords);
	%>

<liferay-ui:search-container
		emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>") %>'
		iteratorURL="<%= portletURL %>"
	>

<%
        
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		
	    BooleanQuery classNameQuery = BooleanQueryFactoryUtil.create(searchContext);
	    classNameQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, Author.class.getName()); 
	    fullQuery.add(classNameQuery, BooleanClauseOccur.MUST);
	    
	    Query stringQuery = null;
	    
	    
	    if (advanceSearch){
	    	BooleanQuery termQuery = BooleanQueryFactoryUtil.create(searchContext);
	    	
	    	if (matchAll)
	    	{
	    		//first name
	    		if (Validator.isNotNull(authorFirstName))
	    		{
		    		BooleanQuery authorFirstNameQuery = BooleanQueryFactoryUtil.create(searchContext);
		    		authorFirstNameQuery.addTerm(SuburField.AUTHOR_FIRST_NAME, authorFirstName);
		    		fullQuery.add(authorFirstNameQuery, BooleanClauseOccur.MUST);
	    		}
	    		//last name
	    		if (Validator.isNotNull(authorLastName))
	    		{
		    		BooleanQuery authorLastNameQuery = BooleanQueryFactoryUtil.create(searchContext);
		    		authorLastNameQuery.addTerm(SuburField.AUTHOR_LAST_NAME, authorLastName);
		    		fullQuery.add(authorLastNameQuery, BooleanClauseOccur.MUST);
	    		}
	    		//assetTagNames
	    		if (Validator.isNotNull(assetTagNames))
	    		{
		    		
		    		String[] tagNameArray = StringUtil.split(assetTagNames);
		    		for (String tagName : tagNameArray)
		    		{
		    			BooleanQuery assetTagNameQuery = BooleanQueryFactoryUtil.create(searchContext);
		    			assetTagNameQuery.addExactTerm(SuburField.ASSET_TAG_NAMES, tagName);
		    			fullQuery.add(assetTagNameQuery, BooleanClauseOccur.MUST);
		    		}

	    		}
	    		if (Validator.isNotNull(assetCategoryIds))
	    		{
	    			for (long categoryId : assetCategoryIds)
	    			{
	    				BooleanQuery categoryIdQuery = BooleanQueryFactoryUtil.create(searchContext);
	    				categoryIdQuery.addExactTerm(SuburField.ASSET_CATEGORY_IDS, categoryId);
		    			fullQuery.add(categoryIdQuery, BooleanClauseOccur.MUST);
	    				
	    			}
	    		}
	    		if (Validator.isNotNull(expertiseName))
	    		{
	    			BooleanQuery expertiseNameQuery = BooleanQueryFactoryUtil.create(searchContext);
	    			expertiseNameQuery.addTerm(SuburField.EXPERTISE_NAMES, expertiseName);
	    			fullQuery.add(expertiseNameQuery,BooleanClauseOccur.MUST);
	    		}
	    		
	    		if (Validator.isNotNull(researchInterestName))
	    		{
	    			BooleanQuery researchInterestNameQuery = BooleanQueryFactoryUtil.create(searchContext);
	    			researchInterestNameQuery.addTerm(SuburField.RESEARCH_INTEREST_NAMES, researchInterestName);
	    			fullQuery.add(researchInterestNameQuery,BooleanClauseOccur.MUST);
	    		}
	    		
	    		
	    	}else
	    	{
		    	if (Validator.isNotNull(authorFirstName))
		    	{
		    		termQuery.addTerm(SuburField.AUTHOR_FIRST_NAME, authorFirstName);
		    	}
		    	
		    	if (Validator.isNotNull(authorLastName))
		    	{
		    		termQuery.addTerm(SuburField.AUTHOR_LAST_NAME, authorLastName);
		    	}
		    	if (Validator.isNotNull(assetTagNames))
	    		{
		    		
		    		String[] tagNameArray = StringUtil.split(assetTagNames);
		    		for (String tagName : tagNameArray)
		    		{
		    			
		    			termQuery.addTerm(SuburField.ASSET_TAG_NAMES, tagName);
		    			
		    		}

	    		}
	    		if (Validator.isNotNull(assetCategoryIds))
	    		{
	    			for (long categoryId : assetCategoryIds)
	    			{
	    				BooleanQuery categoryIdQuery = BooleanQueryFactoryUtil.create(searchContext);
	    				termQuery.addExactTerm(SuburField.ASSET_CATEGORY_IDS, categoryId);
		    			
	    				
	    			}
	    		}
	    		if (Validator.isNotNull(expertiseName))
	    		{
	    			
	    			termQuery.addTerm(SuburField.EXPERTISE_NAMES, expertiseName);
	    			
	    		}
	    		
	    		if (Validator.isNotNull(researchInterestName))
	    		{
	    			termQuery.addTerm(SuburField.RESEARCH_INTEREST_NAMES, researchInterestName);
	    			
	    		}
		    	fullQuery.add(termQuery, BooleanClauseOccur.MUST);
		    	
	    	}
	    	
	    	
	    	
	    	//fullQuery = SuburSearchUtil.getSearchQuery(request, searchContext);
	    }else //simple search
	    {
	    	searchContext.setKeywords(keywords);
		    BooleanQuery descQuery = BooleanQueryFactoryUtil.create(searchContext);
		    
		    descQuery.addTerm(SuburField.AUTHOR_FIRST_NAME, keywords);
		    descQuery.addTerm(SuburField.AUTHOR_LAST_NAME, keywords);
		    
		    

	    	fullQuery.add(descQuery, BooleanClauseOccur.MUST);
	    	

	    	
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
        Indexer indexer = IndexerRegistryUtil.getIndexer(Author.class);
		
        Hits hits = null;
        
        
        //Hits hits = indexer.search(searchContext);
        //if (advanceSearch)
        hits =  SearchEngineUtil.search(searchContext, fullQuery); 
        //else
        //	hits = indexer.search(searchContext);
        searchContainer.setTotal(hits.getLength());
        
        PortletURL hitURL = renderResponse.createRenderURL();

		hitURL.setParameter("struts_action", "/blogs/view_entry");
		hitURL.setParameter("redirect", currentURL);
		
		
		List<Author> authors = new ArrayList<Author>();
		
		for (int i = 0; i < hits.getDocs().length; i++)
		{
			Document doc = hits.doc(i);
			
			long entryId = GetterUtil.getLong(doc.get(SuburField.ENTRY_CLASS_PK));
			
			Author author = null;
			try {
                author = AuthorLocalServiceUtil.getAuthor(entryId);
	        } catch (PortalException pe) {
	                _log.error(pe.getLocalizedMessage());
	        } catch (SystemException se) {
	                _log.error(se.getLocalizedMessage());
	        }
	
	        authors.add(author);
				
		}
		
		
%>
	<liferay-ui:search-container-results
			results="<%= authors %>"
		/>
	<liferay-ui:search-container-row
			className="com.idetronic.subur.model.Author"
			modelVar="author"
			escapedModel="<%=true%>"
			keyProperty="authorId"
		>
        	
			 <liferay-ui:search-container-column-text name="displayName">
			 	<portlet:renderURL var="viewAuthorURL">
						<portlet:param name="mvcPath" value="/html/author/view_author.jsp"/>
						
						<portlet:param name="authorId" value="<%=String.valueOf(author.getAuthorId()) %>" />
				</portlet:renderURL>
                <a href="<%=viewAuthorURL%>">
                	<%=author.getDisplayName() %>
                </a>
			 
			 </liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="itemCount" />
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
                	<portlet:renderURL var="byResearchInterestURL">
						<portlet:param name="mvcPath" value="/html/search/author_search.jsp"/>
						<portlet:param name="filterBy" value="ri" />
						<portlet:param name="filterKey" value="<%=String.valueOf(researchInterest.getResearchInterestId()) %>" />
					</portlet:renderURL>
                	
                		<a href="<%=byResearchInterestURL %>">
                			<%=name%>
                		</a>
                	<%
                		}
                	
                	
                	%>
                	
                
                </liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-date property="lastPublishedDate" />
		</liferay-ui:search-container-row> 
	 <liferay-ui:search-iterator />
		
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