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

import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.model.ItemTypeModel;

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
 * The base model implementation for the ItemType service. Represents a row in the &quot;Subur_ItemType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.ItemTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ItemTypeImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemTypeImpl
 * @see com.idetronic.subur.model.ItemType
 * @see com.idetronic.subur.model.ItemTypeModel
 * @generated
 */
public class ItemTypeModelImpl extends BaseModelImpl<ItemType>
	implements ItemTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a item type model instance should use the {@link com.idetronic.subur.model.ItemType} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_ItemType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ItemTypeId", Types.BIGINT },
			{ "ItemTypeName", Types.VARCHAR },
			{ "itemCount", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_ItemType (ItemTypeId LONG not null primary key,ItemTypeName VARCHAR(75) null,itemCount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Subur_ItemType";
	public static final String ORDER_BY_JPQL = " ORDER BY itemType.ItemTypeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_ItemType.ItemTypeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.ItemType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.ItemType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.ItemType"));

	public ItemTypeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ItemTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ItemTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ItemType.class;
	}

	@Override
	public String getModelClassName() {
		return ItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ItemTypeId", getItemTypeId());
		attributes.put("ItemTypeName", getItemTypeName());
		attributes.put("itemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ItemTypeId = (Long)attributes.get("ItemTypeId");

		if (ItemTypeId != null) {
			setItemTypeId(ItemTypeId);
		}

		String ItemTypeName = (String)attributes.get("ItemTypeName");

		if (ItemTypeName != null) {
			setItemTypeName(ItemTypeName);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}
	}

	@Override
	public long getItemTypeId() {
		return _ItemTypeId;
	}

	@Override
	public void setItemTypeId(long ItemTypeId) {
		_ItemTypeId = ItemTypeId;
	}

	@Override
	public String getItemTypeName() {
		if (_ItemTypeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _ItemTypeName;
		}
	}

	@Override
	public void setItemTypeName(String ItemTypeName) {
		_ItemTypeName = ItemTypeName;
	}

	@Override
	public int getItemCount() {
		return _itemCount;
	}

	@Override
	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ItemType.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ItemType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ItemType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ItemTypeImpl itemTypeImpl = new ItemTypeImpl();

		itemTypeImpl.setItemTypeId(getItemTypeId());
		itemTypeImpl.setItemTypeName(getItemTypeName());
		itemTypeImpl.setItemCount(getItemCount());

		itemTypeImpl.resetOriginalValues();

		return itemTypeImpl;
	}

	@Override
	public int compareTo(ItemType itemType) {
		long primaryKey = itemType.getPrimaryKey();

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

		if (!(obj instanceof ItemType)) {
			return false;
		}

		ItemType itemType = (ItemType)obj;

		long primaryKey = itemType.getPrimaryKey();

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
	}

	@Override
	public CacheModel<ItemType> toCacheModel() {
		ItemTypeCacheModel itemTypeCacheModel = new ItemTypeCacheModel();

		itemTypeCacheModel.ItemTypeId = getItemTypeId();

		itemTypeCacheModel.ItemTypeName = getItemTypeName();

		String ItemTypeName = itemTypeCacheModel.ItemTypeName;

		if ((ItemTypeName != null) && (ItemTypeName.length() == 0)) {
			itemTypeCacheModel.ItemTypeName = null;
		}

		itemTypeCacheModel.itemCount = getItemCount();

		return itemTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ItemTypeId=");
		sb.append(getItemTypeId());
		sb.append(", ItemTypeName=");
		sb.append(getItemTypeName());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ItemTypeId</column-name><column-value><![CDATA[");
		sb.append(getItemTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ItemTypeName</column-name><column-value><![CDATA[");
		sb.append(getItemTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ItemType.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ItemType.class
		};
	private long _ItemTypeId;
	private String _ItemTypeName;
	private int _itemCount;
	private ItemType _escapedModel;
}