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

import com.idetronic.subur.model.CopyRequest;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CopyRequest in entity cache.
 *
 * @author Mazlan Mat
 * @see CopyRequest
 * @generated
 */
public class CopyRequestCacheModel implements CacheModel<CopyRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{copyRequestId=");
		sb.append(copyRequestId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", dateCreated=");
		sb.append(dateCreated);
		sb.append(", status=");
		sb.append(status);
		sb.append(", suburItemId=");
		sb.append(suburItemId);
		sb.append(", fromEmailAddress=");
		sb.append(fromEmailAddress);
		sb.append(", requesterName=");
		sb.append(requesterName);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", organization=");
		sb.append(organization);
		sb.append(", dateResponsed=");
		sb.append(dateResponsed);
		sb.append(", respondText=");
		sb.append(respondText);
		sb.append(", responsedByUserId=");
		sb.append(responsedByUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CopyRequest toEntityModel() {
		CopyRequestImpl copyRequestImpl = new CopyRequestImpl();

		copyRequestImpl.setCopyRequestId(copyRequestId);
		copyRequestImpl.setCompanyId(companyId);
		copyRequestImpl.setGroupId(groupId);

		if (dateCreated == Long.MIN_VALUE) {
			copyRequestImpl.setDateCreated(null);
		}
		else {
			copyRequestImpl.setDateCreated(new Date(dateCreated));
		}

		copyRequestImpl.setStatus(status);
		copyRequestImpl.setSuburItemId(suburItemId);

		if (fromEmailAddress == null) {
			copyRequestImpl.setFromEmailAddress(StringPool.BLANK);
		}
		else {
			copyRequestImpl.setFromEmailAddress(fromEmailAddress);
		}

		if (requesterName == null) {
			copyRequestImpl.setRequesterName(StringPool.BLANK);
		}
		else {
			copyRequestImpl.setRequesterName(requesterName);
		}

		if (reason == null) {
			copyRequestImpl.setReason(StringPool.BLANK);
		}
		else {
			copyRequestImpl.setReason(reason);
		}

		if (organization == null) {
			copyRequestImpl.setOrganization(StringPool.BLANK);
		}
		else {
			copyRequestImpl.setOrganization(organization);
		}

		if (dateResponsed == Long.MIN_VALUE) {
			copyRequestImpl.setDateResponsed(null);
		}
		else {
			copyRequestImpl.setDateResponsed(new Date(dateResponsed));
		}

		if (respondText == null) {
			copyRequestImpl.setRespondText(StringPool.BLANK);
		}
		else {
			copyRequestImpl.setRespondText(respondText);
		}

		copyRequestImpl.setResponsedByUserId(responsedByUserId);

		copyRequestImpl.resetOriginalValues();

		return copyRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		copyRequestId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		dateCreated = objectInput.readLong();
		status = objectInput.readInt();
		suburItemId = objectInput.readLong();
		fromEmailAddress = objectInput.readUTF();
		requesterName = objectInput.readUTF();
		reason = objectInput.readUTF();
		organization = objectInput.readUTF();
		dateResponsed = objectInput.readLong();
		respondText = objectInput.readUTF();
		responsedByUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(copyRequestId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(dateCreated);
		objectOutput.writeInt(status);
		objectOutput.writeLong(suburItemId);

		if (fromEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fromEmailAddress);
		}

		if (requesterName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requesterName);
		}

		if (reason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (organization == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organization);
		}

		objectOutput.writeLong(dateResponsed);

		if (respondText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(respondText);
		}

		objectOutput.writeLong(responsedByUserId);
	}

	public long copyRequestId;
	public long companyId;
	public long groupId;
	public long dateCreated;
	public int status;
	public long suburItemId;
	public String fromEmailAddress;
	public String requesterName;
	public String reason;
	public String organization;
	public long dateResponsed;
	public String respondText;
	public long responsedByUserId;
}