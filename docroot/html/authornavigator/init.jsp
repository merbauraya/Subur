<%@ include file="/html/init.jsp" %>


<%
	
	
	String  displayStyle = portletPreferences.getValue("displayStyle", "researcher-name");
	int  maxResearcher = GetterUtil.getInteger(portletPreferences.getValue("max", "5"));
	//long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null), themeDisplay.getScopeGroupId());

%>
