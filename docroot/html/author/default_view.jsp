<%@ include file="/html/author/init.jsp" %>
<%
	List<AssetVocabulary> authorVocabs = AssetVocabularyLocalServiceUtil.getGroupsVocabularies(new long[]{themeDisplay.getScopeGroupId()},
		Author.class.getName());	

	List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		long[] groupIds = new long[] {themeDisplay.getScopeGroupId()};
		List<AssetVocabulary> authorVocabularies = AuthorUtil.getAuthorVocabulary(groupIds);
		int vocabCount = authorVocabularies.size();
		int colWidth=33;
		if (vocabCount > 1)
			colWidth=50;
		

%>
<aui:row>
	<aui:layout>
		<div class="span4">
		<h4>By Expertise</h4>	
		
		<ul>
		<%
			List<Expertise> top10Expertises = ExpertiseLocalServiceUtil.getTop10(themeDisplay.getScopeGroupId());
			for (Expertise expertise: top10Expertises)
			{
		%>
			<portlet:actionURL var="byExpertiseURL" name="search">
				
				<portlet:param name="filterBy" value="expertise" />
				<portlet:param name="filterKey" value="<%=String.valueOf(expertise.getExpertiseId()) %>" />
			</portlet:actionURL>
		
		
			<li><a href="<%=byExpertiseURL %>">
				<%=expertise.getName() %>
			</a>
			
			
			<span class="badge"><%=expertise.getAuthorCount() %></span>
			</li>
		
		<%} %>
		</ul>
	</div>
	<div class="span4">
		<h4>By Research Interest</h4>	
		<ul>
		
		<%
			List<ResearchInterest> top10ResearchInterest = ResearchInterestLocalServiceUtil.getTop10(themeDisplay.getScopeGroupId());
			for (ResearchInterest researchInterest: top10ResearchInterest)
			{
		%>
		<portlet:actionURL var="byRIURL" name="search">
				
				<portlet:param name="filterBy" value="ri" />
				<portlet:param name="filterKey" value="<%=String.valueOf(researchInterest.getResearchInterestId()) %>" />
			</portlet:actionURL>
		
			<li><a href="<%=byRIURL %>">
			<%=researchInterest.getName()  %>
				</a>
				<span class="badge"><%= researchInterest.getAuthorCount() %></span>
			</li>
		
		<%} %>
		</ul>
	</div>
	
	
	
</aui:layout>
</aui:row>

	<aui:row>
	<%
	int vocabCol = 0;
	for (AssetVocabulary vocab: authorVocabularies)
	{
		
	%>
		<div class="span4">
			<h4>By <%=vocab.getName() %></h4>
				<ul>
				<%
	
				Map<String,AssetCategory> top10Categories = AuthorUtil.getTop10CategoryByVocabulary(vocab.getVocabularyId());
				int i = 0;
				for (Map.Entry<String, AssetCategory> entries : top10Categories.entrySet())
				{
					AssetCategory category = entries.getValue();
					String keyWithCount = entries.getKey();
					int count = Integer.parseInt(StringUtil.split(keyWithCount,"-")[0]);
					String key = StringUtil.split(keyWithCount,"-")[1];
					i++;
					if (i > 10)
						break;
				%>
				<portlet:actionURL var="byCategory" name="search">
				
				<portlet:param name="filterBy" value="category" />
				<portlet:param name="filterKey" value="<%=key %>" />
			</portlet:actionURL>
				
					<li>
						<a href="<%=byCategory %>">
							<%=category.getName() %>
						</a>
						<span class="badge"><%= count %></span>
					</li>
				
				<%
				}
					%>
				
				</ul>
		
		
		</div>
	<%
	}
	%>
	
	
	
	
	</aui:row>
