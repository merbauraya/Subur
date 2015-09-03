package com.idetronic.subur.search;

import java.util.Date;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class AuthorDisplayTerms  extends DisplayTerms{
	
	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";
	public static final String LAST_PUBLISHED_DATE = "lastPublishedDate";
	public static final String EXPERTISE_ID = "expertiseId";
	public static final String EXPERTISE_NAME ="expertiseName";
	public static final String RESEARCH_INTEREST_ID = "researchInterestId";
	public static final String RESEARCH_INTEREST_NAME = "researchInterestName";
			
	
	protected String description;
	protected String firstName;
	protected String lastName;
	protected Date lastPublishedDate;
	protected boolean advanceSearch;
	protected boolean matchAll;
	protected int type;
	
	public AuthorDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		
		firstName = ParamUtil.getString(portletRequest, FIRSTNAME);
		lastName = ParamUtil.getString(portletRequest, LASTNAME);
		advanceSearch = ParamUtil.getBoolean(portletRequest, "advancedSearch");
		String andOperator = ParamUtil.getString(portletRequest,"andOperator");
		matchAll = Validator.equals(andOperator, "1");
		
		//lastPublishedDate = ParamUtil.getDate(portletRequest, LAST_PUBLISHED_DATE);//, dateFormat);//
	}
	public boolean getAdvanceSearch()
	{
		return advanceSearch;
	}
	public boolean matchAllKeyword()
	{
		return matchAll;
	}
	public Date getLastPublishedDate()
	{
		return lastPublishedDate;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	

}
