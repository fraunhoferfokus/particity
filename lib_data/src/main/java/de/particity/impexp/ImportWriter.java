package de.particity.impexp;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;
import de.particity.schemagen.impexpv100.CategoryEntryType;
import de.particity.schemagen.impexpv100.CategoryType;
import de.particity.schemagen.impexpv100.ConfigurationType;
import de.particity.schemagen.impexpv100.ImportExportRoot;
import de.particity.schemagen.impexpv100.OfferType;
import de.particity.schemagen.impexpv100.OrganisationType;
import de.particity.schemagen.impexpv100.SubscriptionType;
import de.particity.util.PersistentLog;

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

	private static Log m_objLog = LogFactoryUtil.getLog(ImportWriter.class);
	
	public static final String LOG_CATEGORIES = "ImpCat";
	public static final String LOG_CONFIG = "ImpCfg";
	public static final String LOG_ORGANISATIONS = "ImpOrg";
	public static final String LOG_OFFERS = "ImpOffer";
	public static final String LOG_SUBSCRIPTIONS = "ImpSub";
	
	//private Set<Long> m_objImportedEntries;
	
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
	
	public void write(JAXBElement data) throws ImportFailedException {
		if (data != null && data.getValue() != null && data.getValue() instanceof ImportExportRoot) {
			try {
				ImportExportRoot root = (ImportExportRoot) data.getValue();
				initCategories(root.getCategory());
				initConfig(root.getConfig());
				initOrganisations(root.getOrganisation());
				initOffers(root.getOffer());
				initSubscriptions(root.getSubscription());
			} catch (Throwable t) {
				m_objLog.warn("Data import failed",t);
				throw new ImportFailedException(ImportFailedException.IMPORT_STORE_FAIL);
			}
		} else {
			throw new ImportFailedException(ImportFailedException.IMPORT_UNMARSHAL_FAIL);
		}
	}
	
	public void initCategories(List<CategoryType> categories) {
		if (categories != null && categories.size() > 0) {
			de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_CATEGORIES);
			for (CategoryType type: categories) {
				AHCategories cat = CustomCategoryServiceHandler.addMainCategory(type.getName(), type.getDescr(), E_CategoryType.valueOf(type.getType()));
				if (cat != null) {
					log.log(cat.getName());
					initCategoryEntries(type.getEntry(),cat.getCatId());
				} else
					log.err(type.getName());
			}
		}
	}
	
	public void initCategoryEntries(List<CategoryEntryType> entries, long catId) {
		if (entries != null && entries.size() > 0) {
			de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().getLog(LOG_CATEGORIES);
			for (CategoryEntryType entry: entries) {
				if (!m_objCatEntryIdMap.containsKey(entry.getItemId())) {
					AHCatEntries dbentry = CustomCategoryServiceHandler.addCategoryEntry(catId, entry.getName(), entry.getDescr(), -1);
					if (dbentry != null) {
						log.log(entry.getName());
						m_objCatEntryIdMap.put(entry.getItemId(), dbentry.getItemId());
						if (entry.getChildEntry() != null && entry.getChildEntry().size() > 0) {
							for (CategoryEntryType child: entry.getChildEntry()) {
								if (!m_objCatEntryIdMap.containsKey(child.getItemId())) {
									AHCatEntries dbchild = CustomCategoryServiceHandler.addCategoryEntry(catId, child.getName(), child.getDescr(), dbentry.getItemId());
									if (dbchild != null) {
										m_objCatEntryIdMap.put(child.getItemId(), dbchild.getItemId());
										log.log(child.getName());
									} else
										log.err(child.getName());
								}
									
							}
						}
					} else
						log.err(entry.getName());
				}				
			}
		}
	}
	
	public void initConfig(List<ConfigurationType> config) {
		if (config != null && config.size() > 0) {
			de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_CONFIG);
			for (ConfigurationType cfg: config) {
				String value = cfg.getValue();
				if (value != null && value.trim().length() > 0) {
					log.log(cfg.getKey());
					CustomPortalServiceHandler.setConfig(E_ConfigKey.valueOf(cfg.getKey()), cfg.getValue());
				}
			}
		}
	}
	
	public void initOrganisations(List<OrganisationType> organisations) {
		if (organisations != null && organisations.size() > 0) {
			de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_ORGANISATIONS);
			for (OrganisationType org: organisations) {
				AHOrg dborg = CustomOrgServiceHandler.addOrganisation(m_objCompanyId, m_objUserId, m_objGroupId, org.getOwner(), org.getName(), org.getHolder(), org.getDescription(), org.getLegalStatus(), org.getAddress().getStreet(), org.getAddress().getHouse(), org.getAddress().getCity(), org.getAddress().getCountry(), org.getAddress().getZip(), org.getContact().getPhone(), org.getContact().getFax(), org.getContact().getEmail(), org.getContact().getWww(), null, org.getAddress().getCoordLat(), org.getAddress().getCoordLon());
				if (dborg != null) {
					log.log(org.getName());
					CustomOrgServiceHandler.updateLogo(m_objCompanyId, m_objUserId, m_objGroupId, dborg.getOrgId(), org.getLogo(), org.getLogoFilename());
					
					User lrUser = null;
					try {
						lrUser = UserLocalServiceUtil.getUserByEmailAddress(m_objCompanyId, org.getOwner());
					} catch (Throwable t) {}
					if (lrUser == null) {
						lrUser = CustomPortalServiceHandler.createPortalUser(org.getName(), org.getHolder(), org.getOwner(), m_objCompanyId, m_objGroupId, Locale.GERMAN, false);
						lrUser.setPassword(org.getLoginPassword());
						lrUser.setAgreedToTermsOfUse(true);
						lrUser.setEmailAddressVerified(true);
						try {
		                    UserLocalServiceUtil.updateUser(lrUser);
	                    } catch (Throwable e) {
		                    m_objLog.warn("Could not update user password for user "+org.getOwner()+" id "+lrUser.getUserId());
	                    }
					}
	
					m_objOrgIdMap.put(org.getOrgId(), dborg.getOrgId());
				} else {
					log.err(org.getName());
				}
			}
		}
	}
	
	public void initOffers(List<OfferType> offers) {
		if (offers != null && offers.size() > 0) {
			de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_OFFERS);
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
				if (orgId != null) {
					AHOffer dbOffer = CustomOfferServiceHandler.addOffer(-1L, offer.getTitle(), offer.getDescription(), orgId,  E_OfferType.valueOf(offer.getType()), offer.getContact().getForename(), offer.getContact().getSurname(), offer.getContact().getPhone(), offer.getContact().getEmail(), offer.getSndContact().getForename(), offer.getSndContact().getSurname(), offer.getSndContact().getPhone(), offer.getSndContact().getEmail(), offer.getAddress().getStreet(), offer.getAddress().getHouse(), offer.getAddress().getCoordLat(), offer.getAddress().getCoordLon(), offer.getAddress().getCity(), offer.getAddress().getCountry(), offer.getAddress().getZip(),
							offer.getWorkTime(), E_OfferWorkType.valueOf(offer.getWorkType()), categories, offer.getPublish(), offer.getExpires(), offer.isContactAgency());
					if (dbOffer != null) {
						log.log(dbOffer.getOfferId()+" - "+dbOffer.getTitle());
					} else {
						log.err(offer.getOfferId()+" - "+offer.getTitle());
					}
				} else {
					log.err(offer.getOfferId()+" - "+offer.getTitle()+" - org unknown");
				}
			}
		}
	}
	
	public void initSubscriptions(List<SubscriptionType> subscriptions) {
		if (subscriptions != null && subscriptions.size() > 0) {
			de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_SUBSCRIPTIONS);
			for (SubscriptionType sub: subscriptions) {
				long[] catEntries = null;
				if (sub.getCategories() != null && sub.getCategories().size() > 0) {
					 catEntries = new long[sub.getCategories().size()];
					for (int i=0; i<sub.getCategories().size(); i++) {
						catEntries[i] = m_objCatEntryIdMap.get(sub.getCategories().get(i));
					}
				} 
				AHSubscription subscr = CustomPersistanceServiceHandler.addSubscription(sub.getEmail(), catEntries, sub.getUuid(), E_SubscriptionStatus.valueOf(sub.getStatus()));
				if (subscr != null) {
					log.log(subscr.getEmail());
				} else {
					log.err(sub.getEmail());	
				}
			}
		}
	}
	
	public Map<String, String> getLog() {
		Map<String, String> result = new HashMap<String, String>();
		
		PersistentLog pl = PersistentLog.getInstance();
		
		de.particity.util.PersistentLog.Log log = pl.getLog(LOG_CATEGORIES);
		if (log != null)
			result.put(LOG_CATEGORIES,log.toString());
		log = pl.getLog(LOG_CONFIG);
		if (log != null)
			result.put(LOG_CONFIG,log.toString());
		log = pl.getLog(LOG_OFFERS);
		if (log != null)
			result.put(LOG_OFFERS,log.toString());
		log = pl.getLog(LOG_ORGANISATIONS);
		if (log != null)
			result.put(LOG_ORGANISATIONS,log.toString());
		log = pl.getLog(LOG_SUBSCRIPTIONS);
		if (log != null)
			result.put(LOG_SUBSCRIPTIONS,log.toString());
		
		return result;
	}
	
	public void cleanup() {
		PersistentLog pl = PersistentLog.getInstance();
		pl.removeLog(LOG_CATEGORIES);
		pl.removeLog(LOG_CONFIG);
		pl.removeLog(LOG_OFFERS);
		pl.removeLog(LOG_ORGANISATIONS);
		pl.removeLog(LOG_SUBSCRIPTIONS);
		
	}
	
}
