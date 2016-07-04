package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_ContactModel;
import de.particity.model.impl.Contact;

@ApplicationScoped
public class ContactMapper extends SimpleQueryInOutMapperBase<Contact, I_ContactModel> {

	@Override
	protected Object getPrimaryKey(I_ContactModel dto) {
		return dto.getId();
	}

	@Override
	protected I_ContactModel toDto(Contact entity) {
		return entity;
	}

	@Override
	protected Contact toEntity(Contact entity, I_ContactModel dto) {
		return (Contact) dto;
	}

}
