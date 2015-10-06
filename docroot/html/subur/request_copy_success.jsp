<%@ include file="/html/subur/init.jsp" %>
<%@ page import="com.idetronic.subur.model.CopyRequest" %>

<%
	CopyRequest copyRequest = (CopyRequest) request.getAttribute(WebKeys.SUBUR_COPY_REQUEST);
	String fromEmailAddress = copyRequest.getFromEmailAddress();

%>

<div class="alert alert-success">
	
	<liferay-ui:message arguments="<%= fromEmailAddress %>" key="request-copy-success-x" />
	
</div>