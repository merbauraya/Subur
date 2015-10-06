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

package com.idetronic.subur.service.persistence;

import com.idetronic.subur.model.StatViewItemType;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat view item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewItemTypePersistenceImpl
 * @see StatViewItemTypeUtil
 * @generated
 */
public interface StatViewItemTypePersistence extends BasePersistence<StatViewItemType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatViewItemTypeUtil} to access the stat view item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; or throws a {@link com.idetronic.subur.NoSuchStatViewItemTypeException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param itemTypeId the item type ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the matching stat view item type
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType findByItemTypePeriodGroup(
		long companyId, long groupId, long itemTypeId, int perYear, int perMonth)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param itemTypeId the item type ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the matching stat view item type, or <code>null</code> if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType fetchByItemTypePeriodGroup(
		long companyId, long groupId, long itemTypeId, int perYear, int perMonth)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param itemTypeId the item type ID
	* @param perYear the per year
	* @param perMonth the per month
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching stat view item type, or <code>null</code> if a matching stat view item type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType fetchByItemTypePeriodGroup(
		long companyId, long groupId, long itemTypeId, int perYear,
		int perMonth, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param itemTypeId the item type ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the stat view item type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType removeByItemTypePeriodGroup(
		long companyId, long groupId, long itemTypeId, int perYear, int perMonth)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view item types where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param itemTypeId the item type ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the number of matching stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemTypePeriodGroup(long companyId, long groupId,
		long itemTypeId, int perYear, int perMonth)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat view item type in the entity cache if it is enabled.
	*
	* @param statViewItemType the stat view item type
	*/
	public void cacheResult(
		com.idetronic.subur.model.StatViewItemType statViewItemType);

	/**
	* Caches the stat view item types in the entity cache if it is enabled.
	*
	* @param statViewItemTypes the stat view item types
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatViewItemType> statViewItemTypes);

	/**
	* Creates a new stat view item type with the primary key. Does not add the stat view item type to the database.
	*
	* @param id the primary key for the new stat view item type
	* @return the new stat view item type
	*/
	public com.idetronic.subur.model.StatViewItemType create(long id);

	/**
	* Removes the stat view item type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type that was removed
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType remove(long id)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatViewItemType updateImpl(
		com.idetronic.subur.model.StatViewItemType statViewItemType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view item type with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewItemTypeException} if it could not be found.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type
	* @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchStatViewItemTypeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view item type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat view item type
	* @return the stat view item type, or <code>null</code> if a stat view item type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewItemType fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat view item types.
	*
	* @return the stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewItemType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat view item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @return the range of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewItemType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat view item types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view item types
	* @param end the upper bound of the range of stat view item types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat view item types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view item types.
	*
	* @return the number of stat view item types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}