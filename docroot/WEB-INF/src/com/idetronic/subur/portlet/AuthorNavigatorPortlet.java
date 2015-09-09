package com.idetronic.subur.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AuthorNavigator
 */
public class AuthorNavigatorPortlet extends MVCPortlet {
	@Override
	  public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
	      PortletException {

	    String authorId = ParamUtil.getString(actionRequest, "authorId");
	    _log.info("authornav action="+authorId);
	    if (Validator.isNotNull(authorId)) {
	    	QName qName = new QName("http://liferay.com", "authorNav", "x");
		    	
		    actionResponse.setEvent(qName, authorId);
	    	
	    	actionResponse.setRenderParameter("authorId", authorId);
	    } else {
	    	actionResponse.setRenderParameter("authorId", StringPool.BLANK);
	    }

	    actionResponse.setRenderParameter("resetCur", Boolean.TRUE.toString());

	    super.processAction(actionRequest, actionResponse);
	  }
	
	
	
 
	private static Log _log = LogFactoryUtil.getLog(AuthorNavigatorPortlet.class);
}
