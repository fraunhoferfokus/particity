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
package de.fraunhofer.fokus.oefit.particity.service.impl;


// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h offer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHOfferLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil
 */
public class AHOfferLocalServiceImpl {

	/*

	@Override
	public void addSocialStatus(final Long offerId,
	        final int smBitmask) {
		try {
			final AHOffer offer = this.getAHOffer(offerId);
			if (offer != null) {
				offer.setSocialStatus(smBitmask | offer.getSocialStatus());
				this.updateAHOffer(offer);
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
	}

	@Override
	public int countNewOffer() {
		int result = 0;
		try {
			result += this.getAHOfferPersistence().countBystatus(
			        E_OfferStatus.CHANGED.getIntValue());
			result += this.getAHOfferPersistence().countBystatus(
			        E_OfferStatus.NEW.getIntValue());
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	
	@Override
	public int countOfferByAddress(final long addrId) {
		int result = -1;
		try {
			result = this.getAHOfferPersistence().countByaddress(addrId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	
	@Override
	public Integer countOfferByCategoryId(final Long[] ids) {
		Integer result = null;
		try {
			result = AHOfferFinderUtil.countOfferByCategories(
			        E_OfferStatus.VALIDATED.getIntValue(), ids);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	@Override
	public Integer countOfferByOfferTypes(final int[] types) {
		Integer result = null;
		try {
			result = AHOfferFinderUtil.countOfferByOfferTypes(
			        E_OfferStatus.VALIDATED.getIntValue(), types);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public Integer countOfferByTypesAndCItemsAndOrg(final String categoryItems,
	        final String types, final long orgId, Float lat, Float lon, Integer dist) {
		Integer result = null;
		try {
			result = AHOfferFinderUtil.countOfferByTypesAndItemsAndOrg(
			        E_OfferStatus.VALIDATED.getIntValue(), types, categoryItems, orgId, lat, lon, dist);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public int countOffersForOrganization(final long orgId) {
		int result = 0;

		try {
			result = this.getAHOfferPersistence().countByorg(orgId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}


	
	@Override
	public void deleteOffersByOrg(final long orgId) {
		try {
			this.getAHOfferPersistence().removeByorg(orgId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
	}

	
	@Override
	public List<AHOffer> findExpiredOffersForOrg(final long orgId,
	        final long startTime, final long endTime) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getExpiredOffersByOrg(orgId, startTime,
			        endTime);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public List<AHCatEntries> getCategoriesByOffer(final long offerId,
	        final Integer type) {
		List<AHCatEntries> result = new LinkedList<AHCatEntries>();

		try {
			result = AHCatEntriesFinderUtil.getCategoriesByOffer(offerId, type);
			// result = getAHOfferPersistence().getAHCatEntrieses(offerId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	
	@Override
	public Long[] getCategoriesByOfferAsLong(final long offerId,
	        final Integer type) {
		final List<AHCatEntries> categories = this.getCategoriesByOffer(
		        offerId, type);
		final Long[] result = new Long[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = categories.get(i).getItemId();
		}
		return result;
	}

	
	@Override
	public String getCategoriesByOfferAsString(final long offerId,
	        final Integer type) {
		final List<AHCatEntries> categories = this.getCategoriesByOffer(
		        offerId, type);
		final StringBuffer strCategories = new StringBuffer();
		if (categories != null && categories.size() > 0) {
			strCategories.append(categories.get(0).getName());
			for (int i = 1; i < categories.size(); i++) {
				strCategories.append(", ").append(categories.get(i).getName());
			}
		}
		return strCategories.toString();
	}

	
	@Override
	public AHOffer getLastOfferForOrganization(final long orgId) {

		AHOffer result = null;
		try {
			final List<AHOffer> offer = this.getAHOfferPersistence().findByorg(
			        orgId, 0, 1);
			if (offer != null && offer.size() > 0) {
				result = offer.get(0);
			}
		} catch (final Throwable t) {
			m_objLog.warn(t);
		}

		return result;
	}

	
	@Override
	public List<AHOffer> getNewlyPublishedOffers(final long publishStartTime) {
		List<AHOffer> result = new LinkedList<AHOffer>();

		try {
			result = AHOfferFinderUtil
			        .getNewlyPublishedOffers(publishStartTime);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}


	@Override
	public List<AHOffer> getOfferByCategoryId(final Long[] ids,
	        final int start, final int end) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getOfferByCategories(
			        E_OfferStatus.VALIDATED.getIntValue(), ids, start, end);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	@Override
	public List<AHOffer> getOfferByCategoryItems(final String[] categoryItems,
	        final int start, final int end) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getOfferByCategoryitems(
			        E_OfferStatus.VALIDATED.getIntValue(), categoryItems, start, end);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public Integer getOfferByOfferTypes(final int[] types) {
		Integer result = null;
		try {
			result = AHOfferFinderUtil.countOfferByOfferTypes(
			        E_OfferStatus.VALIDATED.getIntValue(), types);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public List<AHOffer> getOfferByOfferTypes(final int[] types,
	        final int start, final int end) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getOfferByOfferTypes(
			        E_OfferStatus.VALIDATED.getIntValue(), types, start, end);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public List<AHOffer> getOfferByTypesAndCItemsAndOrg(
	        final String categoryItems, final String types, final long orgId,
	        final int start, final int end, Float lat, Float lon, Integer dist) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getOfferByTypesAndItemsAndOrg(
			        E_OfferStatus.VALIDATED.getIntValue(), types, categoryItems, orgId,
			        start, end, lat, lon, dist);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public List<AHOffer> getOffers(final int start, final int end,
	        final String column, final String order) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getOffersWithCustomOrder(column, order,
			        start, end);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}
	
	@Override
	public List<AHOffer> getOffersForOrganization(final long orgId,
	        final int start, final int end, final String column,
	        final String order) {
		List<AHOffer> result = null;
		try {
			result = AHOfferFinderUtil.getOffersByOrgWithCustomOrder(orgId,
			        column, order, start, end);
			// m_objLog.debug("Looking up organisations sorted by "+column.getColName()+" in order "+order.toString()+" from "+start+", to "+end);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public void setOfferStatus(final long offerId, final Integer status) {
		try {
			final AHOffer offer = this.getAHOffer(offerId);
			if (offer != null && status != null) {
				offer.setStatus(status);
				this.updateAHOffer(offer);
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
	}

	
	@Override
	public void setSndContact(final Long offerId, final long contactId,
	        final Integer newStatus) {
		try {
			final AHOffer offer = this.getAHOffer(offerId);
			if (offer != null) {
				if (newStatus != null) {
					offer.setStatus(newStatus);
				}
				if (contactId >= 0) {
					offer.setSndContactId(contactId);
				}
				this.updateAHOffer(offer);
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
	}
	*/
}
