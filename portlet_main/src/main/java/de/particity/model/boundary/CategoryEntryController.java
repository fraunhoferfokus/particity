package de.particity.model.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_CategoryEntryModel;
import de.particity.model.impl.Category;
import de.particity.model.impl.CategoryEntry;
import de.particity.model.repository.CategoryEntryRepository;
import de.particity.model.repository.CategoryRepository;

@Singleton
public class CategoryEntryController implements I_CategoryEntryController {
	
	@Inject
	private CategoryRepository catRepo;
	
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

	@Override
	public void delete(I_CategoryEntryModel entity) {
		repo.remove((CategoryEntry) entity);	
	}

	@Override
	public void delete(Long pk) {
		CategoryEntry entity = repo.findBy(pk);
		if (entity != null)
			delete(entity);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_CategoryEntryModel> get(int from, int to) {
		return (List) repo.findAll(from, to-from);
	}

	@Override
	public I_CategoryEntryModel addCategoryEntry(long catId, String name,
			String descr, long parentId) {
		Category cat = catRepo.findBy(catId);
		CategoryEntry entity = new CategoryEntry();
		entity.setDescription(descr);
		entity.setName(name);
		entity.setParentId(parentId);
		entity.setCategory(cat);
		return persist(entity);
	}

	@Override
	public List<I_CategoryEntryModel> getByCategory(long catId) {
		return (List) repo.findByCategory_id(catId);
	}

	@Override
	public List<I_CategoryEntryModel> getChildEntriesById(long itemId) {
		return (List) repo.findByParentId(itemId);
	}
	
}
