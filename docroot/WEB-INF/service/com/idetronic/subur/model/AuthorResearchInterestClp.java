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

import com.idetronic.subur.service.AuthorResearchInterestLocalServiceUtil;
import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.persistence.AuthorResearchInterestPK;

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
public class AuthorResearchInterestClp extends BaseModelImpl<AuthorResearchInterest>
	implements AuthorResearchInterest {
	public AuthorResearchInterestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorResearchInterest.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorResearchInterest.class.getName();
	}

	@Override
	public AuthorResearchInterestPK getPrimaryKey() {
		return new AuthorResearchInterestPK(_authorId, _researchInterestId);
	}

	@Override
	public void setPrimaryKey(AuthorResearchInterestPK primaryKey) {
		setAuthorId(primaryKey.authorId);
		setResearchInterestId(primaryKey.researchInterestId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AuthorResearchInterestPK(_authorId, _researchInterestId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AuthorResearchInterestPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("researchInterestId", getResearchInterestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long researchInterestId = (Long)attributes.get("researchInterestId");

		if (researchInterestId != null) {
			setResearchInterestId(researchInterestId);
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_authorResearchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _authorResearchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_authorResearchInterestRemoteModel, authorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResearchInterestId() {
		return _researchInterestId;
	}

	@Override
	public void setResearchInterestId(long researchInterestId) {
		_researchInterestId = researchInterestId;

		if (_authorResearchInterestRemoteModel != null) {
			try {
				Class<?> clazz = _authorResearchInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchInterestId",
						long.class);

				method.invoke(_authorResearchInterestRemoteModel,
					researchInterestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAuthorResearchInterestRemoteModel() {
		return _authorResearchInterestRemoteModel;
	}

	public void setAuthorResearchInterestRemoteModel(
		BaseModel<?> authorResearchInterestRemoteModel) {
		_authorResearchInterestRemoteModel = authorResearchInterestRemoteModel;
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

		Class<?> remoteModelClass = _authorResearchInterestRemoteModel.getClass();

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

		Object returnValue = method.invoke(_authorResearchInterestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AuthorResearchInterestLocalServiceUtil.addAuthorResearchInterest(this);
		}
		else {
			AuthorResearchInterestLocalServiceUtil.updateAuthorResearchInterest(this);
		}
	}

	@Override
	public AuthorResearchInterest toEscapedModel() {
		return (AuthorResearchInterest)ProxyUtil.newProxyInstance(AuthorResearchInterest.class.getClassLoader(),
			new Class[] { AuthorResearchInterest.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuthorResearchInterestClp clone = new AuthorResearchInterestClp();

		clone.setAuthorId(getAuthorId());
		clone.setResearchInterestId(getResearchInterestId());

		return clone;
	}

	@Override
	public int compareTo(AuthorResearchInterest authorResearchInterest) {
		AuthorResearchInterestPK primaryKey = authorResearchInterest.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorResearchInterestClp)) {
			return false;
		}

		AuthorResearchInterestClp authorResearchInterest = (AuthorResearchInterestClp)obj;

		AuthorResearchInterestPK primaryKey = authorResearchInterest.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(getAuthorId());
		sb.append(", researchInterestId=");
		sb.append(getResearchInterestId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.AuthorResearchInterest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchInterestId</column-name><column-value><![CDATA[");
		sb.append(getResearchInterestId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _authorId;
	private long _researchInterestId;
	private BaseModel<?> _authorResearchInterestRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}