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

import com.idetronic.subur.service.persistence.AuthorResearchInterestPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class AuthorResearchInterestSoap implements Serializable {
	public static AuthorResearchInterestSoap toSoapModel(
		AuthorResearchInterest model) {
		AuthorResearchInterestSoap soapModel = new AuthorResearchInterestSoap();

		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setResearchInterestId(model.getResearchInterestId());

		return soapModel;
	}

	public static AuthorResearchInterestSoap[] toSoapModels(
		AuthorResearchInterest[] models) {
		AuthorResearchInterestSoap[] soapModels = new AuthorResearchInterestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorResearchInterestSoap[][] toSoapModels(
		AuthorResearchInterest[][] models) {
		AuthorResearchInterestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorResearchInterestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorResearchInterestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorResearchInterestSoap[] toSoapModels(
		List<AuthorResearchInterest> models) {
		List<AuthorResearchInterestSoap> soapModels = new ArrayList<AuthorResearchInterestSoap>(models.size());

		for (AuthorResearchInterest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorResearchInterestSoap[soapModels.size()]);
	}

	public AuthorResearchInterestSoap() {
	}

	public AuthorResearchInterestPK getPrimaryKey() {
		return new AuthorResearchInterestPK(_authorId, _researchInterestId);
	}

	public void setPrimaryKey(AuthorResearchInterestPK pk) {
		setAuthorId(pk.authorId);
		setResearchInterestId(pk.researchInterestId);
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public long getResearchInterestId() {
		return _researchInterestId;
	}

	public void setResearchInterestId(long researchInterestId) {
		_researchInterestId = researchInterestId;
	}

	private long _authorId;
	private long _researchInterestId;
}