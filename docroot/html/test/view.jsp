<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<portlet:renderURL var="simpleDialogIframeExample"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath"
		value="/html/subur/advance_search.jsp" />
</portlet:renderURL>

<div class="separator"></div>
<div>
	<h1>Iframe AUI Dialog Please click on button and see</h1>
	<br />
	<aui:button name="openDialog" type="button" value="open-dialog" />
	
	<aui:button onClick="popup('<%= simpleDialogIframeExample%>')" value="popup"/>
</div>


    
<aui:script use="aui-toggler,liferay-util-window">
A.one('#<portlet:namespace/>openDialog').on('click', function(event) {
	Liferay.Util.selectEntity(
	{
		dialog: {
			centered: true,
			height: 300,
			modal: true,
			width: 400
		},
		id: '<portlet:namespace/>dialog',
		title: '<liferay-ui:message key="i-am-the-dialog" />',
		eventName: '<portlet:namespace />doSearch',
		uri: '<%=simpleDialogIframeExample %>'
	},
	function (event)
	{
		
		<portlet:namespace />doSearch(data);
		
		
	}
	
	
	);
});

Liferay.provide(
		window,
		'<portlet:namespace/>closePopup',
		function(dialogId,fm) {
			var A = AUI();
			console.log(fm);
			fm.submit();
			// Here you can use "data" parameter
			
			// Closing the dialog
			var dialog = Liferay.Util.Window.getById(dialogId);
			dialog.destroy();
			
		},
		['liferay-util-window']
	);
</aui:script>
<aui:script use="aui-base,escape,liferay-search-container">
Liferay.provide(
		window,
		'<portlet:namespace />doSearch',
		function(data) {
			var A = AUI();
			
			console.log(data);
		}
		
	);

</aui:script>

