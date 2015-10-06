<%@include file="/html/suburstatistic/init.jsp"%>

<%
	PortletURL updStatURL = renderResponse.createActionURL();
	String statDisplay = StringPool.BLANK;
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY_ITEMTYPE))
		statDisplay = "renderMonthlyItemType('2015')";
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY_TAG))
		statDisplay = "renderMonthlyTag('2015')";
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY))
		statDisplay="renderMonthlySummary('2015')";
	if (displayType.equals(SuburStatUtil.VIEW_MONTHLY_SUMMARY_CATEGORY))
		statDisplay="renderMonthlyCategoryChart('2015','20817')";
	
	ResourceURL ref = renderResponse.createResourceURL();
%>
	
	
	
	<div class="row-fluid">
		
			<div id="<portlet:namespace />myDataTable">
		
			<div id="<portlet:namespace />chartArea" style="width:100%; height:400px;">
	
	
	</div>
	
	
	
	
<aui:script use="aui-base,aui-datatable,datatable-sort,aui-datatype,datasource-local,datasource-jsonschema,dataschema-json,datatable-datasource">
	var A = AUI();
	
	<%=statDisplay%>
	/*
	renderMonthlySummary();
	renderMonthlyTag(2015);
	renderMonthlyItemType(2015);
	*/
	
	function renderMonthlySummary(statYear)
	{
			var columns = [{key:'monthName',label:'Month'},{key:'totalview',label:'View',sortable:true}];
		Liferay.Service(
			  '/Subur-portlet.viewsummary/get-monthly-summary',
			  {
			    year: statYear
			  },
			  function(obj) {
			    
				var chartData = new Array(); 
				var xCategories = new Array();
			    //renderStat(columns,obj,statYear + " monthly View Summary");
				  for (i = 0; i < obj.length; i++){
					  chartData.push(parseInt(obj[i].totalview));
			            xCategories.push(obj[i].monthName);
			        }
			    
				  renderChart(chartData,xCategories,statYear + " Monthly view");
			  }
			);
	}
	function renderMonthlyCategory(statYear,vocabularyId)
	{
		
		Liferay.Service(
				'/Subur-portlet.viewsummary/get-monthly-category',
			  {
			    year: statYear,
			    vocabularyId : vocabularyId 
			  },
			  function(obj) 
			  {
				  var column = [];
				  var columns = {};
				  var key = "categoryname";
				  var label = "Category";
				  var monthName = new Array();
				  column.push({"key": key,"label":label });
				  for (i = 0; i < obj.length; i++)
						
				   {
					  var d = obj[i];
					 // console.log(d);
					  for(var key in d)
					  {
				            var attrName = key;
				            var attrValue = d[key];
				      		if (attrName != "categoryname" && (monthName.indexOf(attrName) < 0))
				            {
				            	monthName.push(attrName);
					            column.push({
					            	"key":attrName,
					            	"label" : attrName
					            	
					            });
					            
				            }		
				            
				        }
					  
					  
				   }
			    
			    renderStat(column,obj, statYear + " monthly by Category");
			  }
			);
	}
	function renderMonthlyItemType(statYear)
	{
	
				               
		Liferay.Service(
				'/Subur-portlet.viewsummary/get-monthly-item-type',
				  {
				    year: statYear
				  },
				  function(obj) 
				  {
					  var column = [];
					  var columns = {};
					  var key = "itemtypename";
					  var label = "Item Type";
					  var monthName = new Array();
					  column.push({"key": key,"label":label });
					  
					  
					  for (i = 0; i < obj.length; i++)
							
					   {
						  var d = obj[i];
						 // console.log(d);
						  for(var key in d)
						  {
					            var attrName = key;
					            var attrValue = d[key];
					      		if (attrName != "itemtypename" && (monthName.indexOf(attrName) < 0))
					            {
					            	monthName.push(attrName);
						            column.push({
						            	"key":attrName,
						            	"label" : attrName
						            	
						            });
						            
					            }		
					            
					        }
						  
						  
					   }
					  renderStat(column,obj,statYear + " monthly by Item Type");
				  }
				);
		
	
	}
	function renderMonthlyTag(statYear)
	{
		
		
		
		
		Liferay.Service(
				  '/Subur-portlet.viewsummary/get-monthly-tag-summary',
				  {
				    year: statYear
				  },
				  function(obj) 
				  {
					  
					  var schema = obj.schema;
					  var data = obj.data;
					  var columns = obj.column;
					  var caption="yes";
					  var title = obj.title;
					  
					  var tableData = [];
					  //datatable
					   A.Object.each(obj.data, function(seriesObj,i){
						   
						   var serieData = [];
						   //seriesObj[0] = series name
						   serieData.push(seriesObj[0]);
						   A.Object.each(seriesObj[1], function(serie,j){
							   
							   
							   serieData.push(serie);
							  
							   //console.log(serie);
							   
							   
						   })
						   
						   tableData.push(serieData);
						   
					   });
					  
					  //console.log(tableData);
					  //chart related
					  var seriesOptions = [];
					  var chartCategories = obj.category;
					  var yAxisTitle = obj.yAxisTitle;
					  var chartTitle = obj.title;
					  
					  
					  var serieName = obj.serieName;
					  
					 // var responseData = A.DataSchema.JSON.apply(schema,data);
					  //var resultData = responseData.results;
					  //console.log(resultData);
					  
					  A.Object.each(obj.data, function(seriesObj,i){
						 // console.log(seriesObj);
						seriesOptions[i] = {
									name: seriesObj[0],
									data: seriesObj[1]
								};
						  
					  });
					  
					  console.log(seriesOptions);
					  //renderDataTable(tableData,schema,columns,title)
					  renderChart2(chartCategories,title,seriesOptions,yAxisTitle);

					  //renderDataTable(data,schema,columns,caption)
				  }
				);
		
	
	}
	function renderMonthlyCategoryChart(statYear,vocabularyId)
	{
		
		Liferay.Service(
				'/Subur-portlet.viewsummary/get-monthly-asset-category-chart',
				{
					year: statYear,
					vocabularyId : vocabularyId
				},
			  
			  function(obj) 
			  {
					 var seriesOptions = [];
					  var chartCategories = obj.category;
					  var yAxisTitle = obj.yAxisTitle;
					  var chartTitle = obj.title;
					  
					  
					  var serieName = obj.serieName;
					  
					 // var responseData = A.DataSchema.JSON.apply(schema,data);
					  //var resultData = responseData.results;
					  //console.log(resultData);
					  
					  A.Object.each(obj.data, function(seriesObj,i){
						 // console.log(seriesObj);
						seriesOptions[i] = {
									name: seriesObj[0],
									data: seriesObj[1]
								};
						  
					  });
				  
					
					
					
					/*
				var column = [];
				  var columns = {};
				  var seriesArr = [];
				  console.log(obj);
				  var chartTitle = obj.title;
				  var chartCategories = obj.period;
				  var yAxisTitle = obj.yAxisTitle;
				  var seriesOptions = [];
				  var chartData = new Array(); 
				  //console.log(chartTitle + "::"+ chartCategories);
				  
				  
				 
				  A.Object.each(obj.series, function(seriesObj,i){
					seriesOptions[i] = {
								name: seriesObj.name,
								data: seriesObj.data
							};
					  
				  });
				  */
		
				  
				   
				   renderChart2(chartCategories,chartTitle,seriesOptions,yAxisTitle);
				 
			  }
			);
	}
	function renderDataTable(data,schema,columns,caption)
	{
		//console.log(data);
		var responseData = A.DataSchema.JSON.apply(schema,data);
		
		//console.log(responseData);
		
		
		var dataTable = new A.DataTable(
			{
				columnset: columns,
				recordset: responseData.results,
				caption: caption,
				sortable: true
				
			}		
		).render('#<portlet:namespace />myDataTable');
		/*
		
		var dataTable = new A.DataTable(
				{
					columnset : columns,
				});
		dataTable.plug(A.Plugin.DataTableDataSource, { datasource: mydata });
		dataTable.render('#<portlet:namespace />myDataTable');
		
		dataTable.datasource.load();
		*/
		//dataTable.get('boundingBox').unselectable();
	}
	function renderStat(columns,data,caption)
	{
		console.log(data);
		var xData = [
		  {	"tagName":"Tag Name1","Jan":10,"Feb":100,"Mac":"20"},
		  {	"tagName":"Tag Name2","Jan":10,"Feb":70,"Mac":"20"},
		  {	"tagName":"Tag Name3","Jan":23,"Feb":100,"Mac":"80"},
		];
		
		
		var xData = [
		   		  {	"tagName":"Tag Name1"},[10,100,20],
		   		  {	"tagName":"Tag Name2"},[10,70,20],
		   		  {	"tagName":"Tag Name3"},[23,100,80],
		   		];
		var xData = [
			   		  [	"Tag Name1",10,100,20],
			   		  [	"Tag Name2",10,70,20],
			   		  ["Tag Name3",23,100,80],
			   		];
		//console.log(xData);
		
		var mydata = new A.DataSource.Local(xData);
		//console.log(mydata);
		mydata.responseSchema = {
			fields:["tagname","January","February","Mac","April","Mei","June","July","August","September"]	
		};
		
		
		mydata.responseSchema = {
				fields:["tagname","Jan","Feb","Mac"]	
			};
		
		var schema = {
				resultFields:["tagName","Jan","Feb","Mac"]	
		};
		
		var response = A.DataSchema.JSON.apply(schema,xData);
		
		//console.log(response);
		var xData = [
		   		  {	month:"Jan","tagName":"Tag Name1",viewCount : 10},
		   			{month:"Feb","tagName":"Tag Name1",viewCount : 20},
		   			{month:"Mac","tagName":"Tag Name1",viewCount : 20}
		   		];
		
		
		
		
		var column = [
		              {key : "tagName",sortable:true},
		              {key: "tagName"}
		              
		              
		              ];
		
		var columns = [{key: "tagName"},"Jan","Feb","Mac"];
		//console.log(columns);
		
		var dataTable = new A.DataTable(
			{
				columnset: columns,
				recordset: response.results,
				caption: caption,
				sortable: true
				
			}		
		).render('#<portlet:namespace />myDataTable');
		/*
		
		var dataTable = new A.DataTable(
				{
					columnset : columns,
				});
		dataTable.plug(A.Plugin.DataTableDataSource, { datasource: mydata });
		dataTable.render('#<portlet:namespace />myDataTable');
		
		dataTable.datasource.load();
		*/
		//dataTable.get('boundingBox').unselectable();
	}
	function renderChart3()
	{
		var      chart1 = new Highcharts.Chart({
	         chart: {
	            renderTo: '<portlet:namespace />chartArea',
	            //type : 'column',
	            defaultSeriesType: 'line',
	            zoomType: null
	            
	         },
	         title: {
	                text: 'Monthly Average Rainfall'
	            },
	            subtitle: {
	                text: 'Source: WorldClimate.com'
	            },
	            xAxis: {
	                categories: [
	                    'Jan',
	                    'Feb',
	                    'Mar',
	                    'Apr',
	                    'May',
	                    'Jun',
	                    'Jul',
	                    'Aug',
	                    'Sep',
	                    'Oct',
	                    'Nov',
	                    'Dec'
	                ]
	            },
	            yAxis: {
	                min: 0,
	                title: {
	                    text: 'Rainfall (mm)'
	                }
	            },
	            tooltip: {
	                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
	                footerFormat: '</table>',
	                shared: true,
	                useHTML: true
	            },
	            plotOptions: {
	                column: {
	                    pointPadding: 0.2,
	                    borderWidth: 0
	                }
	            },
	            series: [{
	                name: 'Tokyo',
	                data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
	    
	            }, {
	                name: 'New York',
	                data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
	    
	            }, {
	                name: 'London',
	                data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]
	    
	            }, {
	                name: 'Berlin',
	                data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]
	            }]
	      });
	}
	function renderChart2(chartCategories,chartTitle,seriesOption,yAxisTitle)
	{
		console.log(seriesOption[0].name);
		console.log(seriesOption[0].data);
		var      chart1 = new Highcharts.Chart({
		         chart: {
		            renderTo: '<portlet:namespace />chartArea',
		           // type : 'column',
		            defaultSeriesType: 'line',
		            zoomType: null
		            
		         },
		         title: {
		                text: chartTitle
		            },
		            subtitle: {
		                text: 'Source: subtitle'
		            },
		            xAxis: {
		                categories: chartCategories
		            },
		            yAxis: {
		            	allowDecimals: false,
		                min: 0,
		                title: {
		                    text: yAxisTitle
		                }
		            },
		            tooltip: {
		                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                    '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
		                footerFormat: '</table>',
		                shared: true,
		                useHTML: true
		            },
		            plotOptions: {
		                column: {
		                    pointPadding: 0.2,
		                    borderWidth: 0
		                }
		            },
		            credits: {
			            enabled: false
			        },
		            series: seriesOption
		      });
		   
	}
	function renderChart(chartData,chartCategories,chartTtitle)
	{
		
	
		var      chart1 = new Highcharts.Chart({
		         chart: {
		            renderTo: '<portlet:namespace />chartArea',
		            type : 'column',
		            zoomType: null
		            
		         },
		         title: {
		        	 text : chartTtitle
		         },
		         navigator : {
						enabled : false
				},
				scrollbar : {
		                enabled : false
		        },
		        credits: {
		            enabled: false
		        },
		         
		         xAxis: {
                  
                     categories: chartCategories,                 
              
                 },
                 yAxis: {
                     title: {
                         text: "Views"
                     },
                     min:0,
                 },
                 rangeSelector : {
     				enabled: false
     			},
		        
		         series: [{
		            name: 'Monthly View', 
		            
		            data: chartData // predefined JavaScript array
		         }]
		      });
		   
	}
	function testX()
	{
		var data = {
				   "Category 1": [
				        	
				            {
				               "Jan":10,
				               "Feb": 15,
				               "Mac": 13
				            }],
				      	
				   "Category 2" :[        
				            {
				               "Jan":14,
				               "Feb": 9,
				               "Mac": 20
				               
				            }
				         ]
				      }
		
		//console.log(data);
		
		 var seriesArr = [];
		
	
		//console.log(seriesArr);
		
	
	}
</aui:script>