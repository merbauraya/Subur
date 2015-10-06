package com.idetronic.subur.portlet;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.NoSuchAuthorException;
import com.idetronic.subur.model.Author;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ResearchInterestLocalServiceUtil;
import com.idetronic.subur.service.permission.AuthorPermission;
import com.idetronic.subur.service.persistence.AuthorQuery;
import com.idetronic.subur.util.AuthorQueryUtil;
import com.idetronic.subur.util.AuthorUtil;
import com.idetronic.subur.util.WebKeys;
import com.liferay.portal.ImageTypeException;
import com.liferay.portal.NoSuchRepositoryException;
import com.liferay.portal.NoSuchResourceException;
import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.security.permission.PermissionChecker;
/**
 * Portlet implementation class AuthorPortlet
 */
public class AuthorPortlet extends MVCPortlet {
	
	
	public void newAuthor(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException
	{
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String salutation = ParamUtil.getString(actionRequest, "salutation");
		String middleName =  ParamUtil.getString(actionRequest, "middleName");
		String lastName =  ParamUtil.getString(actionRequest, "lastName");
		String email = ParamUtil.getString(actionRequest, "email");
		String officeNo = ParamUtil.getString(actionRequest, "officeNo");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Author.class.getName(), actionRequest);
		
		Author author = AuthorLocalServiceUtil.newAuthor(firstName, middleName, lastName, salutation, 
				email, officeNo, serviceContext);
		
		actionRequest.setAttribute(WebKeys.SUBUR_AUTHOR, author);
		
		actionResponse.setRenderParameter("authorId", String.valueOf(author.getAuthorId()));
		actionResponse.setRenderParameter("mvcPath","/html/admin/author/edit_author.jsp");
	}
	
	/**
	 * editAuthor - Add/Edit author action request during item author 	
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException 
	 */
	public void editAuthor(ActionRequest request,ActionResponse response)throws PortalException, SystemException, IOException
	{
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		File coverPhoto = uploadRequest.getFile("coverPhoto");

		
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
		String salutation = ParamUtil.getString(request, "salutation");
		String email = ParamUtil.getString(request, "email");
		String officeNo = ParamUtil.getString(request, "officeNo");
		String categoryIds = ParamUtil.getString(request, "categoryIds");
		String title = ParamUtil.getString(request, "title");
		
		
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
		int[] authorSiteIndexes = StringUtil.split(authorSiteIndexesString,0);
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
		
		serviceContext.setAttribute(WebKeys.AUTHOR_COVER_PHOTO, coverPhoto); 
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
					salutation,email,officeNo, 
					authorSite,remoteId, 
					idType, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 
					themeDisplay.getUserId(),expertiseNamesArr,researchInterestNameArr,serviceContext);
			
			
		}else
		{
			 AuthorLocalServiceUtil.updateAuthor(authorId, salutation, 
					firstName, middleName,lastName, 
					email,officeNo,
					authorSite,
					title, 
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), 
					expertiseNamesArr,researchInterestNameArr,serviceContext);
			
			
		}
		
		
		
		
		
	}
	public void editPortrait(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception
	{
		
		
		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD_TEMP)) {
				_log.info("ADD_TEMP");
				addTempImageFile(actionRequest);
			}
			else {
				_log.info("saveTmp");
				UploadPortletRequest uploadPortletRequest =
						PortalUtil.getUploadPortletRequest(actionRequest);
				
				long authorId = ParamUtil.getLong(uploadPortletRequest, "authorId");
				_log.info("mz-"+authorId);
				saveTempImageFile(actionRequest,authorId);

				sendRedirect(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchAuthorException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass());
				actionResponse.setRenderParameter("mvcPath", "/html/author/error.jsp");
				
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			}
			else if (e instanceof FileSizeException ||
					 e instanceof ImageTypeException ||
					 e instanceof NoSuchFileException ||
					 e instanceof UploadException ||
					 e instanceof UserPortraitSizeException ||
					 e instanceof UserPortraitTypeException) {

				SessionErrors.add(actionRequest, e.getClass());
			}
			else {
				throw e;
			}
		}
		
	}
	protected void saveTempImageFile(ActionRequest actionRequest,long authorId)
			throws Exception 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);
			FileEntry tempFileEntry = null;
			
			InputStream tempImageStream = null;

			try 
			{
				_log.info("trying savetno");
				
				
				String xx = ParamUtil.getString(actionRequest, "authorId");
				_log.info(":author="+authorId	+ "::"+xx);
				tempFileEntry = TempFileUtil.getTempFile(
						themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
						String.valueOf(authorId), getTempImageFolderName());
				
				
				_log.info(tempFileEntry.getTitle());
				tempImageStream = tempFileEntry.getContentStream();

				ImageBag imageBag = ImageToolUtil.read(tempImageStream);

				RenderedImage renderedImage = imageBag.getRenderedImage();

				String cropRegionJSON = ParamUtil.getString(
					actionRequest, "cropRegion");

				if (Validator.isNotNull(cropRegionJSON)) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
						cropRegionJSON);

					int height = jsonObject.getInt("height");
					int width = jsonObject.getInt("width");
					int x = jsonObject.getInt("x");
					int y = jsonObject.getInt("y");

					if ((height + y) > renderedImage.getHeight()) {
						height = renderedImage.getHeight() - y;
					}

					if ((width + x) > renderedImage.getWidth()) {
						width = renderedImage.getWidth() - x;
					}

					renderedImage = getCroppedRenderedImage(
						renderedImage, height, width, x, y);
				}

				byte[] bytes = ImageToolUtil.getBytes(
					renderedImage, imageBag.getType());
				_log.info("saved tmp");
				saveTempImageFile(authorId, bytes);
			}
			catch (NoSuchFileEntryException nsfee) {
				_log.info("nsfee");
				throw new UploadException(nsfee);
			}
			catch (NoSuchRepositoryException nsre) {
				nsre.printStackTrace();
				throw new UploadException(nsre);
			}
			finally {
				StreamUtil.cleanUp(tempImageStream);

				if (tempFileEntry != null) {
					TempFileUtil.deleteTempFile(tempFileEntry.getFileEntryId());
				}
			}
		}
	protected RenderedImage getCroppedRenderedImage(
			RenderedImage renderedImage, int height, int width, int x, int y) {

			Rectangle rectangle = new Rectangle(width, height);

			Rectangle croppedRectangle = rectangle.intersection(
				new Rectangle(renderedImage.getWidth(), renderedImage.getHeight()));

			BufferedImage bufferedImage = ImageToolUtil.getBufferedImage(
				renderedImage);

			return bufferedImage.getSubimage(
				x, y, croppedRectangle.width, croppedRectangle.height);
		}
	protected void saveTempImageFile(
			long authorId, byte[] bytes)
		throws Exception {
		
		
		_log.info("saveTemp="+authorId);
		AuthorLocalServiceUtil.updatePortrait(authorId, bytes);
	}
	protected void addTempImageFile(PortletRequest portletRequest)
			throws Exception 
	{

			UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(portletRequest);

			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

			String contentType = uploadPortletRequest.getContentType("fileName");
			_log.info(contentType);

			if (!MimeTypesUtil.isWebImage(contentType)) {
				throw new ImageTypeException();
			}
			_log.info("in addTemp");
			
			try {
				TempFileUtil.deleteTempFile(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					getTempImageFileName(portletRequest), getTempImageFolderName());
			}
			catch (Exception e) {
			}

			InputStream inputStream = null;

			try {
				inputStream = uploadPortletRequest.getFileAsStream("fileName");
				String tmpFolderName = getTempImageFolderName();
				String fileName = ParamUtil.getString(uploadPortletRequest, "authorId"); //   getTempImageFileName(portletRequest);
				_log.info(fileName);
				_log.info(tmpFolderName);
				TempFileUtil.addTempFile(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
					fileName, getTempImageFolderName(),
					inputStream, contentType);
				_log.info("temp aded");
			}
			finally {
				StreamUtil.cleanUp(inputStream);
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

		/*response.setRenderParameter("jspPage","/html/author/filter_view.jsp");*/
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
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String action = ParamUtil.getString(renderRequest, "action");
		try {
			if (action == ActionKeys.UPDATE)
			{
				PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
				if (!AuthorPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), ActionKeys.UPDATE))
				{
					throw new PrincipalException("Not Authorized");
				}
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchResourceException ||
				
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass());
			}
			else {
				throw new PortletException(e);
			}
		}

		super.render(renderRequest, renderResponse);
	}
	
	public void serveResource(ResourceRequest resourceRequest,	ResourceResponse resourceResponse)
			
	{
		_log.info("serveResource");
		try {
			String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

			if (cmd.equals(Constants.GET_TEMP)) {
				FileEntry tempFileEntry = getTempImageFileEntry(
					resourceRequest);

				serveTempImageFile(
					resourceResponse, tempFileEntry.getContentStream());
			}
		}
		catch (NoSuchFileEntryException nsfee) {
		}
		catch (Exception e) {
			_log.error(e);
		}
		
	}
	protected void serveTempImageFile(
			MimeResponse mimeResponse, InputStream tempImageStream)
		throws Exception {

		ImageBag imageBag = ImageToolUtil.read(tempImageStream);

		byte[] bytes = ImageToolUtil.getBytes(
			imageBag.getRenderedImage(), imageBag.getType());

		String contentType = MimeTypesUtil.getExtensionContentType(
			imageBag.getType());

		mimeResponse.setContentType(contentType);

		PortletResponseUtil.write(mimeResponse, bytes);
		_log.info("in serveTempImageFile");
	}
	protected FileEntry getTempImageFileEntry(PortletRequest portletRequest)
			throws PortalException, SystemException {

			ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest =
					PortalUtil.getUploadPortletRequest(portletRequest);
			
			String fileName =  ParamUtil.getString(uploadPortletRequest, "authorId");// getTempImageFileName(uploadPortletRequest);
			String folderName = getTempImageFolderName();
			_log.info(folderName + ":"+ fileName);
			return TempFileUtil.getTempFile(
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
				getTempImageFileName(portletRequest), getTempImageFolderName());
	}
	protected String getTempImageFileName(PortletRequest portletRequest) 
	{
		
		return ParamUtil.getString(portletRequest, "authorId");
	}
	
	protected String getTempImageFolderName() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}
	protected void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		if (SessionErrors.contains(
				renderRequest, NoSuchResourceException.class.getName()) ||
			SessionErrors.contains(
				renderRequest, PrincipalException.class.getName())) {

			include("/html/error.jsp", renderRequest, renderResponse);
		}
		else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}
 
		private static Log _log = LogFactoryUtil.getLog(Subur.class);

}
