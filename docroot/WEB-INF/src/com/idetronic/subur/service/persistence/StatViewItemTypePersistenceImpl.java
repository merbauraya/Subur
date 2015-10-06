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

import com.idetronic.subur.NoSuchStatViewItemTypeException;
import com.idetronic.subur.model.StatViewItemType;
import com.idetronic.subur.model.impl.StatViewItemTypeImpl;
import com.idetronic.subur.model.impl.StatViewItemTypeModelImpl;

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
 * The persistence implementation for the stat view item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see StatViewItemTypePersistence
 * @see StatViewItemTypeUtil
 * @generated
 */
public class StatViewItemTypePersistenceImpl extends BasePersistenceImpl<StatViewItemType>
	implements StatViewItemTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatViewItemTypeUtil} to access the stat view item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatViewItemTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatViewItemTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatViewItemTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP = new FinderPath(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeModelImpl.FINDER_CACHE_ENABLED,
			StatViewItemTypeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByItemTypePeriodGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			StatViewItemTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			StatViewItemTypeModelImpl.GROUPID_COLUMN_BITMASK |
			StatViewItemTypeModelImpl.ITEMTYPEID_COLUMN_BITMASK |
			StatViewItemTypeModelImpl.PERYEAR_COLUMN_BITMASK |
			StatViewItemTypeModelImpl.PERMONTH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEMTYPEPERIODGROUP = new FinderPath(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByItemTypePeriodGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; or throws a {@link com.idetronic.subur.NoSuchStatViewItemTypeException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param itemTypeId the item type ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the matching stat view item type
	 * @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a matching stat view item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType findByItemTypePeriodGroup(long companyId,
		long groupId, long itemTypeId, int perYear, int perMonth)
		throws NoSuchStatViewItemTypeException, SystemException {
		StatViewItemType statViewItemType = fetchByItemTypePeriodGroup(companyId,
				groupId, itemTypeId, perYear, perMonth);

		if (statViewItemType == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", itemTypeId=");
			msg.append(itemTypeId);

			msg.append(", perYear=");
			msg.append(perYear);

			msg.append(", perMonth=");
			msg.append(perMonth);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStatViewItemTypeException(msg.toString());
		}

		return statViewItemType;
	}

	/**
	 * Returns the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param itemTypeId the item type ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the matching stat view item type, or <code>null</code> if a matching stat view item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType fetchByItemTypePeriodGroup(long companyId,
		long groupId, long itemTypeId, int perYear, int perMonth)
		throws SystemException {
		return fetchByItemTypePeriodGroup(companyId, groupId, itemTypeId,
			perYear, perMonth, true);
	}

	/**
	 * Returns the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param itemTypeId the item type ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching stat view item type, or <code>null</code> if a matching stat view item type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType fetchByItemTypePeriodGroup(long companyId,
		long groupId, long itemTypeId, int perYear, int perMonth,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, itemTypeId, perYear, perMonth
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
					finderArgs, this);
		}

		if (result instanceof StatViewItemType) {
			StatViewItemType statViewItemType = (StatViewItemType)result;

			if ((companyId != statViewItemType.getCompanyId()) ||
					(groupId != statViewItemType.getGroupId()) ||
					(itemTypeId != statViewItemType.getItemTypeId()) ||
					(perYear != statViewItemType.getPerYear()) ||
					(perMonth != statViewItemType.getPerMonth())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_STATVIEWITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_ITEMTYPEID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_PERYEAR_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_PERMONTH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(itemTypeId);

				qPos.add(perYear);

				qPos.add(perMonth);

				List<StatViewItemType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
						finderArgs, list);
				}
				else {
					StatViewItemType statViewItemType = list.get(0);

					result = statViewItemType;

					cacheResult(statViewItemType);

					if ((statViewItemType.getCompanyId() != companyId) ||
							(statViewItemType.getGroupId() != groupId) ||
							(statViewItemType.getItemTypeId() != itemTypeId) ||
							(statViewItemType.getPerYear() != perYear) ||
							(statViewItemType.getPerMonth() != perMonth)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
							finderArgs, statViewItemType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
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
			return (StatViewItemType)result;
		}
	}

	/**
	 * Removes the stat view item type where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param itemTypeId the item type ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the stat view item type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType removeByItemTypePeriodGroup(long companyId,
		long groupId, long itemTypeId, int perYear, int perMonth)
		throws NoSuchStatViewItemTypeException, SystemException {
		StatViewItemType statViewItemType = findByItemTypePeriodGroup(companyId,
				groupId, itemTypeId, perYear, perMonth);

		return remove(statViewItemType);
	}

	/**
	 * Returns the number of stat view item types where companyId = &#63; and groupId = &#63; and itemTypeId = &#63; and perYear = &#63; and perMonth = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param itemTypeId the item type ID
	 * @param perYear the per year
	 * @param perMonth the per month
	 * @return the number of matching stat view item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByItemTypePeriodGroup(long companyId, long groupId,
		long itemTypeId, int perYear, int perMonth) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMTYPEPERIODGROUP;

		Object[] finderArgs = new Object[] {
				companyId, groupId, itemTypeId, perYear, perMonth
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_STATVIEWITEMTYPE_WHERE);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_ITEMTYPEID_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_PERYEAR_2);

			query.append(_FINDER_COLUMN_ITEMTYPEPERIODGROUP_PERMONTH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(itemTypeId);

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

	private static final String _FINDER_COLUMN_ITEMTYPEPERIODGROUP_COMPANYID_2 = "statViewItemType.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPERIODGROUP_GROUPID_2 = "statViewItemType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPERIODGROUP_ITEMTYPEID_2 = "statViewItemType.itemTypeId = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPERIODGROUP_PERYEAR_2 = "statViewItemType.perYear = ? AND ";
	private static final String _FINDER_COLUMN_ITEMTYPEPERIODGROUP_PERMONTH_2 = "statViewItemType.perMonth = ?";

	public StatViewItemTypePersistenceImpl() {
		setModelClass(StatViewItemType.class);
	}

	/**
	 * Caches the stat view item type in the entity cache if it is enabled.
	 *
	 * @param statViewItemType the stat view item type
	 */
	@Override
	public void cacheResult(StatViewItemType statViewItemType) {
		EntityCacheUtil.putResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeImpl.class, statViewItemType.getPrimaryKey(),
			statViewItemType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
			new Object[] {
				statViewItemType.getCompanyId(), statViewItemType.getGroupId(),
				statViewItemType.getItemTypeId(), statViewItemType.getPerYear(),
				statViewItemType.getPerMonth()
			}, statViewItemType);

		statViewItemType.resetOriginalValues();
	}

	/**
	 * Caches the stat view item types in the entity cache if it is enabled.
	 *
	 * @param statViewItemTypes the stat view item types
	 */
	@Override
	public void cacheResult(List<StatViewItemType> statViewItemTypes) {
		for (StatViewItemType statViewItemType : statViewItemTypes) {
			if (EntityCacheUtil.getResult(
						StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						StatViewItemTypeImpl.class,
						statViewItemType.getPrimaryKey()) == null) {
				cacheResult(statViewItemType);
			}
			else {
				statViewItemType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stat view item types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatViewItemTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatViewItemTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stat view item type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StatViewItemType statViewItemType) {
		EntityCacheUtil.removeResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeImpl.class, statViewItemType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(statViewItemType);
	}

	@Override
	public void clearCache(List<StatViewItemType> statViewItemTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StatViewItemType statViewItemType : statViewItemTypes) {
			EntityCacheUtil.removeResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				StatViewItemTypeImpl.class, statViewItemType.getPrimaryKey());

			clearUniqueFindersCache(statViewItemType);
		}
	}

	protected void cacheUniqueFindersCache(StatViewItemType statViewItemType) {
		if (statViewItemType.isNew()) {
			Object[] args = new Object[] {
					statViewItemType.getCompanyId(),
					statViewItemType.getGroupId(),
					statViewItemType.getItemTypeId(),
					statViewItemType.getPerYear(),
					statViewItemType.getPerMonth()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMTYPEPERIODGROUP,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
				args, statViewItemType);
		}
		else {
			StatViewItemTypeModelImpl statViewItemTypeModelImpl = (StatViewItemTypeModelImpl)statViewItemType;

			if ((statViewItemTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						statViewItemType.getCompanyId(),
						statViewItemType.getGroupId(),
						statViewItemType.getItemTypeId(),
						statViewItemType.getPerYear(),
						statViewItemType.getPerMonth()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMTYPEPERIODGROUP,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
					args, statViewItemType);
			}
		}
	}

	protected void clearUniqueFindersCache(StatViewItemType statViewItemType) {
		StatViewItemTypeModelImpl statViewItemTypeModelImpl = (StatViewItemTypeModelImpl)statViewItemType;

		Object[] args = new Object[] {
				statViewItemType.getCompanyId(), statViewItemType.getGroupId(),
				statViewItemType.getItemTypeId(), statViewItemType.getPerYear(),
				statViewItemType.getPerMonth()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPEPERIODGROUP,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
			args);

		if ((statViewItemTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP.getColumnBitmask()) != 0) {
			args = new Object[] {
					statViewItemTypeModelImpl.getOriginalCompanyId(),
					statViewItemTypeModelImpl.getOriginalGroupId(),
					statViewItemTypeModelImpl.getOriginalItemTypeId(),
					statViewItemTypeModelImpl.getOriginalPerYear(),
					statViewItemTypeModelImpl.getOriginalPerMonth()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMTYPEPERIODGROUP,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMTYPEPERIODGROUP,
				args);
		}
	}

	/**
	 * Creates a new stat view item type with the primary key. Does not add the stat view item type to the database.
	 *
	 * @param id the primary key for the new stat view item type
	 * @return the new stat view item type
	 */
	@Override
	public StatViewItemType create(long id) {
		StatViewItemType statViewItemType = new StatViewItemTypeImpl();

		statViewItemType.setNew(true);
		statViewItemType.setPrimaryKey(id);

		return statViewItemType;
	}

	/**
	 * Removes the stat view item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stat view item type
	 * @return the stat view item type that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType remove(long id)
		throws NoSuchStatViewItemTypeException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stat view item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stat view item type
	 * @return the stat view item type that was removed
	 * @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType remove(Serializable primaryKey)
		throws NoSuchStatViewItemTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StatViewItemType statViewItemType = (StatViewItemType)session.get(StatViewItemTypeImpl.class,
					primaryKey);

			if (statViewItemType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatViewItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statViewItemType);
		}
		catch (NoSuchStatViewItemTypeException nsee) {
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
	protected StatViewItemType removeImpl(StatViewItemType statViewItemType)
		throws SystemException {
		statViewItemType = toUnwrappedModel(statViewItemType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(statViewItemType)) {
				statViewItemType = (StatViewItemType)session.get(StatViewItemTypeImpl.class,
						statViewItemType.getPrimaryKeyObj());
			}

			if (statViewItemType != null) {
				session.delete(statViewItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (statViewItemType != null) {
			clearCache(statViewItemType);
		}

		return statViewItemType;
	}

	@Override
	public StatViewItemType updateImpl(
		com.idetronic.subur.model.StatViewItemType statViewItemType)
		throws SystemException {
		statViewItemType = toUnwrappedModel(statViewItemType);

		boolean isNew = statViewItemType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (statViewItemType.isNew()) {
				session.save(statViewItemType);

				statViewItemType.setNew(false);
			}
			else {
				session.merge(statViewItemType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StatViewItemTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
			StatViewItemTypeImpl.class, statViewItemType.getPrimaryKey(),
			statViewItemType);

		clearUniqueFindersCache(statViewItemType);
		cacheUniqueFindersCache(statViewItemType);

		return statViewItemType;
	}

	protected StatViewItemType toUnwrappedModel(
		StatViewItemType statViewItemType) {
		if (statViewItemType instanceof StatViewItemTypeImpl) {
			return statViewItemType;
		}

		StatViewItemTypeImpl statViewItemTypeImpl = new StatViewItemTypeImpl();

		statViewItemTypeImpl.setNew(statViewItemType.isNew());
		statViewItemTypeImpl.setPrimaryKey(statViewItemType.getPrimaryKey());

		statViewItemTypeImpl.setId(statViewItemType.getId());
		statViewItemTypeImpl.setCompanyId(statViewItemType.getCompanyId());
		statViewItemTypeImpl.setGroupId(statViewItemType.getGroupId());
		statViewItemTypeImpl.setPerYear(statViewItemType.getPerYear());
		statViewItemTypeImpl.setPerMonth(statViewItemType.getPerMonth());
		statViewItemTypeImpl.setItemTypeId(statViewItemType.getItemTypeId());
		statViewItemTypeImpl.setViewCount(statViewItemType.getViewCount());

		return statViewItemTypeImpl;
	}

	/**
	 * Returns the stat view item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view item type
	 * @return the stat view item type
	 * @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatViewItemTypeException, SystemException {
		StatViewItemType statViewItemType = fetchByPrimaryKey(primaryKey);

		if (statViewItemType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatViewItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return statViewItemType;
	}

	/**
	 * Returns the stat view item type with the primary key or throws a {@link com.idetronic.subur.NoSuchStatViewItemTypeException} if it could not be found.
	 *
	 * @param id the primary key of the stat view item type
	 * @return the stat view item type
	 * @throws com.idetronic.subur.NoSuchStatViewItemTypeException if a stat view item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType findByPrimaryKey(long id)
		throws NoSuchStatViewItemTypeException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stat view item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stat view item type
	 * @return the stat view item type, or <code>null</code> if a stat view item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StatViewItemType statViewItemType = (StatViewItemType)EntityCacheUtil.getResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
				StatViewItemTypeImpl.class, primaryKey);

		if (statViewItemType == _nullStatViewItemType) {
			return null;
		}

		if (statViewItemType == null) {
			Session session = null;

			try {
				session = openSession();

				statViewItemType = (StatViewItemType)session.get(StatViewItemTypeImpl.class,
						primaryKey);

				if (statViewItemType != null) {
					cacheResult(statViewItemType);
				}
				else {
					EntityCacheUtil.putResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
						StatViewItemTypeImpl.class, primaryKey,
						_nullStatViewItemType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StatViewItemTypeModelImpl.ENTITY_CACHE_ENABLED,
					StatViewItemTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return statViewItemType;
	}

	/**
	 * Returns the stat view item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stat view item type
	 * @return the stat view item type, or <code>null</code> if a stat view item type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StatViewItemType fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the stat view item types.
	 *
	 * @return the stat view item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewItemType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stat view item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat view item types
	 * @param end the upper bound of the range of stat view item types (not inclusive)
	 * @return the range of stat view item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewItemType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stat view item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.StatViewItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stat view item types
	 * @param end the upper bound of the range of stat view item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stat view item types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StatViewItemType> findAll(int start, int end,
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

		List<StatViewItemType> list = (List<StatViewItemType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATVIEWITEMTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATVIEWITEMTYPE;

				if (pagination) {
					sql = sql.concat(StatViewItemTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StatViewItemType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StatViewItemType>(list);
				}
				else {
					list = (List<StatViewItemType>)QueryUtil.list(q,
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
	 * Removes all the stat view item types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StatViewItemType statViewItemType : findAll()) {
			remove(statViewItemType);
		}
	}

	/**
	 * Returns the number of stat view item types.
	 *
	 * @return the number of stat view item types
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

				Query q = session.createQuery(_SQL_COUNT_STATVIEWITEMTYPE);

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
	 * Initializes the stat view item type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.StatViewItemType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StatViewItemType>> listenersList = new ArrayList<ModelListener<StatViewItemType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StatViewItemType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StatViewItemTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STATVIEWITEMTYPE = "SELECT statViewItemType FROM StatViewItemType statViewItemType";
	private static final String _SQL_SELECT_STATVIEWITEMTYPE_WHERE = "SELECT statViewItemType FROM StatViewItemType statViewItemType WHERE ";
	private static final String _SQL_COUNT_STATVIEWITEMTYPE = "SELECT COUNT(statViewItemType) FROM StatViewItemType statViewItemType";
	private static final String _SQL_COUNT_STATVIEWITEMTYPE_WHERE = "SELECT COUNT(statViewItemType) FROM StatViewItemType statViewItemType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statViewItemType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StatViewItemType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StatViewItemType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatViewItemTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static StatViewItemType _nullStatViewItemType = new StatViewItemTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StatViewItemType> toCacheModel() {
				return _nullStatViewItemTypeCacheModel;
			}
		};

	private static CacheModel<StatViewItemType> _nullStatViewItemTypeCacheModel = new CacheModel<StatViewItemType>() {
			@Override
			public StatViewItemType toEntityModel() {
				return _nullStatViewItemType;
			}
		};
}