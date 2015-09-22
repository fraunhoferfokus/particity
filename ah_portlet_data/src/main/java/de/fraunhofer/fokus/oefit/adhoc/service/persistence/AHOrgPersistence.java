/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.adhoc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.oefit.adhoc.model.AHOrg;

/**
 * The persistence interface for the a h org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOrgPersistenceImpl
 * @see AHOrgUtil
 * @generated
 */
public interface AHOrgPersistence extends BasePersistence<AHOrg> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHOrgUtil} to access the a h org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the a h orgs where name = &#63;.
    *
    * @param name the name
    * @return the matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findByname(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h orgs where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findByname(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h orgs where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findByname(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findByname_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the first a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchByname_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findByname_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the last a h org in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchByname_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h orgs before and after the current a h org in the ordered set where name = &#63;.
    *
    * @param orgId the primary key of the current a h org
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg[] findByname_PrevAndNext(
        long orgId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Removes all the a h orgs where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByname(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h orgs where name = &#63;.
    *
    * @param name the name
    * @return the number of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public int countByname(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h orgs where owner = &#63;.
    *
    * @param owner the owner
    * @return the matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findByowner(
        java.lang.String owner)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h orgs where owner = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param owner the owner
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findByowner(
        java.lang.String owner, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h orgs where owner = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param owner the owner
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findByowner(
        java.lang.String owner, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findByowner_First(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the first a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchByowner_First(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findByowner_Last(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the last a h org in the ordered set where owner = &#63;.
    *
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchByowner_Last(
        java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h orgs before and after the current a h org in the ordered set where owner = &#63;.
    *
    * @param orgId the primary key of the current a h org
    * @param owner the owner
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg[] findByowner_PrevAndNext(
        long orgId, java.lang.String owner,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Removes all the a h orgs where owner = &#63; from the database.
    *
    * @param owner the owner
    * @throws SystemException if a system exception occurred
    */
    public void removeByowner(java.lang.String owner)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h orgs where owner = &#63;.
    *
    * @param owner the owner
    * @return the number of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public int countByowner(java.lang.String owner)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h orgs where status = &#63;.
    *
    * @param status the status
    * @return the matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findBystatus(
        int status) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h orgs where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findBystatus(
        int status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h orgs where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findBystatus(
        int status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the first a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchBystatus_First(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the last a h org in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h org, or <code>null</code> if a matching a h org could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchBystatus_Last(
        int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h orgs before and after the current a h org in the ordered set where status = &#63;.
    *
    * @param orgId the primary key of the current a h org
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg[] findBystatus_PrevAndNext(
        long orgId, int status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Removes all the a h orgs where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h orgs where status = &#63;.
    *
    * @param status the status
    * @return the number of matching a h orgs
    * @throws SystemException if a system exception occurred
    */
    public int countBystatus(int status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the a h org in the entity cache if it is enabled.
    *
    * @param ahOrg the a h org
    */
    public void cacheResult(de.fraunhofer.fokus.oefit.adhoc.model.AHOrg ahOrg);

    /**
    * Caches the a h orgs in the entity cache if it is enabled.
    *
    * @param ahOrgs the a h orgs
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> ahOrgs);

    /**
    * Creates a new a h org with the primary key. Does not add the a h org to the database.
    *
    * @param orgId the primary key for the new a h org
    * @return the new a h org
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg create(long orgId);

    /**
    * Removes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg remove(long orgId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOrg ahOrg)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h org with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException} if it could not be found.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg findByPrimaryKey(
        long orgId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHOrgException;

    /**
    * Returns the a h org with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org, or <code>null</code> if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchByPrimaryKey(
        long orgId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h orgs.
    *
    * @return the a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h orgs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @return the range of a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h orgs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h orgs
    * @param end the upper bound of the range of a h orgs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h orgs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h orgs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h orgs.
    *
    * @return the number of a h orgs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
