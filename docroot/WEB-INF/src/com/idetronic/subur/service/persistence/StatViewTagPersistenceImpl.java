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

import com.idetronic.subur.NoSuchStatViewTagException;
import com.idetronic.subur.model.StatViewTag;
import com.idetronic.subur.model.impl.StatViewTagImpl;
import com.idetronic.subur.model.impl.StatViewTagModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the stat view tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewTagPersistence
 * @see StatViewTagUtil
 * @generated
 */
public class StatViewTagPersistenceImpl extends BasePersistenceImpl<StatViewTag>
	implements StatViewTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatViewTagUtil} to access the stat view tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatViewTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagModelImpl.FINDER_CACHE_ENABLED, StatViewTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagModelImpl.FINDER_CACHE_ENABLED, StatViewTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TAGPERIOD = new FinderPath(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagModelImpl.FINDER_CACHE_ENABLED, StatViewTagImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTagPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			StatViewTagModelImpl.COMPANYID_COLUMN_BITMASK |
			StatViewTagModelImpl.GROUPID_COLUMN_BITMASK |
			StatViewTagModelImpl.TAGID_COLUMN_BITMASK |
			StatViewTagModelImpl.PERYEAR_COLUMN_BITMASK |
			StatViewTagModelImpl.PERMONTH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAGPERIOD = new FinderPath(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTagPeriod",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; or throws a {@link com.idetronic.subur.NoSuchStatViewTagException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param tagId the tag ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the matching stat view tag
	 * @throws com.idetronic.subur.NoSuchStatViewTagException if a matching stat view tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag findByTagPeriod(long companyId, long groupId,
		long tagId, int perYear, int perMonth)
		throws NoSuchStatViewTagException, SystemException {
		StatViewTag statViewTag = fetchByTagPeriod(companyId, groupId, tagId,
				perYear, perMonth);

		if (statViewTag == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", tagId=");
			msg.append(tagId);

			msg.append(", perYear=");
			msg.append(perYear);

			msg.append(", perMonth=");
			msg.append(perMonth);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStatViewTagException(msg.toString());
		}

		return statViewTag;
	}

	/**
	 * Returns the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param tagId the tag ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the matching stat view tag, or <code>null</code> if a matching stat view tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag fetchByTagPeriod(long companyId, long groupId,
		long tagId, int perYear, int perMonth) throws SystemException {
		return fetchByTagPeriod(companyId, groupId, tagId, perYear, perMonth,
			true);
	}

	/**
	 * Returns the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param tagId the tag ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching stat view tag, or <code>null</code> if a matching stat view tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag fetchByTagPeriod(long companyId, long groupId,
		long tagId, int perYear, int perMonth, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, tagId, perYear, perMonth
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TAGPERIOD,
					finderArgs, this);
		}

		if (result instanceof StatViewTag) {
			StatViewTag statViewTag = (StatViewTag)result;

			if ((companyId != statViewTag.getCompanyId()) ||
					(groupId != statViewTag.getGroupId()) ||
					(tagId != statViewTag.getTagId()) ||
					(perYear != statViewTag.getPerYear()) ||
					(perMonth != statViewTag.getPerMonth())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_STATVIEWTAG_WHERE);

			query.append(_FINDER_COLUMN_TAGPERIOD_COMPANYID_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_GROUPID_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_TAGID_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_PERYEAR_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_PERMONTH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(tagId);

				qPos.add(perYear);

				qPos.add(perMonth);

				List<StatViewTag> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGPERIOD,
						finderArgs, list);
				}
				else {
					StatViewTag statViewTag = list.get(0);

					result = statViewTag;

					cacheResult(statViewTag);

					if ((statViewTag.getCompanyId() != companyId) ||
							(statViewTag.getGroupId() != groupId) ||
							(statViewTag.getTagId() != tagId) ||
							(statViewTag.getPerYear() != perYear) ||
							(statViewTag.getPerMonth() != perMonth)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGPERIOD,
							finderArgs, statViewTag);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAGPERIOD,
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
			return (StatViewTag)result;
		}
	}

	/**
	 * Removes the stat view tag where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param tagId the tag ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the stat view tag that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag removeByTagPeriod(long companyId, long groupId,
		long tagId, int perYear, int perMonth)
		throws NoSuchStatViewTagException, SystemException {
		StatViewTag statViewTag = findByTagPeriod(companyId, groupId, tagId,
				perYear, perMonth);

		return remove(statViewTag);
	}

	/**
	 * Returns the number of stat view tags where companyId = &#63; and groupId = &#63; and tagId = &#63; and perYear = &#63; and perMonth = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param tagId the tag ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the number of matching stat view tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTagPeriod(long companyId, long groupId, long tagId,
		int perYear, int perMonth) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAGPERIOD;

		Object[] finderArgs = new Object[] {
				companyId, groupId, tagId, perYear, perMonth
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_STATVIEWTAG_WHERE);

			query.append(_FINDER_COLUMN_TAGPERIOD_COMPANYID_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_GROUPID_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_TAGID_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_PERYEAR_2);

			query.append(_FINDER_COLUMN_TAGPERIOD_PERMONTH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(tagId);

				qPos.add(perYear);

				qPos.add(perMonth);

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

	private static final String _FINDER_COLUMN_TAGPERIOD_COMPANYID_2 = "statViewTag.companyId = ? AND ";
	private static final String _FINDER_COLUMN_TAGPERIOD_GROUPID_2 = "statViewTag.groupId = ? AND ";
	private static final String _FINDER_COLUMN_TAGPERIOD_TAGID_2 = "statViewTag.tagId = ? AND ";
	private static final String _FINDER_COLUMN_TAGPERIOD_PERYEAR_2 = "statViewTag.perYear = ? AND ";
	private static final String _FINDER_COLUMN_TAGPERIOD_PERMONTH_2 = "statViewTag.perMonth = ?";

	public StatViewTagPersistenceImpl() {
		setModelClass(StatViewTag.class);
	}

	/**
	 * Caches the stat view tag in the entity cache if it is enabled.
	 *
	 * @param statViewTag the stat view tag
	 */
	@Override
	public void cacheResult(StatViewTag statViewTag) {
		EntityCacheUtil.putResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagImpl.class, statViewTag.getPrimaryKey(), statViewTag);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGPERIOD,
			new Object[] {
				statViewTag.getCompanyId(), statViewTag.getGroupId(),
				statViewTag.getTagId(), statViewTag.getPerYear(),
				statViewTag.getPerMonth()
			}, statViewTag);

		statViewTag.resetOriginalValues();
	}

	/**
	 * Caches the stat view tags in the entity cache if it is enabled.
	 *
	 * @param statViewTags the stat view tags
	 */
	@Override
	public void cacheResult(List<StatViewTag> statViewTags) {
		for (StatViewTag statViewTag : statViewTags) {
			if (EntityCacheUtil.getResult(
						StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
						StatViewTagImpl.class, statViewTag.getPrimaryKey()) == null) {
				cacheResult(statViewTag);
			}
			else {
				statViewTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat view tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatViewTagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatViewTagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat view tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatViewTag statViewTag) {
		EntityCacheUtil.removeResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagImpl.class, statViewTag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(statViewTag);
	}

	@Override
	public void clearCache(List<StatViewTag> statViewTags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatViewTag statViewTag : statViewTags) {
			EntityCacheUtil.removeResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
				StatViewTagImpl.class, statViewTag.getPrimaryKey());

			clearUniqueFindersCache(statViewTag);
		}
	}

	protected void cacheUniqueFindersCache(StatViewTag statViewTag) {
		if (statViewTag.isNew()) {
			Object[] args = new Object[] {
					statViewTag.getCompanyId(), statViewTag.getGroupId(),
					statViewTag.getTagId(), statViewTag.getPerYear(),
					statViewTag.getPerMonth()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAGPERIOD, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGPERIOD, args,
				statViewTag);
		}
		else {
			StatViewTagModelImpl statViewTagModelImpl = (StatViewTagModelImpl)statViewTag;

			if ((statViewTagModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TAGPERIOD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statViewTag.getCompanyId(), statViewTag.getGroupId(),
						statViewTag.getTagId(), statViewTag.getPerYear(),
						statViewTag.getPerMonth()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAGPERIOD, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAGPERIOD, args,
					statViewTag);
			}
		}
	}

	protected void clearUniqueFindersCache(StatViewTag statViewTag) {
		StatViewTagModelImpl statViewTagModelImpl = (StatViewTagModelImpl)statViewTag;

		Object[] args = new Object[] {
				statViewTag.getCompanyId(), statViewTag.getGroupId(),
				statViewTag.getTagId(), statViewTag.getPerYear(),
				statViewTag.getPerMonth()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGPERIOD, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAGPERIOD, args);

		if ((statViewTagModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TAGPERIOD.getColumnBitmask()) != 0) {
			args = new Object[] {
					statViewTagModelImpl.getOriginalCompanyId(),
					statViewTagModelImpl.getOriginalGroupId(),
					statViewTagModelImpl.getOriginalTagId(),
					statViewTagModelImpl.getOriginalPerYear(),
					statViewTagModelImpl.getOriginalPerMonth()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGPERIOD, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAGPERIOD, args);
		}
	}

	/**
	 * Creates a new stat view tag with the primary key. Does not add the stat view tag to the database.
	 *
	 * @param id the primary key for the new stat view tag
	 * @return the new stat view tag
	 */
	@Override
	public StatViewTag create(long id) {
		StatViewTag statViewTag = new StatViewTagImpl();

		statViewTag.setNew(true);
		statViewTag.setPrimaryKey(id);

		return statViewTag;
	}

	/**
	 * Removes the stat view tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat view tag
	 * @return the stat view tag that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag remove(long id)
		throws NoSuchStatViewTagException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat view tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat view tag
	 * @return the stat view tag that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag remove(Serializable primaryKey)
		throws NoSuchStatViewTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatViewTag statViewTag = (StatViewTag)session.get(StatViewTagImpl.class,
					primaryKey);

			if (statViewTag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatViewTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statViewTag);
		}
		catch (NoSuchStatViewTagException nsee) {
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
	protected StatViewTag removeImpl(StatViewTag statViewTag)
		throws SystemException {
		statViewTag = toUnwrappedModel(statViewTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statViewTag)) {
				statViewTag = (StatViewTag)session.get(StatViewTagImpl.class,
						statViewTag.getPrimaryKeyObj());
			}

			if (statViewTag != null) {
				session.delete(statViewTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statViewTag != null) {
			clearCache(statViewTag);
		}

		return statViewTag;
	}

	@Override
	public StatViewTag updateImpl(
		com.idetronic.subur.model.StatViewTag statViewTag)
		throws SystemException {
		statViewTag = toUnwrappedModel(statViewTag);

		boolean isNew = statViewTag.isNew();

		Session session = null;

		try {
			session = openSession();

			if (statViewTag.isNew()) {
				session.save(statViewTag);

				statViewTag.setNew(false);
			}
			else {
				session.merge(statViewTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatViewTagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
			StatViewTagImpl.class, statViewTag.getPrimaryKey(), statViewTag);

		clearUniqueFindersCache(statViewTag);
		cacheUniqueFindersCache(statViewTag);

		return statViewTag;
	}

	protected StatViewTag toUnwrappedModel(StatViewTag statViewTag) {
		if (statViewTag instanceof StatViewTagImpl) {
			return statViewTag;
		}

		StatViewTagImpl statViewTagImpl = new StatViewTagImpl();

		statViewTagImpl.setNew(statViewTag.isNew());
		statViewTagImpl.setPrimaryKey(statViewTag.getPrimaryKey());

		statViewTagImpl.setId(statViewTag.getId());
		statViewTagImpl.setCompanyId(statViewTag.getCompanyId());
		statViewTagImpl.setGroupId(statViewTag.getGroupId());
		statViewTagImpl.setPerMonth(statViewTag.getPerMonth());
		statViewTagImpl.setPerYear(statViewTag.getPerYear());
		statViewTagImpl.setTagId(statViewTag.getTagId());
		statViewTagImpl.setViewCount(statViewTag.getViewCount());

		return statViewTagImpl;
	}

	/**
	 * Returns the stat view tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view tag
	 * @return the stat view tag
	 * @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatViewTagException, SystemException {
		StatViewTag statViewTag = fetchByPrimaryKey(primaryKey);

		if (statViewTag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatViewTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statViewTag;
	}

	/**
	 * Returns the stat view tag with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewTagException} if it could not be found.
	 *
	 * @param id the primary key of the stat view tag
	 * @return the stat view tag
	 * @throws com.idetronic.subur.NoSuchStatViewTagException if a stat view tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag findByPrimaryKey(long id)
		throws NoSuchStatViewTagException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat view tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view tag
	 * @return the stat view tag, or <code>null</code> if a stat view tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatViewTag statViewTag = (StatViewTag)EntityCacheUtil.getResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
				StatViewTagImpl.class, primaryKey);

		if (statViewTag == _nullStatViewTag) {
			return null;
		}

		if (statViewTag == null) {
			Session session = null;

			try {
				session = openSession();

				statViewTag = (StatViewTag)session.get(StatViewTagImpl.class,
						primaryKey);

				if (statViewTag != null) {
					cacheResult(statViewTag);
				}
				else {
					EntityCacheUtil.putResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
						StatViewTagImpl.class, primaryKey, _nullStatViewTag);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatViewTagModelImpl.ENTITY_CACHE_ENABLED,
					StatViewTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statViewTag;
	}

	/**
	 * Returns the stat view tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat view tag
	 * @return the stat view tag, or <code>null</code> if a stat view tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewTag fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat view tags.
	 *
	 * @return the stat view tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewTag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat view tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat view tags
	 * @param end the upper bound of the range of stat view tags (not inclusive)
	 * @return the range of stat view tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewTag> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat view tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat view tags
	 * @param end the upper bound of the range of stat view tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat view tags
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewTag> findAll(int start, int end,
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

		List<StatViewTag> list = (List<StatViewTag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATVIEWTAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATVIEWTAG;

				if (pagination) {
					sql = sql.concat(StatViewTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatViewTag>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatViewTag>(list);
				}
				else {
					list = (List<StatViewTag>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the stat view tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatViewTag statViewTag : findAll()) {
			remove(statViewTag);
		}
	}

	/**
	 * Returns the number of stat view tags.
	 *
	 * @return the number of stat view tags
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

				Query q = session.createQuery(_SQL_COUNT_STATVIEWTAG);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the stat view tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatViewTag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatViewTag>> listenersList = new ArrayList<ModelListener<StatViewTag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatViewTag>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatViewTagImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATVIEWTAG = "SELECT statViewTag FROM StatViewTag statViewTag";
	private static final String _SQL_SELECT_STATVIEWTAG_WHERE = "SELECT statViewTag FROM StatViewTag statViewTag WHERE ";
	private static final String _SQL_COUNT_STATVIEWTAG = "SELECT COUNT(statViewTag) FROM StatViewTag statViewTag";
	private static final String _SQL_COUNT_STATVIEWTAG_WHERE = "SELECT COUNT(statViewTag) FROM StatViewTag statViewTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statViewTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatViewTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatViewTag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatViewTagPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatViewTag _nullStatViewTag = new StatViewTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatViewTag> toCacheModel() {
				return _nullStatViewTagCacheModel;
			}
		};

	private static CacheModel<StatViewTag> _nullStatViewTagCacheModel = new CacheModel<StatViewTag>() {
			@Override
			public StatViewTag toEntityModel() {
				return _nullStatViewTag;
			}
		};
}