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
package de.fraunhofer.fokus.oefit.adhoc.portlet.admin;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;

import de.fraunhofer.fokus.oefit.adhoc.custom.Constants;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.forms.CategoryForm;
import de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.adhoc.model.AHCategories;
import de.fraunhofer.fokus.oefit.adhoc.portlet.BaseController;
import de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil;

/**
 * Controller for basic administrative tasks
 * 
 * Redirects to admin/admin by default
 *
 */
@Controller("adminController")
@RequestMapping("view")
public class AdminController extends BaseController {

	private static final Log	 m_objLog	                        = LogFactoryUtil
	                                                                        .getLog(AdminController.class);

	private static final boolean	_CHECK_METHOD_ON_PROCESS_ACTION	= false;

	/**
	 * Adds the category entry.
	 *
	 * @param data the data
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@RequestMapping(value = "view")
	@ActionMapping(params = "action=addCategoryEntry")
	public void addCategoryEntry(
	        @ModelAttribute("data") final CategoryForm data,
	        final ActionRequest request, final ActionResponse response,
	        final Model model) {
		
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("addCategoryEntry::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("addCategoryEntry::start");

		if (data != null) {
			response.setRenderParameter("catId", data.getCat());
			response.setRenderParameter("catType", data.getType());
			final AHCatEntries entry = AHCatEntriesLocalServiceUtil
			        .addCategoryEntry(data.getCat(), data.getName(),
			                data.getDescr(), data.getParent());
			if (entry != null) {
				data.clear();
			}
		}

		m_objLog.debug("addCategoryEntry::end");
	}

	/**
	 * Adds the main category.
	 *
	 * @param data the data
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@RequestMapping(value = "view")
	@ActionMapping(params = "action=addMainCategory")
	public void addMainCategory(
	        @ModelAttribute("data") final CategoryForm data,
	        final ActionRequest request, final ActionResponse response,
	        final Model model) {
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("addMainCategory::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("addMainCategory::start");

		if (data != null) {
			try {

				AHCategories cat = null;
				final E_CategoryType type = E_CategoryType.valueOf(data
				        .getType());
				cat = AHCategoriesLocalServiceUtil.addCategory(data.getName(),
				        data.getDescr(), type);
				response.setRenderParameter("catType", data.getType());

				if (cat != null) {
					data.clear();
				}
			} catch (final SystemException e) {
				m_objLog.error(e);
				// response.setRenderParameter("error", "project.wrongcapture");
			}
		}

		m_objLog.debug("addMainCategory::end");
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@ModelAttribute("data")
	public CategoryForm getData() {
		return new CategoryForm();
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
	 * Removes the category.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@RequestMapping(value = "view")
	@ActionMapping(params = "action=removeCategory")
	public void removeCategory(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("removeCategory::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("removeCategory::start");

		final String catId = request.getParameter("catId");

		if (catId != null) {
			response.setRenderParameter("catId", catId);
			final Long l_catId = Long.parseLong(catId);
			if (l_catId != null) {
				AHCategoriesLocalServiceUtil.deleteCategoryById(l_catId);
			}
		}

		m_objLog.debug("removeCategory::end");
	}

	/**
	 * Removes the category entry.
	 *
	 * @param request the request
	 * @param response the response
	 * @param model the model
	 */
	@RequestMapping(value = "view")
	@ActionMapping(params = "action=removeCategoryEntry")
	public void removeCategoryEntry(final ActionRequest request,
	        final ActionResponse response, final Model model) {
		if (Constants.RESTRICT_TO_DEMO) {
			m_objLog.debug("removeCategoryEntry::denied()");
			SessionErrors.add(request, "common.demo.denied");
			return;
		}
		
		m_objLog.debug("removeCategoryEntry::start");

		final String catId = request.getParameter("catId");
		final String itemId = request.getParameter("itemId");

		if (catId != null) {
			response.setRenderParameter("catId", catId);
			final Long l_itemId = Long.parseLong(itemId);
			if (l_itemId != null) {
				CustomPersistanceServiceHandler
				        .deleteCategoryEntryById(l_itemId);
			}
		}

		m_objLog.debug("removeCategoryEntry::end");
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
		CustomPortalServiceHandler.checkInit(this.getThemeDisplay(request));
		String page = request.getParameter("jspPage");
		if (page == null) {
			page = "admin";
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
