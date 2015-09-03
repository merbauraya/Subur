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

import com.idetronic.subur.model.SuburConfig;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the subur config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburConfigPersistenceImpl
 * @see SuburConfigUtil
 * @generated
 */
public interface SuburConfigPersistence extends BasePersistence<SuburConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SuburConfigUtil} to access the subur config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the subur config where key = &#63; or throws a {@link com.idetronic.subur.NoSuchConfigException} if it could not be found.
	*
	* @param key the key
	* @return the matching subur config
	* @throws com.idetronic.subur.NoSuchConfigException if a matching subur config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig findByKey(java.lang.String key)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur config where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching subur config, or <code>null</code> if a matching subur config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig fetchByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur config where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subur config, or <code>null</code> if a matching subur config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig fetchByKey(
		java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the subur config where key = &#63; from the database.
	*
	* @param key the key
	* @return the subur config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig removeByKey(
		java.lang.String key)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subur configs where key = &#63;.
	*
	* @param key the key
	* @return the number of matching subur configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subur config in the entity cache if it is enabled.
	*
	* @param suburConfig the subur config
	*/
	public void cacheResult(com.idetronic.subur.model.SuburConfig suburConfig);

	/**
	* Caches the subur configs in the entity cache if it is enabled.
	*
	* @param suburConfigs the subur configs
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.SuburConfig> suburConfigs);

	/**
	* Creates a new subur config with the primary key. Does not add the subur config to the database.
	*
	* @param id the primary key for the new subur config
	* @return the new subur config
	*/
	public com.idetronic.subur.model.SuburConfig create(long id);

	/**
	* Removes the subur config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subur config
	* @return the subur config that was removed
	* @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig remove(long id)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.SuburConfig updateImpl(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur config with the primary key or throws a {@link com.idetronic.subur.NoSuchConfigException} if it could not be found.
	*
	* @param id the primary key of the subur config
	* @return the subur config
	* @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig findByPrimaryKey(long id)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subur config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the subur config
	* @return the subur config, or <code>null</code> if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.SuburConfig fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subur configs.
	*
	* @return the subur configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.SuburConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.SuburConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.idetronic.subur.model.SuburConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subur configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subur configs.
	*
	* @return the number of subur configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}