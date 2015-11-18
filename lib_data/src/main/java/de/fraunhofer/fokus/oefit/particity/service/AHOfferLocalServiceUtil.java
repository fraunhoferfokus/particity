package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AHOffer. This utility wraps
 * {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHOfferLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHOfferLocalService
 * @see de.fraunhofer.fokus.oefit.particity.service.base.AHOfferLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHOfferLocalServiceImpl
 * @generated
 */
public class AHOfferLocalServiceUtil {
    private static AHOfferLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHOfferLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the a h offer to the database. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer addAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAHOffer(ahOffer);
    }

    /**
    * Creates a new a h offer with the primary key. Does not add the a h offer to the database.
    *
    * @param offerId the primary key for the new a h offer
    * @return the new a h offer
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer createAHOffer(
        long offerId) {
        return getService().createAHOffer(offerId);
    }

    /**
    * Deletes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer that was removed
    * @throws PortalException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer deleteAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHOffer(offerId);
    }

    /**
    * Deletes the a h offer from the database. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer deleteAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHOffer(ahOffer);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer fetchAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAHOffer(offerId);
    }

    /**
    * Returns the a h offer with the primary key.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer
    * @throws PortalException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer getAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHOffer(offerId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h offers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h offers
    * @param end the upper bound of the range of a h offers (not inclusive)
    * @return the range of a h offers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHOffers(start, end);
    }

    /**
    * Returns the number of a h offers.
    *
    * @return the number of a h offers
    * @throws SystemException if a system exception occurred
    */
    public static int getAHOffersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHOffersCount();
    }

    /**
    * Updates the a h offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer updateAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAHOffer(ahOffer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHOffer(itemId, offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHOffer(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHOffer(itemId, ahOffer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHOffers(itemId, offerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addAHCatEntriesAHOffers(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> AHOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addAHCatEntriesAHOffers(itemId, AHOffers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHCatEntriesAHOffers(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearAHCatEntriesAHOffers(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHOffer(itemId, offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHOffer(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHOffer(itemId, ahOffer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHOffers(itemId, offerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteAHCatEntriesAHOffers(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> AHOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAHCatEntriesAHOffers(itemId, AHOffers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesAHOffers(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesAHOffers(itemId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getAHCatEntriesAHOffers(itemId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getAHCatEntriesAHOffersCount(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCatEntriesAHOffersCount(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHCatEntriesAHOffer(itemId, offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasAHCatEntriesAHOffers(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasAHCatEntriesAHOffers(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setAHCatEntriesAHOffers(itemId, offerIds);
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer addOffer(
        int type, java.lang.String title, java.lang.String descr,
        java.lang.String workTime, java.lang.Integer workType,
        long publishDate, long expireDate, long addressId, long contactId,
        long contact2Id, boolean agencyContact, long orgId, long[] categories) {
        return getService()
                   .addOffer(type, title, descr, workTime, workType,
            publishDate, expireDate, addressId, contactId, contact2Id,
            agencyContact, orgId, categories);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer addOffer(
        java.lang.Long offerId, int type, java.lang.String title,
        java.lang.String descr, java.lang.String workTime,
        java.lang.Integer workType, long publishDate, long expireDate,
        long addressId, long contactId, long contact2Id, boolean agencyContact,
        long orgId, long[] categories) {
        return getService()
                   .addOffer(offerId, type, title, descr, workTime, workType,
            publishDate, expireDate, addressId, contactId, contact2Id,
            agencyContact, orgId, categories);
    }

    public static void addSocialStatus(java.lang.Long offerId, int smBitmask) {
        getService().addSocialStatus(offerId, smBitmask);
    }

    public static int countNewOffer() {
        return getService().countNewOffer();
    }

    public static int countOfferByAddress(long addrId) {
        return getService().countOfferByAddress(addrId);
    }

    public static java.lang.Integer countOfferByCategoryId(java.lang.Long[] ids) {
        return getService().countOfferByCategoryId(ids);
    }

    public static java.lang.Integer countOfferByCategoryItems(
        java.lang.String[] categoryItems) {
        return getService().countOfferByCategoryItems(categoryItems);
    }

    public static java.lang.Integer countOfferByOfferTypes(int[] types) {
        return getService().countOfferByOfferTypes(types);
    }

    public static java.lang.Integer countOfferByTypesAndCItemsAndOrg(
        java.lang.String categoryItems, java.lang.String types, long orgId,
        java.lang.Float lat, java.lang.Float lon, java.lang.Integer dist) {
        return getService()
                   .countOfferByTypesAndCItemsAndOrg(categoryItems, types,
            orgId, lat, lon, dist);
    }

    public static int countOffersForOrganization(long orgId) {
        return getService().countOffersForOrganization(orgId);
    }

    public static java.lang.Integer countPublishedOffers(long orgId) {
        return getService().countPublishedOffers(orgId);
    }

    public static void deleteOffersByOrg(long orgId) {
        getService().deleteOffersByOrg(orgId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> findExpiredOffersForOrg(
        long orgId, long startTime, long endTime) {
        return getService().findExpiredOffersForOrg(orgId, startTime, endTime);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesByOffer(
        long offerId, java.lang.Integer type) {
        return getService().getCategoriesByOffer(offerId, type);
    }

    public static java.lang.Long[] getCategoriesByOfferAsLong(long offerId,
        java.lang.Integer type) {
        return getService().getCategoriesByOfferAsLong(offerId, type);
    }

    public static java.lang.String getCategoriesByOfferAsString(long offerId,
        java.lang.Integer type) {
        return getService().getCategoriesByOfferAsString(offerId, type);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHOffer getLastOfferForOrganization(
        long orgId) {
        return getService().getLastOfferForOrganization(orgId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getNewlyPublishedOffers(
        long publishStartTime) {
        return getService().getNewlyPublishedOffers(publishStartTime);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryId(
        java.lang.Long[] ids, int start, int end) {
        return getService().getOfferByCategoryId(ids, start, end);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryItems(
        java.lang.String[] categoryItems, int start, int end) {
        return getService().getOfferByCategoryItems(categoryItems, start, end);
    }

    public static java.lang.Integer getOfferByOfferTypes(int[] types) {
        return getService().getOfferByOfferTypes(types);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        int[] types, int start, int end) {
        return getService().getOfferByOfferTypes(types, start, end);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByTypesAndCItemsAndOrg(
        java.lang.String categoryItems, java.lang.String types, long orgId,
        int start, int end, java.lang.Float lat, java.lang.Float lon,
        java.lang.Integer dist) {
        return getService()
                   .getOfferByTypesAndCItemsAndOrg(categoryItems, types, orgId,
            start, end, lat, lon, dist);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffers(
        int start, int end, java.lang.String column, java.lang.String order) {
        return getService().getOffers(start, end, column, order);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersForOrganization(
        long orgId) {
        return getService().getOffersForOrganization(orgId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersForOrganization(
        long orgId, int start, int end, java.lang.String column,
        java.lang.String order) {
        return getService()
                   .getOffersForOrganization(orgId, start, end, column, order);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getPublishedOffers(
        int start, int end, long orgId) {
        return getService().getPublishedOffers(start, end, orgId);
    }

    public static void setOfferStatus(long offerId, java.lang.Integer status) {
        getService().setOfferStatus(offerId, status);
    }

    public static void setSndContact(java.lang.Long offerId, long contactId,
        java.lang.Integer newStatus) {
        getService().setSndContact(offerId, contactId, newStatus);
    }

    public static void clearService() {
        _service = null;
    }

    public static AHOfferLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AHOfferLocalService.class.getName());

            if (invokableLocalService instanceof AHOfferLocalService) {
                _service = (AHOfferLocalService) invokableLocalService;
            } else {
                _service = new AHOfferLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AHOfferLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AHOfferLocalService service) {
    }
}
