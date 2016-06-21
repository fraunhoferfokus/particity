package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.impl.Subscription;
import de.particity.model.map.SubscriptionMapper;

@Repository
@Transactional
@MappingConfig(SubscriptionMapper.class)
public interface SubscriptionRepository extends EntityRepository<I_SubscriptionModel, String> {

	
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
	
	void removeById(String pk);

	List<I_SubscriptionModel> findAll(@FirstResult int start, @MaxResults int pageSize);
	
	List<I_SubscriptionModel> findByEmail(String email);

	@Query(named=Subscription.getUsersBySubscriptions, isNative=true)
	List<I_SubscriptionModel> findUsers();
	
	@Query(named=Subscription.getByCategoryItems, isNative=true)
	List<I_SubscriptionModel> findByCategoryItems(E_SubscriptionStatus status, String categoryItems);
}
