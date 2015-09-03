
<div class="author-detail">
	<div class="author-info">
		
	</div>
	
	
	<div class="author-summary">
		<h2><%= author.getDisplayName()%></h2>
		<c:if test="<%=canUpdate %>">
			<portlet:renderURL var="editAuthorURL">
					<portlet:param name="jspPage" value="/html/admin/author/edit_author.jsp" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="backURL" value="<%= currentURL %>" />
					<portlet:param name="authorId" value="<%= String.valueOf(author.getAuthorId()) %>"/>
					 
				</portlet:renderURL>
				<liferay-ui:icon
							image="edit"
							label="<%= true %>"
							url="<%= editAuthorURL %>"
						/>
		</c:if>
		
		<div class="author-bio">
			<div class="author-title">
				<p><span class="title">Title : </span>
				<%=author.getTitle() %>
				</p>
			</div>
			<div class="author-contrib">
				<p><span class="title">Published Item : </span>
				<%=author.getItemCount() %>
				</p>
			
			</div>
			
		</div>
	</div>
	
<%
	
String tabs2Names = "biodata,publication,categorization";
%>

</div>
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
	
	