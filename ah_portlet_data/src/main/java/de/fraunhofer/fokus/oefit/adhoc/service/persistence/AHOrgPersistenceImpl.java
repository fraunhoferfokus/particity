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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;
import de.fraunhofer.fokus.oefit.adhoc.model.AHOrg;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgImpl;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHOrgPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the a h org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOrgPersistence
 * @see AHOrgUtil
 * @generated
 */
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
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "ahOrg.status = ?";
    private static final String _SQL_SELECT_AHORG = "SELECT ahOrg FROM AHOrg ahOrg";
    private static final String _SQL_SELECT_AHORG_WHERE = "SELECT ahOrg FROM AHOrg ahOrg WHERE ";
    private static final String _SQL_COUNT_AHORG = "SELECT COUNT(ahOrg) FROM AHOrg ahOrg";
    private static final String _SQL_COUNT_AHORG_WHERE = "SELECT COUNT(ahOrg) FROM AHOrg ahOrg WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahOrg.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHOrg exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHOrg exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHOrgPersistenceImpl.class);
    private static AHOrg _nullAHOrg = new AHOrgImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHOrg> toCacheModel() {
                return _nullAHOrgCacheModel;
            }
        };

    private static CacheModel<AHOrg> _nullAHOrgCacheModel = new CacheModel<AHOrg>() {
            @Override
            public AHOrg toEntityModel() {
                return _nullAHOrg;
            }
        };

    public AHOrgPersistenceImpl() {
        setModelClass(AHOrg.class);
    }

    /**
     * Returns all the a h orgs where name = &#63;.
     *
     * @param name the name
     * @return the matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findByname(String name) throws SystemException {
        return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h orgs where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @return the range of matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findByname(String name, int start, int end)
        throws SystemException {
        return findByname(name, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h orgs where name = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param name the name
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findByname(String name, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { name, start, end, orderByComparator };
        }

        List<AHOrg> list = (List<AHOrg>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOrg ahOrg : list) {
                if (!Validator.equals(name, ahOrg.getName())) {
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

            query.append(_SQL_SELECT_AHORG_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
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
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOrg>(list);
                } else {
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first a h org in the ordered set where name = &#63;.
     *
     * @param name the name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h org
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findByname_First(String name,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchByname_First(String name,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findByname_Last(String name,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchByname_Last(String name,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg[] findByname_PrevAndNext(long orgId, String name,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOrg getByname_PrevAndNext(Session session, AHOrg ahOrg,
        String name, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHORG_WHERE);

        boolean bindName = false;

        if (name == null) {
            query.append(_FINDER_COLUMN_NAME_NAME_1);
        } else if (name.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_NAME_3);
        } else {
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
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h orgs where name = &#63; from the database.
     *
     * @param name the name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByname(String name) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByname(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHORG_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
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
     * Returns all the a h orgs where owner = &#63;.
     *
     * @param owner the owner
     * @return the matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findByowner(String owner) throws SystemException {
        return findByowner(owner, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h orgs where owner = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param owner the owner
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @return the range of matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findByowner(String owner, int start, int end)
        throws SystemException {
        return findByowner(owner, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h orgs where owner = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param owner the owner
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findByowner(String owner, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER;
            finderArgs = new Object[] { owner };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OWNER;
            finderArgs = new Object[] { owner, start, end, orderByComparator };
        }

        List<AHOrg> list = (List<AHOrg>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOrg ahOrg : list) {
                if (!Validator.equals(owner, ahOrg.getOwner())) {
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

            query.append(_SQL_SELECT_AHORG_WHERE);

            boolean bindOwner = false;

            if (owner == null) {
                query.append(_FINDER_COLUMN_OWNER_OWNER_1);
            } else if (owner.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_OWNER_OWNER_3);
            } else {
                bindOwner = true;

                query.append(_FINDER_COLUMN_OWNER_OWNER_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
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
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOrg>(list);
                } else {
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first a h org in the ordered set where owner = &#63;.
     *
     * @param owner the owner
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h org
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findByowner_First(String owner,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchByowner_First(String owner,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findByowner_Last(String owner,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchByowner_Last(String owner,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg[] findByowner_PrevAndNext(long orgId, String owner,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOrg getByowner_PrevAndNext(Session session, AHOrg ahOrg,
        String owner, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHORG_WHERE);

        boolean bindOwner = false;

        if (owner == null) {
            query.append(_FINDER_COLUMN_OWNER_OWNER_1);
        } else if (owner.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_OWNER_OWNER_3);
        } else {
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
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h orgs where owner = &#63; from the database.
     *
     * @param owner the owner
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByowner(String owner) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByowner(String owner) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_OWNER;

        Object[] finderArgs = new Object[] { owner };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHORG_WHERE);

            boolean bindOwner = false;

            if (owner == null) {
                query.append(_FINDER_COLUMN_OWNER_OWNER_1);
            } else if (owner.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_OWNER_OWNER_3);
            } else {
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
     * Returns all the a h orgs where status = &#63;.
     *
     * @param status the status
     * @return the matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findBystatus(int status) throws SystemException {
        return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h orgs where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @return the range of matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findBystatus(int status, int start, int end)
        throws SystemException {
        return findBystatus(status, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h orgs where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findBystatus(int status, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status, start, end, orderByComparator };
        }

        List<AHOrg> list = (List<AHOrg>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOrg ahOrg : list) {
                if ((status != ahOrg.getStatus())) {
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

            query.append(_SQL_SELECT_AHORG_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
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
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOrg>(list);
                } else {
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first a h org in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h org
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findBystatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchBystatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findBystatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchBystatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg[] findBystatus_PrevAndNext(long orgId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchAHOrgException, SystemException {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOrg getBystatus_PrevAndNext(Session session, AHOrg ahOrg,
        int status, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
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
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h orgs where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBystatus(int status) throws SystemException {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBystatus(int status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

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
     * Caches the a h org in the entity cache if it is enabled.
     *
     * @param ahOrg the a h org
     */
    @Override
    public void cacheResult(AHOrg ahOrg) {
        EntityCacheUtil.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
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
            if (EntityCacheUtil.getResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
                        AHOrgImpl.class, ahOrg.getPrimaryKey()) == null) {
                cacheResult(ahOrg);
            } else {
                ahOrg.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h orgs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHOrgImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHOrgImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h org.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHOrg ahOrg) {
        EntityCacheUtil.removeResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
            AHOrgImpl.class, ahOrg.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHOrg> ahOrgs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHOrg ahOrg : ahOrgs) {
            EntityCacheUtil.removeResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg remove(long orgId)
        throws NoSuchAHOrgException, SystemException {
        return remove((Serializable) orgId);
    }

    /**
     * Removes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h org
     * @return the a h org that was removed
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg remove(Serializable primaryKey)
        throws NoSuchAHOrgException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHOrg ahOrg = (AHOrg) session.get(AHOrgImpl.class, primaryKey);

            if (ahOrg == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahOrg);
        } catch (NoSuchAHOrgException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHOrg removeImpl(AHOrg ahOrg) throws SystemException {
        ahOrg = toUnwrappedModel(ahOrg);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahOrg)) {
                ahOrg = (AHOrg) session.get(AHOrgImpl.class,
                        ahOrg.getPrimaryKeyObj());
            }

            if (ahOrg != null) {
                session.delete(ahOrg);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahOrg != null) {
            clearCache(ahOrg);
        }

        return ahOrg;
    }

    @Override
    public AHOrg updateImpl(de.fraunhofer.fokus.oefit.adhoc.model.AHOrg ahOrg)
        throws SystemException {
        ahOrg = toUnwrappedModel(ahOrg);

        boolean isNew = ahOrg.isNew();

        AHOrgModelImpl ahOrgModelImpl = (AHOrgModelImpl) ahOrg;

        Session session = null;

        try {
            session = openSession();

            if (ahOrg.isNew()) {
                session.save(ahOrg);

                ahOrg.setNew(false);
            } else {
                session.merge(ahOrg);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AHOrgModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((ahOrgModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahOrgModelImpl.getOriginalName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { ahOrgModelImpl.getName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }

            if ((ahOrgModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahOrgModelImpl.getOriginalOwner() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER,
                    args);

                args = new Object[] { ahOrgModelImpl.getOwner() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OWNER, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OWNER,
                    args);
            }

            if ((ahOrgModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahOrgModelImpl.getOriginalStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { ahOrgModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }
        }

        EntityCacheUtil.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
            AHOrgImpl.class, ahOrg.getPrimaryKey(), ahOrg);

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
     * Returns the a h org with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h org
     * @return the a h org
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHOrgException, SystemException {
        AHOrg ahOrg = fetchByPrimaryKey(primaryKey);

        if (ahOrg == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahOrg;
    }

    /**
     * Returns the a h org with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException} if it could not be found.
     *
     * @param orgId the primary key of the a h org
     * @return the a h org
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg findByPrimaryKey(long orgId)
        throws NoSuchAHOrgException, SystemException {
        return findByPrimaryKey((Serializable) orgId);
    }

    /**
     * Returns the a h org with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h org
     * @return the a h org, or <code>null</code> if a a h org with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHOrg ahOrg = (AHOrg) EntityCacheUtil.getResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
                AHOrgImpl.class, primaryKey);

        if (ahOrg == _nullAHOrg) {
            return null;
        }

        if (ahOrg == null) {
            Session session = null;

            try {
                session = openSession();

                ahOrg = (AHOrg) session.get(AHOrgImpl.class, primaryKey);

                if (ahOrg != null) {
                    cacheResult(ahOrg);
                } else {
                    EntityCacheUtil.putResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
                        AHOrgImpl.class, primaryKey, _nullAHOrg);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHOrgModelImpl.ENTITY_CACHE_ENABLED,
                    AHOrgImpl.class, primaryKey);

                throw processException(e);
            } finally {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOrg fetchByPrimaryKey(long orgId) throws SystemException {
        return fetchByPrimaryKey((Serializable) orgId);
    }

    /**
     * Returns all the a h orgs.
     *
     * @return the a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h orgs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @return the range of a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h orgs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h orgs
     * @param end the upper bound of the range of a h orgs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h orgs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOrg> findAll(int start, int end,
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

        List<AHOrg> list = (List<AHOrg>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHORG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
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
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOrg>(list);
                } else {
                    list = (List<AHOrg>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the a h orgs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHOrg ahOrg : findAll()) {
            remove(ahOrg);
        }
    }

    /**
     * Returns the number of a h orgs.
     *
     * @return the number of a h orgs
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

                Query q = session.createQuery(_SQL_COUNT_AHORG);

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
     * Initializes the a h org persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.adhoc.model.AHOrg")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHOrg>> listenersList = new ArrayList<ModelListener<AHOrg>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHOrg>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHOrgImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
