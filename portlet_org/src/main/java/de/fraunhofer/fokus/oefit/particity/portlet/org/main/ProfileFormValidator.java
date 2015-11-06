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
package de.fraunhofer.fokus.oefit.particity.portlet.org.main;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;

/**
 * Validator of profile forms for new organisation users
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

		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(
			        this.m_objDisplay.getCompanyId(), form.getMail());
		} catch (final Throwable t) {
		}

		if (user != null) {
			errors.rejectValue("mail", "notExistentErrorCode",
			        "org.intern.tabs.user.form.addUser.field.mail.exists");
		}

		/*
		 * if (form.getPass1() != null && form.getPass2() != null) { if
		 * (!form.getPass1().equals(form.getPass2())) {
		 * errors.rejectValue("pass1", "notExistentErrorCode",
		 * "org.intern.tabs.user.form.addUser.field.pass.invalid");
		 * errors.rejectValue("pass2", "notExistentErrorCode",
		 * "org.intern.tabs.user.form.addUser.field.pass.invalid");
		 * form.setPass1(""); form.setPass2(""); } } else {
		 * errors.rejectValue("pass1", "notExistentErrorCode",
		 * "org.intern.tabs.user.form.addUser.field.pass.empty"); }
		 */

	}

}
