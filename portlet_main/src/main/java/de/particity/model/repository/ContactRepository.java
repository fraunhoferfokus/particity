package de.particity.model.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import de.particity.model.I_ContactModel;
import de.particity.model.impl.Contact;
import de.particity.model.map.ContactMapper;

@Repository(forEntity=Contact.class)
@Transactional
@MappingConfig(ContactMapper.class)
public interface ContactRepository extends EntityRepository<I_ContactModel, Long> {
	
	void removeById(long id);

	List<I_ContactModel> findAll(@FirstResult int start, @MaxResults int pageSize);

	I_ContactModel findByForenameAndSurnameAndEmail(String forename, String surname, String email);
}
