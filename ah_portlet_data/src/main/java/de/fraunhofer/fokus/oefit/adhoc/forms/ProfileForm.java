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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * A form representing a user profile
 */
public class ProfileForm {

	private String	m_strForename;
	private String	m_strSurname;
	private String	m_strMail;
	private String	m_strPass1;
	private String	m_strPass2;

	/**
	 * Instantiates a new profile form.
	 */
	public ProfileForm() {
		this.clear();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		this.m_strMail = "";
		this.m_strPass1 = "";
		this.m_strPass2 = "";
		this.m_strForename = "";
		this.m_strSurname = "";
	}

	/**
	 * Gets the forename.
	 *
	 * @return the forename
	 */
	public String getForename() {
		return this.m_strForename;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	@NotEmpty(message = "common.form.profile.field.mail.empty")
	@NotNull(message = "common.form.profile.field.mail.empty")
	@NotBlank(message = "common.form.profile.field.mail.empty")
	@Email(message = "common.form.profile.field.mail.pattern")
	public String getMail() {
		return this.m_strMail;
	}

	/**
	 * Gets the pass1.
	 *
	 * @return the pass1
	 */
	public String getPass1() {
		return this.m_strPass1;
	}

	/**
	 * Gets the pass2.
	 *
	 * @return the pass2
	 */
	public String getPass2() {
		return this.m_strPass2;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return this.m_strSurname;
	}

	/**
	 * Sets the forename.
	 *
	 * @param val the new forename
	 */
	public void setForename(final String val) {
		this.m_strForename = val;
	}

	/**
	 * Sets the mail.
	 *
	 * @param val the new mail
	 */
	public void setMail(final String val) {
		this.m_strMail = val;
	}

	/**
	 * Sets the pass1.
	 *
	 * @param val the new pass1
	 */
	public void setPass1(final String val) {
		this.m_strPass1 = val;
	}

	/**
	 * Sets the pass2.
	 *
	 * @param val the new pass2
	 */
	public void setPass2(final String val) {
		this.m_strPass2 = val;
	}

	/**
	 * Sets the surname.
	 *
	 * @param val the new surname
	 */
	public void setSurname(final String val) {
		this.m_strSurname = val;
	}

}
