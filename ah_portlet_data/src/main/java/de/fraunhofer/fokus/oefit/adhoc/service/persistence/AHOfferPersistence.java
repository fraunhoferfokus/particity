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

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;

/**
 * The persistence interface for the a h offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOfferPersistenceImpl
 * @see AHOfferUtil
 * @generated
 */
public interface AHOfferPersistence extends BasePersistence<AHOffer> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHOfferUtil} to access the a h offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the a h offers where orgId = &#63;.
    *
    * @param orgId the org ID
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorg(
        long orgId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorg(
        long orgId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorg(
        long orgId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorg_First(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the first a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorg_First(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorg_Last(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the last a h offer in the ordered set where orgId = &#63;.
    *
    * @param orgId the org ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorg_Last(
        long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findByorg_PrevAndNext(
        long offerId, long orgId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Removes all the a h offers where orgId = &#63; from the database.
    *
    * @param orgId the org ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByorg(long orgId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers where orgId = &#63;.
    *
    * @param orgId the org ID
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public int countByorg(long orgId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h offers where title = &#63;.
    *
    * @param title the title
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBytitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBytitle(
        java.lang.String title, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBytitle(
        java.lang.String title, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBytitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the first a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBytitle_First(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBytitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the last a h offer in the ordered set where title = &#63;.
    *
    * @param title the title
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBytitle_Last(
        java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findBytitle_PrevAndNext(
        long offerId, java.lang.String title,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Removes all the a h offers where title = &#63; from the database.
    *
    * @param title the title
    * @throws SystemException if a system exception occurred
    */
    public void removeBytitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers where title = &#63;.
    *
    * @param title the title
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public int countBytitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h offers where status = &#63;.
    *
    * @param status the status
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the first a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the last a h offer in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findBystatus_PrevAndNext(
        long offerId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Removes all the a h offers where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers where status = &#63;.
    *
    * @param status the status
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatusAndDate(
        int status, long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatusAndDate(
        int status, long expires, long publish, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findBystatusAndDate(
        int status, long expires, long publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatusAndDate_First(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatusAndDate_First(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findBystatusAndDate_Last(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchBystatusAndDate_Last(
        int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findBystatusAndDate_PrevAndNext(
        long offerId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Removes all the a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63; from the database.
    *
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @throws SystemException if a system exception occurred
    */
    public void removeBystatusAndDate(int status, long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers where status = &#63; and expires &gt; &#63; and publish &lt; &#63;.
    *
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public int countBystatusAndDate(int status, long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorgAndstatusAndDate(
        long orgId, int status, long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorgAndstatusAndDate(
        long orgId, int status, long expires, long publish, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByorgAndstatusAndDate(
        long orgId, int status, long expires, long publish, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorgAndstatusAndDate_First(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorgAndstatusAndDate_First(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByorgAndstatusAndDate_Last(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByorgAndstatusAndDate_Last(
        long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findByorgAndstatusAndDate_PrevAndNext(
        long offerId, long orgId, int status, long expires, long publish,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Removes all the a h offers where orgId = &#63; and status = &#63; and expires &gt; &#63; and publish &lt; &#63; from the database.
    *
    * @param orgId the org ID
    * @param status the status
    * @param expires the expires
    * @param publish the publish
    * @throws SystemException if a system exception occurred
    */
    public void removeByorgAndstatusAndDate(long orgId, int status,
        long expires, long publish)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public int countByorgAndstatusAndDate(long orgId, int status, long expires,
        long publish)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h offers where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @return the matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByaddress(
        long adressId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByaddress(
        long adressId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findByaddress(
        long adressId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByaddress_First(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the first a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByaddress_First(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByaddress_Last(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the last a h offer in the ordered set where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h offer, or <code>null</code> if a matching a h offer could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByaddress_Last(
        long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer[] findByaddress_PrevAndNext(
        long offerId, long adressId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Removes all the a h offers where adressId = &#63; from the database.
    *
    * @param adressId the adress ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByaddress(long adressId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers where adressId = &#63;.
    *
    * @param adressId the adress ID
    * @return the number of matching a h offers
    * @throws SystemException if a system exception occurred
    */
    public int countByaddress(long adressId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the a h offer in the entity cache if it is enabled.
    *
    * @param ahOffer the a h offer
    */
    public void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer);

    /**
    * Caches the a h offers in the entity cache if it is enabled.
    *
    * @param ahOffers the a h offers
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers);

    /**
    * Creates a new a h offer with the primary key. Does not add the a h offer to the database.
    *
    * @param offerId the primary key for the new a h offer
    * @return the new a h offer
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer create(long offerId);

    /**
    * Removes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer remove(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h offer with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException} if it could not be found.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer findByPrimaryKey(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOfferException;

    /**
    * Returns the a h offer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer, or <code>null</code> if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOffer fetchByPrimaryKey(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h offers.
    *
    * @return the a h offers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h offers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers.
    *
    * @return the number of a h offers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h cat entrieses associated with the a h offer.
    *
    * @param pk the primary key of the a h offer
    * @return the a h cat entrieses associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h cat entrieses associated with the a h offer.
    *
    * @param pk the primary key of the a h offer
    * @return the number of a h cat entrieses associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public int getAHCatEntriesesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the a h cat entries is associated with the a h offer.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @return <code>true</code> if the a h cat entries is associated with the a h offer; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the a h offer has any a h cat entrieses associated with it.
    *
    * @param pk the primary key of the a h offer to check for associations with a h cat entrieses
    * @return <code>true</code> if the a h offer has any a h cat entrieses associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsAHCatEntrieses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntries the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntrieses the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the a h offer and its a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer to clear the associated a h cat entrieses from
    * @throws SystemException if a system exception occurred
    */
    public void clearAHCatEntrieses(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPK the primary key of the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void removeAHCatEntries(long pk, long ahCatEntriesPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h offer and the a h cat entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntries the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void removeAHCatEntries(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public void removeAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h offer and the a h cat entrieses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntrieses the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public void removeAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the a h cat entrieses associated with the a h offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntriesPKs the primary keys of the a h cat entrieses to be associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public void setAHCatEntrieses(long pk, long[] ahCatEntriesPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the a h cat entrieses associated with the a h offer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h offer
    * @param ahCatEntrieses the a h cat entrieses to be associated with the a h offer
    * @throws SystemException if a system exception occurred
    */
    public void setAHCatEntrieses(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException;
}
