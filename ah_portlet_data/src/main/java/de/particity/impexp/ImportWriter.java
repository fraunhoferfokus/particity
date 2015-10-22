package de.particity.impexp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.particity.schemagen.impexpv100.CategoryEntryType;
import de.particity.schemagen.impexpv100.CategoryType;
import de.particity.schemagen.impexpv100.ConfigurationType;
import de.particity.schemagen.impexpv100.ImportExportRoot;
import de.particity.schemagen.impexpv100.OfferType;
import de.particity.schemagen.impexpv100.OrganisationType;
import de.particity.schemagen.impexpv100.SubscriptionType;

/**
 * Write an XML-structure that conforms to the newest supported XML-schema
 * to the database. Existing keys should not be touched, however, content
 * is not checked against duplicates.
 * 
 * This implementation MUST always match the latest JAXB-objects of the
 * current schema
 * 
 * @author sma
 *
 */
public class ImportWriter {

	private long m_objGroupId;
	private long m_objUserId;
	private long m_objCompanyId;
	private HashMap<Long, Long> m_objOrgIdMap;
	private HashMap<Long, Long> m_objCatEntryIdMap;
	
	public ImportWriter(long userId, long groupId, long companyId) {
		m_objGroupId = groupId;
		m_objUserId = userId;
		m_objCompanyId = companyId;
		m_objOrgIdMap = new HashMap<Long, Long>();
		m_objCatEntryIdMap = new HashMap<Long, Long>();
	}
	
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
				AHCategories cat = CustomCategoryServiceHandler.addMainCategory(type.getName(), type.getDescr(), E_CategoryType.valueOf(type.getType()));
				initCategoryEntries(type.getEntry(),cat.getCatId());
			}
		}
	}
	
	public void initCategoryEntries(List<CategoryEntryType> entries, long catId) {
		if (entries != null && entries.size() > 0) {
			for (CategoryEntryType entry: entries) {
				AHCatEntries dbentry = CustomCategoryServiceHandler.addCategoryEntry(catId, entry.getName(), entry.getDescr(), -1);
				m_objCatEntryIdMap.put(entry.getItemId(), dbentry.getItemId());
				if (entry.getChildEntry() != null && entry.getChildEntry().size() > 0) {
					for (CategoryEntryType child: entry.getChildEntry()) {
						AHCatEntries dbchild = CustomCategoryServiceHandler.addCategoryEntry(catId, child.getName(), child.getDescr(), dbentry.getItemId());
						m_objCatEntryIdMap.put(child.getItemId(), dbchild.getItemId());
					}
				}
			}
		}
	}
	
	public void initConfig(List<ConfigurationType> config) {
		if (config != null && config.size() > 0) {
			for (ConfigurationType cfg: config) {
				String value = cfg.getValue();
				if (value != null && value.trim().length() > 0)
					CustomPortalServiceHandler.setConfig(E_ConfigKey.valueOf(cfg.getKey()), cfg.getValue());
			}
		}
	}
	
	public void initOrganisations(List<OrganisationType> organisations) {
		if (organisations != null && organisations.size() > 0) {
			for (OrganisationType org: organisations) {
				AHOrg dborg = CustomOrgServiceHandler.addOrganisation(m_objCompanyId, m_objUserId, m_objGroupId, org.getOwner(), org.getName(), org.getHolder(), org.getDescription(), org.getLegalStatus(), org.getAddress().getStreet(), org.getAddress().getHouse(), org.getAddress().getCity(), org.getAddress().getCountry(), org.getAddress().getZip(), org.getContact().getPhone(), org.getContact().getFax(), org.getContact().getEmail(), org.getContact().getWww(), null, org.getAddress().getCoordLat(), org.getAddress().getCoordLon());
				CustomOrgServiceHandler.updateLogo(m_objCompanyId, m_objUserId, m_objGroupId, dborg.getOrgId(), org.getLogo(), org.getLogoFilename());
				m_objOrgIdMap.put(org.getOrgId(), dborg.getOrgId());
			}
		}
	}
	
	public void initOffers(List<OfferType> offers) {
		if (offers != null && offers.size() > 0) {
			for (OfferType offer: offers) {
				Long orgId = offer.getOrgId();
				orgId = m_objOrgIdMap.get(orgId);
				long[] categories = null;
				if (offer.getCategoryItem() != null && offer.getCategoryItem().size() > 0) {
					categories = new long[offer.getCategoryItem().size()];
					for (int i=0; i<offer.getCategoryItem().size();i++) {
						CategoryEntryType entry = offer.getCategoryItem().get(i);
						categories[i] = m_objCatEntryIdMap.get(entry.getItemId());
					}
				}
				if (orgId != null)
					CustomOfferServiceHandler.addOffer(-1L, offer.getTitle(), offer.getDescription(), orgId,  E_OfferType.valueOf(offer.getType()), offer.getContact().getForename(), offer.getContact().getSurname(), offer.getContact().getPhone(), offer.getContact().getEmail(), offer.getSndContact().getForename(), offer.getSndContact().getSurname(), offer.getSndContact().getPhone(), offer.getSndContact().getEmail(), offer.getAddress().getStreet(), offer.getAddress().getHouse(), offer.getAddress().getCoordLat(), offer.getAddress().getCoordLon(), offer.getAddress().getCity(), offer.getAddress().getCountry(), offer.getAddress().getZip(),
							offer.getWorkTime(), E_OfferWorkType.valueOf(offer.getWorkType()), categories, offer.getPublish(), offer.getExpires(), offer.isContactAgency());
			}
		}
	}
	
	public void initSubscriptions(List<SubscriptionType> subscriptions) {
		
	}
	
	
}
