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
public class AHAddrSoap implements Serializable {
    private long _addrId;
    private String _street;
    private String _number;
    private float _coordLat;
    private float _coordLon;
    private long _regionId;

    public AHAddrSoap() {
    }

    public static AHAddrSoap toSoapModel(AHAddr model) {
        AHAddrSoap soapModel = new AHAddrSoap();

        soapModel.setAddrId(model.getAddrId());
        soapModel.setStreet(model.getStreet());
        soapModel.setNumber(model.getNumber());
        soapModel.setCoordLat(model.getCoordLat());
        soapModel.setCoordLon(model.getCoordLon());
        soapModel.setRegionId(model.getRegionId());

        return soapModel;
    }

    public static AHAddrSoap[] toSoapModels(AHAddr[] models) {
        AHAddrSoap[] soapModels = new AHAddrSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHAddrSoap[][] toSoapModels(AHAddr[][] models) {
        AHAddrSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHAddrSoap[models.length][models[0].length];
        } else {
            soapModels = new AHAddrSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHAddrSoap[] toSoapModels(List<AHAddr> models) {
        List<AHAddrSoap> soapModels = new ArrayList<AHAddrSoap>(models.size());

        for (AHAddr model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHAddrSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _addrId;
    }

    public void setPrimaryKey(long pk) {
        setAddrId(pk);
    }

    public long getAddrId() {
        return _addrId;
    }

    public void setAddrId(long addrId) {
        _addrId = addrId;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String street) {
        _street = street;
    }

    public String getNumber() {
        return _number;
    }

    public void setNumber(String number) {
        _number = number;
    }

    public float getCoordLat() {
        return _coordLat;
    }

    public void setCoordLat(float coordLat) {
        _coordLat = coordLat;
    }

    public float getCoordLon() {
        return _coordLon;
    }

    public void setCoordLon(float coordLon) {
        _coordLon = coordLon;
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
    }
}
