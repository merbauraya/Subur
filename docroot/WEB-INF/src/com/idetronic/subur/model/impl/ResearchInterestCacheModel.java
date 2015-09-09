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

import com.idetronic.subur.model.ResearchInterest;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResearchInterest in entity cache.
 *
 * @author Mazlan Mat
 * @see ResearchInterest
 * @generated
 */
public class ResearchInterestCacheModel implements CacheModel<ResearchInterest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{researchInterestId=");
		sb.append(researchInterestId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", indexedName=");
		sb.append(indexedName);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", authorCount=");
		sb.append(authorCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResearchInterest toEntityModel() {
		ResearchInterestImpl researchInterestImpl = new ResearchInterestImpl();

		researchInterestImpl.setResearchInterestId(researchInterestId);
		researchInterestImpl.setGroupId(groupId);
		researchInterestImpl.setCompanyId(companyId);
		researchInterestImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			researchInterestImpl.setCreateDate(null);
		}
		else {
			researchInterestImpl.setCreateDate(new Date(createDate));
		}

		if (name == null) {
			researchInterestImpl.setName(StringPool.BLANK);
		}
		else {
			researchInterestImpl.setName(name);
		}

		if (indexedName == null) {
			researchInterestImpl.setIndexedName(StringPool.BLANK);
		}
		else {
			researchInterestImpl.setIndexedName(indexedName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			researchInterestImpl.setModifiedDate(null);
		}
		else {
			researchInterestImpl.setModifiedDate(new Date(modifiedDate));
		}

		researchInterestImpl.setAuthorCount(authorCount);

		researchInterestImpl.resetOriginalValues();

		return researchInterestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		researchInterestId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		name = objectInput.readUTF();
		indexedName = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		authorCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(researchInterestId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (indexedName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indexedName);
		}

		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(authorCount);
	}

	public long researchInterestId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public String name;
	public String indexedName;
	public long modifiedDate;
	public int authorCount;
}