package de.particity.model;

public interface I_ContactModel extends I_Model {

	public long getId();

	public void setId(long id);

	public String getForename();

	public void setForename(String forename);

	public String getSurname();

	public void setSurname(String surname);

	public String getTel();

	public void setTel(String tel);

	public String getMobile();

	public void setMobile(String mobile);

	public String getFax();

	public void setFax(String fax);

	public String getEmail();

	public void setEmail(String email);

	public String getWww();

	public void setWww(String www);

}