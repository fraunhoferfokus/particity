package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_ConfigModel;
import de.particity.model.impl.Config;
import de.particity.model.repository.ConfigRepository;

@Singleton
public class ConfigController implements I_ConfigController {

	@Inject
	private ConfigRepository repo;

	@Override
	public I_ConfigModel get(E_ConfigKey pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_ConfigModel persist(I_ConfigModel entity) {
		return repo.save((Config) entity);
	}

	@Override
	public I_ConfigModel create() {
		return new Config();
	}
	
	
}
