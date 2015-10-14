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
public class AHContactSoap implements Serializable {
    private long _contactId;
    private String _forename;
    private String _surname;
    private String _tel;
    private String _mobile;
    private String _fax;
    private String _email;
    private String _www;

    public AHContactSoap() {
    }

    public static AHContactSoap toSoapModel(AHContact model) {
        AHContactSoap soapModel = new AHContactSoap();

        soapModel.setContactId(model.getContactId());
        soapModel.setForename(model.getForename());
        soapModel.setSurname(model.getSurname());
        soapModel.setTel(model.getTel());
        soapModel.setMobile(model.getMobile());
        soapModel.setFax(model.getFax());
        soapModel.setEmail(model.getEmail());
        soapModel.setWww(model.getWww());

        return soapModel;
    }

    public static AHContactSoap[] toSoapModels(AHContact[] models) {
        AHContactSoap[] soapModels = new AHContactSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHContactSoap[][] toSoapModels(AHContact[][] models) {
        AHContactSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHContactSoap[models.length][models[0].length];
        } else {
            soapModels = new AHContactSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHContactSoap[] toSoapModels(List<AHContact> models) {
        List<AHContactSoap> soapModels = new ArrayList<AHContactSoap>(models.size());

        for (AHContact model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHContactSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactId;
    }

    public void setPrimaryKey(long pk) {
        setContactId(pk);
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public String getForename() {
        return _forename;
    }

    public void setForename(String forename) {
        _forename = forename;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String surname) {
        _surname = surname;
    }

    public String getTel() {
        return _tel;
    }

    public void setTel(String tel) {
        _tel = tel;
    }

    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getWww() {
        return _www;
    }

    public void setWww(String www) {
        _www = www;
    }
}
