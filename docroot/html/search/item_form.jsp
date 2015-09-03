<%@include file="/html/init.jsp"%>

<%
	SuburSearch searchContainer = (SuburSearch)request.getAttribute("liferay-ui:search:searchContainer");

	SuburDisplayTerms suburDisplayTerms = (SuburDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>"
	buttonLabel="search"
	displayTerms="<%= suburDisplayTerms %>"
	id="toggle_id_subur_item_search"
	
	
>
	<aui:fieldset id="itemSearch" cssClass="itemSearchForm">
		
		
		<aui:field-wrapper>
			<aui:input inlineLabel ="left" inlineField="<%= true %>" name="<%= suburDisplayTerms.TITLE %>" size="20" value="<%= suburDisplayTerms.getTitle() %>" />
			
			<aui:input inlineLabel ="left" inlineField="true" name="<%= suburDisplayTerms.AUTHOR_FIRST_NAME %>" size="30" value="<%= suburDisplayTerms.getAuthorFirstName() %>" />
			<aui:input last="<%=true %>" inlineLabel ="left" inlineField="<%= true %>" name="<%= suburDisplayTerms.AUTHOR_LAST_NAME %>" size="30" value="<%= suburDisplayTerms.getAuthorLastName() %>" />
			<aui:input label="yearPublished" name="<%= suburDisplayTerms.YEAR_PUBLISHED %>" size="20" value="<%= suburDisplayTerms.getYear() %>" />
			<aui:select size="1" multiple="<%=false %>" name="<%=SuburDisplayTerms.ITEM_TYPE %>">
				<aui:option value="0" selected="<%= suburDisplayTerms.getItemType()==0 %>">Any</aui:option>
			<%
				List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				for (ItemType itemType: itemTypes)
				{
					boolean selected = itemType.getItemTypeId() == suburDisplayTerms.getItemType();
			%>
					<aui:option selected="<%=selected %>" value="<%= itemType.getItemTypeId() %>">
						<%=itemType.getItemTypeName() %>
					</aui:option>
			<%	}
			%>
				
			</aui:select>
			
			<aui:input 
		
		model="<%= SuburItem.class %>" 
		name="categories" 
		type="assetCategories" />	
		
		<aui:input 
		model="<%= SuburItem.class %>" 
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