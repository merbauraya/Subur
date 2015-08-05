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

import com.idetronic.subur.model.StatDownloadCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the stat download category service. This utility wraps {@link StatDownloadCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatDownloadCategoryPersistence
 * @see StatDownloadCategoryPersistenceImpl
 * @generated
 */
public class StatDownloadCategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(StatDownloadCategory statDownloadCategory) {
		getPersistence().clearCache(statDownloadCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StatDownloadCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StatDownloadCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StatDownloadCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StatDownloadCategory update(
		StatDownloadCategory statDownloadCategory) throws SystemException {
		return getPersistence().update(statDownloadCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StatDownloadCategory update(
		StatDownloadCategory statDownloadCategory, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(statDownloadCategory, serviceContext);
	}

	/**
	* Returns all the stat download categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadCategory> findByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	* Returns a range of all the stat download categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @return the range of matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadCategory> findByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the stat download categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadCategory> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory findByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching stat download category, or <code>null</code> if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory findByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last stat download category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching stat download category, or <code>null</code> if a matching stat download category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the stat download categories before and after the current stat download category in the ordered set where categoryId = &#63;.
	*
	* @param id the primary key of the current stat download category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory[] findByCategory_PrevAndNext(
		long id, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategory_PrevAndNext(id, categoryId, orderByComparator);
	}

	/**
	* Removes all the stat download categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Returns the number of stat download categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Caches the stat download category in the entity cache if it is enabled.
	*
	* @param statDownloadCategory the stat download category
	*/
	public static void cacheResult(
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory) {
		getPersistence().cacheResult(statDownloadCategory);
	}

	/**
	* Caches the stat download categories in the entity cache if it is enabled.
	*
	* @param statDownloadCategories the stat download categories
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.StatDownloadCategory> statDownloadCategories) {
		getPersistence().cacheResult(statDownloadCategories);
	}

	/**
	* Creates a new stat download category with the primary key. Does not add the stat download category to the database.
	*
	* @param id the primary key for the new stat download category
	* @return the new stat download category
	*/
	public static com.idetronic.subur.model.StatDownloadCategory create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the stat download category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stat download category
	* @return the stat download category that was removed
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory remove(long id)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.idetronic.subur.model.StatDownloadCategory updateImpl(
		com.idetronic.subur.model.StatDownloadCategory statDownloadCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(statDownloadCategory);
	}

	/**
	* Returns the stat download category with the primary key or throws a {@link com.idetronic.subur.NoSuchStatDownloadCategoryException} if it could not be found.
	*
	* @param id the primary key of the stat download category
	* @return the stat download category
	* @throws com.idetronic.subur.NoSuchStatDownloadCategoryException if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchStatDownloadCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the stat download category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the stat download category
	* @return the stat download category, or <code>null</code> if a stat download category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.StatDownloadCategory fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the stat download categories.
	*
	* @return the stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the stat download categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @return the range of stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the stat download categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatDownloadCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stat download categories
	* @param end the upper bound of the range of stat download categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.StatDownloadCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the stat download categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of stat download categories.
	*
	* @return the number of stat download categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StatDownloadCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StatDownloadCategoryPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					StatDownloadCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(StatDownloadCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StatDownloadCategoryPersistence persistence) {
	}

	private static StatDownloadCategoryPersistence _persistence;
}