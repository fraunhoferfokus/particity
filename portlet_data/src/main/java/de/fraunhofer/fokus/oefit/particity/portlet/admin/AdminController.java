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
package de.fraunhofer.fokus.oefit.particity.portlet.admin;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.annotation.ErrorsMethodArgumentResolver;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.Constants;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.forms.CategoryForm;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.portlet.BaseController;
import de.particity.impexp.ExportWriter;
import de.particity.impexp.ImportFailedException;
import de.particity.impexp.ImporterFactory;

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
			response.setRenderParameter("tab", data.getType());
			CustomCategoryServiceHandler.addCategoryEntry(data);
			data.clear();
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
	@RequestMapping(value = "view" /*, method = RequestMethod.POST,headers = "content-type=application/x-www-form-urlencoded"*/)
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
		
		String name = data != null ? data.getName() : "N/A";
		m_objLog.debug("addMainCategory::start("+name+")");

		if (data != null) {
				final E_CategoryType type = E_CategoryType.valueOf(data
				        .getType());
				CustomCategoryServiceHandler.addMainCategory(data, type);
				response.setRenderParameter("tab", data.getType());
				data.clear();
		}

		m_objLog.debug("addMainCategory::end("+name+")");
	}

	@RequestMapping(value = "view")
	@ActionMapping(params = "action=exportDatabase")
	public void exportDb(final ActionRequest request, final ActionResponse response,
	        final Model model) {
		m_objLog.debug("exportDatabase::start");
		
		ByteArrayOutputStream bout = null;
		//GZIPOutputStream zipout = null;
		
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) PortalUtil
					.getHttpServletRequest(request);
			HttpServletResponse httpServletResponse = (HttpServletResponse) PortalUtil
					.getHttpServletResponse(response);
	
			httpServletResponse.setHeader("Expires", "0");
			httpServletResponse.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			httpServletResponse.setHeader("Pragma", "public");
			
			
			ExportWriter export = new ExportWriter(getCompanyId(request));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
			String dateStr = sdf.format(Calendar.getInstance().getTime());
			String lrHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
			
			boolean toFileDone = false;
			// write to file
			if (lrHome != null) {
				File lrBackupDir = new File(lrHome+File.separator+"backup");
				if (!lrBackupDir.exists()) {
					lrBackupDir.mkdir();
				}
				if (lrBackupDir.exists()) {
					File backupFile = new File(lrBackupDir,"particity_"+dateStr+".xml");
					if (backupFile.exists())
						toFileDone = backupFile.delete();
					if (!backupFile.exists()) {
						toFileDone = backupFile.createNewFile();
						if (toFileDone) {
							m_objLog.debug("Writing out to "+backupFile.getAbsolutePath());
							FileOutputStream fout = new FileOutputStream(backupFile);
							export.writeToStream(fout);
							fout.flush();
							fout.close();
							//SessionMessages.add(request, "request_processed", "admin.jsp.db.export.success");
							response.setRenderParameter("exportFilename", backupFile.getAbsolutePath());
							Map<String, String> logs = export.getLog();
							export.cleanup();
							request.setAttribute("exportLogs", logs);
						} else {
							m_objLog.warn("Could not create backup file at "+backupFile.getAbsolutePath());
						}
					}
				} else {
					m_objLog.warn("Could not create backup directory at "+lrBackupDir.getAbsolutePath());
				}
				
			} else {
				m_objLog.warn("Could not evaluate liferay home");
			}
			// if for any reason the file could not be written, try to send it to the client
			if (!toFileDone) {
				// write to client
				bout = new ByteArrayOutputStream();
				export.writeToStream(bout);
				bout.flush();
					
				com.liferay.portal.kernel.servlet.ServletResponseUtil.sendFile(
						httpServletRequest, httpServletResponse, "particity_"+dateStr+".xml", bout.toByteArray());
				Map<String, String> logs = export.getLog();
				export.cleanup();
				request.setAttribute("exportLogs", logs);
			}
		} catch (Throwable t) {
			m_objLog.error("Error exporting data",t);
		} finally {
			if (bout != null) {
				try {
	                bout.close();
                } catch (IOException e) {
                }
			}
		}
		
		response.setRenderParameter("tab", "dbtools");
		m_objLog.debug("exportDatabase::end");
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

	@RequestMapping(value = "view")
	@ActionMapping(params = "action=importDatabase")
	public void importDatabase(ActionRequest request, ActionResponse response) {
	  m_objLog.debug("importDatabase::start");
	  UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
	  //Enumeration<?> paramEnum = uploadRequest.getParameterNames();
	  //File tempFile = uploadRequest.getFile("file");
	  if (uploadRequest.getSize("file") > 0) {
		  try {
			  InputStream fin = uploadRequest.getFileAsStream("file", true);
			  if (fin != null) {
				  Map<String,String> logs = ImporterFactory.importData(fin, getCompanyId(request), getGroupId(request), getUserId(request));
				  if (logs != null)
					  request.setAttribute("importLogs", logs);
			  }
		  } catch (ImportFailedException t) {
			  response.setRenderParameter("errorCode", t.getMessageCode());
			  //SessionErrors.add(request, t.getMessageCode());
			  m_objLog.warn("Import failed",t);
		  } catch (Throwable t) {
			  m_objLog.warn("Import failed",t);
			  //response.setRenderParameter("errorCode", ImportFailedException.);
		  }
		  
	  } 
	  
	  response.setRenderParameter("tab", "dbtools");
	  m_objLog.debug("importDatabase::end");
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
				CustomCategoryServiceHandler.deleteMainCategory(l_catId);
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
				CustomCategoryServiceHandler.deleteCategoryEntry(l_itemId);
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
		
		// get IDs of current session
		long groupId = getGroupId(request);
		long userId = getUserId(request);
		
		// check whether portal already initialized
		CustomPortalServiceHandler.checkInit(groupId, userId);
		
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
