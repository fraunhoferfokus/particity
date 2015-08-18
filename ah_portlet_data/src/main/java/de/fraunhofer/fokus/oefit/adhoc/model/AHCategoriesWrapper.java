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
 * This class is a wrapper for {@link AHCategories}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCategories
 * @generated
 */
public class AHCategoriesWrapper implements AHCategories,
    ModelWrapper<AHCategories> {
    private AHCategories _ahCategories;

    public AHCategoriesWrapper(AHCategories ahCategories) {
        _ahCategories = ahCategories;
    }

    @Override
    public Class<?> getModelClass() {
        return AHCategories.class;
    }

    @Override
    public String getModelClassName() {
        return AHCategories.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("catId", getCatId());
        attributes.put("name", getName());
        attributes.put("descr", getDescr());
        attributes.put("type", getType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long catId = (Long) attributes.get("catId");

        if (catId != null) {
            setCatId(catId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String descr = (String) attributes.get("descr");

        if (descr != null) {
            setDescr(descr);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }
    }

    /**
    * Returns the primary key of this a h categories.
    *
    * @return the primary key of this a h categories
    */
    @Override
    public long getPrimaryKey() {
        return _ahCategories.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h categories.
    *
    * @param primaryKey the primary key of this a h categories
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahCategories.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the cat ID of this a h categories.
    *
    * @return the cat ID of this a h categories
    */
    @Override
    public long getCatId() {
        return _ahCategories.getCatId();
    }

    /**
    * Sets the cat ID of this a h categories.
    *
    * @param catId the cat ID of this a h categories
    */
    @Override
    public void setCatId(long catId) {
        _ahCategories.setCatId(catId);
    }

    /**
    * Returns the name of this a h categories.
    *
    * @return the name of this a h categories
    */
    @Override
    public java.lang.String getName() {
        return _ahCategories.getName();
    }

    /**
    * Sets the name of this a h categories.
    *
    * @param name the name of this a h categories
    */
    @Override
    public void setName(java.lang.String name) {
        _ahCategories.setName(name);
    }

    /**
    * Returns the descr of this a h categories.
    *
    * @return the descr of this a h categories
    */
    @Override
    public java.lang.String getDescr() {
        return _ahCategories.getDescr();
    }

    /**
    * Sets the descr of this a h categories.
    *
    * @param descr the descr of this a h categories
    */
    @Override
    public void setDescr(java.lang.String descr) {
        _ahCategories.setDescr(descr);
    }

    /**
    * Returns the type of this a h categories.
    *
    * @return the type of this a h categories
    */
    @Override
    public int getType() {
        return _ahCategories.getType();
    }

    /**
    * Sets the type of this a h categories.
    *
    * @param type the type of this a h categories
    */
    @Override
    public void setType(int type) {
        _ahCategories.setType(type);
    }

    @Override
    public boolean isNew() {
        return _ahCategories.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahCategories.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahCategories.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahCategories.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahCategories.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahCategories.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahCategories.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahCategories.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahCategories.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahCategories.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahCategories.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHCategoriesWrapper((AHCategories) _ahCategories.clone());
    }

    @Override
    public int compareTo(
        de.fraunhofer.fokus.oefit.adhoc.model.AHCategories ahCategories) {
        return _ahCategories.compareTo(ahCategories);
    }

    @Override
    public int hashCode() {
        return _ahCategories.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> toCacheModel() {
        return _ahCategories.toCacheModel();
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories toEscapedModel() {
        return new AHCategoriesWrapper(_ahCategories.toEscapedModel());
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHCategories toUnescapedModel() {
        return new AHCategoriesWrapper(_ahCategories.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahCategories.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahCategories.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCategories.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHCategoriesWrapper)) {
            return false;
        }

        AHCategoriesWrapper ahCategoriesWrapper = (AHCategoriesWrapper) obj;

        if (Validator.equals(_ahCategories, ahCategoriesWrapper._ahCategories)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHCategories getWrappedAHCategories() {
        return _ahCategories;
    }

    @Override
    public AHCategories getWrappedModel() {
        return _ahCategories;
    }

    @Override
    public void resetOriginalValues() {
        _ahCategories.resetOriginalValues();
    }
}
