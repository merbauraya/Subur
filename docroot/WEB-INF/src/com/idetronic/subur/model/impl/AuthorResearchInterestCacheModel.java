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

package com.idetronic.subur.model.impl;

import com.idetronic.subur.model.AuthorResearchInterest;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AuthorResearchInterest in entity cache.
 *
 * @author Mazlan Mat
 * @see AuthorResearchInterest
 * @generated
 */
public class AuthorResearchInterestCacheModel implements CacheModel<AuthorResearchInterest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", researchInterestId=");
		sb.append(researchInterestId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuthorResearchInterest toEntityModel() {
		AuthorResearchInterestImpl authorResearchInterestImpl = new AuthorResearchInterestImpl();

		authorResearchInterestImpl.setAuthorId(authorId);
		authorResearchInterestImpl.setResearchInterestId(researchInterestId);

		authorResearchInterestImpl.resetOriginalValues();

		return authorResearchInterestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();
		researchInterestId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorId);
		objectOutput.writeLong(researchInterestId);
	}

	public long authorId;
	public long researchInterestId;
}