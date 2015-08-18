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
 * A form representing a search request
 * 
 * @deprecated due to use of request parameters for searching
 */
@Deprecated
public class SearchForm {

	private String[]	m_strCategories;
	private String[]	m_strTypes;
	private String[]	m_strRootCategories;
	private String	 m_numOrgId;

	/**
	 * Instantiates a new search form.
	 */
	public SearchForm() {
		this.clear();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		this.m_strCategories = null;
		this.m_strTypes = null;
		this.m_strRootCategories = null;
		this.m_numOrgId = null;
	}

	// @Size(min=1,message = "user.form.register.field.categories.empty")
	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	public String[] getCategories() {
		return this.m_strCategories;
	}

	/**
	 * Gets the org id.
	 *
	 * @return the org id
	 */
	public String getOrgId() {
		return this.m_numOrgId;
	}

	/**
	 * Gets the root categories.
	 *
	 * @return the root categories
	 */
	public String[] getRootCategories() {
		return this.m_strRootCategories;
	}

	/**
	 * Gets the root categories str.
	 *
	 * @return the root categories str
	 */
	public String getRootCategoriesStr() {
		final StringBuffer result = new StringBuffer();

		if (this.m_strRootCategories != null
		        && this.m_strRootCategories.length > 0) {
			result.append("\"").append(this.m_strRootCategories[0])
			        .append("\"");
			for (int i = 1; i < this.m_strRootCategories.length; i++) {
				result.append(",").append("\"")
				        .append(this.m_strRootCategories[i]).append("\"");
			}
		}

		return result.toString();
	}

	/**
	 * Gets the types.
	 *
	 * @return the types
	 */
	public String[] getTypes() {
		return this.m_strTypes;
	}

	/**
	 * Sets the categories.
	 *
	 * @param m_strCategories the new categories
	 */
	public void setCategories(final String[] m_strCategories) {
		this.m_strCategories = m_strCategories;
	}

	/**
	 * Sets the org id.
	 *
	 * @param orgId the new org id
	 */
	public void setOrgId(final String orgId) {
		this.m_numOrgId = orgId;
	}

	/**
	 * Sets the root categories.
	 *
	 * @param m_strCategories the new root categories
	 */
	public void setRootCategories(final String[] m_strCategories) {
		this.m_strRootCategories = m_strCategories;
	}

	/**
	 * Sets the types.
	 *
	 * @param m_strTypes the new types
	 */
	public void setTypes(final String[] m_strTypes) {
		this.m_strTypes = m_strTypes;
	}

}