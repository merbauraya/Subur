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

import com.idetronic.subur.NoSuchAuthorResearchInterestException;
import com.idetronic.subur.model.AuthorResearchInterest;
import com.idetronic.subur.model.impl.AuthorResearchInterestImpl;
import com.idetronic.subur.model.impl.AuthorResearchInterestModelImpl;

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
 * The persistence implementation for the author research interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see AuthorResearchInterestPersistence
 * @see AuthorResearchInterestUtil
 * @generated
 */
public class AuthorResearchInterestPersistenceImpl extends BasePersistenceImpl<AuthorResearchInterest>
	implements AuthorResearchInterestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuthorResearchInterestUtil} to access the author research interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuthorResearchInterestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR = new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthor",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR =
		new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthor",
			new String[] { Long.class.getName() },
			AuthorResearchInterestModelImpl.AUTHORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHOR = new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthor",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the author research interests where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching author research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorResearchInterest> findByAuthor(long authorId)
		throws SystemException {
		return findByAuthor(authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<AuthorResearchInterest> findByAuthor(long authorId, int start,
		int end) throws SystemException {
		return findByAuthor(authorId, start, end, null);
	}

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
	@Override
	public List<AuthorResearchInterest> findByAuthor(long authorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { authorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { authorId, start, end, orderByComparator };
		}

		List<AuthorResearchInterest> list = (List<AuthorResearchInterest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AuthorResearchInterest authorResearchInterest : list) {
				if ((authorId != authorResearchInterest.getAuthorId())) {
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

			query.append(_SQL_SELECT_AUTHORRESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AuthorResearchInterestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (!pagination) {
					list = (List<AuthorResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorResearchInterest>(list);
				}
				else {
					list = (List<AuthorResearchInterest>)QueryUtil.list(q,
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
	 * Returns the first author research interest in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author research interest
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest findByAuthor_First(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = fetchByAuthor_First(authorId,
				orderByComparator);

		if (authorResearchInterest != null) {
			return authorResearchInterest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorResearchInterestException(msg.toString());
	}

	/**
	 * Returns the first author research interest in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author research interest, or <code>null</code> if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest fetchByAuthor_First(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AuthorResearchInterest> list = findByAuthor(authorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author research interest in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author research interest
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest findByAuthor_Last(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = fetchByAuthor_Last(authorId,
				orderByComparator);

		if (authorResearchInterest != null) {
			return authorResearchInterest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorResearchInterestException(msg.toString());
	}

	/**
	 * Returns the last author research interest in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author research interest, or <code>null</code> if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest fetchByAuthor_Last(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthor(authorId);

		if (count == 0) {
			return null;
		}

		List<AuthorResearchInterest> list = findByAuthor(authorId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public AuthorResearchInterest[] findByAuthor_PrevAndNext(
		AuthorResearchInterestPK authorResearchInterestPK, long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = findByPrimaryKey(authorResearchInterestPK);

		Session session = null;

		try {
			session = openSession();

			AuthorResearchInterest[] array = new AuthorResearchInterestImpl[3];

			array[0] = getByAuthor_PrevAndNext(session, authorResearchInterest,
					authorId, orderByComparator, true);

			array[1] = authorResearchInterest;

			array[2] = getByAuthor_PrevAndNext(session, authorResearchInterest,
					authorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AuthorResearchInterest getByAuthor_PrevAndNext(Session session,
		AuthorResearchInterest authorResearchInterest, long authorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUTHORRESEARCHINTEREST_WHERE);

		query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

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
			query.append(AuthorResearchInterestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(authorResearchInterest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AuthorResearchInterest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the author research interests where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthor(long authorId) throws SystemException {
		for (AuthorResearchInterest authorResearchInterest : findByAuthor(
				authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(authorResearchInterest);
		}
	}

	/**
	 * Returns the number of author research interests where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching author research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthor(long authorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHOR;

		Object[] finderArgs = new Object[] { authorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUTHORRESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_AUTHOR_AUTHORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

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

	private static final String _FINDER_COLUMN_AUTHOR_AUTHORID_2 = "authorResearchInterest.id.authorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHINTEREST =
		new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearchInterest",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHINTEREST =
		new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchInterest", new String[] { Long.class.getName() },
			AuthorResearchInterestModelImpl.RESEARCHINTERESTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHINTEREST = new FinderPath(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchInterest", new String[] { Long.class.getName() });

	/**
	 * Returns all the author research interests where researchInterestId = &#63;.
	 *
	 * @param researchInterestId the research interest ID
	 * @return the matching author research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorResearchInterest> findByResearchInterest(
		long researchInterestId) throws SystemException {
		return findByResearchInterest(researchInterestId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<AuthorResearchInterest> findByResearchInterest(
		long researchInterestId, int start, int end) throws SystemException {
		return findByResearchInterest(researchInterestId, start, end, null);
	}

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
	@Override
	public List<AuthorResearchInterest> findByResearchInterest(
		long researchInterestId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHINTEREST;
			finderArgs = new Object[] { researchInterestId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHINTEREST;
			finderArgs = new Object[] {
					researchInterestId,
					
					start, end, orderByComparator
				};
		}

		List<AuthorResearchInterest> list = (List<AuthorResearchInterest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AuthorResearchInterest authorResearchInterest : list) {
				if ((researchInterestId != authorResearchInterest.getResearchInterestId())) {
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

			query.append(_SQL_SELECT_AUTHORRESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHINTEREST_RESEARCHINTERESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AuthorResearchInterestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchInterestId);

				if (!pagination) {
					list = (List<AuthorResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorResearchInterest>(list);
				}
				else {
					list = (List<AuthorResearchInterest>)QueryUtil.list(q,
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
	 * Returns the first author research interest in the ordered set where researchInterestId = &#63;.
	 *
	 * @param researchInterestId the research interest ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author research interest
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest findByResearchInterest_First(
		long researchInterestId, OrderByComparator orderByComparator)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = fetchByResearchInterest_First(researchInterestId,
				orderByComparator);

		if (authorResearchInterest != null) {
			return authorResearchInterest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchInterestId=");
		msg.append(researchInterestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorResearchInterestException(msg.toString());
	}

	/**
	 * Returns the first author research interest in the ordered set where researchInterestId = &#63;.
	 *
	 * @param researchInterestId the research interest ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author research interest, or <code>null</code> if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest fetchByResearchInterest_First(
		long researchInterestId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AuthorResearchInterest> list = findByResearchInterest(researchInterestId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author research interest in the ordered set where researchInterestId = &#63;.
	 *
	 * @param researchInterestId the research interest ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author research interest
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest findByResearchInterest_Last(
		long researchInterestId, OrderByComparator orderByComparator)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = fetchByResearchInterest_Last(researchInterestId,
				orderByComparator);

		if (authorResearchInterest != null) {
			return authorResearchInterest;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchInterestId=");
		msg.append(researchInterestId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAuthorResearchInterestException(msg.toString());
	}

	/**
	 * Returns the last author research interest in the ordered set where researchInterestId = &#63;.
	 *
	 * @param researchInterestId the research interest ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author research interest, or <code>null</code> if a matching author research interest could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest fetchByResearchInterest_Last(
		long researchInterestId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResearchInterest(researchInterestId);

		if (count == 0) {
			return null;
		}

		List<AuthorResearchInterest> list = findByResearchInterest(researchInterestId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public AuthorResearchInterest[] findByResearchInterest_PrevAndNext(
		AuthorResearchInterestPK authorResearchInterestPK,
		long researchInterestId, OrderByComparator orderByComparator)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = findByPrimaryKey(authorResearchInterestPK);

		Session session = null;

		try {
			session = openSession();

			AuthorResearchInterest[] array = new AuthorResearchInterestImpl[3];

			array[0] = getByResearchInterest_PrevAndNext(session,
					authorResearchInterest, researchInterestId,
					orderByComparator, true);

			array[1] = authorResearchInterest;

			array[2] = getByResearchInterest_PrevAndNext(session,
					authorResearchInterest, researchInterestId,
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

	protected AuthorResearchInterest getByResearchInterest_PrevAndNext(
		Session session, AuthorResearchInterest authorResearchInterest,
		long researchInterestId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AUTHORRESEARCHINTEREST_WHERE);

		query.append(_FINDER_COLUMN_RESEARCHINTEREST_RESEARCHINTERESTID_2);

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
			query.append(AuthorResearchInterestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchInterestId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(authorResearchInterest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AuthorResearchInterest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the author research interests where researchInterestId = &#63; from the database.
	 *
	 * @param researchInterestId the research interest ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchInterest(long researchInterestId)
		throws SystemException {
		for (AuthorResearchInterest authorResearchInterest : findByResearchInterest(
				researchInterestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(authorResearchInterest);
		}
	}

	/**
	 * Returns the number of author research interests where researchInterestId = &#63;.
	 *
	 * @param researchInterestId the research interest ID
	 * @return the number of matching author research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchInterest(long researchInterestId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHINTEREST;

		Object[] finderArgs = new Object[] { researchInterestId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AUTHORRESEARCHINTEREST_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHINTEREST_RESEARCHINTERESTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchInterestId);

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

	private static final String _FINDER_COLUMN_RESEARCHINTEREST_RESEARCHINTERESTID_2 =
		"authorResearchInterest.id.researchInterestId = ?";

	public AuthorResearchInterestPersistenceImpl() {
		setModelClass(AuthorResearchInterest.class);
	}

	/**
	 * Caches the author research interest in the entity cache if it is enabled.
	 *
	 * @param authorResearchInterest the author research interest
	 */
	@Override
	public void cacheResult(AuthorResearchInterest authorResearchInterest) {
		EntityCacheUtil.putResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			authorResearchInterest.getPrimaryKey(), authorResearchInterest);

		authorResearchInterest.resetOriginalValues();
	}

	/**
	 * Caches the author research interests in the entity cache if it is enabled.
	 *
	 * @param authorResearchInterests the author research interests
	 */
	@Override
	public void cacheResult(
		List<AuthorResearchInterest> authorResearchInterests) {
		for (AuthorResearchInterest authorResearchInterest : authorResearchInterests) {
			if (EntityCacheUtil.getResult(
						AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
						AuthorResearchInterestImpl.class,
						authorResearchInterest.getPrimaryKey()) == null) {
				cacheResult(authorResearchInterest);
			}
			else {
				authorResearchInterest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all author research interests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuthorResearchInterestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuthorResearchInterestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the author research interest.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuthorResearchInterest authorResearchInterest) {
		EntityCacheUtil.removeResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			authorResearchInterest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AuthorResearchInterest> authorResearchInterests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuthorResearchInterest authorResearchInterest : authorResearchInterests) {
			EntityCacheUtil.removeResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
				AuthorResearchInterestImpl.class,
				authorResearchInterest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new author research interest with the primary key. Does not add the author research interest to the database.
	 *
	 * @param authorResearchInterestPK the primary key for the new author research interest
	 * @return the new author research interest
	 */
	@Override
	public AuthorResearchInterest create(
		AuthorResearchInterestPK authorResearchInterestPK) {
		AuthorResearchInterest authorResearchInterest = new AuthorResearchInterestImpl();

		authorResearchInterest.setNew(true);
		authorResearchInterest.setPrimaryKey(authorResearchInterestPK);

		return authorResearchInterest;
	}

	/**
	 * Removes the author research interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorResearchInterestPK the primary key of the author research interest
	 * @return the author research interest that was removed
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest remove(
		AuthorResearchInterestPK authorResearchInterestPK)
		throws NoSuchAuthorResearchInterestException, SystemException {
		return remove((Serializable)authorResearchInterestPK);
	}

	/**
	 * Removes the author research interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the author research interest
	 * @return the author research interest that was removed
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest remove(Serializable primaryKey)
		throws NoSuchAuthorResearchInterestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AuthorResearchInterest authorResearchInterest = (AuthorResearchInterest)session.get(AuthorResearchInterestImpl.class,
					primaryKey);

			if (authorResearchInterest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorResearchInterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(authorResearchInterest);
		}
		catch (NoSuchAuthorResearchInterestException nsee) {
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
	protected AuthorResearchInterest removeImpl(
		AuthorResearchInterest authorResearchInterest)
		throws SystemException {
		authorResearchInterest = toUnwrappedModel(authorResearchInterest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(authorResearchInterest)) {
				authorResearchInterest = (AuthorResearchInterest)session.get(AuthorResearchInterestImpl.class,
						authorResearchInterest.getPrimaryKeyObj());
			}

			if (authorResearchInterest != null) {
				session.delete(authorResearchInterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (authorResearchInterest != null) {
			clearCache(authorResearchInterest);
		}

		return authorResearchInterest;
	}

	@Override
	public AuthorResearchInterest updateImpl(
		com.idetronic.subur.model.AuthorResearchInterest authorResearchInterest)
		throws SystemException {
		authorResearchInterest = toUnwrappedModel(authorResearchInterest);

		boolean isNew = authorResearchInterest.isNew();

		AuthorResearchInterestModelImpl authorResearchInterestModelImpl = (AuthorResearchInterestModelImpl)authorResearchInterest;

		Session session = null;

		try {
			session = openSession();

			if (authorResearchInterest.isNew()) {
				session.save(authorResearchInterest);

				authorResearchInterest.setNew(false);
			}
			else {
				session.merge(authorResearchInterest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AuthorResearchInterestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((authorResearchInterestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						authorResearchInterestModelImpl.getOriginalAuthorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);

				args = new Object[] {
						authorResearchInterestModelImpl.getAuthorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);
			}

			if ((authorResearchInterestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHINTEREST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						authorResearchInterestModelImpl.getOriginalResearchInterestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHINTEREST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHINTEREST,
					args);

				args = new Object[] {
						authorResearchInterestModelImpl.getResearchInterestId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHINTEREST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHINTEREST,
					args);
			}
		}

		EntityCacheUtil.putResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
			AuthorResearchInterestImpl.class,
			authorResearchInterest.getPrimaryKey(), authorResearchInterest);

		return authorResearchInterest;
	}

	protected AuthorResearchInterest toUnwrappedModel(
		AuthorResearchInterest authorResearchInterest) {
		if (authorResearchInterest instanceof AuthorResearchInterestImpl) {
			return authorResearchInterest;
		}

		AuthorResearchInterestImpl authorResearchInterestImpl = new AuthorResearchInterestImpl();

		authorResearchInterestImpl.setNew(authorResearchInterest.isNew());
		authorResearchInterestImpl.setPrimaryKey(authorResearchInterest.getPrimaryKey());

		authorResearchInterestImpl.setAuthorId(authorResearchInterest.getAuthorId());
		authorResearchInterestImpl.setResearchInterestId(authorResearchInterest.getResearchInterestId());

		return authorResearchInterestImpl;
	}

	/**
	 * Returns the author research interest with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the author research interest
	 * @return the author research interest
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthorResearchInterestException, SystemException {
		AuthorResearchInterest authorResearchInterest = fetchByPrimaryKey(primaryKey);

		if (authorResearchInterest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthorResearchInterestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return authorResearchInterest;
	}

	/**
	 * Returns the author research interest with the primary key or throws a {@link com.idetronic.subur.NoSuchAuthorResearchInterestException} if it could not be found.
	 *
	 * @param authorResearchInterestPK the primary key of the author research interest
	 * @return the author research interest
	 * @throws com.idetronic.subur.NoSuchAuthorResearchInterestException if a author research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest findByPrimaryKey(
		AuthorResearchInterestPK authorResearchInterestPK)
		throws NoSuchAuthorResearchInterestException, SystemException {
		return findByPrimaryKey((Serializable)authorResearchInterestPK);
	}

	/**
	 * Returns the author research interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the author research interest
	 * @return the author research interest, or <code>null</code> if a author research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AuthorResearchInterest authorResearchInterest = (AuthorResearchInterest)EntityCacheUtil.getResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
				AuthorResearchInterestImpl.class, primaryKey);

		if (authorResearchInterest == _nullAuthorResearchInterest) {
			return null;
		}

		if (authorResearchInterest == null) {
			Session session = null;

			try {
				session = openSession();

				authorResearchInterest = (AuthorResearchInterest)session.get(AuthorResearchInterestImpl.class,
						primaryKey);

				if (authorResearchInterest != null) {
					cacheResult(authorResearchInterest);
				}
				else {
					EntityCacheUtil.putResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
						AuthorResearchInterestImpl.class, primaryKey,
						_nullAuthorResearchInterest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AuthorResearchInterestModelImpl.ENTITY_CACHE_ENABLED,
					AuthorResearchInterestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return authorResearchInterest;
	}

	/**
	 * Returns the author research interest with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorResearchInterestPK the primary key of the author research interest
	 * @return the author research interest, or <code>null</code> if a author research interest with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuthorResearchInterest fetchByPrimaryKey(
		AuthorResearchInterestPK authorResearchInterestPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)authorResearchInterestPK);
	}

	/**
	 * Returns all the author research interests.
	 *
	 * @return the author research interests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AuthorResearchInterest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<AuthorResearchInterest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<AuthorResearchInterest> findAll(int start, int end,
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

		List<AuthorResearchInterest> list = (List<AuthorResearchInterest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUTHORRESEARCHINTEREST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHORRESEARCHINTEREST;

				if (pagination) {
					sql = sql.concat(AuthorResearchInterestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AuthorResearchInterest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AuthorResearchInterest>(list);
				}
				else {
					list = (List<AuthorResearchInterest>)QueryUtil.list(q,
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
	 * Removes all the author research interests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AuthorResearchInterest authorResearchInterest : findAll()) {
			remove(authorResearchInterest);
		}
	}

	/**
	 * Returns the number of author research interests.
	 *
	 * @return the number of author research interests
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

				Query q = session.createQuery(_SQL_COUNT_AUTHORRESEARCHINTEREST);

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
	 * Initializes the author research interest persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.AuthorResearchInterest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AuthorResearchInterest>> listenersList = new ArrayList<ModelListener<AuthorResearchInterest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AuthorResearchInterest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuthorResearchInterestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AUTHORRESEARCHINTEREST = "SELECT authorResearchInterest FROM AuthorResearchInterest authorResearchInterest";
	private static final String _SQL_SELECT_AUTHORRESEARCHINTEREST_WHERE = "SELECT authorResearchInterest FROM AuthorResearchInterest authorResearchInterest WHERE ";
	private static final String _SQL_COUNT_AUTHORRESEARCHINTEREST = "SELECT COUNT(authorResearchInterest) FROM AuthorResearchInterest authorResearchInterest";
	private static final String _SQL_COUNT_AUTHORRESEARCHINTEREST_WHERE = "SELECT COUNT(authorResearchInterest) FROM AuthorResearchInterest authorResearchInterest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "authorResearchInterest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuthorResearchInterest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AuthorResearchInterest exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuthorResearchInterestPersistenceImpl.class);
	private static AuthorResearchInterest _nullAuthorResearchInterest = new AuthorResearchInterestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AuthorResearchInterest> toCacheModel() {
				return _nullAuthorResearchInterestCacheModel;
			}
		};

	private static CacheModel<AuthorResearchInterest> _nullAuthorResearchInterestCacheModel =
		new CacheModel<AuthorResearchInterest>() {
			@Override
			public AuthorResearchInterest toEntityModel() {
				return _nullAuthorResearchInterest;
			}
		};
}