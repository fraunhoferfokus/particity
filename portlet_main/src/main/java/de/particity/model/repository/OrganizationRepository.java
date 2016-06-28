package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.SingleResultType;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.particity.model.I_OrganizationModel;
import de.particity.model.impl.Organization;
import de.particity.model.map.OrganizationMapper;

@Repository
@Transactional
@MappingConfig(OrganizationMapper.class)
public interface OrganizationRepository extends EntityRepository<I_OrganizationModel, Long> {
	
	void removeById(long id);

	List<I_OrganizationModel> findByOwner(String owner);

	@Query(singleResult=SingleResultType.ANY)
	I_OrganizationModel findTop1ByOwner(String owner);

	@Query(named=Organization.getByUserListEntry, singleResult=SingleResultType.ANY)
	I_OrganizationModel findByUser(String user);

	long countByStatus(E_OrgStatus status);

	List<I_OrganizationModel> findAll(int start, int pageSize, String orderType);

	@Query(named=Organization.orderByCustom)
	QueryResult<I_OrganizationModel> fetchAll(@FirstResult int start, @MaxResults int pageSize);
}
