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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.ResearchInterestServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.ResearchInterestServiceSoap
 * @generated
 */
public class ResearchInterestSoap implements Serializable {
	public static ResearchInterestSoap toSoapModel(ResearchInterest model) {
		ResearchInterestSoap soapModel = new ResearchInterestSoap();

		soapModel.setResearchInterestId(model.getResearchInterestId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setResearchInterestName(model.getResearchInterestName());
		soapModel.setIndexedName(model.getIndexedName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAuthorCount(model.getAuthorCount());

		return soapModel;
	}

	public static ResearchInterestSoap[] toSoapModels(ResearchInterest[] models) {
		ResearchInterestSoap[] soapModels = new ResearchInterestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResearchInterestSoap[][] toSoapModels(
		ResearchInterest[][] models) {
		ResearchInterestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResearchInterestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResearchInterestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResearchInterestSoap[] toSoapModels(
		List<ResearchInterest> models) {
		List<ResearchInterestSoap> soapModels = new ArrayList<ResearchInterestSoap>(models.size());

		for (ResearchInterest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResearchInterestSoap[soapModels.size()]);
	}

	public ResearchInterestSoap() {
	}

	public long getPrimaryKey() {
		return _researchInterestId;
	}

	public void setPrimaryKey(long pk) {
		setResearchInterestId(pk);
	}

	public long getResearchInterestId() {
		return _researchInterestId;
	}

	public void setResearchInterestId(long researchInterestId) {
		_researchInterestId = researchInterestId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getResearchInterestName() {
		return _researchInterestName;
	}

	public void setResearchInterestName(String researchInterestName) {
		_researchInterestName = researchInterestName;
	}

	public String getIndexedName() {
		return _indexedName;
	}

	public void setIndexedName(String indexedName) {
		_indexedName = indexedName;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getAuthorCount() {
		return _authorCount;
	}

	public void setAuthorCount(int authorCount) {
		_authorCount = authorCount;
	}

	private long _researchInterestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private String _researchInterestName;
	private String _indexedName;
	private Date _modifiedDate;
	private int _authorCount;
}