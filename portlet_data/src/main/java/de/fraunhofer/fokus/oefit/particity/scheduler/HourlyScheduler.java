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

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.custom.ModelNotificationRepository;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * Scheduler for hourly tasks
 */
public class HourlyScheduler implements MessageListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(HourlyScheduler.class);

	private static final long	HOUR	 = 1000 * 60 * 60;

	private void notifyExpiredOffers() {
		try {
			final long now = CustomServiceUtils.time();
			final long minExpired = now - HOUR;
			final int orgSize = AHOrgLocalServiceUtil.getAHOrgsCount();
			if (orgSize > 0) {
				List<AHOrg> orgs;
				List<AHOffer> offer;
				for (int i = 0; i < orgSize; i += 5) {
					orgs = AHOrgLocalServiceUtil.getAHOrgs(i, i + 5);
					for (final AHOrg org : orgs) {
						offer = AHOfferLocalServiceUtil
						        .findExpiredOffersForOrg(org.getOrgId(),
						                minExpired, now);
						if (offer != null && offer.size() > 0) {
							ModelNotificationRepository.getInstance()
							        .notifyOutdated(offer, HOUR);
						}
					}
				}
			}
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Check for expired offers failed due to " + t.getMessage(),
			        t);
		}
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(final Message message) throws MessageListenerException {
		try {

			this.notifyExpiredOffers();

			m_objLog.info("Hourly scheduler update done.");
		} catch (final Throwable t) {
			m_objLog.warn(
			        "Could not exec daily schedule due to: " + t.getMessage(),
			        t);
		}
	}

}
