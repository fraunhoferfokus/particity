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

import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHRegionPK;

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
    private int _zip;
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

    public int getZip() {
        return _zip;
    }

    public void setZip(int zip) {
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
