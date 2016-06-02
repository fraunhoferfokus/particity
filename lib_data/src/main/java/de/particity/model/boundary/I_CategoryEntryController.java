package de.particity.model.boundary;

import java.util.List;

import de.particity.model.I_CategoryEntryModel;

public interface I_CategoryEntryController extends I_ModelController<I_CategoryEntryModel, Long> {

	I_CategoryEntryModel addCategoryEntry(long catId, String name,
			String descr, long parentId);

	List<I_CategoryEntryModel> getByCategory(long catId);

	List<I_CategoryEntryModel> getChildEntriesById(long itemId);

}
