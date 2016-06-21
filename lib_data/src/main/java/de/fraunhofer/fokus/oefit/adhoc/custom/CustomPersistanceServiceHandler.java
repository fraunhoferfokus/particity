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
package de.fraunhofer.fokus.oefit.adhoc.custom;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.NewsletterForm;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_ContactModel;
import de.particity.model.I_SubscriptionModel;
import de.particity.model.boundary.I_CategoryController;
import de.particity.model.boundary.I_CategoryEntryController;
import de.particity.model.boundary.I_ContactController;
import de.particity.model.boundary.I_OfferController;
import de.particity.model.boundary.I_SubscriptionController;

/**
 * Custom utility methods for various tasks on portlet-related data structures that do not require for a separate handler class
 */
public class CustomPersistanceServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomPersistanceServiceHandler.class);

	@Inject 
	public static I_CategoryController catCtrl;
	
	@Inject
	public static I_CategoryEntryController catEntryCtrl;
	
	@Inject
	public static I_OfferController offerCtrl;
	
	@Inject
	public static I_ContactController contactCtrl;
	
	@Inject
	public static I_SubscriptionController subCtrl;
	
	/**
	 * Add (or receive an existing) contact address
	 *
	 * @param contactForename the contact forename
	 * @param contactSurname the contact surname
	 * @param contactMail the contact email address
	 * @param contactTel the contact telephone or mobile number
	 * @return the AH contact added or found
	 */
	public static I_ContactModel addContact(final String contactForename,
	        final String contactSurname, final String contactMail,
	        final String contactTel) {
		return contactCtrl.add(contactForename,
		        contactSurname, contactTel, null, contactMail, null);
	}

	/**
	 * Add a subscription - according to a form object
	 *
	 * @param data the form object
	 * @return the subscription object
	 */
	public static I_SubscriptionModel addSubscription(final NewsletterForm data) {

		final String[] categories = data.getCategories();
		long[] l_cats = null;
		if (categories != null && categories.length > 0) {
			l_cats = new long[categories.length];
			for (int i = 0; i < categories.length; i++) {
				l_cats[i] = Long.parseLong(categories[i]);
			}
		}

		return subCtrl.add(data.getMail(), l_cats, null, null);
	}
	
	public static I_SubscriptionModel addSubscription(String mail, long[] categories, String uuid, E_SubscriptionStatus status) {

		return  subCtrl.add(mail, categories, uuid, status);
	}

	/**
	 * Clear all dependencies for a specified category entry from offers and subscriptions and delete the category entry afterwards
	 *
	 * @param entryId the category entry ID
	 * @return the category entry just deleted, or <code>null</code> if not found
	 */
	public static I_CategoryEntryModel deleteCategoryEntryById(final long entryId) {
		final I_CategoryEntryModel result = catEntryCtrl.get(entryId);
		if (result != null) {
			try {
				// clear references
				offerCtrl.clearFromCategoryEntryId(result.getId());
				subCtrl.clearFromCategoryEntryId(result.getId());
				// delete
				catEntryCtrl.delete(result);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}

		return result;
	}

	/**
	 * Receive a data-list from storage
	 *
	 * @param type the data-list type
	 * @param includeEmpty whether to include an empty entry (-1,'-') on top of the map
	 * @return a sorted map of data-list primaries mapped to the actual entry titles
	 */
	public static Map<Long, String> getDataList(final E_CategoryType type,
	        final boolean includeEmpty) {
		Map<Long, String> result = null;

		try {
			result = catCtrl.getCategoryMap(type,
			        includeEmpty);
		} catch (final Throwable e) {
			m_objLog.warn(e);
		}

		return result;
	}

	/**
	 * Gets the number of subscriptions for a given email address
	 *
	 * @param email the email address
	 * @return the subscriptions size
	 */
	public static int getSubscriptionsSize(final String email) {

		final List<I_SubscriptionModel> subscriptions = subCtrl
		        .getByMail(email);

		return subscriptions != null ? subscriptions.size() : 0;
	}

	/**
	 * Get all users (that is: newsletter subscribers) in CSV-format (UTF-8)
	 *
	 * @return the users as csv
	 */
	public static byte[] getUsersAsCsv() {
		byte[] result = null;

		final List<String> addresses = subCtrl
		        .getUserAddresses();
		final StringBuffer csv = new StringBuffer();
		if (addresses != null) {
			for (final String address : addresses) {
				csv.append(address).append("\n");
			}
		}
		try {
			result = csv.toString().getBytes("utf-8");
		} catch (final UnsupportedEncodingException e) {
			m_objLog.error(e);
		}

		return result;
	}
	
	public static List<I_SubscriptionModel> getSubscriptions(int start, int end) {
		return subCtrl.get(start, end);
	}
	
	public static long countSubscriptions() {
		return subCtrl.count();
	}
}
