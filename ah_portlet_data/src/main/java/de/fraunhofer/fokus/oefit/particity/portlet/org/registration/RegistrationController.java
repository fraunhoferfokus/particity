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
package de.fraunhofer.fokus.oefit.particity.portlet.org.registration;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.portlet.BaseController;

/**
 * Controller for the organisation registration form
 * 
 * Redirects to shared/register by default
 *
 */
@Controller("orgRegistrationController")
@RequestMapping("view")
public class RegistrationController extends BaseController {

	private static final Log	      m_objLog	                      = LogFactoryUtil
	                                                                          .getLog(RegistrationController.class);

	private static final boolean	  _CHECK_METHOD_ON_PROCESS_ACTION	= false;

	@Autowired
	private RegistrationFormValidator	m_objFormValidator;

	/**
	 * Adds the organisation.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=addOrganisation")
	public void addOrganisation(
	        @Valid @ModelAttribute("orgData") final RegistrationForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("addOrganisation::start");

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);

		if (!result.hasErrors()) {
			this.m_objFormValidator.setThemeDisplay(themeDisplay);
			this.m_objFormValidator.validate(data, result);
		}

		if (!result.hasErrors()) {
			final User user = CustomPortalServiceHandler.createPortalUser(
			        data.getName(), data.getHolder(), data.getMail(),
			        themeDisplay.getCompanyId(), themeDisplay.getLocale(), true);
			if (user != null) {
				final AHOrg org = CustomOrgServiceHandler.addOrganisation(
				        this.getCompanyId(request), -1,
				        this.getGroupId(request), data);
				if (org == null) {
					SessionErrors.add(request, "org.form.addOrg.failed.org");
				}
				else {
					response.setRenderParameter("jspPage", "registerSuccess");
				}

			}
			else {
				SessionErrors.add(request, "org.form.addOrg.failed.user");
			}

		}

		m_objLog.debug("addOrganisation::end");
	}

	/**
	 * Gets the countries.
	 *
	 * @return the countries
	 */
	@ModelAttribute("countries")
	public Map<Long, String> getCountries() {
		return CustomPersistanceServiceHandler.getDataList(
		        E_CategoryType.COUNTRIES, true);
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@ModelAttribute("orgData")
	public RegistrationForm getData() {
		return new RegistrationForm();
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
	 * Render.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 * @return the string
	 */
	@RenderMapping
	public String render(final RenderRequest request,
	        final RenderResponse response, final Model model) {
		m_objLog.trace("render::start");
		String page = request.getParameter("jspPage");
		if (page == null) {
			page = "../shared/register";
			if (this.isLoggedInOrg(request)) {
				page = "registerLoggedIn";
			}
		}
		final String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", error);
			m_objLog.warn("Handing over error " + error);
			final String ePage = request.getParameter("errorPage");
			if (ePage != null) {
				page = ePage;
			}
		} /*
		 * else { model.addAttribute("data", new BerliosProject()); }
		 */
		m_objLog.trace("render::end(" + page + ")");
		return page;
	}

}
