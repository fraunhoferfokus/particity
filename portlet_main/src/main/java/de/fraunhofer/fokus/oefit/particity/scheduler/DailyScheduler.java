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

import javax.inject.Inject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import de.particity.model.I_AddressModel;
import de.particity.model.I_OfferModel;
import de.particity.model.I_OrganizationModel;
import de.particity.model.I_RegionModel;
import de.particity.model.boundary.I_AddressControler;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.boundary.I_OrganizationController;
import de.particity.model.boundary.I_RegionController;

/**
 * Scheduler for daily tasks
 */
public class DailyScheduler implements MessageListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(DailyScheduler.class);

	@Inject
	private I_OfferController offerCtrl;
	
	@Inject
	private I_OrganizationController orgCtrl;
	
	@Inject
	private I_AddressControler addrCtrl;
	
	@Inject
	private I_RegionController regionCtrl;
	
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
			final long offerSize = offerCtrl.count();
			if (offerSize > 0) {
				List<I_OfferModel> offers;
				I_AddressModel addr;
				for (int i = 0; i < offerSize; i += 5) {
					offers = offerCtrl.get(i, i + 5);
					for (final I_OfferModel offer : offers) {
						if (offer.getAddress() == null) {
							offerCtrl.delete(offer);
							m_objLog.warn("Removing offer "
							        + offer.getId() + "/"
							        + offer.getTitle()
							        + " due to missing address");
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
			final long offerSize = offerCtrl.count();
			if (offerSize > 0) {
				List<I_OfferModel> offers;
				for (int i = 0; i < offerSize; i += 5) {
					offers = offerCtrl.get(i, i + 5);
					for (final I_OfferModel offer : offers) {
						if (offer.getOrg() == null) {
							offerCtrl.delete(offer);
							m_objLog.warn("Removing offer "
							        + offer.getId() + "/"
							        + offer.getTitle()
							        + " due to missing organisation");
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
			final long orgSize = orgCtrl.count();
			if (orgSize > 0) {
				List<I_OrganizationModel> orgs;
				for (int i = 0; i < orgSize; i += 5) {
					orgs = orgCtrl.get(i, i + 5);
					for (final I_OrganizationModel org : orgs) {
						final String mail = org.getOwner();
						User user = null;
						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(
							        companyId, mail);
						} catch (final Throwable t) {
						}
						if (user == null) {
							m_objLog.warn("Removing organisation "
							        + org.getId() + "/" + org.getName()
							        + " due to missing user.");
							orgCtrl.delete(org);
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
			final long addrSize = addrCtrl.count();
			if (addrSize > 0) {
				List<I_AddressModel> addresses;
				for (int i = 0; i < addrSize; i += 5) {
					addresses = addrCtrl.get(i, i + 5);
					for (final I_AddressModel addr : addresses) {
						final int size = offerCtrl
						        .countByAddress(addr.getId());
						if (size <= 0) {
							addrCtrl.delete(addr);
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
			final long regSize = regionCtrl.count();
			if (regSize > 0) {
				List<I_RegionModel> regions;
				for (int i = 0; i < regSize; i += 5) {
					regions = regionCtrl.get(i, i + 5);
					for (final I_RegionModel region : regions) {
						// TODO : count only
						final List<I_AddressModel> addrs = addrCtrl
						        .findForRegion(region.getId());
						if (addrs == null || addrs.size() == 0) {
							regionCtrl.delete(region);
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
