package de.particity.model.impl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_ConfigModel;

@Entity
@Table(name=Config.TABLE)
public class Config implements I_ConfigModel {
	
	public static final String TABLE = "pa_config";

	@Id
    @Enumerated(EnumType.STRING)
	private E_ConfigKey name;
	private String value;
	
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ConfigModel#getName()
	 */
	@Override
	public E_ConfigKey getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ConfigModel#setName(de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey)
	 */
	@Override
	public void setName(E_ConfigKey name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ConfigModel#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_ConfigModel#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
