/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.idetronic.subur.model.MetadataValueView;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the metadata value view service. This utility wraps {@link MetadataValueViewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see MetadataValueViewPersistence
 * @see MetadataValueViewPersistenceImpl
 * @generated
 */
public class MetadataValueViewUtil {
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
	public static void clearCache(MetadataValueView metadataValueView) {
		getPersistence().clearCache(metadataValueView);
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
	public static List<MetadataValueView> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MetadataValueView> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MetadataValueView> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MetadataValueView update(MetadataValueView metadataValueView)
		throws SystemException {
		return getPersistence().update(metadataValueView);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MetadataValueView update(
		MetadataValueView metadataValueView, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(metadataValueView, serviceContext);
	}

	/**
	* Caches the metadata value view in the entity cache if it is enabled.
	*
	* @param metadataValueView the metadata value view
	*/
	public static void cacheResult(
		com.idetronic.subur.model.MetadataValueView metadataValueView) {
		getPersistence().cacheResult(metadataValueView);
	}

	/**
	* Caches the metadata value views in the entity cache if it is enabled.
	*
	* @param metadataValueViews the metadata value views
	*/
	public static void cacheResult(
		java.util.List<com.idetronic.subur.model.MetadataValueView> metadataValueViews) {
		getPersistence().cacheResult(metadataValueViews);
	}

	/**
	* Creates a new metadata value view with the primary key. Does not add the metadata value view to the database.
	*
	* @param metadataValueViewPK the primary key for the new metadata value view
	* @return the new metadata value view
	*/
	public static com.idetronic.subur.model.MetadataValueView create(
		com.idetronic.subur.service.persistence.MetadataValueViewPK metadataValueViewPK) {
		return getPersistence().create(metadataValueViewPK);
	}

	/**
	* Removes the metadata value view with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param metadataValueViewPK the primary key of the metadata value view
	* @return the metadata value view that was removed
	* @throws com.idetronic.subur.NoSuchMetadataValueViewException if a metadata value view with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataValueView remove(
		com.idetronic.subur.service.persistence.MetadataValueViewPK metadataValueViewPK)
		throws com.idetronic.subur.NoSuchMetadataValueViewException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(metadataValueViewPK);
	}

	public static com.idetronic.subur.model.MetadataValueView updateImpl(
		com.idetronic.subur.model.MetadataValueView metadataValueView)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(metadataValueView);
	}

	/**
	* Returns the metadata value view with the primary key or throws a {@link com.idetronic.subur.NoSuchMetadataValueViewException} if it could not be found.
	*
	* @param metadataValueViewPK the primary key of the metadata value view
	* @return the metadata value view
	* @throws com.idetronic.subur.NoSuchMetadataValueViewException if a metadata value view with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataValueView findByPrimaryKey(
		com.idetronic.subur.service.persistence.MetadataValueViewPK metadataValueViewPK)
		throws com.idetronic.subur.NoSuchMetadataValueViewException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(metadataValueViewPK);
	}

	/**
	* Returns the metadata value view with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param metadataValueViewPK the primary key of the metadata value view
	* @return the metadata value view, or <code>null</code> if a metadata value view with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.MetadataValueView fetchByPrimaryKey(
		com.idetronic.subur.service.persistence.MetadataValueViewPK metadataValueViewPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(metadataValueViewPK);
	}

	/**
	* Returns all the metadata value views.
	*
	* @return the metadata value views
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataValueView> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the metadata value views.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata value views
	* @param end the upper bound of the range of metadata value views (not inclusive)
	* @return the range of metadata value views
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataValueView> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the metadata value views.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.MetadataValueViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of metadata value views
	* @param end the upper bound of the range of metadata value views (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of metadata value views
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.MetadataValueView> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the metadata value views from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of metadata value views.
	*
	* @return the number of metadata value views
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MetadataValueViewPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MetadataValueViewPersistence)PortletBeanLocatorUtil.locate(com.idetronic.subur.service.ClpSerializer.getServletContextName(),
					MetadataValueViewPersistence.class.getName());

			ReferenceRegistry.registerReference(MetadataValueViewUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MetadataValueViewPersistence persistence) {
	}

	private static MetadataValueViewPersistence _persistence;
}