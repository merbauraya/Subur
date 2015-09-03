<div class="author-categorization">

<liferay-ui:asset-categories-summary
	className="<%= Author.class.getName() %>"
	classPK="<%= author.getAuthorId () %>"
	portletURL='<%= renderResponse.createRenderURL() %>'
/>

</div>