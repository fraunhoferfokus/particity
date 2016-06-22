package de.particity.model.boundary;

import java.util.List;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;
import de.particity.model.I_AddressModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;


public interface I_OfferController extends I_ModelController<I_OfferModel, Long> {

	I_OfferModel add(long offerId, E_OfferType type, String title, String descr,
			String workHours, E_OfferWorkType workType, long publishDateTime,
			long expireDateTime, I_AddressModel address,
			I_ContactModel contact, I_ContactModel contact2,
			boolean agencyContact, long orgId, long[] categories);
	
	void clearFromCategoryEntryId(long id);

	Integer countPublishedByOrg(long orgId);

	int countByCategories(Long[] catId);

	int countByCategoryEntries(String[] itemIds);

	Integer countByTypes(E_OfferType[] itypes);

	Integer countByTypesAndCategoryEntriesAndOrg(String items, String types,
			long orgId, Float lat, Float lon, Integer dist);

	List<I_OfferModel> getPublishedByOrg(long orgId, int from, int to);

	List<I_OfferModel> getByCategories(Long[] catId, int from, int to);

	List<I_OfferModel> getByCategoryEntries(String[] itemIds, int from,
			int to);

	List<I_OfferModel> getByTypes(E_OfferType[] itypes, int from, int to);

	List<I_OfferModel> getByTypesAndCategoryEntriesAndOrg(String items,
			String types, long orgId, int from, int to, Float lat, Float lon,
			Integer dist);

	int countByAddress(long id);

	List<I_OfferModel> findExpiredForOrg(long id, long minExpired, long now);

	List<I_OfferModel> getNewlyPublished(long publish);

	I_OfferModel getLastForOrg(long id);

	void setSndContact(long offerId, I_ContactModel contact, E_OfferStatus status);

	void setOfferStatus(long offerId, E_OfferStatus status);

	void addSocialStatus(Long offerId, int bitmask);

	int countByStatus(E_OfferStatus status);

	List<I_OfferModel> get(int start, int end, String orderColumn,
			String orderType);

	int countByOrgId(long orgId);

	List<I_OfferModel> get(long orgId, int start, int end, String orderColumn,
			String orderType);

}
