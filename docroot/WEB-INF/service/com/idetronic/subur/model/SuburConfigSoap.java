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
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class SuburConfigSoap implements Serializable {
	public static SuburConfigSoap toSoapModel(SuburConfig model) {
		SuburConfigSoap soapModel = new SuburConfigSoap();

		soapModel.setId(model.getId());
		soapModel.setKey(model.getKey());
		soapModel.setDescription(model.getDescription());
		soapModel.setConfig(model.getConfig());

		return soapModel;
	}

	public static SuburConfigSoap[] toSoapModels(SuburConfig[] models) {
		SuburConfigSoap[] soapModels = new SuburConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SuburConfigSoap[][] toSoapModels(SuburConfig[][] models) {
		SuburConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SuburConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SuburConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SuburConfigSoap[] toSoapModels(List<SuburConfig> models) {
		List<SuburConfigSoap> soapModels = new ArrayList<SuburConfigSoap>(models.size());

		for (SuburConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SuburConfigSoap[soapModels.size()]);
	}

	public SuburConfigSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getConfig() {
		return _config;
	}

	public void setConfig(String config) {
		_config = config;
	}

	private long _id;
	private String _key;
	private String _description;
	private String _config;
}