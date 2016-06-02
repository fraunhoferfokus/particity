package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_RegionModel;
import de.particity.model.impl.Region;
import de.particity.model.repository.RegionRepository;

@Singleton
public class RegionController implements I_RegionController {

	@Inject
	private RegionRepository repo;

	@Override
	public I_RegionModel get(Long pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_RegionModel persist(I_RegionModel entity) {
		return repo.save((Region) entity);
	}

	@Override
	public I_RegionModel create() {
		return new Region();
	}
	
	
}
