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

import com.idetronic.subur.model.ItemAuthor;
import com.idetronic.subur.model.ItemAuthorModel;
import com.idetronic.subur.service.persistence.ItemAuthorPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ItemAuthor service. Represents a row in the &quot;Subur_ItemAuthor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.ItemAuthorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ItemAuthorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemAuthorImpl
 * @see com.idetronic.subur.model.ItemAuthor
 * @see com.idetronic.subur.model.ItemAuthorModel
 * @generated
 */
public class ItemAuthorModelImpl extends BaseModelImpl<ItemAuthor>
	implements ItemAuthorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a item author model instance should use the {@link com.idetronic.subur.model.ItemAuthor} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_ItemAuthor";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemId", Types.BIGINT },
			{ "authorId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_ItemAuthor (itemId LONG not null,authorId LONG not null,primary key (itemId, authorId))";
	public static final String TABLE_SQL_DROP = "drop table Subur_ItemAuthor";
	public static final String ORDER_BY_JPQL = " ORDER BY itemAuthor.id.itemId ASC, itemAuthor.id.authorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_ItemAuthor.itemId ASC, Subur_ItemAuthor.authorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.ItemAuthor"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.ItemAuthor"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.ItemAuthor"),
			true);
	public static long AUTHORID_COLUMN_BITMASK = 1L;
	public static long ITEMID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.ItemAuthor"));

	public ItemAuthorModelImpl() {
	}

	@Override
	public ItemAuthorPK getPrimaryKey() {
		return new ItemAuthorPK(_itemId, _authorId);
	}

	@Override
	public void setPrimaryKey(ItemAuthorPK primaryKey) {
		setItemId(primaryKey.itemId);
		setAuthorId(primaryKey.authorId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ItemAuthorPK(_itemId, _authorId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ItemAuthorPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ItemAuthor.class;
	}

	@Override
	public String getModelClassName() {
		return ItemAuthor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("authorId", getAuthorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}
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
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_columnBitmask |= AUTHORID_COLUMN_BITMASK;

		if (!_setOriginalAuthorId) {
			_setOriginalAuthorId = true;

			_originalAuthorId = _authorId;
		}

		_authorId = authorId;
	}

	public long getOriginalAuthorId() {
		return _originalAuthorId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ItemAuthor toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ItemAuthor)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ItemAuthorImpl itemAuthorImpl = new ItemAuthorImpl();

		itemAuthorImpl.setItemId(getItemId());
		itemAuthorImpl.setAuthorId(getAuthorId());

		itemAuthorImpl.resetOriginalValues();

		return itemAuthorImpl;
	}

	@Override
	public int compareTo(ItemAuthor itemAuthor) {
		ItemAuthorPK primaryKey = itemAuthor.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ItemAuthor)) {
			return false;
		}

		ItemAuthor itemAuthor = (ItemAuthor)obj;

		ItemAuthorPK primaryKey = itemAuthor.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		ItemAuthorModelImpl itemAuthorModelImpl = this;

		itemAuthorModelImpl._originalItemId = itemAuthorModelImpl._itemId;

		itemAuthorModelImpl._setOriginalItemId = false;

		itemAuthorModelImpl._originalAuthorId = itemAuthorModelImpl._authorId;

		itemAuthorModelImpl._setOriginalAuthorId = false;

		itemAuthorModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ItemAuthor> toCacheModel() {
		ItemAuthorCacheModel itemAuthorCacheModel = new ItemAuthorCacheModel();

		itemAuthorCacheModel.itemId = getItemId();

		itemAuthorCacheModel.authorId = getAuthorId();

		return itemAuthorCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{itemId=");
		sb.append(getItemId());
		sb.append(", authorId=");
		sb.append(getAuthorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.ItemAuthor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ItemAuthor.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ItemAuthor.class
		};
	private long _itemId;
	private long _originalItemId;
	private boolean _setOriginalItemId;
	private long _authorId;
	private long _originalAuthorId;
	private boolean _setOriginalAuthorId;
	private long _columnBitmask;
	private ItemAuthor _escapedModel;
}