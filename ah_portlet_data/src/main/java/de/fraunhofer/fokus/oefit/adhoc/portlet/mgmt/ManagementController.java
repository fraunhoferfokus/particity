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
package de.fraunhofer.fokus.oefit.adhoc.portlet.mgmt;

import java.net.URL;

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
import com.liferay.portal.theme.ThemeDisplay;

import de.fraunhofer.fokus.oefit.adhoc.custom.Constants;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomLockServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_SocialMediaPlugins;
import de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm;
import de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm;
import de.fraunhofer.fokus.oefit.adhoc.portlet.BaseController;
import de.fraunhofer.fokus.oefit.adhoc.socialize.I_SocialMediaClient;
import de.fraunhofer.fokus.oefit.adhoc.socialize.SocialMediaFactory;
import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * Controller for the management backend
 * 
 * Redirects to mgmt/mgmt by default
 *
 */
@Controller("adminController")
@RequestMapping("view")
public class ManagementController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(ManagementController.class);

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	@Autowired
	private OfferFormValidator	 m_objOfferFormValidator;

	/**
	 * Approve offer.
	 *
	 * @param data the data
	 * @param result the result
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=approveOffer")
	public void approveOffer(
	        @Valid @ModelAttribute("data") final OfferForm data,
	        final BindingResult result, final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("approveOffer::start(" + data.getOfferId() + ")");

		this.m_objOfferFormValidator.validate(data, result);

		if (result.hasErrors()) {
			response.setRenderParameter("jspPage", "../shared/offer");
			response.setRenderParameter("actionType", "approve");
		} else {
			if (data.getOfferId() >= 0) {

				final ThemeDisplay themeDisplay = (ThemeDisplay) request
				        .getAttribute(WebKeys.THEME_DISPLAY);

				if (!CustomLockServiceHandler.isLocked(AHOffer.class.getName(),
				        data.getOfferId(), themeDisplay)) {
					try {
						if (data.isRequireAgencyContact()) {
							m_objLog.debug("Saving with agency contact!");
							final AHContact contact = CustomPersistanceServiceHandler
							        .addContact(data.getContactForename(),
							                data.getContactSurname(),
							                data.getContactMail(),
							                data.getContactTel());
							AHOfferLocalServiceUtil.setSndContact(
							        data.getOfferId(), contact.getContactId(),
							        E_OfferStatus.VALIDATED);
						} else {
							m_objLog.debug("Saving with orga contact!");
							AHOfferLocalServiceUtil.setOfferStatus(
							        data.getOfferId(), E_OfferStatus.VALIDATED);
						}
						// force unlock
						CustomLockServiceHandler.unlock(
						        AHOffer.class.getName(), data.getOfferId(),
						        themeDisplay);
					} catch (final Throwable e) {
						m_objLog.error(e);
					}
				}
			}
			// redirect to offer tab
			response.setRenderParameter("tabId", "offer");
		}

		m_objLog.debug("approveOffer::end");
	}

	/**
	 * Approve org.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=approveOrg")
	public void approveOrg(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("approveOrg::start");

		final Long l_orgId = this.getOrgId(request);
		if (l_orgId != null) {
			AHOrgLocalServiceUtil.setOrganisationStatus(l_orgId,
			        E_OrgStatus.VALIDATED);
		}

		m_objLog.debug("approveOrg::end");
	}

	/**
	 * Delete org.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=deleteOrg")
	public void deleteOrg(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("deleteOrg::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("deleteOrg::start");

		
		
		final Long l_orgId = this.getOrgId(request);
		if (l_orgId != null) {
			AHOrgLocalServiceUtil.deleteOrganisation(l_orgId);
		}

		m_objLog.debug("deleteOrg::end");
	}

	/**
	 * Disable offer.
	 *
	 * @param data the data
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=disableOffer")
	public void disableOffer(@ModelAttribute("data") final OfferForm data,
	        final ActionRequest request, final ActionResponse response,
	        final Model model) {
		m_objLog.debug("disableOffer::start(" + data.getOfferId() + ")");

		if (data.getOfferId() >= 0) {

			final ThemeDisplay themeDisplay = (ThemeDisplay) request
			        .getAttribute(WebKeys.THEME_DISPLAY);

			if (!CustomLockServiceHandler.isLocked(AHOffer.class.getName(),
			        data.getOfferId(), themeDisplay)) {
				try {
					AHOfferLocalServiceUtil.setOfferStatus(data.getOfferId(),
					        E_OfferStatus.DISABLED);
					// force unlock
					CustomLockServiceHandler.unlock(AHOffer.class.getName(),
					        data.getOfferId(), themeDisplay);
				} catch (final Throwable e) {
					m_objLog.error(e);
				}
			}
		}

		// redirect to offer tab
		response.setRenderParameter("tabId", "offer");

		m_objLog.debug("disableOffer::end");
	}

	/**
	 * Disable org.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=disableOrg")
	public void disableOrg(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("disableOrg::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("disableOrg::start");

		final Long l_orgId = this.getOrgId(request);
		if (l_orgId != null) {
			AHOrgLocalServiceUtil.setOrganisationStatus(l_orgId,
			        E_OrgStatus.DISABLED);
		}

		m_objLog.debug("disableOrg::end");
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

		if (offerId != null) {
			final ThemeDisplay themeDisplay = (ThemeDisplay) request
			        .getAttribute(WebKeys.THEME_DISPLAY);
			final OfferForm form = CustomOfferServiceHandler.getOffer(offerId);
			m_objLog.debug("Edit offer with agency contact: "
			        + form.isRequireAgencyContact());
			model.addAttribute("data", form);
			response.setRenderParameter("jspPage", "../shared/offer");
			response.setRenderParameter("actionType", "approve");
			CustomLockServiceHandler.lock(AHOffer.class.getName(),
			        form.getOfferId(), themeDisplay);
		}

		m_objLog.debug("editOffer::end");
	}

	/**
	 * Export orgs.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=exportOrg")
	public void exportOrgs(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("exportOrgs::start");

		this.copyRenderParameter("page", request, response);
		this.copyRenderParameter("tabId", request, response);

		this.sendFile("organisations.csv",
		        "application/comma-separated-values",
		        CustomOrgServiceHandler.getOrganisationsAsCsv(), request,
		        response);

		m_objLog.debug("exportOrgs::end");
	}

	/**
	 * Export user.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=exportUser")
	public void exportUser(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("exportUser::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("exportUser::start");

		this.copyRenderParameter("page", request, response);
		this.copyRenderParameter("tabId", request, response);

		this.sendFile("users.csv", "application/comma-separated-values",
		        CustomPersistanceServiceHandler.getUsersAsCsv(), request,
		        response);

		m_objLog.debug("exportUser::end");
	}

	/**
	 * Checks if is check method on process action.
	 *
	 * @return true, if is check method on process action
	 */
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	@ActionMapping(params = "action=publishSocial")
	private void publishSocial(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("publishSocial::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		final Long offerId = this.getOfferId(request);
		final String strType = request.getParameter("type");
		m_objLog.debug("publishSocial::start(" + offerId + "," + strType + ")");

		this.copyRenderParameter("tabId", request, response);
		this.copyRenderParameter("page", request, response);
		this.copyRenderParameter("column", request, response);
		this.copyRenderParameter("order", request, response);

		E_SocialMediaPlugins smtype = null;
		if (strType != null) {
			try {
				smtype = E_SocialMediaPlugins.valueOf(strType);
			} catch (final Throwable t) {
			}
			if (smtype != null) {
				final I_SocialMediaClient client = SocialMediaFactory
				        .getClient(smtype);
				if (client != null) {
					final String offerUrlStr = CustomPortalServiceHandler
					        .getConfigValue(E_ConfigKey.MGMT_PATH_OFFER_PERMALINK)
					        + offerId;
					URL offerUrl = null;
					try {
						offerUrl = new URL(offerUrlStr);
					} catch (final Throwable t) {
						m_objLog.error("Could not generate offer URL "
						        + offerUrlStr);
					}
					if (offerUrl != null) {
						final boolean sent = client.publishOffer(offerUrl,
						        offerId);
						if (sent) {
							AHOfferLocalServiceUtil.addSocialStatus(offerId,
							        smtype);
						} else {
							SessionErrors.add(request,
							        "common.socialize.plugin.publishfail");
						}
					}
				}
			}
		}

		m_objLog.debug("publishSocial::end()");
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
			page = "mgmt";
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
		/*
		 * for (E_ConfigCategory cat: E_ConfigCategory.values()) { if
		 * (cat.getRole().equals(E_Role.MGMT)) {
		 * model.addAttribute(cat.toString().toLowerCase()+"CfgData",
		 * CustomServiceHandler.getConfig(cat)); } }
		 */
		m_objLog.trace("render::end(" + page + ")");
		return page;
	}

	@ActionMapping(params = "action=saveCfg")
	private void saveCfg(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("saveCfg::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("saveCfg::start()");
		response.setRenderParameter("tabId", "cfg");
		// response.setRenderParameter("cfgId",
		// form.getCategory().toString().toLowerCase());

		CustomPortalServiceHandler.saveConfig(request);
		m_objLog.debug("saveCfg::end()");
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
		// redirect to offer tab
		response.setRenderParameter("tabId", "offer");

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
			// model.addAttribute("workhours",getWorkhours());
			// model.addAttribute("countries",getCountries());
			response.setRenderParameter("jspPage", "../shared/offer");
			response.setRenderParameter("actionType", "view");
		}

		m_objLog.debug("viewOffer::end");
	}

	/**
	 * View org.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=viewOrg")
	public void viewOrg(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("viewOrg::start");

		final Long l_orgId = this.getOrgId(request);
		if (l_orgId != null) {
			final String actionType = request.getParameter("actionType");
			if (actionType != null) {
				response.setRenderParameter("actionType", actionType);
			}
			final RegistrationForm form = CustomOrgServiceHandler
			        .getOrganisation(l_orgId);
			model.addAttribute("data", form);
			response.setRenderParameter("jspPage", "orgDetail");
		}

		m_objLog.debug("viewOrg::end");
	}

}
