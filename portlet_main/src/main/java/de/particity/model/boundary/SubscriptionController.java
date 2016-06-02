package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_SubscriptionModel;
import de.particity.model.impl.Subscription;
import de.particity.model.repository.SubscriptionRepository;

@Singleton
public class SubscriptionController implements I_SubscriptionController {

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
	
	
}
