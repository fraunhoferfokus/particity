package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AHOrg}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOrg
 * @generated
 */
public class AHOrgWrapper implements AHOrg, ModelWrapper<AHOrg> {
    private AHOrg _ahOrg;

    public AHOrgWrapper(AHOrg ahOrg) {
        _ahOrg = ahOrg;
    }

    @Override
    public Class<?> getModelClass() {
        return AHOrg.class;
    }

    @Override
    public String getModelClassName() {
        return AHOrg.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("orgId", getOrgId());
        attributes.put("name", getName());
        attributes.put("holder", getHolder());
        attributes.put("owner", getOwner());
        attributes.put("userlist", getUserlist());
        attributes.put("description", getDescription());
        attributes.put("legalStatus", getLegalStatus());
        attributes.put("created", getCreated());
        attributes.put("updated", getUpdated());
        attributes.put("contactId", getContactId());
        attributes.put("addressId", getAddressId());
        attributes.put("status", getStatus());
        attributes.put("logoLocation", getLogoLocation());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long orgId = (Long) attributes.get("orgId");

        if (orgId != null) {
            setOrgId(orgId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String holder = (String) attributes.get("holder");

        if (holder != null) {
            setHolder(holder);
        }

        String owner = (String) attributes.get("owner");

        if (owner != null) {
            setOwner(owner);
        }

        String userlist = (String) attributes.get("userlist");

        if (userlist != null) {
            setUserlist(userlist);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String legalStatus = (String) attributes.get("legalStatus");

        if (legalStatus != null) {
            setLegalStatus(legalStatus);
        }

        Long created = (Long) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }

        Long updated = (Long) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Long addressId = (Long) attributes.get("addressId");

        if (addressId != null) {
            setAddressId(addressId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String logoLocation = (String) attributes.get("logoLocation");

        if (logoLocation != null) {
            setLogoLocation(logoLocation);
        }
    }

    /**
    * Returns the primary key of this a h org.
    *
    * @return the primary key of this a h org
    */
    @Override
    public long getPrimaryKey() {
        return _ahOrg.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h org.
    *
    * @param primaryKey the primary key of this a h org
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahOrg.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the org ID of this a h org.
    *
    * @return the org ID of this a h org
    */
    @Override
    public long getOrgId() {
        return _ahOrg.getOrgId();
    }

    /**
    * Sets the org ID of this a h org.
    *
    * @param orgId the org ID of this a h org
    */
    @Override
    public void setOrgId(long orgId) {
        _ahOrg.setOrgId(orgId);
    }

    /**
    * Returns the name of this a h org.
    *
    * @return the name of this a h org
    */
    @Override
    public java.lang.String getName() {
        return _ahOrg.getName();
    }

    /**
    * Sets the name of this a h org.
    *
    * @param name the name of this a h org
    */
    @Override
    public void setName(java.lang.String name) {
        _ahOrg.setName(name);
    }

    /**
    * Returns the holder of this a h org.
    *
    * @return the holder of this a h org
    */
    @Override
    public java.lang.String getHolder() {
        return _ahOrg.getHolder();
    }

    /**
    * Sets the holder of this a h org.
    *
    * @param holder the holder of this a h org
    */
    @Override
    public void setHolder(java.lang.String holder) {
        _ahOrg.setHolder(holder);
    }

    /**
    * Returns the owner of this a h org.
    *
    * @return the owner of this a h org
    */
    @Override
    public java.lang.String getOwner() {
        return _ahOrg.getOwner();
    }

    /**
    * Sets the owner of this a h org.
    *
    * @param owner the owner of this a h org
    */
    @Override
    public void setOwner(java.lang.String owner) {
        _ahOrg.setOwner(owner);
    }

    /**
    * Returns the userlist of this a h org.
    *
    * @return the userlist of this a h org
    */
    @Override
    public java.lang.String getUserlist() {
        return _ahOrg.getUserlist();
    }

    /**
    * Sets the userlist of this a h org.
    *
    * @param userlist the userlist of this a h org
    */
    @Override
    public void setUserlist(java.lang.String userlist) {
        _ahOrg.setUserlist(userlist);
    }

    /**
    * Returns the description of this a h org.
    *
    * @return the description of this a h org
    */
    @Override
    public java.lang.String getDescription() {
        return _ahOrg.getDescription();
    }

    /**
    * Sets the description of this a h org.
    *
    * @param description the description of this a h org
    */
    @Override
    public void setDescription(java.lang.String description) {
        _ahOrg.setDescription(description);
    }

    /**
    * Returns the legal status of this a h org.
    *
    * @return the legal status of this a h org
    */
    @Override
    public java.lang.String getLegalStatus() {
        return _ahOrg.getLegalStatus();
    }

    /**
    * Sets the legal status of this a h org.
    *
    * @param legalStatus the legal status of this a h org
    */
    @Override
    public void setLegalStatus(java.lang.String legalStatus) {
        _ahOrg.setLegalStatus(legalStatus);
    }

    /**
    * Returns the created of this a h org.
    *
    * @return the created of this a h org
    */
    @Override
    public long getCreated() {
        return _ahOrg.getCreated();
    }

    /**
    * Sets the created of this a h org.
    *
    * @param created the created of this a h org
    */
    @Override
    public void setCreated(long created) {
        _ahOrg.setCreated(created);
    }

    /**
    * Returns the updated of this a h org.
    *
    * @return the updated of this a h org
    */
    @Override
    public long getUpdated() {
        return _ahOrg.getUpdated();
    }

    /**
    * Sets the updated of this a h org.
    *
    * @param updated the updated of this a h org
    */
    @Override
    public void setUpdated(long updated) {
        _ahOrg.setUpdated(updated);
    }

    /**
    * Returns the contact ID of this a h org.
    *
    * @return the contact ID of this a h org
    */
    @Override
    public long getContactId() {
        return _ahOrg.getContactId();
    }

    /**
    * Sets the contact ID of this a h org.
    *
    * @param contactId the contact ID of this a h org
    */
    @Override
    public void setContactId(long contactId) {
        _ahOrg.setContactId(contactId);
    }

    /**
    * Returns the address ID of this a h org.
    *
    * @return the address ID of this a h org
    */
    @Override
    public long getAddressId() {
        return _ahOrg.getAddressId();
    }

    /**
    * Sets the address ID of this a h org.
    *
    * @param addressId the address ID of this a h org
    */
    @Override
    public void setAddressId(long addressId) {
        _ahOrg.setAddressId(addressId);
    }

    /**
    * Returns the status of this a h org.
    *
    * @return the status of this a h org
    */
    @Override
    public int getStatus() {
        return _ahOrg.getStatus();
    }

    /**
    * Sets the status of this a h org.
    *
    * @param status the status of this a h org
    */
    @Override
    public void setStatus(int status) {
        _ahOrg.setStatus(status);
    }

    /**
    * Returns the logo location of this a h org.
    *
    * @return the logo location of this a h org
    */
    @Override
    public java.lang.String getLogoLocation() {
        return _ahOrg.getLogoLocation();
    }

    /**
    * Sets the logo location of this a h org.
    *
    * @param logoLocation the logo location of this a h org
    */
    @Override
    public void setLogoLocation(java.lang.String logoLocation) {
        _ahOrg.setLogoLocation(logoLocation);
    }

    @Override
    public boolean isNew() {
        return _ahOrg.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahOrg.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahOrg.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahOrg.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahOrg.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahOrg.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahOrg.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahOrg.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahOrg.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahOrg.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahOrg.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHOrgWrapper((AHOrg) _ahOrg.clone());
    }

    @Override
    public int compareTo(AHOrg ahOrg) {
        return _ahOrg.compareTo(ahOrg);
    }

    @Override
    public int hashCode() {
        return _ahOrg.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<AHOrg> toCacheModel() {
        return _ahOrg.toCacheModel();
    }

    @Override
    public AHOrg toEscapedModel() {
        return new AHOrgWrapper(_ahOrg.toEscapedModel());
    }

    @Override
    public AHOrg toUnescapedModel() {
        return new AHOrgWrapper(_ahOrg.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahOrg.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahOrg.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOrg.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHOrgWrapper)) {
            return false;
        }

        AHOrgWrapper ahOrgWrapper = (AHOrgWrapper) obj;

        if (Validator.equals(_ahOrg, ahOrgWrapper._ahOrg)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHOrg getWrappedAHOrg() {
        return _ahOrg;
    }

    @Override
    public AHOrg getWrappedModel() {
        return _ahOrg;
    }

    @Override
    public void resetOriginalValues() {
        _ahOrg.resetOriginalValues();
    }
}
