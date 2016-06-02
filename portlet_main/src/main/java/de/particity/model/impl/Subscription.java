package de.particity.model.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.listener.SubscriptionListener;

@Entity
@Table(name=Subscription.TABLE)
@EntityListeners(value=SubscriptionListener.class)
public class Subscription implements I_SubscriptionModel {
	
	public static final String TABLE = "pa_subscr";

	@Id
	private String uuid;
	
	private String email;
	
    @Enumerated(EnumType.STRING)
	private E_SubscriptionStatus status;
	
    private LocalDateTime created;
	
	@ManyToMany(targetEntity=CategoryEntry.class)
	private List<I_CategoryEntryModel> categoryEntries;

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#getUuid()
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#setUuid(java.lang.String)
	 */
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#getStatus()
	 */
	@Override
	public E_SubscriptionStatus getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#setStatus(de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus)
	 */
	@Override
	public void setStatus(E_SubscriptionStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#getCreated()
	 */
	@Override
	public LocalDateTime getCreated() {
		return created;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#setCreated(java.time.LocalDateTime)
	 */
	@Override
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#getCategoryEntries()
	 */
	@Override
	public List<I_CategoryEntryModel> getCategoryEntries() {
		return categoryEntries;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_SubscriptionModel#setCategoryEntries(java.util.List)
	 */
	@Override
	public void setCategoryEntries(List<I_CategoryEntryModel> categoryEntries) {
		this.categoryEntries = categoryEntries;
	}
	
}
