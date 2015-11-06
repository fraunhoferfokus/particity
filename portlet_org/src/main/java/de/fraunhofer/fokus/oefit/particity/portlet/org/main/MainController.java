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

import java.util.List;
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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

import de.fraunhofer.fokus.oefit.adhoc.custom.Constants;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomLockServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm;
import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;
import de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm;
import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.portlet.BaseController;
import de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * Controller for the organisation backend
 * 
 * Redirects to org/organization by default
 *
 */
@Controller("orgMainController")
@RequestMapping("view")
public class MainController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(MainController.class);

	/** The Constant DEFAULT_PAGE. */
	public static final String	 DEFAULT_PAGE	                    = "organization";

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	@Autowired
	private ProfileFormValidator	m_objProfileFormValidator;

	@Autowired
	private OfferFormValidator	 m_objOfferFormValidator;

	/**
	 * Adds the offer.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=addOffer")
	public void addOffer(@Valid @ModelAttribute("data") final OfferForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("addOffer::start");

		final ThemeDisplay themeDisplay = this.getThemeDisplay(request);

		this.m_objOfferFormValidator.setThemeDisplay(themeDisplay);
		this.m_objOfferFormValidator.validate(data, result);

		if (!result.hasErrors()) {
			final long orgId = CustomOrgServiceHandler
			        .getOrgIdByLiferayUser(themeDisplay);
			data.setOrgId(orgId);
			CustomOfferServiceHandler.addOffer(data);
			data.clear();
		} else {
			model.addAttribute("countries", CustomPersistanceServiceHandler
			        .getDataList(E_CategoryType.COUNTRIES, true));
			model.addAttribute("workhours", CustomPersistanceServiceHandler
			        .getDataList(E_CategoryType.OFFERTIME, false));
			response.setRenderParameter("jspPage", "../shared/offer");
		}

		m_objLog.debug("addOffer::end");
	}

	/**
	 * Adds the user.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=addUser")
	public void addUser(
	        @Valid @ModelAttribute("userData") final ProfileForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		final long orgId = CustomOrgServiceHandler
		        .getOrgIdByLiferayUser(themeDisplay);
		m_objLog.debug("addUser::start(" + orgId + ")");

		this.m_objProfileFormValidator.setThemeDisplay(themeDisplay);
		this.m_objProfileFormValidator.validate(data, result);

		if (!result.hasErrors() && orgId >= 0) {
			final AHOrg org = AHOrgLocalServiceUtil
			        .getOrganisationByOwnerMail(themeDisplay.getUser()
			                .getEmailAddress());
			if (org != null) {
				final User newUser = CustomPortalServiceHandler
				        .createPortalUser(data.getForename(),
				                data.getSurname(), data.getMail(),
				                themeDisplay.getCompanyId(),
				                themeDisplay.getLocale(),true);
				if (newUser != null) {
					AHOrgLocalServiceUtil.addOrganisationUser(orgId,
					        data.getMail());
				}
			}
			data.clear();
		}

		m_objLog.debug("addUser::end");
	}

	/**
	 * Copy offer.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=copyOffer")
	public void copyOffer(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final Long offerId = this.getOfferId(request);
		m_objLog.debug("copyOffer::start(" + offerId + ")");

		// ThemeDisplay themeDisplay = (ThemeDisplay)
		// request.getAttribute(WebKeys.THEME_DISPLAY);

		final OfferForm offer = CustomOfferServiceHandler.getOffer(offerId);
		offer.setOfferId(-1);

		model.addAttribute("countries", CustomPersistanceServiceHandler
		        .getDataList(E_CategoryType.COUNTRIES, true));
		model.addAttribute("workhours", CustomPersistanceServiceHandler
		        .getDataList(E_CategoryType.OFFERTIME, false));
		model.addAttribute("data", offer);
		response.setRenderParameter("jspPage", "../shared/offer");

		m_objLog.debug("copyOffer::end");
	}

	/**
	 * Delete offer.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=deleteOffer")
	public void deleteOffer(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("deleteOffer::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
			
		
		final Long offerId = this.getOfferId(request);
		m_objLog.debug("deleteOffer::start(" + offerId + ")");

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);

		if (!CustomLockServiceHandler.isLocked(AHOffer.class.getName(),
		        offerId, themeDisplay)) {
			try {
				AHOfferLocalServiceUtil.deleteAHOffer(offerId);
				// force unlock
				CustomLockServiceHandler.unlock(AHOffer.class.getName(),
				        offerId, themeDisplay);
			} catch (final Throwable e) {
				m_objLog.error(e);
			}
		}

		m_objLog.debug("deleteOffer::end");
	}

	/**
	 * Delete organisation.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=deleteOrganisation")
	public void deleteOrganisation(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("deleteOrganisation::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		final Long orgId = this.getOrgId(request);
		m_objLog.debug("deleteOrganisation::start(" + orgId + ")");

		if (orgId >= 0) {
			CustomOrgServiceHandler.deleteOrganisation(orgId);
		}

		m_objLog.debug("deleteOrganisation::end");
	}

	/**
	 * Edits the offer.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=editOffer")
	public void editOffer(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final Long offerId = this.getOfferId(request);
		m_objLog.debug("editOffer::start(" + offerId + ")");

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);

		if (offerId != null) {
			final OfferForm form = CustomOfferServiceHandler
			        .getOfferForEdit(offerId);
			m_objLog.info("Edit offer serving offer form " + form.getOfferId());
			model.addAttribute("data", form);
			model.addAttribute("workhours", CustomPersistanceServiceHandler
			        .getDataList(E_CategoryType.OFFERTIME, false));
			response.setRenderParameter("jspPage", "../shared/offer");
			response.setRenderParameter("actionType", "edit");
			CustomLockServiceHandler.lock(AHOffer.class.getName(),
			        form.getOfferId(), themeDisplay);
		}

		m_objLog.debug("editOffer::end");
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
	 * Gets the org data.
	 *
	 * @return the org data
	 */
	@ModelAttribute("orgData")
	public RegistrationForm getOrgData() {
		return new RegistrationForm();
	}

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
	 * Handle exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView handleException(final Exception ex,
	        final RenderRequest request, final RenderResponse response) {
		m_objLog.error(ex);
		final ModelAndView mv = new ModelAndView(DEFAULT_PAGE);

		// response.setParameter("tabId", "profile");
		// response.setParameter("setModel", Boolean.FALSE.toString());
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);
		final long orgId = CustomOrgServiceHandler
		        .getOrgIdByLiferayUser(themeDisplay);
		RegistrationForm formData = null;
		if (orgId >= 0) {
			formData = CustomOrgServiceHandler.getOrganisationForEdit(orgId);
		}
		if (formData != null) {
			mv.addObject("orgData", formData);
		}
		mv.addObject("countries", CustomPersistanceServiceHandler.getDataList(
		        E_CategoryType.COUNTRIES, true));
		mv.addObject("userData", new ProfileForm());
		mv.addObject("actionType", "edit");
		mv.addObject("tabId", "profile");
		SessionErrors.add(request, "org.form.addOrg.field.logoFile.exceed");
		return mv;
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
	 * Prepare offer.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=prepareOffer")
	public void prepareOffer(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("prepareOffer::start()");

		final ThemeDisplay themeDisplay = this.getThemeDisplay(request);
		final AHOrg org = CustomOrgServiceHandler
		        .getOrgByLiferayUser(themeDisplay);
		AHContact contact = null;

		final OfferForm form = new OfferForm();
		if (org != null) {
			try {
				contact = AHContactLocalServiceUtil.getAHContact(org
				        .getContactId());
			} catch (final Throwable e) {
				m_objLog.warn(e);
			}
			if (contact != null) {
				form.setContactSndForename(contact.getForename());
				form.setContactSndSurname(contact.getSurname());
				form.setContactSndMail(contact.getEmail());
				form.setContactSndTel(contact.getTel());
			}
		}
		final String siteContactSurname = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.MGMT_CONTACT_SURNAME);
		final String siteContactForename = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.MGMT_CONTACT_FORENAME);
		final String siteContactMail = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.MGMT_CONTACT_MAIL);
		final String siteContactTel = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.MGMT_CONTACT_TEL);
		form.setContactForename(siteContactForename);
		form.setContactSurname(siteContactSurname);
		form.setContactMail(siteContactMail);
		form.setContactTel(siteContactTel);

		model.addAttribute("data", form);
		model.addAttribute("countries", CustomPersistanceServiceHandler
		        .getDataList(E_CategoryType.COUNTRIES, true));
		model.addAttribute("workhours", CustomPersistanceServiceHandler
		        .getDataList(E_CategoryType.OFFERTIME, false));

		response.setRenderParameter("jspPage", "../shared/offer");

		m_objLog.debug("prepareOffer::end");
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
			page = DEFAULT_PAGE;
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
		final String sm = request.getParameter("setModel");
		boolean setModel = true;
		if (sm != null) {
			setModel = Boolean.parseBoolean(sm);
		}
		if (setModel) {
			final ThemeDisplay themeDisplay = (ThemeDisplay) request
			        .getAttribute(WebKeys.THEME_DISPLAY);
			final long orgId = CustomOrgServiceHandler
			        .getOrgIdByLiferayUser(themeDisplay);
			RegistrationForm formData = null;
			if (orgId >= 0) {
				formData = CustomOrgServiceHandler
				        .getOrganisationForEdit(orgId);
			}
			if (formData != null) {
				model.addAttribute("orgData", formData);
			}
		}
		model.addAttribute("actionType", "edit");
		m_objLog.trace("render::end(" + page + ")");
		return page;
	}

	/**
	 * Save offer.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=saveOffer")
	public void saveOffer(@Valid @ModelAttribute("data") final OfferForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("saveOffer::start(" + data.getOfferId() + ")");

		final ThemeDisplay themeDisplay = (ThemeDisplay) request
		        .getAttribute(WebKeys.THEME_DISPLAY);

		this.m_objOfferFormValidator.setThemeDisplay(themeDisplay);
		this.m_objOfferFormValidator.validate(data, result);

		if (!result.hasErrors()) {
			CustomOfferServiceHandler.addOffer(data);
			CustomLockServiceHandler.unlock(AHOffer.class.getName(),
			        data.getOfferId(), themeDisplay);
			data.clear();
		} else {
			response.setRenderParameter("actionType", "edit");
			response.setRenderParameter("jspPage", "../shared/offer");
		}

		m_objLog.debug("saveOffer::end");
	}

	/**
	 * Save organisation.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=saveOrganisation")
	public void saveOrganisation(
	        @Valid @ModelAttribute("orgData") final RegistrationForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("saveOrganisation::start");

		if (!result.hasErrors()) {
			CustomOrgServiceHandler.addOrganisation(this.getCompanyId(request),
			        this.getUserId(request), this.getGroupId(request), data);
		} else {
			m_objLog.info("Errors in form!");
			final List<ObjectError> errors = result.getAllErrors();
			for (final ObjectError error : errors) {
				m_objLog.info("Got error " + error.getClass().getName() + " : "
				        + error);
			}
		}

		response.setRenderParameter("tabId", "profile");
		response.setRenderParameter("setModel", Boolean.FALSE.toString());
		m_objLog.debug("saveOrganisation::end");
	}

	/**
	 * Unlock.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=unlock")
	public void unlock(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final Long offerId = this.getOfferId(request);
		m_objLog.debug("unlock::start(" + offerId + ")");

		if (offerId != null && offerId >= 0) {
			final ThemeDisplay themeDisplay = (ThemeDisplay) request
			        .getAttribute(WebKeys.THEME_DISPLAY);
			CustomLockServiceHandler.unlock(AHOffer.class.getName(), offerId,
			        themeDisplay);
		}

		m_objLog.debug("unlock::end");
	}

	/**
	 * View offer.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=viewOffer")
	public void viewOffer(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final Long offerId = this.getOfferId(request);
		m_objLog.debug("viewOffer::start(" + offerId + ")");

		if (offerId != null) {
			final OfferForm form = CustomOfferServiceHandler.getOffer(offerId);
			model.addAttribute("data", form);
			response.setRenderParameter("jspPage", "../shared/offer");
			response.setRenderParameter("actionType", "view");
		}

		m_objLog.debug("viewOffer::end");
	}

}
