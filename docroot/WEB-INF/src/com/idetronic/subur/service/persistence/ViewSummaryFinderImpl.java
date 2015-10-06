package com.idetronic.subur.service.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.model.ViewSummary;
import com.idetronic.subur.service.impl.ViewSummaryLocalServiceImpl;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewSummaryFinderImpl extends BasePersistenceImpl<ViewSummary> implements ViewSummaryFinder{
	
	private static Log LOGGER = LogFactoryUtil.getLog(ViewSummaryFinderImpl.class);
	
	public JSONObject getMonthlyCategoryChart(int year,long vocabularyId) throws SQLException
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		JSONObject schemaObject = JSONFactoryUtil.createJSONObject();
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_CATEGORY_SUMMARY);
			
			sql = sql.replace("[$YEAR$]", String.valueOf(year));
			sql = sql.replace("[$VOCAB_ID$]", String.valueOf(vocabularyId));
			
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			LOGGER.info(sql);
			
			JSONObject finalJSON = JSONFactoryUtil.createJSONObject();
			finalJSON.put("data", monthlyTabularY(rs,"categoryname"));
			
			
			JSONArray mthJson = getMonthByYear(year);
			
			
			JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < mthJson.length();i++ )
			{
				categoryArray.put(mthJson.getString(i));
			}
			
			
			JSONArray schemaArray = JSONFactoryUtil.createJSONArray();
			schemaArray.put("categoryname");
			
			for (int i = 0; i < mthJson.length();i++ )
			{
				schemaArray.put(mthJson.getString(i));
			}
			
			//schemaArray.put(mthJson);
			schemaObject.put("resultFields", schemaArray);
			finalJSON.put("column", schemaArray);
			finalJSON.put("schema", schemaObject);
			finalJSON.put("serieName", "categoryname");
			finalJSON.put("category", categoryArray);
			finalJSON.put("yAxisTitle", "Total View");
			finalJSON.put("title", "Category(Subject) monthly view"); 
			return finalJSON;
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			
			
		}catch(Exception e)
		{
			LOGGER.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	
	/*
	public JSONObject getMonthlyCategoryChart(int year,long vocabularyId) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		JSONObject serieObject = null;
		JSONArray serieData = JSONFactoryUtil.createJSONArray();
		JSONArray series = JSONFactoryUtil.createJSONArray();
		JSONObject finalData = JSONFactoryUtil.createJSONObject();
		JSONArray periodJSON = JSONFactoryUtil.createJSONArray();
		
		
		//finalData.put("categories", periodJSON);
		finalData.put("title", "This is Chart Title");
		finalData.put("yAxisTitle", "Total View");
		
		try
		{
			JSONArray monthJSON = getMonthByYear(year);
			//periodJSON = JSONFactoryUtil.createJSONArray(monthMap);
			
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			//get months available
			String sql = CustomSQLUtil.get(SQL_MONTHLY_CATEGORY_SUMMARY);
			sql = sql.replace("[$YEAR$]", String.valueOf(year));
			sql = sql.replace("[$VOCAB_ID$]", String.valueOf(vocabularyId));
			java.sql.ResultSet rst = stmt.executeQuery(sql);
			String categoryName = StringPool.BLANK;
			while (rst.next())
			{
				if (!StringUtil.equalsIgnoreCase(categoryName, rst.getString("categoryName")))
				{
					if (Validator.isNotNull(serieObject))
					{
						serieObject.put("data",serieData);
						series.put(serieObject);
						finalData.put("series", series);
					}
					categoryName = rst.getString("categoryName");
					serieObject = JSONFactoryUtil.createJSONObject();
					serieObject.put("name", categoryName);
					serieData = JSONFactoryUtil.createJSONArray();
					//check missing mth
					
				}
				serieData.put(rst.getInt("viewCount"));
			}
			serieObject.put("data",serieData);
			series.put(serieObject);
			finalData.put("series", series);
			finalData.put("period", monthJSON);
			
			
			
		}
		finally
		{ 
			stmt.close();
			conn.close();
		}
		return finalData;
	}
	*/
	private JSONArray getMonthByYear(int year) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		JSONArray monthJSON = JSONFactoryUtil.createJSONArray();
		Locale locale = LocaleUtil.getDefault();
		DateFormatSymbols  dateFormatSymbols = new DateFormatSymbols(locale);
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		
		for (int month = 0 ; month <= currentMonth ; month++)
		{
			String mthName = dateFormatSymbols.getShortMonths()[month];
			monthJSON.put(mthName);
		}
		
		/*
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			//get months available
			String sql = CustomSQLUtil.get(SQL_GET_MONTH_BY_YEAR);
			sql = sql.replace("[$YEAR$]", String.valueOf(year));
			LOGGER.info(sql);
			java.sql.ResultSet rsMonth = stmt.executeQuery(sql);
			while (rsMonth.next())
			{
				//mthMap.put(rsMonth.getString("perMonth"),rsMonth.getString("perMonth"));
				int month = rsMonth.getInt("perMonth")-1;
				String mthName = dateFormatSymbols.getMonths()[month];
				monthJSON.put(mthName);
				
			}
			
			return monthJSON;
		}catch(Exception e)
		{
			LOGGER.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		*/
		return monthJSON;
	}
	public JSONObject getMonthlyCategorySummary(int year,long vocabularyId) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		LOGGER.info("mthSummary");
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_CATEGORY_SUMMARY);
			
			sql = sql.replace("[$VOCAB_ID$]", String.valueOf(vocabularyId));
			sql = sql.replace("[$YEAR$]", String.valueOf(year));
			
			LOGGER.info(sql);
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			//return monthlyTabular(rs,"categoryname");
			return monthlyTabularX(rs,"categoryname");
			
		}catch(Exception e)
		{
			LOGGER.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	public JSONArray getMothlyItemTypeSummary(int year) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_ITEMTYPE_SUMMARY);
			
			sql = sql.replace("?", String.valueOf(year));
			LOGGER.info(sql);
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			return monthlyTabular(rs,"itemtypename");
			
			
		}catch(Exception e)
		{
			LOGGER.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	private JSONObject monthlyTabularX(ResultSet rst,String keyColumn) throws SQLException
	{
		boolean addMonthName = true;
		
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ResultSetMetaData rsMetaData = rst.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		
		String[] columns = new String[colCount];
		
		for (int i=1; i <= colCount; i++)
			columns[i-1] = rsMetaData.getColumnName(i);
		
		Locale locale = LocaleUtil.getDefault();
		DateFormatSymbols  dateFormatSymbols = new DateFormatSymbols(locale);
		String keyColumnValue = StringPool.BLANK;
		JSONObject jsonObj = null;
		Set<String> monthSet = new HashSet<String>();
		String keyValue = null;
		JSONObject monthJson = JSONFactoryUtil.createJSONObject();
		while (rst.next())
		{
				
			keyValue = rst.getString(keyColumn);
			if (!keyValue.equalsIgnoreCase(keyColumnValue))
			{
				if (jsonObj != null)
					jsonArray.put(jsonObj);

				jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put(keyColumn, keyValue);
				keyColumnValue = keyValue;
			}
			
			
			
			String mth = "M" +rst.getString("permonth");
			int month = rst.getInt("permonth")-1;
			String mthName = dateFormatSymbols.getMonths()[month];
			monthJson.put(mth, mthName);
			monthSet.add(mthName);
			
			LOGGER.info(mth + "::"+mthName);
			if (addMonthName)
			{
				mth = dateFormatSymbols.getMonths()[month];
			
			}
			
			String val = rst.getString("viewCount");
			jsonObj.put(mth , val);
			
	
		}
		
		
		//ArrayUtil.toString(array, param, delimiter)
		//StringUtil.
		JSONObject finalObject = JSONFactoryUtil.createJSONObject();
		jsonArray.put(jsonObj);
		
		
		finalObject.put("data", jsonArray);
		finalObject.put("period", monthJson);
		
		return finalObject;
		
	}
	private JSONArray monthlyTabular(ResultSet rst,String keyColumn) throws SQLException
	{
		boolean addMonthName = true;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ResultSetMetaData rsMetaData = rst.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		//JSONObject monthJson = JSONFactoryUtil.createJSONObject();
		
		String[] columns = new String[colCount];
		
		for (int i=1; i <= colCount; i++)
			columns[i-1] = rsMetaData.getColumnName(i);
		
		Locale locale = LocaleUtil.getDefault();
		DateFormatSymbols  dateFormatSymbols = new DateFormatSymbols(locale);
		String keyColumnValue = StringPool.BLANK;
		JSONObject jsonObj = null;
		Set<String> monthSet = new HashSet();
		String keyValue = null;
		while (rst.next())
		{
				
			keyValue = rst.getString(keyColumn);
			LOGGER.info(keyValue);
			if (!keyValue.equalsIgnoreCase(keyColumnValue))
			{
				if (jsonObj != null)
					jsonArray.put(jsonObj);

				jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put(keyColumn, keyValue);
				keyColumnValue = keyValue;
				LOGGER.info("newKey");
			}
			LOGGER.info(rst.getString("permonth"));
			String mth = "M" +rst.getString("permonth");
			int month = rst.getInt("permonth")-1;
			String mthName = dateFormatSymbols.getMonths()[month];
			monthSet.add(mthName);
			
			//logger.info(mth + "::"+mthName);
			if (addMonthName)
			{
				mth = dateFormatSymbols.getMonths()[month];
				
				
			}
			
			String val = rst.getString("viewCount");
			jsonObj.put(mth , val);
			
	
		}
		/*
		JSONObject monthJson = JSONFactoryUtil.createJSONObject();
		for (String monthName : monthSet)
		{
			monthJson.put("month",monthName);//, arg1);//
			//logger.info(monthName);
		}*/
		//ArrayUtil.toString(array, param, delimiter)
		//StringUtil.
		jsonArray.put(jsonObj);
		//jsonArray.put(monthJson);
		
		return jsonArray;
		
	}
	private JSONArray monthlyTabularY(ResultSet rst,String keyColumn) throws SQLException
	{
		
		//TODO put data in command separated
		boolean addMonthName = true;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ResultSetMetaData rsMetaData = rst.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		//JSONObject monthJson = JSONFactoryUtil.createJSONObject();
		
		String[] columns = new String[colCount];
		
		for (int i=1; i <= colCount; i++)
			columns[i-1] = rsMetaData.getColumnName(i);
		
		Locale locale = LocaleUtil.getDefault();
		DateFormatSymbols  dateFormatSymbols = new DateFormatSymbols(locale);
		String keyColumnValue = StringPool.BLANK;
		JSONObject jsonObj = null;
		Set<String> monthSet = new HashSet();
		String keyValue = null;
		JSONObject keyData = null;
		JSONArray data = null;
		JSONArray keyArray = null;
		while (rst.next())
		{
				
			keyValue = rst.getString(keyColumn);
			//LOGGER.info(keyValue);
			if (!keyValue.equalsIgnoreCase(keyColumnValue))
			{
				LOGGER.info(keyValue);
				if (keyArray != null)
				{
					jsonArray.put(keyArray);
				}
				if (data != null)
				{
					//jsonArray.put(keyData);
					//jsonArray.put(data);
					keyArray.put(data);
					
				}
				jsonObj = JSONFactoryUtil.createJSONObject();
				keyArray = JSONFactoryUtil.createJSONArray();
				keyArray.put(keyValue);
				
				data = JSONFactoryUtil.createJSONArray();
				//keyData = JSONFactoryUtil.createJSONObject();
				//keyData.put("tagName", keyValue);
				//data.put(keyValue);
				//jsonObj.put(keyColumn, keyValue);
				keyColumnValue = keyValue;
				
			}
			
			data.put(rst.getInt("viewCount"));
	
			
	
		}
		keyArray.put(data);
		jsonArray.put(keyArray);
		//jsonArray.put(data);
		
		
		return jsonArray;
		
	}
	
	
	/**
	 * Get tag visit summary by month
	 */
	public JSONObject getMothlyTagSummary(int year) throws SQLException
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		JSONObject schemaObject = JSONFactoryUtil.createJSONObject();
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_TAG_SUMMARY);
			
			sql = sql.replace("?", String.valueOf(year));
			
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			LOGGER.info(sql);
			
			JSONObject finalJSON = JSONFactoryUtil.createJSONObject();
			finalJSON.put("data", monthlyTabularY(rs,"tagname"));
			
			
			JSONArray mthJson = getMonthByYear(year);
			
			
			JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < mthJson.length();i++ )
			{
				categoryArray.put(mthJson.getString(i));
			}
			
			
			JSONArray schemaArray = JSONFactoryUtil.createJSONArray();
			schemaArray.put("tagname");
			
			for (int i = 0; i < mthJson.length();i++ )
			{
				schemaArray.put(mthJson.getString(i));
			}
			
			//schemaArray.put(mthJson);
			schemaObject.put("resultFields", schemaArray);
			finalJSON.put("column", schemaArray);
			finalJSON.put("schema", schemaObject);
			finalJSON.put("serieName", "tagname");
			finalJSON.put("category", categoryArray);
			finalJSON.put("yAxisTitle", "Total View");
			finalJSON.put("title", "Tag monthly view"); 
			return finalJSON;
			//String[] columns = new String[]{"permonth,totalview"};
			//return resultSetToJSON(rs,true);
			
			
		}catch(Exception e)
		{
			LOGGER.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
	}
	
	/**
	 * Get basic monthly view Summary by month
	 */
	public JSONArray getMonthlySummary(int year) throws SQLException
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		
		try
		{
			conn= com.liferay.portal.kernel.dao.jdbc.DataAccess.getConnection();
			stmt = conn.createStatement();
			String sql = CustomSQLUtil.get(SQL_MONTHLY_SUMMARY);
			
			sql = sql.replace("?", String.valueOf(year));
			
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			
			
			
			//String[] columns = new String[]{"permonth,totalview"};
			return resultSetToJSON(rs,true);
			
			
		}catch(Exception e)
		{
			LOGGER.error(e);
		}finally
		{ 
			stmt.close();
			conn.close();
		}
		
		return null;
		
	}
	
	private JSONArray resultSetToJSON(ResultSet rst,boolean addMonthName) throws SQLException
	{
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ResultSetMetaData rsMetaData = rst.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		Locale locale = LocaleUtil.getDefault();
		while (rst.next())
			{
				
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
				
				for (int i = 1; i <= colCount; i++)
				{
					
					String colName = rsMetaData.getColumnName(i);
					
					jsonObj.put(colName , rst.getString(i));
					if (addMonthName && colName.equalsIgnoreCase("permonth"))
					{
						DateFormatSymbols  xx = new DateFormatSymbols(locale);
						int month = rst.getInt(i)-1;
						String monthString = xx.getMonths()[month];
						jsonObj.put("monthName",monthString );
					}
				}
				
				
				
				jsonArray.put(jsonObj);
				
				
		}
		return jsonArray;
	
		
	}
	
	private static final String SQL_MONTHLY_SUMMARY = ViewSummaryFinder.class.getName()+ ".monthlySummary";
	private static final String SQL_MONTHLY_TAG_SUMMARY = ViewSummaryFinder.class.getName() + ".monthlyTagSummary";
	private static final String SQL_MONTHLY_ITEMTYPE_SUMMARY = ViewSummaryFinder.class.getName() +".monthlyItemTypeSummary";
	private static final String SQL_MONTHLY_CATEGORY_SUMMARY = ViewSummaryFinder.class.getName() +".monthlyCategorySummary";
	private static final String SQL_GET_MONTH_BY_YEAR = ViewSummaryFinder.class.getName() + ".getMonthByYear";
}
