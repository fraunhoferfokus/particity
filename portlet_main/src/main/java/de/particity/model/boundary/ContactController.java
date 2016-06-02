package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_ContactModel;
import de.particity.model.impl.Contact;
import de.particity.model.repository.ContactRepository;

@Singleton
public class ContactController implements I_ContactController {

	@Inject
	private ContactRepository repo;

	@Override
	public I_ContactModel get(Long pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_ContactModel persist(I_ContactModel entity) {
		return repo.save((Contact) entity);
	}

	@Override
	public I_ContactModel create() {
		return new Contact();
	}
	
	
}
