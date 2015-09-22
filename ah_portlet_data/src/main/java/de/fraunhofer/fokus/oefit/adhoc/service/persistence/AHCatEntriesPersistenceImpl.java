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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;
import de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesImpl;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHCatEntriesPersistence;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHOfferPersistence;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHSubscriptionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
 * @see AHCatEntriesUtil
 * @generated
 */
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
    private static final String _FINDER_COLUMN_ITEM_ITEMID_2 = "ahCatEntries.itemId = ?";
    private static final String _SQL_SELECT_AHCATENTRIES = "SELECT ahCatEntries FROM AHCatEntries ahCatEntries";
    private static final String _SQL_SELECT_AHCATENTRIES_WHERE = "SELECT ahCatEntries FROM AHCatEntries ahCatEntries WHERE ";
    private static final String _SQL_COUNT_AHCATENTRIES = "SELECT COUNT(ahCatEntries) FROM AHCatEntries ahCatEntries";
    private static final String _SQL_COUNT_AHCATENTRIES_WHERE = "SELECT COUNT(ahCatEntries) FROM AHCatEntries ahCatEntries WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahCatEntries.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHCatEntries exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHCatEntries exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHCatEntriesPersistenceImpl.class);
    private static AHCatEntries _nullAHCatEntries = new AHCatEntriesImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHCatEntries> toCacheModel() {
                return _nullAHCatEntriesCacheModel;
            }
        };

    private static CacheModel<AHCatEntries> _nullAHCatEntriesCacheModel = new CacheModel<AHCatEntries>() {
            @Override
            public AHCatEntries toEntityModel() {
                return _nullAHCatEntries;
            }
        };

    @BeanReference(type = AHSubscriptionPersistence.class)
    protected AHSubscriptionPersistence ahSubscriptionPersistence;
    protected TableMapper<AHCatEntries, de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahCatEntriesToAHSubscriptionTableMapper;
    @BeanReference(type = AHOfferPersistence.class)
    protected AHOfferPersistence ahOfferPersistence;
    protected TableMapper<AHCatEntries, de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahCatEntriesToAHOfferTableMapper;

    public AHCatEntriesPersistenceImpl() {
        setModelClass(AHCatEntries.class);
    }

    /**
     * Returns all the a h cat entrieses where catId = &#63;.
     *
     * @param catId the cat ID
     * @return the matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findBycat(long catId) throws SystemException {
        return findBycat(catId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h cat entrieses where catId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param catId the cat ID
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @return the range of matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findBycat(long catId, int start, int end)
        throws SystemException {
        return findBycat(catId, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h cat entrieses where catId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param catId the cat ID
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findBycat(long catId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT;
            finderArgs = new Object[] { catId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT;
            finderArgs = new Object[] { catId, start, end, orderByComparator };
        }

        List<AHCatEntries> list = (List<AHCatEntries>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHCatEntries ahCatEntries : list) {
                if ((catId != ahCatEntries.getCatId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

            query.append(_FINDER_COLUMN_CAT_CATID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
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
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCatEntries>(list);
                } else {
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findBycat_First(long catId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchBycat_First(long catId,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findBycat_Last(long catId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchBycat_Last(long catId,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries[] findBycat_PrevAndNext(long itemId, long catId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHCatEntries getBycat_PrevAndNext(Session session,
        AHCatEntries ahCatEntries, long catId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
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
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h cat entrieses where catId = &#63; from the database.
     *
     * @param catId the cat ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycat(long catId) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycat(long catId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CAT;

        Object[] finderArgs = new Object[] { catId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

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

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the a h cat entrieses where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findByparent(long parentId)
        throws SystemException {
        return findByparent(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h cat entrieses where parentId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param parentId the parent ID
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @return the range of matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findByparent(long parentId, int start, int end)
        throws SystemException {
        return findByparent(parentId, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h cat entrieses where parentId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param parentId the parent ID
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findByparent(long parentId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
            finderArgs = new Object[] { parentId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
            finderArgs = new Object[] { parentId, start, end, orderByComparator };
        }

        List<AHCatEntries> list = (List<AHCatEntries>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHCatEntries ahCatEntries : list) {
                if ((parentId != ahCatEntries.getParentId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

            query.append(_FINDER_COLUMN_PARENT_PARENTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
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
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCatEntries>(list);
                } else {
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findByparent_First(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchByparent_First(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findByparent_Last(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchByparent_Last(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries[] findByparent_PrevAndNext(long itemId, long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHCatEntries getByparent_PrevAndNext(Session session,
        AHCatEntries ahCatEntries, long parentId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
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
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h cat entrieses where parentId = &#63; from the database.
     *
     * @param parentId the parent ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByparent(long parentId) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByparent(long parentId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENT;

        Object[] finderArgs = new Object[] { parentId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

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

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the a h cat entrieses where itemId = &#63;.
     *
     * @param itemId the item ID
     * @return the matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findByitem(long itemId) throws SystemException {
        return findByitem(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h cat entrieses where itemId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemId the item ID
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @return the range of matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findByitem(long itemId, int start, int end)
        throws SystemException {
        return findByitem(itemId, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h cat entrieses where itemId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemId the item ID
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findByitem(long itemId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM;
            finderArgs = new Object[] { itemId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEM;
            finderArgs = new Object[] { itemId, start, end, orderByComparator };
        }

        List<AHCatEntries> list = (List<AHCatEntries>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHCatEntries ahCatEntries : list) {
                if ((itemId != ahCatEntries.getItemId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_AHCATENTRIES_WHERE);

            query.append(_FINDER_COLUMN_ITEM_ITEMID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
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
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCatEntries>(list);
                } else {
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findByitem_First(long itemId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchByitem_First(long itemId,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findByitem_Last(long itemId,
        OrderByComparator orderByComparator)
        throws NoSuchAHCatEntriesException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchByitem_Last(long itemId,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByitem(long itemId) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByitem(long itemId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEM;

        Object[] finderArgs = new Object[] { itemId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

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

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the a h cat entries in the entity cache if it is enabled.
     *
     * @param ahCatEntries the a h cat entries
     */
    @Override
    public void cacheResult(AHCatEntries ahCatEntries) {
        EntityCacheUtil.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
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
            if (EntityCacheUtil.getResult(
                        AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
                        AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey()) == null) {
                cacheResult(ahCatEntries);
            } else {
                ahCatEntries.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h cat entrieses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHCatEntriesImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHCatEntriesImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h cat entries.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHCatEntries ahCatEntries) {
        EntityCacheUtil.removeResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHCatEntries> ahCatEntrieses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHCatEntries ahCatEntries : ahCatEntrieses) {
            EntityCacheUtil.removeResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries remove(long itemId)
        throws NoSuchAHCatEntriesException, SystemException {
        return remove((Serializable) itemId);
    }

    /**
     * Removes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h cat entries
     * @return the a h cat entries that was removed
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries remove(Serializable primaryKey)
        throws NoSuchAHCatEntriesException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHCatEntries ahCatEntries = (AHCatEntries) session.get(AHCatEntriesImpl.class,
                    primaryKey);

            if (ahCatEntries == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHCatEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahCatEntries);
        } catch (NoSuchAHCatEntriesException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHCatEntries removeImpl(AHCatEntries ahCatEntries)
        throws SystemException {
        ahCatEntries = toUnwrappedModel(ahCatEntries);

        ahCatEntriesToAHSubscriptionTableMapper.deleteLeftPrimaryKeyTableMappings(ahCatEntries.getPrimaryKey());

        ahCatEntriesToAHOfferTableMapper.deleteLeftPrimaryKeyTableMappings(ahCatEntries.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahCatEntries)) {
                ahCatEntries = (AHCatEntries) session.get(AHCatEntriesImpl.class,
                        ahCatEntries.getPrimaryKeyObj());
            }

            if (ahCatEntries != null) {
                session.delete(ahCatEntries);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahCatEntries != null) {
            clearCache(ahCatEntries);
        }

        return ahCatEntries;
    }

    @Override
    public AHCatEntries updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws SystemException {
        ahCatEntries = toUnwrappedModel(ahCatEntries);

        boolean isNew = ahCatEntries.isNew();

        AHCatEntriesModelImpl ahCatEntriesModelImpl = (AHCatEntriesModelImpl) ahCatEntries;

        Session session = null;

        try {
            session = openSession();

            if (ahCatEntries.isNew()) {
                session.save(ahCatEntries);

                ahCatEntries.setNew(false);
            } else {
                session.merge(ahCatEntries);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AHCatEntriesModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((ahCatEntriesModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahCatEntriesModelImpl.getOriginalCatId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT,
                    args);

                args = new Object[] { ahCatEntriesModelImpl.getCatId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT,
                    args);
            }

            if ((ahCatEntriesModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahCatEntriesModelImpl.getOriginalParentId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
                    args);

                args = new Object[] { ahCatEntriesModelImpl.getParentId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
                    args);
            }

            if ((ahCatEntriesModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahCatEntriesModelImpl.getOriginalItemId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEM, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM,
                    args);

                args = new Object[] { ahCatEntriesModelImpl.getItemId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEM, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEM,
                    args);
            }
        }

        EntityCacheUtil.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCatEntriesImpl.class, ahCatEntries.getPrimaryKey(), ahCatEntries);

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
     * Returns the a h cat entries with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h cat entries
     * @return the a h cat entries
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHCatEntriesException, SystemException {
        AHCatEntries ahCatEntries = fetchByPrimaryKey(primaryKey);

        if (ahCatEntries == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHCatEntriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahCatEntries;
    }

    /**
     * Returns the a h cat entries with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException} if it could not be found.
     *
     * @param itemId the primary key of the a h cat entries
     * @return the a h cat entries
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries findByPrimaryKey(long itemId)
        throws NoSuchAHCatEntriesException, SystemException {
        return findByPrimaryKey((Serializable) itemId);
    }

    /**
     * Returns the a h cat entries with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h cat entries
     * @return the a h cat entries, or <code>null</code> if a a h cat entries with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHCatEntries ahCatEntries = (AHCatEntries) EntityCacheUtil.getResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
                AHCatEntriesImpl.class, primaryKey);

        if (ahCatEntries == _nullAHCatEntries) {
            return null;
        }

        if (ahCatEntries == null) {
            Session session = null;

            try {
                session = openSession();

                ahCatEntries = (AHCatEntries) session.get(AHCatEntriesImpl.class,
                        primaryKey);

                if (ahCatEntries != null) {
                    cacheResult(ahCatEntries);
                } else {
                    EntityCacheUtil.putResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
                        AHCatEntriesImpl.class, primaryKey, _nullAHCatEntries);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHCatEntriesModelImpl.ENTITY_CACHE_ENABLED,
                    AHCatEntriesImpl.class, primaryKey);

                throw processException(e);
            } finally {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCatEntries fetchByPrimaryKey(long itemId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) itemId);
    }

    /**
     * Returns all the a h cat entrieses.
     *
     * @return the a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h cat entrieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @return the range of a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h cat entrieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCatEntries> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<AHCatEntries> list = (List<AHCatEntries>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHCATENTRIES);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
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
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCatEntries>(list);
                } else {
                    list = (List<AHCatEntries>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the a h cat entrieses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHCatEntries ahCatEntries : findAll()) {
            remove(ahCatEntries);
        }
    }

    /**
     * Returns the number of a h cat entrieses.
     *
     * @return the number of a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_AHCATENTRIES);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the a h subscriptions associated with the a h cat entries.
     *
     * @param pk the primary key of the a h cat entries
     * @return the a h subscriptions associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getAHSubscriptions(
        long pk) throws SystemException {
        return getAHSubscriptions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the a h subscriptions associated with the a h cat entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the a h cat entries
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @return the range of a h subscriptions associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getAHSubscriptions(
        long pk, int start, int end) throws SystemException {
        return getAHSubscriptions(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h subscriptions associated with the a h cat entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the a h cat entries
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h subscriptions associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getAHSubscriptions(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return ahCatEntriesToAHSubscriptionTableMapper.getRightBaseModels(pk,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of a h subscriptions associated with the a h cat entries.
     *
     * @param pk the primary key of the a h cat entries
     * @return the number of a h subscriptions associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getAHSubscriptionsSize(long pk) throws SystemException {
        long[] pks = ahCatEntriesToAHSubscriptionTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the a h subscription is associated with the a h cat entries.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptionPK the primary key of the a h subscription
     * @return <code>true</code> if the a h subscription is associated with the a h cat entries; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsAHSubscription(long pk, long ahSubscriptionPK)
        throws SystemException {
        return ahCatEntriesToAHSubscriptionTableMapper.containsTableMapping(pk,
            ahSubscriptionPK);
    }

    /**
     * Returns <code>true</code> if the a h cat entries has any a h subscriptions associated with it.
     *
     * @param pk the primary key of the a h cat entries to check for associations with a h subscriptions
     * @return <code>true</code> if the a h cat entries has any a h subscriptions associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsAHSubscriptions(long pk) throws SystemException {
        if (getAHSubscriptionsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptionPK the primary key of the a h subscription
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHSubscription(long pk, long ahSubscriptionPK)
        throws SystemException {
        ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(pk,
            ahSubscriptionPK);
    }

    /**
     * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscription the a h subscription
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHSubscription(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription)
        throws SystemException {
        ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(pk,
            ahSubscription.getPrimaryKey());
    }

    /**
     * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptionPKs the primary keys of the a h subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws SystemException {
        for (long ahSubscriptionPK : ahSubscriptionPKs) {
            ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(pk,
                ahSubscriptionPK);
        }
    }

    /**
     * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptions the a h subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHSubscriptions(long pk,
        List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions)
        throws SystemException {
        for (de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription : ahSubscriptions) {
            ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(pk,
                ahSubscription.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the a h cat entries and its a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries to clear the associated a h subscriptions from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearAHSubscriptions(long pk) throws SystemException {
        ahCatEntriesToAHSubscriptionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptionPK the primary key of the a h subscription
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHSubscription(long pk, long ahSubscriptionPK)
        throws SystemException {
        ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
            ahSubscriptionPK);
    }

    /**
     * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscription the a h subscription
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHSubscription(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription)
        throws SystemException {
        ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
            ahSubscription.getPrimaryKey());
    }

    /**
     * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptionPKs the primary keys of the a h subscriptions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHSubscriptions(long pk,
        List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions)
        throws SystemException {
        for (de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription : ahSubscriptions) {
            ahCatEntriesToAHSubscriptionTableMapper.deleteTableMapping(pk,
                ahSubscription.getPrimaryKey());
        }
    }

    /**
     * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptionPKs the primary keys of the a h subscriptions to be associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws SystemException {
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

        for (long newAHSubscriptionPK : newAHSubscriptionPKsSet) {
            ahCatEntriesToAHSubscriptionTableMapper.addTableMapping(pk,
                newAHSubscriptionPK);
        }
    }

    /**
     * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahSubscriptions the a h subscriptions to be associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setAHSubscriptions(long pk,
        List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions)
        throws SystemException {
        try {
            long[] ahSubscriptionPKs = new long[ahSubscriptions.size()];

            for (int i = 0; i < ahSubscriptions.size(); i++) {
                de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription =
                    ahSubscriptions.get(i);

                ahSubscriptionPKs[i] = ahSubscription.getPrimaryKey();
            }

            setAHSubscriptions(pk, ahSubscriptionPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(AHCatEntriesModelImpl.MAPPING_TABLE_ADHOC_SUB_CITM_NAME);
        }
    }

    /**
     * Returns all the a h offers associated with the a h cat entries.
     *
     * @param pk the primary key of the a h cat entries
     * @return the a h offers associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getAHOffers(
        long pk) throws SystemException {
        return getAHOffers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the a h offers associated with the a h cat entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the a h cat entries
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @return the range of a h offers associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getAHOffers(
        long pk, int start, int end) throws SystemException {
        return getAHOffers(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers associated with the a h cat entries.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the a h cat entries
     * @param start the lower bound of the range of a h cat entrieses
     * @param end the upper bound of the range of a h cat entrieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h offers associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getAHOffers(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return ahCatEntriesToAHOfferTableMapper.getRightBaseModels(pk, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of a h offers associated with the a h cat entries.
     *
     * @param pk the primary key of the a h cat entries
     * @return the number of a h offers associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getAHOffersSize(long pk) throws SystemException {
        long[] pks = ahCatEntriesToAHOfferTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the a h offer is associated with the a h cat entries.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOfferPK the primary key of the a h offer
     * @return <code>true</code> if the a h offer is associated with the a h cat entries; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsAHOffer(long pk, long ahOfferPK)
        throws SystemException {
        return ahCatEntriesToAHOfferTableMapper.containsTableMapping(pk,
            ahOfferPK);
    }

    /**
     * Returns <code>true</code> if the a h cat entries has any a h offers associated with it.
     *
     * @param pk the primary key of the a h cat entries to check for associations with a h offers
     * @return <code>true</code> if the a h cat entries has any a h offers associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsAHOffers(long pk) throws SystemException {
        if (getAHOffersSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOfferPK the primary key of the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHOffer(long pk, long ahOfferPK) throws SystemException {
        ahCatEntriesToAHOfferTableMapper.addTableMapping(pk, ahOfferPK);
    }

    /**
     * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOffer the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHOffer(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer)
        throws SystemException {
        ahCatEntriesToAHOfferTableMapper.addTableMapping(pk,
            ahOffer.getPrimaryKey());
    }

    /**
     * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOfferPKs the primary keys of the a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHOffers(long pk, long[] ahOfferPKs)
        throws SystemException {
        for (long ahOfferPK : ahOfferPKs) {
            ahCatEntriesToAHOfferTableMapper.addTableMapping(pk, ahOfferPK);
        }
    }

    /**
     * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOffers the a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHOffers(long pk,
        List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers)
        throws SystemException {
        for (de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer : ahOffers) {
            ahCatEntriesToAHOfferTableMapper.addTableMapping(pk,
                ahOffer.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the a h cat entries and its a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries to clear the associated a h offers from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearAHOffers(long pk) throws SystemException {
        ahCatEntriesToAHOfferTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOfferPK the primary key of the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHOffer(long pk, long ahOfferPK)
        throws SystemException {
        ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk, ahOfferPK);
    }

    /**
     * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOffer the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHOffer(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer)
        throws SystemException {
        ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk,
            ahOffer.getPrimaryKey());
    }

    /**
     * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOfferPKs the primary keys of the a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHOffers(long pk, long[] ahOfferPKs)
        throws SystemException {
        for (long ahOfferPK : ahOfferPKs) {
            ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk, ahOfferPK);
        }
    }

    /**
     * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOffers the a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHOffers(long pk,
        List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers)
        throws SystemException {
        for (de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer : ahOffers) {
            ahCatEntriesToAHOfferTableMapper.deleteTableMapping(pk,
                ahOffer.getPrimaryKey());
        }
    }

    /**
     * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOfferPKs the primary keys of the a h offers to be associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setAHOffers(long pk, long[] ahOfferPKs)
        throws SystemException {
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

        for (long newAHOfferPK : newAHOfferPKsSet) {
            ahCatEntriesToAHOfferTableMapper.addTableMapping(pk, newAHOfferPK);
        }
    }

    /**
     * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h cat entries
     * @param ahOffers the a h offers to be associated with the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setAHOffers(long pk,
        List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers)
        throws SystemException {
        try {
            long[] ahOfferPKs = new long[ahOffers.size()];

            for (int i = 0; i < ahOffers.size(); i++) {
                de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer = ahOffers.get(i);

                ahOfferPKs[i] = ahOffer.getPrimaryKey();
            }

            setAHOffers(pk, ahOfferPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(AHCatEntriesModelImpl.MAPPING_TABLE_ADHOC_OFFER_CITM_NAME);
        }
    }

    /**
     * Initializes the a h cat entries persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHCatEntries>> listenersList = new ArrayList<ModelListener<AHCatEntries>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHCatEntries>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        ahCatEntriesToAHSubscriptionTableMapper = TableMapperFactory.getTableMapper("ADHOC_sub_citm",
                "itemId", "subId", this, ahSubscriptionPersistence);

        ahCatEntriesToAHOfferTableMapper = TableMapperFactory.getTableMapper("ADHOC_offer_citm",
                "itemId", "offerId", this, ahOfferPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHCatEntriesImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
