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
public class AHOfferSoap implements Serializable {
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

    public AHOfferSoap() {
    }

    public static AHOfferSoap toSoapModel(AHOffer model) {
        AHOfferSoap soapModel = new AHOfferSoap();

        soapModel.setOfferId(model.getOfferId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setWorkTime(model.getWorkTime());
        soapModel.setWorkType(model.getWorkType());
        soapModel.setType(model.getType());
        soapModel.setStatus(model.getStatus());
        soapModel.setSocialStatus(model.getSocialStatus());
        soapModel.setCreated(model.getCreated());
        soapModel.setUpdated(model.getUpdated());
        soapModel.setExpires(model.getExpires());
        soapModel.setPublish(model.getPublish());
        soapModel.setAdressId(model.getAdressId());
        soapModel.setContactId(model.getContactId());
        soapModel.setSndContactId(model.getSndContactId());
        soapModel.setContactAgency(model.getContactAgency());
        soapModel.setOrgId(model.getOrgId());

        return soapModel;
    }

    public static AHOfferSoap[] toSoapModels(AHOffer[] models) {
        AHOfferSoap[] soapModels = new AHOfferSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHOfferSoap[][] toSoapModels(AHOffer[][] models) {
        AHOfferSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHOfferSoap[models.length][models[0].length];
        } else {
            soapModels = new AHOfferSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHOfferSoap[] toSoapModels(List<AHOffer> models) {
        List<AHOfferSoap> soapModels = new ArrayList<AHOfferSoap>(models.size());

        for (AHOffer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHOfferSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _offerId;
    }

    public void setPrimaryKey(long pk) {
        setOfferId(pk);
    }

    public long getOfferId() {
        return _offerId;
    }

    public void setOfferId(long offerId) {
        _offerId = offerId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getWorkTime() {
        return _workTime;
    }

    public void setWorkTime(String workTime) {
        _workTime = workTime;
    }

    public int getWorkType() {
        return _workType;
    }

    public void setWorkType(int workType) {
        _workType = workType;
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public int getSocialStatus() {
        return _socialStatus;
    }

    public void setSocialStatus(int socialStatus) {
        _socialStatus = socialStatus;
    }

    public long getCreated() {
        return _created;
    }

    public void setCreated(long created) {
        _created = created;
    }

    public long getUpdated() {
        return _updated;
    }

    public void setUpdated(long updated) {
        _updated = updated;
    }

    public long getExpires() {
        return _expires;
    }

    public void setExpires(long expires) {
        _expires = expires;
    }

    public long getPublish() {
        return _publish;
    }

    public void setPublish(long publish) {
        _publish = publish;
    }

    public long getAdressId() {
        return _adressId;
    }

    public void setAdressId(long adressId) {
        _adressId = adressId;
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public long getSndContactId() {
        return _sndContactId;
    }

    public void setSndContactId(long sndContactId) {
        _sndContactId = sndContactId;
    }

    public boolean getContactAgency() {
        return _contactAgency;
    }

    public boolean isContactAgency() {
        return _contactAgency;
    }

    public void setContactAgency(boolean contactAgency) {
        _contactAgency = contactAgency;
    }

    public long getOrgId() {
        return _orgId;
    }

    public void setOrgId(long orgId) {
        _orgId = orgId;
    }
}
