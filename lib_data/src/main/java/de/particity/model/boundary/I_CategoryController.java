package de.particity.model.boundary;

import java.util.List;
import java.util.Map;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.particity.model.I_CategoryModel;

public interface I_CategoryController extends I_ModelController<I_CategoryModel, Long> {

	I_CategoryModel addCategory(String name, String descr, E_CategoryType type);

	I_CategoryModel get(String countryName, E_CategoryType countries);

	Map<Long, String> getCategoryMap(E_CategoryType type, boolean includeEmpty);

}
