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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;

/**
 * A form representing an offer
 */
public class OfferForm {

	private long	 m_numOfferId;
	private long	 m_numOrgId;

	private String[]	m_strCategories;
	private String[]	m_strServices;
	private String	 m_strTitle;
	private String	 m_strDescr;
	private String	 m_strAddrStreet;
	private String	 m_strAddrNum;
	private String	 m_strRegionCity;
	private String	 m_strRegionCountry;
	private String	 m_strRegionZip;
	private String	 m_strContactForename;
	private String	 m_strContactSurname;
	private String	 m_strContactTel;
	private String	 m_strContactMail;
	private String	 m_strContactSndForename;
	private String	 m_strContactSndSurname;
	private String	 m_strContactSndTel;
	private String	 m_strContactSndMail;
	private String	 m_strWorkHours;
	private long	 m_numCreateDate;
	private String	 m_numExpireDate;
	private String	 m_numExpireTime;
	private String	 m_numPublishDate;
	private String	 m_numPublishTime;
	private String	 m_strType;
	private String	 m_strWorkType;
	private Float	 m_strAddrLat;
	private Float	 m_strAddrLon;
	private boolean	 m_bRequireAgencyContact;

	/**
	 * Instantiates a new offer form.
	 */
	public OfferForm() {
		this.clear();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		this.m_numOrgId = -1;
		this.m_numOfferId = -1;
		this.m_strWorkHours = "-1";
		this.m_numCreateDate = -1;
		long time = CustomServiceUtils.time();
		// two hours in the future
		time += 1000 * 60 * 60 * 2;
		this.m_numPublishDate = CustomServiceUtils.formatZoneDate(time);
		this.m_numPublishTime = CustomServiceUtils.formatZoneTime(time);
		// one week in the future
		time += 1000 * 60 * 60 * 24 * 7;
		this.m_numExpireDate = CustomServiceUtils.formatZoneDate(time);
		this.m_numExpireTime = CustomServiceUtils.formatZoneTime(time);
		this.m_strCategories = null;
		this.m_strTitle = "";
		this.m_strDescr = "";
		this.m_strAddrStreet = "";
		this.m_strAddrNum = "";
		this.m_strRegionCity = "";
		this.m_strRegionCountry = "-1";
		this.m_strRegionZip = "00000";
		this.m_strContactForename = "";
		this.m_strContactSurname = "";
		this.m_strContactTel = "";
		this.m_strContactMail = "";
		this.m_strType = "";
		this.m_strAddrLat = null;
		this.m_strAddrLon = null;
	}

	/**
	 * Gets the addr lat.
	 *
	 * @return the addr lat
	 */
	public Float getAddrLat() {
		return this.m_strAddrLat;
	}

	/**
	 * Gets the addr lon.
	 *
	 * @return the addr lon
	 */
	public Float getAddrLon() {
		return this.m_strAddrLon;
	}

	/**
	 * Gets the addr num.
	 *
	 * @return the addr num
	 */
	@NotEmpty(message = "org.form.offer.field.addrNum.empty")
	@NotNull(message = "org.form.offer.field.addrNum.empty")
	@NotBlank(message = "org.form.offer.field.addrNum.empty")
	public String getAddrNum() {
		return this.m_strAddrNum;
	}

	/**
	 * Gets the addr street.
	 *
	 * @return the addr street
	 */
	@NotEmpty(message = "org.form.offer.field.addrStreet.empty")
	@NotNull(message = "org.form.offer.field.addrStreet.empty")
	@NotBlank(message = "org.form.offer.field.addrStreet.empty")
	public String getAddrStreet() {
		return this.m_strAddrStreet;
	}

	/*
	 * @NotEmpty(message = "org.form.offer.field.categories.empty")
	 * @NotNull(message = "org.form.offer.field.categories.empty")
	 * @NotBlank(message = "org.form.offer.field.categories.empty")
	 */
	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	@Size(min = 1, message = "org.form.offer.field.categories.empty")
	public String[] getCategories() {
		return this.m_strCategories;
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
	public String getContactMail() {
		return this.m_strContactMail;
	}

	/**
	 * Gets the contact snd forename.
	 *
	 * @return the contact snd forename
	 */
	@NotEmpty(message = "org.form.offer.field.contactFN.empty")
	@NotNull(message = "org.form.offer.field.contactFN.empty")
	@NotBlank(message = "org.form.offer.field.contactFN.empty")
	public String getContactSndForename() {
		return this.m_strContactSndForename;
	}

	/**
	 * Gets the contact snd mail.
	 *
	 * @return the contact snd mail
	 */
	@NotEmpty(message = "org.form.offer.field.contactMail.empty")
	@NotNull(message = "org.form.offer.field.contactMail.empty")
	@NotBlank(message = "org.form.offer.field.contactMail.empty")
	@Email(message = "org.form.offer.field.contactMail.pattern")
	public String getContactSndMail() {
		return this.m_strContactSndMail;
	}

	/**
	 * Gets the contact snd surname.
	 *
	 * @return the contact snd surname
	 */
	@NotEmpty(message = "org.form.offer.field.contactSN.empty")
	@NotNull(message = "org.form.offer.field.contactSN.empty")
	@NotBlank(message = "org.form.offer.field.contactSN.empty")
	public String getContactSndSurname() {
		return this.m_strContactSndSurname;
	}

	/**
	 * Gets the contact snd tel.
	 *
	 * @return the contact snd tel
	 */
	@NotEmpty(message = "org.form.offer.field.contactTel.empty")
	@NotNull(message = "org.form.offer.field.contactTel.empty")
	@NotBlank(message = "org.form.offer.field.contactTel.empty")
	public String getContactSndTel() {
		return this.m_strContactSndTel;
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
	 * Gets the contact tel.
	 *
	 * @return the contact tel
	 */
	public String getContactTel() {
		return this.m_strContactTel;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public long getCreateDate() {
		return this.m_numCreateDate;
	}

	/**
	 * Gets the descr.
	 *
	 * @return the descr
	 */
	@NotEmpty(message = "org.form.offer.field.descr.empty")
	@NotNull(message = "org.form.offer.field.descr.empty")
	@NotBlank(message = "org.form.offer.field.descr.empty")
	public String getDescr() {
		return this.m_strDescr;
	}

	/**
	 * Gets the expire date.
	 *
	 * @return the expire date
	 */
	@NotNull(message = "org.form.offer.field.expireDate.empty")
	@NotEmpty(message = "org.form.offer.field.expireDate.empty")
	@NotBlank(message = "org.form.offer.field.expireDate.empty")
	public String getExpireDate() {
		return this.m_numExpireDate;
	}

	/**
	 * Gets the expire time.
	 *
	 * @return the expire time
	 */
	@NotEmpty(message = "org.form.offer.field.expireTime.empty")
	@NotNull(message = "org.form.offer.field.expireTime.empty")
	@NotBlank(message = "org.form.offer.field.expireTime.empty")
	@Pattern(
	        regexp = "\\d{2}:\\d{2}",
	            message = "org.form.offer.field.expireTime.invalid")
	public String getExpireTime() {
		return this.m_numExpireTime;
	}

	/**
	 * Gets the offer id.
	 *
	 * @return the offer id
	 */
	public long getOfferId() {
		return this.m_numOfferId;
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
	 * Gets the publish date.
	 *
	 * @return the publish date
	 */
	@NotNull(message = "org.form.offer.field.publishDate.empty")
	@NotEmpty(message = "org.form.offer.field.publishDate.empty")
	@NotBlank(message = "org.form.offer.field.publishDate.empty")
	public String getPublishDate() {
		return this.m_numPublishDate;
	}

	/**
	 * Gets the publish time.
	 *
	 * @return the publish time
	 */
	@NotEmpty(message = "org.form.offer.field.publishTime.empty")
	@NotNull(message = "org.form.offer.field.publishTime.empty")
	@NotBlank(message = "org.form.offer.field.publishTime.empty")
	@Pattern(
	        regexp = "\\d{2}:\\d{2}",
	            message = "org.form.offer.field.publishTime.invalid")
	public String getPublishTime() {
		return this.m_numPublishTime;
	}

	/**
	 * Gets the region city.
	 *
	 * @return the region city
	 */
	@NotEmpty(message = "org.form.offer.field.regionCity.empty")
	@NotNull(message = "org.form.offer.field.regionCity.empty")
	@NotBlank(message = "org.form.offer.field.regionCity.empty")
	public String getRegionCity() {
		return this.m_strRegionCity;
	}

	/**
	 * Gets the region country.
	 *
	 * @return the region country
	 */
	@NotEmpty(message = "org.form.offer.field.regionCountry.empty")
	@NotNull(message = "org.form.offer.field.regionCountry.empty")
	@NotBlank(message = "org.form.offer.field.regionCountry.empty")
	@Pattern(
	        regexp = "[0-9]\\d*",
	            message = "org.form.offer.field.regionCountry.empty")
	public String getRegionCountry() {
		return this.m_strRegionCountry;
	}

	/**
	 * Gets the region zip.
	 *
	 * @return the region zip
	 */
	@NotEmpty(message = "org.form.offer.field.regionZip.empty")
	@NotNull(message = "org.form.offer.field.regionZip.empty")
	@NotBlank(message = "org.form.offer.field.regionZip.empty")
	@Pattern(
	        regexp = "\\d{5}",
	            message = "org.form.offer.field.regionZip.invalid")
	public String getRegionZip() {
		return this.m_strRegionZip;
	}

	/**
	 * Gets the require agency contact.
	 *
	 * @return the require agency contact
	 */
	public boolean getRequireAgencyContact() {
		return this.m_bRequireAgencyContact;
	}

	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public String[] getServices() {
		return this.m_strServices;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@NotEmpty(message = "org.form.offer.field.title.empty")
	@NotNull(message = "org.form.offer.field.title.empty")
	@NotBlank(message = "org.form.offer.field.title.empty")
	public String getTitle() {
		return this.m_strTitle;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@NotEmpty(message = "org.form.offer.field.type.empty")
	@NotNull(message = "org.form.offer.field.type.empty")
	@NotBlank(message = "org.form.offer.field.type.empty")
	public String getType() {
		return this.m_strType;
	}

	/**
	 * Gets the work hours.
	 *
	 * @return the work hours
	 */
	@NotEmpty(message = "org.form.offer.field.workHours.empty")
	@NotNull(message = "org.form.offer.field.workHours.empty")
	@NotBlank(message = "org.form.offer.field.workHours.empty")
	@Pattern(
	        regexp = "[0-9]\\d*",
	            message = "org.form.offer.field.workHours.empty")
	public String getWorkHours() {
		return this.m_strWorkHours;
	}

	/**
	 * Gets the work type.
	 *
	 * @return the work type
	 */
	public String getWorkType() {
		return this.m_strWorkType;
	}

	/**
	 * Checks if is require agency contact.
	 *
	 * @return true, if is require agency contact
	 */
	public boolean isRequireAgencyContact() {
		return this.m_bRequireAgencyContact;
	}

	/**
	 * Sets the addr lat.
	 *
	 * @param val the new addr lat
	 */
	public void setAddrLat(final Float val) {
		this.m_strAddrLat = val;
	}

	/**
	 * Sets the addr lon.
	 *
	 * @param val the new addr lon
	 */
	public void setAddrLon(final Float val) {
		this.m_strAddrLon = val;
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
	 * Sets the categories.
	 *
	 * @param array the new categories
	 */
	public void setCategories(final String[] array) {
		this.m_strCategories = array;
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
	 * Sets the contact snd forename.
	 *
	 * @param m_strContactForename the new contact snd forename
	 */
	public void setContactSndForename(final String m_strContactForename) {
		this.m_strContactSndForename = m_strContactForename;
	}

	/**
	 * Sets the contact snd mail.
	 *
	 * @param m_strContactMail the new contact snd mail
	 */
	public void setContactSndMail(final String m_strContactMail) {
		this.m_strContactSndMail = m_strContactMail;
	}

	/**
	 * Sets the contact snd surname.
	 *
	 * @param m_strContactSurname the new contact snd surname
	 */
	public void setContactSndSurname(final String m_strContactSurname) {
		this.m_strContactSndSurname = m_strContactSurname;
	}

	/**
	 * Sets the contact snd tel.
	 *
	 * @param m_strContactTel the new contact snd tel
	 */
	public void setContactSndTel(final String m_strContactTel) {
		this.m_strContactSndTel = m_strContactTel;
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
	 * Sets the contact tel.
	 *
	 * @param m_strContactTel the new contact tel
	 */
	public void setContactTel(final String m_strContactTel) {
		this.m_strContactTel = m_strContactTel;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param m_numCreateDate the new creates the date
	 */
	public void setCreateDate(final long m_numCreateDate) {
		this.m_numCreateDate = m_numCreateDate;
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
	 * Sets the expire date.
	 *
	 * @param m_numExpireDate the new expire date
	 */
	public void setExpireDate(final String m_numExpireDate) {
		this.m_numExpireDate = m_numExpireDate;
	}

	/**
	 * Sets the expire time.
	 *
	 * @param m_numExpireTime the new expire time
	 */
	public void setExpireTime(final String m_numExpireTime) {
		this.m_numExpireTime = m_numExpireTime;
	}

	/**
	 * Sets the offer id.
	 *
	 * @param id the new offer id
	 */
	public void setOfferId(final long id) {
		this.m_numOfferId = id;
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
	 * Sets the publish date.
	 *
	 * @param m_numDate the new publish date
	 */
	public void setPublishDate(final String m_numDate) {
		this.m_numPublishDate = m_numDate;
	}

	/**
	 * Sets the publish time.
	 *
	 * @param m_numPublishTime the new publish time
	 */
	public void setPublishTime(final String m_numPublishTime) {
		this.m_numPublishTime = m_numPublishTime;
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

	/**
	 * Sets the require agency contact.
	 *
	 * @param val the new require agency contact
	 */
	public void setRequireAgencyContact(final boolean val) {
		this.m_bRequireAgencyContact = val;
	}

	/**
	 * Sets the services.
	 *
	 * @param array the new services
	 */
	public void setServices(final String[] array) {
		this.m_strServices = array;
	}

	/**
	 * Sets the title.
	 *
	 * @param m_strTitle the new title
	 */
	public void setTitle(final String m_strTitle) {
		this.m_strTitle = m_strTitle;
	}

	/**
	 * Sets the type.
	 *
	 * @param m_strType the new type
	 */
	public void setType(final String m_strType) {
		this.m_strType = m_strType;
	}

	/**
	 * Sets the work hours.
	 *
	 * @param val the new work hours
	 */
	public void setWorkHours(final String val) {
		this.m_strWorkHours = val;
	}

	/**
	 * Sets the work type.
	 *
	 * @param m_strType the new work type
	 */
	public void setWorkType(final String m_strType) {
		this.m_strWorkType = m_strType;
	}

}
