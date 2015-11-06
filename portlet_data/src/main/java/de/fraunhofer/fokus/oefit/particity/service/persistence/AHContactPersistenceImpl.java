package de.fraunhofer.fokus.oefit.particity.service.persistence;

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

import de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;
import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHContactImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHContactPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the a h contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHContactPersistence
 * @see AHContactUtil
 * @generated
 */
public class AHContactPersistenceImpl extends BasePersistenceImpl<AHContact>
    implements AHContactPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AHContactUtil} to access the a h contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AHContactImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, AHContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, AHContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, AHContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemail",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, AHContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemail",
            new String[] { String.class.getName() },
            AHContactModelImpl.EMAIL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemail",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "ahContact.email IS NULL";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "ahContact.email = ?";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(ahContact.email IS NULL OR ahContact.email = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, AHContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, AHContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
            new String[] { String.class.getName(), String.class.getName() },
            AHContactModelImpl.FORENAME_COLUMN_BITMASK |
            AHContactModelImpl.SURNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_FORENAME_1 = "ahContact.forename IS NULL AND ";
    private static final String _FINDER_COLUMN_NAME_FORENAME_2 = "ahContact.forename = ? AND ";
    private static final String _FINDER_COLUMN_NAME_FORENAME_3 = "(ahContact.forename IS NULL OR ahContact.forename = '') AND ";
    private static final String _FINDER_COLUMN_NAME_SURNAME_1 = "ahContact.surname IS NULL";
    private static final String _FINDER_COLUMN_NAME_SURNAME_2 = "ahContact.surname = ?";
    private static final String _FINDER_COLUMN_NAME_SURNAME_3 = "(ahContact.surname IS NULL OR ahContact.surname = '')";
    private static final String _SQL_SELECT_AHCONTACT = "SELECT ahContact FROM AHContact ahContact";
    private static final String _SQL_SELECT_AHCONTACT_WHERE = "SELECT ahContact FROM AHContact ahContact WHERE ";
    private static final String _SQL_COUNT_AHCONTACT = "SELECT COUNT(ahContact) FROM AHContact ahContact";
    private static final String _SQL_COUNT_AHCONTACT_WHERE = "SELECT COUNT(ahContact) FROM AHContact ahContact WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahContact.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHContact exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHContact exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHContactPersistenceImpl.class);
    private static AHContact _nullAHContact = new AHContactImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHContact> toCacheModel() {
                return _nullAHContactCacheModel;
            }
        };

    private static CacheModel<AHContact> _nullAHContactCacheModel = new CacheModel<AHContact>() {
            @Override
            public AHContact toEntityModel() {
                return _nullAHContact;
            }
        };

    public AHContactPersistenceImpl() {
        setModelClass(AHContact.class);
    }

    /**
     * Returns all the a h contacts where email = &#63;.
     *
     * @param email the email
     * @return the matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findByemail(String email) throws SystemException {
        return findByemail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h contacts where email = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param email the email
     * @param start the lower bound of the range of a h contacts
     * @param end the upper bound of the range of a h contacts (not inclusive)
     * @return the range of matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findByemail(String email, int start, int end)
        throws SystemException {
        return findByemail(email, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h contacts where email = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param email the email
     * @param start the lower bound of the range of a h contacts
     * @param end the upper bound of the range of a h contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findByemail(String email, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email, start, end, orderByComparator };
        }

        List<AHContact> list = (List<AHContact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHContact ahContact : list) {
                if (!Validator.equals(email, ahContact.getEmail())) {
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

            query.append(_SQL_SELECT_AHCONTACT_WHERE);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
                bindEmail = true;

                query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHContactModelImpl.ORDER_BY_JPQL);
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
                    list = (List<AHContact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHContact>(list);
                } else {
                    list = (List<AHContact>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h contact in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact findByemail_First(String email,
        OrderByComparator orderByComparator)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = fetchByemail_First(email, orderByComparator);

        if (ahContact != null) {
            return ahContact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHContactException(msg.toString());
    }

    /**
     * Returns the first a h contact in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h contact, or <code>null</code> if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact fetchByemail_First(String email,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHContact> list = findByemail(email, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h contact in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact findByemail_Last(String email,
        OrderByComparator orderByComparator)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = fetchByemail_Last(email, orderByComparator);

        if (ahContact != null) {
            return ahContact;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHContactException(msg.toString());
    }

    /**
     * Returns the last a h contact in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h contact, or <code>null</code> if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact fetchByemail_Last(String email,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByemail(email);

        if (count == 0) {
            return null;
        }

        List<AHContact> list = findByemail(email, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h contacts before and after the current a h contact in the ordered set where email = &#63;.
     *
     * @param contactId the primary key of the current a h contact
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact[] findByemail_PrevAndNext(long contactId, String email,
        OrderByComparator orderByComparator)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            AHContact[] array = new AHContactImpl[3];

            array[0] = getByemail_PrevAndNext(session, ahContact, email,
                    orderByComparator, true);

            array[1] = ahContact;

            array[2] = getByemail_PrevAndNext(session, ahContact, email,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHContact getByemail_PrevAndNext(Session session,
        AHContact ahContact, String email, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHCONTACT_WHERE);

        boolean bindEmail = false;

        if (email == null) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
        } else if (email.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
        } else {
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
            query.append(AHContactModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(ahContact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHContact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h contacts where email = &#63; from the database.
     *
     * @param email the email
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByemail(String email) throws SystemException {
        for (AHContact ahContact : findByemail(email, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahContact);
        }
    }

    /**
     * Returns the number of a h contacts where email = &#63;.
     *
     * @param email the email
     * @return the number of matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByemail(String email) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

        Object[] finderArgs = new Object[] { email };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHCONTACT_WHERE);

            boolean bindEmail = false;

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
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
     * Returns all the a h contacts where forename = &#63; and surname = &#63;.
     *
     * @param forename the forename
     * @param surname the surname
     * @return the matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findByname(String forename, String surname)
        throws SystemException {
        return findByname(forename, surname, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h contacts where forename = &#63; and surname = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param forename the forename
     * @param surname the surname
     * @param start the lower bound of the range of a h contacts
     * @param end the upper bound of the range of a h contacts (not inclusive)
     * @return the range of matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findByname(String forename, String surname,
        int start, int end) throws SystemException {
        return findByname(forename, surname, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h contacts where forename = &#63; and surname = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param forename the forename
     * @param surname the surname
     * @param start the lower bound of the range of a h contacts
     * @param end the upper bound of the range of a h contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findByname(String forename, String surname,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { forename, surname };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] {
                    forename, surname,
                    
                    start, end, orderByComparator
                };
        }

        List<AHContact> list = (List<AHContact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHContact ahContact : list) {
                if (!Validator.equals(forename, ahContact.getForename()) ||
                        !Validator.equals(surname, ahContact.getSurname())) {
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

            query.append(_SQL_SELECT_AHCONTACT_WHERE);

            boolean bindForename = false;

            if (forename == null) {
                query.append(_FINDER_COLUMN_NAME_FORENAME_1);
            } else if (forename.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_FORENAME_3);
            } else {
                bindForename = true;

                query.append(_FINDER_COLUMN_NAME_FORENAME_2);
            }

            boolean bindSurname = false;

            if (surname == null) {
                query.append(_FINDER_COLUMN_NAME_SURNAME_1);
            } else if (surname.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_SURNAME_3);
            } else {
                bindSurname = true;

                query.append(_FINDER_COLUMN_NAME_SURNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHContactModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindForename) {
                    qPos.add(forename);
                }

                if (bindSurname) {
                    qPos.add(surname);
                }

                if (!pagination) {
                    list = (List<AHContact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHContact>(list);
                } else {
                    list = (List<AHContact>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h contact in the ordered set where forename = &#63; and surname = &#63;.
     *
     * @param forename the forename
     * @param surname the surname
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact findByname_First(String forename, String surname,
        OrderByComparator orderByComparator)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = fetchByname_First(forename, surname,
                orderByComparator);

        if (ahContact != null) {
            return ahContact;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("forename=");
        msg.append(forename);

        msg.append(", surname=");
        msg.append(surname);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHContactException(msg.toString());
    }

    /**
     * Returns the first a h contact in the ordered set where forename = &#63; and surname = &#63;.
     *
     * @param forename the forename
     * @param surname the surname
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h contact, or <code>null</code> if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact fetchByname_First(String forename, String surname,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHContact> list = findByname(forename, surname, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h contact in the ordered set where forename = &#63; and surname = &#63;.
     *
     * @param forename the forename
     * @param surname the surname
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact findByname_Last(String forename, String surname,
        OrderByComparator orderByComparator)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = fetchByname_Last(forename, surname,
                orderByComparator);

        if (ahContact != null) {
            return ahContact;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("forename=");
        msg.append(forename);

        msg.append(", surname=");
        msg.append(surname);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHContactException(msg.toString());
    }

    /**
     * Returns the last a h contact in the ordered set where forename = &#63; and surname = &#63;.
     *
     * @param forename the forename
     * @param surname the surname
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h contact, or <code>null</code> if a matching a h contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact fetchByname_Last(String forename, String surname,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByname(forename, surname);

        if (count == 0) {
            return null;
        }

        List<AHContact> list = findByname(forename, surname, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h contacts before and after the current a h contact in the ordered set where forename = &#63; and surname = &#63;.
     *
     * @param contactId the primary key of the current a h contact
     * @param forename the forename
     * @param surname the surname
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact[] findByname_PrevAndNext(long contactId, String forename,
        String surname, OrderByComparator orderByComparator)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = findByPrimaryKey(contactId);

        Session session = null;

        try {
            session = openSession();

            AHContact[] array = new AHContactImpl[3];

            array[0] = getByname_PrevAndNext(session, ahContact, forename,
                    surname, orderByComparator, true);

            array[1] = ahContact;

            array[2] = getByname_PrevAndNext(session, ahContact, forename,
                    surname, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHContact getByname_PrevAndNext(Session session,
        AHContact ahContact, String forename, String surname,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHCONTACT_WHERE);

        boolean bindForename = false;

        if (forename == null) {
            query.append(_FINDER_COLUMN_NAME_FORENAME_1);
        } else if (forename.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_FORENAME_3);
        } else {
            bindForename = true;

            query.append(_FINDER_COLUMN_NAME_FORENAME_2);
        }

        boolean bindSurname = false;

        if (surname == null) {
            query.append(_FINDER_COLUMN_NAME_SURNAME_1);
        } else if (surname.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_NAME_SURNAME_3);
        } else {
            bindSurname = true;

            query.append(_FINDER_COLUMN_NAME_SURNAME_2);
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
            query.append(AHContactModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindForename) {
            qPos.add(forename);
        }

        if (bindSurname) {
            qPos.add(surname);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahContact);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHContact> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h contacts where forename = &#63; and surname = &#63; from the database.
     *
     * @param forename the forename
     * @param surname the surname
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByname(String forename, String surname)
        throws SystemException {
        for (AHContact ahContact : findByname(forename, surname,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(ahContact);
        }
    }

    /**
     * Returns the number of a h contacts where forename = &#63; and surname = &#63;.
     *
     * @param forename the forename
     * @param surname the surname
     * @return the number of matching a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByname(String forename, String surname)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { forename, surname };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_AHCONTACT_WHERE);

            boolean bindForename = false;

            if (forename == null) {
                query.append(_FINDER_COLUMN_NAME_FORENAME_1);
            } else if (forename.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_FORENAME_3);
            } else {
                bindForename = true;

                query.append(_FINDER_COLUMN_NAME_FORENAME_2);
            }

            boolean bindSurname = false;

            if (surname == null) {
                query.append(_FINDER_COLUMN_NAME_SURNAME_1);
            } else if (surname.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_SURNAME_3);
            } else {
                bindSurname = true;

                query.append(_FINDER_COLUMN_NAME_SURNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindForename) {
                    qPos.add(forename);
                }

                if (bindSurname) {
                    qPos.add(surname);
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
     * Caches the a h contact in the entity cache if it is enabled.
     *
     * @param ahContact the a h contact
     */
    @Override
    public void cacheResult(AHContact ahContact) {
        EntityCacheUtil.putResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactImpl.class, ahContact.getPrimaryKey(), ahContact);

        ahContact.resetOriginalValues();
    }

    /**
     * Caches the a h contacts in the entity cache if it is enabled.
     *
     * @param ahContacts the a h contacts
     */
    @Override
    public void cacheResult(List<AHContact> ahContacts) {
        for (AHContact ahContact : ahContacts) {
            if (EntityCacheUtil.getResult(
                        AHContactModelImpl.ENTITY_CACHE_ENABLED,
                        AHContactImpl.class, ahContact.getPrimaryKey()) == null) {
                cacheResult(ahContact);
            } else {
                ahContact.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h contacts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHContactImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHContactImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h contact.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHContact ahContact) {
        EntityCacheUtil.removeResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactImpl.class, ahContact.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHContact> ahContacts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHContact ahContact : ahContacts) {
            EntityCacheUtil.removeResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
                AHContactImpl.class, ahContact.getPrimaryKey());
        }
    }

    /**
     * Creates a new a h contact with the primary key. Does not add the a h contact to the database.
     *
     * @param contactId the primary key for the new a h contact
     * @return the new a h contact
     */
    @Override
    public AHContact create(long contactId) {
        AHContact ahContact = new AHContactImpl();

        ahContact.setNew(true);
        ahContact.setPrimaryKey(contactId);

        return ahContact;
    }

    /**
     * Removes the a h contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contactId the primary key of the a h contact
     * @return the a h contact that was removed
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact remove(long contactId)
        throws NoSuchAHContactException, SystemException {
        return remove((Serializable) contactId);
    }

    /**
     * Removes the a h contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h contact
     * @return the a h contact that was removed
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact remove(Serializable primaryKey)
        throws NoSuchAHContactException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHContact ahContact = (AHContact) session.get(AHContactImpl.class,
                    primaryKey);

            if (ahContact == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahContact);
        } catch (NoSuchAHContactException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHContact removeImpl(AHContact ahContact)
        throws SystemException {
        ahContact = toUnwrappedModel(ahContact);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahContact)) {
                ahContact = (AHContact) session.get(AHContactImpl.class,
                        ahContact.getPrimaryKeyObj());
            }

            if (ahContact != null) {
                session.delete(ahContact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahContact != null) {
            clearCache(ahContact);
        }

        return ahContact;
    }

    @Override
    public AHContact updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHContact ahContact)
        throws SystemException {
        ahContact = toUnwrappedModel(ahContact);

        boolean isNew = ahContact.isNew();

        AHContactModelImpl ahContactModelImpl = (AHContactModelImpl) ahContact;

        Session session = null;

        try {
            session = openSession();

            if (ahContact.isNew()) {
                session.save(ahContact);

                ahContact.setNew(false);
            } else {
                session.merge(ahContact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AHContactModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((ahContactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahContactModelImpl.getOriginalEmail()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);

                args = new Object[] { ahContactModelImpl.getEmail() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);
            }

            if ((ahContactModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahContactModelImpl.getOriginalForename(),
                        ahContactModelImpl.getOriginalSurname()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] {
                        ahContactModelImpl.getForename(),
                        ahContactModelImpl.getSurname()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
            AHContactImpl.class, ahContact.getPrimaryKey(), ahContact);

        return ahContact;
    }

    protected AHContact toUnwrappedModel(AHContact ahContact) {
        if (ahContact instanceof AHContactImpl) {
            return ahContact;
        }

        AHContactImpl ahContactImpl = new AHContactImpl();

        ahContactImpl.setNew(ahContact.isNew());
        ahContactImpl.setPrimaryKey(ahContact.getPrimaryKey());

        ahContactImpl.setContactId(ahContact.getContactId());
        ahContactImpl.setForename(ahContact.getForename());
        ahContactImpl.setSurname(ahContact.getSurname());
        ahContactImpl.setTel(ahContact.getTel());
        ahContactImpl.setMobile(ahContact.getMobile());
        ahContactImpl.setFax(ahContact.getFax());
        ahContactImpl.setEmail(ahContact.getEmail());
        ahContactImpl.setWww(ahContact.getWww());

        return ahContactImpl;
    }

    /**
     * Returns the a h contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h contact
     * @return the a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHContactException, SystemException {
        AHContact ahContact = fetchByPrimaryKey(primaryKey);

        if (ahContact == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahContact;
    }

    /**
     * Returns the a h contact with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException} if it could not be found.
     *
     * @param contactId the primary key of the a h contact
     * @return the a h contact
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact findByPrimaryKey(long contactId)
        throws NoSuchAHContactException, SystemException {
        return findByPrimaryKey((Serializable) contactId);
    }

    /**
     * Returns the a h contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h contact
     * @return the a h contact, or <code>null</code> if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHContact ahContact = (AHContact) EntityCacheUtil.getResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
                AHContactImpl.class, primaryKey);

        if (ahContact == _nullAHContact) {
            return null;
        }

        if (ahContact == null) {
            Session session = null;

            try {
                session = openSession();

                ahContact = (AHContact) session.get(AHContactImpl.class,
                        primaryKey);

                if (ahContact != null) {
                    cacheResult(ahContact);
                } else {
                    EntityCacheUtil.putResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
                        AHContactImpl.class, primaryKey, _nullAHContact);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHContactModelImpl.ENTITY_CACHE_ENABLED,
                    AHContactImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return ahContact;
    }

    /**
     * Returns the a h contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contactId the primary key of the a h contact
     * @return the a h contact, or <code>null</code> if a a h contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHContact fetchByPrimaryKey(long contactId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) contactId);
    }

    /**
     * Returns all the a h contacts.
     *
     * @return the a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h contacts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h contacts
     * @param end the upper bound of the range of a h contacts (not inclusive)
     * @return the range of a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h contacts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h contacts
     * @param end the upper bound of the range of a h contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHContact> findAll(int start, int end,
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

        List<AHContact> list = (List<AHContact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHCONTACT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AHCONTACT;

                if (pagination) {
                    sql = sql.concat(AHContactModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AHContact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHContact>(list);
                } else {
                    list = (List<AHContact>) QueryUtil.list(q, getDialect(),
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
     * Removes all the a h contacts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHContact ahContact : findAll()) {
            remove(ahContact);
        }
    }

    /**
     * Returns the number of a h contacts.
     *
     * @return the number of a h contacts
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

                Query q = session.createQuery(_SQL_COUNT_AHCONTACT);

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
     * Initializes the a h contact persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.particity.model.AHContact")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHContact>> listenersList = new ArrayList<ModelListener<AHContact>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHContact>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHContactImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
