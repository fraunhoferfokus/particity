package de.fraunhofer.fokus.oefit.particity.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHSubscriptionSoap implements Serializable {
    private long _subId;
    private String _uuid;
    private String _email;
    private int _status;
    private long _created;

    public AHSubscriptionSoap() {
    }

    public static AHSubscriptionSoap toSoapModel(AHSubscription model) {
        AHSubscriptionSoap soapModel = new AHSubscriptionSoap();

        soapModel.setSubId(model.getSubId());
        soapModel.setUuid(model.getUuid());
        soapModel.setEmail(model.getEmail());
        soapModel.setStatus(model.getStatus());
        soapModel.setCreated(model.getCreated());

        return soapModel;
    }

    public static AHSubscriptionSoap[] toSoapModels(AHSubscription[] models) {
        AHSubscriptionSoap[] soapModels = new AHSubscriptionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHSubscriptionSoap[][] toSoapModels(AHSubscription[][] models) {
        AHSubscriptionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHSubscriptionSoap[models.length][models[0].length];
        } else {
            soapModels = new AHSubscriptionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHSubscriptionSoap[] toSoapModels(List<AHSubscription> models) {
        List<AHSubscriptionSoap> soapModels = new ArrayList<AHSubscriptionSoap>(models.size());

        for (AHSubscription model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHSubscriptionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _subId;
    }

    public void setPrimaryKey(long pk) {
        setSubId(pk);
    }

    public long getSubId() {
        return _subId;
    }

    public void setSubId(long subId) {
        _subId = subId;
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getCreated() {
        return _created;
    }

    public void setCreated(long created) {
        _created = created;
    }
}
