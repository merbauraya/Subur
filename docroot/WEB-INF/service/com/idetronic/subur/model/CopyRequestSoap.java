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
 * This class is used by SOAP remote services, specifically {@link com.idetronic.subur.service.http.CopyRequestServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.http.CopyRequestServiceSoap
 * @generated
 */
public class CopyRequestSoap implements Serializable {
	public static CopyRequestSoap toSoapModel(CopyRequest model) {
		CopyRequestSoap soapModel = new CopyRequestSoap();

		soapModel.setCopyRequestId(model.getCopyRequestId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setDateCreated(model.getDateCreated());
		soapModel.setStatus(model.getStatus());
		soapModel.setSuburItemId(model.getSuburItemId());
		soapModel.setFromEmailAddress(model.getFromEmailAddress());
		soapModel.setRequesterName(model.getRequesterName());
		soapModel.setReason(model.getReason());
		soapModel.setOrganization(model.getOrganization());
		soapModel.setDateResponsed(model.getDateResponsed());
		soapModel.setRespondText(model.getRespondText());
		soapModel.setResponsedByUserId(model.getResponsedByUserId());

		return soapModel;
	}

	public static CopyRequestSoap[] toSoapModels(CopyRequest[] models) {
		CopyRequestSoap[] soapModels = new CopyRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CopyRequestSoap[][] toSoapModels(CopyRequest[][] models) {
		CopyRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CopyRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CopyRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CopyRequestSoap[] toSoapModels(List<CopyRequest> models) {
		List<CopyRequestSoap> soapModels = new ArrayList<CopyRequestSoap>(models.size());

		for (CopyRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CopyRequestSoap[soapModels.size()]);
	}

	public CopyRequestSoap() {
	}

	public long getPrimaryKey() {
		return _copyRequestId;
	}

	public void setPrimaryKey(long pk) {
		setCopyRequestId(pk);
	}

	public long getCopyRequestId() {
		return _copyRequestId;
	}

	public void setCopyRequestId(long copyRequestId) {
		_copyRequestId = copyRequestId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getDateCreated() {
		return _dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		_dateCreated = dateCreated;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getSuburItemId() {
		return _suburItemId;
	}

	public void setSuburItemId(long suburItemId) {
		_suburItemId = suburItemId;
	}

	public String getFromEmailAddress() {
		return _fromEmailAddress;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		_fromEmailAddress = fromEmailAddress;
	}

	public String getRequesterName() {
		return _requesterName;
	}

	public void setRequesterName(String requesterName) {
		_requesterName = requesterName;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getOrganization() {
		return _organization;
	}

	public void setOrganization(String organization) {
		_organization = organization;
	}

	public Date getDateResponsed() {
		return _dateResponsed;
	}

	public void setDateResponsed(Date dateResponsed) {
		_dateResponsed = dateResponsed;
	}

	public String getRespondText() {
		return _respondText;
	}

	public void setRespondText(String respondText) {
		_respondText = respondText;
	}

	public long getResponsedByUserId() {
		return _responsedByUserId;
	}

	public void setResponsedByUserId(long responsedByUserId) {
		_responsedByUserId = responsedByUserId;
	}

	private long _copyRequestId;
	private long _companyId;
	private long _groupId;
	private Date _dateCreated;
	private int _status;
	private long _suburItemId;
	private String _fromEmailAddress;
	private String _requesterName;
	private String _reason;
	private String _organization;
	private Date _dateResponsed;
	private String _respondText;
	private long _responsedByUserId;
}