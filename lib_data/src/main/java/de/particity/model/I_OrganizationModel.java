package de.particity.model;

import java.time.LocalDateTime;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;

public interface I_OrganizationModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getName();

	public void setName(String name);

	public String getHolder();

	public void setHolder(String holder);

	public String getOwner();

	public void setOwner(String owner);

	public String getUserList();

	public void setUserList(String userList);

	public String getDescription();

	public void setDescription(String description);

	public String getLegalStatus();

	public void setLegalStatus(String legalStatus);

	public E_OrgStatus getStatus();

	public void setStatus(E_OrgStatus status);

	public String getLogoLocation();

	public void setLogoLocation(String logoLocation);

	public LocalDateTime getCreated();

	public void setCreated(LocalDateTime created);

	public LocalDateTime getUpdated();

	public void setUpdated(LocalDateTime updated);

	public I_ContactModel getContact();

	public void setContact(I_ContactModel contact);

	public I_AddressModel getAddress();

	public void setAddress(I_AddressModel address);

}