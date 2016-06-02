package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

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
	
	
}
