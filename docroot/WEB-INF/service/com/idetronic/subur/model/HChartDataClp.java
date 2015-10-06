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
import com.idetronic.subur.service.HChartDataLocalServiceUtil;

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
public class HChartDataClp extends BaseModelImpl<HChartData>
	implements HChartData {
	public HChartDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return HChartData.class;
	}

	@Override
	public String getModelClassName() {
		return HChartData.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _hChartDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHChartDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hChartDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("hChartDataId", getHChartDataId());
		attributes.put("title", getTitle());
		attributes.put("yAxisTitle", getYAxisTitle());
		attributes.put("xAxisTitle", getXAxisTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long hChartDataId = (Long)attributes.get("hChartDataId");

		if (hChartDataId != null) {
			setHChartDataId(hChartDataId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String yAxisTitle = (String)attributes.get("yAxisTitle");

		if (yAxisTitle != null) {
			setYAxisTitle(yAxisTitle);
		}

		String xAxisTitle = (String)attributes.get("xAxisTitle");

		if (xAxisTitle != null) {
			setXAxisTitle(xAxisTitle);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_hChartDataRemoteModel != null) {
			try {
				Class<?> clazz = _hChartDataRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_hChartDataRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHChartDataId() {
		return _hChartDataId;
	}

	@Override
	public void setHChartDataId(long hChartDataId) {
		_hChartDataId = hChartDataId;

		if (_hChartDataRemoteModel != null) {
			try {
				Class<?> clazz = _hChartDataRemoteModel.getClass();

				Method method = clazz.getMethod("setHChartDataId", long.class);

				method.invoke(_hChartDataRemoteModel, hChartDataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_hChartDataRemoteModel != null) {
			try {
				Class<?> clazz = _hChartDataRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_hChartDataRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYAxisTitle() {
		return _yAxisTitle;
	}

	@Override
	public void setYAxisTitle(String yAxisTitle) {
		_yAxisTitle = yAxisTitle;

		if (_hChartDataRemoteModel != null) {
			try {
				Class<?> clazz = _hChartDataRemoteModel.getClass();

				Method method = clazz.getMethod("setYAxisTitle", String.class);

				method.invoke(_hChartDataRemoteModel, yAxisTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXAxisTitle() {
		return _xAxisTitle;
	}

	@Override
	public void setXAxisTitle(String xAxisTitle) {
		_xAxisTitle = xAxisTitle;

		if (_hChartDataRemoteModel != null) {
			try {
				Class<?> clazz = _hChartDataRemoteModel.getClass();

				Method method = clazz.getMethod("setXAxisTitle", String.class);

				method.invoke(_hChartDataRemoteModel, xAxisTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHChartDataRemoteModel() {
		return _hChartDataRemoteModel;
	}

	public void setHChartDataRemoteModel(BaseModel<?> hChartDataRemoteModel) {
		_hChartDataRemoteModel = hChartDataRemoteModel;
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

		Class<?> remoteModelClass = _hChartDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_hChartDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HChartDataLocalServiceUtil.addHChartData(this);
		}
		else {
			HChartDataLocalServiceUtil.updateHChartData(this);
		}
	}

	@Override
	public HChartData toEscapedModel() {
		return (HChartData)ProxyUtil.newProxyInstance(HChartData.class.getClassLoader(),
			new Class[] { HChartData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HChartDataClp clone = new HChartDataClp();

		clone.setUuid(getUuid());
		clone.setHChartDataId(getHChartDataId());
		clone.setTitle(getTitle());
		clone.setYAxisTitle(getYAxisTitle());
		clone.setXAxisTitle(getXAxisTitle());

		return clone;
	}

	@Override
	public int compareTo(HChartData hChartData) {
		long primaryKey = hChartData.getPrimaryKey();

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

		if (!(obj instanceof HChartDataClp)) {
			return false;
		}

		HChartDataClp hChartData = (HChartDataClp)obj;

		long primaryKey = hChartData.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", hChartDataId=");
		sb.append(getHChartDataId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", yAxisTitle=");
		sb.append(getYAxisTitle());
		sb.append(", xAxisTitle=");
		sb.append(getXAxisTitle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.HChartData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hChartDataId</column-name><column-value><![CDATA[");
		sb.append(getHChartDataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yAxisTitle</column-name><column-value><![CDATA[");
		sb.append(getYAxisTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xAxisTitle</column-name><column-value><![CDATA[");
		sb.append(getXAxisTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _hChartDataId;
	private String _title;
	private String _yAxisTitle;
	private String _xAxisTitle;
	private BaseModel<?> _hChartDataRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}