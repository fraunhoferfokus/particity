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

import de.fraunhofer.fokus.oefit.adhoc.model.AHOrg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHOrg in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHOrg
 * @generated
 */
public class AHOrgCacheModel implements CacheModel<AHOrg>, Externalizable {
    public long orgId;
    public String name;
    public String holder;
    public String owner;
    public String userlist;
    public String description;
    public String legalStatus;
    public long created;
    public long updated;
    public long contactId;
    public long addressId;
    public int status;
    public String logoLocation;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{orgId=");
        sb.append(orgId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", holder=");
        sb.append(holder);
        sb.append(", owner=");
        sb.append(owner);
        sb.append(", userlist=");
        sb.append(userlist);
        sb.append(", description=");
        sb.append(description);
        sb.append(", legalStatus=");
        sb.append(legalStatus);
        sb.append(", created=");
        sb.append(created);
        sb.append(", updated=");
        sb.append(updated);
        sb.append(", contactId=");
        sb.append(contactId);
        sb.append(", addressId=");
        sb.append(addressId);
        sb.append(", status=");
        sb.append(status);
        sb.append(", logoLocation=");
        sb.append(logoLocation);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHOrg toEntityModel() {
        AHOrgImpl ahOrgImpl = new AHOrgImpl();

        ahOrgImpl.setOrgId(orgId);

        if (name == null) {
            ahOrgImpl.setName(StringPool.BLANK);
        } else {
            ahOrgImpl.setName(name);
        }

        if (holder == null) {
            ahOrgImpl.setHolder(StringPool.BLANK);
        } else {
            ahOrgImpl.setHolder(holder);
        }

        if (owner == null) {
            ahOrgImpl.setOwner(StringPool.BLANK);
        } else {
            ahOrgImpl.setOwner(owner);
        }

        if (userlist == null) {
            ahOrgImpl.setUserlist(StringPool.BLANK);
        } else {
            ahOrgImpl.setUserlist(userlist);
        }

        if (description == null) {
            ahOrgImpl.setDescription(StringPool.BLANK);
        } else {
            ahOrgImpl.setDescription(description);
        }

        if (legalStatus == null) {
            ahOrgImpl.setLegalStatus(StringPool.BLANK);
        } else {
            ahOrgImpl.setLegalStatus(legalStatus);
        }

        ahOrgImpl.setCreated(created);
        ahOrgImpl.setUpdated(updated);
        ahOrgImpl.setContactId(contactId);
        ahOrgImpl.setAddressId(addressId);
        ahOrgImpl.setStatus(status);

        if (logoLocation == null) {
            ahOrgImpl.setLogoLocation(StringPool.BLANK);
        } else {
            ahOrgImpl.setLogoLocation(logoLocation);
        }

        ahOrgImpl.resetOriginalValues();

        return ahOrgImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        orgId = objectInput.readLong();
        name = objectInput.readUTF();
        holder = objectInput.readUTF();
        owner = objectInput.readUTF();
        userlist = objectInput.readUTF();
        description = objectInput.readUTF();
        legalStatus = objectInput.readUTF();
        created = objectInput.readLong();
        updated = objectInput.readLong();
        contactId = objectInput.readLong();
        addressId = objectInput.readLong();
        status = objectInput.readInt();
        logoLocation = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(orgId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (holder == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(holder);
        }

        if (owner == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(owner);
        }

        if (userlist == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userlist);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (legalStatus == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(legalStatus);
        }

        objectOutput.writeLong(created);
        objectOutput.writeLong(updated);
        objectOutput.writeLong(contactId);
        objectOutput.writeLong(addressId);
        objectOutput.writeInt(status);

        if (logoLocation == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logoLocation);
        }
    }
}
