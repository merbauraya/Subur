package com.idetronic.subur.util;

import java.io.IOException;
import java.util.Properties;

import com.idetronic.subur.NoSuchConfigException;
import com.idetronic.subur.model.SuburConfig;
import com.idetronic.subur.service.SuburConfigLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SuburConfiguration {
	
	public static final String AUTHOR_SALUTATION="AuthorSalutation";
	public static final String AUTHOR_SITES="AuthorSites";
	public static final String ITEM_IDENTIFIERS="ItemIdentifiers";
	
	
	public static Properties getConfig(String configKey) throws NoSuchConfigException, SystemException, IOException
	{
		SuburConfig suburConfig = SuburConfigLocalServiceUtil.get(configKey);
		
		return PropertyConfig.getProperties(suburConfig.getConfig());
		
	}
	
	public static String getConfigString (String configKey) throws SystemException, IOException
	{
		Properties props = null;
		try {
			props = getConfig(configKey);
		} catch (NoSuchConfigException e) {
			// TODO Auto-generated catch block
			_log.warn(e);
			return null;
		}
		
		return props.getProperty(configKey);
	}
	
	private static Log _log = LogFactoryUtil.getLog(SuburConfiguration.class);

}
