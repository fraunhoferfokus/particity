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
package de.fraunhofer.fokus.oefit.adhoc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.adhoc.model.AHOffer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHOffer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHOffer
 * @generated
 */
public class AHOfferCacheModel implements CacheModel<AHOffer>, Externalizable {
    public long offerId;
    public String title;
    public String description;
    public String workTime;
    public int workType;
    public int type;
    public int status;
    public int socialStatus;
    public long created;
    public long updated;
    public long expires;
    public long publish;
    public long adressId;
    public long contactId;
    public long sndContactId;
    public boolean contactAgency;
    public long orgId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{offerId=");
        sb.append(offerId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", workTime=");
        sb.append(workTime);
        sb.append(", workType=");
        sb.append(workType);
        sb.append(", type=");
        sb.append(type);
        sb.append(", status=");
        sb.append(status);
        sb.append(", socialStatus=");
        sb.append(socialStatus);
        sb.append(", created=");
        sb.append(created);
        sb.append(", updated=");
        sb.append(updated);
        sb.append(", expires=");
        sb.append(expires);
        sb.append(", publish=");
        sb.append(publish);
        sb.append(", adressId=");
        sb.append(adressId);
        sb.append(", contactId=");
        sb.append(contactId);
        sb.append(", sndContactId=");
        sb.append(sndContactId);
        sb.append(", contactAgency=");
        sb.append(contactAgency);
        sb.append(", orgId=");
        sb.append(orgId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHOffer toEntityModel() {
        AHOfferImpl ahOfferImpl = new AHOfferImpl();

        ahOfferImpl.setOfferId(offerId);

        if (title == null) {
            ahOfferImpl.setTitle(StringPool.BLANK);
        } else {
            ahOfferImpl.setTitle(title);
        }

        if (description == null) {
            ahOfferImpl.setDescription(StringPool.BLANK);
        } else {
            ahOfferImpl.setDescription(description);
        }

        if (workTime == null) {
            ahOfferImpl.setWorkTime(StringPool.BLANK);
        } else {
            ahOfferImpl.setWorkTime(workTime);
        }

        ahOfferImpl.setWorkType(workType);
        ahOfferImpl.setType(type);
        ahOfferImpl.setStatus(status);
        ahOfferImpl.setSocialStatus(socialStatus);
        ahOfferImpl.setCreated(created);
        ahOfferImpl.setUpdated(updated);
        ahOfferImpl.setExpires(expires);
        ahOfferImpl.setPublish(publish);
        ahOfferImpl.setAdressId(adressId);
        ahOfferImpl.setContactId(contactId);
        ahOfferImpl.setSndContactId(sndContactId);
        ahOfferImpl.setContactAgency(contactAgency);
        ahOfferImpl.setOrgId(orgId);

        ahOfferImpl.resetOriginalValues();

        return ahOfferImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        offerId = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        workTime = objectInput.readUTF();
        workType = objectInput.readInt();
        type = objectInput.readInt();
        status = objectInput.readInt();
        socialStatus = objectInput.readInt();
        created = objectInput.readLong();
        updated = objectInput.readLong();
        expires = objectInput.readLong();
        publish = objectInput.readLong();
        adressId = objectInput.readLong();
        contactId = objectInput.readLong();
        sndContactId = objectInput.readLong();
        contactAgency = objectInput.readBoolean();
        orgId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(offerId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (workTime == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(workTime);
        }

        objectOutput.writeInt(workType);
        objectOutput.writeInt(type);
        objectOutput.writeInt(status);
        objectOutput.writeInt(socialStatus);
        objectOutput.writeLong(created);
        objectOutput.writeLong(updated);
        objectOutput.writeLong(expires);
        objectOutput.writeLong(publish);
        objectOutput.writeLong(adressId);
        objectOutput.writeLong(contactId);
        objectOutput.writeLong(sndContactId);
        objectOutput.writeBoolean(contactAgency);
        objectOutput.writeLong(orgId);
    }
}
