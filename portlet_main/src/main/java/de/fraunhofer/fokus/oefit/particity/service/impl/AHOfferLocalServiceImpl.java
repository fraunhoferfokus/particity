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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.service.base.AHOfferLocalServiceBaseImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesFinderUtil;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferFinderUtil;

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
public class AHOfferLocalServiceImpl extends AHOfferLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalServiceUtil}
	 * to access the a h offer local service.
	 */
	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHOfferLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#addOffer(de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType, java.lang.String, java.lang.String, java.lang.String, de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType, long, long, long, long, long, boolean, long, long[])
	 */
	@Override
	public AHOffer addOffer(int type, final String title,
	        final String descr, final String workTime,
	        final Integer workType, final long publishDate,
	        final long expireDate, final long addressId, final long contactId,
	        final long contact2Id, final boolean agencyContact,
	        final long orgId, final long[] categories) {
		return this.addOffer(null, type, title, descr, workTime, workType,
		        publishDate, expireDate, addressId, contactId, contact2Id,
		        agencyContact, orgId, categories);
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#addOffer(java.lang.Long, de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType, java.lang.String, java.lang.String, java.lang.String, de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType, long, long, long, long, long, boolean, long, long[])
	 */
	@Override
	public AHOffer addOffer(final Long offerId, int type,
	        final String title, final String descr, final String workTime,
	        final Integer workType, final long publishDate,
	        final long expireDate, final long addressId, final long contactId,
	        final long contact2Id, final boolean agencyContact,
	        final long orgId, final long[] categories) {
		AHOffer result = null;

		try {
			if (offerId != null && offerId >= 0) {
				try {
					result = this.getAHOffer(offerId);
				} catch (final PortalException e) {
				}
			} else {
				result = this.createAHOffer(CounterLocalServiceUtil
				        .increment(AHOffer.class.getName()));
			}
			if (result != null) {
				final long now = CustomServiceUtils.time();

				result.setAdressId(addressId);
				result.setContactId(contactId);
				result.setExpires(expireDate);
				result.setDescription(descr);
				// result.setRegionId(regionId);
				result.setTitle(title);
				result.setType(type);
				result.setPublish(publishDate);
				result.setWorkTime(workTime);
				result.setUpdated(now);
				result.setSndContactId(contact2Id);
				result.setContactAgency(agencyContact);
				result.setSocialStatus(0);

				if (workType != null) {
					result.setWorkType(workType);
				}
				if (offerId == null || offerId < 0) {
					result.setOrgId(orgId);
					result.setCreated(now);
					result.setStatus(E_OfferStatus.NEW.getIntValue());
					if (categories != null && categories.length > 0) {
						this.getAHOfferPersistence().addAHCatEntrieses(
						        result.getPrimaryKey(), categories);
					}
				} else {
					result.setStatus(E_OfferStatus.CHANGED.getIntValue());
					// TODO - evaluate whether it is worth the computation or
					// whether a batch removeAll/addAll would be more efficient
					final List<AHCatEntries> entries = this
					        .getCategoriesByOffer(offerId, null);
					final List<Long> entryIds = new LinkedList<Long>();
					if (entries != null && entries.size() > 0) {
						for (final AHCatEntries entry : entries) {
							entryIds.add(entry.getItemId());
						}
					}
					if (categories != null && categories.length > 0) {
						for (int i = 0; i < categories.length; i++) {
							if (!entryIds.contains(categories[i])) {
								this.getAHOfferPersistence().addAHCatEntries(
								        offerId, categories[i]);
							}
						}
						if (entries != null && entries.size() > 0) {
							final List<Long> newEntries = Arrays
							        .asList(ArrayUtil.toArray(categories));
							for (final Long entryId : entryIds) {
								if (!newEntries.contains(entryId)) {
									this.getAHOfferPersistence()
									        .removeAHCatEntries(offerId,
									                entryId);
								}
							}
						}
					} else if (entries.size() > 0) {
						// remove all
						this.getAHOfferPersistence().removeAHCatEntrieses(
						        offerId, entries);
					}
				}
				// set valid, if it does not require additional input or check by mgmt and moderation is disabled
				if (!result.isContactAgency() && !CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.MODERATE_OFFERS)) {
					result.setStatus(E_OfferStatus.VALIDATED.getIntValue());
				}
				result = this.updateAHOffer(result);
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#addSocialStatus(java.lang.Long, de.fraunhofer.fokus.oefit.adhoc.custom.E_SocialMediaPlugins)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countNewOffer()
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countOfferByAddress(long)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countOfferByCategoryId(java.lang.Long[])
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countOfferByCategoryItems(java.lang.String[])
	 */
	@Override
	public Integer countOfferByCategoryItems(final String[] categoryItems) {
		Integer result = 0;
		try {
			result = AHOfferFinderUtil.countOfferByCategoryitems(
			        E_OfferStatus.VALIDATED.getIntValue(), categoryItems);
		} catch (final SystemException e) {
			result = 0;
			m_objLog.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countOfferByOfferTypes(int[])
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countOfferByTypesAndCItemsAndOrg(java.lang.String, java.lang.String, long)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countOffersForOrganization(long)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#countPublishedOffers(long)
	 */
	@Override
	public Integer countPublishedOffers(final long orgId) {
		Integer result = null;
		try {
			final long millis = CustomServiceUtils.time();
			if (orgId >= 0) {
				result = this.getAHOfferPersistence()
				        .countByorgAndstatusAndDate(orgId,
				                E_OfferStatus.VALIDATED.getIntValue(), millis,
				                millis);
			} else {
				result = this.getAHOfferPersistence().countBystatusAndDate(
				        E_OfferStatus.VALIDATED.getIntValue(), millis, millis);
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#deleteOffersByOrg(long)
	 */
	@Override
	public void deleteOffersByOrg(final long orgId) {
		try {
			this.getAHOfferPersistence().removeByorg(orgId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#findExpiredOffersForOrg(long, long, long)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getCategoriesByOffer(long, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getCategoriesByOfferAsLong(long, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getCategoriesByOfferAsString(long, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getLastOfferForOrganization(long)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getNewlyPublishedOffers(long)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOfferByCategoryId(java.lang.Long[], int, int)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOfferByCategoryItems(java.lang.String[], int, int)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOfferByOfferTypes(int[])
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOfferByOfferTypes(int[], int, int)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOfferByTypesAndCItemsAndOrg(java.lang.String, java.lang.String, long, int, int)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOffers(int, int, java.lang.String, de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOffersForOrganization(long)
	 */
	@Override
	public List<AHOffer> getOffersForOrganization(final long orgId) {
		List<AHOffer> result = new LinkedList<AHOffer>();

		try {
			result = this.getAHOfferPersistence().findByorg(orgId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getOffersForOrganization(long, int, int, java.lang.String, de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#getPublishedOffers(int, int, long)
	 */
	@Override
	public List<AHOffer> getPublishedOffers(final int start, final int end,
	        final long orgId) {
		List<AHOffer> result = null;
		try {
			final long millis = CustomServiceUtils.time();
			if (orgId >= 0) {
				result = this.getAHOfferPersistence()
				        .findByorgAndstatusAndDate(orgId,
				                E_OfferStatus.VALIDATED.getIntValue(), millis,
				                millis, start, end);
			} else {
				result = this.getAHOfferPersistence().findBystatusAndDate(
				        E_OfferStatus.VALIDATED.getIntValue(), millis, millis,
				        start, end);
				/*
				 * if (result.size() == 0) {
				 * m_objLog.info("No results! Looking for misbehaviour ... ");
				 * long currentTime = System.currentTimeMillis(); List<AHOffer>
				 * offers = getAHOffers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				 * for (AHOffer offer: offers) { if (offer.getStatus() ==
				 * E_OfferStatus.VALIDATED.getIntValue()) { long pubTime =
				 * offer.getPublish(); long expTime = offer.getExpires(); if
				 * (pubTime >= currentTime && expTime <= currentTime) {
				 * m_objLog.
				 * info("Got VALID offer "+offer.getTitle()+" with pubTime "
				 * +pubTime+", expTime "+expTime+", currenTime "+currentTime); }
				 * else m_objLog.info("Got INVALID offer "+offer.getTitle()+
				 * " with pubTime "
				 * +pubTime+", expTime "+expTime+", currenTime "+currentTime); }
				 * } }
				 */
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#setOfferStatus(long, de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus)
	 */
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

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalService#setSndContact(java.lang.Long, long, de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus)
	 */
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
}
