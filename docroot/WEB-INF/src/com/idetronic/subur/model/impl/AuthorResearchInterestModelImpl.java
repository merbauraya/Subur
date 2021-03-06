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

import com.idetronic.subur.model.AuthorResearchInterest;
import com.idetronic.subur.model.AuthorResearchInterestModel;
import com.idetronic.subur.service.persistence.AuthorResearchInterestPK;

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
 * The base model implementation for the AuthorResearchInterest service. Represents a row in the &quot;Subur_AuthorResearchInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.AuthorResearchInterestModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuthorResearchInterestImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorResearchInterestImpl
 * @see com.idetronic.subur.model.AuthorResearchInterest
 * @see com.idetronic.subur.model.AuthorResearchInterestModel
 * @generated
 */
public class AuthorResearchInterestModelImpl extends BaseModelImpl<AuthorResearchInterest>
	implements AuthorResearchInterestModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a author research interest model instance should use the {@link com.idetronic.subur.model.AuthorResearchInterest} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_AuthorResearchInterest";
	public static final Object[][] TABLE_COLUMNS = {
			{ "authorId", Types.BIGINT },
			{ "researchInterestId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_AuthorResearchInterest (authorId LONG not null,researchInterestId LONG not null,primary key (authorId, researchInterestId))";
	public static final String TABLE_SQL_DROP = "drop table Subur_AuthorResearchInterest";
	public static final String ORDER_BY_JPQL = " ORDER BY authorResearchInterest.id.authorId ASC, authorResearchInterest.id.researchInterestId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_AuthorResearchInterest.authorId ASC, Subur_AuthorResearchInterest.researchInterestId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.AuthorResearchInterest"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.AuthorResearchInterest"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.AuthorResearchInterest"),
			true);
	public static long AUTHORID_COLUMN_BITMASK = 1L;
	public static long RESEARCHINTERESTID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.AuthorResearchInterest"));

	public AuthorResearchInterestModelImpl() {
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
	public Class<?> getModelClass() {
		return AuthorResearchInterest.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorResearchInterest.class.getName();
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

	@Override
	public long getResearchInterestId() {
		return _researchInterestId;
	}

	@Override
	public void setResearchInterestId(long researchInterestId) {
		_columnBitmask |= RESEARCHINTERESTID_COLUMN_BITMASK;

		if (!_setOriginalResearchInterestId) {
			_setOriginalResearchInterestId = true;

			_originalResearchInterestId = _researchInterestId;
		}

		_researchInterestId = researchInterestId;
	}

	public long getOriginalResearchInterestId() {
		return _originalResearchInterestId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public AuthorResearchInterest toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AuthorResearchInterest)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AuthorResearchInterestImpl authorResearchInterestImpl = new AuthorResearchInterestImpl();

		authorResearchInterestImpl.setAuthorId(getAuthorId());
		authorResearchInterestImpl.setResearchInterestId(getResearchInterestId());

		authorResearchInterestImpl.resetOriginalValues();

		return authorResearchInterestImpl;
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

		if (!(obj instanceof AuthorResearchInterest)) {
			return false;
		}

		AuthorResearchInterest authorResearchInterest = (AuthorResearchInterest)obj;

		AuthorResearchInterestPK primaryKey = authorResearchInterest.getPrimaryKey();

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
		AuthorResearchInterestModelImpl authorResearchInterestModelImpl = this;

		authorResearchInterestModelImpl._originalAuthorId = authorResearchInterestModelImpl._authorId;

		authorResearchInterestModelImpl._setOriginalAuthorId = false;

		authorResearchInterestModelImpl._originalResearchInterestId = authorResearchInterestModelImpl._researchInterestId;

		authorResearchInterestModelImpl._setOriginalResearchInterestId = false;

		authorResearchInterestModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AuthorResearchInterest> toCacheModel() {
		AuthorResearchInterestCacheModel authorResearchInterestCacheModel = new AuthorResearchInterestCacheModel();

		authorResearchInterestCacheModel.authorId = getAuthorId();

		authorResearchInterestCacheModel.researchInterestId = getResearchInterestId();

		return authorResearchInterestCacheModel;
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

	private static ClassLoader _classLoader = AuthorResearchInterest.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AuthorResearchInterest.class
		};
	private long _authorId;
	private long _originalAuthorId;
	private boolean _setOriginalAuthorId;
	private long _researchInterestId;
	private long _originalResearchInterestId;
	private boolean _setOriginalResearchInterestId;
	private long _columnBitmask;
	private AuthorResearchInterest _escapedModel;
}