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

package com.idetronic.subur.service.messaging;

import com.idetronic.subur.service.AuthorExpertiseLocalServiceUtil;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.AuthorResearchInterestLocalServiceUtil;
import com.idetronic.subur.service.AuthorSiteLocalServiceUtil;
import com.idetronic.subur.service.ClpSerializer;
import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;
import com.idetronic.subur.service.ExpertiseLocalServiceUtil;
import com.idetronic.subur.service.ExpertiseServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ResearchInterestLocalServiceUtil;
import com.idetronic.subur.service.ResearchInterestServiceUtil;
import com.idetronic.subur.service.StatDownloadCategoryLocalServiceUtil;
import com.idetronic.subur.service.StatDownloadItemTypeLocalServiceUtil;
import com.idetronic.subur.service.StatDownloadPeriodLocalServiceUtil;
import com.idetronic.subur.service.StatDownloadTagLocalServiceUtil;
import com.idetronic.subur.service.StatViewCategoryLocalServiceUtil;
import com.idetronic.subur.service.StatViewItemTypeLocalServiceUtil;
import com.idetronic.subur.service.StatViewTagLocalServiceUtil;
import com.idetronic.subur.service.SuburConfigLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.service.SuburItemServiceUtil;
import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.idetronic.subur.service.ViewSummaryServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Mazlan Mat
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AuthorLocalServiceUtil.clearService();

			AuthorExpertiseLocalServiceUtil.clearService();

			AuthorResearchInterestLocalServiceUtil.clearService();

			AuthorSiteLocalServiceUtil.clearService();

			DownloadSummaryLocalServiceUtil.clearService();

			ExpertiseLocalServiceUtil.clearService();

			ExpertiseServiceUtil.clearService();
			ItemAuthorLocalServiceUtil.clearService();

			ItemItemTypeLocalServiceUtil.clearService();

			ItemTypeLocalServiceUtil.clearService();

			ResearchInterestLocalServiceUtil.clearService();

			ResearchInterestServiceUtil.clearService();
			StatDownloadCategoryLocalServiceUtil.clearService();

			StatDownloadItemTypeLocalServiceUtil.clearService();

			StatDownloadPeriodLocalServiceUtil.clearService();

			StatDownloadTagLocalServiceUtil.clearService();

			StatViewCategoryLocalServiceUtil.clearService();

			StatViewItemTypeLocalServiceUtil.clearService();

			StatViewTagLocalServiceUtil.clearService();

			SuburConfigLocalServiceUtil.clearService();

			SuburItemLocalServiceUtil.clearService();

			SuburItemServiceUtil.clearService();
			ViewSummaryLocalServiceUtil.clearService();

			ViewSummaryServiceUtil.clearService();
		}
	}
}