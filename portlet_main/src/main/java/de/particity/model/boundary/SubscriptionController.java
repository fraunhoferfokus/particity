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
import de.particity.model.impl.CategoryEntry;
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
		Subscription entity = repo.findBy(pk);
		if (entity != null)
			delete(entity);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_SubscriptionModel> get(int from, int to) {
		return (List) repo.findAll(from, to-from);
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
				CategoryEntry catEntry = catEntryRepo.findBy(catEntryId);
				if (catEntry != null)
					catEntries.add(catEntry);
			}
			entity.setCategoryEntries(catEntries);
		}
		return persist(entity);
	}

	@Override
	public void clearFromCategoryEntryId(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<I_SubscriptionModel> getByMail(String email) {
		return (List) repo.findByEmail(email);
	}

	@Override
	public List<String> getUserAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_SubscriptionModel> getUserAddressesByCategoryEntries(
			Long[] cats) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSubscriptionStatus(Long subId, E_SubscriptionStatus validated) {
		// TODO Auto-generated method stub
		
	}
	
	
}
