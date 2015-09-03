<%@ include file="/html/author/init.jsp" %>
<div class="form-search">
	<liferay-ui:input-search autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' />
</div>