package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.fraunhofer.fokus.oefit.particity.model.AHOrg;

import java.util.List;

/**
 * The persistence utility for the a h org service. This utility wraps {@link AHOrgPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOrgPersistence
 * @see AHOrgPersistenceImpl
 * @generated
 */
public class AHOrgUtil {
    private static AHOrgPersistence _persistence;

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
    public static void clearCache(AHOrg ahOrg) {
        getPersistence().clearCache(ahOrg);
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
    public static List<AHOrg> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AHOrg> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AHOrg> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AHOrg update(AHOrg ahOrg) throws SystemException {
        return getPersistence().update(ahOrg);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AHOrg update(AHOrg ahOrg, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(ahOrg, serviceContext);
    }

    /**
    * Returns all the a h orgs where name = &#63;.
    *
    * @param name the name
    * @return the matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findByname(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(name);
    }

    /**
    * Returns a range of all the a h orgs where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findByname(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(name, start, end);
    }

    /**
    * Returns an ordered range of all the a h orgs where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findByname(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname(name, start, end, orderByComparator);
    }

    /**
    * Returns the first a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findByname_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findByname_First(name, orderByComparator);
    }

    /**
    * Returns the first a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchByname_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByname_First(name, orderByComparator);
    }

    /**
    * Returns the last a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findByname_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findByname_Last(name, orderByComparator);
    }

    /**
    * Returns the last a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchByname_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByname_Last(name, orderByComparator);
    }

    /**
    * Returns the a h orgs before and after the current a h org in the ordered set where name = &#63;.
    *
    * @param orgId the primary key of the current a h org
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg[] findByname_PrevAndNext(
        long orgId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence()
                   .findByname_PrevAndNext(orgId, name, orderByComparator);
    }

    /**
    * Removes all the a h orgs where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByname(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByname(name);
    }

    /**
    * Returns the number of a h orgs where name = &#63;.
    *
    * @param name the name
    * @return the number of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static int countByname(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByname(name);
    }

    /**
    * Returns all the a h orgs where owner = &#63;.
    *
    * @param owner the owner
    * @return the matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findByowner(
        java.lang.String owner)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByowner(owner);
    }

    /**
    * Returns a range of all the a h orgs where owner = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param owner the owner
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findByowner(
        java.lang.String owner, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByowner(owner, start, end);
    }

    /**
    * Returns an ordered range of all the a h orgs where owner = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param owner the owner
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findByowner(
        java.lang.String owner, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByowner(owner, start, end, orderByComparator);
    }

    /**
    * Returns the first a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findByowner_First(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findByowner_First(owner, orderByComparator);
    }

    /**
    * Returns the first a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchByowner_First(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByowner_First(owner, orderByComparator);
    }

    /**
    * Returns the last a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findByowner_Last(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findByowner_Last(owner, orderByComparator);
    }

    /**
    * Returns the last a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchByowner_Last(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByowner_Last(owner, orderByComparator);
    }

    /**
    * Returns the a h orgs before and after the current a h org in the ordered set where owner = &#63;.
    *
    * @param orgId the primary key of the current a h org
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg[] findByowner_PrevAndNext(
        long orgId, java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence()
                   .findByowner_PrevAndNext(orgId, owner, orderByComparator);
    }

    /**
    * Removes all the a h orgs where owner = &#63; from the database.
    *
    * @param owner the owner
    * @throws SystemException if a system exception occurred
    */
    public static void removeByowner(java.lang.String owner)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByowner(owner);
    }

    /**
    * Returns the number of a h orgs where owner = &#63;.
    *
    * @param owner the owner
    * @return the number of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static int countByowner(java.lang.String owner)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByowner(owner);
    }

    /**
    * Returns all the a h orgs where status = &#63;.
    *
    * @param status the status
    * @return the matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status);
    }

    /**
    * Returns a range of all the a h orgs where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBystatus(status, start, end);
    }

    /**
    * Returns an ordered range of all the a h orgs where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBystatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the first a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_First(status, orderByComparator);
    }

    /**
    * Returns the last a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findBystatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBystatus_Last(status, orderByComparator);
    }

    /**
    * Returns the a h orgs before and after the current a h org in the ordered set where status = &#63;.
    *
    * @param orgId the primary key of the current a h org
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg[] findBystatus_PrevAndNext(
        long orgId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence()
                   .findBystatus_PrevAndNext(orgId, status, orderByComparator);
    }

    /**
    * Removes all the a h orgs where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBystatus(status);
    }

    /**
    * Returns the number of a h orgs where status = &#63;.
    *
    * @param status the status
    * @return the number of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBystatus(status);
    }

    /**
    * Caches the a h org in the entity cache if it is enabled.
    *
    * @param ahOrg the a h org
    */
    public static void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHOrg ahOrg) {
        getPersistence().cacheResult(ahOrg);
    }

    /**
    * Caches the a h orgs in the entity cache if it is enabled.
    *
    * @param ahOrgs the a h orgs
    */
    public static void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> ahOrgs) {
        getPersistence().cacheResult(ahOrgs);
    }

    /**
    * Creates a new a h org with the primary key. Does not add the a h org to the database.
    *
    * @param orgId the primary key for the new a h org
    * @return the new a h org
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg create(
        long orgId) {
        return getPersistence().create(orgId);
    }

    /**
    * Removes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg remove(
        long orgId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().remove(orgId);
    }

    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHOrg ahOrg)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ahOrg);
    }

    /**
    * Returns the a h org with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException} if it could not be found.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg findByPrimaryKey(
        long orgId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException {
        return getPersistence().findByPrimaryKey(orgId);
    }

    /**
    * Returns the a h org with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org, or <code>null</code> if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.fraunhofer.fokus.oefit.particity.model.AHOrg fetchByPrimaryKey(
        long orgId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(orgId);
    }

    /**
    * Returns all the a h orgs.
    *
    * @return the a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the a h orgs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the a h orgs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the a h orgs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of a h orgs.
    *
    * @return the number of a h orgs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AHOrgPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AHOrgPersistence) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHOrgPersistence.class.getName());

            ReferenceRegistry.registerReference(AHOrgUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AHOrgPersistence persistence) {
    }
}
