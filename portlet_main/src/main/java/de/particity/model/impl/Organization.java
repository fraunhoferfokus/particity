package de.particity.model.impl;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.particity.model.I_AddressModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.listener.OrgListener;

@Entity
@Table(name=Organization.TABLE)
@EntityListeners(value=OrgListener.class)
public class Organization implements I_OrganizationModel {
	
	public static final String TABLE = "pa_org";

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String holder;
	private String owner;
	private String userList;
	private String description;
	private String legalStatus;
	
    @Enumerated(EnumType.STRING)
	private E_OrgStatus status;
	
    private String logoLocation;
	
	private LocalDateTime created;
	private LocalDateTime updated;
	
	@ManyToOne(targetEntity=Contact.class)
	private I_ContactModel contact;
	
	@ManyToOne(targetEntity=Address.class)
	private I_AddressModel address;

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getHolder()
	 */
	@Override
	public String getHolder() {
		return holder;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setHolder(java.lang.String)
	 */
	@Override
	public void setHolder(String holder) {
		this.holder = holder;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getOwner()
	 */
	@Override
	public String getOwner() {
		return owner;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setOwner(java.lang.String)
	 */
	@Override
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getUserList()
	 */
	@Override
	public String getUserList() {
		return userList;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setUserList(java.lang.String)
	 */
	@Override
	public void setUserList(String userList) {
		this.userList = userList;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getLegalStatus()
	 */
	@Override
	public String getLegalStatus() {
		return legalStatus;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setLegalStatus(java.lang.String)
	 */
	@Override
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getStatus()
	 */
	@Override
	public E_OrgStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setStatus(de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus)
	 */
	@Override
	public void setStatus(E_OrgStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getLogoLocation()
	 */
	@Override
	public String getLogoLocation() {
		return logoLocation;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setLogoLocation(java.lang.String)
	 */
	@Override
	public void setLogoLocation(String logoLocation) {
		this.logoLocation = logoLocation;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getCreated()
	 */
	@Override
	public LocalDateTime getCreated() {
		return created;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setCreated(java.time.LocalDateTime)
	 */
	@Override
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getUpdated()
	 */
	@Override
	public LocalDateTime getUpdated() {
		return updated;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setUpdated(java.time.LocalDateTime)
	 */
	@Override
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getContact()
	 */
	@Override
	public I_ContactModel getContact() {
		return contact;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setContact(de.particity.model.impl.Contact)
	 */
	@Override
	public void setContact(I_ContactModel contact) {
		this.contact = contact;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#getAddress()
	 */
	@Override
	public I_AddressModel getAddress() {
		return address;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_OrganizationModel#setAddress(de.particity.model.impl.Address)
	 */
	@Override
	public void setAddress(I_AddressModel address) {
		this.address = address;
	}
	
}
