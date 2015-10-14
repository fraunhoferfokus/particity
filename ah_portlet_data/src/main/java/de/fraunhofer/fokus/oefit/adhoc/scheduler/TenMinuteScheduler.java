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
package de.fraunhofer.fokus.oefit.adhoc.scheduler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;
import de.fraunhofer.fokus.oefit.particity.model.custom.MailListener;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil;

/**
 * Scheduler for tasks with 10-minute period
 */
public class TenMinuteScheduler implements MessageListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(TenMinuteScheduler.class);

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(final Message message) throws MessageListenerException {
		try {

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

			final long now = CustomServiceUtils.time();
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

			final List<AHOffer> offers = AHOfferLocalServiceUtil
			        .getNewlyPublishedOffers(lastUpdate);
			final Map<String, List<AHOffer>> offerUserMap = new HashMap<String, List<AHOffer>>();
			final Map<String, AHSubscription> userSubscriptionMap = new HashMap<String, AHSubscription>();
			List<AHOffer> userOffers;
			Long[] cats;
			List<AHSubscription> recipients;
			for (final AHOffer offer : offers) {
				cats = AHOfferLocalServiceUtil.getCategoriesByOfferAsLong(
				        offer.getOfferId(), E_CategoryType.SEARCH);
				recipients = AHSubscriptionLocalServiceUtil
				        .getUserAddressesByCatItems(cats);
				if (recipients != null && recipients.size() > 0) {
					for (final AHSubscription rec : recipients) {
						userOffers = offerUserMap.get(rec.getEmail());
						if (userOffers == null) {
							userOffers = new LinkedList<AHOffer>();
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
