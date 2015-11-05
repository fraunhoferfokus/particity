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
 * An enum describing different offer status
 */
public enum E_OfferStatus {

	/** Offer is disabled. */
	DISABLED(1, "enum.offer.status.disabled"),
	
	/** Offer is validated and visible to everyone. */
	VALIDATED(2, "enum.offer.status.validated"),
	
	/** Offer is new and requires validation and acceptance. */
	NEW(3, "enum.offer.status.new"),
	
	/** Offer was modified and required review and acceptance. */
	CHANGED(4, "enum.offer.status.changed"), ;

	/**
	 * Find by value.
	 *
	 * @param val the val
	 * @return the e_ offer status
	 */
	public static E_OfferStatus findByValue(final int val) {
		E_OfferStatus result = null;

		for (final E_OfferStatus status : E_OfferStatus.values()) {
			if (status.getIntValue() == val) {
				result = status;
				break;
			}
		}

		return result;
	}

	private String	m_strMsgProperty;

	private int	   m_numValue;

	private E_OfferStatus(final int value, final String msgProperty) {
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
