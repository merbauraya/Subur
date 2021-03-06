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
 * Provides a wrapper for {@link ItemAuthorLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemAuthorLocalService
 * @generated
 */
public class ItemAuthorLocalServiceWrapper implements ItemAuthorLocalService,
	ServiceWrapper<ItemAuthorLocalService> {
	public ItemAuthorLocalServiceWrapper(
		ItemAuthorLocalService itemAuthorLocalService) {
		_itemAuthorLocalService = itemAuthorLocalService;
	}

	/**
	* Adds the item author to the database. Also notifies the appropriate model listeners.
	*
	* @param itemAuthor the item author
	* @return the item author that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemAuthor addItemAuthor(
		com.idetronic.subur.model.ItemAuthor itemAuthor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.addItemAuthor(itemAuthor);
	}

	/**
	* Creates a new item author with the primary key. Does not add the item author to the database.
	*
	* @param itemAuthorPK the primary key for the new item author
	* @return the new item author
	*/
	@Override
	public com.idetronic.subur.model.ItemAuthor createItemAuthor(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK) {
		return _itemAuthorLocalService.createItemAuthor(itemAuthorPK);
	}

	/**
	* Deletes the item author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemAuthorPK the primary key of the item author
	* @return the item author that was removed
	* @throws PortalException if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemAuthor deleteItemAuthor(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.deleteItemAuthor(itemAuthorPK);
	}

	/**
	* Deletes the item author from the database. Also notifies the appropriate model listeners.
	*
	* @param itemAuthor the item author
	* @return the item author that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemAuthor deleteItemAuthor(
		com.idetronic.subur.model.ItemAuthor itemAuthor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.deleteItemAuthor(itemAuthor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemAuthorLocalService.dynamicQuery();
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
		return _itemAuthorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemAuthorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemAuthorLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _itemAuthorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _itemAuthorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.ItemAuthor fetchItemAuthor(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.fetchItemAuthor(itemAuthorPK);
	}

	/**
	* Returns the item author with the primary key.
	*
	* @param itemAuthorPK the primary key of the item author
	* @return the item author
	* @throws PortalException if a item author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemAuthor getItemAuthor(
		com.idetronic.subur.service.persistence.ItemAuthorPK itemAuthorPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getItemAuthor(itemAuthorPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the item authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item authors
	* @param end the upper bound of the range of item authors (not inclusive)
	* @return the range of item authors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.ItemAuthor> getItemAuthors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getItemAuthors(start, end);
	}

	/**
	* Returns the number of item authors.
	*
	* @return the number of item authors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemAuthorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getItemAuthorsCount();
	}

	/**
	* Updates the item author in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemAuthor the item author
	* @return the item author that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemAuthor updateItemAuthor(
		com.idetronic.subur.model.ItemAuthor itemAuthor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.updateItemAuthor(itemAuthor);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemAuthorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemAuthorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemAuthorLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void add(long itemId, long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemAuthorLocalService.add(itemId, authorId);
	}

	/**
	* Return all author id for a given item id
	*
	* @param itemId Subur Item id
	* @return long array of author id
	* @throws SystemException if author could not be found for the given item id
	*/
	@Override
	public long[] getAuthorId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getAuthorId(itemId);
	}

	/**
	* Get list of author for the given item Id
	*
	* @param itemId
	* @return list of author
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.Author> getAuthors(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getAuthors(itemId);
	}

	/**
	* Get an array of author for a given item id
	*
	* @param itemId
	* @return array of Author
	* @throws PortalException
	* @throws SystemException
	*/
	@Override
	public com.idetronic.subur.model.Author[] getAuthorArray(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemAuthorLocalService.getAuthorArray(itemId);
	}

	@Override
	public void setItemAuthor(long itemId, long[] authorIds, int itemStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_itemAuthorLocalService.setItemAuthor(itemId, authorIds, itemStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemAuthorLocalService getWrappedItemAuthorLocalService() {
		return _itemAuthorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemAuthorLocalService(
		ItemAuthorLocalService itemAuthorLocalService) {
		_itemAuthorLocalService = itemAuthorLocalService;
	}

	@Override
	public ItemAuthorLocalService getWrappedService() {
		return _itemAuthorLocalService;
	}

	@Override
	public void setWrappedService(ItemAuthorLocalService itemAuthorLocalService) {
		_itemAuthorLocalService = itemAuthorLocalService;
	}

	private ItemAuthorLocalService _itemAuthorLocalService;
}