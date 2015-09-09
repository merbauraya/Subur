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

package com.idetronic.subur.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.model.ResearchInterest;
import com.idetronic.subur.service.base.ResearchInterestServiceBaseImpl;
import com.idetronic.subur.util.comparator.ResearchInterestNameComparator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.Autocomplete;

/**
 * The implementation of the research interest remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ResearchInterestService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ResearchInterestServiceBaseImpl
 * @see com.idetronic.subur.service.ResearchInterestServiceUtil
 */
public class ResearchInterestServiceImpl extends ResearchInterestServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ResearchInterestServiceUtil} to access the research interest remote service.
	 */
	public List<ResearchInterest> getGroupResearchInterests(long[] groupIds) throws SystemException
	{
		Set<ResearchInterest> grpResearchInterests = new TreeSet<ResearchInterest>();
		
		for (long groupId : groupIds) {
			List<ResearchInterest> groupResearchInterest = getGroupResearchInterests(groupId);

			grpResearchInterests.addAll(groupResearchInterest);
		}

		return new ArrayList<ResearchInterest>(grpResearchInterests);
		
	}
	public List<ResearchInterest> getGroupResearchInterests(long groupId) throws SystemException
	{
		return researchInterestPersistence.findByGroup(groupId);
	}
	
	public JSONArray search(
			long[] groupIds, String name, int start,
			int end)
		throws SystemException {

		name = StringUtil.lowerCase(name);		
		List<ResearchInterest> researchInterests = researchInterestLocalService.findByGroupsName(groupIds, name, start, end, null);

		return Autocomplete.listToJson(researchInterests, "name", "name");
	}
	
	
	public JSONArray search(
			long groupId, String name, int start, int end)
		throws SystemException {

		return search(new long[]{groupId},name,start,end);
	}
}