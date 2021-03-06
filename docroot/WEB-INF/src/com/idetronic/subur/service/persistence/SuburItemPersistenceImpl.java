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

import com.idetronic.subur.NoSuchItemException;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.impl.SuburItemImpl;
import com.idetronic.subur.model.impl.SuburItemModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the subur item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburItemPersistence
 * @see SuburItemUtil
 * @generated
 */
public class SuburItemPersistenceImpl extends BasePersistenceImpl<SuburItem>
	implements SuburItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SuburItemUtil} to access the subur item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SuburItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SuburItemModelImpl.GROUPID_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the subur items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<SuburItem> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((groupId != suburItem.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupId_First(groupId, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the first subur item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SuburItem> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupId_Last(groupId, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the last subur item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByGroupId_PrevAndNext(long itemId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, suburItem, groupId,
					orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByGroupId_PrevAndNext(session, suburItem, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByGroupId_PrevAndNext(Session session,
		SuburItem suburItem, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the subur items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching subur items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<SuburItem> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SuburItem[] filterFindByGroupId_PrevAndNext(long itemId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(itemId, groupId, orderByComparator);
		}

		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, suburItem,
					groupId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = filterGetByGroupId_PrevAndNext(session, suburItem,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem filterGetByGroupId_PrevAndNext(Session session,
		SuburItem suburItem, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subur items where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (SuburItem suburItem : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
	}

	/**
	 * Returns the number of subur items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of subur items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching subur items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "suburItem.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPSTATUS =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SuburItemModelImpl.COMPANYID_COLUMN_BITMASK |
			SuburItemModelImpl.GROUPID_COLUMN_BITMASK |
			SuburItemModelImpl.STATUS_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPSTATUS = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the subur items where companyId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findByGroupStatus(long companyId, long groupId,
		int status) throws SystemException {
		return findByGroupStatus(companyId, groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByGroupStatus(long companyId, long groupId,
		int status, int start, int end) throws SystemException {
		return findByGroupStatus(companyId, groupId, status, start, end, null);
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
	@Override
	public List<SuburItem> findByGroupStatus(long companyId, long groupId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS;
			finderArgs = new Object[] { companyId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPSTATUS;
			finderArgs = new Object[] {
					companyId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((companyId != suburItem.getCompanyId()) ||
						(groupId != suburItem.getGroupId()) ||
						(status != suburItem.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByGroupStatus_First(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupStatus_First(companyId, groupId,
				status, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroupStatus_First(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<SuburItem> list = findByGroupStatus(companyId, groupId, status, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByGroupStatus_Last(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupStatus_Last(companyId, groupId,
				status, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroupStatus_Last(long companyId, long groupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupStatus(companyId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByGroupStatus(companyId, groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByGroupStatus_PrevAndNext(long itemId,
		long companyId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByGroupStatus_PrevAndNext(session, suburItem,
					companyId, groupId, status, orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByGroupStatus_PrevAndNext(session, suburItem,
					companyId, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByGroupStatus_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SuburItem> filterFindByGroupStatus(long companyId,
		long groupId, int status) throws SystemException {
		return filterFindByGroupStatus(companyId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> filterFindByGroupStatus(long companyId,
		long groupId, int status, int start, int end) throws SystemException {
		return filterFindByGroupStatus(companyId, groupId, status, start, end,
			null);
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
	@Override
	public List<SuburItem> filterFindByGroupStatus(long companyId,
		long groupId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupStatus(companyId, groupId, status, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(status);

			return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SuburItem[] filterFindByGroupStatus_PrevAndNext(long itemId,
		long companyId, long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupStatus_PrevAndNext(itemId, companyId, groupId,
				status, orderByComparator);
		}

		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = filterGetByGroupStatus_PrevAndNext(session, suburItem,
					companyId, groupId, status, orderByComparator, true);

			array[1] = suburItem;

			array[2] = filterGetByGroupStatus_PrevAndNext(session, suburItem,
					companyId, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem filterGetByGroupStatus_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subur items where companyId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupStatus(long companyId, long groupId, int status)
		throws SystemException {
		for (SuburItem suburItem : findByGroupStatus(companyId, groupId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
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
	@Override
	public int countByGroupStatus(long companyId, long groupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPSTATUS;

		Object[] finderArgs = new Object[] { companyId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
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
	@Override
	public int filterCountByGroupStatus(long companyId, long groupId, int status)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupStatus(companyId, groupId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPSTATUS_COMPANYID_2 = "suburItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPSTATUS_GROUPID_2 = "suburItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPSTATUS_STATUS_2 = "suburItem.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			SuburItemModelImpl.COMPANYID_COLUMN_BITMASK |
			SuburItemModelImpl.GROUPID_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the subur items where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findByGroup(long companyId, long groupId)
		throws SystemException {
		return findByGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByGroup(long companyId, long groupId, int start,
		int end) throws SystemException {
		return findByGroup(companyId, groupId, start, end, null);
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
	@Override
	public List<SuburItem> findByGroup(long companyId, long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((companyId != suburItem.getCompanyId()) ||
						(groupId != suburItem.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroup_First(companyId, groupId,
				orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SuburItem> list = findByGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroup_Last(companyId, groupId,
				orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByGroup(companyId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByGroup_PrevAndNext(long itemId, long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByGroup_PrevAndNext(session, suburItem, companyId,
					groupId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByGroup_PrevAndNext(session, suburItem, companyId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByGroup_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the subur items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching subur items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> filterFindByGroup(long companyId, long groupId)
		throws SystemException {
		return filterFindByGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> filterFindByGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return filterFindByGroup(companyId, groupId, start, end, null);
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
	@Override
	public List<SuburItem> filterFindByGroup(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup(companyId, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SuburItem[] filterFindByGroup_PrevAndNext(long itemId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroup_PrevAndNext(itemId, companyId, groupId,
				orderByComparator);
		}

		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = filterGetByGroup_PrevAndNext(session, suburItem,
					companyId, groupId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = filterGetByGroup_PrevAndNext(session, suburItem,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem filterGetByGroup_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subur items where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long companyId, long groupId)
		throws SystemException {
		for (SuburItem suburItem : findByGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
	}

	/**
	 * Returns the number of subur items where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of subur items that the user has permission to view where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching subur items that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroup(long companyId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroup(companyId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUP_COMPANYID_2 = "suburItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "suburItem.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			SuburItemModelImpl.STATUS_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the subur items where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<SuburItem> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((status != suburItem.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByStatus_First(status, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the first subur item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subur item, or <code>null</code> if a matching subur item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SuburItem> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByStatus_Last(status, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
	}

	/**
	 * Returns the last subur item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subur item, or <code>null</code> if a matching subur item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByStatus_PrevAndNext(long itemId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByStatus_PrevAndNext(session, suburItem, status,
					orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByStatus_PrevAndNext(session, suburItem, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByStatus_PrevAndNext(Session session,
		SuburItem suburItem, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subur items where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (SuburItem suburItem : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
	}

	/**
	 * Returns the number of subur items where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "suburItem.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCREATORSTATUS =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupCreatorStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATORSTATUS =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupCreatorStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SuburItemModelImpl.COMPANYID_COLUMN_BITMASK |
			SuburItemModelImpl.GROUPID_COLUMN_BITMASK |
			SuburItemModelImpl.USERID_COLUMN_BITMASK |
			SuburItemModelImpl.STATUS_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCREATORSTATUS = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupCreatorStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

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
	@Override
	public List<SuburItem> findByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status) throws SystemException {
		return findByGroupCreatorStatus(companyId, groupId, userId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status, int start, int end)
		throws SystemException {
		return findByGroupCreatorStatus(companyId, groupId, userId, status,
			start, end, null);
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
	@Override
	public List<SuburItem> findByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATORSTATUS;
			finderArgs = new Object[] { companyId, groupId, userId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCREATORSTATUS;
			finderArgs = new Object[] {
					companyId, groupId, userId, status,
					
					start, end, orderByComparator
				};
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((companyId != suburItem.getCompanyId()) ||
						(groupId != suburItem.getGroupId()) ||
						(userId != suburItem.getUserId()) ||
						(status != suburItem.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByGroupCreatorStatus_First(long companyId,
		long groupId, long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupCreatorStatus_First(companyId,
				groupId, userId, status, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroupCreatorStatus_First(long companyId,
		long groupId, long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SuburItem> list = findByGroupCreatorStatus(companyId, groupId,
				userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByGroupCreatorStatus_Last(long companyId,
		long groupId, long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupCreatorStatus_Last(companyId,
				groupId, userId, status, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroupCreatorStatus_Last(long companyId,
		long groupId, long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupCreatorStatus(companyId, groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByGroupCreatorStatus(companyId, groupId,
				userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByGroupCreatorStatus_PrevAndNext(long itemId,
		long companyId, long groupId, long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByGroupCreatorStatus_PrevAndNext(session, suburItem,
					companyId, groupId, userId, status, orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByGroupCreatorStatus_PrevAndNext(session, suburItem,
					companyId, groupId, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByGroupCreatorStatus_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId, long userId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SuburItem> filterFindByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status) throws SystemException {
		return filterFindByGroupCreatorStatus(companyId, groupId, userId,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> filterFindByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status, int start, int end)
		throws SystemException {
		return filterFindByGroupCreatorStatus(companyId, groupId, userId,
			status, start, end, null);
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
	@Override
	public List<SuburItem> filterFindByGroupCreatorStatus(long companyId,
		long groupId, long userId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupCreatorStatus(companyId, groupId, userId, status,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(userId);

			qPos.add(status);

			return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SuburItem[] filterFindByGroupCreatorStatus_PrevAndNext(long itemId,
		long companyId, long groupId, long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupCreatorStatus_PrevAndNext(itemId, companyId,
				groupId, userId, status, orderByComparator);
		}

		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = filterGetByGroupCreatorStatus_PrevAndNext(session,
					suburItem, companyId, groupId, userId, status,
					orderByComparator, true);

			array[1] = suburItem;

			array[2] = filterGetByGroupCreatorStatus_PrevAndNext(session,
					suburItem, companyId, groupId, userId, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem filterGetByGroupCreatorStatus_PrevAndNext(
		Session session, SuburItem suburItem, long companyId, long groupId,
		long userId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByGroupCreatorStatus(long companyId, long groupId,
		long userId, int status) throws SystemException {
		for (SuburItem suburItem : findByGroupCreatorStatus(companyId, groupId,
				userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
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
	@Override
	public int countByGroupCreatorStatus(long companyId, long groupId,
		long userId, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCREATORSTATUS;

		Object[] finderArgs = new Object[] { companyId, groupId, userId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
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
	@Override
	public int filterCountByGroupCreatorStatus(long companyId, long groupId,
		long userId, int status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupCreatorStatus(companyId, groupId, userId, status);
		}

		StringBundler query = new StringBundler(5);

		query.append(_FILTER_SQL_COUNT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2);

		query.append(_FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(userId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPCREATORSTATUS_COMPANYID_2 = "suburItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCREATORSTATUS_GROUPID_2 = "suburItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCREATORSTATUS_USERID_2 = "suburItem.userId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCREATORSTATUS_STATUS_2 = "suburItem.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCREATOR =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATOR =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SuburItemModelImpl.COMPANYID_COLUMN_BITMASK |
			SuburItemModelImpl.GROUPID_COLUMN_BITMASK |
			SuburItemModelImpl.USERID_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPCREATOR = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findByGroupCreator(long companyId, long groupId,
		long userId) throws SystemException {
		return findByGroupCreator(companyId, groupId, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByGroupCreator(long companyId, long groupId,
		long userId, int start, int end) throws SystemException {
		return findByGroupCreator(companyId, groupId, userId, start, end, null);
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
	@Override
	public List<SuburItem> findByGroupCreator(long companyId, long groupId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATOR;
			finderArgs = new Object[] { companyId, groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPCREATOR;
			finderArgs = new Object[] {
					companyId, groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((companyId != suburItem.getCompanyId()) ||
						(groupId != suburItem.getGroupId()) ||
						(userId != suburItem.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPCREATOR_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCREATOR_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCREATOR_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByGroupCreator_First(long companyId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupCreator_First(companyId, groupId,
				userId, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroupCreator_First(long companyId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SuburItem> list = findByGroupCreator(companyId, groupId, userId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByGroupCreator_Last(long companyId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByGroupCreator_Last(companyId, groupId,
				userId, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByGroupCreator_Last(long companyId, long groupId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupCreator(companyId, groupId, userId);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByGroupCreator(companyId, groupId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByGroupCreator_PrevAndNext(long itemId,
		long companyId, long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByGroupCreator_PrevAndNext(session, suburItem,
					companyId, groupId, userId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByGroupCreator_PrevAndNext(session, suburItem,
					companyId, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByGroupCreator_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPCREATOR_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SuburItem> filterFindByGroupCreator(long companyId,
		long groupId, long userId) throws SystemException {
		return filterFindByGroupCreator(companyId, groupId, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> filterFindByGroupCreator(long companyId,
		long groupId, long userId, int start, int end)
		throws SystemException {
		return filterFindByGroupCreator(companyId, groupId, userId, start, end,
			null);
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
	@Override
	public List<SuburItem> filterFindByGroupCreator(long companyId,
		long groupId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupCreator(companyId, groupId, userId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCREATOR_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(userId);

			return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SuburItem[] filterFindByGroupCreator_PrevAndNext(long itemId,
		long companyId, long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupCreator_PrevAndNext(itemId, companyId, groupId,
				userId, orderByComparator);
		}

		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = filterGetByGroupCreator_PrevAndNext(session, suburItem,
					companyId, groupId, userId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = filterGetByGroupCreator_PrevAndNext(session, suburItem,
					companyId, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem filterGetByGroupCreator_PrevAndNext(Session session,
		SuburItem suburItem, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPCREATOR_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subur items where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupCreator(long companyId, long groupId, long userId)
		throws SystemException {
		for (SuburItem suburItem : findByGroupCreator(companyId, groupId,
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
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
	@Override
	public int countByGroupCreator(long companyId, long groupId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPCREATOR;

		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_GROUPCREATOR_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUPCREATOR_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPCREATOR_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
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
	@Override
	public int filterCountByGroupCreator(long companyId, long groupId,
		long userId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupCreator(companyId, groupId, userId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_GROUPCREATOR_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPCREATOR_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPCREATOR_COMPANYID_2 = "suburItem.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCREATOR_GROUPID_2 = "suburItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPCREATOR_USERID_2 = "suburItem.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSBYGROUP =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusByGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSBYGROUP =
		new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, SuburItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusByGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			SuburItemModelImpl.STATUS_COLUMN_BITMASK |
			SuburItemModelImpl.GROUPID_COLUMN_BITMASK |
			SuburItemModelImpl.COMPANYID_COLUMN_BITMASK |
			SuburItemModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSBYGROUP = new FinderPath(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusByGroup",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the subur items where status = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findByStatusByGroup(int status, long groupId,
		long companyId) throws SystemException {
		return findByStatusByGroup(status, groupId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findByStatusByGroup(int status, long groupId,
		long companyId, int start, int end) throws SystemException {
		return findByStatusByGroup(status, groupId, companyId, start, end, null);
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
	@Override
	public List<SuburItem> findByStatusByGroup(int status, long groupId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSBYGROUP;
			finderArgs = new Object[] { status, groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSBYGROUP;
			finderArgs = new Object[] {
					status, groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SuburItem suburItem : list) {
				if ((status != suburItem.getStatus()) ||
						(groupId != suburItem.getGroupId()) ||
						(companyId != suburItem.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_STATUSBYGROUP_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSBYGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SuburItem findByStatusByGroup_First(int status, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByStatusByGroup_First(status, groupId,
				companyId, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByStatusByGroup_First(int status, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SuburItem> list = findByStatusByGroup(status, groupId, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem findByStatusByGroup_Last(int status, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByStatusByGroup_Last(status, groupId,
				companyId, orderByComparator);

		if (suburItem != null) {
			return suburItem;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchItemException(msg.toString());
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
	@Override
	public SuburItem fetchByStatusByGroup_Last(int status, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusByGroup(status, groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<SuburItem> list = findByStatusByGroup(status, groupId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SuburItem[] findByStatusByGroup_PrevAndNext(long itemId, int status,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = getByStatusByGroup_PrevAndNext(session, suburItem,
					status, groupId, companyId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = getByStatusByGroup_PrevAndNext(session, suburItem,
					status, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem getByStatusByGroup_PrevAndNext(Session session,
		SuburItem suburItem, int status, long groupId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SuburItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<SuburItem> filterFindByStatusByGroup(int status, long groupId,
		long companyId) throws SystemException {
		return filterFindByStatusByGroup(status, groupId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> filterFindByStatusByGroup(int status, long groupId,
		long companyId, int start, int end) throws SystemException {
		return filterFindByStatusByGroup(status, groupId, companyId, start,
			end, null);
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
	@Override
	public List<SuburItem> filterFindByStatusByGroup(int status, long groupId,
		long companyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusByGroup(status, groupId, companyId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSBYGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			qPos.add(groupId);

			qPos.add(companyId);

			return (List<SuburItem>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public SuburItem[] filterFindByStatusByGroup_PrevAndNext(long itemId,
		int status, long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchItemException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByStatusByGroup_PrevAndNext(itemId, status, groupId,
				companyId, orderByComparator);
		}

		SuburItem suburItem = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			SuburItem[] array = new SuburItemImpl[3];

			array[0] = filterGetByStatusByGroup_PrevAndNext(session, suburItem,
					status, groupId, companyId, orderByComparator, true);

			array[1] = suburItem;

			array[2] = filterGetByStatusByGroup_PrevAndNext(session, suburItem,
					status, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SuburItem filterGetByStatusByGroup_PrevAndNext(Session session,
		SuburItem suburItem, int status, long groupId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_STATUSBYGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SuburItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SuburItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SuburItemImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SuburItemImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(suburItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SuburItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subur items where status = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatusByGroup(int status, long groupId, long companyId)
		throws SystemException {
		for (SuburItem suburItem : findByStatusByGroup(status, groupId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(suburItem);
		}
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
	@Override
	public int countByStatusByGroup(int status, long groupId, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUSBYGROUP;

		Object[] finderArgs = new Object[] { status, groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SUBURITEM_WHERE);

			query.append(_FINDER_COLUMN_STATUSBYGROUP_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSBYGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
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
	@Override
	public int filterCountByStatusByGroup(int status, long groupId,
		long companyId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByStatusByGroup(status, groupId, companyId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_SUBURITEM_WHERE);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SuburItem.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(status);

			qPos.add(groupId);

			qPos.add(companyId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_STATUSBYGROUP_STATUS_2 = "suburItem.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSBYGROUP_GROUPID_2 = "suburItem.groupId = ? AND ";
	private static final String _FINDER_COLUMN_STATUSBYGROUP_COMPANYID_2 = "suburItem.companyId = ?";

	public SuburItemPersistenceImpl() {
		setModelClass(SuburItem.class);
	}

	/**
	 * Caches the subur item in the entity cache if it is enabled.
	 *
	 * @param suburItem the subur item
	 */
	@Override
	public void cacheResult(SuburItem suburItem) {
		EntityCacheUtil.putResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemImpl.class, suburItem.getPrimaryKey(), suburItem);

		suburItem.resetOriginalValues();
	}

	/**
	 * Caches the subur items in the entity cache if it is enabled.
	 *
	 * @param suburItems the subur items
	 */
	@Override
	public void cacheResult(List<SuburItem> suburItems) {
		for (SuburItem suburItem : suburItems) {
			if (EntityCacheUtil.getResult(
						SuburItemModelImpl.ENTITY_CACHE_ENABLED,
						SuburItemImpl.class, suburItem.getPrimaryKey()) == null) {
				cacheResult(suburItem);
			}
			else {
				suburItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subur items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SuburItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SuburItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subur item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SuburItem suburItem) {
		EntityCacheUtil.removeResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemImpl.class, suburItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SuburItem> suburItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SuburItem suburItem : suburItems) {
			EntityCacheUtil.removeResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
				SuburItemImpl.class, suburItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subur item with the primary key. Does not add the subur item to the database.
	 *
	 * @param itemId the primary key for the new subur item
	 * @return the new subur item
	 */
	@Override
	public SuburItem create(long itemId) {
		SuburItem suburItem = new SuburItemImpl();

		suburItem.setNew(true);
		suburItem.setPrimaryKey(itemId);

		return suburItem;
	}

	/**
	 * Removes the subur item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the subur item
	 * @return the subur item that was removed
	 * @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem remove(long itemId)
		throws NoSuchItemException, SystemException {
		return remove((Serializable)itemId);
	}

	/**
	 * Removes the subur item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subur item
	 * @return the subur item that was removed
	 * @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem remove(Serializable primaryKey)
		throws NoSuchItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SuburItem suburItem = (SuburItem)session.get(SuburItemImpl.class,
					primaryKey);

			if (suburItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(suburItem);
		}
		catch (NoSuchItemException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SuburItem removeImpl(SuburItem suburItem)
		throws SystemException {
		suburItem = toUnwrappedModel(suburItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(suburItem)) {
				suburItem = (SuburItem)session.get(SuburItemImpl.class,
						suburItem.getPrimaryKeyObj());
			}

			if (suburItem != null) {
				session.delete(suburItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (suburItem != null) {
			clearCache(suburItem);
		}

		return suburItem;
	}

	@Override
	public SuburItem updateImpl(com.idetronic.subur.model.SuburItem suburItem)
		throws SystemException {
		suburItem = toUnwrappedModel(suburItem);

		boolean isNew = suburItem.isNew();

		SuburItemModelImpl suburItemModelImpl = (SuburItemModelImpl)suburItem;

		Session session = null;

		try {
			session = openSession();

			if (suburItem.isNew()) {
				session.save(suburItem);

				suburItem.setNew(false);
			}
			else {
				session.merge(suburItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SuburItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { suburItemModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalCompanyId(),
						suburItemModelImpl.getOriginalGroupId(),
						suburItemModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS,
					args);

				args = new Object[] {
						suburItemModelImpl.getCompanyId(),
						suburItemModelImpl.getGroupId(),
						suburItemModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPSTATUS,
					args);
			}

			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalCompanyId(),
						suburItemModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] {
						suburItemModelImpl.getCompanyId(),
						suburItemModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { suburItemModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATORSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalCompanyId(),
						suburItemModelImpl.getOriginalGroupId(),
						suburItemModelImpl.getOriginalUserId(),
						suburItemModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCREATORSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATORSTATUS,
					args);

				args = new Object[] {
						suburItemModelImpl.getCompanyId(),
						suburItemModelImpl.getGroupId(),
						suburItemModelImpl.getUserId(),
						suburItemModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCREATORSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATORSTATUS,
					args);
			}

			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalCompanyId(),
						suburItemModelImpl.getOriginalGroupId(),
						suburItemModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATOR,
					args);

				args = new Object[] {
						suburItemModelImpl.getCompanyId(),
						suburItemModelImpl.getGroupId(),
						suburItemModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPCREATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPCREATOR,
					args);
			}

			if ((suburItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSBYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						suburItemModelImpl.getOriginalStatus(),
						suburItemModelImpl.getOriginalGroupId(),
						suburItemModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSBYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSBYGROUP,
					args);

				args = new Object[] {
						suburItemModelImpl.getStatus(),
						suburItemModelImpl.getGroupId(),
						suburItemModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSBYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSBYGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
			SuburItemImpl.class, suburItem.getPrimaryKey(), suburItem);

		return suburItem;
	}

	protected SuburItem toUnwrappedModel(SuburItem suburItem) {
		if (suburItem instanceof SuburItemImpl) {
			return suburItem;
		}

		SuburItemImpl suburItemImpl = new SuburItemImpl();

		suburItemImpl.setNew(suburItem.isNew());
		suburItemImpl.setPrimaryKey(suburItem.getPrimaryKey());

		suburItemImpl.setItemId(suburItem.getItemId());
		suburItemImpl.setCompanyId(suburItem.getCompanyId());
		suburItemImpl.setGroupId(suburItem.getGroupId());
		suburItemImpl.setUserId(suburItem.getUserId());
		suburItemImpl.setUserName(suburItem.getUserName());
		suburItemImpl.setCreateDate(suburItem.getCreateDate());
		suburItemImpl.setModifiedDate(suburItem.getModifiedDate());
		suburItemImpl.setPublishedDate(suburItem.getPublishedDate());
		suburItemImpl.setTitle(suburItem.getTitle());
		suburItemImpl.setItemAbstract(suburItem.getItemAbstract());
		suburItemImpl.setLanguage(suburItem.getLanguage());
		suburItemImpl.setStatus(suburItem.getStatus());
		suburItemImpl.setUuid(suburItem.getUuid());
		suburItemImpl.setMetadataValue(suburItem.getMetadataValue());
		suburItemImpl.setRelatedRestricted(suburItem.isRelatedRestricted());
		suburItemImpl.setStatusByUserId(suburItem.getStatusByUserId());
		suburItemImpl.setStatusDate(suburItem.getStatusDate());
		suburItemImpl.setCompleted(suburItem.isCompleted());
		suburItemImpl.setCoverImageId(suburItem.getCoverImageId());
		suburItemImpl.setCounted(suburItem.isCounted());

		return suburItemImpl;
	}

	/**
	 * Returns the subur item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subur item
	 * @return the subur item
	 * @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchItemException, SystemException {
		SuburItem suburItem = fetchByPrimaryKey(primaryKey);

		if (suburItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return suburItem;
	}

	/**
	 * Returns the subur item with the primary key or throws a {@link com.idetronic.subur.NoSuchItemException} if it could not be found.
	 *
	 * @param itemId the primary key of the subur item
	 * @return the subur item
	 * @throws com.idetronic.subur.NoSuchItemException if a subur item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem findByPrimaryKey(long itemId)
		throws NoSuchItemException, SystemException {
		return findByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns the subur item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subur item
	 * @return the subur item, or <code>null</code> if a subur item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SuburItem suburItem = (SuburItem)EntityCacheUtil.getResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
				SuburItemImpl.class, primaryKey);

		if (suburItem == _nullSuburItem) {
			return null;
		}

		if (suburItem == null) {
			Session session = null;

			try {
				session = openSession();

				suburItem = (SuburItem)session.get(SuburItemImpl.class,
						primaryKey);

				if (suburItem != null) {
					cacheResult(suburItem);
				}
				else {
					EntityCacheUtil.putResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
						SuburItemImpl.class, primaryKey, _nullSuburItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SuburItemModelImpl.ENTITY_CACHE_ENABLED,
					SuburItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return suburItem;
	}

	/**
	 * Returns the subur item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the subur item
	 * @return the subur item, or <code>null</code> if a subur item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburItem fetchByPrimaryKey(long itemId) throws SystemException {
		return fetchByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns all the subur items.
	 *
	 * @return the subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SuburItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SuburItem> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SuburItem> list = (List<SuburItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBURITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBURITEM;

				if (pagination) {
					sql = sql.concat(SuburItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburItem>(list);
				}
				else {
					list = (List<SuburItem>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the subur items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SuburItem suburItem : findAll()) {
			remove(suburItem);
		}
	}

	/**
	 * Returns the number of subur items.
	 *
	 * @return the number of subur items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBURITEM);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the subur item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.SuburItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SuburItem>> listenersList = new ArrayList<ModelListener<SuburItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SuburItem>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SuburItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBURITEM = "SELECT suburItem FROM SuburItem suburItem";
	private static final String _SQL_SELECT_SUBURITEM_WHERE = "SELECT suburItem FROM SuburItem suburItem WHERE ";
	private static final String _SQL_COUNT_SUBURITEM = "SELECT COUNT(suburItem) FROM SuburItem suburItem";
	private static final String _SQL_COUNT_SUBURITEM_WHERE = "SELECT COUNT(suburItem) FROM SuburItem suburItem WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "suburItem.itemId";
	private static final String _FILTER_SQL_SELECT_SUBURITEM_WHERE = "SELECT DISTINCT {suburItem.*} FROM Subur_Item suburItem WHERE ";
	private static final String _FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Subur_Item.*} FROM (SELECT DISTINCT suburItem.itemId FROM Subur_Item suburItem WHERE ";
	private static final String _FILTER_SQL_SELECT_SUBURITEM_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Subur_Item ON TEMP_TABLE.itemId = Subur_Item.itemId";
	private static final String _FILTER_SQL_COUNT_SUBURITEM_WHERE = "SELECT COUNT(DISTINCT suburItem.itemId) AS COUNT_VALUE FROM Subur_Item suburItem WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "suburItem";
	private static final String _FILTER_ENTITY_TABLE = "Subur_Item";
	private static final String _ORDER_BY_ENTITY_ALIAS = "suburItem.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Subur_Item.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SuburItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SuburItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SuburItemPersistenceImpl.class);
	private static SuburItem _nullSuburItem = new SuburItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SuburItem> toCacheModel() {
				return _nullSuburItemCacheModel;
			}
		};

	private static CacheModel<SuburItem> _nullSuburItemCacheModel = new CacheModel<SuburItem>() {
			@Override
			public SuburItem toEntityModel() {
				return _nullSuburItem;
			}
		};
}