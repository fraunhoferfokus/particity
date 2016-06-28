package de.particity.model.boundary;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.impl.Subscription;
import de.particity.model.repository.CategoryEntryRepository;
import de.particity.model.repository.SubscriptionRepository;

@Singleton
public class SubscriptionController implements I_SubscriptionController {

	@Inject
	private CategoryEntryRepository catEntryRepo;
	
	@Inject
	private SubscriptionRepository repo;

	@Override
	public I_SubscriptionModel get(String pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_SubscriptionModel persist(I_SubscriptionModel entity) {
		return repo.save((Subscription) entity);
	}

	@Override
	public I_SubscriptionModel create() {
		return new Subscription();
	}

	@Override
	public void delete(I_SubscriptionModel entity) {
		repo.remove((Subscription) entity);
	}

	@Override
	public void delete(String pk) {
		repo.removeById(pk);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_SubscriptionModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_SubscriptionModel add(String mail, long[] categories, String uuid,
			E_SubscriptionStatus status) {
		List<I_SubscriptionModel> entries = getByMail(mail);
		if (uuid == null && entries != null && entries.size() > 0) {
			uuid = entries.get(0).getUuid();
		} else if (uuid == null) {
			uuid = UUID.randomUUID().toString() + "-"
			        + System.currentTimeMillis();
		}
		if (status == null)
			status = E_SubscriptionStatus.NEW;

		I_SubscriptionModel entity = create();
		entity.setUuid(uuid);
		entity.setStatus(status);
		entity.setEmail(mail);
		entity.setCreated(LocalDateTime.now());
		if (categories != null) {
			List<I_CategoryEntryModel> catEntries = new LinkedList<>();
			for (long catEntryId: categories) {
				I_CategoryEntryModel catEntry = catEntryRepo.findBy(catEntryId);
				if (catEntry != null)
					catEntries.add(catEntry);
			}
			entity.setCategoryEntries(catEntries);
		}
		return persist(entity);
	}

	@Override
	public void clearFromCategoryEntryId(long id) {
		I_CategoryEntryModel catEntry = catEntryRepo.findBy(id);
		if (catEntry != null) {
			List<I_SubscriptionModel> subs = repo.findByCategoryItems(E_SubscriptionStatus.VALIDATED, new Long[]{ id });
			if (subs != null) {
				for (I_SubscriptionModel sub: subs) {
					if (sub.getCategoryEntries().remove(catEntry))
						repo.save(sub);
				}
			}
		}
	}

	@Override
	public List<I_SubscriptionModel> getByMail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<String> getUserAddresses() {
		List<String> result = new LinkedList<>();
		
		List<I_SubscriptionModel> subs = repo.findUsers();
		for (I_SubscriptionModel sub: subs)
			result.add(sub.getEmail());
		
		return result;
	}

	@Override
	public List<I_SubscriptionModel> getByCategoryEntries(
			Long[] cats) {
		return repo.findByCategoryItems(E_SubscriptionStatus.VALIDATED, cats);
	}

	@Override
	public void setSubscriptionStatus(String uuid, E_SubscriptionStatus status) {
		I_SubscriptionModel sub = repo.findBy(uuid);
		if (sub != null) {
			sub.setStatus(status);
			repo.save(sub);
		}
	}

	@Override
	public List<I_SubscriptionModel> getAllSameUserByUuid(String uuid) {
		I_SubscriptionModel uuidSub = repo.findBy(uuid);
		List<I_SubscriptionModel> result = new LinkedList<>();
		
		if (uuidSub != null)
			result = getByMail(uuidSub.getEmail());
		
		return result;
	}
	
	
}
