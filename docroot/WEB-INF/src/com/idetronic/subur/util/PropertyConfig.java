package com.idetronic.subur.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import com.idetronic.subur.portlet.Subur;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class PropertyConfig {
	
	
	
	
	public static String setProperties(Map<String,String> propsMap)
	{
		Properties props = new Properties();
		for (Map.Entry<String, String> entry : propsMap.entrySet())
		{
			props.put(entry.getKey(), entry.getValue());
		}
		
		return props.toString();
	}
	public static String setPropertiesAsString(Map<String,String> propsMap) throws IOException
	{
		Properties props = new Properties();
		for (Map.Entry<String, String> entry : propsMap.entrySet())
		{
			props.put(entry.getKey(), entry.getValue());
		}
		StringWriter writer = new StringWriter();
		props.store(writer, StringPool.BLANK);
		
		return writer.getBuffer().toString();
	}
	
	public static Properties getProperties(String value) throws IOException
	{
		Properties props = new Properties();
		props.load(new StringReader(value));
		return props;
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(PropertyConfig.class);
	

}
