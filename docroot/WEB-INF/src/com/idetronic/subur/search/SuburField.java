package com.idetronic.subur.search;

import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.search.Field;

public class SuburField extends Field{
	
	public static final String YEAR_PUBLISHED = "year";
	public static final String AUTHOR_FIRST_NAME = "authorFirstName";
	public static final String AUTHOR_LAST_NAME = "authorLastName";
	public static final String ITEM_TYPE = "itemType";
	public static final String OTHER_TITLES = "otherTitles";
	public static final String AUTHOR = "author";
	
	public SuburField(String name, Map<Locale, String> localizedValues) {
		super(name, localizedValues);
		// TODO Auto-generated constructor stub
	}

}
