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
package de.fraunhofer.fokus.oefit.adhoc.forms;

/**
 * A form representing an entry for a data-list
 */
public class CategoryForm {

	private String	m_strName;
	private String	m_strDescr;
	private String	m_strParent;
	private String	m_strCat;
	private String	m_strType;

	/**
	 * Instantiates a new category form.
	 */
	public CategoryForm() {

	}

	/** 
	 * Clear.
	 */
	public void clear() {
		this.m_strCat = "";
		this.m_strDescr = "";
		this.m_strName = "";
		this.m_strParent = "";
	}

	/**
	 * Gets the cat.
	 *
	 * @return the cat
	 */
	public String getCat() {
		return this.m_strCat;
	}

	/**
	 * Gets the descr.
	 *
	 * @return the descr
	 */
	public String getDescr() {
		return this.m_strDescr;
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
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public String getParent() {
		return this.m_strParent;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.m_strType;
	}

	/**
	 * Sets the cat.
	 *
	 * @param val the new cat
	 */
	public void setCat(final String val) {
		this.m_strCat = val;
	}

	/**
	 * Sets the descr.
	 *
	 * @param val the new descr
	 */
	public void setDescr(final String val) {
		this.m_strDescr = val;
	}

	/**
	 * Sets the name.
	 *
	 * @param val the new name
	 */
	public void setName(final String val) {
		this.m_strName = val;
	}

	/**
	 * Sets the parent.
	 *
	 * @param val the new parent
	 */
	public void setParent(final String val) {
		this.m_strParent = val;
	}

	/**
	 * Sets the type.
	 *
	 * @param val the new type
	 */
	public void setType(final String val) {
		this.m_strType = val;
	}
}
