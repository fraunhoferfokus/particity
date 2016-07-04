package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import de.particity.model.I_RegionModel;
import de.particity.model.impl.Region;
import de.particity.model.map.RegionMapper;

@Repository(forEntity=Region.class)
@Transactional
@MappingConfig(RegionMapper.class)
public interface RegionRepository extends EntityRepository<I_RegionModel, Long> {
	
	void removeById(long id);

	List<I_RegionModel> findAll(@FirstResult int start, @MaxResults int pageSize);

	I_RegionModel findByCountryAndCityAndZip(String country, String city, String zip);
	
}
