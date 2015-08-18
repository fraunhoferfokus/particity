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

import de.fraunhofer.fokus.oefit.adhoc.service.AHOrgLocalServiceUtil;
import de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHOrgClp extends BaseModelImpl<AHOrg> implements AHOrg {
    private long _orgId;
    private String _name;
    private String _holder;
    private String _owner;
    private String _userlist;
    private String _description;
    private String _legalStatus;
    private long _created;
    private long _updated;
    private long _contactId;
    private long _addressId;
    private int _status;
    private String _logoLocation;
    private BaseModel<?> _ahOrgRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.class;

    public AHOrgClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AHOrg.class;
    }

    @Override
    public String getModelClassName() {
        return AHOrg.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _orgId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setOrgId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _orgId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("orgId", getOrgId());
        attributes.put("name", getName());
        attributes.put("holder", getHolder());
        attributes.put("owner", getOwner());
        attributes.put("userlist", getUserlist());
        attributes.put("description", getDescription());
        attributes.put("legalStatus", getLegalStatus());
        attributes.put("created", getCreated());
        attributes.put("updated", getUpdated());
        attributes.put("contactId", getContactId());
        attributes.put("addressId", getAddressId());
        attributes.put("status", getStatus());
        attributes.put("logoLocation", getLogoLocation());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long orgId = (Long) attributes.get("orgId");

        if (orgId != null) {
            setOrgId(orgId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String holder = (String) attributes.get("holder");

        if (holder != null) {
            setHolder(holder);
        }

        String owner = (String) attributes.get("owner");

        if (owner != null) {
            setOwner(owner);
        }

        String userlist = (String) attributes.get("userlist");

        if (userlist != null) {
            setUserlist(userlist);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String legalStatus = (String) attributes.get("legalStatus");

        if (legalStatus != null) {
            setLegalStatus(legalStatus);
        }

        Long created = (Long) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }

        Long updated = (Long) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Long addressId = (Long) attributes.get("addressId");

        if (addressId != null) {
            setAddressId(addressId);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String logoLocation = (String) attributes.get("logoLocation");

        if (logoLocation != null) {
            setLogoLocation(logoLocation);
        }
    }

    @Override
    public long getOrgId() {
        return _orgId;
    }

    @Override
    public void setOrgId(long orgId) {
        _orgId = orgId;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setOrgId", long.class);

                method.invoke(_ahOrgRemoteModel, orgId);
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

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_ahOrgRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getHolder() {
        return _holder;
    }

    @Override
    public void setHolder(String holder) {
        _holder = holder;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setHolder", String.class);

                method.invoke(_ahOrgRemoteModel, holder);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOwner() {
        return _owner;
    }

    @Override
    public void setOwner(String owner) {
        _owner = owner;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setOwner", String.class);

                method.invoke(_ahOrgRemoteModel, owner);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserlist() {
        return _userlist;
    }

    @Override
    public void setUserlist(String userlist) {
        _userlist = userlist;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setUserlist", String.class);

                method.invoke(_ahOrgRemoteModel, userlist);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_ahOrgRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLegalStatus() {
        return _legalStatus;
    }

    @Override
    public void setLegalStatus(String legalStatus) {
        _legalStatus = legalStatus;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setLegalStatus", String.class);

                method.invoke(_ahOrgRemoteModel, legalStatus);
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

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setCreated", long.class);

                method.invoke(_ahOrgRemoteModel, created);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUpdated() {
        return _updated;
    }

    @Override
    public void setUpdated(long updated) {
        _updated = updated;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setUpdated", long.class);

                method.invoke(_ahOrgRemoteModel, updated);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContactId() {
        return _contactId;
    }

    @Override
    public void setContactId(long contactId) {
        _contactId = contactId;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId", long.class);

                method.invoke(_ahOrgRemoteModel, contactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAddressId() {
        return _addressId;
    }

    @Override
    public void setAddressId(long addressId) {
        _addressId = addressId;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setAddressId", long.class);

                method.invoke(_ahOrgRemoteModel, addressId);
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

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_ahOrgRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLogoLocation() {
        return _logoLocation;
    }

    @Override
    public void setLogoLocation(String logoLocation) {
        _logoLocation = logoLocation;

        if (_ahOrgRemoteModel != null) {
            try {
                Class<?> clazz = _ahOrgRemoteModel.getClass();

                Method method = clazz.getMethod("setLogoLocation", String.class);

                method.invoke(_ahOrgRemoteModel, logoLocation);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHOrgRemoteModel() {
        return _ahOrgRemoteModel;
    }

    public void setAHOrgRemoteModel(BaseModel<?> ahOrgRemoteModel) {
        _ahOrgRemoteModel = ahOrgRemoteModel;
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

        Class<?> remoteModelClass = _ahOrgRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahOrgRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHOrgLocalServiceUtil.addAHOrg(this);
        } else {
            AHOrgLocalServiceUtil.updateAHOrg(this);
        }
    }

    @Override
    public AHOrg toEscapedModel() {
        return (AHOrg) ProxyUtil.newProxyInstance(AHOrg.class.getClassLoader(),
            new Class[] { AHOrg.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHOrgClp clone = new AHOrgClp();

        clone.setOrgId(getOrgId());
        clone.setName(getName());
        clone.setHolder(getHolder());
        clone.setOwner(getOwner());
        clone.setUserlist(getUserlist());
        clone.setDescription(getDescription());
        clone.setLegalStatus(getLegalStatus());
        clone.setCreated(getCreated());
        clone.setUpdated(getUpdated());
        clone.setContactId(getContactId());
        clone.setAddressId(getAddressId());
        clone.setStatus(getStatus());
        clone.setLogoLocation(getLogoLocation());

        return clone;
    }

    @Override
    public int compareTo(AHOrg ahOrg) {
        int value = 0;

        if (getUpdated() < ahOrg.getUpdated()) {
            value = -1;
        } else if (getUpdated() > ahOrg.getUpdated()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        if (getStatus() < ahOrg.getStatus()) {
            value = -1;
        } else if (getStatus() > ahOrg.getStatus()) {
            value = 1;
        } else {
            value = 0;
        }

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

        if (!(obj instanceof AHOrgClp)) {
            return false;
        }

        AHOrgClp ahOrg = (AHOrgClp) obj;

        long primaryKey = ahOrg.getPrimaryKey();

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
        StringBundler sb = new StringBundler(27);

        sb.append("{orgId=");
        sb.append(getOrgId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", holder=");
        sb.append(getHolder());
        sb.append(", owner=");
        sb.append(getOwner());
        sb.append(", userlist=");
        sb.append(getUserlist());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", legalStatus=");
        sb.append(getLegalStatus());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append(", updated=");
        sb.append(getUpdated());
        sb.append(", contactId=");
        sb.append(getContactId());
        sb.append(", addressId=");
        sb.append(getAddressId());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", logoLocation=");
        sb.append(getLogoLocation());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.adhoc.model.AHOrg");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>orgId</column-name><column-value><![CDATA[");
        sb.append(getOrgId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>holder</column-name><column-value><![CDATA[");
        sb.append(getHolder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>owner</column-name><column-value><![CDATA[");
        sb.append(getOwner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userlist</column-name><column-value><![CDATA[");
        sb.append(getUserlist());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>legalStatus</column-name><column-value><![CDATA[");
        sb.append(getLegalStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>created</column-name><column-value><![CDATA[");
        sb.append(getCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>updated</column-name><column-value><![CDATA[");
        sb.append(getUpdated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>addressId</column-name><column-value><![CDATA[");
        sb.append(getAddressId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>logoLocation</column-name><column-value><![CDATA[");
        sb.append(getLogoLocation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
