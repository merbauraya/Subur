<%@ include file="/html/init.jsp" %>
<%@page import="javax.portlet.ResourceResponse"%>


<portlet:resourceURL var="subjectListURL">
	<portlet:param name="resource" value="depositableSubject" />
</portlet:resourceURL>
<%
	SuburItem item = (SuburItem)request.getAttribute("suburItem");
	//List<ItemSubject> itemSubjects = ItemSubjectLocalServiceUtil.getByItemId(item.getItemId());
	//List<ItemDivision> itemDivisions = ItemDivisionLocalServiceUtil.getByItemId(item.getItemId());
	
	//List<Division> divisions = DivisionLocalServiceUtil.getDepositable();
	//long divisionId = 0;
	//for (ItemDivision itemDivision: itemDivisions)
	//	divisionId = itemDivision.getDivisionId();

	List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
	List<AssetCategory> categories = new ArrayList<AssetCategory>();
	List<AssetCategory> subCategories;
	long catId = 0L;
	String subCatIdsList ="";
	

%>

<liferay-ui:asset-categories-error />
<liferay-ui:asset-tags-error />
<aui:fieldset>
	
	<aui:input 
		classPK="<%=item.getItemId() %>" 
		model="<%= SuburItem.class %>" 
		name="categories" 
		type="assetCategories" />	
	
	
	<aui:input classPK="<%=item.getItemId() %>" 
		model="<%= SuburItem.class %>" 
		name="tags" 
		type="assetTags" />
	
</aui:fieldset>				
<input type="hidden" name="categoryIds" id="<portlet:namespace/>categoryIds" value=""/>			
<input type="hidden" name="tagNames" id="<portlet:namespace/>tagNames" value=""/>		




