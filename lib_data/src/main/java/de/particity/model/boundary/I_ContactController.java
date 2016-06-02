package de.particity.model.boundary;

import de.particity.model.I_ContactModel;

public interface I_ContactController extends I_ModelController<I_ContactModel, Long> {

	I_ContactModel add(String contact1Fn, String contact1Sn,
			String contact1Phone, Object object, String contact1Mail,
			Object object2);


}
