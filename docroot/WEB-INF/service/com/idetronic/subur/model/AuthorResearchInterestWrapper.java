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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuthorResearchInterest}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorResearchInterest
 * @generated
 */
public class AuthorResearchInterestWrapper implements AuthorResearchInterest,
	ModelWrapper<AuthorResearchInterest> {
	public AuthorResearchInterestWrapper(
		AuthorResearchInterest authorResearchInterest) {
		_authorResearchInterest = authorResearchInterest;
	}

	@Override
	public Class<?> getModelClass() {
		return AuthorResearchInterest.class;
	}

	@Override
	public String getModelClassName() {
		return AuthorResearchInterest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("researchInterestId", getResearchInterestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long researchInterestId = (Long)attributes.get("researchInterestId");

		if (researchInterestId != null) {
			setResearchInterestId(researchInterestId);
		}
	}

	/**
	* Returns the primary key of this author research interest.
	*
	* @return the primary key of this author research interest
	*/
	@Override
	public com.idetronic.subur.service.persistence.AuthorResearchInterestPK getPrimaryKey() {
		return _authorResearchInterest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author research interest.
	*
	* @param primaryKey the primary key of this author research interest
	*/
	@Override
	public void setPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK primaryKey) {
		_authorResearchInterest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author ID of this author research interest.
	*
	* @return the author ID of this author research interest
	*/
	@Override
	public long getAuthorId() {
		return _authorResearchInterest.getAuthorId();
	}

	/**
	* Sets the author ID of this author research interest.
	*
	* @param authorId the author ID of this author research interest
	*/
	@Override
	public void setAuthorId(long authorId) {
		_authorResearchInterest.setAuthorId(authorId);
	}

	/**
	* Returns the research interest ID of this author research interest.
	*
	* @return the research interest ID of this author research interest
	*/
	@Override
	public long getResearchInterestId() {
		return _authorResearchInterest.getResearchInterestId();
	}

	/**
	* Sets the research interest ID of this author research interest.
	*
	* @param researchInterestId the research interest ID of this author research interest
	*/
	@Override
	public void setResearchInterestId(long researchInterestId) {
		_authorResearchInterest.setResearchInterestId(researchInterestId);
	}

	@Override
	public boolean isNew() {
		return _authorResearchInterest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_authorResearchInterest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _authorResearchInterest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_authorResearchInterest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _authorResearchInterest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _authorResearchInterest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_authorResearchInterest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _authorResearchInterest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_authorResearchInterest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_authorResearchInterest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_authorResearchInterest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorResearchInterestWrapper((AuthorResearchInterest)_authorResearchInterest.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.AuthorResearchInterest authorResearchInterest) {
		return _authorResearchInterest.compareTo(authorResearchInterest);
	}

	@Override
	public int hashCode() {
		return _authorResearchInterest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.AuthorResearchInterest> toCacheModel() {
		return _authorResearchInterest.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.AuthorResearchInterest toEscapedModel() {
		return new AuthorResearchInterestWrapper(_authorResearchInterest.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.AuthorResearchInterest toUnescapedModel() {
		return new AuthorResearchInterestWrapper(_authorResearchInterest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _authorResearchInterest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _authorResearchInterest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_authorResearchInterest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorResearchInterestWrapper)) {
			return false;
		}

		AuthorResearchInterestWrapper authorResearchInterestWrapper = (AuthorResearchInterestWrapper)obj;

		if (Validator.equals(_authorResearchInterest,
					authorResearchInterestWrapper._authorResearchInterest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AuthorResearchInterest getWrappedAuthorResearchInterest() {
		return _authorResearchInterest;
	}

	@Override
	public AuthorResearchInterest getWrappedModel() {
		return _authorResearchInterest;
	}

	@Override
	public void resetOriginalValues() {
		_authorResearchInterest.resetOriginalValues();
	}

	private AuthorResearchInterest _authorResearchInterest;
}