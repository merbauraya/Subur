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
 * This class is a wrapper for {@link SuburConfig}.
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburConfig
 * @generated
 */
public class SuburConfigWrapper implements SuburConfig,
	ModelWrapper<SuburConfig> {
	public SuburConfigWrapper(SuburConfig suburConfig) {
		_suburConfig = suburConfig;
	}

	@Override
	public Class<?> getModelClass() {
		return SuburConfig.class;
	}

	@Override
	public String getModelClassName() {
		return SuburConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("key", getKey());
		attributes.put("description", getDescription());
		attributes.put("config", getConfig());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String config = (String)attributes.get("config");

		if (config != null) {
			setConfig(config);
		}
	}

	/**
	* Returns the primary key of this subur config.
	*
	* @return the primary key of this subur config
	*/
	@Override
	public long getPrimaryKey() {
		return _suburConfig.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subur config.
	*
	* @param primaryKey the primary key of this subur config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_suburConfig.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this subur config.
	*
	* @return the ID of this subur config
	*/
	@Override
	public long getId() {
		return _suburConfig.getId();
	}

	/**
	* Sets the ID of this subur config.
	*
	* @param id the ID of this subur config
	*/
	@Override
	public void setId(long id) {
		_suburConfig.setId(id);
	}

	/**
	* Returns the key of this subur config.
	*
	* @return the key of this subur config
	*/
	@Override
	public java.lang.String getKey() {
		return _suburConfig.getKey();
	}

	/**
	* Sets the key of this subur config.
	*
	* @param key the key of this subur config
	*/
	@Override
	public void setKey(java.lang.String key) {
		_suburConfig.setKey(key);
	}

	/**
	* Returns the description of this subur config.
	*
	* @return the description of this subur config
	*/
	@Override
	public java.lang.String getDescription() {
		return _suburConfig.getDescription();
	}

	/**
	* Sets the description of this subur config.
	*
	* @param description the description of this subur config
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_suburConfig.setDescription(description);
	}

	/**
	* Returns the config of this subur config.
	*
	* @return the config of this subur config
	*/
	@Override
	public java.lang.String getConfig() {
		return _suburConfig.getConfig();
	}

	/**
	* Sets the config of this subur config.
	*
	* @param config the config of this subur config
	*/
	@Override
	public void setConfig(java.lang.String config) {
		_suburConfig.setConfig(config);
	}

	@Override
	public boolean isNew() {
		return _suburConfig.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_suburConfig.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _suburConfig.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_suburConfig.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _suburConfig.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _suburConfig.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_suburConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _suburConfig.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_suburConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_suburConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_suburConfig.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SuburConfigWrapper((SuburConfig)_suburConfig.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.SuburConfig suburConfig) {
		return _suburConfig.compareTo(suburConfig);
	}

	@Override
	public int hashCode() {
		return _suburConfig.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.SuburConfig> toCacheModel() {
		return _suburConfig.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.SuburConfig toEscapedModel() {
		return new SuburConfigWrapper(_suburConfig.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.SuburConfig toUnescapedModel() {
		return new SuburConfigWrapper(_suburConfig.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _suburConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _suburConfig.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_suburConfig.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SuburConfigWrapper)) {
			return false;
		}

		SuburConfigWrapper suburConfigWrapper = (SuburConfigWrapper)obj;

		if (Validator.equals(_suburConfig, suburConfigWrapper._suburConfig)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SuburConfig getWrappedSuburConfig() {
		return _suburConfig;
	}

	@Override
	public SuburConfig getWrappedModel() {
		return _suburConfig;
	}

	@Override
	public void resetOriginalValues() {
		_suburConfig.resetOriginalValues();
	}

	private SuburConfig _suburConfig;
}