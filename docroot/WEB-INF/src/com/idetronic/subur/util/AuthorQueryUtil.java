package com.idetronic.subur.util;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.service.persistence.AuthorQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class AuthorQueryUtil {
	
	private AuthorQuery _authorQuery;
	private StringBuilder sb;
	
	public AuthorQueryUtil(AuthorQuery authorQuery)
	{
		this._authorQuery = authorQuery;
		
	}
	
	public String getQueryString()
	{
		sb = new StringBuilder();
		sb.append("+");
		sb.append(StringPool.OPEN_PARENTHESIS);
		sb.append("entryClassName:");
		sb.append(Author.class.getName());
		sb.append(StringPool.CLOSE_PARENTHESIS);
		
		sb.append(queryCategoryId());
		sb.append(queryExpertiseId());
		sb.append(queryResearchInterestId());
		sb.append(queryName("firstName",_authorQuery.getAuthorFirstName()));
		sb.append(queryName("lastName",_authorQuery.getAuthorLastName()));
		sb.append(queryName("middleNamwe",_authorQuery.getMiddleName()));
		_log.info(sb.toString());
		return sb.toString();
		
	}
	
	private String queryName(String fieldName,String value)
	{
		
		if (Validator.isNotNull(value) && value.length() >0 )
		{
			StringBuilder sb = new StringBuilder();
			sb.append(matchField(fieldName));
			//sb.append(StringPool.DOUBLE_QUOTE);
			sb.append(value);
			//sb.append(StringPool.DOUBLE_QUOTE);
			sb.append(StringPool.CLOSE_PARENTHESIS);
			return sb.toString();
		}else
		{
			return StringPool.BLANK;
		}
	}
	
	private String queryCategoryId()
	{
		StringBuilder sb = new StringBuilder();
		String anyCategory = matchMultiValue(ASSET_CATEGORY_IDS,_authorQuery.getAnyCategoryIds(),"OR");
		String allCategory = matchMultiValue(ASSET_CATEGORY_IDS,_authorQuery.getAllCategoryIds(),"AND");
		
		
		
		return sb.append(anyCategory).append(allCategory).toString();
	}
	
	private String queryExpertiseId()
	{
		StringBuilder sb = new StringBuilder();
		String matchAny = matchMultiValue(AUTHOR_EXPERTISE_IDS,_authorQuery.getAnyExpertiseId(),"OR");
		String matchAll = matchMultiValue(AUTHOR_EXPERTISE_IDS,_authorQuery.getAllExpertiseId(),"AND");
		
		return sb.append(matchAny).append(matchAll).toString();
	}
	private String queryResearchInterestId()
	{
		StringBuilder sb = new StringBuilder();
		String matchAny = matchMultiValue(AUTHOR_RESEARCH_INTEREST_IDS,_authorQuery.getAnyResearchInterestId(),"OR");
		String matchAll = matchMultiValue(AUTHOR_RESEARCH_INTEREST_IDS,_authorQuery.getAllResearchInterestIds(),"AND");
		
		return sb.append(matchAny).append(matchAll).toString();
	}
	private String matchMultiValue(String fieldName,long[] ids, String operator)
	{
		if (ArrayUtil.isEmpty(ids))
		{
			
			return StringPool.SPACE;
		}
		if (ids.length == 1 && ids[0] == 0L)
		{
			return StringPool.SPACE;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(StringPool.SPACE);
		sb.append(StringPool.PLUS);
		sb.append(StringPool.OPEN_PARENTHESIS);
		sb.append(fieldName);
		sb.append(StringPool.COLON);
		if (ids.length > 0)
		{
			
			for (int i = 0; i < ids.length; i++)
			{
				long id = ids[i];
				sb.append(id);
				if ( i+1 < ids.length)
				{
					sb.append(StringPool.SPACE);
					sb.append(operator);
					sb.append(StringPool.SPACE);
				}
			}
			
			
		}
		sb.append(StringPool.CLOSE_PARENTHESIS);
		
		return sb.toString();
	}
	private String matchField(String fieldName)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(StringPool.SPACE);
		sb.append(StringPool.PLUS);
		sb.append(StringPool.OPEN_PARENTHESIS);
		sb.append(fieldName);
		sb.append(StringPool.COLON);
		
		return sb.toString();
		
	}
	
	private final String ASSET_CATEGORY_IDS="assetCategoryIds";
	private final String AUTHOR_EXPERTISE_IDS = " expertiseId";
	private final String AUTHOR_RESEARCH_INTEREST_IDS = " researchInterestId";
	
	private static Log _log = LogFactoryUtil.getLog(AuthorQueryUtil.class);
}
