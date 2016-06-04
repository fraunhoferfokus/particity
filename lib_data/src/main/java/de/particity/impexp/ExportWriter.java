package de.particity.impexp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_AddressModel;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_CategoryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.I_RegionModel;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.boundary.I_AddressControler;
import de.particity.model.boundary.I_CategoryController;
import de.particity.model.boundary.I_CategoryEntryController;
import de.particity.model.boundary.I_ConfigController;
import de.particity.model.boundary.I_ContactController;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.boundary.I_OrganizationController;
import de.particity.model.boundary.I_RegionController;
import de.particity.model.boundary.I_SubscriptionController;
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
	
	@Inject
	public I_ConfigController cfgCtrl;
	
	@Inject 
	public I_CategoryController catCtrl;
	
	@Inject
	public I_CategoryEntryController catEntryCtrl;
	
	@Inject 
	public I_OfferController offerCtrl;
	
	@Inject
	public I_RegionController regionCtrl;
	
	@Inject
	public I_AddressControler addressCtrl;
	
	@Inject
	public I_ContactController contactCtrl;
	
	@Inject
	public I_OrganizationController orgCtrl;
	
	@Inject
	public I_SubscriptionController subCtr;
	
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
			long size = catCtrl.count();
			List<I_CategoryModel> cats = null;
			I_CategoryModel cat = null;
			CategoryType catType = null;
			for (int i = 0; i<size;i+=10) {
				cats = catCtrl.get(i, i+10);
				if (cats != null) {
					for (int j=0; j<cats.size(); j++) {
						cat = cats.get(j);
						catType = new CategoryType();
						catType.setCatId(cat.getId());
						catType.setDescr(cat.getDescription());
						catType.setName(cat.getName());
						catType.setType(cat.getType().name());
						categories.add(catType);
						log.log(cat.getName());
						writeCategoryEntries(catType.getEntry(), cat.getId());
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
			List<I_CategoryEntryModel> list = catEntryCtrl.getByCategory(catId);
			I_CategoryEntryModel data = null;
			CategoryEntryType type = null;
			for (int i=0; i<list.size();i++) {
				data = list.get(i);
				type = new CategoryEntryType();
				type.setCatId(data.getCategory().getId());
				type.setItemId(data.getId());
				type.setName(data.getName());
				type.setDescr(data.getDescription());
				writeCategoryChildEntries(type.getChildEntry(),data.getId());
				if (!m_objExportedEntries.contains(data.getId())) {
					log.log(data.getName());
					m_objExportedEntries.add(data.getId());
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
			List<I_CategoryEntryModel> list = catEntryCtrl.getChildEntriesById(itemId);
			I_CategoryEntryModel data = null;
			CategoryEntryType type = null;
			for (int i=0; i<list.size();i++) {
				data = list.get(i);
				type = new CategoryEntryType();
				type.setCatId(data.getCategory().getId());
				type.setItemId(data.getId());
				type.setName(data.getName());
				type.setDescr(data.getDescription());
				childs.add(type);
				if (!m_objExportedEntries.contains(data.getId())) {
					log.log(data.getName());
					m_objExportedEntries.add(data.getId());
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
				value = cfgCtrl.get(ckey).getValue();
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
			long size = orgCtrl.count();
			List<I_OrganizationModel> list = null;
			I_OrganizationModel data = null;
			OrganisationType type = null;
			for (int i = 0; i<size;i+=10) {
				list = orgCtrl.get(i, i+10);
				if (list != null) {
					for (int j=0; j<list.size(); j++) {
						data= list.get(j);
						type = new OrganisationType();
						type.setUserlist(data.getUserList());
						type.setUpdated(CustomServiceUtils.localDateTimeToMillis(data.getUpdated()));
						type.setStatus(data.getStatus().name());
						type.setOwner(data.getOwner());
						type.setOrgId(data.getId());
						type.setName(data.getName());
						DLFileEntry logoFile = getFileFromPath(data.getLogoLocation());
						type.setLogo(getFileContent(logoFile));
						if (logoFile != null)
							type.setLogoFilename(logoFile.getName());
						type.setLegalStatus(data.getLegalStatus());
						type.setHolder(data.getHolder());
						type.setDescription(data.getDescription());
						type.setCreated(CustomServiceUtils.localDateTimeToMillis(data.getCreated()));
						type.setAddress(getAddressType(data.getAddress().getId()));
						type.setContact(getContactType(data.getContact().getId()));
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
			long size = offerCtrl.count();
			List<I_OfferModel> list = null;
			I_OfferModel data = null;
			OfferType type = null;
			for (int i = 0; i<size;i+=10) {
				list = offerCtrl.get(i, i+10);
				if (list != null) {
					for (int j=0; j<list.size(); j++) {
						data= list.get(j);
						type = new OfferType();
						type.setWorkType(data.getWorkType().name());
						type.setWorkTime(data.getWorkTime());
						type.setUpdated(CustomServiceUtils.localDateTimeToMillis(data.getUpdated()));
						type.setType(data.getType().name());
						type.setTitle(data.getTitle());
						type.setStatus(data.getStatus().name());
						type.setSocialStatus(data.getSocialStatus());
						type.setPublish(CustomServiceUtils.localDateTimeToMillis(data.getPublish()));
						type.setOfferId(data.getId());
						type.setOrgId(data.getOrg().getId());
						type.setExpires(CustomServiceUtils.localDateTimeToMillis(data.getExpires()));
						type.setDescription(data.getDescription());
						type.setCreated(CustomServiceUtils.localDateTimeToMillis(data.getCreated()));
						type.setContactAgency(data.isContactAgency());
						type.setAddress(getAddressType(data.getAddress().getId()));
						type.setContact(getContactType(data.getContact().getId()));
						type.setSndContact(getContactType(data.getSndContact().getId()));
						List<I_CategoryEntryModel> entries = offerCtrl.getCategoriesByOffer(data.getId(), E_CategoryType.SEARCH);
						List<I_CategoryEntryModel> services = offerCtrl.getCategoriesByOffer(data.getId(), E_CategoryType.OFFERCATS);
						List<I_CategoryEntryModel> itemlist = entries;
						if (itemlist == null || itemlist.size() == 0)
							itemlist = services;
						else if (services != null && services.size() > 0)
							itemlist.addAll(services);
						if (itemlist != null && itemlist.size() > 0) {
							List<CategoryEntryType> cats = type.getCategoryItem();
							for (I_CategoryEntryModel entry: itemlist) {
								CategoryEntryType cet = new CategoryEntryType();
								cet.setItemId(entry.getId());
								cats.add(cet);
							} 
						}
						offers.add(type);
						log.log(data.getId()+" - "+data.getTitle());
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
			long size = subCtr.count();
			List<I_SubscriptionModel> list = null;
			I_SubscriptionModel data = null;
			SubscriptionType type = null;
			for (int i = 0; i<size;i+=10) {
				list = subCtr.get(i, i+10);
				if (list != null) {
					for (int j=0; j<list.size(); j++) {
						data= list.get(j);
						type = new SubscriptionType();
						type.setCreated(CustomServiceUtils.localDateTimeToMillis(data.getCreated()));
						type.setEmail(data.getEmail());
						type.setStatus(data.getStatus().name());
						type.setUuid(data.getUuid());
						List<I_CategoryEntryModel> entries = data.getCategoryEntries();
						if (entries != null && entries.size() > 0) {
							List<CategoryEntryType> cats = type.getCategories();
							for (I_CategoryEntryModel entry: entries) {
								CategoryEntryType cet = new CategoryEntryType();
								cet.setItemId(entry.getId());
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
		I_ContactModel contact = null;
		try {
			contact = contactCtrl.get(contactId);
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
		I_AddressModel addr = null;
		I_RegionModel regio = null;
		try {
			addr = addressCtrl.get(addrId);
			if (addr != null)
				regio = addr.getRegion();
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
