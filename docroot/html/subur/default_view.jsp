<%
	int maxItem = 5;
	assetEntryQuery.setStart(0);
	assetEntryQuery.setEnd(maxItem);
	List<AssetEntry> assetEntries = SuburItemLocalServiceUtil.getAssetEntries(assetEntryQuery,anyItemTypeIds,allItemTypeIds);
	request.setAttribute("view.jsp-results", assetEntries);
	request.setAttribute("show-title-only",true);
%>

<aui:row>
	<div class="span6">
		<h4>Latest publication</h4>
	<%
	
	for (int assetEntryIndex = 0; assetEntryIndex < assetEntries.size(); assetEntryIndex++) {
		AssetEntry assetEntry = assetEntries.get(assetEntryIndex);
		AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(assetEntry.getClassName());
		AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(assetEntry.getClassPK());
		String title = assetRenderer.getTitle(locale);
		String suburItemId = String.valueOf(assetEntry.getClassPK());
		boolean show = true;
		boolean print = false;

		request.setAttribute("view.jsp-assetEntryIndex", new Integer(assetEntryIndex));

		request.setAttribute("view.jsp-assetEntry", assetEntry);
		request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
		request.setAttribute("view.jsp-assetRenderer", assetRenderer);

		request.setAttribute("view.jsp-title", title);

		request.setAttribute("view.jsp-show", new Boolean(show));
		request.setAttribute("view.jsp-print", new Boolean(print));
		request.setAttribute("view.jsp-itemId", suburItemId);

		try {
	%>
		<liferay-util:include 
		page="/html/renderer/display_table.jsp" 
		useCustomPage="<%=true %>"
		servletContext="<%=application %>"
	/>
		
		

	<%
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		
	}
	
	%>
	
	
	
	</div>
	
	<div class="span6">
		
	</div>

</aui:row>