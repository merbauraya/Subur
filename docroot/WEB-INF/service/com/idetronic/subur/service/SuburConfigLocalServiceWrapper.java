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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SuburConfigLocalService}.
 *
 * @author Mazlan Mat
 * @see SuburConfigLocalService
 * @generated
 */
public class SuburConfigLocalServiceWrapper implements SuburConfigLocalService,
	ServiceWrapper<SuburConfigLocalService> {
	public SuburConfigLocalServiceWrapper(
		SuburConfigLocalService suburConfigLocalService) {
		_suburConfigLocalService = suburConfigLocalService;
	}

	/**
	* Adds the subur config to the database. Also notifies the appropriate model listeners.
	*
	* @param suburConfig the subur config
	* @return the subur config that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburConfig addSuburConfig(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.addSuburConfig(suburConfig);
	}

	/**
	* Creates a new subur config with the primary key. Does not add the subur config to the database.
	*
	* @param id the primary key for the new subur config
	* @return the new subur config
	*/
	@Override
	public com.idetronic.subur.model.SuburConfig createSuburConfig(long id) {
		return _suburConfigLocalService.createSuburConfig(id);
	}

	/**
	* Deletes the subur config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subur config
	* @return the subur config that was removed
	* @throws PortalException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburConfig deleteSuburConfig(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.deleteSuburConfig(id);
	}

	/**
	* Deletes the subur config from the database. Also notifies the appropriate model listeners.
	*
	* @param suburConfig the subur config
	* @return the subur config that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburConfig deleteSuburConfig(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.deleteSuburConfig(suburConfig);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _suburConfigLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.SuburConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.SuburConfig fetchSuburConfig(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.fetchSuburConfig(id);
	}

	/**
	* Returns the subur config with the primary key.
	*
	* @param id the primary key of the subur config
	* @return the subur config
	* @throws PortalException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburConfig getSuburConfig(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.getSuburConfig(id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.idetronic.subur.model.SuburConfig> getSuburConfigs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.getSuburConfigs(start, end);
	}

	/**
	* Returns the number of subur configs.
	*
	* @return the number of subur configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSuburConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.getSuburConfigsCount();
	}

	/**
	* Updates the subur config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param suburConfig the subur config
	* @return the subur config that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.SuburConfig updateSuburConfig(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.updateSuburConfig(suburConfig);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _suburConfigLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_suburConfigLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _suburConfigLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.idetronic.subur.model.SuburConfig addConfig(
		java.util.Map<java.lang.String, java.lang.String> configMap,
		java.lang.String configKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.addConfig(configMap, configKey);
	}

	@Override
	public com.idetronic.subur.model.SuburConfig get(java.lang.String configKey)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.get(configKey);
	}

	@Override
	public com.idetronic.subur.model.SuburConfig updateConfig(
		java.lang.String configKey, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.updateConfig(configKey, value);
	}

	@Override
	public com.idetronic.subur.model.SuburConfig addConfig(
		java.lang.String configKey, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.addConfig(configKey, value);
	}

	@Override
	public com.idetronic.subur.model.SuburConfig updateConfig(
		java.util.Map<java.lang.String, java.lang.String> configMap,
		java.lang.String configKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _suburConfigLocalService.updateConfig(configMap, configKey);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SuburConfigLocalService getWrappedSuburConfigLocalService() {
		return _suburConfigLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSuburConfigLocalService(
		SuburConfigLocalService suburConfigLocalService) {
		_suburConfigLocalService = suburConfigLocalService;
	}

	@Override
	public SuburConfigLocalService getWrappedService() {
		return _suburConfigLocalService;
	}

	@Override
	public void setWrappedService(
		SuburConfigLocalService suburConfigLocalService) {
		_suburConfigLocalService = suburConfigLocalService;
	}

	private SuburConfigLocalService _suburConfigLocalService;
}