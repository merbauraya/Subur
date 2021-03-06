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

import com.idetronic.subur.model.AuthorExpertise;
import com.idetronic.subur.model.AuthorExpertiseModel;
import com.idetronic.subur.service.persistence.AuthorExpertisePK;

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
 * The base model implementation for the AuthorExpertise service. Represents a row in the &quot;Subur_AuthorExpertise&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.AuthorExpertiseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuthorExpertiseImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorExpertiseImpl
 * @see com.idetronic.subur.model.AuthorExpertise
 * @see com.idetronic.subur.model.AuthorExpertiseModel
 * @generated
 */
public class AuthorExpertiseModelImpl extends BaseModelImpl<AuthorExpertise>
	implements AuthorExpertiseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a author expertise model instance should use the {@link com.idetronic.subur.model.AuthorExpertise} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_AuthorExpertise";
	public static final Object[][] TABLE_COLUMNS = {
			{ "authorId", Types.BIGINT },
			{ "expertiseId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_AuthorExpertise (authorId LONG not null,expertiseId LONG not null,primary key (authorId, expertiseId))";
	public static final String TABLE_SQL_DROP = "drop table Subur_AuthorExpertise";
	public static final String ORDER_BY_JPQL = " ORDER BY authorExpertise.id.authorId ASC, authorExpertise.id.expertiseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_AuthorExpertise.authorId ASC, Subur_AuthorExpertise.expertiseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.AuthorExpertise"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.AuthorExpertise"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.AuthorExpertise"),
			true);
	public static long AUTHORID_COLUMN_BITMASK = 1L;
	public static long EXPERTISEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.AuthorExpertise"));

	public AuthorExpertiseModelImpl() {
	}

	@Override
	public AuthorExpertisePK getPrimaryKey() {
		return new AuthorExpertisePK(_authorId, _expertiseId);
	}

	@Override
	public void setPrimaryKey(AuthorExpertisePK primaryKey) {
		setAuthorId(primaryKey.authorId);
		setExpertiseId(primaryKey.expertiseId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AuthorExpertisePK(_authorId, _expertiseId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AuthorExpertisePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorExpertise.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorExpertise.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("expertiseId", getExpertiseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long expertiseId = (Long)attributes.get("expertiseId");

		if (expertiseId != null) {
			setExpertiseId(expertiseId);
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
	public long getExpertiseId() {
		return _expertiseId;
	}

	@Override
	public void setExpertiseId(long expertiseId) {
		_columnBitmask |= EXPERTISEID_COLUMN_BITMASK;

		if (!_setOriginalExpertiseId) {
			_setOriginalExpertiseId = true;

			_originalExpertiseId = _expertiseId;
		}

		_expertiseId = expertiseId;
	}

	public long getOriginalExpertiseId() {
		return _originalExpertiseId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public AuthorExpertise toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AuthorExpertise)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AuthorExpertiseImpl authorExpertiseImpl = new AuthorExpertiseImpl();

		authorExpertiseImpl.setAuthorId(getAuthorId());
		authorExpertiseImpl.setExpertiseId(getExpertiseId());

		authorExpertiseImpl.resetOriginalValues();

		return authorExpertiseImpl;
	}

	@Override
	public int compareTo(AuthorExpertise authorExpertise) {
		AuthorExpertisePK primaryKey = authorExpertise.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorExpertise)) {
			return false;
		}

		AuthorExpertise authorExpertise = (AuthorExpertise)obj;

		AuthorExpertisePK primaryKey = authorExpertise.getPrimaryKey();

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
		AuthorExpertiseModelImpl authorExpertiseModelImpl = this;

		authorExpertiseModelImpl._originalAuthorId = authorExpertiseModelImpl._authorId;

		authorExpertiseModelImpl._setOriginalAuthorId = false;

		authorExpertiseModelImpl._originalExpertiseId = authorExpertiseModelImpl._expertiseId;

		authorExpertiseModelImpl._setOriginalExpertiseId = false;

		authorExpertiseModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AuthorExpertise> toCacheModel() {
		AuthorExpertiseCacheModel authorExpertiseCacheModel = new AuthorExpertiseCacheModel();

		authorExpertiseCacheModel.authorId = getAuthorId();

		authorExpertiseCacheModel.expertiseId = getExpertiseId();

		return authorExpertiseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(getAuthorId());
		sb.append(", expertiseId=");
		sb.append(getExpertiseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.AuthorExpertise");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertiseId</column-name><column-value><![CDATA[");
		sb.append(getExpertiseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AuthorExpertise.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AuthorExpertise.class
		};
	private long _authorId;
	private long _originalAuthorId;
	private boolean _setOriginalAuthorId;
	private long _expertiseId;
	private long _originalExpertiseId;
	private boolean _setOriginalExpertiseId;
	private long _columnBitmask;
	private AuthorExpertise _escapedModel;
}