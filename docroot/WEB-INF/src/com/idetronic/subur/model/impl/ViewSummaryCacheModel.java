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

import com.idetronic.subur.model.ViewSummary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ViewSummary in entity cache.
 *
 * @author Mazlan Mat
 * @see ViewSummary
 * @generated
 */
public class ViewSummaryCacheModel implements CacheModel<ViewSummary>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", perYear=");
		sb.append(perYear);
		sb.append(", perMonth=");
		sb.append(perMonth);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ViewSummary toEntityModel() {
		ViewSummaryImpl viewSummaryImpl = new ViewSummaryImpl();

		viewSummaryImpl.setId(id);
		viewSummaryImpl.setItemId(itemId);
		viewSummaryImpl.setCompanyId(companyId);
		viewSummaryImpl.setGroupId(groupId);
		viewSummaryImpl.setPerYear(perYear);
		viewSummaryImpl.setPerMonth(perMonth);
		viewSummaryImpl.setStatus(status);

		viewSummaryImpl.resetOriginalValues();

		return viewSummaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		itemId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		perYear = objectInput.readInt();
		perMonth = objectInput.readInt();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(itemId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeInt(perYear);
		objectOutput.writeInt(perMonth);
		objectOutput.writeInt(status);
	}

	public long id;
	public long itemId;
	public long companyId;
	public long groupId;
	public int perYear;
	public int perMonth;
	public int status;
}