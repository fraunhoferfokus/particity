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
 * This class is a wrapper for {@link AHAddr}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHAddr
 * @generated
 */
public class AHAddrWrapper implements AHAddr, ModelWrapper<AHAddr> {
    private AHAddr _ahAddr;

    public AHAddrWrapper(AHAddr ahAddr) {
        _ahAddr = ahAddr;
    }

    @Override
    public Class<?> getModelClass() {
        return AHAddr.class;
    }

    @Override
    public String getModelClassName() {
        return AHAddr.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("addrId", getAddrId());
        attributes.put("street", getStreet());
        attributes.put("number", getNumber());
        attributes.put("coordLat", getCoordLat());
        attributes.put("coordLon", getCoordLon());
        attributes.put("regionId", getRegionId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long addrId = (Long) attributes.get("addrId");

        if (addrId != null) {
            setAddrId(addrId);
        }

        String street = (String) attributes.get("street");

        if (street != null) {
            setStreet(street);
        }

        String number = (String) attributes.get("number");

        if (number != null) {
            setNumber(number);
        }

        String coordLat = (String) attributes.get("coordLat");

        if (coordLat != null) {
            setCoordLat(coordLat);
        }

        String coordLon = (String) attributes.get("coordLon");

        if (coordLon != null) {
            setCoordLon(coordLon);
        }

        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
        }
    }

    /**
    * Returns the primary key of this a h addr.
    *
    * @return the primary key of this a h addr
    */
    @Override
    public long getPrimaryKey() {
        return _ahAddr.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h addr.
    *
    * @param primaryKey the primary key of this a h addr
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahAddr.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the addr ID of this a h addr.
    *
    * @return the addr ID of this a h addr
    */
    @Override
    public long getAddrId() {
        return _ahAddr.getAddrId();
    }

    /**
    * Sets the addr ID of this a h addr.
    *
    * @param addrId the addr ID of this a h addr
    */
    @Override
    public void setAddrId(long addrId) {
        _ahAddr.setAddrId(addrId);
    }

    /**
    * Returns the street of this a h addr.
    *
    * @return the street of this a h addr
    */
    @Override
    public java.lang.String getStreet() {
        return _ahAddr.getStreet();
    }

    /**
    * Sets the street of this a h addr.
    *
    * @param street the street of this a h addr
    */
    @Override
    public void setStreet(java.lang.String street) {
        _ahAddr.setStreet(street);
    }

    /**
    * Returns the number of this a h addr.
    *
    * @return the number of this a h addr
    */
    @Override
    public java.lang.String getNumber() {
        return _ahAddr.getNumber();
    }

    /**
    * Sets the number of this a h addr.
    *
    * @param number the number of this a h addr
    */
    @Override
    public void setNumber(java.lang.String number) {
        _ahAddr.setNumber(number);
    }

    /**
    * Returns the coord lat of this a h addr.
    *
    * @return the coord lat of this a h addr
    */
    @Override
    public java.lang.String getCoordLat() {
        return _ahAddr.getCoordLat();
    }

    /**
    * Sets the coord lat of this a h addr.
    *
    * @param coordLat the coord lat of this a h addr
    */
    @Override
    public void setCoordLat(java.lang.String coordLat) {
        _ahAddr.setCoordLat(coordLat);
    }

    /**
    * Returns the coord lon of this a h addr.
    *
    * @return the coord lon of this a h addr
    */
    @Override
    public java.lang.String getCoordLon() {
        return _ahAddr.getCoordLon();
    }

    /**
    * Sets the coord lon of this a h addr.
    *
    * @param coordLon the coord lon of this a h addr
    */
    @Override
    public void setCoordLon(java.lang.String coordLon) {
        _ahAddr.setCoordLon(coordLon);
    }

    /**
    * Returns the region ID of this a h addr.
    *
    * @return the region ID of this a h addr
    */
    @Override
    public long getRegionId() {
        return _ahAddr.getRegionId();
    }

    /**
    * Sets the region ID of this a h addr.
    *
    * @param regionId the region ID of this a h addr
    */
    @Override
    public void setRegionId(long regionId) {
        _ahAddr.setRegionId(regionId);
    }

    @Override
    public boolean isNew() {
        return _ahAddr.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahAddr.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahAddr.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahAddr.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahAddr.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahAddr.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahAddr.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahAddr.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahAddr.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahAddr.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahAddr.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHAddrWrapper((AHAddr) _ahAddr.clone());
    }

    @Override
    public int compareTo(de.fraunhofer.fokus.oefit.adhoc.model.AHAddr ahAddr) {
        return _ahAddr.compareTo(ahAddr);
    }

    @Override
    public int hashCode() {
        return _ahAddr.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.fraunhofer.fokus.oefit.adhoc.model.AHAddr> toCacheModel() {
        return _ahAddr.toCacheModel();
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHAddr toEscapedModel() {
        return new AHAddrWrapper(_ahAddr.toEscapedModel());
    }

    @Override
    public de.fraunhofer.fokus.oefit.adhoc.model.AHAddr toUnescapedModel() {
        return new AHAddrWrapper(_ahAddr.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahAddr.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahAddr.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahAddr.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHAddrWrapper)) {
            return false;
        }

        AHAddrWrapper ahAddrWrapper = (AHAddrWrapper) obj;

        if (Validator.equals(_ahAddr, ahAddrWrapper._ahAddr)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHAddr getWrappedAHAddr() {
        return _ahAddr;
    }

    @Override
    public AHAddr getWrappedModel() {
        return _ahAddr;
    }

    @Override
    public void resetOriginalValues() {
        _ahAddr.resetOriginalValues();
    }
}
