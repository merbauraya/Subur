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

import com.idetronic.subur.model.HChartSeries;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the h chart series service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mazlan Mat
 * @see HChartSeriesPersistenceImpl
 * @see HChartSeriesUtil
 * @generated
 */
public interface HChartSeriesPersistence extends BasePersistence<HChartSeries> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HChartSeriesUtil} to access the h chart series persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the h chart serieses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.HChartSeries> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the h chart serieses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of h chart serieses
	* @param end the upper bound of the range of h chart serieses (not inclusive)
	* @return the range of matching h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.HChartSeries> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the h chart serieses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of h chart serieses
	* @param end the upper bound of the range of h chart serieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.HChartSeries> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first h chart series in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching h chart series
	* @throws com.idetronic.subur.NoSuchHChartSeriesException if a matching h chart series could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchHChartSeriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first h chart series in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching h chart series, or <code>null</code> if a matching h chart series could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last h chart series in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching h chart series
	* @throws com.idetronic.subur.NoSuchHChartSeriesException if a matching h chart series could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchHChartSeriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last h chart series in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching h chart series, or <code>null</code> if a matching h chart series could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the h chart serieses before and after the current h chart series in the ordered set where uuid = &#63;.
	*
	* @param hChartSeriesId the primary key of the current h chart series
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next h chart series
	* @throws com.idetronic.subur.NoSuchHChartSeriesException if a h chart series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries[] findByUuid_PrevAndNext(
		long hChartSeriesId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.idetronic.subur.NoSuchHChartSeriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the h chart serieses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of h chart serieses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the h chart series in the entity cache if it is enabled.
	*
	* @param hChartSeries the h chart series
	*/
	public void cacheResult(com.idetronic.subur.model.HChartSeries hChartSeries);

	/**
	* Caches the h chart serieses in the entity cache if it is enabled.
	*
	* @param hChartSerieses the h chart serieses
	*/
	public void cacheResult(
		java.util.List<com.idetronic.subur.model.HChartSeries> hChartSerieses);

	/**
	* Creates a new h chart series with the primary key. Does not add the h chart series to the database.
	*
	* @param hChartSeriesId the primary key for the new h chart series
	* @return the new h chart series
	*/
	public com.idetronic.subur.model.HChartSeries create(long hChartSeriesId);

	/**
	* Removes the h chart series with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hChartSeriesId the primary key of the h chart series
	* @return the h chart series that was removed
	* @throws com.idetronic.subur.NoSuchHChartSeriesException if a h chart series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries remove(long hChartSeriesId)
		throws com.idetronic.subur.NoSuchHChartSeriesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.idetronic.subur.model.HChartSeries updateImpl(
		com.idetronic.subur.model.HChartSeries hChartSeries)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the h chart series with the primary key or throws a {@link com.idetronic.subur.NoSuchHChartSeriesException} if it could not be found.
	*
	* @param hChartSeriesId the primary key of the h chart series
	* @return the h chart series
	* @throws com.idetronic.subur.NoSuchHChartSeriesException if a h chart series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries findByPrimaryKey(
		long hChartSeriesId)
		throws com.idetronic.subur.NoSuchHChartSeriesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the h chart series with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hChartSeriesId the primary key of the h chart series
	* @return the h chart series, or <code>null</code> if a h chart series with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.idetronic.subur.model.HChartSeries fetchByPrimaryKey(
		long hChartSeriesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the h chart serieses.
	*
	* @return the h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.HChartSeries> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the h chart serieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of h chart serieses
	* @param end the upper bound of the range of h chart serieses (not inclusive)
	* @return the range of h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.HChartSeries> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the h chart serieses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.HChartSeriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of h chart serieses
	* @param end the upper bound of the range of h chart serieses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.idetronic.subur.model.HChartSeries> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the h chart serieses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of h chart serieses.
	*
	* @return the number of h chart serieses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}