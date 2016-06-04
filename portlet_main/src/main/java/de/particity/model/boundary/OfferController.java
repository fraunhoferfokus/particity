package de.particity.model.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.particity.model.I_AddressModel;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;
import de.particity.model.impl.Offer;
import de.particity.model.repository.OfferRepository;

@Singleton
public class OfferController implements I_OfferController {

	@Inject
	private OfferRepository repo;

	@Override
	public I_OfferModel get(Long pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_OfferModel persist(I_OfferModel entity) {
		return repo.save((Offer) entity);
	}

	@Override
	public I_OfferModel create() {
		return new Offer();
	}

	@Override
	public void delete(I_OfferModel entity) {
		repo.remove((Offer) entity);
	}

	@Override
	public void delete(Long pk) {
		Offer entity = repo.findBy(pk);
		if (entity != null)
			delete(entity);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_OfferModel> get(int from, int to) {
		return (List) repo.findAll(from, to-from);
	}

	@Override
	public I_OfferModel add(long offerId, int intValue, String title,
			String descr, String workHours, int intValue2,
			long publishDateTime, long expireDateTime, I_AddressModel address,
			I_ContactModel contact, I_ContactModel contact2,
			boolean agencyContact, long orgId, long[] categories) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_CategoryEntryModel> getCategoriesByOffer(long id,
			E_CategoryType search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearFromCategoryEntryId(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer countPublishedOffers(long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOfferByCategoryId(Long[] catId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countOfferByCategoryItems(String[] itemIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer countOfferByOfferTypes(int[] itypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countOfferByTypesAndCItemsAndOrg(String items, String types,
			long orgId, Float lat, Float lon, Integer dist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OfferModel> getPublishedOffers(int from, int to, long orgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OfferModel> getOfferByCategoryId(Long[] catId, int from,
			int to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OfferModel> getOfferByCategoryItems(String[] itemIds,
			int from, int to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OfferModel> getOfferByOfferTypes(int[] itypes, int from,
			int to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OfferModel> getOfferByTypesAndCItemsAndOrg(String items,
			String types, long orgId, int from, int to, Float lat, Float lon,
			Integer dist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOfferByAddress(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<I_OfferModel> findExpiredForOrg(long id, long minExpired,
			long now) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OfferModel> getNewlyPublished(long lastUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long[] getCategoriesAsLong(long id, E_CategoryType search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I_OfferModel getLastOfferForOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSndContact(long offerId, long id, E_OfferStatus validated) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOfferStatus(long offerId, E_OfferStatus validated) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSocialStatus(Long offerId, int bitmask) {
		// TODO Auto-generated method stub
		
	}
	
	
}
