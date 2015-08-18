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

import de.fraunhofer.fokus.oefit.adhoc.model.AHContact;

import java.util.List;

/**
 * The persistence utility for the a h contact service. This utility wraps {@link AHContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHContactPersistence
 * @see AHContactPersistenceImpl
 * @generated
 */
public class AHContactUtil {
    private static AHContactPersistence _persistence;

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
    public static void clearCache(AHContact ahContact) {
        getPersistence().clearCache(ahContact);
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
    public static List<AHContact> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHContact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHContact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHContact update(AHContact ahContact)
        throws SystemException {
        return getPersistence().update(ahContact);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHContact update(AHContact ahContact,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(ahContact, serviceContext);
    }

    /**
    * Returns all the a h contacts where email = &#63;.
    *
    * @param email the email
    * @return the matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findByemail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByemail(email);
    }

    /**
    * Returns a range of all the a h contacts where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @return the range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findByemail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByemail(email, start, end);
    }

    /**
    * Returns an ordered range of all the a h contacts where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findByemail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByemail(email, start, end, orderByComparator);
    }

    /**
    * Returns the first a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact findByemail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence().findByemail_First(email, orderByComparator);
    }

    /**
    * Returns the first a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact, or <code>null</code> if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact fetchByemail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByemail_First(email, orderByComparator);
    }

    /**
    * Returns the last a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact findByemail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence().findByemail_Last(email, orderByComparator);
    }

    /**
    * Returns the last a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact, or <code>null</code> if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact fetchByemail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByemail_Last(email, orderByComparator);
    }

    /**
    * Returns the a h contacts before and after the current a h contact in the ordered set where email = &#63;.
    *
    * @param contactId the primary key of the current a h contact
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact[] findByemail_PrevAndNext(
        long contactId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence()
                   .findByemail_PrevAndNext(contactId, email, orderByComparator);
    }

    /**
    * Removes all the a h contacts where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public static void removeByemail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByemail(email);
    }

    /**
    * Returns the number of a h contacts where email = &#63;.
    *
    * @param email the email
    * @return the number of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByemail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByemail(email);
    }

    /**
    * Returns all the a h contacts where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @return the matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findByname(
        java.lang.String forename, java.lang.String surname)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(forename, surname);
    }

    /**
    * Returns a range of all the a h contacts where forename = &#63; and surname = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param forename the forename
    * @param surname the surname
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @return the range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findByname(
        java.lang.String forename, java.lang.String surname, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(forename, surname, start, end);
    }

    /**
    * Returns an ordered range of all the a h contacts where forename = &#63; and surname = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findByname(
        java.lang.String forename, java.lang.String surname, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByname(forename, surname, start, end, orderByComparator);
    }

    /**
    * Returns the first a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact findByname_First(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence()
                   .findByname_First(forename, surname, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact fetchByname_First(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByname_First(forename, surname, orderByComparator);
    }

    /**
    * Returns the last a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact findByname_Last(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence()
                   .findByname_Last(forename, surname, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact fetchByname_Last(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByname_Last(forename, surname, orderByComparator);
    }

    /**
    * Returns the a h contacts before and after the current a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param contactId the primary key of the current a h contact
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact[] findByname_PrevAndNext(
        long contactId, java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence()
                   .findByname_PrevAndNext(contactId, forename, surname,
            orderByComparator);
    }

    /**
    * Removes all the a h contacts where forename = &#63; and surname = &#63; from the database.
    *
    * @param forename the forename
    * @param surname the surname
    * @throws SystemException if a system exception occurred
    */
    public static void removeByname(java.lang.String forename,
        java.lang.String surname)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByname(forename, surname);
    }

    /**
    * Returns the number of a h contacts where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @return the number of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByname(java.lang.String forename,
        java.lang.String surname)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByname(forename, surname);
    }

    /**
    * Caches the a h contact in the entity cache if it is enabled.
    *
    * @param ahContact the a h contact
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHContact ahContact) {
        getPersistence().cacheResult(ahContact);
    }

    /**
    * Caches the a h contacts in the entity cache if it is enabled.
    *
    * @param ahContacts the a h contacts
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> ahContacts) {
        getPersistence().cacheResult(ahContacts);
    }

    /**
    * Creates a new a h contact with the primary key. Does not add the a h contact to the database.
    *
    * @param contactId the primary key for the new a h contact
    * @return the new a h contact
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact create(
        long contactId) {
        return getPersistence().create(contactId);
    }

    /**
    * Removes the a h contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact remove(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence().remove(contactId);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHContact ahContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahContact);
    }

    /**
    * Returns the a h contact with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException} if it could not be found.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact findByPrimaryKey(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHContactException {
        return getPersistence().findByPrimaryKey(contactId);
    }

    /**
    * Returns the a h contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact, or <code>null</code> if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHContact fetchByPrimaryKey(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(contactId);
    }

    /**
    * Returns all the a h contacts.
    *
    * @return the a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the a h contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @return the range of a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHContact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h contacts.
    *
    * @return the number of a h contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AHContactPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHContactPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
                    AHContactPersistence.class.getName());

            ReferenceRegistry.registerReference(AHContactUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHContactPersistence persistence) {
    }
}
