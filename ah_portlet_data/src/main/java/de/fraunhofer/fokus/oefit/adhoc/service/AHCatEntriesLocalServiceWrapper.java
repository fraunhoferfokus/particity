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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AHCatEntriesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntriesLocalService
 * @generated
 */
public class AHCatEntriesLocalServiceWrapper implements AHCatEntriesLocalService,
    ServiceWrapper<AHCatEntriesLocalService> {
    private AHCatEntriesLocalService _ahCatEntriesLocalService;

    public AHCatEntriesLocalServiceWrapper(
        AHCatEntriesLocalService ahCatEntriesLocalService) {
        _ahCatEntriesLocalService = ahCatEntriesLocalService;
    }

    /**
    * Adds the a h cat entries to the database. Also notifies the appropriate model listeners.
    *
    * @param ahCatEntries the a h cat entries
    * @return the a h cat entries that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries addAHCatEntries(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.addAHCatEntries(ahCatEntries);
    }

    /**
    * Creates a new a h cat entries with the primary key. Does not add the a h cat entries to the database.
    *
    * @param itemId the primary key for the new a h cat entries
    * @return the new a h cat entries
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries createAHCatEntries(
        long itemId) {
        return _ahCatEntriesLocalService.createAHCatEntries(itemId);
    }

    /**
    * Deletes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries that was removed
    * @throws PortalException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries deleteAHCatEntries(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.deleteAHCatEntries(itemId);
    }

    /**
    * Deletes the a h cat entries from the database. Also notifies the appropriate model listeners.
    *
    * @param ahCatEntries the a h cat entries
    * @return the a h cat entries that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries deleteAHCatEntries(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.deleteAHCatEntries(ahCatEntries);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahCatEntriesLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries fetchAHCatEntries(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.fetchAHCatEntries(itemId);
    }

    /**
    * Returns the a h cat entries with the primary key.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries
    * @throws PortalException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries getAHCatEntries(
        long itemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHCatEntries(itemId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHCatEntrieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHCatEntrieses(start, end);
    }

    /**
    * Returns the number of a h cat entrieses.
    *
    * @return the number of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHCatEntriesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHCatEntriesesCount();
    }

    /**
    * Updates the a h cat entries in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahCatEntries the a h cat entries
    * @return the a h cat entries that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries updateAHCatEntries(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.updateAHCatEntries(ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHSubscriptionAHCatEntries(long subId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHSubscriptionAHCatEntries(subId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHSubscriptionAHCatEntries(long subId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHSubscriptionAHCatEntries(subId,
            ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHSubscriptionAHCatEntrieses(long subId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHSubscriptionAHCatEntrieses(subId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHSubscriptionAHCatEntrieses(long subId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHSubscriptionAHCatEntrieses(subId,
            AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearAHSubscriptionAHCatEntrieses(long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.clearAHSubscriptionAHCatEntrieses(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHSubscriptionAHCatEntries(long subId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHSubscriptionAHCatEntries(subId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHSubscriptionAHCatEntries(long subId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHSubscriptionAHCatEntries(subId,
            ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHSubscriptionAHCatEntrieses(long subId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHSubscriptionAHCatEntrieses(subId,
            itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHSubscriptionAHCatEntrieses(long subId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHSubscriptionAHCatEntrieses(subId,
            AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHSubscriptionAHCatEntrieses(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHSubscriptionAHCatEntrieses(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHSubscriptionAHCatEntrieses(
        long subId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHSubscriptionAHCatEntrieses(subId,
            start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHSubscriptionAHCatEntrieses(
        long subId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHSubscriptionAHCatEntrieses(subId,
            start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHSubscriptionAHCatEntriesesCount(long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHSubscriptionAHCatEntriesesCount(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHSubscriptionAHCatEntries(long subId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.hasAHSubscriptionAHCatEntries(subId,
            itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHSubscriptionAHCatEntrieses(long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.hasAHSubscriptionAHCatEntrieses(subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setAHSubscriptionAHCatEntrieses(long subId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.setAHSubscriptionAHCatEntrieses(subId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHOfferAHCatEntries(long offerId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHOfferAHCatEntries(offerId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHOfferAHCatEntries(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHOfferAHCatEntries(offerId, ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHOfferAHCatEntrieses(long offerId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHOfferAHCatEntrieses(offerId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHOfferAHCatEntrieses(long offerId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.addAHOfferAHCatEntrieses(offerId,
            AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearAHOfferAHCatEntrieses(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.clearAHOfferAHCatEntrieses(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHOfferAHCatEntries(long offerId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHOfferAHCatEntries(offerId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHOfferAHCatEntries(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHOfferAHCatEntries(offerId,
            ahCatEntries);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHOfferAHCatEntrieses(long offerId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHOfferAHCatEntrieses(offerId, itemIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHOfferAHCatEntrieses(long offerId,
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> AHCatEntrieses)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.deleteAHOfferAHCatEntrieses(offerId,
            AHCatEntrieses);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHOfferAHCatEntrieses(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHOfferAHCatEntrieses(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHOfferAHCatEntrieses(
        long offerId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHOfferAHCatEntrieses(offerId,
            start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getAHOfferAHCatEntrieses(
        long offerId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHOfferAHCatEntrieses(offerId,
            start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHOfferAHCatEntriesesCount(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.getAHOfferAHCatEntriesesCount(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHOfferAHCatEntries(long offerId, long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.hasAHOfferAHCatEntries(offerId, itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHOfferAHCatEntrieses(long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCatEntriesLocalService.hasAHOfferAHCatEntrieses(offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setAHOfferAHCatEntrieses(long offerId, long[] itemIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntriesLocalService.setAHOfferAHCatEntrieses(offerId, itemIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahCatEntriesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahCatEntriesLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahCatEntriesLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getCategoryEntries(
        long catId) {
        return _ahCatEntriesLocalService.getCategoryEntries(catId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getCategoryEntriesChildsSorted(
        long catId) {
        return _ahCatEntriesLocalService.getCategoryEntriesChildsSorted(catId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getChildEntriesById(
        long entryId) {
        return _ahCatEntriesLocalService.getChildEntriesById(entryId);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries getCategoryEntryById(
        long entryId) {
        return _ahCatEntriesLocalService.getCategoryEntryById(entryId);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries addCategoryEntry(
        java.lang.String catId, java.lang.String name,
        java.lang.String description, java.lang.String parentId) {
        return _ahCatEntriesLocalService.addCategoryEntry(catId, name,
            description, parentId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getEntriesForCatId(
        long catId) {
        return _ahCatEntriesLocalService.getEntriesForCatId(catId);
    }

    @Override
    public java.util.Map<java.lang.Long, java.lang.String> getEntryMapForCatId(
        long catId) {
        return _ahCatEntriesLocalService.getEntryMapForCatId(catId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHCatEntriesLocalService getWrappedAHCatEntriesLocalService() {
        return _ahCatEntriesLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHCatEntriesLocalService(
        AHCatEntriesLocalService ahCatEntriesLocalService) {
        _ahCatEntriesLocalService = ahCatEntriesLocalService;
    }

    @Override
    public AHCatEntriesLocalService getWrappedService() {
        return _ahCatEntriesLocalService;
    }

    @Override
    public void setWrappedService(
        AHCatEntriesLocalService ahCatEntriesLocalService) {
        _ahCatEntriesLocalService = ahCatEntriesLocalService;
    }
}
