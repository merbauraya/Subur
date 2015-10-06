<%@include file="/html/itemtype-navigation/init.jsp" %>


xxxxxxx

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" >
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	

	<aui:fieldset>

		<aui:input label="show-internal-label"
			name="preferences--showInternalLabel--" 
			type="checkbox" checked="<%=showInternalLabel %>"/>

		

		<aui:input name="preferences--internalLabel--" value="<%= internalLabel %>" />

		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>


