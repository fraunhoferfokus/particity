package de.particity.model.boundary;

import java.util.List;

import de.particity.model.I_AddressModel;
import de.particity.model.I_RegionModel;

public interface I_AddressControler extends I_ModelController<I_AddressModel, Long> {


	I_AddressModel add(String street, String streetNumber, Float lat,
			Float lon, I_RegionModel region);

	List<I_AddressModel> findForRegion(long id);

}
