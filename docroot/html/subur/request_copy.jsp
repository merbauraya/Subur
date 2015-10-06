<%@ include file="/html/subur/init.jsp" %>
<%@ page import="com.idetronic.subur.model.CopyRequest" %>
<%
	CopyRequest copyRequest = null;
	long suburItemId = ParamUtil.getLong(request, "suburItemId");
%>

<portlet:actionURL name="saveRequestCopy" var="saveRequestCopyURL"></portlet:actionURL>


<aui:form method="post" name="fm" action="<%=saveRequestCopyURL %>">
	<aui:model-context bean="<%= copyRequest %>" model="<%= CopyRequest.class %>"></aui:model-context>
	<aui:input type="hidden" name="suburItemId" value="<%= suburItemId %>" />
	<aui:input name="requesterName" label="your-name"/>
	<aui:input name="fromEmailAddress">
		<aui:validator name="email"/>
		<aui:validator name="required" />
	
	</aui:input>
	
	<aui:input name="organization"/>
	<aui:input name="reason">
		<aui:validator name="required" />
	
	</aui:input>
	



	<aui:button-row>
		<aui:button name="submitBtn" type="submit" value="submit" last="true" />
	</aui:button-row>
</aui:form>