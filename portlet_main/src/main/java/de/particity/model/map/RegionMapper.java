package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_RegionModel;
import de.particity.model.impl.Region;

@ApplicationScoped
public class RegionMapper extends SimpleQueryInOutMapperBase<Region, I_RegionModel> {

	@Override
	protected Object getPrimaryKey(I_RegionModel dto) {
		return dto.getId();
	}

	@Override
	protected I_RegionModel toDto(Region entity) {
		return entity;
	}

	@Override
	protected Region toEntity(Region entity, I_RegionModel dto) {
		return (Region) dto;
	}

}
