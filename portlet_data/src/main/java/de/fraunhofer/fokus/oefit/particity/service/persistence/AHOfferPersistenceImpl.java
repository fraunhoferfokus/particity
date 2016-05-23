package de.fraunhofer.fokus.oefit.particity.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException;
import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the a h offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOfferPersistence
 * @see AHOfferUtil
 * @generated
 */
public class AHOfferPersistenceImpl extends BasePersistenceImpl<AHOffer>
    implements AHOfferPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AHOfferUtil} to access the a h offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AHOfferImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorg",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorg",
            new String[] { Long.class.getName() },
            AHOfferModelImpl.ORGID_COLUMN_BITMASK |
            AHOfferModelImpl.UPDATED_COLUMN_BITMASK |
            AHOfferModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ORG = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorg",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ORG_ORGID_2 = "ahOffer.orgId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytitle",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytitle",
            new String[] { String.class.getName() },
            AHOfferModelImpl.TITLE_COLUMN_BITMASK |
            AHOfferModelImpl.UPDATED_COLUMN_BITMASK |
            AHOfferModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytitle",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "ahOffer.title IS NULL";
    private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "ahOffer.title = ?";
    private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(ahOffer.title IS NULL OR ahOffer.title = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
        new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
            new String[] { Integer.class.getName() },
            AHOfferModelImpl.STATUS_COLUMN_BITMASK |
            AHOfferModelImpl.UPDATED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "ahOffer.status = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDDATE =
        new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatusAndDate",
            new String[] {
                Integer.class.getName(), Long.class.getName(),
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDDATE =
        new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBystatusAndDate",
            new String[] {
                Integer.class.getName(), Long.class.getName(),
                Long.class.getName()
            });
    private static final String _FINDER_COLUMN_STATUSANDDATE_STATUS_2 = "ahOffer.status = ? AND ";
    private static final String _FINDER_COLUMN_STATUSANDDATE_EXPIRES_2 = "ahOffer.expires > ? AND ";
    private static final String _FINDER_COLUMN_STATUSANDDATE_PUBLISH_2 = "ahOffer.publish < ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANDSTATUSANDDATE =
        new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByorgAndstatusAndDate",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ORGANDSTATUSANDDATE =
        new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByorgAndstatusAndDate",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_ORGANDSTATUSANDDATE_ORGID_2 = "ahOffer.orgId = ? AND ";
    private static final String _FINDER_COLUMN_ORGANDSTATUSANDDATE_STATUS_2 = "ahOffer.status = ? AND ";
    private static final String _FINDER_COLUMN_ORGANDSTATUSANDDATE_EXPIRES_2 = "ahOffer.expires > ? AND ";
    private static final String _FINDER_COLUMN_ORGANDSTATUSANDDATE_PUBLISH_2 = "ahOffer.publish < ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESS = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByaddress",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS =
        new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, AHOfferImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByaddress",
            new String[] { Long.class.getName() },
            AHOfferModelImpl.ADRESSID_COLUMN_BITMASK |
            AHOfferModelImpl.UPDATED_COLUMN_BITMASK |
            AHOfferModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ADDRESS = new FinderPath(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByaddress",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ADDRESS_ADRESSID_2 = "ahOffer.adressId = ?";
    private static final String _SQL_SELECT_AHOFFER = "SELECT ahOffer FROM AHOffer ahOffer";
    private static final String _SQL_SELECT_AHOFFER_WHERE = "SELECT ahOffer FROM AHOffer ahOffer WHERE ";
    private static final String _SQL_COUNT_AHOFFER = "SELECT COUNT(ahOffer) FROM AHOffer ahOffer";
    private static final String _SQL_COUNT_AHOFFER_WHERE = "SELECT COUNT(ahOffer) FROM AHOffer ahOffer WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahOffer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHOffer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHOffer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHOfferPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "type"
            });
    private static AHOffer _nullAHOffer = new AHOfferImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHOffer> toCacheModel() {
                return _nullAHOfferCacheModel;
            }
        };

    private static CacheModel<AHOffer> _nullAHOfferCacheModel = new CacheModel<AHOffer>() {
            @Override
            public AHOffer toEntityModel() {
                return _nullAHOffer;
            }
        };

    @BeanReference(type = AHCatEntriesPersistence.class)
    protected AHCatEntriesPersistence ahCatEntriesPersistence;
    protected TableMapper<AHOffer, de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahOfferToAHCatEntriesTableMapper;

    public AHOfferPersistenceImpl() {
        setModelClass(AHOffer.class);
    }

    /**
     * Returns all the a h offers where orgId = &#63;.
     *
     * @param orgId the org ID
     * @return the matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByorg(long orgId) throws SystemException {
        return findByorg(orgId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h offers where orgId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param orgId the org ID
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByorg(long orgId, int start, int end)
        throws SystemException {
        return findByorg(orgId, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers where orgId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param orgId the org ID
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByorg(long orgId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG;
            finderArgs = new Object[] { orgId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG;
            finderArgs = new Object[] { orgId, start, end, orderByComparator };
        }

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOffer ahOffer : list) {
                if ((orgId != ahOffer.getOrgId())) {
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

            query.append(_SQL_SELECT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_ORG_ORGID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHOfferModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgId);

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h offer in the ordered set where orgId = &#63;.
     *
     * @param orgId the org ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByorg_First(long orgId,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByorg_First(orgId, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("orgId=");
        msg.append(orgId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the first a h offer in the ordered set where orgId = &#63;.
     *
     * @param orgId the org ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByorg_First(long orgId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHOffer> list = findByorg(orgId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h offer in the ordered set where orgId = &#63;.
     *
     * @param orgId the org ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByorg_Last(long orgId,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByorg_Last(orgId, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("orgId=");
        msg.append(orgId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the last a h offer in the ordered set where orgId = &#63;.
     *
     * @param orgId the org ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByorg_Last(long orgId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByorg(orgId);

        if (count == 0) {
            return null;
        }

        List<AHOffer> list = findByorg(orgId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h offers before and after the current a h offer in the ordered set where orgId = &#63;.
     *
     * @param offerId the primary key of the current a h offer
     * @param orgId the org ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer[] findByorg_PrevAndNext(long offerId, long orgId,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = findByPrimaryKey(offerId);

        Session session = null;

        try {
            session = openSession();

            AHOffer[] array = new AHOfferImpl[3];

            array[0] = getByorg_PrevAndNext(session, ahOffer, orgId,
                    orderByComparator, true);

            array[1] = ahOffer;

            array[2] = getByorg_PrevAndNext(session, ahOffer, orgId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOffer getByorg_PrevAndNext(Session session, AHOffer ahOffer,
        long orgId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHOFFER_WHERE);

        query.append(_FINDER_COLUMN_ORG_ORGID_2);

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
            query.append(AHOfferModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(orgId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahOffer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHOffer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h offers where orgId = &#63; from the database.
     *
     * @param orgId the org ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByorg(long orgId) throws SystemException {
        for (AHOffer ahOffer : findByorg(orgId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers where orgId = &#63;.
     *
     * @param orgId the org ID
     * @return the number of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByorg(long orgId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ORG;

        Object[] finderArgs = new Object[] { orgId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_ORG_ORGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgId);

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
     * Returns all the a h offers where title = &#63;.
     *
     * @param title the title
     * @return the matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBytitle(String title) throws SystemException {
        return findBytitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h offers where title = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBytitle(String title, int start, int end)
        throws SystemException {
        return findBytitle(title, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers where title = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBytitle(String title, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
            finderArgs = new Object[] { title };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
            finderArgs = new Object[] { title, start, end, orderByComparator };
        }

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOffer ahOffer : list) {
                if (!Validator.equals(title, ahOffer.getTitle())) {
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

            query.append(_SQL_SELECT_AHOFFER_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_TITLE_TITLE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHOfferModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTitle) {
                    qPos.add(title);
                }

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h offer in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findBytitle_First(String title,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchBytitle_First(title, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the first a h offer in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchBytitle_First(String title,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHOffer> list = findBytitle(title, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h offer in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findBytitle_Last(String title,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchBytitle_Last(title, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the last a h offer in the ordered set where title = &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchBytitle_Last(String title,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBytitle(title);

        if (count == 0) {
            return null;
        }

        List<AHOffer> list = findBytitle(title, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h offers before and after the current a h offer in the ordered set where title = &#63;.
     *
     * @param offerId the primary key of the current a h offer
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer[] findBytitle_PrevAndNext(long offerId, String title,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = findByPrimaryKey(offerId);

        Session session = null;

        try {
            session = openSession();

            AHOffer[] array = new AHOfferImpl[3];

            array[0] = getBytitle_PrevAndNext(session, ahOffer, title,
                    orderByComparator, true);

            array[1] = ahOffer;

            array[2] = getBytitle_PrevAndNext(session, ahOffer, title,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOffer getBytitle_PrevAndNext(Session session, AHOffer ahOffer,
        String title, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHOFFER_WHERE);

        boolean bindTitle = false;

        if (title == null) {
            query.append(_FINDER_COLUMN_TITLE_TITLE_1);
        } else if (title.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_TITLE_TITLE_3);
        } else {
            bindTitle = true;

            query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
            query.append(AHOfferModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindTitle) {
            qPos.add(title);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahOffer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHOffer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h offers where title = &#63; from the database.
     *
     * @param title the title
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBytitle(String title) throws SystemException {
        for (AHOffer ahOffer : findBytitle(title, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers where title = &#63;.
     *
     * @param title the title
     * @return the number of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBytitle(String title) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLE;

        Object[] finderArgs = new Object[] { title };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHOFFER_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_3);
            } else {
                bindTitle = true;

                query.append(_FINDER_COLUMN_TITLE_TITLE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTitle) {
                    qPos.add(title);
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
     * Returns all the a h offers where status = &#63;.
     *
     * @param status the status
     * @return the matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBystatus(int status) throws SystemException {
        return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h offers where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBystatus(int status, int start, int end)
        throws SystemException {
        return findBystatus(status, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers where status = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBystatus(int status, int start, int end,
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

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOffer ahOffer : list) {
                if ((status != ahOffer.getStatus())) {
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

            query.append(_SQL_SELECT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_STATUS_STATUS_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHOfferModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h offer in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findBystatus_First(int status,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchBystatus_First(status, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the first a h offer in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchBystatus_First(int status,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHOffer> list = findBystatus(status, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h offer in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findBystatus_Last(int status,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchBystatus_Last(status, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the last a h offer in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchBystatus_Last(int status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBystatus(status);

        if (count == 0) {
            return null;
        }

        List<AHOffer> list = findBystatus(status, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h offers before and after the current a h offer in the ordered set where status = &#63;.
     *
     * @param offerId the primary key of the current a h offer
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer[] findBystatus_PrevAndNext(long offerId, int status,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = findByPrimaryKey(offerId);

        Session session = null;

        try {
            session = openSession();

            AHOffer[] array = new AHOfferImpl[3];

            array[0] = getBystatus_PrevAndNext(session, ahOffer, status,
                    orderByComparator, true);

            array[1] = ahOffer;

            array[2] = getBystatus_PrevAndNext(session, ahOffer, status,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOffer getBystatus_PrevAndNext(Session session, AHOffer ahOffer,
        int status, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHOFFER_WHERE);

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
            query.append(AHOfferModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahOffer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHOffer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h offers where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBystatus(int status) throws SystemException {
        for (AHOffer ahOffer : findBystatus(status, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers where status = &#63;.
     *
     * @param status the status
     * @return the number of matching a h offers
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

            query.append(_SQL_COUNT_AHOFFER_WHERE);

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
     * Returns all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @return the matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBystatusAndDate(int status, long expires,
        long publish) throws SystemException {
        return findBystatusAndDate(status, expires, publish, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBystatusAndDate(int status, long expires,
        long publish, int start, int end) throws SystemException {
        return findBystatusAndDate(status, expires, publish, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findBystatusAndDate(int status, long expires,
        long publish, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSANDDATE;
        finderArgs = new Object[] {
                status, expires, publish,
                
                start, end, orderByComparator
            };

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOffer ahOffer : list) {
                if ((status != ahOffer.getStatus()) ||
                        (expires >= ahOffer.getExpires()) ||
                        (publish <= ahOffer.getPublish())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_STATUSANDDATE_STATUS_2);

            query.append(_FINDER_COLUMN_STATUSANDDATE_EXPIRES_2);

            query.append(_FINDER_COLUMN_STATUSANDDATE_PUBLISH_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHOfferModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                qPos.add(expires);

                qPos.add(publish);

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findBystatusAndDate_First(int status, long expires,
        long publish, OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchBystatusAndDate_First(status, expires, publish,
                orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(", expires=");
        msg.append(expires);

        msg.append(", publish=");
        msg.append(publish);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the first a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchBystatusAndDate_First(int status, long expires,
        long publish, OrderByComparator orderByComparator)
        throws SystemException {
        List<AHOffer> list = findBystatusAndDate(status, expires, publish, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findBystatusAndDate_Last(int status, long expires,
        long publish, OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchBystatusAndDate_Last(status, expires, publish,
                orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(", expires=");
        msg.append(expires);

        msg.append(", publish=");
        msg.append(publish);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the last a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchBystatusAndDate_Last(int status, long expires,
        long publish, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBystatusAndDate(status, expires, publish);

        if (count == 0) {
            return null;
        }

        List<AHOffer> list = findBystatusAndDate(status, expires, publish,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h offers before and after the current a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param offerId the primary key of the current a h offer
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer[] findBystatusAndDate_PrevAndNext(long offerId, int status,
        long expires, long publish, OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = findByPrimaryKey(offerId);

        Session session = null;

        try {
            session = openSession();

            AHOffer[] array = new AHOfferImpl[3];

            array[0] = getBystatusAndDate_PrevAndNext(session, ahOffer, status,
                    expires, publish, orderByComparator, true);

            array[1] = ahOffer;

            array[2] = getBystatusAndDate_PrevAndNext(session, ahOffer, status,
                    expires, publish, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOffer getBystatusAndDate_PrevAndNext(Session session,
        AHOffer ahOffer, int status, long expires, long publish,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHOFFER_WHERE);

        query.append(_FINDER_COLUMN_STATUSANDDATE_STATUS_2);

        query.append(_FINDER_COLUMN_STATUSANDDATE_EXPIRES_2);

        query.append(_FINDER_COLUMN_STATUSANDDATE_PUBLISH_2);

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
            query.append(AHOfferModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(status);

        qPos.add(expires);

        qPos.add(publish);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahOffer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHOffer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63; from the database.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBystatusAndDate(int status, long expires, long publish)
        throws SystemException {
        for (AHOffer ahOffer : findBystatusAndDate(status, expires, publish,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @return the number of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBystatusAndDate(int status, long expires, long publish)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_STATUSANDDATE;

        Object[] finderArgs = new Object[] { status, expires, publish };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_STATUSANDDATE_STATUS_2);

            query.append(_FINDER_COLUMN_STATUSANDDATE_EXPIRES_2);

            query.append(_FINDER_COLUMN_STATUSANDDATE_PUBLISH_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(status);

                qPos.add(expires);

                qPos.add(publish);

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
     * Returns all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @return the matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish) throws SystemException {
        return findByorgAndstatusAndDate(orgId, status, expires, publish,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish, int start, int end)
        throws SystemException {
        return findByorgAndstatusAndDate(orgId, status, expires, publish,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANDSTATUSANDDATE;
        finderArgs = new Object[] {
                orgId, status, expires, publish,
                
                start, end, orderByComparator
            };

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOffer ahOffer : list) {
                if ((orgId != ahOffer.getOrgId()) ||
                        (status != ahOffer.getStatus()) ||
                        (expires >= ahOffer.getExpires()) ||
                        (publish <= ahOffer.getPublish())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_ORGID_2);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_STATUS_2);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_EXPIRES_2);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_PUBLISH_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHOfferModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgId);

                qPos.add(status);

                qPos.add(expires);

                qPos.add(publish);

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h offer in the ordered set where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByorgAndstatusAndDate_First(long orgId, int status,
        long expires, long publish, OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByorgAndstatusAndDate_First(orgId, status,
                expires, publish, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("orgId=");
        msg.append(orgId);

        msg.append(", status=");
        msg.append(status);

        msg.append(", expires=");
        msg.append(expires);

        msg.append(", publish=");
        msg.append(publish);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the first a h offer in the ordered set where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByorgAndstatusAndDate_First(long orgId, int status,
        long expires, long publish, OrderByComparator orderByComparator)
        throws SystemException {
        List<AHOffer> list = findByorgAndstatusAndDate(orgId, status, expires,
                publish, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h offer in the ordered set where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByorgAndstatusAndDate_Last(long orgId, int status,
        long expires, long publish, OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByorgAndstatusAndDate_Last(orgId, status,
                expires, publish, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("orgId=");
        msg.append(orgId);

        msg.append(", status=");
        msg.append(status);

        msg.append(", expires=");
        msg.append(expires);

        msg.append(", publish=");
        msg.append(publish);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the last a h offer in the ordered set where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByorgAndstatusAndDate_Last(long orgId, int status,
        long expires, long publish, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByorgAndstatusAndDate(orgId, status, expires, publish);

        if (count == 0) {
            return null;
        }

        List<AHOffer> list = findByorgAndstatusAndDate(orgId, status, expires,
                publish, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h offers before and after the current a h offer in the ordered set where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param offerId the primary key of the current a h offer
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer[] findByorgAndstatusAndDate_PrevAndNext(long offerId,
        long orgId, int status, long expires, long publish,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = findByPrimaryKey(offerId);

        Session session = null;

        try {
            session = openSession();

            AHOffer[] array = new AHOfferImpl[3];

            array[0] = getByorgAndstatusAndDate_PrevAndNext(session, ahOffer,
                    orgId, status, expires, publish, orderByComparator, true);

            array[1] = ahOffer;

            array[2] = getByorgAndstatusAndDate_PrevAndNext(session, ahOffer,
                    orgId, status, expires, publish, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOffer getByorgAndstatusAndDate_PrevAndNext(Session session,
        AHOffer ahOffer, long orgId, int status, long expires, long publish,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHOFFER_WHERE);

        query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_ORGID_2);

        query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_STATUS_2);

        query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_EXPIRES_2);

        query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_PUBLISH_2);

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
            query.append(AHOfferModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(orgId);

        qPos.add(status);

        qPos.add(expires);

        qPos.add(publish);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahOffer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHOffer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63; from the database.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish) throws SystemException {
        for (AHOffer ahOffer : findByorgAndstatusAndDate(orgId, status,
                expires, publish, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
     *
     * @param orgId the org ID
     * @param status the status
     * @param expires the expires
     * @param publish the publish
     * @return the number of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByorgAndstatusAndDate(long orgId, int status, long expires,
        long publish) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_ORGANDSTATUSANDDATE;

        Object[] finderArgs = new Object[] { orgId, status, expires, publish };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_ORGID_2);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_STATUS_2);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_EXPIRES_2);

            query.append(_FINDER_COLUMN_ORGANDSTATUSANDDATE_PUBLISH_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgId);

                qPos.add(status);

                qPos.add(expires);

                qPos.add(publish);

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
     * Returns all the a h offers where adressId = &#63;.
     *
     * @param adressId the adress ID
     * @return the matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByaddress(long adressId) throws SystemException {
        return findByaddress(adressId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the a h offers where adressId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param adressId the adress ID
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByaddress(long adressId, int start, int end)
        throws SystemException {
        return findByaddress(adressId, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers where adressId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param adressId the adress ID
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findByaddress(long adressId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS;
            finderArgs = new Object[] { adressId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ADDRESS;
            finderArgs = new Object[] { adressId, start, end, orderByComparator };
        }

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHOffer ahOffer : list) {
                if ((adressId != ahOffer.getAdressId())) {
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

            query.append(_SQL_SELECT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_ADDRESS_ADRESSID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHOfferModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(adressId);

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h offer in the ordered set where adressId = &#63;.
     *
     * @param adressId the adress ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByaddress_First(long adressId,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByaddress_First(adressId, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("adressId=");
        msg.append(adressId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the first a h offer in the ordered set where adressId = &#63;.
     *
     * @param adressId the adress ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByaddress_First(long adressId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHOffer> list = findByaddress(adressId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h offer in the ordered set where adressId = &#63;.
     *
     * @param adressId the adress ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByaddress_Last(long adressId,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByaddress_Last(adressId, orderByComparator);

        if (ahOffer != null) {
            return ahOffer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("adressId=");
        msg.append(adressId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHOfferException(msg.toString());
    }

    /**
     * Returns the last a h offer in the ordered set where adressId = &#63;.
     *
     * @param adressId the adress ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByaddress_Last(long adressId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByaddress(adressId);

        if (count == 0) {
            return null;
        }

        List<AHOffer> list = findByaddress(adressId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h offers before and after the current a h offer in the ordered set where adressId = &#63;.
     *
     * @param offerId the primary key of the current a h offer
     * @param adressId the adress ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer[] findByaddress_PrevAndNext(long offerId, long adressId,
        OrderByComparator orderByComparator)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = findByPrimaryKey(offerId);

        Session session = null;

        try {
            session = openSession();

            AHOffer[] array = new AHOfferImpl[3];

            array[0] = getByaddress_PrevAndNext(session, ahOffer, adressId,
                    orderByComparator, true);

            array[1] = ahOffer;

            array[2] = getByaddress_PrevAndNext(session, ahOffer, adressId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHOffer getByaddress_PrevAndNext(Session session,
        AHOffer ahOffer, long adressId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHOFFER_WHERE);

        query.append(_FINDER_COLUMN_ADDRESS_ADRESSID_2);

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
            query.append(AHOfferModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(adressId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahOffer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHOffer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h offers where adressId = &#63; from the database.
     *
     * @param adressId the adress ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByaddress(long adressId) throws SystemException {
        for (AHOffer ahOffer : findByaddress(adressId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers where adressId = &#63;.
     *
     * @param adressId the adress ID
     * @return the number of matching a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByaddress(long adressId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ADDRESS;

        Object[] finderArgs = new Object[] { adressId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHOFFER_WHERE);

            query.append(_FINDER_COLUMN_ADDRESS_ADRESSID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(adressId);

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
     * Caches the a h offer in the entity cache if it is enabled.
     *
     * @param ahOffer the a h offer
     */
    @Override
    public void cacheResult(AHOffer ahOffer) {
        EntityCacheUtil.putResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferImpl.class, ahOffer.getPrimaryKey(), ahOffer);

        ahOffer.resetOriginalValues();
    }

    /**
     * Caches the a h offers in the entity cache if it is enabled.
     *
     * @param ahOffers the a h offers
     */
    @Override
    public void cacheResult(List<AHOffer> ahOffers) {
        for (AHOffer ahOffer : ahOffers) {
            if (EntityCacheUtil.getResult(
                        AHOfferModelImpl.ENTITY_CACHE_ENABLED,
                        AHOfferImpl.class, ahOffer.getPrimaryKey()) == null) {
                cacheResult(ahOffer);
            } else {
                ahOffer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h offers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHOfferImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHOfferImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h offer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHOffer ahOffer) {
        EntityCacheUtil.removeResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferImpl.class, ahOffer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHOffer> ahOffers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHOffer ahOffer : ahOffers) {
            EntityCacheUtil.removeResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
                AHOfferImpl.class, ahOffer.getPrimaryKey());
        }
    }

    /**
     * Creates a new a h offer with the primary key. Does not add the a h offer to the database.
     *
     * @param offerId the primary key for the new a h offer
     * @return the new a h offer
     */
    @Override
    public AHOffer create(long offerId) {
        AHOffer ahOffer = new AHOfferImpl();

        ahOffer.setNew(true);
        ahOffer.setPrimaryKey(offerId);

        return ahOffer;
    }

    /**
     * Removes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param offerId the primary key of the a h offer
     * @return the a h offer that was removed
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer remove(long offerId)
        throws NoSuchAHOfferException, SystemException {
        return remove((Serializable) offerId);
    }

    /**
     * Removes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h offer
     * @return the a h offer that was removed
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer remove(Serializable primaryKey)
        throws NoSuchAHOfferException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHOffer ahOffer = (AHOffer) session.get(AHOfferImpl.class,
                    primaryKey);

            if (ahOffer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHOfferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahOffer);
        } catch (NoSuchAHOfferException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHOffer removeImpl(AHOffer ahOffer) throws SystemException {
        ahOffer = toUnwrappedModel(ahOffer);

        ahOfferToAHCatEntriesTableMapper.deleteLeftPrimaryKeyTableMappings(ahOffer.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahOffer)) {
                ahOffer = (AHOffer) session.get(AHOfferImpl.class,
                        ahOffer.getPrimaryKeyObj());
            }

            if (ahOffer != null) {
                session.delete(ahOffer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahOffer != null) {
            clearCache(ahOffer);
        }

        return ahOffer;
    }

    @Override
    public AHOffer updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws SystemException {
        ahOffer = toUnwrappedModel(ahOffer);

        boolean isNew = ahOffer.isNew();

        AHOfferModelImpl ahOfferModelImpl = (AHOfferModelImpl) ahOffer;

        Session session = null;

        try {
            session = openSession();

            if (ahOffer.isNew()) {
                session.save(ahOffer);

                ahOffer.setNew(false);
            } else {
                session.merge(ahOffer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AHOfferModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((ahOfferModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahOfferModelImpl.getOriginalOrgId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG,
                    args);

                args = new Object[] { ahOfferModelImpl.getOrgId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG,
                    args);
            }

            if ((ahOfferModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahOfferModelImpl.getOriginalTitle() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
                    args);

                args = new Object[] { ahOfferModelImpl.getTitle() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
                    args);
            }

            if ((ahOfferModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahOfferModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { ahOfferModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }

            if ((ahOfferModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahOfferModelImpl.getOriginalAdressId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS,
                    args);

                args = new Object[] { ahOfferModelImpl.getAdressId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADDRESS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADDRESS,
                    args);
            }
        }

        EntityCacheUtil.putResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
            AHOfferImpl.class, ahOffer.getPrimaryKey(), ahOffer);

        return ahOffer;
    }

    protected AHOffer toUnwrappedModel(AHOffer ahOffer) {
        if (ahOffer instanceof AHOfferImpl) {
            return ahOffer;
        }

        AHOfferImpl ahOfferImpl = new AHOfferImpl();

        ahOfferImpl.setNew(ahOffer.isNew());
        ahOfferImpl.setPrimaryKey(ahOffer.getPrimaryKey());

        ahOfferImpl.setOfferId(ahOffer.getOfferId());
        ahOfferImpl.setTitle(ahOffer.getTitle());
        ahOfferImpl.setDescription(ahOffer.getDescription());
        ahOfferImpl.setWorkTime(ahOffer.getWorkTime());
        ahOfferImpl.setWorkType(ahOffer.getWorkType());
        ahOfferImpl.setType(ahOffer.getType());
        ahOfferImpl.setStatus(ahOffer.getStatus());
        ahOfferImpl.setSocialStatus(ahOffer.getSocialStatus());
        ahOfferImpl.setCreated(ahOffer.getCreated());
        ahOfferImpl.setUpdated(ahOffer.getUpdated());
        ahOfferImpl.setExpires(ahOffer.getExpires());
        ahOfferImpl.setPublish(ahOffer.getPublish());
        ahOfferImpl.setAdressId(ahOffer.getAdressId());
        ahOfferImpl.setContactId(ahOffer.getContactId());
        ahOfferImpl.setSndContactId(ahOffer.getSndContactId());
        ahOfferImpl.setContactAgency(ahOffer.isContactAgency());
        ahOfferImpl.setOrgId(ahOffer.getOrgId());

        return ahOfferImpl;
    }

    /**
     * Returns the a h offer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h offer
     * @return the a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHOfferException, SystemException {
        AHOffer ahOffer = fetchByPrimaryKey(primaryKey);

        if (ahOffer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHOfferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahOffer;
    }

    /**
     * Returns the a h offer with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException} if it could not be found.
     *
     * @param offerId the primary key of the a h offer
     * @return the a h offer
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer findByPrimaryKey(long offerId)
        throws NoSuchAHOfferException, SystemException {
        return findByPrimaryKey((Serializable) offerId);
    }

    /**
     * Returns the a h offer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h offer
     * @return the a h offer, or <code>null</code> if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHOffer ahOffer = (AHOffer) EntityCacheUtil.getResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
                AHOfferImpl.class, primaryKey);

        if (ahOffer == _nullAHOffer) {
            return null;
        }

        if (ahOffer == null) {
            Session session = null;

            try {
                session = openSession();

                ahOffer = (AHOffer) session.get(AHOfferImpl.class, primaryKey);

                if (ahOffer != null) {
                    cacheResult(ahOffer);
                } else {
                    EntityCacheUtil.putResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
                        AHOfferImpl.class, primaryKey, _nullAHOffer);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHOfferModelImpl.ENTITY_CACHE_ENABLED,
                    AHOfferImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return ahOffer;
    }

    /**
     * Returns the a h offer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param offerId the primary key of the a h offer
     * @return the a h offer, or <code>null</code> if a a h offer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHOffer fetchByPrimaryKey(long offerId) throws SystemException {
        return fetchByPrimaryKey((Serializable) offerId);
    }

    /**
     * Returns all the a h offers.
     *
     * @return the a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h offers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h offers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h offers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHOffer> findAll(int start, int end,
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

        List<AHOffer> list = (List<AHOffer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHOFFER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AHOFFER;

                if (pagination) {
                    sql = sql.concat(AHOfferModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHOffer>(list);
                } else {
                    list = (List<AHOffer>) QueryUtil.list(q, getDialect(),
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
     * Removes all the a h offers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHOffer ahOffer : findAll()) {
            remove(ahOffer);
        }
    }

    /**
     * Returns the number of a h offers.
     *
     * @return the number of a h offers
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

                Query q = session.createQuery(_SQL_COUNT_AHOFFER);

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
     * Returns all the a h cat entrieses associated with the a h offer.
     *
     * @param pk the primary key of the a h offer
     * @return the a h cat entrieses associated with the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getAHCatEntrieses(
        long pk) throws SystemException {
        return getAHCatEntrieses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the a h cat entrieses associated with the a h offer.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the a h offer
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @return the range of a h cat entrieses associated with the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end) throws SystemException {
        return getAHCatEntrieses(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h cat entrieses associated with the a h offer.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the a h offer
     * @param start the lower bound of the range of a h offers
     * @param end the upper bound of the range of a h offers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h cat entrieses associated with the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return ahOfferToAHCatEntriesTableMapper.getRightBaseModels(pk, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of a h cat entrieses associated with the a h offer.
     *
     * @param pk the primary key of the a h offer
     * @return the number of a h cat entrieses associated with the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getAHCatEntriesesSize(long pk) throws SystemException {
        long[] pks = ahOfferToAHCatEntriesTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the a h cat entries is associated with the a h offer.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntriesPK the primary key of the a h cat entries
     * @return <code>true</code> if the a h cat entries is associated with the a h offer; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsAHCatEntries(long pk, long ahCatEntriesPK)
        throws SystemException {
        return ahOfferToAHCatEntriesTableMapper.containsTableMapping(pk,
            ahCatEntriesPK);
    }

    /**
     * Returns <code>true</code> if the a h offer has any a h cat entrieses associated with it.
     *
     * @param pk the primary key of the a h offer to check for associations with a h cat entrieses
     * @return <code>true</code> if the a h offer has any a h cat entrieses associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsAHCatEntrieses(long pk) throws SystemException {
        if (getAHCatEntriesesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntriesPK the primary key of the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHCatEntries(long pk, long ahCatEntriesPK)
        throws SystemException {
        ahOfferToAHCatEntriesTableMapper.addTableMapping(pk, ahCatEntriesPK);
    }

    /**
     * Adds an association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntries the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries)
        throws SystemException {
        ahOfferToAHCatEntriesTableMapper.addTableMapping(pk,
            ahCatEntries.getPrimaryKey());
    }

    /**
     * Adds an association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws SystemException {
        for (long ahCatEntriesPK : ahCatEntriesPKs) {
            ahOfferToAHCatEntriesTableMapper.addTableMapping(pk, ahCatEntriesPK);
        }
    }

    /**
     * Adds an association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntrieses the a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addAHCatEntrieses(long pk,
        List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses)
        throws SystemException {
        for (de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries : ahCatEntrieses) {
            ahOfferToAHCatEntriesTableMapper.addTableMapping(pk,
                ahCatEntries.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the a h offer and its a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer to clear the associated a h cat entrieses from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearAHCatEntrieses(long pk) throws SystemException {
        ahOfferToAHCatEntriesTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntriesPK the primary key of the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHCatEntries(long pk, long ahCatEntriesPK)
        throws SystemException {
        ahOfferToAHCatEntriesTableMapper.deleteTableMapping(pk, ahCatEntriesPK);
    }

    /**
     * Removes the association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntries the a h cat entries
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries)
        throws SystemException {
        ahOfferToAHCatEntriesTableMapper.deleteTableMapping(pk,
            ahCatEntries.getPrimaryKey());
    }

    /**
     * Removes the association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws SystemException {
        for (long ahCatEntriesPK : ahCatEntriesPKs) {
            ahOfferToAHCatEntriesTableMapper.deleteTableMapping(pk,
                ahCatEntriesPK);
        }
    }

    /**
     * Removes the association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntrieses the a h cat entrieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAHCatEntrieses(long pk,
        List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses)
        throws SystemException {
        for (de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries : ahCatEntrieses) {
            ahOfferToAHCatEntriesTableMapper.deleteTableMapping(pk,
                ahCatEntries.getPrimaryKey());
        }
    }

    /**
     * Sets the a h cat entrieses associated with the a h offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntriesPKs the primary keys of the a h cat entrieses to be associated with the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws SystemException {
        Set<Long> newAHCatEntriesPKsSet = SetUtil.fromArray(ahCatEntriesPKs);
        Set<Long> oldAHCatEntriesPKsSet = SetUtil.fromArray(ahOfferToAHCatEntriesTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeAHCatEntriesPKsSet = new HashSet<Long>(oldAHCatEntriesPKsSet);

        removeAHCatEntriesPKsSet.removeAll(newAHCatEntriesPKsSet);

        for (long removeAHCatEntriesPK : removeAHCatEntriesPKsSet) {
            ahOfferToAHCatEntriesTableMapper.deleteTableMapping(pk,
                removeAHCatEntriesPK);
        }

        newAHCatEntriesPKsSet.removeAll(oldAHCatEntriesPKsSet);

        for (long newAHCatEntriesPK : newAHCatEntriesPKsSet) {
            ahOfferToAHCatEntriesTableMapper.addTableMapping(pk,
                newAHCatEntriesPK);
        }
    }

    /**
     * Sets the a h cat entrieses associated with the a h offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the a h offer
     * @param ahCatEntrieses the a h cat entrieses to be associated with the a h offer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setAHCatEntrieses(long pk,
        List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses)
        throws SystemException {
        try {
            long[] ahCatEntriesPKs = new long[ahCatEntrieses.size()];

            for (int i = 0; i < ahCatEntrieses.size(); i++) {
                de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries =
                    ahCatEntrieses.get(i);

                ahCatEntriesPKs[i] = ahCatEntries.getPrimaryKey();
            }

            setAHCatEntrieses(pk, ahCatEntriesPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(AHOfferModelImpl.MAPPING_TABLE_PARTICITY_OFFER_CITM_NAME);
        }
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the a h offer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.particity.model.AHOffer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHOffer>> listenersList = new ArrayList<ModelListener<AHOffer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHOffer>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        ahOfferToAHCatEntriesTableMapper = TableMapperFactory.getTableMapper("PARTICITY_offer_citm",
                "offerId", "itemId", this, ahCatEntriesPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHOfferImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("PARTICITY_offer_citm");
    }
}
