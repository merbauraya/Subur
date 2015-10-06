/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.subur.service.impl;

import java.io.IOException;
import java.util.Map;

import com.idetronic.subur.NoSuchConfigException;
import com.idetronic.subur.model.SuburConfig;
import com.idetronic.subur.service.base.SuburConfigLocalServiceBaseImpl;
import com.idetronic.subur.util.PropertyConfig;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the subur config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.SuburConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.SuburConfigLocalServiceBaseImpl
 * @see com.idetronic.subur.service.SuburConfigLocalServiceUtil
 */
public class SuburConfigLocalServiceImpl extends SuburConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.SuburConfigLocalServiceUtil} to access the subur config local service.
	 */
	
	
	
	public SuburConfig addConfig(Map<String,String> configMap,String configKey) throws SystemException
	{
		
		long pk = CounterLocalServiceUtil.increment(SuburConfig.class.getName());
		SuburConfig suburConfig = suburConfigPersistence.create(pk);
		
		String propString;
		try {
			propString = PropertyConfig.setPropertiesAsString(configMap);
			suburConfig.setConfig(propString);
			suburConfig.setKey(configKey);
			suburConfigPersistence.update(suburConfig);
		} catch (IOException e) {
			
			_log.error(e);
		}
		
		
		return suburConfig;
		
	}
	public SuburConfig get(String configKey) throws NoSuchConfigException, SystemException
	{
		return suburConfigPersistence.findByKey(configKey);
	}
	public SuburConfig updateConfig(String configKey,String value) throws SystemException
	{
		SuburConfig suburConfig = null;
		
		try {
			suburConfig = get(configKey);
			suburConfig.setConfig(value);
			return suburConfigPersistence.update(suburConfig);
		} catch (NoSuchConfigException e)
		{
			return addConfig(configKey,value);
		}
	}
	
	public SuburConfig addConfig(String configKey,String value) throws SystemException
	{
		long pk = CounterLocalServiceUtil.increment(SuburConfig.class.getName());
		SuburConfig suburConfig = suburConfigPersistence.create(pk);
		suburConfig.setKey(configKey);
		suburConfig.setConfig(value);
		
		return suburConfigPersistence.update(suburConfig);
		
	}
	
	public SuburConfig updateConfig(Map<String,String> configMap,String configKey) throws SystemException
	{
		
		
		SuburConfig suburConfig = null;
		try {
			suburConfig = get(configKey);
			String propString = PropertyConfig.setPropertiesAsString(configMap);
			suburConfig.setConfig(propString);
			
			suburConfigPersistence.update(suburConfig);
		} catch (NoSuchConfigException e) {
			addConfig(configMap,configKey);
			
		} catch(IOException e)
		{
			_log.error(e);
		}
		
		return suburConfig;
		
	}
	private static Log _log = LogFactoryUtil.getLog(SuburConfigLocalServiceImpl.class);
}