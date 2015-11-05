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
package de.fraunhofer.fokus.oefit.particity.scheduler;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.particity.model.AHAddr;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;

/**
 * Scheduler for daily tasks
 */
public class DailyScheduler implements MessageListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(DailyScheduler.class);

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(final Message message) throws MessageListenerException {
		try {

			// removeOrganisationsWithoutUsers();
			// removeOffersWithoutOrganisations();
			// removeOrphanedAddresses();
			// removeOrphanedRegions();
			// removeOffersWithoutAddresses();

			m_objLog.info("Daily scheduler update done.");
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Could not exec daily schedule due to: " + t.getMessage(),
			        t);
		}
	}

	/**
	 * Removes the offers without addresses.
	 */
	public void removeOffersWithoutAddresses() {
		try {
			final int offerSize = AHOfferLocalServiceUtil.getAHOffersCount();
			if (offerSize > 0) {
				List<AHOffer> offers;
				AHAddr addr;
				for (int i = 0; i < offerSize; i += 5) {
					offers = AHOfferLocalServiceUtil.getAHOffers(i, i + 5);
					for (final AHOffer offer : offers) {
						try {
							addr = AHAddrLocalServiceUtil.getAHAddr(offer
							        .getAdressId());
						} catch (final Throwable t) {
							addr = null;
						}
						if (addr == null) {
							AHOfferLocalServiceUtil.deleteAHOffer(offer
							        .getOfferId());
							m_objLog.warn("Removing offer "
							        + offer.getOfferId() + "/"
							        + offer.getTitle()
							        + " due to missing address "
							        + offer.getAdressId());
						}
					}
				}
			}
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Check for orphaned offers failed due to " + t.getMessage(),
			        t);
		}
	}

	/**
	 * Removes the offers without organisations.
	 */
	public void removeOffersWithoutOrganisations() {
		try {
			final int offerSize = AHOfferLocalServiceUtil.getAHOffersCount();
			if (offerSize > 0) {
				List<AHOffer> offers;
				AHOrg org;
				for (int i = 0; i < offerSize; i += 5) {
					offers = AHOfferLocalServiceUtil.getAHOffers(i, i + 5);
					for (final AHOffer offer : offers) {
						final long orgId = offer.getOrgId();
						try {
							org = AHOrgLocalServiceUtil.getAHOrg(orgId);
						} catch (final Throwable t) {
							org = null;
						}
						if (org == null) {
							AHOfferLocalServiceUtil.deleteAHOffer(offer
							        .getOfferId());
							m_objLog.warn("Removing offer "
							        + offer.getOfferId() + "/"
							        + offer.getTitle()
							        + " due to missing organisation "
							        + offer.getOrgId());
						}
					}
				}
			}
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Check for orphaned offers failed due to " + t.getMessage(),
			        t);
		}
	}

	/**
	 * Removes the organisations without users.
	 */
	public void removeOrganisationsWithoutUsers() {
		try {
			final long companyId = PortalUtil.getDefaultCompanyId();
			final int orgSize = AHOrgLocalServiceUtil.getAHOrgsCount();
			if (orgSize > 0) {
				List<AHOrg> orgs;
				for (int i = 0; i < orgSize; i += 5) {
					orgs = AHOrgLocalServiceUtil.getAHOrgs(i, i + 5);
					for (final AHOrg org : orgs) {
						final String mail = org.getOwner();
						User user = null;
						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(
							        companyId, mail);
						} catch (final Throwable t) {
						}
						if (user == null) {
							m_objLog.warn("Removing organisation "
							        + org.getOrgId() + "/" + org.getName()
							        + " due to missing user.");
							AHOrgLocalServiceUtil.deleteOrganisation(org
							        .getOrgId());
						}
					}
				}
			}
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Check for inactive organisations failed due to "
			                + t.getMessage(), t);
		}
	}

	/**
	 * Removes the orphaned addresses.
	 */
	public void removeOrphanedAddresses() {
		try {
			final int addrSize = AHAddrLocalServiceUtil.getAHAddrsCount();
			if (addrSize > 0) {
				List<AHAddr> addresses;
				for (int i = 0; i < addrSize; i += 5) {
					addresses = AHAddrLocalServiceUtil.getAHAddrs(i, i + 5);
					for (final AHAddr addr : addresses) {
						final int size = AHOfferLocalServiceUtil
						        .countOfferByAddress(addr.getAddrId());
						if (size <= 0) {
							AHAddrLocalServiceUtil.deleteAHAddr(addr
							        .getAddrId());
							m_objLog.info("Removing address "
							        + addr.getStreet() + " " + addr.getNumber()
							        + " with " + size + " offers!");
						}
					}
				}
			}

		} catch (final Throwable t) {
			m_objLog.warn("Check for orphaned addresses/regions failed due to "
			        + t.getMessage(), t);
		}
	}

	/**
	 * Removes the orphaned regions.
	 */
	public void removeOrphanedRegions() {
		try {
			final int regSize = AHRegionLocalServiceUtil.getAHRegionsCount();
			if (regSize > 0) {
				List<AHRegion> regions;
				for (int i = 0; i < regSize; i += 5) {
					regions = AHRegionLocalServiceUtil.getAHRegions(i, i + 5);
					for (final AHRegion region : regions) {
						// TODO : count only
						final List<AHAddr> addrs = AHAddrLocalServiceUtil
						        .findAddressesForRegion(region.getRegionId());
						if (addrs == null || addrs.size() == 0) {
							AHRegionLocalServiceUtil.removeRegion(region
							        .getRegionId());
							m_objLog.info("Removing region " + region.getZip()
							        + ", " + region.getCity()
							        + " without addresses!");
						}
					}
				}
			}

		} catch (final Throwable t) {
			m_objLog.warn("Check for orphaned addresses/regions failed due to "
			        + t.getMessage(), t);
		}
	}
}
