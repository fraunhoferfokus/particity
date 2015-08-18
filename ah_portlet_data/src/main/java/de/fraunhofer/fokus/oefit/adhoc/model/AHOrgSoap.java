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
public class AHOrgSoap implements Serializable {
    private long _orgId;
    private String _name;
    private String _holder;
    private String _owner;
    private String _userlist;
    private String _description;
    private String _legalStatus;
    private long _created;
    private long _updated;
    private long _contactId;
    private long _addressId;
    private int _status;
    private String _logoLocation;

    public AHOrgSoap() {
    }

    public static AHOrgSoap toSoapModel(AHOrg model) {
        AHOrgSoap soapModel = new AHOrgSoap();

        soapModel.setOrgId(model.getOrgId());
        soapModel.setName(model.getName());
        soapModel.setHolder(model.getHolder());
        soapModel.setOwner(model.getOwner());
        soapModel.setUserlist(model.getUserlist());
        soapModel.setDescription(model.getDescription());
        soapModel.setLegalStatus(model.getLegalStatus());
        soapModel.setCreated(model.getCreated());
        soapModel.setUpdated(model.getUpdated());
        soapModel.setContactId(model.getContactId());
        soapModel.setAddressId(model.getAddressId());
        soapModel.setStatus(model.getStatus());
        soapModel.setLogoLocation(model.getLogoLocation());

        return soapModel;
    }

    public static AHOrgSoap[] toSoapModels(AHOrg[] models) {
        AHOrgSoap[] soapModels = new AHOrgSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHOrgSoap[][] toSoapModels(AHOrg[][] models) {
        AHOrgSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHOrgSoap[models.length][models[0].length];
        } else {
            soapModels = new AHOrgSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHOrgSoap[] toSoapModels(List<AHOrg> models) {
        List<AHOrgSoap> soapModels = new ArrayList<AHOrgSoap>(models.size());

        for (AHOrg model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHOrgSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _orgId;
    }

    public void setPrimaryKey(long pk) {
        setOrgId(pk);
    }

    public long getOrgId() {
        return _orgId;
    }

    public void setOrgId(long orgId) {
        _orgId = orgId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getHolder() {
        return _holder;
    }

    public void setHolder(String holder) {
        _holder = holder;
    }

    public String getOwner() {
        return _owner;
    }

    public void setOwner(String owner) {
        _owner = owner;
    }

    public String getUserlist() {
        return _userlist;
    }

    public void setUserlist(String userlist) {
        _userlist = userlist;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getLegalStatus() {
        return _legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        _legalStatus = legalStatus;
    }

    public long getCreated() {
        return _created;
    }

    public void setCreated(long created) {
        _created = created;
    }

    public long getUpdated() {
        return _updated;
    }

    public void setUpdated(long updated) {
        _updated = updated;
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public long getAddressId() {
        return _addressId;
    }

    public void setAddressId(long addressId) {
        _addressId = addressId;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public String getLogoLocation() {
        return _logoLocation;
    }

    public void setLogoLocation(String logoLocation) {
        _logoLocation = logoLocation;
    }
}
