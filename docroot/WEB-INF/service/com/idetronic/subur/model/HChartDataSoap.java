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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.HChartDataServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.HChartDataServiceSoap
 * @generated
 */
public class HChartDataSoap implements Serializable {
	public static HChartDataSoap toSoapModel(HChartData model) {
		HChartDataSoap soapModel = new HChartDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setHChartDataId(model.getHChartDataId());
		soapModel.setTitle(model.getTitle());
		soapModel.setYAxisTitle(model.getYAxisTitle());
		soapModel.setXAxisTitle(model.getXAxisTitle());

		return soapModel;
	}

	public static HChartDataSoap[] toSoapModels(HChartData[] models) {
		HChartDataSoap[] soapModels = new HChartDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HChartDataSoap[][] toSoapModels(HChartData[][] models) {
		HChartDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HChartDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HChartDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HChartDataSoap[] toSoapModels(List<HChartData> models) {
		List<HChartDataSoap> soapModels = new ArrayList<HChartDataSoap>(models.size());

		for (HChartData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HChartDataSoap[soapModels.size()]);
	}

	public HChartDataSoap() {
	}

	public long getPrimaryKey() {
		return _hChartDataId;
	}

	public void setPrimaryKey(long pk) {
		setHChartDataId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getHChartDataId() {
		return _hChartDataId;
	}

	public void setHChartDataId(long hChartDataId) {
		_hChartDataId = hChartDataId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getYAxisTitle() {
		return _yAxisTitle;
	}

	public void setYAxisTitle(String yAxisTitle) {
		_yAxisTitle = yAxisTitle;
	}

	public String getXAxisTitle() {
		return _xAxisTitle;
	}

	public void setXAxisTitle(String xAxisTitle) {
		_xAxisTitle = xAxisTitle;
	}

	private String _uuid;
	private long _hChartDataId;
	private String _title;
	private String _yAxisTitle;
	private String _xAxisTitle;
}