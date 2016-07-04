package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_CategoryModel;
import de.particity.model.impl.Category;

@ApplicationScoped
public class CategoryMapper extends SimpleQueryInOutMapperBase<Category, I_CategoryModel> {

	@Override
	protected Object getPrimaryKey(I_CategoryModel dto) {
		return dto.getId();
	}

	@Override
	protected I_CategoryModel toDto(Category entity) {
		return entity;
	}

	@Override
	protected Category toEntity(Category entity, I_CategoryModel dto) {
		return (Category) dto;
	}

}
