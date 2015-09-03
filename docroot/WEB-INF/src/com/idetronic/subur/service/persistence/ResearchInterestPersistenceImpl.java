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

import com.idetronic.subur.NoSuchResearchInterestException;
import com.idetronic.subur.model.ResearchInterest;
import com.idetronic.subur.model.impl.ResearchInterestImpl;
import com.idetronic.subur.model.impl.ResearchInterestModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the research interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see ResearchInterestPersistence
 * @see ResearchInterestUtil
 * @generated
 */
public class ResearchInterestPersistenceImpl extends BasePersistenceImpl<ResearchInterest>
	implements ResearchInterestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResearchInterestUtil} to access the research interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResearchInterestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			ResearchInterestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			ResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			ResearchInterestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			ResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			ResearchInterestModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the research interests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchInterest> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ResearchInterest> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

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
	@Override
	public List<ResearchInterest> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ResearchInterest> list = (List<ResearchInterest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResearchInterest researchInterest : list) {
				if ((groupId != researchInterest.getGroupId())) {
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

			query.append(_SQL_SELECT_RESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResearchInterestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchInterest>(list);
				}
				else {
					list = (List<ResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first research interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research interest
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchResearchInterestException, SystemException {
		ResearchInterest researchInterest = fetchByGroup_First(groupId,
				orderByComparator);

		if (researchInterest != null) {
			return researchInterest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchInterestException(msg.toString());
	}

	/**
	 * Returns the first research interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research interest, or <code>null</code> if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResearchInterest> list = findByGroup(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last research interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research interest
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchResearchInterestException, SystemException {
		ResearchInterest researchInterest = fetchByGroup_Last(groupId,
				orderByComparator);

		if (researchInterest != null) {
			return researchInterest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchInterestException(msg.toString());
	}

	/**
	 * Returns the last research interest in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research interest, or <code>null</code> if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<ResearchInterest> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ResearchInterest[] findByGroup_PrevAndNext(long researchInterestId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchResearchInterestException, SystemException {
		ResearchInterest researchInterest = findByPrimaryKey(researchInterestId);

		Session session = null;

		try {
			session = openSession();

			ResearchInterest[] array = new ResearchInterestImpl[3];

			array[0] = getByGroup_PrevAndNext(session, researchInterest,
					groupId, orderByComparator, true);

			array[1] = researchInterest;

			array[2] = getByGroup_PrevAndNext(session, researchInterest,
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

	protected ResearchInterest getByGroup_PrevAndNext(Session session,
		ResearchInterest researchInterest, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESEARCHINTEREST_WHERE);

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
			query.append(ResearchInterestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(researchInterest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResearchInterest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the research interests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (ResearchInterest researchInterest : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(researchInterest);
		}
	}

	/**
	 * Returns the number of research interests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "researchInterest.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPNAME = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			ResearchInterestImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGroupName",
			new String[] { Long.class.getName(), String.class.getName() },
			ResearchInterestModelImpl.GROUPID_COLUMN_BITMASK |
			ResearchInterestModelImpl.INDEXEDNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPNAME = new FinderPath(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the research interest where groupId = &#63; and indexedName = &#63; or throws a {@link com.idetronic.subur.NoSuchResearchInterestException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the matching research interest
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest findByGroupName(long groupId, String indexedName)
		throws NoSuchResearchInterestException, SystemException {
		ResearchInterest researchInterest = fetchByGroupName(groupId,
				indexedName);

		if (researchInterest == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", indexedName=");
			msg.append(indexedName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchResearchInterestException(msg.toString());
		}

		return researchInterest;
	}

	/**
	 * Returns the research interest where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the matching research interest, or <code>null</code> if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest fetchByGroupName(long groupId, String indexedName)
		throws SystemException {
		return fetchByGroupName(groupId, indexedName, true);
	}

	/**
	 * Returns the research interest where groupId = &#63; and indexedName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching research interest, or <code>null</code> if a matching research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest fetchByGroupName(long groupId, String indexedName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, indexedName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPNAME,
					finderArgs, this);
		}

		if (result instanceof ResearchInterest) {
			ResearchInterest researchInterest = (ResearchInterest)result;

			if ((groupId != researchInterest.getGroupId()) ||
					!Validator.equals(indexedName,
						researchInterest.getIndexedName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_GROUPNAME_GROUPID_2);

			boolean bindIndexedName = false;

			if (indexedName == null) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_1);
			}
			else if (indexedName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_3);
			}
			else {
				bindIndexedName = true;

				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindIndexedName) {
					qPos.add(indexedName);
				}

				List<ResearchInterest> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME,
						finderArgs, list);
				}
				else {
					ResearchInterest researchInterest = list.get(0);

					result = researchInterest;

					cacheResult(researchInterest);

					if ((researchInterest.getGroupId() != groupId) ||
							(researchInterest.getIndexedName() == null) ||
							!researchInterest.getIndexedName()
												 .equals(indexedName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME,
							finderArgs, researchInterest);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ResearchInterest)result;
		}
	}

	/**
	 * Removes the research interest where groupId = &#63; and indexedName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the research interest that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest removeByGroupName(long groupId, String indexedName)
		throws NoSuchResearchInterestException, SystemException {
		ResearchInterest researchInterest = findByGroupName(groupId, indexedName);

		return remove(researchInterest);
	}

	/**
	 * Returns the number of research interests where groupId = &#63; and indexedName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param indexedName the indexed name
	 * @return the number of matching research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupName(long groupId, String indexedName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPNAME;

		Object[] finderArgs = new Object[] { groupId, indexedName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_GROUPNAME_GROUPID_2);

			boolean bindIndexedName = false;

			if (indexedName == null) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_1);
			}
			else if (indexedName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_3);
			}
			else {
				bindIndexedName = true;

				query.append(_FINDER_COLUMN_GROUPNAME_INDEXEDNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindIndexedName) {
					qPos.add(indexedName);
				}

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

	private static final String _FINDER_COLUMN_GROUPNAME_GROUPID_2 = "researchInterest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPNAME_INDEXEDNAME_1 = "researchInterest.indexedName IS NULL";
	private static final String _FINDER_COLUMN_GROUPNAME_INDEXEDNAME_2 = "researchInterest.indexedName = ?";
	private static final String _FINDER_COLUMN_GROUPNAME_INDEXEDNAME_3 = "(researchInterest.indexedName IS NULL OR researchInterest.indexedName = '')";

	public ResearchInterestPersistenceImpl() {
		setModelClass(ResearchInterest.class);
	}

	/**
	 * Caches the research interest in the entity cache if it is enabled.
	 *
	 * @param researchInterest the research interest
	 */
	@Override
	public void cacheResult(ResearchInterest researchInterest) {
		EntityCacheUtil.putResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestImpl.class, researchInterest.getPrimaryKey(),
			researchInterest);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME,
			new Object[] {
				researchInterest.getGroupId(), researchInterest.getIndexedName()
			}, researchInterest);

		researchInterest.resetOriginalValues();
	}

	/**
	 * Caches the research interests in the entity cache if it is enabled.
	 *
	 * @param researchInterests the research interests
	 */
	@Override
	public void cacheResult(List<ResearchInterest> researchInterests) {
		for (ResearchInterest researchInterest : researchInterests) {
			if (EntityCacheUtil.getResult(
						ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
						ResearchInterestImpl.class,
						researchInterest.getPrimaryKey()) == null) {
				cacheResult(researchInterest);
			}
			else {
				researchInterest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all research interests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResearchInterestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResearchInterestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the research interest.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResearchInterest researchInterest) {
		EntityCacheUtil.removeResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestImpl.class, researchInterest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(researchInterest);
	}

	@Override
	public void clearCache(List<ResearchInterest> researchInterests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResearchInterest researchInterest : researchInterests) {
			EntityCacheUtil.removeResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
				ResearchInterestImpl.class, researchInterest.getPrimaryKey());

			clearUniqueFindersCache(researchInterest);
		}
	}

	protected void cacheUniqueFindersCache(ResearchInterest researchInterest) {
		if (researchInterest.isNew()) {
			Object[] args = new Object[] {
					researchInterest.getGroupId(),
					researchInterest.getIndexedName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME, args,
				researchInterest);
		}
		else {
			ResearchInterestModelImpl researchInterestModelImpl = (ResearchInterestModelImpl)researchInterest;

			if ((researchInterestModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchInterest.getGroupId(),
						researchInterest.getIndexedName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPNAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPNAME, args,
					researchInterest);
			}
		}
	}

	protected void clearUniqueFindersCache(ResearchInterest researchInterest) {
		ResearchInterestModelImpl researchInterestModelImpl = (ResearchInterestModelImpl)researchInterest;

		Object[] args = new Object[] {
				researchInterest.getGroupId(), researchInterest.getIndexedName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPNAME, args);

		if ((researchInterestModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GROUPNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					researchInterestModelImpl.getOriginalGroupId(),
					researchInterestModelImpl.getOriginalIndexedName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPNAME, args);
		}
	}

	/**
	 * Creates a new research interest with the primary key. Does not add the research interest to the database.
	 *
	 * @param researchInterestId the primary key for the new research interest
	 * @return the new research interest
	 */
	@Override
	public ResearchInterest create(long researchInterestId) {
		ResearchInterest researchInterest = new ResearchInterestImpl();

		researchInterest.setNew(true);
		researchInterest.setPrimaryKey(researchInterestId);

		return researchInterest;
	}

	/**
	 * Removes the research interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param researchInterestId the primary key of the research interest
	 * @return the research interest that was removed
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest remove(long researchInterestId)
		throws NoSuchResearchInterestException, SystemException {
		return remove((Serializable)researchInterestId);
	}

	/**
	 * Removes the research interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the research interest
	 * @return the research interest that was removed
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest remove(Serializable primaryKey)
		throws NoSuchResearchInterestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResearchInterest researchInterest = (ResearchInterest)session.get(ResearchInterestImpl.class,
					primaryKey);

			if (researchInterest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResearchInterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(researchInterest);
		}
		catch (NoSuchResearchInterestException nsee) {
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
	protected ResearchInterest removeImpl(ResearchInterest researchInterest)
		throws SystemException {
		researchInterest = toUnwrappedModel(researchInterest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(researchInterest)) {
				researchInterest = (ResearchInterest)session.get(ResearchInterestImpl.class,
						researchInterest.getPrimaryKeyObj());
			}

			if (researchInterest != null) {
				session.delete(researchInterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (researchInterest != null) {
			clearCache(researchInterest);
		}

		return researchInterest;
	}

	@Override
	public ResearchInterest updateImpl(
		com.idetronic.subur.model.ResearchInterest researchInterest)
		throws SystemException {
		researchInterest = toUnwrappedModel(researchInterest);

		boolean isNew = researchInterest.isNew();

		ResearchInterestModelImpl researchInterestModelImpl = (ResearchInterestModelImpl)researchInterest;

		Session session = null;

		try {
			session = openSession();

			if (researchInterest.isNew()) {
				session.save(researchInterest);

				researchInterest.setNew(false);
			}
			else {
				session.merge(researchInterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ResearchInterestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((researchInterestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchInterestModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { researchInterestModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			ResearchInterestImpl.class, researchInterest.getPrimaryKey(),
			researchInterest);

		clearUniqueFindersCache(researchInterest);
		cacheUniqueFindersCache(researchInterest);

		return researchInterest;
	}

	protected ResearchInterest toUnwrappedModel(
		ResearchInterest researchInterest) {
		if (researchInterest instanceof ResearchInterestImpl) {
			return researchInterest;
		}

		ResearchInterestImpl researchInterestImpl = new ResearchInterestImpl();

		researchInterestImpl.setNew(researchInterest.isNew());
		researchInterestImpl.setPrimaryKey(researchInterest.getPrimaryKey());

		researchInterestImpl.setResearchInterestId(researchInterest.getResearchInterestId());
		researchInterestImpl.setGroupId(researchInterest.getGroupId());
		researchInterestImpl.setCompanyId(researchInterest.getCompanyId());
		researchInterestImpl.setUserId(researchInterest.getUserId());
		researchInterestImpl.setCreateDate(researchInterest.getCreateDate());
		researchInterestImpl.setResearchInterestName(researchInterest.getResearchInterestName());
		researchInterestImpl.setIndexedName(researchInterest.getIndexedName());
		researchInterestImpl.setModifiedDate(researchInterest.getModifiedDate());
		researchInterestImpl.setAuthorCount(researchInterest.getAuthorCount());

		return researchInterestImpl;
	}

	/**
	 * Returns the research interest with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the research interest
	 * @return the research interest
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResearchInterestException, SystemException {
		ResearchInterest researchInterest = fetchByPrimaryKey(primaryKey);

		if (researchInterest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResearchInterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return researchInterest;
	}

	/**
	 * Returns the research interest with the primary key or throws a {@link com.idetronic.subur.NoSuchResearchInterestException} if it could not be found.
	 *
	 * @param researchInterestId the primary key of the research interest
	 * @return the research interest
	 * @throws com.idetronic.subur.NoSuchResearchInterestException if a research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest findByPrimaryKey(long researchInterestId)
		throws NoSuchResearchInterestException, SystemException {
		return findByPrimaryKey((Serializable)researchInterestId);
	}

	/**
	 * Returns the research interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the research interest
	 * @return the research interest, or <code>null</code> if a research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ResearchInterest researchInterest = (ResearchInterest)EntityCacheUtil.getResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
				ResearchInterestImpl.class, primaryKey);

		if (researchInterest == _nullResearchInterest) {
			return null;
		}

		if (researchInterest == null) {
			Session session = null;

			try {
				session = openSession();

				researchInterest = (ResearchInterest)session.get(ResearchInterestImpl.class,
						primaryKey);

				if (researchInterest != null) {
					cacheResult(researchInterest);
				}
				else {
					EntityCacheUtil.putResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
						ResearchInterestImpl.class, primaryKey,
						_nullResearchInterest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
					ResearchInterestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return researchInterest;
	}

	/**
	 * Returns the research interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param researchInterestId the primary key of the research interest
	 * @return the research interest, or <code>null</code> if a research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchInterest fetchByPrimaryKey(long researchInterestId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)researchInterestId);
	}

	/**
	 * Returns all the research interests.
	 *
	 * @return the research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchInterest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ResearchInterest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ResearchInterest> findAll(int start, int end,
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

		List<ResearchInterest> list = (List<ResearchInterest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESEARCHINTEREST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESEARCHINTEREST;

				if (pagination) {
					sql = sql.concat(ResearchInterestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchInterest>(list);
				}
				else {
					list = (List<ResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the research interests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ResearchInterest researchInterest : findAll()) {
			remove(researchInterest);
		}
	}

	/**
	 * Returns the number of research interests.
	 *
	 * @return the number of research interests
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

				Query q = session.createQuery(_SQL_COUNT_RESEARCHINTEREST);

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
	 * Initializes the research interest persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.ResearchInterest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResearchInterest>> listenersList = new ArrayList<ModelListener<ResearchInterest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResearchInterest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ResearchInterestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RESEARCHINTEREST = "SELECT researchInterest FROM ResearchInterest researchInterest";
	private static final String _SQL_SELECT_RESEARCHINTEREST_WHERE = "SELECT researchInterest FROM ResearchInterest researchInterest WHERE ";
	private static final String _SQL_COUNT_RESEARCHINTEREST = "SELECT COUNT(researchInterest) FROM ResearchInterest researchInterest";
	private static final String _SQL_COUNT_RESEARCHINTEREST_WHERE = "SELECT COUNT(researchInterest) FROM ResearchInterest researchInterest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "researchInterest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResearchInterest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResearchInterest exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResearchInterestPersistenceImpl.class);
	private static ResearchInterest _nullResearchInterest = new ResearchInterestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResearchInterest> toCacheModel() {
				return _nullResearchInterestCacheModel;
			}
		};

	private static CacheModel<ResearchInterest> _nullResearchInterestCacheModel = new CacheModel<ResearchInterest>() {
			@Override
			public ResearchInterest toEntityModel() {
				return _nullResearchInterest;
			}
		};
}