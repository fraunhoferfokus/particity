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
package de.fraunhofer.fokus.oefit.adhoc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AHCatEntries. This utility wraps
 * {@link de.fraunhofer.fokus.oefit.adhoc.service.impl.AHCatEntriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntriesLocalService
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHCatEntriesLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.adhoc.service.impl.AHCatEntriesLocalServiceImpl
 * @generated
 */
public class AHCatEntriesLocalServiceUtil {
    private static AHCatEntriesLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.oefit.adhoc.service.impl.AHCatEntriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the a h cat entries to the database. Also notifies the appropriate model listeners.
    *
    * @param ahCatEntries the a h cat entries
    * @return the a h cat entries that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries addAHCatEntries(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAHCatEntries(ahCatEntries);
    }

    /**
    * Creates a new a h cat entries with the primary key. Does not add the a h cat entries to the database.
    *
    * @param itemId the primary key for the new a h cat entries
    * @return the new a h cat entries
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries createAHCatEntries(
        long itemId) {
        return getService().createAHCatEntries(itemId);
    }

    /**
    * Deletes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries that was removed
    * @throws PortalException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries deleteAHCatEntries(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHCatEntries(itemId);
    }

    /**
    * Deletes the a h cat entries from the database. Also notifies the appropriate model listeners.
    *
    * @param ahCatEntries the a h cat entries
    * @return the a h cat entries that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries deleteAHCatEntries(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHCatEntries(ahCatEntries);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchAHCatEntries(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAHCatEntries(itemId);
    }

    /**
    * Returns the a h cat entries with the primary key.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries
    * @throws PortalException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries getAHCatEntries(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntries(itemId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

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
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntrieses(start, end);
    }

    /**
    * Returns the number of a h cat entrieses.
    *
    * @return the number of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static int getAHCatEntriesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesesCount();
    }

    /**
    * Updates the a h cat entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahCatEntries the a h cat entries
    * @return the a h cat entries that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries updateAHCatEntries(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAHCatEntries(ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscriptionAHCatEntries(long subId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHSubscriptionAHCatEntries(subId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscriptionAHCatEntries(long subId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHSubscriptionAHCatEntries(subId, ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscriptionAHCatEntrieses(long subId,
        long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHSubscriptionAHCatEntrieses(subId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscriptionAHCatEntrieses(long subId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHSubscriptionAHCatEntrieses(subId, AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHSubscriptionAHCatEntrieses(long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearAHSubscriptionAHCatEntrieses(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHSubscriptionAHCatEntries(long subId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHSubscriptionAHCatEntries(subId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHSubscriptionAHCatEntries(long subId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHSubscriptionAHCatEntries(subId, ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHSubscriptionAHCatEntrieses(long subId,
        long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHSubscriptionAHCatEntrieses(subId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHSubscriptionAHCatEntrieses(long subId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHSubscriptionAHCatEntrieses(subId, AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHSubscriptionAHCatEntrieses(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHSubscriptionAHCatEntrieses(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHSubscriptionAHCatEntrieses(
        long subId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHSubscriptionAHCatEntrieses(subId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHSubscriptionAHCatEntrieses(
        long subId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAHSubscriptionAHCatEntrieses(subId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getAHSubscriptionAHCatEntriesesCount(long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHSubscriptionAHCatEntriesesCount(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHSubscriptionAHCatEntries(long subId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHSubscriptionAHCatEntries(subId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHSubscriptionAHCatEntrieses(long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHSubscriptionAHCatEntrieses(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setAHSubscriptionAHCatEntrieses(long subId,
        long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setAHSubscriptionAHCatEntrieses(subId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOfferAHCatEntries(long offerId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHOfferAHCatEntries(offerId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOfferAHCatEntries(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHOfferAHCatEntries(offerId, ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOfferAHCatEntrieses(long offerId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHOfferAHCatEntrieses(offerId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOfferAHCatEntrieses(long offerId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHOfferAHCatEntrieses(offerId, AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHOfferAHCatEntrieses(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearAHOfferAHCatEntrieses(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHOfferAHCatEntries(long offerId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHOfferAHCatEntries(offerId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHOfferAHCatEntries(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHOfferAHCatEntries(offerId, ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHOfferAHCatEntrieses(long offerId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHOfferAHCatEntrieses(offerId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHOfferAHCatEntrieses(long offerId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHOfferAHCatEntrieses(offerId, AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHOfferAHCatEntrieses(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHOfferAHCatEntrieses(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHOfferAHCatEntrieses(
        long offerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHOfferAHCatEntrieses(offerId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHOfferAHCatEntrieses(
        long offerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAHOfferAHCatEntrieses(offerId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getAHOfferAHCatEntriesesCount(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHOfferAHCatEntriesesCount(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHOfferAHCatEntries(long offerId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHOfferAHCatEntries(offerId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHOfferAHCatEntrieses(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHOfferAHCatEntrieses(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setAHOfferAHCatEntrieses(long offerId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setAHOfferAHCatEntrieses(offerId, itemIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getCategoryEntries(
        long catId) {
        return getService().getCategoryEntries(catId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getCategoryEntriesChildsSorted(
        long catId) {
        return getService().getCategoryEntriesChildsSorted(catId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getChildEntriesById(
        long entryId) {
        return getService().getChildEntriesById(entryId);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries getCategoryEntryById(
        long entryId) {
        return getService().getCategoryEntryById(entryId);
    }

    public static de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries addCategoryEntry(
        java.lang.String catId, java.lang.String name,
        java.lang.String description, java.lang.String parentId) {
        return getService().addCategoryEntry(catId, name, description, parentId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getEntriesForCatId(
        long catId) {
        return getService().getEntriesForCatId(catId);
    }

    public static java.util.Map<java.lang.Long, java.lang.String> getEntryMapForCatId(
        long catId) {
        return getService().getEntryMapForCatId(catId);
    }

    public static void clearService() {
        _service = null;
    }

    public static AHCatEntriesLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AHCatEntriesLocalService.class.getName());

            if (invokableLocalService instanceof AHCatEntriesLocalService) {
                _service = (AHCatEntriesLocalService) invokableLocalService;
            } else {
                _service = new AHCatEntriesLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AHCatEntriesLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AHCatEntriesLocalService service) {
    }
}
