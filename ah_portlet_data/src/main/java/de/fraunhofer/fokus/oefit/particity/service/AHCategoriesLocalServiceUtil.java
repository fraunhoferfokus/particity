package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AHCategories. This utility wraps
 * {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHCategoriesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AHCategoriesLocalService
 * @see de.fraunhofer.fokus.oefit.particity.service.base.AHCategoriesLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.impl.AHCategoriesLocalServiceImpl
 * @generated
 */
public class AHCategoriesLocalServiceUtil {
    private static AHCategoriesLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.fraunhofer.fokus.oefit.particity.service.impl.AHCategoriesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the a h categories to the database. Also notifies the appropriate model listeners.
    *
    * @param ahCategories the a h categories
    * @return the a h categories that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories addAHCategories(
        de.fraunhofer.fokus.oefit.particity.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAHCategories(ahCategories);
    }

    /**
    * Creates a new a h categories with the primary key. Does not add the a h categories to the database.
    *
    * @param catId the primary key for the new a h categories
    * @return the new a h categories
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories createAHCategories(
        long catId) {
        return getService().createAHCategories(catId);
    }

    /**
    * Deletes the a h categories with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories that was removed
    * @throws PortalException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories deleteAHCategories(
        long catId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHCategories(catId);
    }

    /**
    * Deletes the a h categories from the database. Also notifies the appropriate model listeners.
    *
    * @param ahCategories the a h categories
    * @return the a h categories that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories deleteAHCategories(
        de.fraunhofer.fokus.oefit.particity.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAHCategories(ahCategories);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories fetchAHCategories(
        long catId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAHCategories(catId);
    }

    /**
    * Returns the a h categories with the primary key.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories
    * @throws PortalException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories getAHCategories(
        long catId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCategories(catId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getAHCategorieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCategorieses(start, end);
    }

    /**
    * Returns the number of a h categorieses.
    *
    * @return the number of a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static int getAHCategoriesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAHCategoriesesCount();
    }

    /**
    * Updates the a h categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahCategories the a h categories
    * @return the a h categories that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories updateAHCategories(
        de.fraunhofer.fokus.oefit.particity.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAHCategories(ahCategories);
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

    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories addCategory(
        java.lang.String name, java.lang.String description,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCategory(name, description, type);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories deleteCategoryById(
        long catId) {
        return getService().deleteCategoryById(catId);
    }

    /**
    * Get all root categories.
    *
    * @param type the type
    * @return a list of root categories
    * @throws SystemException the system exception
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategories(type);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategoriesByIdStr(
        java.lang.String idStr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategoriesByIdStr(idStr);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategoriesByInverseIdStr(
        java.lang.String idStr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategoriesByInverseIdStr(idStr);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories getCategory(
        long catId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategory(catId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories getCategory(
        java.lang.String name,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategory(name, type);
    }

    public static java.util.Map<java.lang.Long, java.lang.String> getCategoryMap(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type,
        boolean includeEmpty)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategoryMap(type, includeEmpty);
    }

    public static void clearService() {
        _service = null;
    }

    public static AHCategoriesLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AHCategoriesLocalService.class.getName());

            if (invokableLocalService instanceof AHCategoriesLocalService) {
                _service = (AHCategoriesLocalService) invokableLocalService;
            } else {
                _service = new AHCategoriesLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AHCategoriesLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AHCategoriesLocalService service) {
    }
}
