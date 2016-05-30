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

import de.fraunhofer.fokus.oefit.particity.exception.NoSuchAHSubscriptionException;
import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHSubscriptionPersistence;

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
 * The persistence implementation for the a h subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscriptionPersistence
 * @see de.fraunhofer.fokus.oefit.particity.service.persistence.AHSubscriptionUtil
 * @generated
 */
@ProviderType
public class AHSubscriptionPersistenceImpl extends BasePersistenceImpl<AHSubscription>
	implements AHSubscriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AHSubscriptionUtil} to access the a h subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AHSubscriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			AHSubscriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			AHSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			AHSubscriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			AHSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemail",
			new String[] { String.class.getName() },
			AHSubscriptionModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemail",
			new String[] { String.class.getName() });

	/**
	 * Returns all the a h subscriptions where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByemail(String email) {
		return findByemail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h subscriptions where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @return the range of matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByemail(String email, int start, int end) {
		return findByemail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByemail(String email, int start, int end,
		OrderByComparator<AHSubscription> orderByComparator) {
		return findByemail(email, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByemail(String email, int start, int end,
		OrderByComparator<AHSubscription> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email, start, end, orderByComparator };
		}

		List<AHSubscription> list = null;

		if (retrieveFromCache) {
			list = (List<AHSubscription>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AHSubscription ahSubscription : list) {
					if (!Objects.equals(email, ahSubscription.getEmail())) {
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

			query.append(_SQL_SELECT_AHSUBSCRIPTION_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<AHSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHSubscription>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first a h subscription in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h subscription
	 * @throws NoSuchAHSubscriptionException if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription findByemail_First(String email,
		OrderByComparator<AHSubscription> orderByComparator)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = fetchByemail_First(email,
				orderByComparator);

		if (ahSubscription != null) {
			return ahSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first a h subscription in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription fetchByemail_First(String email,
		OrderByComparator<AHSubscription> orderByComparator) {
		List<AHSubscription> list = findByemail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h subscription in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h subscription
	 * @throws NoSuchAHSubscriptionException if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription findByemail_Last(String email,
		OrderByComparator<AHSubscription> orderByComparator)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = fetchByemail_Last(email,
				orderByComparator);

		if (ahSubscription != null) {
			return ahSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last a h subscription in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription fetchByemail_Last(String email,
		OrderByComparator<AHSubscription> orderByComparator) {
		int count = countByemail(email);

		if (count == 0) {
			return null;
		}

		List<AHSubscription> list = findByemail(email, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h subscriptions before and after the current a h subscription in the ordered set where email = &#63;.
	 *
	 * @param subId the primary key of the current a h subscription
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h subscription
	 * @throws NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription[] findByemail_PrevAndNext(long subId, String email,
		OrderByComparator<AHSubscription> orderByComparator)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = findByPrimaryKey(subId);

		Session session = null;

		try {
			session = openSession();

			AHSubscription[] array = new AHSubscriptionImpl[3];

			array[0] = getByemail_PrevAndNext(session, ahSubscription, email,
					orderByComparator, true);

			array[1] = ahSubscription;

			array[2] = getByemail_PrevAndNext(session, ahSubscription, email,
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

	protected AHSubscription getByemail_PrevAndNext(Session session,
		AHSubscription ahSubscription, String email,
		OrderByComparator<AHSubscription> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AHSUBSCRIPTION_WHERE);

		boolean bindEmail = false;

		if (email == null) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
		}
		else if (email.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			query.append(AHSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h subscriptions where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByemail(String email) {
		for (AHSubscription ahSubscription : findByemail(email,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ahSubscription);
		}
	}

	/**
	 * Returns the number of a h subscriptions where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching a h subscriptions
	 */
	@Override
	public int countByemail(String email) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHSUBSCRIPTION_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "ahSubscription.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "ahSubscription.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(ahSubscription.email IS NULL OR ahSubscription.email = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			AHSubscriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			AHSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuuid",
			new String[] { String.class.getName() },
			AHSubscriptionModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the a h subscriptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByuuid(String uuid) {
		return findByuuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h subscriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @return the range of matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByuuid(String uuid, int start, int end) {
		return findByuuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByuuid(String uuid, int start, int end,
		OrderByComparator<AHSubscription> orderByComparator) {
		return findByuuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching a h subscriptions
	 */
	@Override
	public List<AHSubscription> findByuuid(String uuid, int start, int end,
		OrderByComparator<AHSubscription> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<AHSubscription> list = null;

		if (retrieveFromCache) {
			list = (List<AHSubscription>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AHSubscription ahSubscription : list) {
					if (!Objects.equals(uuid, ahSubscription.getUuid())) {
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

			query.append(_SQL_SELECT_AHSUBSCRIPTION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AHSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<AHSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHSubscription>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first a h subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h subscription
	 * @throws NoSuchAHSubscriptionException if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription findByuuid_First(String uuid,
		OrderByComparator<AHSubscription> orderByComparator)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = fetchByuuid_First(uuid,
				orderByComparator);

		if (ahSubscription != null) {
			return ahSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first a h subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription fetchByuuid_First(String uuid,
		OrderByComparator<AHSubscription> orderByComparator) {
		List<AHSubscription> list = findByuuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last a h subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h subscription
	 * @throws NoSuchAHSubscriptionException if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription findByuuid_Last(String uuid,
		OrderByComparator<AHSubscription> orderByComparator)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = fetchByuuid_Last(uuid, orderByComparator);

		if (ahSubscription != null) {
			return ahSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAHSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last a h subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
	 */
	@Override
	public AHSubscription fetchByuuid_Last(String uuid,
		OrderByComparator<AHSubscription> orderByComparator) {
		int count = countByuuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AHSubscription> list = findByuuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the a h subscriptions before and after the current a h subscription in the ordered set where uuid = &#63;.
	 *
	 * @param subId the primary key of the current a h subscription
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next a h subscription
	 * @throws NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription[] findByuuid_PrevAndNext(long subId, String uuid,
		OrderByComparator<AHSubscription> orderByComparator)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = findByPrimaryKey(subId);

		Session session = null;

		try {
			session = openSession();

			AHSubscription[] array = new AHSubscriptionImpl[3];

			array[0] = getByuuid_PrevAndNext(session, ahSubscription, uuid,
					orderByComparator, true);

			array[1] = ahSubscription;

			array[2] = getByuuid_PrevAndNext(session, ahSubscription, uuid,
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

	protected AHSubscription getByuuid_PrevAndNext(Session session,
		AHSubscription ahSubscription, String uuid,
		OrderByComparator<AHSubscription> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AHSUBSCRIPTION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(AHSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ahSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AHSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the a h subscriptions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByuuid(String uuid) {
		for (AHSubscription ahSubscription : findByuuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ahSubscription);
		}
	}

	/**
	 * Returns the number of a h subscriptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching a h subscriptions
	 */
	@Override
	public int countByuuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AHSUBSCRIPTION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ahSubscription.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ahSubscription.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ahSubscription.uuid IS NULL OR ahSubscription.uuid = '')";

	public AHSubscriptionPersistenceImpl() {
		setModelClass(AHSubscription.class);
	}

	/**
	 * Caches the a h subscription in the entity cache if it is enabled.
	 *
	 * @param ahSubscription the a h subscription
	 */
	@Override
	public void cacheResult(AHSubscription ahSubscription) {
		entityCache.putResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionImpl.class, ahSubscription.getPrimaryKey(),
			ahSubscription);

		ahSubscription.resetOriginalValues();
	}

	/**
	 * Caches the a h subscriptions in the entity cache if it is enabled.
	 *
	 * @param ahSubscriptions the a h subscriptions
	 */
	@Override
	public void cacheResult(List<AHSubscription> ahSubscriptions) {
		for (AHSubscription ahSubscription : ahSubscriptions) {
			if (entityCache.getResult(
						AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
						AHSubscriptionImpl.class, ahSubscription.getPrimaryKey()) == null) {
				cacheResult(ahSubscription);
			}
			else {
				ahSubscription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a h subscriptions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AHSubscriptionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a h subscription.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AHSubscription ahSubscription) {
		entityCache.removeResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionImpl.class, ahSubscription.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AHSubscription> ahSubscriptions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AHSubscription ahSubscription : ahSubscriptions) {
			entityCache.removeResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
				AHSubscriptionImpl.class, ahSubscription.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a h subscription with the primary key. Does not add the a h subscription to the database.
	 *
	 * @param subId the primary key for the new a h subscription
	 * @return the new a h subscription
	 */
	@Override
	public AHSubscription create(long subId) {
		AHSubscription ahSubscription = new AHSubscriptionImpl();

		ahSubscription.setNew(true);
		ahSubscription.setPrimaryKey(subId);

		return ahSubscription;
	}

	/**
	 * Removes the a h subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subId the primary key of the a h subscription
	 * @return the a h subscription that was removed
	 * @throws NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription remove(long subId)
		throws NoSuchAHSubscriptionException {
		return remove((Serializable)subId);
	}

	/**
	 * Removes the a h subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a h subscription
	 * @return the a h subscription that was removed
	 * @throws NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription remove(Serializable primaryKey)
		throws NoSuchAHSubscriptionException {
		Session session = null;

		try {
			session = openSession();

			AHSubscription ahSubscription = (AHSubscription)session.get(AHSubscriptionImpl.class,
					primaryKey);

			if (ahSubscription == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAHSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ahSubscription);
		}
		catch (NoSuchAHSubscriptionException nsee) {
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
	protected AHSubscription removeImpl(AHSubscription ahSubscription) {
		ahSubscription = toUnwrappedModel(ahSubscription);

		ahSubscriptionToAHCatEntriesTableMapper.deleteLeftPrimaryKeyTableMappings(ahSubscription.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ahSubscription)) {
				ahSubscription = (AHSubscription)session.get(AHSubscriptionImpl.class,
						ahSubscription.getPrimaryKeyObj());
			}

			if (ahSubscription != null) {
				session.delete(ahSubscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ahSubscription != null) {
			clearCache(ahSubscription);
		}

		return ahSubscription;
	}

	@Override
	public AHSubscription updateImpl(AHSubscription ahSubscription) {
		ahSubscription = toUnwrappedModel(ahSubscription);

		boolean isNew = ahSubscription.isNew();

		AHSubscriptionModelImpl ahSubscriptionModelImpl = (AHSubscriptionModelImpl)ahSubscription;

		Session session = null;

		try {
			session = openSession();

			if (ahSubscription.isNew()) {
				session.save(ahSubscription);

				ahSubscription.setNew(false);
			}
			else {
				ahSubscription = (AHSubscription)session.merge(ahSubscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AHSubscriptionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ahSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ahSubscriptionModelImpl.getOriginalEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { ahSubscriptionModelImpl.getEmail() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((ahSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ahSubscriptionModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ahSubscriptionModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			AHSubscriptionImpl.class, ahSubscription.getPrimaryKey(),
			ahSubscription, false);

		ahSubscription.resetOriginalValues();

		return ahSubscription;
	}

	protected AHSubscription toUnwrappedModel(AHSubscription ahSubscription) {
		if (ahSubscription instanceof AHSubscriptionImpl) {
			return ahSubscription;
		}

		AHSubscriptionImpl ahSubscriptionImpl = new AHSubscriptionImpl();

		ahSubscriptionImpl.setNew(ahSubscription.isNew());
		ahSubscriptionImpl.setPrimaryKey(ahSubscription.getPrimaryKey());

		ahSubscriptionImpl.setSubId(ahSubscription.getSubId());
		ahSubscriptionImpl.setUuid(ahSubscription.getUuid());
		ahSubscriptionImpl.setEmail(ahSubscription.getEmail());
		ahSubscriptionImpl.setStatus(ahSubscription.getStatus());
		ahSubscriptionImpl.setCreated(ahSubscription.getCreated());

		return ahSubscriptionImpl;
	}

	/**
	 * Returns the a h subscription with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h subscription
	 * @return the a h subscription
	 * @throws NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAHSubscriptionException {
		AHSubscription ahSubscription = fetchByPrimaryKey(primaryKey);

		if (ahSubscription == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAHSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ahSubscription;
	}

	/**
	 * Returns the a h subscription with the primary key or throws a {@link NoSuchAHSubscriptionException} if it could not be found.
	 *
	 * @param subId the primary key of the a h subscription
	 * @return the a h subscription
	 * @throws NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription findByPrimaryKey(long subId)
		throws NoSuchAHSubscriptionException {
		return findByPrimaryKey((Serializable)subId);
	}

	/**
	 * Returns the a h subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h subscription
	 * @return the a h subscription, or <code>null</code> if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription fetchByPrimaryKey(Serializable primaryKey) {
		AHSubscription ahSubscription = (AHSubscription)entityCache.getResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
				AHSubscriptionImpl.class, primaryKey);

		if (ahSubscription == _nullAHSubscription) {
			return null;
		}

		if (ahSubscription == null) {
			Session session = null;

			try {
				session = openSession();

				ahSubscription = (AHSubscription)session.get(AHSubscriptionImpl.class,
						primaryKey);

				if (ahSubscription != null) {
					cacheResult(ahSubscription);
				}
				else {
					entityCache.putResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
						AHSubscriptionImpl.class, primaryKey,
						_nullAHSubscription);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
					AHSubscriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ahSubscription;
	}

	/**
	 * Returns the a h subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subId the primary key of the a h subscription
	 * @return the a h subscription, or <code>null</code> if a a h subscription with the primary key could not be found
	 */
	@Override
	public AHSubscription fetchByPrimaryKey(long subId) {
		return fetchByPrimaryKey((Serializable)subId);
	}

	@Override
	public Map<Serializable, AHSubscription> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AHSubscription> map = new HashMap<Serializable, AHSubscription>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AHSubscription ahSubscription = fetchByPrimaryKey(primaryKey);

			if (ahSubscription != null) {
				map.put(primaryKey, ahSubscription);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AHSubscription ahSubscription = (AHSubscription)entityCache.getResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
					AHSubscriptionImpl.class, primaryKey);

			if (ahSubscription == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ahSubscription);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AHSUBSCRIPTION_WHERE_PKS_IN);

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

			for (AHSubscription ahSubscription : (List<AHSubscription>)q.list()) {
				map.put(ahSubscription.getPrimaryKeyObj(), ahSubscription);

				cacheResult(ahSubscription);

				uncachedPrimaryKeys.remove(ahSubscription.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AHSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
					AHSubscriptionImpl.class, primaryKey, _nullAHSubscription);
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
	 * Returns all the a h subscriptions.
	 *
	 * @return the a h subscriptions
	 */
	@Override
	public List<AHSubscription> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @return the range of a h subscriptions
	 */
	@Override
	public List<AHSubscription> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h subscriptions
	 */
	@Override
	public List<AHSubscription> findAll(int start, int end,
		OrderByComparator<AHSubscription> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of a h subscriptions
	 */
	@Override
	public List<AHSubscription> findAll(int start, int end,
		OrderByComparator<AHSubscription> orderByComparator,
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

		List<AHSubscription> list = null;

		if (retrieveFromCache) {
			list = (List<AHSubscription>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AHSUBSCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AHSUBSCRIPTION;

				if (pagination) {
					sql = sql.concat(AHSubscriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AHSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHSubscription>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the a h subscriptions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AHSubscription ahSubscription : findAll()) {
			remove(ahSubscription);
		}
	}

	/**
	 * Returns the number of a h subscriptions.
	 *
	 * @return the number of a h subscriptions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AHSUBSCRIPTION);

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
	 * Returns the primaryKeys of a h cat entrieses associated with the a h subscription.
	 *
	 * @param pk the primary key of the a h subscription
	 * @return long[] of the primaryKeys of a h cat entrieses associated with the a h subscription
	 */
	@Override
	public long[] getAHCatEntriesPrimaryKeys(long pk) {
		long[] pks = ahSubscriptionToAHCatEntriesTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the a h cat entrieses associated with the a h subscription.
	 *
	 * @param pk the primary key of the a h subscription
	 * @return the a h cat entrieses associated with the a h subscription
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getAHCatEntrieses(
		long pk) {
		return getAHCatEntrieses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the a h cat entrieses associated with the a h subscription.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the a h subscription
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @return the range of a h cat entrieses associated with the a h subscription
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getAHCatEntrieses(
		long pk, int start, int end) {
		return getAHCatEntrieses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h cat entrieses associated with the a h subscription.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the a h subscription
	 * @param start the lower bound of the range of a h subscriptions
	 * @param end the upper bound of the range of a h subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h cat entrieses associated with the a h subscription
	 */
	@Override
	public List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getAHCatEntrieses(
		long pk, int start, int end,
		OrderByComparator<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> orderByComparator) {
		return ahSubscriptionToAHCatEntriesTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of a h cat entrieses associated with the a h subscription.
	 *
	 * @param pk the primary key of the a h subscription
	 * @return the number of a h cat entrieses associated with the a h subscription
	 */
	@Override
	public int getAHCatEntriesesSize(long pk) {
		long[] pks = ahSubscriptionToAHCatEntriesTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the a h cat entries is associated with the a h subscription.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntriesPK the primary key of the a h cat entries
	 * @return <code>true</code> if the a h cat entries is associated with the a h subscription; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAHCatEntries(long pk, long ahCatEntriesPK) {
		return ahSubscriptionToAHCatEntriesTableMapper.containsTableMapping(pk,
			ahCatEntriesPK);
	}

	/**
	 * Returns <code>true</code> if the a h subscription has any a h cat entrieses associated with it.
	 *
	 * @param pk the primary key of the a h subscription to check for associations with a h cat entrieses
	 * @return <code>true</code> if the a h subscription has any a h cat entrieses associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAHCatEntrieses(long pk) {
		if (getAHCatEntriesesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntriesPK the primary key of the a h cat entries
	 */
	@Override
	public void addAHCatEntries(long pk, long ahCatEntriesPK) {
		AHSubscription ahSubscription = fetchByPrimaryKey(pk);

		if (ahSubscription == null) {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, ahCatEntriesPK);
		}
		else {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(ahSubscription.getCompanyId(),
				pk, ahCatEntriesPK);
		}
	}

	/**
	 * Adds an association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntries the a h cat entries
	 */
	@Override
	public void addAHCatEntries(long pk,
		de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries) {
		AHSubscription ahSubscription = fetchByPrimaryKey(pk);

		if (ahSubscription == null) {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, ahCatEntries.getPrimaryKey());
		}
		else {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(ahSubscription.getCompanyId(),
				pk, ahCatEntries.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
	 */
	@Override
	public void addAHCatEntrieses(long pk, long[] ahCatEntriesPKs) {
		long companyId = 0;

		AHSubscription ahSubscription = fetchByPrimaryKey(pk);

		if (ahSubscription == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahSubscription.getCompanyId();
		}

		for (long ahCatEntriesPK : ahCatEntriesPKs) {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(companyId,
				pk, ahCatEntriesPK);
		}
	}

	/**
	 * Adds an association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntrieses the a h cat entrieses
	 */
	@Override
	public void addAHCatEntrieses(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses) {
		long companyId = 0;

		AHSubscription ahSubscription = fetchByPrimaryKey(pk);

		if (ahSubscription == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahSubscription.getCompanyId();
		}

		for (de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries : ahCatEntrieses) {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(companyId,
				pk, ahCatEntries.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the a h subscription and its a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription to clear the associated a h cat entrieses from
	 */
	@Override
	public void clearAHCatEntrieses(long pk) {
		ahSubscriptionToAHCatEntriesTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntriesPK the primary key of the a h cat entries
	 */
	@Override
	public void removeAHCatEntries(long pk, long ahCatEntriesPK) {
		ahSubscriptionToAHCatEntriesTableMapper.deleteTableMapping(pk,
			ahCatEntriesPK);
	}

	/**
	 * Removes the association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntries the a h cat entries
	 */
	@Override
	public void removeAHCatEntries(long pk,
		de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries) {
		ahSubscriptionToAHCatEntriesTableMapper.deleteTableMapping(pk,
			ahCatEntries.getPrimaryKey());
	}

	/**
	 * Removes the association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
	 */
	@Override
	public void removeAHCatEntrieses(long pk, long[] ahCatEntriesPKs) {
		for (long ahCatEntriesPK : ahCatEntriesPKs) {
			ahSubscriptionToAHCatEntriesTableMapper.deleteTableMapping(pk,
				ahCatEntriesPK);
		}
	}

	/**
	 * Removes the association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntrieses the a h cat entrieses
	 */
	@Override
	public void removeAHCatEntrieses(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses) {
		for (de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries : ahCatEntrieses) {
			ahSubscriptionToAHCatEntriesTableMapper.deleteTableMapping(pk,
				ahCatEntries.getPrimaryKey());
		}
	}

	/**
	 * Sets the a h cat entrieses associated with the a h subscription, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntriesPKs the primary keys of the a h cat entrieses to be associated with the a h subscription
	 */
	@Override
	public void setAHCatEntrieses(long pk, long[] ahCatEntriesPKs) {
		Set<Long> newAHCatEntriesPKsSet = SetUtil.fromArray(ahCatEntriesPKs);
		Set<Long> oldAHCatEntriesPKsSet = SetUtil.fromArray(ahSubscriptionToAHCatEntriesTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeAHCatEntriesPKsSet = new HashSet<Long>(oldAHCatEntriesPKsSet);

		removeAHCatEntriesPKsSet.removeAll(newAHCatEntriesPKsSet);

		for (long removeAHCatEntriesPK : removeAHCatEntriesPKsSet) {
			ahSubscriptionToAHCatEntriesTableMapper.deleteTableMapping(pk,
				removeAHCatEntriesPK);
		}

		newAHCatEntriesPKsSet.removeAll(oldAHCatEntriesPKsSet);

		long companyId = 0;

		AHSubscription ahSubscription = fetchByPrimaryKey(pk);

		if (ahSubscription == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = ahSubscription.getCompanyId();
		}

		for (long newAHCatEntriesPK : newAHCatEntriesPKsSet) {
			ahSubscriptionToAHCatEntriesTableMapper.addTableMapping(companyId,
				pk, newAHCatEntriesPK);
		}
	}

	/**
	 * Sets the a h cat entrieses associated with the a h subscription, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the a h subscription
	 * @param ahCatEntrieses the a h cat entrieses to be associated with the a h subscription
	 */
	@Override
	public void setAHCatEntrieses(long pk,
		List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses) {
		try {
			long[] ahCatEntriesPKs = new long[ahCatEntrieses.size()];

			for (int i = 0; i < ahCatEntrieses.size(); i++) {
				de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries =
					ahCatEntrieses.get(i);

				ahCatEntriesPKs[i] = ahCatEntries.getPrimaryKey();
			}

			setAHCatEntrieses(pk, ahCatEntriesPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AHSubscriptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the a h subscription persistence.
	 */
	public void afterPropertiesSet() {
		ahSubscriptionToAHCatEntriesTableMapper = TableMapperFactory.getTableMapper("PARTICITY_sub_citm",
				"companyId", "subId", "itemId", this, ahCatEntriesPersistence);
	}

	public void destroy() {
		entityCache.removeCache(AHSubscriptionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("PARTICITY_sub_citm");
	}

	@ServiceReference(type = CompanyProvider.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = AHCatEntriesPersistence.class)
	protected AHCatEntriesPersistence ahCatEntriesPersistence;
	protected TableMapper<AHSubscription, de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahSubscriptionToAHCatEntriesTableMapper;
	private static final String _SQL_SELECT_AHSUBSCRIPTION = "SELECT ahSubscription FROM AHSubscription ahSubscription";
	private static final String _SQL_SELECT_AHSUBSCRIPTION_WHERE_PKS_IN = "SELECT ahSubscription FROM AHSubscription ahSubscription WHERE subId IN (";
	private static final String _SQL_SELECT_AHSUBSCRIPTION_WHERE = "SELECT ahSubscription FROM AHSubscription ahSubscription WHERE ";
	private static final String _SQL_COUNT_AHSUBSCRIPTION = "SELECT COUNT(ahSubscription) FROM AHSubscription ahSubscription";
	private static final String _SQL_COUNT_AHSUBSCRIPTION_WHERE = "SELECT COUNT(ahSubscription) FROM AHSubscription ahSubscription WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ahSubscription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHSubscription exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHSubscription exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AHSubscriptionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final AHSubscription _nullAHSubscription = new AHSubscriptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AHSubscription> toCacheModel() {
				return _nullAHSubscriptionCacheModel;
			}
		};

	private static final CacheModel<AHSubscription> _nullAHSubscriptionCacheModel =
		new CacheModel<AHSubscription>() {
			@Override
			public AHSubscription toEntityModel() {
				return _nullAHSubscription;
			}
		};
}