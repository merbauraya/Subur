<%@include file="/html/author/init.jsp"%>

<%
	AuthorSearch searchContainer = (AuthorSearch)request.getAttribute("liferay-ui:search:searchContainer");

	AuthorDisplayTerms authorDisplayTerms = (AuthorDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= authorDisplayTerms %>"
	id="toggle_id_author_search"
	
>
	<aui:fieldset>
		
		
		<aui:field-wrapper>
			<aui:input inlineLabel ="left" inlineField="<%= true %>" name="<%= SuburField.AUTHOR_FIRST_NAME %>" size="20" value="<%= authorDisplayTerms.getFirstName() %>" />
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= SuburField.AUTHOR_LAST_NAME %>" size="20" value="<%= authorDisplayTerms.getLastName() %>" />
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= SuburField.EXPERTISE_NAMES %>" size="20" value="<%= authorDisplayTerms.getExpertiseName() %>" />
			<aui:input inlineLabel ="left" inlineField="true" name="<%= SuburField.RESEARCH_INTEREST_NAMES %>" size="20" value="<%= authorDisplayTerms.getResearchInterestName() %>" />
			
			
		</aui:field-wrapper>
		
		<aui:input 
		
		model="<%= Author.class %>" 
		name="categories" 
		type="assetCategories" />	
		
		<aui:input 
		model="<%= Author.class %>" 
		name="tags" 
		type="assetTags" />
		
		
		
		
	</aui:fieldset>
</liferay-ui:search-toggle>