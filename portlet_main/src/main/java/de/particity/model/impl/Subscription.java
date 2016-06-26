package de.particity.model.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.listener.SubscriptionListener;

@Entity
@Table(name = Subscription.TABLE)
@EntityListeners(value = SubscriptionListener.class)
@NamedQueries({
		@NamedQuery(name = Subscription.getUsersBySubscriptions, query = Subscription.getUsersBySubscriptions_Query),
		@NamedQuery(name = Subscription.getByCategoryItems, query = Subscription.getByCategoryItems_Query) })
public class Subscription implements I_SubscriptionModel {

	public static final String TABLE = "pa_subscr";
	public static final String TABLE_PK_COLNAME = "UUID";

	public static final String getUsersBySubscriptions = "subscr.getUsers";
	public static final String getByCategoryItems = "subscr.byCategories";

	public static final String getUsersBySubscriptions_Query = "select * from "
			+ TABLE + " entry " + "GROUP BY entry.email ORDER by entry.created";
	public static final String getByCategoryItems_Query = "select entry.* from "
			+ TABLE
			+ " entry "
			+ "INNER JOIN "
			+ CategoryEntry.JOIN_TABLE_SUBSCR
			+ " map ON map."
			+ TABLE_PK_COLNAME
			+ "=entry."
			+ TABLE_PK_COLNAME
			+ " "
			+ "WHERE entry.status=?1 AND map."
			+ CategoryEntry.TABLE_PK_COLNAME
			+ " IN ([ ?2 ]) GROUP BY entry."
			+ TABLE_PK_COLNAME
			+ " ORDER by entry.created";

	@Id
	@Column(name = TABLE_PK_COLNAME, unique = true, nullable = false)
	private String uuid;

	private String email;

	@Enumerated(EnumType.STRING)
	private E_SubscriptionStatus status;

	private LocalDateTime created;

	@ManyToMany(targetEntity = CategoryEntry.class)
	@JoinTable(name = CategoryEntry.JOIN_TABLE_SUBSCR, joinColumns = { @JoinColumn(name = TABLE_PK_COLNAME, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false) })
	private List<I_CategoryEntryModel> categoryEntries;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_SubscriptionModel#getUuid()
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_SubscriptionModel#setUuid(java.lang.String)
	 */
	@Override
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_SubscriptionModel#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_SubscriptionModel#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_SubscriptionModel#getStatus()
	 */
	@Override
	public E_SubscriptionStatus getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_SubscriptionModel#setStatus(de.fraunhofer.fokus
	 * .oefit.adhoc.custom.E_SubscriptionStatus)
	 */
	@Override
	public void setStatus(E_SubscriptionStatus status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_SubscriptionModel#getCreated()
	 */
	@Override
	public LocalDateTime getCreated() {
		return created;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_SubscriptionModel#setCreated(java.time.
	 * LocalDateTime)
	 */
	@Override
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_SubscriptionModel#getCategoryEntries()
	 */
	@Override
	public List<I_CategoryEntryModel> getCategoryEntries() {
		return categoryEntries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_SubscriptionModel#setCategoryEntries(java.util
	 * .List)
	 */
	@Override
	public void setCategoryEntries(List<I_CategoryEntryModel> categoryEntries) {
		this.categoryEntries = categoryEntries;
	}

}
