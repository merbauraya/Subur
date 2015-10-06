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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SuburItem}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburItem
 * @generated
 */
public class SuburItemWrapper implements SuburItem, ModelWrapper<SuburItem> {
	public SuburItemWrapper(SuburItem suburItem) {
		_suburItem = suburItem;
	}

	@Override
	public Class<?> getModelClass() {
		return SuburItem.class;
	}

	@Override
	public String getModelClassName() {
		return SuburItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishedDate", getPublishedDate());
		attributes.put("title", getTitle());
		attributes.put("itemAbstract", getItemAbstract());
		attributes.put("language", getLanguage());
		attributes.put("status", getStatus());
		attributes.put("Uuid", getUuid());
		attributes.put("metadataValue", getMetadataValue());
		attributes.put("relatedRestricted", getRelatedRestricted());
		attributes.put("photoCoverId", getPhotoCoverId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishedDate = (Date)attributes.get("publishedDate");

		if (publishedDate != null) {
			setPublishedDate(publishedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String itemAbstract = (String)attributes.get("itemAbstract");

		if (itemAbstract != null) {
			setItemAbstract(itemAbstract);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String Uuid = (String)attributes.get("Uuid");

		if (Uuid != null) {
			setUuid(Uuid);
		}

		String metadataValue = (String)attributes.get("metadataValue");

		if (metadataValue != null) {
			setMetadataValue(metadataValue);
		}

		Boolean relatedRestricted = (Boolean)attributes.get("relatedRestricted");

		if (relatedRestricted != null) {
			setRelatedRestricted(relatedRestricted);
		}

		Long photoCoverId = (Long)attributes.get("photoCoverId");

		if (photoCoverId != null) {
			setPhotoCoverId(photoCoverId);
		}
	}

	/**
	* Returns the primary key of this subur item.
	*
	* @return the primary key of this subur item
	*/
	@Override
	public long getPrimaryKey() {
		return _suburItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subur item.
	*
	* @param primaryKey the primary key of this subur item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_suburItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this subur item.
	*
	* @return the item ID of this subur item
	*/
	@Override
	public long getItemId() {
		return _suburItem.getItemId();
	}

	/**
	* Sets the item ID of this subur item.
	*
	* @param itemId the item ID of this subur item
	*/
	@Override
	public void setItemId(long itemId) {
		_suburItem.setItemId(itemId);
	}

	/**
	* Returns the company ID of this subur item.
	*
	* @return the company ID of this subur item
	*/
	@Override
	public long getCompanyId() {
		return _suburItem.getCompanyId();
	}

	/**
	* Sets the company ID of this subur item.
	*
	* @param companyId the company ID of this subur item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_suburItem.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this subur item.
	*
	* @return the group ID of this subur item
	*/
	@Override
	public long getGroupId() {
		return _suburItem.getGroupId();
	}

	/**
	* Sets the group ID of this subur item.
	*
	* @param groupId the group ID of this subur item
	*/
	@Override
	public void setGroupId(long groupId) {
		_suburItem.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this subur item.
	*
	* @return the user ID of this subur item
	*/
	@Override
	public long getUserId() {
		return _suburItem.getUserId();
	}

	/**
	* Sets the user ID of this subur item.
	*
	* @param userId the user ID of this subur item
	*/
	@Override
	public void setUserId(long userId) {
		_suburItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this subur item.
	*
	* @return the user uuid of this subur item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this subur item.
	*
	* @param userUuid the user uuid of this subur item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_suburItem.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this subur item.
	*
	* @return the user name of this subur item
	*/
	@Override
	public java.lang.String getUserName() {
		return _suburItem.getUserName();
	}

	/**
	* Sets the user name of this subur item.
	*
	* @param userName the user name of this subur item
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_suburItem.setUserName(userName);
	}

	/**
	* Returns the create date of this subur item.
	*
	* @return the create date of this subur item
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _suburItem.getCreateDate();
	}

	/**
	* Sets the create date of this subur item.
	*
	* @param createDate the create date of this subur item
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_suburItem.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this subur item.
	*
	* @return the modified date of this subur item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _suburItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this subur item.
	*
	* @param modifiedDate the modified date of this subur item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_suburItem.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the published date of this subur item.
	*
	* @return the published date of this subur item
	*/
	@Override
	public java.util.Date getPublishedDate() {
		return _suburItem.getPublishedDate();
	}

	/**
	* Sets the published date of this subur item.
	*
	* @param publishedDate the published date of this subur item
	*/
	@Override
	public void setPublishedDate(java.util.Date publishedDate) {
		_suburItem.setPublishedDate(publishedDate);
	}

	/**
	* Returns the title of this subur item.
	*
	* @return the title of this subur item
	*/
	@Override
	public java.lang.String getTitle() {
		return _suburItem.getTitle();
	}

	/**
	* Sets the title of this subur item.
	*
	* @param title the title of this subur item
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_suburItem.setTitle(title);
	}

	/**
	* Returns the item abstract of this subur item.
	*
	* @return the item abstract of this subur item
	*/
	@Override
	public java.lang.String getItemAbstract() {
		return _suburItem.getItemAbstract();
	}

	/**
	* Sets the item abstract of this subur item.
	*
	* @param itemAbstract the item abstract of this subur item
	*/
	@Override
	public void setItemAbstract(java.lang.String itemAbstract) {
		_suburItem.setItemAbstract(itemAbstract);
	}

	/**
	* Returns the language of this subur item.
	*
	* @return the language of this subur item
	*/
	@Override
	public java.lang.String getLanguage() {
		return _suburItem.getLanguage();
	}

	/**
	* Sets the language of this subur item.
	*
	* @param language the language of this subur item
	*/
	@Override
	public void setLanguage(java.lang.String language) {
		_suburItem.setLanguage(language);
	}

	/**
	* Returns the status of this subur item.
	*
	* @return the status of this subur item
	*/
	@Override
	public int getStatus() {
		return _suburItem.getStatus();
	}

	/**
	* Sets the status of this subur item.
	*
	* @param status the status of this subur item
	*/
	@Override
	public void setStatus(int status) {
		_suburItem.setStatus(status);
	}

	/**
	* Returns the uuid of this subur item.
	*
	* @return the uuid of this subur item
	*/
	@Override
	public java.lang.String getUuid() {
		return _suburItem.getUuid();
	}

	/**
	* Sets the uuid of this subur item.
	*
	* @param Uuid the uuid of this subur item
	*/
	@Override
	public void setUuid(java.lang.String Uuid) {
		_suburItem.setUuid(Uuid);
	}

	/**
	* Returns the metadata value of this subur item.
	*
	* @return the metadata value of this subur item
	*/
	@Override
	public java.lang.String getMetadataValue() {
		return _suburItem.getMetadataValue();
	}

	/**
	* Sets the metadata value of this subur item.
	*
	* @param metadataValue the metadata value of this subur item
	*/
	@Override
	public void setMetadataValue(java.lang.String metadataValue) {
		_suburItem.setMetadataValue(metadataValue);
	}

	/**
	* Returns the related restricted of this subur item.
	*
	* @return the related restricted of this subur item
	*/
	@Override
	public boolean getRelatedRestricted() {
		return _suburItem.getRelatedRestricted();
	}

	/**
	* Returns <code>true</code> if this subur item is related restricted.
	*
	* @return <code>true</code> if this subur item is related restricted; <code>false</code> otherwise
	*/
	@Override
	public boolean isRelatedRestricted() {
		return _suburItem.isRelatedRestricted();
	}

	/**
	* Sets whether this subur item is related restricted.
	*
	* @param relatedRestricted the related restricted of this subur item
	*/
	@Override
	public void setRelatedRestricted(boolean relatedRestricted) {
		_suburItem.setRelatedRestricted(relatedRestricted);
	}

	/**
	* Returns the photo cover ID of this subur item.
	*
	* @return the photo cover ID of this subur item
	*/
	@Override
	public long getPhotoCoverId() {
		return _suburItem.getPhotoCoverId();
	}

	/**
	* Sets the photo cover ID of this subur item.
	*
	* @param photoCoverId the photo cover ID of this subur item
	*/
	@Override
	public void setPhotoCoverId(long photoCoverId) {
		_suburItem.setPhotoCoverId(photoCoverId);
	}

	@Override
	public boolean isNew() {
		return _suburItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_suburItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _suburItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_suburItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _suburItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _suburItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_suburItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _suburItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_suburItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_suburItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_suburItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SuburItemWrapper((SuburItem)_suburItem.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.SuburItem suburItem) {
		return _suburItem.compareTo(suburItem);
	}

	@Override
	public int hashCode() {
		return _suburItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.SuburItem> toCacheModel() {
		return _suburItem.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.SuburItem toEscapedModel() {
		return new SuburItemWrapper(_suburItem.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.SuburItem toUnescapedModel() {
		return new SuburItemWrapper(_suburItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _suburItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _suburItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_suburItem.persist();
	}

	@Override
	public void setSeriesReportNo(
		java.util.Map<java.lang.String, java.lang.String> entryMap) {
		_suburItem.setSeriesReportNo(entryMap);
	}

	@Override
	public void setIdentifier(
		java.util.Map<java.lang.String, java.lang.String> identifierMap) {
		_suburItem.setIdentifier(identifierMap);
	}

	@Override
	public void setOtherTitle(java.lang.String[] otherTitle) {
		_suburItem.setOtherTitle(otherTitle);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getIdentifiers()
		throws java.io.IOException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return _suburItem.getIdentifiers();
	}

	@Override
	public java.util.Map getSeriesReportNo()
		throws java.io.IOException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return _suburItem.getSeriesReportNo();
	}

	@Override
	public java.lang.String[] getOtherTitles()
		throws java.io.IOException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return _suburItem.getOtherTitles();
	}

	@Override
	public java.lang.String getSearchDescription() {
		return _suburItem.getSearchDescription();
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ItemType> getItemTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburItem.getItemTypes();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SuburItemWrapper)) {
			return false;
		}

		SuburItemWrapper suburItemWrapper = (SuburItemWrapper)obj;

		if (Validator.equals(_suburItem, suburItemWrapper._suburItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SuburItem getWrappedSuburItem() {
		return _suburItem;
	}

	@Override
	public SuburItem getWrappedModel() {
		return _suburItem;
	}

	@Override
	public void resetOriginalValues() {
		_suburItem.resetOriginalValues();
	}

	private SuburItem _suburItem;
}