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

package com.idetronic.subur.model.impl;

import com.idetronic.subur.model.MetadataPropertyValue;
import com.idetronic.subur.model.MetadataPropertyValueModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MetadataPropertyValue service. Represents a row in the &quot;Subur_MetadataPropertyValue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.MetadataPropertyValueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MetadataPropertyValueImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataPropertyValueImpl
 * @see com.idetronic.subur.model.MetadataPropertyValue
 * @see com.idetronic.subur.model.MetadataPropertyValueModel
 * @generated
 */
public class MetadataPropertyValueModelImpl extends BaseModelImpl<MetadataPropertyValue>
	implements MetadataPropertyValueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a metadata property value model instance should use the {@link com.idetronic.subur.model.MetadataPropertyValue} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_MetadataPropertyValue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "metadataPropertyValueId", Types.BIGINT },
			{ "itemId", Types.BIGINT },
			{ "propertyId", Types.BIGINT },
			{ "textValue", Types.CLOB },
			{ "itemCount", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_MetadataPropertyValue (metadataPropertyValueId LONG not null primary key,itemId LONG,propertyId LONG,textValue TEXT null,itemCount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Subur_MetadataPropertyValue";
	public static final String ORDER_BY_JPQL = " ORDER BY metadataPropertyValue.metadataPropertyValueId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_MetadataPropertyValue.metadataPropertyValueId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.MetadataPropertyValue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.MetadataPropertyValue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.MetadataPropertyValue"),
			true);
	public static long ITEMID_COLUMN_BITMASK = 1L;
	public static long METADATAPROPERTYVALUEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.MetadataPropertyValue"));

	public MetadataPropertyValueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _metadataPropertyValueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMetadataPropertyValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _metadataPropertyValueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MetadataPropertyValue.class;
	}

	@Override
	public String getModelClassName() {
		return MetadataPropertyValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("metadataPropertyValueId", getMetadataPropertyValueId());
		attributes.put("itemId", getItemId());
		attributes.put("propertyId", getPropertyId());
		attributes.put("textValue", getTextValue());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long metadataPropertyValueId = (Long)attributes.get(
				"metadataPropertyValueId");

		if (metadataPropertyValueId != null) {
			setMetadataPropertyValueId(metadataPropertyValueId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long propertyId = (Long)attributes.get("propertyId");

		if (propertyId != null) {
			setPropertyId(propertyId);
		}

		String textValue = (String)attributes.get("textValue");

		if (textValue != null) {
			setTextValue(textValue);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	@Override
	public long getMetadataPropertyValueId() {
		return _metadataPropertyValueId;
	}

	@Override
	public void setMetadataPropertyValueId(long metadataPropertyValueId) {
		_metadataPropertyValueId = metadataPropertyValueId;
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_columnBitmask |= ITEMID_COLUMN_BITMASK;

		if (!_setOriginalItemId) {
			_setOriginalItemId = true;

			_originalItemId = _itemId;
		}

		_itemId = itemId;
	}

	public long getOriginalItemId() {
		return _originalItemId;
	}

	@Override
	public long getPropertyId() {
		return _propertyId;
	}

	@Override
	public void setPropertyId(long propertyId) {
		_propertyId = propertyId;
	}

	@Override
	public String getTextValue() {
		if (_textValue == null) {
			return StringPool.BLANK;
		}
		else {
			return _textValue;
		}
	}

	@Override
	public void setTextValue(String textValue) {
		_textValue = textValue;
	}

	@Override
	public int getItemCount() {
		return _itemCount;
	}

	@Override
	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MetadataPropertyValue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MetadataPropertyValue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MetadataPropertyValue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MetadataPropertyValueImpl metadataPropertyValueImpl = new MetadataPropertyValueImpl();

		metadataPropertyValueImpl.setMetadataPropertyValueId(getMetadataPropertyValueId());
		metadataPropertyValueImpl.setItemId(getItemId());
		metadataPropertyValueImpl.setPropertyId(getPropertyId());
		metadataPropertyValueImpl.setTextValue(getTextValue());
		metadataPropertyValueImpl.setItemCount(getItemCount());

		metadataPropertyValueImpl.resetOriginalValues();

		return metadataPropertyValueImpl;
	}

	@Override
	public int compareTo(MetadataPropertyValue metadataPropertyValue) {
		long primaryKey = metadataPropertyValue.getPrimaryKey();

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

		if (!(obj instanceof MetadataPropertyValue)) {
			return false;
		}

		MetadataPropertyValue metadataPropertyValue = (MetadataPropertyValue)obj;

		long primaryKey = metadataPropertyValue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		MetadataPropertyValueModelImpl metadataPropertyValueModelImpl = this;

		metadataPropertyValueModelImpl._originalItemId = metadataPropertyValueModelImpl._itemId;

		metadataPropertyValueModelImpl._setOriginalItemId = false;

		metadataPropertyValueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MetadataPropertyValue> toCacheModel() {
		MetadataPropertyValueCacheModel metadataPropertyValueCacheModel = new MetadataPropertyValueCacheModel();

		metadataPropertyValueCacheModel.metadataPropertyValueId = getMetadataPropertyValueId();

		metadataPropertyValueCacheModel.itemId = getItemId();

		metadataPropertyValueCacheModel.propertyId = getPropertyId();

		metadataPropertyValueCacheModel.textValue = getTextValue();

		String textValue = metadataPropertyValueCacheModel.textValue;

		if ((textValue != null) && (textValue.length() == 0)) {
			metadataPropertyValueCacheModel.textValue = null;
		}

		metadataPropertyValueCacheModel.itemCount = getItemCount();

		return metadataPropertyValueCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{metadataPropertyValueId=");
		sb.append(getMetadataPropertyValueId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", propertyId=");
		sb.append(getPropertyId());
		sb.append(", textValue=");
		sb.append(getTextValue());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.MetadataPropertyValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>metadataPropertyValueId</column-name><column-value><![CDATA[");
		sb.append(getMetadataPropertyValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>propertyId</column-name><column-value><![CDATA[");
		sb.append(getPropertyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textValue</column-name><column-value><![CDATA[");
		sb.append(getTextValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MetadataPropertyValue.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MetadataPropertyValue.class
		};
	private long _metadataPropertyValueId;
	private long _itemId;
	private long _originalItemId;
	private boolean _setOriginalItemId;
	private long _propertyId;
	private String _textValue;
	private int _itemCount;
	private long _columnBitmask;
	private MetadataPropertyValue _escapedModel;
}