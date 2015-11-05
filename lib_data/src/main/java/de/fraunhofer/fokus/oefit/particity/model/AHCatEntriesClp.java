package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHCatEntriesClp extends BaseModelImpl<AHCatEntries>
    implements AHCatEntries {
    private long _itemId;
    private long _catId;
    private String _name;
    private String _descr;
    private long _parentId;
    private BaseModel<?> _ahCatEntriesRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class;

    public AHCatEntriesClp() {
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
    public long getPrimaryKey() {
        return _itemId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setItemId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _itemId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getItemId() {
        return _itemId;
    }

    @Override
    public void setItemId(long itemId) {
        _itemId = itemId;

        if (_ahCatEntriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCatEntriesRemoteModel.getClass();

                Method method = clazz.getMethod("setItemId", long.class);

                method.invoke(_ahCatEntriesRemoteModel, itemId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCatId() {
        return _catId;
    }

    @Override
    public void setCatId(long catId) {
        _catId = catId;

        if (_ahCatEntriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCatEntriesRemoteModel.getClass();

                Method method = clazz.getMethod("setCatId", long.class);

                method.invoke(_ahCatEntriesRemoteModel, catId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_ahCatEntriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCatEntriesRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_ahCatEntriesRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescr() {
        return _descr;
    }

    @Override
    public void setDescr(String descr) {
        _descr = descr;

        if (_ahCatEntriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCatEntriesRemoteModel.getClass();

                Method method = clazz.getMethod("setDescr", String.class);

                method.invoke(_ahCatEntriesRemoteModel, descr);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getParentId() {
        return _parentId;
    }

    @Override
    public void setParentId(long parentId) {
        _parentId = parentId;

        if (_ahCatEntriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCatEntriesRemoteModel.getClass();

                Method method = clazz.getMethod("setParentId", long.class);

                method.invoke(_ahCatEntriesRemoteModel, parentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHCatEntriesRemoteModel() {
        return _ahCatEntriesRemoteModel;
    }

    public void setAHCatEntriesRemoteModel(BaseModel<?> ahCatEntriesRemoteModel) {
        _ahCatEntriesRemoteModel = ahCatEntriesRemoteModel;
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

        Class<?> remoteModelClass = _ahCatEntriesRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahCatEntriesRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHCatEntriesLocalServiceUtil.addAHCatEntries(this);
        } else {
            AHCatEntriesLocalServiceUtil.updateAHCatEntries(this);
        }
    }

    @Override
    public AHCatEntries toEscapedModel() {
        return (AHCatEntries) ProxyUtil.newProxyInstance(AHCatEntries.class.getClassLoader(),
            new Class[] { AHCatEntries.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHCatEntriesClp clone = new AHCatEntriesClp();

        clone.setItemId(getItemId());
        clone.setCatId(getCatId());
        clone.setName(getName());
        clone.setDescr(getDescr());
        clone.setParentId(getParentId());

        return clone;
    }

    @Override
    public int compareTo(AHCatEntries ahCatEntries) {
        long primaryKey = ahCatEntries.getPrimaryKey();

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

        if (!(obj instanceof AHCatEntriesClp)) {
            return false;
        }

        AHCatEntriesClp ahCatEntries = (AHCatEntriesClp) obj;

        long primaryKey = ahCatEntries.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{itemId=");
        sb.append(getItemId());
        sb.append(", catId=");
        sb.append(getCatId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", descr=");
        sb.append(getDescr());
        sb.append(", parentId=");
        sb.append(getParentId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.particity.model.AHCatEntries");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>itemId</column-name><column-value><![CDATA[");
        sb.append(getItemId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>catId</column-name><column-value><![CDATA[");
        sb.append(getCatId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descr</column-name><column-value><![CDATA[");
        sb.append(getDescr());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
