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

import de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHSubscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscription
 * @generated
 */
public class AHSubscriptionCacheModel implements CacheModel<AHSubscription>,
    Externalizable {
    public long subId;
    public String uuid;
    public String email;
    public int status;
    public long created;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{subId=");
        sb.append(subId);
        sb.append(", uuid=");
        sb.append(uuid);
        sb.append(", email=");
        sb.append(email);
        sb.append(", status=");
        sb.append(status);
        sb.append(", created=");
        sb.append(created);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHSubscription toEntityModel() {
        AHSubscriptionImpl ahSubscriptionImpl = new AHSubscriptionImpl();

        ahSubscriptionImpl.setSubId(subId);

        if (uuid == null) {
            ahSubscriptionImpl.setUuid(StringPool.BLANK);
        } else {
            ahSubscriptionImpl.setUuid(uuid);
        }

        if (email == null) {
            ahSubscriptionImpl.setEmail(StringPool.BLANK);
        } else {
            ahSubscriptionImpl.setEmail(email);
        }

        ahSubscriptionImpl.setStatus(status);
        ahSubscriptionImpl.setCreated(created);

        ahSubscriptionImpl.resetOriginalValues();

        return ahSubscriptionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        subId = objectInput.readLong();
        uuid = objectInput.readUTF();
        email = objectInput.readUTF();
        status = objectInput.readInt();
        created = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(subId);

        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        objectOutput.writeInt(status);
        objectOutput.writeLong(created);
    }
}
