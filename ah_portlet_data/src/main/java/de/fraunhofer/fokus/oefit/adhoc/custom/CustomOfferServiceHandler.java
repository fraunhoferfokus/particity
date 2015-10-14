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

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm;
import de.fraunhofer.fokus.oefit.particity.model.AHAddr;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;

/**
 * Custom utility methods for all tasks regarding offers
 */
public class CustomOfferServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                              .getLog(CustomOfferServiceHandler.class);

	/**
	 * Add an offer by its form object
	 *
	 * @param data the form object
	 * @return the offer model just added
	 */
	public static AHOffer addOffer(final OfferForm data) {
		AHOffer result = null;

		String countryName = data.getRegionCountry();

		try {
			final Long countryId = Long.parseLong(countryName);
			final AHCategories countryCat = AHCategoriesLocalServiceUtil
			        .getCategory(countryId);
			if (countryCat != null) {
				countryName = countryCat.getName();
			}
		} catch (final Throwable t) {
			// m_objLog.warn(t);
		}
		String workHours = data.getWorkHours();

		try {
			final Long id = Long.parseLong(workHours);
			final AHCategories cat = AHCategoriesLocalServiceUtil
			        .getCategory(id);
			if (cat != null) {
				workHours = cat.getName();
			}
		} catch (final Throwable t) {
			// m_objLog.warn(t);
		}

		final AHRegion region = AHRegionLocalServiceUtil.addRegion(
		        data.getRegionCity(), data.getRegionCountry(),
		        Integer.parseInt(data.getRegionZip()));
		m_objLog.debug("Added/got region " + region.getRegionId());
		final AHAddr address = AHAddrLocalServiceUtil.addAddress(
		        data.getAddrStreet(), data.getAddrNum(), data.getAddrLat(),
		        data.getAddrLon(), region.getRegionId());
		m_objLog.debug("Added/got addr " + address.getAddrId());
		final AHContact contact = AHContactLocalServiceUtil.addContact(
		        data.getContactForename(), data.getContactSurname(),
		        data.getContactTel(), null, data.getContactMail(), null);
		final AHContact contact2 = AHContactLocalServiceUtil.addContact(
		        data.getContactSndForename(), data.getContactSndSurname(),
		        data.getContactSndTel(), null, data.getContactSndMail(), null);
		m_objLog.debug("Added/got contact " + contact.getContactId());

		final E_OfferType type = E_OfferType.valueOf(data.getType());

		AHOrg org = null;
		try {
			org = AHOrgLocalServiceUtil.getAHOrg(data.getOrgId());
		} catch (final Throwable t) {
			m_objLog.error(t);
		}

		E_OfferWorkType workType = null;
		try {
			workType = E_OfferWorkType.valueOf(data.getWorkType());
		} catch (final Throwable t) {
		}

		String[] categories = data.getCategories();
		final String[] services = data.getServices();
		categories = (String[]) ArrayUtils.addAll(categories, services);

		final long[] l_cats = CustomServiceUtils.categoryStrToLong(categories);

		final long publishDate = CustomServiceUtils.parseZoneDateTime(
		        data.getPublishDate(),
		        data.getPublishTime());
		final long expireDate = CustomServiceUtils.parseZoneDateTime(
		        data.getExpireDate(),
		        data.getExpireTime());

		if (org != null && region != null && address != null && contact != null
		        && workType != null) {
			result = AHOfferLocalServiceUtil.addOffer(data.getOfferId(), type,
			        data.getTitle(),
			        data.getDescr(), workHours, workType,
			        publishDate, expireDate,
			        address.getAddrId(), contact.getContactId(),
			        contact2.getContactId(), data.isRequireAgencyContact(),
			        data.getOrgId(), l_cats);
		} else {
			m_objLog.error("Unexpected values while adding/updating offer "
			        + data.getOfferId());
		}

		return result;
	}

	/**
	 * Get the form object for a specific offer
	 *
	 * @param offer the offer model
	 * @return the form object
	 */
	public static OfferForm getOffer(final AHOffer offer) {
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
			result.setType(E_OfferType.findByValue(offer.getType()).toString());
			result.setWorkType(E_OfferWorkType.findByValue(offer.getWorkType())
			        .toString());
			result.setWorkHours(offer.getWorkTime());
			result.setOfferId(offer.getOfferId());
			result.setOrgId(offer.getOrgId());
			result.setRequireAgencyContact(offer.isContactAgency());

			AHAddr addr = null;
			AHContact contact = null;
			AHContact contact2 = null;
			AHRegion region = null;
			try {
				contact = AHContactLocalServiceUtil.getAHContact(offer
				        .getContactId());
			} catch (final Throwable t) {
				m_objLog.warn(t);
			}
			try {
				contact2 = AHContactLocalServiceUtil.getAHContact(offer
				        .getSndContactId());
			} catch (final Throwable t) {
				m_objLog.warn(t);
			}
			try {
				addr = AHAddrLocalServiceUtil.getAHAddr(offer.getAdressId());
			} catch (final Throwable t) {
				m_objLog.warn(t);
			}
			try {
				if (addr != null) {
					region = AHRegionLocalServiceUtil.getRegion(addr
					        .getRegionId());
				} else {
					m_objLog.warn("No region for address " + addr.getAddrId());
				}
			} catch (final Throwable t) {
				m_objLog.warn(t);
			}

			if (contact != null) {
				result.setContactForename(contact.getForename());
				result.setContactSurname(contact.getSurname());
				result.setContactMail(contact.getEmail());
				result.setContactTel(contact.getTel());
			} else {
				m_objLog.warn("No contact for offer " + offer.getOfferId());
			}
			if (contact2 != null) {
				result.setContactSndForename(contact2.getForename());
				result.setContactSndSurname(contact2.getSurname());
				result.setContactSndMail(contact2.getEmail());
				result.setContactSndTel(contact2.getTel());
			} else {
				m_objLog.warn("No 2nd contact for offer " + offer.getOfferId());
			}
			if (region != null) {
				result.setRegionCity(region.getCity());
				result.setRegionCountry(region.getCountry());
				result.setRegionZip(Integer.toString(region.getZip()));
			} else {
				m_objLog.warn("No region for offer " + offer.getOfferId());
			}
			if (addr != null) {
				result.setAddrNum(addr.getNumber());
				result.setAddrStreet(addr.getStreet());
				result.setAddrLat(addr.getCoordLat());
				result.setAddrLon(addr.getCoordLon());
			} else {
				m_objLog.warn("No address for offer " + offer.getOfferId());
			}

			List<AHCatEntries> categories = AHOfferLocalServiceUtil
			        .getCategoriesByOffer(offer.getOfferId(),
			                E_CategoryType.SEARCH);
			if (categories != null && categories.size() > 0) {
				final String[] catArr = new String[categories.size()];
				for (int i = 0; i < categories.size(); i++) {
					catArr[i] = Long.toString(categories.get(i).getItemId());
				}
				result.setCategories(catArr);
			}

			categories = AHOfferLocalServiceUtil.getCategoriesByOffer(
			        offer.getOfferId(), E_CategoryType.OFFERCATS);
			if (categories != null && categories.size() > 0) {
				final String[] catArr = new String[categories.size()];
				for (int i = 0; i < categories.size(); i++) {
					catArr[i] = Long.toString(categories.get(i).getItemId());
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
			final AHOffer offer = AHOfferLocalServiceUtil.getAHOffer(offerId);
			result = getOffer(offer);
		} catch (final PortalException e) {
			m_objLog.error(e);
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

			AHCategories cat = null;
			try {
				cat = AHCategoriesLocalServiceUtil.getCategory(countryName,
				        E_CategoryType.COUNTRIES);
				if (cat != null) {
					result.setRegionCountry(Long.toString(cat.getCatId()));
				}
			} catch (final Throwable t) {
			}
			final String offerTimeName = result.getWorkHours();
			try {
				cat = AHCategoriesLocalServiceUtil.getCategory(offerTimeName,
				        E_CategoryType.OFFERTIME);
				if (cat != null) {
					result.setWorkHours(Long.toString(cat.getCatId()));
				}
			} catch (final Throwable t) {
			}
		}

		return result;
	}

}
