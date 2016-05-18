package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.oefit.particity.model.AHRegion;

/**
 * The persistence interface for the a h region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHRegionPersistenceImpl
 * @see AHRegionUtil
 * @generated
 */
public interface AHRegionPersistence extends BasePersistence<AHRegion> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHRegionUtil} to access the a h region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the a h regions where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByregionId(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByregionId(
        long regionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByregionId(
        long regionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h region in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findByregionId_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the first a h region in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByregionId_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h region in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findByregionId_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the last a h region in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByregionId_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findByregionId_PrevAndNext(
        AHRegionPK ahRegionPK, long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Removes all the a h regions where regionId = &#63; from the database.
    *
    * @param regionId the region ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByregionId(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h regions where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public int countByregionId(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h regions where zip = &#63;.
    *
    * @param zip the zip
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByzip(
        java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByzip(
        java.lang.String zip, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findByzip(
        java.lang.String zip, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h region in the ordered set where zip = &#63;.
    *
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findByzip_First(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the first a h region in the ordered set where zip = &#63;.
    *
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByzip_First(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h region in the ordered set where zip = &#63;.
    *
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findByzip_Last(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the last a h region in the ordered set where zip = &#63;.
    *
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByzip_Last(
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findByzip_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Removes all the a h regions where zip = &#63; from the database.
    *
    * @param zip the zip
    * @throws SystemException if a system exception occurred
    */
    public void removeByzip(java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h regions where zip = &#63;.
    *
    * @param zip the zip
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public int countByzip(java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h regions where city = &#63;.
    *
    * @param city the city
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycity(
        java.lang.String city)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycity(
        java.lang.String city, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycity(
        java.lang.String city, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h region in the ordered set where city = &#63;.
    *
    * @param city the city
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycity_First(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the first a h region in the ordered set where city = &#63;.
    *
    * @param city the city
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycity_First(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h region in the ordered set where city = &#63;.
    *
    * @param city the city
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycity_Last(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the last a h region in the ordered set where city = &#63;.
    *
    * @param city the city
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycity_Last(
        java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findBycity_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String city,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Removes all the a h regions where city = &#63; from the database.
    *
    * @param city the city
    * @throws SystemException if a system exception occurred
    */
    public void removeBycity(java.lang.String city)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h regions where city = &#63;.
    *
    * @param city the city
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public int countBycity(java.lang.String city)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h regions where city = &#63; and zip = &#63;.
    *
    * @param city the city
    * @param zip the zip
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycityAndZip(
        java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycityAndZip(
        java.lang.String city, java.lang.String zip, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycityAndZip(
        java.lang.String city, java.lang.String zip, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycityAndZip_First(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the first a h region in the ordered set where city = &#63; and zip = &#63;.
    *
    * @param city the city
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycityAndZip_First(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycityAndZip_Last(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the last a h region in the ordered set where city = &#63; and zip = &#63;.
    *
    * @param city the city
    * @param zip the zip
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h region, or <code>null</code> if a matching a h region could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycityAndZip_Last(
        java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findBycityAndZip_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Removes all the a h regions where city = &#63; and zip = &#63; from the database.
    *
    * @param city the city
    * @param zip the zip
    * @throws SystemException if a system exception occurred
    */
    public void removeBycityAndZip(java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h regions where city = &#63; and zip = &#63;.
    *
    * @param city the city
    * @param zip the zip
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public int countBycityAndZip(java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h regions where country = &#63; and city = &#63; and zip = &#63;.
    *
    * @param country the country
    * @param city the city
    * @param zip the zip
    * @return the matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycountryAndCityAndZip(
        java.lang.String country, java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycountryAndCityAndZip(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findBycountryAndCityAndZip(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycountryAndCityAndZip_First(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycountryAndCityAndZip_First(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findBycountryAndCityAndZip_Last(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchBycountryAndCityAndZip_Last(
        java.lang.String country, java.lang.String city, java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion[] findBycountryAndCityAndZip_PrevAndNext(
        AHRegionPK ahRegionPK, java.lang.String country, java.lang.String city,
        java.lang.String zip,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Removes all the a h regions where country = &#63; and city = &#63; and zip = &#63; from the database.
    *
    * @param country the country
    * @param city the city
    * @param zip the zip
    * @throws SystemException if a system exception occurred
    */
    public void removeBycountryAndCityAndZip(java.lang.String country,
        java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h regions where country = &#63; and city = &#63; and zip = &#63;.
    *
    * @param country the country
    * @param city the city
    * @param zip the zip
    * @return the number of matching a h regions
    * @throws SystemException if a system exception occurred
    */
    public int countBycountryAndCityAndZip(java.lang.String country,
        java.lang.String city, java.lang.String zip)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the a h region in the entity cache if it is enabled.
    *
    * @param ahRegion the a h region
    */
    public void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion);

    /**
    * Caches the a h regions in the entity cache if it is enabled.
    *
    * @param ahRegions the a h regions
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> ahRegions);

    /**
    * Creates a new a h region with the primary key. Does not add the a h region to the database.
    *
    * @param ahRegionPK the primary key for the new a h region
    * @return the new a h region
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion create(
        AHRegionPK ahRegionPK);

    /**
    * Removes the a h region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion remove(
        AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    public de.fraunhofer.fokus.oefit.particity.model.AHRegion updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h region with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException} if it could not be found.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion findByPrimaryKey(
        AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException;

    /**
    * Returns the a h region with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region, or <code>null</code> if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchByPrimaryKey(
        AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h regions.
    *
    * @return the a h regions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h regions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h regions.
    *
    * @return the number of a h regions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
