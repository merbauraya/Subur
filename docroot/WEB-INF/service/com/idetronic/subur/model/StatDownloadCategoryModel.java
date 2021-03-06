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
 * The base model interface for the StatDownloadCategory service. Represents a row in the &quot;Subur_StatDownloadCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.StatDownloadCategoryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadCategory
 * @see com.idetronic.subur.model.impl.StatDownloadCategoryImpl
 * @see com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl
 * @generated
 */
public interface StatDownloadCategoryModel extends BaseModel<StatDownloadCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stat download category model instance should use the {@link StatDownloadCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this stat download category.
	 *
	 * @return the primary key of this stat download category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stat download category.
	 *
	 * @param primaryKey the primary key of this stat download category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this stat download category.
	 *
	 * @return the ID of this stat download category
	 */
	public long getId();

	/**
	 * Sets the ID of this stat download category.
	 *
	 * @param id the ID of this stat download category
	 */
	public void setId(long id);

	/**
	 * Returns the per month of this stat download category.
	 *
	 * @return the per month of this stat download category
	 */
	public int getPerMonth();

	/**
	 * Sets the per month of this stat download category.
	 *
	 * @param perMonth the per month of this stat download category
	 */
	public void setPerMonth(int perMonth);

	/**
	 * Returns the per year of this stat download category.
	 *
	 * @return the per year of this stat download category
	 */
	public int getPerYear();

	/**
	 * Sets the per year of this stat download category.
	 *
	 * @param perYear the per year of this stat download category
	 */
	public void setPerYear(int perYear);

	/**
	 * Returns the category ID of this stat download category.
	 *
	 * @return the category ID of this stat download category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this stat download category.
	 *
	 * @param categoryId the category ID of this stat download category
	 */
	public void setCategoryId(long categoryId);

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
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.StatDownloadCategory> toCacheModel();

	@Override
	public com.idetronic.subur.model.StatDownloadCategory toEscapedModel();

	@Override
	public com.idetronic.subur.model.StatDownloadCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}