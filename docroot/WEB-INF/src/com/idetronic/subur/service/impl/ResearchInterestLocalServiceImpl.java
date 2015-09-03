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
import java.util.Date;
import java.util.List;

import com.idetronic.subur.ExpertiseException;
import com.idetronic.subur.NoSuchResearchInterestException;
import com.idetronic.subur.ResearchInterestException;
import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.model.ResearchInterest;
import com.idetronic.subur.service.base.ResearchInterestLocalServiceBaseImpl;
import com.idetronic.subur.util.SuburAssetUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the research interest local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ResearchInterestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ResearchInterestLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ResearchInterestLocalServiceUtil
 */
public class ResearchInterestLocalServiceImpl
	extends ResearchInterestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ResearchInterestLocalServiceUtil} to access the research interest local service.
	 */
	public List<ResearchInterest> checkResearchInterests(long userId,Group group,String[] names)
			throws SystemException,PortalException
		{
			List<ResearchInterest> researchInterests = new ArrayList<ResearchInterest>();
			
			for (String name: names)
			{
				ResearchInterest researchInterest = null;
				try
				{
					researchInterest = getResearchInterest(group.getGroupId(),StringUtil.lowerCase(name));
					
				}catch (NoSuchResearchInterestException nse)
				{
					ServiceContext serviceContext = new ServiceContext();

					serviceContext.setAddGroupPermissions(true);
					serviceContext.setAddGuestPermissions(true);
					serviceContext.setScopeGroupId(group.getGroupId());
					researchInterest = addResearchInterest(userId,name,serviceContext);
					
				}
				
				if (researchInterest != null)
					researchInterests.add(researchInterest);
				
			}
			return researchInterests;
		}
		@Override
		public ResearchInterest addResearchInterest(long userId,String name,ServiceContext serviceContext) throws SystemException, PortalException
		{
			User user = userPersistence.findByPrimaryKey(userId);
			long groupId = serviceContext.getScopeGroupId();
			
			Date now = new Date();

			long researchInterestId = CounterLocalServiceUtil.increment(ResearchInterest.class.getName());
			ResearchInterest researchInterest = researchInterestPersistence.create(researchInterestId);
			
			
			
			researchInterest.setGroupId(groupId);
			researchInterest.setCompanyId(user.getCompanyId());
			researchInterest.setUserId(userId);;
			researchInterest.setCreateDate(now);
			researchInterest.setModifiedDate(now);
			
			name = StringUtil.trim(name);
			
			validate(name);

			researchInterest.setResearchInterestName(name);
			researchInterest.setIndexedName(StringUtil.toLowerCase(name));
			researchInterestPersistence.update(researchInterest);
			
			
			return researchInterest;
			
			
			
		}
		@Override
		public ResearchInterest getResearchInterest(long groupId,String name) throws NoSuchResearchInterestException, SystemException
		{
			return researchInterestPersistence.findByGroupName(groupId, name);
		}
		
		public List<ResearchInterest> findByGroupsName(long[] groupIds,String name,
				int start,int end,OrderByComparator obc) throws SystemException
		{
			return researchInterestFinder.filterFindByG_N(groupIds, name, start, end, obc);
		}
		protected void validate(String name) throws PortalException {
			if (!SuburAssetUtil.isValidWord(name)) {
				throw new ResearchInterestException(
					StringUtil.merge(
						SuburAssetUtil.INVALID_CHARACTERS, StringPool.SPACE),
						ResearchInterestException.INVALID_CHARACTER);
			}
		}
		
		@Override
		public ResearchInterest incrementAuthorCount(long researchInterestId) throws SystemException
		{
			ResearchInterest researchInterest;
			try {
				researchInterest = researchInterestPersistence.findByPrimaryKey(researchInterestId);
				researchInterest.setAuthorCount(researchInterest.getAuthorCount() + 1);
				
				researchInterestPersistence.update(researchInterest);
				
				return researchInterest;
				
			} catch (NoSuchResearchInterestException e) {
				// TODO Auto-generated catch block
				return null;
			}
			
		}
		@Override
		public ResearchInterest decrementAuthorCount(long researchInterestId) throws SystemException
		{
			ResearchInterest researchInterest;
			try {
				researchInterest = researchInterestPersistence.findByPrimaryKey(researchInterestId);
				researchInterest.setAuthorCount(researchInterest.getAuthorCount() - 1);
				
				researchInterestPersistence.update(researchInterest);
				
				return researchInterest;
				
			} catch (NoSuchResearchInterestException e) {
				// TODO Auto-generated catch block
				return null;
			}
			
		}
		public List<ResearchInterest> getTop10(long groupId) throws SystemException
		{
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("Subur_ResearchInterest", "authorCount", false) ;
			return researchInterestPersistence.findByGroup(groupId, 0, 9, obc);
		}
}