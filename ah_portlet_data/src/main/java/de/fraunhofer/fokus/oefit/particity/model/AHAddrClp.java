package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHAddrClp extends BaseModelImpl<AHAddr> implements AHAddr {
    private long _addrId;
    private String _street;
    private String _number;
    private float _coordLat;
    private float _coordLon;
    private long _regionId;
    private BaseModel<?> _ahAddrRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class;

    public AHAddrClp() {
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
    public long getPrimaryKey() {
        return _addrId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAddrId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _addrId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

        Float coordLat = (Float) attributes.get("coordLat");

        if (coordLat != null) {
            setCoordLat(coordLat);
        }

        Float coordLon = (Float) attributes.get("coordLon");

        if (coordLon != null) {
            setCoordLon(coordLon);
        }

        Long regionId = (Long) attributes.get("regionId");

        if (regionId != null) {
            setRegionId(regionId);
        }
    }

    @Override
    public long getAddrId() {
        return _addrId;
    }

    @Override
    public void setAddrId(long addrId) {
        _addrId = addrId;

        if (_ahAddrRemoteModel != null) {
            try {
                Class<?> clazz = _ahAddrRemoteModel.getClass();

                Method method = clazz.getMethod("setAddrId", long.class);

                method.invoke(_ahAddrRemoteModel, addrId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStreet() {
        return _street;
    }

    @Override
    public void setStreet(String street) {
        _street = street;

        if (_ahAddrRemoteModel != null) {
            try {
                Class<?> clazz = _ahAddrRemoteModel.getClass();

                Method method = clazz.getMethod("setStreet", String.class);

                method.invoke(_ahAddrRemoteModel, street);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNumber() {
        return _number;
    }

    @Override
    public void setNumber(String number) {
        _number = number;

        if (_ahAddrRemoteModel != null) {
            try {
                Class<?> clazz = _ahAddrRemoteModel.getClass();

                Method method = clazz.getMethod("setNumber", String.class);

                method.invoke(_ahAddrRemoteModel, number);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public float getCoordLat() {
        return _coordLat;
    }

    @Override
    public void setCoordLat(float coordLat) {
        _coordLat = coordLat;

        if (_ahAddrRemoteModel != null) {
            try {
                Class<?> clazz = _ahAddrRemoteModel.getClass();

                Method method = clazz.getMethod("setCoordLat", float.class);

                method.invoke(_ahAddrRemoteModel, coordLat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public float getCoordLon() {
        return _coordLon;
    }

    @Override
    public void setCoordLon(float coordLon) {
        _coordLon = coordLon;

        if (_ahAddrRemoteModel != null) {
            try {
                Class<?> clazz = _ahAddrRemoteModel.getClass();

                Method method = clazz.getMethod("setCoordLon", float.class);

                method.invoke(_ahAddrRemoteModel, coordLon);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRegionId() {
        return _regionId;
    }

    @Override
    public void setRegionId(long regionId) {
        _regionId = regionId;

        if (_ahAddrRemoteModel != null) {
            try {
                Class<?> clazz = _ahAddrRemoteModel.getClass();

                Method method = clazz.getMethod("setRegionId", long.class);

                method.invoke(_ahAddrRemoteModel, regionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHAddrRemoteModel() {
        return _ahAddrRemoteModel;
    }

    public void setAHAddrRemoteModel(BaseModel<?> ahAddrRemoteModel) {
        _ahAddrRemoteModel = ahAddrRemoteModel;
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

        Class<?> remoteModelClass = _ahAddrRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahAddrRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHAddrLocalServiceUtil.addAHAddr(this);
        } else {
            AHAddrLocalServiceUtil.updateAHAddr(this);
        }
    }

    @Override
    public AHAddr toEscapedModel() {
        return (AHAddr) ProxyUtil.newProxyInstance(AHAddr.class.getClassLoader(),
            new Class[] { AHAddr.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHAddrClp clone = new AHAddrClp();

        clone.setAddrId(getAddrId());
        clone.setStreet(getStreet());
        clone.setNumber(getNumber());
        clone.setCoordLat(getCoordLat());
        clone.setCoordLon(getCoordLon());
        clone.setRegionId(getRegionId());

        return clone;
    }

    @Override
    public int compareTo(AHAddr ahAddr) {
        long primaryKey = ahAddr.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHAddrClp)) {
            return false;
        }

        AHAddrClp ahAddr = (AHAddrClp) obj;

        long primaryKey = ahAddr.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
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
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{addrId=");
        sb.append(getAddrId());
        sb.append(", street=");
        sb.append(getStreet());
        sb.append(", number=");
        sb.append(getNumber());
        sb.append(", coordLat=");
        sb.append(getCoordLat());
        sb.append(", coordLon=");
        sb.append(getCoordLon());
        sb.append(", regionId=");
        sb.append(getRegionId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.particity.model.AHAddr");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>addrId</column-name><column-value><![CDATA[");
        sb.append(getAddrId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>street</column-name><column-value><![CDATA[");
        sb.append(getStreet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>number</column-name><column-value><![CDATA[");
        sb.append(getNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>coordLat</column-name><column-value><![CDATA[");
        sb.append(getCoordLat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>coordLon</column-name><column-value><![CDATA[");
        sb.append(getCoordLon());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>regionId</column-name><column-value><![CDATA[");
        sb.append(getRegionId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
