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
