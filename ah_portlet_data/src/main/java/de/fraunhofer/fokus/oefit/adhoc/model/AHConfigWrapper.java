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
 * This class is a wrapper for {@link AHConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHConfig
 * @generated
 */
public class AHConfigWrapper implements AHConfig, ModelWrapper<AHConfig> {
    private AHConfig _ahConfig;

    public AHConfigWrapper(AHConfig ahConfig) {
        _ahConfig = ahConfig;
    }

    @Override
    public Class<?> getModelClass() {
        return AHConfig.class;
    }

    @Override
    public String getModelClassName() {
        return AHConfig.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("name", getName());
        attributes.put("value", getValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }
    }

    /**
    * Returns the primary key of this a h config.
    *
    * @return the primary key of this a h config
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _ahConfig.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h config.
    *
    * @param primaryKey the primary key of this a h config
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _ahConfig.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the name of this a h config.
    *
    * @return the name of this a h config
    */
    @Override
    public java.lang.String getName() {
        return _ahConfig.getName();
    }

    /**
    * Sets the name of this a h config.
    *
    * @param name the name of this a h config
    */
    @Override
    public void setName(java.lang.String name) {
        _ahConfig.setName(name);
    }

    /**
    * Returns the value of this a h config.
    *
    * @return the value of this a h config
    */
    @Override
    public java.lang.String getValue() {
        return _ahConfig.getValue();
    }

    /**
    * Sets the value of this a h config.
    *
    * @param value the value of this a h config
    */
    @Override
    public void setValue(java.lang.String value) {
        _ahConfig.setValue(value);
    }

    @Override
    public boolean isNew() {
        return _ahConfig.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahConfig.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahConfig.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahConfig.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahConfig.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahConfig.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahConfig.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahConfig.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahConfig.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahConfig.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahConfig.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHConfigWrapper((AHConfig) _ahConfig.clone());
    }

    @Override
    public int compareTo(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig) {
        return _ahConfig.compareTo(ahConfig);
    }

    @Override
    public int hashCode() {
        return _ahConfig.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.fraunhofer.fokus.oefit.adhoc.model.AHConfig> toCacheModel() {
        return _ahConfig.toCacheModel();
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig toEscapedModel() {
        return new AHConfigWrapper(_ahConfig.toEscapedModel());
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig toUnescapedModel() {
        return new AHConfigWrapper(_ahConfig.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahConfig.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahConfig.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahConfig.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHConfigWrapper)) {
            return false;
        }

        AHConfigWrapper ahConfigWrapper = (AHConfigWrapper) obj;

        if (Validator.equals(_ahConfig, ahConfigWrapper._ahConfig)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHConfig getWrappedAHConfig() {
        return _ahConfig;
    }

    @Override
    public AHConfig getWrappedModel() {
        return _ahConfig;
    }

    @Override
    public void resetOriginalValues() {
        _ahConfig.resetOriginalValues();
    }
}
