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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class ItemTypeSoap implements Serializable {
	public static ItemTypeSoap toSoapModel(ItemType model) {
		ItemTypeSoap soapModel = new ItemTypeSoap();

		soapModel.setItemTypeId(model.getItemTypeId());
		soapModel.setItemTypeName(model.getItemTypeName());
		soapModel.setItemCount(model.getItemCount());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setApprovedCount(model.getApprovedCount());

		return soapModel;
	}

	public static ItemTypeSoap[] toSoapModels(ItemType[] models) {
		ItemTypeSoap[] soapModels = new ItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[][] toSoapModels(ItemType[][] models) {
		ItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ItemTypeSoap[] toSoapModels(List<ItemType> models) {
		List<ItemTypeSoap> soapModels = new ArrayList<ItemTypeSoap>(models.size());

		for (ItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ItemTypeSoap[soapModels.size()]);
	}

	public ItemTypeSoap() {
	}

	public long getPrimaryKey() {
		return _itemTypeId;
	}

	public void setPrimaryKey(long pk) {
		setItemTypeId(pk);
	}

	public long getItemTypeId() {
		return _itemTypeId;
	}

	public void setItemTypeId(long itemTypeId) {
		_itemTypeId = itemTypeId;
	}

	public String getItemTypeName() {
		return _itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		_itemTypeName = itemTypeName;
	}

	public int getItemCount() {
		return _itemCount;
	}

	public void setItemCount(int itemCount) {
		_itemCount = itemCount;
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

	public int getApprovedCount() {
		return _approvedCount;
	}

	public void setApprovedCount(int approvedCount) {
		_approvedCount = approvedCount;
	}

	private long _itemTypeId;
	private String _itemTypeName;
	private int _itemCount;
	private long _companyId;
	private long _groupId;
	private int _approvedCount;
}