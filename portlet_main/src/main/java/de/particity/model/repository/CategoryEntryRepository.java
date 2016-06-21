package de.particity.model.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.impl.CategoryEntry;
import de.particity.model.map.CategoryEntryMapper;

@Repository
@Transactional
@MappingConfig(CategoryEntryMapper.class)
public interface CategoryEntryRepository extends EntityRepository<I_CategoryEntryModel, Long> {

	
	//@Query("select count(p) from Person p where p.age > ?1")
    //Long countAllOlderThan(int minAge);
    

    //@Query("select p from Person p where p.age between ?1 and ?2")
    //QueryResult<Person> findAllByAge(int minAge, int maxAge);
	
	//    List<Person> findByLastNameLikeOrderByAgeAscLastNameDesc(String lastName);
	
	//    List<Person> findAllOrderByAgeAsc();
	
	//    List<Person> findByNameLike(String name, @FirstResult int start, @MaxResults int pageSize);
	
	//List<Person> findByNameLike(String name, @FirstResult int start, @MaxResults int pageSize);
	
	//@Query(named = Person.BY_MIN_AGE)
    //Long countAllOlderThan(int minAge);
	
	void removeById(long id);
	
	List<I_CategoryEntryModel> findAll(@FirstResult int start, @MaxResults int pageSize);
	
	List<I_CategoryEntryModel> findByCategory_id(long id);
	
	List<I_CategoryEntryModel> findByParentId(long parentId);

	@Query(named=CategoryEntry.getByTypeAndOffer)
	List<I_CategoryEntryModel> getCategoryEntriesByOffer(E_CategoryType type, long offerId);

}
