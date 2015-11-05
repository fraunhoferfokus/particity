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
public class AHCategoriesSoap implements Serializable {
    private long _catId;
    private String _name;
    private String _descr;
    private int _type;

    public AHCategoriesSoap() {
    }

    public static AHCategoriesSoap toSoapModel(AHCategories model) {
        AHCategoriesSoap soapModel = new AHCategoriesSoap();

        soapModel.setCatId(model.getCatId());
        soapModel.setName(model.getName());
        soapModel.setDescr(model.getDescr());
        soapModel.setType(model.getType());

        return soapModel;
    }

    public static AHCategoriesSoap[] toSoapModels(AHCategories[] models) {
        AHCategoriesSoap[] soapModels = new AHCategoriesSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHCategoriesSoap[][] toSoapModels(AHCategories[][] models) {
        AHCategoriesSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHCategoriesSoap[models.length][models[0].length];
        } else {
            soapModels = new AHCategoriesSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHCategoriesSoap[] toSoapModels(List<AHCategories> models) {
        List<AHCategoriesSoap> soapModels = new ArrayList<AHCategoriesSoap>(models.size());

        for (AHCategories model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHCategoriesSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _catId;
    }

    public void setPrimaryKey(long pk) {
        setCatId(pk);
    }

    public long getCatId() {
        return _catId;
    }

    public void setCatId(long catId) {
        _catId = catId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescr() {
        return _descr;
    }

    public void setDescr(String descr) {
        _descr = descr;
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }
}
