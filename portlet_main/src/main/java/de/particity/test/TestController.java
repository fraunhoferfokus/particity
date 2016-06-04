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
package de.particity.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
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

import de.particity.model.I_OfferModel;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.impl.Offer;
import de.particity.model.repository.OfferRepository;

/**
 * Controller for the header portlet
 * 
 * Redirects to site/header by default
 *
 */
@Controller("testController")
@RequestMapping("view")
public class TestController {

	@Inject 
	private I_OfferController offerRepo;
	
	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(TestController.class);

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
	        final RenderResponse response,
	        final Model model) {
		m_objLog.trace("render::start");
		List<I_OfferModel> offers = offerRepo.get(0, 10);
		String page = "init";
		m_objLog.trace("render::end(" + page + ")");

		return page;
	}
	
	@RequestMapping(value = "view")
	@ActionMapping(params="action=initParticity")
	public void initParticity(final ActionRequest request,
	        final ActionResponse response,
	        final Model model) {
		m_objLog.trace("initParticity::start");

		
		m_objLog.trace("initParticity::end()");
	}

	@PostConstruct
	public void init() {
		
	}
	
}
