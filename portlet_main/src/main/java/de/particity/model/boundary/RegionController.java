package de.particity.model.boundary;

import java.util.List;

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

	@Override
	public void delete(I_RegionModel entity) {
		repo.remove((Region) entity);
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
	public List<I_RegionModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_RegionModel add(String city, String country, String zip) {
		I_RegionModel entity = repo.findByCountryAndCityAndZip(country, city, zip);
		if (entity == null) {
			entity = create();
			entity.setCountry(country);
			entity.setCity(city);
			entity.setZip(zip);
			entity = persist(entity);
		}
		return entity;
	}
	
	
}
