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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.fraunhofer.fokus.oefit.adhoc.model.AHAddr;

import java.util.List;

/**
 * The persistence utility for the a h addr service. This utility wraps {@link AHAddrPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHAddrPersistence
 * @see AHAddrPersistenceImpl
 * @generated
 */
public class AHAddrUtil {
    private static AHAddrPersistence _persistence;

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
    public static void clearCache(AHAddr ahAddr) {
        getPersistence().clearCache(ahAddr);
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
    public static List<AHAddr> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHAddr> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHAddr> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHAddr update(AHAddr ahAddr) throws SystemException {
        return getPersistence().update(ahAddr);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHAddr update(AHAddr ahAddr, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(ahAddr, serviceContext);
    }

    /**
    * Returns all the a h addrs where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> findByregion(
        long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregion(regionId);
    }

    /**
    * Returns a range of all the a h addrs where regionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionId the region ID
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @return the range of matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> findByregion(
        long regionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregion(regionId, start, end);
    }

    /**
    * Returns an ordered range of all the a h addrs where regionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param regionId the region ID
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> findByregion(
        long regionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregion(regionId, start, end, orderByComparator);
    }

    /**
    * Returns the first a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h addr
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr findByregion_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException {
        return getPersistence().findByregion_First(regionId, orderByComparator);
    }

    /**
    * Returns the first a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h addr, or <code>null</code> if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr fetchByregion_First(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByregion_First(regionId, orderByComparator);
    }

    /**
    * Returns the last a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h addr
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr findByregion_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException {
        return getPersistence().findByregion_Last(regionId, orderByComparator);
    }

    /**
    * Returns the last a h addr in the ordered set where regionId = &#63;.
    *
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h addr, or <code>null</code> if a matching a h addr could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr fetchByregion_Last(
        long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByregion_Last(regionId, orderByComparator);
    }

    /**
    * Returns the a h addrs before and after the current a h addr in the ordered set where regionId = &#63;.
    *
    * @param addrId the primary key of the current a h addr
    * @param regionId the region ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h addr
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr[] findByregion_PrevAndNext(
        long addrId, long regionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException {
        return getPersistence()
                   .findByregion_PrevAndNext(addrId, regionId, orderByComparator);
    }

    /**
    * Removes all the a h addrs where regionId = &#63; from the database.
    *
    * @param regionId the region ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByregion(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByregion(regionId);
    }

    /**
    * Returns the number of a h addrs where regionId = &#63;.
    *
    * @param regionId the region ID
    * @return the number of matching a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static int countByregion(long regionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByregion(regionId);
    }

    /**
    * Caches the a h addr in the entity cache if it is enabled.
    *
    * @param ahAddr the a h addr
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHAddr ahAddr) {
        getPersistence().cacheResult(ahAddr);
    }

    /**
    * Caches the a h addrs in the entity cache if it is enabled.
    *
    * @param ahAddrs the a h addrs
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> ahAddrs) {
        getPersistence().cacheResult(ahAddrs);
    }

    /**
    * Creates a new a h addr with the primary key. Does not add the a h addr to the database.
    *
    * @param addrId the primary key for the new a h addr
    * @return the new a h addr
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr create(
        long addrId) {
        return getPersistence().create(addrId);
    }

    /**
    * Removes the a h addr with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr remove(
        long addrId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException {
        return getPersistence().remove(addrId);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHAddr ahAddr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahAddr);
    }

    /**
    * Returns the a h addr with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException} if it could not be found.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr findByPrimaryKey(
        long addrId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHAddrException {
        return getPersistence().findByPrimaryKey(addrId);
    }

    /**
    * Returns the a h addr with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr, or <code>null</code> if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHAddr fetchByPrimaryKey(
        long addrId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(addrId);
    }

    /**
    * Returns all the a h addrs.
    *
    * @return the a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the a h addrs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @return the range of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h addrs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h addrs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h addrs.
    *
    * @return the number of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AHAddrPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHAddrPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
                    AHAddrPersistence.class.getName());

            ReferenceRegistry.registerReference(AHAddrUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHAddrPersistence persistence) {
    }
}
