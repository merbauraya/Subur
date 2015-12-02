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

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.NoSuchAuthorException;
import com.idetronic.subur.NoSuchConfigException;
import com.idetronic.subur.actionhelper.SuburActionHelper;
import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.AuthorExpertise;
import com.idetronic.subur.model.AuthorResearchInterest;
import com.idetronic.subur.model.AuthorSite;
import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.model.ItemAuthor;
import com.idetronic.subur.model.ResearchInterest;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorExpertiseLocalServiceUtil;
import com.idetronic.subur.service.AuthorResearchInterestLocalServiceUtil;
import com.idetronic.subur.service.AuthorSiteLocalServiceUtil;
import com.idetronic.subur.service.ExpertiseLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ResearchInterestLocalServiceUtil;
import com.idetronic.subur.service.base.AuthorLocalServiceBaseImpl;
import com.idetronic.subur.service.persistence.AuthorExpertisePK;
import com.idetronic.subur.service.persistence.AuthorFinderUtil;
import com.idetronic.subur.service.persistence.AuthorQuery;
import com.idetronic.subur.service.persistence.AuthorResearchInterestPK;
import com.idetronic.subur.service.persistence.SuburItemFinderUtil;
import com.idetronic.subur.util.AuthorQueryUtil;
import com.idetronic.subur.util.SuburConfiguration;
import com.idetronic.subur.util.SuburConstant;
import com.idetronic.subur.util.SuburFolderUtil;
import com.idetronic.subur.util.WebKeys;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Image;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.documentlibrary.ImageSizeException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.service.AuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mazlan Mat
 * @see com.idetronic.subur.service.base.AuthorLocalServiceBaseImpl
 * @see com.idetronic.subur.service.AuthorLocalServiceUtil
 */
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.idetronic.subur.service.AuthorLocalServiceUtil} to access the author local service.
	 */
	private static Log logger = LogFactoryUtil.getLog(AuthorLocalServiceImpl.class);
	
	/**
	 * 
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
	public Author newAuthor(String firstName,String middleName,String lastName,
			String salutation,String email,String officeNo,ServiceContext serviceContext) throws SystemException
	{
		Date now = new Date(); 
		long authorId = CounterLocalServiceUtil.increment(Author.class.getName());
		Author author = authorPersistence.create(authorId);
		author.setFirstName(firstName);
		author.setMiddleName(middleName);
		author.setLastName(lastName);
		author.setEmail(email);
		author.setOfficeNo(officeNo);
		author.setCompanyId(serviceContext.getCompanyId());
		author.setGroupId(serviceContext.getScopeGroupId());
		author.setCreateDate(now);
		author.setModifiedDate(now);
		author.setCreatedBy(serviceContext.getUserId());
		author.setUuid(PortalUUIDUtil.generate());
		
		return authorPersistence.update(author);
		
	}
	
	
	public long addAuthor(String firstName,String middleName,String lastName,String salutation,
			String email,String officeNo,
			Map<String,String> authorSite,
			String remoteId,int idType,
			long userId, long groupId,long createdByUserId,
			String[] expertiseNames,String[] researchInterestNames,
			ServiceContext serviceContext) throws SystemException, PortalException,IOException
	{
		
		User user = userLocalService.getUserById(userId);
		
		Date now = new Date();
		long authorId = CounterLocalServiceUtil.increment(Author.class.getName());
		Author author = authorPersistence.create(authorId);
		author.setFirstName(firstName);
		author.setMiddleName(middleName);
		author.setLastName(lastName);
		author.setSalutation(salutation);
		author.setEmail(email);
		author.setOfficeNo(officeNo);
		
	//	author.setRemoteId(remoteId);
//		author.setIdType(idType);
		author.setCompanyId(user.getCompanyId());
		author.setGroupId(groupId);
		author.setCreateDate(now);
		author.setModifiedDate(now);
		author.setUuid(PortalUUIDUtil.generate());
		author.setCreatedBy(createdByUserId);
		//author.setPersonalSite(personalSite);
		
		logger.info("author creted:"+authorId);
		
		
		
		author.setItemCount(0);
		
		
		if (expertiseNames != null)
		{
			long siteGroupId = PortalUtil.getSiteGroupId(groupId);
			Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);
			
			List<Expertise> expertises = ExpertiseLocalServiceUtil.checkExpertises(userId, siteGroup, expertiseNames);
			
			for (Expertise expertise : expertises)
			{
				expertiseLocalService.incrementAuthorCount(expertise.getExpertiseId());
			}
			setExpertises(authorId,expertises);
		}
		
		if (researchInterestNames != null)
		{
			long siteGroupId = PortalUtil.getSiteGroupId(groupId);
			Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);
			
			List<ResearchInterest> researchInterests = ResearchInterestLocalServiceUtil.checkResearchInterests(userId, siteGroup, researchInterestNames);
			
			for (ResearchInterest researchInterest : researchInterests)
			{
				researchInterestLocalService.incrementAuthorCount(researchInterest.getResearchInterestId());
			}
			setResearchInterests(authorId,researchInterests);
		}
		
		updateAuthorSite(authorId,authorSite);
		
		//long coverPhotoId = attachCoverPhoto(author,serviceContext);
		
		//author.setCoverPhotoId(coverPhotoId);
		
		authorPersistence.update(author);
		
		
		
		
		
		AssetEntry assetEntry = updateAssetEntry(createdByUserId,groupId,
				author, serviceContext);
		
		
		
		resourceLocalService.addResources(author.getCompanyId(), author.getGroupId(),
				createdByUserId,Author.class.getName(),author.getAuthorId(),
				false,true,true);
		/*
		addResource(author.getCompanyId(),author.getGroupId(),
				createdByUserId,author.getAuthorId());
		*/
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Author.class);
		
		indexer.reindex(author);
		return authorId;
		
	}
	private void addResource(long companyId,long groupId,long createdBy,long authorId)
	{
		try {
			ResourceLocalServiceUtil.addResources(companyId, groupId, 
					createdBy, Author.class.getName(), authorId, 
					false, true, true);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void setExpertises(long authorId, List<Expertise> expertises) throws SystemException
	{
		//remove existing/old expertises , if any
		authorExpertisePersistence.removeByAuthor(authorId);
		
		for (Expertise expertise : expertises)
		{
			AuthorExpertisePK pk = new AuthorExpertisePK();
			pk.setAuthorId(authorId);
			pk.setExpertiseId(expertise.getExpertiseId());
			AuthorExpertise authorExpertise = AuthorExpertiseLocalServiceUtil.createAuthorExpertise(pk);
			AuthorExpertiseLocalServiceUtil.updateAuthorExpertise(authorExpertise);
			
		}
		
	}
	public void setResearchInterests(long authorId, List<ResearchInterest> researchInterests) throws SystemException
	{
		//remove existing/old expertises , if any
		authorResearchInterestPersistence.removeByAuthor(authorId);
		
		for (ResearchInterest researchInterest : researchInterests)
		{
			AuthorResearchInterestPK pk = new AuthorResearchInterestPK();
			pk.setAuthorId(authorId);
			pk.setResearchInterestId(researchInterest.getResearchInterestId());
			AuthorResearchInterest authorResearchInterest = AuthorResearchInterestLocalServiceUtil.createAuthorResearchInterest(pk);
			AuthorResearchInterestLocalServiceUtil.updateAuthorResearchInterest(authorResearchInterest);
			
		}
		
	}
	/**
	 * Update existing author, throw Exception if author not found or update fails
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
	public Author updateAuthor(long authorId,String salutation,String firstName,String middleName,
				String lastName,String email,String officeNo,
				Map<String,String> authorSite,
				String title,
				long userId, long groupId,
				long createdByUserId,
				String[] expertiseNames, String[] researchInterestNames,
				ServiceContext serviceContext) throws SystemException, PortalException,IOException
	{
		Author author = authorPersistence.fetchByPrimaryKey(authorId);
		author.setSalutation(salutation);
		author.setMiddleName(middleName);
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setEmail(email);
		author.setOfficeNo(officeNo);
		author.setTitle(title);
		
		
		
		
		
		if (expertiseNames != null)
		{
			long siteGroupId = PortalUtil.getSiteGroupId(groupId);
			Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);
			
			//get existing author expertise and decrement the count
			List<Expertise> oldExpertises = getExpertises(authorId);
			List<Expertise> newExpertises = ExpertiseLocalServiceUtil.checkExpertises(userId, siteGroup, expertiseNames);

			
			for (Expertise expertise: oldExpertises)
			{
				if (!newExpertises.contains(expertise))
					expertiseLocalService.decrementAuthorCount(expertise.getExpertiseId());
				
					
			}
			
			for (Expertise expertise: newExpertises)
			{
				if (!oldExpertises.contains(expertise))
					expertiseLocalService.incrementAuthorCount(expertise.getExpertiseId());
			}
			
			
			setExpertises(authorId,newExpertises);
		}
		
		if (researchInterestNames != null)
		{
			long siteGroupId = PortalUtil.getSiteGroupId(groupId);
			Group siteGroup = GroupLocalServiceUtil.getGroup(siteGroupId);
			
			//get existing author expertise and decrement the count
			List<ResearchInterest> oldResearchInterests = getResearchInterests(authorId);
			List<ResearchInterest> newResearchInterests = ResearchInterestLocalServiceUtil.checkResearchInterests(userId, siteGroup, researchInterestNames);

			
			for (ResearchInterest researchInterest: oldResearchInterests)
			{
				if (!newResearchInterests.contains(researchInterest))
					researchInterestLocalService.decrementAuthorCount(researchInterest.getResearchInterestId());
				
					
			}
			
			for (ResearchInterest researchInterest: newResearchInterests)
			{
				if (!oldResearchInterests.contains(researchInterest))
					researchInterestLocalService.incrementAuthorCount(researchInterest.getResearchInterestId());
			}
			
			
			setResearchInterests(authorId,newResearchInterests);
		}
		
		
		//author Site
		updateAuthorSite(authorId,authorSite);
		
		
		
		
		
		authorPersistence.update(author);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(),
                serviceContext.getScopeGroupId(), author.getDisplayName(), author.getAuthorId(),
                serviceContext.getGroupPermissions(),
                serviceContext.getGuestPermissions());
		
		AssetEntry assetEntry = updateAssetEntry(createdByUserId,groupId,
				author, serviceContext);
		
		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                AssetLinkConstants.TYPE_RELATED);
		
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
                Author.class);
		
		indexer.reindex(author);
		
		return author;

	}
	
	private AssetEntry updateAssetEntry(long userId,long groupId,
				Author author,ServiceContext serviceContext) throws PortalException, SystemException
	{
		boolean visible = true;
		String itemDescription = StringPool.BLANK;
		String summary = StringPool.BLANK;
		String url = StringPool.BLANK;
		String layoutUuid = StringPool.BLANK;
		
		
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.updateEntry(userId,
                groupId, author.getCreateDate(),
                author.getModifiedDate(), Author.class.getName(),
                author.getAuthorId(), author.getUuid(), 0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), visible, null, null, null,
                ContentTypes.TEXT_HTML, author.getDisplayName(), itemDescription, summary, url,
                layoutUuid, 0, 0, null, false);
		
		return assetEntry;
	}
	/**
	 * Find all item under a given author
	 * @param groupId
	 * @param authorId
	 * @param start
	 * @param end
	 * @param status Item status
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	@Override
	public List<SuburItem> getItemByAuthorGroup(long groupId,long authorId,
			int start, int end, int status, OrderByComparator obc) throws SystemException
			
	{
		
		return SuburItemFinderUtil.findByAuthorGroup(groupId, authorId, start, end, status, obc);
	
	}
	/**
	 * Create/update author site
	 * @param authorId to be updated
	 * @param authorSiteMap of Author site
	 * @throws SystemException 
	 * @throws IOException 
	 * @throws PortalException 
	 */
	private void updateAuthorSite(long authorId,Map<String,String> authorSiteMap) throws SystemException, IOException, PortalException
	{
		//AuthorSite authorSite = null;
		List<AuthorSite> authorSites = AuthorSiteLocalServiceUtil.findByAuthorId(authorId);
		
		//
		//String authorSiteString = SuburConfiguration.getConfig(SuburConfiguration.AUTHOR_SITES);
		//String[] authorSiteConfig = StringUtil.split(authorSiteString);
		
		//AuthorSiteLocalServiceUtil.deleteByAuthorId(authorId);
		
		//update existing if matches
		logger.info("size="+authorSiteMap.size());
		for (Map.Entry<String, String> entry : authorSiteMap.entrySet()) 
		{
			String siteName = entry.getKey();
		    String siteURL = entry.getValue();
		    boolean exists = false;
		    for (AuthorSite authorSite : authorSites)
		    {
		    	if (authorSite.getSiteName().equalsIgnoreCase(siteName))
		    	{
		    		authorSite.setSiteURL(siteURL);
		    		AuthorSiteLocalServiceUtil.updateAuthorSite(authorSite);
		    		exists = true;
		    	}
		    }
		    if (!exists) //create if not exists
		    {
		    	logger.info("new="+siteName + "-"+siteURL);
		    	AuthorSiteLocalServiceUtil.addAuthorSite(authorId,siteName,siteURL);
		    }
		}
		
		//delete existing entry if does not match with new ones
		
		for (AuthorSite authorSite : authorSites)
		{
			boolean match = false;
			for (Map.Entry<String, String> entry : authorSiteMap.entrySet()) 
			{
				String siteName = entry.getKey();
				if (siteName.equalsIgnoreCase(authorSite.getSiteName()))
				{
					match = true;
					break;
				}
			}
			if (!match)
			{
				logger.info("not match="+authorSite.getSiteName());
				AuthorSiteLocalServiceUtil.deleteAuthorSite(authorSite);
			}
		}
		
		
		
		
		
		    
		    
		    
		    
		
		
		
		//
		
	}
	/**
	 * Find and return all associated expertise for the author
	 * @param authorId to seearch for
	 * @return List of Expertise
	 * @throws SystemException
	 */
	public List<Expertise> getExpertises(long authorId) throws SystemException
	{
		List<AuthorExpertise> authorExpertises = authorExpertisePersistence.findByAuthor(authorId);
		List<Expertise> expertises = new ArrayList<Expertise>(authorExpertises.size());
		
		for (AuthorExpertise authorExpertise: authorExpertises)
		{
			Expertise expertise = expertisePersistence.fetchByPrimaryKey(authorExpertise.getExpertiseId());
			expertises.add(expertise);
		}
		return expertises;
		
		
	}
	public List<ResearchInterest> getResearchInterests(long authorId) throws SystemException
	{
		List<AuthorResearchInterest> authorResearchInterests = authorResearchInterestPersistence.findByAuthor(authorId);
		List<ResearchInterest> researchInterests = new ArrayList<ResearchInterest>(authorResearchInterests.size());
		
		for (AuthorResearchInterest authorResearchInterest: authorResearchInterests)
		{
			ResearchInterest researchInterest = researchInterestPersistence.fetchByPrimaryKey(authorResearchInterest.getResearchInterestId());
			researchInterests.add(researchInterest);
		}
		return researchInterests;
	}
	
	/**
	 * Update author latest posting
	 * @param suburItem
	 * @throws SystemException
	 */
	public void updateAuthorPosting(SuburItem suburItem,int oldStatus,int newStatus) throws SystemException
	{
		
		if (oldStatus == newStatus)
		{
			return;
		}
		
		long[] authors = ItemAuthorLocalServiceUtil.getAuthorId(suburItem.getItemId());
		
		if (newStatus == WorkflowConstants.STATUS_APPROVED)
		{
			for (long authorId : authors)
			{
				updateNewPosting(authorId,suburItem.getPublishedDate());
			}
		}
		
		//from approved to other, we decrement author count
		if (oldStatus == WorkflowConstants.STATUS_APPROVED)
		{
			for (long authorId : authors)
			{
				decrementItemCount(authorId);
			}
		}
		
		
	}
	
	/**
	 * Increment item count and last posted date for an author
	 * Usually called during new item creation
	 * @param authorId
	 * @return new item count for the author
	 * @throws SystemException if author cannot be found or fail during update
	 */
	public int updateNewPosting(long authorId,Date newPostDate) throws SystemException
	{
		
		
		Author author = authorPersistence.fetchByPrimaryKey(authorId);
		int newCount = author.getItemCount() + 1;
		author.setItemCount(newCount);
		author.setLastPublishedDate(newPostDate);
		authorPersistence.update(author);
		return newCount;
	}
	/**
	 * Return all authors with the primary keys
	 * @param authorIds the primary key of the author
	 * @return authors with primary key
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Author> getAuthors(long[] authorIds) throws PortalException, SystemException  {
		List<Author> authors = new ArrayList<Author>(authorIds.length);
		for (long authorId : authorIds)
		{
			Author author = getAuthor(authorId);
			authors.add(author);
		}
		return authors;
	}
	/**
	 * Update all author with up to date item count
	 * @param companyId
	 * @param groupId
	 */
	public void updateAllItemCount(long companyId,long groupId)
	{
		List authorItemCounts = AuthorFinderUtil.getItemCountByGroupCompanyScalar(companyId, groupId);
		String serilizeString = null;
		JSONArray authorJsonArray = null;
		
		for (Object elemObject : authorItemCounts)
		{
			serilizeString = JSONFactoryUtil.serialize(elemObject);
			try {
				authorJsonArray = JSONFactoryUtil.createJSONArray(serilizeString);
				long authorId = authorJsonArray.getLong(0);
				int itemCount = authorJsonArray.getInt(1);
				Author author = authorPersistence.fetchByPrimaryKey(authorId);
				author.setItemCount(itemCount);
				authorPersistence.update(author);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Decrement item count for the author
	 */
	public void decrementItemCount(long authorId) throws SystemException
	{
		Author author;
		try {
			author = authorPersistence.findByPrimaryKey(authorId);
			int newItemCount = author.getItemCount() -1;
			author.setItemCount(newItemCount);
			authorPersistence.update(author);
			
		} catch (NoSuchAuthorException e) {
			logger.warn(e);
		}
		
	}
	/**
	 * 
	 */
	public int getSearchCount(String keyword,long companyId,long groupId) throws SystemException
	{
		
		if (Validator.isNotNull(keyword) || Validator.isBlank(keyword))
			return authorPersistence.countByCompanyGroup(companyId,groupId);//, companyId);//
		else
			return AuthorFinderUtil.getTotalByName(keyword, companyId, groupId);
	}
	
	public int getSearchCount(String keyword,long companyId,long groupId,
			String firstName, String lastName,
			boolean isAdvancedSearch,boolean isAndOperator,
			int start, int end, OrderByComparator obc)
	{
		try {
			return AuthorFinderUtil.countByFistNameLastName(companyId, groupId, firstName, lastName, isAndOperator, start, end, obc);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public List<SuburItem> getSuburItems(long authorId,int start,int end,OrderByComparator obc)
	{
		return null;
	}
	
	
	public List<Author> search(String keyword,long companyId,long groupId,
			String firstName, String lastName,
			boolean isAdvancedSearch,boolean isAndOperator,
			int start, int end, OrderByComparator obc) throws SystemException
	{
		String[] keywords = null;
		
		boolean matchAll;
		if (isAdvancedSearch)
		{
			return advanceSearch(keyword,companyId,groupId,
			firstName,lastName,isAndOperator, start, end,  obc);
			
			
		}else
		{
		
			if (Validator.isNotNull(keyword) && !Validator.isBlank(keyword))
				keywords = CustomSQLUtil.keywords(keyword);
			else
			{
				return authorPersistence.findAll(start, end, obc);
			}
				
			try {
				return AuthorFinderUtil.findByName(keyword, companyId,groupId,start, end, obc);
				//return AuthorFinderUtil.findByFirstName(keywords,new LinkedHashMap<String, Object>(), start, end, obc);
			} catch (SystemException e) {
				
				
				throw new SystemException(e);
			}
		}
	}
	
	/**
	 * Perform advance search
	 * @param keyword
	 * @param companyId
	 * @param groupId
	 * @param firstName
	 * @param lastName
	 * @param isAndOperator
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	private List<Author> advanceSearch(String keyword,long companyId,long groupId,
			String firstName,String lastName,boolean isAndOperator,
			int start, int end, OrderByComparator obc) throws SystemException
	{
		
		
		return AuthorFinderUtil.findByFistNameLastName(companyId, groupId, 
				firstName, lastName, isAndOperator, start, end, obc);
		
	}
	
	/**
	 * 
	 */
	
	
	public List<Author> search(String keyword,long companyId,long groupId,
			int start, int end, OrderByComparator obc) throws SystemException
	{
		String[] keywords = null;
		if (Validator.isNotNull(keyword) && !Validator.isBlank(keyword))
			keywords = CustomSQLUtil.keywords(keyword);
		else
		{
			return authorPersistence.findAll(start, end, obc);
		}
			
		try {
			return AuthorFinderUtil.findByName(keyword, companyId,groupId,start, end, obc);
			//return AuthorFinderUtil.findByFirstName(keywords,new LinkedHashMap<String, Object>(), start, end, obc);
		} catch (SystemException e) {
			
			
			throw new SystemException(e);
		}
		
	}
	public List<Author> findByGroupCompany(long companyId,long groupId,int start,int end)
	{
		return AuthorFinderUtil.findByCompanyGroup(companyId,groupId,start,end);
	}
	public List<Author> recentByGroup(long companyId, long groupId,Date lastPublishedDate, int start,int end) throws SystemException
	{
		return AuthorFinderUtil.recentByGroupIds(companyId, groupId, lastPublishedDate, start, end);
	}
	public void deleteItem(long itemId) throws SystemException
	{
		List<ItemAuthor> itemAuthors = itemAuthorPersistence.findByitemId(itemId);
		for (ItemAuthor itemAuthor : itemAuthors)
		{
			decrementItemCount(itemAuthor.getAuthorId());
		}
	}
	public Author updatePortrait(long authorId, byte[] bytes)
			throws PortalException, SystemException 
	{

			Author author = authorPersistence.findByPrimaryKey(authorId);

			long imageMaxSize = Long.valueOf(PortletProps.get("author.image.max.size"));

			if ((imageMaxSize > 0) &&
				((bytes == null) || (bytes.length > imageMaxSize))) {

				throw new UserPortraitSizeException();
			}

			long portraitId = author.getPortraitId();

			if (portraitId <= 0) {
				portraitId = counterLocalService.increment();

				author.setPortraitId(portraitId);
			}

			try {
				ImageBag imageBag = ImageToolUtil.read(bytes);

				RenderedImage renderedImage = imageBag.getRenderedImage();

				if (renderedImage == null) {
					throw new UserPortraitTypeException();
				}
				int maxHeight = Integer.valueOf(PortletProps.get("author.image.max.height"));
				int maxWidth = Integer.valueOf(PortletProps.get("author.image.max.width"));
				renderedImage = ImageToolUtil.scale(
					renderedImage, maxHeight,
					maxWidth);

				String contentType = imageBag.getType();

				imageLocalService.updateImage(
					portraitId,
					ImageToolUtil.getBytes(renderedImage, contentType));
			}
			catch (IOException ioe) {
				throw new ImageSizeException(ioe);
			}
			authorPersistence.update(author);
			

			return author;
		}
	public long[] createAuthor(JSONArray authors,ServiceContext serviceContext) throws SystemException
	{
		long[] authorIds = new long[authors.length()];
		for (int i = 0; i < authors.length(); i ++)
		{
			JSONObject jsonObj = authors.getJSONObject(i);
			String firstName = jsonObj.getString("firstName");
			String lastName = jsonObj.getString("lastName");
			Author author = newAuthor(firstName,null,lastName,
					null,null,null, serviceContext);
			
			authorIds[i] = author.getAuthorId();
			
		}
		return authorIds;
	}
	private static Log LOGGER = LogFactoryUtil.getLog(AuthorLocalServiceImpl.class);
	
}