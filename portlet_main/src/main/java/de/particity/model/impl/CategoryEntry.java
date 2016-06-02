package de.particity.model.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_CategoryModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_SubscriptionModel;

@Entity
@Table(name=CategoryEntry.TABLE)
public class CategoryEntry implements I_CategoryEntryModel {
	
	public static final String TABLE = "pa_cat";

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String description;
	
	private long parentId;
	
	@ManyToOne(targetEntity=Category.class)
	private I_CategoryModel category;
	

	@ManyToMany(targetEntity=Subscription.class)
	private List<I_SubscriptionModel> subscriptions;
	
	@ManyToMany(targetEntity=Offer.class)
	private List<I_OfferModel> offers;

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getParentId()
	 */
	@Override
	public long getParentId() {
		return parentId;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setParentId(long)
	 */
	@Override
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getCategory()
	 */
	@Override
	public I_CategoryModel getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setCategory(de.particity.model.impl.Category)
	 */
	@Override
	public void setCategory(I_CategoryModel category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getSubscriptions()
	 */
	@Override
	public List<I_SubscriptionModel> getSubscriptions() {
		return subscriptions;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setSubscriptions(java.util.List)
	 */
	@Override
	public void setSubscriptions(List<I_SubscriptionModel> subscriptions) {
		this.subscriptions = subscriptions;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#getOffers()
	 */
	@Override
	public List<I_OfferModel> getOffers() {
		return offers;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryEntryModel#setOffers(java.util.List)
	 */
	@Override
	public void setOffers(List<I_OfferModel> offers) {
		this.offers = offers;
	}

	
}
