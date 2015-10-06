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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SuburItem service. Represents a row in the &quot;Subur_Item&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.SuburItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.SuburItemImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburItem
 * @see com.idetronic.subur.model.impl.SuburItemImpl
 * @see com.idetronic.subur.model.impl.SuburItemModelImpl
 * @generated
 */
public interface SuburItemModel extends BaseModel<SuburItem>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a subur item model instance should use the {@link SuburItem} interface instead.
	 */

	/**
	 * Returns the primary key of this subur item.
	 *
	 * @return the primary key of this subur item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this subur item.
	 *
	 * @param primaryKey the primary key of this subur item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the item ID of this subur item.
	 *
	 * @return the item ID of this subur item
	 */
	public long getItemId();

	/**
	 * Sets the item ID of this subur item.
	 *
	 * @param itemId the item ID of this subur item
	 */
	public void setItemId(long itemId);

	/**
	 * Returns the company ID of this subur item.
	 *
	 * @return the company ID of this subur item
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this subur item.
	 *
	 * @param companyId the company ID of this subur item
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this subur item.
	 *
	 * @return the group ID of this subur item
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this subur item.
	 *
	 * @param groupId the group ID of this subur item
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this subur item.
	 *
	 * @return the user ID of this subur item
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this subur item.
	 *
	 * @param userId the user ID of this subur item
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this subur item.
	 *
	 * @return the user uuid of this subur item
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this subur item.
	 *
	 * @param userUuid the user uuid of this subur item
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this subur item.
	 *
	 * @return the user name of this subur item
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this subur item.
	 *
	 * @param userName the user name of this subur item
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this subur item.
	 *
	 * @return the create date of this subur item
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this subur item.
	 *
	 * @param createDate the create date of this subur item
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this subur item.
	 *
	 * @return the modified date of this subur item
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this subur item.
	 *
	 * @param modifiedDate the modified date of this subur item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the published date of this subur item.
	 *
	 * @return the published date of this subur item
	 */
	public Date getPublishedDate();

	/**
	 * Sets the published date of this subur item.
	 *
	 * @param publishedDate the published date of this subur item
	 */
	public void setPublishedDate(Date publishedDate);

	/**
	 * Returns the title of this subur item.
	 *
	 * @return the title of this subur item
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this subur item.
	 *
	 * @param title the title of this subur item
	 */
	public void setTitle(String title);

	/**
	 * Returns the item abstract of this subur item.
	 *
	 * @return the item abstract of this subur item
	 */
	@AutoEscape
	public String getItemAbstract();

	/**
	 * Sets the item abstract of this subur item.
	 *
	 * @param itemAbstract the item abstract of this subur item
	 */
	public void setItemAbstract(String itemAbstract);

	/**
	 * Returns the language of this subur item.
	 *
	 * @return the language of this subur item
	 */
	@AutoEscape
	public String getLanguage();

	/**
	 * Sets the language of this subur item.
	 *
	 * @param language the language of this subur item
	 */
	public void setLanguage(String language);

	/**
	 * Returns the status of this subur item.
	 *
	 * @return the status of this subur item
	 */
	public int getStatus();

	/**
	 * Sets the status of this subur item.
	 *
	 * @param status the status of this subur item
	 */
	public void setStatus(int status);

	/**
	 * Returns the uuid of this subur item.
	 *
	 * @return the uuid of this subur item
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this subur item.
	 *
	 * @param Uuid the uuid of this subur item
	 */
	public void setUuid(String Uuid);

	/**
	 * Returns the metadata value of this subur item.
	 *
	 * @return the metadata value of this subur item
	 */
	@AutoEscape
	public String getMetadataValue();

	/**
	 * Sets the metadata value of this subur item.
	 *
	 * @param metadataValue the metadata value of this subur item
	 */
	public void setMetadataValue(String metadataValue);

	/**
	 * Returns the related restricted of this subur item.
	 *
	 * @return the related restricted of this subur item
	 */
	public boolean getRelatedRestricted();

	/**
	 * Returns <code>true</code> if this subur item is related restricted.
	 *
	 * @return <code>true</code> if this subur item is related restricted; <code>false</code> otherwise
	 */
	public boolean isRelatedRestricted();

	/**
	 * Sets whether this subur item is related restricted.
	 *
	 * @param relatedRestricted the related restricted of this subur item
	 */
	public void setRelatedRestricted(boolean relatedRestricted);

	/**
	 * Returns the photo cover ID of this subur item.
	 *
	 * @return the photo cover ID of this subur item
	 */
	public long getPhotoCoverId();

	/**
	 * Sets the photo cover ID of this subur item.
	 *
	 * @param photoCoverId the photo cover ID of this subur item
	 */
	public void setPhotoCoverId(long photoCoverId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.idetronic.subur.model.SuburItem suburItem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.SuburItem> toCacheModel();

	@Override
	public com.idetronic.subur.model.SuburItem toEscapedModel();

	@Override
	public com.idetronic.subur.model.SuburItem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}