package de.particity.model;

public interface I_AddressModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getStreet();

	public void setStreet(String street);

	public String getNumber();

	public void setNumber(String number);

	public float getCoordLat();

	public void setCoordLat(float coordLat);

	public float getCoordLon();

	public void setCoordLon(float coordLon);

	public I_RegionModel getRegion();

	public void setRegion(I_RegionModel region);

}