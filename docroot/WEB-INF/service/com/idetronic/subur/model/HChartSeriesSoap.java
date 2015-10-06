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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.HChartSeriesServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.HChartSeriesServiceSoap
 * @generated
 */
public class HChartSeriesSoap implements Serializable {
	public static HChartSeriesSoap toSoapModel(HChartSeries model) {
		HChartSeriesSoap soapModel = new HChartSeriesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setHChartSeriesId(model.getHChartSeriesId());
		soapModel.setSeriesName(model.getSeriesName());
		soapModel.setColor(model.getColor());

		return soapModel;
	}

	public static HChartSeriesSoap[] toSoapModels(HChartSeries[] models) {
		HChartSeriesSoap[] soapModels = new HChartSeriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HChartSeriesSoap[][] toSoapModels(HChartSeries[][] models) {
		HChartSeriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HChartSeriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HChartSeriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HChartSeriesSoap[] toSoapModels(List<HChartSeries> models) {
		List<HChartSeriesSoap> soapModels = new ArrayList<HChartSeriesSoap>(models.size());

		for (HChartSeries model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HChartSeriesSoap[soapModels.size()]);
	}

	public HChartSeriesSoap() {
	}

	public long getPrimaryKey() {
		return _hChartSeriesId;
	}

	public void setPrimaryKey(long pk) {
		setHChartSeriesId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getHChartSeriesId() {
		return _hChartSeriesId;
	}

	public void setHChartSeriesId(long hChartSeriesId) {
		_hChartSeriesId = hChartSeriesId;
	}

	public String getSeriesName() {
		return _seriesName;
	}

	public void setSeriesName(String seriesName) {
		_seriesName = seriesName;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	private String _uuid;
	private long _hChartSeriesId;
	private String _seriesName;
	private String _color;
}