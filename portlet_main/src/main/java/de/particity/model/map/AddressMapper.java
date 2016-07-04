package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_AddressModel;
import de.particity.model.impl.Address;

@ApplicationScoped
public class AddressMapper extends SimpleQueryInOutMapperBase<Address, I_AddressModel> {

	@Override
	protected Object getPrimaryKey(I_AddressModel dto) {
		return dto.getId();
	}

	@Override
	protected I_AddressModel toDto(Address entity) {
		return entity;
	}

	@Override
	protected Address toEntity(Address entity, I_AddressModel dto) {
		return (Address) dto;
	}

}
