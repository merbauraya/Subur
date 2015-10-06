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
 * This class is a wrapper for {@link CopyRequest}.
 * </p>
 *
 * @author Mazlan Mat
 * @see CopyRequest
 * @generated
 */
public class CopyRequestWrapper implements CopyRequest,
	ModelWrapper<CopyRequest> {
	public CopyRequestWrapper(CopyRequest copyRequest) {
		_copyRequest = copyRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return CopyRequest.class;
	}

	@Override
	public String getModelClassName() {
		return CopyRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("copyRequestId", getCopyRequestId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("dateCreated", getDateCreated());
		attributes.put("status", getStatus());
		attributes.put("suburItemId", getSuburItemId());
		attributes.put("fromEmailAddress", getFromEmailAddress());
		attributes.put("requesterName", getRequesterName());
		attributes.put("reason", getReason());
		attributes.put("organization", getOrganization());
		attributes.put("dateResponsed", getDateResponsed());
		attributes.put("respondText", getRespondText());
		attributes.put("responsedByUserId", getResponsedByUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long copyRequestId = (Long)attributes.get("copyRequestId");

		if (copyRequestId != null) {
			setCopyRequestId(copyRequestId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date dateCreated = (Date)attributes.get("dateCreated");

		if (dateCreated != null) {
			setDateCreated(dateCreated);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long suburItemId = (Long)attributes.get("suburItemId");

		if (suburItemId != null) {
			setSuburItemId(suburItemId);
		}

		String fromEmailAddress = (String)attributes.get("fromEmailAddress");

		if (fromEmailAddress != null) {
			setFromEmailAddress(fromEmailAddress);
		}

		String requesterName = (String)attributes.get("requesterName");

		if (requesterName != null) {
			setRequesterName(requesterName);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		Date dateResponsed = (Date)attributes.get("dateResponsed");

		if (dateResponsed != null) {
			setDateResponsed(dateResponsed);
		}

		String respondText = (String)attributes.get("respondText");

		if (respondText != null) {
			setRespondText(respondText);
		}

		Long responsedByUserId = (Long)attributes.get("responsedByUserId");

		if (responsedByUserId != null) {
			setResponsedByUserId(responsedByUserId);
		}
	}

	/**
	* Returns the primary key of this copy request.
	*
	* @return the primary key of this copy request
	*/
	@Override
	public long getPrimaryKey() {
		return _copyRequest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this copy request.
	*
	* @param primaryKey the primary key of this copy request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_copyRequest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the copy request ID of this copy request.
	*
	* @return the copy request ID of this copy request
	*/
	@Override
	public long getCopyRequestId() {
		return _copyRequest.getCopyRequestId();
	}

	/**
	* Sets the copy request ID of this copy request.
	*
	* @param copyRequestId the copy request ID of this copy request
	*/
	@Override
	public void setCopyRequestId(long copyRequestId) {
		_copyRequest.setCopyRequestId(copyRequestId);
	}

	/**
	* Returns the company ID of this copy request.
	*
	* @return the company ID of this copy request
	*/
	@Override
	public long getCompanyId() {
		return _copyRequest.getCompanyId();
	}

	/**
	* Sets the company ID of this copy request.
	*
	* @param companyId the company ID of this copy request
	*/
	@Override
	public void setCompanyId(long companyId) {
		_copyRequest.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this copy request.
	*
	* @return the group ID of this copy request
	*/
	@Override
	public long getGroupId() {
		return _copyRequest.getGroupId();
	}

	/**
	* Sets the group ID of this copy request.
	*
	* @param groupId the group ID of this copy request
	*/
	@Override
	public void setGroupId(long groupId) {
		_copyRequest.setGroupId(groupId);
	}

	/**
	* Returns the date created of this copy request.
	*
	* @return the date created of this copy request
	*/
	@Override
	public java.util.Date getDateCreated() {
		return _copyRequest.getDateCreated();
	}

	/**
	* Sets the date created of this copy request.
	*
	* @param dateCreated the date created of this copy request
	*/
	@Override
	public void setDateCreated(java.util.Date dateCreated) {
		_copyRequest.setDateCreated(dateCreated);
	}

	/**
	* Returns the status of this copy request.
	*
	* @return the status of this copy request
	*/
	@Override
	public int getStatus() {
		return _copyRequest.getStatus();
	}

	/**
	* Sets the status of this copy request.
	*
	* @param status the status of this copy request
	*/
	@Override
	public void setStatus(int status) {
		_copyRequest.setStatus(status);
	}

	/**
	* Returns the subur item ID of this copy request.
	*
	* @return the subur item ID of this copy request
	*/
	@Override
	public long getSuburItemId() {
		return _copyRequest.getSuburItemId();
	}

	/**
	* Sets the subur item ID of this copy request.
	*
	* @param suburItemId the subur item ID of this copy request
	*/
	@Override
	public void setSuburItemId(long suburItemId) {
		_copyRequest.setSuburItemId(suburItemId);
	}

	/**
	* Returns the from email address of this copy request.
	*
	* @return the from email address of this copy request
	*/
	@Override
	public java.lang.String getFromEmailAddress() {
		return _copyRequest.getFromEmailAddress();
	}

	/**
	* Sets the from email address of this copy request.
	*
	* @param fromEmailAddress the from email address of this copy request
	*/
	@Override
	public void setFromEmailAddress(java.lang.String fromEmailAddress) {
		_copyRequest.setFromEmailAddress(fromEmailAddress);
	}

	/**
	* Returns the requester name of this copy request.
	*
	* @return the requester name of this copy request
	*/
	@Override
	public java.lang.String getRequesterName() {
		return _copyRequest.getRequesterName();
	}

	/**
	* Sets the requester name of this copy request.
	*
	* @param requesterName the requester name of this copy request
	*/
	@Override
	public void setRequesterName(java.lang.String requesterName) {
		_copyRequest.setRequesterName(requesterName);
	}

	/**
	* Returns the reason of this copy request.
	*
	* @return the reason of this copy request
	*/
	@Override
	public java.lang.String getReason() {
		return _copyRequest.getReason();
	}

	/**
	* Sets the reason of this copy request.
	*
	* @param reason the reason of this copy request
	*/
	@Override
	public void setReason(java.lang.String reason) {
		_copyRequest.setReason(reason);
	}

	/**
	* Returns the organization of this copy request.
	*
	* @return the organization of this copy request
	*/
	@Override
	public java.lang.String getOrganization() {
		return _copyRequest.getOrganization();
	}

	/**
	* Sets the organization of this copy request.
	*
	* @param organization the organization of this copy request
	*/
	@Override
	public void setOrganization(java.lang.String organization) {
		_copyRequest.setOrganization(organization);
	}

	/**
	* Returns the date responsed of this copy request.
	*
	* @return the date responsed of this copy request
	*/
	@Override
	public java.util.Date getDateResponsed() {
		return _copyRequest.getDateResponsed();
	}

	/**
	* Sets the date responsed of this copy request.
	*
	* @param dateResponsed the date responsed of this copy request
	*/
	@Override
	public void setDateResponsed(java.util.Date dateResponsed) {
		_copyRequest.setDateResponsed(dateResponsed);
	}

	/**
	* Returns the respond text of this copy request.
	*
	* @return the respond text of this copy request
	*/
	@Override
	public java.lang.String getRespondText() {
		return _copyRequest.getRespondText();
	}

	/**
	* Sets the respond text of this copy request.
	*
	* @param respondText the respond text of this copy request
	*/
	@Override
	public void setRespondText(java.lang.String respondText) {
		_copyRequest.setRespondText(respondText);
	}

	/**
	* Returns the responsed by user ID of this copy request.
	*
	* @return the responsed by user ID of this copy request
	*/
	@Override
	public long getResponsedByUserId() {
		return _copyRequest.getResponsedByUserId();
	}

	/**
	* Sets the responsed by user ID of this copy request.
	*
	* @param responsedByUserId the responsed by user ID of this copy request
	*/
	@Override
	public void setResponsedByUserId(long responsedByUserId) {
		_copyRequest.setResponsedByUserId(responsedByUserId);
	}

	/**
	* Returns the responsed by user uuid of this copy request.
	*
	* @return the responsed by user uuid of this copy request
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getResponsedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _copyRequest.getResponsedByUserUuid();
	}

	/**
	* Sets the responsed by user uuid of this copy request.
	*
	* @param responsedByUserUuid the responsed by user uuid of this copy request
	*/
	@Override
	public void setResponsedByUserUuid(java.lang.String responsedByUserUuid) {
		_copyRequest.setResponsedByUserUuid(responsedByUserUuid);
	}

	@Override
	public boolean isNew() {
		return _copyRequest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_copyRequest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _copyRequest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_copyRequest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _copyRequest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _copyRequest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_copyRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _copyRequest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_copyRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_copyRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_copyRequest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CopyRequestWrapper((CopyRequest)_copyRequest.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.CopyRequest copyRequest) {
		return _copyRequest.compareTo(copyRequest);
	}

	@Override
	public int hashCode() {
		return _copyRequest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.CopyRequest> toCacheModel() {
		return _copyRequest.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.CopyRequest toEscapedModel() {
		return new CopyRequestWrapper(_copyRequest.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.CopyRequest toUnescapedModel() {
		return new CopyRequestWrapper(_copyRequest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _copyRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _copyRequest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_copyRequest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CopyRequestWrapper)) {
			return false;
		}

		CopyRequestWrapper copyRequestWrapper = (CopyRequestWrapper)obj;

		if (Validator.equals(_copyRequest, copyRequestWrapper._copyRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CopyRequest getWrappedCopyRequest() {
		return _copyRequest;
	}

	@Override
	public CopyRequest getWrappedModel() {
		return _copyRequest;
	}

	@Override
	public void resetOriginalValues() {
		_copyRequest.resetOriginalValues();
	}

	private CopyRequest _copyRequest;
}