package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AHCatEntries}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntries
 * @generated
 */
public class AHCatEntriesWrapper implements AHCatEntries,
    ModelWrapper<AHCatEntries> {
    private AHCatEntries _ahCatEntries;

    public AHCatEntriesWrapper(AHCatEntries ahCatEntries) {
        _ahCatEntries = ahCatEntries;
    }

    @Override
    public Class<?> getModelClass() {
        return AHCatEntries.class;
    }

    @Override
    public String getModelClassName() {
        return AHCatEntries.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("itemId", getItemId());
        attributes.put("catId", getCatId());
        attributes.put("name", getName());
        attributes.put("descr", getDescr());
        attributes.put("parentId", getParentId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long itemId = (Long) attributes.get("itemId");

        if (itemId != null) {
            setItemId(itemId);
        }

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

        Long parentId = (Long) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }
    }

    /**
    * Returns the primary key of this a h cat entries.
    *
    * @return the primary key of this a h cat entries
    */
    @Override
    public long getPrimaryKey() {
        return _ahCatEntries.getPrimaryKey();
    }

    /**
    * Sets the primary key of this a h cat entries.
    *
    * @param primaryKey the primary key of this a h cat entries
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ahCatEntries.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the item ID of this a h cat entries.
    *
    * @return the item ID of this a h cat entries
    */
    @Override
    public long getItemId() {
        return _ahCatEntries.getItemId();
    }

    /**
    * Sets the item ID of this a h cat entries.
    *
    * @param itemId the item ID of this a h cat entries
    */
    @Override
    public void setItemId(long itemId) {
        _ahCatEntries.setItemId(itemId);
    }

    /**
    * Returns the cat ID of this a h cat entries.
    *
    * @return the cat ID of this a h cat entries
    */
    @Override
    public long getCatId() {
        return _ahCatEntries.getCatId();
    }

    /**
    * Sets the cat ID of this a h cat entries.
    *
    * @param catId the cat ID of this a h cat entries
    */
    @Override
    public void setCatId(long catId) {
        _ahCatEntries.setCatId(catId);
    }

    /**
    * Returns the name of this a h cat entries.
    *
    * @return the name of this a h cat entries
    */
    @Override
    public java.lang.String getName() {
        return _ahCatEntries.getName();
    }

    /**
    * Sets the name of this a h cat entries.
    *
    * @param name the name of this a h cat entries
    */
    @Override
    public void setName(java.lang.String name) {
        _ahCatEntries.setName(name);
    }

    /**
    * Returns the descr of this a h cat entries.
    *
    * @return the descr of this a h cat entries
    */
    @Override
    public java.lang.String getDescr() {
        return _ahCatEntries.getDescr();
    }

    /**
    * Sets the descr of this a h cat entries.
    *
    * @param descr the descr of this a h cat entries
    */
    @Override
    public void setDescr(java.lang.String descr) {
        _ahCatEntries.setDescr(descr);
    }

    /**
    * Returns the parent ID of this a h cat entries.
    *
    * @return the parent ID of this a h cat entries
    */
    @Override
    public long getParentId() {
        return _ahCatEntries.getParentId();
    }

    /**
    * Sets the parent ID of this a h cat entries.
    *
    * @param parentId the parent ID of this a h cat entries
    */
    @Override
    public void setParentId(long parentId) {
        _ahCatEntries.setParentId(parentId);
    }

    @Override
    public boolean isNew() {
        return _ahCatEntries.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ahCatEntries.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ahCatEntries.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ahCatEntries.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ahCatEntries.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ahCatEntries.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ahCatEntries.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ahCatEntries.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ahCatEntries.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ahCatEntries.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ahCatEntries.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AHCatEntriesWrapper((AHCatEntries) _ahCatEntries.clone());
    }

    @Override
    public int compareTo(AHCatEntries ahCatEntries) {
        return _ahCatEntries.compareTo(ahCatEntries);
    }

    @Override
    public int hashCode() {
        return _ahCatEntries.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<AHCatEntries> toCacheModel() {
        return _ahCatEntries.toCacheModel();
    }

    @Override
    public AHCatEntries toEscapedModel() {
        return new AHCatEntriesWrapper(_ahCatEntries.toEscapedModel());
    }

    @Override
    public AHCatEntries toUnescapedModel() {
        return new AHCatEntriesWrapper(_ahCatEntries.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ahCatEntries.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ahCatEntries.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ahCatEntries.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHCatEntriesWrapper)) {
            return false;
        }

        AHCatEntriesWrapper ahCatEntriesWrapper = (AHCatEntriesWrapper) obj;

        if (Validator.equals(_ahCatEntries, ahCatEntriesWrapper._ahCatEntries)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AHCatEntries getWrappedAHCatEntries() {
        return _ahCatEntries;
    }

    @Override
    public AHCatEntries getWrappedModel() {
        return _ahCatEntries;
    }

    @Override
    public void resetOriginalValues() {
        _ahCatEntries.resetOriginalValues();
    }
}
