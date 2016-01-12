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
package de.fraunhofer.fokus.oefit.particity.portlet.login.form;

import java.util.List;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

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

import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;
import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;
import de.fraunhofer.fokus.oefit.particity.portlet.BaseController;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;

/**
 * Controller for the login portlet
 * 
 * Redirects to login/form by default
 *
 */
@Controller("loginController")
@RequestMapping("view")
public class LoginController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(LoginController.class);

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	/**
	 * Gets the user data.
	 *
	 * @return the user data
	 */
	@ModelAttribute("userData")
	public ProfileForm getUserData() {
		return new ProfileForm();
	}

	/**
	 * Checks if is check method on process action.
	 *
	 * @return true, if is check method on process action
	 */
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	/**
	 * Login.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=login")
	public void login(@Valid @ModelAttribute("data") final ProfileForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("login::start(" + data.getMail() + ")");

		if (!result.hasErrors()) {
			try {
				/*
				 * ClassLoader pcl = PortalClassLoaderUtil.getClassLoader();
				 * Class lClass =
				 * pcl.loadClass("com.liferay.portlet.login.util.LoginUtil");
				 * Method method = lClass.getDeclaredMethod("login",
				 * HttpServletRequest.class, HttpServletResponse.class,
				 * String.class, String.class, Boolean.TYPE, String.class);
				 * method.invoke(null,
				 * PortalUtil.getHttpServletRequest(request),
				 * PortalUtil.getHttpServletResponse(response), data.getMail(),
				 * data.getPass1(), false, CompanyConstants.AUTH_TYPE_EA);
				 */

				/*
				 * Class<?> loginUtilClass = ClassResolverUtil
				 * .resolveByPortalClassLoader(LOGIN_UTIL_FQCN); MethodKey
				 * methodKey = new MethodKey(loginUtilClass, LOGIN_METHOD,
				 * LOGIN_PARAM_TYPES); PortalClassInvoker.invoke(false,
				 * methodKey, PortalUtil.getHttpServletRequest(request),
				 * PortalUtil.getHttpServletResponse(response), data.getMail(),
				 * data.getPass1(), true, CompanyConstants.AUTH_TYPE_EA);
				 */
				final ThemeDisplay td = this.getThemeDisplay(request);
				final int status = UserLocalServiceUtil
				        .authenticateByEmailAddress(
				                td.getCompanyId(), data.getMail(),
				                data.getPass1(),
				                null, null, null);

				if (status == Authenticator.SUCCESS) {

					final User user = UserLocalServiceUtil
					        .getUserByEmailAddress(
					                td.getCompanyId(), data.getMail());
					// Long userId =
					// UserLocalServiceUtil.getUserIdByEmailAddress(td.getCompanyId(),
					// data.getMail());
					final String userIdString = String
					        .valueOf(user.getUserId());

					final HttpServletRequest hrequest = PortalUtil
					        .getHttpServletRequest(request);
					final HttpSession session = hrequest.getSession();

					session.setAttribute("j_username", userIdString);
					session.setAttribute("j_password", user.getPassword());
					session.setAttribute("j_remoteuser", userIdString);

					E_Role erole = null;

					if (user != null && user.getEmailAddress() != null) {
						List<Role> roles = null;
						try {
							roles = user.getRoles();
						} catch (final SystemException e) {
						}
						if (roles != null) {
							for (final Role role : roles) {
								erole = CustomPortalServiceHandler.matchesRole(role);
								if (erole != null) {
									break;
								}
							}
						}
					}

					if (erole != null) {
						response.sendRedirect(erole.getHomeUrl());
					}

				} else {

					final PortletConfig portletConfig = (PortletConfig) request
					        .getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
					final LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
					SessionMessages
					        .add(request,
					                liferayPortletConfig.getPortletId()
					                        + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

					// SessionMessages.add(request,
					// getThemeDisplay(request).getPortletDisplay().getPortletName()
					// + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					m_objLog.debug("Login failed!");
					SessionErrors.add(request, "common.form.login.failed");
					// result.addError(new FieldError("data", "mail",
					// "common.form.login.failed"));
				}

			} catch (final Throwable t) {
				m_objLog.warn(t);
			}

			/*
			 * String className =
			 * "com.liferay.portlet.login.action.LoginAction"; PortletConfig
			 * portletConfig = (PortletConfig)
			 * request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			 * NoRedirectActionResponse noRedirectActionResponse = new
			 * NoRedirectActionResponse(response); try {
			 * PortletActionInvoker.processAction( className, portletConfig,
			 * request, noRedirectActionResponse); } catch (Throwable e) {
			 * m_objLog.error(e, e); } if
			 * (!Validator.isNull(noRedirectActionResponse.getRedirectLocation
			 * ())) { String redirect = PortalUtil.getPathMain() +
			 * "/portal/login?login=" + data.getMail() + "&password=" +
			 * data.getPass1() + "&rememberMe=true"; try {
			 * response.sendRedirect(redirect); } catch (Throwable e) {
			 * m_objLog.warn(e); } }
			 */
		}

		m_objLog.debug("login::end");
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
		String page = request.getParameter("jspPage");
		if (page == null) {
			page = "form";
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

}
