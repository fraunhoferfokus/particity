package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_CategoryEntryModel;
import de.particity.model.impl.CategoryEntry;

@ApplicationScoped
public class CategoryEntryMapper extends SimpleQueryInOutMapperBase<CategoryEntry, I_CategoryEntryModel> {

	@Override
	protected Object getPrimaryKey(I_CategoryEntryModel dto) {
		return dto.getId();
	}

	@Override
	protected I_CategoryEntryModel toDto(CategoryEntry entity) {
		return entity;
	}

	@Override
	protected CategoryEntry toEntity(CategoryEntry entity, I_CategoryEntryModel dto) {
		return (CategoryEntry) dto;
	}

}
