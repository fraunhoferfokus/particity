package de.fraunhofer.fokus.oefit.particity.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHAddrPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCategoriesFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCategoriesPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHConfigPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHContactPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOrgFinder;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOrgPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPersistence;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHSubscriptionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the a h categories local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHCategoriesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHCategoriesLocalServiceImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil
 * @generated
 */
public abstract class AHCategoriesLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements AHCategoriesLocalService,
        IdentifiableBean {
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService ahAddrLocalService;
    @BeanReference(type = AHAddrPersistence.class)
    protected AHAddrPersistence ahAddrPersistence;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService ahCategoriesLocalService;
    @BeanReference(type = AHCategoriesPersistence.class)
    protected AHCategoriesPersistence ahCategoriesPersistence;
    @BeanReference(type = AHCategoriesFinder.class)
    protected AHCategoriesFinder ahCategoriesFinder;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService ahCatEntriesLocalService;
    @BeanReference(type = AHCatEntriesPersistence.class)
    protected AHCatEntriesPersistence ahCatEntriesPersistence;
    @BeanReference(type = AHCatEntriesFinder.class)
    protected AHCatEntriesFinder ahCatEntriesFinder;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService ahConfigLocalService;
    @BeanReference(type = AHConfigPersistence.class)
    protected AHConfigPersistence ahConfigPersistence;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService ahContactLocalService;
    @BeanReference(type = AHContactPersistence.class)
    protected AHContactPersistence ahContactPersistence;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService ahOfferLocalService;
    @BeanReference(type = AHOfferPersistence.class)
    protected AHOfferPersistence ahOfferPersistence;
    @BeanReference(type = AHOfferFinder.class)
    protected AHOfferFinder ahOfferFinder;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalService ahOrgLocalService;
    @BeanReference(type = AHOrgPersistence.class)
    protected AHOrgPersistence ahOrgPersistence;
    @BeanReference(type = AHOrgFinder.class)
    protected AHOrgFinder ahOrgFinder;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService ahRegionLocalService;
    @BeanReference(type = AHRegionPersistence.class)
    protected AHRegionPersistence ahRegionPersistence;
    @BeanReference(type = de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService.class)
    protected de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService ahSubscriptionLocalService;
    @BeanReference(type = AHSubscriptionPersistence.class)
    protected AHSubscriptionPersistence ahSubscriptionPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private AHCategoriesLocalServiceClpInvoker _clpInvoker = new AHCategoriesLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil} to access the a h categories local service.
     */

    /**
     * Adds the a h categories to the database. Also notifies the appropriate model listeners.
     *
     * @param ahCategories the a h categories
     * @return the a h categories that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public AHCategories addAHCategories(AHCategories ahCategories)
        throws SystemException {
        ahCategories.setNew(true);

        return ahCategoriesPersistence.update(ahCategories);
    }

    /**
     * Creates a new a h categories with the primary key. Does not add the a h categories to the database.
     *
     * @param catId the primary key for the new a h categories
     * @return the new a h categories
     */
    @Override
    public AHCategories createAHCategories(long catId) {
        return ahCategoriesPersistence.create(catId);
    }

    /**
     * Deletes the a h categories with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param catId the primary key of the a h categories
     * @return the a h categories that was removed
     * @throws PortalException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public AHCategories deleteAHCategories(long catId)
        throws PortalException, SystemException {
        return ahCategoriesPersistence.remove(catId);
    }

    /**
     * Deletes the a h categories from the database. Also notifies the appropriate model listeners.
     *
     * @param ahCategories the a h categories
     * @return the a h categories that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public AHCategories deleteAHCategories(AHCategories ahCategories)
        throws SystemException {
        return ahCategoriesPersistence.remove(ahCategories);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(AHCategories.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return ahCategoriesPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return ahCategoriesPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return ahCategoriesPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return ahCategoriesPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return ahCategoriesPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public AHCategories fetchAHCategories(long catId) throws SystemException {
        return ahCategoriesPersistence.fetchByPrimaryKey(catId);
    }

    /**
     * Returns the a h categories with the primary key.
     *
     * @param catId the primary key of the a h categories
     * @return the a h categories
     * @throws PortalException if a a h categories with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHCategories getAHCategories(long catId)
        throws PortalException, SystemException {
        return ahCategoriesPersistence.findByPrimaryKey(catId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return ahCategoriesPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the a h categorieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h categorieses
     * @param end the upper bound of the range of a h categorieses (not inclusive)
     * @return the range of a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHCategories> getAHCategorieses(int start, int end)
        throws SystemException {
        return ahCategoriesPersistence.findAll(start, end);
    }

    /**
     * Returns the number of a h categorieses.
     *
     * @return the number of a h categorieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getAHCategoriesesCount() throws SystemException {
        return ahCategoriesPersistence.countAll();
    }

    /**
     * Updates the a h categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param ahCategories the a h categories
     * @return the a h categories that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public AHCategories updateAHCategories(AHCategories ahCategories)
        throws SystemException {
        return ahCategoriesPersistence.update(ahCategories);
    }

    /**
     * Returns the a h addr local service.
     *
     * @return the a h addr local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService getAHAddrLocalService() {
        return ahAddrLocalService;
    }

    /**
     * Sets the a h addr local service.
     *
     * @param ahAddrLocalService the a h addr local service
     */
    public void setAHAddrLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalService ahAddrLocalService) {
        this.ahAddrLocalService = ahAddrLocalService;
    }

    /**
     * Returns the a h addr persistence.
     *
     * @return the a h addr persistence
     */
    public AHAddrPersistence getAHAddrPersistence() {
        return ahAddrPersistence;
    }

    /**
     * Sets the a h addr persistence.
     *
     * @param ahAddrPersistence the a h addr persistence
     */
    public void setAHAddrPersistence(AHAddrPersistence ahAddrPersistence) {
        this.ahAddrPersistence = ahAddrPersistence;
    }

    /**
     * Returns the a h categories local service.
     *
     * @return the a h categories local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService getAHCategoriesLocalService() {
        return ahCategoriesLocalService;
    }

    /**
     * Sets the a h categories local service.
     *
     * @param ahCategoriesLocalService the a h categories local service
     */
    public void setAHCategoriesLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService ahCategoriesLocalService) {
        this.ahCategoriesLocalService = ahCategoriesLocalService;
    }

    /**
     * Returns the a h categories persistence.
     *
     * @return the a h categories persistence
     */
    public AHCategoriesPersistence getAHCategoriesPersistence() {
        return ahCategoriesPersistence;
    }

    /**
     * Sets the a h categories persistence.
     *
     * @param ahCategoriesPersistence the a h categories persistence
     */
    public void setAHCategoriesPersistence(
        AHCategoriesPersistence ahCategoriesPersistence) {
        this.ahCategoriesPersistence = ahCategoriesPersistence;
    }

    /**
     * Returns the a h categories finder.
     *
     * @return the a h categories finder
     */
    public AHCategoriesFinder getAHCategoriesFinder() {
        return ahCategoriesFinder;
    }

    /**
     * Sets the a h categories finder.
     *
     * @param ahCategoriesFinder the a h categories finder
     */
    public void setAHCategoriesFinder(AHCategoriesFinder ahCategoriesFinder) {
        this.ahCategoriesFinder = ahCategoriesFinder;
    }

    /**
     * Returns the a h cat entries local service.
     *
     * @return the a h cat entries local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService getAHCatEntriesLocalService() {
        return ahCatEntriesLocalService;
    }

    /**
     * Sets the a h cat entries local service.
     *
     * @param ahCatEntriesLocalService the a h cat entries local service
     */
    public void setAHCatEntriesLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService ahCatEntriesLocalService) {
        this.ahCatEntriesLocalService = ahCatEntriesLocalService;
    }

    /**
     * Returns the a h cat entries persistence.
     *
     * @return the a h cat entries persistence
     */
    public AHCatEntriesPersistence getAHCatEntriesPersistence() {
        return ahCatEntriesPersistence;
    }

    /**
     * Sets the a h cat entries persistence.
     *
     * @param ahCatEntriesPersistence the a h cat entries persistence
     */
    public void setAHCatEntriesPersistence(
        AHCatEntriesPersistence ahCatEntriesPersistence) {
        this.ahCatEntriesPersistence = ahCatEntriesPersistence;
    }

    /**
     * Returns the a h cat entries finder.
     *
     * @return the a h cat entries finder
     */
    public AHCatEntriesFinder getAHCatEntriesFinder() {
        return ahCatEntriesFinder;
    }

    /**
     * Sets the a h cat entries finder.
     *
     * @param ahCatEntriesFinder the a h cat entries finder
     */
    public void setAHCatEntriesFinder(AHCatEntriesFinder ahCatEntriesFinder) {
        this.ahCatEntriesFinder = ahCatEntriesFinder;
    }

    /**
     * Returns the a h config local service.
     *
     * @return the a h config local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService getAHConfigLocalService() {
        return ahConfigLocalService;
    }

    /**
     * Sets the a h config local service.
     *
     * @param ahConfigLocalService the a h config local service
     */
    public void setAHConfigLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService ahConfigLocalService) {
        this.ahConfigLocalService = ahConfigLocalService;
    }

    /**
     * Returns the a h config persistence.
     *
     * @return the a h config persistence
     */
    public AHConfigPersistence getAHConfigPersistence() {
        return ahConfigPersistence;
    }

    /**
     * Sets the a h config persistence.
     *
     * @param ahConfigPersistence the a h config persistence
     */
    public void setAHConfigPersistence(AHConfigPersistence ahConfigPersistence) {
        this.ahConfigPersistence = ahConfigPersistence;
    }

    /**
     * Returns the a h contact local service.
     *
     * @return the a h contact local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService getAHContactLocalService() {
        return ahContactLocalService;
    }

    /**
     * Sets the a h contact local service.
     *
     * @param ahContactLocalService the a h contact local service
     */
    public void setAHContactLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService ahContactLocalService) {
        this.ahContactLocalService = ahContactLocalService;
    }

    /**
     * Returns the a h contact persistence.
     *
     * @return the a h contact persistence
     */
    public AHContactPersistence getAHContactPersistence() {
        return ahContactPersistence;
    }

    /**
     * Sets the a h contact persistence.
     *
     * @param ahContactPersistence the a h contact persistence
     */
    public void setAHContactPersistence(
        AHContactPersistence ahContactPersistence) {
        this.ahContactPersistence = ahContactPersistence;
    }

    /**
     * Returns the a h offer local service.
     *
     * @return the a h offer local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService getAHOfferLocalService() {
        return ahOfferLocalService;
    }

    /**
     * Sets the a h offer local service.
     *
     * @param ahOfferLocalService the a h offer local service
     */
    public void setAHOfferLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalService ahOfferLocalService) {
        this.ahOfferLocalService = ahOfferLocalService;
    }

    /**
     * Returns the a h offer persistence.
     *
     * @return the a h offer persistence
     */
    public AHOfferPersistence getAHOfferPersistence() {
        return ahOfferPersistence;
    }

    /**
     * Sets the a h offer persistence.
     *
     * @param ahOfferPersistence the a h offer persistence
     */
    public void setAHOfferPersistence(AHOfferPersistence ahOfferPersistence) {
        this.ahOfferPersistence = ahOfferPersistence;
    }

    /**
     * Returns the a h offer finder.
     *
     * @return the a h offer finder
     */
    public AHOfferFinder getAHOfferFinder() {
        return ahOfferFinder;
    }

    /**
     * Sets the a h offer finder.
     *
     * @param ahOfferFinder the a h offer finder
     */
    public void setAHOfferFinder(AHOfferFinder ahOfferFinder) {
        this.ahOfferFinder = ahOfferFinder;
    }

    /**
     * Returns the a h org local service.
     *
     * @return the a h org local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalService getAHOrgLocalService() {
        return ahOrgLocalService;
    }

    /**
     * Sets the a h org local service.
     *
     * @param ahOrgLocalService the a h org local service
     */
    public void setAHOrgLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalService ahOrgLocalService) {
        this.ahOrgLocalService = ahOrgLocalService;
    }

    /**
     * Returns the a h org persistence.
     *
     * @return the a h org persistence
     */
    public AHOrgPersistence getAHOrgPersistence() {
        return ahOrgPersistence;
    }

    /**
     * Sets the a h org persistence.
     *
     * @param ahOrgPersistence the a h org persistence
     */
    public void setAHOrgPersistence(AHOrgPersistence ahOrgPersistence) {
        this.ahOrgPersistence = ahOrgPersistence;
    }

    /**
     * Returns the a h org finder.
     *
     * @return the a h org finder
     */
    public AHOrgFinder getAHOrgFinder() {
        return ahOrgFinder;
    }

    /**
     * Sets the a h org finder.
     *
     * @param ahOrgFinder the a h org finder
     */
    public void setAHOrgFinder(AHOrgFinder ahOrgFinder) {
        this.ahOrgFinder = ahOrgFinder;
    }

    /**
     * Returns the a h region local service.
     *
     * @return the a h region local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService getAHRegionLocalService() {
        return ahRegionLocalService;
    }

    /**
     * Sets the a h region local service.
     *
     * @param ahRegionLocalService the a h region local service
     */
    public void setAHRegionLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService ahRegionLocalService) {
        this.ahRegionLocalService = ahRegionLocalService;
    }

    /**
     * Returns the a h region persistence.
     *
     * @return the a h region persistence
     */
    public AHRegionPersistence getAHRegionPersistence() {
        return ahRegionPersistence;
    }

    /**
     * Sets the a h region persistence.
     *
     * @param ahRegionPersistence the a h region persistence
     */
    public void setAHRegionPersistence(AHRegionPersistence ahRegionPersistence) {
        this.ahRegionPersistence = ahRegionPersistence;
    }

    /**
     * Returns the a h subscription local service.
     *
     * @return the a h subscription local service
     */
    public de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService getAHSubscriptionLocalService() {
        return ahSubscriptionLocalService;
    }

    /**
     * Sets the a h subscription local service.
     *
     * @param ahSubscriptionLocalService the a h subscription local service
     */
    public void setAHSubscriptionLocalService(
        de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalService ahSubscriptionLocalService) {
        this.ahSubscriptionLocalService = ahSubscriptionLocalService;
    }

    /**
     * Returns the a h subscription persistence.
     *
     * @return the a h subscription persistence
     */
    public AHSubscriptionPersistence getAHSubscriptionPersistence() {
        return ahSubscriptionPersistence;
    }

    /**
     * Sets the a h subscription persistence.
     *
     * @param ahSubscriptionPersistence the a h subscription persistence
     */
    public void setAHSubscriptionPersistence(
        AHSubscriptionPersistence ahSubscriptionPersistence) {
        this.ahSubscriptionPersistence = ahSubscriptionPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("de.fraunhofer.fokus.oefit.particity.model.AHCategories",
            ahCategoriesLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "de.fraunhofer.fokus.oefit.particity.model.AHCategories");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return AHCategories.class;
    }

    protected String getModelClassName() {
        return AHCategories.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = ahCategoriesPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
