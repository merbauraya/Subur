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

import com.idetronic.subur.NoSuchCopyRequestException;
import com.idetronic.subur.model.CopyRequest;
import com.idetronic.subur.model.impl.CopyRequestImpl;
import com.idetronic.subur.model.impl.CopyRequestModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the copy request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see CopyRequestPersistence
 * @see CopyRequestUtil
 * @generated
 */
public class CopyRequestPersistenceImpl extends BasePersistenceImpl<CopyRequest>
	implements CopyRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CopyRequestUtil} to access the copy request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CopyRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CopyRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			CopyRequestModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the copy requests where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the copy requests where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @return the range of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByCompanyGroup(long companyId, long groupId,
		int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the copy requests where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByCompanyGroup(long companyId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CopyRequest> list = (List<CopyRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CopyRequest copyRequest : list) {
				if ((companyId != copyRequest.getCompanyId()) ||
						(groupId != copyRequest.getGroupId())) {
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

			query.append(_SQL_SELECT_COPYREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CopyRequestModelImpl.ORDER_BY_JPQL);
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
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CopyRequest>(list);
				}
				else {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByCompanyGroup_First(companyId, groupId,
				orderByComparator);

		if (copyRequest != null) {
			return copyRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCopyRequestException(msg.toString());
	}

	/**
	 * Returns the first copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByCompanyGroup_First(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CopyRequest> list = findByCompanyGroup(companyId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByCompanyGroup_Last(companyId, groupId,
				orderByComparator);

		if (copyRequest != null) {
			return copyRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCopyRequestException(msg.toString());
	}

	/**
	 * Returns the last copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<CopyRequest> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the copy requests before and after the current copy request in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param copyRequestId the primary key of the current copy request
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest[] findByCompanyGroup_PrevAndNext(long copyRequestId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = findByPrimaryKey(copyRequestId);

		Session session = null;

		try {
			session = openSession();

			CopyRequest[] array = new CopyRequestImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, copyRequest,
					companyId, groupId, orderByComparator, true);

			array[1] = copyRequest;

			array[2] = getByCompanyGroup_PrevAndNext(session, copyRequest,
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

	protected CopyRequest getByCompanyGroup_PrevAndNext(Session session,
		CopyRequest copyRequest, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COPYREQUEST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

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
			query.append(CopyRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(copyRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CopyRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the copy requests where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (CopyRequest copyRequest : findByCompanyGroup(companyId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(copyRequest);
		}
	}

	/**
	 * Returns the number of copy requests where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COPYREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

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

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "copyRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "copyRequest.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS =
		new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CopyRequestModelImpl.GROUPID_COLUMN_BITMASK |
			CopyRequestModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPANDSTATUS = new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the copy requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByGroupAndStatus(long groupId, int status)
		throws SystemException {
		return findByGroupAndStatus(groupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the copy requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @return the range of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByGroupAndStatus(long groupId, int status,
		int start, int end) throws SystemException {
		return findByGroupAndStatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the copy requests where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByGroupAndStatus(long groupId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPANDSTATUS;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<CopyRequest> list = (List<CopyRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CopyRequest copyRequest : list) {
				if ((groupId != copyRequest.getGroupId()) ||
						(status != copyRequest.getStatus())) {
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

			query.append(_SQL_SELECT_COPYREQUEST_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CopyRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CopyRequest>(list);
				}
				else {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first copy request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByGroupAndStatus_First(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByGroupAndStatus_First(groupId, status,
				orderByComparator);

		if (copyRequest != null) {
			return copyRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCopyRequestException(msg.toString());
	}

	/**
	 * Returns the first copy request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByGroupAndStatus_First(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<CopyRequest> list = findByGroupAndStatus(groupId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last copy request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByGroupAndStatus_Last(long groupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByGroupAndStatus_Last(groupId, status,
				orderByComparator);

		if (copyRequest != null) {
			return copyRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCopyRequestException(msg.toString());
	}

	/**
	 * Returns the last copy request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByGroupAndStatus_Last(long groupId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupAndStatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<CopyRequest> list = findByGroupAndStatus(groupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the copy requests before and after the current copy request in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param copyRequestId the primary key of the current copy request
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest[] findByGroupAndStatus_PrevAndNext(long copyRequestId,
		long groupId, int status, OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = findByPrimaryKey(copyRequestId);

		Session session = null;

		try {
			session = openSession();

			CopyRequest[] array = new CopyRequestImpl[3];

			array[0] = getByGroupAndStatus_PrevAndNext(session, copyRequest,
					groupId, status, orderByComparator, true);

			array[1] = copyRequest;

			array[2] = getByGroupAndStatus_PrevAndNext(session, copyRequest,
					groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CopyRequest getByGroupAndStatus_PrevAndNext(Session session,
		CopyRequest copyRequest, long groupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COPYREQUEST_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

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
			query.append(CopyRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(copyRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CopyRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the copy requests where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupAndStatus(long groupId, int status)
		throws SystemException {
		for (CopyRequest copyRequest : findByGroupAndStatus(groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(copyRequest);
		}
	}

	/**
	 * Returns the number of copy requests where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupAndStatus(long groupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPANDSTATUS;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COPYREQUEST_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPANDSTATUS_GROUPID_2 = "copyRequest.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPANDSTATUS_STATUS_2 = "copyRequest.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS =
		new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, CopyRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CopyRequestModelImpl.COMPANYID_COLUMN_BITMASK |
			CopyRequestModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYANDSTATUS = new FinderPath(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the copy requests where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByCompanyAndStatus(long companyId, int status)
		throws SystemException {
		return findByCompanyAndStatus(companyId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the copy requests where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @return the range of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByCompanyAndStatus(long companyId, int status,
		int start, int end) throws SystemException {
		return findByCompanyAndStatus(companyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the copy requests where companyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findByCompanyAndStatus(long companyId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] { companyId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYANDSTATUS;
			finderArgs = new Object[] {
					companyId, status,
					
					start, end, orderByComparator
				};
		}

		List<CopyRequest> list = (List<CopyRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CopyRequest copyRequest : list) {
				if ((companyId != copyRequest.getCompanyId()) ||
						(status != copyRequest.getStatus())) {
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

			query.append(_SQL_SELECT_COPYREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CopyRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(status);

				if (!pagination) {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CopyRequest>(list);
				}
				else {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first copy request in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByCompanyAndStatus_First(long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByCompanyAndStatus_First(companyId,
				status, orderByComparator);

		if (copyRequest != null) {
			return copyRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCopyRequestException(msg.toString());
	}

	/**
	 * Returns the first copy request in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching copy request, or <code>null</code> if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByCompanyAndStatus_First(long companyId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<CopyRequest> list = findByCompanyAndStatus(companyId, status, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last copy request in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByCompanyAndStatus_Last(long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByCompanyAndStatus_Last(companyId,
				status, orderByComparator);

		if (copyRequest != null) {
			return copyRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCopyRequestException(msg.toString());
	}

	/**
	 * Returns the last copy request in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching copy request, or <code>null</code> if a matching copy request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByCompanyAndStatus_Last(long companyId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyAndStatus(companyId, status);

		if (count == 0) {
			return null;
		}

		List<CopyRequest> list = findByCompanyAndStatus(companyId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the copy requests before and after the current copy request in the ordered set where companyId = &#63; and status = &#63;.
	 *
	 * @param copyRequestId the primary key of the current copy request
	 * @param companyId the company ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest[] findByCompanyAndStatus_PrevAndNext(
		long copyRequestId, long companyId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = findByPrimaryKey(copyRequestId);

		Session session = null;

		try {
			session = openSession();

			CopyRequest[] array = new CopyRequestImpl[3];

			array[0] = getByCompanyAndStatus_PrevAndNext(session, copyRequest,
					companyId, status, orderByComparator, true);

			array[1] = copyRequest;

			array[2] = getByCompanyAndStatus_PrevAndNext(session, copyRequest,
					companyId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CopyRequest getByCompanyAndStatus_PrevAndNext(Session session,
		CopyRequest copyRequest, long companyId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COPYREQUEST_WHERE);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

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
			query.append(CopyRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(copyRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CopyRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the copy requests where companyId = &#63; and status = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyAndStatus(long companyId, int status)
		throws SystemException {
		for (CopyRequest copyRequest : findByCompanyAndStatus(companyId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(copyRequest);
		}
	}

	/**
	 * Returns the number of copy requests where companyId = &#63; and status = &#63;.
	 *
	 * @param companyId the company ID
	 * @param status the status
	 * @return the number of matching copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyAndStatus(long companyId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYANDSTATUS;

		Object[] finderArgs = new Object[] { companyId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COPYREQUEST_WHERE);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_COMPANYID_2 = "copyRequest.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYANDSTATUS_STATUS_2 = "copyRequest.status = ?";

	public CopyRequestPersistenceImpl() {
		setModelClass(CopyRequest.class);
	}

	/**
	 * Caches the copy request in the entity cache if it is enabled.
	 *
	 * @param copyRequest the copy request
	 */
	@Override
	public void cacheResult(CopyRequest copyRequest) {
		EntityCacheUtil.putResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestImpl.class, copyRequest.getPrimaryKey(), copyRequest);

		copyRequest.resetOriginalValues();
	}

	/**
	 * Caches the copy requests in the entity cache if it is enabled.
	 *
	 * @param copyRequests the copy requests
	 */
	@Override
	public void cacheResult(List<CopyRequest> copyRequests) {
		for (CopyRequest copyRequest : copyRequests) {
			if (EntityCacheUtil.getResult(
						CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
						CopyRequestImpl.class, copyRequest.getPrimaryKey()) == null) {
				cacheResult(copyRequest);
			}
			else {
				copyRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all copy requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CopyRequestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CopyRequestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the copy request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CopyRequest copyRequest) {
		EntityCacheUtil.removeResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestImpl.class, copyRequest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CopyRequest> copyRequests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CopyRequest copyRequest : copyRequests) {
			EntityCacheUtil.removeResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
				CopyRequestImpl.class, copyRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new copy request with the primary key. Does not add the copy request to the database.
	 *
	 * @param copyRequestId the primary key for the new copy request
	 * @return the new copy request
	 */
	@Override
	public CopyRequest create(long copyRequestId) {
		CopyRequest copyRequest = new CopyRequestImpl();

		copyRequest.setNew(true);
		copyRequest.setPrimaryKey(copyRequestId);

		return copyRequest;
	}

	/**
	 * Removes the copy request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param copyRequestId the primary key of the copy request
	 * @return the copy request that was removed
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest remove(long copyRequestId)
		throws NoSuchCopyRequestException, SystemException {
		return remove((Serializable)copyRequestId);
	}

	/**
	 * Removes the copy request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the copy request
	 * @return the copy request that was removed
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest remove(Serializable primaryKey)
		throws NoSuchCopyRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CopyRequest copyRequest = (CopyRequest)session.get(CopyRequestImpl.class,
					primaryKey);

			if (copyRequest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCopyRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(copyRequest);
		}
		catch (NoSuchCopyRequestException nsee) {
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
	protected CopyRequest removeImpl(CopyRequest copyRequest)
		throws SystemException {
		copyRequest = toUnwrappedModel(copyRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(copyRequest)) {
				copyRequest = (CopyRequest)session.get(CopyRequestImpl.class,
						copyRequest.getPrimaryKeyObj());
			}

			if (copyRequest != null) {
				session.delete(copyRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (copyRequest != null) {
			clearCache(copyRequest);
		}

		return copyRequest;
	}

	@Override
	public CopyRequest updateImpl(
		com.idetronic.subur.model.CopyRequest copyRequest)
		throws SystemException {
		copyRequest = toUnwrappedModel(copyRequest);

		boolean isNew = copyRequest.isNew();

		CopyRequestModelImpl copyRequestModelImpl = (CopyRequestModelImpl)copyRequest;

		Session session = null;

		try {
			session = openSession();

			if (copyRequest.isNew()) {
				session.save(copyRequest);

				copyRequest.setNew(false);
			}
			else {
				session.merge(copyRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CopyRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((copyRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						copyRequestModelImpl.getOriginalCompanyId(),
						copyRequestModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						copyRequestModelImpl.getCompanyId(),
						copyRequestModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((copyRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						copyRequestModelImpl.getOriginalGroupId(),
						copyRequestModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);

				args = new Object[] {
						copyRequestModelImpl.getGroupId(),
						copyRequestModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPANDSTATUS,
					args);
			}

			if ((copyRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						copyRequestModelImpl.getOriginalCompanyId(),
						copyRequestModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);

				args = new Object[] {
						copyRequestModelImpl.getCompanyId(),
						copyRequestModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
			CopyRequestImpl.class, copyRequest.getPrimaryKey(), copyRequest);

		return copyRequest;
	}

	protected CopyRequest toUnwrappedModel(CopyRequest copyRequest) {
		if (copyRequest instanceof CopyRequestImpl) {
			return copyRequest;
		}

		CopyRequestImpl copyRequestImpl = new CopyRequestImpl();

		copyRequestImpl.setNew(copyRequest.isNew());
		copyRequestImpl.setPrimaryKey(copyRequest.getPrimaryKey());

		copyRequestImpl.setCopyRequestId(copyRequest.getCopyRequestId());
		copyRequestImpl.setCompanyId(copyRequest.getCompanyId());
		copyRequestImpl.setGroupId(copyRequest.getGroupId());
		copyRequestImpl.setDateCreated(copyRequest.getDateCreated());
		copyRequestImpl.setStatus(copyRequest.getStatus());
		copyRequestImpl.setSuburItemId(copyRequest.getSuburItemId());
		copyRequestImpl.setFromEmailAddress(copyRequest.getFromEmailAddress());
		copyRequestImpl.setRequesterName(copyRequest.getRequesterName());
		copyRequestImpl.setReason(copyRequest.getReason());
		copyRequestImpl.setOrganization(copyRequest.getOrganization());
		copyRequestImpl.setDateResponsed(copyRequest.getDateResponsed());
		copyRequestImpl.setRespondText(copyRequest.getRespondText());
		copyRequestImpl.setResponsedByUserId(copyRequest.getResponsedByUserId());

		return copyRequestImpl;
	}

	/**
	 * Returns the copy request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the copy request
	 * @return the copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCopyRequestException, SystemException {
		CopyRequest copyRequest = fetchByPrimaryKey(primaryKey);

		if (copyRequest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCopyRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return copyRequest;
	}

	/**
	 * Returns the copy request with the primary key or throws a {@link com.idetronic.subur.NoSuchCopyRequestException} if it could not be found.
	 *
	 * @param copyRequestId the primary key of the copy request
	 * @return the copy request
	 * @throws com.idetronic.subur.NoSuchCopyRequestException if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest findByPrimaryKey(long copyRequestId)
		throws NoSuchCopyRequestException, SystemException {
		return findByPrimaryKey((Serializable)copyRequestId);
	}

	/**
	 * Returns the copy request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the copy request
	 * @return the copy request, or <code>null</code> if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CopyRequest copyRequest = (CopyRequest)EntityCacheUtil.getResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
				CopyRequestImpl.class, primaryKey);

		if (copyRequest == _nullCopyRequest) {
			return null;
		}

		if (copyRequest == null) {
			Session session = null;

			try {
				session = openSession();

				copyRequest = (CopyRequest)session.get(CopyRequestImpl.class,
						primaryKey);

				if (copyRequest != null) {
					cacheResult(copyRequest);
				}
				else {
					EntityCacheUtil.putResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
						CopyRequestImpl.class, primaryKey, _nullCopyRequest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CopyRequestModelImpl.ENTITY_CACHE_ENABLED,
					CopyRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return copyRequest;
	}

	/**
	 * Returns the copy request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param copyRequestId the primary key of the copy request
	 * @return the copy request, or <code>null</code> if a copy request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CopyRequest fetchByPrimaryKey(long copyRequestId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)copyRequestId);
	}

	/**
	 * Returns all the copy requests.
	 *
	 * @return the copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the copy requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @return the range of copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the copy requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.CopyRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of copy requests
	 * @param end the upper bound of the range of copy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of copy requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CopyRequest> findAll(int start, int end,
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

		List<CopyRequest> list = (List<CopyRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COPYREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COPYREQUEST;

				if (pagination) {
					sql = sql.concat(CopyRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CopyRequest>(list);
				}
				else {
					list = (List<CopyRequest>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the copy requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CopyRequest copyRequest : findAll()) {
			remove(copyRequest);
		}
	}

	/**
	 * Returns the number of copy requests.
	 *
	 * @return the number of copy requests
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

				Query q = session.createQuery(_SQL_COUNT_COPYREQUEST);

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
	 * Initializes the copy request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.CopyRequest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CopyRequest>> listenersList = new ArrayList<ModelListener<CopyRequest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CopyRequest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CopyRequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COPYREQUEST = "SELECT copyRequest FROM CopyRequest copyRequest";
	private static final String _SQL_SELECT_COPYREQUEST_WHERE = "SELECT copyRequest FROM CopyRequest copyRequest WHERE ";
	private static final String _SQL_COUNT_COPYREQUEST = "SELECT COUNT(copyRequest) FROM CopyRequest copyRequest";
	private static final String _SQL_COUNT_COPYREQUEST_WHERE = "SELECT COUNT(copyRequest) FROM CopyRequest copyRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "copyRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CopyRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CopyRequest exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CopyRequestPersistenceImpl.class);
	private static CopyRequest _nullCopyRequest = new CopyRequestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CopyRequest> toCacheModel() {
				return _nullCopyRequestCacheModel;
			}
		};

	private static CacheModel<CopyRequest> _nullCopyRequestCacheModel = new CacheModel<CopyRequest>() {
			@Override
			public CopyRequest toEntityModel() {
				return _nullCopyRequest;
			}
		};
}