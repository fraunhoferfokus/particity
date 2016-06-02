package de.particity.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.particity.model.I_AddressModel;
import de.particity.model.I_RegionModel;

@Entity
@Table(name=Address.TABLE)
public class Address implements I_AddressModel {
	
	public static final String TABLE = "pa_address";

	@Id
	@GeneratedValue
	private long id;
	
	private String street;
	private String number;
	private float coordLat;
	private float coordLon;

	@ManyToOne(targetEntity=Region.class)
	private I_RegionModel region;
	
	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#getStreet()
	 */
	@Override
	public String getStreet() {
		return street;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#setStreet(java.lang.String)
	 */
	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#getNumber()
	 */
	@Override
	public String getNumber() {
		return number;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#setNumber(java.lang.String)
	 */
	@Override
	public void setNumber(String number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#getCoordLat()
	 */
	@Override
	public float getCoordLat() {
		return coordLat;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#setCoordLat(float)
	 */
	@Override
	public void setCoordLat(float coordLat) {
		this.coordLat = coordLat;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#getCoordLon()
	 */
	@Override
	public float getCoordLon() {
		return coordLon;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#setCoordLon(float)
	 */
	@Override
	public void setCoordLon(float coordLon) {
		this.coordLon = coordLon;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#getRegion()
	 */
	@Override
	public I_RegionModel getRegion() {
		return region;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.AddressModel#setRegion(de.particity.model.impl.Region)
	 */
	@Override
	public void setRegion(I_RegionModel region) {
		this.region = region;
	}

}
