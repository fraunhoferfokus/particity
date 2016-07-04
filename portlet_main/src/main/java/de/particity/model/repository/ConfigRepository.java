package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_ConfigModel;
import de.particity.model.impl.Config;
import de.particity.model.map.ConfigMapper;

@Repository(forEntity=Config.class)
@Transactional
@MappingConfig(ConfigMapper.class)
public interface ConfigRepository extends EntityRepository<I_ConfigModel, E_ConfigKey> {
	
	void removeById(E_ConfigKey id);
	
	List<I_ConfigModel> findAll(@FirstResult int start, @MaxResults int pageSize);

}
