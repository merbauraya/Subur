<%@ include file="/html/init.jsp" %>


<%
	//orcid researcher search
	//pub.orcid.org/search/orcid-bio/?q=family-name:Smith
	SuburItem suburItem = (SuburItem)request.getAttribute("suburItem");
	String license = SuburConfiguration.getConfig(SuburConfiguration.PUBLICATION_LICENSE);

%>

<c:choose>
	<c:when test="<%= Validator.isNull(license) %>">
		<div class="alert">
			<liferay-ui:message key="please-upload-license-file"></liferay-ui:message>
		</div>
	
	</c:when>
	<c:otherwise>
	<div>
		<%= license %>
	
	</div>
	
	</c:otherwise>

</c:choose>
	