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
package de.fraunhofer.fokus.oefit.adhoc.model.custom;

import java.util.List;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOrg;
import de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription;
import de.fraunhofer.fokus.oefit.adhoc.service.AHOrgLocalServiceUtil;

/**
 * Basic listener to send notification emails, when specific data-structures change their state
 *
 */
public class MailListener implements I_ModelListener {

	private static final Log	m_objLog	= LogFactoryUtil
	                                              .getLog(MailListener.class);

	private static MailListener	m_objSelf	= null;

	/**
	 * Gets the single instance of MailListener.
	 *
	 * @return single instance of MailListener
	 */
	public synchronized static MailListener getInstance() {
		if (m_objSelf == null) {
			m_objSelf = new MailListener();
		}

		return m_objSelf;
	}

	private Company	        m_objDefCompany	= null;
	private String	        m_strPortalURL	= null;
	private String	        m_strPortalName	= null;

	private String	        m_strPortalMail	= null;

	private MessageComposer	m_objComposer	= null;

	private MailListener() {
		try {
			this.m_objComposer = MessageComposer.getInstance();
			this.m_strPortalMail = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.MGMT_CONTACT_MAIL);
			this.m_strPortalName = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.MGMT_CONTACT_NAME);
			this.m_objDefCompany = CompanyLocalServiceUtil
			        .getCompany(PortalUtil.getDefaultCompanyId());
			this.m_strPortalURL = PortalUtil.getPortalURL(
			        this.m_objDefCompany.getVirtualHostname(),
			        PortalUtil.getPortalPort(), false);
		} catch (final Throwable e) {
			m_objLog.error(e);
		}
	}

	private void notify(final String className, final Object clazz) {
		if (className.equals(ORG_CLASS)) {
			String subj = null;
			String body = null;
			InternetAddress from = null;
			InternetAddress to = null;
			final AHOrg org = (AHOrg) clazz;
			final E_OrgStatus status = E_OrgStatus.findByValue(org.getStatus());
			switch (status) {
				case NEW:
				case CHANGED:
					try {
						from = new InternetAddress(this.m_strPortalMail);
						to = from;
						subj = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.MGMT_NEW_ORG_SUBJ);
						body = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.MGMT_NEW_ORG_BODY);
					} catch (final Throwable t) {
						m_objLog.error(t);
					}
					break;
				case DISABLED:
				case VALIDATED:
					try {
						from = new InternetAddress(this.m_strPortalMail);
						to = new InternetAddress(org.getOwner());
						subj = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.ORG_VALID_ORG_SUBJ);
						body = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.ORG_VALID_ORG_BODY);
					} catch (final Throwable t) {
						m_objLog.error(t);
					}
					break;
			}
			if (subj != null && body != null && from != null && to != null) {
				this.sendOrgMail(from, to, subj, body, org);
			} else {
				m_objLog.warn("Not sending mail from " + from + " to " + to
				        + " about " + subj);
			}
		} else if (className.equals(OFFER_CLASS)) {
			String subj = null;
			String body = null;
			InternetAddress from = null;
			InternetAddress to = null;
			final AHOffer offer = (AHOffer) clazz;
			AHOrg org = null;
			try {
				org = AHOrgLocalServiceUtil.getAHOrg(offer.getOrgId());
			} catch (final Throwable t) {
				m_objLog.error(t);
			}
			final E_OfferStatus status = E_OfferStatus.findByValue(offer
			        .getStatus());
			switch (status) {
				case NEW:
				case CHANGED:
					try {
						from = new InternetAddress(this.m_strPortalMail);
						to = from;
						subj = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.MGMT_NEW_OFFER_SUBJ);
						body = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.MGMT_NEW_OFFER_BODY);
						if (subj != null && body != null && from != null
						        && to != null) {
							this.sendOfferMail(from, to, subj, body, offer, org);
						} else {
							m_objLog.warn("Not sending mail from " + from
							        + " to " + to + " about " + subj);
						}
						from = new InternetAddress(this.m_strPortalMail);
						to = new InternetAddress(org.getOwner());
						subj = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.ORG_NEW_OFFER_SUBJ);
						body = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.ORG_NEW_OFFER_BODY);
						if (subj != null && body != null && from != null
						        && to != null) {
							this.sendOfferMail(from, to, subj, body, offer, org);
						} else {
							m_objLog.warn("Not sending mail from " + from
							        + " to " + to + " about " + subj);
						}
					} catch (final Throwable t) {
						m_objLog.error(t);
					}
					break;
				case VALIDATED:
				case DISABLED:
					try {

						from = new InternetAddress(this.m_strPortalMail);
						to = new InternetAddress(org.getOwner());
						subj = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.ORG_VALID_OFFER_SUBJ);
						body = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.ORG_VALID_OFFER_BODY);
						if (subj != null && body != null && from != null
						        && to != null) {
							this.sendOfferMail(from, to, subj, body, offer, org);
						} else {
							m_objLog.warn("Not sending mail from " + from
							        + " to " + to + " about " + subj);
						}
					} catch (final Throwable t) {
						m_objLog.error(t);
					}
					break;
			}

		} else if (className.equals(SUBSCR_CLASS)) {
			final AHSubscription sub = (AHSubscription) clazz;
			final E_SubscriptionStatus status = E_SubscriptionStatus
			        .findByValue(sub.getStatus());
			switch (status) {
				case NEW:
					try {
						final String addr = PrefsPropsUtil.getString(
						        PortalUtil.getDefaultCompanyId(),
						        PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
						final InternetAddress from = new InternetAddress(addr);
						final InternetAddress to = new InternetAddress(
						        sub.getEmail());
						final String subj = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.NEWS_REG_CONFIRM_SUBJ);
						final String body = CustomPortalServiceHandler
						        .getConfigValue(E_ConfigKey.NEWS_REG_CONFIRM_BODY);
						this.sendNewsMail(from, to, subj, body, sub);
					} catch (final Throwable t) {
						m_objLog.error(t);
					}
					break;
			}

		} else {
			m_objLog.warn("Ignoring unknown class " + className);
		}
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.model.custom.I_ModelListener#notifyCreate(java.lang.String, java.lang.Object)
	 */
	@Override
	public void notifyCreate(final String className, final Object clazz) {
		this.notify(className, clazz);
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.model.custom.I_ModelListener#notifyDelete(java.lang.String, java.lang.Object)
	 */
	@Override
	public void notifyDelete(final String className, final Object clazz) {
		// notify(className,clazz);
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.model.custom.I_ModelListener#notifyOutdated(java.lang.String, java.util.List, long)
	 */
	@Override
	public void notifyOutdated(final String className,
	        final List<Object> clazz, final long time) {
		if (className.equals(OFFER_CLASS)) {
			if (clazz.size() > 0) {
				AHOrg org = null;
				InternetAddress from = null;
				InternetAddress to = null;
				String subj = null;
				String body = null;
				try {
					final AHOffer offer = (AHOffer) clazz.get(0);
					org = AHOrgLocalServiceUtil.getAHOrg(offer.getOrgId());
					from = new InternetAddress(this.m_strPortalMail);
					to = new InternetAddress(org.getOwner());
					subj = CustomPortalServiceHandler
					        .getConfigValue(E_ConfigKey.ORG_EXPIRED_OFFER_SUBJ);
					body = CustomPortalServiceHandler
					        .getConfigValue(E_ConfigKey.ORG_EXPIRED_OFFER_BODY);
					body = this.m_objComposer.replaceOfferList(body, clazz);
				} catch (final Throwable t) {
					m_objLog.error(t);
				}
				if (from != null && to != null && subj != null && body != null
				        && org != null) {
					this.sendOrgMail(from, to, subj, body, org);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.model.custom.I_ModelListener#notifyOutdated(java.lang.String, java.lang.Object, long)
	 */
	@Override
	public void notifyOutdated(final String className, final Object clazz,
	        final long time) {
		if (className.equals(ORG_CLASS)) {
			final AHOrg org = (AHOrg) clazz;
			InternetAddress from = null;
			InternetAddress to = null;
			String subj = null;
			String body = null;
			try {
				from = new InternetAddress(this.m_strPortalMail);
				to = new InternetAddress(org.getOwner());
				subj = CustomPortalServiceHandler
				        .getConfigValue(E_ConfigKey.ORG_REMINDER_SUBJ);
				body = CustomPortalServiceHandler
				        .getConfigValue(E_ConfigKey.ORG_REMINDER_BODY);
			} catch (final Throwable t) {
				m_objLog.error(t);
			}
			if (from != null && to != null && subj != null && body != null) {
				this.sendOrgMail(from, to, subj, body, org);
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.model.custom.I_ModelListener#notifyUpdate(java.lang.String, java.lang.Object)
	 */
	@Override
	public void notifyUpdate(final String className, final Object clazz) {
		this.notify(className, clazz);
	}

	private void sendMail(final InternetAddress from, final InternetAddress to,
	        final String subj, final String body) {
		final MailMessage msg = new MailMessage();
		msg.setHTMLFormat(true);
		msg.setFrom(from);
		msg.setTo(to);
		msg.setSubject(this.m_objComposer.replaceCommon(from.toString(),
		        to.toString(), subj));
		msg.setBody(this.m_objComposer.replaceCommon(from.toString(),
		        to.toString(), body));
		m_objLog.info("Sending mail from " + from + " to " + to + " about "
		        + subj);
		MailServiceUtil.sendEmail(msg);
	}

	private void sendNewsMail(final InternetAddress from,
	        final InternetAddress to, final String subjSrc,
	        final String bodySrc, final AHSubscription sub) {
		this.sendMail(from, to,
		        this.m_objComposer.replaceNewsValues(subjSrc, sub),
		        this.m_objComposer.replaceNewsValues(bodySrc, sub));
	}

	private void sendNewsMail(final InternetAddress from,
	        final InternetAddress to, String subjSrc, String bodySrc,
	        final AHSubscription sub, final List<AHOffer> offers) {
		subjSrc = this.m_objComposer.replaceOfferSize(subjSrc, offers);
		bodySrc = this.m_objComposer.replaceOfferSize(bodySrc, offers);
		bodySrc = this.m_objComposer.replaceOfferList(bodySrc, offers);
		this.sendMail(from, to,
		        this.m_objComposer.replaceNewsValues(subjSrc, sub),
		        this.m_objComposer.replaceNewsValues(bodySrc, sub));
	}

	/**
	 * Send news update mail.
	 *
	 * @param sub the sub
	 * @param offers the offers
	 */
	public void sendNewsUpdateMail(final AHSubscription sub,
	        final List<AHOffer> offers) {
		try {
			final String addr = PrefsPropsUtil.getString(
			        PortalUtil.getDefaultCompanyId(),
			        PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			final InternetAddress from = new InternetAddress(addr);
			final InternetAddress to = new InternetAddress(sub.getEmail());
			final String subj = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.NEWS_UPDATE_SUBJ);
			final String body = CustomPortalServiceHandler
			        .getConfigValue(E_ConfigKey.NEWS_UPDATE_BODY);
			this.sendNewsMail(from, to, subj, body, sub, offers);
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
	}

	private void sendOfferMail(final InternetAddress from,
	        final InternetAddress to, final String subjSrc,
	        final String bodySrc, final AHOffer offer, final AHOrg org) {
		String subj = this.m_objComposer.replaceOfferValues(subjSrc, offer);
		if (org != null) {
			subj = this.m_objComposer.replaceOrgValues(subj, org);
		}
		String body = this.m_objComposer.replaceOfferValues(bodySrc, offer);
		if (org != null) {
			body = this.m_objComposer.replaceOrgValues(body, org);
		}
		this.sendMail(from, to, subj, body);
	}

	private void sendOrgMail(final InternetAddress from,
	        final InternetAddress to, final String subjSrc,
	        final String bodySrc, final AHOrg org) {
		this.sendMail(from, to,
		        this.m_objComposer.replaceOrgValues(subjSrc, org),
		        this.m_objComposer.replaceOrgValues(bodySrc, org));
	}

}
