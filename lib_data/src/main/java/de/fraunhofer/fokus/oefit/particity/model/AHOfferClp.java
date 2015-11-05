package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AHOfferClp extends BaseModelImpl<AHOffer> implements AHOffer {
    private long _offerId;
    private String _title;
    private String _description;
    private String _workTime;
    private int _workType;
    private int _type;
    private int _status;
    private int _socialStatus;
    private long _created;
    private long _updated;
    private long _expires;
    private long _publish;
    private long _adressId;
    private long _contactId;
    private long _sndContactId;
    private boolean _contactAgency;
    private long _orgId;
    private BaseModel<?> _ahOfferRemoteModel;
    private Class<?> _clpSerializerClass = de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class;

    public AHOfferClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AHOffer.class;
    }

    @Override
    public String getModelClassName() {
        return AHOffer.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _offerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setOfferId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _offerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("offerId", getOfferId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("workTime", getWorkTime());
        attributes.put("workType", getWorkType());
        attributes.put("type", getType());
        attributes.put("status", getStatus());
        attributes.put("socialStatus", getSocialStatus());
        attributes.put("created", getCreated());
        attributes.put("updated", getUpdated());
        attributes.put("expires", getExpires());
        attributes.put("publish", getPublish());
        attributes.put("adressId", getAdressId());
        attributes.put("contactId", getContactId());
        attributes.put("sndContactId", getSndContactId());
        attributes.put("contactAgency", getContactAgency());
        attributes.put("orgId", getOrgId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long offerId = (Long) attributes.get("offerId");

        if (offerId != null) {
            setOfferId(offerId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String workTime = (String) attributes.get("workTime");

        if (workTime != null) {
            setWorkTime(workTime);
        }

        Integer workType = (Integer) attributes.get("workType");

        if (workType != null) {
            setWorkType(workType);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Integer socialStatus = (Integer) attributes.get("socialStatus");

        if (socialStatus != null) {
            setSocialStatus(socialStatus);
        }

        Long created = (Long) attributes.get("created");

        if (created != null) {
            setCreated(created);
        }

        Long updated = (Long) attributes.get("updated");

        if (updated != null) {
            setUpdated(updated);
        }

        Long expires = (Long) attributes.get("expires");

        if (expires != null) {
            setExpires(expires);
        }

        Long publish = (Long) attributes.get("publish");

        if (publish != null) {
            setPublish(publish);
        }

        Long adressId = (Long) attributes.get("adressId");

        if (adressId != null) {
            setAdressId(adressId);
        }

        Long contactId = (Long) attributes.get("contactId");

        if (contactId != null) {
            setContactId(contactId);
        }

        Long sndContactId = (Long) attributes.get("sndContactId");

        if (sndContactId != null) {
            setSndContactId(sndContactId);
        }

        Boolean contactAgency = (Boolean) attributes.get("contactAgency");

        if (contactAgency != null) {
            setContactAgency(contactAgency);
        }

        Long orgId = (Long) attributes.get("orgId");

        if (orgId != null) {
            setOrgId(orgId);
        }
    }

    @Override
    public long getOfferId() {
        return _offerId;
    }

    @Override
    public void setOfferId(long offerId) {
        _offerId = offerId;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setOfferId", long.class);

                method.invoke(_ahOfferRemoteModel, offerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_ahOfferRemoteModel, title);
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

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_ahOfferRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWorkTime() {
        return _workTime;
    }

    @Override
    public void setWorkTime(String workTime) {
        _workTime = workTime;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setWorkTime", String.class);

                method.invoke(_ahOfferRemoteModel, workTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getWorkType() {
        return _workType;
    }

    @Override
    public void setWorkType(int workType) {
        _workType = workType;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setWorkType", int.class);

                method.invoke(_ahOfferRemoteModel, workType);
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

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setType", int.class);

                method.invoke(_ahOfferRemoteModel, type);
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

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_ahOfferRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSocialStatus() {
        return _socialStatus;
    }

    @Override
    public void setSocialStatus(int socialStatus) {
        _socialStatus = socialStatus;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setSocialStatus", int.class);

                method.invoke(_ahOfferRemoteModel, socialStatus);
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

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setCreated", long.class);

                method.invoke(_ahOfferRemoteModel, created);
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

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setUpdated", long.class);

                method.invoke(_ahOfferRemoteModel, updated);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getExpires() {
        return _expires;
    }

    @Override
    public void setExpires(long expires) {
        _expires = expires;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setExpires", long.class);

                method.invoke(_ahOfferRemoteModel, expires);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPublish() {
        return _publish;
    }

    @Override
    public void setPublish(long publish) {
        _publish = publish;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setPublish", long.class);

                method.invoke(_ahOfferRemoteModel, publish);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAdressId() {
        return _adressId;
    }

    @Override
    public void setAdressId(long adressId) {
        _adressId = adressId;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setAdressId", long.class);

                method.invoke(_ahOfferRemoteModel, adressId);
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

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId", long.class);

                method.invoke(_ahOfferRemoteModel, contactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSndContactId() {
        return _sndContactId;
    }

    @Override
    public void setSndContactId(long sndContactId) {
        _sndContactId = sndContactId;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setSndContactId", long.class);

                method.invoke(_ahOfferRemoteModel, sndContactId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getContactAgency() {
        return _contactAgency;
    }

    @Override
    public boolean isContactAgency() {
        return _contactAgency;
    }

    @Override
    public void setContactAgency(boolean contactAgency) {
        _contactAgency = contactAgency;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setContactAgency",
                        boolean.class);

                method.invoke(_ahOfferRemoteModel, contactAgency);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getOrgId() {
        return _orgId;
    }

    @Override
    public void setOrgId(long orgId) {
        _orgId = orgId;

        if (_ahOfferRemoteModel != null) {
            try {
                Class<?> clazz = _ahOfferRemoteModel.getClass();

                Method method = clazz.getMethod("setOrgId", long.class);

                method.invoke(_ahOfferRemoteModel, orgId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAHOfferRemoteModel() {
        return _ahOfferRemoteModel;
    }

    public void setAHOfferRemoteModel(BaseModel<?> ahOfferRemoteModel) {
        _ahOfferRemoteModel = ahOfferRemoteModel;
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

        Class<?> remoteModelClass = _ahOfferRemoteModel.getClass();

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

        Object returnValue = method.invoke(_ahOfferRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHOfferLocalServiceUtil.addAHOffer(this);
        } else {
            AHOfferLocalServiceUtil.updateAHOffer(this);
        }
    }

    @Override
    public AHOffer toEscapedModel() {
        return (AHOffer) ProxyUtil.newProxyInstance(AHOffer.class.getClassLoader(),
            new Class[] { AHOffer.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AHOfferClp clone = new AHOfferClp();

        clone.setOfferId(getOfferId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setWorkTime(getWorkTime());
        clone.setWorkType(getWorkType());
        clone.setType(getType());
        clone.setStatus(getStatus());
        clone.setSocialStatus(getSocialStatus());
        clone.setCreated(getCreated());
        clone.setUpdated(getUpdated());
        clone.setExpires(getExpires());
        clone.setPublish(getPublish());
        clone.setAdressId(getAdressId());
        clone.setContactId(getContactId());
        clone.setSndContactId(getSndContactId());
        clone.setContactAgency(getContactAgency());
        clone.setOrgId(getOrgId());

        return clone;
    }

    @Override
    public int compareTo(AHOffer ahOffer) {
        int value = 0;

        if (getUpdated() < ahOffer.getUpdated()) {
            value = -1;
        } else if (getUpdated() > ahOffer.getUpdated()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        if (getStatus() < ahOffer.getStatus()) {
            value = -1;
        } else if (getStatus() > ahOffer.getStatus()) {
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

        if (!(obj instanceof AHOfferClp)) {
            return false;
        }

        AHOfferClp ahOffer = (AHOfferClp) obj;

        long primaryKey = ahOffer.getPrimaryKey();

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
        StringBundler sb = new StringBundler(35);

        sb.append("{offerId=");
        sb.append(getOfferId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", workTime=");
        sb.append(getWorkTime());
        sb.append(", workType=");
        sb.append(getWorkType());
        sb.append(", type=");
        sb.append(getType());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", socialStatus=");
        sb.append(getSocialStatus());
        sb.append(", created=");
        sb.append(getCreated());
        sb.append(", updated=");
        sb.append(getUpdated());
        sb.append(", expires=");
        sb.append(getExpires());
        sb.append(", publish=");
        sb.append(getPublish());
        sb.append(", adressId=");
        sb.append(getAdressId());
        sb.append(", contactId=");
        sb.append(getContactId());
        sb.append(", sndContactId=");
        sb.append(getSndContactId());
        sb.append(", contactAgency=");
        sb.append(getContactAgency());
        sb.append(", orgId=");
        sb.append(getOrgId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.particity.model.AHOffer");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>offerId</column-name><column-value><![CDATA[");
        sb.append(getOfferId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>workTime</column-name><column-value><![CDATA[");
        sb.append(getWorkTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>workType</column-name><column-value><![CDATA[");
        sb.append(getWorkType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialStatus</column-name><column-value><![CDATA[");
        sb.append(getSocialStatus());
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
            "<column><column-name>expires</column-name><column-value><![CDATA[");
        sb.append(getExpires());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publish</column-name><column-value><![CDATA[");
        sb.append(getPublish());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>adressId</column-name><column-value><![CDATA[");
        sb.append(getAdressId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sndContactId</column-name><column-value><![CDATA[");
        sb.append(getSndContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactAgency</column-name><column-value><![CDATA[");
        sb.append(getContactAgency());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orgId</column-name><column-value><![CDATA[");
        sb.append(getOrgId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
