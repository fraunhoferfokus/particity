package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AHAddr. This utility wraps
 * {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHAddrLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHAddrLocalService
 * @see de.fraunhofer.fokus.oefit.particity.service.base.AHAddrLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHAddrLocalServiceImpl
 * @generated
 */
public class AHAddrLocalServiceUtil {
    private static AHAddrLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHAddrLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the a h addr to the database. Also notifies the appropriate model listeners.
    *
    * @param ahAddr the a h addr
    * @return the a h addr that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr addAHAddr(
        de.fraunhofer.fokus.oefit.particity.model.AHAddr ahAddr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAHAddr(ahAddr);
    }

    /**
    * Creates a new a h addr with the primary key. Does not add the a h addr to the database.
    *
    * @param addrId the primary key for the new a h addr
    * @return the new a h addr
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr createAHAddr(
        long addrId) {
        return getService().createAHAddr(addrId);
    }

    /**
    * Deletes the a h addr with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr that was removed
    * @throws PortalException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr deleteAHAddr(
        long addrId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHAddr(addrId);
    }

    /**
    * Deletes the a h addr from the database. Also notifies the appropriate model listeners.
    *
    * @param ahAddr the a h addr
    * @return the a h addr that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr deleteAHAddr(
        de.fraunhofer.fokus.oefit.particity.model.AHAddr ahAddr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHAddr(ahAddr);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr fetchAHAddr(
        long addrId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAHAddr(addrId);
    }

    /**
    * Returns the a h addr with the primary key.
    *
    * @param addrId the primary key of the a h addr
    * @return the a h addr
    * @throws PortalException if a a h addr with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr getAHAddr(
        long addrId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHAddr(addrId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h addrs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h addrs
    * @param end the upper bound of the range of a h addrs (not inclusive)
    * @return the range of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> getAHAddrs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHAddrs(start, end);
    }

    /**
    * Returns the number of a h addrs.
    *
    * @return the number of a h addrs
    * @throws SystemException if a system exception occurred
    */
    public static int getAHAddrsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHAddrsCount();
    }

    /**
    * Updates the a h addr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahAddr the a h addr
    * @return the a h addr that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr updateAHAddr(
        de.fraunhofer.fokus.oefit.particity.model.AHAddr ahAddr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAHAddr(ahAddr);
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr addAddress(
        java.lang.String street, java.lang.String number, java.lang.Float lat,
        java.lang.Float lon, long regionId) {
        return getService().addAddress(street, number, lat, lon, regionId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHAddr> findAddressesForRegion(
        long regionId) {
        return getService().findAddressesForRegion(regionId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr getAddress(
        java.lang.String street, java.lang.String number, long regionId) {
        return getService().getAddress(street, number, regionId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHAddr updateCoords(
        long addrId, java.lang.Float lat, java.lang.Float lon) {
        return getService().updateCoords(addrId, lat, lon);
    }

    public static void clearService() {
        _service = null;
    }

    public static AHAddrLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AHAddrLocalService.class.getName());

            if (invokableLocalService instanceof AHAddrLocalService) {
                _service = (AHAddrLocalService) invokableLocalService;
            } else {
                _service = new AHAddrLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AHAddrLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AHAddrLocalService service) {
    }
}
