<%@ include file="/html/author/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	
	
	String authorSalutationConfigString = SuburConfiguration.getConfigString(SuburConfiguration.AUTHOR_SALUTATION);
	String authorSiteConfigString = SuburConfiguration.getConfigString(SuburConfiguration.AUTHOR_SITES);
	
	String[] siteNameList = StringUtil.split(authorSiteConfigString,",");
	String[] titles = StringUtil.split(authorSalutationConfigString, ",");
	long authorId = ParamUtil.getLong(request,"authorId");
	
	Author author = null;
	List<AuthorSite> authorSites = Collections.emptyList();
	int[] authorSiteIndexes = null;
	
	
	if (Validator.isNotNull(authorId))
	{
		author = AuthorLocalServiceUtil.getAuthor(authorId);
		authorSites = AuthorSiteLocalServiceUtil.findByAuthorId(authorId);
		authorSiteIndexes = new int[authorSites.size()];
		for (int i = 0; i < authorSites.size(); i++)
		{
			authorSiteIndexes[i] = i;
		}
		
		
		
	}else
	{
		authorSiteIndexes = new int[] {0};
		
	}
	if (authorSites.isEmpty())
	{
		authorSites = new ArrayList<AuthorSite>();
		authorSites.add(new AuthorSiteImpl());
		authorSiteIndexes = new int[] {0};
	}
	if (authorSiteIndexes == null)
	{
		authorSiteIndexes = new int[] {0};
	}
	
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	localizeTitle="<%= (author == null) %>"
	title='<%= (author == null) ? "new-author" : author.getDisplayName() %>'
/>
<portlet:actionURL var="editAuthorActionURL" name="editAuthor">

	<portlet:param name="backURL" value="<%= backURL %>" />
</portlet:actionURL>
<aui:form action="<%=editAuthorActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (author == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="authorId" type="hidden" value="<%= authorId %>" />
	
	<aui:model-context bean="<%= author %>" model="<%= Author.class %>" />
	
		<aui:select name="title">
		<%	for (String authorTitle : titles) {
			boolean selected = false;
			if ((author != null) && (author.getTitle() == authorTitle))
				selected = true;
		%>
			<aui:option selected="<%= selected %>"  value="<%=authorTitle %>"><%=authorTitle %></aui:option>
		<%
		}
		%>
		</aui:select>
		<aui:input type="text" name="firstName" cssClass="fullwidth">
			<aui:validator name="required" />	
			
		
		</aui:input>
		<aui:input type="text" name="middleName" cssClass="fullwidth"/>
		<aui:input type="text" name="lastName" cssClass="fullwidth">
			<aui:validator name="required" />	
		</aui:input>
		<aui:input type="text" name="email" cssClass="fullwidth">
			<aui:validator name="email" />
		</aui:input>
		<aui:input name="officeNo" cssClass="fullwidth"/>
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="categorization">
			<%
				PortletURL portletURL = renderResponse.createRenderURL();
				/*
				String authorVocabularyIdString = null;
				Map<String,Long> authorCategoryMap = AuthorUtil.getAuthorCategories(authorCategoryXML);
				long[] authorVocabs = null;
				
				if (authorCategoryMap != null && authorCategoryMap.size() > 0 )
				{
					authorVocabs = new long[authorCategoryMap.size()];
					int i = 0;
					for (Map.Entry<String,Long> entry : authorCategoryMap.entrySet())
					{
						
						authorVocabs[i] = entry.getValue();
						i++;
					}
					authorVocabularyIdString = StringUtil.merge(authorVocabs);
					
				}
				*/
				
			%>
			<aui:input 
				classPK="<%= (author != null ? author.getAuthorId(): 0L) %>" 
				model="<%= Author.class %>" 
				name="categories" 
				className="<%= Author.class.getName() %>"
			type="assetCategories" />
				
			
		<aui:input type="hidden" name="categoryIds" id="categoryIds" value=""/>			
		
		
		
		</liferay-ui:panel>
		
		
<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="author-site">
		
		
		<div id="authorSite">
		<%
			for (int i = 0; i < authorSiteIndexes.length; i++) {
				int authorSiteIndex = authorSiteIndexes[i];
				AuthorSite authorSite = authorSites.get(i);
		%>
		
			<aui:model-context bean="<%= authorSite %>" model="<%= AuthorSite.class %>" />
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields">
					<aui:input name='<%= "authorSiteId" + authorSiteIndex %>' type="hidden" value="<%= authorSite.getAuthorSiteId() %>" />
					<aui:select inlineField="<%= true %>" label="type" name='<%= "siteName" +  authorSiteIndex%>'>
					<%
						for (String siteName : siteNameList) 
						{
							boolean selected = false;
							if (siteName.equalsIgnoreCase(authorSite.getSiteName())) 
								selected = true;
					%>
						<aui:option selected="<%= selected %>"  value="<%=siteName %>"><%=siteName %></aui:option>
					<%		
						}
					%>
					</aui:select>
					
					<aui:input type="text" label="site-url" fieldParam='<%= "siteURL" + authorSiteIndex %>' 
						id='<%= "siteURL" + authorSiteIndex %>'
						inlineField="<%= true %>" 
						name='siteURL' 
						cssClass="fullwidth"
						
					>
						<aui:validator name="uri" />	
						
					</aui:input>
					
				</div>
			
			</div>
		<%
			}
		%>
		<aui:input name="authorSiteIndexes" type="hidden" value="<%= StringUtil.merge(authorSiteIndexes) %>" />
		</div>
		<aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
    	{
    		contentBox: '#authorSite',
    		fieldIndexes: '<portlet:namespace />authorSiteIndexes',
    		namespace: '<portlet:namespace/>'
    	}
    ).render();
  </aui:script>
	
</liferay-ui:panel>		
		
	



<%
	boolean autoFocus = true;
	PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
	String contentCallback = portletResponse.getNamespace() + "getSuggestionsContent";
	String riContentCallback = contentCallback + "_ri";
	String curTags = StringPool.BLANK;
	String curResearchInterest = StringPool.BLANK;
	if (author!= null)
	{
		List<Expertise> curExpertises = AuthorLocalServiceUtil.getExpertises(authorId);
		curTags = ListUtil.toString(curExpertises,"name");
		List<ResearchInterest> authorResearchInterests = AuthorLocalServiceUtil.getResearchInterests(authorId)	;
		curResearchInterest = ListUtil.toString(authorResearchInterests,"name");
		
	}
	
	long[] groupIds = new long[] {themeDisplay.getScopeGroupId() } ;
	String className = SuburItem.class.getName();
	String namespace = portletResponse.getNamespace();
	String hiddenInput = "expertiseNames";
	String hiddenInput2 = "researchInterestNames";
	String id = "expertise";// GetterUtil.getString((String)request.getAttribute("liferay-ui:asset-tags-selector:id"));
	String id2 = "researchInterest";//id+"researchInterest";
%>
<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title="expertise-and-research-interest">

<h5>
<liferay-ui:message key="expertise"/>
</h5>
<div class="lfr-tags-selector-content" id="<%= namespace + id %>expertiseTagsSelector">
	<aui:input name="<%= hiddenInput %>" type="hidden" />

	<input class="lfr-tag-selector-input" id="<%= id %>assetTagNames" maxlength="75" size="35" title="<liferay-ui:message key="add-tags" />" type="text" />
</div>

<h5><liferay-ui:message key="research-interest"/></h5>
<div class="lfr-tags-selector-content" id="<%= namespace + id %>researchInterestTagsSelector">
	<aui:input name="<%= hiddenInput2 %>" type="hidden" />

	<input class="lfr-tag-selector-input" id="<%= id %>researchInterestTagNames" maxlength="75" size="35" title="<liferay-ui:message key="add-tags" />" type="text" />
</div>

</liferay-ui:panel>
<aui:script use="expertise-tags-selector">
	var expertiseSelector = new Liferay.ExpertiseTagsSelector(
		{
			allowSuggestions: <%= false %>,
			contentBox: '#<%= namespace + id %>expertiseTagsSelector',

			<c:if test="<%= Validator.isNotNull(contentCallback) %>">
				contentCallback: function() {
					if (window.<%= contentCallback %>) {
						return <%= contentCallback %>();
					}
				},
			</c:if>

			curEntries: '<%= HtmlUtil.escapeJS(curTags) %>',

			<c:if test="<%= groupIds != null %>">
				groupIds: '<%= StringUtil.merge(groupIds) %>',
			</c:if>

			hiddenInput: '#<%= namespace + hiddenInput %>',
			input: '#<%= id %>assetTagNames',
			instanceVar: '<%= namespace + id %>',
			tagType :'expertise',
			NAME: 'expertiseTagSelector',
			portalModelResource: <%= Validator.isNotNull(className) && (ResourceActionsUtil.isPortalModelResource(className) || className.equals(Group.class.getName())) %>
		}
	);
	expertiseSelector.render();

	<c:if test="<%= autoFocus %>">
		Liferay.Util.focusFormField('#<%= id %>assetTagNames');
	</c:if>
	
	var expertiseSelector = new Liferay.ExpertiseTagsSelector(
			{
				allowSuggestions: <%= true %>,
				contentBox: '#<%= namespace + id %>researchInterestTagsSelector',

				<c:if test="<%= Validator.isNotNull(riContentCallback) %>">
					contentCallback: function() {
						if (window.<%= riContentCallback %>) {
							return <%= riContentCallback %>();
						}
					},
				</c:if>

				curEntries: '<%= HtmlUtil.escapeJS(curResearchInterest) %>',

				<c:if test="<%= groupIds != null %>">
					groupIds: '<%= StringUtil.merge(groupIds) %>',
				</c:if>

				hiddenInput: '#<%= namespace + hiddenInput2 %>',
				input: '#<%= id %>researchInterestTagNames',
				instanceVar: '<%= namespace + id2 %>',
				tagType :'researchInterest',
				NAME: 'researchInterestTagSelector',
				portalModelResource: <%= Validator.isNotNull(className) && (ResourceActionsUtil.isPortalModelResource(className) || className.equals(Group.class.getName())) %>
			}
		);
		
		expertiseSelector.render();
	
</aui:script>


	<aui:button-row>
	<aui:button type="submit" />
	
	<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
<aui:script>
function <portlet:namespace />submitForm()
{
	var A = AUI();
	var assetCategoryIdArr = [];
	var catdIds = A.all('input[name^=<portlet:namespace/>assetCategoryIds]');
	
	catdIds.each(function(){
		assetCategoryIdArr.push(this.val());
		
		
		
	});
	A.one("#<portlet:namespace/>categoryIds").val(assetCategoryIdArr);
	submitForm(document.<portlet:namespace />fm);
	
}
</aui:script>


<%!
private static Log _log = LogFactoryUtil.getLog("subur.html.edit.author");
%>