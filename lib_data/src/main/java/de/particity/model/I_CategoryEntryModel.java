package de.particity.model;

import java.util.List;

public interface I_CategoryEntryModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public long getParentId();

	public void setParentId(long parentId);

	public I_CategoryModel getCategory();

	public void setCategory(I_CategoryModel category);

	public List<I_SubscriptionModel> getSubscriptions();

	public void setSubscriptions(List<I_SubscriptionModel> subscriptions);

	public List<I_OfferModel> getOffers();

	public void setOffers(List<I_OfferModel> offers);

}