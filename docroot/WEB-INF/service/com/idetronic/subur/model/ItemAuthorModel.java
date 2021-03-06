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

import com.idetronic.subur.service.persistence.ItemAuthorPK;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ItemAuthor service. Represents a row in the &quot;Subur_ItemAuthor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.idetronic.subur.model.impl.ItemAuthorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemAuthor
 * @see com.idetronic.subur.model.impl.ItemAuthorImpl
 * @see com.idetronic.subur.model.impl.ItemAuthorModelImpl
 * @generated
 */
public interface ItemAuthorModel extends BaseModel<ItemAuthor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a item author model instance should use the {@link ItemAuthor} interface instead.
	 */

	/**
	 * Returns the primary key of this item author.
	 *
	 * @return the primary key of this item author
	 */
	public ItemAuthorPK getPrimaryKey();

	/**
	 * Sets the primary key of this item author.
	 *
	 * @param primaryKey the primary key of this item author
	 */
	public void setPrimaryKey(ItemAuthorPK primaryKey);

	/**
	 * Returns the item ID of this item author.
	 *
	 * @return the item ID of this item author
	 */
	public long getItemId();

	/**
	 * Sets the item ID of this item author.
	 *
	 * @param itemId the item ID of this item author
	 */
	public void setItemId(long itemId);

	/**
	 * Returns the author ID of this item author.
	 *
	 * @return the author ID of this item author
	 */
	public long getAuthorId();

	/**
	 * Sets the author ID of this item author.
	 *
	 * @param authorId the author ID of this item author
	 */
	public void setAuthorId(long authorId);

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
	public int compareTo(com.idetronic.subur.model.ItemAuthor itemAuthor);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.idetronic.subur.model.ItemAuthor> toCacheModel();

	@Override
	public com.idetronic.subur.model.ItemAuthor toEscapedModel();

	@Override
	public com.idetronic.subur.model.ItemAuthor toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}