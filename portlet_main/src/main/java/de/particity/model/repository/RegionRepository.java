package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.particity.model.impl.Region;

@Repository
@Transactional
//@MappingConfig(value=)
public interface RegionRepository extends EntityRepository<Region, Long> {

	
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
	
	List<Region> findAll(@FirstResult int start, @MaxResults int pageSize);

	Region findByCountryAndCityAndZip(String country, String city, String zip);
	
}
