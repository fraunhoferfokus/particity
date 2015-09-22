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

import de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription;

import java.util.List;

/**
 * The persistence utility for the a h subscription service. This utility wraps {@link AHSubscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscriptionPersistence
 * @see AHSubscriptionPersistenceImpl
 * @generated
 */
public class AHSubscriptionUtil {
    private static AHSubscriptionPersistence _persistence;

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
    public static void clearCache(AHSubscription ahSubscription) {
        getPersistence().clearCache(ahSubscription);
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
    public static List<AHSubscription> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHSubscription> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHSubscription> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHSubscription update(AHSubscription ahSubscription)
        throws SystemException {
        return getPersistence().update(ahSubscription);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHSubscription update(AHSubscription ahSubscription,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(ahSubscription, serviceContext);
    }

    /**
    * Returns all the a h subscriptions where email = &#63;.
    *
    * @param email the email
    * @return the matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findByemail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByemail(email);
    }

    /**
    * Returns a range of all the a h subscriptions where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @return the range of matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findByemail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByemail(email, start, end);
    }

    /**
    * Returns an ordered range of all the a h subscriptions where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findByemail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByemail(email, start, end, orderByComparator);
    }

    /**
    * Returns the first a h subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription findByemail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence().findByemail_First(email, orderByComparator);
    }

    /**
    * Returns the first a h subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription fetchByemail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByemail_First(email, orderByComparator);
    }

    /**
    * Returns the last a h subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription findByemail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence().findByemail_Last(email, orderByComparator);
    }

    /**
    * Returns the last a h subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription fetchByemail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByemail_Last(email, orderByComparator);
    }

    /**
    * Returns the a h subscriptions before and after the current a h subscription in the ordered set where email = &#63;.
    *
    * @param subId the primary key of the current a h subscription
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription[] findByemail_PrevAndNext(
        long subId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence()
                   .findByemail_PrevAndNext(subId, email, orderByComparator);
    }

    /**
    * Removes all the a h subscriptions where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public static void removeByemail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByemail(email);
    }

    /**
    * Returns the number of a h subscriptions where email = &#63;.
    *
    * @param email the email
    * @return the number of matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int countByemail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByemail(email);
    }

    /**
    * Returns all the a h subscriptions where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findByuuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuuid(uuid);
    }

    /**
    * Returns a range of all the a h subscriptions where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @return the range of matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findByuuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the a h subscriptions where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findByuuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first a h subscription in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription findByuuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence().findByuuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first a h subscription in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription fetchByuuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByuuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last a h subscription in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription findByuuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence().findByuuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last a h subscription in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h subscription, or <code>null</code> if a matching a h subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription fetchByuuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByuuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the a h subscriptions before and after the current a h subscription in the ordered set where uuid = &#63;.
    *
    * @param subId the primary key of the current a h subscription
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription[] findByuuid_PrevAndNext(
        long subId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence()
                   .findByuuid_PrevAndNext(subId, uuid, orderByComparator);
    }

    /**
    * Removes all the a h subscriptions where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByuuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByuuid(uuid);
    }

    /**
    * Returns the number of a h subscriptions where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int countByuuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByuuid(uuid);
    }

    /**
    * Caches the a h subscription in the entity cache if it is enabled.
    *
    * @param ahSubscription the a h subscription
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription) {
        getPersistence().cacheResult(ahSubscription);
    }

    /**
    * Caches the a h subscriptions in the entity cache if it is enabled.
    *
    * @param ahSubscriptions the a h subscriptions
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions) {
        getPersistence().cacheResult(ahSubscriptions);
    }

    /**
    * Creates a new a h subscription with the primary key. Does not add the a h subscription to the database.
    *
    * @param subId the primary key for the new a h subscription
    * @return the new a h subscription
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription create(
        long subId) {
        return getPersistence().create(subId);
    }

    /**
    * Removes the a h subscription with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription remove(
        long subId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence().remove(subId);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahSubscription);
    }

    /**
    * Returns the a h subscription with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException} if it could not be found.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription findByPrimaryKey(
        long subId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHSubscriptionException {
        return getPersistence().findByPrimaryKey(subId);
    }

    /**
    * Returns the a h subscription with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription, or <code>null</code> if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription fetchByPrimaryKey(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(subId);
    }

    /**
    * Returns all the a h subscriptions.
    *
    * @return the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the a h subscriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @return the range of a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h subscriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h subscriptions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h subscriptions.
    *
    * @return the number of a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the a h cat entrieses associated with the a h subscription.
    *
    * @param pk the primary key of the a h subscription
    * @return the a h cat entrieses associated with the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHCatEntrieses(pk);
    }

    /**
    * Returns a range of all the a h cat entrieses associated with the a h subscription.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h subscription
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @return the range of a h cat entrieses associated with the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHCatEntrieses(pk, start, end);
    }

    /**
    * Returns an ordered range of all the a h cat entrieses associated with the a h subscription.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h subscription
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h cat entrieses associated with the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getAHCatEntrieses(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of a h cat entrieses associated with the a h subscription.
    *
    * @param pk the primary key of the a h subscription
    * @return the number of a h cat entrieses associated with the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static int getAHCatEntriesesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHCatEntriesesSize(pk);
    }

    /**
    * Returns <code>true</code> if the a h cat entries is associated with the a h subscription.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @return <code>true</code> if the a h cat entries is associated with the a h subscription; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHCatEntries(pk, ahCatEntriesPK);
    }

    /**
    * Returns <code>true</code> if the a h subscription has any a h cat entrieses associated with it.
    *
    * @param pk the primary key of the a h subscription to check for associations with a h cat entrieses
    * @return <code>true</code> if the a h subscription has any a h cat entrieses associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHCatEntrieses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHCatEntrieses(pk);
    }

    /**
    * Adds an association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntries(pk, ahCatEntriesPK);
    }

    /**
    * Adds an association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntries the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntries(pk, ahCatEntries);
    }

    /**
    * Adds an association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntrieses(pk, ahCatEntriesPKs);
    }

    /**
    * Adds an association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntrieses the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntrieses(pk, ahCatEntrieses);
    }

    /**
    * Clears all associations between the a h subscription and its a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription to clear the associated a h cat entrieses from
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHCatEntrieses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearAHCatEntrieses(pk);
    }

    /**
    * Removes the association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntries(pk, ahCatEntriesPK);
    }

    /**
    * Removes the association between the a h subscription and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntries the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntries(pk, ahCatEntries);
    }

    /**
    * Removes the association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntrieses(pk, ahCatEntriesPKs);
    }

    /**
    * Removes the association between the a h subscription and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntrieses the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntrieses(pk, ahCatEntrieses);
    }

    /**
    * Sets the a h cat entrieses associated with the a h subscription, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses to be associated with the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static void setAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHCatEntrieses(pk, ahCatEntriesPKs);
    }

    /**
    * Sets the a h cat entrieses associated with the a h subscription, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h subscription
    * @param ahCatEntrieses the a h cat entrieses to be associated with the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static void setAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHCatEntrieses(pk, ahCatEntrieses);
    }

    public static AHSubscriptionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHSubscriptionPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
                    AHSubscriptionPersistence.class.getName());

            ReferenceRegistry.registerReference(AHSubscriptionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHSubscriptionPersistence persistence) {
    }
}
