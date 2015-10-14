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
public class AHCatEntriesSoap implements Serializable {
    private long _itemId;
    private long _catId;
    private String _name;
    private String _descr;
    private long _parentId;

    public AHCatEntriesSoap() {
    }

    public static AHCatEntriesSoap toSoapModel(AHCatEntries model) {
        AHCatEntriesSoap soapModel = new AHCatEntriesSoap();

        soapModel.setItemId(model.getItemId());
        soapModel.setCatId(model.getCatId());
        soapModel.setName(model.getName());
        soapModel.setDescr(model.getDescr());
        soapModel.setParentId(model.getParentId());

        return soapModel;
    }

    public static AHCatEntriesSoap[] toSoapModels(AHCatEntries[] models) {
        AHCatEntriesSoap[] soapModels = new AHCatEntriesSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHCatEntriesSoap[][] toSoapModels(AHCatEntries[][] models) {
        AHCatEntriesSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHCatEntriesSoap[models.length][models[0].length];
        } else {
            soapModels = new AHCatEntriesSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHCatEntriesSoap[] toSoapModels(List<AHCatEntries> models) {
        List<AHCatEntriesSoap> soapModels = new ArrayList<AHCatEntriesSoap>(models.size());

        for (AHCatEntries model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHCatEntriesSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _itemId;
    }

    public void setPrimaryKey(long pk) {
        setItemId(pk);
    }

    public long getItemId() {
        return _itemId;
    }

    public void setItemId(long itemId) {
        _itemId = itemId;
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

    public long getParentId() {
        return _parentId;
    }

    public void setParentId(long parentId) {
        _parentId = parentId;
    }
}
