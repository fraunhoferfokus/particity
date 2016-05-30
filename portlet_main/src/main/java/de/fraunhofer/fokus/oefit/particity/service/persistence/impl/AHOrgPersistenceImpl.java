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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.fraunhofer.fokus.oefit.particity.exception.NoSuchAHOrgException;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOrgPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the a h org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOrgPersistence
 * @see de.fraunhofer.fokus.oefit.particity.service.persistence.AHOrgUtil
 * @generated
 */
@ProviderType
public class AHOrgPersistenceImpl extends BasePersistenceImpl<AHOrg>
	implements AHOrgPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AHOrgUtil} to access the a h org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AHOrgImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
			new String[] { String.class.getName() },
			AHOrgModelImpl.NAME_COLUMN_BITMASK |
			AHOrgModelImpl.UPDATED_COLUMN_BITMASK |
			AHOrgModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the a h orgs where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching a h orgs
	 */
	@Override
	public List<AHOrg> findByname(String name) {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h orgs where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @return the range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findByname(String name, int start, int end) {
		return findByname(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h orgs where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findByname(String name, int start, int end,
		OrderByComparator<AHOrg> orderByComparator) {
		return findByname(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h orgs where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findByname(String name, int start, int end,
		OrderByComparator<AHOrg> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<AHOrg> list = null;

		if (retrieveFromCache) {
			list = (List<AHOrg>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (AHOrg ahOrg : list) {
					if (!Objects.equals(name, ahOrg.getName())) {
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

			query.append(_SQL_SELECT_AHORG_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first a h org in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h org
	 * @throws NoSuchAHOrgException if a matching a h org could not be found
	 */
	@Override
	public AHOrg findByname_First(String name,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchByname_First(name, orderByComparator);

		if (ahOrg != null) {
			return ahOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHOrgException(msg.toString());
	}

	/**
	 * Returns the first a h org in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
	 */
	@Override
	public AHOrg fetchByname_First(String name,
		OrderByComparator<AHOrg> orderByComparator) {
		List<AHOrg> list = findByname(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h org in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h org
	 * @throws NoSuchAHOrgException if a matching a h org could not be found
	 */
	@Override
	public AHOrg findByname_Last(String name,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchByname_Last(name, orderByComparator);

		if (ahOrg != null) {
			return ahOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHOrgException(msg.toString());
	}

	/**
	 * Returns the last a h org in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
	 */
	@Override
	public AHOrg fetchByname_Last(String name,
		OrderByComparator<AHOrg> orderByComparator) {
		int count = countByname(name);

		if (count == 0) {
			return null;
		}

		List<AHOrg> list = findByname(name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h orgs before and after the current a h org in the ordered set where name = &#63;.
	 *
	 * @param orgId the primary key of the current a h org
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h org
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg[] findByname_PrevAndNext(long orgId, String name,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = findByPrimaryKey(orgId);

		Session session = null;

		try {
			session = openSession();

			AHOrg[] array = new AHOrgImpl[3];

			array[0] = getByname_PrevAndNext(session, ahOrg, name,
					orderByComparator, true);

			array[1] = ahOrg;

			array[2] = getByname_PrevAndNext(session, ahOrg, name,
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

	protected AHOrg getByname_PrevAndNext(Session session, AHOrg ahOrg,
		String name, OrderByComparator<AHOrg> orderByComparator,
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

		query.append(_SQL_SELECT_AHORG_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(AHOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h orgs where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByname(String name) {
		for (AHOrg ahOrg : findByname(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ahOrg);
		}
	}

	/**
	 * Returns the number of a h orgs where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching a h orgs
	 */
	@Override
	public int countByname(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHORG_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "ahOrg.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "ahOrg.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(ahOrg.name IS NULL OR ahOrg.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNER = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByowner",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByowner",
			new String[] { String.class.getName() },
			AHOrgModelImpl.OWNER_COLUMN_BITMASK |
			AHOrgModelImpl.UPDATED_COLUMN_BITMASK |
			AHOrgModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OWNER = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByowner",
			new String[] { String.class.getName() });

	/**
	 * Returns all the a h orgs where owner = &#63;.
	 *
	 * @param owner the owner
	 * @return the matching a h orgs
	 */
	@Override
	public List<AHOrg> findByowner(String owner) {
		return findByowner(owner, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h orgs where owner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param owner the owner
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @return the range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findByowner(String owner, int start, int end) {
		return findByowner(owner, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h orgs where owner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param owner the owner
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findByowner(String owner, int start, int end,
		OrderByComparator<AHOrg> orderByComparator) {
		return findByowner(owner, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h orgs where owner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param owner the owner
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findByowner(String owner, int start, int end,
		OrderByComparator<AHOrg> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER;
			finderArgs = new Object[] { owner };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNER;
			finderArgs = new Object[] { owner, start, end, orderByComparator };
		}

		List<AHOrg> list = null;

		if (retrieveFromCache) {
			list = (List<AHOrg>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (AHOrg ahOrg : list) {
					if (!Objects.equals(owner, ahOrg.getOwner())) {
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

			query.append(_SQL_SELECT_AHORG_WHERE);

			boolean bindOwner = false;

			if (owner == null) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_1);
			}
			else if (owner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_3);
			}
			else {
				bindOwner = true;

				query.append(_FINDER_COLUMN_OWNER_OWNER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOwner) {
					qPos.add(owner);
				}

				if (!pagination) {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first a h org in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h org
	 * @throws NoSuchAHOrgException if a matching a h org could not be found
	 */
	@Override
	public AHOrg findByowner_First(String owner,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchByowner_First(owner, orderByComparator);

		if (ahOrg != null) {
			return ahOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("owner=");
		msg.append(owner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHOrgException(msg.toString());
	}

	/**
	 * Returns the first a h org in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
	 */
	@Override
	public AHOrg fetchByowner_First(String owner,
		OrderByComparator<AHOrg> orderByComparator) {
		List<AHOrg> list = findByowner(owner, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h org in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h org
	 * @throws NoSuchAHOrgException if a matching a h org could not be found
	 */
	@Override
	public AHOrg findByowner_Last(String owner,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchByowner_Last(owner, orderByComparator);

		if (ahOrg != null) {
			return ahOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("owner=");
		msg.append(owner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHOrgException(msg.toString());
	}

	/**
	 * Returns the last a h org in the ordered set where owner = &#63;.
	 *
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
	 */
	@Override
	public AHOrg fetchByowner_Last(String owner,
		OrderByComparator<AHOrg> orderByComparator) {
		int count = countByowner(owner);

		if (count == 0) {
			return null;
		}

		List<AHOrg> list = findByowner(owner, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h orgs before and after the current a h org in the ordered set where owner = &#63;.
	 *
	 * @param orgId the primary key of the current a h org
	 * @param owner the owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h org
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg[] findByowner_PrevAndNext(long orgId, String owner,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = findByPrimaryKey(orgId);

		Session session = null;

		try {
			session = openSession();

			AHOrg[] array = new AHOrgImpl[3];

			array[0] = getByowner_PrevAndNext(session, ahOrg, owner,
					orderByComparator, true);

			array[1] = ahOrg;

			array[2] = getByowner_PrevAndNext(session, ahOrg, owner,
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

	protected AHOrg getByowner_PrevAndNext(Session session, AHOrg ahOrg,
		String owner, OrderByComparator<AHOrg> orderByComparator,
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

		query.append(_SQL_SELECT_AHORG_WHERE);

		boolean bindOwner = false;

		if (owner == null) {
			query.append(_FINDER_COLUMN_OWNER_OWNER_1);
		}
		else if (owner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OWNER_OWNER_3);
		}
		else {
			bindOwner = true;

			query.append(_FINDER_COLUMN_OWNER_OWNER_2);
		}

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
			query.append(AHOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOwner) {
			qPos.add(owner);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h orgs where owner = &#63; from the database.
	 *
	 * @param owner the owner
	 */
	@Override
	public void removeByowner(String owner) {
		for (AHOrg ahOrg : findByowner(owner, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ahOrg);
		}
	}

	/**
	 * Returns the number of a h orgs where owner = &#63;.
	 *
	 * @param owner the owner
	 * @return the number of matching a h orgs
	 */
	@Override
	public int countByowner(String owner) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OWNER;

		Object[] finderArgs = new Object[] { owner };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHORG_WHERE);

			boolean bindOwner = false;

			if (owner == null) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_1);
			}
			else if (owner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OWNER_OWNER_3);
			}
			else {
				bindOwner = true;

				query.append(_FINDER_COLUMN_OWNER_OWNER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOwner) {
					qPos.add(owner);
				}

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

	private static final String _FINDER_COLUMN_OWNER_OWNER_1 = "ahOrg.owner IS NULL";
	private static final String _FINDER_COLUMN_OWNER_OWNER_2 = "ahOrg.owner = ?";
	private static final String _FINDER_COLUMN_OWNER_OWNER_3 = "(ahOrg.owner IS NULL OR ahOrg.owner = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, AHOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Integer.class.getName() },
			AHOrgModelImpl.STATUS_COLUMN_BITMASK |
			AHOrgModelImpl.UPDATED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the a h orgs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching a h orgs
	 */
	@Override
	public List<AHOrg> findBystatus(int status) {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h orgs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @return the range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findBystatus(int status, int start, int end) {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h orgs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findBystatus(int status, int start, int end,
		OrderByComparator<AHOrg> orderByComparator) {
		return findBystatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h orgs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h orgs
	 */
	@Override
	public List<AHOrg> findBystatus(int status, int start, int end,
		OrderByComparator<AHOrg> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<AHOrg> list = null;

		if (retrieveFromCache) {
			list = (List<AHOrg>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (AHOrg ahOrg : list) {
					if ((status != ahOrg.getStatus())) {
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

			query.append(_SQL_SELECT_AHORG_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first a h org in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h org
	 * @throws NoSuchAHOrgException if a matching a h org could not be found
	 */
	@Override
	public AHOrg findBystatus_First(int status,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchBystatus_First(status, orderByComparator);

		if (ahOrg != null) {
			return ahOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHOrgException(msg.toString());
	}

	/**
	 * Returns the first a h org in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
	 */
	@Override
	public AHOrg fetchBystatus_First(int status,
		OrderByComparator<AHOrg> orderByComparator) {
		List<AHOrg> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h org in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h org
	 * @throws NoSuchAHOrgException if a matching a h org could not be found
	 */
	@Override
	public AHOrg findBystatus_Last(int status,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchBystatus_Last(status, orderByComparator);

		if (ahOrg != null) {
			return ahOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHOrgException(msg.toString());
	}

	/**
	 * Returns the last a h org in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
	 */
	@Override
	public AHOrg fetchBystatus_Last(int status,
		OrderByComparator<AHOrg> orderByComparator) {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<AHOrg> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h orgs before and after the current a h org in the ordered set where status = &#63;.
	 *
	 * @param orgId the primary key of the current a h org
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h org
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg[] findBystatus_PrevAndNext(long orgId, int status,
		OrderByComparator<AHOrg> orderByComparator) throws NoSuchAHOrgException {
		AHOrg ahOrg = findByPrimaryKey(orgId);

		Session session = null;

		try {
			session = openSession();

			AHOrg[] array = new AHOrgImpl[3];

			array[0] = getBystatus_PrevAndNext(session, ahOrg, status,
					orderByComparator, true);

			array[1] = ahOrg;

			array[2] = getBystatus_PrevAndNext(session, ahOrg, status,
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

	protected AHOrg getBystatus_PrevAndNext(Session session, AHOrg ahOrg,
		int status, OrderByComparator<AHOrg> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AHORG_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(AHOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h orgs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBystatus(int status) {
		for (AHOrg ahOrg : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ahOrg);
		}
	}

	/**
	 * Returns the number of a h orgs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching a h orgs
	 */
	@Override
	public int countBystatus(int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHORG_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "ahOrg.status = ?";

	public AHOrgPersistenceImpl() {
		setModelClass(AHOrg.class);
	}

	/**
	 * Caches the a h org in the entity cache if it is enabled.
	 *
	 * @param ahOrg the a h org
	 */
	@Override
	public void cacheResult(AHOrg ahOrg) {
		entityCache.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgImpl.class, ahOrg.getPrimaryKey(), ahOrg);

		ahOrg.resetOriginalValues();
	}

	/**
	 * Caches the a h orgs in the entity cache if it is enabled.
	 *
	 * @param ahOrgs the a h orgs
	 */
	@Override
	public void cacheResult(List<AHOrg> ahOrgs) {
		for (AHOrg ahOrg : ahOrgs) {
			if (entityCache.getResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
						AHOrgImpl.class, ahOrg.getPrimaryKey()) == null) {
				cacheResult(ahOrg);
			}
			else {
				ahOrg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a h orgs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AHOrgImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a h org.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AHOrg ahOrg) {
		entityCache.removeResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgImpl.class, ahOrg.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AHOrg> ahOrgs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AHOrg ahOrg : ahOrgs) {
			entityCache.removeResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
				AHOrgImpl.class, ahOrg.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a h org with the primary key. Does not add the a h org to the database.
	 *
	 * @param orgId the primary key for the new a h org
	 * @return the new a h org
	 */
	@Override
	public AHOrg create(long orgId) {
		AHOrg ahOrg = new AHOrgImpl();

		ahOrg.setNew(true);
		ahOrg.setPrimaryKey(orgId);

		return ahOrg;
	}

	/**
	 * Removes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgId the primary key of the a h org
	 * @return the a h org that was removed
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg remove(long orgId) throws NoSuchAHOrgException {
		return remove((Serializable)orgId);
	}

	/**
	 * Removes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a h org
	 * @return the a h org that was removed
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg remove(Serializable primaryKey) throws NoSuchAHOrgException {
		Session session = null;

		try {
			session = openSession();

			AHOrg ahOrg = (AHOrg)session.get(AHOrgImpl.class, primaryKey);

			if (ahOrg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAHOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ahOrg);
		}
		catch (NoSuchAHOrgException nsee) {
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
	protected AHOrg removeImpl(AHOrg ahOrg) {
		ahOrg = toUnwrappedModel(ahOrg);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ahOrg)) {
				ahOrg = (AHOrg)session.get(AHOrgImpl.class,
						ahOrg.getPrimaryKeyObj());
			}

			if (ahOrg != null) {
				session.delete(ahOrg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ahOrg != null) {
			clearCache(ahOrg);
		}

		return ahOrg;
	}

	@Override
	public AHOrg updateImpl(AHOrg ahOrg) {
		ahOrg = toUnwrappedModel(ahOrg);

		boolean isNew = ahOrg.isNew();

		AHOrgModelImpl ahOrgModelImpl = (AHOrgModelImpl)ahOrg;

		Session session = null;

		try {
			session = openSession();

			if (ahOrg.isNew()) {
				session.save(ahOrg);

				ahOrg.setNew(false);
			}
			else {
				ahOrg = (AHOrg)session.merge(ahOrg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AHOrgModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ahOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { ahOrgModelImpl.getOriginalName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { ahOrgModelImpl.getName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((ahOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { ahOrgModelImpl.getOriginalOwner() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OWNER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER,
					args);

				args = new Object[] { ahOrgModelImpl.getOwner() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OWNER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER,
					args);
			}

			if ((ahOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { ahOrgModelImpl.getOriginalStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { ahOrgModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
			AHOrgImpl.class, ahOrg.getPrimaryKey(), ahOrg, false);

		ahOrg.resetOriginalValues();

		return ahOrg;
	}

	protected AHOrg toUnwrappedModel(AHOrg ahOrg) {
		if (ahOrg instanceof AHOrgImpl) {
			return ahOrg;
		}

		AHOrgImpl ahOrgImpl = new AHOrgImpl();

		ahOrgImpl.setNew(ahOrg.isNew());
		ahOrgImpl.setPrimaryKey(ahOrg.getPrimaryKey());

		ahOrgImpl.setOrgId(ahOrg.getOrgId());
		ahOrgImpl.setName(ahOrg.getName());
		ahOrgImpl.setHolder(ahOrg.getHolder());
		ahOrgImpl.setOwner(ahOrg.getOwner());
		ahOrgImpl.setUserlist(ahOrg.getUserlist());
		ahOrgImpl.setDescription(ahOrg.getDescription());
		ahOrgImpl.setLegalStatus(ahOrg.getLegalStatus());
		ahOrgImpl.setCreated(ahOrg.getCreated());
		ahOrgImpl.setUpdated(ahOrg.getUpdated());
		ahOrgImpl.setContactId(ahOrg.getContactId());
		ahOrgImpl.setAddressId(ahOrg.getAddressId());
		ahOrgImpl.setStatus(ahOrg.getStatus());
		ahOrgImpl.setLogoLocation(ahOrg.getLogoLocation());

		return ahOrgImpl;
	}

	/**
	 * Returns the a h org with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h org
	 * @return the a h org
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAHOrgException {
		AHOrg ahOrg = fetchByPrimaryKey(primaryKey);

		if (ahOrg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAHOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ahOrg;
	}

	/**
	 * Returns the a h org with the primary key or throws a {@link NoSuchAHOrgException} if it could not be found.
	 *
	 * @param orgId the primary key of the a h org
	 * @return the a h org
	 * @throws NoSuchAHOrgException if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg findByPrimaryKey(long orgId) throws NoSuchAHOrgException {
		return findByPrimaryKey((Serializable)orgId);
	}

	/**
	 * Returns the a h org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h org
	 * @return the a h org, or <code>null</code> if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg fetchByPrimaryKey(Serializable primaryKey) {
		AHOrg ahOrg = (AHOrg)entityCache.getResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
				AHOrgImpl.class, primaryKey);

		if (ahOrg == _nullAHOrg) {
			return null;
		}

		if (ahOrg == null) {
			Session session = null;

			try {
				session = openSession();

				ahOrg = (AHOrg)session.get(AHOrgImpl.class, primaryKey);

				if (ahOrg != null) {
					cacheResult(ahOrg);
				}
				else {
					entityCache.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
						AHOrgImpl.class, primaryKey, _nullAHOrg);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
					AHOrgImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ahOrg;
	}

	/**
	 * Returns the a h org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orgId the primary key of the a h org
	 * @return the a h org, or <code>null</code> if a a h org with the primary key could not be found
	 */
	@Override
	public AHOrg fetchByPrimaryKey(long orgId) {
		return fetchByPrimaryKey((Serializable)orgId);
	}

	@Override
	public Map<Serializable, AHOrg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AHOrg> map = new HashMap<Serializable, AHOrg>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AHOrg ahOrg = fetchByPrimaryKey(primaryKey);

			if (ahOrg != null) {
				map.put(primaryKey, ahOrg);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AHOrg ahOrg = (AHOrg)entityCache.getResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
					AHOrgImpl.class, primaryKey);

			if (ahOrg == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ahOrg);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AHORG_WHERE_PKS_IN);

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

			for (AHOrg ahOrg : (List<AHOrg>)q.list()) {
				map.put(ahOrg.getPrimaryKeyObj(), ahOrg);

				cacheResult(ahOrg);

				uncachedPrimaryKeys.remove(ahOrg.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
					AHOrgImpl.class, primaryKey, _nullAHOrg);
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
	 * Returns all the a h orgs.
	 *
	 * @return the a h orgs
	 */
	@Override
	public List<AHOrg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @return the range of a h orgs
	 */
	@Override
	public List<AHOrg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h orgs
	 */
	@Override
	public List<AHOrg> findAll(int start, int end,
		OrderByComparator<AHOrg> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h orgs
	 * @param end the upper bound of the range of a h orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of a h orgs
	 */
	@Override
	public List<AHOrg> findAll(int start, int end,
		OrderByComparator<AHOrg> orderByComparator, boolean retrieveFromCache) {
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

		List<AHOrg> list = null;

		if (retrieveFromCache) {
			list = (List<AHOrg>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AHORG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AHORG;

				if (pagination) {
					sql = sql.concat(AHOrgModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHOrg>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the a h orgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AHOrg ahOrg : findAll()) {
			remove(ahOrg);
		}
	}

	/**
	 * Returns the number of a h orgs.
	 *
	 * @return the number of a h orgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AHORG);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return AHOrgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the a h org persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AHOrgImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AHORG = "SELECT ahOrg FROM AHOrg ahOrg";
	private static final String _SQL_SELECT_AHORG_WHERE_PKS_IN = "SELECT ahOrg FROM AHOrg ahOrg WHERE orgId IN (";
	private static final String _SQL_SELECT_AHORG_WHERE = "SELECT ahOrg FROM AHOrg ahOrg WHERE ";
	private static final String _SQL_COUNT_AHORG = "SELECT COUNT(ahOrg) FROM AHOrg ahOrg";
	private static final String _SQL_COUNT_AHORG_WHERE = "SELECT COUNT(ahOrg) FROM AHOrg ahOrg WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ahOrg.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHOrg exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHOrg exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AHOrgPersistenceImpl.class);
	private static final AHOrg _nullAHOrg = new AHOrgImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AHOrg> toCacheModel() {
				return _nullAHOrgCacheModel;
			}
		};

	private static final CacheModel<AHOrg> _nullAHOrgCacheModel = new CacheModel<AHOrg>() {
			@Override
			public AHOrg toEntityModel() {
				return _nullAHOrg;
			}
		};
}