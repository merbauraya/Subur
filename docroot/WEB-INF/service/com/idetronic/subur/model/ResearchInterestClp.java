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
import com.idetronic.subur.service.ResearchInterestLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mazlan Mat
 */
public class ResearchInterestClp extends BaseModelImpl<ResearchInterest>
	implements ResearchInterest {
	public ResearchInterestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ResearchInterest.class;
	}

	@Override
	public String getModelClassName() {
		return ResearchInterest.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _researchInterestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResearchInterestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _researchInterestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("researchInterestId", getResearchInterestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("researchInterestName", getResearchInterestName());
		attributes.put("indexedName", getIndexedName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("authorCount", getAuthorCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long researchInterestId = (Long)attributes.get("researchInterestId");

		if (researchInterestId != null) {
			setResearchInterestId(researchInterestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String researchInterestName = (String)attributes.get(
				"researchInterestName");

		if (researchInterestName != null) {
			setResearchInterestName(researchInterestName);
		}

		String indexedName = (String)attributes.get("indexedName");

		if (indexedName != null) {
			setIndexedName(indexedName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer authorCount = (Integer)attributes.get("authorCount");

		if (authorCount != null) {
			setAuthorCount(authorCount);
		}
	}

	@Override
	public long getResearchInterestId() {
		return _researchInterestId;
	}

	@Override
	public void setResearchInterestId(long researchInterestId) {
		_researchInterestId = researchInterestId;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchInterestId",
						long.class);

				method.invoke(_researchInterestRemoteModel, researchInterestId);
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

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_researchInterestRemoteModel, groupId);
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

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_researchInterestRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_researchInterestRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_researchInterestRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResearchInterestName() {
		return _researchInterestName;
	}

	@Override
	public void setResearchInterestName(String researchInterestName) {
		_researchInterestName = researchInterestName;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchInterestName",
						String.class);

				method.invoke(_researchInterestRemoteModel, researchInterestName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndexedName() {
		return _indexedName;
	}

	@Override
	public void setIndexedName(String indexedName) {
		_indexedName = indexedName;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexedName", String.class);

				method.invoke(_researchInterestRemoteModel, indexedName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_researchInterestRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAuthorCount() {
		return _authorCount;
	}

	@Override
	public void setAuthorCount(int authorCount) {
		_authorCount = authorCount;

		if (_researchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _researchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorCount", int.class);

				method.invoke(_researchInterestRemoteModel, authorCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getResearchInterestRemoteModel() {
		return _researchInterestRemoteModel;
	}

	public void setResearchInterestRemoteModel(
		BaseModel<?> researchInterestRemoteModel) {
		_researchInterestRemoteModel = researchInterestRemoteModel;
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

		Class<?> remoteModelClass = _researchInterestRemoteModel.getClass();

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

		Object returnValue = method.invoke(_researchInterestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ResearchInterestLocalServiceUtil.addResearchInterest(this);
		}
		else {
			ResearchInterestLocalServiceUtil.updateResearchInterest(this);
		}
	}

	@Override
	public ResearchInterest toEscapedModel() {
		return (ResearchInterest)ProxyUtil.newProxyInstance(ResearchInterest.class.getClassLoader(),
			new Class[] { ResearchInterest.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ResearchInterestClp clone = new ResearchInterestClp();

		clone.setResearchInterestId(getResearchInterestId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setResearchInterestName(getResearchInterestName());
		clone.setIndexedName(getIndexedName());
		clone.setModifiedDate(getModifiedDate());
		clone.setAuthorCount(getAuthorCount());

		return clone;
	}

	@Override
	public int compareTo(ResearchInterest researchInterest) {
		long primaryKey = researchInterest.getPrimaryKey();

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

		if (!(obj instanceof ResearchInterestClp)) {
			return false;
		}

		ResearchInterestClp researchInterest = (ResearchInterestClp)obj;

		long primaryKey = researchInterest.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{researchInterestId=");
		sb.append(getResearchInterestId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", researchInterestName=");
		sb.append(getResearchInterestName());
		sb.append(", indexedName=");
		sb.append(getIndexedName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", authorCount=");
		sb.append(getAuthorCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ResearchInterest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>researchInterestId</column-name><column-value><![CDATA[");
		sb.append(getResearchInterestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchInterestName</column-name><column-value><![CDATA[");
		sb.append(getResearchInterestName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexedName</column-name><column-value><![CDATA[");
		sb.append(getIndexedName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorCount</column-name><column-value><![CDATA[");
		sb.append(getAuthorCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _researchInterestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private String _researchInterestName;
	private String _indexedName;
	private Date _modifiedDate;
	private int _authorCount;
	private BaseModel<?> _researchInterestRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}