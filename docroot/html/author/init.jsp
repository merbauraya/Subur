<%@ include file="/html/init.jsp" %>
<%@ page import="com.idetronic.subur.model.ResearchInterest" %>
<%@ page import="com.idetronic.subur.util.AuthorUtil" %>
<%@ page import="com.idetronic.subur.service.ExpertiseLocalServiceUtil" %>
<%@ page import="com.idetronic.subur.service.ResearchInterestLocalServiceUtil" %>
<%@ page import="com.idetronic.subur.service.persistence.AuthorQuery" %>
<%@ page import="com.idetronic.subur.util.AuthorQueryUtil" %>
<%@ page import="com.idetronic.subur.service.permission.AuthorPermission" %>
<%@ page import="com.liferay.portal.kernel.search.StringQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.Query" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClauseFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClauseOccur" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanClause" %>
<%@ page import="com.liferay.portal.kernel.search.SearchException" %>
<%@ page import="com.idetronic.subur.NoSuchAuthorException" %>
<%
	int delta = GetterUtil.getInteger(portletPreferences.getValue("delta", null), SearchContainer.DEFAULT_DELTA);
	String paginationType = GetterUtil.getString(portletPreferences.getValue("paginationType", "none"));

	boolean showAdminAuthor = AuthorPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE);
	boolean showSearch = true;
%>
