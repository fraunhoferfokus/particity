package de.particity.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import de.particity.model.I_ContactModel;

@Entity
@Table(name=Contact.TABLE)
public class Contact implements I_ContactModel {
	
	public static final String TABLE = "pa_contact";

	@Id
	@GeneratedValue
	private long id;

	private String forename;
	private String surname;
	private String tel;
	private String mobile;
	private String fax;
	private String email;
	private String www;
	
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getForename()
	 */
	@Override
	public String getForename() {
		return forename;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setForename(java.lang.String)
	 */
	@Override
	public void setForename(String forename) {
		this.forename = forename;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getSurname()
	 */
	@Override
	public String getSurname() {
		return surname;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setSurname(java.lang.String)
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getTel()
	 */
	@Override
	public String getTel() {
		return tel;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setTel(java.lang.String)
	 */
	@Override
	public void setTel(String tel) {
		this.tel = tel;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getMobile()
	 */
	@Override
	public String getMobile() {
		return mobile;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setMobile(java.lang.String)
	 */
	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getFax()
	 */
	@Override
	public String getFax() {
		return fax;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setFax(java.lang.String)
	 */
	@Override
	public void setFax(String fax) {
		this.fax = fax;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#getWww()
	 */
	@Override
	public String getWww() {
		return www;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ContactModel#setWww(java.lang.String)
	 */
	@Override
	public void setWww(String www) {
		this.www = www;
	}
	
}
