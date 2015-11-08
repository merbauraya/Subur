<%@ include file="/html/subur/init.jsp" %>
<%@ page import="com.idetronic.subur.model.CopyRequest" %>

<%
	CopyRequest copyRequest = (CopyRequest) request.getAttribute(WebKeys.SUBUR_COPY_REQUEST);
	String fromEmailAddress = StringPool.BLANK;	
	if (Validator.isNotNull(copyRequest))
		fromEmailAddress = copyRequest.getFromEmailAddress();

%>

<c:choose>
	<c:when test="<%=Validator.isNotNull(copyRequest) %>">
		<div class="alert alert-success">
	
			<liferay-ui:message arguments="<%= fromEmailAddress %>" key="request-copy-success-x" />
	
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<liferay-ui:message key="error-processing-your-request" />
			
		</div>
	
	</c:otherwise>
</c:choose>
