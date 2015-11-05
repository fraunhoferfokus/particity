package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.fraunhofer.fokus.oefit.particity.model.AHCategories;

import java.util.List;

/**
 * The persistence utility for the a h categories service. This utility wraps {@link AHCategoriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCategoriesPersistence
 * @see AHCategoriesPersistenceImpl
 * @generated
 */
public class AHCategoriesUtil {
    private static AHCategoriesPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(AHCategories ahCategories) {
        getPersistence().clearCache(ahCategories);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<AHCategories> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHCategories> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHCategories> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHCategories update(AHCategories ahCategories)
        throws SystemException {
        return getPersistence().update(ahCategories);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHCategories update(AHCategories ahCategories,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(ahCategories, serviceContext);
    }

    /**
    * Returns all the a h categorieses where name = &#63; and type = &#63;.
    *
    * @param name the name
    * @param type the type
    * @return the matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findBynameAndType(
        java.lang.String name, int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBynameAndType(name, type);
    }

    /**
    * Returns a range of all the a h categorieses where name = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param type the type
    * @param start the lower bound of the range of a h categorieses
    * @param end the upper bound of the range of a h categorieses (not inclusive)
    * @return the range of matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findBynameAndType(
        java.lang.String name, int type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBynameAndType(name, type, start, end);
    }

    /**
    * Returns an ordered range of all the a h categorieses where name = &#63; and type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param type the type
    * @param start the lower bound of the range of a h categorieses
    * @param end the upper bound of the range of a h categorieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findBynameAndType(
        java.lang.String name, int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBynameAndType(name, type, start, end, orderByComparator);
    }

    /**
    * Returns the first a h categories in the ordered set where name = &#63; and type = &#63;.
    *
    * @param name the name
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories findBynameAndType_First(
        java.lang.String name, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence()
                   .findBynameAndType_First(name, type, orderByComparator);
    }

    /**
    * Returns the first a h categories in the ordered set where name = &#63; and type = &#63;.
    *
    * @param name the name
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h categories, or <code>null</code> if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories fetchBynameAndType_First(
        java.lang.String name, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBynameAndType_First(name, type, orderByComparator);
    }

    /**
    * Returns the last a h categories in the ordered set where name = &#63; and type = &#63;.
    *
    * @param name the name
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories findBynameAndType_Last(
        java.lang.String name, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence()
                   .findBynameAndType_Last(name, type, orderByComparator);
    }

    /**
    * Returns the last a h categories in the ordered set where name = &#63; and type = &#63;.
    *
    * @param name the name
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h categories, or <code>null</code> if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories fetchBynameAndType_Last(
        java.lang.String name, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBynameAndType_Last(name, type, orderByComparator);
    }

    /**
    * Returns the a h categorieses before and after the current a h categories in the ordered set where name = &#63; and type = &#63;.
    *
    * @param catId the primary key of the current a h categories
    * @param name the name
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories[] findBynameAndType_PrevAndNext(
        long catId, java.lang.String name, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence()
                   .findBynameAndType_PrevAndNext(catId, name, type,
            orderByComparator);
    }

    /**
    * Removes all the a h categorieses where name = &#63; and type = &#63; from the database.
    *
    * @param name the name
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public static void removeBynameAndType(java.lang.String name, int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBynameAndType(name, type);
    }

    /**
    * Returns the number of a h categorieses where name = &#63; and type = &#63;.
    *
    * @param name the name
    * @param type the type
    * @return the number of matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static int countBynameAndType(java.lang.String name, int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBynameAndType(name, type);
    }

    /**
    * Returns all the a h categorieses where type = &#63;.
    *
    * @param type the type
    * @return the matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findBytype(
        int type) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytype(type);
    }

    /**
    * Returns a range of all the a h categorieses where type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param type the type
    * @param start the lower bound of the range of a h categorieses
    * @param end the upper bound of the range of a h categorieses (not inclusive)
    * @return the range of matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findBytype(
        int type, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytype(type, start, end);
    }

    /**
    * Returns an ordered range of all the a h categorieses where type = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param type the type
    * @param start the lower bound of the range of a h categorieses
    * @param end the upper bound of the range of a h categorieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findBytype(
        int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytype(type, start, end, orderByComparator);
    }

    /**
    * Returns the first a h categories in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories findBytype_First(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence().findBytype_First(type, orderByComparator);
    }

    /**
    * Returns the first a h categories in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h categories, or <code>null</code> if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories fetchBytype_First(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytype_First(type, orderByComparator);
    }

    /**
    * Returns the last a h categories in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories findBytype_Last(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence().findBytype_Last(type, orderByComparator);
    }

    /**
    * Returns the last a h categories in the ordered set where type = &#63;.
    *
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h categories, or <code>null</code> if a matching a h categories could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories fetchBytype_Last(
        int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytype_Last(type, orderByComparator);
    }

    /**
    * Returns the a h categorieses before and after the current a h categories in the ordered set where type = &#63;.
    *
    * @param catId the primary key of the current a h categories
    * @param type the type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories[] findBytype_PrevAndNext(
        long catId, int type,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence()
                   .findBytype_PrevAndNext(catId, type, orderByComparator);
    }

    /**
    * Removes all the a h categorieses where type = &#63; from the database.
    *
    * @param type the type
    * @throws SystemException if a system exception occurred
    */
    public static void removeBytype(int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBytype(type);
    }

    /**
    * Returns the number of a h categorieses where type = &#63;.
    *
    * @param type the type
    * @return the number of matching a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static int countBytype(int type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytype(type);
    }

    /**
    * Caches the a h categories in the entity cache if it is enabled.
    *
    * @param ahCategories the a h categories
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHCategories ahCategories) {
        getPersistence().cacheResult(ahCategories);
    }

    /**
    * Caches the a h categorieses in the entity cache if it is enabled.
    *
    * @param ahCategorieses the a h categorieses
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> ahCategorieses) {
        getPersistence().cacheResult(ahCategorieses);
    }

    /**
    * Creates a new a h categories with the primary key. Does not add the a h categories to the database.
    *
    * @param catId the primary key for the new a h categories
    * @return the new a h categories
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories create(
        long catId) {
        return getPersistence().create(catId);
    }

    /**
    * Removes the a h categories with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories remove(
        long catId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence().remove(catId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahCategories);
    }

    /**
    * Returns the a h categories with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException} if it could not be found.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories findByPrimaryKey(
        long catId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException {
        return getPersistence().findByPrimaryKey(catId);
    }

    /**
    * Returns the a h categories with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories, or <code>null</code> if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCategories fetchByPrimaryKey(
        long catId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(catId);
    }

    /**
    * Returns all the a h categorieses.
    *
    * @return the a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h categorieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h categorieses
    * @param end the upper bound of the range of a h categorieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h categorieses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h categorieses.
    *
    * @return the number of a h categorieses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AHCategoriesPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHCategoriesPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHCategoriesPersistence.class.getName());

            ReferenceRegistry.registerReference(AHCategoriesUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHCategoriesPersistence persistence) {
    }
}
