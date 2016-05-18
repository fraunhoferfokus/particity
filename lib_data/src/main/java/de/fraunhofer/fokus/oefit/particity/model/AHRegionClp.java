package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.ClpSerializer;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHRegionClp extends BaseModelImpl<AHRegion> implements AHRegion {
    private long _regionId;
    private String _zip;
    private String _city;
    private String _country;
    private int _permissions;
    private BaseModel<?> _ahRegionRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class;

    public AHRegionClp() {
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
        _regionId = regionId;

        if (_ahRegionRemoteModel != null) {
            try {
                Class<?> clazz = _ahRegionRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionId", long.class);

                method.invoke(_ahRegionRemoteModel, regionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getZip() {
        return _zip;
    }

    @Override
    public void setZip(String zip) {
        _zip = zip;

        if (_ahRegionRemoteModel != null) {
            try {
                Class<?> clazz = _ahRegionRemoteModel.getClass();

                Method method = clazz.getMethod("setZip", String.class);

                method.invoke(_ahRegionRemoteModel, zip);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCity() {
        return _city;
    }

    @Override
    public void setCity(String city) {
        _city = city;

        if (_ahRegionRemoteModel != null) {
            try {
                Class<?> clazz = _ahRegionRemoteModel.getClass();

                Method method = clazz.getMethod("setCity", String.class);

                method.invoke(_ahRegionRemoteModel, city);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCountry() {
        return _country;
    }

    @Override
    public void setCountry(String country) {
        _country = country;

        if (_ahRegionRemoteModel != null) {
            try {
                Class<?> clazz = _ahRegionRemoteModel.getClass();

                Method method = clazz.getMethod("setCountry", String.class);

                method.invoke(_ahRegionRemoteModel, country);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPermissions() {
        return _permissions;
    }

    @Override
    public void setPermissions(int permissions) {
        _permissions = permissions;

        if (_ahRegionRemoteModel != null) {
            try {
                Class<?> clazz = _ahRegionRemoteModel.getClass();

                Method method = clazz.getMethod("setPermissions", int.class);

                method.invoke(_ahRegionRemoteModel, permissions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHRegionRemoteModel() {
        return _ahRegionRemoteModel;
    }

    public void setAHRegionRemoteModel(BaseModel<?> ahRegionRemoteModel) {
        _ahRegionRemoteModel = ahRegionRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _ahRegionRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_ahRegionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHRegionLocalServiceUtil.addAHRegion(this);
        } else {
            AHRegionLocalServiceUtil.updateAHRegion(this);
        }
    }

    @Override
    public AHRegion toEscapedModel() {
        return (AHRegion) ProxyUtil.newProxyInstance(AHRegion.class.getClassLoader(),
            new Class[] { AHRegion.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHRegionClp clone = new AHRegionClp();

        clone.setRegionId(getRegionId());
        clone.setZip(getZip());
        clone.setCity(getCity());
        clone.setCountry(getCountry());
        clone.setPermissions(getPermissions());

        return clone;
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

        if (!(obj instanceof AHRegionClp)) {
            return false;
        }

        AHRegionClp ahRegion = (AHRegionClp) obj;

        AHRegionPK primaryKey = ahRegion.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
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
