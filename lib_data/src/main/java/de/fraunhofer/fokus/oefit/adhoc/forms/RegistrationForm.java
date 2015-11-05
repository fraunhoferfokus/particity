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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * A form representing an organisation
 */
public class RegistrationForm {

	private long	             m_numOrgId;

	private String	             m_strName;
	private String	             m_strHolder;
	private String	             m_strLegalState;
	private String	             m_strDescr;

	private String	             m_strMail;
	private String	             m_strAddrStreet;
	private String	             m_strAddrNum;
	private String	             m_strRegionZip;

	private String	             m_strRegionCountry;
	private String	             m_strRegionCity;

	private String	             m_strContactPhone;
	private String	             m_strContactFax;
	private String	             m_strContactMail;
	private String	             m_strContactWeb;

	private String	             m_strContactForename;
	private String	             m_strContactSurname;

	private String	             m_strLogoFileName;
	private CommonsMultipartFile	m_objLogoFile;

	/**
	 * Instantiates a new registration form.
	 */
	public RegistrationForm() {

	}

	/**
	 * Clear.
	 */
	public void clear() {
		this.m_numOrgId = -1;
		this.m_strName = "";
		this.m_strHolder = "";
		this.m_strLegalState = "";
		this.m_strDescr = "";
		this.m_strMail = "";
		this.m_strAddrStreet = "";
		this.m_strAddrNum = "";
		this.m_strRegionZip = "00000";
		this.m_strRegionCountry = "-1";
		this.m_strRegionCity = "";
		this.m_strContactPhone = "";
		this.m_strContactFax = "";
		this.m_strContactMail = "";
		this.m_strContactWeb = "";
		this.m_strContactForename = "";
		this.m_strContactSurname = "";
	}

	/**
	 * Gets the addr num.
	 *
	 * @return the addr num
	 */
	@NotEmpty(message = "org.form.addOrg.field.addrNum.empty")
	@NotNull(message = "org.form.addOrg.field.addrNum.empty")
	@NotBlank(message = "org.form.addOrg.field.addrNum.empty")
	public String getAddrNum() {
		return this.m_strAddrNum;
	}

	/**
	 * Gets the addr street.
	 *
	 * @return the addr street
	 */
	@NotEmpty(message = "org.form.addOrg.field.addrStreet.empty")
	@NotNull(message = "org.form.addOrg.field.addrStreet.empty")
	@NotBlank(message = "org.form.addOrg.field.addrStreet.empty")
	public String getAddrStreet() {
		return this.m_strAddrStreet;
	}

	/**
	 * Gets the contact fax.
	 *
	 * @return the contact fax
	 */
	public String getContactFax() {
		return this.m_strContactFax;
	}

	/**
	 * Gets the contact forename.
	 *
	 * @return the contact forename
	 */
	public String getContactForename() {
		return this.m_strContactForename;
	}

	/**
	 * Gets the contact mail.
	 *
	 * @return the contact mail
	 */
	@NotEmpty(message = "org.form.addOrg.field.contactMail.empty")
	@NotNull(message = "org.form.addOrg.field.contactMail.empty")
	@NotBlank(message = "org.form.addOrg.field.contactMail.empty")
	@Pattern(
	        message = "org.form.addOrg.field.contactMail.pattern",
	            regexp = "[a-zA-Z_0-9]*[.[a-zA-Z_0-9]*]*@[a-zA-Z0-9_-]*[.[a-zA-Z_0-9]*]*.[a-zA-Z]{2,3}")
	public String getContactMail() {
		return this.m_strContactMail;
	}

	/**
	 * Gets the contact phone.
	 *
	 * @return the contact phone
	 */
	@NotEmpty(message = "org.form.addOrg.field.contactPhone.empty")
	@NotNull(message = "org.form.addOrg.field.contactPhone.empty")
	@NotBlank(message = "org.form.addOrg.field.contactPhone.empty")
	public String getContactPhone() {
		return this.m_strContactPhone;
	}

	/**
	 * Gets the contact surname.
	 *
	 * @return the contact surname
	 */
	public String getContactSurname() {
		return this.m_strContactSurname;
	}

	/**
	 * Gets the contact web.
	 *
	 * @return the contact web
	 */
	@NotEmpty(message = "org.form.addOrg.field.contactWeb.empty")
	@NotNull(message = "org.form.addOrg.field.contactWeb.empty")
	@NotBlank(message = "org.form.addOrg.field.contactWeb.empty")
	public String getContactWeb() {
		return this.m_strContactWeb;
	}

	/**
	 * Gets the descr.
	 *
	 * @return the descr
	 */
	@NotEmpty(message = "org.form.addOrg.field.descr.empty")
	@NotNull(message = "org.form.addOrg.field.descr.empty")
	@NotBlank(message = "org.form.addOrg.field.descr.empty")
	public String getDescr() {
		return this.m_strDescr;
	}

	/**
	 * Gets the holder.
	 *
	 * @return the holder
	 */
	@NotEmpty(message = "org.form.addOrg.field.holder.empty")
	@NotNull(message = "org.form.addOrg.field.holder.empty")
	@NotBlank(message = "org.form.addOrg.field.holder.empty")
	public String getHolder() {
		return this.m_strHolder;
	}

	/**
	 * Gets the legal state.
	 *
	 * @return the legal state
	 */
	@NotEmpty(message = "org.form.addOrg.field.legalState.empty")
	@NotNull(message = "org.form.addOrg.field.legalState.empty")
	@NotBlank(message = "org.form.addOrg.field.legalState.empty")
	public String getLegalState() {
		return this.m_strLegalState;
	}

	/**
	 * Gets the logo file.
	 *
	 * @return the logo file
	 */
	public CommonsMultipartFile getLogoFile() {
		return this.m_objLogoFile;
	}

	/**
	 * Gets the logo filename.
	 *
	 * @return the logo filename
	 */
	public String getLogoFilename() {
		return this.m_strLogoFileName;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	@NotEmpty(message = "org.form.addOrg.field.mail.empty")
	@NotNull(message = "org.form.addOrg.field.mail.empty")
	@NotBlank(message = "org.form.addOrg.field.mail.empty")
	@Pattern(
	        message = "org.form.addOrg.field.mail.pattern",
	            regexp = "[a-zA-Z_0-9]*[.[a-zA-Z_0-9]*]*@[a-zA-Z0-9_-]*[.[a-zA-Z_0-9]*]*.[a-zA-Z]{2,3}")
	public String getMail() {
		return this.m_strMail;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@NotEmpty(message = "org.form.addOrg.field.name.empty")
	@NotNull(message = "org.form.addOrg.field.name.empty")
	@NotBlank(message = "org.form.addOrg.field.name.empty")
	public String getName() {
		return this.m_strName;
	}

	/**
	 * Gets the org id.
	 *
	 * @return the org id
	 */
	public long getOrgId() {
		return this.m_numOrgId;
	}

	/**
	 * Gets the region city.
	 *
	 * @return the region city
	 */
	@NotEmpty(message = "org.form.addOrg.field.regionCity.empty")
	@NotNull(message = "org.form.addOrg.field.regionCity.empty")
	@NotBlank(message = "org.form.addOrg.field.regionCity.empty")
	public String getRegionCity() {
		return this.m_strRegionCity;
	}

	/**
	 * Gets the region country.
	 *
	 * @return the region country
	 */
	@NotEmpty(message = "org.form.addOrg.field.regionCountry.empty")
	@NotNull(message = "org.form.addOrg.field.regionCountry.empty")
	@NotBlank(message = "org.form.addOrg.field.regionCountry.empty")
	@Pattern(
	        regexp = "[0-9]\\d*",
	            message = "org.form.addOrg.field.regionCountry.empty")
	public String getRegionCountry() {
		return this.m_strRegionCountry;
	}

	/**
	 * Gets the region zip.
	 *
	 * @return the region zip
	 */
	@NotEmpty(message = "org.form.addOrg.field.regionZip.empty")
	@NotNull(message = "org.form.addOrg.field.regionZip.empty")
	@NotBlank(message = "org.form.addOrg.field.regionZip.empty")
	// @Min(value=1,message = "org.form.addOrg.field.regionZip.invalid")
	// @Max(value=99999,message = "org.form.addOrg.field.regionZip.invalid")
	// @Digits(integer=5,fraction=0,message="org.form.addOrg.field.regionZip.invalid")
	@Pattern(
	        regexp = "\\d{5}",
	            message = "org.form.addOrg.field.regionZip.invalid")
	public String getRegionZip() {
		return this.m_strRegionZip;
	}

	/**
	 * Sets the addr num.
	 *
	 * @param m_strAddrNum the new addr num
	 */
	public void setAddrNum(final String m_strAddrNum) {
		this.m_strAddrNum = m_strAddrNum;
	}

	/**
	 * Sets the addr street.
	 *
	 * @param m_strAddrStreet the new addr street
	 */
	public void setAddrStreet(final String m_strAddrStreet) {
		this.m_strAddrStreet = m_strAddrStreet;
	}

	/**
	 * Sets the contact fax.
	 *
	 * @param m_strContactFax the new contact fax
	 */
	public void setContactFax(final String m_strContactFax) {
		this.m_strContactFax = m_strContactFax;
	}

	/**
	 * Sets the contact forename.
	 *
	 * @param m_strContactForename the new contact forename
	 */
	public void setContactForename(final String m_strContactForename) {
		this.m_strContactForename = m_strContactForename;
	}

	/**
	 * Sets the contact mail.
	 *
	 * @param m_strContactMail the new contact mail
	 */
	public void setContactMail(final String m_strContactMail) {
		this.m_strContactMail = m_strContactMail;
	}

	/**
	 * Sets the contact phone.
	 *
	 * @param m_strContactPhone the new contact phone
	 */
	public void setContactPhone(final String m_strContactPhone) {
		this.m_strContactPhone = m_strContactPhone;
	}

	/**
	 * Sets the contact surname.
	 *
	 * @param m_strContactSurname the new contact surname
	 */
	public void setContactSurname(final String m_strContactSurname) {
		this.m_strContactSurname = m_strContactSurname;
	}

	/**
	 * Sets the contact web.
	 *
	 * @param m_strContactWeb the new contact web
	 */
	public void setContactWeb(final String m_strContactWeb) {
		this.m_strContactWeb = m_strContactWeb;
	}

	/**
	 * Sets the descr.
	 *
	 * @param m_strDescr the new descr
	 */
	public void setDescr(final String m_strDescr) {
		this.m_strDescr = m_strDescr;
	}

	/**
	 * Sets the holder.
	 *
	 * @param m_strHolder the new holder
	 */
	public void setHolder(final String m_strHolder) {
		this.m_strHolder = m_strHolder;
	}

	/**
	 * Sets the legal state.
	 *
	 * @param m_strLegalState the new legal state
	 */
	public void setLegalState(final String m_strLegalState) {
		this.m_strLegalState = m_strLegalState;
	}

	/**
	 * Sets the logo file.
	 *
	 * @param val the new logo file
	 */
	public void setLogoFile(final CommonsMultipartFile val) {
		this.m_objLogoFile = val;
	}

	/**
	 * Sets the logo filename.
	 *
	 * @param val the new logo filename
	 */
	public void setLogoFilename(final String val) {
		this.m_strLogoFileName = val;
	}

	/**
	 * Sets the mail.
	 *
	 * @param m_strMail the new mail
	 */
	public void setMail(final String m_strMail) {
		this.m_strMail = m_strMail;
	}

	/**
	 * Sets the name.
	 *
	 * @param m_strName the new name
	 */
	public void setName(final String m_strName) {
		this.m_strName = m_strName;
	}

	/**
	 * Sets the org id.
	 *
	 * @param id the new org id
	 */
	public void setOrgId(final long id) {
		this.m_numOrgId = id;
	}

	/**
	 * Sets the region city.
	 *
	 * @param m_strRegionCity the new region city
	 */
	public void setRegionCity(final String m_strRegionCity) {
		this.m_strRegionCity = m_strRegionCity;
	}

	/**
	 * Sets the region country.
	 *
	 * @param m_strRegionCountry the new region country
	 */
	public void setRegionCountry(final String m_strRegionCountry) {
		this.m_strRegionCountry = m_strRegionCountry;
	}

	/**
	 * Sets the region zip.
	 *
	 * @param m_strRegionZip the new region zip
	 */
	public void setRegionZip(final String m_strRegionZip) {
		this.m_strRegionZip = m_strRegionZip;
	}
}
