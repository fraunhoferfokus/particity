package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AHContactLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AHContactLocalService
 * @generated
 */
public class AHContactLocalServiceWrapper implements AHContactLocalService,
    ServiceWrapper<AHContactLocalService> {
    private AHContactLocalService _ahContactLocalService;

    public AHContactLocalServiceWrapper(
        AHContactLocalService ahContactLocalService) {
        _ahContactLocalService = ahContactLocalService;
    }

    /**
    * Adds the a h contact to the database. Also notifies the appropriate model listeners.
    *
    * @param ahContact the a h contact
    * @return the a h contact that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact addAHContact(
        de.fraunhofer.fokus.oefit.particity.model.AHContact ahContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.addAHContact(ahContact);
    }

    /**
    * Creates a new a h contact with the primary key. Does not add the a h contact to the database.
    *
    * @param contactId the primary key for the new a h contact
    * @return the new a h contact
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact createAHContact(
        long contactId) {
        return _ahContactLocalService.createAHContact(contactId);
    }

    /**
    * Deletes the a h contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact that was removed
    * @throws PortalException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact deleteAHContact(
        long contactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.deleteAHContact(contactId);
    }

    /**
    * Deletes the a h contact from the database. Also notifies the appropriate model listeners.
    *
    * @param ahContact the a h contact
    * @return the a h contact that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact deleteAHContact(
        de.fraunhofer.fokus.oefit.particity.model.AHContact ahContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.deleteAHContact(ahContact);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _ahContactLocalService.dynamicQuery();
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
        return _ahContactLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahContactLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _ahContactLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _ahContactLocalService.dynamicQueryCount(dynamicQuery);
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
        return _ahContactLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact fetchAHContact(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.fetchAHContact(contactId);
    }

    /**
    * Returns the a h contact with the primary key.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact
    * @throws PortalException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact getAHContact(
        long contactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.getAHContact(contactId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the a h contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @return the range of a h contacts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> getAHContacts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.getAHContacts(start, end);
    }

    /**
    * Returns the number of a h contacts.
    *
    * @return the number of a h contacts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getAHContactsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.getAHContactsCount();
    }

    /**
    * Updates the a h contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param ahContact the a h contact
    * @return the a h contact that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact updateAHContact(
        de.fraunhofer.fokus.oefit.particity.model.AHContact ahContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ahContactLocalService.updateAHContact(ahContact);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ahContactLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ahContactLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ahContactLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHContact addContact(
        java.lang.String forename, java.lang.String surname,
        java.lang.String phone, java.lang.String fax, java.lang.String mail,
        java.lang.String web) {
        return _ahContactLocalService.addContact(forename, surname, phone, fax,
            mail, web);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> getByMail(
        java.lang.String mail) {
        return _ahContactLocalService.getByMail(mail);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> getByName(
        java.lang.String forename, java.lang.String surname) {
        return _ahContactLocalService.getByName(forename, surname);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AHContactLocalService getWrappedAHContactLocalService() {
        return _ahContactLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAHContactLocalService(
        AHContactLocalService ahContactLocalService) {
        _ahContactLocalService = ahContactLocalService;
    }

    @Override
    public AHContactLocalService getWrappedService() {
        return _ahContactLocalService;
    }

    @Override
    public void setWrappedService(AHContactLocalService ahContactLocalService) {
        _ahContactLocalService = ahContactLocalService;
    }
}
