package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_CategoryEntryModel;
import de.particity.model.impl.CategoryEntry;
import de.particity.model.repository.CategoryEntryRepository;

@Singleton
public class CategoryEntryController implements I_CategoryEntryController {

	@Inject
	private CategoryEntryRepository repo;

	@Override
	public I_CategoryEntryModel get(Long pk) {
		return repo.findBy(pk);
	}
	
	@Override
	public I_CategoryEntryModel persist(I_CategoryEntryModel entity) {
		return repo.save((CategoryEntry) entity);
	}

	@Override
	public I_CategoryEntryModel create() {
		return new CategoryEntry();
	}
	
}
