package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_OrganizationModel;
import de.particity.model.impl.Organization;

@ApplicationScoped
public class OrganizationMapper extends SimpleQueryInOutMapperBase<Organization, I_OrganizationModel> {

	@Override
	protected Object getPrimaryKey(I_OrganizationModel dto) {
		return dto.getId();
	}

	@Override
	protected I_OrganizationModel toDto(Organization entity) {
		return entity;
	}

	@Override
	protected Organization toEntity(Organization entity, I_OrganizationModel dto) {
		return (Organization) dto;
	}

}
