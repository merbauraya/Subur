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
import com.idetronic.subur.service.HChartSeriesLocalServiceUtil;

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
public class HChartSeriesClp extends BaseModelImpl<HChartSeries>
	implements HChartSeries {
	public HChartSeriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return HChartSeries.class;
	}

	@Override
	public String getModelClassName() {
		return HChartSeries.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _hChartSeriesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHChartSeriesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hChartSeriesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("hChartSeriesId", getHChartSeriesId());
		attributes.put("seriesName", getSeriesName());
		attributes.put("color", getColor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long hChartSeriesId = (Long)attributes.get("hChartSeriesId");

		if (hChartSeriesId != null) {
			setHChartSeriesId(hChartSeriesId);
		}

		String seriesName = (String)attributes.get("seriesName");

		if (seriesName != null) {
			setSeriesName(seriesName);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_hChartSeriesRemoteModel != null) {
			try {
				Class<?> clazz = _hChartSeriesRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_hChartSeriesRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHChartSeriesId() {
		return _hChartSeriesId;
	}

	@Override
	public void setHChartSeriesId(long hChartSeriesId) {
		_hChartSeriesId = hChartSeriesId;

		if (_hChartSeriesRemoteModel != null) {
			try {
				Class<?> clazz = _hChartSeriesRemoteModel.getClass();

				Method method = clazz.getMethod("setHChartSeriesId", long.class);

				method.invoke(_hChartSeriesRemoteModel, hChartSeriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeriesName() {
		return _seriesName;
	}

	@Override
	public void setSeriesName(String seriesName) {
		_seriesName = seriesName;

		if (_hChartSeriesRemoteModel != null) {
			try {
				Class<?> clazz = _hChartSeriesRemoteModel.getClass();

				Method method = clazz.getMethod("setSeriesName", String.class);

				method.invoke(_hChartSeriesRemoteModel, seriesName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColor() {
		return _color;
	}

	@Override
	public void setColor(String color) {
		_color = color;

		if (_hChartSeriesRemoteModel != null) {
			try {
				Class<?> clazz = _hChartSeriesRemoteModel.getClass();

				Method method = clazz.getMethod("setColor", String.class);

				method.invoke(_hChartSeriesRemoteModel, color);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHChartSeriesRemoteModel() {
		return _hChartSeriesRemoteModel;
	}

	public void setHChartSeriesRemoteModel(BaseModel<?> hChartSeriesRemoteModel) {
		_hChartSeriesRemoteModel = hChartSeriesRemoteModel;
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

		Class<?> remoteModelClass = _hChartSeriesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_hChartSeriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HChartSeriesLocalServiceUtil.addHChartSeries(this);
		}
		else {
			HChartSeriesLocalServiceUtil.updateHChartSeries(this);
		}
	}

	@Override
	public HChartSeries toEscapedModel() {
		return (HChartSeries)ProxyUtil.newProxyInstance(HChartSeries.class.getClassLoader(),
			new Class[] { HChartSeries.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HChartSeriesClp clone = new HChartSeriesClp();

		clone.setUuid(getUuid());
		clone.setHChartSeriesId(getHChartSeriesId());
		clone.setSeriesName(getSeriesName());
		clone.setColor(getColor());

		return clone;
	}

	@Override
	public int compareTo(HChartSeries hChartSeries) {
		long primaryKey = hChartSeries.getPrimaryKey();

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

		if (!(obj instanceof HChartSeriesClp)) {
			return false;
		}

		HChartSeriesClp hChartSeries = (HChartSeriesClp)obj;

		long primaryKey = hChartSeries.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", hChartSeriesId=");
		sb.append(getHChartSeriesId());
		sb.append(", seriesName=");
		sb.append(getSeriesName());
		sb.append(", color=");
		sb.append(getColor());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.HChartSeries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hChartSeriesId</column-name><column-value><![CDATA[");
		sb.append(getHChartSeriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>seriesName</column-name><column-value><![CDATA[");
		sb.append(getSeriesName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _hChartSeriesId;
	private String _seriesName;
	private String _color;
	private BaseModel<?> _hChartSeriesRemoteModel;
	private Class<?> _clpSerializerClass = com.idetronic.subur.service.ClpSerializer.class;
}