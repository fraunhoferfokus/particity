package de.particity.model.boundary;

import java.util.List;

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

	@Override
	public void delete(I_ConfigModel entity) {
		repo.remove((Config) entity);
	}

	@Override
	public void delete(E_ConfigKey pk) {
		repo.removeById(pk);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_ConfigModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public void update(E_ConfigKey key, String value) {
		I_ConfigModel entity = repo.findBy(key);
		if (entity == null) {
			entity = new Config();
			entity.setName(key);
		}
		entity.setValue(value);
		persist(entity);
	}
	
	
}
