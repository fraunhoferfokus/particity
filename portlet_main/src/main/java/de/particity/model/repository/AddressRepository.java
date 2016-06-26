package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.particity.model.I_AddressModel;
import de.particity.model.map.AddressMapper;

@Repository
@Transactional
@MappingConfig(AddressMapper.class)
public interface AddressRepository extends EntityRepository<I_AddressModel, Long> {
	
	void removeById(long id);
	
    List<I_AddressModel> findByRegion_id(long id);
    
	List<I_AddressModel> findAll(@FirstResult int start, @MaxResults int pageSize);
	
	I_AddressModel findByStreetLikeAndNumberLikeAndRegion_id(String street, String number, long id);

}
