package com.idetronic.subur.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.persistence.SuburItemQuery;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class SuburSearchUtil {
	
	private static Log _log = LogFactoryUtil.getLog(SuburSearchUtil.class);
	
	private static String keywords = StringPool.BLANK;
	private static String author =StringPool.BLANK;
	private static String title = StringPool.BLANK;
	private static String yearPublished = StringPool.BLANK;
	private static String monthPublished = StringPool.BLANK;
	private static String andOperator;
	private static boolean advanceSearch;
	private static boolean matchAllField;
	private static String authorFirstName;
	private static String authorLastName;
	private static long itemType;
	private static String viewCount;
	
	private static long[] anyTagIds = new long[0];
	private static long[] allTagIds = new long[0];
	private static long[] anyCategoryIds = new long[0];
	private static long[] allCategoryIds = new long[0];
	private static long[] allItemTypeIds = new long[0];
	private static long[] anyItemTypeIds = new long[0];
	private static boolean visible = true;
	
	
	
	
	private static SearchContext _searchContext = null;
	private static String className = SuburItem.class.getName();
	
	private static BooleanQuery fullQuery = null;
	
	//searchable field
	private static String[] SEARCH_FIELD_ARRAY  = 
		{SuburField.TITLE,
		SuburField.DESCRIPTION,/*item abstract */
		SuburField.AUTHOR,
		SuburField.AUTHOR_FIRST_NAME,
		SuburField.AUTHOR_LAST_NAME,
		SuburField.YEAR_PUBLISHED,
		SuburField.ITEM_TYPE,
		SuburField.ASSET_CATEGORY_IDS,
		SuburField.ASSET_TAG_NAMES,
		SuburField.VIEW_COUNT
	};
	
	private static Map<String,Object> QueryValue = new HashMap<String,Object>();
	public Hits search(SuburItemQuery itemQuery)
	{
		getSearchParams(itemQuery);
		
		return null;
	}
	
	private static String buildQuery(SuburItemQuery itemQuery)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("+(entryClassName:").append(className).append(") ");
		
		if (itemQuery.getAnyTagIds().length > 0) {
			sb.append("+(assetTagIds:");
			for (int i = 0; i < itemQuery.getAnyTagIds().length ; i++)
			{
				sb.append(itemQuery.getAnyTagIds()[i]);
				if (i+1 < itemQuery.getAnyTagIds().length)
					sb.append(" assetTagIds:");
				
			}
			sb.append(") ");

		}
		if (itemQuery.getAnyCategoryIds().length > 0)
		{
			sb.append("+(assetCategoryIds:");
			for (int i = 0; i < itemQuery.getAnyCategoryIds().length ; i++)
			{
				sb.append(itemQuery.getAnyCategoryIds()[i]);
				if (i+1 < itemQuery.getAnyCategoryIds().length)
					sb.append(" assetCategoryIds:");
				
			}
			sb.append(") ");
			
			
		}
		
		if (itemQuery.getAllCategoryIds().length > 0)
		{
			sb.append("+(assetCategoryIds:");
			for (int i = 0; i < itemQuery.getAllCategoryIds().length ; i++)
			{
				sb.append(itemQuery.getAllCategoryIds()[i]);
				if (i+1 < itemQuery.getAllCategoryIds().length)
					sb.append(" +assetCategoryIds:");
			}
			sb.append(") ");
			
			
		}
		//all tags
		if (itemQuery.getAllTagIds().length > 0) {
			sb.append("+(assetTagIds:");
			for (int i = 0; i < itemQuery.getAllTagIds().length ; i++)
			{
				sb.append(itemQuery.getAllTagIds()[i]);
				if (i+1 < itemQuery.getAllTagIds().length)
					sb.append(" +assetTagIds:");
			}
			sb.append(") ");

		}
		//any item types
		
		if (itemQuery.getAnyItemTypeIds().length>0)
		{
			sb.append("+(itemType:");
			for (int i = 0; i < itemQuery.getAnyItemTypeIds().length; i++)
			{
				sb.append(itemQuery.getAnyItemTypeIds()[i]);
				if (i+1 < itemQuery.getAnyItemTypeIds().length )
					sb.append(" itemType:");
			}
			sb.append(") ");
		}
		//all item Type
		if (itemQuery.getAllItemTypeIds().length > 0)
		{
			sb.append("+(itemType:");
			for (int i = 0; i < itemQuery.getAllItemTypeIds().length; i++)
			{
				sb.append(itemQuery.getAllItemTypeIds()[i]);
				if (i+1 < itemQuery.getAllItemTypeIds().length )
					sb.append(" itemType:");
			}
			sb.append(") ");
		}
		//year published
		if (itemQuery.getYearPublished() > 0)
		{
			sb.append("+(yearAdded:"+ itemQuery.getYearPublished() + ") ");
		}
		if (!itemQuery.getAuthorFirstName().isEmpty())
		{
			sb.append("+(authorFirstName:"+ StringUtil.toLowerCase(itemQuery.getAuthorFirstName()) + "*) ");
		}
		
		return sb.toString();
		//itemType = itemQuery.
	}
	
	public static BooleanQuery getSearchQuery(HttpServletRequest request,SearchContext searchContext) 
	{
		_searchContext = searchContext;
		getSearchParams(request);
		fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		//classname Query
		BooleanQuery classNameQuery = BooleanQueryFactoryUtil.create(searchContext);
		classNameQuery.addRequiredTerm(SuburField.ENTRY_CLASS_NAME, SuburItem.class.getName()); 
		try {
			fullQuery.add(classNameQuery, BooleanClauseOccur.MUST);
			if (matchAllField)
			{
				for (Map.Entry<String, Object> entry : QueryValue.entrySet())
				{
					String fieldName = entry.getKey();
					Object value = entry.getValue();
					
					BooleanQuery fldQuery = buildFieldQuery(fieldName,value);
					if (Validator.isNotNull(fldQuery))
					{
						
						fullQuery.add(fldQuery, matchAllField ? BooleanClauseOccur.MUST: BooleanClauseOccur.SHOULD );
					}
					
				}
			}else //match any
			{
				BooleanQuery termQuery = BooleanQueryFactoryUtil.create(_searchContext);
				for (Map.Entry<String, Object> entry : QueryValue.entrySet())
				{
					String fieldName = entry.getKey();
					Object value = entry.getValue();
					
					
					
					BooleanQuery fldQuery = buildFieldQuery(fieldName,value);
					if (Validator.isNotNull(fldQuery))
					{
						
						termQuery.add(fldQuery,BooleanClauseOccur.SHOULD );
					}
					
				}
				
				fullQuery.add(termQuery, BooleanClauseOccur.MUST);
			}
			
			
			
			
		} catch (ParseException e) {
			_log.error("Error parsing Query",e);
			return null;
		}
		
		
		
		
		return fullQuery;
	}
	
	
	
	private static BooleanQuery buildFieldQuery(String fieldName,Object value)
	{
		
		
		if (Validator.isNull(value))
		{
			_log.info(fieldName + " value=null");
			return null;
		}
		//we need to construct author separately if matchAllField
		//if (fieldName.startsWith("author") && !matchAllField)
		//	return null;
		
		_log.info(fieldName + " value="+value);
		
		long[] longArrayValue = null;
		BooleanQuery termQuery = BooleanQueryFactoryUtil.create(_searchContext);
		
		try
		{
			if (value instanceof String)
			{
				
				String stringValue = (String)value;
				if (stringValue.trim().length() == 0)
					return null;
				termQuery.addTerm(fieldName, stringValue);
				
			}
			if (value instanceof Long)
			{
				_log.info("long type ="+fieldName);
				long longValue = (long) value;
				if (longValue == 0)
					return null;
				
				termQuery.addExactTerm(fieldName, longValue);
			}
			if (value instanceof long[])
			{
				longArrayValue = (long[]) value;
				for (long searchValue : longArrayValue)
				{
					if (searchValue > 0)
						termQuery.addExactTerm(fieldName, searchValue);
				}
				
			}
			
			if (value instanceof String[])
			{
				String[] stringArrayValue = (String[])value;
				for (String searchValue : stringArrayValue)
				{
					if (Validator.isNotNull(searchValue))
						termQuery.addExactTerm(fieldName, searchValue);
					_log.info(searchValue);
				}
			}
			
			
		} catch (ParseException e)
		{
			_log.error("Error parsing field",e);
			return null;
		}
		
		
		
		if (termQuery.hasClauses())
			return termQuery;
		else
			return null;
	}
	
	
	/**
	 * Build lucene query syntax based on the request params
	 * @param request
	 * @param searchContext
	 * @return
	 */
	public static Query buildSearchQuery(HttpServletRequest request, SearchContext searchContext)
	{
		_searchContext = searchContext;
		getSearchParams(request);
		
		
		
		//String z = sb.toString();
		//logger.info(z);
		//String z = "+(entryClassName:com.idetronic.subur.model.SuburItem) +(authorFirstName:{mazlan* zzz*}authorLastName:jongk* )";
		//return StringQueryFactoryUtil.create(z);
		return StringQueryFactoryUtil.create(buildQuery());
	}
	public static Query buildSearchQuery(SuburItemQuery itemQuery)
	{
		getSearchParams(itemQuery);
		return StringQueryFactoryUtil.create(buildQuery());
	}
	
	private static void getSearchParams(HttpServletRequest request)
	{
		keywords = ParamUtil.getString(request, "keywords");
		author = ParamUtil.getString(request,"author");
		title = ParamUtil.getString(request,"title");
		yearPublished = ParamUtil.getString(request,"year");
		andOperator = ParamUtil.getString(request,"andOperator");
		advanceSearch = ParamUtil.getBoolean(request, "advancedSearch");
		matchAllField = Validator.equals(andOperator, "1");
		authorFirstName = ParamUtil.getString(request,"authorFirstName");
		authorLastName = ParamUtil.getString(request,"authorLastName");
		itemType = ParamUtil.getLong(request, SuburDisplayTerms.ITEM_TYPE);
		viewCount = ParamUtil.getString(request, "viewCount");
		String itemTypeString = ParamUtil.getString(request, SuburConstant.FIELD_ITEM_TYPE);
		
		
		if (!itemTypeString.equals("0"))
			buildItemTypeIdParam(itemTypeString);
		
		/*
		 SuburField.TITLE,
		SuburField.AUTHOR,
		SuburField.AUTHOR_FIRST_NAME,
		SuburField.AUTHOR_LAST_NAME,
		SuburField.YEAR_PUBLISHED,
		SuburField.ITEM_TYPE,
		SuburField.OTHER_TITLES,
		SuburField.ASSET_CATEGORY_IDS,
		SuburField.ASSET_TAG_IDS,
		SuburField.GROUP_ID,
		SuburField.VIEW_COUNT
		 * 
		 * 
		 */
		
		QueryValue.put(SuburField.TITLE, title);
		//QueryValue.put(SuburField.DESCRIPTION, title);
		QueryValue.put(SuburField.YEAR_PUBLISHED, yearPublished);
		QueryValue.put(SuburField.AUTHOR, author);
		QueryValue.put(SuburField.AUTHOR_FIRST_NAME, authorFirstName);
		QueryValue.put(SuburField.AUTHOR_LAST_NAME, authorLastName);
		QueryValue.put(SuburField.ITEM_TYPE, itemType);
		_log.info("it="+itemType);
		//QueryValue.put(SuburField.OTHER_TITLES, title);
		QueryValue.put(SuburField.ASSET_CATEGORY_IDS, _searchContext.getAssetCategoryIds());
		QueryValue.put(SuburField.ASSET_TAG_NAMES, _searchContext.getAssetTagNames());
		QueryValue.put(SuburField.VIEW_COUNT, viewCount);
		
		
		
		
	}
	private static void buildItemTypeIdParam(String itemTypeString)
	{
		List<Long> itemtypeIdList = new ArrayList<Long>();
		String[] itemTypes = StringUtil.split(itemTypeString);
		
		if (itemTypes.length > 0)
		{
			for(String itemType : itemTypes) {
			  	long id = Long.parseLong(itemType);
			  	if (id != 0L) {
			  		itemtypeIdList.add(id);
			  	}
			}
		}
		
		
		
		if (matchAllField)
			allItemTypeIds = ArrayUtil.toLongArray(itemtypeIdList);
		else
			anyItemTypeIds = ArrayUtil.toLongArray(itemtypeIdList);
	}
	private static void getSearchParams(SuburItemQuery itemQuery)
	{
		keywords = itemQuery.getKeywords();
		title = itemQuery.getTitle();
		yearPublished = String.valueOf(itemQuery.getYearPublished());
		authorFirstName = itemQuery.getAuthorFirstName();
		authorLastName = itemQuery.getAuthorLastName();
		anyItemTypeIds = itemQuery.getAnyItemTypeIds();
		allItemTypeIds = itemQuery.getAllItemTypeIds();
		anyTagIds = itemQuery.getAnyTagIds();
		allTagIds = itemQuery.getAllTagIds();
		anyCategoryIds = itemQuery.getAnyCategoryIds();
		allCategoryIds = itemQuery.getAllCategoryIds();
		visible = itemQuery.isVisible();
	}
	
	private static String buildQuery()
	{
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("+(entryClassName:").append(className).append(") ");
		if (Validator.isNotNull(authorFirstName) || Validator.isNotNull(authorLastName)
				|| Validator.isNotNull(title) || Validator.isNotNull(yearPublished)
				|| allItemTypeIds.length > 0 || anyItemTypeIds.length > 0 )

		{
			
			
		}
		
		//stringBuilder.append("+(");
		stringBuilder.append(buildAllCriteria());
		//stringBuilder.append(")");
		
		
		return stringBuilder.toString();
		
	
	}
	private static String buildAllCriteria()
	{
		
		StringBuilder sb = new StringBuilder();
		String[] fieldArray  = {Field.TITLE,
				SuburConstant.FIELD_AUTHOR_FIRST_NAME,
				SuburConstant.FIELD_AUTHOR_LAST_NAME,
				SuburConstant.FIELD_YEAR,
				SuburConstant.FIELD_ITEM_TYPE,
				SuburConstant.FIELD_MONTH,
				Field.ASSET_CATEGORY_IDS,
				Field.ASSET_TAG_IDS,
				Field.GROUP_ID,
				Field.VIEW_COUNT
		};
		
		
		String query = StringPool.BLANK;
		for (String field : fieldArray)
		{
			sb.append(buildFieldCriteria(field));
		}
		
		return sb.toString();
	}
	private static String buildFieldCriteria(String fieldName)
	{
		
		String qry = StringPool.BLANK;
		
		
		StringBuilder sb = new StringBuilder();
		qry = matchAllField ? "+".concat(fieldName).concat(":") : " "+ fieldName.concat(":");
		
		if (fieldName.equals(Field.TITLE))
		{
			if (Validator.isNull(title))
				return StringPool.BLANK;
			else
			{
				sb.append(qry);
				sb.append(handleStringTerm(title).concat(StringPool.SPACE));
			}
				

		}
		else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_AUTHOR_FIRST_NAME))
		{
			if (Validator.isNull(authorFirstName))
			{
				return StringPool.BLANK;
				
			}else {
				
				qry = handleStringTerm(authorFirstName).concat(StringPool.SPACE);
				//qry = qry.concat(StringUtil.toLowerCase(suffixWithStar(authorFirstName)).concat(StringPool.PLUS).concat("zzz*"));
				
			}
		}else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_AUTHOR_LAST_NAME))
		{
			if (Validator.isNull(authorLastName))
				return StringPool.BLANK;
			else
				qry = handleStringTerm(authorLastName).concat(StringPool.SPACE);
			
		}else if (fieldName.equalsIgnoreCase(SuburConstant.FIELD_YEAR))
		{
			if (Validator.isNull(yearPublished))
				return StringPool.BLANK;
			else
				qry = yearPublished.concat(StringPool.SPACE);
			
		}else if (fieldName.equalsIgnoreCase(SuburDisplayTerms.ITEM_TYPE))
		{
			
			if (itemType > 0)
				qry = String.valueOf(itemType).concat(StringPool.SPACE);
			else
				return StringPool.BLANK;
					
		}else if (fieldName.equals(Field.ASSET_CATEGORY_IDS))
		{
			
			qry = qry.concat(buildAnyAllCriteria(_searchContext.getAssetCategoryIds() ,_searchContext.getAssetCategoryIds(),Field.ASSET_CATEGORY_IDS));//   buildAssetCategoryIdsCriteria();
			
		}	
		else if (fieldName.equals(Field.ASSET_TAG_IDS))
			
			qry = buildAnyAllCriteria(anyTagIds,allTagIds,Field.ASSET_TAG_IDS);
		else if (fieldName.equals(SuburConstant.FIELD_ITEM_TYPE))
			qry = buildAnyAllCriteria(anyItemTypeIds,allItemTypeIds,SuburConstant.FIELD_ITEM_TYPE);
		else
			qry = StringPool.BLANK;
		
		sb.append(qry);
		logger.info(qry);
		return sb.toString();
		
		
	}
	
	private static String buildAnyAllCriteria(long[] anyIds,long[] allIds,String fieldName)
	{
		
		StringBuilder sb = new StringBuilder();
		if (matchAllField)
		{
			if (allIds.length > 0)
			{
				for (int i = 0; i < allIds.length; i++)
				{
					//sb.append(CharPool.PLUS);
					//sb.append(fieldName);
					//sb.append(CharPool.SEMICOLON);
					sb.append(allIds[i]);
					sb.append(StringPool.BLANK);
					if (i+1 < allIds.length)
						sb.append("AND ");
					
					sb.append(CharPool.SPACE);
					
				}
			}
		}else
			
		{
			if (anyIds.length > 0)
			{
				for (int i = 0; i < anyIds.length; i++)
				{
					sb.append(allIds[i]);
					sb.append(StringPool.BLANK);
					if (i+1 < allIds.length)
						sb.append("OR ");
					
					sb.append(CharPool.SPACE);
					
				}
			}
		}
		
		
		return sb.toString();
		
	}
	private static String handleStringTerm(String term)
	{
		return suffixWithStar(handleSpace(term)).toLowerCase();
	}
	private static String handleSpace(String criteria)
	{
		criteria = criteria.replace(CharPool.SPACE, CharPool.QUESTION);
		return criteria;
	}
	public static String suffixWithStar(String value)
	{
		if (StringUtil.endsWith(value, StringPool.STAR))
			return value;
		else
			return value.concat(StringPool.STAR);
				
	}
}
