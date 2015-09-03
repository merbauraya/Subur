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

import com.idetronic.subur.model.ResearchInterest;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the research interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ResearchInterestPersistenceImpl
 * @see ResearchInterestUtil
 * @generated
 */
public interface ResearchInterestPersistence extends BasePersistence<ResearchInterest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResearchInterestUtil} to access the research interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the research interests where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research interests where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of research interests
	* @param end the upper bound of the range of research interests (not inclusive)
	* @return the range of matching research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research interests where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of research interests
	* @param end the upper bound of the range of research interests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research interest in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research interest
	* @throws com.idetronic.subur.NoSuchResearchInterestException if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research interest in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research interest, or <code>null</code> if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research interest in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research interest
	* @throws com.idetronic.subur.NoSuchResearchInterestException if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research interest in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research interest, or <code>null</code> if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research interests before and after the current research interest in the ordered set where groupId = &#63;.
	*
	* @param researchInterestId the primary key of the current research interest
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research interest
	* @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest[] findByGroup_PrevAndNext(
		long researchInterestId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the research interests where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research interests where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching research interests
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research interest where groupId = &#63; and indexedName = &#63; or throws a {@link com.idetronic.subur.NoSuchResearchInterestException} if it could not be found.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the matching research interest
	* @throws com.idetronic.subur.NoSuchResearchInterestException if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest findByGroupName(
		long groupId, java.lang.String indexedName)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research interest where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the matching research interest, or <code>null</code> if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest fetchByGroupName(
		long groupId, java.lang.String indexedName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research interest where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching research interest, or <code>null</code> if a matching research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest fetchByGroupName(
		long groupId, java.lang.String indexedName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the research interest where groupId = &#63; and indexedName = &#63; from the database.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the research interest that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest removeByGroupName(
		long groupId, java.lang.String indexedName)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research interests where groupId = &#63; and indexedName = &#63;.
	*
	* @param groupId the group ID
	* @param indexedName the indexed name
	* @return the number of matching research interests
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupName(long groupId, java.lang.String indexedName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the research interest in the entity cache if it is enabled.
	*
	* @param researchInterest the research interest
	*/
	public void cacheResult(
		com.idetronic.subur.model.ResearchInterest researchInterest);

	/**
	* Caches the research interests in the entity cache if it is enabled.
	*
	* @param researchInterests the research interests
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.ResearchInterest> researchInterests);

	/**
	* Creates a new research interest with the primary key. Does not add the research interest to the database.
	*
	* @param researchInterestId the primary key for the new research interest
	* @return the new research interest
	*/
	public com.idetronic.subur.model.ResearchInterest create(
		long researchInterestId);

	/**
	* Removes the research interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchInterestId the primary key of the research interest
	* @return the research interest that was removed
	* @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest remove(
		long researchInterestId)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.ResearchInterest updateImpl(
		com.idetronic.subur.model.ResearchInterest researchInterest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research interest with the primary key or throws a {@link com.idetronic.subur.NoSuchResearchInterestException} if it could not be found.
	*
	* @param researchInterestId the primary key of the research interest
	* @return the research interest
	* @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest findByPrimaryKey(
		long researchInterestId)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research interest with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param researchInterestId the primary key of the research interest
	* @return the research interest, or <code>null</code> if a research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.ResearchInterest fetchByPrimaryKey(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research interests.
	*
	* @return the research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research interests
	* @param end the upper bound of the range of research interests (not inclusive)
	* @return the range of research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research interests
	* @param end the upper bound of the range of research interests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the research interests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research interests.
	*
	* @return the number of research interests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}