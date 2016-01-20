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
package de.fraunhofer.fokus.oefit.adhoc.custom;

import java.util.LinkedList;
import java.util.List;

/**
 * A config category bundles several E_ConfigKey together and is itself
 * grouped by a parent E_ConfigDomain
 */
public enum E_ConfigCategory {

	/** Placeholder for hidden configuration settings (i.e. internal ones). */
	NONE(E_ConfigDomain.NONE, "", "", E_ConfigRole.NULL),
	
	/** Contact settings for the portal itself. */
	MGMTCONTACT(
	        E_ConfigDomain.AGENCYCFG,
	        "mgmt.cfg.category.contact.title",
	        "mgmt.cfg.category.contact.descr",
	        E_ConfigRole.MGMT),
	
	/** Global path settings for the portal itself. */
	MGMTPATHS(
	        E_ConfigDomain.AGENCYCFG,
	        "mgmt.cfg.category.paths.title",
	        "mgmt.cfg.category.paths.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about new organisations to the agency. */
	MGMTNEWORG(
	        E_ConfigDomain.AGENCYMAIL,
	        "mgmt.cfg.category.mgmtneworg.title",
	        "mgmt.cfg.category.mgmtneworg.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about new offers to the agency. */
	MGMTNEWOFFER(
	        E_ConfigDomain.AGENCYMAIL,
	        "mgmt.cfg.category.mgmtnewoffer.title",
	        "mgmt.cfg.category.mgmtnewoffer.descr",
	        E_ConfigRole.MGMT),

	/** Email templates regarding notifications about registration to the new organisation. */
	ORGREG(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgreg.title",
	        "mgmt.cfg.category.orgreg.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about registration verification to the new organisation. */
	ORGVER(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgver.title",
	        "mgmt.cfg.category.orgver.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about registration approval to the new organisation. */
	ORGORGVALID(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgorgvalid.title",
	        "mgmt.cfg.category.orgorgvalid.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about offer approval to the organisation. */
	ORGOFFERVALID(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgoffervalid.title",
	        "mgmt.cfg.category.orgoffervalid.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about a new offer to the organisation. */
	ORGOFFERNEW(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgoffernew.title",
	        "mgmt.cfg.category.orgoffernew.descr",
	        E_ConfigRole.MGMT),

	/** Email templates regarding notifications about a subscription registration to a users email address. */
	NEWSREG(
	        E_ConfigDomain.USERMAIL,
	        "mgmt.cfg.category.newsreg.title",
	        "mgmt.cfg.category.newsreg.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding notifications about new offers to a subscribers email address. */
	NEWSUPD(
	        E_ConfigDomain.USERMAIL,
	        "mgmt.cfg.category.newsupd.title",
	        "mgmt.cfg.category.newsupd.descr",
	        E_ConfigRole.MGMT),

	/** Email templates regarding reminders on missing offers to organisations. */
	ORGREMIND(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgremind.title",
	        "mgmt.cfg.category.orgremind.descr",
	        E_ConfigRole.MGMT),
	
	/** Email templates regarding expiry of offers to organisations. */
	ORGEXPIRED(
	        E_ConfigDomain.ORGMAIL,
	        "mgmt.cfg.category.orgexpired.title",
	        "mgmt.cfg.category.orgexpired.descr",
	        E_ConfigRole.MGMT),

	/** Access tokens and post templates regarding Facebook integration. */
	SOCIALFB(
	        E_ConfigDomain.EXTSERV,
	        "mgmt.cfg.category.socialfb.title",
	        "mgmt.cfg.category.socialfb.descr",
	        E_ConfigRole.MGMT),
	
	/** Access tokens and post templates regarding Twitter integration. */
	SOCIALTW(
	        E_ConfigDomain.EXTSERV,
	        "mgmt.cfg.category.socialtw.title",
	        "mgmt.cfg.category.socialtw.descr",
	        E_ConfigRole.MGMT),
	        
	OSMMAP(E_ConfigDomain.EXTSERV,
			"mgmt.cfg.category.osm.title",
	        "mgmt.cfg.category.osm.descr",
	        E_ConfigRole.MGMT),

	;

	/**
	 * Gets the by domain.
	 *
	 * @param domain the domain
	 * @return the by domain
	 */
	public static List<E_ConfigCategory> getByDomain(final E_ConfigDomain domain) {
		final List<E_ConfigCategory> result = new LinkedList<E_ConfigCategory>();

		for (final E_ConfigCategory cat : E_ConfigCategory.values()) {
			if (cat.getDomain().equals(domain)) {
				result.add(cat);
			}
		}

		return result;
	}

	private String	       m_strMsgTitle;
	private String	       m_strMsgDescr;
	private E_ConfigRole	       m_objRole;

	private E_ConfigDomain	m_objDomain;

	private E_ConfigCategory(final E_ConfigDomain domain,
	        final String msgTitleKey, final String msgDescrKey,
	        final E_ConfigRole role) {
		this.m_strMsgTitle = msgTitleKey;
		this.m_strMsgDescr = msgDescrKey;
		this.m_objRole = role;
		this.m_objDomain = domain;
	}

	/**
	 * Gets the domain.
	 *
	 * @return the domain
	 */
	public E_ConfigDomain getDomain() {
		return this.m_objDomain;
	}

	/**
	 * Gets the msg descr key.
	 *
	 * @return the msg descr key
	 */
	public String getMsgDescrKey() {
		return this.m_strMsgDescr;
	}

	/**
	 * Gets the msg title key.
	 *
	 * @return the msg title key
	 */
	public String getMsgTitleKey() {
		return this.m_strMsgTitle;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public E_ConfigRole getRole() {
		return this.m_objRole;
	}

}
