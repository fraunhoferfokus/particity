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


// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService}
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
 * @see de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil
 */
public class AHSubscriptionLocalServiceImpl {
	
	/*
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


	@Override
	public List<AHSubscription> getUserAddressesByCatItems(final Long[] catItems) {
		List<AHSubscription> result = new LinkedList<AHSubscription>();

		try {
			final List<AHSubscription> subscriptions = AHCatEntriesFinderUtil
			        .getSubscriptionMailsByCategoryitems(
			                E_SubscriptionStatus.VALIDATED.getIntValue(), catItems);
			if (subscriptions != null) {
				result = subscriptions;
			}

		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}


	@Override
	public void removeSubscription(final long id) {
		try {
			this.getAHSubscriptionPersistence().clearAHCatEntrieses(id);
			this.deleteAHSubscription(id);
		} catch (final Throwable e) {
			m_objLog.error(e);
		}
	}


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
	*/
}
