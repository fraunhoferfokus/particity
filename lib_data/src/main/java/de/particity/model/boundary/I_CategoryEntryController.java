package de.particity.model.boundary;

import java.util.List;
import java.util.Map;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_CategoryEntryModel;

public interface I_CategoryEntryController extends I_ModelController<I_CategoryEntryModel, Long> {

	I_CategoryEntryModel addCategoryEntry(long catId, String name,
			String descr, long parentId);

	List<I_CategoryEntryModel> getByCategory(long catId);

	List<I_CategoryEntryModel> getChildEntriesById(long itemId);

	List<I_CategoryEntryModel> getCategoryEntriesByOffer(long offerId, E_CategoryType type); 
	
	Long[] getByOfferAsLong(long id, E_CategoryType type);

	Map<Long, String> getMapByCategoryId(long catId);

	List<I_CategoryEntryModel> getByCategorySorted(long catId);
}
