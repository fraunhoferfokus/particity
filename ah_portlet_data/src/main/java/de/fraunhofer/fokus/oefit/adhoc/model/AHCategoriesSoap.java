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
