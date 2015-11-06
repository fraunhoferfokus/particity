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
package de.fraunhofer.fokus.oefit.particity.portlet.user.main;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.fraunhofer.fokus.oefit.particity.portlet.BaseController;
import de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil;

/**
 * Controller for the per-user newsletter configuration
 * 
 * Redirects to user/user by default
 *
 */
@Controller("adminController")
@RequestMapping("view")
public class MainController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(MainController.class);

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	/**
	 * Approve sub.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=approveSub")
	public void approveSub(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final Long subId = this.getSubId(request);
		m_objLog.debug("approveSub::start(" + subId + ")");

		final String uuid = request.getParameter("uuid");
		if (uuid != null) {
			response.setRenderParameter("uuid", uuid);
		}
		if (subId != null) {
			AHSubscriptionLocalServiceUtil.setSubscriptionStatus(subId,
			        E_SubscriptionStatus.VALIDATED);
		}

		m_objLog.debug("approveSub::end");
	}

	/**
	 * Delete sub.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@ActionMapping(params = "action=deleteSub")
	public void deleteSub(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		final Long subId = this.getSubId(request);
		m_objLog.debug("deleteSub::start(" + subId + ")");

		final String uuid = request.getParameter("uuid");
		if (uuid != null) {
			response.setRenderParameter("uuid", uuid);
		}
		if (subId != null) {
			AHSubscriptionLocalServiceUtil.removeSubscription(subId);
		}

		m_objLog.debug("deleteSub::end");
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
			page = "user";
		}
		/*
		 * String uuid = request.getParameter("uuid"); if (uuid != null) {
		 * m_objLog.info("Got uuid: "+uuid); } else { uuid =
		 * PortalUtil.getHttpServletRequest(request).getParameter("uuid");
		 * m_objLog.info("Got uuid from servlet: "+uuid); }
		 */
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
