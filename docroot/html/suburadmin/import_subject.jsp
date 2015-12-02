<%@ include file="/html/init.jsp" %>

<liferay-portlet:actionURL name="importSubject" var="importSubjectURL"></liferay-portlet:actionURL>


<aui:form name="fm" action="<%= importSubjectURL %>" enctype="multipart/form-data">
	
	<aui:input name="file" type="file"></aui:input>
	<aui:input name="title"></aui:input>
	<aui:button-row>
		<aui:button type="submit" value="import"></aui:button>
	</aui:button-row>
</aui:form>