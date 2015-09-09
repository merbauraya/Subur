package com.idetronic.subur.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;

import com.idetronic.subur.model.Author;
import com.idetronic.subur.model.Expertise;
import com.idetronic.subur.model.ItemItemType;
import com.idetronic.subur.model.ResearchInterest;
import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.AuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemAuthorLocalServiceUtil;
import com.idetronic.subur.service.ItemItemTypeLocalServiceUtil;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.service.impl.SuburItemLocalServiceImpl;
import com.idetronic.subur.service.persistence.AuthorActionableDynamicQuery;
import com.idetronic.subur.service.persistence.SuburItemActionableDynamicQuery;
import com.idetronic.subur.util.SuburConstant;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class AuthorIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { Author.class.getName() };
	public static final String PORTLET_ID = "Author_WAR_Suburportlet";

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object arg0) throws Exception {
		 Author item = (Author)arg0;

         deleteDocument(item.getCompanyId(), item.getAuthorId());
		
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		Author item = (Author)arg0;
		
         Document document = getBaseModelDocument(PORTLET_ID, item);
         Date createDate = item.getCreateDate();
         Calendar cal = Calendar.getInstance();
         cal.setTime(createDate);
       
         document.addDate(Field.MODIFIED_DATE, item.getModifiedDate());
         document.addText(SuburField.TITLE, item.getDisplayName());
         document.addText(SuburField.AUTHOR_FIRST_NAME, item.getFirstName());
         document.addText(SuburField.AUTHOR_LAST_NAME, item.getLastName());
         document.addKeyword(SuburField.GROUP_ID, getSiteGroupId(item.getGroupId()));
         document.addKeyword(SuburField.SCOPE_GROUP_ID, item.getGroupId());
        
         //expertise 
         List<Expertise> expertises = AuthorLocalServiceUtil.getExpertises(item.getAuthorId());
         String[] expertiseIds = new String[expertises.size()];
         String[] expertiseNames = new String[expertises.size()];
         
         
         for (int i = 0; i < expertises.size(); i++)
         {
        	 expertiseIds[i] = String.valueOf(expertises.get(i).getExpertiseId());
        	 expertiseNames[i] = String.valueOf(expertises.get(i).getName());
         }
         Field expertiseIdField = new Field(SuburField.EXPERTISE_IDS, expertiseIds );
         Field expertiseNameField = new Field(SuburField.EXPERTISE_NAMES, expertiseNames );
         expertiseNameField.setTokenized(true);
         
         document.add(expertiseIdField);
         document.add(expertiseNameField);
         
         
         //research interest
         List<ResearchInterest> researchInterests = AuthorLocalServiceUtil.getResearchInterests(item.getAuthorId());
         String[] researchInterestIds = new String[researchInterests.size()];
         String[] researchInterestNames = new String[researchInterests.size()];
         
         for (int i = 0; i < researchInterests.size(); i++)
         {
        	 researchInterestIds[i] = String.valueOf(researchInterests.get(i).getResearchInterestId());
        	 researchInterestNames[i] = researchInterests.get(i).getName();
         }
         
         
         Field researchInterestIdField = new Field(SuburField.RESEARCH_INTEREST_IDS,researchInterestIds);
         Field researchInterestNameField = new Field(SuburField.RESEARCH_INTEREST_NAMES,researchInterestNames);
         researchInterestNameField.setTokenized(true);
         document.add(researchInterestIdField);
         document.add(researchInterestNameField);
         
         //
        
         
        
         
         
      

         return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet,
			PortletURL portletURL) throws Exception {

        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Author item = (Author)obj;

        Document document = getDocument(item);

        SearchEngineUtil.updateDocument(
                getSearchEngineId(), item.getCompanyId(), document,true);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

        reindexEntries(companyId);
		
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Author item = AuthorLocalServiceUtil.getAuthor(classPK);

        doReindex(item);
		
	}
	protected void reindexEntries(long companyId) throws PortalException,
    SystemException {

		final Collection<Document> documents = new ArrayList<Document>();
		
		ActionableDynamicQuery actionableDynamicQuery = new AuthorActionableDynamicQuery() {
		
		    @Override
		    protected void addCriteria(DynamicQuery dynamicQuery) {
		    }
		
		    @Override
		    protected void performAction(Object object) throws PortalException {
		    	Author item = (Author) object;
		
		            Document document = getDocument(item);
		
		            documents.add(document);
		    }
		
		};
		
		actionableDynamicQuery.setCompanyId(companyId);
		
		actionableDynamicQuery.performActions();
		
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,documents,true);
		}
	@Override
	protected String getPortletId(SearchContext arg0) {
		
		return PORTLET_ID;
	}
	private static Log _log = LogFactoryUtil.getLog(AuthorIndexer.class);


}