package de.particity.model.boundary;

import java.util.List;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.particity.model.I_AddressModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OrganizationModel;

public interface I_OrganizationController extends I_ModelController<I_OrganizationModel, Long> {

	I_OrganizationModel add(String owner, String name, String holder,
			String descr, String legalStatus, I_AddressModel address,
			I_ContactModel contact);

	List<I_OrganizationModel> get(int i, int j);

	I_OrganizationModel getByOwnerMail(String ownerEmail);

	I_OrganizationModel getByUserMail(String ownerEmail);

	void updateLogoLocation(long orgId, String logoLocation);

	void updateOwner(String oldMail, String newMail);

	void addUser(long orgId, String mail);

	void setStatus(Long orgId, E_OrgStatus status);

	int countByStatus(E_OrgStatus status);

	List<I_OrganizationModel> get(int start, int end, String orderColumn,
			String orderType);

}
