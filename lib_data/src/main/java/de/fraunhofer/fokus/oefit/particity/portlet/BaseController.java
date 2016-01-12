/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.particity.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.Constants;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

/**
 * An abstract controller class to bundle common utility methods used by all controllers
 */
public class BaseController {

	/**
	 * Copy render parameter.
	 *
	 * @param name the name
	 * @param request the request
	 * @param response the response
	 */
	protected void copyRenderParameter(final String name,
	        final ActionRequest request, final ActionResponse response) {
		final String paramValue = request.getParameter(name);
		if (paramValue != null) {
			response.setRenderParameter(name, paramValue);
		}
	}

	/**
	 * Gets the company id.
	 *
	 * @param request the request
	 * @return the company id
	 */
	protected Long getCompanyId(final PortletRequest request) {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay.getCompanyId();
	}

	private String getGlobalParam(final PortletRequest request,
	        final String name) {
		return PortalUtil.getOriginalServletRequest(
		        PortalUtil.getHttpServletRequest(request)).getParameter(name);
	}

	/**
	 * Gets the group id.
	 *
	 * @param request the request
	 * @return the group id
	 */
	protected Long getGroupId(final PortletRequest request) {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay.getScopeGroupId();
	}

	private Long getId(final PortletRequest request, final String name) {
		final String offerId = request.getParameter(name);
		Long l_offerId = null;
		if (offerId != null) {
			l_offerId = this.toLong(offerId);
		}
		return l_offerId;
	}

	private Integer getIntId(final ActionRequest request, final String name) {
		final String offerId = request.getParameter(name);
		Integer l_offerId = null;
		if (offerId != null) {
			l_offerId = this.toInt(offerId);
		}
		return l_offerId;
	}

	/**
	 * Gets the offer id.
	 *
	 * @param request the request
	 * @return the offer id
	 */
	protected Long getOfferId(final ActionRequest request) {
		return this.getId(request, "offerId");
	}

	/**
	 * Gets the org id.
	 *
	 * @param request the request
	 * @return the org id
	 */
	protected Long getOrgId(final PortletRequest request) {
		return this.getId(request, "orgId");
	}

	/*
	 * protected Long getCompanyId(PortletRequest request) { ThemeDisplay
	 * themeDisplay = (ThemeDisplay)
	 * request.getAttribute(WebKeys.THEME_DISPLAY); return
	 * themeDisplay.getCompanyId(); }
	 */

	/**
	 * Gets the result skip.
	 *
	 * @param request the request
	 * @return the result skip
	 */
	protected Integer getResultSkip(final ActionRequest request) {
		return this.getIntId(request, "resultSkip");
	}

	/**
	 * Gets the role.
	 *
	 * @param display the display
	 * @return the role
	 */
	protected E_Role getRole(final ThemeDisplay display) {
		E_Role result = null;

		final User user = display.getUser();
		if (user != null && user.getEmailAddress() != null) {
			List<Role> roles = null;
			try {
				roles = user.getRoles();
			} catch (final SystemException e) {
			}
			if (roles != null) {
				for (final Role role : roles) {
					result = CustomPortalServiceHandler.matchesRole(role);
					if (result != null) {
						break;
					}
				}
			}
		}

		return result;

	}

	/**
	 * Gets the search cat id.
	 *
	 * @param request the request
	 * @return the search cat id
	 */
	protected Long[] getSearchCatId(final RenderRequest request) {
		Long[] result = null;
		final String param = this.getGlobalParam(request, "catId");
		if (param != null) {
			final String[] ids = param.split(",");
			if (ids != null && ids.length > 0) {
				result = new Long[ids.length];
				for (int i = 0; i < ids.length; i++) {
					result[i] = this.toLong(ids[i]);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the search cat id str.
	 *
	 * @param request the request
	 * @return the search cat id str
	 */
	protected String[] getSearchCatIdStr(final RenderRequest request) {
		String[] result = null;
		final String param = this.getGlobalParam(request, "catId");
		if (param != null) {
			result = param.split(",");

		}
		return result;
	}

	/**
	 * Gets the sub id.
	 *
	 * @param request the request
	 * @return the sub id
	 */
	protected Long getSubId(final ActionRequest request) {
		return this.getId(request, "subId");
	}

	/**
	 * Gets the theme display.
	 *
	 * @param request the request
	 * @return the theme display
	 */
	protected ThemeDisplay getThemeDisplay(final PortletRequest request) {
		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Gets the user id.
	 *
	 * @param request the request
	 * @return the user id
	 */
	protected Long getUserId(final PortletRequest request) {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay.getUserId();
	}

	/**
	 * Checks if is logged in mgmt.
	 *
	 * @param request the request
	 * @return true, if is logged in mgmt
	 */
	protected boolean isLoggedInMgmt(final PortletRequest request) {
		boolean result = false;
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			final User user = themeDisplay.getUser();
			if (user != null) {
				try {
					final List<Role> roles = user.getRoles();
					String mgmtRoleName = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.ROLE_NAME_MGMT);
					for (final Role role : roles) {
						if (role.getName().equals(mgmtRoleName)) {
							result = true;
							break;
						}
					}
				} catch (final Throwable t) {
				}
			}
		}
		return result;
	}

	/**
	 * Checks if is logged in org.
	 *
	 * @param request the request
	 * @return true, if is logged in org
	 */
	protected boolean isLoggedInOrg(final PortletRequest request) {
		boolean result = false;
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			final User user = themeDisplay.getUser();
			if (user != null) {
				try {
					final List<Role> roles = user.getRoles();
					final String orgRoleName = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.ROLE_NAME_ORG);
					for (final Role role : roles) {
						if (role.getName().equals(orgRoleName)) {
							result = true;
							break;
						}
					}
				} catch (final Throwable t) {
				}
			}
		}
		return result;
	}

	/**
	 * Send file.
	 *
	 * @param name the name
	 * @param mimeType the mime type
	 * @param contents the contents
	 * @param request the request
	 * @param response the response
	 */
	protected void sendFile(final String name, final String mimeType,
	        final byte[] contents, final ActionRequest request,
	        final ActionResponse response) {
		try {
			if (name != null && mimeType != null && contents != null) {
				final HttpServletRequest httpServletRequest = PortalUtil
				        .getHttpServletRequest(request);
				final HttpServletResponse httpServletResponse = PortalUtil
				        .getHttpServletResponse(response);

				httpServletResponse.setContentType(mimeType);
				httpServletResponse.setHeader("Expires", "0");
				httpServletResponse.setHeader("Cache-Control",
				        "must-revalidate, post-check=0, pre-check=0");
				httpServletResponse.setHeader("Pragma", "public");
				httpServletResponse.setContentLength(contents.length);
				ServletResponseUtil.sendFile(httpServletRequest,
				        httpServletResponse, name, contents);
			}
		} catch (final Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * To int.
	 *
	 * @param str the str
	 * @return the integer
	 */
	protected Integer toInt(final String str) {
		Integer result = null;

		try {
			result = Integer.parseInt(str);
		} catch (final Throwable t) {
		}

		return result;
	}

	/**
	 * To long.
	 *
	 * @param str the str
	 * @return the long
	 */
	protected Long toLong(final String str) {
		Long result = null;

		try {
			result = Long.parseLong(str);
		} catch (final Throwable t) {
		}

		return result;
	}

}
