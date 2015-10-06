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
 * This class is a wrapper for {@link StatViewItemType}.
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewItemType
 * @generated
 */
public class StatViewItemTypeWrapper implements StatViewItemType,
	ModelWrapper<StatViewItemType> {
	public StatViewItemTypeWrapper(StatViewItemType statViewItemType) {
		_statViewItemType = statViewItemType;
	}

	@Override
	public Class<?> getModelClass() {
		return StatViewItemType.class;
	}

	@Override
	public String getModelClassName() {
		return StatViewItemType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("perYear", getPerYear());
		attributes.put("perMonth", getPerMonth());
		attributes.put("itemTypeId", getItemTypeId());
		attributes.put("viewCount", getViewCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer perYear = (Integer)attributes.get("perYear");

		if (perYear != null) {
			setPerYear(perYear);
		}

		Integer perMonth = (Integer)attributes.get("perMonth");

		if (perMonth != null) {
			setPerMonth(perMonth);
		}

		Long itemTypeId = (Long)attributes.get("itemTypeId");

		if (itemTypeId != null) {
			setItemTypeId(itemTypeId);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}
	}

	/**
	* Returns the primary key of this stat view item type.
	*
	* @return the primary key of this stat view item type
	*/
	@Override
	public long getPrimaryKey() {
		return _statViewItemType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this stat view item type.
	*
	* @param primaryKey the primary key of this stat view item type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statViewItemType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this stat view item type.
	*
	* @return the ID of this stat view item type
	*/
	@Override
	public long getId() {
		return _statViewItemType.getId();
	}

	/**
	* Sets the ID of this stat view item type.
	*
	* @param id the ID of this stat view item type
	*/
	@Override
	public void setId(long id) {
		_statViewItemType.setId(id);
	}

	/**
	* Returns the company ID of this stat view item type.
	*
	* @return the company ID of this stat view item type
	*/
	@Override
	public long getCompanyId() {
		return _statViewItemType.getCompanyId();
	}

	/**
	* Sets the company ID of this stat view item type.
	*
	* @param companyId the company ID of this stat view item type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_statViewItemType.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this stat view item type.
	*
	* @return the group ID of this stat view item type
	*/
	@Override
	public long getGroupId() {
		return _statViewItemType.getGroupId();
	}

	/**
	* Sets the group ID of this stat view item type.
	*
	* @param groupId the group ID of this stat view item type
	*/
	@Override
	public void setGroupId(long groupId) {
		_statViewItemType.setGroupId(groupId);
	}

	/**
	* Returns the per year of this stat view item type.
	*
	* @return the per year of this stat view item type
	*/
	@Override
	public int getPerYear() {
		return _statViewItemType.getPerYear();
	}

	/**
	* Sets the per year of this stat view item type.
	*
	* @param perYear the per year of this stat view item type
	*/
	@Override
	public void setPerYear(int perYear) {
		_statViewItemType.setPerYear(perYear);
	}

	/**
	* Returns the per month of this stat view item type.
	*
	* @return the per month of this stat view item type
	*/
	@Override
	public int getPerMonth() {
		return _statViewItemType.getPerMonth();
	}

	/**
	* Sets the per month of this stat view item type.
	*
	* @param perMonth the per month of this stat view item type
	*/
	@Override
	public void setPerMonth(int perMonth) {
		_statViewItemType.setPerMonth(perMonth);
	}

	/**
	* Returns the item type ID of this stat view item type.
	*
	* @return the item type ID of this stat view item type
	*/
	@Override
	public long getItemTypeId() {
		return _statViewItemType.getItemTypeId();
	}

	/**
	* Sets the item type ID of this stat view item type.
	*
	* @param itemTypeId the item type ID of this stat view item type
	*/
	@Override
	public void setItemTypeId(long itemTypeId) {
		_statViewItemType.setItemTypeId(itemTypeId);
	}

	/**
	* Returns the view count of this stat view item type.
	*
	* @return the view count of this stat view item type
	*/
	@Override
	public int getViewCount() {
		return _statViewItemType.getViewCount();
	}

	/**
	* Sets the view count of this stat view item type.
	*
	* @param viewCount the view count of this stat view item type
	*/
	@Override
	public void setViewCount(int viewCount) {
		_statViewItemType.setViewCount(viewCount);
	}

	@Override
	public boolean isNew() {
		return _statViewItemType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statViewItemType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statViewItemType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statViewItemType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statViewItemType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statViewItemType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statViewItemType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statViewItemType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statViewItemType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statViewItemType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statViewItemType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatViewItemTypeWrapper((StatViewItemType)_statViewItemType.clone());
	}

	@Override
	public int compareTo(
		com.idetronic.subur.model.StatViewItemType statViewItemType) {
		return _statViewItemType.compareTo(statViewItemType);
	}

	@Override
	public int hashCode() {
		return _statViewItemType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.StatViewItemType> toCacheModel() {
		return _statViewItemType.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.StatViewItemType toEscapedModel() {
		return new StatViewItemTypeWrapper(_statViewItemType.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.StatViewItemType toUnescapedModel() {
		return new StatViewItemTypeWrapper(_statViewItemType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statViewItemType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statViewItemType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statViewItemType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatViewItemTypeWrapper)) {
			return false;
		}

		StatViewItemTypeWrapper statViewItemTypeWrapper = (StatViewItemTypeWrapper)obj;

		if (Validator.equals(_statViewItemType,
					statViewItemTypeWrapper._statViewItemType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StatViewItemType getWrappedStatViewItemType() {
		return _statViewItemType;
	}

	@Override
	public StatViewItemType getWrappedModel() {
		return _statViewItemType;
	}

	@Override
	public void resetOriginalValues() {
		_statViewItemType.resetOriginalValues();
	}

	private StatViewItemType _statViewItemType;
}