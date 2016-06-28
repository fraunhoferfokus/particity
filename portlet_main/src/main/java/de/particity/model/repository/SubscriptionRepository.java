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
	
	void removeById(String pk);

	List<I_SubscriptionModel> findAll(@FirstResult int start, @MaxResults int pageSize);
	
	List<I_SubscriptionModel> findByEmail(String email);

	@Query(named=Subscription.getUsersBySubscriptions)
	List<I_SubscriptionModel> findUsers();
	
	@Query(named=Subscription.getByCategoryItems)
	List<I_SubscriptionModel> findByCategoryItems(E_SubscriptionStatus status, Long[] categoryEntryIds);
}
