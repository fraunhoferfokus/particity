package de.particity.model.boundary;

import de.particity.model.I_RegionModel;

public interface I_RegionController extends I_ModelController<I_RegionModel, Long> {

	I_RegionModel add(String city, String country, String zip);

}
