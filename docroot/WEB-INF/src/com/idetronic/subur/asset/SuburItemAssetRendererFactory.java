package com.idetronic.subur.asset;

import com.idetronic.subur.model.SuburItem;
import com.idetronic.subur.service.SuburItemLocalServiceUtil;
import com.idetronic.subur.service.permission.SuburItemPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class SuburItemAssetRendererFactory extends BaseAssetRendererFactory {
	

        public static final String CLASS_NAME = SuburItem.class.getName();

        public static final String TYPE = "subur";

        @Override
        public AssetRenderer getAssetRenderer(long classPK, int type)
                throws PortalException, SystemException {

            SuburItem suburItem = SuburItemLocalServiceUtil.getSuburItem(classPK);
            
            SuburItemAssetRenderer suburItemAssetRender =
        			new SuburItemAssetRenderer(suburItem);
            suburItemAssetRender.setAssetRendererType(type);
            
            return suburItemAssetRender;
        }
        @Override
        protected String getIconPath(ThemeDisplay themeDisplay) {

               return themeDisplay.getURLPortal()
                                + "/Subur-portlet/subur.png";

        }
        @Override
        public String getClassName() {
                return CLASS_NAME;
        }

        @Override
        public String getType() {
                return TYPE;
        }

        @Override
        public boolean hasPermission(
                        PermissionChecker permissionChecker, long classPK, String actionId)
                throws Exception {

                return SuburItemPermission.contains(permissionChecker, classPK, actionId);
        }

        @Override
        public boolean isLinkable() {
                return _LINKABLE;
        }

        private static final boolean _LINKABLE = true;
        
        private static final Log LOGGER = LogFactoryUtil.getLog(SuburItemAssetRendererFactory.class);
}


