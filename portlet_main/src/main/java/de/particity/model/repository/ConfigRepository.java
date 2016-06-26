package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_ConfigModel;
import de.particity.model.map.ConfigMapper;

@Repository
@Transactional
@MappingConfig(ConfigMapper.class)
public interface ConfigRepository extends EntityRepository<I_ConfigModel, E_ConfigKey> {
	
	void removeById(E_ConfigKey id);
	
	List<I_ConfigModel> findAll(@FirstResult int start, @MaxResults int pageSize);

}
