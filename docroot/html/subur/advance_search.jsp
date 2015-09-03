<%@ include file="/html/init.jsp" %>

advance search
<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/search/subur_search.jsp" />
</liferay-portlet:renderURL>
<aui:form action="<%=searchURL %>" name="fm" method="post">
	<aui:input name="keyword"/>
	
	
	<aui:button name="closeDialog"  value="next" last="true" />
</aui:form>


<aui:script use="aui-base,aui-io">
A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
	// Let's suppose that "data" contains the processing results
	
	// Invoke a function with processgin results and dialog id
	//console.log(document.<portlet:namespace />fm);
	var fm = document.<portlet:namespace />fm;
	console.log(fm);
	
	//submitForm(<portlet:namespace/>fm);//.submit();
	
	A.io.request("<%=searchURL%>",
	{
		method: 'POST',
		form: {id : '<portlet:namespace />fm'},
		on: {
			success: function()
			{
				console.log('success');
			}
		}
	});
	
	
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog',fm);
	
});

</aui:script>

<aui:script use="aui-io-request,aui-node" >
Liferay.provide(window,'submitForm',
 function() {
  var A = AUI();
  A.io.request('${formsubmissionURL}',{
  method: 'POST',
  form: { id: '<portlet:namespace />fm' },
  on: {
  success: function(){
  
   
       }
     }
    });
  });

</aui:script >