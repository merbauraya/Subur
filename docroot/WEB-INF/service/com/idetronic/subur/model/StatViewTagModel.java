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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the StatViewTag service. Represents a row in the &quot;Subur_StatViewTag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.StatViewTagModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.StatViewTagImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewTag
 * @see com.idetronic.subur.model.impl.StatViewTagImpl
 * @see com.idetronic.subur.model.impl.StatViewTagModelImpl
 * @generated
 */
public interface StatViewTagModel extends BaseModel<StatViewTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stat view tag model instance should use the {@link StatViewTag} interface instead.
	 */

	/**
	 * Returns the primary key of this stat view tag.
	 *
	 * @return the primary key of this stat view tag
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stat view tag.
	 *
	 * @param primaryKey the primary key of this stat view tag
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this stat view tag.
	 *
	 * @return the ID of this stat view tag
	 */
	public long getId();

	/**
	 * Sets the ID of this stat view tag.
	 *
	 * @param id the ID of this stat view tag
	 */
	public void setId(long id);

	/**
	 * Returns the company ID of this stat view tag.
	 *
	 * @return the company ID of this stat view tag
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this stat view tag.
	 *
	 * @param companyId the company ID of this stat view tag
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this stat view tag.
	 *
	 * @return the group ID of this stat view tag
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this stat view tag.
	 *
	 * @param groupId the group ID of this stat view tag
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the per month of this stat view tag.
	 *
	 * @return the per month of this stat view tag
	 */
	public int getPerMonth();

	/**
	 * Sets the per month of this stat view tag.
	 *
	 * @param perMonth the per month of this stat view tag
	 */
	public void setPerMonth(int perMonth);

	/**
	 * Returns the per year of this stat view tag.
	 *
	 * @return the per year of this stat view tag
	 */
	public int getPerYear();

	/**
	 * Sets the per year of this stat view tag.
	 *
	 * @param perYear the per year of this stat view tag
	 */
	public void setPerYear(int perYear);

	/**
	 * Returns the tag ID of this stat view tag.
	 *
	 * @return the tag ID of this stat view tag
	 */
	public long getTagId();

	/**
	 * Sets the tag ID of this stat view tag.
	 *
	 * @param tagId the tag ID of this stat view tag
	 */
	public void setTagId(long tagId);

	/**
	 * Returns the view count of this stat view tag.
	 *
	 * @return the view count of this stat view tag
	 */
	public int getViewCount();

	/**
	 * Sets the view count of this stat view tag.
	 *
	 * @param viewCount the view count of this stat view tag
	 */
	public void setViewCount(int viewCount);

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
	public int compareTo(com.idetronic.subur.model.StatViewTag statViewTag);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.StatViewTag> toCacheModel();

	@Override
	public com.idetronic.subur.model.StatViewTag toEscapedModel();

	@Override
	public com.idetronic.subur.model.StatViewTag toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}