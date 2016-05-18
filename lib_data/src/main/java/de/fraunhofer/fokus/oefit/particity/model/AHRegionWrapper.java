package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AHRegion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHRegion
 * @generated
 */
public class AHRegionWrapper implements AHRegion, ModelWrapper<AHRegion> {
    private AHRegion _ahRegion;

    public AHRegionWrapper(AHRegion ahRegion) {
        _ahRegion = ahRegion;
    }

    @Override
    public Class<?> getModelClass() {
        return AHRegion.class;
    }

    @Override
    public String getModelClassName() {
        return AHRegion.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("regionId", getRegionId());
        attributes.put("zip", getZip());
        attributes.put("city", getCity());
        attributes.put("country", getCountry());
        attributes.put("permissions", getPermissions());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
        }

        String zip = (String) attributes.get("zip");

        if (zip != null) {
            setZip(zip);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        Integer permissions = (Integer) attributes.get("permissions");

        if (permissions != null) {
            setPermissions(permissions);
        }
    }

    /**
    * Returns the primary key of this a h region.
    *
    * @return the primary key of this a h region
    */
    @Override
    public de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK getPrimaryKey() {
        return _ahRegion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h region.
    *
    * @param primaryKey the primary key of this a h region
    */
    @Override
    public void setPrimaryKey(
        de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK primaryKey) {
        _ahRegion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the region ID of this a h region.
    *
    * @return the region ID of this a h region
    */
    @Override
    public long getRegionId() {
        return _ahRegion.getRegionId();
    }

    /**
    * Sets the region ID of this a h region.
    *
    * @param regionId the region ID of this a h region
    */
    @Override
    public void setRegionId(long regionId) {
        _ahRegion.setRegionId(regionId);
    }

    /**
    * Returns the zip of this a h region.
    *
    * @return the zip of this a h region
    */
    @Override
    public java.lang.String getZip() {
        return _ahRegion.getZip();
    }

    /**
    * Sets the zip of this a h region.
    *
    * @param zip the zip of this a h region
    */
    @Override
    public void setZip(java.lang.String zip) {
        _ahRegion.setZip(zip);
    }

    /**
    * Returns the city of this a h region.
    *
    * @return the city of this a h region
    */
    @Override
    public java.lang.String getCity() {
        return _ahRegion.getCity();
    }

    /**
    * Sets the city of this a h region.
    *
    * @param city the city of this a h region
    */
    @Override
    public void setCity(java.lang.String city) {
        _ahRegion.setCity(city);
    }

    /**
    * Returns the country of this a h region.
    *
    * @return the country of this a h region
    */
    @Override
    public java.lang.String getCountry() {
        return _ahRegion.getCountry();
    }

    /**
    * Sets the country of this a h region.
    *
    * @param country the country of this a h region
    */
    @Override
    public void setCountry(java.lang.String country) {
        _ahRegion.setCountry(country);
    }

    /**
    * Returns the permissions of this a h region.
    *
    * @return the permissions of this a h region
    */
    @Override
    public int getPermissions() {
        return _ahRegion.getPermissions();
    }

    /**
    * Sets the permissions of this a h region.
    *
    * @param permissions the permissions of this a h region
    */
    @Override
    public void setPermissions(int permissions) {
        _ahRegion.setPermissions(permissions);
    }

    @Override
    public boolean isNew() {
        return _ahRegion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahRegion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahRegion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahRegion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahRegion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahRegion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahRegion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahRegion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahRegion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahRegion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahRegion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHRegionWrapper((AHRegion) _ahRegion.clone());
    }

    @Override
    public int compareTo(AHRegion ahRegion) {
        return _ahRegion.compareTo(ahRegion);
    }

    @Override
    public int hashCode() {
        return _ahRegion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<AHRegion> toCacheModel() {
        return _ahRegion.toCacheModel();
    }

    @Override
    public AHRegion toEscapedModel() {
        return new AHRegionWrapper(_ahRegion.toEscapedModel());
    }

    @Override
    public AHRegion toUnescapedModel() {
        return new AHRegionWrapper(_ahRegion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahRegion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahRegion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahRegion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHRegionWrapper)) {
            return false;
        }

        AHRegionWrapper ahRegionWrapper = (AHRegionWrapper) obj;

        if (Validator.equals(_ahRegion, ahRegionWrapper._ahRegion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHRegion getWrappedAHRegion() {
        return _ahRegion;
    }

    @Override
    public AHRegion getWrappedModel() {
        return _ahRegion;
    }

    @Override
    public void resetOriginalValues() {
        _ahRegion.resetOriginalValues();
    }
}
