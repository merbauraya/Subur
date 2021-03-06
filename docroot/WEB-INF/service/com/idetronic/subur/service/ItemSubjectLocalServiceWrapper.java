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
 * Provides a wrapper for {@link ItemSubjectLocalService}.
 *
 * @author Mazlan Mat
 * @see ItemSubjectLocalService
 * @generated
 */
public class ItemSubjectLocalServiceWrapper implements ItemSubjectLocalService,
	ServiceWrapper<ItemSubjectLocalService> {
	public ItemSubjectLocalServiceWrapper(
		ItemSubjectLocalService itemSubjectLocalService) {
		_itemSubjectLocalService = itemSubjectLocalService;
	}

	/**
	* Adds the item subject to the database. Also notifies the appropriate model listeners.
	*
	* @param itemSubject the item subject
	* @return the item subject that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemSubject addItemSubject(
		com.idetronic.subur.model.ItemSubject itemSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.addItemSubject(itemSubject);
	}

	/**
	* Creates a new item subject with the primary key. Does not add the item subject to the database.
	*
	* @param itemSubjectPK the primary key for the new item subject
	* @return the new item subject
	*/
	@Override
	public com.idetronic.subur.model.ItemSubject createItemSubject(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK) {
		return _itemSubjectLocalService.createItemSubject(itemSubjectPK);
	}

	/**
	* Deletes the item subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemSubjectPK the primary key of the item subject
	* @return the item subject that was removed
	* @throws PortalException if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemSubject deleteItemSubject(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.deleteItemSubject(itemSubjectPK);
	}

	/**
	* Deletes the item subject from the database. Also notifies the appropriate model listeners.
	*
	* @param itemSubject the item subject
	* @return the item subject that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemSubject deleteItemSubject(
		com.idetronic.subur.model.ItemSubject itemSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.deleteItemSubject(itemSubject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _itemSubjectLocalService.dynamicQuery();
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
		return _itemSubjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemSubjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _itemSubjectLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _itemSubjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _itemSubjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.idetronic.subur.model.ItemSubject fetchItemSubject(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.fetchItemSubject(itemSubjectPK);
	}

	/**
	* Returns the item subject with the primary key.
	*
	* @param itemSubjectPK the primary key of the item subject
	* @return the item subject
	* @throws PortalException if a item subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemSubject getItemSubject(
		com.idetronic.subur.service.persistence.ItemSubjectPK itemSubjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.getItemSubject(itemSubjectPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the item subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.idetronic.subur.model.impl.ItemSubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item subjects
	* @param end the upper bound of the range of item subjects (not inclusive)
	* @return the range of item subjects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.idetronic.subur.model.ItemSubject> getItemSubjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.getItemSubjects(start, end);
	}

	/**
	* Returns the number of item subjects.
	*
	* @return the number of item subjects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getItemSubjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.getItemSubjectsCount();
	}

	/**
	* Updates the item subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemSubject the item subject
	* @return the item subject that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.idetronic.subur.model.ItemSubject updateItemSubject(
		com.idetronic.subur.model.ItemSubject itemSubject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.updateItemSubject(itemSubject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _itemSubjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_itemSubjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _itemSubjectLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addItemSubject(long itemId,
		java.util.ArrayList<java.lang.String> subjects)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		_itemSubjectLocalService.addItemSubject(itemId, subjects);
	}

	@Override
	public java.util.List<com.idetronic.subur.model.ItemSubject> getByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return _itemSubjectLocalService.getByItemId(itemId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ItemSubjectLocalService getWrappedItemSubjectLocalService() {
		return _itemSubjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedItemSubjectLocalService(
		ItemSubjectLocalService itemSubjectLocalService) {
		_itemSubjectLocalService = itemSubjectLocalService;
	}

	@Override
	public ItemSubjectLocalService getWrappedService() {
		return _itemSubjectLocalService;
	}

	@Override
	public void setWrappedService(
		ItemSubjectLocalService itemSubjectLocalService) {
		_itemSubjectLocalService = itemSubjectLocalService;
	}

	private ItemSubjectLocalService _itemSubjectLocalService;
}