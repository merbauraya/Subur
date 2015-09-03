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
 * This class is a wrapper for {@link ResearchInterest}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ResearchInterest
 * @generated
 */
public class ResearchInterestWrapper implements ResearchInterest,
	ModelWrapper<ResearchInterest> {
	public ResearchInterestWrapper(ResearchInterest researchInterest) {
		_researchInterest = researchInterest;
	}

	@Override
	public Class<?> getModelClass() {
		return ResearchInterest.class;
	}

	@Override
	public String getModelClassName() {
		return ResearchInterest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("researchInterestId", getResearchInterestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("researchInterestName", getResearchInterestName());
		attributes.put("indexedName", getIndexedName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("authorCount", getAuthorCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long researchInterestId = (Long)attributes.get("researchInterestId");

		if (researchInterestId != null) {
			setResearchInterestId(researchInterestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String researchInterestName = (String)attributes.get(
				"researchInterestName");

		if (researchInterestName != null) {
			setResearchInterestName(researchInterestName);
		}

		String indexedName = (String)attributes.get("indexedName");

		if (indexedName != null) {
			setIndexedName(indexedName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer authorCount = (Integer)attributes.get("authorCount");

		if (authorCount != null) {
			setAuthorCount(authorCount);
		}
	}

	/**
	* Returns the primary key of this research interest.
	*
	* @return the primary key of this research interest
	*/
	@Override
	public long getPrimaryKey() {
		return _researchInterest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this research interest.
	*
	* @param primaryKey the primary key of this research interest
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_researchInterest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the research interest ID of this research interest.
	*
	* @return the research interest ID of this research interest
	*/
	@Override
	public long getResearchInterestId() {
		return _researchInterest.getResearchInterestId();
	}

	/**
	* Sets the research interest ID of this research interest.
	*
	* @param researchInterestId the research interest ID of this research interest
	*/
	@Override
	public void setResearchInterestId(long researchInterestId) {
		_researchInterest.setResearchInterestId(researchInterestId);
	}

	/**
	* Returns the group ID of this research interest.
	*
	* @return the group ID of this research interest
	*/
	@Override
	public long getGroupId() {
		return _researchInterest.getGroupId();
	}

	/**
	* Sets the group ID of this research interest.
	*
	* @param groupId the group ID of this research interest
	*/
	@Override
	public void setGroupId(long groupId) {
		_researchInterest.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this research interest.
	*
	* @return the company ID of this research interest
	*/
	@Override
	public long getCompanyId() {
		return _researchInterest.getCompanyId();
	}

	/**
	* Sets the company ID of this research interest.
	*
	* @param companyId the company ID of this research interest
	*/
	@Override
	public void setCompanyId(long companyId) {
		_researchInterest.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this research interest.
	*
	* @return the user ID of this research interest
	*/
	@Override
	public long getUserId() {
		return _researchInterest.getUserId();
	}

	/**
	* Sets the user ID of this research interest.
	*
	* @param userId the user ID of this research interest
	*/
	@Override
	public void setUserId(long userId) {
		_researchInterest.setUserId(userId);
	}

	/**
	* Returns the user uuid of this research interest.
	*
	* @return the user uuid of this research interest
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterest.getUserUuid();
	}

	/**
	* Sets the user uuid of this research interest.
	*
	* @param userUuid the user uuid of this research interest
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_researchInterest.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this research interest.
	*
	* @return the create date of this research interest
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _researchInterest.getCreateDate();
	}

	/**
	* Sets the create date of this research interest.
	*
	* @param createDate the create date of this research interest
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_researchInterest.setCreateDate(createDate);
	}

	/**
	* Returns the research interest name of this research interest.
	*
	* @return the research interest name of this research interest
	*/
	@Override
	public java.lang.String getResearchInterestName() {
		return _researchInterest.getResearchInterestName();
	}

	/**
	* Sets the research interest name of this research interest.
	*
	* @param researchInterestName the research interest name of this research interest
	*/
	@Override
	public void setResearchInterestName(java.lang.String researchInterestName) {
		_researchInterest.setResearchInterestName(researchInterestName);
	}

	/**
	* Returns the indexed name of this research interest.
	*
	* @return the indexed name of this research interest
	*/
	@Override
	public java.lang.String getIndexedName() {
		return _researchInterest.getIndexedName();
	}

	/**
	* Sets the indexed name of this research interest.
	*
	* @param indexedName the indexed name of this research interest
	*/
	@Override
	public void setIndexedName(java.lang.String indexedName) {
		_researchInterest.setIndexedName(indexedName);
	}

	/**
	* Returns the modified date of this research interest.
	*
	* @return the modified date of this research interest
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _researchInterest.getModifiedDate();
	}

	/**
	* Sets the modified date of this research interest.
	*
	* @param modifiedDate the modified date of this research interest
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_researchInterest.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the author count of this research interest.
	*
	* @return the author count of this research interest
	*/
	@Override
	public int getAuthorCount() {
		return _researchInterest.getAuthorCount();
	}

	/**
	* Sets the author count of this research interest.
	*
	* @param authorCount the author count of this research interest
	*/
	@Override
	public void setAuthorCount(int authorCount) {
		_researchInterest.setAuthorCount(authorCount);
	}

	@Override
	public boolean isNew() {
		return _researchInterest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_researchInterest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _researchInterest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_researchInterest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _researchInterest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _researchInterest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_researchInterest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _researchInterest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_researchInterest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_researchInterest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_researchInterest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResearchInterestWrapper((ResearchInterest)_researchInterest.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.ResearchInterest researchInterest) {
		return _researchInterest.compareTo(researchInterest);
	}

	@Override
	public int hashCode() {
		return _researchInterest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.ResearchInterest> toCacheModel() {
		return _researchInterest.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest toEscapedModel() {
		return new ResearchInterestWrapper(_researchInterest.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest toUnescapedModel() {
		return new ResearchInterestWrapper(_researchInterest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _researchInterest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _researchInterest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_researchInterest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResearchInterestWrapper)) {
			return false;
		}

		ResearchInterestWrapper researchInterestWrapper = (ResearchInterestWrapper)obj;

		if (Validator.equals(_researchInterest,
					researchInterestWrapper._researchInterest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ResearchInterest getWrappedResearchInterest() {
		return _researchInterest;
	}

	@Override
	public ResearchInterest getWrappedModel() {
		return _researchInterest;
	}

	@Override
	public void resetOriginalValues() {
		_researchInterest.resetOriginalValues();
	}

	private ResearchInterest _researchInterest;
}