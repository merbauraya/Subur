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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the subur config service. This utility wraps {@link SuburConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see SuburConfigPersistence
 * @see SuburConfigPersistenceImpl
 * @generated
 */
public class SuburConfigUtil {
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
	public static void clearCache(SuburConfig suburConfig) {
		getPersistence().clearCache(suburConfig);
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
	public static List<SuburConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SuburConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SuburConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SuburConfig update(SuburConfig suburConfig)
		throws SystemException {
		return getPersistence().update(suburConfig);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SuburConfig update(SuburConfig suburConfig,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(suburConfig, serviceContext);
	}

	/**
	* Returns the subur config where key = &#63; or throws a {@link com.idetronic.subur.NoSuchConfigException} if it could not be found.
	*
	* @param key the key
	* @return the matching subur config
	* @throws com.idetronic.subur.NoSuchConfigException if a matching subur config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig findByKey(
		java.lang.String key)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKey(key);
	}

	/**
	* Returns the subur config where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching subur config, or <code>null</code> if a matching subur config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig fetchByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey(key);
	}

	/**
	* Returns the subur config where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subur config, or <code>null</code> if a matching subur config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig fetchByKey(
		java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey(key, retrieveFromCache);
	}

	/**
	* Removes the subur config where key = &#63; from the database.
	*
	* @param key the key
	* @return the subur config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig removeByKey(
		java.lang.String key)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByKey(key);
	}

	/**
	* Returns the number of subur configs where key = &#63;.
	*
	* @param key the key
	* @return the number of matching subur configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKey(key);
	}

	/**
	* Caches the subur config in the entity cache if it is enabled.
	*
	* @param suburConfig the subur config
	*/
	public static void cacheResult(
		com.idetronic.subur.model.SuburConfig suburConfig) {
		getPersistence().cacheResult(suburConfig);
	}

	/**
	* Caches the subur configs in the entity cache if it is enabled.
	*
	* @param suburConfigs the subur configs
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.SuburConfig> suburConfigs) {
		getPersistence().cacheResult(suburConfigs);
	}

	/**
	* Creates a new subur config with the primary key. Does not add the subur config to the database.
	*
	* @param id the primary key for the new subur config
	* @return the new subur config
	*/
	public static com.idetronic.subur.model.SuburConfig create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the subur config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subur config
	* @return the subur config that was removed
	* @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig remove(long id)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.idetronic.subur.model.SuburConfig updateImpl(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(suburConfig);
	}

	/**
	* Returns the subur config with the primary key or throws a {@link com.idetronic.subur.NoSuchConfigException} if it could not be found.
	*
	* @param id the primary key of the subur config
	* @return the subur config
	* @throws com.idetronic.subur.NoSuchConfigException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig findByPrimaryKey(
		long id)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the subur config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the subur config
	* @return the subur config, or <code>null</code> if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the subur configs.
	*
	* @return the subur configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.SuburConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.idetronic.subur.model.SuburConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.idetronic.subur.model.SuburConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subur configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subur configs.
	*
	* @return the number of subur configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SuburConfigPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SuburConfigPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					SuburConfigPersistence.class.getName());

			ReferenceRegistry.registerReference(SuburConfigUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SuburConfigPersistence persistence) {
	}

	private static SuburConfigPersistence _persistence;
}