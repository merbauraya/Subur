<%@ include file="/html/author/init.jsp" %>

<%
	long authorId = ParamUtil.getLong(request, "authorId");
	
	Author author = AuthorLocalServiceUtil.fetchAuthor(authorId);
	List<Expertise> expertises = AuthorLocalServiceUtil.getExpertises(authorId);
	List<ResearchInterest> researchInterests = AuthorLocalServiceUtil.getResearchInterests(authorId);
	
	boolean canUpdate = AuthorPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE);

%>

<c:choose>
	<c:when test="<%= author == null %>">
		<liferay-ui:message key="no-author-found"></liferay-ui:message>
	</c:when>
	<c:otherwise>
		<%@ include file="/html/author/author_detail.jsp" %>
	</c:otherwise>

</c:choose>