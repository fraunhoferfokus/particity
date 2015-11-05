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
 * An enum describing the current moderation state of an organisation
 */
public enum E_OrgStatus {

	/** The organisation is disabled. */
	DISABLED(1, "enum.org.disabled"),
	
	/** The organisation is validated an allowed to edit settings and post new offers. */
	VALIDATED(2, "enum.org.validated"),
	
	/** The organisation is new and requires review and acceptance. */
	NEW(3, "enum.org.new"),
	
	/** The organisation was modified and requires review and acceptance. */
	CHANGED(4, "enum.org.changed"), ;

	/**
	 * Find by value.
	 *
	 * @param val the val
	 * @return the e_ org status
	 */
	public static E_OrgStatus findByValue(final int val) {
		E_OrgStatus result = null;

		for (final E_OrgStatus status : E_OrgStatus.values()) {
			if (status.getIntValue() == val) {
				result = status;
				break;
			}
		}

		return result;
	}

	private String	m_strMsgProperty;

	private int	   m_numValue;

	private E_OrgStatus(final int value, final String msgProperty) {
		this.m_numValue = value;
		this.m_strMsgProperty = msgProperty;
	}

	/**
	 * Gets the int value.
	 *
	 * @return the int value
	 */
	public int getIntValue() {
		return this.m_numValue;
	}

	/**
	 * Gets the msg property.
	 *
	 * @return the msg property
	 */
	public String getMsgProperty() {
		return this.m_strMsgProperty;
	}
}
