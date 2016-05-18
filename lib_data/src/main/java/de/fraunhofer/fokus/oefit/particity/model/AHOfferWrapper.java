package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AHOffer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOffer
 * @generated
 */
public class AHOfferWrapper implements AHOffer, ModelWrapper<AHOffer> {
    private AHOffer _ahOffer;

    public AHOfferWrapper(AHOffer ahOffer) {
        _ahOffer = ahOffer;
    }

    @Override
    public Class<?> getModelClass() {
        return AHOffer.class;
    }

    @Override
    public String getModelClassName() {
        return AHOffer.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("offerId", getOfferId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("workTime", getWorkTime());
        attributes.put("workType", getWorkType());
        attributes.put("type", getType());
        attributes.put("status", getStatus());
        attributes.put("socialStatus", getSocialStatus());
        attributes.put("created", getCreated());
        attributes.put("updated", getUpdated());
        attributes.put("expires", getExpires());
        attributes.put("publish", getPublish());
        attributes.put("adressId", getAdressId());
        attributes.put("contactId", getContactId());
        attributes.put("sndContactId", getSndContactId());
        attributes.put("contactAgency", getContactAgency());
        attributes.put("orgId", getOrgId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long offerId = (Long) attributes.get("offerId");

        if (offerId != null) {
            setOfferId(offerId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String workTime = (String) attributes.get("workTime");

        if (workTime != null) {
            setWorkTime(workTime);
        }

        Integer workType = (Integer) attributes.get("workType");

        if (workType != null) {
            setWorkType(workType);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Integer socialStatus = (Integer) attributes.get("socialStatus");

        if (socialStatus != null) {
            setSocialStatus(socialStatus);
        }

        Long created = (Long) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }

        Long updated = (Long) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        Long expires = (Long) attributes.get("expires");

        if (expires != null) {
            setExpires(expires);
        }

        Long publish = (Long) attributes.get("publish");

        if (publish != null) {
            setPublish(publish);
        }

        Long adressId = (Long) attributes.get("adressId");

        if (adressId != null) {
            setAdressId(adressId);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Long sndContactId = (Long) attributes.get("sndContactId");

        if (sndContactId != null) {
            setSndContactId(sndContactId);
        }

        Boolean contactAgency = (Boolean) attributes.get("contactAgency");

        if (contactAgency != null) {
            setContactAgency(contactAgency);
        }

        Long orgId = (Long) attributes.get("orgId");

        if (orgId != null) {
            setOrgId(orgId);
        }
    }

    /**
    * Returns the primary key of this a h offer.
    *
    * @return the primary key of this a h offer
    */
    @Override
    public long getPrimaryKey() {
        return _ahOffer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h offer.
    *
    * @param primaryKey the primary key of this a h offer
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahOffer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the offer ID of this a h offer.
    *
    * @return the offer ID of this a h offer
    */
    @Override
    public long getOfferId() {
        return _ahOffer.getOfferId();
    }

    /**
    * Sets the offer ID of this a h offer.
    *
    * @param offerId the offer ID of this a h offer
    */
    @Override
    public void setOfferId(long offerId) {
        _ahOffer.setOfferId(offerId);
    }

    /**
    * Returns the title of this a h offer.
    *
    * @return the title of this a h offer
    */
    @Override
    public java.lang.String getTitle() {
        return _ahOffer.getTitle();
    }

    /**
    * Sets the title of this a h offer.
    *
    * @param title the title of this a h offer
    */
    @Override
    public void setTitle(java.lang.String title) {
        _ahOffer.setTitle(title);
    }

    /**
    * Returns the description of this a h offer.
    *
    * @return the description of this a h offer
    */
    @Override
    public java.lang.String getDescription() {
        return _ahOffer.getDescription();
    }

    /**
    * Sets the description of this a h offer.
    *
    * @param description the description of this a h offer
    */
    @Override
    public void setDescription(java.lang.String description) {
        _ahOffer.setDescription(description);
    }

    /**
    * Returns the work time of this a h offer.
    *
    * @return the work time of this a h offer
    */
    @Override
    public java.lang.String getWorkTime() {
        return _ahOffer.getWorkTime();
    }

    /**
    * Sets the work time of this a h offer.
    *
    * @param workTime the work time of this a h offer
    */
    @Override
    public void setWorkTime(java.lang.String workTime) {
        _ahOffer.setWorkTime(workTime);
    }

    /**
    * Returns the work type of this a h offer.
    *
    * @return the work type of this a h offer
    */
    @Override
    public int getWorkType() {
        return _ahOffer.getWorkType();
    }

    /**
    * Sets the work type of this a h offer.
    *
    * @param workType the work type of this a h offer
    */
    @Override
    public void setWorkType(int workType) {
        _ahOffer.setWorkType(workType);
    }

    /**
    * Returns the type of this a h offer.
    *
    * @return the type of this a h offer
    */
    @Override
    public int getType() {
        return _ahOffer.getType();
    }

    /**
    * Sets the type of this a h offer.
    *
    * @param type the type of this a h offer
    */
    @Override
    public void setType(int type) {
        _ahOffer.setType(type);
    }

    /**
    * Returns the status of this a h offer.
    *
    * @return the status of this a h offer
    */
    @Override
    public int getStatus() {
        return _ahOffer.getStatus();
    }

    /**
    * Sets the status of this a h offer.
    *
    * @param status the status of this a h offer
    */
    @Override
    public void setStatus(int status) {
        _ahOffer.setStatus(status);
    }

    /**
    * Returns the social status of this a h offer.
    *
    * @return the social status of this a h offer
    */
    @Override
    public int getSocialStatus() {
        return _ahOffer.getSocialStatus();
    }

    /**
    * Sets the social status of this a h offer.
    *
    * @param socialStatus the social status of this a h offer
    */
    @Override
    public void setSocialStatus(int socialStatus) {
        _ahOffer.setSocialStatus(socialStatus);
    }

    /**
    * Returns the created of this a h offer.
    *
    * @return the created of this a h offer
    */
    @Override
    public long getCreated() {
        return _ahOffer.getCreated();
    }

    /**
    * Sets the created of this a h offer.
    *
    * @param created the created of this a h offer
    */
    @Override
    public void setCreated(long created) {
        _ahOffer.setCreated(created);
    }

    /**
    * Returns the updated of this a h offer.
    *
    * @return the updated of this a h offer
    */
    @Override
    public long getUpdated() {
        return _ahOffer.getUpdated();
    }

    /**
    * Sets the updated of this a h offer.
    *
    * @param updated the updated of this a h offer
    */
    @Override
    public void setUpdated(long updated) {
        _ahOffer.setUpdated(updated);
    }

    /**
    * Returns the expires of this a h offer.
    *
    * @return the expires of this a h offer
    */
    @Override
    public long getExpires() {
        return _ahOffer.getExpires();
    }

    /**
    * Sets the expires of this a h offer.
    *
    * @param expires the expires of this a h offer
    */
    @Override
    public void setExpires(long expires) {
        _ahOffer.setExpires(expires);
    }

    /**
    * Returns the publish of this a h offer.
    *
    * @return the publish of this a h offer
    */
    @Override
    public long getPublish() {
        return _ahOffer.getPublish();
    }

    /**
    * Sets the publish of this a h offer.
    *
    * @param publish the publish of this a h offer
    */
    @Override
    public void setPublish(long publish) {
        _ahOffer.setPublish(publish);
    }

    /**
    * Returns the adress ID of this a h offer.
    *
    * @return the adress ID of this a h offer
    */
    @Override
    public long getAdressId() {
        return _ahOffer.getAdressId();
    }

    /**
    * Sets the adress ID of this a h offer.
    *
    * @param adressId the adress ID of this a h offer
    */
    @Override
    public void setAdressId(long adressId) {
        _ahOffer.setAdressId(adressId);
    }

    /**
    * Returns the contact ID of this a h offer.
    *
    * @return the contact ID of this a h offer
    */
    @Override
    public long getContactId() {
        return _ahOffer.getContactId();
    }

    /**
    * Sets the contact ID of this a h offer.
    *
    * @param contactId the contact ID of this a h offer
    */
    @Override
    public void setContactId(long contactId) {
        _ahOffer.setContactId(contactId);
    }

    /**
    * Returns the snd contact ID of this a h offer.
    *
    * @return the snd contact ID of this a h offer
    */
    @Override
    public long getSndContactId() {
        return _ahOffer.getSndContactId();
    }

    /**
    * Sets the snd contact ID of this a h offer.
    *
    * @param sndContactId the snd contact ID of this a h offer
    */
    @Override
    public void setSndContactId(long sndContactId) {
        _ahOffer.setSndContactId(sndContactId);
    }

    /**
    * Returns the contact agency of this a h offer.
    *
    * @return the contact agency of this a h offer
    */
    @Override
    public boolean getContactAgency() {
        return _ahOffer.getContactAgency();
    }

    /**
    * Returns <code>true</code> if this a h offer is contact agency.
    *
    * @return <code>true</code> if this a h offer is contact agency; <code>false</code> otherwise
    */
    @Override
    public boolean isContactAgency() {
        return _ahOffer.isContactAgency();
    }

    /**
    * Sets whether this a h offer is contact agency.
    *
    * @param contactAgency the contact agency of this a h offer
    */
    @Override
    public void setContactAgency(boolean contactAgency) {
        _ahOffer.setContactAgency(contactAgency);
    }

    /**
    * Returns the org ID of this a h offer.
    *
    * @return the org ID of this a h offer
    */
    @Override
    public long getOrgId() {
        return _ahOffer.getOrgId();
    }

    /**
    * Sets the org ID of this a h offer.
    *
    * @param orgId the org ID of this a h offer
    */
    @Override
    public void setOrgId(long orgId) {
        _ahOffer.setOrgId(orgId);
    }

    @Override
    public boolean isNew() {
        return _ahOffer.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahOffer.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahOffer.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahOffer.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahOffer.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahOffer.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahOffer.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahOffer.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahOffer.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahOffer.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahOffer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHOfferWrapper((AHOffer) _ahOffer.clone());
    }

    @Override
    public int compareTo(AHOffer ahOffer) {
        return _ahOffer.compareTo(ahOffer);
    }

    @Override
    public int hashCode() {
        return _ahOffer.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<AHOffer> toCacheModel() {
        return _ahOffer.toCacheModel();
    }

    @Override
    public AHOffer toEscapedModel() {
        return new AHOfferWrapper(_ahOffer.toEscapedModel());
    }

    @Override
    public AHOffer toUnescapedModel() {
        return new AHOfferWrapper(_ahOffer.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahOffer.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahOffer.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahOffer.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHOfferWrapper)) {
            return false;
        }

        AHOfferWrapper ahOfferWrapper = (AHOfferWrapper) obj;

        if (Validator.equals(_ahOffer, ahOfferWrapper._ahOffer)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHOffer getWrappedAHOffer() {
        return _ahOffer;
    }

    @Override
    public AHOffer getWrappedModel() {
        return _ahOffer;
    }

    @Override
    public void resetOriginalValues() {
        _ahOffer.resetOriginalValues();
    }
}
