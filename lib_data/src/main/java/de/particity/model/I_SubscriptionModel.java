package de.particity.model;

import java.time.LocalDateTime;
import java.util.List;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;

public interface I_SubscriptionModel extends I_Model {

	public String getUuid();

	public void setUuid(String uuid);

	public String getEmail();

	public void setEmail(String email);

	public E_SubscriptionStatus getStatus();

	public void setStatus(E_SubscriptionStatus status);

	public LocalDateTime getCreated();

	public void setCreated(LocalDateTime created);

	public List<I_CategoryEntryModel> getCategoryEntries();

	public void setCategoryEntries(List<I_CategoryEntryModel> categoryEntries);

}