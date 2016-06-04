package de.particity.model.boundary;

import de.particity.model.I_ContactModel;

public interface I_ContactController extends I_ModelController<I_ContactModel, Long> {

	I_ContactModel add(String forename, String surname,
			String phone, String fax, String mail,
			String www);


}
