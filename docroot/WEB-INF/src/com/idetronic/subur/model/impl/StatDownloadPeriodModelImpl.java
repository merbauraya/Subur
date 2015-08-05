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

import com.idetronic.subur.model.StatDownloadPeriod;
import com.idetronic.subur.model.StatDownloadPeriodModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
 * The base model implementation for the StatDownloadPeriod service. Represents a row in the &quot;Subur_StatDownloadPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.StatDownloadPeriodModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StatDownloadPeriodImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadPeriodImpl
 * @see com.idetronic.subur.model.StatDownloadPeriod
 * @see com.idetronic.subur.model.StatDownloadPeriodModel
 * @generated
 */
public class StatDownloadPeriodModelImpl extends BaseModelImpl<StatDownloadPeriod>
	implements StatDownloadPeriodModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stat download period model instance should use the {@link com.idetronic.subur.model.StatDownloadPeriod} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_StatDownloadPeriod";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "itemId", Types.BIGINT },
			{ "perMonth", Types.INTEGER },
			{ "perYear", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_StatDownloadPeriod (id_ LONG not null primary key,itemId LONG,perMonth INTEGER,perYear INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Subur_StatDownloadPeriod";
	public static final String ORDER_BY_JPQL = " ORDER BY statDownloadPeriod.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_StatDownloadPeriod.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.StatDownloadPeriod"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.StatDownloadPeriod"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.StatDownloadPeriod"),
			true);
	public static long PERMONTH_COLUMN_BITMASK = 1L;
	public static long PERYEAR_COLUMN_BITMASK = 2L;
	public static long ID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.StatDownloadPeriod"));

	public StatDownloadPeriodModelImpl() {
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
	public Class<?> getModelClass() {
		return StatDownloadPeriod.class;
	}

	@Override
	public String getModelClassName() {
		return StatDownloadPeriod.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("itemId", getItemId());
		attributes.put("perMonth", getPerMonth());
		attributes.put("perYear", getPerYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	@Override
	public int getPerMonth() {
		return _perMonth;
	}

	@Override
	public void setPerMonth(int perMonth) {
		_columnBitmask |= PERMONTH_COLUMN_BITMASK;

		if (!_setOriginalPerMonth) {
			_setOriginalPerMonth = true;

			_originalPerMonth = _perMonth;
		}

		_perMonth = perMonth;
	}

	public int getOriginalPerMonth() {
		return _originalPerMonth;
	}

	@Override
	public int getPerYear() {
		return _perYear;
	}

	@Override
	public void setPerYear(int perYear) {
		_columnBitmask |= PERYEAR_COLUMN_BITMASK;

		if (!_setOriginalPerYear) {
			_setOriginalPerYear = true;

			_originalPerYear = _perYear;
		}

		_perYear = perYear;
	}

	public int getOriginalPerYear() {
		return _originalPerYear;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			StatDownloadPeriod.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StatDownloadPeriod toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StatDownloadPeriod)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StatDownloadPeriodImpl statDownloadPeriodImpl = new StatDownloadPeriodImpl();

		statDownloadPeriodImpl.setId(getId());
		statDownloadPeriodImpl.setItemId(getItemId());
		statDownloadPeriodImpl.setPerMonth(getPerMonth());
		statDownloadPeriodImpl.setPerYear(getPerYear());

		statDownloadPeriodImpl.resetOriginalValues();

		return statDownloadPeriodImpl;
	}

	@Override
	public int compareTo(StatDownloadPeriod statDownloadPeriod) {
		long primaryKey = statDownloadPeriod.getPrimaryKey();

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

		if (!(obj instanceof StatDownloadPeriod)) {
			return false;
		}

		StatDownloadPeriod statDownloadPeriod = (StatDownloadPeriod)obj;

		long primaryKey = statDownloadPeriod.getPrimaryKey();

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
		StatDownloadPeriodModelImpl statDownloadPeriodModelImpl = this;

		statDownloadPeriodModelImpl._originalPerMonth = statDownloadPeriodModelImpl._perMonth;

		statDownloadPeriodModelImpl._setOriginalPerMonth = false;

		statDownloadPeriodModelImpl._originalPerYear = statDownloadPeriodModelImpl._perYear;

		statDownloadPeriodModelImpl._setOriginalPerYear = false;

		statDownloadPeriodModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StatDownloadPeriod> toCacheModel() {
		StatDownloadPeriodCacheModel statDownloadPeriodCacheModel = new StatDownloadPeriodCacheModel();

		statDownloadPeriodCacheModel.id = getId();

		statDownloadPeriodCacheModel.itemId = getItemId();

		statDownloadPeriodCacheModel.perMonth = getPerMonth();

		statDownloadPeriodCacheModel.perYear = getPerYear();

		return statDownloadPeriodCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", perMonth=");
		sb.append(getPerMonth());
		sb.append(", perYear=");
		sb.append(getPerYear());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.StatDownloadPeriod");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perMonth</column-name><column-value><![CDATA[");
		sb.append(getPerMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perYear</column-name><column-value><![CDATA[");
		sb.append(getPerYear());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = StatDownloadPeriod.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StatDownloadPeriod.class
		};
	private long _id;
	private long _itemId;
	private int _perMonth;
	private int _originalPerMonth;
	private boolean _setOriginalPerMonth;
	private int _perYear;
	private int _originalPerYear;
	private boolean _setOriginalPerYear;
	private long _columnBitmask;
	private StatDownloadPeriod _escapedModel;
}