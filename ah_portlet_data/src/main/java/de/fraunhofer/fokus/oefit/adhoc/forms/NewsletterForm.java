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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * A form representing a subscription request
 */
public class NewsletterForm {

	private String	 m_strUuId;
	private String	 m_strMail;
	private long	 m_numSubId;

	private String[]	m_strCategories;

	/**
	 * Instantiates a new newsletter form.
	 */
	public NewsletterForm() {
		this.clear();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		this.m_strCategories = null;
		this.m_strMail = "";
		this.m_strUuId = "";
	}

	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	@Size(min = 1, message = "user.form.register.field.categories.empty")
	public String[] getCategories() {
		return this.m_strCategories;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	@NotEmpty(message = "user.form.register.field.mail.empty")
	@NotNull(message = "user.form.register.field.mail.empty")
	@NotBlank(message = "user.form.register.field.mail.empty")
	@Email(message = "user.form.register.field.mail.pattern")
	public String getMail() {
		return this.m_strMail;
	}

	/**
	 * Gets the sub id.
	 *
	 * @return the sub id
	 */
	public long getSubId() {
		return this.m_numSubId;
	}

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public String getUuid() {
		return this.m_strUuId;
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
	 * Sets the mail.
	 *
	 * @param value the new mail
	 */
	public void setMail(final String value) {
		this.m_strMail = value;
	}

	/**
	 * Sets the sub id.
	 *
	 * @param value the new sub id
	 */
	public void setSubId(final long value) {
		this.m_numSubId = value;
	}

	/**
	 * Sets the uuid.
	 *
	 * @param value the new uuid
	 */
	public void setUuid(final String value) {
		this.m_strUuId = value;
	}

}
