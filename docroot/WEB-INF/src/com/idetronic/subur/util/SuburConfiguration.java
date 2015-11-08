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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class SuburConfiguration {
	
	public static final String AUTHOR_SALUTATION="AuthorSalutation";
	public static final String AUTHOR_SITES="AuthorSites";
	public static final String ITEM_IDENTIFIERS="ItemIdentifiers";
	public static final String NOTIFICATION_ROLES="notificationRoles";
	
	
	public static String getConfig(String configKey) throws NoSuchConfigException, SystemException, IOException
	{
		SuburConfig suburConfig = SuburConfigLocalServiceUtil.get(configKey);
		
		if (Validator.isNull(suburConfig))
			return StringPool.BLANK;
		
		return suburConfig.getConfig();
		
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(SuburConfiguration.class);

}
