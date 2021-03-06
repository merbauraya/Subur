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

import com.idetronic.subur.model.Author;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Author in entity cache.
 *
 * @author Mazlan Mat
 * @see Author
 * @generated
 */
public class AuthorCacheModel implements CacheModel<Author>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", salutation=");
		sb.append(salutation);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", metadata=");
		sb.append(metadata);
		sb.append(", lastPublishedDate=");
		sb.append(lastPublishedDate);
		sb.append(", itemCount=");
		sb.append(itemCount);
		sb.append(", email=");
		sb.append(email);
		sb.append(", officeNo=");
		sb.append(officeNo);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", Uuid=");
		sb.append(Uuid);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", portraitId=");
		sb.append(portraitId);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);
		authorImpl.setGroupId(groupId);
		authorImpl.setCompanyId(companyId);

		if (salutation == null) {
			authorImpl.setSalutation(StringPool.BLANK);
		}
		else {
			authorImpl.setSalutation(salutation);
		}

		if (firstName == null) {
			authorImpl.setFirstName(StringPool.BLANK);
		}
		else {
			authorImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			authorImpl.setLastName(StringPool.BLANK);
		}
		else {
			authorImpl.setLastName(lastName);
		}

		if (middleName == null) {
			authorImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			authorImpl.setMiddleName(middleName);
		}

		authorImpl.setUserId(userId);

		if (metadata == null) {
			authorImpl.setMetadata(StringPool.BLANK);
		}
		else {
			authorImpl.setMetadata(metadata);
		}

		if (lastPublishedDate == Long.MIN_VALUE) {
			authorImpl.setLastPublishedDate(null);
		}
		else {
			authorImpl.setLastPublishedDate(new Date(lastPublishedDate));
		}

		authorImpl.setItemCount(itemCount);

		if (email == null) {
			authorImpl.setEmail(StringPool.BLANK);
		}
		else {
			authorImpl.setEmail(email);
		}

		if (officeNo == null) {
			authorImpl.setOfficeNo(StringPool.BLANK);
		}
		else {
			authorImpl.setOfficeNo(officeNo);
		}

		if (createDate == Long.MIN_VALUE) {
			authorImpl.setCreateDate(null);
		}
		else {
			authorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			authorImpl.setModifiedDate(null);
		}
		else {
			authorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (Uuid == null) {
			authorImpl.setUuid(StringPool.BLANK);
		}
		else {
			authorImpl.setUuid(Uuid);
		}

		authorImpl.setCreatedBy(createdBy);
		authorImpl.setPortraitId(portraitId);

		if (title == null) {
			authorImpl.setTitle(StringPool.BLANK);
		}
		else {
			authorImpl.setTitle(title);
		}

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		authorId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		salutation = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		userId = objectInput.readInt();
		metadata = objectInput.readUTF();
		lastPublishedDate = objectInput.readLong();
		itemCount = objectInput.readInt();
		email = objectInput.readUTF();
		officeNo = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		Uuid = objectInput.readUTF();
		createdBy = objectInput.readLong();
		portraitId = objectInput.readLong();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(authorId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (salutation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(salutation);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		objectOutput.writeInt(userId);

		if (metadata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadata);
		}

		objectOutput.writeLong(lastPublishedDate);
		objectOutput.writeInt(itemCount);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (officeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeNo);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (Uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Uuid);
		}

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(portraitId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public long authorId;
	public long groupId;
	public long companyId;
	public String salutation;
	public String firstName;
	public String lastName;
	public String middleName;
	public int userId;
	public String metadata;
	public long lastPublishedDate;
	public int itemCount;
	public String email;
	public String officeNo;
	public long createDate;
	public long modifiedDate;
	public String Uuid;
	public long createdBy;
	public long portraitId;
	public String title;
}