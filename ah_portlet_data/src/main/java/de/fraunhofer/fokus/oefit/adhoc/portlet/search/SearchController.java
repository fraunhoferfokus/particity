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
package de.fraunhofer.fokus.oefit.adhoc.portlet.search;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.portlet.BaseController;

/**
 * Controller for the frontend search
 * 
 * Redirects to search/searchBy{Type,Cat,Org} by default, depending on provided parameters
 *
 */
@Controller("searchController")
@RequestMapping("view")
public class SearchController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(SearchController.class);

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
	        final RenderResponse response, final Model model) {
		m_objLog.trace("render::start");
		String page = request.getParameter("jspPage");
		if (page == null) {
			final String orgIdStr = request.getParameter("orgId");
			final PortletPreferences prefs = request.getPreferences();
			final String catIdsStr = prefs.getValue("categoryId", "-1");
			if (orgIdStr != null && orgIdStr.trim().length() > 0) {
				page = "searchByOrg";
			} else if (catIdsStr.equals("-1")) {
				page = "searchByType";
			} else {
				page = "searchByCat";
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
		}
		m_objLog.trace("render::end(" + page + ")");
		return page;
	}

	/**
	 * Show offer.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=showOffer")
	public void showOffer(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		m_objLog.debug("showOffer::start()");

		final Long offerId = this.getOfferId(request);
		if (offerId != null) {
			// OfferForm form = CustomServiceHandler.getOffer(offerId);
			// model.addAttribute("data",form);
			this.copyRenderParameter("offerId", request, response);
			this.copyRenderParameter("modal", request, response);
			response.setRenderParameter("jspPage", "searchresult");
		}

		m_objLog.debug("showOffer::end");
	}

}
