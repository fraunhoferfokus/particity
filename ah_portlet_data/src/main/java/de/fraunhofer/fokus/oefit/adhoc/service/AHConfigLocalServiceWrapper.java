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
 * Provides a wrapper for {@link AHConfigLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHConfigLocalService
 * @generated
 */
public class AHConfigLocalServiceWrapper implements AHConfigLocalService,
    ServiceWrapper<AHConfigLocalService> {
    private AHConfigLocalService _ahConfigLocalService;

    public AHConfigLocalServiceWrapper(
        AHConfigLocalService ahConfigLocalService) {
        _ahConfigLocalService = ahConfigLocalService;
    }

    /**
    * Adds the a h config to the database. Also notifies the appropriate model listeners.
    *
    * @param ahConfig the a h config
    * @return the a h config that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig addAHConfig(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.addAHConfig(ahConfig);
    }

    /**
    * Creates a new a h config with the primary key. Does not add the a h config to the database.
    *
    * @param name the primary key for the new a h config
    * @return the new a h config
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig createAHConfig(
        java.lang.String name) {
        return _ahConfigLocalService.createAHConfig(name);
    }

    /**
    * Deletes the a h config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param name the primary key of the a h config
    * @return the a h config that was removed
    * @throws PortalException if a a h config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig deleteAHConfig(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.deleteAHConfig(name);
    }

    /**
    * Deletes the a h config from the database. Also notifies the appropriate model listeners.
    *
    * @param ahConfig the a h config
    * @return the a h config that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig deleteAHConfig(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.deleteAHConfig(ahConfig);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahConfigLocalService.dynamicQuery();
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
        return _ahConfigLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahConfigLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahConfigLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _ahConfigLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahConfigLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig fetchAHConfig(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.fetchAHConfig(name);
    }

    /**
    * Returns the a h config with the primary key.
    *
    * @param name the primary key of the a h config
    * @return the a h config
    * @throws PortalException if a a h config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig getAHConfig(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.getAHConfig(name);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h configs
    * @param end the upper bound of the range of a h configs (not inclusive)
    * @return the range of a h configs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHConfig> getAHConfigs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.getAHConfigs(start, end);
    }

    /**
    * Returns the number of a h configs.
    *
    * @return the number of a h configs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHConfigsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.getAHConfigsCount();
    }

    /**
    * Updates the a h config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahConfig the a h config
    * @return the a h config that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig updateAHConfig(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahConfigLocalService.updateAHConfig(ahConfig);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahConfigLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahConfigLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahConfigLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.lang.String getConfig(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey key) {
        return _ahConfigLocalService.getConfig(key);
    }

    @Override
    public java.lang.String getConfig(java.lang.String key,
        java.lang.String defaultValue) {
        return _ahConfigLocalService.getConfig(key, defaultValue);
    }

    @Override
    public void setConfig(java.lang.String key, java.lang.String value) {
        _ahConfigLocalService.setConfig(key, value);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHConfigLocalService getWrappedAHConfigLocalService() {
        return _ahConfigLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHConfigLocalService(
        AHConfigLocalService ahConfigLocalService) {
        _ahConfigLocalService = ahConfigLocalService;
    }

    @Override
    public AHConfigLocalService getWrappedService() {
        return _ahConfigLocalService;
    }

    @Override
    public void setWrappedService(AHConfigLocalService ahConfigLocalService) {
        _ahConfigLocalService = ahConfigLocalService;
    }
}
