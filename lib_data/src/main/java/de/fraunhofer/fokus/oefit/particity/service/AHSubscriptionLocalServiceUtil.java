package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AHSubscription. This utility wraps
 * {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHSubscriptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscriptionLocalService
 * @see de.fraunhofer.fokus.oefit.particity.service.base.AHSubscriptionLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHSubscriptionLocalServiceImpl
 * @generated
 */
public class AHSubscriptionLocalServiceUtil {
    private static AHSubscriptionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHSubscriptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the a h subscription to the database. Also notifies the appropriate model listeners.
    *
    * @param ahSubscription the a h subscription
    * @return the a h subscription that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription addAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAHSubscription(ahSubscription);
    }

    /**
    * Creates a new a h subscription with the primary key. Does not add the a h subscription to the database.
    *
    * @param subId the primary key for the new a h subscription
    * @return the new a h subscription
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription createAHSubscription(
        long subId) {
        return getService().createAHSubscription(subId);
    }

    /**
    * Deletes the a h subscription with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription that was removed
    * @throws PortalException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription deleteAHSubscription(
        long subId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHSubscription(subId);
    }

    /**
    * Deletes the a h subscription from the database. Also notifies the appropriate model listeners.
    *
    * @param ahSubscription the a h subscription
    * @return the a h subscription that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription deleteAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHSubscription(ahSubscription);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription fetchAHSubscription(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAHSubscription(subId);
    }

    /**
    * Returns the a h subscription with the primary key.
    *
    * @param subId the primary key of the a h subscription
    * @return the a h subscription
    * @throws PortalException if a a h subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription getAHSubscription(
        long subId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHSubscription(subId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHSubscriptions(start, end);
    }

    /**
    * Returns the number of a h subscriptions.
    *
    * @return the number of a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int getAHSubscriptionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHSubscriptionsCount();
    }

    /**
    * Updates the a h subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahSubscription the a h subscription
    * @return the a h subscription that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription updateAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAHSubscription(ahSubscription);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHSubscription(itemId, subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHSubscription(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHSubscription(itemId, ahSubscription);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHSubscriptions(itemId, subIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHSubscriptions(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> AHSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHSubscriptions(itemId, AHSubscriptions);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHCatEntriesAHSubscriptions(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearAHCatEntriesAHSubscriptions(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHSubscription(itemId, subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHSubscription(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHSubscription(itemId, ahSubscription);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHSubscriptions(long itemId,
        long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHSubscriptions(itemId, subIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHSubscriptions(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> AHSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHSubscriptions(itemId, AHSubscriptions);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesAHSubscriptions(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesAHSubscriptions(itemId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAHCatEntriesAHSubscriptions(itemId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getAHCatEntriesAHSubscriptionsCount(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesAHSubscriptionsCount(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHCatEntriesAHSubscription(itemId, subId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHCatEntriesAHSubscriptions(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHCatEntriesAHSubscriptions(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setAHCatEntriesAHSubscriptions(itemId, subIds);
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription addSubscription(
        java.lang.String email, long[] categories) {
        return getService().addSubscription(email, categories);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHSubscription addSubscription(
        java.lang.String email, long[] categories, java.lang.String uuid,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status) {
        return getService().addSubscription(email, categories, uuid, status);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesBySubscription(
        long subId) {
        return getService().getCategoriesBySubscription(subId);
    }

    public static java.lang.String getCategoriesBySubscriptionAsString(
        long subId) {
        return getService().getCategoriesBySubscriptionAsString(subId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByMail(
        java.lang.String email) {
        return getService().getSubscriptionsByMail(email);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByUuid(
        java.lang.String uuid) {
        return getService().getSubscriptionsByUuid(uuid);
    }

    public static java.util.List<java.lang.String> getUserAddresses() {
        return getService().getUserAddresses();
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getUserAddressesByCatItems(
        java.lang.Long[] catItems) {
        return getService().getUserAddressesByCatItems(catItems);
    }

    public static void removeSubscription(long id) {
        getService().removeSubscription(id);
    }

    public static void setSubscriptionStatus(long subId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status) {
        getService().setSubscriptionStatus(subId, status);
    }

    public static void clearService() {
        _service = null;
    }

    public static AHSubscriptionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AHSubscriptionLocalService.class.getName());

            if (invokableLocalService instanceof AHSubscriptionLocalService) {
                _service = (AHSubscriptionLocalService) invokableLocalService;
            } else {
                _service = new AHSubscriptionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AHSubscriptionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AHSubscriptionLocalService service) {
    }
}
