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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.particity.model.I_OfferModel;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.boundary.I_CategoryEntryController;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.boundary.I_SubscriptionController;
import de.particity.model.listener.MailListener;

/**
 * Scheduler for tasks with 10-minute period
 */
public class TenMinuteScheduler implements MessageListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(TenMinuteScheduler.class);

	@Inject
	private I_OfferController offerCtrl;
	
	@Inject
	private I_CategoryEntryController catEntryCtrl;
	
	@Inject
	private I_SubscriptionController subCtrl;
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(final Message message) throws MessageListenerException {
		try {

			boolean newsletterIsEnabled = CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.ENABLE_NEWSLETTER);
			
			if (newsletterIsEnabled)
				this.sendNewsletter();

			m_objLog.info("Ten-Minute scheduler update done.");
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Could not exec daily schedule due to: " + t.getMessage(),
			        t);
		}
	}

	private void sendNewsletter() {
		try {

			final long now = CustomServiceUtils.timeMillis();
			final String strLastUpdate = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.SCHED_NEWS);
			long lastUpdate = 0;
			if (strLastUpdate != null && strLastUpdate.trim().length() != 0) {
				try {
					lastUpdate = Long.parseLong(strLastUpdate);
				} catch (final Throwable t) {
					lastUpdate = 0;
				}
			}

			final List<I_OfferModel> offers = offerCtrl
			        .getNewlyPublished(lastUpdate);
			final Map<String, List<I_OfferModel>> offerUserMap = new HashMap<String, List<I_OfferModel>>();
			final Map<String, I_SubscriptionModel> userSubscriptionMap = new HashMap<String, I_SubscriptionModel>();
			List<I_OfferModel> userOffers;
			Long[] cats;
			List<I_SubscriptionModel> recipients;
			for (final I_OfferModel offer : offers) {
				cats = catEntryCtrl.getByOfferAsLong(
				        offer.getId(), E_CategoryType.SEARCH);
				recipients = subCtrl
				        .getByCategoryEntries(cats);
				if (recipients != null && recipients.size() > 0) {
					for (final I_SubscriptionModel rec : recipients) {
						userOffers = offerUserMap.get(rec.getEmail());
						if (userOffers == null) {
							userOffers = new LinkedList<I_OfferModel>();
							offerUserMap.put(rec.getEmail(), userOffers);
							userSubscriptionMap.put(rec.getEmail(), rec);
						}
						userOffers.add(offer);
					}
				}
			}

			final MailListener sender = MailListener.getInstance();

			for (final String user : offerUserMap.keySet()) {
				userOffers = offerUserMap.get(user);
				if (userOffers.size() > 0) {
					sender.sendNewsUpdateMail(userSubscriptionMap.get(user),
					        userOffers);
				}
			}

			CustomPortalServiceHandler.setConfig(E_ConfigKey.SCHED_NEWS,
			        Long.toString(now));

		} catch (final Throwable t) {
			m_objLog.warn(
			        "Check for expired offers failed due to " + t.getMessage(),
			        t);
		}
	}

}
