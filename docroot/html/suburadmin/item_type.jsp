<%@ include file="/html/init.jsp" %>

<%
	String pageName="itemType";
%>

<%@ include file="/html/suburadmin/nav.jsp" %>

<%
	List<ItemType> itemTypes = ItemTypeLocalServiceUtil.getItemTypes(-1, -1);
	


%>

<liferay-ui:search-container  
	emptyResultsMessage="no-item-type-were-found"
	deltaConfigurable="false">
        <liferay-ui:search-container-results
                results="<%= itemTypes %>"
                total="<%= itemTypes.size() %>"
        />

        <liferay-ui:search-container-row
                className="com.idetronic.subur.model.ItemType"
                keyProperty="itemTypeId" modelVar="itemType" escapedModel="<%=true%>">
                
				
				
				<liferay-ui:search-container-column-text
				name="name"
				value="<%= itemType.getItemTypeName() %>"
				orderable="<%= true %>"
				orderableProperty="itemCount"
		/>
		
		
               
                <liferay-ui:search-container-column-text
				name="item-count"
				value="<%= String.valueOf(itemType.getItemCount()) %>"
				orderable="<%= false %>"
				orderableProperty="lastPublishedDate"
		/>
        <liferay-portlet:renderURL varImpl="editItemTypeURL">
				<portlet:param name="jspPage" value="/html/suburadmin/edit_itemtype.jsp" />
				<portlet:param name="redirect" value="<%=currentURL %>" />
				<portlet:param name="itemTypeId" value="<%= String.valueOf(itemType.getItemTypeId()) %>" />
				
		</liferay-portlet:renderURL>
       
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="edit" message="Edit" label="edit" url="<%= editItemTypeURL.toString() %>" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>        

               
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>

<portlet:renderURL var="newItemTypeURL">
	<portlet:param name="jspPage" value="/html/suburadmin/edit_itemtype.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="backURL" value="<%= currentURL %>" />
				 
</portlet:renderURL>

<aui:script use="aui-toggler,liferay-util-window">
var A = AUI();
A.one('#<portlet:namespace/>addItemTypeButton').on('click', function(event) {
     Liferay.Util.selectEntity({ 
     dialog: { 
             centered: true, 
             height: 450, 
             modal: true, 
             width: 450 
             }, 
     id: '<portlet:namespace/>editItemType', 
     title: 'Sample Dailog', 
     uri: '<%=newItemTypeURL %>' 
     });
},
	function(event)
	{
		
	
	
	}

);

Liferay.provide(
        window,
        'closePopup',
        function(popupIdToClose) {
            var dialog = Liferay.Util.getWindow(popupIdToClose);
            dialog.destroy(); 
        },
        ['aui-base','aui-dialog','aui-dialog-iframe']
    );
</aui:script>

<aui:script>
Liferay.provide(
        window,
 '<portlet:namespace/>closePopup',
 function(data, dialogId) {
               var A = AUI();
               // Closing the dialog
                var dialog = Liferay.Util.Window.getById(dialogId);
                dialog.destroy(); 
        },
        ['liferay-util-window']
);
</aui:script>