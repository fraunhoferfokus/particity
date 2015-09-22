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

import de.fraunhofer.fokus.oefit.adhoc.service.AHContactLocalServiceUtil;
import de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHContactClp extends BaseModelImpl<AHContact> implements AHContact {
    private long _contactId;
    private String _forename;
    private String _surname;
    private String _tel;
    private String _mobile;
    private String _fax;
    private String _email;
    private String _www;
    private BaseModel<?> _ahContactRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.class;

    public AHContactClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AHContact.class;
    }

    @Override
    public String getModelClassName() {
        return AHContact.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _contactId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContactId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _contactId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactId", getContactId());
        attributes.put("forename", getForename());
        attributes.put("surname", getSurname());
        attributes.put("tel", getTel());
        attributes.put("mobile", getMobile());
        attributes.put("fax", getFax());
        attributes.put("email", getEmail());
        attributes.put("www", getWww());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        String forename = (String) attributes.get("forename");

        if (forename != null) {
            setForename(forename);
        }

        String surname = (String) attributes.get("surname");

        if (surname != null) {
            setSurname(surname);
        }

        String tel = (String) attributes.get("tel");

        if (tel != null) {
            setTel(tel);
        }

        String mobile = (String) attributes.get("mobile");

        if (mobile != null) {
            setMobile(mobile);
        }

        String fax = (String) attributes.get("fax");

        if (fax != null) {
            setFax(fax);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String www = (String) attributes.get("www");

        if (www != null) {
            setWww(www);
        }
    }

    @Override
    public long getContactId() {
        return _contactId;
    }

    @Override
    public void setContactId(long contactId) {
        _contactId = contactId;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId", long.class);

                method.invoke(_ahContactRemoteModel, contactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getForename() {
        return _forename;
    }

    @Override
    public void setForename(String forename) {
        _forename = forename;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setForename", String.class);

                method.invoke(_ahContactRemoteModel, forename);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSurname() {
        return _surname;
    }

    @Override
    public void setSurname(String surname) {
        _surname = surname;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setSurname", String.class);

                method.invoke(_ahContactRemoteModel, surname);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTel() {
        return _tel;
    }

    @Override
    public void setTel(String tel) {
        _tel = tel;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setTel", String.class);

                method.invoke(_ahContactRemoteModel, tel);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMobile() {
        return _mobile;
    }

    @Override
    public void setMobile(String mobile) {
        _mobile = mobile;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setMobile", String.class);

                method.invoke(_ahContactRemoteModel, mobile);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFax() {
        return _fax;
    }

    @Override
    public void setFax(String fax) {
        _fax = fax;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setFax", String.class);

                method.invoke(_ahContactRemoteModel, fax);
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

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_ahContactRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWww() {
        return _www;
    }

    @Override
    public void setWww(String www) {
        _www = www;

        if (_ahContactRemoteModel != null) {
            try {
                Class<?> clazz = _ahContactRemoteModel.getClass();

                Method method = clazz.getMethod("setWww", String.class);

                method.invoke(_ahContactRemoteModel, www);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHContactRemoteModel() {
        return _ahContactRemoteModel;
    }

    public void setAHContactRemoteModel(BaseModel<?> ahContactRemoteModel) {
        _ahContactRemoteModel = ahContactRemoteModel;
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

        Class<?> remoteModelClass = _ahContactRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahContactRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHContactLocalServiceUtil.addAHContact(this);
        } else {
            AHContactLocalServiceUtil.updateAHContact(this);
        }
    }

    @Override
    public AHContact toEscapedModel() {
        return (AHContact) ProxyUtil.newProxyInstance(AHContact.class.getClassLoader(),
            new Class[] { AHContact.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHContactClp clone = new AHContactClp();

        clone.setContactId(getContactId());
        clone.setForename(getForename());
        clone.setSurname(getSurname());
        clone.setTel(getTel());
        clone.setMobile(getMobile());
        clone.setFax(getFax());
        clone.setEmail(getEmail());
        clone.setWww(getWww());

        return clone;
    }

    @Override
    public int compareTo(AHContact ahContact) {
        long primaryKey = ahContact.getPrimaryKey();

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

        if (!(obj instanceof AHContactClp)) {
            return false;
        }

        AHContactClp ahContact = (AHContactClp) obj;

        long primaryKey = ahContact.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{contactId=");
        sb.append(getContactId());
        sb.append(", forename=");
        sb.append(getForename());
        sb.append(", surname=");
        sb.append(getSurname());
        sb.append(", tel=");
        sb.append(getTel());
        sb.append(", mobile=");
        sb.append(getMobile());
        sb.append(", fax=");
        sb.append(getFax());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", www=");
        sb.append(getWww());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.adhoc.model.AHContact");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>forename</column-name><column-value><![CDATA[");
        sb.append(getForename());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>surname</column-name><column-value><![CDATA[");
        sb.append(getSurname());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tel</column-name><column-value><![CDATA[");
        sb.append(getTel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mobile</column-name><column-value><![CDATA[");
        sb.append(getMobile());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fax</column-name><column-value><![CDATA[");
        sb.append(getFax());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>www</column-name><column-value><![CDATA[");
        sb.append(getWww());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
