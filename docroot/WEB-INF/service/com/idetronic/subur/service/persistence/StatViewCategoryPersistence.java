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

import com.idetronic.subur.model.StatViewCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the stat view category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewCategoryPersistenceImpl
 * @see StatViewCategoryUtil
 * @generated
 */
public interface StatViewCategoryPersistence extends BasePersistence<StatViewCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatViewCategoryUtil} to access the stat view category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the stat view categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewCategory> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat view categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of stat view categories
	* @param end the upper bound of the range of stat view categories (not inclusive)
	* @return the range of matching stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewCategory> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat view categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of stat view categories
	* @param end the upper bound of the range of stat view categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewCategory> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat view category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view category
	* @throws com.idetronic.subur.NoSuchStatViewCategoryException if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first stat view category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat view category, or <code>null</code> if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat view category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view category
	* @throws com.idetronic.subur.NoSuchStatViewCategoryException if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last stat view category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat view category, or <code>null</code> if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view categories before and after the current stat view category in the ordered set where categoryId = &#63;.
	*
	* @param id the primary key of the current stat view category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat view category
	* @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory[] findByCategory_PrevAndNext(
		long id, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat view categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view category where companyId = &#63; and groupId = &#63; and categoryId = &#63; and perYear = &#63; and perMonth = &#63; or throws a {@link com.idetronic.subur.NoSuchStatViewCategoryException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the matching stat view category
	* @throws com.idetronic.subur.NoSuchStatViewCategoryException if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory findByCategoryPeriod(
		long companyId, long groupId, long categoryId, int perYear, int perMonth)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view category where companyId = &#63; and groupId = &#63; and categoryId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the matching stat view category, or <code>null</code> if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory fetchByCategoryPeriod(
		long companyId, long groupId, long categoryId, int perYear, int perMonth)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view category where companyId = &#63; and groupId = &#63; and categoryId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param perYear the per year
	* @param perMonth the per month
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching stat view category, or <code>null</code> if a matching stat view category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory fetchByCategoryPeriod(
		long companyId, long groupId, long categoryId, int perYear,
		int perMonth, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the stat view category where companyId = &#63; and groupId = &#63; and categoryId = &#63; and perYear = &#63; and perMonth = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the stat view category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory removeByCategoryPeriod(
		long companyId, long groupId, long categoryId, int perYear, int perMonth)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view categories where companyId = &#63; and groupId = &#63; and categoryId = &#63; and perYear = &#63; and perMonth = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param perYear the per year
	* @param perMonth the per month
	* @return the number of matching stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryPeriod(long companyId, long groupId,
		long categoryId, int perYear, int perMonth)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the stat view category in the entity cache if it is enabled.
	*
	* @param statViewCategory the stat view category
	*/
	public void cacheResult(
		com.idetronic.subur.model.StatViewCategory statViewCategory);

	/**
	* Caches the stat view categories in the entity cache if it is enabled.
	*
	* @param statViewCategories the stat view categories
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.StatViewCategory> statViewCategories);

	/**
	* Creates a new stat view category with the primary key. Does not add the stat view category to the database.
	*
	* @param id the primary key for the new stat view category
	* @return the new stat view category
	*/
	public com.idetronic.subur.model.StatViewCategory create(long id);

	/**
	* Removes the stat view category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat view category
	* @return the stat view category that was removed
	* @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory remove(long id)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.StatViewCategory updateImpl(
		com.idetronic.subur.model.StatViewCategory statViewCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view category with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewCategoryException} if it could not be found.
	*
	* @param id the primary key of the stat view category
	* @return the stat view category
	* @throws com.idetronic.subur.NoSuchStatViewCategoryException if a stat view category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchStatViewCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the stat view category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat view category
	* @return the stat view category, or <code>null</code> if a stat view category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.StatViewCategory fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the stat view categories.
	*
	* @return the stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the stat view categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view categories
	* @param end the upper bound of the range of stat view categories (not inclusive)
	* @return the range of stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the stat view categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat view categories
	* @param end the upper bound of the range of stat view categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.StatViewCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the stat view categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of stat view categories.
	*
	* @return the number of stat view categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}