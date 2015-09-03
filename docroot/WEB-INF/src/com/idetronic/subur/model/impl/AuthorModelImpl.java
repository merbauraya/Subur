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

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.AuthorModel;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Author service. Represents a row in the &quot;Subur_Author&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.idetronic.subur.model.AuthorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuthorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorImpl
 * @see com.idetronic.subur.model.Author
 * @see com.idetronic.subur.model.AuthorModel
 * @generated
 */
public class AuthorModelImpl extends BaseModelImpl<Author>
	implements AuthorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a author model instance should use the {@link com.idetronic.subur.model.Author} interface instead.
	 */
	public static final String TABLE_NAME = "Subur_Author";
	public static final Object[][] TABLE_COLUMNS = {
			{ "authorId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "idType", Types.INTEGER },
			{ "remoteId", Types.VARCHAR },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "middleName", Types.VARCHAR },
			{ "userId", Types.INTEGER },
			{ "metadata", Types.VARCHAR },
			{ "lastPublishedDate", Types.TIMESTAMP },
			{ "itemCount", Types.INTEGER },
			{ "email", Types.VARCHAR },
			{ "officeNo", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "Uuid", Types.VARCHAR },
			{ "createdBy", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Subur_Author (authorId LONG not null primary key,groupId LONG,companyId LONG,title VARCHAR(75) null,idType INTEGER,remoteId VARCHAR(75) null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,middleName VARCHAR(75) null,userId INTEGER,metadata VARCHAR(75) null,lastPublishedDate DATE null,itemCount INTEGER,email VARCHAR(75) null,officeNo VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,Uuid VARCHAR(75) null,createdBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table Subur_Author";
	public static final String ORDER_BY_JPQL = " ORDER BY author.authorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Subur_Author.authorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.idetronic.subur.model.Author"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.idetronic.subur.model.Author"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.idetronic.subur.model.Author"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long FIRSTNAME_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long IDTYPE_COLUMN_BITMASK = 8L;
	public static long LASTNAME_COLUMN_BITMASK = 16L;
	public static long AUTHORID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.idetronic.subur.model.Author"));

	public AuthorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _authorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAuthorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _authorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Author.class;
	}

	@Override
	public String getModelClassName() {
		return Author.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("title", getTitle());
		attributes.put("idType", getIdType());
		attributes.put("remoteId", getRemoteId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("userId", getUserId());
		attributes.put("metadata", getMetadata());
		attributes.put("lastPublishedDate", getLastPublishedDate());
		attributes.put("itemCount", getItemCount());
		attributes.put("email", getEmail());
		attributes.put("officeNo", getOfficeNo());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Uuid", getUuid());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer idType = (Integer)attributes.get("idType");

		if (idType != null) {
			setIdType(idType);
		}

		String remoteId = (String)attributes.get("remoteId");

		if (remoteId != null) {
			setRemoteId(remoteId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		Integer userId = (Integer)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		Date lastPublishedDate = (Date)attributes.get("lastPublishedDate");

		if (lastPublishedDate != null) {
			setLastPublishedDate(lastPublishedDate);
		}

		Integer itemCount = (Integer)attributes.get("itemCount");

		if (itemCount != null) {
			setItemCount(itemCount);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String officeNo = (String)attributes.get("officeNo");

		if (officeNo != null) {
			setOfficeNo(officeNo);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String Uuid = (String)attributes.get("Uuid");

		if (Uuid != null) {
			setUuid(Uuid);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public int getIdType() {
		return _idType;
	}

	@Override
	public void setIdType(int idType) {
		_columnBitmask |= IDTYPE_COLUMN_BITMASK;

		if (!_setOriginalIdType) {
			_setOriginalIdType = true;

			_originalIdType = _idType;
		}

		_idType = idType;
	}

	public int getOriginalIdType() {
		return _originalIdType;
	}

	@Override
	public String getRemoteId() {
		if (_remoteId == null) {
			return StringPool.BLANK;
		}
		else {
			return _remoteId;
		}
	}

	@Override
	public void setRemoteId(String remoteId) {
		_remoteId = remoteId;
	}

	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_columnBitmask |= FIRSTNAME_COLUMN_BITMASK;

		if (_originalFirstName == null) {
			_originalFirstName = _firstName;
		}

		_firstName = firstName;
	}

	public String getOriginalFirstName() {
		return GetterUtil.getString(_originalFirstName);
	}

	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_columnBitmask |= LASTNAME_COLUMN_BITMASK;

		if (_originalLastName == null) {
			_originalLastName = _lastName;
		}

		_lastName = lastName;
	}

	public String getOriginalLastName() {
		return GetterUtil.getString(_originalLastName);
	}

	@Override
	public String getMiddleName() {
		if (_middleName == null) {
			return StringPool.BLANK;
		}
		else {
			return _middleName;
		}
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	@Override
	public int getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(int userId) {
		_userId = userId;
	}

	@Override
	public String getMetadata() {
		if (_metadata == null) {
			return StringPool.BLANK;
		}
		else {
			return _metadata;
		}
	}

	@Override
	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	@Override
	public Date getLastPublishedDate() {
		return _lastPublishedDate;
	}

	@Override
	public void setLastPublishedDate(Date lastPublishedDate) {
		_lastPublishedDate = lastPublishedDate;
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
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getOfficeNo() {
		if (_officeNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _officeNo;
		}
	}

	@Override
	public void setOfficeNo(String officeNo) {
		_officeNo = officeNo;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getUuid() {
		if (_Uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _Uuid;
		}
	}

	@Override
	public void setUuid(String Uuid) {
		_Uuid = Uuid;
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Author.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Author toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Author)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(getAuthorId());
		authorImpl.setGroupId(getGroupId());
		authorImpl.setCompanyId(getCompanyId());
		authorImpl.setTitle(getTitle());
		authorImpl.setIdType(getIdType());
		authorImpl.setRemoteId(getRemoteId());
		authorImpl.setFirstName(getFirstName());
		authorImpl.setLastName(getLastName());
		authorImpl.setMiddleName(getMiddleName());
		authorImpl.setUserId(getUserId());
		authorImpl.setMetadata(getMetadata());
		authorImpl.setLastPublishedDate(getLastPublishedDate());
		authorImpl.setItemCount(getItemCount());
		authorImpl.setEmail(getEmail());
		authorImpl.setOfficeNo(getOfficeNo());
		authorImpl.setCreateDate(getCreateDate());
		authorImpl.setModifiedDate(getModifiedDate());
		authorImpl.setUuid(getUuid());
		authorImpl.setCreatedBy(getCreatedBy());

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	@Override
	public int compareTo(Author author) {
		long primaryKey = author.getPrimaryKey();

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

		if (!(obj instanceof Author)) {
			return false;
		}

		Author author = (Author)obj;

		long primaryKey = author.getPrimaryKey();

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
		AuthorModelImpl authorModelImpl = this;

		authorModelImpl._originalGroupId = authorModelImpl._groupId;

		authorModelImpl._setOriginalGroupId = false;

		authorModelImpl._originalCompanyId = authorModelImpl._companyId;

		authorModelImpl._setOriginalCompanyId = false;

		authorModelImpl._originalIdType = authorModelImpl._idType;

		authorModelImpl._setOriginalIdType = false;

		authorModelImpl._originalFirstName = authorModelImpl._firstName;

		authorModelImpl._originalLastName = authorModelImpl._lastName;

		authorModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Author> toCacheModel() {
		AuthorCacheModel authorCacheModel = new AuthorCacheModel();

		authorCacheModel.authorId = getAuthorId();

		authorCacheModel.groupId = getGroupId();

		authorCacheModel.companyId = getCompanyId();

		authorCacheModel.title = getTitle();

		String title = authorCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			authorCacheModel.title = null;
		}

		authorCacheModel.idType = getIdType();

		authorCacheModel.remoteId = getRemoteId();

		String remoteId = authorCacheModel.remoteId;

		if ((remoteId != null) && (remoteId.length() == 0)) {
			authorCacheModel.remoteId = null;
		}

		authorCacheModel.firstName = getFirstName();

		String firstName = authorCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			authorCacheModel.firstName = null;
		}

		authorCacheModel.lastName = getLastName();

		String lastName = authorCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			authorCacheModel.lastName = null;
		}

		authorCacheModel.middleName = getMiddleName();

		String middleName = authorCacheModel.middleName;

		if ((middleName != null) && (middleName.length() == 0)) {
			authorCacheModel.middleName = null;
		}

		authorCacheModel.userId = getUserId();

		authorCacheModel.metadata = getMetadata();

		String metadata = authorCacheModel.metadata;

		if ((metadata != null) && (metadata.length() == 0)) {
			authorCacheModel.metadata = null;
		}

		Date lastPublishedDate = getLastPublishedDate();

		if (lastPublishedDate != null) {
			authorCacheModel.lastPublishedDate = lastPublishedDate.getTime();
		}
		else {
			authorCacheModel.lastPublishedDate = Long.MIN_VALUE;
		}

		authorCacheModel.itemCount = getItemCount();

		authorCacheModel.email = getEmail();

		String email = authorCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			authorCacheModel.email = null;
		}

		authorCacheModel.officeNo = getOfficeNo();

		String officeNo = authorCacheModel.officeNo;

		if ((officeNo != null) && (officeNo.length() == 0)) {
			authorCacheModel.officeNo = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			authorCacheModel.createDate = createDate.getTime();
		}
		else {
			authorCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			authorCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			authorCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		authorCacheModel.Uuid = getUuid();

		String Uuid = authorCacheModel.Uuid;

		if ((Uuid != null) && (Uuid.length() == 0)) {
			authorCacheModel.Uuid = null;
		}

		authorCacheModel.createdBy = getCreatedBy();

		return authorCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{authorId=");
		sb.append(getAuthorId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", idType=");
		sb.append(getIdType());
		sb.append(", remoteId=");
		sb.append(getRemoteId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", metadata=");
		sb.append(getMetadata());
		sb.append(", lastPublishedDate=");
		sb.append(getLastPublishedDate());
		sb.append(", itemCount=");
		sb.append(getItemCount());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", officeNo=");
		sb.append(getOfficeNo());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", Uuid=");
		sb.append(getUuid());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.idetronic.subur.model.Author");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idType</column-name><column-value><![CDATA[");
		sb.append(getIdType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteId</column-name><column-value><![CDATA[");
		sb.append(getRemoteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadata</column-name><column-value><![CDATA[");
		sb.append(getMetadata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishedDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCount</column-name><column-value><![CDATA[");
		sb.append(getItemCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeNo</column-name><column-value><![CDATA[");
		sb.append(getOfficeNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Author.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Author.class };
	private long _authorId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _title;
	private int _idType;
	private int _originalIdType;
	private boolean _setOriginalIdType;
	private String _remoteId;
	private String _firstName;
	private String _originalFirstName;
	private String _lastName;
	private String _originalLastName;
	private String _middleName;
	private int _userId;
	private String _metadata;
	private Date _lastPublishedDate;
	private int _itemCount;
	private String _email;
	private String _officeNo;
	private Date _createDate;
	private Date _modifiedDate;
	private String _Uuid;
	private long _createdBy;
	private long _columnBitmask;
	private Author _escapedModel;
}