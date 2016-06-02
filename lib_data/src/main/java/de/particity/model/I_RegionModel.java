package de.particity.model;

public interface I_RegionModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getZip();

	public void setZip(String zip);

	public String getCity();

	public void setCity(String city);

	public String getCountry();

	public void setCountry(String country);

	public int getPermissions();

	public void setPermissions(int permissions);

}