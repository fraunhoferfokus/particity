package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.model.AHRegionModel;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AHRegion service. Represents a row in the &quot;AHREGION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.fraunhofer.fokus.oefit.particity.model.AHRegionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AHRegionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHRegionImpl
 * @see de.fraunhofer.fokus.oefit.particity.model.AHRegion
 * @see de.fraunhofer.fokus.oefit.particity.model.AHRegionModel
 * @generated
 */
public class AHRegionModelImpl extends BaseModelImpl<AHRegion>
    implements AHRegionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a a h region model instance should use the {@link de.fraunhofer.fokus.oefit.particity.model.AHRegion} interface instead.
     */
    public static final String TABLE_NAME = "AHREGION";
    public static final Object[][] TABLE_COLUMNS = {
            { "regionId", Types.BIGINT },
            { "zip", Types.VARCHAR },
            { "city", Types.VARCHAR },
            { "country", Types.VARCHAR },
            { "permissions", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table AHREGION (regionId LONG not null,zip VARCHAR(75) not null,city VARCHAR(160) not null,country VARCHAR(160) not null,permissions INTEGER,primary key (regionId, zip, city, country))";
    public static final String TABLE_SQL_DROP = "drop table AHREGION";
    public static final String ORDER_BY_JPQL = " ORDER BY ahRegion.id.zip DESC";
    public static final String ORDER_BY_SQL = " ORDER BY AHREGION.zip DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.de.fraunhofer.fokus.oefit.particity.model.AHRegion"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.de.fraunhofer.fokus.oefit.particity.model.AHRegion"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.de.fraunhofer.fokus.oefit.particity.model.AHRegion"),
            true);
    public static long CITY_COLUMN_BITMASK = 1L;
    public static long COUNTRY_COLUMN_BITMASK = 2L;
    public static long REGIONID_COLUMN_BITMASK = 4L;
    public static long ZIP_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.de.fraunhofer.fokus.oefit.particity.model.AHRegion"));
    private static ClassLoader _classLoader = AHRegion.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            AHRegion.class
        };
    private long _regionId;
    private long _originalRegionId;
    private boolean _setOriginalRegionId;
    private String _zip;
    private String _originalZip;
    private String _city;
    private String _originalCity;
    private String _country;
    private String _originalCountry;
    private int _permissions;
    private long _columnBitmask;
    private AHRegion _escapedModel;

    public AHRegionModelImpl() {
    }

    @Override
    public AHRegionPK getPrimaryKey() {
        return new AHRegionPK(_regionId, _zip, _city, _country);
    }

    @Override
    public void setPrimaryKey(AHRegionPK primaryKey) {
        setRegionId(primaryKey.regionId);
        setZip(primaryKey.zip);
        setCity(primaryKey.city);
        setCountry(primaryKey.country);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new AHRegionPK(_regionId, _zip, _city, _country);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((AHRegionPK) primaryKeyObj);
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

    @Override
    public long getRegionId() {
        return _regionId;
    }

    @Override
    public void setRegionId(long regionId) {
        _columnBitmask |= REGIONID_COLUMN_BITMASK;

        if (!_setOriginalRegionId) {
            _setOriginalRegionId = true;

            _originalRegionId = _regionId;
        }

        _regionId = regionId;
    }

    public long getOriginalRegionId() {
        return _originalRegionId;
    }

    @Override
    public String getZip() {
        if (_zip == null) {
            return StringPool.BLANK;
        } else {
            return _zip;
        }
    }

    @Override
    public void setZip(String zip) {
        _columnBitmask = -1L;

        if (_originalZip == null) {
            _originalZip = _zip;
        }

        _zip = zip;
    }

    public String getOriginalZip() {
        return GetterUtil.getString(_originalZip);
    }

    @Override
    public String getCity() {
        if (_city == null) {
            return StringPool.BLANK;
        } else {
            return _city;
        }
    }

    @Override
    public void setCity(String city) {
        _columnBitmask |= CITY_COLUMN_BITMASK;

        if (_originalCity == null) {
            _originalCity = _city;
        }

        _city = city;
    }

    public String getOriginalCity() {
        return GetterUtil.getString(_originalCity);
    }

    @Override
    public String getCountry() {
        if (_country == null) {
            return StringPool.BLANK;
        } else {
            return _country;
        }
    }

    @Override
    public void setCountry(String country) {
        _columnBitmask |= COUNTRY_COLUMN_BITMASK;

        if (_originalCountry == null) {
            _originalCountry = _country;
        }

        _country = country;
    }

    public String getOriginalCountry() {
        return GetterUtil.getString(_originalCountry);
    }

    @Override
    public int getPermissions() {
        return _permissions;
    }

    @Override
    public void setPermissions(int permissions) {
        _permissions = permissions;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public AHRegion toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (AHRegion) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        AHRegionImpl ahRegionImpl = new AHRegionImpl();

        ahRegionImpl.setRegionId(getRegionId());
        ahRegionImpl.setZip(getZip());
        ahRegionImpl.setCity(getCity());
        ahRegionImpl.setCountry(getCountry());
        ahRegionImpl.setPermissions(getPermissions());

        ahRegionImpl.resetOriginalValues();

        return ahRegionImpl;
    }

    @Override
    public int compareTo(AHRegion ahRegion) {
        int value = 0;

        value = getZip().compareTo(ahRegion.getZip());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHRegion)) {
            return false;
        }

        AHRegion ahRegion = (AHRegion) obj;

        AHRegionPK primaryKey = ahRegion.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
        AHRegionModelImpl ahRegionModelImpl = this;

        ahRegionModelImpl._originalRegionId = ahRegionModelImpl._regionId;

        ahRegionModelImpl._setOriginalRegionId = false;

        ahRegionModelImpl._originalZip = ahRegionModelImpl._zip;

        ahRegionModelImpl._originalCity = ahRegionModelImpl._city;

        ahRegionModelImpl._originalCountry = ahRegionModelImpl._country;

        ahRegionModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<AHRegion> toCacheModel() {
        AHRegionCacheModel ahRegionCacheModel = new AHRegionCacheModel();

        ahRegionCacheModel.regionId = getRegionId();

        ahRegionCacheModel.zip = getZip();

        String zip = ahRegionCacheModel.zip;

        if ((zip != null) && (zip.length() == 0)) {
            ahRegionCacheModel.zip = null;
        }

        ahRegionCacheModel.city = getCity();

        String city = ahRegionCacheModel.city;

        if ((city != null) && (city.length() == 0)) {
            ahRegionCacheModel.city = null;
        }

        ahRegionCacheModel.country = getCountry();

        String country = ahRegionCacheModel.country;

        if ((country != null) && (country.length() == 0)) {
            ahRegionCacheModel.country = null;
        }

        ahRegionCacheModel.permissions = getPermissions();

        return ahRegionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{regionId=");
        sb.append(getRegionId());
        sb.append(", zip=");
        sb.append(getZip());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", country=");
        sb.append(getCountry());
        sb.append(", permissions=");
        sb.append(getPermissions());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.particity.model.AHRegion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>regionId</column-name><column-value><![CDATA[");
        sb.append(getRegionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>zip</column-name><column-value><![CDATA[");
        sb.append(getZip());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>country</column-name><column-value><![CDATA[");
        sb.append(getCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>permissions</column-name><column-value><![CDATA[");
        sb.append(getPermissions());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
