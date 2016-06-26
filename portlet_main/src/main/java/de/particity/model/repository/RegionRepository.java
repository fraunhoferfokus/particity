package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.particity.model.I_RegionModel;
import de.particity.model.map.RegionMapper;

@Repository
@Transactional
@MappingConfig(RegionMapper.class)
public interface RegionRepository extends EntityRepository<I_RegionModel, Long> {
	
	void removeById(long id);

	List<I_RegionModel> findAll(@FirstResult int start, @MaxResults int pageSize);

	I_RegionModel findByCountryAndCityAndZip(String country, String city, String zip);
	
}
