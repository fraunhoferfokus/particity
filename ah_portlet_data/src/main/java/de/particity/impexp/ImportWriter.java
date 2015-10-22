package de.particity.impexp;

import java.util.List;

import javax.xml.bind.JAXBElement;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.particity.schemagen.impexpv100.CategoryType;
import de.particity.schemagen.impexpv100.ConfigurationType;
import de.particity.schemagen.impexpv100.ImportExportRoot;
import de.particity.schemagen.impexpv100.OfferType;
import de.particity.schemagen.impexpv100.OrganisationType;
import de.particity.schemagen.impexpv100.SubscriptionType;

public class ImportWriter {

	public ImportWriter() {}
	
	public void write(JAXBElement data) {
		// TODO - throw exception on invalid type
		if (data != null) {
			ImportExportRoot root = (ImportExportRoot) data.getValue();
			initCategories(root.getCategory());
			initConfig(root.getConfig());
			initOrganisations(root.getOrganisation());
			initOffers(root.getOffer());
			initSubscriptions(root.getSubscription());
		}
	}
	
	public void initCategories(List<CategoryType> categories) {
		if (categories != null && categories.size() > 0) {
			for (CategoryType type: categories) {
				
			}
		}
	}
	
	public void initConfig(List<ConfigurationType> config) {
		
	}
	
	public void initOrganisations(List<OrganisationType> organisations) {
		
	}
	
	public void initOffers(List<OfferType> offers) {
		
	}
	
	public void initSubscriptions(List<SubscriptionType> subscriptions) {
		
	}
	
	
}
