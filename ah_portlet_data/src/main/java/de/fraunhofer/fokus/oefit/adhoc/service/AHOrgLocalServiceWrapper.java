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
package de.fraunhofer.fokus.oefit.adhoc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AHOrgLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHOrgLocalService
 * @generated
 */
public class AHOrgLocalServiceWrapper implements AHOrgLocalService,
    ServiceWrapper<AHOrgLocalService> {
    private AHOrgLocalService _ahOrgLocalService;

    public AHOrgLocalServiceWrapper(AHOrgLocalService ahOrgLocalService) {
        _ahOrgLocalService = ahOrgLocalService;
    }

    /**
    * Adds the a h org to the database. Also notifies the appropriate model listeners.
    *
    * @param ahOrg the a h org
    * @return the a h org that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg addAHOrg(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOrg ahOrg)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.addAHOrg(ahOrg);
    }

    /**
    * Creates a new a h org with the primary key. Does not add the a h org to the database.
    *
    * @param orgId the primary key for the new a h org
    * @return the new a h org
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg createAHOrg(long orgId) {
        return _ahOrgLocalService.createAHOrg(orgId);
    }

    /**
    * Deletes the a h org with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org that was removed
    * @throws PortalException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg deleteAHOrg(long orgId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.deleteAHOrg(orgId);
    }

    /**
    * Deletes the a h org from the database. Also notifies the appropriate model listeners.
    *
    * @param ahOrg the a h org
    * @return the a h org that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg deleteAHOrg(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOrg ahOrg)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.deleteAHOrg(ahOrg);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahOrgLocalService.dynamicQuery();
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
        return _ahOrgLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahOrgLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHOrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahOrgLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _ahOrgLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahOrgLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg fetchAHOrg(long orgId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.fetchAHOrg(orgId);
    }

    /**
    * Returns the a h org with the primary key.
    *
    * @param orgId the primary key of the a h org
    * @return the a h org
    * @throws PortalException if a a h org with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg getAHOrg(long orgId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.getAHOrg(orgId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.getPersistedModel(primaryKeyObj);
    }

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
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> getAHOrgs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.getAHOrgs(start, end);
    }

    /**
    * Returns the number of a h orgs.
    *
    * @return the number of a h orgs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHOrgsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.getAHOrgsCount();
    }

    /**
    * Updates the a h org in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahOrg the a h org
    * @return the a h org that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg updateAHOrg(
        de.fraunhofer.fokus.oefit.adhoc.model.AHOrg ahOrg)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahOrgLocalService.updateAHOrg(ahOrg);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahOrgLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahOrgLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahOrgLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> getOrganisations(
        int start, int end, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order) {
        return _ahOrgLocalService.getOrganisations(start, end, column, order);
    }

    @Override
    public void addOrganisationUser(long orgId, java.lang.String userMail) {
        _ahOrgLocalService.addOrganisationUser(orgId, userMail);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg getOrganisationByOwnerMail(
        java.lang.String owner) {
        return _ahOrgLocalService.getOrganisationByOwnerMail(owner);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg getOrganisationByUserMail(
        java.lang.String userMail) {
        return _ahOrgLocalService.getOrganisationByUserMail(userMail);
    }

    @Override
    public void deleteOrganisation(long orgId) {
        _ahOrgLocalService.deleteOrganisation(orgId);
    }

    @Override
    public void setOrganisationStatus(long orgId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus status) {
        _ahOrgLocalService.setOrganisationStatus(orgId, status);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHOrg addOrganisation(
        java.lang.String owner, java.lang.String name, java.lang.String holder,
        java.lang.String descr, java.lang.String legalStatus, long addressId,
        long contactId) {
        return _ahOrgLocalService.addOrganisation(owner, name, holder, descr,
            legalStatus, addressId, contactId);
    }

    @Override
    public void updateLogoLocation(long orgId, java.lang.String logoLocation) {
        _ahOrgLocalService.updateLogoLocation(orgId, logoLocation);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOrg> listOrganisations() {
        return _ahOrgLocalService.listOrganisations();
    }

    @Override
    public void updateOwner(java.lang.String oldOwner, java.lang.String newOwner) {
        _ahOrgLocalService.updateOwner(oldOwner, newOwner);
    }

    @Override
    public int countNewOrg() {
        return _ahOrgLocalService.countNewOrg();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHOrgLocalService getWrappedAHOrgLocalService() {
        return _ahOrgLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHOrgLocalService(AHOrgLocalService ahOrgLocalService) {
        _ahOrgLocalService = ahOrgLocalService;
    }

    @Override
    public AHOrgLocalService getWrappedService() {
        return _ahOrgLocalService;
    }

    @Override
    public void setWrappedService(AHOrgLocalService ahOrgLocalService) {
        _ahOrgLocalService = ahOrgLocalService;
    }
}
