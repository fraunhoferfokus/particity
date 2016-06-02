package de.particity.model.boundary;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ApplicationScoped
public class ControllerProducer {

	@Inject
	private OfferController offerCtrl;
	
	@Inject
	private AddressController addressCtrl;
	
	@Inject
	private CategoryController catCtrl;
	
	@Inject
	private CategoryEntryController catEntryCtrl;
	
	@Inject
	private ConfigController cfgCtrl;
	
	@Inject
	private ContactController contactCtrl;
	
	@Inject
	private OrganizationController orgCtrl;
	
	@Inject
	private RegionController regionCtrl;
	
	@Inject
	private SubscriptionController subCtrl;
	
	@Produces
	public I_OfferController getOfferControl() {
		return offerCtrl;
	}
	
	@Produces
	public I_AddressControler getAddressControl() {
		return addressCtrl;
	}
	
	@Produces
	public I_CategoryController getCategoryControl() {
		return catCtrl;
	}
	
	@Produces
	public I_CategoryEntryController getCategoryEntryControl() {
		return catEntryCtrl;
	}
	
	@Produces
	public I_ConfigController getConfigControl() {
		return cfgCtrl;
	}
	
	@Produces
	public I_ContactController getContactControl() {
		return contactCtrl;
	}
	
	@Produces
	public I_OrganizationController getOrganizationControl() {
		return orgCtrl;
	}
	
	@Produces
	public I_RegionController getRegionControl() {
		return regionCtrl;
	}
	
	@Produces
	public I_SubscriptionController getSubscriptionControl() {
		return subCtrl;
	}
}
