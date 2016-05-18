package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.fraunhofer.fokus.oefit.particity.model.AHRegion;

import java.util.List;

/**
 * The persistence utility for the a h region service. This utility wraps {@link AHRegionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHRegionPersistence
 * @see AHRegionPersistenceImpl
 * @generated
 */
public class AHRegionUtil {
    private static AHRegionPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(AHRegion ahRegion) {
        getPersistence().clearCache(ahRegion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<AHRegion> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHRegion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHRegion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHRegion update(AHRegion ahRegion) throws SystemException {
        return getPersistence().update(ahRegion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHRegion update(AHRegion ahRegion,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(ahRegion, serviceContext);
    }

    /**
    * Returns all the a h regions where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByregionId(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregionId(regionId);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByregionId(
        long regionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregionId(regionId, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByregionId(
        long regionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregionId(regionId, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findByregionId_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findByregionId_First(regionId, orderByComparator);
    }

    /**
    * Returns the first a h region in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByregionId_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregionId_First(regionId, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findByregionId_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findByregionId_Last(regionId, orderByComparator);
    }

    /**
    * Returns the last a h region in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByregionId_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByregionId_Last(regionId, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findByregionId_PrevAndNext(
        AHRegionPK ahRegionPK, long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findByregionId_PrevAndNext(ahRegionPK, regionId,
            orderByComparator);
    }

    /**
    * Removes all the a h regions where regionId = &#63; from the database.
    *
    * @param regionId the region ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByregionId(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByregionId(regionId);
    }

    /**
    * Returns the number of a h regions where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByregionId(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByregionId(regionId);
    }

    /**
    * Returns all the a h regions where zip = &#63;.
    *
    * @param zip the zip
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByzip(
        java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByzip(zip);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByzip(
        java.lang.String zip, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByzip(zip, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByzip(
        java.lang.String zip, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByzip(zip, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findByzip_First(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findByzip_First(zip, orderByComparator);
    }

    /**
    * Returns the first a h region in the ordered set where zip = &#63;.
    *
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByzip_First(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByzip_First(zip, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findByzip_Last(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findByzip_Last(zip, orderByComparator);
    }

    /**
    * Returns the last a h region in the ordered set where zip = &#63;.
    *
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByzip_Last(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByzip_Last(zip, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findByzip_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findByzip_PrevAndNext(ahRegionPK, zip, orderByComparator);
    }

    /**
    * Removes all the a h regions where zip = &#63; from the database.
    *
    * @param zip the zip
    * @throws SystemException if a system exception occurred
    */
    public static void removeByzip(java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByzip(zip);
    }

    /**
    * Returns the number of a h regions where zip = &#63;.
    *
    * @param zip the zip
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static int countByzip(java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByzip(zip);
    }

    /**
    * Returns all the a h regions where city = &#63;.
    *
    * @param city the city
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycity(
        java.lang.String city)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycity(city);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycity(
        java.lang.String city, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycity(city, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycity(
        java.lang.String city, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycity(city, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycity_First(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findBycity_First(city, orderByComparator);
    }

    /**
    * Returns the first a h region in the ordered set where city = &#63;.
    *
    * @param city the city
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycity_First(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBycity_First(city, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycity_Last(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findBycity_Last(city, orderByComparator);
    }

    /**
    * Returns the last a h region in the ordered set where city = &#63;.
    *
    * @param city the city
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycity_Last(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBycity_Last(city, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findBycity_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycity_PrevAndNext(ahRegionPK, city, orderByComparator);
    }

    /**
    * Removes all the a h regions where city = &#63; from the database.
    *
    * @param city the city
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycity(java.lang.String city)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycity(city);
    }

    /**
    * Returns the number of a h regions where city = &#63;.
    *
    * @param city the city
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static int countBycity(java.lang.String city)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycity(city);
    }

    /**
    * Returns all the a h regions where city = &#63; and zip = &#63;.
    *
    * @param city the city
    * @param zip the zip
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycityAndZip(
        java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycityAndZip(city, zip);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycityAndZip(
        java.lang.String city, java.lang.String zip, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycityAndZip(city, zip, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycityAndZip(
        java.lang.String city, java.lang.String zip, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycityAndZip(city, zip, start, end, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycityAndZip_First(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycityAndZip_First(city, zip, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycityAndZip_First(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycityAndZip_First(city, zip, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycityAndZip_Last(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycityAndZip_Last(city, zip, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycityAndZip_Last(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycityAndZip_Last(city, zip, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findBycityAndZip_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycityAndZip_PrevAndNext(ahRegionPK, city, zip,
            orderByComparator);
    }

    /**
    * Removes all the a h regions where city = &#63; and zip = &#63; from the database.
    *
    * @param city the city
    * @param zip the zip
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycityAndZip(java.lang.String city,
        java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycityAndZip(city, zip);
    }

    /**
    * Returns the number of a h regions where city = &#63; and zip = &#63;.
    *
    * @param city the city
    * @param zip the zip
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public static int countBycityAndZip(java.lang.String city,
        java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycityAndZip(city, zip);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycountryAndCityAndZip(
        java.lang.String country, java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycountryAndCityAndZip(country, city, zip);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycountryAndCityAndZip(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycountryAndCityAndZip(country, city, zip, start, end);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycountryAndCityAndZip(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBycountryAndCityAndZip(country, city, zip, start, end,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycountryAndCityAndZip_First(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycountryAndCityAndZip_First(country, city, zip,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycountryAndCityAndZip_First(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycountryAndCityAndZip_First(country, city, zip,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycountryAndCityAndZip_Last(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycountryAndCityAndZip_Last(country, city, zip,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycountryAndCityAndZip_Last(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBycountryAndCityAndZip_Last(country, city, zip,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findBycountryAndCityAndZip_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String country, java.lang.String city,
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence()
                   .findBycountryAndCityAndZip_PrevAndNext(ahRegionPK, country,
            city, zip, orderByComparator);
    }

    /**
    * Removes all the a h regions where country = &#63; and city = &#63; and zip = &#63; from the database.
    *
    * @param country the country
    * @param city the city
    * @param zip the zip
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycountryAndCityAndZip(java.lang.String country,
        java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycountryAndCityAndZip(country, city, zip);
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
    public static int countBycountryAndCityAndZip(java.lang.String country,
        java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycountryAndCityAndZip(country, city, zip);
    }

    /**
    * Caches the a h region in the entity cache if it is enabled.
    *
    * @param ahRegion the a h region
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion) {
        getPersistence().cacheResult(ahRegion);
    }

    /**
    * Caches the a h regions in the entity cache if it is enabled.
    *
    * @param ahRegions the a h regions
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> ahRegions) {
        getPersistence().cacheResult(ahRegions);
    }

    /**
    * Creates a new a h region with the primary key. Does not add the a h region to the database.
    *
    * @param ahRegionPK the primary key for the new a h region
    * @return the new a h region
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion create(
        AHRegionPK ahRegionPK) {
        return getPersistence().create(ahRegionPK);
    }

    /**
    * Removes the a h region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion remove(
        AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().remove(ahRegionPK);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahRegion);
    }

    /**
    * Returns the a h region with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException} if it could not be found.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion findByPrimaryKey(
        AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException {
        return getPersistence().findByPrimaryKey(ahRegionPK);
    }

    /**
    * Returns the a h region with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region, or <code>null</code> if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByPrimaryKey(
        AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(ahRegionPK);
    }

    /**
    * Returns all the a h regions.
    *
    * @return the a h regions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h regions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h regions.
    *
    * @return the number of a h regions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AHRegionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHRegionPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHRegionPersistence.class.getName());

            ReferenceRegistry.registerReference(AHRegionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHRegionPersistence persistence) {
    }
}
