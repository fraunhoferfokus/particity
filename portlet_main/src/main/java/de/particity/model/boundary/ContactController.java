package de.particity.model.boundary;

import java.util.List;

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

	@Override
	public void delete(I_ContactModel entity) {
		repo.remove((Contact) entity);
	}

	@Override
	public void delete(Long pk) {
		repo.removeById(pk);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public List<I_ContactModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_ContactModel add(String forename, String surname,
			String phone, String fax, String mail,
			String www) {
		I_ContactModel entity = repo.findByForenameAndSurnameAndEmail(forename, surname, mail);
		if (entity == null) {
			entity = new Contact();
			entity.setEmail(mail);
			entity.setForename(forename);
			entity.setSurname(surname);
		}
		entity.setTel(phone);
		entity.setFax(fax);
		entity.setWww(www);
		return persist(entity);
	}
	
	
}
