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

import com.idetronic.subur.model.StatViewTag;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatViewTag in entity cache.
 *
 * @author Mazlan Mat
 * @see StatViewTag
 * @generated
 */
public class StatViewTagCacheModel implements CacheModel<StatViewTag>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", perMonth=");
		sb.append(perMonth);
		sb.append(", perYear=");
		sb.append(perYear);
		sb.append(", tagId=");
		sb.append(tagId);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatViewTag toEntityModel() {
		StatViewTagImpl statViewTagImpl = new StatViewTagImpl();

		statViewTagImpl.setId(id);
		statViewTagImpl.setCompanyId(companyId);
		statViewTagImpl.setGroupId(groupId);
		statViewTagImpl.setPerMonth(perMonth);
		statViewTagImpl.setPerYear(perYear);
		statViewTagImpl.setTagId(tagId);
		statViewTagImpl.setViewCount(viewCount);

		statViewTagImpl.resetOriginalValues();

		return statViewTagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		perMonth = objectInput.readInt();
		perYear = objectInput.readInt();
		tagId = objectInput.readLong();
		viewCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(perMonth);
		objectOutput.writeInt(perYear);
		objectOutput.writeLong(tagId);
		objectOutput.writeInt(viewCount);
	}

	public long id;
	public long companyId;
	public long groupId;
	public int perMonth;
	public int perYear;
	public long tagId;
	public int viewCount;
}