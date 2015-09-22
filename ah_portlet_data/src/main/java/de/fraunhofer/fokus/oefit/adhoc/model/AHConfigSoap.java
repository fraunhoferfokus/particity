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
