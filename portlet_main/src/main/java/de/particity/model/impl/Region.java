package de.particity.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import de.particity.model.I_RegionModel;

@Entity
@Table(name=Region.TABLE)
public class Region implements I_RegionModel {
	
	public static final String TABLE = "pa_region";

	public static final String TABLE_PK_COLNAME = "regionId";
	
	@Id
	@GeneratedValue
	@Column(name = TABLE_PK_COLNAME, unique = true, nullable = false)
	private long id;
	
	private String zip;
	private String city;
	private String country;
	private int permissions;
	
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#getZip()
	 */
	@Override
	public String getZip() {
		return zip;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#setZip(java.lang.String)
	 */
	@Override
	public void setZip(String zip) {
		this.zip = zip;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#getCity()
	 */
	@Override
	public String getCity() {
		return city;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#setCity(java.lang.String)
	 */
	@Override
	public void setCity(String city) {
		this.city = city;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#getCountry()
	 */
	@Override
	public String getCountry() {
		return country;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#setCountry(java.lang.String)
	 */
	@Override
	public void setCountry(String country) {
		this.country = country;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#getPermissions()
	 */
	@Override
	public int getPermissions() {
		return permissions;
	}
	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_RegionModel#setPermissions(int)
	 */
	@Override
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
}
