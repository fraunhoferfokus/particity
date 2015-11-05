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

/**
 * A config domain bundles several E_ConfigCategory and should be used in the view to group those categories together
 */
public enum E_ConfigDomain {

	/** Placeholder for hidden categories (e.g. internal). */
	NONE("", ""),
	
	/** Default value for agency settings. */
	AGENCYCFG(
	        "mgmt.cfg.domain.agencycfg.title",
	        "mgmt.cfg.domain.agencycfg.descr"),
	
	/** Groups email settings regarding the agency. */
	AGENCYMAIL(
	        "mgmt.cfg.domain.agencymail.title",
	        "mgmt.cfg.domain.agencymail.descr"),
	
	/** Groups email settings regarding organisations. */
	ORGMAIL("mgmt.cfg.domain.orgmail.title", "mgmt.cfg.domain.orgmail.descr"),
	
	/** Groups email settings regarding subscriptions/users. */
	USERMAIL("mgmt.cfg.domain.usermail.title", "mgmt.cfg.domain.usermail.descr"),
	
	/** Groups settings regarding integration of external services (i.e. social media). */
	EXTSERV("mgmt.cfg.domain.extserv.title", "mgmt.cfg.domain.extserv.descr"), ;

	private String	m_strMsgTitle;
	private String	m_strMsgDescr;

	private E_ConfigDomain(final String msgTitle, final String msgDescr) {
		this.m_strMsgTitle = msgTitle;
		this.m_strMsgDescr = msgDescr;
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

}
