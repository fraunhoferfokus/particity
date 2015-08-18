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
package de.fraunhofer.fokus.oefit.adhoc.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferImpl;

public class AHOfferFinderImpl extends BasePersistenceImpl<AHOffer>
		implements AHOfferFinder {
	
	private static final Log m_objLog = LogFactoryUtil
			.getLog(AHOfferFinderImpl.class);
 
	public static String getOfferCustomOrder = "select * from AHOFFER ORDER BY _COL_ _DIR_";
	
	public static String getOfferByOrgCustomOrder = "select * from AHOFFER offer WHERE offer.orgId=_ORGID_ ORDER BY _COL_ _DIR_";
	
	public static String getOfferByCategoryItems = "select offer.* from AHOFFER offer "
			+ "INNER JOIN ADHOC_offer_citm map ON map.offerId=offer.offerId "
			+ "WHERE offer.status=? AND offer.publish <= ? AND offer.expires > ? AND map.itemId IN ([$ITEM_IDS$]) GROUP BY offer.offerId ORDER by offer.created";

	public static String getOfferByCategory = "select offer.* from ADHOC_offer_citm map "
			+ "INNER JOIN AHCITEM citm ON citm.itemId=map.itemId AND citm.catId IN ([$ITEM_IDS$]) "
			+ "INNER JOIN AHOFFER offer ON map.offerId=offer.offerId "
			+ "WHERE offer.status=? AND offer.publish <= ? AND offer.expires > ? GROUP BY offer.offerId ORDER by offer.created";
	
	public static String getExpiredOffersByOrg = "select offer.* from AHOFFER offer "
			+ "WHERE offer.orgId=? AND offer.expires >= ? AND offer.expires <= ? ORDER by offer.expires";
	
	public static String getOfferByTypes = "select offer.* from AHOFFER offer WHERE offer.type_ IN ([$TYPE_IDS$]) "
			+ "AND offer.status=? AND offer.publish <= ? AND offer.expires > ? ORDER by offer.created";

	
	public static String getOfferByIssuerTime = "select offer.* from AHOFFER offer "
			+ "WHERE offer.status=? AND offer.publish >= ? AND offer.publish < ? AND offer.expires > ? ORDER by offer.publish";
	
	
	@Override
	public List<AHOffer> getOffersWithCustomOrder(String column, E_OrderType order, int from, int to)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
			session = openSession();

			String sql = getOfferCustomOrder.replaceAll("_COL_", column).replaceAll("_DIR_", order.toString());
			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHOffer", AHOfferImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHOffer> getOffersByOrgWithCustomOrder(long orgId, String column, E_OrderType order, int from, int to)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
			session = openSession();

			String sql = getOfferByOrgCustomOrder.replaceAll("_COL_", column).replaceAll("_DIR_", order.toString()).replaceAll("_ORGID_",Long.toString(orgId));
			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHOffer", AHOfferImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
		
	@Override
	public List<AHOffer> getNewlyPublishedOffers(long publishStartTime)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
	
			session = openSession();
			
			SQLQuery query = session.createSQLQuery(getOfferByIssuerTime);
			
			query.addEntity("AHOffer", AHOfferImpl.class);
			
			long now = CustomServiceUtils.time();
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(E_OfferStatus.VALIDATED.getIntValue());
			qPos.add(publishStartTime);
			qPos.add(now);
			qPos.add(now);
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	

	
	@Override
	public List<AHOffer> getExpiredOffersByOrg(long orgId, long starTime, long endTime)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
	
			session = openSession();
			
			SQLQuery query = session.createSQLQuery(getExpiredOffersByOrg);
			
			query.addEntity("AHOffer", AHOfferImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(orgId);
			qPos.add(starTime);
			qPos.add(endTime);
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	
	@Override
	public Integer countOfferByCategoryitems(E_OfferStatus status, String[] categoryItems)
			throws SystemException {
		Integer result = 0;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
			
			session = openSession();
			
			//String sql = CustomSQLUtil.get(getOfferByCategories);
			String sql = StringUtil.replace(getOfferByCategoryItems, "[$ITEM_IDS$]", arrToStr(categoryItems));
			//sql = sql.replace("offer.*", "COUNT(*) AS COUNT_VALUE");
			sql = "select count(*) as COUNT_VALUE from ("+sql+") x";
			//m_objLog.trace("Counting from "+currentTimeStr+" ("+currentTime+") with query "+sql);

			SQLQuery query = session.createSQLQuery(sql);

			query.addScalar("COUNT_VALUE", Type.INTEGER);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			
			Iterator<Integer> itr = query.list().iterator();

			if (itr.hasNext()) {
				result = itr.next();
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHOffer> getOfferByCategoryitems(E_OfferStatus status, String[] categoryItems, int from, int to)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
//			String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
			
			session = openSession();
			
			//String sql = CustomSQLUtil.get(getOfferByCategories);
			String sql = StringUtil.replace(getOfferByCategoryItems, "[$ITEM_IDS$]", arrToStr(categoryItems));
			//m_objLog.trace("Listing offers from "+currentTimeStr+" ("+currentTime+") with sql "+sql);
			
			SQLQuery query = session.createSQLQuery(sql);
			
			query.addEntity("AHOffer", AHOfferImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	
	@Override
	public Integer countOfferByOfferTypes(E_OfferStatus status, String types)
			throws SystemException {
		Integer result = null;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
;
			session = openSession();
			
			types = types.trim();
			if (types.startsWith(","))
				types = types.substring(1);
			if (types.endsWith(","))
				types = types.substring(0, types.length()-1);
			
			//String sql = CustomSQLUtil.get(getOfferByCategories);
			String sql = StringUtil.replace(getOfferByTypes, "[$TYPE_IDS$]", types);
			sql = sql.replace("offer.*", "COUNT(*) AS COUNT_VALUE");
			m_objLog.info("SQL: "+sql);
			//m_objLog.trace("Counting from "+currentTimeStr+" ("+currentTime+") with query "+sql);
			
			SQLQuery query = session.createSQLQuery(sql);

			query.addScalar("COUNT_VALUE", Type.INTEGER);

			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			
			Iterator<Integer> itr = query.list().iterator();

			if (itr.hasNext()) {
				result = itr.next();
			}
			
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHOffer> getOfferByTypesAndItemsAndOrg(E_OfferStatus status, String types, String categories, long orgId, int from, int to) throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
			
			session = openSession();
			
			String sql = getOfferByTypesAndItemsAndOrgSQL(types, categories, orgId);
		
			m_objLog.debug("Gettings offers for types "+types+", categories "+categories+", and org "+orgId+" from "+from+" to "+to+" with "+sql);
			
			SQLQuery query = session.createSQLQuery(sql);
			
			query.addEntity("AHOffer", AHOfferImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public Integer countOfferByTypesAndItemsAndOrg(E_OfferStatus status, String types, String categories, long orgId) throws SystemException {
		Integer result = 0;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
;
			session = openSession();
			
			String sql = getOfferByTypesAndItemsAndOrgSQL(types, categories, orgId);
			
			//sql = sql.replace("offer.*", "COUNT(*) AS COUNT_VALUE");
			sql = "select count(*) as COUNT_VALUE from ("+sql+") x";

			
			m_objLog.debug("Counting offers for types "+types+", categories "+categories+", and org "+orgId+" with "+sql);

			//m_objLog.trace("Counting from "+currentTimeStr+" ("+currentTime+") with query "+sql);
			
			SQLQuery query = session.createSQLQuery(sql);

			query.addScalar("COUNT_VALUE", Type.INTEGER);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			
			Iterator<Integer> itr = query.list().iterator();

			if (itr.hasNext()) {
				result = itr.next();
			}
			
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;

	}
	
	private String getOfferByTypesAndItemsAndOrgSQL(String types, String categories, long orgId) {
		
		if (categories != null && categories.trim().length() == 0)
			categories = null;
		if (types != null && types.trim().length() == 0)
			types = null;
		
		if (types != null) {
			types = types.trim();
			if (types.startsWith(","))
				types = types.substring(1);
			if (types.endsWith(","))
				types = types.substring(0, types.length()-1);
			if (types.length() == 0)
				types = null;
		}
		
		if (categories != null) {
			categories = categories.trim();
			if (categories.startsWith(","))
				categories = categories.substring(1);
			if (categories.endsWith(","))
				categories = categories.substring(0, categories.length()-1);
			if (categories.length() == 0)
				categories = null;
		}
		
		String sql = "select offer.* from AHOFFER offer ";
		if (categories != null)
			sql+= " INNER JOIN ADHOC_offer_citm map ON map.offerId=offer.offerId";
		sql+=" WHERE offer.status=? AND offer.publish <= ? AND offer.expires > ?";
		if (orgId >= 0) {
			sql+=" AND offer.orgId="+orgId;
		}
		if (categories != null)
			sql+=" AND map.itemId IN ("+categories+")";
		if (types != null && types.trim().length() > 0) {
			sql+= " AND offer.type_ IN ("+types+")";
		}
		if (categories != null)
			sql+=" GROUP BY offer.offerId";
		sql+=" ORDER by offer.updated";
		
		return sql;
	}
	
	@Override
	public List<AHOffer> getOfferByOfferTypes(E_OfferStatus status, String types, int from, int to)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
			
			session = openSession();
			
			//String sql = CustomSQLUtil.get(getOfferByCategories);
			String sql = StringUtil.replace(getOfferByTypes, "[$TYPE_IDS$]", types);
			//m_objLog.info("SQL: "+sql);
			//m_objLog.trace("Listing offers from "+currentTimeStr+" ("+currentTime+") with sql "+sql);

			
			SQLQuery query = session.createSQLQuery(sql);
			
			query.addEntity("AHOffer", AHOfferImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public Integer countOfferByCategories(E_OfferStatus status, String categories)
			throws SystemException {
		Integer result = null;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
			
			session = openSession();
			
			//String sql = CustomSQLUtil.get(getOfferByCategories);
			String sql = StringUtil.replace(getOfferByCategory, "[$ITEM_IDS$]", categories);
			//m_objLog.info("SQL: "+sql);
			
			//sql = sql.replace("offer.*", "COUNT(*) AS COUNT_VALUE");
			sql = "select count(*) as COUNT_VALUE from ("+sql+") x";
			//m_objLog.trace("Counting from "+currentTimeStr+" ("+currentTime+") with query "+sql);
			
			SQLQuery query = session.createSQLQuery(sql);

			query.addScalar("COUNT_VALUE", Type.INTEGER);
			
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			
			Iterator<Integer> itr = query.list().iterator();

			if (itr.hasNext()) {
				result = itr.next();
			}
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHOffer> getOfferByCategories(E_OfferStatus status, String categories, int from, int to)
			throws SystemException {
		List<AHOffer> result = null;

		Session session = null;

		try {
			long currentTime = CustomServiceUtils.time();
			//String currentTimeStr = CustomServiceHandler.formatZoneDateTime(currentTime);
			
			session = openSession();
			
			//String sql = CustomSQLUtil.get(getOfferByCategories);
			String sql = StringUtil.replace(getOfferByCategory, "[$ITEM_IDS$]", categories);
			//m_objLog.info("SQL: "+sql);
			//m_objLog.trace("Listing offers from "+currentTimeStr+" ("+currentTime+") with sql "+sql);

			
			SQLQuery query = session.createSQLQuery(sql);
			
			query.addEntity("AHOffer", AHOfferImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(status.getIntValue());
			qPos.add(currentTime);
			qPos.add(currentTime);
			result = (List<AHOffer>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

	
	@Override
	public List<AHOffer> getOfferByCategories(E_OfferStatus status, String[] categories, int from, int to)
			throws SystemException {
		return getOfferByCategories(status, arrToStr(categories),from,to);
	}
	
	@Override
	public List<AHOffer> getOfferByCategories(E_OfferStatus status, Long[] categories, int from, int to)
			throws SystemException {
		return getOfferByCategories(status, arrToStr(categories),from,to);
	}
	
	@Override
	public Integer countOfferByCategories(E_OfferStatus status, Long[] categories)
			throws SystemException {
		return countOfferByCategories(status, arrToStr(categories));
	}
	
	@Override
	public List<AHOffer> getOfferByOfferTypes(E_OfferStatus status, int[] types, int from, int to)
			throws SystemException {
		return getOfferByOfferTypes(status, arrToStr(types),from,to);
	}
	
	@Override
	public Integer countOfferByOfferTypes(E_OfferStatus status, int[] types)
			throws SystemException {
		return countOfferByOfferTypes(status, arrToStr(types));
	}
	
	

	private String arrToStr(String[] categoryItems) {
		StringBuffer result = new StringBuffer();
		
		if (categoryItems != null && categoryItems.length > 0) {
			int i = 0;
			String item;
			for (;i<categoryItems.length;i++) {
				item = categoryItems[i];
				
				if (item != null && item.trim().length() > 0) {
					//m_objLog.info("Adding first category item "+i+": "+item);
					result.append(item);
					break;
				}
			}
			
			for (;i<categoryItems.length; i++) {
				item = categoryItems[i];
				if (item != null && item.trim().length() > 0) {
					//m_objLog.info("Adding category item "+i+": "+item);
					result.append(",").append(item);
				}
			}
				
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

}
