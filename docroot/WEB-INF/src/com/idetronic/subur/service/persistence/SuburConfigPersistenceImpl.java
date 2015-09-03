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

import com.idetronic.subur.NoSuchConfigException;
import com.idetronic.subur.model.SuburConfig;
import com.idetronic.subur.model.impl.SuburConfigImpl;
import com.idetronic.subur.model.impl.SuburConfigModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the subur config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburConfigPersistence
 * @see SuburConfigUtil
 * @generated
 */
public class SuburConfigPersistenceImpl extends BasePersistenceImpl<SuburConfig>
	implements SuburConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SuburConfigUtil} to access the subur config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SuburConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigModelImpl.FINDER_CACHE_ENABLED, SuburConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigModelImpl.FINDER_CACHE_ENABLED, SuburConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigModelImpl.FINDER_CACHE_ENABLED, SuburConfigImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] { String.class.getName() },
			SuburConfigModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the subur config where key = &#63; or throws a {@link com.idetronic.subur.NoSuchConfigException} if it could not be found.
	 *
	 * @param key the key
	 * @return the matching subur config
	 * @throws com.idetronic.subur.NoSuchConfigException if a matching subur config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig findByKey(String key)
		throws NoSuchConfigException, SystemException {
		SuburConfig suburConfig = fetchByKey(key);

		if (suburConfig == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConfigException(msg.toString());
		}

		return suburConfig;
	}

	/**
	 * Returns the subur config where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching subur config, or <code>null</code> if a matching subur config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig fetchByKey(String key) throws SystemException {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the subur config where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching subur config, or <code>null</code> if a matching subur config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig fetchByKey(String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
					finderArgs, this);
		}

		if (result instanceof SuburConfig) {
			SuburConfig suburConfig = (SuburConfig)result;

			if (!Validator.equals(key, suburConfig.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SUBURCONFIG_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<SuburConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
						finderArgs, list);
				}
				else {
					SuburConfig suburConfig = list.get(0);

					result = suburConfig;

					cacheResult(suburConfig);

					if ((suburConfig.getKey() == null) ||
							!suburConfig.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
							finderArgs, suburConfig);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
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
			return (SuburConfig)result;
		}
	}

	/**
	 * Removes the subur config where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the subur config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig removeByKey(String key)
		throws NoSuchConfigException, SystemException {
		SuburConfig suburConfig = findByKey(key);

		return remove(suburConfig);
	}

	/**
	 * Returns the number of subur configs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching subur configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKey(String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEY;

		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBURCONFIG_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_KEY_KEY_1 = "suburConfig.key IS NULL";
	private static final String _FINDER_COLUMN_KEY_KEY_2 = "suburConfig.key = ?";
	private static final String _FINDER_COLUMN_KEY_KEY_3 = "(suburConfig.key IS NULL OR suburConfig.key = '')";

	public SuburConfigPersistenceImpl() {
		setModelClass(SuburConfig.class);
	}

	/**
	 * Caches the subur config in the entity cache if it is enabled.
	 *
	 * @param suburConfig the subur config
	 */
	@Override
	public void cacheResult(SuburConfig suburConfig) {
		EntityCacheUtil.putResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigImpl.class, suburConfig.getPrimaryKey(), suburConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
			new Object[] { suburConfig.getKey() }, suburConfig);

		suburConfig.resetOriginalValues();
	}

	/**
	 * Caches the subur configs in the entity cache if it is enabled.
	 *
	 * @param suburConfigs the subur configs
	 */
	@Override
	public void cacheResult(List<SuburConfig> suburConfigs) {
		for (SuburConfig suburConfig : suburConfigs) {
			if (EntityCacheUtil.getResult(
						SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
						SuburConfigImpl.class, suburConfig.getPrimaryKey()) == null) {
				cacheResult(suburConfig);
			}
			else {
				suburConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subur configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SuburConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SuburConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subur config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SuburConfig suburConfig) {
		EntityCacheUtil.removeResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigImpl.class, suburConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(suburConfig);
	}

	@Override
	public void clearCache(List<SuburConfig> suburConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SuburConfig suburConfig : suburConfigs) {
			EntityCacheUtil.removeResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
				SuburConfigImpl.class, suburConfig.getPrimaryKey());

			clearUniqueFindersCache(suburConfig);
		}
	}

	protected void cacheUniqueFindersCache(SuburConfig suburConfig) {
		if (suburConfig.isNew()) {
			Object[] args = new Object[] { suburConfig.getKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
				suburConfig);
		}
		else {
			SuburConfigModelImpl suburConfigModelImpl = (SuburConfigModelImpl)suburConfig;

			if ((suburConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { suburConfig.getKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
					suburConfig);
			}
		}
	}

	protected void clearUniqueFindersCache(SuburConfig suburConfig) {
		SuburConfigModelImpl suburConfigModelImpl = (SuburConfigModelImpl)suburConfig;

		Object[] args = new Object[] { suburConfig.getKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

		if ((suburConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
			args = new Object[] { suburConfigModelImpl.getOriginalKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);
		}
	}

	/**
	 * Creates a new subur config with the primary key. Does not add the subur config to the database.
	 *
	 * @param id the primary key for the new subur config
	 * @return the new subur config
	 */
	@Override
	public SuburConfig create(long id) {
		SuburConfig suburConfig = new SuburConfigImpl();

		suburConfig.setNew(true);
		suburConfig.setPrimaryKey(id);

		return suburConfig;
	}

	/**
	 * Removes the subur config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the subur config
	 * @return the subur config that was removed
	 * @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig remove(long id)
		throws NoSuchConfigException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the subur config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subur config
	 * @return the subur config that was removed
	 * @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig remove(Serializable primaryKey)
		throws NoSuchConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SuburConfig suburConfig = (SuburConfig)session.get(SuburConfigImpl.class,
					primaryKey);

			if (suburConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(suburConfig);
		}
		catch (NoSuchConfigException nsee) {
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
	protected SuburConfig removeImpl(SuburConfig suburConfig)
		throws SystemException {
		suburConfig = toUnwrappedModel(suburConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(suburConfig)) {
				suburConfig = (SuburConfig)session.get(SuburConfigImpl.class,
						suburConfig.getPrimaryKeyObj());
			}

			if (suburConfig != null) {
				session.delete(suburConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (suburConfig != null) {
			clearCache(suburConfig);
		}

		return suburConfig;
	}

	@Override
	public SuburConfig updateImpl(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws SystemException {
		suburConfig = toUnwrappedModel(suburConfig);

		boolean isNew = suburConfig.isNew();

		Session session = null;

		try {
			session = openSession();

			if (suburConfig.isNew()) {
				session.save(suburConfig);

				suburConfig.setNew(false);
			}
			else {
				session.merge(suburConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SuburConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
			SuburConfigImpl.class, suburConfig.getPrimaryKey(), suburConfig);

		clearUniqueFindersCache(suburConfig);
		cacheUniqueFindersCache(suburConfig);

		return suburConfig;
	}

	protected SuburConfig toUnwrappedModel(SuburConfig suburConfig) {
		if (suburConfig instanceof SuburConfigImpl) {
			return suburConfig;
		}

		SuburConfigImpl suburConfigImpl = new SuburConfigImpl();

		suburConfigImpl.setNew(suburConfig.isNew());
		suburConfigImpl.setPrimaryKey(suburConfig.getPrimaryKey());

		suburConfigImpl.setId(suburConfig.getId());
		suburConfigImpl.setKey(suburConfig.getKey());
		suburConfigImpl.setDescription(suburConfig.getDescription());
		suburConfigImpl.setConfig(suburConfig.getConfig());

		return suburConfigImpl;
	}

	/**
	 * Returns the subur config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subur config
	 * @return the subur config
	 * @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConfigException, SystemException {
		SuburConfig suburConfig = fetchByPrimaryKey(primaryKey);

		if (suburConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return suburConfig;
	}

	/**
	 * Returns the subur config with the primary key or throws a {@link com.idetronic.subur.NoSuchConfigException} if it could not be found.
	 *
	 * @param id the primary key of the subur config
	 * @return the subur config
	 * @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig findByPrimaryKey(long id)
		throws NoSuchConfigException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the subur config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subur config
	 * @return the subur config, or <code>null</code> if a subur config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SuburConfig suburConfig = (SuburConfig)EntityCacheUtil.getResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
				SuburConfigImpl.class, primaryKey);

		if (suburConfig == _nullSuburConfig) {
			return null;
		}

		if (suburConfig == null) {
			Session session = null;

			try {
				session = openSession();

				suburConfig = (SuburConfig)session.get(SuburConfigImpl.class,
						primaryKey);

				if (suburConfig != null) {
					cacheResult(suburConfig);
				}
				else {
					EntityCacheUtil.putResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
						SuburConfigImpl.class, primaryKey, _nullSuburConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SuburConfigModelImpl.ENTITY_CACHE_ENABLED,
					SuburConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return suburConfig;
	}

	/**
	 * Returns the subur config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the subur config
	 * @return the subur config, or <code>null</code> if a subur config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SuburConfig fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the subur configs.
	 *
	 * @return the subur configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subur configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subur configs
	 * @param end the upper bound of the range of subur configs (not inclusive)
	 * @return the range of subur configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subur configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subur configs
	 * @param end the upper bound of the range of subur configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subur configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SuburConfig> findAll(int start, int end,
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

		List<SuburConfig> list = (List<SuburConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBURCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBURCONFIG;

				if (pagination) {
					sql = sql.concat(SuburConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SuburConfig>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SuburConfig>(list);
				}
				else {
					list = (List<SuburConfig>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subur configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SuburConfig suburConfig : findAll()) {
			remove(suburConfig);
		}
	}

	/**
	 * Returns the number of subur configs.
	 *
	 * @return the number of subur configs
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

				Query q = session.createQuery(_SQL_COUNT_SUBURCONFIG);

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
	 * Initializes the subur config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.idetronic.subur.model.SuburConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SuburConfig>> listenersList = new ArrayList<ModelListener<SuburConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SuburConfig>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SuburConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBURCONFIG = "SELECT suburConfig FROM SuburConfig suburConfig";
	private static final String _SQL_SELECT_SUBURCONFIG_WHERE = "SELECT suburConfig FROM SuburConfig suburConfig WHERE ";
	private static final String _SQL_COUNT_SUBURCONFIG = "SELECT COUNT(suburConfig) FROM SuburConfig suburConfig";
	private static final String _SQL_COUNT_SUBURCONFIG_WHERE = "SELECT COUNT(suburConfig) FROM SuburConfig suburConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "suburConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SuburConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SuburConfig exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SuburConfigPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "key"
			});
	private static SuburConfig _nullSuburConfig = new SuburConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SuburConfig> toCacheModel() {
				return _nullSuburConfigCacheModel;
			}
		};

	private static CacheModel<SuburConfig> _nullSuburConfigCacheModel = new CacheModel<SuburConfig>() {
			@Override
			public SuburConfig toEntityModel() {
				return _nullSuburConfig;
			}
		};
}