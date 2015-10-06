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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SuburConfig. This utility wraps
 * {@link com.idetronic.subur.service.impl.SuburConfigLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see SuburConfigLocalService
 * @see com.idetronic.subur.service.base.SuburConfigLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.SuburConfigLocalServiceImpl
 * @generated
 */
public class SuburConfigLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.SuburConfigLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the subur config to the database. Also notifies the appropriate model listeners.
	*
	* @param suburConfig the subur config
	* @return the subur config that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig addSuburConfig(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSuburConfig(suburConfig);
	}

	/**
	* Creates a new subur config with the primary key. Does not add the subur config to the database.
	*
	* @param id the primary key for the new subur config
	* @return the new subur config
	*/
	public static com.idetronic.subur.model.SuburConfig createSuburConfig(
		long id) {
		return getService().createSuburConfig(id);
	}

	/**
	* Deletes the subur config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the subur config
	* @return the subur config that was removed
	* @throws PortalException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig deleteSuburConfig(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSuburConfig(id);
	}

	/**
	* Deletes the subur config from the database. Also notifies the appropriate model listeners.
	*
	* @param suburConfig the subur config
	* @return the subur config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig deleteSuburConfig(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSuburConfig(suburConfig);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.idetronic.subur.model.SuburConfig fetchSuburConfig(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSuburConfig(id);
	}

	/**
	* Returns the subur config with the primary key.
	*
	* @param id the primary key of the subur config
	* @return the subur config
	* @throws PortalException if a subur config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig getSuburConfig(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburConfig(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.idetronic.subur.model.SuburConfig> getSuburConfigs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburConfigs(start, end);
	}

	/**
	* Returns the number of subur configs.
	*
	* @return the number of subur configs
	* @throws SystemException if a system exception occurred
	*/
	public static int getSuburConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSuburConfigsCount();
	}

	/**
	* Updates the subur config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param suburConfig the subur config
	* @return the subur config that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.SuburConfig updateSuburConfig(
		com.idetronic.subur.model.SuburConfig suburConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSuburConfig(suburConfig);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.idetronic.subur.model.SuburConfig addConfig(
		java.util.Map<java.lang.String, java.lang.String> configMap,
		java.lang.String configKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConfig(configMap, configKey);
	}

	public static com.idetronic.subur.model.SuburConfig get(
		java.lang.String configKey)
		throws com.idetronic.subur.NoSuchConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().get(configKey);
	}

	public static com.idetronic.subur.model.SuburConfig updateConfig(
		java.lang.String configKey, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateConfig(configKey, value);
	}

	public static com.idetronic.subur.model.SuburConfig addConfig(
		java.lang.String configKey, java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConfig(configKey, value);
	}

	public static com.idetronic.subur.model.SuburConfig updateConfig(
		java.util.Map<java.lang.String, java.lang.String> configMap,
		java.lang.String configKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateConfig(configMap, configKey);
	}

	public static void clearService() {
		_service = null;
	}

	public static SuburConfigLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SuburConfigLocalService.class.getName());

			if (invokableLocalService instanceof SuburConfigLocalService) {
				_service = (SuburConfigLocalService)invokableLocalService;
			}
			else {
				_service = new SuburConfigLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SuburConfigLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SuburConfigLocalService service) {
	}

	private static SuburConfigLocalService _service;
}