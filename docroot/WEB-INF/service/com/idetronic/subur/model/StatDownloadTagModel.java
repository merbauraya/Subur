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
 * The base model interface for the StatDownloadTag service. Represents a row in the &quot;Subur_StatDownloadTag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.StatDownloadTagModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.StatDownloadTagImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadTag
 * @see com.idetronic.subur.model.impl.StatDownloadTagImpl
 * @see com.idetronic.subur.model.impl.StatDownloadTagModelImpl
 * @generated
 */
public interface StatDownloadTagModel extends BaseModel<StatDownloadTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stat download tag model instance should use the {@link StatDownloadTag} interface instead.
	 */

	/**
	 * Returns the primary key of this stat download tag.
	 *
	 * @return the primary key of this stat download tag
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stat download tag.
	 *
	 * @param primaryKey the primary key of this stat download tag
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this stat download tag.
	 *
	 * @return the ID of this stat download tag
	 */
	public long getId();

	/**
	 * Sets the ID of this stat download tag.
	 *
	 * @param id the ID of this stat download tag
	 */
	public void setId(long id);

	/**
	 * Returns the per month of this stat download tag.
	 *
	 * @return the per month of this stat download tag
	 */
	public int getPerMonth();

	/**
	 * Sets the per month of this stat download tag.
	 *
	 * @param perMonth the per month of this stat download tag
	 */
	public void setPerMonth(int perMonth);

	/**
	 * Returns the per year of this stat download tag.
	 *
	 * @return the per year of this stat download tag
	 */
	public int getPerYear();

	/**
	 * Sets the per year of this stat download tag.
	 *
	 * @param perYear the per year of this stat download tag
	 */
	public void setPerYear(int perYear);

	/**
	 * Returns the tag ID of this stat download tag.
	 *
	 * @return the tag ID of this stat download tag
	 */
	public long getTagId();

	/**
	 * Sets the tag ID of this stat download tag.
	 *
	 * @param tagId the tag ID of this stat download tag
	 */
	public void setTagId(long tagId);

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
	public int compareTo(
		com.idetronic.subur.model.StatDownloadTag statDownloadTag);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.StatDownloadTag> toCacheModel();

	@Override
	public com.idetronic.subur.model.StatDownloadTag toEscapedModel();

	@Override
	public com.idetronic.subur.model.StatDownloadTag toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}