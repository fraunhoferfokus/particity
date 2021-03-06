package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the AHOrg service. Represents a row in the &quot;AHORG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHOrg
 * @see de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgImpl
 * @see de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgModelImpl
 * @generated
 */
public interface AHOrgModel extends BaseModel<AHOrg> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a a h org model instance should use the {@link AHOrg} interface instead.
     */

    /**
     * Returns the primary key of this a h org.
     *
     * @return the primary key of this a h org
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this a h org.
     *
     * @param primaryKey the primary key of this a h org
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the org ID of this a h org.
     *
     * @return the org ID of this a h org
     */
    public long getOrgId();

    /**
     * Sets the org ID of this a h org.
     *
     * @param orgId the org ID of this a h org
     */
    public void setOrgId(long orgId);

    /**
     * Returns the name of this a h org.
     *
     * @return the name of this a h org
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this a h org.
     *
     * @param name the name of this a h org
     */
    public void setName(String name);

    /**
     * Returns the holder of this a h org.
     *
     * @return the holder of this a h org
     */
    @AutoEscape
    public String getHolder();

    /**
     * Sets the holder of this a h org.
     *
     * @param holder the holder of this a h org
     */
    public void setHolder(String holder);

    /**
     * Returns the owner of this a h org.
     *
     * @return the owner of this a h org
     */
    @AutoEscape
    public String getOwner();

    /**
     * Sets the owner of this a h org.
     *
     * @param owner the owner of this a h org
     */
    public void setOwner(String owner);

    /**
     * Returns the userlist of this a h org.
     *
     * @return the userlist of this a h org
     */
    @AutoEscape
    public String getUserlist();

    /**
     * Sets the userlist of this a h org.
     *
     * @param userlist the userlist of this a h org
     */
    public void setUserlist(String userlist);

    /**
     * Returns the description of this a h org.
     *
     * @return the description of this a h org
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this a h org.
     *
     * @param description the description of this a h org
     */
    public void setDescription(String description);

    /**
     * Returns the legal status of this a h org.
     *
     * @return the legal status of this a h org
     */
    @AutoEscape
    public String getLegalStatus();

    /**
     * Sets the legal status of this a h org.
     *
     * @param legalStatus the legal status of this a h org
     */
    public void setLegalStatus(String legalStatus);

    /**
     * Returns the created of this a h org.
     *
     * @return the created of this a h org
     */
    public long getCreated();

    /**
     * Sets the created of this a h org.
     *
     * @param created the created of this a h org
     */
    public void setCreated(long created);

    /**
     * Returns the updated of this a h org.
     *
     * @return the updated of this a h org
     */
    public long getUpdated();

    /**
     * Sets the updated of this a h org.
     *
     * @param updated the updated of this a h org
     */
    public void setUpdated(long updated);

    /**
     * Returns the contact ID of this a h org.
     *
     * @return the contact ID of this a h org
     */
    public long getContactId();

    /**
     * Sets the contact ID of this a h org.
     *
     * @param contactId the contact ID of this a h org
     */
    public void setContactId(long contactId);

    /**
     * Returns the address ID of this a h org.
     *
     * @return the address ID of this a h org
     */
    public long getAddressId();

    /**
     * Sets the address ID of this a h org.
     *
     * @param addressId the address ID of this a h org
     */
    public void setAddressId(long addressId);

    /**
     * Returns the status of this a h org.
     *
     * @return the status of this a h org
     */
    public int getStatus();

    /**
     * Sets the status of this a h org.
     *
     * @param status the status of this a h org
     */
    public void setStatus(int status);

    /**
     * Returns the logo location of this a h org.
     *
     * @return the logo location of this a h org
     */
    @AutoEscape
    public String getLogoLocation();

    /**
     * Sets the logo location of this a h org.
     *
     * @param logoLocation the logo location of this a h org
     */
    public void setLogoLocation(String logoLocation);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(AHOrg ahOrg);

    @Override
    public int hashCode();

    @Override
    public CacheModel<AHOrg> toCacheModel();

    @Override
    public AHOrg toEscapedModel();

    @Override
    public AHOrg toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
