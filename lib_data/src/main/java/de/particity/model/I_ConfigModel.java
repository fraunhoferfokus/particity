package de.particity.model;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;

public interface I_ConfigModel extends I_Model {

	public E_ConfigKey getName();

	public void setName(E_ConfigKey name);

	public String getValue();

	public void setValue(String value);

}