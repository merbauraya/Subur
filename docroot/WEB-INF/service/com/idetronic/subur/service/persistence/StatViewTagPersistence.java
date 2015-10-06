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

import com.idetronic.subur.model.StatViewTag;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat view tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewTagPersistenceImpl
 * @see StatViewTagUtil
 * @generated
 */
public interface StatViewTagPersistence extends BasePersistence<StatViewTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatViewTagUtil} to access the stat view tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; or throws a {@link com.idetronic.subur.NoSuchStatViewTagException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param tagId the tag ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the matching stat view tag
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag findByTagPeriod(
		long companyId, long groupId, long tagId, int perYear, int perMonth)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param tagId the tag ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the matching stat view tag, or <code>null</code> if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag fetchByTagPeriod(
		long companyId, long groupId, long tagId, int perYear, int perMonth)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param tagId the tag ID
	* @param perYear the per year
	* @param perMonth the per month
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching stat view tag, or <code>null</code> if a matching stat view tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag fetchByTagPeriod(
		long companyId, long groupId, long tagId, int perYear, int perMonth,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param tagId the tag ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the stat view tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag removeByTagPeriod(
		long companyId, long groupId, long tagId, int perYear, int perMonth)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view tags where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param tagId the tag ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the number of matching stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public int countByTagPeriod(long companyId, long groupId, long tagId,
		int perYear, int perMonth)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat view tag in the entity cache if it is enabled.
	*
	* @param statViewTag the stat view tag
	*/
	public void cacheResult(com.idetronic.subur.model.StatViewTag statViewTag);

	/**
	* Caches the stat view tags in the entity cache if it is enabled.
	*
	* @param statViewTags the stat view tags
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatViewTag> statViewTags);

	/**
	* Creates a new stat view tag with the primary key. Does not add the stat view tag to the database.
	*
	* @param id the primary key for the new stat view tag
	* @return the new stat view tag
	*/
	public com.idetronic.subur.model.StatViewTag create(long id);

	/**
	* Removes the stat view tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag that was removed
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag remove(long id)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatViewTag updateImpl(
		com.idetronic.subur.model.StatViewTag statViewTag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view tag with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewTagException} if it could not be found.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag
	* @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchStatViewTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat view tag
	* @return the stat view tag, or <code>null</code> if a stat view tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewTag fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat view tags.
	*
	* @return the stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat view tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @return the range of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat view tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view tags
	* @param end the upper bound of the range of stat view tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat view tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view tags.
	*
	* @return the number of stat view tags
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}