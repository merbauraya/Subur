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
 * Provides the local service utility for Author. This utility wraps
 * {@link com.idetronic.subur.service.impl.AuthorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mazlan Mat
 * @see AuthorLocalService
 * @see com.idetronic.subur.service.base.AuthorLocalServiceBaseImpl
 * @see com.idetronic.subur.service.impl.AuthorLocalServiceImpl
 * @generated
 */
public class AuthorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.idetronic.subur.service.impl.AuthorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the author to the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Author addAuthor(
		com.idetronic.subur.model.Author author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAuthor(author);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public static com.idetronic.subur.model.Author createAuthor(long authorId) {
		return getService().createAuthor(authorId);
	}

	/**
	* Deletes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws PortalException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Author deleteAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAuthor(authorId);
	}

	/**
	* Deletes the author from the database. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Author deleteAuthor(
		com.idetronic.subur.model.Author author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAuthor(author);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.idetronic.subur.model.Author fetchAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAuthor(authorId);
	}

	/**
	* Returns the author with the primary key.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws PortalException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Author getAuthor(long authorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuthor(authorId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.AuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.idetronic.subur.model.Author> getAuthors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuthors(start, end);
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	* @throws SystemException if a system exception occurred
	*/
	public static int getAuthorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuthorsCount();
	}

	/**
	* Updates the author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param author the author
	* @return the author that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.idetronic.subur.model.Author updateAuthor(
		com.idetronic.subur.model.Author author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAuthor(author);
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

	/**
	* @param firstName
	* @param middleName
	* @param lastName
	* @param salutation
	* @param email
	* @param officeNo
	* @param serviceContext
	* @return
	* @throws SystemException
	*/
	public static com.idetronic.subur.model.Author newAuthor(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String salutation,
		java.lang.String email, java.lang.String officeNo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .newAuthor(firstName, middleName, lastName, salutation,
			email, officeNo, serviceContext);
	}

	public static long addAuthor(java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String salutation, java.lang.String email,
		java.lang.String officeNo,
		java.util.Map<java.lang.String, java.lang.String> authorSite,
		java.lang.String remoteId, int idType, long userId, long groupId,
		long createdByUserId, java.lang.String[] expertiseNames,
		java.lang.String[] researchInterestNames,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .addAuthor(firstName, middleName, lastName, salutation,
			email, officeNo, authorSite, remoteId, idType, userId, groupId,
			createdByUserId, expertiseNames, researchInterestNames,
			serviceContext);
	}

	public static void setExpertises(long authorId,
		java.util.List<com.idetronic.subur.model.Expertise> expertises)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setExpertises(authorId, expertises);
	}

	public static void setResearchInterests(long authorId,
		java.util.List<com.idetronic.subur.model.ResearchInterest> researchInterests)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setResearchInterests(authorId, researchInterests);
	}

	/**
	* Update existing author, throw Exception if author not found or update fails
	*
	* @param authorId
	* @param firstName
	* @param lastName
	* @param remoteId
	* @param idType
	* @param userId
	* @param groupId
	* @return
	* @throws SystemException
	* @throws PortalException
	*/
	public static com.idetronic.subur.model.Author updateAuthor(long authorId,
		java.lang.String salutation, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String email, java.lang.String officeNo,
		java.util.Map<java.lang.String, java.lang.String> authorSite,
		java.lang.String title, long userId, long groupId,
		long createdByUserId, java.lang.String[] expertiseNames,
		java.lang.String[] researchInterestNames,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService()
				   .updateAuthor(authorId, salutation, firstName, middleName,
			lastName, email, officeNo, authorSite, title, userId, groupId,
			createdByUserId, expertiseNames, researchInterestNames,
			serviceContext);
	}

	/**
	* Find all item under a given author
	*
	* @param groupId
	* @param authorId
	* @param start
	* @param end
	* @param status Item status
	* @param obc
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.idetronic.subur.model.SuburItem> getItemByAuthorGroup(
		long groupId, long authorId, int start, int end, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getItemByAuthorGroup(groupId, authorId, start, end, status,
			obc);
	}

	/**
	* Find and return all associated expertise for the author
	*
	* @param authorId to seearch for
	* @return List of Expertise
	* @throws SystemException
	*/
	public static java.util.List<com.idetronic.subur.model.Expertise> getExpertises(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getExpertises(authorId);
	}

	public static java.util.List<com.idetronic.subur.model.ResearchInterest> getResearchInterests(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchInterests(authorId);
	}

	/**
	* Update author latest posting
	*
	* @param suburItem
	* @throws SystemException
	*/
	public static void updateAuthorPosting(
		com.idetronic.subur.model.SuburItem suburItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateAuthorPosting(suburItem);
	}

	/**
	* Increment item count and last posted date for an author
	* Usually called during new item creation
	*
	* @param authorId
	* @return new item count for the author
	* @throws SystemException if author cannot be found or fail during update
	*/
	public static int updateNewPosting(long authorId, java.util.Date newPostDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewPosting(authorId, newPostDate);
	}

	/**
	* Return all authors with the primary keys
	*
	* @param authorIds the primary key of the author
	* @return authors with primary key
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<com.idetronic.subur.model.Author> getAuthors(
		long[] authorIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuthors(authorIds);
	}

	/**
	* Update all author with up to date item count
	*
	* @param companyId
	* @param groupId
	*/
	public static void updateAllItemCount(long companyId, long groupId) {
		getService().updateAllItemCount(companyId, groupId);
	}

	/**
	* Decrement item count for the author
	*/
	public static void decrementItemCount(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().decrementItemCount(authorId);
	}

	public static int getSearchCount(java.lang.String keyword, long companyId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSearchCount(keyword, companyId, groupId);
	}

	public static int getSearchCount(java.lang.String keyword, long companyId,
		long groupId, java.lang.String firstName, java.lang.String lastName,
		boolean isAdvancedSearch, boolean isAndOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService()
				   .getSearchCount(keyword, companyId, groupId, firstName,
			lastName, isAdvancedSearch, isAndOperator, start, end, obc);
	}

	public static java.util.List<com.idetronic.subur.model.SuburItem> getSuburItems(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {
		return getService().getSuburItems(authorId, start, end, obc);
	}

	public static java.util.List<com.idetronic.subur.model.Author> search(
		java.lang.String keyword, long companyId, long groupId,
		java.lang.String firstName, java.lang.String lastName,
		boolean isAdvancedSearch, boolean isAndOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(keyword, companyId, groupId, firstName, lastName,
			isAdvancedSearch, isAndOperator, start, end, obc);
	}

	public static java.util.List<com.idetronic.subur.model.Author> search(
		java.lang.String keyword, long companyId, long groupId, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().search(keyword, companyId, groupId, start, end, obc);
	}

	public static java.util.List<com.idetronic.subur.model.Author> findByGroupCompany(
		long companyId, long groupId, int start, int end) {
		return getService().findByGroupCompany(companyId, groupId, start, end);
	}

	public static java.util.List<com.idetronic.subur.model.Author> recentByGroup(
		long companyId, long groupId, java.util.Date lastPublishedDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .recentByGroup(companyId, groupId, lastPublishedDate, start,
			end);
	}

	public static void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteItem(itemId);
	}

	public static com.idetronic.subur.model.Author updatePortrait(
		long authorId, byte[] bytes)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortrait(authorId, bytes);
	}

	public static void clearService() {
		_service = null;
	}

	public static AuthorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AuthorLocalService.class.getName());

			if (invokableLocalService instanceof AuthorLocalService) {
				_service = (AuthorLocalService)invokableLocalService;
			}
			else {
				_service = new AuthorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AuthorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AuthorLocalService service) {
	}

	private static AuthorLocalService _service;
}