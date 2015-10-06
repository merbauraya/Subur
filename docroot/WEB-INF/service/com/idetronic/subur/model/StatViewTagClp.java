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
import com.idetronic.subur.service.StatViewTagLocalServiceUtil;

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
public class StatViewTagClp extends BaseModelImpl<StatViewTag>
	implements StatViewTag {
	public StatViewTagClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewTag.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewTag.class.getName();
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
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());
		attributes.put("tagId", getTagId());
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

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
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

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_statViewTagRemoteModel, id);
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

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_statViewTagRemoteModel, companyId);
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

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_statViewTagRemoteModel, groupId);
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

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setPerMonth", int.class);

				method.invoke(_statViewTagRemoteModel, perMonth);
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

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setPerYear", int.class);

				method.invoke(_statViewTagRemoteModel, perYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_tagId = tagId;

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTagId", long.class);

				method.invoke(_statViewTagRemoteModel, tagId);
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

		if (_statViewTagRemoteModel != null) {
			try {
				Class<?> clazz = _statViewTagRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_statViewTagRemoteModel, viewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStatViewTagRemoteModel() {
		return _statViewTagRemoteModel;
	}

	public void setStatViewTagRemoteModel(BaseModel<?> statViewTagRemoteModel) {
		_statViewTagRemoteModel = statViewTagRemoteModel;
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

		Class<?> remoteModelClass = _statViewTagRemoteModel.getClass();

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

		Object returnValue = method.invoke(_statViewTagRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StatViewTagLocalServiceUtil.addStatViewTag(this);
		}
		else {
			StatViewTagLocalServiceUtil.updateStatViewTag(this);
		}
	}

	@Override
	public StatViewTag toEscapedModel() {
		return (StatViewTag)ProxyUtil.newProxyInstance(StatViewTag.class.getClassLoader(),
			new Class[] { StatViewTag.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StatViewTagClp clone = new StatViewTagClp();

		clone.setId(getId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setPerMonth(getPerMonth());
		clone.setPerYear(getPerYear());
		clone.setTagId(getTagId());
		clone.setViewCount(getViewCount());

		return clone;
	}

	@Override
	public int compareTo(StatViewTag statViewTag) {
		long primaryKey = statViewTag.getPrimaryKey();

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

		if (!(obj instanceof StatViewTagClp)) {
			return false;
		}

		StatViewTagClp statViewTag = (StatViewTagClp)obj;

		long primaryKey = statViewTag.getPrimaryKey();

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
		sb.append(", perMonth=");
		sb.append(getPerMonth());
		sb.append(", perYear=");
		sb.append(getPerYear());
		sb.append(", tagId=");
		sb.append(getTagId());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.StatViewTag");
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
			"<column><column-name>perMonth</column-name><column-value><![CDATA[");
		sb.append(getPerMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perYear</column-name><column-value><![CDATA[");
		sb.append(getPerYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
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
	private int _perMonth;
	private int _perYear;
	private long _tagId;
	private int _viewCount;
	private BaseModel<?> _statViewTagRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}