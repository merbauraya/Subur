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

package com.idetronic.subur.service.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.idetronic.subur.NoSuchStatViewCategoryException;
import com.idetronic.subur.NoSuchStatViewItemTypeException;
import com.idetronic.subur.NoSuchStatViewTagException;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.StatViewCategory;
import com.idetronic.subur.model.StatViewItemType;
import com.idetronic.subur.model.StatViewTag;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.ViewSummary;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.base.ViewSummaryLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.ViewSummaryFinderUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;

/**
 * The implementation of the view summary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.ViewSummaryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.ViewSummaryLocalServiceBaseImpl
 * @see com.idetronic.subur.service.ViewSummaryLocalServiceUtil
 */
public class ViewSummaryLocalServiceImpl extends ViewSummaryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.ViewSummaryLocalServiceUtil} to access the view summary local service.
	 */
	public static final int STATUS_NEW = 0;
	public static final int STATUS_UPDATED = 1;
	
	
	private static Log logger = LogFactoryUtil.getLog(ViewSummaryLocalServiceImpl.class);

	
	@Override
	public JSONArray getMonthlyStatRs(int year) throws SQLException
	{
		return ViewSummaryFinderUtil.getMonthlySummary(year);
		
		
	}
	/*
	public JSONArray getMonthlyTag(int year) throws SQLException
	{
		return ViewSummaryFinderUtil.getMothlyTagSummary(year);
	}
	*/
	/**
	 * Add view stats info the the entity. 
	 */
	public ViewSummary addStats(long itemId,long companyId,long groupId) throws SystemException
	{
		
		
		long id = CounterLocalServiceUtil.increment(ViewSummary.class.getName());
		ViewSummary dSummary = viewSummaryPersistence.create(id);
		
	
		dSummary.setItemId(itemId);
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		dSummary.setStatus(STATUS_NEW);
		dSummary.setPerYear(year);
		dSummary.setPerMonth(month);
		dSummary.setCompanyId(companyId);
		dSummary.setGroupId(groupId);
		
		viewSummaryPersistence.update(dSummary);
		
		return dSummary;
	}
	@Override
	public void updateStats(long companyId,long groupId) throws SystemException,PortalException
	{
		List<ViewSummary> viewSummaries = viewSummaryPersistence.findByStatus(STATUS_NEW, groupId, companyId);
		
		long id = 0L;
		for (ViewSummary viewSummary : viewSummaries)
		{
			int month = viewSummary.getPerMonth();
			int year = viewSummary.getPerYear();
			long itemId = viewSummary.getItemId();
			
			//get item Type
			
			List<ItemItemType> itemItemTypes = ItemItemTypeLocalServiceUtil.itemTypeByItemid(itemId);
			
			for (int i = 0; i < itemItemTypes.size(); i++)
			{
				generateViewYearItemTypeRow(companyId,groupId,year,month,itemItemTypes.get(i).getItemTypeId());
				updateItemTypeStat(companyId,groupId,year,month,itemItemTypes.get(i).getItemTypeId());
				
			}
			
			//category
			//get categories
			List<AssetCategory> categories = AssetCategoryServiceUtil.getCategories(SuburItem.class.getName(), itemId);
			
			
			for (int i = 0; i < categories.size(); i++)
			{
				generateViewYearCategoryRow(companyId,groupId,year,month,categories.get(i).getCategoryId());
				updateCategoryStat(companyId,groupId,year,month,categories.get(i).getCategoryId());
				
			}
			
			//tags
			List<AssetTag> tags = AssetTagServiceUtil.getTags(SuburItem.class.getName(), itemId);
			
			for (int i = 0; i < tags.size(); i++)
			{
				generateViewYearTagRow(companyId,groupId,year,month,tags.get(i).getTagId());
				updateTagStat(companyId,groupId,year,month,tags.get(i).getTagId());
			}
			
			
			
			
			
			
			
			
			
			viewSummary.setStatus(STATUS_UPDATED);
			viewSummaryPersistence.update(viewSummary);
		}
	}
	private void updateItemTypeStat(long companyId,long groupId,int year,int month,long itemTypeId) throws SystemException
	{
		//item type stats
		
		StatViewItemType viewItemType = getStatViewItemType(companyId,groupId,year,month,itemTypeId);
		int viewCount = viewItemType.getViewCount() +1;
		
		viewItemType.setViewCount(viewCount);
		
		statViewItemTypePersistence.update(viewItemType);
	}
	private void updateTagStat(long companyId,long groupId,int year,int month,long tagId) throws SystemException
	{
		
		StatViewTag viewTag = getStatViewTag(companyId,groupId,year,month,tagId);
		
		int viewCount = viewTag.getViewCount() +1;
		viewTag.setViewCount(viewCount);
		
		statViewTagPersistence.update(viewTag);
		
	}
	private StatViewItemType getStatViewItemType(long companyId,long groupId,int perYear,int perMonth,long itemTypeId) throws SystemException
	{
		StatViewItemType viewItemType = null;
		
		
		try
		{
			viewItemType = statViewItemTypePersistence.findByItemTypePeriodGroup(companyId,groupId,itemTypeId, perYear, perMonth);
		
		} catch (NoSuchStatViewItemTypeException e)
		{
			long id  = CounterLocalServiceUtil.increment(StatViewItemType.class.getName());
			viewItemType = statViewItemTypePersistence.create(id);
			viewItemType.setViewCount(0);
			viewItemType.setItemTypeId(itemTypeId);
			viewItemType.setCompanyId(companyId);
			viewItemType.setGroupId(groupId);
			viewItemType.setPerYear(perYear);
			viewItemType.setPerMonth(perMonth);
			viewItemType.setNew(true);
			
			
		}
		return viewItemType;
	}
	private StatViewTag getStatViewTag(long companyId,long groupId,int perYear,int perMonth,long tagId) throws SystemException
	{
		StatViewTag viewStat = null;
		try
		{
			viewStat = statViewTagPersistence.findByTagPeriod(companyId,groupId,tagId, perYear,perMonth );
		
		} catch (NoSuchStatViewTagException e)
		{
			long id  = CounterLocalServiceUtil.increment(StatViewTag.class.getName());
			viewStat = statViewTagPersistence.create(id);
			viewStat.setViewCount(0);
			viewStat.setTagId(tagId);
			viewStat.setCompanyId(companyId);
			viewStat.setGroupId(groupId);
			viewStat.setPerMonth(perMonth);
			viewStat.setPerYear(perYear);
			viewStat.setNew(true);
			
			
		}
		return viewStat;
	}
	private void updateCategoryStat(long companyId,long groupId,int perYear, int perMonth, long categoryId) throws SystemException
	{
		
		StatViewCategory viewCategory = getStatViewCategory(companyId,groupId,perYear,perMonth,categoryId);
		
		
		int viewCount = viewCategory.getViewCount() +1;
		
		//LOGGER.info(categoryId + "  view="+viewCount);
		viewCategory.setViewCount(viewCount);	
		
		
		
		statViewCategoryPersistence.update(viewCategory);
	}
	/**
	 * Get Statistic View Category based on period and Vocabulary Id. If none exist
	 * new row will be created with 0 viewCount 
	 * @param perMonth
	 * @param perYear
	 * @param categoryId
	 * @return
	 * @throws SystemException
	 */
	private StatViewCategory getStatViewCategory(long companyId,long groupId,int perYear, int perMonth, long categoryId) throws SystemException
	{
		StatViewCategory viewCategory = null;
		
		LOGGER.info(companyId + ":"+groupId + ":"+perYear+":"+perMonth+":"+categoryId);
		try
		{
			viewCategory = statViewCategoryPersistence.findByCategoryPeriod(companyId,groupId,categoryId, perYear, perMonth);
		
		} catch (NoSuchStatViewCategoryException nsvce)
		{
			LOGGER.info("newCatStat:"+perYear+":"+perMonth+":"+ categoryId);
			long id  = CounterLocalServiceUtil.increment(StatViewCategory.class.getName());
			viewCategory = statViewCategoryPersistence.create(id);
			viewCategory.setViewCount(0);
			viewCategory.setCategoryId(categoryId);
			viewCategory.setPerYear(perYear);
			viewCategory.setPerMonth(perMonth);
			viewCategory.setNew(true);
			viewCategory.setCompanyId(companyId);
			viewCategory.setGroupId(groupId);
			
		}
		return viewCategory;
		
	}
	
	/**
	 * Generate view by Category statistic current + previous month row to
	 * ensure no month are missing in the db
	 * @param year
	 * @param month
	 * @param categoryId
	 * @throws SystemException
	 */
	private void generateViewYearCategoryRow(long companyId,long groupId,int perYear,int perMonth,long categoryId) throws SystemException
	{
		for (int month = perMonth; month > 0; month--)
		{
			StatViewCategory viewCategory = getStatViewCategory(companyId,groupId,perYear,month,categoryId);
			if (viewCategory.isNew())
			{
				statViewCategoryPersistence.update(viewCategory);
			}
		}
		
	}
	private void generateViewYearTagRow(long companyId,long groupId,int perYear,int perMonth, long tagId) throws SystemException
	{
		for (int month = perMonth; month > 0; month--)
		{
			StatViewTag viewTag = getStatViewTag(companyId,groupId,perYear,month,tagId);
			if (viewTag.isNew())
			{
				statViewTagPersistence.update(viewTag);
			}

		}
	}
	private void generateViewYearItemTypeRow(long companyId,long groupId,int perYear,int perMonth,long itemTypeId) throws SystemException
	{
		for (int month = perMonth; month > 0; month--)
		{
			StatViewItemType viewItemType = getStatViewItemType(companyId,groupId,perYear,month,itemTypeId);
			if (viewItemType.isNew())
			{
				statViewItemTypePersistence.update(viewItemType);
			}

		}
	}
	private static Log LOGGER = LogFactoryUtil.getLog(ViewSummaryLocalServiceImpl.class);
	
}