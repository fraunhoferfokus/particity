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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHCategoriesClp extends BaseModelImpl<AHCategories>
    implements AHCategories {
    private long _catId;
    private String _name;
    private String _descr;
    private int _type;
    private BaseModel<?> _ahCategoriesRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.class;

    public AHCategoriesClp() {
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
    public long getPrimaryKey() {
        return _catId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCatId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _catId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getCatId() {
        return _catId;
    }

    @Override
    public void setCatId(long catId) {
        _catId = catId;

        if (_ahCategoriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCategoriesRemoteModel.getClass();

                Method method = clazz.getMethod("setCatId", long.class);

                method.invoke(_ahCategoriesRemoteModel, catId);
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

        if (_ahCategoriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCategoriesRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_ahCategoriesRemoteModel, name);
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

        if (_ahCategoriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCategoriesRemoteModel.getClass();

                Method method = clazz.getMethod("setDescr", String.class);

                method.invoke(_ahCategoriesRemoteModel, descr);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getType() {
        return _type;
    }

    @Override
    public void setType(int type) {
        _type = type;

        if (_ahCategoriesRemoteModel != null) {
            try {
                Class<?> clazz = _ahCategoriesRemoteModel.getClass();

                Method method = clazz.getMethod("setType", int.class);

                method.invoke(_ahCategoriesRemoteModel, type);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHCategoriesRemoteModel() {
        return _ahCategoriesRemoteModel;
    }

    public void setAHCategoriesRemoteModel(BaseModel<?> ahCategoriesRemoteModel) {
        _ahCategoriesRemoteModel = ahCategoriesRemoteModel;
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

        Class<?> remoteModelClass = _ahCategoriesRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahCategoriesRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHCategoriesLocalServiceUtil.addAHCategories(this);
        } else {
            AHCategoriesLocalServiceUtil.updateAHCategories(this);
        }
    }

    @Override
    public AHCategories toEscapedModel() {
        return (AHCategories) ProxyUtil.newProxyInstance(AHCategories.class.getClassLoader(),
            new Class[] { AHCategories.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHCategoriesClp clone = new AHCategoriesClp();

        clone.setCatId(getCatId());
        clone.setName(getName());
        clone.setDescr(getDescr());
        clone.setType(getType());

        return clone;
    }

    @Override
    public int compareTo(AHCategories ahCategories) {
        long primaryKey = ahCategories.getPrimaryKey();

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

        if (!(obj instanceof AHCategoriesClp)) {
            return false;
        }

        AHCategoriesClp ahCategories = (AHCategoriesClp) obj;

        long primaryKey = ahCategories.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{catId=");
        sb.append(getCatId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", descr=");
        sb.append(getDescr());
        sb.append(", type=");
        sb.append(getType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.adhoc.model.AHCategories");
        sb.append("</model-name>");

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
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
