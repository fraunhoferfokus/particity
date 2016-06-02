package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_CategoryModel;
import de.particity.model.impl.Category;
import de.particity.model.repository.CategoryRepository;

@Singleton
public class CategoryController implements I_CategoryController {

	@Inject
	private CategoryRepository repo;

	@Override
	public I_CategoryModel get(Long pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_CategoryModel persist(I_CategoryModel entity) {
		return repo.save((Category) entity);
	}

	@Override
	public I_CategoryModel create() {
		return new Category();
	}
	
	
}
