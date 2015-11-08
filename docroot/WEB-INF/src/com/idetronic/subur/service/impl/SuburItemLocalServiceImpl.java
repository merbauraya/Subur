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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;

import com.idetronic.subur.NoSuchItemException;
import com.idetronic.subur.NoSuchSuburItemException;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.ItemType;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.DownloadSummaryLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ItemTypeLocalServiceUtil;
import com.idetronic.subur.service.ViewSummaryLocalServiceUtil;
import com.idetronic.subur.service.base.SuburItemLocalServiceBaseImpl;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.idetronic.subur.service.persistence.SuburItemFinderUtil;
import com.idetronic.subur.social.SuburActivityKeys;
import com.idetronic.subur.util.PortletKeys;
import com.idetronic.subur.util.SuburConstant;
import com.idetronic.subur.util.SuburURLUtil;
import com.idetronic.subur.util.SuburUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

/**
 * The implementation of the subur item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.SuburItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.SuburItemLocalServiceBaseImpl
 * @see com.idetronic.subur.service.SuburItemLocalServiceUtil
 */
public class SuburItemLocalServiceImpl extends SuburItemLocalServiceBaseImpl {
	private static Log LOGGER = LogFactoryUtil.getLog(SuburItemLocalServiceImpl.class);
	
	public SuburItem addItem(long userId,long groupId,String title,String itemAbstract,
			long[] itemTypeId,ServiceContext serviceContext) throws PortalException, SystemException
	{
		User user = userLocalService.getUserById(userId);
		
		Date now = new Date();
		long itemId = CounterLocalServiceUtil.increment(SuburItem.class.getName());
		
		SuburItem suburItem = suburItemPersistence.create(itemId);
		
		suburItem.setItemId(itemId);
		suburItem.setGroupId(groupId);
		suburItem.setCompanyId(user.getCompanyId());
		suburItem.setUserId(userId);
		suburItem.setCreateDate(now);
		suburItem.setModifiedDate(now);
		suburItem.setTitle(title);
		suburItem.setItemAbstract(itemAbstract);
		suburItem.setUuid(PortalUUIDUtil.generate());
		suburItem.setStatus(WorkflowConstants.STATUS_DRAFT);
		suburItem.setCompleted(false);
		suburItemPersistence.update(suburItem);
		ItemItemTypeLocalServiceUtil.addItemItemType(itemId, itemTypeId);
		
		/*
				
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);

		indexer.reindex(suburItem);
		*/
		//only show item with published status
		boolean visible = (suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM);
		String itemDescription = null;
		String summary = null;
		String url = null;
		String layoutUuid = null;
		
		/*
		resourceLocalService.addResources(suburItem.getCompanyId(), suburItem.getGroupId(), 
				suburItem.getUserId(), SuburItem.class.getName(), suburItem.getItemId(), 
				false, true, true);
		
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, suburItem.getCreateDate(),
                suburItem.getModifiedDate(), SuburItem.class.getName(),
                suburItem.getItemId(), suburItem.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), visible, null, null, null,
                ContentTypes.TEXT_HTML, suburItem.getTitle(), itemDescription, summary, url,
                layoutUuid, 0, 0, null, false);
                   
		*/
		
		
		return suburItem;
	}
	
	public List<SuburItem> findByGroupAndUserAndStatus(long companyId,long groupId,long userId,int status,int start,int end) throws SystemException
	{
		if (status != WorkflowConstants.STATUS_ANY)
		{
			return suburItemPersistence.findByGroupCreatorStatus(companyId, groupId, userId, status, start, end);
		}else
		{
			return suburItemPersistence.findByGroupCreator(companyId,groupId,userId,start,end);
		}
	}
	public int countByGroupAndUserAndStatus(long companyId,long groupId,long userId,int status) throws SystemException
	{
		if (status != WorkflowConstants.STATUS_ANY)
		{
			return suburItemPersistence.countByGroupCreatorStatus(companyId, groupId, userId, status);
		}else
		{
			return suburItemPersistence.countByGroupCreator(companyId,groupId,userId);
		}
	}
	
	public List<SuburItem> findByGroupAndStatus(long companyId,long groupId,int status,int start,int end) throws SystemException
	{
		
		if (status != WorkflowConstants.STATUS_ANY)
			return suburItemPersistence.findByGroupStatus(companyId, groupId, status, start, end);
		else
			return suburItemPersistence.filterFindByGroupId(groupId, start, end);
	}
	public int countByGroupStatus(long companyId,long groupId,int status) throws SystemException
	{
		if (status != WorkflowConstants.STATUS_ANY)
		{
			return suburItemPersistence.countByGroupStatus(companyId, groupId, status);
		}else
		{
			return suburItemPersistence.countByGroup(companyId,groupId);
		}
	}
	@Override
	public SuburItem updateSuburItem(SuburItem suburItem,long userId,int newStatus,
			long[] itemTypeIds, long[] authorIds, ServiceContext serviceContext) throws PortalException,SystemException 
	{
		
		long groupId = serviceContext.getScopeGroupId();
		
		if (Validator.isNull(suburItem.getPublishedDate()) && suburItem.getStatus() == SuburConstant.STATUS_PUBLISHED_ITEM)
			suburItem.setPublishedDate(new Date());
		
		//only show item with published status
		boolean visible = false;
		String itemDescription = null;
		String summary = null;
		String url = null;
		String layoutUuid = null;
		Date publishedDate = suburItem.getPublishedDate();
		suburItem.getMetadataValue();
		
		itemDescription = suburItem.getTitle();
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                groupId, suburItem.getCreateDate(),
                suburItem.getModifiedDate(), SuburItem.class.getName(),
                suburItem.getItemId(), suburItem.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), visible, null, null, null,
                ContentTypes.TEXT_HTML, suburItem.getTitle(), itemDescription, summary, url,
                layoutUuid, 0, 0, null, false);
		
		
		
		if (suburItem.isDraft() || suburItem.isPending())
		{
			
		}else
		{
			suburItem.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		
		
		
		//if status is published, ensure to update asset entry published date
		if (Validator.isNull(assetEntry.getPublishDate()) && suburItem.getStatus() == WorkflowConstants.STATUS_APPROVED)
			assetEntryLocalService.updateEntry(
					SuburItem.class.getName(), suburItem.getItemId(), suburItem.getPublishedDate(),
					true);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		ItemAuthorLocalServiceUtil.setItemAuthor(suburItem.getItemId(), authorIds);
		AuthorLocalServiceUtil.updateAuthorPosting(suburItem);
		
		resourceLocalService.addResources(serviceContext.getCompanyId(), groupId, userId,
			       SuburItem.class.getName(), suburItem.getItemId(), false, true, true);
		
		
		
		ItemItemTypeLocalServiceUtil.updateItemItemType(suburItem.getItemId(),itemTypeIds);
		
		
		//workflow
		WorkflowDefinitionLink workflowDefinitionLink=null;
		workflowDefinitionLink=WorkflowDefinitionLinkLocalServiceUtil.getDefaultWorkflowDefinitionLink(suburItem.getCompanyId(), SuburItem.class.getName(), 0, 0);
		
		serviceContext.setAttribute("trackbacks", null);
		
		
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
						suburItem.getCompanyId(), suburItem.getGroupId(), userId,
						SuburItem.class.getName(), suburItem.getItemId(), suburItem,
						serviceContext);
		
		
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);
		
		if (serviceContext.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH)
		{
			suburItem.setStatus(WorkflowConstants.STATUS_PENDING);
			JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

			extraDataJSONObject.put("title", suburItem.getTitle());
			if (suburItem.getCompleted())
			{
				SocialActivityLocalServiceUtil.addActivity(
						userId, suburItem.getGroupId(), SuburItem.class.getName(),
						suburItem.getItemId(), SuburActivityKeys.UPDATE_SUBUR_PUBLICATION,
						extraDataJSONObject.toString(), 0);
				
				
			} else
			{
				SocialActivityLocalServiceUtil.addActivity(
						userId, suburItem.getGroupId(), SuburItem.class.getName(),
						suburItem.getItemId(), SuburActivityKeys.ADD_SUBUR_PUBLICATION,
						extraDataJSONObject.toString(), 0);
				
				suburItem.setCompleted(true);
			}
		}
		
		indexer.reindex(suburItem);
		suburItem.setExpandoBridgeAttributes(serviceContext);
		

		
		
		//updateStatus(suburItem.getItemId(),userId,newStatus,serviceContext);
		return suburItemPersistence.update(suburItem);
		
	}
	
	public void deleteItem(long itemId)
	{
		SuburItem suburItem;
		try {
			suburItem = suburItemPersistence.findByPrimaryKey(itemId);
			suburItemLocalService.deleteSuburItem(suburItem);

		} catch (NoSuchItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteItem(SuburItem suburItem) throws SystemException, PortalException
	{
		
		
		resourceLocalService.deleteResource(suburItem.getCompanyId(),SuburItem.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL,suburItem.getItemId());
		
		List<ItemItemType> itemTypes = ItemItemTypeLocalServiceUtil.getByItemId(suburItem.getItemId());
		for (ItemItemType iType : itemTypes)
		{
			itemItemTypePersistence.remove(iType);
			ItemTypeLocalServiceUtil.decrementCounter(iType.getItemTypeId());
			
		}
		AuthorLocalServiceUtil.deleteItem(suburItem.getItemId());
		// Asset

		assetEntryLocalService.deleteEntry(
			SuburItem.class.getName(), suburItem.getItemId());
		
		

		suburItemPersistence.remove(suburItem);
		
		
		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			SuburItem.class);

		indexer.delete(suburItem);
				
				
	}
	
	public List getItemTypes(long itemId)
	{
		List itemList =  SuburItemFinderUtil.getItemTypes(itemId);// .getItemTypes(itemId);
		List itemType = (List)itemList.get(0);
		return itemType;
		
	}
	public List<SuburItem> getByGroupAndStatus(long companyId,long groupId,int status,int start,int end) throws SystemException
	{
		
		if (status != SuburConstant.STATUS_ANY)
			return suburItemPersistence.findByGroupStatus(companyId, groupId, status, start, end);// .findByStatusByGroup(status,groupId,companyId,start,end);
		else
			return suburItemPersistence.filterFindByGroupId(groupId, start, end);
	}
	public List<SuburItem> getSuburItems(int start,int end,int status) throws SystemException
	{
		if (status != SuburConstant.STATUS_ANY)
			return suburItemPersistence.findByStatus(status,start,end);
		else
			return suburItemPersistence.findAll(start, end);
	}
	/**
	 * Publish a subur item
	 * @param itemId subur Item Id
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public SuburItem publishItem(long itemId) throws SystemException, PortalException
	{
		SuburItem suburItem = suburItemPersistence.fetchByPrimaryKey(itemId);
		suburItem.setStatus(SuburConstant.STATUS_PUBLISHED_ITEM);
		suburItem.setPublishedDate(new Date());
		assetEntryLocalService.updateEntry(
				SuburItem.class.getName(), suburItem.getItemId(), suburItem.getPublishedDate(),
				true);
		return suburItemPersistence.update(suburItem);
	}
	public SuburItem updateStatus(long userId,long itemId,int status,ServiceContext serviceContext) throws SystemException, PortalException
	{
		Date now = new Date();
		SuburItem item = suburItemPersistence.findByPrimaryKey(itemId);
		
		int oldStatus = item.getStatus();
		if (oldStatus == status)
			return item;
				
		item.setStatus(status);
		item.setStatusByUserId(userId);
		item.setStatusDate(now);
		item.setModifiedDate(now);
		
		
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				SuburItem.class.getName(), itemId);
		
		JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();

		extraDataJSONObject.put("title", item.getTitle());
		
		if (status == WorkflowConstants.STATUS_APPROVED)
		{
			// Asset
			
			assetEntryLocalService.updateEntry(
				SuburItem.class.getName(), itemId, now,
				true);
			
			//increment approved item type count
			if (!item.getCounted())
			{
				List<ItemType> itemItemTypes = getItemTypes(item.getItemId());
				
				for (ItemType iType: itemItemTypes)
				{
					itemTypeLocalService.incrementApprovedCount(iType.getItemTypeId());
				}
				item.setCounted(true);
				
			}
			
			if (oldStatus != WorkflowConstants.STATUS_IN_TRASH) 
			{

				//social activity
				if (serviceContext.isCommandUpdate()) {
					SocialActivityLocalServiceUtil.addActivity(
						userId, item.getGroupId(),
						SuburItem.class.getName(), itemId,
						SuburActivityKeys.UPDATE_SUBUR_PUBLICATION,
						extraDataJSONObject.toString(), 0);
				}
				else {
					SocialActivityLocalServiceUtil.addUniqueActivity(
						userId, item.getGroupId(),
						SuburItem.class.getName(), itemId,
						SuburActivityKeys.ADD_SUBUR_PUBLICATION,
						extraDataJSONObject.toString(), 0);
				}
				
				// Subscriptions

				notifySubscribers(item, serviceContext);

				// Ping

			}
			
		}else  //not approved
		{
			//asset
			assetEntryLocalService.updateVisible(
					SuburItem.class.getName(), itemId, false);
			
			
		}
		suburItemPersistence.update(item);
		return item;
		
	}
	protected void notifySubscribers(
			SuburItem item, ServiceContext serviceContext)
		throws SystemException, PortalException {

		if (!item.isApproved()) 
		{
			return;
		}

		String layoutFullURL = serviceContext.getLayoutFullURL();

		if (Validator.isNull(layoutFullURL)) 
		{
			return;
		}

		PortletPreferences preferences =
			ServiceContextUtil.getPortletPreferences(serviceContext);

		if (preferences == null) {
			long ownerId = item.getGroupId();
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
			long plid = PortletKeys.PREFS_PLID_SHARED;
			String portletId = PortletKeys.SUBUR;
			String defaultPreferences = null;

			preferences = PortletPreferencesLocalServiceUtil.getPreferences(
				item.getCompanyId(), ownerId, ownerType, plid, portletId,
				defaultPreferences);
		}

		if (serviceContext.isCommandAdd() &&
			SuburUtil.getEmailEntryAddedEnabled(preferences)) {
		}
		else if (serviceContext.isCommandUpdate() &&
				 SuburUtil.getEmailEntryUpdatedEnabled(preferences)) {
		}
		else {
			return;
		}

		String entryURL = SuburURLUtil.getItemViewURL(serviceContext.getThemeDisplay(), item.getItemId());
		
		

		String fromName = SuburUtil.getEmailFromName(
			preferences, item.getCompanyId());
		
		String fromAddress = SuburUtil.getEmailFromAddress(
			preferences, item.getCompanyId());

		Map<Locale, String> localizedSubjectMap = null;
		Map<Locale, String> localizedBodyMap = null;

		if (serviceContext.isCommandUpdate()) {
			localizedSubjectMap = SuburUtil.getEmailEntryUpdatedSubjectMap(
				preferences);
			localizedBodyMap = SuburUtil.getEmailEntryUpdatedBodyMap(
				preferences);
		}
		else {
			localizedSubjectMap = SuburUtil.getEmailEntryAddedSubjectMap(
				preferences);
			localizedBodyMap = SuburUtil.getEmailEntryAddedBodyMap(preferences);
		}

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setCompanyId(item.getCompanyId());
		subscriptionSender.setContextAttributes(
			"[$SUBUR_PUBLICATION_STATUS_BY_USER_NAME$]", item.getUserId(),
			"[$SUBUR_PUBLICATION_URL$]", entryURL);
		
		subscriptionSender.setContextUserPrefix("SUBUR_PUBLICATION");
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setLocalizedBodyMap(localizedBodyMap);
		subscriptionSender.setLocalizedSubjectMap(localizedSubjectMap);
		subscriptionSender.setMailId("subur_publication", item.getItemId());
		subscriptionSender.setPortletId(PortletKeys.BLOGS);
		subscriptionSender.setReplyToAddress(fromAddress);
		subscriptionSender.setScopeGroupId(item.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setUserId(item.getUserId());

		subscriptionSender.addPersistedSubscribers(
			SuburItem.class.getName(), item.getGroupId());

		subscriptionSender.addPersistedSubscribers(
			SuburItem.class.getName(), item.getItemId());

		subscriptionSender.flushNotificationsAsync();
	}
	
	/**
	 * Withdraw item from public viewing
	 * @param itemId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public SuburItem withDrawItem(long itemId) throws SystemException, PortalException
	{
		SuburItem suburItem = suburItemPersistence.fetchByPrimaryKey(itemId);
		suburItem.setStatus(SuburConstant.STATUS_WITHDRAWN_ITEM);
		assetEntryLocalService.updateEntry(
				SuburItem.class.getName(), suburItem.getItemId(), null,
				false);
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                SuburItem.class);

		indexer.reindex(suburItem);
		return suburItemPersistence.update(suburItem);
	}
	
	public int getItemCount(int status) throws SystemException
	{
		if (status != SuburConstant.STATUS_ANY)
			return suburItemPersistence.countByStatus(SuburConstant.STATUS_DRAFT_ITEM);
		else
			return suburItemPersistence.countAll();
	}
	
	public List<SuburItem> getByGroup(long groupId) throws SystemException
	{
		return suburItemPersistence.findByGroupId(groupId);
	}
	
		
	public int countAssetVocabularyById(long vocabularyId) throws SystemException
	{
		return AssetCategoryUtil.countByVocabularyId(vocabularyId);
	}
	public int getEntriesCount(AssetEntryQuery entryQuery,long[] anyItemTypeIds,long[] allItemTypeIds) throws SystemException
	{
		return SuburItemFinderUtil.countEntries(entryQuery,anyItemTypeIds,allItemTypeIds);
	}
	public List<AssetEntry> getAssetEntries(AssetEntryQuery entryQuery,long[] anyItemTypeIds,long[] allItemTypeIds) throws SystemException
	{
		return SuburItemFinderUtil.findAssetEntries(entryQuery,anyItemTypeIds,allItemTypeIds);
	}
	/**
	 * Add download info for the Item
	 */
	public void addDownloadStats(long itemId) throws SystemException, PortalException
	{
		
		DownloadSummaryLocalServiceUtil.addStats(itemId);
		
	}
	/**
	 * Add view stats info the Item and increment Asset Entry view counter
	 * @param itemId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void addViewStat(long itemId,long companyId,long groupId) throws PortalException, SystemException
	{
		AssetEntry incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(SuburItem.class.getName(), itemId);
		
		ViewSummaryLocalServiceUtil.addStats(itemId,companyId,groupId);//, itemTypeIds, categoryIds, tagIds);
		
		
	}
	
	public void subscribe(long userId, long groupId)
			throws PortalException, SystemException 
	{
		SubscriptionLocalServiceUtil.addSubscription(userId, groupId, 
				SuburItem.class.getName(), groupId);
		
	}
	public void unsubscribe(long userId, long groupId)
			throws PortalException, SystemException {

		SubscriptionLocalServiceUtil.deleteSubscription(
				userId, SuburItem.class.getName(), groupId);
		}
}