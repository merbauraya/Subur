<%
	List<AuthorSite> authorSites = AuthorSiteLocalServiceUtil.findByAuthorId(author.getAuthorId());
%>
<c:choose>
	<c:when test="<%= authorSites.size() > 0 %>">

		<h4>Sites</h4>

		<ul class="list-style-none no-left-margin">

<%
	for (AuthorSite authorSite : authorSites)
	{
%>
		<li><a href="<%=authorSite.getSiteURL() %>"><%=authorSite.getSiteName() %></a></li>

<%	
	}
%>

	</ul>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="no-site-defined" />
		</div>
	
	</c:otherwise>

</c:choose>

<c:choose>
	<c:when test="<%=expertises.size() > 0 %>">
		<div class="author-expertise">
			<h4>Expertise </h4>
			
				<ul class="list-style-none no-left-margin">
					<%	for (Expertise expertise : expertises) 
						{	
					%>
							<li class="asset-entry"><%=expertise.getName() %>
					<%
					
						}
					%>
				</ul>
			
			
			
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="no-expertise-defined" />
		</div>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="<%=researchInterests.size() > 0 %>">
		<div class="author-ri">
			<h4>Research Interest </h4>
			
				<ul class="list-style-none no-left-margin">
					<%	for (ResearchInterest ri : researchInterests) 
						{	
					%>
							<li class="asset-entry"><%=ri.getName() %>
					<%
					
						}
					%>
				</ul>
			
			
			
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="no-research-interest-defined" />
		</div>
	</c:otherwise>
</c:choose>	