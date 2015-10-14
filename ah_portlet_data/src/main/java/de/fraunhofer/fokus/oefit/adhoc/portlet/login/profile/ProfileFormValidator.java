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

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * Validator for user profile forms
 */
@Component
public class ProfileFormValidator implements Validator {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(ProfileFormValidator.class);

	private ThemeDisplay	 m_objDisplay;

	/**
	 * Sets the theme display.
	 *
	 * @param display the new theme display
	 */
	public void setThemeDisplay(final ThemeDisplay display) {
		this.m_objDisplay = display;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> clazz) {
		return ProfileForm.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object target, final Errors errors) {
		final ProfileForm form = (ProfileForm) target;

		final User user = this.m_objDisplay.getUser();

		final String oldMail = user.getEmailAddress();
		final String newMail = form.getMail();
		if (newMail != null
		        && newMail.trim().length() > 0
		        && !newMail.toLowerCase().trim()
		                .equals(oldMail.toLowerCase().trim())) {
			final AHOrg newOrg = AHOrgLocalServiceUtil
			        .getOrganisationByOwnerMail(newMail.toLowerCase().trim());
			if (newOrg != null) {
				errors.rejectValue("mail", "notExistentErrorCode",
				        "common.form.profile.field.mail.orgexists");
			}
			User newUser = null;
			try {
				newUser = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil
				        .getDefaultCompanyId(), newMail.toLowerCase().trim());
				if (newUser != null) {
					errors.rejectValue("mail", "notExistentErrorCode",
					        "common.form.profile.field.mail.usrexists");
				}
			} catch (final Throwable e) {
			}
		}
		if (form.getPass1() != null && form.getPass2() != null) {
			if (!form.getPass1().equals(form.getPass2())) {
				errors.rejectValue("pass1", "notExistentErrorCode",
				        "common.form.profile.field.pass1.match");
				errors.rejectValue("pass2", "notExistentErrorCode",
				        "common.form.profile.field.pass1.match");
				form.setPass1("");
				form.setPass2("");
			}
		}

	}

}
