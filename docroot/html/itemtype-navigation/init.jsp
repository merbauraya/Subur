<%@include file="/html/subur/init.jsp" %>


<%
	boolean showInternalLabel = GetterUtil.getBoolean(portletPreferences.getValue("showInternalLabel", Boolean.FALSE.toString()));
	String internalLabel = portletPreferences.getValue("internalLabel", StringPool.BLANK);

%>