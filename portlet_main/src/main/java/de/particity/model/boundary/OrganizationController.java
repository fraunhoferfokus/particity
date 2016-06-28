package de.particity.model.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType;
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
		repo.removeById(pk);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public I_OrganizationModel add(String owner, String name, String holder,
			String descr, String legalStatus, I_AddressModel address,
			I_ContactModel contact) {
		I_OrganizationModel result = repo.findTop1ByOwner(owner);
		if (result == null) {
			result = create();
			result.setCreated(CustomServiceUtils.time());
			result.setStatus(E_OrgStatus.NEW);
			result.setOwner(owner);
		} else {
			result.setStatus(E_OrgStatus.CHANGED);
		}
		result.setName(name);
		result.setHolder(holder);
		result.setDescription(descr);
		result.setLegalStatus(legalStatus);
		result.setAddress(address);
		result.setContact(contact);
		result.setUpdated(CustomServiceUtils.time());
		
		if (!CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.MODERATE_ORGS)) {
			result.setStatus(E_OrgStatus.VALIDATED);
		}
		
		result = repo.save(result);
		
		return result;
	}

	@Override
	public List<I_OrganizationModel> get(int from, int to) {
		return repo.findAll(from, to-from);
	}

	@Override
	public I_OrganizationModel getByOwnerMail(String ownerEmail) {
		return repo.findTop1ByOwner(ownerEmail);
	}

	@Override
	public I_OrganizationModel getByUserMail(String userMail) {
		return repo.findByUser(userMail);
	}

	@Override
	public void updateLogoLocation(long orgId, String logoLocation) {
		I_OrganizationModel org = repo.findBy(orgId);
		if (org != null) {
			org.setLogoLocation(logoLocation);
			repo.save(org);
		}
	}

	@Override
	public void updateOwner(String oldMail, String newMail) {
		List<I_OrganizationModel> orgs = repo.findByOwner(oldMail);
		if (orgs != null) {
			for (I_OrganizationModel org: orgs) {
				org.setOwner(newMail);
				repo.save(org);
			}
		}
	}

	@Override
	public void addUser(long orgId, String mail) {
		I_OrganizationModel org = repo.findBy(orgId);
		if (org != null) {
			String users = org.getUserList();
			if (users.length() > 0) {
				users += ",";
			}
			users += mail.toLowerCase();
			org.setUserList(users);
			repo.save(org);
		}
	}

	@Override
	public void setStatus(Long orgId, E_OrgStatus status) {
		I_OrganizationModel org = repo.findBy(orgId);
		if (org != null) {
			org.setStatus(status);
			repo.save(org);
		}
	}

	@Override
	public long countByStatus(E_OrgStatus status) {
		return repo.countByStatus(status);
	}

	@Override
	public List<I_OrganizationModel> get(int start, int end,
			String orderColumn, E_OrderType orderType) {
		List<I_OrganizationModel> result = null;
		switch (orderType) {
			case ASC:
				result =  repo.fetchAll(start, end-start).orderAsc(orderColumn, true).getResultList();
				break;
			case DESC:
				result =  repo.fetchAll(start, end-start).orderDesc(orderColumn, true).getResultList();
				break;
		}
		return result;
	}
	
	
}
