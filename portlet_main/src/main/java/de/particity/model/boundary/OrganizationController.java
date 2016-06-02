package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_OrganizationModel;
import de.particity.model.impl.Organization;
import de.particity.model.repository.OrganizationRepository;

@Singleton
public class OrganizationController implements I_OrganizationController {

	@Inject
	private OrganizationRepository repo;

	@Override
	public I_OrganizationModel get(Long pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_OrganizationModel persist(I_OrganizationModel entity) {
		return repo.save((Organization) entity);
	}

	@Override
	public I_OrganizationModel create() {
		return new Organization();
	}
	
	
}
