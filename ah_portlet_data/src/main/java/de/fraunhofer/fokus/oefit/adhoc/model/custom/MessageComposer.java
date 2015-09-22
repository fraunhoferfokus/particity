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
package de.fraunhofer.fokus.oefit.adhoc.model.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOrg;
import de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription;

/**
 * The message composer uses the configuration backend to replace
 * variables and placeholders inside notification templates with actual content
 * (i.e. subscription emails with offer lists; reminder emails for organisations)
 */
public class MessageComposer {

	private static final Log	   m_objLog	  = LogFactoryUtil
	                                                  .getLog(MessageComposer.class);

	private static MessageComposer	m_objSelf	= null;

	/**
	 * Gets the single instance of MessageComposer.
	 *
	 * @return single instance of MessageComposer
	 */
	public synchronized static MessageComposer getInstance() {
		if (m_objSelf == null) {
			m_objSelf = new MessageComposer();
		}

		return m_objSelf;
	}

	private static String replaceVar(final String name, String src, String val) {
		if (val == null) {
			val = "null";
		}
		// normalize
		src = src.replaceAll("\\[\\$", "[@");
		src = src.replaceAll("\\$\\]", "@]");
		// m_objLog.info("Replace >>"+name+"<< in >>"+src+"<< for >>"+val+"<<");
		// src = src.replaceAll("\\[\\$"+name+"\\$\\]",
		// Matcher.quoteReplacement(val));
		// System.out.println("First replace: "+src);
		return src.replaceAll("\\[@" + name + "(:[^@]+)*@\\]",
		        Matcher.quoteReplacement(val));
	}

	private Company	m_objDefCompany	    = null;

	private String	m_strPortalURL	    = null;

	private String	m_strPortalName	    = null;

	private String	m_strOfferPermaBase	= null;

	private MessageComposer() {
		this.refreshCfg();
	}

	/**
	 * Gets the parameters.
	 *
	 * @param name the name
	 * @param src the src
	 * @return the parameters
	 */
	public Map<String, String> getParameters(final String name, final String src) {
		final Map<String, String> result = new HashMap<String, String>();

		final String begStr = "[@" + name + ":";
		final int beg = src.indexOf(begStr);
		if (beg >= 0) {
			final int end = src.indexOf("@]", beg);
			if (end >= 0) {
				final String params = src.substring(beg + begStr.length(), end);
				final String[] paramSplit = params.split(":");
				if (paramSplit.length > 0) {
					for (final String param : paramSplit) {
						final String[] innerSplit = param.split("=");
						if (innerSplit.length > 1) {
							result.put(innerSplit[0], innerSplit[1]);
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * Refresh cfg.
	 */
	public void refreshCfg() {
		try {
			this.m_strPortalName = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.MGMT_CONTACT_NAME);
			this.m_strOfferPermaBase = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.MGMT_PATH_OFFER_PERMALINK);
			this.m_objDefCompany = CompanyLocalServiceUtil
			        .getCompany(PortalUtil
			                .getDefaultCompanyId());
			if (this.m_objDefCompany == null)
				this.m_objDefCompany = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			this.m_strPortalURL = PortalUtil.getPortalURL(
			        this.m_objDefCompany.getVirtualHostname(),
			        PortalUtil.getPortalPort(), false);
			m_objLog.info("Portal URL is "+this.m_strPortalURL);
		} catch (final Throwable e) {
			m_objLog.error(e);
		}
	}

	/**
	 * Replace common.
	 *
	 * @param from the from
	 * @param to the to
	 * @param src the src
	 * @return the string
	 */
	public String replaceCommon(final String from, final String to,
	        final String src) {
		String result = replaceVar("FROM_ADDRESS", src, from);
		result = this.replacePortalValues(result);
		result = replaceVar("TO_ADDRESS", result, to);
		return result;
	}

	/**
	 * Replace news values.
	 *
	 * @param src the src
	 * @param sub the sub
	 * @return the string
	 */
	public String replaceNewsValues(final String src, final AHSubscription sub) {
		return replaceVar("TO_UUID", src, sub.getUuid());
	}

	/**
	 * Replace offer list.
	 *
	 * @param body the body
	 * @param list the list
	 * @return the string
	 */
	public String replaceOfferList(final String body, final List list) {
		String result = body;

		if (body.contains("OFFER_LIST_EXT")) {
			final Map<String, String> params = this.getParameters(
			        "OFFER_LIST_EXT", body);
			String basePath = params.get("baseUrl");
			if (basePath == null) {
				basePath = "";
			}
			basePath = "[$PORTAL_URL$]" + basePath + "/-/search/result/";

			final StringBuffer sb = new StringBuffer("<ul>");

			if (list != null) {
				for (final Object o : list) {
					final AHOffer offer = (AHOffer) o;
					sb.append("<li><a href='").append(basePath)
					        .append(offer.getOfferId()).append("'>")
					        .append(offer.getTitle()).append("</a>")
					        .append("</li>");
				}
			}
			sb.append("</ul>");
			result = replaceVar("OFFER_LIST_EXT", body, sb.toString());
		} else if (body.contains("OFFER_LIST")) {
			final StringBuffer sb = new StringBuffer("<ul>");

			if (list != null) {
				for (final Object o : list) {
					final AHOffer offer = (AHOffer) o;
					sb.append("<li>").append(offer.getTitle()).append("</li>");
				}
			}
			sb.append("</ul>");
			result = replaceVar("OFFER_LIST", body, sb.toString());
		}

		return result;
	}

	/**
	 * Replace offer size.
	 *
	 * @param body the body
	 * @param list the list
	 * @return the string
	 */
	public String replaceOfferSize(final String body, final List list) {
		return replaceVar("OFFER_COUNT", body, Integer.toString(list.size()));
	}

	/**
	 * Replace offer values.
	 *
	 * @param src the src
	 * @param offer the offer
	 * @return the string
	 */
	public String replaceOfferValues(String src, final AHOffer offer) {
		src = replaceVar("OFFER_URL", src,
		        this.m_strOfferPermaBase + offer.getOfferId());
		return replaceVar("OFFER_NAME", src, offer.getTitle());
	}

	/**
	 * Replace org values.
	 *
	 * @param src the src
	 * @param org the org
	 * @return the string
	 */
	public String replaceOrgValues(final String src, final AHOrg org) {
		return replaceVar("ORG_NAME", src, org.getName());
	}

	/**
	 * Replace portal values.
	 *
	 * @param src the src
	 * @return the string
	 */
	public String replacePortalValues(String src) {
		src = replaceVar("FROM_NAME", src, this.m_strPortalName);
		return replaceVar("PORTAL_URL", src, this.m_strPortalURL);
	}

}
