package de.particity.model.boundary;

import java.util.List;

import de.particity.model.I_CategoryModel;
import de.particity.model.I_Model;

public interface I_ModelController<T extends I_Model, V> {

	T create();
	
	T get(V pk);
	
	T persist(T entity);
	
	void delete(T entity);
	
	void delete(V pk);

	int count();
	
	List<T> get(int from, int to);

}
