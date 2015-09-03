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
 * Provides a wrapper for {@link ResearchInterestLocalService}.
 *
 * @author Mazlan Mat
 * @see ResearchInterestLocalService
 * @generated
 */
public class ResearchInterestLocalServiceWrapper
	implements ResearchInterestLocalService,
		ServiceWrapper<ResearchInterestLocalService> {
	public ResearchInterestLocalServiceWrapper(
		ResearchInterestLocalService researchInterestLocalService) {
		_researchInterestLocalService = researchInterestLocalService;
	}

	/**
	* Adds the research interest to the database. Also notifies the appropriate model listeners.
	*
	* @param researchInterest the research interest
	* @return the research interest that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ResearchInterest addResearchInterest(
		com.idetronic.subur.model.ResearchInterest researchInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.addResearchInterest(researchInterest);
	}

	/**
	* Creates a new research interest with the primary key. Does not add the research interest to the database.
	*
	* @param researchInterestId the primary key for the new research interest
	* @return the new research interest
	*/
	@Override
	public com.idetronic.subur.model.ResearchInterest createResearchInterest(
		long researchInterestId) {
		return _researchInterestLocalService.createResearchInterest(researchInterestId);
	}

	/**
	* Deletes the research interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchInterestId the primary key of the research interest
	* @return the research interest that was removed
	* @throws PortalException if a research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ResearchInterest deleteResearchInterest(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.deleteResearchInterest(researchInterestId);
	}

	/**
	* Deletes the research interest from the database. Also notifies the appropriate model listeners.
	*
	* @param researchInterest the research interest
	* @return the research interest that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ResearchInterest deleteResearchInterest(
		com.idetronic.subur.model.ResearchInterest researchInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.deleteResearchInterest(researchInterest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _researchInterestLocalService.dynamicQuery();
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
		return _researchInterestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _researchInterestLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _researchInterestLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _researchInterestLocalService.dynamicQueryCount(dynamicQuery);
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
		return _researchInterestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest fetchResearchInterest(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.fetchResearchInterest(researchInterestId);
	}

	/**
	* Returns the research interest with the primary key.
	*
	* @param researchInterestId the primary key of the research interest
	* @return the research interest
	* @throws PortalException if a research interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ResearchInterest getResearchInterest(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.getResearchInterest(researchInterestId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the research interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ResearchInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research interests
	* @param end the upper bound of the range of research interests (not inclusive)
	* @return the range of research interests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.ResearchInterest> getResearchInterests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.getResearchInterests(start, end);
	}

	/**
	* Returns the number of research interests.
	*
	* @return the number of research interests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getResearchInterestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.getResearchInterestsCount();
	}

	/**
	* Updates the research interest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param researchInterest the research interest
	* @return the research interest that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ResearchInterest updateResearchInterest(
		com.idetronic.subur.model.ResearchInterest researchInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.updateResearchInterest(researchInterest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _researchInterestLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_researchInterestLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _researchInterestLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ResearchInterest> checkResearchInterests(
		long userId, com.liferay.portal.model.Group group,
		java.lang.String[] names)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.checkResearchInterests(userId,
			group, names);
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest addResearchInterest(
		long userId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.addResearchInterest(userId, name,
			serviceContext);
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest getResearchInterest(
		long groupId, java.lang.String name)
		throws com.idetronic.subur.NoSuchResearchInterestException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.getResearchInterest(groupId, name);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ResearchInterest> findByGroupsName(
		long[] groupIds, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.findByGroupsName(groupIds, name,
			start, end, obc);
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest incrementAuthorCount(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.incrementAuthorCount(researchInterestId);
	}

	@Override
	public com.idetronic.subur.model.ResearchInterest decrementAuthorCount(
		long researchInterestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.decrementAuthorCount(researchInterestId);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ResearchInterest> getTop10(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestLocalService.getTop10(groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResearchInterestLocalService getWrappedResearchInterestLocalService() {
		return _researchInterestLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResearchInterestLocalService(
		ResearchInterestLocalService researchInterestLocalService) {
		_researchInterestLocalService = researchInterestLocalService;
	}

	@Override
	public ResearchInterestLocalService getWrappedService() {
		return _researchInterestLocalService;
	}

	@Override
	public void setWrappedService(
		ResearchInterestLocalService researchInterestLocalService) {
		_researchInterestLocalService = researchInterestLocalService;
	}

	private ResearchInterestLocalService _researchInterestLocalService;
}