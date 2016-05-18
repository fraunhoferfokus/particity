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
package de.fraunhofer.fokus.oefit.particity.portlet.init;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.util.PortletUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.URLUtil;
import com.liferay.portlet.PortletURLUtil;
import com.liferay.taglib.ui.LogoSelectorTag;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;
import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;
import de.fraunhofer.fokus.oefit.particity.portlet.BaseController;

/**
 * Controller for the header portlet
 * 
 * Redirects to site/header by default
 *
 */
@Controller("initController")
@RequestMapping("view")
public class InitController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(InitController.class);

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	/**
	 * Checks if is check method on process action.
	 *
	 * @return true, if is check method on process action
	 */
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	/**
	 * Render.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "view")
	@RenderMapping
	public String render(final RenderRequest request,
	        final RenderResponse response,
	        final Model model) {
		m_objLog.trace("render::start");
		if (getThemeDisplay(request).isSignedIn()) {
			try {
				HttpServletRequest oreq = PortalUtil.getHttpServletRequest(request);
				oreq.getSession().invalidate();
				PortalUtil.getHttpServletResponse(response).sendRedirect(getThemeDisplay(request).getURLSignOut());
				return null;
			} catch (IOException e) {
				m_objLog.error(e);
			}
		}
		String page = request.getParameter("jspPage");
		if (page == null) {
			page = "init";
		}
		final String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", error);
			m_objLog.warn("Handing over error " + error);
			final String ePage = request.getParameter("errorPage");
			if (ePage != null) {
				page = ePage;
			}
		}
		m_objLog.trace("render::end(" + page + ")");

		return page;
	}
	
	@RequestMapping(value = "view")
	@ActionMapping(params="action=initParticity")
	public void initParticity(final ActionRequest request,
	        final ActionResponse response,
	        final Model model) {
		m_objLog.trace("initParticity::start");

		Map<E_ContextPath, String> pathMap = new HashMap<E_ContextPath, String>();
		Map<E_SetupParam, String> paramMap = new HashMap<E_SetupParam, String>();
		Enumeration<String> pnames = request.getParameterNames();
		while (pnames.hasMoreElements()) {
			String pname = pnames.nextElement();
			String pval = request.getParameter(pname);
			m_objLog.debug("Found parameter "+pname+" = "+pval);
			if (pname.startsWith("role_")) {
				pname = pname.replaceAll("role_", "");
				E_Role role = null;
				try {
					role = E_Role.valueOf(pname);
				} catch (Throwable t) {}
				if (role != null) {
					// setup role
					CustomPortalServiceHandler.setConfig(role.getKey(), pval);
				} else
					m_objLog.warn("Unknown role "+pname);
			} else if (pname.startsWith("page_")) {
				pname = pname.replaceAll("page_", "");
				E_ContextPath pth = null;
				try {
					pth = E_ContextPath.valueOf(pname);
				} catch (Throwable t) {}
				if (pth != null) {
					pathMap.put(pth, pval);
				}
		    } else if (pname.startsWith("opt_")) {
				pname = pname.replaceAll("opt_", "");
				E_SetupParam sp = null;
				try {
					sp = E_SetupParam.valueOf(pname);
				} catch (Throwable t) {}
				if (sp != null) {
					paramMap.put(sp, pval);
				} 
		    }
		}
		// setup layouts & content
		if (pathMap.size() > 0)
			ParticityInitializer.setup(pathMap, paramMap);		
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
		}
		
		m_objLog.trace("initParticity::end()");
	}

	@PostConstruct
	public void init() {
		ParticityInitializer.init();
		
		//ParticityInitializer.test();
	}
	
}
