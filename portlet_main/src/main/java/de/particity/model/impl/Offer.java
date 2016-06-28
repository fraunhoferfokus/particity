package de.particity.model.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;
import de.particity.model.I_AddressModel;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.listener.OfferListener;

@Entity
@Table(name = Offer.TABLE)
@EntityListeners(value = OfferListener.class)
@NamedQueries({
		@NamedQuery(name = Offer.getByCategoryEntries, query = Offer.getByCategoryEntries_Query),
		@NamedQuery(name = Offer.getByCategories, query = Offer.getByCategories_Query),
		@NamedQuery(name = Offer.getByTypes, query = Offer.getByTypes_Query),
		@NamedQuery(name = Offer.getByExpiredAndOrg, query = Offer.getByExpiredAndOrg_Query),
		@NamedQuery(name = Offer.getByIssuerTime, query = Offer.getByIssuerTime_Query),
		@NamedQuery(name = Offer.countByCategories, query = Offer.countByCategories_Query),
		@NamedQuery(name = Offer.countByCategoryEntries, query = Offer.countByCategoryEntries_Query),
		@NamedQuery(name = Offer.countByTypes, query = Offer.countByTypes_Query) })
public class Offer implements I_OfferModel {

	public static final String TABLE = "pa_offer";

	public static final String TABLE_PK_COLNAME = "offerId";

	public static final String getByCategoryEntries = "offer.byCategoryEntries";
	public static final String getByCategories = "offer.byCategories";
	public static final String getByTypes = "offer.byTypes";
	public static final String getByExpiredAndOrg = "offer.byExpiredAndOrg";
	public static final String getByIssuerTime = "offer.getByIssuerTime";
	public static final String countByCategories = "offer.countByCategories";
	public static final String countByCategoryEntries = "offer.countByCategoryEntries";
	public static final String countByTypes = "offer.countByTypes";

	public static final String getByCategoryEntries_Query = "select offer from Offer offer "
			+ "INNER JOIN offer.categoryEntries catEntry WHERE offer.status = :status AND "
			+ "offer.publish <= :published AND offer.expires > :expires AND catEntry.id IN "
			+ ":categoryEntryIds GROUP BY offer.id ORDER by offer.created";

	public static final String getByCategories_Query = "select offer from Offer offer "
			+ "INNER JOIN offer.categoryEntries catEntry WHERE catEntry.category.id IN :categoryIds "
			+ "AND offer.status = :status AND offer.publish <= :published AND offer.expires > :expires GROUP BY offer.id "
			+ "ORDER by offer.created";

	public static final String getByTypes_Query = "select offer from Offer offer "
			+ "WHERE offer.type IN :types "
			+ "AND offer.status = :status AND "
			+ "offer.publish <= :published AND offer.expires > :expires ORDER by offer.created";

	public static final String getByExpiredAndOrg_Query = "select offer from Offer offer "
			+ "WHERE offer.org.id = :orgId AND offer.expires >= :minExpired "
			+ "AND offer.expires <= :maxExpired ORDER by offer.expires";

	public static final String getByIssuerTime_Query = "select offer from Offer offer "
			+ "WHERE offer.status = :status AND offer.publish >= :minPublished "
			+ "AND offer.publish < :maxPublished AND offer.expires > :expires ORDER by offer.publish";

	public static final String countByCategories_Query = "select count(offer) from Offer offer WHERE offer IN ("
			+ getByCategories_Query + ")";
	public static final String countByCategoryEntries_Query = "select count(offer) from Offer offer WHERE offer IN ("
			+ getByCategoryEntries_Query + ")";
	public static final String countByTypes_Query = "select count(offer) from Offer offer WHERE offer IN ("
			+ getByTypes_Query + ")";

	@Id
	@GeneratedValue
	@Column(name = TABLE_PK_COLNAME, unique = true, nullable = false)
	private long id;

	private String title;
	private String description;
	private String workTime;

	@Enumerated(EnumType.STRING)
	private E_OfferWorkType workType;
	@Enumerated(EnumType.STRING)
	private E_OfferType type;
	@Enumerated(EnumType.STRING)
	private E_OfferStatus status;

	private int socialStatus;
	private boolean contactAgency;

	private LocalDateTime created;

	@OrderColumn
	@OrderBy(value = "DESC")
	private LocalDateTime updated;
	private LocalDateTime expires;
	private LocalDateTime publish;

	@ManyToOne(targetEntity = Address.class)
	@JoinColumn(name = "addressId")
	private I_AddressModel address;

	@ManyToOne(targetEntity = Contact.class)
	@JoinColumn(name = "contactId")
	private I_ContactModel contact;

	@ManyToOne(targetEntity = Contact.class)
	@JoinColumn(name = "sndContactId")
	private I_ContactModel sndContact;

	@ManyToOne(targetEntity = Organization.class)
	@JoinColumn(name = "orgId")
	private I_OrganizationModel org;

	@ManyToMany(targetEntity = CategoryEntry.class)
	@JoinTable(name = CategoryEntry.JOIN_TABLE_OFFER, joinColumns = { @JoinColumn(name = TABLE_PK_COLNAME, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = CategoryEntry.TABLE_PK_COLNAME, nullable = false, updatable = false) })
	private List<I_CategoryEntryModel> categoryEntries;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getWorkTime()
	 */
	@Override
	public String getWorkTime() {
		return workTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#setWorkTime(java.lang.String)
	 */
	@Override
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getWorkType()
	 */
	@Override
	public E_OfferWorkType getWorkType() {
		return workType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setWorkType(de.fraunhofer.fokus.
	 * oefit.adhoc.custom.E_OfferWorkType)
	 */
	@Override
	public void setWorkType(E_OfferWorkType workType) {
		this.workType = workType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getType()
	 */
	@Override
	public E_OfferType getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setType(de.fraunhofer.fokus.oefit
	 * .adhoc.custom.E_OfferType)
	 */
	@Override
	public void setType(E_OfferType type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getStatus()
	 */
	@Override
	public E_OfferStatus getStatus() {
		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setStatus(de.fraunhofer.fokus.oefit
	 * .adhoc.custom.E_OfferStatus)
	 */
	@Override
	public void setStatus(E_OfferStatus status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getSocialStatus()
	 */
	@Override
	public int getSocialStatus() {
		return socialStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#setSocialStatus(int)
	 */
	@Override
	public void setSocialStatus(int socialStatus) {
		this.socialStatus = socialStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#isContactAgency()
	 */
	@Override
	public boolean isContactAgency() {
		return contactAgency;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#setContactAgency(boolean)
	 */
	@Override
	public void setContactAgency(boolean contactAgency) {
		this.contactAgency = contactAgency;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getCreated()
	 */
	@Override
	public LocalDateTime getCreated() {
		return created;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setCreated(java.time.LocalDateTime)
	 */
	@Override
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getUpdated()
	 */
	@Override
	public LocalDateTime getUpdated() {
		return updated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setUpdated(java.time.LocalDateTime)
	 */
	@Override
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getExpires()
	 */
	@Override
	public LocalDateTime getExpires() {
		return expires;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setExpires(java.time.LocalDateTime)
	 */
	@Override
	public void setExpires(LocalDateTime expires) {
		this.expires = expires;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getPublish()
	 */
	@Override
	public LocalDateTime getPublish() {
		return publish;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setPublish(java.time.LocalDateTime)
	 */
	@Override
	public void setPublish(LocalDateTime publish) {
		this.publish = publish;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getAddress()
	 */
	@Override
	public I_AddressModel getAddress() {
		return address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setAddress(de.particity.model.impl
	 * .Address)
	 */
	@Override
	public void setAddress(I_AddressModel address) {
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getContact()
	 */
	@Override
	public I_ContactModel getContact() {
		return contact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#setContact(long)
	 */
	@Override
	public void setContact(I_ContactModel contact) {
		this.contact = contact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getSndContact()
	 */
	@Override
	public I_ContactModel getSndContact() {
		return sndContact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setSndContact(de.particity.model
	 * .impl.Contact)
	 */
	@Override
	public void setSndContact(I_ContactModel sndContact) {
		this.sndContact = sndContact;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getOrgId()
	 */
	@Override
	public I_OrganizationModel getOrg() {
		return org;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setOrgId(de.particity.model.impl
	 * .Organization)
	 */
	@Override
	public void setOrg(I_OrganizationModel org) {
		this.org = org;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_OfferModel#getCategoryEntries()
	 */
	@Override
	public List<I_CategoryEntryModel> getCategoryEntries() {
		return categoryEntries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_OfferModel#setCategoryEntries(java.util.List)
	 */
	@Override
	public void setCategoryEntries(List<I_CategoryEntryModel> categoryEntries) {
		this.categoryEntries = categoryEntries;
	}

}
