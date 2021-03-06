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

import com.idetronic.subur.service.persistence.AuthorExpertisePK;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the AuthorExpertise service. Represents a row in the &quot;Subur_AuthorExpertise&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.AuthorExpertiseImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorExpertise
 * @see com.idetronic.subur.model.impl.AuthorExpertiseImpl
 * @see com.idetronic.subur.model.impl.AuthorExpertiseModelImpl
 * @generated
 */
public interface AuthorExpertiseModel extends BaseModel<AuthorExpertise> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a author expertise model instance should use the {@link AuthorExpertise} interface instead.
	 */

	/**
	 * Returns the primary key of this author expertise.
	 *
	 * @return the primary key of this author expertise
	 */
	public AuthorExpertisePK getPrimaryKey();

	/**
	 * Sets the primary key of this author expertise.
	 *
	 * @param primaryKey the primary key of this author expertise
	 */
	public void setPrimaryKey(AuthorExpertisePK primaryKey);

	/**
	 * Returns the author ID of this author expertise.
	 *
	 * @return the author ID of this author expertise
	 */
	public long getAuthorId();

	/**
	 * Sets the author ID of this author expertise.
	 *
	 * @param authorId the author ID of this author expertise
	 */
	public void setAuthorId(long authorId);

	/**
	 * Returns the expertise ID of this author expertise.
	 *
	 * @return the expertise ID of this author expertise
	 */
	public long getExpertiseId();

	/**
	 * Sets the expertise ID of this author expertise.
	 *
	 * @param expertiseId the expertise ID of this author expertise
	 */
	public void setExpertiseId(long expertiseId);

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
		com.idetronic.subur.model.AuthorExpertise authorExpertise);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.AuthorExpertise> toCacheModel();

	@Override
	public com.idetronic.subur.model.AuthorExpertise toEscapedModel();

	@Override
	public com.idetronic.subur.model.AuthorExpertise toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}