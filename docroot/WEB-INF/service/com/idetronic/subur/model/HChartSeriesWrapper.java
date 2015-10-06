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
 * This class is a wrapper for {@link HChartSeries}.
 * </p>
 *
 * @author Mazlan Mat
 * @see HChartSeries
 * @generated
 */
public class HChartSeriesWrapper implements HChartSeries,
	ModelWrapper<HChartSeries> {
	public HChartSeriesWrapper(HChartSeries hChartSeries) {
		_hChartSeries = hChartSeries;
	}

	@Override
	public Class<?> getModelClass() {
		return HChartSeries.class;
	}

	@Override
	public String getModelClassName() {
		return HChartSeries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("hChartSeriesId", getHChartSeriesId());
		attributes.put("seriesName", getSeriesName());
		attributes.put("color", getColor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long hChartSeriesId = (Long)attributes.get("hChartSeriesId");

		if (hChartSeriesId != null) {
			setHChartSeriesId(hChartSeriesId);
		}

		String seriesName = (String)attributes.get("seriesName");

		if (seriesName != null) {
			setSeriesName(seriesName);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}
	}

	/**
	* Returns the primary key of this h chart series.
	*
	* @return the primary key of this h chart series
	*/
	@Override
	public long getPrimaryKey() {
		return _hChartSeries.getPrimaryKey();
	}

	/**
	* Sets the primary key of this h chart series.
	*
	* @param primaryKey the primary key of this h chart series
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hChartSeries.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this h chart series.
	*
	* @return the uuid of this h chart series
	*/
	@Override
	public java.lang.String getUuid() {
		return _hChartSeries.getUuid();
	}

	/**
	* Sets the uuid of this h chart series.
	*
	* @param uuid the uuid of this h chart series
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_hChartSeries.setUuid(uuid);
	}

	/**
	* Returns the h chart series ID of this h chart series.
	*
	* @return the h chart series ID of this h chart series
	*/
	@Override
	public long getHChartSeriesId() {
		return _hChartSeries.getHChartSeriesId();
	}

	/**
	* Sets the h chart series ID of this h chart series.
	*
	* @param hChartSeriesId the h chart series ID of this h chart series
	*/
	@Override
	public void setHChartSeriesId(long hChartSeriesId) {
		_hChartSeries.setHChartSeriesId(hChartSeriesId);
	}

	/**
	* Returns the series name of this h chart series.
	*
	* @return the series name of this h chart series
	*/
	@Override
	public java.lang.String getSeriesName() {
		return _hChartSeries.getSeriesName();
	}

	/**
	* Sets the series name of this h chart series.
	*
	* @param seriesName the series name of this h chart series
	*/
	@Override
	public void setSeriesName(java.lang.String seriesName) {
		_hChartSeries.setSeriesName(seriesName);
	}

	/**
	* Returns the color of this h chart series.
	*
	* @return the color of this h chart series
	*/
	@Override
	public java.lang.String getColor() {
		return _hChartSeries.getColor();
	}

	/**
	* Sets the color of this h chart series.
	*
	* @param color the color of this h chart series
	*/
	@Override
	public void setColor(java.lang.String color) {
		_hChartSeries.setColor(color);
	}

	@Override
	public boolean isNew() {
		return _hChartSeries.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_hChartSeries.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _hChartSeries.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hChartSeries.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _hChartSeries.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _hChartSeries.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hChartSeries.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hChartSeries.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_hChartSeries.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_hChartSeries.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hChartSeries.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HChartSeriesWrapper((HChartSeries)_hChartSeries.clone());
	}

	@Override
	public int compareTo(com.idetronic.subur.model.HChartSeries hChartSeries) {
		return _hChartSeries.compareTo(hChartSeries);
	}

	@Override
	public int hashCode() {
		return _hChartSeries.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.idetronic.subur.model.HChartSeries> toCacheModel() {
		return _hChartSeries.toCacheModel();
	}

	@Override
	public com.idetronic.subur.model.HChartSeries toEscapedModel() {
		return new HChartSeriesWrapper(_hChartSeries.toEscapedModel());
	}

	@Override
	public com.idetronic.subur.model.HChartSeries toUnescapedModel() {
		return new HChartSeriesWrapper(_hChartSeries.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hChartSeries.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _hChartSeries.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hChartSeries.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HChartSeriesWrapper)) {
			return false;
		}

		HChartSeriesWrapper hChartSeriesWrapper = (HChartSeriesWrapper)obj;

		if (Validator.equals(_hChartSeries, hChartSeriesWrapper._hChartSeries)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HChartSeries getWrappedHChartSeries() {
		return _hChartSeries;
	}

	@Override
	public HChartSeries getWrappedModel() {
		return _hChartSeries;
	}

	@Override
	public void resetOriginalValues() {
		_hChartSeries.resetOriginalValues();
	}

	private HChartSeries _hChartSeries;
}