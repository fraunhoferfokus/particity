package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AHRegion. This utility wraps
 * {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHRegionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHRegionLocalService
 * @see de.fraunhofer.fokus.oefit.particity.service.base.AHRegionLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHRegionLocalServiceImpl
 * @generated
 */
public class AHRegionLocalServiceUtil {
    private static AHRegionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHRegionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the a h region to the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegion the a h region
    * @return the a h region that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion addAHRegion(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAHRegion(ahRegion);
    }

    /**
    * Creates a new a h region with the primary key. Does not add the a h region to the database.
    *
    * @param ahRegionPK the primary key for the new a h region
    * @return the new a h region
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion createAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK) {
        return getService().createAHRegion(ahRegionPK);
    }

    /**
    * Deletes the a h region with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region that was removed
    * @throws PortalException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion deleteAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHRegion(ahRegionPK);
    }

    /**
    * Deletes the a h region from the database. Also notifies the appropriate model listeners.
    *
    * @param ahRegion the a h region
    * @return the a h region that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion deleteAHRegion(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHRegion(ahRegion);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion fetchAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAHRegion(ahRegionPK);
    }

    /**
    * Returns the a h region with the primary key.
    *
    * @param ahRegionPK the primary key of the a h region
    * @return the a h region
    * @throws PortalException if a a h region with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion getAHRegion(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK ahRegionPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHRegion(ahRegionPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHRegion> getAHRegions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHRegions(start, end);
    }

    /**
    * Returns the number of a h regions.
    *
    * @return the number of a h regions
    * @throws SystemException if a system exception occurred
    */
    public static int getAHRegionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHRegionsCount();
    }

    /**
    * Updates the a h region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahRegion the a h region
    * @return the a h region that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion updateAHRegion(
        de.fraunhofer.fokus.oefit.particity.model.AHRegion ahRegion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAHRegion(ahRegion);
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion addRegion(
        java.lang.String city, java.lang.String country, java.lang.String zip) {
        return getService().addRegion(city, country, zip);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion getRegion(
        long regionId) {
        return getService().getRegion(regionId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion getRegion(
        java.lang.String city, java.lang.String country, java.lang.String zip) {
        return getService().getRegion(city, country, zip);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion removeRegion(
        long regionId) {
        return getService().removeRegion(regionId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHRegion removeRegion(
        java.lang.String city, java.lang.String country, java.lang.String zip) {
        return getService().removeRegion(city, country, zip);
    }

    public static void clearService() {
        _service = null;
    }

    public static AHRegionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AHRegionLocalService.class.getName());

            if (invokableLocalService instanceof AHRegionLocalService) {
                _service = (AHRegionLocalService) invokableLocalService;
            } else {
                _service = new AHRegionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AHRegionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AHRegionLocalService service) {
    }
}
