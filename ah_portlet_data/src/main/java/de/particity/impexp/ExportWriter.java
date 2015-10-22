package de.particity.impexp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
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

public class ExportWriter {

	private Log m_objLog = LogFactoryUtil.getLog(ExportWriter.class);
	
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
						catType.setType(cat.getType());
						categories.add(catType);
						writeCategoryEntries(catType.getEntry(), cat.getCatId());
					}
				}
			}
		} catch (Throwable t) {
			m_objLog.error("Error on category export",t);
		}
		
	}
	
	private void writeCategoryEntries(List<CategoryEntryType> entries, long catId) {
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
				// only support child to the third level
				for (CategoryEntryType child: type.getChildEntry()) {
					writeCategoryChildEntries(child.getChildEntry(), child.getItemId());
				}
				entries.add(type);
			}
		} catch (Throwable t) {
			m_objLog.error("Error on category entries export",t);
		}
	}
	
	private void writeCategoryChildEntries(List<CategoryEntryType> childs, long itemId) {
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
			}
		} catch (Throwable t) {
			m_objLog.error("Error on category entries export",t);
		}
	}
	
	private void writeConfig(List<ConfigurationType> config) {
		try {
			ConfigurationType cfgObj = null;
			String value = null;
			for (E_ConfigKey ckey : E_ConfigKey.values()) {
				value = AHConfigLocalServiceUtil.getConfig(ckey);
				cfgObj = new ConfigurationType();
				cfgObj.setKey(ckey.name());
				cfgObj.setValue(value);
				config.add(cfgObj);
			}
		} catch (Throwable t) {
			m_objLog.error("Error on category entries export",t);
		}
	}
	
	private void writeOrganisations(List<OrganisationType> organisations) {
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
						type.setLogo(getFileContentFromPath(data.getLogoLocation()));
						type.setLegalStatus(data.getLegalStatus());
						type.setHolder(data.getHolder());
						type.setDescription(data.getDescription());
						type.setCreated(data.getCreated());
						type.setAddress(getAddressType(data.getAddressId()));
						type.setContact(getContactType(data.getContactId()));
						organisations.add(type);
					}
				}
			}
		} catch (Throwable t) {
			m_objLog.error("Error on organisation export",t);
		}
	}
	
	private void writeOffers(List<OfferType> offers) {
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
						type.setWorkType(data.getWorkType());
						type.setWorkTime(data.getWorkTime());
						type.setUpdated(data.getUpdated());
						type.setType(E_OfferType.findByValue(data.getType()).name());
						type.setTitle(data.getTitle());
						type.setStatus(E_OfferStatus.findByValue(data.getStatus()).name());
						type.setSocialStatus(data.getSocialStatus());
						type.setPublish(data.getPublish());
						type.setOfferId(data.getOfferId());
						type.setExpires(data.getExpires());
						type.setDescription(data.getDescription());
						type.setCreated(data.getCreated());
						type.setContactAgency(data.getContactAgency());
						type.setAddress(getAddressType(data.getAdressId()));
						type.setContact(getContactType(data.getContactId()));
						type.setSndContact(getContactType(data.getSndContactId()));
						offers.add(type);
					}
				}
			}
		} catch (Throwable t) {
			m_objLog.error("Error on offer export",t);
		}
	}
	
	private void writeSubscriptions(List<SubscriptionType> subscriptions) {
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
						type.setStatus(data.getStatus());
						type.setUuid(data.getUuid());
					}
				}
			}
		} catch (Throwable t) {
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
	
	private byte[] getFileContentFromPath(String fileName) {
		m_objLog.debug("getFileContentFromPath::start("+fileName+")");
		byte[] result = null;
		
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
	                	
	                	logoFile = logoFile.getLatestFileVersion(true).getFileEntry();
						InputStream stream = DLFileEntryLocalServiceUtil.getFileAsStream(
								logoFile.getUserId(), logoFile.getFileEntryId(),
								logoFile.getVersion());
						result = IOUtils.toByteArray(stream);
						if (result != null) {
							m_objLog.debug("Retrieved file "+logoFile.getFileEntryId()+" of size "+result.length);	
						}	
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
		m_objLog.debug("getFileContentFromPath::end("+fileName+")");
		return result;
	}
}
