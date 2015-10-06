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

import com.idetronic.subur.model.StatViewCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatViewCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see StatViewCategory
 * @generated
 */
public class StatViewCategoryCacheModel implements CacheModel<StatViewCategory>,
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
		sb.append(", perYear=");
		sb.append(perYear);
		sb.append(", perMonth=");
		sb.append(perMonth);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatViewCategory toEntityModel() {
		StatViewCategoryImpl statViewCategoryImpl = new StatViewCategoryImpl();

		statViewCategoryImpl.setId(id);
		statViewCategoryImpl.setCompanyId(companyId);
		statViewCategoryImpl.setGroupId(groupId);
		statViewCategoryImpl.setPerYear(perYear);
		statViewCategoryImpl.setPerMonth(perMonth);
		statViewCategoryImpl.setCategoryId(categoryId);
		statViewCategoryImpl.setViewCount(viewCount);

		statViewCategoryImpl.resetOriginalValues();

		return statViewCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		perYear = objectInput.readInt();
		perMonth = objectInput.readInt();
		categoryId = objectInput.readLong();
		viewCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(perYear);
		objectOutput.writeInt(perMonth);
		objectOutput.writeLong(categoryId);
		objectOutput.writeInt(viewCount);
	}

	public long id;
	public long companyId;
	public long groupId;
	public int perYear;
	public int perMonth;
	public long categoryId;
	public int viewCount;
}