package de.particity.model.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.impl.Config;

@Repository
@Transactional
//@MappingConfig(value=)
public interface ConfigRepository extends EntityRepository<Config, E_ConfigKey> {

	
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
}