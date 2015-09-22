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
public class AHAddrSoap implements Serializable {
    private long _addrId;
    private String _street;
    private String _number;
    private String _coordLat;
    private String _coordLon;
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

    public String getCoordLat() {
        return _coordLat;
    }

    public void setCoordLat(String coordLat) {
        _coordLat = coordLat;
    }

    public String getCoordLon() {
        return _coordLon;
    }

    public void setCoordLon(String coordLon) {
        _coordLon = coordLon;
    }

    public long getRegionId() {
        return _regionId;
    }

    public void setRegionId(long regionId) {
        _regionId = regionId;
    }
}
