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

package com.idetronic.subur.model;

import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.SuburConfigLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class SuburConfigClp extends BaseModelImpl<SuburConfig>
	implements SuburConfig {
	public SuburConfigClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SuburConfig.class;
	}

	@Override
	public String getModelClassName() {
		return SuburConfig.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("key", getKey());
		attributes.put("description", getDescription());
		attributes.put("config", getConfig());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String config = (String)attributes.get("config");

		if (config != null) {
			setConfig(config);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_suburConfigRemoteModel != null) {
			try {
				Class<?> clazz = _suburConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_suburConfigRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public void setKey(String key) {
		_key = key;

		if (_suburConfigRemoteModel != null) {
			try {
				Class<?> clazz = _suburConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setKey", String.class);

				method.invoke(_suburConfigRemoteModel, key);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_suburConfigRemoteModel != null) {
			try {
				Class<?> clazz = _suburConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_suburConfigRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConfig() {
		return _config;
	}

	@Override
	public void setConfig(String config) {
		_config = config;

		if (_suburConfigRemoteModel != null) {
			try {
				Class<?> clazz = _suburConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setConfig", String.class);

				method.invoke(_suburConfigRemoteModel, config);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSuburConfigRemoteModel() {
		return _suburConfigRemoteModel;
	}

	public void setSuburConfigRemoteModel(BaseModel<?> suburConfigRemoteModel) {
		_suburConfigRemoteModel = suburConfigRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _suburConfigRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_suburConfigRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SuburConfigLocalServiceUtil.addSuburConfig(this);
		}
		else {
			SuburConfigLocalServiceUtil.updateSuburConfig(this);
		}
	}

	@Override
	public SuburConfig toEscapedModel() {
		return (SuburConfig)ProxyUtil.newProxyInstance(SuburConfig.class.getClassLoader(),
			new Class[] { SuburConfig.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SuburConfigClp clone = new SuburConfigClp();

		clone.setId(getId());
		clone.setKey(getKey());
		clone.setDescription(getDescription());
		clone.setConfig(getConfig());

		return clone;
	}

	@Override
	public int compareTo(SuburConfig suburConfig) {
		long primaryKey = suburConfig.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SuburConfigClp)) {
			return false;
		}

		SuburConfigClp suburConfig = (SuburConfigClp)obj;

		long primaryKey = suburConfig.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", config=");
		sb.append(getConfig());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.SuburConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>config</column-name><column-value><![CDATA[");
		sb.append(getConfig());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _key;
	private String _description;
	private String _config;
	private BaseModel<?> _suburConfigRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}