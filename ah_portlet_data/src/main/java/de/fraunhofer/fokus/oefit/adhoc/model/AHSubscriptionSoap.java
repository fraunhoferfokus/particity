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
public class AHSubscriptionSoap implements Serializable {
    private long _subId;
    private String _uuid;
    private String _email;
    private int _status;
    private long _created;

    public AHSubscriptionSoap() {
    }

    public static AHSubscriptionSoap toSoapModel(AHSubscription model) {
        AHSubscriptionSoap soapModel = new AHSubscriptionSoap();

        soapModel.setSubId(model.getSubId());
        soapModel.setUuid(model.getUuid());
        soapModel.setEmail(model.getEmail());
        soapModel.setStatus(model.getStatus());
        soapModel.setCreated(model.getCreated());

        return soapModel;
    }

    public static AHSubscriptionSoap[] toSoapModels(AHSubscription[] models) {
        AHSubscriptionSoap[] soapModels = new AHSubscriptionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AHSubscriptionSoap[][] toSoapModels(AHSubscription[][] models) {
        AHSubscriptionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AHSubscriptionSoap[models.length][models[0].length];
        } else {
            soapModels = new AHSubscriptionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AHSubscriptionSoap[] toSoapModels(List<AHSubscription> models) {
        List<AHSubscriptionSoap> soapModels = new ArrayList<AHSubscriptionSoap>(models.size());

        for (AHSubscription model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AHSubscriptionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _subId;
    }

    public void setPrimaryKey(long pk) {
        setSubId(pk);
    }

    public long getSubId() {
        return _subId;
    }

    public void setSubId(long subId) {
        _subId = subId;
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public long getCreated() {
        return _created;
    }

    public void setCreated(long created) {
        _created = created;
    }
}
