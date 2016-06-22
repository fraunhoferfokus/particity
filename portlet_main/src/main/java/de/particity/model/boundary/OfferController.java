package de.particity.model.boundary;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;
import de.particity.model.I_AddressModel;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.impl.Offer;
import de.particity.model.repository.CategoryEntryRepository;
import de.particity.model.repository.OfferRepository;
import de.particity.model.repository.OrganizationRepository;

@Singleton
public class OfferController implements I_OfferController {

	@Inject
	private OfferRepository repo;
	
	@Inject
	private OrganizationRepository orgRepo;
	
	@Inject
	private CategoryEntryRepository catEntryRepo;

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
		I_OfferModel result = new Offer();
		result.setStatus(E_OfferStatus.NEW);
		result.setCreated(CustomServiceUtils.time());
		return result;
	}

	@Override
	public void delete(I_OfferModel entity) {
		repo.remove((Offer) entity);
	}

	@Override
	public void delete(Long pk) {
		repo.removeById(pk);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_OfferModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_OfferModel add(long offerId, E_OfferType type, String title,
			String descr, String workHours, E_OfferWorkType workType,
			long publishDateTime, long expireDateTime, I_AddressModel address,
			I_ContactModel contact, I_ContactModel contact2,
			boolean agencyContact, long orgId, long[] catEntryIds) {
		I_OfferModel result = null;
		I_OrganizationModel org = orgRepo.findBy(orgId);
		if (org != null) {
			// get offer, if ID present
			if (offerId >= 0) {
				result = repo.findBy(offerId);
			}
			// otherwise create new
			if (result == null)
				result = create();
			else {
				// if no moderation configured, just set validared
				if (agencyContact && !CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.MODERATE_OFFERS)) {
					result.setStatus(E_OfferStatus.VALIDATED);
				} else
					result.setStatus(E_OfferStatus.CHANGED);					
			}
			
			List<I_CategoryEntryModel> catEntrys = new LinkedList<>();
			if (catEntryIds != null) {
				for (long catEntryId : catEntryIds) {
					I_CategoryEntryModel catEntry = catEntryRepo.findBy(catEntryId);
					if (catEntry != null) catEntrys.add(catEntry);
				}
			}
			result.setTitle(title);
			result.setDescription(descr);
			result.setWorkTime(workHours);
			result.setWorkType(workType);
			result.setType(type);
			result.setPublish(CustomServiceUtils.toLocalDateTime(publishDateTime));
			result.setExpires(CustomServiceUtils.toLocalDateTime(expireDateTime));
			result.setAddress(address);
			result.setContact(contact);
			result.setSndContact(contact2);
			result.setContactAgency(agencyContact);
			result.setOrg(org);
			result.setCategoryEntries(catEntrys);
			result.setUpdated(CustomServiceUtils.time());
			result = repo.save(result);
		}
		return result;
	}

	@Override
	public void clearFromCategoryEntryId(long id) {
		List<I_OfferModel> offers = repo.findByCategoryEntries(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), Long.toString(id));
		I_CategoryEntryModel catEntry = catEntryRepo.findBy(id);
		if (offers != null && catEntry != null) {
			for (I_OfferModel offer: offers) {
				List<I_CategoryEntryModel> catEntries = offer.getCategoryEntries();
				catEntries.remove(catEntry);
				repo.save(offer);
			}
		}
	}

	@Override
	public Integer countPublishedByOrg(long orgId) {
		Integer result = null;
		if (orgId >= 0)
			result = repo.countByStatusAndOrganization_id(E_OfferStatus.VALIDATED, orgId);
		else
			result = repo.countByStatus(E_OfferStatus.VALIDATED);
		return result;
	}

	@Override
	public int countByCategories(Long[] catId) {
		return repo.countByCategories(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), CustomServiceUtils.arrToStr(catId));
	}

	@Override
	public int countByCategoryEntries(String[] entryIds) {
		return repo.countByCategoryEntries(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), CustomServiceUtils.arrToStr(entryIds));
	}

	@Override
	public Integer countByTypes(E_OfferType[] itypes) {
		return repo.countByTypes(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), CustomServiceUtils.arrToStr(itypes));
	}

	@Override
	public Integer countByTypesAndCategoryEntriesAndOrg(String items, String types,
			long orgId, Float lat, Float lon, Integer dist) {
		return repo.countByVarious(items, types, orgId, lat, lon, dist);
	}

	@Override
	public List<I_OfferModel> getPublishedByOrg(long orgId, int from, int to) {
		List<I_OfferModel> result = null;
		if (orgId >= 0)
			result = repo.findByStatusAndOrganization_idOrderByPublishDesc(E_OfferStatus.VALIDATED, orgId, from, to-from);
		else
			result = repo.findByStatusOrderByPublishDesc(E_OfferStatus.VALIDATED, from, to-from);
		return result;
	}

	@Override
	public List<I_OfferModel> getByCategories(Long[] catId, int from,
			int to) {
		return repo.findByCategories(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), CustomServiceUtils.arrToStr(catId), from, to-from);
	}

	@Override
	public List<I_OfferModel> getByCategoryEntries(String[] entryIds,
			int from, int to) {
		return repo.findByCategoryEntries(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), CustomServiceUtils.arrToStr(entryIds), from, to-from);
	}

	@Override
	public List<I_OfferModel> getByTypes(E_OfferType[] itypes, int from,
			int to) {
		return repo.findByTypes(E_OfferStatus.VALIDATED, CustomServiceUtils.time(), CustomServiceUtils.time(), CustomServiceUtils.arrToStr(itypes), from, to-from);
	}

	@Override
	public List<I_OfferModel> getByTypesAndCategoryEntriesAndOrg(String items,
			String types, long orgId, int from, int to, Float lat, Float lon,
			Integer dist) {
		return repo.findByVarious(items, types, orgId, lat, lon, dist, from, to);
	}

	@Override
	public int countByAddress(long id) {
		return repo.countByAddress_id(id);
	}

	@Override
	public List<I_OfferModel> findExpiredForOrg(long id, long minExpired,
			long now) {
		return repo.findByExpiresAndOrgId(id, minExpired, now);
	}

	@Override
	public List<I_OfferModel> getNewlyPublished(long publishStartTime) {
		return repo.findByIssuerTime(E_OfferStatus.VALIDATED, publishStartTime , CustomServiceUtils.timeMillis(), CustomServiceUtils.timeMillis());
	}


	@Override
	public I_OfferModel getLastForOrg(long id) {
		return repo.findFirstByOrg_idAndPublishLessThanOrderByPublishDesc(id, CustomServiceUtils.timeMillis());
	}

	@Override
	public void setSndContact(long offerId, I_ContactModel contact, E_OfferStatus status) {
		I_OfferModel offer = repo.findBy(offerId);
		if (offer != null) {
			offer.setSndContact(contact);
			offer.setStatus(status);
			repo.save(offer);
		}
	}

	@Override
	public void setOfferStatus(long offerId, E_OfferStatus status) {
		I_OfferModel offer = repo.findBy(offerId);
		if (offer != null) {
			offer.setStatus(status);
			repo.save(offer);
		}
	}

	@Override
	public void addSocialStatus(Long offerId, int bitmask) {
		I_OfferModel offer = repo.findBy(offerId);
		if (offer != null) {
			offer.setSocialStatus(bitmask | offer.getSocialStatus());
			repo.save(offer);
		}
	}

	@Override
	public int countByStatus(E_OfferStatus status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<I_OfferModel> get(int start, int end, String orderColumn,
			String orderType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByOrgId(long orgId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<I_OfferModel> get(long orgId, int start, int end,
			String orderColumn, String orderType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
