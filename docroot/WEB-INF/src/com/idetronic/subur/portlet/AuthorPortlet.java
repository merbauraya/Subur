package com.idetronic.subur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.persistence.AuthorQuery;
import com.idetronic.subur.util.AuthorQueryUtil;
import com.idetronic.subur.util.AuthorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AuthorPortlet
 */
public class AuthorPortlet extends MVCPortlet {
	
	/**
	 * editAuthor - Add/Edit author action request during item author 	
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void editAuthor(ActionRequest request,ActionResponse response)throws PortalException, SystemException
	{
		
		
		
		String cmd = ParamUtil.getString(request, "cmd");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long authorId = ParamUtil.getLong(request, "authorId");
		Author author = null;
		if (cmd.equalsIgnoreCase(Constants.UPDATE))
			author = AuthorLocalServiceUtil.getAuthor(authorId);
		
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String middleName = ParamUtil.getString(request, "middleName");
		String remoteId = ParamUtil.getString(request, "remoteId");
		String title = ParamUtil.getString(request, "title");
		String email = ParamUtil.getString(request, "email");
		String officeNo = ParamUtil.getString(request, "officeNo");
		String categoryIds = ParamUtil.getString(request, "categoryIds");
		
		
		
		categoryIds = StringUtil.replace(categoryIds, ",,", ",");
		_log.info("cat="+categoryIds);
		String expertises = ParamUtil.getString(request, "expertiseNames");
		String researchInterests = ParamUtil.getString(request, "researchInterestNames");
		
		String[] expertiseNamesArr = null;
		if (!expertises.isEmpty())
		{
			expertiseNamesArr = expertises.split(",");
		}
		String[] researchInterestNameArr = null;
		if (!researchInterests.isEmpty())
		{
			researchInterestNameArr = researchInterests.split(",");
		}
		
		int idType = ParamUtil.getInteger(request, "idType");
		
		//handle Author Site
		String authorSiteIndexesString = request.getParameter(
				"authorSiteIndexes");
		
		
		HashMap<String, String> authorSite = new HashMap<>();
		int[] authorSiteIndexes = StringUtil.split(authorSiteIndexesString, 0);
		for (int authorSiteIndex : authorSiteIndexes) {
			
			long authorSiteId = ParamUtil.getLong(
					request, "authorSiteId" + authorSiteIndex);
			
			String authorSiteName = ParamUtil.getString(
					request, "siteName" + authorSiteIndex);
			
			String authorSiteURL = ParamUtil.getString(
					request, "siteURL" + authorSiteIndex);
			
			if (Validator.isNull(authorSiteURL))  {
				continue;
			}		
			
			
			authorSite.put(authorSiteName, authorSiteURL);
			
			
			
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
		         Author.class.getName(), request);
		
		
		long[] catIds = null;
		
		if (!categoryIds.isEmpty())
		{
			String[] catIdsArr = categoryIds.split(",");
			catIds= new long[catIdsArr.length];
			for (int i = 0;i < catIdsArr.length; i++)
			{
				if (!catIdsArr[i].isEmpty())
					catIds[i] = Long.parseLong(catIdsArr[i]);
				
			}
		}
		//fail safe
		if (Validator.isNotNull(catIds))
		{
			catIds = ArrayUtil.remove(catIds, 0L);
		}
		serviceContext.setAssetCategoryIds(catIds);
		
		if (cmd.equalsIgnoreCase(Constants.ADD))
		{
			
			authorId = AuthorLocalServiceUtil.addAuthor(firstName, middleName,lastName,
					title,email,officeNo, 
					authorSite,remoteId, 
					idType, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 
					themeDisplay.getUserId(),expertiseNamesArr,researchInterestNameArr,serviceContext);
			
			
		}else
		{
			 AuthorLocalServiceUtil.updateAuthor(authorId, title, 
					firstName, middleName,lastName, 
					email,officeNo,
					authorSite,
					remoteId, idType, 
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), 
					expertiseNamesArr,researchInterestNameArr,serviceContext);
			
			
		}
		
		
		
		
		
	}
	public void search(ActionRequest request,ActionResponse response) throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String middleName = ParamUtil.getString(request, "middleName");
		String filterBy = ParamUtil.getString(request, "filterBy");
		long filterKey = ParamUtil.getLong(request, "filterKey");
		
		_log.info("filterby="+filterBy);
		boolean matchAny = ParamUtil.getBoolean(request, "matchAny");
		//expertise
		
		String[] expertiseIdArr = ParamUtil.getParameterValues(request, "expertise");
		String[] researchInterestIdArr = ParamUtil.getParameterValues(request, "researchInterest");
		
		
		long[] expertiseIds = new long[]{expertiseIdArr.length};
		long[] researchInterestIds = new long[] {researchInterestIdArr.length};
		ArrayList<Long> expIds = new ArrayList<Long>();
		for(String expIdString: expertiseIdArr)
		{
			try
			{
				expIds.add(Long.valueOf(expIdString));
			} catch (Exception ex)
			{
				
			}
		}
		expertiseIds = ArrayUtil.toLongArray(expIds);
		
		ArrayList<Long> riIds = new ArrayList<Long>();
		for (String riIdString : researchInterestIdArr)
		{
			try
			{
				riIds.add(Long.valueOf(riIdString));
			} catch (Exception ex)
			{
				
			}
		}
		researchInterestIds = ArrayUtil.toLongArray(riIds);
		
		//collect category
		long[] groupIds = new long[] {themeDisplay.getScopeGroupId()};
		List<AssetVocabulary> authorVocabularies = AuthorUtil.getAuthorVocabulary(groupIds);
		
		
		long[] categoryIds = new long[]{};
		for (AssetVocabulary vocab: authorVocabularies)
		{
			String key = StringUtil.replace(vocab.getName(), StringPool.SPACE, StringPool.UNDERLINE);
			String[] valueArr = ParamUtil.getParameterValues(request, key);
			
			
			long[] vocabCategories = new long[]{0};
			ArrayList<Long> vocabCategoryList = new ArrayList<Long>();
			
			for (String id: valueArr)
			{
				try
				{
					String _id = StringUtil.split(id, "-")[1];
					vocabCategoryList.add(Long.valueOf(_id));
					
				}catch (Exception ex)
				{
					
				}
			}
			vocabCategories = ArrayUtil.toLongArray(vocabCategoryList);
			
			categoryIds = ArrayUtil.append(categoryIds,vocabCategories);
			
		}
		if (categoryIds.length == 0)
		{
			String catId = ParamUtil.getString(request, "categoryId");
			if (Validator.isNotNull(catId))
				categoryIds = new long[]{Long.valueOf(catId)};
		}
		
		
		AuthorQuery authorQuery = new AuthorQuery();
		authorQuery.setFirstName(firstName);
		authorQuery.setMiddleName(middleName);
		authorQuery.setLastName(lastName);
		if (matchAny)
		{
			authorQuery.setAnyExpertiseIds(expertiseIds);
			authorQuery.setAnyCategoryIds(categoryIds);
			authorQuery.setAnyResearchInterestIds(researchInterestIds);
			
		}else
		{
			authorQuery.setAllCategoryIds(categoryIds);
			authorQuery.setAllExpertiseIds(expertiseIds);
			authorQuery.setAllResearchInterestIds(researchInterestIds);
			
		}
		if (Validator.isNotNull(filterBy))
		{
			_log.info("filterBy="+filterKey+ " :"+filterBy);
			if (filterBy.equalsIgnoreCase("expertise"))
			{
				
				authorQuery.setAllExpertiseIds(new long[]{filterKey});
			}
			if (filterBy.equalsIgnoreCase("ri"))
			{
				authorQuery.setAllResearchInterestIds(new long[]{filterKey});
			}
			if (filterBy.equalsIgnoreCase("category"))
			{
				authorQuery.setAllCategoryIds(new long[]{filterKey});

			}
		}
		
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);
		
		List<Author> entries = doSearch(authorQuery,searchContext);
		
		
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
		PortalUtil.copyRequestParameters(request, response);

		response.setRenderParameter("jspPage","/html/author/filter_view.jsp");
		response.setRenderParameter("search", "true");
		request.setAttribute("entries", entries);


	    
	}
	public void processEvent(EventRequest request,EventResponse response) throws PortletException, IOException 
	{
		
		Event event = request.getEvent();
        String value = (String) event.getValue();
        
        _log.info("event"+event.getName()+value);
        long authorId = 0L;
        if (event.getName().equalsIgnoreCase("authorNav"))
        {
        	authorId = Long.valueOf(value);
        }
        
		//event from author nav portlet
		if (Validator.isNotNull(authorId) && authorId != 0)
		{
			_log.info("au event="+authorId);
			
			response.setRenderParameter("authorId", value);
			response.setRenderParameter("jspPage", "/html/author/view_author.jsp");
			return;
		}
        
        List<Author> entries = null;
        
        
        
		try {
			entries = searchAuthor(request,response);
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		
        request.setAttribute("entries", entries);
        response.setRenderParameter("jspPage", "/html/author/filter_view.jsp");
        
        
	}
	
	private List<Author> searchAuthor(EventRequest request,EventResponse response) throws PortalException, SystemException
	{
		String categoryIds = ParamUtil.getString(request, "categoryId", StringPool.BLANK);
		
		
		AuthorQuery authorQuery = new AuthorQuery();
		authorQuery.setAllCategoryIdString(categoryIds);
		
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);

		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);
		return doSearch(authorQuery,searchContext);
		
	}
	
	private List<Author> doSearch(AuthorQuery authorQuery,SearchContext searchContext) throws PortalException, SystemException
	{
		
		
		
		AuthorQueryUtil queryUtil = new AuthorQueryUtil(authorQuery);

		Query stringQuery = StringQueryFactoryUtil.create(queryUtil.getQueryString());
		BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery, BooleanClauseOccur.MUST.getName());
		
		searchContext.setBooleanClauses(new BooleanClause[] {clause});
		
		List<Document> docs= null;
	    List<Author> entries = new ArrayList<Author>();
		Hits hits = null;
	    try
		{
			hits = SearchEngineUtil.search(searchContext,stringQuery);//, groupIds, userId, className, query, start, end)
			docs = hits.toList();
			_log.info("hit="+hits.getLength());
			for (int i = 0;i < hits.getDocs().length; i++)
			{
	            Document doc = hits.doc(i);
				long authorId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				Author author = AuthorLocalServiceUtil.getAuthor(authorId);
				entries.add(author);
				
			}
		}
		catch (SearchException se)
		{
			_log.error(se);
		}
	    return entries;
	}
 
		private static Log _log = LogFactoryUtil.getLog(Subur.class);

}
