<%@ include file="/html/init.jsp" %>


<%
	//orcid researcher search
	//pub.orcid.org/search/orcid-bio/?q=family-name:Smith
	SuburItem suburItem = (SuburItem)request.getAttribute("suburItem");
	/*
	List<MetadataPropertyValue> authors = Collections.emptyList();
	int[] authorsIndexes = null;
	
	if (Validator.isNotNull(suburItem))
	{
		authors = MetadataPropertyValueLocalServiceUtil.getAuthor(suburItem.getItemId());
		authorsIndexes = new int[authors.size()];
		for (int i = 0;i < authors.size(); i++){
			authorsIndexes[i] = i;
		}
		
	}
	
	if (Validator.isNull(suburItem) || authors.isEmpty())
	{
		authors = new ArrayList<MetadataPropertyValue>();
		authors.add(new MetadataPropertyValueImpl());
		authorsIndexes =  new int[] {0};
	}
	*/
%>
<h3><liferay-ui:message key="edit-authors" /></h3>
<portlet:resourceURL var="getAuthors" id="<%=SuburConstant.RESOURCE_AUTHOR_LOOKUP %>">
   <portlet:param name="<%=Constants.CMD%>" value="get_users" />
 </portlet:resourceURL>

<aui:row> 
	<aui:col width="40">
			<aui:input id="firstName" name="firstName"  helpMessage="Type Researcher name"/>
		
	</aui:col>
	<aui:col width="40">
		<aui:input name="lastName"/>
	</aui:col>
	<aui:col width="20">
		<div class="control-group">
			<label class="control-label">Add</label>
			<aui:button name="addAuthorBtn" cssClass="icon-plus" />
		</div>
	</aui:col>
</aui:row>

<aui:input name="authorIndex" type="hidden"  />


<%
	//String indexes = StringUtil.merge(authorsIndexes);
	String authorsIndexes = "0";
%>


<%
	long[] authorIds = ItemAuthorLocalServiceUtil.getAuthorId(suburItem.getItemId());
	List<Author> authors = AuthorLocalServiceUtil.getAuthors(authorIds);
	

%>
<liferay-util:buffer var="removeAuthorIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>

<liferay-ui:search-container
	curParam="authorsCur"
	headerNames="First Name,Last Name,null"
	id="authorsSearchContainer"
	iteratorURL="<%= currentURLObj %>"
	total="<%= authors.size() %>"
>
	<liferay-ui:search-container-results
		results="<%= authors.subList(searchContainer.getStart(), searchContainer.getResultEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.idetronic.subur.model.Author"
		keyProperty="authorId"
		modelVar="author"
	>
		
		<liferay-ui:search-container-column-text
			name="First Name"
			value="<%= HtmlUtil.escape(author.getFirstName()) %>"
		/>
		<liferay-ui:search-container-column-text
			name="Last Name"
			value="<%= HtmlUtil.escape(author.getLastName()) %>"
		/>
		<liferay-ui:search-container-column-text>
				<a class="modify-link" data-rowId="<%= author.getAuthorId() %>" href="javascript:;"><%= removeAuthorIcon %></a>
		</liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<liferay-ui:icon cssClass="edit-author" iconCssClass="icon-edit"
	label="<%=true%>"
	linkCssClass="<%=renderResponse.getNamespace() +\"btnAddExp btn\"%>"
	message="add" url="javascript:;" />


		
<aui:input name="authorsIndexes" id="authorsIndexes"
	type="hidden" 
	value="<%=authorsIndexes%>" />
	
<div id="authorEntry">

</div>





<portlet:resourceURL var="authorLookupURL" id="authorLookup">
</portlet:resourceURL>




<portlet:renderURL var="addAuthorURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="itemId" value="<%=String.valueOf(suburItem.getItemId()) %>"/>
	<portlet:param name="mvcPath" value="/html/deposit/authorlookup.jsp"/>
	<portlet:param name="event" value="addAuthor" />
</portlet:renderURL>


<portlet:actionURL name="addAuthor" var="addAuthorActionURL">
	
</portlet:actionURL>

<aui:script use="aui-base,aui-toggler,liferay-util-window,aui-datatable,datatable-formatters">
var totIndex = 0;
A.one('.<portlet:namespace />btnAddExp').on('click',function(event) {
		//event.preventDefault();
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width: 600
				},
				id: '<portlet:namespace />addAuthor',
				title: '<liferay-ui:message arguments="search-author" key="select-author" />',
				uri: '<%=addAuthorURL%>',
				eventName: '<portlet:namespace />addAuthor',
			},
			function (event)
			{
				
				<portlet:namespace />addAuthor(event.authorid,event.firstname,event.lastname,event.searchcontainername);
				
				
			}
			
			
		);
	}
);


Liferay.provide(
		window,
		'<portlet:namespace />addNewAuthor',
		function(authorJson){
			
			var authorAjaxReq = A.io.request('<%=addAuthorActionURL.toString()%>',{ 
                dataType: 'json', 
                method:'POST', 
                data:{<portlet:namespace />authorId: authorJson.authorId,
                	  <portlet:namespace />firstName: authorJson.firstName,
                	  <portlet:namespace />lastName: authorJson.lastName,
                	  <portlet:namespace />type: "author",
                	  <portlet:namespace />idType: "local",
                	  <portlet:namespace />itemId: '<%=suburItem.getItemId()%>'
                
                }, 
                autoLoad:false, 
                sync:false, 
                on: { success:function(){ 
                    var data=this.get('responseData'); 
                    authorData=data; 
                }} 
            }); 
            authorAjaxReq.start(); 
			
			
			
			
			
			
		}
			
		
		
		
);

</aui:script>
<aui:script use="aui-base,escape,liferay-search-container">
Liferay.provide(
		window,
		'<portlet:namespace />addAuthor',
		function(authorId, firstName, lastName,searchContainer) {
			var A = AUI();
			console.log(authorId);
			var searchContainerName = '<portlet:namespace />' + searchContainer + 'SearchContainer';
			
			searchContainer = Liferay.SearchContainer.get(searchContainerName);
			
			
			
			
			var data = searchContainer.getData(true);
			var existingAuthor = false;
			if (authorId > 0)
			{
				for (var i = 0; i < data.length; i++)
				{
					if (authorId == data[i])
						return;
				}
			}else //manually added
			{
				var tb =   A.one('#'+ searchContainerName).getElementsByTagName('table');
				//console.log(tb);
				var rows = A.all('#'+ searchContainerName + ' tbody tr');
				
				
				
				rows.each(function (row){
				
					var columns  = this.all('td');
					var fName,lName;
					
					columns.each(function(td, idx){
						if (idx == 0)
						{
							fName = td.html().trim();
						}
						else if (idx == 1)
						{
							lName = td.html().trim();
						}
						
					});
					
					if (fName.toUpperCase() == firstName.toUpperCase() && 
							lName.toUpperCase() == lastName.toUpperCase())
					{
						
						existingAuthor = true;
						return false;
					}
					
				});
				
				
				
			}
			
			if (existingAuthor)
			{
				return ;
			}
			var rowColumns = [];

			rowColumns.push(A.Escape.html(firstName));
			rowColumns.push(A.Escape.html(lastName));
			

			
			rowColumns.push('<a class="modify-link" data-rowId="' + authorId + '" href="javascript:;"><%= UnicodeFormatter.toString(removeAuthorIcon) %></a>');
			
			
			searchContainer.addRow(rowColumns, authorId);
			searchContainer.updateDataStore();
		}
		
	);

</aui:script>
<aui:script use="liferay-search-container">
	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />authorsSearchContainer');

	searchContainer.get('contentBox').delegate(
	'click',
	function(event) {
		var link = event.currentTarget;
		var tr = link.ancestor('tr');
		
		searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		//remove manual entry as well
		var id = link.getAttribute('data-rowId');
		id  = id * -1;
		<portlet:namespace />removeAuthor(id);
		
		
	},
	'.modify-link'
);
</aui:script>
<aui:script>
	AUI().use('autocomplete-list','datasource-io','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
		var authorDS =  new A.DataSource.IO({
			source: '<%=getAuthors%>'
		});
		
		
		var autoComplete = new A.AutoCompleteList({
			allowBrowserAutocomplete: false,
			activateFirstItem: false,
			inputNode: '#<portlet:namespace />firstName',
			maxResults: 20,
			after : {
				select: function(event) {
					var result = event.result.raw;
					
					A.one('#<portlet:namespace/>lastName').val('');
					A.one('#<portlet:namespace/>firstName').val('');
					<portlet:namespace />addAuthor(result.id,result.firstName,result.lastName,'authors');
				}
			},
			
			render: true,
			source: authorDS,
			resultHighlighter: 'wordMatch',
			requestTemplate: '&<portlet:namespace />keywords={query}',
			resultListLocator: function (response) {
				
				var responseData = A.JSON.parse(response[0].responseText);
				return responseData;
			},
			resultTextLocator: 'displayName',
			width:400,
			
		})
	});
		
</aui:script>
<aui:script>
	AUI().use('aui-base', function(A){
		A.one("#<portlet:namespace/>addAuthorBtn").on('click',function(){
			var fName = A.one('#<portlet:namespace/>firstName').val();
			var lName = A.one('#<portlet:namespace/>lastName').val();
			
			if (fName.trim() && lName.trim())
			{
				addAuthor(fName,lName);
				A.one('#<portlet:namespace/>firstName').val('');
				A.one('#<portlet:namespace/>lastName').val('');
			}else
			{
				
				
				return;
			}
	
		});
	
		
		function addAuthor(firstName,lastName)
		{
			var box = A.one('#authorEntry');
			var idx = A.one('#<portlet:namespace />authorsIndexes').val();
			
			idx++;
			var fName = '<portlet:namespace />authorNameF' + idx;
			
			var fNameNode = '<input id="' + fName +'" type="hidden" name="'+ fName + '" value="'+ firstName + '"/>';
			
			var lName = '<portlet:namespace />authorNameL' + idx;
			var lNameNode = '<input id="' + lName +'" type="hidden" name="'+ lName + '" value="'+ lastName + '"/>';
			
			
			box.appendChild(fNameNode);
			box.appendChild(lNameNode);
			
			var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />authorsSearchContainer');
	
			<portlet:namespace />addAuthor(idx * -1,firstName,lastName,'authors');
			A.one('#<portlet:namespace />authorsIndexes').val(idx);
			
			
		}
		
		Liferay.provide(
				window,
				'<portlet:namespace />removeAuthor',
				function(id) {
					var authorEntries = A.one('#authorEntry');
					var fName = A.one('#<portlet:namespace />authorNameF' + id);
					var lName = A.one('#<portlet:namespace />authorNameL' +id);
					authorEntries.removeChild(fName);
					authorEntries.removeChild(lName);
					
				});
	});
</aui:script>