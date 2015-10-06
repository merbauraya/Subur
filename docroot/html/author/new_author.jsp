<%@ include file="/html/author/init.jsp" %>

<%
	boolean canUpdate = AuthorPermission.contains(permissionChecker, scopeGroupId, "UPDATE");
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);


	String authorSalutationConfigString =  SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SALUTATION);
	String authorSiteConfigString = SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SITES);

	String[] siteNameList = StringUtil.split(authorSiteConfigString,",");
	String[] salutations = StringUtil.split(authorSalutationConfigString, ",");

%>


<portlet:actionURL var="addAuthorActionURL" name="newAuthor">

	
</portlet:actionURL>

<aui:form method="post" action="<%= addAuthorActionURL %>">
	
	
	
	
	<aui:select name="salutation">
	<% 
	for (String salutation : salutations)
	{
	%>
		<aui:option value="<%= salutation %>"><%= salutation %></aui:option>	
	<%
	}
	%>
	</aui:select>
	<aui:input type="text" name="firstName" cssClass="fullwidth">
		<aui:validator name="required" />	
			
	</aui:input>
	<aui:input type="text" name="middleName" cssClass="fullwidth"/>
	<aui:input type="text" name="lastName" cssClass="fullwidth">
		<aui:validator name="required" />	
	</aui:input>
	<aui:input type="text" name="email" cssClass="fullwidth">
		<aui:validator name="email" />
	</aui:input>
	<aui:input name="officeNo" cssClass="fullwidth"/>
	
	
	<aui:button-row>
		<aui:button name="submitBtn" type="submit" value="next" last="true" />
	</aui:button-row>
</aui:form>
