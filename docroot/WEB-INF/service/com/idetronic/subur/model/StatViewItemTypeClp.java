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
import com.idetronic.subur.service.StatViewItemTypeLocalServiceUtil;

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
public class StatViewItemTypeClp extends BaseModelImpl<StatViewItemType>
	implements StatViewItemType {
	public StatViewItemTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewItemType.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewItemType.class.getName();
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
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("perYear", getPerYear());
		attributes.put("perMonth", getPerMonth());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("viewCount", getViewCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_statViewItemTypeRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_statViewItemTypeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_statViewItemTypeRemoteModel, groupId);
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

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPerYear", int.class);

				method.invoke(_statViewItemTypeRemoteModel, perYear);
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

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPerMonth", int.class);

				method.invoke(_statViewItemTypeRemoteModel, perMonth);
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

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setItemTypeId", long.class);

				method.invoke(_statViewItemTypeRemoteModel, itemTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_viewCount = viewCount;

		if (_statViewItemTypeRemoteModel != null) {
			try {
				Class<?> clazz = _statViewItemTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_statViewItemTypeRemoteModel, viewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStatViewItemTypeRemoteModel() {
		return _statViewItemTypeRemoteModel;
	}

	public void setStatViewItemTypeRemoteModel(
		BaseModel<?> statViewItemTypeRemoteModel) {
		_statViewItemTypeRemoteModel = statViewItemTypeRemoteModel;
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

		Class<?> remoteModelClass = _statViewItemTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_statViewItemTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StatViewItemTypeLocalServiceUtil.addStatViewItemType(this);
		}
		else {
			StatViewItemTypeLocalServiceUtil.updateStatViewItemType(this);
		}
	}

	@Override
	public StatViewItemType toEscapedModel() {
		return (StatViewItemType)ProxyUtil.newProxyInstance(StatViewItemType.class.getClassLoader(),
			new Class[] { StatViewItemType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StatViewItemTypeClp clone = new StatViewItemTypeClp();

		clone.setId(getId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setPerYear(getPerYear());
		clone.setPerMonth(getPerMonth());
		clone.setItemTypeId(getItemTypeId());
		clone.setViewCount(getViewCount());

		return clone;
	}

	@Override
	public int compareTo(StatViewItemType statViewItemType) {
		long primaryKey = statViewItemType.getPrimaryKey();

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

		if (!(obj instanceof StatViewItemTypeClp)) {
			return false;
		}

		StatViewItemTypeClp statViewItemType = (StatViewItemTypeClp)obj;

		long primaryKey = statViewItemType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", perYear=");
		sb.append(getPerYear());
		sb.append(", perMonth=");
		sb.append(getPerMonth());
		sb.append(", itemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.StatViewItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perYear</column-name><column-value><![CDATA[");
		sb.append(getPerYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perMonth</column-name><column-value><![CDATA[");
		sb.append(getPerMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private int _perYear;
	private int _perMonth;
	private long _itemTypeId;
	private int _viewCount;
	private BaseModel<?> _statViewItemTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}