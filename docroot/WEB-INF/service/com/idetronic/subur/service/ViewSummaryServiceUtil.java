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
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ViewSummary. This utility wraps
 * {@link com.idetronic.subur.service.impl.ViewSummaryServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mazlan Mat
 * @see ViewSummaryService
 * @see com.idetronic.subur.service.base.ViewSummaryServiceBaseImpl
 * @see com.idetronic.subur.service.impl.ViewSummaryServiceImpl
 * @generated
 */
public class ViewSummaryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.ViewSummaryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

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

	public static com.liferay.portal.kernel.json.JSONObject getTestChartData() {
		return getService().getTestChartData();
	}

	public static com.liferay.portal.kernel.json.JSONObject getMonthlyAssetCategoryChart(
		int year, int vocabularyId) throws java.sql.SQLException {
		return getService().getMonthlyAssetCategoryChart(year, vocabularyId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getMonthlyCategory(
		int year, long vocabularyId) throws java.lang.Exception {
		return getService().getMonthlyCategory(year, vocabularyId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getMonthlyItemType(
		int year) throws java.lang.Exception {
		return getService().getMonthlyItemType(year);
	}

	public static com.liferay.portal.kernel.json.JSONArray getMonthlySummary(
		int year) throws java.lang.Exception {
		return getService().getMonthlySummary(year);
	}

	public static com.liferay.portal.kernel.json.JSONObject getMonthlyTagSummary(
		int year) throws java.lang.Exception {
		return getService().getMonthlyTagSummary(year);
	}

	public static void clearService() {
		_service = null;
	}

	public static ViewSummaryService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ViewSummaryService.class.getName());

			if (invokableService instanceof ViewSummaryService) {
				_service = (ViewSummaryService)invokableService;
			}
			else {
				_service = new ViewSummaryServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ViewSummaryServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ViewSummaryService service) {
	}

	private static ViewSummaryService _service;
}