package com.idetronic.subur.asset;

import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.idetronic.subur.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetRendererFactory;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class SuburItemAssetRenderer extends BaseAssetRenderer {
	private SuburItem _suburItem;

    public SuburItemAssetRenderer (SuburItem suburItem) {

    	_suburItem = suburItem;
    }

    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) {

            long itemId = _suburItem.getItemId();

            boolean contains = false;

            try {
                    contains = SuburItemPermission.contains(permissionChecker,
                                    itemId, ActionKeys.UPDATE);
            } catch (PortalException pe) {
                    LOGGER.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    LOGGER.error(se.getLocalizedMessage());
            }

            return contains;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {

            long itemId = _suburItem.getItemId();
            
            boolean contains = false;
            
            try 
            {
            	contains = SuburItemPermission.contains(permissionChecker,
                    		itemId, ActionKeys.VIEW);
            } catch (PortalException pe) {
                    LOGGER.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    LOGGER.error(se.getLocalizedMessage());
            }

            return contains;
    }

    @Override
    public String getClassName() {
            return SuburItem.class.getName();
    }

    @Override
    public long getClassPK() {
            return _suburItem.getItemId();
    }

    @Override
    public long getGroupId() {
            return _suburItem.getGroupId();
    }

    @Override
    public String getSummary(Locale locale) {
    	String summary = StringUtil.shorten(
				HtmlUtil.stripHtml(_suburItem.getItemAbstract()), 200);
    	return summary;
    }
    public String getType() {
		return SuburItemAssetRendererFactory.TYPE;
	}
    
    @Override
    public String getTitle(Locale locale) {
            return _suburItem.getTitle();
    }

    @Override
    public long getUserId() {
    	
            return _suburItem.getUserId();
    }

    @Override
    public String getUserName() {
            return _suburItem.getUserName();
    }

    @Override
    public String getUuid() {
            return _suburItem.getUuid();
    }
    
	public int getStatus() {
		return _suburItem.getStatus();
	}
	
	

    @Override
    public String render(RenderRequest renderRequest,
                    RenderResponse renderResponse, String template) throws Exception {
    	
    	String page = "/html/renderer/item_abstract.jsp";
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			page = "/html/renderer/item_full.jsp";
		}
    	
		renderRequest.setAttribute(WebKeys.SUBUR_ITEM, _suburItem);
        return page;
    }
    @Override
	public PortletURL getURLView(
			LiferayPortletResponse liferayPortletResponse,
			WindowState windowState)
		throws Exception {

		AssetRendererFactory assetRendererFactory = getAssetRendererFactory();
		
		//long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
		
		PortletURL portletURL = liferayPortletResponse.createRenderURL();
		/*
		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, portletName, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/html/renderer/item_full.jsp");
		portletURL.setParameter("itemId", String.valueOf(_suburItem.getItemId()));
		/
		
		PortletURL portletURL = assetRendererFactory.getURLView(
			liferayPortletResponse, windowState);
		*/
		
		portletURL.setParameter("mvcPath", "/html/renderer/item_full.jsp");
		portletURL.setParameter("itemId", String.valueOf(_suburItem.getItemId()));
		portletURL.setWindowState(windowState);
		
		
		return portletURL;
	}
    public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect) throws Exception {
		
		//PortletConfig portletConfig = (PortletConfig) liferayPortletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		ThemeDisplay themeDisplay= (ThemeDisplay)liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//String portletName = portletConfig.getPortletName();
		String portletName = "Subur_WAR_Suburportlet";
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, portletName, plid,PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/html/renderer/item_full.jsp");
		portletURL.setParameter("itemId", String.valueOf(_suburItem.getItemId()));
		//

		return portletURL.toString();
		//
	}
    @Override
    protected String getIconPath(ThemeDisplay themeDisplay) {

            return themeDisplay.getURLPortal()
                            + "/Subur-portlet/subur.png";

            
    }
    
    
    private static final Log LOGGER = LogFactoryUtil.getLog(SuburItemAssetRenderer.class);
    private static final String PORTLET_NAME = "Subur_WAR_Suburportlet";
}
