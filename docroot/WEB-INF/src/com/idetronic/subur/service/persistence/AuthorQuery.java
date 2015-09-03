package com.idetronic.subur.service.persistence;

import java.util.Date;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

public class AuthorQuery {
private AssetEntryQuery assetQuery = null;
	
	public AuthorQuery()
	{
		this.assetQuery = new AssetEntryQuery();
		
	}
	
	public AuthorQuery(AssetEntryQuery assetQuery)
	{
		this.assetQuery = assetQuery;
		
	}
	public void setAssetQuery(AssetEntryQuery assetQuery)
	{
		this.assetQuery = assetQuery; 
	}
	public String getTitle()
	{
		return assetQuery.getTitle();
	}
	
	
	public void setTitle(String title)
	{
		assetQuery.setTitle(title);
	}
	
	public long[] getAnyTagIds()
	{
		return assetQuery.getAllTagIds();
	}
	public long[] getAllTagIds()
	{
		return assetQuery.getAnyTagIds();
	}
	public long[] getAllCategoryIds()
	{
		return assetQuery.getAllCategoryIds();
	}
	public long[] getAnyCategoryIds()
	{
		return assetQuery.getAnyCategoryIds();
	}
	public String getAuthorFirstName()
	{
		return _authorFirstName;
	}
	public String getAuthorLastName()
	{
		return _authorLastName;
	}
	public void setFirstName(String name)
	{
		_authorLastName = name;
	}
	public void setLastName(String name)
	{
		_authorLastName = name;
	}
	public void setMiddleName(String name)
	{
		_middleName = name;
	}
	public String getMiddleName()
	{
		return _middleName;
	}
	public long[] getNotAllCategoryIds()
	{
		return assetQuery.getNotAllCategoryIds();
	}
	public long[] getNotAnyCategoryIds()
	{
		return assetQuery.getNotAnyCategoryIds();
	}
	public long[][] getAllTagIdsArray()
	{
		return assetQuery.getAllTagIdsArray();
	}
	public long[] getNotAllTagIds()
	{
		return assetQuery.getNotAllTagIds();
	}
	public long[][] getNotAllTagIdsArray()
	{
		return assetQuery.getNotAllTagIdsArray();
	}
	public long[] getNotAnyTagIds()
	{
		return assetQuery.getNotAnyTagIds();
	}
	
	public long[] getGroupIds()
	{
		return assetQuery.getGroupIds();
	}
	public long[] getClassNameIds()
	{
		return assetQuery.getClassNameIds();
	}
	public long[] getClassTypeIds()
	{
		return assetQuery.getClassTypeIds();
	}
	public String getDescription()
	{
		return assetQuery.getDescription();
	}
	public Layout getLayout()
	{
		return assetQuery.getLayout();
	}
	public boolean isVisible()
	{
		return assetQuery.isVisible();
	}
	public String getKeywords() {
		return assetQuery.getKeywords();
	}
	public int getStart()
	{
		return assetQuery.getStart();
	}
	public int getEnd()
	{
		return assetQuery.getEnd();
	}
	public String getOrderByCol1()
	{
		return assetQuery.getOrderByCol1();
	}
	public String getOrderByCol2()
	{
		return assetQuery.getOrderByCol2();
	}
	public String getOrderByType1()
	{
		return assetQuery.getOrderByType1();
	}
	
	public long getLinkedAssetEntryId()
	{
		return assetQuery.getLinkedAssetEntryId();
	}
	public String getOrderByType2()
	{
		return assetQuery.getOrderByType2();
	}
	
	
	public void setAnyTagIds(long[] anyTagIds) {
		assetQuery.setAnyTagIds(anyTagIds);
	}
	public void setAnyCategoryIds(long[] anyCategoryIds) {
		assetQuery.setAnyCategoryIds(anyCategoryIds);
	}
	public void setAllCategoryIds(long[] allCategoryIds) {
		assetQuery.setAllCategoryIds(allCategoryIds);
	}

	public void setAllTagIds(long[] allTagIds) {
		assetQuery.setAllTagIds(allTagIds);
	}

	public void setAllTagIdsArray(long[][] allTagIdsArray) {
		assetQuery.setAllTagIdsArray(allTagIdsArray);
	}
	
	
	public void setStart(int start) {
		assetQuery.setStart(start);
	}
	public void setKeywords(String keywords)
	{
		assetQuery.setKeywords(keywords);
	}
	public void setVisible(boolean visible)
	{
		assetQuery.setVisible(visible);
	}
	public void setGroupIds(long[] groupIds)
	{
		assetQuery.setGroupIds(groupIds);
	}
	public void setAnyExpertiseIds(long[] expertiseIds)
	{
		this._anyExpertiseIds = expertiseIds;
	}
	
	public long[] getAnyExpertiseId()
	{
		return this._anyExpertiseIds;
	}
	public void setAllExpertiseIds(long[] expertiseIds)
	{
		_allExpertiseIds = expertiseIds;
	}
	public long[] getAllExpertiseId()
	{
		return this._allExpertiseIds;
	}
	public void setAnyResearchInterestIds(long[] researchInterestIds)
	{
		this._anyResearchInterestIds = researchInterestIds;
	}
	public long[] getAnyResearchInterestId()
	{
		return this._anyResearchInterestIds;
	}
	public void setAllResearchInterestIds(long[] researchInterestId)
	{
		_allResearchInterestIds = researchInterestId;
	}
	public long[] getAllResearchInterestIds()
	{
		return _allResearchInterestIds;
	}
	
	public void setAnyCategoryIdString(String ids)
	{
		setAnyCategoryIds(StringUtil.split(ids, StringPool.COMMA, 0L));
	}
	public void setAllCategoryIdString(String ids)
	{
		setAllCategoryIds(StringUtil.split(ids, StringPool.COMMA, 0L));

	}
	public void setAnyExpertiseIdString(String ids)
	{
		setAnyExpertiseIds(StringUtil.split(ids, StringPool.COMMA, 0L));
		
	}
	public void setAllExpertiseIdString(String ids)
	{
		setAllExpertiseIds(StringUtil.split(ids, StringPool.COMMA, 0L));

	}
	public void setAnyResearchInterestIdString(String ids)
	{
		setAnyResearchInterestIds(StringUtil.split(ids, StringPool.COMMA, 0L));

	}
	public void setAllResearchInterestIdString(String ids)
	{
		setAllResearchInterestIds(StringUtil.split(ids, StringPool.COMMA, 0L));

	}
	private static Log _log = LogFactoryUtil.getLog(AuthorQuery.class);
	
	private long[] _anyExpertiseIds = new long[0];
	private long[] _anyResearchInterestIds = new long[0];
	private long[] _allExpertiseIds = new long[0];
	private long[] _allResearchInterestIds = new long[0];

	private String _authorFirstName = StringPool.BLANK;
	private String _authorLastName = StringPool.BLANK;
	private String _middleName = StringPool.BLANK;
	
	

	

}