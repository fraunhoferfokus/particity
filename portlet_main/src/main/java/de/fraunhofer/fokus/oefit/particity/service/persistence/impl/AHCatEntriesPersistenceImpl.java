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

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.fraunhofer.fokus.oefit.particity.exception.NoSuchAHCatEntriesException;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHSubscriptionPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the a h cat entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntriesPersistence
 * @see de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesUtil
 * @generated
 */
@ProviderType
public class AHCatEntriesPersistenceImpl extends BasePersistenceImpl<AHCatEntries>
	implements AHCatEntriesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AHCatEntriesUtil} to access the a h cat entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AHCatEntriesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycat",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycat",
			new String[] { Long.class.getName() },
			AHCatEntriesModelImpl.CATID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAT = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycat",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a h cat entrieses where catId = &#63;.
	 *
	 * @param catId the cat ID
	 * @return the matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findBycat(long catId) {
		return findBycat(catId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h cat entrieses where catId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catId the cat ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @return the range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findBycat(long catId, int start, int end) {
		return findBycat(catId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses where catId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catId the cat ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findBycat(long catId, int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator) {
		return findBycat(catId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses where catId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param catId the cat ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findBycat(long catId, int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT;
			finderArgs = new Object[] { catId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT;
			finderArgs = new Object[] { catId, start, end, orderByComparator };
		}

		List<AHCatEntries> list = null;

		if (retrieveFromCache) {
			list = (List<AHCatEntries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AHCatEntries ahCatEntries : list) {
					if ((catId != ahCatEntries.getCatId())) {
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

			query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

			query.append(_FINDER_COLUMN_CAT_CATID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHCatEntriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catId);

				if (!pagination) {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first a h cat entries in the ordered set where catId = &#63;.
	 *
	 * @param catId the cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h cat entries
	 * @throws NoSuchAHCatEntriesException if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries findBycat_First(long catId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchBycat_First(catId, orderByComparator);

		if (ahCatEntries != null) {
			return ahCatEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catId=");
		msg.append(catId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHCatEntriesException(msg.toString());
	}

	/**
	 * Returns the first a h cat entries in the ordered set where catId = &#63;.
	 *
	 * @param catId the cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries fetchBycat_First(long catId,
		OrderByComparator<AHCatEntries> orderByComparator) {
		List<AHCatEntries> list = findBycat(catId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h cat entries in the ordered set where catId = &#63;.
	 *
	 * @param catId the cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h cat entries
	 * @throws NoSuchAHCatEntriesException if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries findBycat_Last(long catId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchBycat_Last(catId, orderByComparator);

		if (ahCatEntries != null) {
			return ahCatEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("catId=");
		msg.append(catId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHCatEntriesException(msg.toString());
	}

	/**
	 * Returns the last a h cat entries in the ordered set where catId = &#63;.
	 *
	 * @param catId the cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries fetchBycat_Last(long catId,
		OrderByComparator<AHCatEntries> orderByComparator) {
		int count = countBycat(catId);

		if (count == 0) {
			return null;
		}

		List<AHCatEntries> list = findBycat(catId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h cat entrieses before and after the current a h cat entries in the ordered set where catId = &#63;.
	 *
	 * @param itemId the primary key of the current a h cat entries
	 * @param catId the cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h cat entries
	 * @throws NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries[] findBycat_PrevAndNext(long itemId, long catId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			AHCatEntries[] array = new AHCatEntriesImpl[3];

			array[0] = getBycat_PrevAndNext(session, ahCatEntries, catId,
					orderByComparator, true);

			array[1] = ahCatEntries;

			array[2] = getBycat_PrevAndNext(session, ahCatEntries, catId,
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

	protected AHCatEntries getBycat_PrevAndNext(Session session,
		AHCatEntries ahCatEntries, long catId,
		OrderByComparator<AHCatEntries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

		query.append(_FINDER_COLUMN_CAT_CATID_2);

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
			query.append(AHCatEntriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(catId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahCatEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHCatEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h cat entrieses where catId = &#63; from the database.
	 *
	 * @param catId the cat ID
	 */
	@Override
	public void removeBycat(long catId) {
		for (AHCatEntries ahCatEntries : findBycat(catId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ahCatEntries);
		}
	}

	/**
	 * Returns the number of a h cat entrieses where catId = &#63;.
	 *
	 * @param catId the cat ID
	 * @return the number of matching a h cat entrieses
	 */
	@Override
	public int countBycat(long catId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAT;

		Object[] finderArgs = new Object[] { catId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHCATENTRIES_WHERE);

			query.append(_FINDER_COLUMN_CAT_CATID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(catId);

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

	private static final String _FINDER_COLUMN_CAT_CATID_2 = "ahCatEntries.catId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparent",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparent",
			new String[] { Long.class.getName() },
			AHCatEntriesModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByparent",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a h cat entrieses where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByparent(long parentId) {
		return findByparent(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h cat entrieses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @return the range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByparent(long parentId, int start, int end) {
		return findByparent(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByparent(long parentId, int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator) {
		return findByparent(parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByparent(long parentId, int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<AHCatEntries> list = null;

		if (retrieveFromCache) {
			list = (List<AHCatEntries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AHCatEntries ahCatEntries : list) {
					if ((parentId != ahCatEntries.getParentId())) {
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

			query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHCatEntriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first a h cat entries in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h cat entries
	 * @throws NoSuchAHCatEntriesException if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries findByparent_First(long parentId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchByparent_First(parentId,
				orderByComparator);

		if (ahCatEntries != null) {
			return ahCatEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHCatEntriesException(msg.toString());
	}

	/**
	 * Returns the first a h cat entries in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries fetchByparent_First(long parentId,
		OrderByComparator<AHCatEntries> orderByComparator) {
		List<AHCatEntries> list = findByparent(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h cat entries in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h cat entries
	 * @throws NoSuchAHCatEntriesException if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries findByparent_Last(long parentId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchByparent_Last(parentId,
				orderByComparator);

		if (ahCatEntries != null) {
			return ahCatEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHCatEntriesException(msg.toString());
	}

	/**
	 * Returns the last a h cat entries in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries fetchByparent_Last(long parentId,
		OrderByComparator<AHCatEntries> orderByComparator) {
		int count = countByparent(parentId);

		if (count == 0) {
			return null;
		}

		List<AHCatEntries> list = findByparent(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h cat entrieses before and after the current a h cat entries in the ordered set where parentId = &#63;.
	 *
	 * @param itemId the primary key of the current a h cat entries
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h cat entries
	 * @throws NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries[] findByparent_PrevAndNext(long itemId, long parentId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			AHCatEntries[] array = new AHCatEntriesImpl[3];

			array[0] = getByparent_PrevAndNext(session, ahCatEntries, parentId,
					orderByComparator, true);

			array[1] = ahCatEntries;

			array[2] = getByparent_PrevAndNext(session, ahCatEntries, parentId,
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

	protected AHCatEntries getByparent_PrevAndNext(Session session,
		AHCatEntries ahCatEntries, long parentId,
		OrderByComparator<AHCatEntries> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

		query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

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
			query.append(AHCatEntriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahCatEntries);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHCatEntries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h cat entrieses where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByparent(long parentId) {
		for (AHCatEntries ahCatEntries : findByparent(parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ahCatEntries);
		}
	}

	/**
	 * Returns the number of a h cat entrieses where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching a h cat entrieses
	 */
	@Override
	public int countByparent(long parentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENT;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHCATENTRIES_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 = "ahCatEntries.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEM = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByitem",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, AHCatEntriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByitem",
			new String[] { Long.class.getName() },
			AHCatEntriesModelImpl.ITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ITEM = new FinderPath(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByitem",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the a h cat entrieses where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByitem(long itemId) {
		return findByitem(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h cat entrieses where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @return the range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByitem(long itemId, int start, int end) {
		return findByitem(itemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByitem(long itemId, int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator) {
		return findByitem(itemId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses where itemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemId the item ID
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findByitem(long itemId, int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM;
			finderArgs = new Object[] { itemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEM;
			finderArgs = new Object[] { itemId, start, end, orderByComparator };
		}

		List<AHCatEntries> list = null;

		if (retrieveFromCache) {
			list = (List<AHCatEntries>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AHCatEntries ahCatEntries : list) {
					if ((itemId != ahCatEntries.getItemId())) {
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

			query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

			query.append(_FINDER_COLUMN_ITEM_ITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHCatEntriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

				if (!pagination) {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first a h cat entries in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h cat entries
	 * @throws NoSuchAHCatEntriesException if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries findByitem_First(long itemId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchByitem_First(itemId, orderByComparator);

		if (ahCatEntries != null) {
			return ahCatEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHCatEntriesException(msg.toString());
	}

	/**
	 * Returns the first a h cat entries in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries fetchByitem_First(long itemId,
		OrderByComparator<AHCatEntries> orderByComparator) {
		List<AHCatEntries> list = findByitem(itemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h cat entries in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h cat entries
	 * @throws NoSuchAHCatEntriesException if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries findByitem_Last(long itemId,
		OrderByComparator<AHCatEntries> orderByComparator)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchByitem_Last(itemId, orderByComparator);

		if (ahCatEntries != null) {
			return ahCatEntries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemId=");
		msg.append(itemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHCatEntriesException(msg.toString());
	}

	/**
	 * Returns the last a h cat entries in the ordered set where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
	 */
	@Override
	public AHCatEntries fetchByitem_Last(long itemId,
		OrderByComparator<AHCatEntries> orderByComparator) {
		int count = countByitem(itemId);

		if (count == 0) {
			return null;
		}

		List<AHCatEntries> list = findByitem(itemId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the a h cat entrieses where itemId = &#63; from the database.
	 *
	 * @param itemId the item ID
	 */
	@Override
	public void removeByitem(long itemId) {
		for (AHCatEntries ahCatEntries : findByitem(itemId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ahCatEntries);
		}
	}

	/**
	 * Returns the number of a h cat entrieses where itemId = &#63;.
	 *
	 * @param itemId the item ID
	 * @return the number of matching a h cat entrieses
	 */
	@Override
	public int countByitem(long itemId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEM;

		Object[] finderArgs = new Object[] { itemId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHCATENTRIES_WHERE);

			query.append(_FINDER_COLUMN_ITEM_ITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemId);

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

	private static final String _FINDER_COLUMN_ITEM_ITEMID_2 = "ahCatEntries.itemId = ?";

	public AHCatEntriesPersistenceImpl() {
		setModelClass(AHCatEntries.class);
	}

	/**
	 * Caches the a h cat entries in the entity cache if it is enabled.
	 *
	 * @param ahCatEntries the a h cat entries
	 */
	@Override
	public void cacheResult(AHCatEntries ahCatEntries) {
		entityCache.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey(), ahCatEntries);

		ahCatEntries.resetOriginalValues();
	}

	/**
	 * Caches the a h cat entrieses in the entity cache if it is enabled.
	 *
	 * @param ahCatEntrieses the a h cat entrieses
	 */
	@Override
	public void cacheResult(List<AHCatEntries> ahCatEntrieses) {
		for (AHCatEntries ahCatEntries : ahCatEntrieses) {
			if (entityCache.getResult(
						AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
						AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey()) == null) {
				cacheResult(ahCatEntries);
			}
			else {
				ahCatEntries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a h cat entrieses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AHCatEntriesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a h cat entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AHCatEntries ahCatEntries) {
		entityCache.removeResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AHCatEntries> ahCatEntrieses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AHCatEntries ahCatEntries : ahCatEntrieses) {
			entityCache.removeResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
				AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a h cat entries with the primary key. Does not add the a h cat entries to the database.
	 *
	 * @param itemId the primary key for the new a h cat entries
	 * @return the new a h cat entries
	 */
	@Override
	public AHCatEntries create(long itemId) {
		AHCatEntries ahCatEntries = new AHCatEntriesImpl();

		ahCatEntries.setNew(true);
		ahCatEntries.setPrimaryKey(itemId);

		return ahCatEntries;
	}

	/**
	 * Removes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the a h cat entries
	 * @return the a h cat entries that was removed
	 * @throws NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries remove(long itemId) throws NoSuchAHCatEntriesException {
		return remove((Serializable)itemId);
	}

	/**
	 * Removes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a h cat entries
	 * @return the a h cat entries that was removed
	 * @throws NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries remove(Serializable primaryKey)
		throws NoSuchAHCatEntriesException {
		Session session = null;

		try {
			session = openSession();

			AHCatEntries ahCatEntries = (AHCatEntries)session.get(AHCatEntriesImpl.class,
					primaryKey);

			if (ahCatEntries == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAHCatEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ahCatEntries);
		}
		catch (NoSuchAHCatEntriesException nsee) {
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
	protected AHCatEntries removeImpl(AHCatEntries ahCatEntries) {
		ahCatEntries = toUnwrappedModel(ahCatEntries);

		ahCatEntriesToAHSubscriptionTableMapper.deleteLeftPrimaryKeyTableMappings(ahCatEntries.getPrimaryKey());

		ahCatEntriesToAHOfferTableMapper.deleteLeftPrimaryKeyTableMappings(ahCatEntries.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ahCatEntries)) {
				ahCatEntries = (AHCatEntries)session.get(AHCatEntriesImpl.class,
						ahCatEntries.getPrimaryKeyObj());
			}

			if (ahCatEntries != null) {
				session.delete(ahCatEntries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ahCatEntries != null) {
			clearCache(ahCatEntries);
		}

		return ahCatEntries;
	}

	@Override
	public AHCatEntries updateImpl(AHCatEntries ahCatEntries) {
		ahCatEntries = toUnwrappedModel(ahCatEntries);

		boolean isNew = ahCatEntries.isNew();

		AHCatEntriesModelImpl ahCatEntriesModelImpl = (AHCatEntriesModelImpl)ahCatEntries;

		Session session = null;

		try {
			session = openSession();

			if (ahCatEntries.isNew()) {
				session.save(ahCatEntries);

				ahCatEntries.setNew(false);
			}
			else {
				ahCatEntries = (AHCatEntries)session.merge(ahCatEntries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AHCatEntriesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ahCatEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ahCatEntriesModelImpl.getOriginalCatId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT,
					args);

				args = new Object[] { ahCatEntriesModelImpl.getCatId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT,
					args);
			}

			if ((ahCatEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ahCatEntriesModelImpl.getOriginalParentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] { ahCatEntriesModelImpl.getParentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}

			if ((ahCatEntriesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ahCatEntriesModelImpl.getOriginalItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM,
					args);

				args = new Object[] { ahCatEntriesModelImpl.getItemId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ITEM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM,
					args);
			}
		}

		entityCache.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
			AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey(), ahCatEntries,
			false);

		ahCatEntries.resetOriginalValues();

		return ahCatEntries;
	}

	protected AHCatEntries toUnwrappedModel(AHCatEntries ahCatEntries) {
		if (ahCatEntries instanceof AHCatEntriesImpl) {
			return ahCatEntries;
		}

		AHCatEntriesImpl ahCatEntriesImpl = new AHCatEntriesImpl();

		ahCatEntriesImpl.setNew(ahCatEntries.isNew());
		ahCatEntriesImpl.setPrimaryKey(ahCatEntries.getPrimaryKey());

		ahCatEntriesImpl.setItemId(ahCatEntries.getItemId());
		ahCatEntriesImpl.setCatId(ahCatEntries.getCatId());
		ahCatEntriesImpl.setName(ahCatEntries.getName());
		ahCatEntriesImpl.setDescr(ahCatEntries.getDescr());
		ahCatEntriesImpl.setParentId(ahCatEntries.getParentId());

		return ahCatEntriesImpl;
	}

	/**
	 * Returns the a h cat entries with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h cat entries
	 * @return the a h cat entries
	 * @throws NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAHCatEntriesException {
		AHCatEntries ahCatEntries = fetchByPrimaryKey(primaryKey);

		if (ahCatEntries == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAHCatEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ahCatEntries;
	}

	/**
	 * Returns the a h cat entries with the primary key or throws a {@link NoSuchAHCatEntriesException} if it could not be found.
	 *
	 * @param itemId the primary key of the a h cat entries
	 * @return the a h cat entries
	 * @throws NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries findByPrimaryKey(long itemId)
		throws NoSuchAHCatEntriesException {
		return findByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns the a h cat entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h cat entries
	 * @return the a h cat entries, or <code>null</code> if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries fetchByPrimaryKey(Serializable primaryKey) {
		AHCatEntries ahCatEntries = (AHCatEntries)entityCache.getResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
				AHCatEntriesImpl.class, primaryKey);

		if (ahCatEntries == _nullAHCatEntries) {
			return null;
		}

		if (ahCatEntries == null) {
			Session session = null;

			try {
				session = openSession();

				ahCatEntries = (AHCatEntries)session.get(AHCatEntriesImpl.class,
						primaryKey);

				if (ahCatEntries != null) {
					cacheResult(ahCatEntries);
				}
				else {
					entityCache.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
						AHCatEntriesImpl.class, primaryKey, _nullAHCatEntries);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
					AHCatEntriesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ahCatEntries;
	}

	/**
	 * Returns the a h cat entries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the a h cat entries
	 * @return the a h cat entries, or <code>null</code> if a a h cat entries with the primary key could not be found
	 */
	@Override
	public AHCatEntries fetchByPrimaryKey(long itemId) {
		return fetchByPrimaryKey((Serializable)itemId);
	}

	@Override
	public Map<Serializable, AHCatEntries> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AHCatEntries> map = new HashMap<Serializable, AHCatEntries>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AHCatEntries ahCatEntries = fetchByPrimaryKey(primaryKey);

			if (ahCatEntries != null) {
				map.put(primaryKey, ahCatEntries);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AHCatEntries ahCatEntries = (AHCatEntries)entityCache.getResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
					AHCatEntriesImpl.class, primaryKey);

			if (ahCatEntries == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ahCatEntries);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AHCATENTRIES_WHERE_PKS_IN);

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

			for (AHCatEntries ahCatEntries : (List<AHCatEntries>)q.list()) {
				map.put(ahCatEntries.getPrimaryKeyObj(), ahCatEntries);

				cacheResult(ahCatEntries);

				uncachedPrimaryKeys.remove(ahCatEntries.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
					AHCatEntriesImpl.class, primaryKey, _nullAHCatEntries);
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
	 * Returns all the a h cat entrieses.
	 *
	 * @return the a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h cat entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @return the range of a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findAll(int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of a h cat entrieses
	 */
	@Override
	public List<AHCatEntries> findAll(int start, int end,
		OrderByComparator<AHCatEntries> orderByComparator,
		boolean retrieveFromCache) {
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

		List<AHCatEntries> list = null;

		if (retrieveFromCache) {
			list = (List<AHCatEntries>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AHCATENTRIES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AHCATENTRIES;

				if (pagination) {
					sql = sql.concat(AHCatEntriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHCatEntries>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the a h cat entrieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AHCatEntries ahCatEntries : findAll()) {
			remove(ahCatEntries);
		}
	}

	/**
	 * Returns the number of a h cat entrieses.
	 *
	 * @return the number of a h cat entrieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AHCATENTRIES);

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

	/**
	 * Returns the primaryKeys of a h subscriptions associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @return long[] of the primaryKeys of a h subscriptions associated with the a h cat entries
	 */
	@Override
	public long[] getAHSubscriptionPrimaryKeys(long pk) {
		long[] pks = ahCatEntriesToAHSubscriptionTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the a h subscriptions associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @return the a h subscriptions associated with the a h cat entries
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
		long pk) {
		return getAHSubscriptions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the a h subscriptions associated with the a h cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @return the range of a h subscriptions associated with the a h cat entries
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
		long pk, int start, int end) {
		return getAHSubscriptions(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions associated with the a h cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h subscriptions associated with the a h cat entries
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
		long pk, int start, int end,
		OrderByComparator<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> orderByComparator) {
		return ahCatEntriesToAHSubscriptionTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of a h subscriptions associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @return the number of a h subscriptions associated with the a h cat entries
	 */
	@Override
	public int getAHSubscriptionsSize(long pk) {
		long[] pks = ahCatEntriesToAHSubscriptionTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the a h subscription is associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptionPK the primary key of the a h subscription
	 * @return <code>true</code> if the a h subscription is associated with the a h cat entries; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAHSubscription(long pk, long ahSubscriptionPK) {
		return ahCatEntriesToAHSubscriptionTableMapper.containsTableMapping(pk,
			ahSubscriptionPK);
	}

	/**
	 * Returns <code>true</code> if the a h cat entries has any a h subscriptions associated with it.
	 *
	 * @param pk the primary key of the a h cat entries to check for associations with a h subscriptions
	 * @return <code>true</code> if the a h cat entries has any a h subscriptions associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAHSubscriptions(long pk) {
		if (getAHSubscriptionsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptionPK the primary key of the a h subscription
	 */
	@Override
	public void addAHSubscription(long pk, long ahSubscriptionPK) {
		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, ahSubscriptionPK);
		}
		else {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(ahCatEntries.getCompanyId(),
				pk, ahSubscriptionPK);
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscription the a h subscription
	 */
	@Override
	public void addAHSubscription(long pk,
		de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription) {
		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, ahSubscription.getPrimaryKey());
		}
		else {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(ahCatEntries.getCompanyId(),
				pk, ahSubscription.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptionPKs the primary keys of the a h subscriptions
	 */
	@Override
	public void addAHSubscriptions(long pk, long[] ahSubscriptionPKs) {
		long companyId = 0;

		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahCatEntries.getCompanyId();
		}

		for (long ahSubscriptionPK : ahSubscriptionPKs) {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(companyId,
				pk, ahSubscriptionPK);
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptions the a h subscriptions
	 */
	@Override
	public void addAHSubscriptions(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahSubscriptions) {
		long companyId = 0;

		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahCatEntries.getCompanyId();
		}

		for (de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription : ahSubscriptions) {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(companyId,
				pk, ahSubscription.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the a h cat entries and its a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries to clear the associated a h subscriptions from
	 */
	@Override
	public void clearAHSubscriptions(long pk) {
		ahCatEntriesToAHSubscriptionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptionPK the primary key of the a h subscription
	 */
	@Override
	public void removeAHSubscription(long pk, long ahSubscriptionPK) {
		ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
			ahSubscriptionPK);
	}

	/**
	 * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscription the a h subscription
	 */
	@Override
	public void removeAHSubscription(long pk,
		de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription) {
		ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
			ahSubscription.getPrimaryKey());
	}

	/**
	 * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptionPKs the primary keys of the a h subscriptions
	 */
	@Override
	public void removeAHSubscriptions(long pk, long[] ahSubscriptionPKs) {
		for (long ahSubscriptionPK : ahSubscriptionPKs) {
			ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
				ahSubscriptionPK);
		}
	}

	/**
	 * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptions the a h subscriptions
	 */
	@Override
	public void removeAHSubscriptions(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahSubscriptions) {
		for (de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription : ahSubscriptions) {
			ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
				ahSubscription.getPrimaryKey());
		}
	}

	/**
	 * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptionPKs the primary keys of the a h subscriptions to be associated with the a h cat entries
	 */
	@Override
	public void setAHSubscriptions(long pk, long[] ahSubscriptionPKs) {
		Set<Long> newAHSubscriptionPKsSet = SetUtil.fromArray(ahSubscriptionPKs);
		Set<Long> oldAHSubscriptionPKsSet = SetUtil.fromArray(ahCatEntriesToAHSubscriptionTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeAHSubscriptionPKsSet = new HashSet<Long>(oldAHSubscriptionPKsSet);

		removeAHSubscriptionPKsSet.removeAll(newAHSubscriptionPKsSet);

		for (long removeAHSubscriptionPK : removeAHSubscriptionPKsSet) {
			ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
				removeAHSubscriptionPK);
		}

		newAHSubscriptionPKsSet.removeAll(oldAHSubscriptionPKsSet);

		long companyId = 0;

		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahCatEntries.getCompanyId();
		}

		for (long newAHSubscriptionPK : newAHSubscriptionPKsSet) {
			ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(companyId,
				pk, newAHSubscriptionPK);
		}
	}

	/**
	 * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahSubscriptions the a h subscriptions to be associated with the a h cat entries
	 */
	@Override
	public void setAHSubscriptions(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahSubscriptions) {
		try {
			long[] ahSubscriptionPKs = new long[ahSubscriptions.size()];

			for (int i = 0; i < ahSubscriptions.size(); i++) {
				de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription =
					ahSubscriptions.get(i);

				ahSubscriptionPKs[i] = ahSubscription.getPrimaryKey();
			}

			setAHSubscriptions(pk, ahSubscriptionPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	/**
	 * Returns the primaryKeys of a h offers associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @return long[] of the primaryKeys of a h offers associated with the a h cat entries
	 */
	@Override
	public long[] getAHOfferPrimaryKeys(long pk) {
		long[] pks = ahCatEntriesToAHOfferTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the a h offers associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @return the a h offers associated with the a h cat entries
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
		long pk) {
		return getAHOffers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the a h offers associated with the a h cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @return the range of a h offers associated with the a h cat entries
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
		long pk, int start, int end) {
		return getAHOffers(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h offers associated with the a h cat entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param start the lower bound of the range of a h cat entrieses
	 * @param end the upper bound of the range of a h cat entrieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h offers associated with the a h cat entries
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
		long pk, int start, int end,
		OrderByComparator<de.fraunhofer.fokus.oefit.particity.model.AHOffer> orderByComparator) {
		return ahCatEntriesToAHOfferTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of a h offers associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @return the number of a h offers associated with the a h cat entries
	 */
	@Override
	public int getAHOffersSize(long pk) {
		long[] pks = ahCatEntriesToAHOfferTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the a h offer is associated with the a h cat entries.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOfferPK the primary key of the a h offer
	 * @return <code>true</code> if the a h offer is associated with the a h cat entries; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAHOffer(long pk, long ahOfferPK) {
		return ahCatEntriesToAHOfferTableMapper.containsTableMapping(pk,
			ahOfferPK);
	}

	/**
	 * Returns <code>true</code> if the a h cat entries has any a h offers associated with it.
	 *
	 * @param pk the primary key of the a h cat entries to check for associations with a h offers
	 * @return <code>true</code> if the a h cat entries has any a h offers associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAHOffers(long pk) {
		if (getAHOffersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOfferPK the primary key of the a h offer
	 */
	@Override
	public void addAHOffer(long pk, long ahOfferPK) {
		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, ahOfferPK);
		}
		else {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(ahCatEntries.getCompanyId(),
				pk, ahOfferPK);
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOffer the a h offer
	 */
	@Override
	public void addAHOffer(long pk,
		de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer) {
		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, ahOffer.getPrimaryKey());
		}
		else {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(ahCatEntries.getCompanyId(),
				pk, ahOffer.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOfferPKs the primary keys of the a h offers
	 */
	@Override
	public void addAHOffers(long pk, long[] ahOfferPKs) {
		long companyId = 0;

		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahCatEntries.getCompanyId();
		}

		for (long ahOfferPK : ahOfferPKs) {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(companyId, pk,
				ahOfferPK);
		}
	}

	/**
	 * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOffers the a h offers
	 */
	@Override
	public void addAHOffers(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahOffers) {
		long companyId = 0;

		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahCatEntries.getCompanyId();
		}

		for (de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer : ahOffers) {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(companyId, pk,
				ahOffer.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the a h cat entries and its a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries to clear the associated a h offers from
	 */
	@Override
	public void clearAHOffers(long pk) {
		ahCatEntriesToAHOfferTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOfferPK the primary key of the a h offer
	 */
	@Override
	public void removeAHOffer(long pk, long ahOfferPK) {
		ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk, ahOfferPK);
	}

	/**
	 * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOffer the a h offer
	 */
	@Override
	public void removeAHOffer(long pk,
		de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer) {
		ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk,
			ahOffer.getPrimaryKey());
	}

	/**
	 * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOfferPKs the primary keys of the a h offers
	 */
	@Override
	public void removeAHOffers(long pk, long[] ahOfferPKs) {
		for (long ahOfferPK : ahOfferPKs) {
			ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk, ahOfferPK);
		}
	}

	/**
	 * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOffers the a h offers
	 */
	@Override
	public void removeAHOffers(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahOffers) {
		for (de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer : ahOffers) {
			ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk,
				ahOffer.getPrimaryKey());
		}
	}

	/**
	 * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOfferPKs the primary keys of the a h offers to be associated with the a h cat entries
	 */
	@Override
	public void setAHOffers(long pk, long[] ahOfferPKs) {
		Set<Long> newAHOfferPKsSet = SetUtil.fromArray(ahOfferPKs);
		Set<Long> oldAHOfferPKsSet = SetUtil.fromArray(ahCatEntriesToAHOfferTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeAHOfferPKsSet = new HashSet<Long>(oldAHOfferPKsSet);

		removeAHOfferPKsSet.removeAll(newAHOfferPKsSet);

		for (long removeAHOfferPK : removeAHOfferPKsSet) {
			ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk,
				removeAHOfferPK);
		}

		newAHOfferPKsSet.removeAll(oldAHOfferPKsSet);

		long companyId = 0;

		AHCatEntries ahCatEntries = fetchByPrimaryKey(pk);

		if (ahCatEntries == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahCatEntries.getCompanyId();
		}

		for (long newAHOfferPK : newAHOfferPKsSet) {
			ahCatEntriesToAHOfferTableMapper.addTableMapping(companyId, pk,
				newAHOfferPK);
		}
	}

	/**
	 * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h cat entries
	 * @param ahOffers the a h offers to be associated with the a h cat entries
	 */
	@Override
	public void setAHOffers(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahOffers) {
		try {
			long[] ahOfferPKs = new long[ahOffers.size()];

			for (int i = 0; i < ahOffers.size(); i++) {
				de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer = ahOffers.get(i);

				ahOfferPKs[i] = ahOffer.getPrimaryKey();
			}

			setAHOffers(pk, ahOfferPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AHCatEntriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the a h cat entries persistence.
	 */
	public void afterPropertiesSet() {
		ahCatEntriesToAHSubscriptionTableMapper = TableMapperFactory.getTableMapper("PARTICITY_sub_citm",
				"companyId", "itemId", "subId", this, ahSubscriptionPersistence);

		ahCatEntriesToAHOfferTableMapper = TableMapperFactory.getTableMapper("PARTICITY_offer_citm",
				"companyId", "itemId", "offerId", this, ahOfferPersistence);
	}

	public void destroy() {
		entityCache.removeCache(AHCatEntriesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("PARTICITY_sub_citm");
		TableMapperFactory.removeTableMapper("PARTICITY_offer_citm");
	}

	@ServiceReference(type = CompanyProvider.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = AHSubscriptionPersistence.class)
	protected AHSubscriptionPersistence ahSubscriptionPersistence;
	protected TableMapper<AHCatEntries, de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahCatEntriesToAHSubscriptionTableMapper;
	@BeanReference(type = AHOfferPersistence.class)
	protected AHOfferPersistence ahOfferPersistence;
	protected TableMapper<AHCatEntries, de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahCatEntriesToAHOfferTableMapper;
	private static final String _SQL_SELECT_AHCATENTRIES = "SELECT ahCatEntries FROM AHCatEntries ahCatEntries";
	private static final String _SQL_SELECT_AHCATENTRIES_WHERE_PKS_IN = "SELECT ahCatEntries FROM AHCatEntries ahCatEntries WHERE itemId IN (";
	private static final String _SQL_SELECT_AHCATENTRIES_WHERE = "SELECT ahCatEntries FROM AHCatEntries ahCatEntries WHERE ";
	private static final String _SQL_COUNT_AHCATENTRIES = "SELECT COUNT(ahCatEntries) FROM AHCatEntries ahCatEntries";
	private static final String _SQL_COUNT_AHCATENTRIES_WHERE = "SELECT COUNT(ahCatEntries) FROM AHCatEntries ahCatEntries WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ahCatEntries.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHCatEntries exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHCatEntries exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AHCatEntriesPersistenceImpl.class);
	private static final AHCatEntries _nullAHCatEntries = new AHCatEntriesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AHCatEntries> toCacheModel() {
				return _nullAHCatEntriesCacheModel;
			}
		};

	private static final CacheModel<AHCatEntries> _nullAHCatEntriesCacheModel = new CacheModel<AHCatEntries>() {
			@Override
			public AHCatEntries toEntityModel() {
				return _nullAHCatEntries;
			}
		};
}