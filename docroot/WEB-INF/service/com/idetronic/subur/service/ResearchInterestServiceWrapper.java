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
 * Provides a wrapper for {@link ResearchInterestService}.
 *
 * @author Mazlan Mat
 * @see ResearchInterestService
 * @generated
 */
public class ResearchInterestServiceWrapper implements ResearchInterestService,
	ServiceWrapper<ResearchInterestService> {
	public ResearchInterestServiceWrapper(
		ResearchInterestService researchInterestService) {
		_researchInterestService = researchInterestService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _researchInterestService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_researchInterestService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _researchInterestService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ResearchInterest> getGroupResearchInterests(
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestService.getGroupResearchInterests(groupIds);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ResearchInterest> getGroupResearchInterests(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestService.getGroupResearchInterests(groupId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray search(long[] groupIds,
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestService.search(groupIds, name, start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray search(long groupId,
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchInterestService.search(groupId, name, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResearchInterestService getWrappedResearchInterestService() {
		return _researchInterestService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResearchInterestService(
		ResearchInterestService researchInterestService) {
		_researchInterestService = researchInterestService;
	}

	@Override
	public ResearchInterestService getWrappedService() {
		return _researchInterestService;
	}

	@Override
	public void setWrappedService(
		ResearchInterestService researchInterestService) {
		_researchInterestService = researchInterestService;
	}

	private ResearchInterestService _researchInterestService;
}