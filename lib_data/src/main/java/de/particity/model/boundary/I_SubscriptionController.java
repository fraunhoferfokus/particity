package de.particity.model.boundary;

import java.util.List;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.particity.model.I_SubscriptionModel;

public interface I_SubscriptionController extends I_ModelController<I_SubscriptionModel, String> {

	I_SubscriptionModel add(String mail, long[] categories, String uuid,
			E_SubscriptionStatus status);

	void clearFromCategoryEntryId(long id);

	List<I_SubscriptionModel> getByMail(String email);

	List<String> getUserAddresses();

	List<I_SubscriptionModel> getUserAddressesByCategoryEntries(Long[] cats);

}
