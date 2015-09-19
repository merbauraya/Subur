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
 * Provides a wrapper for {@link SuburItemService}.
 *
 * @author Mazlan Mat
 * @see SuburItemService
 * @generated
 */
public class SuburItemServiceWrapper implements SuburItemService,
	ServiceWrapper<SuburItemService> {
	public SuburItemServiceWrapper(SuburItemService suburItemService) {
		_suburItemService = suburItemService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _suburItemService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_suburItemService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _suburItemService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.idetronic.subur.model.SuburItem getSuburItem(long suburItemId)
		throws com.idetronic.subur.NoSuchItemException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _suburItemService.getSuburItem(suburItemId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SuburItemService getWrappedSuburItemService() {
		return _suburItemService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSuburItemService(SuburItemService suburItemService) {
		_suburItemService = suburItemService;
	}

	@Override
	public SuburItemService getWrappedService() {
		return _suburItemService;
	}

	@Override
	public void setWrappedService(SuburItemService suburItemService) {
		_suburItemService = suburItemService;
	}

	private SuburItemService _suburItemService;
}