package de.particity.model.boundary;

import java.util.List;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_AddressModel;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;


public interface I_OfferController extends I_ModelController<I_OfferModel, Long> {

	I_OfferModel add(long offerId, int intValue, String title, String descr,
			String workHours, int intValue2, long publishDateTime,
			long expireDateTime, I_AddressModel address,
			I_ContactModel contact, I_ContactModel contact2,
			boolean agencyContact, long orgId, long[] categories);

	List<I_CategoryEntryModel> getCategoriesByOffer(long id,
			E_CategoryType search);

	void clearFromCategoryEntryId(long id);

	Integer countPublishedOffers(long orgId);

	int countOfferByCategoryId(Long[] catId);

	int countOfferByCategoryItems(String[] itemIds);

	Integer countOfferByOfferTypes(int[] itypes);

	Integer countOfferByTypesAndCItemsAndOrg(String items, String types,
			long orgId, Float lat, Float lon, Integer dist);

	List<I_OfferModel> getPublishedOffers(int from, int to, long orgId);

	List<I_OfferModel> getOfferByCategoryId(Long[] catId, int from, int to);

	List<I_OfferModel> getOfferByCategoryItems(String[] itemIds, int from,
			int to);

	List<I_OfferModel> getOfferByOfferTypes(int[] itypes, int from, int to);

	List<I_OfferModel> getOfferByTypesAndCItemsAndOrg(String items,
			String types, long orgId, int from, int to, Float lat, Float lon,
			Integer dist);

	int countOfferByAddress(long id);

	List<I_OfferModel> findExpiredForOrg(long id, long minExpired, long now);

	List<I_OfferModel> getNewlyPublished(long lastUpdate);

	Long[] getCategoriesAsLong(long id, E_CategoryType search);

	I_OfferModel getLastOfferForOrganization(long id);

}
