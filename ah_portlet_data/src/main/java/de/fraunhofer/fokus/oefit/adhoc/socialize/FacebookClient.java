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


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOrg;
import de.fraunhofer.fokus.oefit.adhoc.model.custom.MessageComposer;
import de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.adhoc.service.AHOrgLocalServiceUtil;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;

/**
 * A Facebook client implementation using facebook4j 
 */
public class FacebookClient implements I_SocialMediaClient {

	private static final Log	       m_objLog	  = LogFactoryUtil
	                                                      .getLog(FacebookClient.class);

	private static I_SocialMediaClient	m_objSelf	= null;

	/**
	 * Gets the single instance of FacebookClient.
	 *
	 * @return single instance of FacebookClient
	 */
	public static final synchronized I_SocialMediaClient getInstance() {
		if (m_objSelf == null) {
			m_objSelf = new FacebookClient();
		}
		return m_objSelf;
	}

	private boolean	        m_bConnected;
	private Facebook	    m_objClient	  = null;

	private MessageComposer	m_objComposer	= null;

	private FacebookClient() {
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
		        .getConfigValue(E_ConfigKey.SOCIAL_FB_MSG);
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
		final String appId = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_FB_APPID);
		final String appSec = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_FB_APPSEC);
		final String aToken = CustomPortalServiceHandler
		        .getConfigValue(E_ConfigKey.SOCIAL_FB_AT);

		if (appId != null && aToken != null && appSec != null
		        && appId.trim().length() > 0 && aToken.trim().length() > 0
		        && appSec.trim().length() > 0) {

			final ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			        .setOAuthAppId(appId)
			        .setOAuthAppSecret(appSec)
			        .setOAuthAccessToken(aToken)
			        .setOAuthPermissions("publish_stream");
			final FacebookFactory ff = new FacebookFactory(cb.build());
			this.m_objClient = ff.getInstance();
			try {
				this.m_objClient.getStatuses();
				result = true;
				this.m_bConnected = true;
			} catch (final FacebookException e) {
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
				this.m_objClient.postLink(url, message);
				result = true;
			} catch (final FacebookException e) {
				m_objLog.warn(e);
			}
		}

		return result;
	}

}
