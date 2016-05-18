package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AHContact}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHContact
 * @generated
 */
public class AHContactWrapper implements AHContact, ModelWrapper<AHContact> {
    private AHContact _ahContact;

    public AHContactWrapper(AHContact ahContact) {
        _ahContact = ahContact;
    }

    @Override
    public Class<?> getModelClass() {
        return AHContact.class;
    }

    @Override
    public String getModelClassName() {
        return AHContact.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactId", getContactId());
        attributes.put("forename", getForename());
        attributes.put("surname", getSurname());
        attributes.put("tel", getTel());
        attributes.put("mobile", getMobile());
        attributes.put("fax", getFax());
        attributes.put("email", getEmail());
        attributes.put("www", getWww());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        String forename = (String) attributes.get("forename");

        if (forename != null) {
            setForename(forename);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String tel = (String) attributes.get("tel");

        if (tel != null) {
            setTel(tel);
        }

        String mobile = (String) attributes.get("mobile");

        if (mobile != null) {
            setMobile(mobile);
        }

        String fax = (String) attributes.get("fax");

        if (fax != null) {
            setFax(fax);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String www = (String) attributes.get("www");

        if (www != null) {
            setWww(www);
        }
    }

    /**
    * Returns the primary key of this a h contact.
    *
    * @return the primary key of this a h contact
    */
    @Override
    public long getPrimaryKey() {
        return _ahContact.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h contact.
    *
    * @param primaryKey the primary key of this a h contact
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahContact.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contact ID of this a h contact.
    *
    * @return the contact ID of this a h contact
    */
    @Override
    public long getContactId() {
        return _ahContact.getContactId();
    }

    /**
    * Sets the contact ID of this a h contact.
    *
    * @param contactId the contact ID of this a h contact
    */
    @Override
    public void setContactId(long contactId) {
        _ahContact.setContactId(contactId);
    }

    /**
    * Returns the forename of this a h contact.
    *
    * @return the forename of this a h contact
    */
    @Override
    public java.lang.String getForename() {
        return _ahContact.getForename();
    }

    /**
    * Sets the forename of this a h contact.
    *
    * @param forename the forename of this a h contact
    */
    @Override
    public void setForename(java.lang.String forename) {
        _ahContact.setForename(forename);
    }

    /**
    * Returns the surname of this a h contact.
    *
    * @return the surname of this a h contact
    */
    @Override
    public java.lang.String getSurname() {
        return _ahContact.getSurname();
    }

    /**
    * Sets the surname of this a h contact.
    *
    * @param surname the surname of this a h contact
    */
    @Override
    public void setSurname(java.lang.String surname) {
        _ahContact.setSurname(surname);
    }

    /**
    * Returns the tel of this a h contact.
    *
    * @return the tel of this a h contact
    */
    @Override
    public java.lang.String getTel() {
        return _ahContact.getTel();
    }

    /**
    * Sets the tel of this a h contact.
    *
    * @param tel the tel of this a h contact
    */
    @Override
    public void setTel(java.lang.String tel) {
        _ahContact.setTel(tel);
    }

    /**
    * Returns the mobile of this a h contact.
    *
    * @return the mobile of this a h contact
    */
    @Override
    public java.lang.String getMobile() {
        return _ahContact.getMobile();
    }

    /**
    * Sets the mobile of this a h contact.
    *
    * @param mobile the mobile of this a h contact
    */
    @Override
    public void setMobile(java.lang.String mobile) {
        _ahContact.setMobile(mobile);
    }

    /**
    * Returns the fax of this a h contact.
    *
    * @return the fax of this a h contact
    */
    @Override
    public java.lang.String getFax() {
        return _ahContact.getFax();
    }

    /**
    * Sets the fax of this a h contact.
    *
    * @param fax the fax of this a h contact
    */
    @Override
    public void setFax(java.lang.String fax) {
        _ahContact.setFax(fax);
    }

    /**
    * Returns the email of this a h contact.
    *
    * @return the email of this a h contact
    */
    @Override
    public java.lang.String getEmail() {
        return _ahContact.getEmail();
    }

    /**
    * Sets the email of this a h contact.
    *
    * @param email the email of this a h contact
    */
    @Override
    public void setEmail(java.lang.String email) {
        _ahContact.setEmail(email);
    }

    /**
    * Returns the www of this a h contact.
    *
    * @return the www of this a h contact
    */
    @Override
    public java.lang.String getWww() {
        return _ahContact.getWww();
    }

    /**
    * Sets the www of this a h contact.
    *
    * @param www the www of this a h contact
    */
    @Override
    public void setWww(java.lang.String www) {
        _ahContact.setWww(www);
    }

    @Override
    public boolean isNew() {
        return _ahContact.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahContact.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahContact.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahContact.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahContact.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahContact.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahContact.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahContact.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahContact.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahContact.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahContact.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHContactWrapper((AHContact) _ahContact.clone());
    }

    @Override
    public int compareTo(AHContact ahContact) {
        return _ahContact.compareTo(ahContact);
    }

    @Override
    public int hashCode() {
        return _ahContact.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<AHContact> toCacheModel() {
        return _ahContact.toCacheModel();
    }

    @Override
    public AHContact toEscapedModel() {
        return new AHContactWrapper(_ahContact.toEscapedModel());
    }

    @Override
    public AHContact toUnescapedModel() {
        return new AHContactWrapper(_ahContact.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahContact.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahContact.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahContact.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHContactWrapper)) {
            return false;
        }

        AHContactWrapper ahContactWrapper = (AHContactWrapper) obj;

        if (Validator.equals(_ahContact, ahContactWrapper._ahContact)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHContact getWrappedAHContact() {
        return _ahContact;
    }

    @Override
    public AHContact getWrappedModel() {
        return _ahContact;
    }

    @Override
    public void resetOriginalValues() {
        _ahContact.resetOriginalValues();
    }
}
