package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;

import java.util.List;

/**
 * The persistence utility for the a h cat entries service. This utility wraps {@link AHCatEntriesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntriesPersistence
 * @see AHCatEntriesPersistenceImpl
 * @generated
 */
public class AHCatEntriesUtil {
    private static AHCatEntriesPersistence _persistence;

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
    public static void clearCache(AHCatEntries ahCatEntries) {
        getPersistence().clearCache(ahCatEntries);
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
    public static List<AHCatEntries> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHCatEntries> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHCatEntries> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHCatEntries update(AHCatEntries ahCatEntries)
        throws SystemException {
        return getPersistence().update(ahCatEntries);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHCatEntries update(AHCatEntries ahCatEntries,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(ahCatEntries, serviceContext);
    }

    /**
    * Returns all the a h cat entrieses where catId = &#63;.
    *
    * @param catId the cat ID
    * @return the matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findBycat(
        long catId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycat(catId);
    }

    /**
    * Returns a range of all the a h cat entrieses where catId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param catId the cat ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findBycat(
        long catId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycat(catId, start, end);
    }

    /**
    * Returns an ordered range of all the a h cat entrieses where catId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param catId the cat ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findBycat(
        long catId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBycat(catId, start, end, orderByComparator);
    }

    /**
    * Returns the first a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findBycat_First(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findBycat_First(catId, orderByComparator);
    }

    /**
    * Returns the first a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchBycat_First(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBycat_First(catId, orderByComparator);
    }

    /**
    * Returns the last a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findBycat_Last(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findBycat_Last(catId, orderByComparator);
    }

    /**
    * Returns the last a h cat entries in the ordered set where catId = &#63;.
    *
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchBycat_Last(
        long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBycat_Last(catId, orderByComparator);
    }

    /**
    * Returns the a h cat entrieses before and after the current a h cat entries in the ordered set where catId = &#63;.
    *
    * @param itemId the primary key of the current a h cat entries
    * @param catId the cat ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries[] findBycat_PrevAndNext(
        long itemId, long catId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence()
                   .findBycat_PrevAndNext(itemId, catId, orderByComparator);
    }

    /**
    * Removes all the a h cat entrieses where catId = &#63; from the database.
    *
    * @param catId the cat ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBycat(long catId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBycat(catId);
    }

    /**
    * Returns the number of a h cat entrieses where catId = &#63;.
    *
    * @param catId the cat ID
    * @return the number of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static int countBycat(long catId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBycat(catId);
    }

    /**
    * Returns all the a h cat entrieses where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findByparent(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByparent(parentId);
    }

    /**
    * Returns a range of all the a h cat entrieses where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findByparent(
        long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByparent(parentId, start, end);
    }

    /**
    * Returns an ordered range of all the a h cat entrieses where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findByparent(
        long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByparent(parentId, start, end, orderByComparator);
    }

    /**
    * Returns the first a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findByparent_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findByparent_First(parentId, orderByComparator);
    }

    /**
    * Returns the first a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchByparent_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByparent_First(parentId, orderByComparator);
    }

    /**
    * Returns the last a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findByparent_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findByparent_Last(parentId, orderByComparator);
    }

    /**
    * Returns the last a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchByparent_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByparent_Last(parentId, orderByComparator);
    }

    /**
    * Returns the a h cat entrieses before and after the current a h cat entries in the ordered set where parentId = &#63;.
    *
    * @param itemId the primary key of the current a h cat entries
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries[] findByparent_PrevAndNext(
        long itemId, long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence()
                   .findByparent_PrevAndNext(itemId, parentId, orderByComparator);
    }

    /**
    * Removes all the a h cat entrieses where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByparent(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByparent(parentId);
    }

    /**
    * Returns the number of a h cat entrieses where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static int countByparent(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByparent(parentId);
    }

    /**
    * Returns all the a h cat entrieses where itemId = &#63;.
    *
    * @param itemId the item ID
    * @return the matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findByitem(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByitem(itemId);
    }

    /**
    * Returns a range of all the a h cat entrieses where itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemId the item ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findByitem(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByitem(itemId, start, end);
    }

    /**
    * Returns an ordered range of all the a h cat entrieses where itemId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param itemId the item ID
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findByitem(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByitem(itemId, start, end, orderByComparator);
    }

    /**
    * Returns the first a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findByitem_First(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findByitem_First(itemId, orderByComparator);
    }

    /**
    * Returns the first a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchByitem_First(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByitem_First(itemId, orderByComparator);
    }

    /**
    * Returns the last a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findByitem_Last(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findByitem_Last(itemId, orderByComparator);
    }

    /**
    * Returns the last a h cat entries in the ordered set where itemId = &#63;.
    *
    * @param itemId the item ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h cat entries, or <code>null</code> if a matching a h cat entries could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchByitem_Last(
        long itemId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByitem_Last(itemId, orderByComparator);
    }

    /**
    * Removes all the a h cat entrieses where itemId = &#63; from the database.
    *
    * @param itemId the item ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByitem(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByitem(itemId);
    }

    /**
    * Returns the number of a h cat entrieses where itemId = &#63;.
    *
    * @param itemId the item ID
    * @return the number of matching a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static int countByitem(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByitem(itemId);
    }

    /**
    * Caches the a h cat entries in the entity cache if it is enabled.
    *
    * @param ahCatEntries the a h cat entries
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries) {
        getPersistence().cacheResult(ahCatEntries);
    }

    /**
    * Caches the a h cat entrieses in the entity cache if it is enabled.
    *
    * @param ahCatEntrieses the a h cat entrieses
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> ahCatEntrieses) {
        getPersistence().cacheResult(ahCatEntrieses);
    }

    /**
    * Creates a new a h cat entries with the primary key. Does not add the a h cat entries to the database.
    *
    * @param itemId the primary key for the new a h cat entries
    * @return the new a h cat entries
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries create(
        long itemId) {
        return getPersistence().create(itemId);
    }

    /**
    * Removes the a h cat entries with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries remove(
        long itemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().remove(itemId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHCatEntries ahCatEntries)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahCatEntries);
    }

    /**
    * Returns the a h cat entries with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException} if it could not be found.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries findByPrimaryKey(
        long itemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException {
        return getPersistence().findByPrimaryKey(itemId);
    }

    /**
    * Returns the a h cat entries with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param itemId the primary key of the a h cat entries
    * @return the a h cat entries, or <code>null</code> if a a h cat entries with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHCatEntries fetchByPrimaryKey(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(itemId);
    }

    /**
    * Returns all the a h cat entrieses.
    *
    * @return the a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the a h cat entrieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h cat entrieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h cat entrieses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h cat entrieses.
    *
    * @return the number of a h cat entrieses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the a h subscriptions associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHSubscriptions(pk);
    }

    /**
    * Returns a range of all the a h subscriptions associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHSubscriptions(pk, start, end);
    }

    /**
    * Returns an ordered range of all the a h subscriptions associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getAHSubscriptions(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of a h subscriptions associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the number of a h subscriptions associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static int getAHSubscriptionsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHSubscriptionsSize(pk);
    }

    /**
    * Returns <code>true</code> if the a h subscription is associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPK the primary key of the a h subscription
    * @return <code>true</code> if the a h subscription is associated with the a h cat entries; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHSubscription(long pk, long ahSubscriptionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHSubscription(pk, ahSubscriptionPK);
    }

    /**
    * Returns <code>true</code> if the a h cat entries has any a h subscriptions associated with it.
    *
    * @param pk the primary key of the a h cat entries to check for associations with a h subscriptions
    * @return <code>true</code> if the a h cat entries has any a h subscriptions associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHSubscriptions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHSubscriptions(pk);
    }

    /**
    * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPK the primary key of the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscription(long pk, long ahSubscriptionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHSubscription(pk, ahSubscriptionPK);
    }

    /**
    * Adds an association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscription the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscription(long pk,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHSubscription(pk, ahSubscription);
    }

    /**
    * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPKs the primary keys of the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHSubscriptions(pk, ahSubscriptionPKs);
    }

    /**
    * Adds an association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptions the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static void addAHSubscriptions(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHSubscriptions(pk, ahSubscriptions);
    }

    /**
    * Clears all associations between the a h cat entries and its a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries to clear the associated a h subscriptions from
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHSubscriptions(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearAHSubscriptions(pk);
    }

    /**
    * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPK the primary key of the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHSubscription(long pk, long ahSubscriptionPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHSubscription(pk, ahSubscriptionPK);
    }

    /**
    * Removes the association between the a h cat entries and the a h subscription. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscription the a h subscription
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHSubscription(long pk,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHSubscription(pk, ahSubscription);
    }

    /**
    * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPKs the primary keys of the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHSubscriptions(pk, ahSubscriptionPKs);
    }

    /**
    * Removes the association between the a h cat entries and the a h subscriptions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptions the a h subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHSubscriptions(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHSubscriptions(pk, ahSubscriptions);
    }

    /**
    * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptionPKs the primary keys of the a h subscriptions to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void setAHSubscriptions(long pk, long[] ahSubscriptionPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHSubscriptions(pk, ahSubscriptionPKs);
    }

    /**
    * Sets the a h subscriptions associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahSubscriptions the a h subscriptions to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void setAHSubscriptions(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> ahSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHSubscriptions(pk, ahSubscriptions);
    }

    /**
    * Returns all the a h offers associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHOffers(pk);
    }

    /**
    * Returns a range of all the a h offers associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @return the range of a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHOffers(pk, start, end);
    }

    /**
    * Returns an ordered range of all the a h offers associated with the a h cat entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the a h cat entries
    * @param start the lower bound of the range of a h cat entrieses
    * @param end the upper bound of the range of a h cat entrieses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getAHOffers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHOffers(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of a h offers associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @return the number of a h offers associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static int getAHOffersSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getAHOffersSize(pk);
    }

    /**
    * Returns <code>true</code> if the a h offer is associated with the a h cat entries.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPK the primary key of the a h offer
    * @return <code>true</code> if the a h offer is associated with the a h cat entries; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHOffer(long pk, long ahOfferPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHOffer(pk, ahOfferPK);
    }

    /**
    * Returns <code>true</code> if the a h cat entries has any a h offers associated with it.
    *
    * @param pk the primary key of the a h cat entries to check for associations with a h offers
    * @return <code>true</code> if the a h cat entries has any a h offers associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsAHOffers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsAHOffers(pk);
    }

    /**
    * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPK the primary key of the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOffer(long pk, long ahOfferPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHOffer(pk, ahOfferPK);
    }

    /**
    * Adds an association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffer the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOffer(long pk,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHOffer(pk, ahOffer);
    }

    /**
    * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPKs the primary keys of the a h offers
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOffers(long pk, long[] ahOfferPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHOffers(pk, ahOfferPKs);
    }

    /**
    * Adds an association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffers the a h offers
    * @throws SystemException if a system exception occurred
    */
    public static void addAHOffers(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addAHOffers(pk, ahOffers);
    }

    /**
    * Clears all associations between the a h cat entries and its a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries to clear the associated a h offers from
    * @throws SystemException if a system exception occurred
    */
    public static void clearAHOffers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearAHOffers(pk);
    }

    /**
    * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPK the primary key of the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHOffer(long pk, long ahOfferPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHOffer(pk, ahOfferPK);
    }

    /**
    * Removes the association between the a h cat entries and the a h offer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffer the a h offer
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHOffer(long pk,
        de.fraunhofer.fokus.oefit.particity.model.AHOffer ahOffer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHOffer(pk, ahOffer);
    }

    /**
    * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPKs the primary keys of the a h offers
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHOffers(long pk, long[] ahOfferPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHOffers(pk, ahOfferPKs);
    }

    /**
    * Removes the association between the a h cat entries and the a h offers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffers the a h offers
    * @throws SystemException if a system exception occurred
    */
    public static void removeAHOffers(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAHOffers(pk, ahOffers);
    }

    /**
    * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOfferPKs the primary keys of the a h offers to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void setAHOffers(long pk, long[] ahOfferPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHOffers(pk, ahOfferPKs);
    }

    /**
    * Sets the a h offers associated with the a h cat entries, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the a h cat entries
    * @param ahOffers the a h offers to be associated with the a h cat entries
    * @throws SystemException if a system exception occurred
    */
    public static void setAHOffers(long pk,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> ahOffers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setAHOffers(pk, ahOffers);
    }

    public static AHCatEntriesPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHCatEntriesPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHCatEntriesPersistence.class.getName());

            ReferenceRegistry.registerReference(AHCatEntriesUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHCatEntriesPersistence persistence) {
    }
}
