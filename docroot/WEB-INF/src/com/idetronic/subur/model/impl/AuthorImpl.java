/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.subur.model.impl;

import com.idetronic.subur.util.SuburUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;

/**
 * The extended model implementation for the Author service. Represents a row in the &quot;subur_Author&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.idetronic.subur.model.Author} interface.
 * </p>
 *
 * @author Mazlan Mat
 */
public class AuthorImpl extends AuthorBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a author model instance should use the {@link com.idetronic.subur.model.Author} interface instead.
	 */
	public AuthorImpl() {
	}
	public String getDisplayName()
	{
		return SuburUtil.getAuhorDisplayName(getFirstName(), getLastName());
	}
	public String getPortraitURL(ThemeDisplay themeDisplay)
	{
		long portraitId = getPortraitId();
		StringBundler sb = new StringBundler(9);

		sb.append(themeDisplay.getPathImage());
		
/*
		if (male) {
			sb.append("male");
		}
		else {
			sb.append("female");
		}
*/
		if (portraitId> 0)
		{
			sb.append("/author");
			sb.append("_portrait?img_id=");
			sb.append(portraitId);
		}else
		{
			sb.append("/user_male_portrait?img_id=0");
		}
/*
		if (GetterUtil.getBoolean(
				PropsUtil.get(PropsKeys.USERS_IMAGE_CHECK_TOKEN))) {

			sb.append("&img_id_token=");
			sb.append(HttpUtil.encodeURL(DigesterUtil.digest(userUuid)));
		}
*/
		sb.append("&t=");
		sb.append(WebServerServletTokenUtil.getToken(portraitId));

		return sb.toString();
		
		
	}
	
}