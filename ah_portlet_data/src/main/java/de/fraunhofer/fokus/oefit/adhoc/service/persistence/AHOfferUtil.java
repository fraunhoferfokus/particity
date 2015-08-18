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

import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;

import java.util.List;

/**
 * The persistence utility for the a h offer service. This utility wraps {@link AHOfferPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOfferPersistence
 * @see AHOfferPersistenceImpl
 * @generated
 */
public class AHOfferUtil {
    private static AHOfferPersistence _persistence;

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
    public static void clearCache(AHOffer ahOffer) {
        getPersistence().clearCache(ahOffer);
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
    public static List<AHOffer> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHOffer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHOffer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHOffer update(AHOffer ahOffer) throws SystemException {
        return getPersistence().update(ahOffer);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHOffer update(AHOffer ahOffer, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(ahOffer, serviceContext);
    }

    /**
    * Returns all the a h offers where orgId = &#63;.
    *
    * @param orgId the org ID
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorg(
        long orgId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByorg(orgId);
    }

    /**
    * Returns a range of all the a h offers where orgId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param orgId the org ID
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorg(
        long orgId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByorg(orgId, start, end);
    }

    /**
    * Returns an ordered range of all the a h offers where orgId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param orgId the org ID
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorg(
        long orgId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByorg(orgId, start, end, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorg_First(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findByorg_First(orgId, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorg_First(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByorg_First(orgId, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorg_Last(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findByorg_Last(orgId, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorg_Last(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByorg_Last(orgId, orderByComparator);
    }

    /**
    * Returns the a h offers before and after the current a h offer in the ordered set where orgId = &#63;.
    *
    * @param offerId the primary key of the current a h offer
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findByorg_PrevAndNext(
        long offerId, long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findByorg_PrevAndNext(offerId, orgId, orderByComparator);
    }

    /**
    * Removes all the a h offers where orgId = &#63; from the database.
    *
    * @param orgId the org ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByorg(long orgId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByorg(orgId);
    }

    /**
    * Returns the number of a h offers where orgId = &#63;.
    *
    * @param orgId the org ID
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static int countByorg(long orgId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByorg(orgId);
    }

    /**
    * Returns all the a h offers where title = &#63;.
    *
    * @param title the title
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBytitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytitle(title);
    }

    /**
    * Returns a range of all the a h offers where title = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param title the title
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBytitle(
        java.lang.String title, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytitle(title, start, end);
    }

    /**
    * Returns an ordered range of all the a h offers where title = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param title the title
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBytitle(
        java.lang.String title, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytitle(title, start, end, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBytitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findBytitle_First(title, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBytitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytitle_First(title, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBytitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findBytitle_Last(title, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBytitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytitle_Last(title, orderByComparator);
    }

    /**
    * Returns the a h offers before and after the current a h offer in the ordered set where title = &#63;.
    *
    * @param offerId the primary key of the current a h offer
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findBytitle_PrevAndNext(
        long offerId, java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findBytitle_PrevAndNext(offerId, title, orderByComparator);
    }

    /**
    * Removes all the a h offers where title = &#63; from the database.
    *
    * @param title the title
    * @throws SystemException if a system exception occurred
    */
    public static void removeBytitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBytitle(title);
    }

    /**
    * Returns the number of a h offers where title = &#63;.
    *
    * @param title the title
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static int countBytitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytitle(title);
    }

    /**
    * Returns all the a h offers where status = &#63;.
    *
    * @param status the status
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status);
    }

    /**
    * Returns a range of all the a h offers where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status, start, end);
    }

    /**
    * Returns an ordered range of all the a h offers where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBystatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findBystatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_Last(status, orderByComparator);
    }

    /**
    * Returns the a h offers before and after the current a h offer in the ordered set where status = &#63;.
    *
    * @param offerId the primary key of the current a h offer
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findBystatus_PrevAndNext(
        long offerId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findBystatus_PrevAndNext(offerId, status, orderByComparator);
    }

    /**
    * Removes all the a h offers where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBystatus(status);
    }

    /**
    * Returns the number of a h offers where status = &#63;.
    *
    * @param status the status
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBystatus(status);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatusAndDate(
        int status, long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatusAndDate(status, expires, publish);
    }

    /**
    * Returns a range of all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatusAndDate(
        int status, long expires, long publish, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBystatusAndDate(status, expires, publish, start, end);
    }

    /**
    * Returns an ordered range of all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatusAndDate(
        int status, long expires, long publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBystatusAndDate(status, expires, publish, start, end,
            orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatusAndDate_First(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findBystatusAndDate_First(status, expires, publish,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatusAndDate_First(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBystatusAndDate_First(status, expires, publish,
            orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatusAndDate_Last(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findBystatusAndDate_Last(status, expires, publish,
            orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatusAndDate_Last(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBystatusAndDate_Last(status, expires, publish,
            orderByComparator);
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
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findBystatusAndDate_PrevAndNext(
        long offerId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findBystatusAndDate_PrevAndNext(offerId, status, expires,
            publish, orderByComparator);
    }

    /**
    * Removes all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63; from the database.
    *
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @throws SystemException if a system exception occurred
    */
    public static void removeBystatusAndDate(int status, long expires,
        long publish)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBystatusAndDate(status, expires, publish);
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
    public static int countBystatusAndDate(int status, long expires,
        long publish)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBystatusAndDate(status, expires, publish);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorgAndstatusAndDate(
        long orgId, int status, long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByorgAndstatusAndDate(orgId, status, expires, publish);
    }

    /**
    * Returns a range of all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorgAndstatusAndDate(
        long orgId, int status, long expires, long publish, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByorgAndstatusAndDate(orgId, status, expires, publish,
            start, end);
    }

    /**
    * Returns an ordered range of all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorgAndstatusAndDate(
        long orgId, int status, long expires, long publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByorgAndstatusAndDate(orgId, status, expires, publish,
            start, end, orderByComparator);
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
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorgAndstatusAndDate_First(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findByorgAndstatusAndDate_First(orgId, status, expires,
            publish, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorgAndstatusAndDate_First(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByorgAndstatusAndDate_First(orgId, status, expires,
            publish, orderByComparator);
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
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorgAndstatusAndDate_Last(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findByorgAndstatusAndDate_Last(orgId, status, expires,
            publish, orderByComparator);
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
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorgAndstatusAndDate_Last(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByorgAndstatusAndDate_Last(orgId, status, expires,
            publish, orderByComparator);
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
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findByorgAndstatusAndDate_PrevAndNext(
        long offerId, long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findByorgAndstatusAndDate_PrevAndNext(offerId, orgId,
            status, expires, publish, orderByComparator);
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
    public static void removeByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByorgAndstatusAndDate(orgId, status, expires, publish);
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
    public static int countByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByorgAndstatusAndDate(orgId, status, expires, publish);
    }

    /**
    * Returns all the a h offers where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByaddress(
        long adressId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByaddress(adressId);
    }

    /**
    * Returns a range of all the a h offers where adressId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param adressId the adress ID
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByaddress(
        long adressId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByaddress(adressId, start, end);
    }

    /**
    * Returns an ordered range of all the a h offers where adressId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param adressId the adress ID
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByaddress(
        long adressId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByaddress(adressId, start, end, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByaddress_First(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findByaddress_First(adressId, orderByComparator);
    }

    /**
    * Returns the first a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByaddress_First(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByaddress_First(adressId, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByaddress_Last(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findByaddress_Last(adressId, orderByComparator);
    }

    /**
    * Returns the last a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByaddress_Last(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByaddress_Last(adressId, orderByComparator);
    }

    /**
    * Returns the a h offers before and after the current a h offer in the ordered set where adressId = &#63;.
    *
    * @param offerId the primary key of the current a h offer
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findByaddress_PrevAndNext(
        long offerId, long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence()
                   .findByaddress_PrevAndNext(offerId, adressId,
            orderByComparator);
    }

    /**
    * Removes all the a h offers where adressId = &#63; from the database.
    *
    * @param adressId the adress ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByaddress(long adressId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByaddress(adressId);
    }

    /**
    * Returns the number of a h offers where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public static int countByaddress(long adressId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByaddress(adressId);
    }

    /**
    * Caches the a h offer in the entity cache if it is enabled.
    *
    * @param ahOffer the a h offer
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer) {
        getPersistence().cacheResult(ahOffer);
    }

    /**
    * Caches the a h offers in the entity cache if it is enabled.
    *
    * @param ahOffers the a h offers
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers) {
        getPersistence().cacheResult(ahOffers);
    }

    /**
    * Creates a new a h offer with the primary key. Does not add the a h offer to the database.
    *
    * @param offerId the primary key for the new a h offer
    * @return the new a h offer
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer create(
        long offerId) {
        return getPersistence().create(offerId);
    }

    /**
    * Removes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer remove(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().remove(offerId);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahOffer);
    }

    /**
    * Returns the a h offer with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException} if it could not be found.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByPrimaryKey(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException {
        return getPersistence().findByPrimaryKey(offerId);
    }

    /**
    * Returns the a h offer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer, or <code>null</code> if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByPrimaryKey(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(offerId);
    }

    /**
    * Returns all the a h offers.
    *
    * @return the a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the a h offers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h offers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h offers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h offers.
    *
    * @return the number of a h offers
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the a h cat entrieses associated with the a h offer.
    *
    * @param pk the primary key of the a h offer
    * @return the a h cat entrieses associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHCatEntrieses(pk);
    }

    /**
    * Returns a range of all the a h cat entrieses associated with the a h offer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h offer
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of a h cat entrieses associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHCatEntrieses(pk, start, end);
    }

    /**
    * Returns an ordered range of all the a h cat entrieses associated with the a h offer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h offer
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h cat entrieses associated with the a h offer
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
    * Returns the number of a h cat entrieses associated with the a h offer.
    *
    * @param pk the primary key of the a h offer
    * @return the number of a h cat entrieses associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static int getAHCatEntriesesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHCatEntriesesSize(pk);
    }

    /**
    * Returns <code>true</code> if the a h cat entries is associated with the a h offer.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @return <code>true</code> if the a h cat entries is associated with the a h offer; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHCatEntries(pk, ahCatEntriesPK);
    }

    /**
    * Returns <code>true</code> if the a h offer has any a h cat entrieses associated with it.
    *
    * @param pk the primary key of the a h offer to check for associations with a h cat entrieses
    * @return <code>true</code> if the a h offer has any a h cat entrieses associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHCatEntrieses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHCatEntrieses(pk);
    }

    /**
    * Adds an association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntries(pk, ahCatEntriesPK);
    }

    /**
    * Adds an association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntries the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntries(pk, ahCatEntries);
    }

    /**
    * Adds an association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntrieses(pk, ahCatEntriesPKs);
    }

    /**
    * Adds an association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntrieses the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHCatEntrieses(pk, ahCatEntrieses);
    }

    /**
    * Clears all associations between the a h offer and its a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer to clear the associated a h cat entrieses from
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHCatEntrieses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearAHCatEntrieses(pk);
    }

    /**
    * Removes the association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntries(pk, ahCatEntriesPK);
    }

    /**
    * Removes the association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntries the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntries(pk, ahCatEntries);
    }

    /**
    * Removes the association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntrieses(pk, ahCatEntriesPKs);
    }

    /**
    * Removes the association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntrieses the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHCatEntrieses(pk, ahCatEntrieses);
    }

    /**
    * Sets the a h cat entrieses associated with the a h offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses to be associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static void setAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHCatEntrieses(pk, ahCatEntriesPKs);
    }

    /**
    * Sets the a h cat entrieses associated with the a h offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntrieses the a h cat entrieses to be associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static void setAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHCatEntrieses(pk, ahCatEntrieses);
    }

    public static AHOfferPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHOfferPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
                    AHOfferPersistence.class.getName());

            ReferenceRegistry.registerReference(AHOfferUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHOfferPersistence persistence) {
    }
}
