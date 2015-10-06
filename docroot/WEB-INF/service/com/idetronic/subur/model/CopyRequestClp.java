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
import com.idetronic.subur.service.CopyRequestLocalServiceUtil;

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
public class CopyRequestClp extends BaseModelImpl<CopyRequest>
	implements CopyRequest {
	public CopyRequestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CopyRequest.class;
	}

	@Override
	public String getModelClassName() {
		return CopyRequest.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _copyRequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCopyRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _copyRequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("copyRequestId", getCopyRequestId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("dateCreated", getDateCreated());
		attributes.put("status", getStatus());
		attributes.put("suburItemId", getSuburItemId());
		attributes.put("fromEmailAddress", getFromEmailAddress());
		attributes.put("requesterName", getRequesterName());
		attributes.put("reason", getReason());
		attributes.put("organization", getOrganization());
		attributes.put("dateResponsed", getDateResponsed());
		attributes.put("respondText", getRespondText());
		attributes.put("responsedByUserId", getResponsedByUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long copyRequestId = (Long)attributes.get("copyRequestId");

		if (copyRequestId != null) {
			setCopyRequestId(copyRequestId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date dateCreated = (Date)attributes.get("dateCreated");

		if (dateCreated != null) {
			setDateCreated(dateCreated);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long suburItemId = (Long)attributes.get("suburItemId");

		if (suburItemId != null) {
			setSuburItemId(suburItemId);
		}

		String fromEmailAddress = (String)attributes.get("fromEmailAddress");

		if (fromEmailAddress != null) {
			setFromEmailAddress(fromEmailAddress);
		}

		String requesterName = (String)attributes.get("requesterName");

		if (requesterName != null) {
			setRequesterName(requesterName);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		Date dateResponsed = (Date)attributes.get("dateResponsed");

		if (dateResponsed != null) {
			setDateResponsed(dateResponsed);
		}

		String respondText = (String)attributes.get("respondText");

		if (respondText != null) {
			setRespondText(respondText);
		}

		Long responsedByUserId = (Long)attributes.get("responsedByUserId");

		if (responsedByUserId != null) {
			setResponsedByUserId(responsedByUserId);
		}
	}

	@Override
	public long getCopyRequestId() {
		return _copyRequestId;
	}

	@Override
	public void setCopyRequestId(long copyRequestId) {
		_copyRequestId = copyRequestId;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCopyRequestId", long.class);

				method.invoke(_copyRequestRemoteModel, copyRequestId);
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

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_copyRequestRemoteModel, companyId);
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

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_copyRequestRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateCreated() {
		return _dateCreated;
	}

	@Override
	public void setDateCreated(Date dateCreated) {
		_dateCreated = dateCreated;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setDateCreated", Date.class);

				method.invoke(_copyRequestRemoteModel, dateCreated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_copyRequestRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSuburItemId() {
		return _suburItemId;
	}

	@Override
	public void setSuburItemId(long suburItemId) {
		_suburItemId = suburItemId;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSuburItemId", long.class);

				method.invoke(_copyRequestRemoteModel, suburItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFromEmailAddress() {
		return _fromEmailAddress;
	}

	@Override
	public void setFromEmailAddress(String fromEmailAddress) {
		_fromEmailAddress = fromEmailAddress;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setFromEmailAddress",
						String.class);

				method.invoke(_copyRequestRemoteModel, fromEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequesterName() {
		return _requesterName;
	}

	@Override
	public void setRequesterName(String requesterName) {
		_requesterName = requesterName;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequesterName", String.class);

				method.invoke(_copyRequestRemoteModel, requesterName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReason() {
		return _reason;
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setReason", String.class);

				method.invoke(_copyRequestRemoteModel, reason);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrganization() {
		return _organization;
	}

	@Override
	public void setOrganization(String organization) {
		_organization = organization;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganization", String.class);

				method.invoke(_copyRequestRemoteModel, organization);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateResponsed() {
		return _dateResponsed;
	}

	@Override
	public void setDateResponsed(Date dateResponsed) {
		_dateResponsed = dateResponsed;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setDateResponsed", Date.class);

				method.invoke(_copyRequestRemoteModel, dateResponsed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRespondText() {
		return _respondText;
	}

	@Override
	public void setRespondText(String respondText) {
		_respondText = respondText;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRespondText", String.class);

				method.invoke(_copyRequestRemoteModel, respondText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResponsedByUserId() {
		return _responsedByUserId;
	}

	@Override
	public void setResponsedByUserId(long responsedByUserId) {
		_responsedByUserId = responsedByUserId;

		if (_copyRequestRemoteModel != null) {
			try {
				Class<?> clazz = _copyRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setResponsedByUserId",
						long.class);

				method.invoke(_copyRequestRemoteModel, responsedByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResponsedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getResponsedByUserId(), "uuid",
			_responsedByUserUuid);
	}

	@Override
	public void setResponsedByUserUuid(String responsedByUserUuid) {
		_responsedByUserUuid = responsedByUserUuid;
	}

	public BaseModel<?> getCopyRequestRemoteModel() {
		return _copyRequestRemoteModel;
	}

	public void setCopyRequestRemoteModel(BaseModel<?> copyRequestRemoteModel) {
		_copyRequestRemoteModel = copyRequestRemoteModel;
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

		Class<?> remoteModelClass = _copyRequestRemoteModel.getClass();

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

		Object returnValue = method.invoke(_copyRequestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CopyRequestLocalServiceUtil.addCopyRequest(this);
		}
		else {
			CopyRequestLocalServiceUtil.updateCopyRequest(this);
		}
	}

	@Override
	public CopyRequest toEscapedModel() {
		return (CopyRequest)ProxyUtil.newProxyInstance(CopyRequest.class.getClassLoader(),
			new Class[] { CopyRequest.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CopyRequestClp clone = new CopyRequestClp();

		clone.setCopyRequestId(getCopyRequestId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setDateCreated(getDateCreated());
		clone.setStatus(getStatus());
		clone.setSuburItemId(getSuburItemId());
		clone.setFromEmailAddress(getFromEmailAddress());
		clone.setRequesterName(getRequesterName());
		clone.setReason(getReason());
		clone.setOrganization(getOrganization());
		clone.setDateResponsed(getDateResponsed());
		clone.setRespondText(getRespondText());
		clone.setResponsedByUserId(getResponsedByUserId());

		return clone;
	}

	@Override
	public int compareTo(CopyRequest copyRequest) {
		long primaryKey = copyRequest.getPrimaryKey();

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

		if (!(obj instanceof CopyRequestClp)) {
			return false;
		}

		CopyRequestClp copyRequest = (CopyRequestClp)obj;

		long primaryKey = copyRequest.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{copyRequestId=");
		sb.append(getCopyRequestId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", dateCreated=");
		sb.append(getDateCreated());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", suburItemId=");
		sb.append(getSuburItemId());
		sb.append(", fromEmailAddress=");
		sb.append(getFromEmailAddress());
		sb.append(", requesterName=");
		sb.append(getRequesterName());
		sb.append(", reason=");
		sb.append(getReason());
		sb.append(", organization=");
		sb.append(getOrganization());
		sb.append(", dateResponsed=");
		sb.append(getDateResponsed());
		sb.append(", respondText=");
		sb.append(getRespondText());
		sb.append(", responsedByUserId=");
		sb.append(getResponsedByUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.CopyRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>copyRequestId</column-name><column-value><![CDATA[");
		sb.append(getCopyRequestId());
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
			"<column><column-name>dateCreated</column-name><column-value><![CDATA[");
		sb.append(getDateCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>suburItemId</column-name><column-value><![CDATA[");
		sb.append(getSuburItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getFromEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requesterName</column-name><column-value><![CDATA[");
		sb.append(getRequesterName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organization</column-name><column-value><![CDATA[");
		sb.append(getOrganization());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateResponsed</column-name><column-value><![CDATA[");
		sb.append(getDateResponsed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respondText</column-name><column-value><![CDATA[");
		sb.append(getRespondText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>responsedByUserId</column-name><column-value><![CDATA[");
		sb.append(getResponsedByUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _copyRequestId;
	private long _companyId;
	private long _groupId;
	private Date _dateCreated;
	private int _status;
	private long _suburItemId;
	private String _fromEmailAddress;
	private String _requesterName;
	private String _reason;
	private String _organization;
	private Date _dateResponsed;
	private String _respondText;
	private long _responsedByUserId;
	private String _responsedByUserUuid;
	private BaseModel<?> _copyRequestRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}