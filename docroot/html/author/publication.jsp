<%
	//PortletURL portletURL = renderResponse.createRenderURL();

//	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);


	

	

%>
<liferay-ui:search-container emptyResultsMessage="no-publication-were-found"
	
>
	<liferay-ui:search-container-results
		results = "<%=AuthorLocalServiceUtil.getItemByAuthorGroup(themeDisplay.getScopeGroupId(),
			authorId,searchContainer.getStart() ,
			searchContainer.getEnd(),WorkflowConstants.STATUS_APPROVED,searchContainer.getOrderByComparator())
			%>"
	
	/>

		<liferay-ui:search-container-row
				className="com.idetronic.subur.model.SuburItem"
				keyProperty="itemId"
				modelVar="item"
		>
			<%
			PortletURL viewItemURL = renderResponse.createRenderURL();
			viewItemURL.setParameter("mvcPath","/html/renderer/item_full.jsp");
			viewItemURL.setParameter("itemId",String.valueOf(item.getItemId()));
			
			%>
			<liferay-ui:search-container-column-text name="title">
				<a href="<%=viewItemURL.toString() %>">
					<%= item.getTitle() %>"
				</a>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
					name="item-type">
					<subur:item-itemtype-display 
						itemId="<%= Long.valueOf(item.getItemId()) %>"
					/>
						
			</liferay-ui:search-container-column-text>
			<%
					PortletURL viewAuthorURL = renderResponse.createRenderURL();
					viewAuthorURL.setParameter("mvcPath", "/html/author/view_author.jsp");
				%>	
			<liferay-ui:search-container-column-text
				name="author">
				<subur:item-author-display
					itemId="<%= Long.valueOf(item.getItemId()) %>" 
					viewAuthorURL ="<%=viewAuthorURL %>"	
				/>
				
			</liferay-ui:search-container-column-text>
			
			<%
			String yearPublished= StringPool.BLANK;	
			if (Validator.isNotNull(item.getPublishedDate()))
				{
					yearPublished = yearFormatDate.format(item.getPublishedDate());
				}
			%>
			
			<liferay-ui:search-container-column-text
					name="published"
					value="<%= yearPublished %>"	
			/>
			<%
				AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(SuburItem.class.getName(), item.getItemId());
			%>
			<liferay-ui:search-container-column-text
					name="views"
					value="<%= String.valueOf(entry.getViewCount()) %>"	
			/>
					
			
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>	