package de.particity.model.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_CategoryModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_SubscriptionModel;

@Entity
@Table(name = CategoryEntry.TABLE)
@NamedQueries({ @NamedQuery(name = CategoryEntry.getByTypeAndOffer, query = CategoryEntry.getByTypeAndOffer_Query) })
public class CategoryEntry implements I_CategoryEntryModel {

	public static final String JOIN_TABLE_OFFER = "pa_map_offer_catentry";

	public static final String JOIN_TABLE_SUBSCR = "pa_map_offer_sub";

	public static final String TABLE = "pa_catentry";

	public static final String TABLE_PK_COLNAME = "categoryEntryId";

	public static final String getByTypeAndOffer = "categoryEntry.byTypeAndOffer";

	public static final String getByTypeAndOffer_Query = "select * from "
			+ CategoryEntry.TABLE + " entry " + "INNER JOIN "
			+ CategoryEntry.JOIN_TABLE_OFFER + " map ON map."
			+ TABLE_PK_COLNAME + "=entry." + TABLE_PK_COLNAME + " "
			+ "INNER JOIN " + Category.TABLE + " cat ON entry.categoryId=cat."
			+ Category.TABLE_PK_COLNAME + " AND cat.type=?1 " + "WHERE map."
			+ Offer.TABLE_PK_COLNAME + "=?2";

	@Id
	@GeneratedValue
	@Column(name = TABLE_PK_COLNAME, unique = true, nullable = false)
	private long id;

	private String name;
	private String description;

	private long parentId;

	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name="categoryId", nullable=false)
	private I_CategoryModel category;

	@ManyToMany(targetEntity = Subscription.class)
	@JoinTable(name = JOIN_TABLE_OFFER, joinColumns = { @JoinColumn(name = TABLE_PK_COLNAME, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = Subscription.TABLE_PK_COLNAME, nullable = false, updatable = false) })
	private List<I_SubscriptionModel> subscriptions;

	@ManyToMany(targetEntity = Offer.class)
	@JoinTable(name = JOIN_TABLE_SUBSCR, joinColumns = { @JoinColumn(name = TABLE_PK_COLNAME, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = Offer.TABLE_PK_COLNAME, nullable = false, updatable = false) })
	private List<I_OfferModel> offers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_CategoryEntryModel#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_CategoryEntryModel#setDescription(java.lang
	 * .String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getParentId()
	 */
	@Override
	public long getParentId() {
		return parentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#setParentId(long)
	 */
	@Override
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getCategory()
	 */
	@Override
	public I_CategoryModel getCategory() {
		return category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_CategoryEntryModel#setCategory(de.particity
	 * .model.impl.Category)
	 */
	@Override
	public void setCategory(I_CategoryModel category) {
		this.category = category;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getSubscriptions()
	 */
	@Override
	public List<I_SubscriptionModel> getSubscriptions() {
		return subscriptions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_CategoryEntryModel#setSubscriptions(java.util
	 * .List)
	 */
	@Override
	public void setSubscriptions(List<I_SubscriptionModel> subscriptions) {
		this.subscriptions = subscriptions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.particity.model.impl.I_CategoryEntryModel#getOffers()
	 */
	@Override
	public List<I_OfferModel> getOffers() {
		return offers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.particity.model.impl.I_CategoryEntryModel#setOffers(java.util.List)
	 */
	@Override
	public void setOffers(List<I_OfferModel> offers) {
		this.offers = offers;
	}

}
