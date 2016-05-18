package de.fraunhofer.fokus.oefit.particity.model;

import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHRegionSoap implements Serializable {
    private long _regionId;
    private String _zip;
    private String _city;
    private String _country;
    private int _permissions;

    public AHRegionSoap() {
    }

    public static AHRegionSoap toSoapModel(AHRegion model) {
        AHRegionSoap soapModel = new AHRegionSoap();

        soapModel.setRegionId(model.getRegionId());
        soapModel.setZip(model.getZip());
        soapModel.setCity(model.getCity());
        soapModel.setCountry(model.getCountry());
        soapModel.setPermissions(model.getPermissions());

        return soapModel;
    }

    public static AHRegionSoap[] toSoapModels(AHRegion[] models) {
        AHRegionSoap[] soapModels = new AHRegionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHRegionSoap[][] toSoapModels(AHRegion[][] models) {
        AHRegionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHRegionSoap[models.length][models[0].length];
        } else {
            soapModels = new AHRegionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHRegionSoap[] toSoapModels(List<AHRegion> models) {
        List<AHRegionSoap> soapModels = new ArrayList<AHRegionSoap>(models.size());

        for (AHRegion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHRegionSoap[soapModels.size()]);
    }

    public AHRegionPK getPrimaryKey() {
        return new AHRegionPK(_regionId, _zip, _city, _country);
    }

    public void setPrimaryKey(AHRegionPK pk) {
        setRegionId(pk.regionId);
        setZip(pk.zip);
        setCity(pk.city);
        setCountry(pk.country);
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
    }

    public String getZip() {
        return _zip;
    }

    public void setZip(String zip) {
        _zip = zip;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public int getPermissions() {
        return _permissions;
    }

    public void setPermissions(int permissions) {
        _permissions = permissions;
    }
}
