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
 * An enum describing columns of tables, actually implemented for sorting
 */
public enum E_TableColumn {

	/** The organisations's name. */
	ORG_NAME("name"),
	
	/** The organisations's holder. */
	ORG_HOLDER("holder"),
	
	/** The organisations's status. */
	ORG_STATUS("status"),
	
	/** The organisations's create date. */
	ORG_CREATED("created"),
	
	/** The organisations's date of last update. */
	ORG_UPDATED("updated"),

	/** The offer's title. */
	OFFER_TITLE("title"),
	
	/** The offer's type. */
	OFFER_TYPE("type_"),
	
	/** The offer's publish date. */
	OFFER_PUBLISH("publish"),
	
	/** The offer's date of last update. */
	OFFER_UPDATED("updated"),
	
	/** The offer's expiry date. */
	OFFER_EXPIRE("expires"),
	
	/** The offer's status. */
	OFFER_STATUS("status"), ;

	private String	m_strColName;

	private E_TableColumn(final String colName) {
		this.m_strColName = colName;
	}

	/**
	 * Gets the col name.
	 *
	 * @return the col name
	 */
	public String getColName() {
		return this.m_strColName;
	}

}
