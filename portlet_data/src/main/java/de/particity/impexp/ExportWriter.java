package de.particity.impexp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.fraunhofer.fokus.oefit.particity.model.AHAddr;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;
import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil;
import de.particity.schemagen.impexpv100.AddressType;
import de.particity.schemagen.impexpv100.CategoryEntryType;
import de.particity.schemagen.impexpv100.CategoryType;
import de.particity.schemagen.impexpv100.ConfigurationType;
import de.particity.schemagen.impexpv100.ContactType;
import de.particity.schemagen.impexpv100.ImportExportRoot;
import de.particity.schemagen.impexpv100.OfferType;
import de.particity.schemagen.impexpv100.OrganisationType;
import de.particity.schemagen.impexpv100.SubscriptionType;
import de.particity.util.PersistentLog;

/**
 * Exporter that converts all relevant database-entries to an XML-format
 * 
 * This implementation MUST always use the latest JAXB-objects of the
 * current schema
 * 
 * @author sma
 *
 */
public class ExportWriter {

	private Log m_objLog = LogFactoryUtil.getLog(ExportWriter.class);
	
	public static final String LOG_CATEGORIES = "ExpCat";
	public static final String LOG_CONFIG = "ExpCfg";
	public static final String LOG_ORGANISATIONS = "ExpOrg";
	public static final String LOG_OFFERS = "ExpOffer";
	public static final String LOG_SUBSCRIPTIONS = "ExpSub";
	
	private Set<Long> m_objExportedEntries;
	
	private long m_numCompanyId = -1;
	
	public ExportWriter(long companyId) {
		m_numCompanyId = companyId;
		m_objExportedEntries = new HashSet<Long>();
	}
	
	public byte[] writeToBytes() {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		writeToStream(bout);
		return bout.toByteArray();
	}
	
	public void writeToStream(OutputStream out) {
		try {
			ImportExportRoot root = write();
			JAXBContext ctx = JAXBContext.newInstance("de.particity.schemagen.impexpv100");
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(root, out);
		} catch (Throwable t) {
			m_objLog.error("Error marshalling",t);
		}
	}
	
	public ImportExportRoot write() {
		ImportExportRoot root = new ImportExportRoot();
		root.setVersion(E_SchemaVersion.getLatest(true).name());
		
		writeCategories(root.getCategory());
		writeConfig(root.getConfig());
		writeOrganisations(root.getOrganisation());
		writeOffers(root.getOffer());
		writeSubscriptions(root.getSubscription());
		
		return root;
	}
	
	private void writeCategories(List<CategoryType> categories) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_CATEGORIES);
		try {
			int size = AHCategoriesLocalServiceUtil.getAHCategoriesesCount();
			List<AHCategories> cats = null;
			AHCategories cat = null;
			CategoryType catType = null;
			for (int i = 0; i<size;i+=10) {
				cats = AHCategoriesLocalServiceUtil.getAHCategorieses(i, i+10);
				if (cats != null) {
					for (int j=0; j<cats.size(); j++) {
						cat = cats.get(j);
						catType = new CategoryType();
						catType.setCatId(cat.getCatId());
						catType.setDescr(cat.getDescr());
						catType.setName(cat.getName());
						catType.setType(E_CategoryType.findByValue(cat.getType()).name());
						categories.add(catType);
						log.log(cat.getName());
						writeCategoryEntries(catType.getEntry(), cat.getCatId());
					}
				}
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on category export",t);
		}
		
	}
	
	private void writeCategoryEntries(List<CategoryEntryType> entries, long catId) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().getLog(LOG_CATEGORIES);
		try {
			List<AHCatEntries> list = AHCatEntriesLocalServiceUtil.getCategoryEntries(catId);
			AHCatEntries data = null;
			CategoryEntryType type = null;
			for (int i=0; i<list.size();i++) {
				data = list.get(i);
				type = new CategoryEntryType();
				type.setCatId(data.getCatId());
				type.setItemId(data.getItemId());
				type.setName(data.getName());
				type.setDescr(data.getDescr());
				writeCategoryChildEntries(type.getChildEntry(),data.getItemId());
				if (!m_objExportedEntries.contains(data.getItemId())) {
					log.log(data.getName());
					m_objExportedEntries.add(data.getItemId());
				}
				// only support child to the third level
				for (CategoryEntryType child: type.getChildEntry()) {
					writeCategoryChildEntries(child.getChildEntry(), child.getItemId());
				}
				entries.add(type);
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on category entries export",t);
		}
	}
	
	private void writeCategoryChildEntries(List<CategoryEntryType> childs, long itemId) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().getLog(LOG_CATEGORIES);
		try {
			List<AHCatEntries> list = AHCatEntriesLocalServiceUtil.getChildEntriesById(itemId);
			AHCatEntries data = null;
			CategoryEntryType type = null;
			for (int i=0; i<list.size();i++) {
				data = list.get(i);
				type = new CategoryEntryType();
				type.setCatId(data.getCatId());
				type.setItemId(data.getItemId());
				type.setName(data.getName());
				type.setDescr(data.getDescr());
				childs.add(type);
				if (!m_objExportedEntries.contains(data.getItemId())) {
					log.log(data.getName());
					m_objExportedEntries.add(data.getItemId());
				}
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on category entries export",t);
		}
	}
	
	private void writeConfig(List<ConfigurationType> config) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_CONFIG);
		try {
			ConfigurationType cfgObj = null;
			String value = null;
			for (E_ConfigKey ckey : E_ConfigKey.values()) {
				value = AHConfigLocalServiceUtil.getConfig(ckey.name(), ckey.getDefaultValue());
				cfgObj = new ConfigurationType();
				cfgObj.setKey(ckey.name());
				cfgObj.setValue(value);
				config.add(cfgObj);
				log.log(ckey.name());
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on category entries export",t);
		}
	}
	
	private void writeOrganisations(List<OrganisationType> organisations) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_ORGANISATIONS);
		try {
			int size = AHOrgLocalServiceUtil.getAHOrgsCount();
			List<AHOrg> list = null;
			AHOrg data = null;
			OrganisationType type = null;
			for (int i = 0; i<size;i+=10) {
				list = AHOrgLocalServiceUtil.getAHOrgs(i, i+10);
				if (list != null) {
					for (int j=0; j<list.size(); j++) {
						data= list.get(j);
						type = new OrganisationType();
						type.setUserlist(data.getUserlist());
						type.setUpdated(data.getUpdated());
						type.setStatus(E_OrgStatus.findByValue(data.getStatus()).name());
						type.setOwner(data.getOwner());
						type.setOrgId(data.getOrgId());
						type.setName(data.getName());
						DLFileEntry logoFile = getFileFromPath(data.getLogoLocation());
						type.setLogo(getFileContent(logoFile));
						if (logoFile != null)
							type.setLogoFilename(logoFile.getName());
						type.setLegalStatus(data.getLegalStatus());
						type.setHolder(data.getHolder());
						type.setDescription(data.getDescription());
						type.setCreated(data.getCreated());
						type.setAddress(getAddressType(data.getAddressId()));
						type.setContact(getContactType(data.getContactId()));
						User lrUser = UserLocalServiceUtil.getUserByEmailAddress(m_numCompanyId, data.getOwner());
						if (lrUser != null) {
							type.setLoginPassword(lrUser.getPassword());
						}
						organisations.add(type);
						log.log(data.getName());
					}
				}
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on organisation export",t);
		}
	}
	
	private void writeOffers(List<OfferType> offers) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_OFFERS);
		try {
			int size = AHOfferLocalServiceUtil.getAHOffersCount();
			List<AHOffer> list = null;
			AHOffer data = null;
			OfferType type = null;
			for (int i = 0; i<size;i+=10) {
				list = AHOfferLocalServiceUtil.getAHOffers(i, i+10);
				if (list != null) {
					for (int j=0; j<list.size(); j++) {
						data= list.get(j);
						type = new OfferType();
						type.setWorkType(E_OfferWorkType.findByValue(data.getWorkType()).name());
						type.setWorkTime(data.getWorkTime());
						type.setUpdated(data.getUpdated());
						type.setType(E_OfferType.findByValue(data.getType()).name());
						type.setTitle(data.getTitle());
						type.setStatus(E_OfferStatus.findByValue(data.getStatus()).name());
						type.setSocialStatus(data.getSocialStatus());
						type.setPublish(data.getPublish());
						type.setOfferId(data.getOfferId());
						type.setOrgId(data.getOrgId());
						type.setExpires(data.getExpires());
						type.setDescription(data.getDescription());
						type.setCreated(data.getCreated());
						type.setContactAgency(data.getContactAgency());
						type.setAddress(getAddressType(data.getAdressId()));
						type.setContact(getContactType(data.getContactId()));
						type.setSndContact(getContactType(data.getSndContactId()));
						List<AHCatEntries> entries = AHOfferLocalServiceUtil.getCategoriesByOffer(data.getOfferId(), E_CategoryType.SEARCH.getIntValue());
						List<AHCatEntries> services = AHOfferLocalServiceUtil.getCategoriesByOffer(data.getOfferId(), E_CategoryType.OFFERCATS.getIntValue());
						List<AHCatEntries> itemlist = entries;
						if (itemlist == null || itemlist.size() == 0)
							itemlist = services;
						else if (services != null && services.size() > 0)
							itemlist.addAll(services);
						if (itemlist != null && itemlist.size() > 0) {
							List<CategoryEntryType> cats = type.getCategoryItem();
							for (AHCatEntries entry: itemlist) {
								CategoryEntryType cet = new CategoryEntryType();
								cet.setItemId(entry.getItemId());
								cats.add(cet);
							} 
						}
						offers.add(type);
						log.log(data.getOfferId()+" - "+data.getTitle());
					}
				}
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on offer export",t);
		}
	}
	
	private void writeSubscriptions(List<SubscriptionType> subscriptions) {
		de.particity.util.PersistentLog.Log log = PersistentLog.getInstance().addLog(LOG_SUBSCRIPTIONS);
		try {
			int size = AHSubscriptionLocalServiceUtil.getAHSubscriptionsCount();
			List<AHSubscription> list = null;
			AHSubscription data = null;
			SubscriptionType type = null;
			for (int i = 0; i<size;i+=10) {
				list = AHSubscriptionLocalServiceUtil.getAHSubscriptions(i, i+10);
				if (list != null) {
					for (int j=0; j<list.size(); j++) {
						data= list.get(j);
						type = new SubscriptionType();
						type.setCreated(data.getCreated());
						type.setEmail(data.getEmail());
						type.setStatus(E_SubscriptionStatus.findByValue(data.getStatus()).name());
						type.setUuid(data.getUuid());
						List<AHCatEntries> entries = AHSubscriptionLocalServiceUtil.getCategoriesBySubscription(data.getSubId());
						if (entries != null && entries.size() > 0) {
							List<CategoryEntryType> cats = type.getCategories();
							for (AHCatEntries entry: entries) {
								CategoryEntryType cet = new CategoryEntryType();
								cet.setItemId(entry.getItemId());
								cats.add(cet);
							}
						}
						subscriptions.add(type);
						log.log(data.getEmail());
					}
				}
			}
		} catch (Throwable t) {
			log.err(t.getMessage());
			m_objLog.error("Error on offer export",t);
		}
	}
	
	private ContactType getContactType(long contactId) {
		ContactType contactType = null;
		AHContact contact = null;
		try {
			contact = AHContactLocalServiceUtil.getAHContact(contactId);
		} catch (Throwable t) {}
		if (contact != null) {
			contactType = new ContactType();
			contactType.setEmail(contact.getEmail());
			contactType.setFax(contact.getFax());
			contactType.setForename(contact.getForename());
			contactType.setMobile(contact.getMobile());
			contactType.setPhone(contact.getTel());
			contactType.setSurname(contact.getSurname());
			contactType.setWww(contact.getWww());	
		}
		return contactType;
	}
	
	private AddressType getAddressType(long addrId) {
		AddressType addrType = null;
		AHAddr addr = null;
		AHRegion regio = null;
		try {
			addr = AHAddrLocalServiceUtil.getAHAddr(addrId);
			if (addr != null)
				regio = AHRegionLocalServiceUtil.getRegion(addr.getRegionId());
		} catch (Throwable t) {}
		if (addr != null) {
			addrType = new AddressType();
			addrType.setStreet(addr.getStreet());
			addrType.setHouse(addr.getNumber());
			addrType.setCoordLat(addr.getCoordLat());
			addrType.setCoordLon(addr.getCoordLon());
			if (regio != null) {
				addrType.setCity(regio.getCity());
				addrType.setCountry(regio.getCountry());
				addrType.setZip(regio.getZip());
			}
		}
		return addrType;
	}
	
	private DLFileEntry getFileFromPath(String fileName) {
		m_objLog.debug("getFileFromPath::start("+fileName+")");
		DLFileEntry result = null;
		
		if (fileName != null) {
			fileName = fileName.replaceAll("//", "/");
			String[] split = fileName.trim().split("/");
			Long folderId = null;
			Long groupId = null;
			String title = null;
			if (split.length > 2) {
				try {
					groupId = Long.parseLong(split[2]);
				} catch (Throwable t) {}
				if (split.length > 3) {
					try {
						folderId = Long.parseLong(split[3]);
					} catch (Throwable t) {}
					if (split.length > 4) {
						try {
							title = HtmlUtil.unescape(HttpUtil.decodeURL(split[4]));
						} catch (Throwable t) {}
					}
				}
			}
			m_objLog.debug("Looking up file "+title+" in folder "+folderId+" for group "+groupId);
			if (title != null && folderId != null && groupId != null) {
				try {
	                List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folderId);
	                DLFileEntry logoFile = null;
	                for (DLFileEntry file: files) {
	                	if (file.getTitle().equals(title)) {
	                		logoFile = file;
	                		break;
	                	}
	                }
	                if (logoFile != null) {
	                	
	                	result = logoFile.getLatestFileVersion(true).getFileEntry();
							
	                } else {
	                	m_objLog.debug("Did not find logo file with name "+title+" in folder "+folderId+" for group "+groupId);
	                }
                } catch (Throwable t) {
	                m_objLog.error("Error retrieving logo-file "+title,t);
                }
				
			} else {
				m_objLog.warn("Did not find logo file with name "+title+" in folder "+folderId+" for group "+groupId+" using base filename "+fileName);
			}
		}
		m_objLog.debug("getFileFromPath::end("+fileName+")");
		return result;
	}
	
	private byte[] getFileContent(DLFileEntry dfile) {
		m_objLog.debug("getFileContent::start()");
		byte[] result = null;
		
		if (dfile != null) {
			try {
				InputStream stream = DLFileEntryLocalServiceUtil.getFileAsStream(
						dfile.getUserId(), dfile.getFileEntryId(),
						dfile.getVersion());
				result = IOUtils.toByteArray(stream);
			} catch (Throwable t) {
				m_objLog.error("Error retrieving file contents",t);
			}
		}
		m_objLog.debug("getFileContent::end()");
		return result;
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
