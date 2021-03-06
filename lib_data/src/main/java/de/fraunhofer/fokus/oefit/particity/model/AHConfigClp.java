package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHConfigClp extends BaseModelImpl<AHConfig> implements AHConfig {
    private String _name;
    private String _value;
    private BaseModel<?> _ahConfigRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class;

    public AHConfigClp() {
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
    public String getPrimaryKey() {
        return _name;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setName(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _name;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
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

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_ahConfigRemoteModel != null) {
            try {
                Class<?> clazz = _ahConfigRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_ahConfigRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getValue() {
        return _value;
    }

    @Override
    public void setValue(String value) {
        _value = value;

        if (_ahConfigRemoteModel != null) {
            try {
                Class<?> clazz = _ahConfigRemoteModel.getClass();

                Method method = clazz.getMethod("setValue", String.class);

                method.invoke(_ahConfigRemoteModel, value);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHConfigRemoteModel() {
        return _ahConfigRemoteModel;
    }

    public void setAHConfigRemoteModel(BaseModel<?> ahConfigRemoteModel) {
        _ahConfigRemoteModel = ahConfigRemoteModel;
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

        Class<?> remoteModelClass = _ahConfigRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahConfigRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHConfigLocalServiceUtil.addAHConfig(this);
        } else {
            AHConfigLocalServiceUtil.updateAHConfig(this);
        }
    }

    @Override
    public AHConfig toEscapedModel() {
        return (AHConfig) ProxyUtil.newProxyInstance(AHConfig.class.getClassLoader(),
            new Class[] { AHConfig.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHConfigClp clone = new AHConfigClp();

        clone.setName(getName());
        clone.setValue(getValue());

        return clone;
    }

    @Override
    public int compareTo(AHConfig ahConfig) {
        String primaryKey = ahConfig.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHConfigClp)) {
            return false;
        }

        AHConfigClp ahConfig = (AHConfigClp) obj;

        String primaryKey = ahConfig.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{name=");
        sb.append(getName());
        sb.append(", value=");
        sb.append(getValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.particity.model.AHConfig");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
