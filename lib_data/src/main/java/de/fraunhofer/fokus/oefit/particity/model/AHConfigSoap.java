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
public class AHConfigSoap implements Serializable {
    private String _name;
    private String _value;

    public AHConfigSoap() {
    }

    public static AHConfigSoap toSoapModel(AHConfig model) {
        AHConfigSoap soapModel = new AHConfigSoap();

        soapModel.setName(model.getName());
        soapModel.setValue(model.getValue());

        return soapModel;
    }

    public static AHConfigSoap[] toSoapModels(AHConfig[] models) {
        AHConfigSoap[] soapModels = new AHConfigSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHConfigSoap[][] toSoapModels(AHConfig[][] models) {
        AHConfigSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHConfigSoap[models.length][models[0].length];
        } else {
            soapModels = new AHConfigSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHConfigSoap[] toSoapModels(List<AHConfig> models) {
        List<AHConfigSoap> soapModels = new ArrayList<AHConfigSoap>(models.size());

        for (AHConfig model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHConfigSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _name;
    }

    public void setPrimaryKey(String pk) {
        setName(pk);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }
}
