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
package de.fraunhofer.fokus.oefit.adhoc.socialize;

import java.net.URL;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.custom.MessageComposer;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * A Twitter client implementation using twitter4j
 */
public class TwitterClient implements I_SocialMediaClient {
	private static final Log	 m_objLog	  = LogFactoryUtil
	                                                  .getLog(TwitterClient.class);

	private static TwitterClient	m_objSelf	= null;

	/**
	 * Gets the single instance of TwitterClient.
	 *
	 * @return single instance of TwitterClient
	 */
	public static final synchronized TwitterClient getInstance() {
		if (m_objSelf == null) {
			m_objSelf = new TwitterClient();
		}
		return m_objSelf;
	}

	private boolean	        m_bConnected	= false;
	private Twitter	        m_objTwitter	= null;

	private MessageComposer	m_objComposer	= null;

	private TwitterClient() {
		this.m_objComposer = MessageComposer.getInstance();
		this.reconnect();
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.socialize.I_SocialMediaClient#isConnected()
	 */
	@Override
	public boolean isConnected() {
		return this.m_bConnected;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.socialize.I_SocialMediaClient#publishOffer(java.net.URL, java.lang.Long)
	 */
	@Override
	public boolean publishOffer(final URL permalink, final Long offerId) {
		boolean result = false;
		String msg = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_TW_MSG);
		AHOffer offer = null;
		AHOrg org = null;
		try {
			offer = AHOfferLocalServiceUtil.getAHOffer(offerId);
			org = AHOrgLocalServiceUtil.getAHOrg(offer.getOrgId());
		} catch (final Throwable t) {
		}
		if (offer != null && msg != null && org != null) {
			msg = this.m_objComposer.replacePortalValues(msg);
			msg = this.m_objComposer.replaceOfferValues(msg, offer);
			msg = this.m_objComposer.replaceOrgValues(msg, org);
			result = this.send(permalink, msg);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.socialize.I_SocialMediaClient#reconnect()
	 */
	@Override
	public boolean reconnect() {
		boolean result = false;
		final String cSecret = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_TW_CS);
		final String cKey = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_TW_CK);
		final String aToken = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_TW_AT);
		final String aSecret = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_TW_ATS);

		if (cKey != null && cSecret != null && aToken != null
		        && aSecret != null && cKey.trim().length() > 0
		        && cSecret.trim().length() > 0 && aToken.trim().length() > 0
		        && aSecret.trim().length() > 0) {
			System.setProperty("twitter4j.loggerFactory",
			        "twitter4j.NullLoggerFactory");
			final ConfigurationBuilder builder = new ConfigurationBuilder();
			builder.setOAuthAccessToken(aToken);
			builder.setOAuthAccessTokenSecret(aSecret);
			builder.setOAuthConsumerKey(cKey);
			builder.setOAuthConsumerSecret(cSecret);
			builder.setDebugEnabled(false);

			final TwitterFactory factory = new TwitterFactory(builder.build());
			/* AccessToken accessToken = new AccessToken(aToken, aSecret); */
			this.m_objTwitter = factory.getInstance();
			/*
			 * m_objTwitter.setOAuthConsumer(cKey, cSecret);
			 * m_objTwitter.setOAuthAccessToken(accessToken);
			 */
			try {
				this.m_objTwitter.getUserTimeline();
				result = true;
				this.m_bConnected = true;
			} catch (final TwitterException e) {
				m_objLog.warn(e);
			}
		}
		return result;

	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.socialize.I_SocialMediaClient#send(java.net.URL, java.lang.String)
	 */
	@Override
	public boolean send(final URL url, final String message) {
		boolean result = false;

		if (!this.m_bConnected) {
			this.reconnect();
		}

		if (this.m_bConnected) {
			try {
				this.m_objTwitter.updateStatus(message);
				result = true;
			} catch (final TwitterException e) {
				m_objLog.warn(e);
			}
		}

		return result;
	}

}
