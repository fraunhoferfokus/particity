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

import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;

/**
 * An enum describing supported roles along with their default locations to redirect to after login.
 * 
 * TODO: Should be made configurable in the settings
 */
public enum E_Role {
	
	/** The null. */
	NULL("@NIL@", RoleConstants.TYPE_REGULAR, "/"),
	
	/** The siteadmin. */
	SITEADMIN(
	        "Administrator",
	        RoleConstants.TYPE_REGULAR,
	        "/int/administration"),
	
	/** The admin. */
	ADMIN(Constants.DEFAULT_ROLE_ADMINISTRATION,
	        RoleConstants.TYPE_REGULAR,
	        "/int/administration"),
	
	/** The org. */
	ORG(Constants.DEFAULT_ROLE_ORGANIZATION ,
	        RoleConstants.TYPE_REGULAR,
	        "/int/organisation"),
	
	/** The mgmt. */
	MGMT(Constants.DEFAULT_ROLE_MANAGEMENT, RoleConstants.TYPE_REGULAR, "/int/verwaltung"), ;

	/**
	 * Check whether a Liferay-Role matches any role defined by this enum
	 *
	 * @param cmpRole the Liferay role
	 * @return the supported enum or null, if not supported
	 */
	public static E_Role matches(final Role cmpRole) {
		E_Role result = null;

		if (cmpRole != null) {
			for (final E_Role role : E_Role.values()) {
				if (role.getName().equals(cmpRole.getName())
				        && role.getType() == cmpRole.getType()) {
					result = role;
					// System.out.println(role.getName()+" ("+role.getType()+") == "+cmpRole.getName()+" ("+cmpRole.getType()+")");
					break;
				} else {
					// System.out.println(role.getName()+" ("+role.getType()+") != "+cmpRole.getName()+" ("+cmpRole.getType()+")");
				}
			}
		}

		return result;
	}

	private String	m_strName;
	private int	   m_numType;

	private String	m_strHomeUrl;

	private E_Role(final String title, final int type, final String userHomeUrl) {
		this.m_strName = title;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.m_strName;
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