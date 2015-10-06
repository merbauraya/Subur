<%@ include file="/html/authornavigator/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.DateSearchEntry" %>


<%
	//int max = Integer.valueOf(maxResearcher);
	//List<Author> authors = AuthorLocalServiceUtil.findByGroupCompany(themeDisplay.getCompanyId(),
	//		themeDisplay.getScopeGroupId(),0,maxResearcher);
	
	List<Author> authors = AuthorLocalServiceUtil.recentByGroup(themeDisplay.getCompanyId(),
			themeDisplay.getScopeGroupId(), new Date(), 0, maxResearcher);


%>
<c:choose>
	<c:when test="<%= authors.isEmpty() %>">
		<liferay-ui:message key="there-are-no-recent-authors" />
	</c:when>
	<c:otherwise>
	<%
		SearchContainer searchContainer = new SearchContainer();
		List resultRows = searchContainer.getResultRows();
		int i = 0;
		for (Author author: authors)
		{
			
			PortletURL viewAuthorURL = renderResponse.createActionURL();
			viewAuthorURL.setParameter("authorId", String.valueOf(author.getAuthorId()));
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(author.getLastPublishedDate());
			int day = cal.get(Calendar.DAY_OF_MONTH);
			String month = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, themeDisplay.getLocale());
					
			
			
	%>
	<c:choose>
		<c:when test='<%=displayStyle.equals("researcher-name") %>'>
			<div class="author-nav-entry media">
				<div class="pull-left">
					<div class="date">
						<span class="month"><%= month %></span>
						<span class="day"><%= day %></span>
					</div>
				</div>
				<div class="author-nav-link media-body">
					<a href="<%= viewAuthorURL.toString() %>">
						<h5> <%= author.getDisplayName() %></h5>
					
					</a>
					
					
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="researcher-display media">
				<aui:a href="<%= viewAuthorURL.toString() %>">
					<span class="researcher-profile-image">
					<%
						String taglibAlt =  HtmlUtil.escapeAttribute(author.getDisplayName());
		
					%>
						<img alt="<%= taglibAlt %>" class="avatar" src="<%=author.getPortraitURL(themeDisplay) %>" width="65" />
					</span>
		
					<span class="user-name">
						<%= author.getDisplayName() %>
					</span>
				</aui:a>
				<div class="researcher-date">
					<span><liferay-ui:message key="date" />:</span> <%= dateFormatDate.format(author.getLastPublishedDate()) %>
				</div>
					
				</div>
			</c:otherwise>
		</c:choose>
	
				
			
			
	<%
		}
	%>	
	
		<liferay-ui:search-iterator paginate="<%= false %>" searchContainer="<%= searchContainer %>" />
	</c:otherwise>
</c:choose>


