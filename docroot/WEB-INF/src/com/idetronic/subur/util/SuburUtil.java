package com.idetronic.subur.util;

import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.util.ContentUtil;
import com.liferay.util.portlet.PortletProps;
import com.idetronic.subur.service.MetadataPropertyValueLocalServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;

public class SuburUtil {
	
	private static Log logger = LogFactoryUtil.getLog(SuburUtil.class);
	
	public static long[] getUserByRole(long companyId,long[] roleIds) throws SystemException {
        //final long companyId = PortalUtil.getDefaultCompanyId();
        Role role = null;
        long[] userInRoles = new long[]{};
        
        for (long roleId : roleIds)
        {
        	long[] userInRole = UserLocalServiceUtil.getRoleUserIds(roleId);
        	userInRoles = ArrayUtil.append(userInRoles,userInRole);
        	
        }
        
        return userInRoles;
       
    }
	
	 public static Role getRoleById(final long companyId, final String roleStrId) {
	        try {
	            return RoleLocalServiceUtil.getRole(companyId, roleStrId);
	        } catch (final Exception e) {
	            logger.error("Utils::getRoleById Exception", e);
	        }
	        return null;
	    }
	
	public List getAdditionalMetadata()
	{
		List metadata = MetadataPropertyValueLocalServiceUtil.getAdditionalMetadata(0);
		return metadata;
	}
	/**
	 * Merge related asset id with DLFileEntry id
	 * @param relatedAsset
	 * @param fileEntries
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static long[] mergeRelatedAssetWithDlFileEntry(long[] relatedAsset,long[] fileEntries) throws PortalException, SystemException
	{
		long[] dlFileEntryAssetPK = new long[fileEntries.length];
		
		//process newly upload files, if any
		if (fileEntries.length > 0 ){
			for (int i = 0; i < fileEntries.length; i++)
			{
				
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(DLFileEntry.class.getName(), fileEntries[i]);
				dlFileEntryAssetPK[i] = assetEntry.getEntryId();
			}
		}
		
		relatedAsset = ArrayUtil.append(dlFileEntryAssetPK,relatedAsset);
		return relatedAsset;
		
	}
	/*
	public List getAuthor(long itemId)
	{
		DynamicQuery authorQuery = DynamicQueryFactoryUtil.forClass(
				 MetadataValue.class, PortletClassLoaderUtil.getClassLoader());
		
		//authorQuery.add(PropertyFactoryUtil.forName(propertyName))
		//List<Object> authors = MetadataValueLocalServiceUtil.
		return null;
	}
	*/
	public static String getAuhorDisplayName(String firstName,String lastName)
	{
		if (Validator.isBlank(lastName) || Validator.isNull(lastName))
		{
			return lastName +",";
		}else
		{
			return lastName + "," + firstName;
		}
	}
	public static String getName(String firstName,String lastName)
	{
		if (Validator.isBlank(lastName) || Validator.isNull(lastName))
		{
			return lastName +",";
		}else
		{
			return lastName + "," + firstName;
		}
	}
	public static String getFirstName(String name)
	{
		Collections.emptyList();
		if (Validator.isBlank(name) || Validator.isNull(name))
		{
			
			return StringPool.BLANK;
		}
		if (name.equals(","))
			return StringPool.BLANK;
		
		String[] names = name.split(",");
		if (names.length < 2)
			return StringPool.BLANK;
		
		return names[1];
		
	}
	public static String getLastName(String name)
	{
		if (Validator.isBlank(name))
			return StringPool.BLANK;
		if (name.equals(","))
			return StringPool.BLANK;
		String[] names = name.split(",");
		if (names.length < 2)
			return StringPool.BLANK;
		return names[0];
		
	}
	
	public static String getEmailFromAddress(
			PortletPreferences preferences, long companyId)
		throws SystemException 
	{

		return PortalUtil.getEmailFromAddress(
			preferences, companyId, PortletProps.get(PropsKeys.SUBUR_EMAIL_FROM_ADDRESS));
	}
	
	public static Map<Locale, String> getEmailEntryUpdatedSubjectMap(
			PortletPreferences preferences) {

			Map<Locale, String> map = LocalizationUtil.getLocalizationMap(
				preferences, "emailEntryUpdatedSubject");

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			String defaultValue = map.get(defaultLocale);

			if (Validator.isNotNull(defaultValue)) {
				return map;
			}

			map.put(
				defaultLocale,
				ContentUtil.get(
						PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_UPDATED_SUBJECT)));

			return map;
	}
	public static Map<Locale, String> getEmailEntryUpdatedBodyMap(PortletPreferences preferences) 
	{

		Map<Locale, String> map = LocalizationUtil.getLocalizationMap(
			preferences, "emailEntryUpdatedBody");

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String defaultValue = map.get(defaultLocale);

		if (Validator.isNotNull(defaultValue)) {
			return map;
		}

		map.put(
			defaultLocale,
			ContentUtil.get(
					PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_UPDATED_BODY)));

		return map;
	}
	
	public static Map<Locale, String> getEmailEntryAddedSubjectMap(PortletPreferences preferences) 
	{

		Map<Locale, String> map = LocalizationUtil.getLocalizationMap(
			preferences, "emailEntryAddedSubject");

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String defaultValue = map.get(defaultLocale);

		if (Validator.isNotNull(defaultValue)) {
			return map;
		}

		map.put(
			defaultLocale,
			ContentUtil.get(
					PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_ADDED_SUBJECT)));

		return map;
	}
	public static Map<Locale, String> getEmailEntryAddedBodyMap(PortletPreferences preferences) 
	{

		Map<Locale, String> map = LocalizationUtil.getLocalizationMap(
			preferences, "emailEntryAddedBody");

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String defaultValue = map.get(defaultLocale);

		if (Validator.isNotNull(defaultValue)) {
			return map;
		}

		map.put(
			defaultLocale,
			ContentUtil.get(
					PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_ADDED_BODY)));

		return map;
	}
	public static boolean getEmailEntryAddedEnabled(PortletPreferences preferences) 
	{

			String emailEntryAddedEnabled = preferences.getValue(
				"emailEntryAddedEnabled", StringPool.BLANK);

			if (Validator.isNotNull(emailEntryAddedEnabled)) {
				return GetterUtil.getBoolean(emailEntryAddedEnabled);
			}
			else {
				return GetterUtil.getBoolean(
						PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_ADDED_ENABLED));
			}
	}
	public static boolean getEmailEntryUpdatedEnabled(PortletPreferences preferences) 
	{

			String emailEntryUpdatedEnabled = preferences.getValue(
				"emailEntryUpdatedEnabled", StringPool.BLANK);

			if (Validator.isNotNull(emailEntryUpdatedEnabled)) {
				return GetterUtil.getBoolean(emailEntryUpdatedEnabled);
			}
			else {
				return GetterUtil.getBoolean(
						PortletProps.get(PropsKeys.SUBUR_EMAIL_ENTRY_UPDATED_ENABLED));
			}
		}
	public static String getEmailFromName(PortletPreferences preferences, long companyId)
		throws SystemException 
	{

		return PortalUtil.getEmailFromName(
			preferences, companyId, PortletProps.get(PropsKeys.SUBUR_EMAIL_FROM_NAME));
	}
	
	
	
	public static int countAssetVocabularyById(long vocabularyId) throws SystemException
	{
		return  SuburItemLocalServiceUtil.countAssetVocabularyById(vocabularyId);
	}
	
	public static byte[] inputStreamToByteArray(InputStream is) throws IOException
	{
		
	    byte[] targetArray = new byte[is.available()];
	    is.read(targetArray);
	    return targetArray;
	}
	public static void localeTest()
	{
		Locale[] availableLocales = LanguageUtil.getAvailableLocales();
		
		for (Locale locale: availableLocales)
			logger.info(locale.getDisplayName());
		
	}
	public static String getDefaultPortraitURL(String imagePath)
	{
		

			StringBundler sb = new StringBundler(9);

			sb.append(imagePath);
			sb.append("/author_");

			
			sb.append("male");
			
			sb.append("_portrait?img_id=");
			sb.append(0);

			
			sb.append("&t=");
			sb.append(WebServerServletTokenUtil.getToken(0));

			return sb.toString();
	}
	public static JSONObject getLineChartData1() 
	{
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject monthJson = JSONFactoryUtil.createJSONObject();
		JSONArray periodJSON = JSONFactoryUtil.createJSONArray();
		JSONArray serieData = JSONFactoryUtil.createJSONArray();
		JSONArray series = JSONFactoryUtil.createJSONArray();
		JSONObject finalData = JSONFactoryUtil.createJSONObject();
		
		periodJSON.put("Jan");
		periodJSON.put("Feb");
		periodJSON.put("Mac");
		periodJSON.put("Apr");
		
		serieData.put(7);
		serieData.put(11);
		serieData.put(0);
		serieData.put(50);
		
		JSONObject serieObject = JSONFactoryUtil.createJSONObject();
		
		serieObject.put("name", "Tokyo");
		serieObject.put("color", "#3366cc");
		serieObject.put("data",serieData);
		series.put(serieObject);
		//series.put("Tokyo");
		//series.put("#3366cc");
		//series.put(dataSeries);
		//series.put(serieObject);
		
		
		finalData.put("categories", periodJSON);
		finalData.put("series", series);
		finalData.put("title", "This is Chart Title");
		finalData.put("yAxisTitle", "Total View");
		
		serieData = JSONFactoryUtil.createJSONArray();
		serieData.put(20);
		serieData.put(9);
		serieData.put(40);
		serieData.put(80);
		
		//series = JSONFactoryUtil.createJSONObject();
		
		serieObject = JSONFactoryUtil.createJSONObject();
		serieObject.put("name", "Subang");
		serieObject.put("color", "#FFF");
		serieObject.put("data", serieData);
		series.put(serieObject);
		
		
		//series.put("Subang");
		//series.put("#3366FF");
		//series.put(dataSeries);
		finalData.put("series", series);
		//finalData.put("series", series);
		return finalData;
		/*
		List<SeriesBean> list = new ArrayList<SeriesBean>();
        list.add(new SeriesBean("Tokyo", "#3366cc", new double[] {7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6}));
        list.add(new SeriesBean("New York", "#8BBC21", new double[] {0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5}));
        list.add(new SeriesBean("London", "#ff33ff", new double[] {3.9, 4.2, 5.7, 8.5, 12.9, 15.2, 15.0, 16.6, 14.2, 10.3, 6.6, 4.8}));

        String[] categories = new String[] {"9 Jan '13", "8 Feb '13","5 Mar '13","12 Apr '13","14 May '13","21 Jun '13","30 Jul '13","8 Aug '13","5 Sep '13","17 Oct '13","23 Nov '13","5 Dec '13"};
        return new DataBean("chart1-container", "LineChart Title", "Y Values (%)", "Run Dates", Arrays.asList(categories), list);
   		*/
    
    }

}
