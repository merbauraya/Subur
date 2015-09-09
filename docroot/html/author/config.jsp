<%@ include file="/html/author/init.jsp" %>


<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<aui:form action="<%= configurationActionURL  %>" method="post" name="fm">

	
	
  
  
	
	
	<div class="button-holder">
		<aui:button type="submit" value="save"></aui:button>
	</div>
</aui:form>


		