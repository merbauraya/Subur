package com.idetronic.subur.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.impl.SuburItemImpl;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.persistence.AuthorQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetCategoryUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

public class AuthorUtil {
	
	private static Log logger = LogFactoryUtil.getLog(AuthorUtil.class);
	
	/**
	 * Return author category/VocabularyId map based on xml stored in portlet preferences
	 * @param categoryXML
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Map<String,Long> getAuthorCategories(String categoryXML) throws ParserConfigurationException, SAXException, IOException
	{
		logger.info(categoryXML);
		if (categoryXML == null ||  categoryXML.isEmpty())
			return null;
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(categoryXML));
		
		doc = docBuilder.parse(is);
		Element docElements = doc.getDocumentElement();
		
		NodeList categoryNodes = docElements.getElementsByTagName("category");//.item(0).getChildNodes();
		
		Map<String,Long> categoryMap = null;
		if (categoryNodes != null && categoryNodes.getLength() > 0)
		{
			categoryMap = new HashMap<String,Long>();
			for (int i=0; i < categoryNodes.getLength();i++)
			{
				Node node = categoryNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) node;
					String categoryName = eElement.getElementsByTagName("name").item(0).getTextContent();
					String vocabularyId = eElement.getElementsByTagName("vocabularyId").item(0).getTextContent();
					categoryMap.put(categoryName, Long.parseLong(vocabularyId));
					logger.info(vocabularyId);
				}
				
				
				
			}
		
			
		}
		
		

		
		
		return categoryMap;
		
	}
	public static String getAuthorCategoryString(Map<String,Long> categoryMap) throws Exception
	{
		String xml = StringPool.BLANK;
		XMLStreamWriter xmlStreamWriter = null;
		
		UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		
		try {
			xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(
					unsyncStringWriter);
			xmlStreamWriter.writeStartDocument();
			xmlStreamWriter.writeStartElement("root");
			
			
			
			xmlStreamWriter.writeStartElement("categories");
			if (categoryMap != null && categoryMap.size() > 0)
			{
				for (Map.Entry<String,Long> entry : categoryMap.entrySet()) {
					xmlStreamWriter.writeStartElement("category");
					
					xmlStreamWriter.writeStartElement("name");
				    xmlStreamWriter.writeCharacters(entry.getKey());
				    xmlStreamWriter.writeEndElement();
					
				    xmlStreamWriter.writeStartElement("vocabularyId");
				    xmlStreamWriter.writeCharacters(String.valueOf(entry.getValue()));
				    xmlStreamWriter.writeEndElement();
					
				    
				  
				    xmlStreamWriter.writeEndElement();
				}
		
			}
			xmlStreamWriter.writeEndElement();//categories
			
			xmlStreamWriter.writeEndElement(); //root
			xml = unsyncStringWriter.toString();
			
		} catch (XMLStreamException e) {
			logger.error(e);
			throw new Exception(e);
		}
		
		
		return xml;
	}
	
	public static List<AssetVocabulary> getAuthorVocabulary(long[] groupIds) throws PortalException, SystemException
	{
		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		List<AssetVocabulary> authorVocabularies = new ArrayList<AssetVocabulary>();
		
		long classNameId = PortalUtil.getClassNameId(Author.class.getName());

		
		List<Long> authorVocab = new ArrayList<Long>();
		for (int i = 0; i < groupIds.length; i++) 
		{
			vocabularies.addAll(AssetVocabularyServiceUtil.getGroupVocabularies(groupIds[i], false));
		}
		for (AssetVocabulary vocabulary: vocabularies)
		{
			UnicodeProperties settingsProperties = vocabulary.getSettingsProperties();
			long[] selectedClassNameIds = StringUtil.split(settingsProperties.getProperty("selectedClassNameIds"), 0L);
			if (ArrayUtil.contains(selectedClassNameIds, classNameId))
			{
				authorVocabularies.add(vocabulary);
				authorVocab.add(vocabulary.getVocabularyId());
			}
		}
		
		return authorVocabularies;
		
	}
	public static int countAuthorByCategory(long categoryId) throws SystemException
	{
		AssetEntryQuery assetQuery = new AssetEntryQuery();
		assetQuery.setClassName(Author.class.getName());
		assetQuery.setAllCategoryIds(new long[] {categoryId});
		
		return AssetEntryLocalServiceUtil.getEntriesCount(assetQuery);
		
		
		
	}
	
	public static Map<String,AssetCategory> getTop10CategoryByVocabulary(long vocabularyId) throws SystemException, PortalException
	{
		List<AssetCategory> categories = AssetCategoryServiceUtil.getVocabularyCategories(vocabularyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);// .findByVocabularyId(vocabularyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		Map<String,AssetCategory> top10Vocabularies = new TreeMap<String,AssetCategory>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
			
				return o2.compareTo(o1);
			}
			
		});
		for (AssetCategory category : categories)
		{
			int count = countAuthorByCategory(category.getCategoryId());
			top10Vocabularies.put(count +"-"+ category.getCategoryId(), category);
			
		}
		return top10Vocabularies;
	}
	
	public static JSONArray authorSearchJson(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String keyword = ParamUtil.getString(resourceRequest, "keywords");
		
		List<Author> authors = AuthorLocalServiceUtil.search(keyword, 
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), 0, 20, null);
		
		
		JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
		for (Author author :authors)
		{
			JSONObject jsonCells = JSONFactoryUtil.createJSONObject();
			jsonCells.put("id", author.getAuthorId());
			jsonCells.put("firstName", author.getFirstName());
			jsonCells.put("lastName", author.getLastName());
			jsonCells.put("displayName", author.getDisplayName());
			jsonResults.put(jsonCells);
		}
		
		
		
	
		return jsonResults;
	}
	
	

}
