package de.fraunhofer.fokus.oefit.adhoc.portlet.site;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * View controller.
 * 
 */
@Controller("siteController")
@RequestMapping("view")
public class SiteController {

	private static final Log m_objLog = LogFactoryUtil
			.getLog(SiteController.class);


	
	/**
	 * Render.
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "view")
	@RenderMapping
	public String render(final RenderRequest request, RenderResponse response, Model model) {
		m_objLog.trace("render::start");
		String page = "site";
		m_objLog.trace("render::end("+page+")");
		return page;
	}
	
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
}
