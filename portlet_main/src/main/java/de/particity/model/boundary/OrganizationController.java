package de.particity.model.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jboss.weld.manager.RemoveMetadataWrapperFunction;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.particity.model.I_AddressModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.impl.Organization;
import de.particity.model.repository.OrganizationRepository;

@Singleton
public class OrganizationController implements I_OrganizationController {

	@Inject
	private OrganizationRepository repo;

	@Override
	public I_OrganizationModel get(Long pk) {
		return repo.findBy(pk);
	}

	@Override
	public I_OrganizationModel persist(I_OrganizationModel entity) {
		return repo.save((Organization) entity);
	}

	@Override
	public I_OrganizationModel create() {
		return new Organization();
	}

	@Override
	public void delete(I_OrganizationModel entity) {
		repo.remove((Organization) entity);
	}

	@Override
	public void delete(Long pk) {
		Organization entity = repo.findBy(pk);
		if (entity != null)
			delete(entity);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public I_OrganizationModel add(String owner, String name, String holder,
			String descr, String legalStatus, I_AddressModel address,
			I_ContactModel contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_OrganizationModel> get(int from, int to) {
		return (List) repo.findAll(from, to-from);
	}

	@Override
	public I_OrganizationModel getByOwnerMail(String ownerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I_OrganizationModel getByUserMail(String ownerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLogoLocation(I_OrganizationModel result,
			String logoLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOwner(String oldMail, String trim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrganisationUser(long orgId, String mail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrganisationStatus(Long l_orgId, E_OrgStatus validated) {
		// TODO Auto-generated method stub
		
	}
	
	
}
