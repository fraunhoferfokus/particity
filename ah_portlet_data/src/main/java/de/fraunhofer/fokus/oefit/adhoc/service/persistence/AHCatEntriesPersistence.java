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

import de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries;

/**
 * The persistence interface for the a h cat entries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntriesPersistenceImpl
 * @see AHCatEntriesUtil
 * @generated
 */
public interface AHCatEntriesPersistence extends BasePersistence<AHCatEntries> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHCatEntriesUtil} to access the a h cat entries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the a h cat entrieses where catId = &#63;.
    *
    * @param catId the cat ID
    * @return the matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findBycat(
        long catId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h cat entrieses where catId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param catId the cat ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findBycat(
        long catId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h cat entrieses where catId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param catId the cat ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findBycat(
        long catId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findBycat_First(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the first a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchBycat_First(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findBycat_Last(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the last a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchBycat_Last(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h cat entrieses before and after the current a h cat entries in the ordered set where catId = &#63;.
    *
    * @param itemId the primary key of the current a h cat entries
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries[] findBycat_PrevAndNext(
        long itemId, long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Removes all the a h cat entrieses where catId = &#63; from the database.
    *
    * @param catId the cat ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBycat(long catId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h cat entrieses where catId = &#63;.
    *
    * @param catId the cat ID
    * @return the number of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public int countBycat(long catId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h cat entrieses where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findByparent(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h cat entrieses where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findByparent(
        long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h cat entrieses where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findByparent(
        long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findByparent_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the first a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchByparent_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findByparent_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the last a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchByparent_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h cat entrieses before and after the current a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param itemId the primary key of the current a h cat entries
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries[] findByparent_PrevAndNext(
        long itemId, long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Removes all the a h cat entrieses where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByparent(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h cat entrieses where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public int countByparent(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h cat entrieses where itemId = &#63;.
    *
    * @param itemId the item ID
    * @return the matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findByitem(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h cat entrieses where itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemId the item ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findByitem(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h cat entrieses where itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemId the item ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findByitem(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findByitem_First(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the first a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchByitem_First(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findByitem_Last(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the last a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchByitem_Last(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h cat entrieses where itemId = &#63; from the database.
    *
    * @param itemId the item ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByitem(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h cat entrieses where itemId = &#63;.
    *
    * @param itemId the item ID
    * @return the number of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public int countByitem(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the a h cat entries in the entity cache if it is enabled.
    *
    * @param ahCatEntries the a h cat entries
    */
    public void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries);

    /**
    * Caches the a h cat entrieses in the entity cache if it is enabled.
    *
    * @param ahCatEntrieses the a h cat entrieses
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> ahCatEntrieses);

    /**
    * Creates a new a h cat entries with the primary key. Does not add the a h cat entries to the database.
    *
    * @param itemId the primary key for the new a h cat entries
    * @return the new a h cat entries
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries create(
        long itemId);

    /**
    * Removes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries remove(
        long itemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h cat entries with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException} if it could not be found.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries findByPrimaryKey(
        long itemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHCatEntriesException;

    /**
    * Returns the a h cat entries with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries, or <code>null</code> if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchByPrimaryKey(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h cat entrieses.
    *
    * @return the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h cat entrieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h cat entrieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h cat entrieses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h cat entrieses.
    *
    * @return the number of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h subscriptions associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getAHSubscriptions(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h subscriptions associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getAHSubscriptions(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h subscriptions associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getAHSubscriptions(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h subscriptions associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the number of a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public int getAHSubscriptionsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the a h subscription is associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPK the primary key of the a h subscription
    * @return <code>true</code> if the a h subscription is associated with the a h cat entries; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsAHSubscription(long pk, long ahSubscriptionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the a h cat entries has any a h subscriptions associated with it.
    *
    * @param pk the primary key of the a h cat entries to check for associations with a h subscriptions
    * @return <code>true</code> if the a h cat entries has any a h subscriptions associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsAHSubscriptions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPK the primary key of the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public void addAHSubscription(long pk, long ahSubscriptionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscription the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public void addAHSubscription(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPKs the primary keys of the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public void addAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptions the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public void addAHSubscriptions(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the a h cat entries and its a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries to clear the associated a h subscriptions from
    * @throws SystemException if a system exception occurred
    */
    public void clearAHSubscriptions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPK the primary key of the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public void removeAHSubscription(long pk, long ahSubscriptionPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscription the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public void removeAHSubscription(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPKs the primary keys of the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public void removeAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptions the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public void removeAHSubscriptions(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPKs the primary keys of the a h subscriptions to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void setAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptions the a h subscriptions to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void setAHSubscriptions(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> ahSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h offers associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getAHOffers(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h offers associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getAHOffers(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h offers associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getAHOffers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the number of a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public int getAHOffersSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the a h offer is associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPK the primary key of the a h offer
    * @return <code>true</code> if the a h offer is associated with the a h cat entries; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsAHOffer(long pk, long ahOfferPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the a h cat entries has any a h offers associated with it.
    *
    * @param pk the primary key of the a h cat entries to check for associations with a h offers
    * @return <code>true</code> if the a h cat entries has any a h offers associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsAHOffers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPK the primary key of the a h offer
    * @throws SystemException if a system exception occurred
    */
    public void addAHOffer(long pk, long ahOfferPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffer the a h offer
    * @throws SystemException if a system exception occurred
    */
    public void addAHOffer(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPKs the primary keys of the a h offers
    * @throws SystemException if a system exception occurred
    */
    public void addAHOffers(long pk, long[] ahOfferPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffers the a h offers
    * @throws SystemException if a system exception occurred
    */
    public void addAHOffers(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the a h cat entries and its a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries to clear the associated a h offers from
    * @throws SystemException if a system exception occurred
    */
    public void clearAHOffers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPK the primary key of the a h offer
    * @throws SystemException if a system exception occurred
    */
    public void removeAHOffer(long pk, long ahOfferPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffer the a h offer
    * @throws SystemException if a system exception occurred
    */
    public void removeAHOffer(long pk,
        de.fraunhofer.fokus.oefit.adhoc.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPKs the primary keys of the a h offers
    * @throws SystemException if a system exception occurred
    */
    public void removeAHOffers(long pk, long[] ahOfferPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffers the a h offers
    * @throws SystemException if a system exception occurred
    */
    public void removeAHOffers(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPKs the primary keys of the a h offers to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void setAHOffers(long pk, long[] ahOfferPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffers the a h offers to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public void setAHOffers(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> ahOffers)
        throws com.liferay.portal.kernel.exception.SystemException;
}
