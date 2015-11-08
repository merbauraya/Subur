package com.idetronic.subur.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

public class SuburItemWorkflowHandler extends BaseWorkflowHandler
{
	public String getClassName() 
	{
		return CLASS_NAME;
	}

	public String getType(Locale locale) 
	{
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}
	
	@Override
	public SuburItem updateStatus(int status, Map<String, Serializable> workflowContext)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		
		
		LOGGER.info("wf upd status="+status + "::"+ classPK);
		
		
		ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");
		
		return SuburItemLocalServiceUtil.updateStatus(userId, classPK, status, serviceContext);
		
		
	}
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getURLPortal()
                   + "/Subur-portlet/subur.png";
	}
	public static final String CLASS_NAME = SuburItem.class.getName();
	private static Log LOGGER = LogFactoryUtil.getLog(SuburItemWorkflowHandler.class);

}
