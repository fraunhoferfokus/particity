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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException;
import de.fraunhofer.fokus.oefit.adhoc.model.AHCategories;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesImpl;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHCategoriesPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the a h categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCategoriesPersistence
 * @see AHCategoriesUtil
 * @generated
 */
public class AHCategoriesPersistenceImpl extends BasePersistenceImpl<AHCategories>
    implements AHCategoriesPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AHCategoriesUtil} to access the a h categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AHCategoriesImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, AHCategoriesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, AHCategoriesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDTYPE =
        new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, AHCategoriesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynameAndType",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDTYPE =
        new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, AHCategoriesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynameAndType",
            new String[] { String.class.getName(), Integer.class.getName() },
            AHCategoriesModelImpl.NAME_COLUMN_BITMASK |
            AHCategoriesModelImpl.TYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDTYPE = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynameAndType",
            new String[] { String.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_NAMEANDTYPE_NAME_1 = "ahCategories.name IS NULL AND ";
    private static final String _FINDER_COLUMN_NAMEANDTYPE_NAME_2 = "ahCategories.name = ? AND ";
    private static final String _FINDER_COLUMN_NAMEANDTYPE_NAME_3 = "(ahCategories.name IS NULL OR ahCategories.name = '') AND ";
    private static final String _FINDER_COLUMN_NAMEANDTYPE_TYPE_2 = "ahCategories.type = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, AHCategoriesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytype",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, AHCategoriesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytype",
            new String[] { Integer.class.getName() },
            AHCategoriesModelImpl.TYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytype",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "ahCategories.type = ?";
    private static final String _SQL_SELECT_AHCATEGORIES = "SELECT ahCategories FROM AHCategories ahCategories";
    private static final String _SQL_SELECT_AHCATEGORIES_WHERE = "SELECT ahCategories FROM AHCategories ahCategories WHERE ";
    private static final String _SQL_COUNT_AHCATEGORIES = "SELECT COUNT(ahCategories) FROM AHCategories ahCategories";
    private static final String _SQL_COUNT_AHCATEGORIES_WHERE = "SELECT COUNT(ahCategories) FROM AHCategories ahCategories WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahCategories.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHCategories exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHCategories exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHCategoriesPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static AHCategories _nullAHCategories = new AHCategoriesImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHCategories> toCacheModel() {
                return _nullAHCategoriesCacheModel;
            }
        };

    private static CacheModel<AHCategories> _nullAHCategoriesCacheModel = new CacheModel<AHCategories>() {
            @Override
            public AHCategories toEntityModel() {
                return _nullAHCategories;
            }
        };

    public AHCategoriesPersistenceImpl() {
        setModelClass(AHCategories.class);
    }

    /**
     * Returns all the a h categorieses where name = &#63; and type = &#63;.
     *
     * @param name the name
     * @param type the type
     * @return the matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findBynameAndType(String name, int type)
        throws SystemException {
        return findBynameAndType(name, type, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h categorieses where name = &#63; and type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param type the type
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @return the range of matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findBynameAndType(String name, int type,
        int start, int end) throws SystemException {
        return findBynameAndType(name, type, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h categorieses where name = &#63; and type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param type the type
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findBynameAndType(String name, int type,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDTYPE;
            finderArgs = new Object[] { name, type };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDTYPE;
            finderArgs = new Object[] { name, type, start, end, orderByComparator };
        }

        List<AHCategories> list = (List<AHCategories>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHCategories ahCategories : list) {
                if (!Validator.equals(name, ahCategories.getName()) ||
                        (type != ahCategories.getType())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_AHCATEGORIES_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_2);
            }

            query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHCategoriesModelImpl.ORDER_BY_JPQL);
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

                qPos.add(type);

                if (!pagination) {
                    list = (List<AHCategories>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCategories>(list);
                } else {
                    list = (List<AHCategories>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h categories in the ordered set where name = &#63; and type = &#63;.
     *
     * @param name the name
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories findBynameAndType_First(String name, int type,
        OrderByComparator orderByComparator)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = fetchBynameAndType_First(name, type,
                orderByComparator);

        if (ahCategories != null) {
            return ahCategories;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(", type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHCategoriesException(msg.toString());
    }

    /**
     * Returns the first a h categories in the ordered set where name = &#63; and type = &#63;.
     *
     * @param name the name
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h categories, or <code>null</code> if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories fetchBynameAndType_First(String name, int type,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHCategories> list = findBynameAndType(name, type, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h categories in the ordered set where name = &#63; and type = &#63;.
     *
     * @param name the name
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories findBynameAndType_Last(String name, int type,
        OrderByComparator orderByComparator)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = fetchBynameAndType_Last(name, type,
                orderByComparator);

        if (ahCategories != null) {
            return ahCategories;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("name=");
        msg.append(name);

        msg.append(", type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHCategoriesException(msg.toString());
    }

    /**
     * Returns the last a h categories in the ordered set where name = &#63; and type = &#63;.
     *
     * @param name the name
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h categories, or <code>null</code> if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories fetchBynameAndType_Last(String name, int type,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBynameAndType(name, type);

        if (count == 0) {
            return null;
        }

        List<AHCategories> list = findBynameAndType(name, type, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h categorieses before and after the current a h categories in the ordered set where name = &#63; and type = &#63;.
     *
     * @param catId the primary key of the current a h categories
     * @param name the name
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories[] findBynameAndType_PrevAndNext(long catId,
        String name, int type, OrderByComparator orderByComparator)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = findByPrimaryKey(catId);

        Session session = null;

        try {
            session = openSession();

            AHCategories[] array = new AHCategoriesImpl[3];

            array[0] = getBynameAndType_PrevAndNext(session, ahCategories,
                    name, type, orderByComparator, true);

            array[1] = ahCategories;

            array[2] = getBynameAndType_PrevAndNext(session, ahCategories,
                    name, type, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHCategories getBynameAndType_PrevAndNext(Session session,
        AHCategories ahCategories, String name, int type,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHCATEGORIES_WHERE);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_3);
        } else {
            bindName = true;

            query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_2);
        }

        query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_2);

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
            query.append(AHCategoriesModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindName) {
            qPos.add(name);
        }

        qPos.add(type);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahCategories);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHCategories> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h categorieses where name = &#63; and type = &#63; from the database.
     *
     * @param name the name
     * @param type the type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBynameAndType(String name, int type)
        throws SystemException {
        for (AHCategories ahCategories : findBynameAndType(name, type,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(ahCategories);
        }
    }

    /**
     * Returns the number of a h categorieses where name = &#63; and type = &#63;.
     *
     * @param name the name
     * @param type the type
     * @return the number of matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBynameAndType(String name, int type)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDTYPE;

        Object[] finderArgs = new Object[] { name, type };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_AHCATEGORIES_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_2);
            }

            query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                qPos.add(type);

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
     * Returns all the a h categorieses where type = &#63;.
     *
     * @param type the type
     * @return the matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findBytype(int type) throws SystemException {
        return findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h categorieses where type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param type the type
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @return the range of matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findBytype(int type, int start, int end)
        throws SystemException {
        return findBytype(type, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h categorieses where type = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param type the type
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findBytype(int type, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
            finderArgs = new Object[] { type };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
            finderArgs = new Object[] { type, start, end, orderByComparator };
        }

        List<AHCategories> list = (List<AHCategories>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHCategories ahCategories : list) {
                if ((type != ahCategories.getType())) {
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

            query.append(_SQL_SELECT_AHCATEGORIES_WHERE);

            query.append(_FINDER_COLUMN_TYPE_TYPE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHCategoriesModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type);

                if (!pagination) {
                    list = (List<AHCategories>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCategories>(list);
                } else {
                    list = (List<AHCategories>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h categories in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories findBytype_First(int type,
        OrderByComparator orderByComparator)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = fetchBytype_First(type, orderByComparator);

        if (ahCategories != null) {
            return ahCategories;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHCategoriesException(msg.toString());
    }

    /**
     * Returns the first a h categories in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h categories, or <code>null</code> if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories fetchBytype_First(int type,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHCategories> list = findBytype(type, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h categories in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories findBytype_Last(int type,
        OrderByComparator orderByComparator)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = fetchBytype_Last(type, orderByComparator);

        if (ahCategories != null) {
            return ahCategories;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("type=");
        msg.append(type);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHCategoriesException(msg.toString());
    }

    /**
     * Returns the last a h categories in the ordered set where type = &#63;.
     *
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h categories, or <code>null</code> if a matching a h categories could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories fetchBytype_Last(int type,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBytype(type);

        if (count == 0) {
            return null;
        }

        List<AHCategories> list = findBytype(type, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h categorieses before and after the current a h categories in the ordered set where type = &#63;.
     *
     * @param catId the primary key of the current a h categories
     * @param type the type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories[] findBytype_PrevAndNext(long catId, int type,
        OrderByComparator orderByComparator)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = findByPrimaryKey(catId);

        Session session = null;

        try {
            session = openSession();

            AHCategories[] array = new AHCategoriesImpl[3];

            array[0] = getBytype_PrevAndNext(session, ahCategories, type,
                    orderByComparator, true);

            array[1] = ahCategories;

            array[2] = getBytype_PrevAndNext(session, ahCategories, type,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHCategories getBytype_PrevAndNext(Session session,
        AHCategories ahCategories, int type,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHCATEGORIES_WHERE);

        query.append(_FINDER_COLUMN_TYPE_TYPE_2);

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
            query.append(AHCategoriesModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(type);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahCategories);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHCategories> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h categorieses where type = &#63; from the database.
     *
     * @param type the type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBytype(int type) throws SystemException {
        for (AHCategories ahCategories : findBytype(type, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahCategories);
        }
    }

    /**
     * Returns the number of a h categorieses where type = &#63;.
     *
     * @param type the type
     * @return the number of matching a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBytype(int type) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

        Object[] finderArgs = new Object[] { type };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHCATEGORIES_WHERE);

            query.append(_FINDER_COLUMN_TYPE_TYPE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type);

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
     * Caches the a h categories in the entity cache if it is enabled.
     *
     * @param ahCategories the a h categories
     */
    @Override
    public void cacheResult(AHCategories ahCategories) {
        EntityCacheUtil.putResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesImpl.class, ahCategories.getPrimaryKey(), ahCategories);

        ahCategories.resetOriginalValues();
    }

    /**
     * Caches the a h categorieses in the entity cache if it is enabled.
     *
     * @param ahCategorieses the a h categorieses
     */
    @Override
    public void cacheResult(List<AHCategories> ahCategorieses) {
        for (AHCategories ahCategories : ahCategorieses) {
            if (EntityCacheUtil.getResult(
                        AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
                        AHCategoriesImpl.class, ahCategories.getPrimaryKey()) == null) {
                cacheResult(ahCategories);
            } else {
                ahCategories.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h categorieses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHCategoriesImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHCategoriesImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHCategories ahCategories) {
        EntityCacheUtil.removeResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesImpl.class, ahCategories.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHCategories> ahCategorieses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHCategories ahCategories : ahCategorieses) {
            EntityCacheUtil.removeResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
                AHCategoriesImpl.class, ahCategories.getPrimaryKey());
        }
    }

    /**
     * Creates a new a h categories with the primary key. Does not add the a h categories to the database.
     *
     * @param catId the primary key for the new a h categories
     * @return the new a h categories
     */
    @Override
    public AHCategories create(long catId) {
        AHCategories ahCategories = new AHCategoriesImpl();

        ahCategories.setNew(true);
        ahCategories.setPrimaryKey(catId);

        return ahCategories;
    }

    /**
     * Removes the a h categories with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param catId the primary key of the a h categories
     * @return the a h categories that was removed
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories remove(long catId)
        throws NoSuchAHCategoriesException, SystemException {
        return remove((Serializable) catId);
    }

    /**
     * Removes the a h categories with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h categories
     * @return the a h categories that was removed
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories remove(Serializable primaryKey)
        throws NoSuchAHCategoriesException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHCategories ahCategories = (AHCategories) session.get(AHCategoriesImpl.class,
                    primaryKey);

            if (ahCategories == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahCategories);
        } catch (NoSuchAHCategoriesException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHCategories removeImpl(AHCategories ahCategories)
        throws SystemException {
        ahCategories = toUnwrappedModel(ahCategories);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahCategories)) {
                ahCategories = (AHCategories) session.get(AHCategoriesImpl.class,
                        ahCategories.getPrimaryKeyObj());
            }

            if (ahCategories != null) {
                session.delete(ahCategories);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahCategories != null) {
            clearCache(ahCategories);
        }

        return ahCategories;
    }

    @Override
    public AHCategories updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCategories ahCategories)
        throws SystemException {
        ahCategories = toUnwrappedModel(ahCategories);

        boolean isNew = ahCategories.isNew();

        AHCategoriesModelImpl ahCategoriesModelImpl = (AHCategoriesModelImpl) ahCategories;

        Session session = null;

        try {
            session = openSession();

            if (ahCategories.isNew()) {
                session.save(ahCategories);

                ahCategories.setNew(false);
            } else {
                session.merge(ahCategories);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AHCategoriesModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((ahCategoriesModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahCategoriesModelImpl.getOriginalName(),
                        ahCategoriesModelImpl.getOriginalType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDTYPE,
                    args);

                args = new Object[] {
                        ahCategoriesModelImpl.getName(),
                        ahCategoriesModelImpl.getType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDTYPE,
                    args);
            }

            if ((ahCategoriesModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahCategoriesModelImpl.getOriginalType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
                    args);

                args = new Object[] { ahCategoriesModelImpl.getType() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
                    args);
            }
        }

        EntityCacheUtil.putResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
            AHCategoriesImpl.class, ahCategories.getPrimaryKey(), ahCategories);

        return ahCategories;
    }

    protected AHCategories toUnwrappedModel(AHCategories ahCategories) {
        if (ahCategories instanceof AHCategoriesImpl) {
            return ahCategories;
        }

        AHCategoriesImpl ahCategoriesImpl = new AHCategoriesImpl();

        ahCategoriesImpl.setNew(ahCategories.isNew());
        ahCategoriesImpl.setPrimaryKey(ahCategories.getPrimaryKey());

        ahCategoriesImpl.setCatId(ahCategories.getCatId());
        ahCategoriesImpl.setName(ahCategories.getName());
        ahCategoriesImpl.setDescr(ahCategories.getDescr());
        ahCategoriesImpl.setType(ahCategories.getType());

        return ahCategoriesImpl;
    }

    /**
     * Returns the a h categories with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h categories
     * @return the a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHCategoriesException, SystemException {
        AHCategories ahCategories = fetchByPrimaryKey(primaryKey);

        if (ahCategories == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHCategoriesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahCategories;
    }

    /**
     * Returns the a h categories with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException} if it could not be found.
     *
     * @param catId the primary key of the a h categories
     * @return the a h categories
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories findByPrimaryKey(long catId)
        throws NoSuchAHCategoriesException, SystemException {
        return findByPrimaryKey((Serializable) catId);
    }

    /**
     * Returns the a h categories with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h categories
     * @return the a h categories, or <code>null</code> if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHCategories ahCategories = (AHCategories) EntityCacheUtil.getResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
                AHCategoriesImpl.class, primaryKey);

        if (ahCategories == _nullAHCategories) {
            return null;
        }

        if (ahCategories == null) {
            Session session = null;

            try {
                session = openSession();

                ahCategories = (AHCategories) session.get(AHCategoriesImpl.class,
                        primaryKey);

                if (ahCategories != null) {
                    cacheResult(ahCategories);
                } else {
                    EntityCacheUtil.putResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
                        AHCategoriesImpl.class, primaryKey, _nullAHCategories);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHCategoriesModelImpl.ENTITY_CACHE_ENABLED,
                    AHCategoriesImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return ahCategories;
    }

    /**
     * Returns the a h categories with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param catId the primary key of the a h categories
     * @return the a h categories, or <code>null</code> if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories fetchByPrimaryKey(long catId) throws SystemException {
        return fetchByPrimaryKey((Serializable) catId);
    }

    /**
     * Returns all the a h categorieses.
     *
     * @return the a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h categorieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @return the range of a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h categorieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> findAll(int start, int end,
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

        List<AHCategories> list = (List<AHCategories>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHCATEGORIES);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AHCATEGORIES;

                if (pagination) {
                    sql = sql.concat(AHCategoriesModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AHCategories>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHCategories>(list);
                } else {
                    list = (List<AHCategories>) QueryUtil.list(q, getDialect(),
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
     * Removes all the a h categorieses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHCategories ahCategories : findAll()) {
            remove(ahCategories);
        }
    }

    /**
     * Returns the number of a h categorieses.
     *
     * @return the number of a h categorieses
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

                Query q = session.createQuery(_SQL_COUNT_AHCATEGORIES);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the a h categories persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.adhoc.model.AHCategories")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHCategories>> listenersList = new ArrayList<ModelListener<AHCategories>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHCategories>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHCategoriesImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
