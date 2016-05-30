package de.particity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=Offer.TABLE)
public class Offer {
	
	public static final String TABLE = "AHOffer";

	@Id
	@GeneratedValue
	private String id;
	
	private String value;
	
	public Offer() {		
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String val) {
		value = val;
	}
	
}
