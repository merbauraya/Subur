/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.idetronic.subur.service.impl;

import java.util.List;

import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;
import com.idetronic.subur.service.base.ItemTypeLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.SuburItemFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the item type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ItemTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ItemTypeLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ItemTypeLocalServiceUtil
 */
public class ItemTypeLocalServiceImpl extends ItemTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ItemTypeLocalServiceUtil} to access the item type local service.
	 */
	
	public ItemType add(String name,long companyId,long groupId) throws SystemException
	{
		long itemTypeId = CounterLocalServiceUtil.increment(ItemType.class.getName());
		ItemType itemType = itemTypePersistence.create(itemTypeId);
		itemType.setItemTypeName(name);
		itemType.setCompanyId(companyId);
		itemType.setGroupId(groupId);
		itemTypePersistence.update(itemType);
		return itemType;
		
	}
	
	/**
	 * 
	 */
	public List<ItemType> findByGroup(long companyId,long groupId,int start,int end,OrderByComparator obc) throws SystemException
	{
		return itemTypePersistence.findByGroup(companyId, groupId,start,end,obc);
		
	}
	public int countByGroup(long companyId,long groupId) throws SystemException
	{
		return itemTypePersistence.countByGroup(companyId, groupId);
	}
	public List<ItemType> findByCompany(long companyId,int start,int end) throws SystemException
	{
		return itemTypePersistence.findByCompany(companyId,start,end);
	}
	public int countByCompany(long companyId) throws SystemException
	{
		return itemTypePersistence.countByCompany(companyId);
	}
	/**
	 * Decrement overall item type count
	 */
	public void decrementCounter(long itemTypeId) throws SystemException
	{
		ItemType itemType = itemTypePersistence.fetchByPrimaryKey(itemTypeId);
		int newCount = itemType.getItemCount() -1 ;
		itemType.setItemCount(newCount);
		itemTypePersistence.update(itemType);
	}
	

	public void incrementCounter(long itemTypeId) throws SystemException
	{
		ItemType itemType = itemTypePersistence.fetchByPrimaryKey(itemTypeId);
		int newCount = itemType.getItemCount() +1 ;
		itemType.setItemCount(newCount);
		itemTypePersistence.update(itemType);
	
	}
	
	/**
	 * Increment approved item count
	 * @param itemTypeId
	 * @throws SystemException
	 */
	public void incrementApprovedCount(long itemTypeId) throws SystemException
	{
		ItemType itemType = itemTypePersistence.fetchByPrimaryKey(itemTypeId);
		int newCount = itemType.getApprovedCount() +1 ;
		itemType.setApprovedCount(newCount);
		itemTypePersistence.update(itemType);
	}
	
	/**
	 * Decrement approved item count
	 * @param itemTypeId
	 * @throws SystemException
	 */
	public void decrementApprovedCount(long itemTypeId) throws SystemException
	{
		ItemType itemType = itemTypePersistence.fetchByPrimaryKey(itemTypeId);
		int newCount = itemType.getApprovedCount() -1 ;
		itemType.setApprovedCount(newCount);
		itemTypePersistence.update(itemType);
	}
	
}