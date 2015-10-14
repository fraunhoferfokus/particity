package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.oefit.particity.model.AHAddr;

/**
 * The persistence interface for the a h addr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHAddrPersistenceImpl
 * @see AHAddrUtil
 * @generated
 */
public interface AHAddrPersistence extends BasePersistence<AHAddr> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHAddrUtil} to access the a h addr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the a h addrs where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findByregion(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h addrs where regionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionId the region ID
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @return the range of matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findByregion(
        long regionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h addrs where regionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionId the region ID
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findByregion(
        long regionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h addr
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr findByregion_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException;

    /**
    * Returns the first a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h addr, or <code>null</code> if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr fetchByregion_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h addr
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr findByregion_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException;

    /**
    * Returns the last a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h addr, or <code>null</code> if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr fetchByregion_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h addrs before and after the current a h addr in the ordered set where regionId = &#63;.
    *
    * @param addrId the primary key of the current a h addr
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h addr
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr[] findByregion_PrevAndNext(
        long addrId, long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException;

    /**
    * Removes all the a h addrs where regionId = &#63; from the database.
    *
    * @param regionId the region ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByregion(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h addrs where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the number of matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public int countByregion(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the a h addr in the entity cache if it is enabled.
    *
    * @param ahAddr the a h addr
    */
    public void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHAddr ahAddr);

    /**
    * Caches the a h addrs in the entity cache if it is enabled.
    *
    * @param ahAddrs the a h addrs
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> ahAddrs);

    /**
    * Creates a new a h addr with the primary key. Does not add the a h addr to the database.
    *
    * @param addrId the primary key for the new a h addr
    * @return the new a h addr
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr create(long addrId);

    /**
    * Removes the a h addr with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr remove(long addrId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException;

    public de.fraunhofer.fokus.oefit.particity.model.AHAddr updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHAddr ahAddr)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h addr with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException} if it could not be found.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr findByPrimaryKey(
        long addrId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException;

    /**
    * Returns the a h addr with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr, or <code>null</code> if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHAddr fetchByPrimaryKey(
        long addrId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h addrs.
    *
    * @return the a h addrs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h addrs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @return the range of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h addrs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h addrs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h addrs.
    *
    * @return the number of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
