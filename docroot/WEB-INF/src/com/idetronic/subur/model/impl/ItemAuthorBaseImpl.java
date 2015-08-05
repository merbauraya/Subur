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

package com.idetronic.subur.model.impl;

import com.idetronic.subur.model.ItemAuthor;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ItemAuthor service. Represents a row in the &quot;Subur_ItemAuthor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ItemAuthorImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see ItemAuthorImpl
 * @see com.idetronic.subur.model.ItemAuthor
 * @generated
 */
public abstract class ItemAuthorBaseImpl extends ItemAuthorModelImpl
	implements ItemAuthor {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a item author model instance should use the {@link ItemAuthor} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ItemAuthorLocalServiceUtil.addItemAuthor(this);
		}
		else {
			ItemAuthorLocalServiceUtil.updateItemAuthor(this);
		}
	}
}