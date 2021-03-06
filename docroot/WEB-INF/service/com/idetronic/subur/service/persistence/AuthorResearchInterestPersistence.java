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

import com.idetronic.subur.model.AuthorResearchInterest;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the author research interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorResearchInterestPersistenceImpl
 * @see AuthorResearchInterestUtil
 * @generated
 */
public interface AuthorResearchInterestPersistence extends BasePersistence<AuthorResearchInterest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorResearchInterestUtil} to access the author research interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the author research interests where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findByAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author research interests where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author research interests
	* @param end the upper bound of the range of author research interests (not inclusive)
	* @return the range of matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findByAuthor(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author research interests where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author research interests
	* @param end the upper bound of the range of author research interests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findByAuthor(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author research interest in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest findByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author research interest in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author research interest, or <code>null</code> if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest fetchByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author research interest in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest findByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author research interest in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author research interest, or <code>null</code> if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest fetchByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author research interests before and after the current author research interest in the ordered set where authorId = &#63;.
	*
	* @param authorResearchInterestPK the primary key of the current author research interest
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest[] findByAuthor_PrevAndNext(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK authorResearchInterestPK,
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author research interests where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author research interests where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the author research interests where researchInterestId = &#63;.
	*
	* @param researchInterestId the research interest ID
	* @return the matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findByResearchInterest(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author research interests where researchInterestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchInterestId the research interest ID
	* @param start the lower bound of the range of author research interests
	* @param end the upper bound of the range of author research interests (not inclusive)
	* @return the range of matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findByResearchInterest(
		long researchInterestId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author research interests where researchInterestId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchInterestId the research interest ID
	* @param start the lower bound of the range of author research interests
	* @param end the upper bound of the range of author research interests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findByResearchInterest(
		long researchInterestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author research interest in the ordered set where researchInterestId = &#63;.
	*
	* @param researchInterestId the research interest ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest findByResearchInterest_First(
		long researchInterestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author research interest in the ordered set where researchInterestId = &#63;.
	*
	* @param researchInterestId the research interest ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author research interest, or <code>null</code> if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest fetchByResearchInterest_First(
		long researchInterestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author research interest in the ordered set where researchInterestId = &#63;.
	*
	* @param researchInterestId the research interest ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest findByResearchInterest_Last(
		long researchInterestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author research interest in the ordered set where researchInterestId = &#63;.
	*
	* @param researchInterestId the research interest ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author research interest, or <code>null</code> if a matching author research interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest fetchByResearchInterest_Last(
		long researchInterestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author research interests before and after the current author research interest in the ordered set where researchInterestId = &#63;.
	*
	* @param authorResearchInterestPK the primary key of the current author research interest
	* @param researchInterestId the research interest ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest[] findByResearchInterest_PrevAndNext(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK authorResearchInterestPK,
		long researchInterestId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author research interests where researchInterestId = &#63; from the database.
	*
	* @param researchInterestId the research interest ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResearchInterest(long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author research interests where researchInterestId = &#63;.
	*
	* @param researchInterestId the research interest ID
	* @return the number of matching author research interests
	* @throws SystemException if a system exception occurred
	*/
	public int countByResearchInterest(long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the author research interest in the entity cache if it is enabled.
	*
	* @param authorResearchInterest the author research interest
	*/
	public void cacheResult(
		com.idetronic.subur.model.AuthorResearchInterest authorResearchInterest);

	/**
	* Caches the author research interests in the entity cache if it is enabled.
	*
	* @param authorResearchInterests the author research interests
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.AuthorResearchInterest> authorResearchInterests);

	/**
	* Creates a new author research interest with the primary key. Does not add the author research interest to the database.
	*
	* @param authorResearchInterestPK the primary key for the new author research interest
	* @return the new author research interest
	*/
	public com.idetronic.subur.model.AuthorResearchInterest create(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK authorResearchInterestPK);

	/**
	* Removes the author research interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorResearchInterestPK the primary key of the author research interest
	* @return the author research interest that was removed
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest remove(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK authorResearchInterestPK)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.AuthorResearchInterest updateImpl(
		com.idetronic.subur.model.AuthorResearchInterest authorResearchInterest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author research interest with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorResearchInterestException} if it could not be found.
	*
	* @param authorResearchInterestPK the primary key of the author research interest
	* @return the author research interest
	* @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest findByPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK authorResearchInterestPK)
		throws com.idetronic.subur.NoSuchAuthorResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author research interest with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorResearchInterestPK the primary key of the author research interest
	* @return the author research interest, or <code>null</code> if a author research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorResearchInterest fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorResearchInterestPK authorResearchInterestPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the author research interests.
	*
	* @return the author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author research interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author research interests
	* @param end the upper bound of the range of author research interests (not inclusive)
	* @return the range of author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author research interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author research interests
	* @param end the upper bound of the range of author research interests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of author research interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorResearchInterest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author research interests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author research interests.
	*
	* @return the number of author research interests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}