<%@ include file="/html/author/init.jsp" %>
<%
	AuthorSearch searchContainer = (AuthorSearch)request.getAttribute("liferay-ui:search:searchContainer");
	AuthorDisplayTerms authorDisplayTerms = (AuthorDisplayTerms)searchContainer.getDisplayTerms();

%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= authorDisplayTerms %>"
	id="toggle_id_subur_author_search"
	
	
>
	<aui:fieldset id="authorSearch" cssClass="authorSearchForm">
		
		
		<aui:field-wrapper>
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= SuburField.AUTHOR_FIRST_NAME %>" size="30" value="<%= authorDisplayTerms.getFirstName() %>" />
			<aui:input last="<%=true %>" inlineLabel ="left" inlineField="<%= true %>" name="<%= SuburField.AUTHOR_LAST_NAME %>" size="30" value="<%= authorDisplayTerms.getLastName() %>" />
			
			
			<aui:input 
		
		model="<%= Author.class %>" 
		name="categories" 
		type="assetCategories" />	
		
		<aui:input 
		model="<%= Author.class %>" 
		name="tags" 
		type="assetTags" />
		</aui:field-wrapper>
		
		
		
	</aui:fieldset>
	<aui:button-row>
	<aui:button type="submit" value="search" />
</aui:button-row>
	<input type="hidden" name="categoryIds" id="<portlet:namespace/>categoryIds" value=""/>			
	<input type="hidden" name="tagNames" id="<portlet:namespace/>tagNames" value=""/>		
</liferay-ui:search-toggle>