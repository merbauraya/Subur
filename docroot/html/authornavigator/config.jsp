<%@ include file="/html/authornavigator/init.jsp" %>
<%
	
	
%>
<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	

	<aui:fieldset>
		<aui:select name="preferences--displayStyle--">
			<aui:option label="researcher-name" value="researcher-name" selected='<%= displayStyle.equalsIgnoreCase("researcher-name") %>'/>
			<aui:option label="researcher-name-and-image" value="researcher-name-and-image" selected='<%= displayStyle.equalsIgnoreCase("researcher-name-and-image") %>'/>
			
		</aui:select>
		
		<aui:select name="preferences--max--" label="max-researcher-display">
			<aui:option label="1" value="1" selected = '<%= maxResearcher == 1 %>'/>
			<aui:option label="2" value="2" selected = '<%= maxResearcher == 2 %>'/>
			<aui:option label="3" value="3" selected = '<%= maxResearcher == 3 %>'/>
			<aui:option label="4" value="4" selected = '<%= maxResearcher == 4 %>'/>
			<aui:option label="5" value="5" selected = '<%= maxResearcher == 5 %>'/>
			<aui:option label="10" value="10" selected = '<%= maxResearcher ==10 %>'/>
		</aui:select>

		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>