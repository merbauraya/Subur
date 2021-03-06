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

import com.idetronic.subur.model.SuburItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the subur item service. This utility wraps {@link SuburItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburItemPersistence
 * @see SuburItemPersistenceImpl
 * @generated
 */
public class SuburItemUtil {
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
	public static void clearCache(SuburItem suburItem) {
		getPersistence().clearCache(suburItem);
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
	public static List<SuburItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SuburItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SuburItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SuburItem update(SuburItem suburItem)
		throws SystemException {
		return getPersistence().update(suburItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SuburItem update(SuburItem suburItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(suburItem, serviceContext);
	}

	/**
	* Returns all the subur items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the subur items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where groupId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByGroupId_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(itemId, groupId, orderByComparator);
	}

	/**
	* Returns all the subur items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the subur items that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where groupId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] filterFindByGroupId_PrevAndNext(
		long itemId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(itemId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the subur items where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of subur items where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of subur items that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the subur items where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupStatus(
		long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupStatus(companyId, groupId, status);
	}

	/**
	* Returns a range of all the subur items where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupStatus(
		long companyId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus(companyId, groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupStatus(
		long companyId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus(companyId, groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupStatus_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus_First(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupStatus_First(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupStatus_First(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupStatus_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus_Last(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupStatus_Last(
		long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupStatus_Last(companyId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByGroupStatus_PrevAndNext(
		long itemId, long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupStatus_PrevAndNext(itemId, companyId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupStatus(
		long companyId, long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus(companyId, groupId, status);
	}

	/**
	* Returns a range of all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupStatus(
		long companyId, long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus(companyId, groupId, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupStatus(
		long companyId, long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus(companyId, groupId, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] filterFindByGroupStatus_PrevAndNext(
		long itemId, long companyId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupStatus_PrevAndNext(itemId, companyId,
			groupId, status, orderByComparator);
	}

	/**
	* Removes all the subur items where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupStatus(long companyId, long groupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupStatus(companyId, groupId, status);
	}

	/**
	* Returns the number of subur items where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupStatus(long companyId, long groupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupStatus(companyId, groupId, status);
	}

	/**
	* Returns the number of subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupStatus(long companyId, long groupId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByGroupStatus(companyId, groupId, status);
	}

	/**
	* Returns all the subur items where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the subur items where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_First(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_Last(companyId, groupId, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByGroup_PrevAndNext(
		long itemId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_PrevAndNext(itemId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(companyId, groupId);
	}

	/**
	* Returns a range of all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup(companyId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup(companyId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] filterFindByGroup_PrevAndNext(
		long itemId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_PrevAndNext(itemId, companyId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the subur items where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup(companyId, groupId);
	}

	/**
	* Returns the number of subur items where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup(companyId, groupId);
	}

	/**
	* Returns the number of subur items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup(companyId, groupId);
	}

	/**
	* Returns all the subur items where status = &#63;.
	*
	* @param status the status
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the subur items where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where status = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByStatus_PrevAndNext(
		long itemId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(itemId, status, orderByComparator);
	}

	/**
	* Removes all the subur items where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of subur items where status = &#63;.
	*
	* @param status the status
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupCreatorStatus(
		long companyId, long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreatorStatus(companyId, groupId, userId, status);
	}

	/**
	* Returns a range of all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupCreatorStatus(
		long companyId, long groupId, long userId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreatorStatus(companyId, groupId, userId,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupCreatorStatus(
		long companyId, long groupId, long userId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreatorStatus(companyId, groupId, userId,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupCreatorStatus_First(
		long companyId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreatorStatus_First(companyId, groupId, userId,
			status, orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupCreatorStatus_First(
		long companyId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCreatorStatus_First(companyId, groupId, userId,
			status, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupCreatorStatus_Last(
		long companyId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreatorStatus_Last(companyId, groupId, userId,
			status, orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupCreatorStatus_Last(
		long companyId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCreatorStatus_Last(companyId, groupId, userId,
			status, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByGroupCreatorStatus_PrevAndNext(
		long itemId, long companyId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreatorStatus_PrevAndNext(itemId, companyId,
			groupId, userId, status, orderByComparator);
	}

	/**
	* Returns all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupCreatorStatus(
		long companyId, long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreatorStatus(companyId, groupId, userId,
			status);
	}

	/**
	* Returns a range of all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupCreatorStatus(
		long companyId, long groupId, long userId, int status, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreatorStatus(companyId, groupId, userId,
			status, start, end);
	}

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupCreatorStatus(
		long companyId, long groupId, long userId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreatorStatus(companyId, groupId, userId,
			status, start, end, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] filterFindByGroupCreatorStatus_PrevAndNext(
		long itemId, long companyId, long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreatorStatus_PrevAndNext(itemId,
			companyId, groupId, userId, status, orderByComparator);
	}

	/**
	* Removes all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCreatorStatus(long companyId, long groupId,
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByGroupCreatorStatus(companyId, groupId, userId, status);
	}

	/**
	* Returns the number of subur items where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCreatorStatus(long companyId, long groupId,
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupCreatorStatus(companyId, groupId, userId, status);
	}

	/**
	* Returns the number of subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63; and status = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param status the status
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByGroupCreatorStatus(companyId, groupId, userId,
			status);
	}

	/**
	* Returns all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupCreator(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupCreator(companyId, groupId, userId);
	}

	/**
	* Returns a range of all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupCreator(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreator(companyId, groupId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByGroupCreator(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreator(companyId, groupId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupCreator_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreator_First(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupCreator_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCreator_First(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByGroupCreator_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreator_Last(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByGroupCreator_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupCreator_Last(companyId, groupId, userId,
			orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByGroupCreator_PrevAndNext(
		long itemId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupCreator_PrevAndNext(itemId, companyId, groupId,
			userId, orderByComparator);
	}

	/**
	* Returns all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupCreator(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreator(companyId, groupId, userId);
	}

	/**
	* Returns a range of all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupCreator(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreator(companyId, groupId, userId, start,
			end);
	}

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByGroupCreator(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreator(companyId, groupId, userId, start,
			end, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] filterFindByGroupCreator_PrevAndNext(
		long itemId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupCreator_PrevAndNext(itemId, companyId,
			groupId, userId, orderByComparator);
	}

	/**
	* Removes all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupCreator(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupCreator(companyId, groupId, userId);
	}

	/**
	* Returns the number of subur items where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupCreator(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupCreator(companyId, groupId, userId);
	}

	/**
	* Returns the number of subur items that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupCreator(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByGroupCreator(companyId, groupId, userId);
	}

	/**
	* Returns all the subur items where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByStatusByGroup(
		int status, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusByGroup(status, groupId, companyId);
	}

	/**
	* Returns a range of all the subur items where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByStatusByGroup(
		int status, long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusByGroup(status, groupId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the subur items where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findByStatusByGroup(
		int status, long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusByGroup(status, groupId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByStatusByGroup_First(
		int status, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusByGroup_First(status, groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first subur item in the ordered set where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByStatusByGroup_First(
		int status, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusByGroup_First(status, groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item
	* @throws com.idetronic.subur.NoSuchItemException if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByStatusByGroup_Last(
		int status, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusByGroup_Last(status, groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last subur item in the ordered set where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByStatusByGroup_Last(
		int status, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusByGroup_Last(status, groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] findByStatusByGroup_PrevAndNext(
		long itemId, int status, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusByGroup_PrevAndNext(itemId, status, groupId,
			companyId, orderByComparator);
	}

	/**
	* Returns all the subur items that the user has permission to view where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByStatusByGroup(
		int status, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusByGroup(status, groupId, companyId);
	}

	/**
	* Returns a range of all the subur items that the user has permission to view where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByStatusByGroup(
		int status, long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusByGroup(status, groupId, companyId,
			start, end);
	}

	/**
	* Returns an ordered range of all the subur items that the user has permissions to view where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> filterFindByStatusByGroup(
		int status, long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusByGroup(status, groupId, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the subur items before and after the current subur item in the ordered set of subur items that the user has permission to view where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param itemId the primary key of the current subur item
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem[] filterFindByStatusByGroup_PrevAndNext(
		long itemId, int status, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByStatusByGroup_PrevAndNext(itemId, status,
			groupId, companyId, orderByComparator);
	}

	/**
	* Removes all the subur items where status = &#63; and groupId = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusByGroup(int status, long groupId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusByGroup(status, groupId, companyId);
	}

	/**
	* Returns the number of subur items where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusByGroup(int status, long groupId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusByGroup(status, groupId, companyId);
	}

	/**
	* Returns the number of subur items that the user has permission to view where status = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching subur items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByStatusByGroup(int status, long groupId,
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByStatusByGroup(status, groupId, companyId);
	}

	/**
	* Caches the subur item in the entity cache if it is enabled.
	*
	* @param suburItem the subur item
	*/
	public static void cacheResult(
		com.idetronic.subur.model.SuburItem suburItem) {
		getPersistence().cacheResult(suburItem);
	}

	/**
	* Caches the subur items in the entity cache if it is enabled.
	*
	* @param suburItems the subur items
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.SuburItem> suburItems) {
		getPersistence().cacheResult(suburItems);
	}

	/**
	* Creates a new subur item with the primary key. Does not add the subur item to the database.
	*
	* @param itemId the primary key for the new subur item
	* @return the new subur item
	*/
	public static com.idetronic.subur.model.SuburItem create(long itemId) {
		return getPersistence().create(itemId);
	}

	/**
	* Removes the subur item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item that was removed
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem remove(long itemId)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(itemId);
	}

	public static com.idetronic.subur.model.SuburItem updateImpl(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(suburItem);
	}

	/**
	* Returns the subur item with the primary key or throws a {@link com.idetronic.subur.NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item
	* @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem findByPrimaryKey(
		long itemId)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(itemId);
	}

	/**
	* Returns the subur item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the subur item
	* @return the subur item, or <code>null</code> if a subur item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemId);
	}

	/**
	* Returns all the subur items.
	*
	* @return the subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subur items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @return the range of subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subur items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subur items
	* @param end the upper bound of the range of subur items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subur items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subur items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subur items.
	*
	* @return the number of subur items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SuburItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SuburItemPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					SuburItemPersistence.class.getName());

			ReferenceRegistry.registerReference(SuburItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SuburItemPersistence persistence) {
	}

	private static SuburItemPersistence _persistence;
}