package de.particity.model.boundary;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
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

	@Override
	public void delete(I_CategoryModel entity) {
		repo.remove((Category) entity);
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
	public List<I_CategoryModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_CategoryModel addCategory(String name, String descr,
			E_CategoryType type) {
		I_CategoryModel cat = get(name,type);
		if (cat == null) {
			cat = new Category();
			cat.setName(name);
			cat.setType(type);
		}
		cat.setDescription(descr);
		return persist(cat);
	}

	@Override
	public I_CategoryModel get(String name, E_CategoryType type) {
		return repo.findByNameAndType(name, type);
	}

	@Override
	public Map<Long, String> getCategoryMap(E_CategoryType type,
			boolean includeEmpty) {
		final Map<Long, String> result = new TreeMap<Long, String>();
		final List<I_CategoryModel> cats = repo.findByType(type);
		if (cats != null) {
			if (includeEmpty) {
				result.put(-1L, "-");
			}
			for (I_CategoryModel cat : cats) {
				result.put(cat.getId(), cat.getName());
			}
		}
		return result;
	}

	@Override
	public List<I_CategoryModel> getByType(E_CategoryType type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
