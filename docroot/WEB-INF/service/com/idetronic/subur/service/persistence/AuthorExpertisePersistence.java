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

import com.idetronic.subur.model.AuthorExpertise;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the author expertise service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorExpertisePersistenceImpl
 * @see AuthorExpertiseUtil
 * @generated
 */
public interface AuthorExpertisePersistence extends BasePersistence<AuthorExpertise> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorExpertiseUtil} to access the author expertise persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the author expertises where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findByAuthor(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author expertises where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findByAuthor(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author expertises where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findByAuthor(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise findByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise fetchByAuthor_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise findByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise fetchByAuthor_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author expertises before and after the current author expertise in the ordered set where authorId = &#63;.
	*
	* @param authorExpertisePK the primary key of the current author expertise
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise[] findByAuthor_PrevAndNext(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK,
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author expertises where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author expertises where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the author expertises where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @return the matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findByExpertise(
		long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author expertises where expertiseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expertiseId the expertise ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findByExpertise(
		long expertiseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author expertises where expertiseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expertiseId the expertise ID
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findByExpertise(
		long expertiseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise findByExpertise_First(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise fetchByExpertise_First(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise findByExpertise_Last(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author expertise, or <code>null</code> if a matching author expertise could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise fetchByExpertise_Last(
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author expertises before and after the current author expertise in the ordered set where expertiseId = &#63;.
	*
	* @param authorExpertisePK the primary key of the current author expertise
	* @param expertiseId the expertise ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise[] findByExpertise_PrevAndNext(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK,
		long expertiseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author expertises where expertiseId = &#63; from the database.
	*
	* @param expertiseId the expertise ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author expertises where expertiseId = &#63;.
	*
	* @param expertiseId the expertise ID
	* @return the number of matching author expertises
	* @throws SystemException if a system exception occurred
	*/
	public int countByExpertise(long expertiseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the author expertise in the entity cache if it is enabled.
	*
	* @param authorExpertise the author expertise
	*/
	public void cacheResult(
		com.idetronic.subur.model.AuthorExpertise authorExpertise);

	/**
	* Caches the author expertises in the entity cache if it is enabled.
	*
	* @param authorExpertises the author expertises
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.AuthorExpertise> authorExpertises);

	/**
	* Creates a new author expertise with the primary key. Does not add the author expertise to the database.
	*
	* @param authorExpertisePK the primary key for the new author expertise
	* @return the new author expertise
	*/
	public com.idetronic.subur.model.AuthorExpertise create(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK);

	/**
	* Removes the author expertise with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise that was removed
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise remove(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.AuthorExpertise updateImpl(
		com.idetronic.subur.model.AuthorExpertise authorExpertise)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author expertise with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorExpertiseException} if it could not be found.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise
	* @throws com.idetronic.subur.NoSuchAuthorExpertiseException if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise findByPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.idetronic.subur.NoSuchAuthorExpertiseException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author expertise with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorExpertisePK the primary key of the author expertise
	* @return the author expertise, or <code>null</code> if a author expertise with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.AuthorExpertise fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.AuthorExpertisePK authorExpertisePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the author expertises.
	*
	* @return the author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @return the range of author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author expertises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorExpertiseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author expertises
	* @param end the upper bound of the range of author expertises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of author expertises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.AuthorExpertise> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author expertises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author expertises.
	*
	* @return the number of author expertises
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}