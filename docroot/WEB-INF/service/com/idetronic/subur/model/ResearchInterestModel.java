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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ResearchInterest service. Represents a row in the &quot;Subur_ResearchInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.ResearchInterestImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ResearchInterest
 * @see com.idetronic.subur.model.impl.ResearchInterestImpl
 * @see com.idetronic.subur.model.impl.ResearchInterestModelImpl
 * @generated
 */
public interface ResearchInterestModel extends BaseModel<ResearchInterest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a research interest model instance should use the {@link ResearchInterest} interface instead.
	 */

	/**
	 * Returns the primary key of this research interest.
	 *
	 * @return the primary key of this research interest
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this research interest.
	 *
	 * @param primaryKey the primary key of this research interest
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the research interest ID of this research interest.
	 *
	 * @return the research interest ID of this research interest
	 */
	public long getResearchInterestId();

	/**
	 * Sets the research interest ID of this research interest.
	 *
	 * @param researchInterestId the research interest ID of this research interest
	 */
	public void setResearchInterestId(long researchInterestId);

	/**
	 * Returns the group ID of this research interest.
	 *
	 * @return the group ID of this research interest
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this research interest.
	 *
	 * @param groupId the group ID of this research interest
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this research interest.
	 *
	 * @return the company ID of this research interest
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this research interest.
	 *
	 * @param companyId the company ID of this research interest
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this research interest.
	 *
	 * @return the user ID of this research interest
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this research interest.
	 *
	 * @param userId the user ID of this research interest
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this research interest.
	 *
	 * @return the user uuid of this research interest
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this research interest.
	 *
	 * @param userUuid the user uuid of this research interest
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this research interest.
	 *
	 * @return the create date of this research interest
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this research interest.
	 *
	 * @param createDate the create date of this research interest
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the name of this research interest.
	 *
	 * @return the name of this research interest
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this research interest.
	 *
	 * @param name the name of this research interest
	 */
	public void setName(String name);

	/**
	 * Returns the indexed name of this research interest.
	 *
	 * @return the indexed name of this research interest
	 */
	@AutoEscape
	public String getIndexedName();

	/**
	 * Sets the indexed name of this research interest.
	 *
	 * @param indexedName the indexed name of this research interest
	 */
	public void setIndexedName(String indexedName);

	/**
	 * Returns the modified date of this research interest.
	 *
	 * @return the modified date of this research interest
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this research interest.
	 *
	 * @param modifiedDate the modified date of this research interest
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the author count of this research interest.
	 *
	 * @return the author count of this research interest
	 */
	public int getAuthorCount();

	/**
	 * Sets the author count of this research interest.
	 *
	 * @param authorCount the author count of this research interest
	 */
	public void setAuthorCount(int authorCount);

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
		com.idetronic.subur.model.ResearchInterest researchInterest);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.ResearchInterest> toCacheModel();

	@Override
	public com.idetronic.subur.model.ResearchInterest toEscapedModel();

	@Override
	public com.idetronic.subur.model.ResearchInterest toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}