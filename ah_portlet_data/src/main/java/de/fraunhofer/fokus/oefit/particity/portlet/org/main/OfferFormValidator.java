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
import com.liferay.portal.theme.ThemeDisplay;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm;

/**
 * Validator for offer forms edited by the organisation
 */
@Component
public class OfferFormValidator implements Validator {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(OfferFormValidator.class);

	/**
	 * Sets the theme display.
	 *
	 * @param display the new theme display
	 */
	public void setThemeDisplay(final ThemeDisplay display) {
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(final Class<?> clazz) {
		return OfferForm.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(final Object target, final Errors errors) {
		final OfferForm form = (OfferForm) target;

		final boolean isEdit = form.getOfferId() >= 0;

		final long now = CustomServiceUtils.time();
		final String pubDateStr = form.getPublishDate();
		final String expDateStr = form.getExpireDate();

		// String nowStr = CustomServiceHandler.formatDate(now.getTime());
		long pubDate = -1;
		long expDate = -1;
		final String pubTime = form.getPublishTime();
		if (pubTime != null && pubTime.trim().length() > 0) {
			pubDate = CustomServiceUtils.parseZoneDateTime(pubDateStr, pubTime);
			if (pubDate > 0) {
				if (!isEdit && pubDate <= now) {
					// SimpleDateFormat sdf = new
					// SimpleDateFormat("dd.MM.yyyy HH:mm");
					// m_objLog.info("DATE now: "+sdf.format(now.getTime())+", DATE pub: "+sdf.format(pubDate));
					// m_objLog.info("DATE now: "+now.getTimeInMillis()+", DATE pub: "+pubDate.getTime());
					errors.rejectValue("publishDate", "notExistentErrorCode",
					        "org.form.offer.field.publishDate.past");
				}
			} else {
				errors.rejectValue("publishDate", "notExistentErrorCode",
				        "org.form.offer.field.publishDate.invalid");
			}
		} else {
			errors.rejectValue("publishTime", "notExistentErrorCode",
			        "org.form.offer.field.publishTime.invalid");
		}
		final String expTime = form.getExpireTime();
		if (expTime != null && expTime.trim().length() > 0) {
			expDate = CustomServiceUtils.parseZoneDateTime(expDateStr, expTime);
			if (expDate > 0) {
				if (!isEdit && expDate <= now) {
					errors.rejectValue("expireDate", "notExistentErrorCode",
					        "org.form.offer.field.expireDate.past");
				}
			} else {
				errors.rejectValue("expireDate", "notExistentErrorCode",
				        "org.form.offer.field.expireDate.invalid");
			}
		} else {
			errors.rejectValue("expireTime", "notExistentErrorCode",
			        "org.form.offer.field.expireTime.invalid");
		}

		if (expDate > 0 && pubDate > 0 && expDate < pubDate) {
			errors.rejectValue("expireDate", "notExistentErrorCode",
			        "org.form.offer.field.expireDate.inverted");
			errors.rejectValue("publishDate", "notExistentErrorCode",
			        "org.form.offer.field.publishDate.inverted");
		}
		if (form.getAddrLat() == null || form.getAddrLon() == null || (form.getAddrLat() == 0 && form.getAddrLon() == 0)) {
			errors.rejectValue("addrStreet", "notExistentErrorCode",
			        "org.form.offer.field.addrStreet.mapError");
		}

		final boolean useAgencyContact = form.isRequireAgencyContact();

		if (!useAgencyContact) {
			String value = form.getContactForename();
			if (value == null || value.trim().length() == 0) {
				errors.rejectValue("contactForename", "notExistentErrorCode",
				        "org.form.offer.field.contactFN.empty");
			}
			value = form.getContactSurname();
			if (value == null || value.trim().length() == 0) {
				errors.rejectValue("contactSurname", "notExistentErrorCode",
				        "org.form.offer.field.contactSN.empty");
			}
			value = form.getContactMail();
			if (value == null || value.trim().length() == 0) {
				errors.rejectValue("contactMail", "notExistentErrorCode",
				        "org.form.offer.field.contactMail.empty");
			}
			value = form.getContactTel();
			if (value == null || value.trim().length() == 0) {
				errors.rejectValue("contactTel", "notExistentErrorCode",
				        "org.form.offer.field.contactTel.empty");
			}
		}
	}

}
