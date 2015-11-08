<%@include file="/html/subur/init.jsp"%>

<%
	SuburItem suburItem = (SuburItem)request.getAttribute(WebKeys.SUBUR_ITEM);
	long itemId = ParamUtil.getLong(request, "itemId");
	if (Validator.isNull(suburItem))
	{
		suburItem = SuburItemLocalServiceUtil.getSuburItem(itemId);
	}

	suburItem = suburItem.toEscapedModel();
	int abstractLength = (Integer)request.getAttribute("ASSET_PUBLISHER_ABSTRACT_LENGTH");

%>
<dl>
	<dt>Date Deposited</dt>
	<dd><%= suburItem.getCreateDate() %></dd>
	
	
	
	
	<%
		long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(suburItem.getItemId());
		List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
		String summary = HtmlUtil.escape(suburItem.getItemAbstract());
	%>
		<%= StringUtil.shorten(summary, abstractLength) %>
	<dt>Author</dt>
	<%
		
		for (Author author: authors)
		{
			author = author.toEscapedModel();	
		
	%>
	<dd>
			<%=author.getDisplayName() %>
	
	</dd>
	<%} %>
	

</dl>