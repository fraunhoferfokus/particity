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

import de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;
import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the a h region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHRegionPersistence
 * @see AHRegionUtil
 * @generated
 */
public class AHRegionPersistenceImpl extends BasePersistenceImpl<AHRegion>
    implements AHRegionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AHRegionUtil} to access the a h region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AHRegionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByregionId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID =
        new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByregionId",
            new String[] { Long.class.getName() },
            AHRegionModelImpl.REGIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REGIONID = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByregionId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_REGIONID_REGIONID_2 = "ahRegion.id.regionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ZIP = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByzip",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZIP = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByzip",
            new String[] { String.class.getName() },
            AHRegionModelImpl.ZIP_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ZIP = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByzip",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ZIP_ZIP_1 = "ahRegion.id.zip IS NULL";
    private static final String _FINDER_COLUMN_ZIP_ZIP_2 = "ahRegion.id.zip = ?";
    private static final String _FINDER_COLUMN_ZIP_ZIP_3 = "(ahRegion.id.zip IS NULL OR ahRegion.id.zip = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITY = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycity",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITY = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycity",
            new String[] { String.class.getName() },
            AHRegionModelImpl.CITY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CITY = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycity",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_CITY_CITY_1 = "ahRegion.id.city IS NULL";
    private static final String _FINDER_COLUMN_CITY_CITY_2 = "ahRegion.id.city = ?";
    private static final String _FINDER_COLUMN_CITY_CITY_3 = "(ahRegion.id.city IS NULL OR ahRegion.id.city = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYANDZIP =
        new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycityAndZip",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYANDZIP =
        new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycityAndZip",
            new String[] { String.class.getName(), String.class.getName() },
            AHRegionModelImpl.CITY_COLUMN_BITMASK |
            AHRegionModelImpl.ZIP_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CITYANDZIP = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycityAndZip",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_CITYANDZIP_CITY_1 = "ahRegion.id.city IS NULL AND ";
    private static final String _FINDER_COLUMN_CITYANDZIP_CITY_2 = "ahRegion.id.city = ? AND ";
    private static final String _FINDER_COLUMN_CITYANDZIP_CITY_3 = "(ahRegion.id.city IS NULL OR ahRegion.id.city = '') AND ";
    private static final String _FINDER_COLUMN_CITYANDZIP_ZIP_1 = "ahRegion.id.zip IS NULL";
    private static final String _FINDER_COLUMN_CITYANDZIP_ZIP_2 = "ahRegion.id.zip = ?";
    private static final String _FINDER_COLUMN_CITYANDZIP_ZIP_3 = "(ahRegion.id.zip IS NULL OR ahRegion.id.zip = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP =
        new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBycountryAndCityAndZip",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP =
        new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, AHRegionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBycountryAndCityAndZip",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            },
            AHRegionModelImpl.COUNTRY_COLUMN_BITMASK |
            AHRegionModelImpl.CITY_COLUMN_BITMASK |
            AHRegionModelImpl.ZIP_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYANDCITYANDZIP = new FinderPath(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBycountryAndCityAndZip",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_1 = "ahRegion.id.country IS NULL AND ";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_2 = "ahRegion.id.country = ? AND ";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_3 = "(ahRegion.id.country IS NULL OR ahRegion.id.country = '') AND ";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_1 = "ahRegion.id.city IS NULL AND ";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_2 = "ahRegion.id.city = ? AND ";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_3 = "(ahRegion.id.city IS NULL OR ahRegion.id.city = '') AND ";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_1 = "ahRegion.id.zip IS NULL";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_2 = "ahRegion.id.zip = ?";
    private static final String _FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_3 = "(ahRegion.id.zip IS NULL OR ahRegion.id.zip = '')";
    private static final String _SQL_SELECT_AHREGION = "SELECT ahRegion FROM AHRegion ahRegion";
    private static final String _SQL_SELECT_AHREGION_WHERE = "SELECT ahRegion FROM AHRegion ahRegion WHERE ";
    private static final String _SQL_COUNT_AHREGION = "SELECT COUNT(ahRegion) FROM AHRegion ahRegion";
    private static final String _SQL_COUNT_AHREGION_WHERE = "SELECT COUNT(ahRegion) FROM AHRegion ahRegion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahRegion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHRegion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AHRegion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHRegionPersistenceImpl.class);
    private static AHRegion _nullAHRegion = new AHRegionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHRegion> toCacheModel() {
                return _nullAHRegionCacheModel;
            }
        };

    private static CacheModel<AHRegion> _nullAHRegionCacheModel = new CacheModel<AHRegion>() {
            @Override
            public AHRegion toEntityModel() {
                return _nullAHRegion;
            }
        };

    public AHRegionPersistenceImpl() {
        setModelClass(AHRegion.class);
    }

    /**
     * Returns all the a h regions where regionId = &#63;.
     *
     * @param regionId the region ID
     * @return the matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findByregionId(long regionId)
        throws SystemException {
        return findByregionId(regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the a h regions where regionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param regionId the region ID
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @return the range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findByregionId(long regionId, int start, int end)
        throws SystemException {
        return findByregionId(regionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h regions where regionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param regionId the region ID
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findByregionId(long regionId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID;
            finderArgs = new Object[] { regionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID;
            finderArgs = new Object[] { regionId, start, end, orderByComparator };
        }

        List<AHRegion> list = (List<AHRegion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHRegion ahRegion : list) {
                if ((regionId != ahRegion.getRegionId())) {
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

            query.append(_SQL_SELECT_AHREGION_WHERE);

            query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHRegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(regionId);

                if (!pagination) {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHRegion>(list);
                } else {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h region in the ordered set where regionId = &#63;.
     *
     * @param regionId the region ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findByregionId_First(long regionId,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchByregionId_First(regionId, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionId=");
        msg.append(regionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the first a h region in the ordered set where regionId = &#63;.
     *
     * @param regionId the region ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchByregionId_First(long regionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHRegion> list = findByregionId(regionId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h region in the ordered set where regionId = &#63;.
     *
     * @param regionId the region ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findByregionId_Last(long regionId,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchByregionId_Last(regionId, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("regionId=");
        msg.append(regionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the last a h region in the ordered set where regionId = &#63;.
     *
     * @param regionId the region ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchByregionId_Last(long regionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByregionId(regionId);

        if (count == 0) {
            return null;
        }

        List<AHRegion> list = findByregionId(regionId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h regions before and after the current a h region in the ordered set where regionId = &#63;.
     *
     * @param ahRegionPK the primary key of the current a h region
     * @param regionId the region ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion[] findByregionId_PrevAndNext(AHRegionPK ahRegionPK,
        long regionId, OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = findByPrimaryKey(ahRegionPK);

        Session session = null;

        try {
            session = openSession();

            AHRegion[] array = new AHRegionImpl[3];

            array[0] = getByregionId_PrevAndNext(session, ahRegion, regionId,
                    orderByComparator, true);

            array[1] = ahRegion;

            array[2] = getByregionId_PrevAndNext(session, ahRegion, regionId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHRegion getByregionId_PrevAndNext(Session session,
        AHRegion ahRegion, long regionId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHREGION_WHERE);

        query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

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
            query.append(AHRegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(regionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahRegion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHRegion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h regions where regionId = &#63; from the database.
     *
     * @param regionId the region ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByregionId(long regionId) throws SystemException {
        for (AHRegion ahRegion : findByregionId(regionId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahRegion);
        }
    }

    /**
     * Returns the number of a h regions where regionId = &#63;.
     *
     * @param regionId the region ID
     * @return the number of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByregionId(long regionId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONID;

        Object[] finderArgs = new Object[] { regionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHREGION_WHERE);

            query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(regionId);

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
     * Returns all the a h regions where zip = &#63;.
     *
     * @param zip the zip
     * @return the matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findByzip(String zip) throws SystemException {
        return findByzip(zip, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h regions where zip = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param zip the zip
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @return the range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findByzip(String zip, int start, int end)
        throws SystemException {
        return findByzip(zip, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h regions where zip = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param zip the zip
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findByzip(String zip, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZIP;
            finderArgs = new Object[] { zip };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ZIP;
            finderArgs = new Object[] { zip, start, end, orderByComparator };
        }

        List<AHRegion> list = (List<AHRegion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHRegion ahRegion : list) {
                if (!Validator.equals(zip, ahRegion.getZip())) {
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

            query.append(_SQL_SELECT_AHREGION_WHERE);

            boolean bindZip = false;

            if (zip == null) {
                query.append(_FINDER_COLUMN_ZIP_ZIP_1);
            } else if (zip.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ZIP_ZIP_3);
            } else {
                bindZip = true;

                query.append(_FINDER_COLUMN_ZIP_ZIP_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHRegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindZip) {
                    qPos.add(zip);
                }

                if (!pagination) {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHRegion>(list);
                } else {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h region in the ordered set where zip = &#63;.
     *
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findByzip_First(String zip,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchByzip_First(zip, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("zip=");
        msg.append(zip);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the first a h region in the ordered set where zip = &#63;.
     *
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchByzip_First(String zip,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHRegion> list = findByzip(zip, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h region in the ordered set where zip = &#63;.
     *
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findByzip_Last(String zip,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchByzip_Last(zip, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("zip=");
        msg.append(zip);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the last a h region in the ordered set where zip = &#63;.
     *
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchByzip_Last(String zip,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByzip(zip);

        if (count == 0) {
            return null;
        }

        List<AHRegion> list = findByzip(zip, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h regions before and after the current a h region in the ordered set where zip = &#63;.
     *
     * @param ahRegionPK the primary key of the current a h region
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion[] findByzip_PrevAndNext(AHRegionPK ahRegionPK, String zip,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = findByPrimaryKey(ahRegionPK);

        Session session = null;

        try {
            session = openSession();

            AHRegion[] array = new AHRegionImpl[3];

            array[0] = getByzip_PrevAndNext(session, ahRegion, zip,
                    orderByComparator, true);

            array[1] = ahRegion;

            array[2] = getByzip_PrevAndNext(session, ahRegion, zip,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHRegion getByzip_PrevAndNext(Session session, AHRegion ahRegion,
        String zip, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHREGION_WHERE);

        boolean bindZip = false;

        if (zip == null) {
            query.append(_FINDER_COLUMN_ZIP_ZIP_1);
        } else if (zip.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ZIP_ZIP_3);
        } else {
            bindZip = true;

            query.append(_FINDER_COLUMN_ZIP_ZIP_2);
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
            query.append(AHRegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindZip) {
            qPos.add(zip);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahRegion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHRegion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h regions where zip = &#63; from the database.
     *
     * @param zip the zip
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByzip(String zip) throws SystemException {
        for (AHRegion ahRegion : findByzip(zip, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahRegion);
        }
    }

    /**
     * Returns the number of a h regions where zip = &#63;.
     *
     * @param zip the zip
     * @return the number of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByzip(String zip) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ZIP;

        Object[] finderArgs = new Object[] { zip };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHREGION_WHERE);

            boolean bindZip = false;

            if (zip == null) {
                query.append(_FINDER_COLUMN_ZIP_ZIP_1);
            } else if (zip.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ZIP_ZIP_3);
            } else {
                bindZip = true;

                query.append(_FINDER_COLUMN_ZIP_ZIP_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindZip) {
                    qPos.add(zip);
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
     * Returns all the a h regions where city = &#63;.
     *
     * @param city the city
     * @return the matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycity(String city) throws SystemException {
        return findBycity(city, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h regions where city = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @return the range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycity(String city, int start, int end)
        throws SystemException {
        return findBycity(city, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h regions where city = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycity(String city, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITY;
            finderArgs = new Object[] { city };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CITY;
            finderArgs = new Object[] { city, start, end, orderByComparator };
        }

        List<AHRegion> list = (List<AHRegion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHRegion ahRegion : list) {
                if (!Validator.equals(city, ahRegion.getCity())) {
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

            query.append(_SQL_SELECT_AHREGION_WHERE);

            boolean bindCity = false;

            if (city == null) {
                query.append(_FINDER_COLUMN_CITY_CITY_1);
            } else if (city.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CITY_CITY_3);
            } else {
                bindCity = true;

                query.append(_FINDER_COLUMN_CITY_CITY_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHRegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCity) {
                    qPos.add(city);
                }

                if (!pagination) {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHRegion>(list);
                } else {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h region in the ordered set where city = &#63;.
     *
     * @param city the city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findBycity_First(String city,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchBycity_First(city, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("city=");
        msg.append(city);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the first a h region in the ordered set where city = &#63;.
     *
     * @param city the city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchBycity_First(String city,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHRegion> list = findBycity(city, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h region in the ordered set where city = &#63;.
     *
     * @param city the city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findBycity_Last(String city,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchBycity_Last(city, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("city=");
        msg.append(city);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the last a h region in the ordered set where city = &#63;.
     *
     * @param city the city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchBycity_Last(String city,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycity(city);

        if (count == 0) {
            return null;
        }

        List<AHRegion> list = findBycity(city, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h regions before and after the current a h region in the ordered set where city = &#63;.
     *
     * @param ahRegionPK the primary key of the current a h region
     * @param city the city
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion[] findBycity_PrevAndNext(AHRegionPK ahRegionPK,
        String city, OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = findByPrimaryKey(ahRegionPK);

        Session session = null;

        try {
            session = openSession();

            AHRegion[] array = new AHRegionImpl[3];

            array[0] = getBycity_PrevAndNext(session, ahRegion, city,
                    orderByComparator, true);

            array[1] = ahRegion;

            array[2] = getBycity_PrevAndNext(session, ahRegion, city,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHRegion getBycity_PrevAndNext(Session session,
        AHRegion ahRegion, String city, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHREGION_WHERE);

        boolean bindCity = false;

        if (city == null) {
            query.append(_FINDER_COLUMN_CITY_CITY_1);
        } else if (city.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CITY_CITY_3);
        } else {
            bindCity = true;

            query.append(_FINDER_COLUMN_CITY_CITY_2);
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
            query.append(AHRegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindCity) {
            qPos.add(city);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahRegion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHRegion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h regions where city = &#63; from the database.
     *
     * @param city the city
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycity(String city) throws SystemException {
        for (AHRegion ahRegion : findBycity(city, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahRegion);
        }
    }

    /**
     * Returns the number of a h regions where city = &#63;.
     *
     * @param city the city
     * @return the number of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycity(String city) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CITY;

        Object[] finderArgs = new Object[] { city };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_AHREGION_WHERE);

            boolean bindCity = false;

            if (city == null) {
                query.append(_FINDER_COLUMN_CITY_CITY_1);
            } else if (city.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CITY_CITY_3);
            } else {
                bindCity = true;

                query.append(_FINDER_COLUMN_CITY_CITY_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCity) {
                    qPos.add(city);
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
     * Returns all the a h regions where city = &#63; and zip = &#63;.
     *
     * @param city the city
     * @param zip the zip
     * @return the matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycityAndZip(String city, String zip)
        throws SystemException {
        return findBycityAndZip(city, zip, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h regions where city = &#63; and zip = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param zip the zip
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @return the range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycityAndZip(String city, String zip, int start,
        int end) throws SystemException {
        return findBycityAndZip(city, zip, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h regions where city = &#63; and zip = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param city the city
     * @param zip the zip
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycityAndZip(String city, String zip, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYANDZIP;
            finderArgs = new Object[] { city, zip };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYANDZIP;
            finderArgs = new Object[] { city, zip, start, end, orderByComparator };
        }

        List<AHRegion> list = (List<AHRegion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHRegion ahRegion : list) {
                if (!Validator.equals(city, ahRegion.getCity()) ||
                        !Validator.equals(zip, ahRegion.getZip())) {
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

            query.append(_SQL_SELECT_AHREGION_WHERE);

            boolean bindCity = false;

            if (city == null) {
                query.append(_FINDER_COLUMN_CITYANDZIP_CITY_1);
            } else if (city.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CITYANDZIP_CITY_3);
            } else {
                bindCity = true;

                query.append(_FINDER_COLUMN_CITYANDZIP_CITY_2);
            }

            boolean bindZip = false;

            if (zip == null) {
                query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_1);
            } else if (zip.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_3);
            } else {
                bindZip = true;

                query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHRegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCity) {
                    qPos.add(city);
                }

                if (bindZip) {
                    qPos.add(zip);
                }

                if (!pagination) {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHRegion>(list);
                } else {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h region in the ordered set where city = &#63; and zip = &#63;.
     *
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findBycityAndZip_First(String city, String zip,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchBycityAndZip_First(city, zip, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("city=");
        msg.append(city);

        msg.append(", zip=");
        msg.append(zip);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the first a h region in the ordered set where city = &#63; and zip = &#63;.
     *
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchBycityAndZip_First(String city, String zip,
        OrderByComparator orderByComparator) throws SystemException {
        List<AHRegion> list = findBycityAndZip(city, zip, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h region in the ordered set where city = &#63; and zip = &#63;.
     *
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findBycityAndZip_Last(String city, String zip,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchBycityAndZip_Last(city, zip, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("city=");
        msg.append(city);

        msg.append(", zip=");
        msg.append(zip);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the last a h region in the ordered set where city = &#63; and zip = &#63;.
     *
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchBycityAndZip_Last(String city, String zip,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBycityAndZip(city, zip);

        if (count == 0) {
            return null;
        }

        List<AHRegion> list = findBycityAndZip(city, zip, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h regions before and after the current a h region in the ordered set where city = &#63; and zip = &#63;.
     *
     * @param ahRegionPK the primary key of the current a h region
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion[] findBycityAndZip_PrevAndNext(AHRegionPK ahRegionPK,
        String city, String zip, OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = findByPrimaryKey(ahRegionPK);

        Session session = null;

        try {
            session = openSession();

            AHRegion[] array = new AHRegionImpl[3];

            array[0] = getBycityAndZip_PrevAndNext(session, ahRegion, city,
                    zip, orderByComparator, true);

            array[1] = ahRegion;

            array[2] = getBycityAndZip_PrevAndNext(session, ahRegion, city,
                    zip, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHRegion getBycityAndZip_PrevAndNext(Session session,
        AHRegion ahRegion, String city, String zip,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHREGION_WHERE);

        boolean bindCity = false;

        if (city == null) {
            query.append(_FINDER_COLUMN_CITYANDZIP_CITY_1);
        } else if (city.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CITYANDZIP_CITY_3);
        } else {
            bindCity = true;

            query.append(_FINDER_COLUMN_CITYANDZIP_CITY_2);
        }

        boolean bindZip = false;

        if (zip == null) {
            query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_1);
        } else if (zip.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_3);
        } else {
            bindZip = true;

            query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_2);
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
            query.append(AHRegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindCity) {
            qPos.add(city);
        }

        if (bindZip) {
            qPos.add(zip);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahRegion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHRegion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h regions where city = &#63; and zip = &#63; from the database.
     *
     * @param city the city
     * @param zip the zip
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycityAndZip(String city, String zip)
        throws SystemException {
        for (AHRegion ahRegion : findBycityAndZip(city, zip, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(ahRegion);
        }
    }

    /**
     * Returns the number of a h regions where city = &#63; and zip = &#63;.
     *
     * @param city the city
     * @param zip the zip
     * @return the number of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycityAndZip(String city, String zip)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CITYANDZIP;

        Object[] finderArgs = new Object[] { city, zip };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_AHREGION_WHERE);

            boolean bindCity = false;

            if (city == null) {
                query.append(_FINDER_COLUMN_CITYANDZIP_CITY_1);
            } else if (city.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CITYANDZIP_CITY_3);
            } else {
                bindCity = true;

                query.append(_FINDER_COLUMN_CITYANDZIP_CITY_2);
            }

            boolean bindZip = false;

            if (zip == null) {
                query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_1);
            } else if (zip.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_3);
            } else {
                bindZip = true;

                query.append(_FINDER_COLUMN_CITYANDZIP_ZIP_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCity) {
                    qPos.add(city);
                }

                if (bindZip) {
                    qPos.add(zip);
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
     * Returns all the a h regions where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @return the matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycountryAndCityAndZip(String country,
        String city, String zip) throws SystemException {
        return findBycountryAndCityAndZip(country, city, zip,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h regions where country = &#63; and city = &#63; and zip = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @return the range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycountryAndCityAndZip(String country,
        String city, String zip, int start, int end) throws SystemException {
        return findBycountryAndCityAndZip(country, city, zip, start, end, null);
    }

    /**
     * Returns an ordered range of all the a h regions where country = &#63; and city = &#63; and zip = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findBycountryAndCityAndZip(String country,
        String city, String zip, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP;
            finderArgs = new Object[] { country, city, zip };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP;
            finderArgs = new Object[] {
                    country, city, zip,
                    
                    start, end, orderByComparator
                };
        }

        List<AHRegion> list = (List<AHRegion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AHRegion ahRegion : list) {
                if (!Validator.equals(country, ahRegion.getCountry()) ||
                        !Validator.equals(city, ahRegion.getCity()) ||
                        !Validator.equals(zip, ahRegion.getZip())) {
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

            query.append(_SQL_SELECT_AHREGION_WHERE);

            boolean bindCountry = false;

            if (country == null) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_1);
            } else if (country.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_3);
            } else {
                bindCountry = true;

                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_2);
            }

            boolean bindCity = false;

            if (city == null) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_1);
            } else if (city.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_3);
            } else {
                bindCity = true;

                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_2);
            }

            boolean bindZip = false;

            if (zip == null) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_1);
            } else if (zip.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_3);
            } else {
                bindZip = true;

                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AHRegionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCountry) {
                    qPos.add(country);
                }

                if (bindCity) {
                    qPos.add(city);
                }

                if (bindZip) {
                    qPos.add(zip);
                }

                if (!pagination) {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHRegion>(list);
                } else {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
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
     * Returns the first a h region in the ordered set where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findBycountryAndCityAndZip_First(String country,
        String city, String zip, OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchBycountryAndCityAndZip_First(country, city,
                zip, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("country=");
        msg.append(country);

        msg.append(", city=");
        msg.append(city);

        msg.append(", zip=");
        msg.append(zip);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the first a h region in the ordered set where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchBycountryAndCityAndZip_First(String country,
        String city, String zip, OrderByComparator orderByComparator)
        throws SystemException {
        List<AHRegion> list = findBycountryAndCityAndZip(country, city, zip, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last a h region in the ordered set where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findBycountryAndCityAndZip_Last(String country,
        String city, String zip, OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchBycountryAndCityAndZip_Last(country, city,
                zip, orderByComparator);

        if (ahRegion != null) {
            return ahRegion;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("country=");
        msg.append(country);

        msg.append(", city=");
        msg.append(city);

        msg.append(", zip=");
        msg.append(zip);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAHRegionException(msg.toString());
    }

    /**
     * Returns the last a h region in the ordered set where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchBycountryAndCityAndZip_Last(String country,
        String city, String zip, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBycountryAndCityAndZip(country, city, zip);

        if (count == 0) {
            return null;
        }

        List<AHRegion> list = findBycountryAndCityAndZip(country, city, zip,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the a h regions before and after the current a h region in the ordered set where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param ahRegionPK the primary key of the current a h region
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion[] findBycountryAndCityAndZip_PrevAndNext(
        AHRegionPK ahRegionPK, String country, String city, String zip,
        OrderByComparator orderByComparator)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = findByPrimaryKey(ahRegionPK);

        Session session = null;

        try {
            session = openSession();

            AHRegion[] array = new AHRegionImpl[3];

            array[0] = getBycountryAndCityAndZip_PrevAndNext(session, ahRegion,
                    country, city, zip, orderByComparator, true);

            array[1] = ahRegion;

            array[2] = getBycountryAndCityAndZip_PrevAndNext(session, ahRegion,
                    country, city, zip, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AHRegion getBycountryAndCityAndZip_PrevAndNext(Session session,
        AHRegion ahRegion, String country, String city, String zip,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_AHREGION_WHERE);

        boolean bindCountry = false;

        if (country == null) {
            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_1);
        } else if (country.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_3);
        } else {
            bindCountry = true;

            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_2);
        }

        boolean bindCity = false;

        if (city == null) {
            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_1);
        } else if (city.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_3);
        } else {
            bindCity = true;

            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_2);
        }

        boolean bindZip = false;

        if (zip == null) {
            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_1);
        } else if (zip.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_3);
        } else {
            bindZip = true;

            query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_2);
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
            query.append(AHRegionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindCountry) {
            qPos.add(country);
        }

        if (bindCity) {
            qPos.add(city);
        }

        if (bindZip) {
            qPos.add(zip);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(ahRegion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AHRegion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the a h regions where country = &#63; and city = &#63; and zip = &#63; from the database.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycountryAndCityAndZip(String country, String city,
        String zip) throws SystemException {
        for (AHRegion ahRegion : findBycountryAndCityAndZip(country, city, zip,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(ahRegion);
        }
    }

    /**
     * Returns the number of a h regions where country = &#63; and city = &#63; and zip = &#63;.
     *
     * @param country the country
     * @param city the city
     * @param zip the zip
     * @return the number of matching a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycountryAndCityAndZip(String country, String city,
        String zip) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYANDCITYANDZIP;

        Object[] finderArgs = new Object[] { country, city, zip };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_AHREGION_WHERE);

            boolean bindCountry = false;

            if (country == null) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_1);
            } else if (country.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_3);
            } else {
                bindCountry = true;

                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_COUNTRY_2);
            }

            boolean bindCity = false;

            if (city == null) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_1);
            } else if (city.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_3);
            } else {
                bindCity = true;

                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_CITY_2);
            }

            boolean bindZip = false;

            if (zip == null) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_1);
            } else if (zip.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_3);
            } else {
                bindZip = true;

                query.append(_FINDER_COLUMN_COUNTRYANDCITYANDZIP_ZIP_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindCountry) {
                    qPos.add(country);
                }

                if (bindCity) {
                    qPos.add(city);
                }

                if (bindZip) {
                    qPos.add(zip);
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
     * Caches the a h region in the entity cache if it is enabled.
     *
     * @param ahRegion the a h region
     */
    @Override
    public void cacheResult(AHRegion ahRegion) {
        EntityCacheUtil.putResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionImpl.class, ahRegion.getPrimaryKey(), ahRegion);

        ahRegion.resetOriginalValues();
    }

    /**
     * Caches the a h regions in the entity cache if it is enabled.
     *
     * @param ahRegions the a h regions
     */
    @Override
    public void cacheResult(List<AHRegion> ahRegions) {
        for (AHRegion ahRegion : ahRegions) {
            if (EntityCacheUtil.getResult(
                        AHRegionModelImpl.ENTITY_CACHE_ENABLED,
                        AHRegionImpl.class, ahRegion.getPrimaryKey()) == null) {
                cacheResult(ahRegion);
            } else {
                ahRegion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h regions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHRegionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHRegionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h region.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHRegion ahRegion) {
        EntityCacheUtil.removeResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionImpl.class, ahRegion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHRegion> ahRegions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHRegion ahRegion : ahRegions) {
            EntityCacheUtil.removeResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
                AHRegionImpl.class, ahRegion.getPrimaryKey());
        }
    }

    /**
     * Creates a new a h region with the primary key. Does not add the a h region to the database.
     *
     * @param ahRegionPK the primary key for the new a h region
     * @return the new a h region
     */
    @Override
    public AHRegion create(AHRegionPK ahRegionPK) {
        AHRegion ahRegion = new AHRegionImpl();

        ahRegion.setNew(true);
        ahRegion.setPrimaryKey(ahRegionPK);

        return ahRegion;
    }

    /**
     * Removes the a h region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param ahRegionPK the primary key of the a h region
     * @return the a h region that was removed
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion remove(AHRegionPK ahRegionPK)
        throws NoSuchAHRegionException, SystemException {
        return remove((Serializable) ahRegionPK);
    }

    /**
     * Removes the a h region with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h region
     * @return the a h region that was removed
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion remove(Serializable primaryKey)
        throws NoSuchAHRegionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHRegion ahRegion = (AHRegion) session.get(AHRegionImpl.class,
                    primaryKey);

            if (ahRegion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahRegion);
        } catch (NoSuchAHRegionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHRegion removeImpl(AHRegion ahRegion) throws SystemException {
        ahRegion = toUnwrappedModel(ahRegion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahRegion)) {
                ahRegion = (AHRegion) session.get(AHRegionImpl.class,
                        ahRegion.getPrimaryKeyObj());
            }

            if (ahRegion != null) {
                session.delete(ahRegion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahRegion != null) {
            clearCache(ahRegion);
        }

        return ahRegion;
    }

    @Override
    public AHRegion updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws SystemException {
        ahRegion = toUnwrappedModel(ahRegion);

        boolean isNew = ahRegion.isNew();

        AHRegionModelImpl ahRegionModelImpl = (AHRegionModelImpl) ahRegion;

        Session session = null;

        try {
            session = openSession();

            if (ahRegion.isNew()) {
                session.save(ahRegion);

                ahRegion.setNew(false);
            } else {
                session.merge(ahRegion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AHRegionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((ahRegionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahRegionModelImpl.getOriginalRegionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
                    args);

                args = new Object[] { ahRegionModelImpl.getRegionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
                    args);
            }

            if ((ahRegionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZIP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahRegionModelImpl.getOriginalZip() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZIP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZIP,
                    args);

                args = new Object[] { ahRegionModelImpl.getZip() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZIP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZIP,
                    args);
            }

            if ((ahRegionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { ahRegionModelImpl.getOriginalCity() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITY,
                    args);

                args = new Object[] { ahRegionModelImpl.getCity() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITY,
                    args);
            }

            if ((ahRegionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYANDZIP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahRegionModelImpl.getOriginalCity(),
                        ahRegionModelImpl.getOriginalZip()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYANDZIP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYANDZIP,
                    args);

                args = new Object[] {
                        ahRegionModelImpl.getCity(), ahRegionModelImpl.getZip()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYANDZIP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYANDZIP,
                    args);
            }

            if ((ahRegionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        ahRegionModelImpl.getOriginalCountry(),
                        ahRegionModelImpl.getOriginalCity(),
                        ahRegionModelImpl.getOriginalZip()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYANDCITYANDZIP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP,
                    args);

                args = new Object[] {
                        ahRegionModelImpl.getCountry(),
                        ahRegionModelImpl.getCity(), ahRegionModelImpl.getZip()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYANDCITYANDZIP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYANDCITYANDZIP,
                    args);
            }
        }

        EntityCacheUtil.putResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
            AHRegionImpl.class, ahRegion.getPrimaryKey(), ahRegion);

        return ahRegion;
    }

    protected AHRegion toUnwrappedModel(AHRegion ahRegion) {
        if (ahRegion instanceof AHRegionImpl) {
            return ahRegion;
        }

        AHRegionImpl ahRegionImpl = new AHRegionImpl();

        ahRegionImpl.setNew(ahRegion.isNew());
        ahRegionImpl.setPrimaryKey(ahRegion.getPrimaryKey());

        ahRegionImpl.setRegionId(ahRegion.getRegionId());
        ahRegionImpl.setZip(ahRegion.getZip());
        ahRegionImpl.setCity(ahRegion.getCity());
        ahRegionImpl.setCountry(ahRegion.getCountry());
        ahRegionImpl.setPermissions(ahRegion.getPermissions());

        return ahRegionImpl;
    }

    /**
     * Returns the a h region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h region
     * @return the a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHRegionException, SystemException {
        AHRegion ahRegion = fetchByPrimaryKey(primaryKey);

        if (ahRegion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahRegion;
    }

    /**
     * Returns the a h region with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException} if it could not be found.
     *
     * @param ahRegionPK the primary key of the a h region
     * @return the a h region
     * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion findByPrimaryKey(AHRegionPK ahRegionPK)
        throws NoSuchAHRegionException, SystemException {
        return findByPrimaryKey((Serializable) ahRegionPK);
    }

    /**
     * Returns the a h region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h region
     * @return the a h region, or <code>null</code> if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHRegion ahRegion = (AHRegion) EntityCacheUtil.getResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
                AHRegionImpl.class, primaryKey);

        if (ahRegion == _nullAHRegion) {
            return null;
        }

        if (ahRegion == null) {
            Session session = null;

            try {
                session = openSession();

                ahRegion = (AHRegion) session.get(AHRegionImpl.class, primaryKey);

                if (ahRegion != null) {
                    cacheResult(ahRegion);
                } else {
                    EntityCacheUtil.putResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
                        AHRegionImpl.class, primaryKey, _nullAHRegion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHRegionModelImpl.ENTITY_CACHE_ENABLED,
                    AHRegionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return ahRegion;
    }

    /**
     * Returns the a h region with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param ahRegionPK the primary key of the a h region
     * @return the a h region, or <code>null</code> if a a h region with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHRegion fetchByPrimaryKey(AHRegionPK ahRegionPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) ahRegionPK);
    }

    /**
     * Returns all the a h regions.
     *
     * @return the a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h regions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @return the range of a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h regions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h regions
     * @param end the upper bound of the range of a h regions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h regions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHRegion> findAll(int start, int end,
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

        List<AHRegion> list = (List<AHRegion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHREGION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AHREGION;

                if (pagination) {
                    sql = sql.concat(AHRegionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHRegion>(list);
                } else {
                    list = (List<AHRegion>) QueryUtil.list(q, getDialect(),
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
     * Removes all the a h regions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHRegion ahRegion : findAll()) {
            remove(ahRegion);
        }
    }

    /**
     * Returns the number of a h regions.
     *
     * @return the number of a h regions
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

                Query q = session.createQuery(_SQL_COUNT_AHREGION);

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
     * Initializes the a h region persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.particity.model.AHRegion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHRegion>> listenersList = new ArrayList<ModelListener<AHRegion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHRegion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHRegionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
