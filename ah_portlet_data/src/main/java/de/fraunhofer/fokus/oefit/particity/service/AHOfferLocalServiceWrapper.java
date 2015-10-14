package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AHOfferLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHOfferLocalService
 * @generated
 */
public class AHOfferLocalServiceWrapper implements AHOfferLocalService,
    ServiceWrapper<AHOfferLocalService> {
    private AHOfferLocalService _ahOfferLocalService;

    public AHOfferLocalServiceWrapper(AHOfferLocalService ahOfferLocalService) {
        _ahOfferLocalService = ahOfferLocalService;
    }

    /**
    * Adds the a h offer to the database. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer addAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.addAHOffer(ahOffer);
    }

    /**
    * Creates a new a h offer with the primary key. Does not add the a h offer to the database.
    *
    * @param offerId the primary key for the new a h offer
    * @return the new a h offer
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer createAHOffer(
        long offerId) {
        return _ahOfferLocalService.createAHOffer(offerId);
    }

    /**
    * Deletes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer that was removed
    * @throws PortalException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer deleteAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.deleteAHOffer(offerId);
    }

    /**
    * Deletes the a h offer from the database. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer deleteAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.deleteAHOffer(ahOffer);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahOfferLocalService.dynamicQuery();
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
        return _ahOfferLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _ahOfferLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahOfferLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer fetchAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.fetchAHOffer(offerId);
    }

    /**
    * Returns the a h offer with the primary key.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer
    * @throws PortalException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer getAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHOffer(offerId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHOffers(start, end);
    }

    /**
    * Returns the number of a h offers.
    *
    * @return the number of a h offers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHOffersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHOffersCount();
    }

    /**
    * Updates the a h offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer updateAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.updateAHOffer(ahOffer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.addAHCatEntriesAHOffer(itemId, offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHOffer(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.addAHCatEntriesAHOffer(itemId, ahOffer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.addAHCatEntriesAHOffers(itemId, offerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void addAHCatEntriesAHOffers(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> AHOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.addAHCatEntriesAHOffers(itemId, AHOffers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void clearAHCatEntriesAHOffers(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.clearAHCatEntriesAHOffers(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.deleteAHCatEntriesAHOffer(itemId, offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHOffer(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.deleteAHCatEntriesAHOffer(itemId, ahOffer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.deleteAHCatEntriesAHOffers(itemId, offerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void deleteAHCatEntriesAHOffers(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> AHOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.deleteAHCatEntriesAHOffers(itemId, AHOffers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHCatEntriesAHOffers(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHCatEntriesAHOffers(itemId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHCatEntriesAHOffers(itemId, start, end,
            orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHCatEntriesAHOffersCount(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.getAHCatEntriesAHOffersCount(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.hasAHCatEntriesAHOffer(itemId, offerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public boolean hasAHCatEntriesAHOffers(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOfferLocalService.hasAHCatEntriesAHOffers(itemId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    @Override
    public void setAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOfferLocalService.setAHCatEntriesAHOffers(itemId, offerIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahOfferLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahOfferLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahOfferLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer addOffer(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType type,
        java.lang.String title, java.lang.String descr,
        java.lang.String workTime,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType workType,
        long publishDate, long expireDate, long addressId, long contactId,
        long contact2Id, boolean agencyContact, long orgId, long[] categories) {
        return _ahOfferLocalService.addOffer(type, title, descr, workTime,
            workType, publishDate, expireDate, addressId, contactId,
            contact2Id, agencyContact, orgId, categories);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer addOffer(
        java.lang.Long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType type,
        java.lang.String title, java.lang.String descr,
        java.lang.String workTime,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType workType,
        long publishDate, long expireDate, long addressId, long contactId,
        long contact2Id, boolean agencyContact, long orgId, long[] categories) {
        return _ahOfferLocalService.addOffer(offerId, type, title, descr,
            workTime, workType, publishDate, expireDate, addressId, contactId,
            contact2Id, agencyContact, orgId, categories);
    }

    @Override
    public void addSocialStatus(java.lang.Long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SocialMediaPlugins sm) {
        _ahOfferLocalService.addSocialStatus(offerId, sm);
    }

    @Override
    public int countNewOffer() {
        return _ahOfferLocalService.countNewOffer();
    }

    @Override
    public int countOfferByAddress(long addrId) {
        return _ahOfferLocalService.countOfferByAddress(addrId);
    }

    @Override
    public java.lang.Integer countOfferByCategoryId(java.lang.Long[] ids) {
        return _ahOfferLocalService.countOfferByCategoryId(ids);
    }

    @Override
    public java.lang.Integer countOfferByCategoryItems(
        java.lang.String[] categoryItems) {
        return _ahOfferLocalService.countOfferByCategoryItems(categoryItems);
    }

    @Override
    public java.lang.Integer countOfferByOfferTypes(int[] types) {
        return _ahOfferLocalService.countOfferByOfferTypes(types);
    }

    @Override
    public java.lang.Integer countOfferByTypesAndCItemsAndOrg(
        java.lang.String categoryItems, java.lang.String types, long orgId) {
        return _ahOfferLocalService.countOfferByTypesAndCItemsAndOrg(categoryItems,
            types, orgId);
    }

    @Override
    public int countOffersForOrganization(long orgId) {
        return _ahOfferLocalService.countOffersForOrganization(orgId);
    }

    @Override
    public java.lang.Integer countPublishedOffers(long orgId) {
        return _ahOfferLocalService.countPublishedOffers(orgId);
    }

    @Override
    public void deleteOffersByOrg(long orgId) {
        _ahOfferLocalService.deleteOffersByOrg(orgId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> findExpiredOffersForOrg(
        long orgId, long startTime, long endTime) {
        return _ahOfferLocalService.findExpiredOffersForOrg(orgId, startTime,
            endTime);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesByOffer(
        long offerId, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type) {
        return _ahOfferLocalService.getCategoriesByOffer(offerId, type);
    }

    @Override
    public java.lang.Long[] getCategoriesByOfferAsLong(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type) {
        return _ahOfferLocalService.getCategoriesByOfferAsLong(offerId, type);
    }

    @Override
    public java.lang.String getCategoriesByOfferAsString(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type) {
        return _ahOfferLocalService.getCategoriesByOfferAsString(offerId, type);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer getLastOfferForOrganization(
        long orgId) {
        return _ahOfferLocalService.getLastOfferForOrganization(orgId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getNewlyPublishedOffers(
        long publishStartTime) {
        return _ahOfferLocalService.getNewlyPublishedOffers(publishStartTime);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryId(
        java.lang.Long[] ids, int start, int end) {
        return _ahOfferLocalService.getOfferByCategoryId(ids, start, end);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryItems(
        java.lang.String[] categoryItems, int start, int end) {
        return _ahOfferLocalService.getOfferByCategoryItems(categoryItems,
            start, end);
    }

    @Override
    public java.lang.Integer getOfferByOfferTypes(int[] types) {
        return _ahOfferLocalService.getOfferByOfferTypes(types);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        int[] types, int start, int end) {
        return _ahOfferLocalService.getOfferByOfferTypes(types, start, end);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByTypesAndCItemsAndOrg(
        java.lang.String categoryItems, java.lang.String types, long orgId,
        int start, int end) {
        return _ahOfferLocalService.getOfferByTypesAndCItemsAndOrg(categoryItems,
            types, orgId, start, end);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffers(
        int start, int end, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order) {
        return _ahOfferLocalService.getOffers(start, end, column, order);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersForOrganization(
        long orgId) {
        return _ahOfferLocalService.getOffersForOrganization(orgId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersForOrganization(
        long orgId, int start, int end, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order) {
        return _ahOfferLocalService.getOffersForOrganization(orgId, start, end,
            column, order);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getPublishedOffers(
        int start, int end, long orgId) {
        return _ahOfferLocalService.getPublishedOffers(start, end, orgId);
    }

    @Override
    public void setOfferStatus(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status) {
        _ahOfferLocalService.setOfferStatus(offerId, status);
    }

    @Override
    public void setSndContact(java.lang.Long offerId, long contactId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus newStatus) {
        _ahOfferLocalService.setSndContact(offerId, contactId, newStatus);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHOfferLocalService getWrappedAHOfferLocalService() {
        return _ahOfferLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHOfferLocalService(
        AHOfferLocalService ahOfferLocalService) {
        _ahOfferLocalService = ahOfferLocalService;
    }

    @Override
    public AHOfferLocalService getWrappedService() {
        return _ahOfferLocalService;
    }

    @Override
    public void setWrappedService(AHOfferLocalService ahOfferLocalService) {
        _ahOfferLocalService = ahOfferLocalService;
    }
}
