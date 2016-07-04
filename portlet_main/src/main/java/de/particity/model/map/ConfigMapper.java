package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_ConfigModel;
import de.particity.model.impl.Config;

@ApplicationScoped
public class ConfigMapper extends SimpleQueryInOutMapperBase<Config, I_ConfigModel> {

	@Override
	protected Object getPrimaryKey(I_ConfigModel dto) {
		return dto.getName();
	}

	@Override
	protected I_ConfigModel toDto(Config entity) {
		return entity;
	}

	@Override
	protected Config toEntity(Config entity, I_ConfigModel dto) {
		return (Config) dto;
	}

}
