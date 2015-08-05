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

import com.idetronic.subur.model.DownloadSummary;
import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the DownloadSummary service. Represents a row in the &quot;Subur_DownloadSummary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DownloadSummaryImpl}.
 * </p>
 *
 * @author Mazlan Mat
 * @see DownloadSummaryImpl
 * @see com.idetronic.subur.model.DownloadSummary
 * @generated
 */
public abstract class DownloadSummaryBaseImpl extends DownloadSummaryModelImpl
	implements DownloadSummary {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a download summary model instance should use the {@link DownloadSummary} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DownloadSummaryLocalServiceUtil.addDownloadSummary(this);
		}
		else {
			DownloadSummaryLocalServiceUtil.updateDownloadSummary(this);
		}
	}
}