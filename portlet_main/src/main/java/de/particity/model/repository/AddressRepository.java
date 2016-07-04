package de.particity.model.repository;

import java.lang.reflect.InvocationHandler;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import de.particity.model.I_AddressModel;
import de.particity.model.impl.Address;
import de.particity.model.map.AddressMapper;

@Repository(forEntity=Address.class)
@Transactional
@MappingConfig(AddressMapper.class)
public interface AddressRepository extends EntityRepository<I_AddressModel, Long>, InvocationHandler {
	
	void removeById(long id);
	
    List<I_AddressModel> findByRegion_id(long id);
    
	List<I_AddressModel> findAll(@FirstResult int start, @MaxResults int pageSize);
	
	I_AddressModel findByStreetLikeAndNumberLikeAndRegion_id(String street, String number, long id);

}
