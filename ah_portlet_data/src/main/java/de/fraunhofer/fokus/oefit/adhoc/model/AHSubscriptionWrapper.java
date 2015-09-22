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
package de.fraunhofer.fokus.oefit.adhoc.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AHSubscription}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscription
 * @generated
 */
public class AHSubscriptionWrapper implements AHSubscription,
    ModelWrapper<AHSubscription> {
    private AHSubscription _ahSubscription;

    public AHSubscriptionWrapper(AHSubscription ahSubscription) {
        _ahSubscription = ahSubscription;
    }

    @Override
    public Class<?> getModelClass() {
        return AHSubscription.class;
    }

    @Override
    public String getModelClassName() {
        return AHSubscription.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subId", getSubId());
        attributes.put("uuid", getUuid());
        attributes.put("email", getEmail());
        attributes.put("status", getStatus());
        attributes.put("created", getCreated());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long subId = (Long) attributes.get("subId");

        if (subId != null) {
            setSubId(subId);
        }

        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long created = (Long) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }
    }

    /**
    * Returns the primary key of this a h subscription.
    *
    * @return the primary key of this a h subscription
    */
    @Override
    public long getPrimaryKey() {
        return _ahSubscription.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h subscription.
    *
    * @param primaryKey the primary key of this a h subscription
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahSubscription.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the sub ID of this a h subscription.
    *
    * @return the sub ID of this a h subscription
    */
    @Override
    public long getSubId() {
        return _ahSubscription.getSubId();
    }

    /**
    * Sets the sub ID of this a h subscription.
    *
    * @param subId the sub ID of this a h subscription
    */
    @Override
    public void setSubId(long subId) {
        _ahSubscription.setSubId(subId);
    }

    /**
    * Returns the uuid of this a h subscription.
    *
    * @return the uuid of this a h subscription
    */
    @Override
    public java.lang.String getUuid() {
        return _ahSubscription.getUuid();
    }

    /**
    * Sets the uuid of this a h subscription.
    *
    * @param uuid the uuid of this a h subscription
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _ahSubscription.setUuid(uuid);
    }

    /**
    * Returns the email of this a h subscription.
    *
    * @return the email of this a h subscription
    */
    @Override
    public java.lang.String getEmail() {
        return _ahSubscription.getEmail();
    }

    /**
    * Sets the email of this a h subscription.
    *
    * @param email the email of this a h subscription
    */
    @Override
    public void setEmail(java.lang.String email) {
        _ahSubscription.setEmail(email);
    }

    /**
    * Returns the status of this a h subscription.
    *
    * @return the status of this a h subscription
    */
    @Override
    public int getStatus() {
        return _ahSubscription.getStatus();
    }

    /**
    * Sets the status of this a h subscription.
    *
    * @param status the status of this a h subscription
    */
    @Override
    public void setStatus(int status) {
        _ahSubscription.setStatus(status);
    }

    /**
    * Returns the created of this a h subscription.
    *
    * @return the created of this a h subscription
    */
    @Override
    public long getCreated() {
        return _ahSubscription.getCreated();
    }

    /**
    * Sets the created of this a h subscription.
    *
    * @param created the created of this a h subscription
    */
    @Override
    public void setCreated(long created) {
        _ahSubscription.setCreated(created);
    }

    @Override
    public boolean isNew() {
        return _ahSubscription.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahSubscription.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahSubscription.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahSubscription.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahSubscription.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahSubscription.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahSubscription.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahSubscription.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahSubscription.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahSubscription.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahSubscription.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHSubscriptionWrapper((AHSubscription) _ahSubscription.clone());
    }

    @Override
    public int compareTo(
        de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription ahSubscription) {
        return _ahSubscription.compareTo(ahSubscription);
    }

    @Override
    public int hashCode() {
        return _ahSubscription.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> toCacheModel() {
        return _ahSubscription.toCacheModel();
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription toEscapedModel() {
        return new AHSubscriptionWrapper(_ahSubscription.toEscapedModel());
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription toUnescapedModel() {
        return new AHSubscriptionWrapper(_ahSubscription.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahSubscription.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahSubscription.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahSubscription.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHSubscriptionWrapper)) {
            return false;
        }

        AHSubscriptionWrapper ahSubscriptionWrapper = (AHSubscriptionWrapper) obj;

        if (Validator.equals(_ahSubscription,
                    ahSubscriptionWrapper._ahSubscription)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHSubscription getWrappedAHSubscription() {
        return _ahSubscription;
    }

    @Override
    public AHSubscription getWrappedModel() {
        return _ahSubscription;
    }

    @Override
    public void resetOriginalValues() {
        _ahSubscription.resetOriginalValues();
    }
}
