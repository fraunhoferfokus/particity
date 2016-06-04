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
package de.fraunhofer.fokus.oefit.particity.service.persistence.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AHCatEntriesFinderImpl {
	
	private static final Log m_objLog = LogFactoryUtil
			.getLog(AHCatEntriesFinderImpl.class);

	
	public static String getOfferCategories = "select * from AHCITEM entry "
			+ "INNER JOIN PARTICITY_offer_citm map ON map.itemId=entry.itemId "
			+ "WHERE map.offerId=?";
	
	public static String getOfferCategoriesByType = "select * from AHCITEM entry "
			+ "INNER JOIN PARTICITY_offer_citm map ON map.itemId=entry.itemId "
			+ "INNER JOIN AHCATS cat ON entry.catId=cat.catId AND cat.type_=? "
			+ "WHERE map.offerId=?";
	
	public static String getSubscriptionCategories = "select * from AHCITEM entry "
			+ "INNER JOIN PARTICITY_sub_citm map ON map.itemId=entry.itemId "
			+ "WHERE map.subId=?";
	
	public static String getSubscriptionsByCategories = "select entry.* from AHSUBSCR entry "
			+ "INNER JOIN PARTICITY_sub_citm map ON map.subId=entry.subId "
			+ "WHERE entry.status=? AND map.itemId IN ([$ITEM_IDS$]) GROUP BY entry.subId ORDER by entry.created";

	
	public static String getUsersBySubscriptions = "select * from AHSUBSCR entry "
			+ "GROUP BY entry.email ORDER by entry.created";

	
	public static String getSubscriptionsByItemIds = "select sub.* from AHSUBSCR sub INNER JOIN PARTICITY_sub_citm map "
			+ "ON map.subId=sub.subId AND sub.status=? AND map.itemId IN ([$ITEM_IDS$]) GROUP BY sub.email";
	
	
	/*
	@Override
	public List<AHSubscription> getSubscriptionMailsByCategoryitems(int status, String categoryItems)
			throws SystemException {
		List<AHSubscription> result = null;

		Session session = null;

		try {
			session = openSession();
			//String sql = CustomSQLUtil.get(getSubscriptionCategories);
			String sql = StringUtil.replace(getSubscriptionsByItemIds, "[$ITEM_IDS$]", categoryItems);

			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHSubscription", AHSubscriptionImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status);
			result = (List<AHSubscription>) query.list();
			
			m_objLog.debug("Search for subscription emails for categoryItems "+categoryItems+" results in "+result.size()+" values");
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	

	
	@Override
	public List<AHSubscription> getUsersBySubscriptions() throws SystemException {
		List<AHSubscription> result = null;

		Session session = null;

		try {
			session = openSession();

			SQLQuery query = session.createSQLQuery(getUsersBySubscriptions);

			query.addEntity("AHSubscription", AHSubscriptionImpl.class);
			
			result = (List<AHSubscription>) query.list();
			
			m_objLog.debug("Search for subscription users results in "+result.size()+" values");
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHSubscription> getSubscriptionsByCategoryitems(int status, String[] categoryItems, int from, int to)
			throws SystemException {
		List<AHSubscription> result = null;

		Session session = null;

		try {
			session = openSession();
			//String sql = CustomSQLUtil.get(getSubscriptionCategories);
			String catItemStr = arrToStr(categoryItems);
			String sql = StringUtil.replace(getSubscriptionCategories, "[$ITEM_IDS$]", catItemStr);

			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHSubscription", AHSubscriptionImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status);
			result = (List<AHSubscription>) query.list();
			
			m_objLog.debug("Search for categoryItems "+catItemStr+" results in "+result.size()+" values");
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	

	@Override
	public List<AHSubscription> getSubscriptionMailsByCategoryitems(int status, Long[] categories)
			throws SystemException {
		return getSubscriptionMailsByCategoryitems(status, arrToStr(categories));
	}
	

	private String arrToStr(String[] categoryItems) {
		StringBuffer result = new StringBuffer();
		
		if (categoryItems != null && categoryItems.length > 0) {
			result.append(categoryItems[0]);
			for (int i=1; i<categoryItems.length; i++)
				result.append(",").append(categoryItems[i]);
		}
		
		return result.toString();
	}
	
	private String arrToStr(Long[] ids) {
		StringBuffer result = new StringBuffer();
		
		if (ids != null && ids.length > 0) {
			result.append(ids[0]);
			for (int i=1; i<ids.length; i++)
				result.append(",").append(ids[i]);
		}
		
		return result.toString();
	}
	
	private String arrToStr(int[] ids) {
		StringBuffer result = new StringBuffer();
		
		if (ids != null && ids.length > 0) {
			result.append(ids[0]);
			for (int i=1; i<ids.length; i++)
				result.append(",").append(ids[i]);
		}
		
		return result.toString();
	}

	@Override
	public List<AHCatEntries> getCategoriesByOffer(long offerId, Integer type)
			throws SystemException {
		List<AHCatEntries> result = null;

		Session session = null;

		try {
			//session = sessionFactory.openSession();
			session = openSession();
			String sql = getOfferCategoriesByType;
			if (type == null)
				sql = getOfferCategories;
			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHCatEntries", AHCatEntriesImpl.class);

			QueryPos qPos = QueryPos.getInstance(query);
			if (type != null)
				qPos.add(type);
			qPos.add(offerId);
			result = (List<AHCatEntries>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
			//sessionFactory.closeSession(session); // edited as per the comment
													// on this answer
		}
		return result;
	}
	
	@Override
	public List<AHCatEntries> getCategoriesBySubscription(long subId)
			throws SystemException {
		List<AHCatEntries> result = null;

		
		Session session = null;

		try {
			//session = sessionFactory.openSession();
			session = openSession();
			SQLQuery query = session.createSQLQuery(getSubscriptionCategories);

			query.addEntity("AHCatEntries", AHCatEntriesImpl.class);

			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(subId);
			result = (List<AHCatEntries>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
			//sessionFactory.closeSession(session); // edited as per the comment
													// on this answer
		}
		return result;
	}
	
	*/

}
