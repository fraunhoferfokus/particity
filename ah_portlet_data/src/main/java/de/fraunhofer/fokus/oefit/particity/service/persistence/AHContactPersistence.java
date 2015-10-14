package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.oefit.particity.model.AHContact;

/**
 * The persistence interface for the a h contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHContactPersistenceImpl
 * @see AHContactUtil
 * @generated
 */
public interface AHContactPersistence extends BasePersistence<AHContact> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHContactUtil} to access the a h contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the a h contacts where email = &#63;.
    *
    * @param email the email
    * @return the matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findByemail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h contacts where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @return the range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findByemail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h contacts where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findByemail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact findByemail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Returns the first a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact, or <code>null</code> if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact fetchByemail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact findByemail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Returns the last a h contact in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact, or <code>null</code> if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact fetchByemail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h contacts before and after the current a h contact in the ordered set where email = &#63;.
    *
    * @param contactId the primary key of the current a h contact
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact[] findByemail_PrevAndNext(
        long contactId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Removes all the a h contacts where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public void removeByemail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h contacts where email = &#63;.
    *
    * @param email the email
    * @return the number of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByemail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h contacts where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @return the matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findByname(
        java.lang.String forename, java.lang.String surname)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the a h contacts where forename = &#63; and surname = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param forename the forename
    * @param surname the surname
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @return the range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findByname(
        java.lang.String forename, java.lang.String surname, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h contacts where forename = &#63; and surname = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param forename the forename
    * @param surname the surname
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findByname(
        java.lang.String forename, java.lang.String surname, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact findByname_First(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Returns the first a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching a h contact, or <code>null</code> if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact fetchByname_First(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact findByname_Last(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Returns the last a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching a h contact, or <code>null</code> if a matching a h contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact fetchByname_Last(
        java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h contacts before and after the current a h contact in the ordered set where forename = &#63; and surname = &#63;.
    *
    * @param contactId the primary key of the current a h contact
    * @param forename the forename
    * @param surname the surname
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact[] findByname_PrevAndNext(
        long contactId, java.lang.String forename, java.lang.String surname,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Removes all the a h contacts where forename = &#63; and surname = &#63; from the database.
    *
    * @param forename the forename
    * @param surname the surname
    * @throws SystemException if a system exception occurred
    */
    public void removeByname(java.lang.String forename, java.lang.String surname)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h contacts where forename = &#63; and surname = &#63;.
    *
    * @param forename the forename
    * @param surname the surname
    * @return the number of matching a h contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByname(java.lang.String forename, java.lang.String surname)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the a h contact in the entity cache if it is enabled.
    *
    * @param ahContact the a h contact
    */
    public void cacheResult(
        de.fraunhofer.fokus.oefit.particity.model.AHContact ahContact);

    /**
    * Caches the a h contacts in the entity cache if it is enabled.
    *
    * @param ahContacts the a h contacts
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> ahContacts);

    /**
    * Creates a new a h contact with the primary key. Does not add the a h contact to the database.
    *
    * @param contactId the primary key for the new a h contact
    * @return the new a h contact
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact create(
        long contactId);

    /**
    * Removes the a h contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact that was removed
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact remove(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    public de.fraunhofer.fokus.oefit.particity.model.AHContact updateImpl(
        de.fraunhofer.fokus.oefit.particity.model.AHContact ahContact)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h contact with the primary key or throws a {@link de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException} if it could not be found.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact
    * @throws de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact findByPrimaryKey(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException;

    /**
    * Returns the a h contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactId the primary key of the a h contact
    * @return the a h contact, or <code>null</code> if a a h contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.particity.model.AHContact fetchByPrimaryKey(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h contacts.
    *
    * @return the a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the a h contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of a h contacts
    * @param end the upper bound of the range of a h contacts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of a h contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHContact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h contacts.
    *
    * @return the number of a h contacts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
