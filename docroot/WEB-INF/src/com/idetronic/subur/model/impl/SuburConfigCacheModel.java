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

import com.idetronic.subur.model.SuburConfig;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SuburConfig in entity cache.
 *
 * @author Mazlan Mat
 * @see SuburConfig
 * @generated
 */
public class SuburConfigCacheModel implements CacheModel<SuburConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", key=");
		sb.append(key);
		sb.append(", description=");
		sb.append(description);
		sb.append(", config=");
		sb.append(config);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SuburConfig toEntityModel() {
		SuburConfigImpl suburConfigImpl = new SuburConfigImpl();

		suburConfigImpl.setId(id);

		if (key == null) {
			suburConfigImpl.setKey(StringPool.BLANK);
		}
		else {
			suburConfigImpl.setKey(key);
		}

		if (description == null) {
			suburConfigImpl.setDescription(StringPool.BLANK);
		}
		else {
			suburConfigImpl.setDescription(description);
		}

		if (config == null) {
			suburConfigImpl.setConfig(StringPool.BLANK);
		}
		else {
			suburConfigImpl.setConfig(config);
		}

		suburConfigImpl.resetOriginalValues();

		return suburConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		key = objectInput.readUTF();
		description = objectInput.readUTF();
		config = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (config == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(config);
		}
	}

	public long id;
	public String key;
	public String description;
	public String config;
}