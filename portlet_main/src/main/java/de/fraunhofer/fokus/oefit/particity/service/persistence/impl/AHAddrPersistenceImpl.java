/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.fraunhofer.fokus.oefit.particity.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.fraunhofer.fokus.oefit.particity.exception.NoSuchAHAddrException;
import de.fraunhofer.fokus.oefit.particity.model.AHAddr;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHAddrPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the a h addr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHAddrPersistence
 * @see de.fraunhofer.fokus.oefit.particity.service.persistence.AHAddrUtil
 * @generated
 */
@ProviderType
public class AHAddrPersistenceImpl extends BasePersistenceImpl<AHAddr>
	implements AHAddrPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AHAddrUtil} to access the a h addr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AHAddrImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrModelImpl.FINDER_CACHE_ENABLED, AHAddrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrModelImpl.FINDER_CACHE_ENABLED, AHAddrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGION = new FinderPath(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrModelImpl.FINDER_CACHE_ENABLED, AHAddrImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByregion",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION =
		new FinderPath(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrModelImpl.FINDER_CACHE_ENABLED, AHAddrImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByregion",
			new String[] { Long.class.getName() },
			AHAddrModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGION = new FinderPath(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByregion",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a h addrs where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching a h addrs
	 */
	@Override
	public List<AHAddr> findByregion(long regionId) {
		return findByregion(regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h addrs where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of a h addrs
	 * @param end the upper bound of the range of a h addrs (not inclusive)
	 * @return the range of matching a h addrs
	 */
	@Override
	public List<AHAddr> findByregion(long regionId, int start, int end) {
		return findByregion(regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h addrs where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of a h addrs
	 * @param end the upper bound of the range of a h addrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h addrs
	 */
	@Override
	public List<AHAddr> findByregion(long regionId, int start, int end,
		OrderByComparator<AHAddr> orderByComparator) {
		return findByregion(regionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h addrs where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of a h addrs
	 * @param end the upper bound of the range of a h addrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h addrs
	 */
	@Override
	public List<AHAddr> findByregion(long regionId, int start, int end,
		OrderByComparator<AHAddr> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION;
			finderArgs = new Object[] { regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGION;
			finderArgs = new Object[] { regionId, start, end, orderByComparator };
		}

		List<AHAddr> list = null;

		if (retrieveFromCache) {
			list = (List<AHAddr>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (AHAddr ahAddr : list) {
					if ((regionId != ahAddr.getRegionId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AHADDR_WHERE);

			query.append(_FINDER_COLUMN_REGION_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHAddrModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<AHAddr>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHAddr>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first a h addr in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h addr
	 * @throws NoSuchAHAddrException if a matching a h addr could not be found
	 */
	@Override
	public AHAddr findByregion_First(long regionId,
		OrderByComparator<AHAddr> orderByComparator)
		throws NoSuchAHAddrException {
		AHAddr ahAddr = fetchByregion_First(regionId, orderByComparator);

		if (ahAddr != null) {
			return ahAddr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHAddrException(msg.toString());
	}

	/**
	 * Returns the first a h addr in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h addr, or <code>null</code> if a matching a h addr could not be found
	 */
	@Override
	public AHAddr fetchByregion_First(long regionId,
		OrderByComparator<AHAddr> orderByComparator) {
		List<AHAddr> list = findByregion(regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h addr in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h addr
	 * @throws NoSuchAHAddrException if a matching a h addr could not be found
	 */
	@Override
	public AHAddr findByregion_Last(long regionId,
		OrderByComparator<AHAddr> orderByComparator)
		throws NoSuchAHAddrException {
		AHAddr ahAddr = fetchByregion_Last(regionId, orderByComparator);

		if (ahAddr != null) {
			return ahAddr;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHAddrException(msg.toString());
	}

	/**
	 * Returns the last a h addr in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h addr, or <code>null</code> if a matching a h addr could not be found
	 */
	@Override
	public AHAddr fetchByregion_Last(long regionId,
		OrderByComparator<AHAddr> orderByComparator) {
		int count = countByregion(regionId);

		if (count == 0) {
			return null;
		}

		List<AHAddr> list = findByregion(regionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h addrs before and after the current a h addr in the ordered set where regionId = &#63;.
	 *
	 * @param addrId the primary key of the current a h addr
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h addr
	 * @throws NoSuchAHAddrException if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr[] findByregion_PrevAndNext(long addrId, long regionId,
		OrderByComparator<AHAddr> orderByComparator)
		throws NoSuchAHAddrException {
		AHAddr ahAddr = findByPrimaryKey(addrId);

		Session session = null;

		try {
			session = openSession();

			AHAddr[] array = new AHAddrImpl[3];

			array[0] = getByregion_PrevAndNext(session, ahAddr, regionId,
					orderByComparator, true);

			array[1] = ahAddr;

			array[2] = getByregion_PrevAndNext(session, ahAddr, regionId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AHAddr getByregion_PrevAndNext(Session session, AHAddr ahAddr,
		long regionId, OrderByComparator<AHAddr> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AHADDR_WHERE);

		query.append(_FINDER_COLUMN_REGION_REGIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AHAddrModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahAddr);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHAddr> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h addrs where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 */
	@Override
	public void removeByregion(long regionId) {
		for (AHAddr ahAddr : findByregion(regionId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ahAddr);
		}
	}

	/**
	 * Returns the number of a h addrs where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching a h addrs
	 */
	@Override
	public int countByregion(long regionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGION;

		Object[] finderArgs = new Object[] { regionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHADDR_WHERE);

			query.append(_FINDER_COLUMN_REGION_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REGION_REGIONID_2 = "ahAddr.regionId = ?";

	public AHAddrPersistenceImpl() {
		setModelClass(AHAddr.class);
	}

	/**
	 * Caches the a h addr in the entity cache if it is enabled.
	 *
	 * @param ahAddr the a h addr
	 */
	@Override
	public void cacheResult(AHAddr ahAddr) {
		entityCache.putResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrImpl.class, ahAddr.getPrimaryKey(), ahAddr);

		ahAddr.resetOriginalValues();
	}

	/**
	 * Caches the a h addrs in the entity cache if it is enabled.
	 *
	 * @param ahAddrs the a h addrs
	 */
	@Override
	public void cacheResult(List<AHAddr> ahAddrs) {
		for (AHAddr ahAddr : ahAddrs) {
			if (entityCache.getResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
						AHAddrImpl.class, ahAddr.getPrimaryKey()) == null) {
				cacheResult(ahAddr);
			}
			else {
				ahAddr.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a h addrs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AHAddrImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a h addr.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AHAddr ahAddr) {
		entityCache.removeResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrImpl.class, ahAddr.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AHAddr> ahAddrs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AHAddr ahAddr : ahAddrs) {
			entityCache.removeResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
				AHAddrImpl.class, ahAddr.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a h addr with the primary key. Does not add the a h addr to the database.
	 *
	 * @param addrId the primary key for the new a h addr
	 * @return the new a h addr
	 */
	@Override
	public AHAddr create(long addrId) {
		AHAddr ahAddr = new AHAddrImpl();

		ahAddr.setNew(true);
		ahAddr.setPrimaryKey(addrId);

		return ahAddr;
	}

	/**
	 * Removes the a h addr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addrId the primary key of the a h addr
	 * @return the a h addr that was removed
	 * @throws NoSuchAHAddrException if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr remove(long addrId) throws NoSuchAHAddrException {
		return remove((Serializable)addrId);
	}

	/**
	 * Removes the a h addr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a h addr
	 * @return the a h addr that was removed
	 * @throws NoSuchAHAddrException if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr remove(Serializable primaryKey) throws NoSuchAHAddrException {
		Session session = null;

		try {
			session = openSession();

			AHAddr ahAddr = (AHAddr)session.get(AHAddrImpl.class, primaryKey);

			if (ahAddr == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAHAddrException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ahAddr);
		}
		catch (NoSuchAHAddrException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AHAddr removeImpl(AHAddr ahAddr) {
		ahAddr = toUnwrappedModel(ahAddr);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ahAddr)) {
				ahAddr = (AHAddr)session.get(AHAddrImpl.class,
						ahAddr.getPrimaryKeyObj());
			}

			if (ahAddr != null) {
				session.delete(ahAddr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ahAddr != null) {
			clearCache(ahAddr);
		}

		return ahAddr;
	}

	@Override
	public AHAddr updateImpl(AHAddr ahAddr) {
		ahAddr = toUnwrappedModel(ahAddr);

		boolean isNew = ahAddr.isNew();

		AHAddrModelImpl ahAddrModelImpl = (AHAddrModelImpl)ahAddr;

		Session session = null;

		try {
			session = openSession();

			if (ahAddr.isNew()) {
				session.save(ahAddr);

				ahAddr.setNew(false);
			}
			else {
				ahAddr = (AHAddr)session.merge(ahAddr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AHAddrModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ahAddrModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ahAddrModelImpl.getOriginalRegionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REGION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION,
					args);

				args = new Object[] { ahAddrModelImpl.getRegionId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REGION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION,
					args);
			}
		}

		entityCache.putResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
			AHAddrImpl.class, ahAddr.getPrimaryKey(), ahAddr, false);

		ahAddr.resetOriginalValues();

		return ahAddr;
	}

	protected AHAddr toUnwrappedModel(AHAddr ahAddr) {
		if (ahAddr instanceof AHAddrImpl) {
			return ahAddr;
		}

		AHAddrImpl ahAddrImpl = new AHAddrImpl();

		ahAddrImpl.setNew(ahAddr.isNew());
		ahAddrImpl.setPrimaryKey(ahAddr.getPrimaryKey());

		ahAddrImpl.setAddrId(ahAddr.getAddrId());
		ahAddrImpl.setStreet(ahAddr.getStreet());
		ahAddrImpl.setNumber(ahAddr.getNumber());
		ahAddrImpl.setCoordLat(ahAddr.getCoordLat());
		ahAddrImpl.setCoordLon(ahAddr.getCoordLon());
		ahAddrImpl.setRegionId(ahAddr.getRegionId());

		return ahAddrImpl;
	}

	/**
	 * Returns the a h addr with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h addr
	 * @return the a h addr
	 * @throws NoSuchAHAddrException if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAHAddrException {
		AHAddr ahAddr = fetchByPrimaryKey(primaryKey);

		if (ahAddr == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAHAddrException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ahAddr;
	}

	/**
	 * Returns the a h addr with the primary key or throws a {@link NoSuchAHAddrException} if it could not be found.
	 *
	 * @param addrId the primary key of the a h addr
	 * @return the a h addr
	 * @throws NoSuchAHAddrException if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr findByPrimaryKey(long addrId) throws NoSuchAHAddrException {
		return findByPrimaryKey((Serializable)addrId);
	}

	/**
	 * Returns the a h addr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h addr
	 * @return the a h addr, or <code>null</code> if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr fetchByPrimaryKey(Serializable primaryKey) {
		AHAddr ahAddr = (AHAddr)entityCache.getResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
				AHAddrImpl.class, primaryKey);

		if (ahAddr == _nullAHAddr) {
			return null;
		}

		if (ahAddr == null) {
			Session session = null;

			try {
				session = openSession();

				ahAddr = (AHAddr)session.get(AHAddrImpl.class, primaryKey);

				if (ahAddr != null) {
					cacheResult(ahAddr);
				}
				else {
					entityCache.putResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
						AHAddrImpl.class, primaryKey, _nullAHAddr);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
					AHAddrImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ahAddr;
	}

	/**
	 * Returns the a h addr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addrId the primary key of the a h addr
	 * @return the a h addr, or <code>null</code> if a a h addr with the primary key could not be found
	 */
	@Override
	public AHAddr fetchByPrimaryKey(long addrId) {
		return fetchByPrimaryKey((Serializable)addrId);
	}

	@Override
	public Map<Serializable, AHAddr> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AHAddr> map = new HashMap<Serializable, AHAddr>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AHAddr ahAddr = fetchByPrimaryKey(primaryKey);

			if (ahAddr != null) {
				map.put(primaryKey, ahAddr);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AHAddr ahAddr = (AHAddr)entityCache.getResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
					AHAddrImpl.class, primaryKey);

			if (ahAddr == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ahAddr);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AHADDR_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AHAddr ahAddr : (List<AHAddr>)q.list()) {
				map.put(ahAddr.getPrimaryKeyObj(), ahAddr);

				cacheResult(ahAddr);

				uncachedPrimaryKeys.remove(ahAddr.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AHAddrModelImpl.ENTITY_CACHE_ENABLED,
					AHAddrImpl.class, primaryKey, _nullAHAddr);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the a h addrs.
	 *
	 * @return the a h addrs
	 */
	@Override
	public List<AHAddr> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h addrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h addrs
	 * @param end the upper bound of the range of a h addrs (not inclusive)
	 * @return the range of a h addrs
	 */
	@Override
	public List<AHAddr> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h addrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h addrs
	 * @param end the upper bound of the range of a h addrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h addrs
	 */
	@Override
	public List<AHAddr> findAll(int start, int end,
		OrderByComparator<AHAddr> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h addrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h addrs
	 * @param end the upper bound of the range of a h addrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of a h addrs
	 */
	@Override
	public List<AHAddr> findAll(int start, int end,
		OrderByComparator<AHAddr> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AHAddr> list = null;

		if (retrieveFromCache) {
			list = (List<AHAddr>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AHADDR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AHADDR;

				if (pagination) {
					sql = sql.concat(AHAddrModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AHAddr>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHAddr>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the a h addrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AHAddr ahAddr : findAll()) {
			remove(ahAddr);
		}
	}

	/**
	 * Returns the number of a h addrs.
	 *
	 * @return the number of a h addrs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AHADDR);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AHAddrModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the a h addr persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AHAddrImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AHADDR = "SELECT ahAddr FROM AHAddr ahAddr";
	private static final String _SQL_SELECT_AHADDR_WHERE_PKS_IN = "SELECT ahAddr FROM AHAddr ahAddr WHERE addrId IN (";
	private static final String _SQL_SELECT_AHADDR_WHERE = "SELECT ahAddr FROM AHAddr ahAddr WHERE ";
	private static final String _SQL_COUNT_AHADDR = "SELECT COUNT(ahAddr) FROM AHAddr ahAddr";
	private static final String _SQL_COUNT_AHADDR_WHERE = "SELECT COUNT(ahAddr) FROM AHAddr ahAddr WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ahAddr.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHAddr exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHAddr exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AHAddrPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number"
			});
	private static final AHAddr _nullAHAddr = new AHAddrImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AHAddr> toCacheModel() {
				return _nullAHAddrCacheModel;
			}
		};

	private static final CacheModel<AHAddr> _nullAHAddrCacheModel = new CacheModel<AHAddr>() {
			@Override
			public AHAddr toEntityModel() {
				return _nullAHAddr;
			}
		};
}