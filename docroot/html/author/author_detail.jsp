<%
	String taglibAlt = (author != null) ? HtmlUtil.escapeAttribute(author.getDisplayName()) : LanguageUtil.get(pageContext, "generic-portrait");
	String taglibSrc = null;
	if (author != null) {
		taglibSrc = author.getPortraitURL(themeDisplay);
	}
	else {
		taglibSrc = SuburUtil.getDefaultPortraitURL(themeDisplay.getPathImage());
	}
%>
<aui:row>
	<div class="profile-image pull-left">
		<span class="user-profile-image">
			<img alt="<%= taglibAlt %>" class="avatar" src="<%= HtmlUtil.escape(taglibSrc) %>" />
		</span>
	
	</div>
		
	
		
		<div class="author-summary">
			<h3><%= author.getDisplayName()%></h3>
			<c:if test="<%=canUpdate %>">
				<liferay-portlet:renderURL var="editAuthorURL" portletName="Author_WAR_Suburportlet">
						<portlet:param name="mvcPath" value="/html/admin/author/edit_author.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="backURL" value="<%= currentURL %>" />
						<portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>"/>
						 
					</liferay-portlet:renderURL>
					<liferay-ui:icon
								image="edit"
								label="<%= true %>"
								url="<%= editAuthorURL %>"
							/>
			</c:if>
			
			<div class="author-bio">
				<div class="author-title">
					<p><span class="author-title">Salutation : </span>
					<%=author.getSalutation() %>
					</p>
				</div>
				<%=author.getTitle() %>
				<div class="author-contrib">
					<p><span class="author-title">Published Item : </span>
					<%=author.getItemCount() %>
					</p>
				
				</div>
				
			</div>
		</div>
	
	
	
	
</aui:row>

<%
	
String tabs2Names = "biodata,publication,categorization";
%>
<aui:row>
<liferay-ui:tabs
	names="<%= tabs2Names %>"
	refresh="<%= false %>"
	>
	<liferay-ui:section>
		<%@ include file="/html/author/biodata.jsp" %>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<%@ include file="/html/author/publication.jsp" %>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<%@ include file="/html/author/categorization.jsp" %>
	</liferay-ui:section>
	

</liferay-ui:tabs>	
</aui:row>	
	