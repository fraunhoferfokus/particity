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
 * Provides a wrapper for {@link AHCategoriesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHCategoriesLocalService
 * @generated
 */
public class AHCategoriesLocalServiceWrapper implements AHCategoriesLocalService,
    ServiceWrapper<AHCategoriesLocalService> {
    private AHCategoriesLocalService _ahCategoriesLocalService;

    public AHCategoriesLocalServiceWrapper(
        AHCategoriesLocalService ahCategoriesLocalService) {
        _ahCategoriesLocalService = ahCategoriesLocalService;
    }

    /**
    * Adds the a h categories to the database. Also notifies the appropriate model listeners.
    *
    * @param ahCategories the a h categories
    * @return the a h categories that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories addAHCategories(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.addAHCategories(ahCategories);
    }

    /**
    * Creates a new a h categories with the primary key. Does not add the a h categories to the database.
    *
    * @param catId the primary key for the new a h categories
    * @return the new a h categories
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories createAHCategories(
        long catId) {
        return _ahCategoriesLocalService.createAHCategories(catId);
    }

    /**
    * Deletes the a h categories with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories that was removed
    * @throws PortalException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories deleteAHCategories(
        long catId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.deleteAHCategories(catId);
    }

    /**
    * Deletes the a h categories from the database. Also notifies the appropriate model listeners.
    *
    * @param ahCategories the a h categories
    * @return the a h categories that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories deleteAHCategories(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.deleteAHCategories(ahCategories);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahCategoriesLocalService.dynamicQuery();
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
        return _ahCategoriesLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahCategoriesLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahCategoriesLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _ahCategoriesLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahCategoriesLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories fetchAHCategories(
        long catId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.fetchAHCategories(catId);
    }

    /**
    * Returns the a h categories with the primary key.
    *
    * @param catId the primary key of the a h categories
    * @return the a h categories
    * @throws PortalException if a a h categories with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories getAHCategories(
        long catId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getAHCategories(catId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h categorieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h categorieses
    * @param end the upper bound of the range of a h categorieses (not inclusive)
    * @return the range of a h categorieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> getAHCategorieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getAHCategorieses(start, end);
    }

    /**
    * Returns the number of a h categorieses.
    *
    * @return the number of a h categorieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHCategoriesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getAHCategoriesesCount();
    }

    /**
    * Updates the a h categories in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahCategories the a h categories
    * @return the a h categories that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories updateAHCategories(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCategories ahCategories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.updateAHCategories(ahCategories);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahCategoriesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahCategoriesLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahCategoriesLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Get all root categories
    *
    * @return a list of root categories
    * @throws SystemException
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> getCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getCategories(type);
    }

    @Override
    public java.util.Map<java.lang.Long, java.lang.String> getCategoryMap(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type,
        boolean includeEmpty)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getCategoryMap(type, includeEmpty);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories getCategory(
        java.lang.String name,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getCategory(name, type);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories getCategory(
        long catId) throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getCategory(catId);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> getCategoriesByIdStr(
        java.lang.String idStr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getCategoriesByIdStr(idStr);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> getCategoriesByInverseIdStr(
        java.lang.String idStr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.getCategoriesByInverseIdStr(idStr);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories deleteCategoryById(
        long catId) {
        return _ahCategoriesLocalService.deleteCategoryById(catId);
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories addCategory(
        java.lang.String name, java.lang.String description,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahCategoriesLocalService.addCategory(name, description, type);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHCategoriesLocalService getWrappedAHCategoriesLocalService() {
        return _ahCategoriesLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHCategoriesLocalService(
        AHCategoriesLocalService ahCategoriesLocalService) {
        _ahCategoriesLocalService = ahCategoriesLocalService;
    }

    @Override
    public AHCategoriesLocalService getWrappedService() {
        return _ahCategoriesLocalService;
    }

    @Override
    public void setWrappedService(
        AHCategoriesLocalService ahCategoriesLocalService) {
        _ahCategoriesLocalService = ahCategoriesLocalService;
    }
}
