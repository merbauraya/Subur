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
 * This class is a wrapper for {@link HChartData}.
 * </p>
 *
 * @author Mazlan Mat
 * @see HChartData
 * @generated
 */
public class HChartDataWrapper implements HChartData, ModelWrapper<HChartData> {
	public HChartDataWrapper(HChartData hChartData) {
		_hChartData = hChartData;
	}

	@Override
	public Class<?> getModelClass() {
		return HChartData.class;
	}

	@Override
	public String getModelClassName() {
		return HChartData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("hChartDataId", getHChartDataId());
		attributes.put("title", getTitle());
		attributes.put("yAxisTitle", getYAxisTitle());
		attributes.put("xAxisTitle", getXAxisTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long hChartDataId = (Long)attributes.get("hChartDataId");

		if (hChartDataId != null) {
			setHChartDataId(hChartDataId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String yAxisTitle = (String)attributes.get("yAxisTitle");

		if (yAxisTitle != null) {
			setYAxisTitle(yAxisTitle);
		}

		String xAxisTitle = (String)attributes.get("xAxisTitle");

		if (xAxisTitle != null) {
			setXAxisTitle(xAxisTitle);
		}
	}

	/**
	* Returns the primary key of this h chart data.
	*
	* @return the primary key of this h chart data
	*/
	@Override
	public long getPrimaryKey() {
		return _hChartData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this h chart data.
	*
	* @param primaryKey the primary key of this h chart data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hChartData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this h chart data.
	*
	* @return the uuid of this h chart data
	*/
	@Override
	public java.lang.String getUuid() {
		return _hChartData.getUuid();
	}

	/**
	* Sets the uuid of this h chart data.
	*
	* @param uuid the uuid of this h chart data
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_hChartData.setUuid(uuid);
	}

	/**
	* Returns the h chart data ID of this h chart data.
	*
	* @return the h chart data ID of this h chart data
	*/
	@Override
	public long getHChartDataId() {
		return _hChartData.getHChartDataId();
	}

	/**
	* Sets the h chart data ID of this h chart data.
	*
	* @param hChartDataId the h chart data ID of this h chart data
	*/
	@Override
	public void setHChartDataId(long hChartDataId) {
		_hChartData.setHChartDataId(hChartDataId);
	}

	/**
	* Returns the title of this h chart data.
	*
	* @return the title of this h chart data
	*/
	@Override
	public java.lang.String getTitle() {
		return _hChartData.getTitle();
	}

	/**
	* Sets the title of this h chart data.
	*
	* @param title the title of this h chart data
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_hChartData.setTitle(title);
	}

	/**
	* Returns the y axis title of this h chart data.
	*
	* @return the y axis title of this h chart data
	*/
	@Override
	public java.lang.String getYAxisTitle() {
		return _hChartData.getYAxisTitle();
	}

	/**
	* Sets the y axis title of this h chart data.
	*
	* @param yAxisTitle the y axis title of this h chart data
	*/
	@Override
	public void setYAxisTitle(java.lang.String yAxisTitle) {
		_hChartData.setYAxisTitle(yAxisTitle);
	}

	/**
	* Returns the x axis title of this h chart data.
	*
	* @return the x axis title of this h chart data
	*/
	@Override
	public java.lang.String getXAxisTitle() {
		return _hChartData.getXAxisTitle();
	}

	/**
	* Sets the x axis title of this h chart data.
	*
	* @param xAxisTitle the x axis title of this h chart data
	*/
	@Override
	public void setXAxisTitle(java.lang.String xAxisTitle) {
		_hChartData.setXAxisTitle(xAxisTitle);
	}

	@Override
	public boolean isNew() {
		return _hChartData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_hChartData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _hChartData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hChartData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _hChartData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _hChartData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hChartData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hChartData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_hChartData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_hChartData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hChartData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HChartDataWrapper((HChartData)_hChartData.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.HChartData hChartData) {
		return _hChartData.compareTo(hChartData);
	}

	@Override
	public int hashCode() {
		return _hChartData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.HChartData> toCacheModel() {
		return _hChartData.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.HChartData toEscapedModel() {
		return new HChartDataWrapper(_hChartData.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.HChartData toUnescapedModel() {
		return new HChartDataWrapper(_hChartData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hChartData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _hChartData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hChartData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HChartDataWrapper)) {
			return false;
		}

		HChartDataWrapper hChartDataWrapper = (HChartDataWrapper)obj;

		if (Validator.equals(_hChartData, hChartDataWrapper._hChartData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HChartData getWrappedHChartData() {
		return _hChartData;
	}

	@Override
	public HChartData getWrappedModel() {
		return _hChartData;
	}

	@Override
	public void resetOriginalValues() {
		_hChartData.resetOriginalValues();
	}

	private HChartData _hChartData;
}