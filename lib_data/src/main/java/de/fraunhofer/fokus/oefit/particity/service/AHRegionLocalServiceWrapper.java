package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AHRegionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHRegionLocalService
 * @generated
 */
public class AHRegionLocalServiceWrapper implements AHRegionLocalService,
    ServiceWrapper<AHRegionLocalService> {
    private AHRegionLocalService _ahRegionLocalService;

    public AHRegionLocalServiceWrapper(
        AHRegionLocalService ahRegionLocalService) {
        _ahRegionLocalService = ahRegionLocalService;
    }

    /**
    * Adds the a h region to the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegion the a h region
    * @return the a h region that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion addAHRegion(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.addAHRegion(ahRegion);
    }

    /**
    * Creates a new a h region with the primary key. Does not add the a h region to the database.
    *
    * @param ahRegionPK the primary key for the new a h region
    * @return the new a h region
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion createAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK) {
        return _ahRegionLocalService.createAHRegion(ahRegionPK);
    }

    /**
    * Deletes the a h region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region that was removed
    * @throws PortalException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion deleteAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.deleteAHRegion(ahRegionPK);
    }

    /**
    * Deletes the a h region from the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegion the a h region
    * @return the a h region that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion deleteAHRegion(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.deleteAHRegion(ahRegion);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahRegionLocalService.dynamicQuery();
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
        return _ahRegionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahRegionLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahRegionLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _ahRegionLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahRegionLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.fetchAHRegion(ahRegionPK);
    }

    /**
    * Returns the a h region with the primary key.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region
    * @throws PortalException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion getAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.getAHRegion(ahRegionPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h regions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h regions
    * @param end the upper bound of the range of a h regions (not inclusive)
    * @return the range of a h regions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> getAHRegions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.getAHRegions(start, end);
    }

    /**
    * Returns the number of a h regions.
    *
    * @return the number of a h regions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHRegionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.getAHRegionsCount();
    }

    /**
    * Updates the a h region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahRegion the a h region
    * @return the a h region that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion updateAHRegion(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahRegionLocalService.updateAHRegion(ahRegion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahRegionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahRegionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahRegionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion addRegion(
        java.lang.String city, java.lang.String country, java.lang.String zip) {
        return _ahRegionLocalService.addRegion(city, country, zip);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion getRegion(
        long regionId) {
        return _ahRegionLocalService.getRegion(regionId);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion getRegion(
        java.lang.String city, java.lang.String country, java.lang.String zip) {
        return _ahRegionLocalService.getRegion(city, country, zip);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion removeRegion(
        long regionId) {
        return _ahRegionLocalService.removeRegion(regionId);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHRegion removeRegion(
        java.lang.String city, java.lang.String country, java.lang.String zip) {
        return _ahRegionLocalService.removeRegion(city, country, zip);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHRegionLocalService getWrappedAHRegionLocalService() {
        return _ahRegionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHRegionLocalService(
        AHRegionLocalService ahRegionLocalService) {
        _ahRegionLocalService = ahRegionLocalService;
    }

    @Override
    public AHRegionLocalService getWrappedService() {
        return _ahRegionLocalService;
    }

    @Override
    public void setWrappedService(AHRegionLocalService ahRegionLocalService) {
        _ahRegionLocalService = ahRegionLocalService;
    }
}
