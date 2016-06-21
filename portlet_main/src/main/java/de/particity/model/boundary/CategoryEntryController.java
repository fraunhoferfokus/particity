package de.particity.model.boundary;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_CategoryModel;
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
		repo.removeById(pk);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_CategoryEntryModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_CategoryEntryModel addCategoryEntry(long catId, String name,
			String descr, long parentId) {
		I_CategoryModel cat = catRepo.findBy(catId);
		I_CategoryEntryModel entity = new CategoryEntry();
		entity.setDescription(descr);
		entity.setName(name);
		entity.setParentId(parentId);
		entity.setCategory(cat);
		return persist(entity);
	}

	@Override
	public List<I_CategoryEntryModel> getByCategory(long catId) {
		return repo.findByCategory_id(catId);
	}

	@Override
	public List<I_CategoryEntryModel> getChildEntriesById(long itemId) {
		return repo.findByParentId(itemId);
	}
	
	@Override
	public List<I_CategoryEntryModel> getCategoryEntriesByOffer(long offerId,
			E_CategoryType type) {
		return repo.getCategoryEntriesByOffer(type, offerId);
	}
	
	@Override
	public Long[] getByOfferAsLong(long id, E_CategoryType type) {
		final List<I_CategoryEntryModel> categories = this.getCategoryEntriesByOffer(
		        id, type);
		final Long[] result = new Long[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = categories.get(i).getId();
		}
		return result;
	}

	@Override
	public Map<Long, String> getMapByCategoryId(long catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_CategoryEntryModel> getByCategorySorted(long catId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
