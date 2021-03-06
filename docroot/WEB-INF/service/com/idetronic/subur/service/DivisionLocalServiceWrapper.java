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

package com.idetronic.subur.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DivisionLocalService}.
 *
 * @author Mazlan Mat
 * @see DivisionLocalService
 * @generated
 */
public class DivisionLocalServiceWrapper implements DivisionLocalService,
	ServiceWrapper<DivisionLocalService> {
	public DivisionLocalServiceWrapper(
		DivisionLocalService divisionLocalService) {
		_divisionLocalService = divisionLocalService;
	}

	/**
	* Adds the division to the database. Also notifies the appropriate model listeners.
	*
	* @param division the division
	* @return the division that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Division addDivision(
		com.idetronic.subur.model.Division division)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.addDivision(division);
	}

	/**
	* Creates a new division with the primary key. Does not add the division to the database.
	*
	* @param divisionId the primary key for the new division
	* @return the new division
	*/
	@Override
	public com.idetronic.subur.model.Division createDivision(long divisionId) {
		return _divisionLocalService.createDivision(divisionId);
	}

	/**
	* Deletes the division with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param divisionId the primary key of the division
	* @return the division that was removed
	* @throws PortalException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Division deleteDivision(long divisionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.deleteDivision(divisionId);
	}

	/**
	* Deletes the division from the database. Also notifies the appropriate model listeners.
	*
	* @param division the division
	* @return the division that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Division deleteDivision(
		com.idetronic.subur.model.Division division)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.deleteDivision(division);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _divisionLocalService.dynamicQuery();
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
		return _divisionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _divisionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _divisionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _divisionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _divisionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.idetronic.subur.model.Division fetchDivision(long divisionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.fetchDivision(divisionId);
	}

	/**
	* Returns the division with the primary key.
	*
	* @param divisionId the primary key of the division
	* @return the division
	* @throws PortalException if a division with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Division getDivision(long divisionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.getDivision(divisionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the divisions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.DivisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of divisions
	* @param end the upper bound of the range of divisions (not inclusive)
	* @return the range of divisions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.Division> getDivisions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.getDivisions(start, end);
	}

	/**
	* Returns the number of divisions.
	*
	* @return the number of divisions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDivisionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.getDivisionsCount();
	}

	/**
	* Updates the division in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param division the division
	* @return the division that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.Division updateDivision(
		com.idetronic.subur.model.Division division)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.updateDivision(division);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _divisionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_divisionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _divisionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Division> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.findAll();
	}

	@Override
	public java.util.List<com.idetronic.subur.model.Division> getDepositable()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _divisionLocalService.getDepositable();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DivisionLocalService getWrappedDivisionLocalService() {
		return _divisionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDivisionLocalService(
		DivisionLocalService divisionLocalService) {
		_divisionLocalService = divisionLocalService;
	}

	@Override
	public DivisionLocalService getWrappedService() {
		return _divisionLocalService;
	}

	@Override
	public void setWrappedService(DivisionLocalService divisionLocalService) {
		_divisionLocalService = divisionLocalService;
	}

	private DivisionLocalService _divisionLocalService;
}