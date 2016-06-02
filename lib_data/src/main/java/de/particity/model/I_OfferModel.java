package de.particity.model;

import java.time.LocalDateTime;
import java.util.List;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;

public interface I_OfferModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getTitle();

	public void setTitle(String title);

	public String getDescription();

	public void setDescription(String description);

	public String getWorkTime();

	public void setWorkTime(String workTime);

	public E_OfferWorkType getWorkType();

	public void setWorkType(E_OfferWorkType workType);

	public E_OfferType getType();

	public void setType(E_OfferType type);

	public E_OfferStatus getStatus();

	public void setStatus(E_OfferStatus status);

	public int getSocialStatus();

	public void setSocialStatus(int socialStatus);

	public boolean isContactAgency();

	public void setContactAgency(boolean contactAgency);

	public LocalDateTime getCreated();

	public void setCreated(LocalDateTime created);

	public LocalDateTime getUpdated();

	public void setUpdated(LocalDateTime updated);

	public LocalDateTime getExpires();

	public void setExpires(LocalDateTime expires);

	public LocalDateTime getPublish();

	public void setPublish(LocalDateTime publish);

	public I_AddressModel getAddress();

	public void setAddress(I_AddressModel address);

	public I_ContactModel getContact();

	public void setContact(I_ContactModel contact);

	public I_ContactModel getSndContact();

	public void setSndContact(I_ContactModel sndContact);

	public I_OrganizationModel getOrg();

	public void setOrg(I_OrganizationModel org);

	public List<I_CategoryEntryModel> getCategoryEntries();

	public void setCategoryEntries(List<I_CategoryEntryModel> categoryEntries);

}