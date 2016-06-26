package de.particity.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_CategoryModel;

@Entity
@Table(name=Category.TABLE)
public class Category implements I_CategoryModel {
	
	public static final String TABLE = "pa_cat";

	public static final String TABLE_PK_COLNAME = "categoryId";
	
	@Id
	@GeneratedValue
	@Column(name = TABLE_PK_COLNAME, unique = true, nullable = false)
	private long id;
	
	private String name;
	private String description;
	
    @Enumerated(EnumType.STRING)
	private E_CategoryType type;

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#getType()
	 */
	@Override
	public E_CategoryType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see de.particity.model.impl.I_CategoryModel#setType(de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType)
	 */
	@Override
	public void setType(E_CategoryType type) {
		this.type = type;
	}


    
}
