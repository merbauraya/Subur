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
import com.idetronic.subur.service.StatDownloadItemTypeLocalServiceUtil;

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
public class StatDownloadItemTypeClp extends BaseModelImpl<StatDownloadItemType>
	implements StatDownloadItemType {
	public StatDownloadItemTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StatDownloadItemType.class;
	}

	@Override
	public String getModelClassName() {
		return StatDownloadItemType.class.getName();
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
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("itemTypeId", getItemTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_statDownloadItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statDownloadItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_statDownloadItemTypeRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPerMonth() {
		return _perMonth;
	}

	@Override
	public void setPerMonth(int perMonth) {
		_perMonth = perMonth;

		if (_statDownloadItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statDownloadItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPerMonth", int.class);

				method.invoke(_statDownloadItemTypeRemoteModel, perMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPerYear() {
		return _perYear;
	}

	@Override
	public void setPerYear(int perYear) {
		_perYear = perYear;

		if (_statDownloadItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statDownloadItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPerYear", int.class);

				method.invoke(_statDownloadItemTypeRemoteModel, perYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemTypeId() {
		return _itemTypeId;
	}

	@Override
	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;

		if (_statDownloadItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statDownloadItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_statDownloadItemTypeRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStatDownloadItemTypeRemoteModel() {
		return _statDownloadItemTypeRemoteModel;
	}

	public void setStatDownloadItemTypeRemoteModel(
		BaseModel<?> statDownloadItemTypeRemoteModel) {
		_statDownloadItemTypeRemoteModel = statDownloadItemTypeRemoteModel;
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

		Class<?> remoteModelClass = _statDownloadItemTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_statDownloadItemTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StatDownloadItemTypeLocalServiceUtil.addStatDownloadItemType(this);
		}
		else {
			StatDownloadItemTypeLocalServiceUtil.updateStatDownloadItemType(this);
		}
	}

	@Override
	public StatDownloadItemType toEscapedModel() {
		return (StatDownloadItemType)ProxyUtil.newProxyInstance(StatDownloadItemType.class.getClassLoader(),
			new Class[] { StatDownloadItemType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StatDownloadItemTypeClp clone = new StatDownloadItemTypeClp();

		clone.setId(getId());
		clone.setPerMonth(getPerMonth());
		clone.setPerYear(getPerYear());
		clone.setItemTypeId(getItemTypeId());

		return clone;
	}

	@Override
	public int compareTo(StatDownloadItemType statDownloadItemType) {
		long primaryKey = statDownloadItemType.getPrimaryKey();

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

		if (!(obj instanceof StatDownloadItemTypeClp)) {
			return false;
		}

		StatDownloadItemTypeClp statDownloadItemType = (StatDownloadItemTypeClp)obj;

		long primaryKey = statDownloadItemType.getPrimaryKey();

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
		sb.append(", perMonth=");
		sb.append(getPerMonth());
		sb.append(", perYear=");
		sb.append(getPerYear());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.StatDownloadItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perMonth</column-name><column-value><![CDATA[");
		sb.append(getPerMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perYear</column-name><column-value><![CDATA[");
		sb.append(getPerYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private int _perMonth;
	private int _perYear;
	private long _itemTypeId;
	private BaseModel<?> _statDownloadItemTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}