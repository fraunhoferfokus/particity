package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AHSubscriptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscriptionLocalService
 * @generated
 */
public class AHSubscriptionLocalServiceWrapper
    implements AHSubscriptionLocalService,
        ServiceWrapper<AHSubscriptionLocalService> {
    private AHSubscriptionLocalService _ahSubscriptionLocalService;

    public AHSubscriptionLocalServiceWrapper(
        AHSubscriptionLocalService ahSubscriptionLocalService) {
        _ahSubscriptionLocalService = ahSubscriptionLocalService;
    }

    /**
    * Adds the a h subscription to the database. Also notifies the appropriate model listeners.
    *
    * @param ahSubscription the a h subscription
    * @return the a h subscription that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription addAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.addAHSubscription(ahSubscription);
    }

    /**
    * Creates a new a h subscription with the primary key. Does not add the a h subscription to the database.
    *
    * @param subId the primary key for the new a h subscription
    * @return the new a h subscription
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription createAHSubscription(
        long subId) {
        return _ahSubscriptionLocalService.createAHSubscription(subId);
    }

    /**
    * Deletes the a h subscription with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription that was removed
    * @throws PortalException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription deleteAHSubscription(
        long subId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.deleteAHSubscription(subId);
    }

    /**
    * Deletes the a h subscription from the database. Also notifies the appropriate model listeners.
    *
    * @param ahSubscription the a h subscription
    * @return the a h subscription that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription deleteAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.deleteAHSubscription(ahSubscription);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahSubscriptionLocalService.dynamicQuery();
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
        return _ahSubscriptionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahSubscriptionLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahSubscriptionLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _ahSubscriptionLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahSubscriptionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription fetchAHSubscription(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.fetchAHSubscription(subId);
    }

    /**
    * Returns the a h subscription with the primary key.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription
    * @throws PortalException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription getAHSubscription(
        long subId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHSubscription(subId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h subscriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h subscriptions
    * @param end the upper bound of the range of a h subscriptions (not inclusive)
    * @return the range of a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHSubscriptions(start, end);
    }

    /**
    * Returns the number of a h subscriptions.
    *
    * @return the number of a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHSubscriptionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHSubscriptionsCount();
    }

    /**
    * Updates the a h subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahSubscription the a h subscription
    * @return the a h subscription that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription updateAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.updateAHSubscription(ahSubscription);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.addAHCatEntriesAHSubscription(itemId, subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHSubscription(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.addAHCatEntriesAHSubscription(itemId,
            ahSubscription);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.addAHCatEntriesAHSubscriptions(itemId,
            subIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHSubscriptions(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> AHSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.addAHCatEntriesAHSubscriptions(itemId,
            AHSubscriptions);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearAHCatEntriesAHSubscriptions(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.clearAHCatEntriesAHSubscriptions(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.deleteAHCatEntriesAHSubscription(itemId,
            subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHSubscription(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.deleteAHCatEntriesAHSubscription(itemId,
            ahSubscription);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.deleteAHCatEntriesAHSubscriptions(itemId,
            subIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHSubscriptions(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> AHSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.deleteAHCatEntriesAHSubscriptions(itemId,
            AHSubscriptions);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHCatEntriesAHSubscriptions(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHCatEntriesAHSubscriptions(itemId,
            start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHCatEntriesAHSubscriptions(itemId,
            start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHCatEntriesAHSubscriptionsCount(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.getAHCatEntriesAHSubscriptionsCount(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.hasAHCatEntriesAHSubscription(itemId,
            subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHCatEntriesAHSubscriptions(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahSubscriptionLocalService.hasAHCatEntriesAHSubscriptions(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscriptionLocalService.setAHCatEntriesAHSubscriptions(itemId,
            subIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahSubscriptionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahSubscriptionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahSubscriptionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription addSubscription(
        java.lang.String email, long[] categories) {
        return _ahSubscriptionLocalService.addSubscription(email, categories);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription addSubscription(
        java.lang.String email, long[] categories, java.lang.String uuid,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status) {
        return _ahSubscriptionLocalService.addSubscription(email, categories,
            uuid, status);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesBySubscription(
        long subId) {
        return _ahSubscriptionLocalService.getCategoriesBySubscription(subId);
    }

    @Override
    public java.lang.String getCategoriesBySubscriptionAsString(long subId) {
        return _ahSubscriptionLocalService.getCategoriesBySubscriptionAsString(subId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByMail(
        java.lang.String email) {
        return _ahSubscriptionLocalService.getSubscriptionsByMail(email);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByUuid(
        java.lang.String uuid) {
        return _ahSubscriptionLocalService.getSubscriptionsByUuid(uuid);
    }

    @Override
    public java.util.List<java.lang.String> getUserAddresses() {
        return _ahSubscriptionLocalService.getUserAddresses();
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getUserAddressesByCatItems(
        java.lang.Long[] catItems) {
        return _ahSubscriptionLocalService.getUserAddressesByCatItems(catItems);
    }

    @Override
    public void removeSubscription(long id) {
        _ahSubscriptionLocalService.removeSubscription(id);
    }

    @Override
    public void setSubscriptionStatus(long subId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status) {
        _ahSubscriptionLocalService.setSubscriptionStatus(subId, status);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHSubscriptionLocalService getWrappedAHSubscriptionLocalService() {
        return _ahSubscriptionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHSubscriptionLocalService(
        AHSubscriptionLocalService ahSubscriptionLocalService) {
        _ahSubscriptionLocalService = ahSubscriptionLocalService;
    }

    @Override
    public AHSubscriptionLocalService getWrappedService() {
        return _ahSubscriptionLocalService;
    }

    @Override
    public void setWrappedService(
        AHSubscriptionLocalService ahSubscriptionLocalService) {
        _ahSubscriptionLocalService = ahSubscriptionLocalService;
    }
}
