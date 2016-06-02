package de.particity.model.boundary;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_AddressModel;
import de.particity.model.impl.Address;
import de.particity.model.repository.AddressRepository;

@Singleton
public class AddressController implements I_AddressControler {

	@Inject
	private AddressRepository addressCtrl;

	@Override
	public I_AddressModel get(Long pk) {
		return addressCtrl.findBy(pk);
	}

	@Override
	public I_AddressModel persist(I_AddressModel entity) {
		return addressCtrl.save((Address) entity);
	}

	@Override
	public I_AddressModel create() {
		return new Address();
	}
	
	
}
