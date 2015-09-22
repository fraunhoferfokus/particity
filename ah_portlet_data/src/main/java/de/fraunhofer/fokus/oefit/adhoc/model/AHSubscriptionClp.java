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

import de.fraunhofer.fokus.oefit.adhoc.service.AHSubscriptionLocalServiceUtil;
import de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHSubscriptionClp extends BaseModelImpl<AHSubscription>
    implements AHSubscription {
    private long _subId;
    private String _uuid;
    private String _email;
    private int _status;
    private long _created;
    private BaseModel<?> _ahSubscriptionRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.class;

    public AHSubscriptionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AHSubscription.class;
    }

    @Override
    public String getModelClassName() {
        return AHSubscription.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _subId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSubId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _subId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subId", getSubId());
        attributes.put("uuid", getUuid());
        attributes.put("email", getEmail());
        attributes.put("status", getStatus());
        attributes.put("created", getCreated());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long subId = (Long) attributes.get("subId");

        if (subId != null) {
            setSubId(subId);
        }

        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Long created = (Long) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }
    }

    @Override
    public long getSubId() {
        return _subId;
    }

    @Override
    public void setSubId(long subId) {
        _subId = subId;

        if (_ahSubscriptionRemoteModel != null) {
            try {
                Class<?> clazz = _ahSubscriptionRemoteModel.getClass();

                Method method = clazz.getMethod("setSubId", long.class);

                method.invoke(_ahSubscriptionRemoteModel, subId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_ahSubscriptionRemoteModel != null) {
            try {
                Class<?> clazz = _ahSubscriptionRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_ahSubscriptionRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_ahSubscriptionRemoteModel != null) {
            try {
                Class<?> clazz = _ahSubscriptionRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_ahSubscriptionRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_ahSubscriptionRemoteModel != null) {
            try {
                Class<?> clazz = _ahSubscriptionRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_ahSubscriptionRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCreated() {
        return _created;
    }

    @Override
    public void setCreated(long created) {
        _created = created;

        if (_ahSubscriptionRemoteModel != null) {
            try {
                Class<?> clazz = _ahSubscriptionRemoteModel.getClass();

                Method method = clazz.getMethod("setCreated", long.class);

                method.invoke(_ahSubscriptionRemoteModel, created);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHSubscriptionRemoteModel() {
        return _ahSubscriptionRemoteModel;
    }

    public void setAHSubscriptionRemoteModel(
        BaseModel<?> ahSubscriptionRemoteModel) {
        _ahSubscriptionRemoteModel = ahSubscriptionRemoteModel;
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

        Class<?> remoteModelClass = _ahSubscriptionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahSubscriptionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHSubscriptionLocalServiceUtil.addAHSubscription(this);
        } else {
            AHSubscriptionLocalServiceUtil.updateAHSubscription(this);
        }
    }

    @Override
    public AHSubscription toEscapedModel() {
        return (AHSubscription) ProxyUtil.newProxyInstance(AHSubscription.class.getClassLoader(),
            new Class[] { AHSubscription.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHSubscriptionClp clone = new AHSubscriptionClp();

        clone.setSubId(getSubId());
        clone.setUuid(getUuid());
        clone.setEmail(getEmail());
        clone.setStatus(getStatus());
        clone.setCreated(getCreated());

        return clone;
    }

    @Override
    public int compareTo(AHSubscription ahSubscription) {
        long primaryKey = ahSubscription.getPrimaryKey();

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

        if (!(obj instanceof AHSubscriptionClp)) {
            return false;
        }

        AHSubscriptionClp ahSubscription = (AHSubscriptionClp) obj;

        long primaryKey = ahSubscription.getPrimaryKey();

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

        sb.append("{subId=");
        sb.append(getSubId());
        sb.append(", uuid=");
        sb.append(getUuid());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>subId</column-name><column-value><![CDATA[");
        sb.append(getSubId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
