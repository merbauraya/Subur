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
 * Provides a wrapper for {@link AuthorSiteLocalService}.
 *
 * @author Mazlan Mat
 * @see AuthorSiteLocalService
 * @generated
 */
public class AuthorSiteLocalServiceWrapper implements AuthorSiteLocalService,
	ServiceWrapper<AuthorSiteLocalService> {
	public AuthorSiteLocalServiceWrapper(
		AuthorSiteLocalService authorSiteLocalService) {
		_authorSiteLocalService = authorSiteLocalService;
	}

	/**
	* Adds the author site to the database. Also notifies the appropriate model listeners.
	*
	* @param authorSite the author site
	* @return the author site that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorSite addAuthorSite(
		com.idetronic.subur.model.AuthorSite authorSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.addAuthorSite(authorSite);
	}

	/**
	* Creates a new author site with the primary key. Does not add the author site to the database.
	*
	* @param authorSiteId the primary key for the new author site
	* @return the new author site
	*/
	@Override
	public com.idetronic.subur.model.AuthorSite createAuthorSite(
		long authorSiteId) {
		return _authorSiteLocalService.createAuthorSite(authorSiteId);
	}

	/**
	* Deletes the author site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorSiteId the primary key of the author site
	* @return the author site that was removed
	* @throws PortalException if a author site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorSite deleteAuthorSite(
		long authorSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.deleteAuthorSite(authorSiteId);
	}

	/**
	* Deletes the author site from the database. Also notifies the appropriate model listeners.
	*
	* @param authorSite the author site
	* @return the author site that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorSite deleteAuthorSite(
		com.idetronic.subur.model.AuthorSite authorSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.deleteAuthorSite(authorSite);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _authorSiteLocalService.dynamicQuery();
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
		return _authorSiteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _authorSiteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _authorSiteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _authorSiteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _authorSiteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.AuthorSite fetchAuthorSite(
		long authorSiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.fetchAuthorSite(authorSiteId);
	}

	/**
	* Returns the author site with the primary key.
	*
	* @param authorSiteId the primary key of the author site
	* @return the author site
	* @throws PortalException if a author site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorSite getAuthorSite(long authorSiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.getAuthorSite(authorSiteId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the author sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorSiteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of author sites
	* @param end the upper bound of the range of author sites (not inclusive)
	* @return the range of author sites
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.AuthorSite> getAuthorSites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.getAuthorSites(start, end);
	}

	/**
	* Returns the number of author sites.
	*
	* @return the number of author sites
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAuthorSitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.getAuthorSitesCount();
	}

	/**
	* Updates the author site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param authorSite the author site
	* @return the author site that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.AuthorSite updateAuthorSite(
		com.idetronic.subur.model.AuthorSite authorSite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.updateAuthorSite(authorSite);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _authorSiteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_authorSiteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _authorSiteLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.AuthorSite> findByAuthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _authorSiteLocalService.findByAuthorId(authorId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AuthorSiteLocalService getWrappedAuthorSiteLocalService() {
		return _authorSiteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAuthorSiteLocalService(
		AuthorSiteLocalService authorSiteLocalService) {
		_authorSiteLocalService = authorSiteLocalService;
	}

	@Override
	public AuthorSiteLocalService getWrappedService() {
		return _authorSiteLocalService;
	}

	@Override
	public void setWrappedService(AuthorSiteLocalService authorSiteLocalService) {
		_authorSiteLocalService = authorSiteLocalService;
	}

	private AuthorSiteLocalService _authorSiteLocalService;
}