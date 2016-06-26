package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.particity.model.I_ContactModel;
import de.particity.model.map.ContactMapper;

@Repository
@Transactional
@MappingConfig(ContactMapper.class)
public interface ContactRepository extends EntityRepository<I_ContactModel, Long> {
	
	void removeById(long id);

	List<I_ContactModel> findAll(@FirstResult int start, @MaxResults int pageSize);

	I_ContactModel findByForenameAndSurnameAndEmail(String forename, String surname, String email);
}
