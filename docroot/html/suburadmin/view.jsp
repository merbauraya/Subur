<%@ include file="/html/init.jsp" %>


<%
	String pageName=StringPool.BLANK;
	String authorSalutation = SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SALUTATION);
	String authorSite = SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SITES);
	String itemIdentifier = SuburConfiguration.getConfig(SuburConfiguration.ITEM_IDENTIFIERS);
	if (Validator.isNull(authorSalutation))
	{
		authorSalutation = "Mr,Mrs,Ms,Dr,Prof";
	}
	
	if (Validator.isNull(authorSite))
	{
		authorSite = "Personal Site,Google Scholar";
	}
	if (Validator.isNull(itemIdentifier))
	{
		itemIdentifier = "ISBN,ISSN,Gov Doc#";
	}
	
%>
<%@ include file="/html/suburadmin/nav.jsp" %>

<portlet:actionURL name="saveConfig" var="saveConfigURL">
	
</portlet:actionURL>
<aui:form action="<%= saveConfigURL %>">
	
	<aui:input name="authorSalutation" value="<%= authorSalutation %>">
		<aui:validator name="required"/>
	</aui:input>
	<aui:input name="authorSite" value="<%= authorSite %>">
		
	</aui:input>
	<aui:input name="itemIdentifier" value="<%= itemIdentifier %>">
		
	</aui:input>
	
	<aui:button-row>
	
		<aui:button type="submit" />

		
	
	</aui:button-row>
</aui:form>