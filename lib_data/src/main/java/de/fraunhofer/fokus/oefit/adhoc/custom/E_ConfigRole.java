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

import com.liferay.portal.model.RoleConstants;

/**
 * An enum describing supported roles along with their default locations to redirect to after login.
 * 
 * TODO: Should be made configurable in the settings
 */
public enum E_ConfigRole {
	
	/** The null. */
	NULL("@NIL@", RoleConstants.TYPE_REGULAR, "/"),
	
	/** The default site user = guest. */
	SITEGUEST(RoleConstants.GUEST, RoleConstants.TYPE_REGULAR, "/"),
	
	/** The siteadmin. */
	SITEADMIN(
	        "Administrator",
	        RoleConstants.TYPE_REGULAR,
	        "/int/administration"),
	
	/** The admin. */
	ADMIN(null, E_ConfigKey.ROLE_NAME_ADM,
	        RoleConstants.TYPE_REGULAR,
	        "/int/administration"),
	
	/** The org. */
	ORG(E_ConfigKey.ROLE_NAME_ORG,
	        RoleConstants.TYPE_REGULAR,
	        "/int/organisation"),
	
	/** The mgmt. */
	MGMT(E_ConfigKey.ROLE_NAME_MGMT, RoleConstants.TYPE_REGULAR, "/int/verwaltung"), ;

	private E_ConfigKey m_objKey = null;;
	private String m_strName = null;
	private int	   m_numType;
	private String	m_strHomeUrl;

	private E_ConfigRole(String name, int type, String userHomeUrl) {
		this(name, null, type, userHomeUrl);
	}
	
	private E_ConfigRole(final E_ConfigKey ckey, int type, String userHomeUrl) {
		this(null, ckey, type, userHomeUrl);
	}
	
	private E_ConfigRole(String name, final E_ConfigKey key, int type, String userHomeUrl) {
		this.m_strName = name;
		this.m_objKey = key;
		this.m_numType = type;
		this.m_strHomeUrl = userHomeUrl;
	}

	/**
	 * Gets the home url.
	 *
	 * @return the home url
	 */
	public String getHomeUrl() {
		return this.m_strHomeUrl;
	}

	/**
	 * Gets the configuration key
	 *
	 * @return the config key enum
	 */
	public E_ConfigKey getKey() {
		return this.m_objKey;
	}

	/**
	 * Get the role's default name
	 * NOTE: If there is a getKey() referenced, this value might have changed in the system configuration. Use <code>CustomPortalServiceHandler.getRoleName()</code> instead
	 * 
	 * @return
	 */
	public String getDefaultName() {
		return m_strName;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public int getType() {
		return this.m_numType;
	}
}
