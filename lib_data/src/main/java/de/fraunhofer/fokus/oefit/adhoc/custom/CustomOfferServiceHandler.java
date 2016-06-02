/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.adhoc.custom;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm;
import de.particity.model.I_AddressModel;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_CategoryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.I_RegionModel;
import de.particity.model.boundary.I_AddressControler;
import de.particity.model.boundary.I_CategoryController;
import de.particity.model.boundary.I_ContactController;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.boundary.I_OrganizationController;
import de.particity.model.boundary.I_RegionController;

/**
 * Custom utility methods for all tasks regarding offers
 */
public class CustomOfferServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                              .getLog(CustomOfferServiceHandler.class);

	@Inject 
	public static I_CategoryController catCtrl;
	
	@Inject 
	public static I_OfferController offerCtrl;
	
	@Inject
	public static I_RegionController regionCtrl;
	
	@Inject
	public static I_AddressControler addressCtrl;
	
	@Inject
	public static I_ContactController contactCtrl;
	
	@Inject
	public static I_OrganizationController orgCtrl;
	
	/**
	 * Add an offer by its form object
	 *
	 * @param data the form object
	 * @return the offer model just added
	 */
	public static I_OfferModel addOffer(final OfferForm data) {

		final E_OfferType type = E_OfferType.valueOf(data.getType());

		E_OfferWorkType workType = null;
		try {
			workType = E_OfferWorkType.valueOf(data.getWorkType());
		} catch (final Throwable t) {
		}

		String[] categories = data.getCategories();
		final String[] services = data.getServices();
		//categories = (String[]) ArrayUtils.addAll(categories, services);
		List<String> cats = Arrays.asList(categories);
		cats.addAll(Arrays.asList(services));
		categories = cats.toArray(new String[0]);
		
		final long[] l_cats = CustomServiceUtils.categoryStrToLong(categories);

		final long publishDate = CustomServiceUtils.parseZoneDateTime(
		        data.getPublishDate(),
		        data.getPublishTime());
		final long expireDate = CustomServiceUtils.parseZoneDateTime(
		        data.getExpireDate(),
		        data.getExpireTime());

		String zip = "0";
		try {
			zip = data.getRegionZip();
		} catch (Throwable t) {}
		
		return addOffer(data.getOfferId(), data.getTitle(), data.getDescr(), data.getOrgId(), type, data.getContactForename(), data.getContactSurname(), data.getContactTel(), data.getContactMail(), data.getContactSndForename(), data.getContactSndSurname(), data.getContactSndTel(), data.getContactSndMail(), data.getAddrStreet(), data.getAddrNum(), data.getAddrLat(), data.getAddrLon(), data.getRegionCity(), data.getRegionCountry(), zip, data.getWorkHours(), workType, l_cats, publishDate, expireDate, data.isRequireAgencyContact());
	}
	
	public static I_OfferModel addOffer(long offerId, String title, String descr, long orgId, E_OfferType offerType, String contact1Fn, String contact1Sn, String contact1Phone, String contact1Mail, String contact2Fn, String contact2Sn, String contact2Phone, String contact2Mail, String street, String streetNr, float lat, float lon, String city, String country, String zip, String workHours, E_OfferWorkType workType, long[] categories, long publishDateTime, long expireDateTime, boolean agencyContact) {
		I_OfferModel result = null;

		try {
			final Long countryId = Long.parseLong(country);
			final I_CategoryModel countryCat = catCtrl.get(countryId);
			if (countryCat != null) {
				country = countryCat.getName();
			}
		} catch (final Throwable t) {
			// m_objLog.warn(t);
		}

		try {
			final Long id = Long.parseLong(workHours);
			final I_CategoryModel cat = catCtrl.get(id);
			if (cat != null) {
				workHours = cat.getName();
			}
		} catch (final Throwable t) {
			// m_objLog.warn(t);
		}
		
		final I_RegionModel region = regionCtrl.add(city, country, zip);
		m_objLog.debug("Added/got region " + region.getId());
		final I_AddressModel address = addressCtrl.add(street, streetNr, lat, lon, region);
		m_objLog.debug("Added/got addr " + address.getId());
		final I_ContactModel contact = contactCtrl.add(contact1Fn, contact1Sn, contact1Phone, null, contact1Mail, null);
		final I_ContactModel contact2 = contactCtrl.add(contact2Fn, contact2Sn, contact2Phone, null, contact2Mail, null);
		m_objLog.debug("Added/got contact " + contact.getId());

		I_OrganizationModel org = null;
		try {
			org = orgCtrl.get(orgId);
		} catch (final Throwable t) {
			m_objLog.error(t);
		}


		if (org != null && region != null && address != null && contact != null
		        && workType != null) {
			result = offerCtrl.add(offerId, offerType.getIntValue(),
			        title, descr, workHours, workType.getIntValue() ,publishDateTime, expireDateTime,
			        address, contact,
			        contact2, agencyContact,
			        orgId, categories);
		} else {
			m_objLog.error("Unexpected values while adding/updating offer "
			        + offerId);
		}

		return result;
	}

	/**
	 * Get the form object for a specific offer
	 *
	 * @param offer the offer model
	 * @return the form object
	 */
	public static OfferForm getOffer(final I_OfferModel offer) {
		OfferForm result = null;

		if (offer != null) {
			result = new OfferForm();
			result.clear();

			result.setTitle(offer.getTitle());
			result.setDescr(offer.getDescription());
			result.setExpireDate(CustomServiceUtils.formatZoneDate(offer
			        .getExpires()));
			result.setExpireTime(CustomServiceUtils.formatZoneTime(offer
			        .getExpires()));
			result.setPublishDate(CustomServiceUtils.formatZoneDate(offer
			        .getPublish()));
			result.setPublishTime(CustomServiceUtils.formatZoneTime(offer
			        .getPublish()));
			result.setType(offer.getType().toString());
			result.setWorkType(offer.getWorkType()
			        .toString());
			result.setWorkHours(offer.getWorkTime());
			result.setOfferId(offer.getId());
			result.setOrgId(offer.getOrg().getId());
			result.setRequireAgencyContact(offer.isContactAgency());

			I_AddressModel addr = offer.getAddress();
			I_ContactModel contact = offer.getContact();
			I_ContactModel contact2 = offer.getSndContact();
			I_RegionModel region = addr.getRegion();
			
			if (contact != null) {
				result.setContactForename(contact.getForename());
				result.setContactSurname(contact.getSurname());
				result.setContactMail(contact.getEmail());
				result.setContactTel(contact.getTel());
			} else {
				m_objLog.warn("No contact for offer " + offer.getId());
			}
			if (contact2 != null) {
				result.setContactSndForename(contact2.getForename());
				result.setContactSndSurname(contact2.getSurname());
				result.setContactSndMail(contact2.getEmail());
				result.setContactSndTel(contact2.getTel());
			} else {
				m_objLog.warn("No 2nd contact for offer " + offer.getId());
			}
			if (region != null) {
				result.setRegionCity(region.getCity());
				result.setRegionCountry(region.getCountry());
				result.setRegionZip(region.getZip());
			} else {
				m_objLog.warn("No region for offer " + offer.getId());
			}
			if (addr != null) {
				result.setAddrNum(addr.getNumber());
				result.setAddrStreet(addr.getStreet());
				result.setAddrLat(addr.getCoordLat());
				result.setAddrLon(addr.getCoordLon());
			} else {
				m_objLog.warn("No address for offer " + offer.getId());
			}

			List<I_CategoryEntryModel> categories = offerCtrl.getCategoriesByOffer(offer.getId(), E_CategoryType.SEARCH);
			if (categories != null && categories.size() > 0) {
				final String[] catArr = new String[categories.size()];
				for (int i = 0; i < categories.size(); i++) {
					catArr[i] = Long.toString(categories.get(i).getId());
				}
				result.setCategories(catArr);
			}

			categories = offerCtrl.getCategoriesByOffer(
			        offer.getId(), E_CategoryType.OFFERCATS);
			if (categories != null && categories.size() > 0) {
				final String[] catArr = new String[categories.size()];
				for (int i = 0; i < categories.size(); i++) {
					catArr[i] = Long.toString(categories.get(i).getId());
				}
				result.setServices(catArr);
			}
		}

		return result;
	}

	/**
	 * Get a form object for a specific offer ID
	 *
	 * @param offerId the offer ID
	 * @return the form object
	 */
	public static OfferForm getOffer(final long offerId) {
		OfferForm result = null;
		try {
			final I_OfferModel offer = offerCtrl.get(offerId);
			result = getOffer(offer);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	/**
	 * Get a form object for a specific offer ID for editing purposes. 
	 * 
	 * This method should be used only for editing form-data in the view, as it
	 * replaces some human-readable fields (i.e. data-lists) with their numeric
	 * values. This workaround is necessary to allow cleartext data-list fields
	 * to be stored in the database instead of numeric values that might point
	 * to wrong references in case the data-lists are modified without updating
	 * the references.
	 *
	 * @param offerId the offer ID
	 * @return the form object
	 */
	public static OfferForm getOfferForEdit(final long offerId) {
		final OfferForm result = getOffer(offerId);

		if (result != null) {
			final String countryName = result.getRegionCountry();

			I_CategoryModel cat = null;
			try {
				cat = catCtrl.get(countryName,E_CategoryType.COUNTRIES);
				if (cat != null) {
					result.setRegionCountry(Long.toString(cat.getId()));
				}
			} catch (final Throwable t) {
			}
			final String offerTimeName = result.getWorkHours();
			try {
				cat = catCtrl.get(offerTimeName,
				        E_CategoryType.OFFERTIME);
				if (cat != null) {
					result.setWorkHours(Long.toString(cat.getId()));
				}
			} catch (final Throwable t) {
			}
		}

		return result;
	}

}
