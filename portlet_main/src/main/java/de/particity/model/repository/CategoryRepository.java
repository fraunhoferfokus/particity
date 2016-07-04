package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_CategoryModel;
import de.particity.model.impl.Category;
import de.particity.model.map.CategoryMapper;

@Repository(forEntity=Category.class)
@Transactional
@MappingConfig(CategoryMapper.class)
public interface CategoryRepository extends EntityRepository<I_CategoryModel, Long> {
	
	void removeById(long id);
	
	List<I_CategoryModel> findAll(@FirstResult int start, @MaxResults int pageSize);
	
	I_CategoryModel findByNameAndType(String name, E_CategoryType type);
	
	List<I_CategoryModel> findByType(E_CategoryType type);

}
