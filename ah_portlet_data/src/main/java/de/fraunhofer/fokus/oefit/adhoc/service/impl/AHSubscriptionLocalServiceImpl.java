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
package de.fraunhofer.fokus.oefit.adhoc.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus;
import de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription;
import de.fraunhofer.fokus.oefit.adhoc.service.base.AHSubscriptionLocalServiceBaseImpl;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHCatEntriesFinderUtil;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHSubscriptionLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalServiceUtil
 */
public class AHSubscriptionLocalServiceImpl
        extends AHSubscriptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalServiceUtil}
	 * to access the a h subscription local service.
	 */

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHSubscriptionLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#addSubscription(java.lang.String, long[])
	 */
	@Override
	public AHSubscription addSubscription(final String email,
	        final long[] categories) {
		AHSubscription result = null;

		try {
			final List<AHSubscription> subscriptions = this
			        .getSubscriptionsByMail(email);
			String uuid = null;
			if (subscriptions != null && subscriptions.size() > 0) {
				uuid = subscriptions.get(0).getUuid();
			} else {
				uuid = UUID.randomUUID().toString() + "-"
				        + System.currentTimeMillis();
			}
			result = this.createAHSubscription(CounterLocalServiceUtil
			        .increment(AHSubscription.class.getName()));
			result.setCreated(System.currentTimeMillis());
			result.setEmail(email);
			result.setUuid(uuid);
			result.setStatus(E_SubscriptionStatus.NEW.getIntValue());
			result = this.updateAHSubscription(result);
			this.getAHSubscriptionPersistence().addAHCatEntrieses(
			        result.getSubId(), categories);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#getCategoriesBySubscription(long)
	 */
	@Override
	public List<AHCatEntries> getCategoriesBySubscription(final long subId) {
		List<AHCatEntries> result = new LinkedList<AHCatEntries>();

		try {
			result = AHCatEntriesFinderUtil.getCategoriesBySubscription(subId);
			// result = getAHOfferPersistence().getAHCatEntrieses(offerId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#getCategoriesBySubscriptionAsString(long)
	 */
	@Override
	public String getCategoriesBySubscriptionAsString(final long subId) {
		final List<AHCatEntries> categories = this
		        .getCategoriesBySubscription(subId);
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
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#getSubscriptionsByMail(java.lang.String)
	 */
	@Override
	public List<AHSubscription> getSubscriptionsByMail(final String email) {
		List<AHSubscription> result = null;

		try {
			result = this.getAHSubscriptionPersistence().findByemail(email);
			if (result == null || result.size() == 0) {
				result = new LinkedList<AHSubscription>();
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#getSubscriptionsByUuid(java.lang.String)
	 */
	@Override
	public List<AHSubscription> getSubscriptionsByUuid(final String uuid) {
		List<AHSubscription> result = null;

		try {
			result = this.getAHSubscriptionPersistence().findByuuid(uuid);
			if (result == null || result.size() == 0) {
				result = new LinkedList<AHSubscription>();
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#getUserAddresses()
	 */
	@Override
	public List<String> getUserAddresses() {
		final List<String> result = new LinkedList<String>();
		try {
			final List<AHSubscription> subs = AHCatEntriesFinderUtil
			        .getUsersBySubscriptions();
			if (subs != null) {
				for (final AHSubscription sub : subs) {
					result.add(sub.getEmail());
				}
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#getUserAddressesByCatItems(java.lang.Long[])
	 */
	@Override
	public List<AHSubscription> getUserAddressesByCatItems(final Long[] catItems) {
		List<AHSubscription> result = new LinkedList<AHSubscription>();

		try {
			final List<AHSubscription> subscriptions = AHCatEntriesFinderUtil
			        .getSubscriptionMailsByCategoryitems(
			                E_SubscriptionStatus.VALIDATED, catItems);
			if (subscriptions != null) {
				result = subscriptions;
			}

		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#removeSubscription(long)
	 */
	@Override
	public void removeSubscription(final long id) {
		try {
			this.getAHSubscriptionPersistence().clearAHCatEntrieses(id);
			this.deleteAHSubscription(id);
		} catch (final Throwable e) {
			m_objLog.error(e);
		}
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalService#setSubscriptionStatus(long, de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus)
	 */
	@Override
	public void setSubscriptionStatus(final long subId,
	        final E_SubscriptionStatus status) {
		try {
			final AHSubscription subscription = this.getAHSubscription(subId);
			subscription.setStatus(status.getIntValue());
			this.updateAHSubscription(subscription);
		} catch (final Throwable e) {
			m_objLog.error(e);
		}

	}
}
