package de.particity.model;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;

public interface I_CategoryModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public E_CategoryType getType();

	public void setType(E_CategoryType type);

}