<%@ include file="/html/init.jsp" %>


<%
	String pageName=StringPool.BLANK;
	String authorSalutation = SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SALUTATION);
	String authorSite = SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SITES);
	String itemIdentifier = SuburConfiguration.getConfig(SuburConfiguration.ITEM_IDENTIFIERS);
	String license = SuburConfiguration.getConfig(SuburConfiguration.PUBLICATION_LICENSE);
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
<aui:form action="<%= saveConfigURL %>" enctype="multipart/form-data">
	
	<aui:input name="authorSalutation" value="<%= authorSalutation %>">
		<aui:validator name="required"/>
	</aui:input>
	<aui:input name="authorSite" value="<%= authorSite %>">
		
	</aui:input>
	<aui:input name="itemIdentifier" value="<%= itemIdentifier %>">
		
	</aui:input>
	
	<c:choose>
		<c:when test="<%= Validator.isNull(license) %>">
			<aui:input name="license" type="file"></aui:input>
		
		</c:when>
		
		<c:otherwise>
			<h2>Publication License</h2>
			<div style="width:80%;height:300px;overflow: scroll;">
				<%=license %>
				
				
			</div>
			<aui:input name="license" type="file"></aui:input>
		</c:otherwise>
	
	</c:choose>
	
	<c:if test="<%= Validator.isNotNull(license)%>">
		
	
	</c:if>
	
	
	
	<aui:button-row>
	
		<aui:button type="submit" />

		
	
	</aui:button-row>
</aui:form>