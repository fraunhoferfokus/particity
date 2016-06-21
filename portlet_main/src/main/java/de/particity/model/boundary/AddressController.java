package de.particity.model.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.particity.model.I_AddressModel;
import de.particity.model.I_RegionModel;
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

	@Override
	public void delete(I_AddressModel entity) {
		addressCtrl.remove((Address) entity);
	}

	@Override
	public void delete(Long pk) {
		addressCtrl.removeById(pk);
	}

	@Override
	public long count() {
		return addressCtrl.count();
	}

	@Override
	public List<I_AddressModel> get(int from, int to) {
		return addressCtrl.findAll(from, to-from);
	}

	@Override
	public I_AddressModel add(String street, String number, Float lat,
			Float lon, I_RegionModel region) {
		I_AddressModel address = getAddress(street, number, region);
		if (address == null) {
			address = new Address();
			address.setStreet(street);
			address.setNumber(number);
			address.setRegion(region);
		}
		address.setCoordLat(lat);
		address.setCoordLon(lon);
		return persist(address);
	}
	
	private I_AddressModel getAddress(String street, String number, I_RegionModel region) {
		return addressCtrl.findByStreetLikeAndNumberLikeAndRegion_id(street, number, region.getId());
	}

	@Override
	public List<I_AddressModel> findForRegion(long id) {
		return addressCtrl.findByRegion_id(id);
	}
	
	
}
