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
public class AHContactSoap implements Serializable {
    private long _contactId;
    private String _forename;
    private String _surname;
    private String _tel;
    private String _mobile;
    private String _fax;
    private String _email;
    private String _www;

    public AHContactSoap() {
    }

    public static AHContactSoap toSoapModel(AHContact model) {
        AHContactSoap soapModel = new AHContactSoap();

        soapModel.setContactId(model.getContactId());
        soapModel.setForename(model.getForename());
        soapModel.setSurname(model.getSurname());
        soapModel.setTel(model.getTel());
        soapModel.setMobile(model.getMobile());
        soapModel.setFax(model.getFax());
        soapModel.setEmail(model.getEmail());
        soapModel.setWww(model.getWww());

        return soapModel;
    }

    public static AHContactSoap[] toSoapModels(AHContact[] models) {
        AHContactSoap[] soapModels = new AHContactSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHContactSoap[][] toSoapModels(AHContact[][] models) {
        AHContactSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHContactSoap[models.length][models[0].length];
        } else {
            soapModels = new AHContactSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHContactSoap[] toSoapModels(List<AHContact> models) {
        List<AHContactSoap> soapModels = new ArrayList<AHContactSoap>(models.size());

        for (AHContact model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHContactSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactId;
    }

    public void setPrimaryKey(long pk) {
        setContactId(pk);
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public String getForename() {
        return _forename;
    }

    public void setForename(String forename) {
        _forename = forename;
    }

    public String getSurname() {
        return _surname;
    }

    public void setSurname(String surname) {
        _surname = surname;
    }

    public String getTel() {
        return _tel;
    }

    public void setTel(String tel) {
        _tel = tel;
    }

    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getWww() {
        return _www;
    }

    public void setWww(String www) {
        _www = www;
    }
}
