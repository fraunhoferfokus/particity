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
package de.fraunhofer.fokus.oefit.adhoc.portlet.login.profile;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;
import de.fraunhofer.fokus.oefit.adhoc.portlet.BaseController;

/**
 * Controller for the user profile portlet
 * 
 * Redirects to login/profile by default
 *
 */
@Controller("profileController")
@RequestMapping("view")
public class ProfileController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(ProfileController.class);

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	@Autowired
	private ProfileFormValidator	m_objFormValidator;

	private void initData(final PortletRequest request, final Model model) {
		if (!model.containsAttribute("profileData")) {
			m_objLog.debug("Adding new profile form!");
			final ThemeDisplay themeDisplay = (ThemeDisplay) request
			        .getAttribute(WebKeys.THEME_DISPLAY);
			final User user = themeDisplay.getUser();
			final ProfileForm form = new ProfileForm();
			form.setMail(user.getEmailAddress());
			final String pass = user.getPassword();
			String formPass = "";
			for (int i = 0; i < pass.length(); i++) {
				formPass += "*";
			}
			form.setPass1(formPass);
			form.setPass2(formPass);
			model.addAttribute("profileData", form);
		} else {
			m_objLog.debug("Using existing profile form!");
		}
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
	@RequestMapping(value = "view")
	@RenderMapping
	public String render(final RenderRequest request,
	        final RenderResponse response, final Model model) {
		m_objLog.trace("render::start");
		String page = request.getParameter("jspPage");
		if (page == null) {
			page = "profile";
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
		this.initData(request, model);
		m_objLog.trace("render::end(" + page + ")");
		return page;
	}

	/**
	 * Save profile.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=saveProfile")
	public void saveProfile(
	        @Valid @ModelAttribute("profileData") final ProfileForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("addOffer::start");

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);

		this.m_objFormValidator.setThemeDisplay(themeDisplay);
		this.m_objFormValidator.validate(data, result);

		if (!result.hasErrors()) {
			CustomPortalServiceHandler.changeUserProfile(
			        themeDisplay.getUser(), data, result);
		}

		m_objLog.debug("saveProfile::end");
	}

}
