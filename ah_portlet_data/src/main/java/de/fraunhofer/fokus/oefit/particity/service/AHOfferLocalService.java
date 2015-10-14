package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for AHOffer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHOfferLocalServiceUtil
 * @see de.fraunhofer.fokus.oefit.particity.service.base.AHOfferLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHOfferLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface AHOfferLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHOfferLocalServiceUtil} to access the a h offer local service. Add custom service methods to {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHOfferLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the a h offer to the database. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer addAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new a h offer with the primary key. Does not add the a h offer to the database.
    *
    * @param offerId the primary key for the new a h offer
    * @return the new a h offer
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer createAHOffer(
        long offerId);

    /**
    * Deletes the a h offer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer that was removed
    * @throws PortalException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer deleteAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the a h offer from the database. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer deleteAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer fetchAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h offer with the primary key.
    *
    * @param offerId the primary key of the a h offer
    * @return the a h offer
    * @throws PortalException if a a h offer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer getAHOffer(
        long offerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h offers.
    *
    * @return the number of a h offers
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAHOffersCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the a h offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahOffer the a h offer
    * @return the a h offer that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer updateAHOffer(
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntriesAHOffer(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void addAHCatEntriesAHOffers(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> AHOffers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void clearAHCatEntriesAHOffers(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteAHCatEntriesAHOffer(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void deleteAHCatEntriesAHOffers(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> AHOffers)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHCatEntriesAHOffers(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAHCatEntriesAHOffersCount(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasAHCatEntriesAHOffer(long itemId, long offerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasAHCatEntriesAHOffers(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * @throws SystemException if a system exception occurred
    */
    public void setAHCatEntriesAHOffers(long itemId, long[] offerIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public de.fraunhofer.fokus.oefit.particity.model.AHOffer addOffer(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType type,
        java.lang.String title, java.lang.String descr,
        java.lang.String workTime,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType workType,
        long publishDate, long expireDate, long addressId, long contactId,
        long contact2Id, boolean agencyContact, long orgId, long[] categories);

    public de.fraunhofer.fokus.oefit.particity.model.AHOffer addOffer(
        java.lang.Long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType type,
        java.lang.String title, java.lang.String descr,
        java.lang.String workTime,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType workType,
        long publishDate, long expireDate, long addressId, long contactId,
        long contact2Id, boolean agencyContact, long orgId, long[] categories);

    public void addSocialStatus(java.lang.Long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SocialMediaPlugins sm);

    public int countNewOffer();

    public int countOfferByAddress(long addrId);

    public java.lang.Integer countOfferByCategoryId(java.lang.Long[] ids);

    public java.lang.Integer countOfferByCategoryItems(
        java.lang.String[] categoryItems);

    public java.lang.Integer countOfferByOfferTypes(int[] types);

    public java.lang.Integer countOfferByTypesAndCItemsAndOrg(
        java.lang.String categoryItems, java.lang.String types, long orgId);

    public int countOffersForOrganization(long orgId);

    public java.lang.Integer countPublishedOffers(long orgId);

    public void deleteOffersByOrg(long orgId);

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> findExpiredOffersForOrg(
        long orgId, long startTime, long endTime);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesByOffer(
        long offerId, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.Long[] getCategoriesByOfferAsLong(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getCategoriesByOfferAsString(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public de.fraunhofer.fokus.oefit.particity.model.AHOffer getLastOfferForOrganization(
        long orgId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getNewlyPublishedOffers(
        long publishStartTime);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryId(
        java.lang.Long[] ids, int start, int end);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryItems(
        java.lang.String[] categoryItems, int start, int end);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.Integer getOfferByOfferTypes(int[] types);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        int[] types, int start, int end);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByTypesAndCItemsAndOrg(
        java.lang.String categoryItems, java.lang.String types, long orgId,
        int start, int end);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffers(
        int start, int end, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersForOrganization(
        long orgId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersForOrganization(
        long orgId, int start, int end, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getPublishedOffers(
        int start, int end, long orgId);

    public void setOfferStatus(long offerId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status);

    public void setSndContact(java.lang.Long offerId, long contactId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus newStatus);
}
