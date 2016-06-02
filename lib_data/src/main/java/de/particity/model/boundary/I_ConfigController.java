package de.particity.model.boundary;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_ConfigModel;

public interface I_ConfigController extends I_ModelController<I_ConfigModel, E_ConfigKey> {

	void update(E_ConfigKey key, String value);

}
