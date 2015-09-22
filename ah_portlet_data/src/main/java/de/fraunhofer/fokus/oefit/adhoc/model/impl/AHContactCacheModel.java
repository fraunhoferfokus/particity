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

import de.fraunhofer.fokus.oefit.adhoc.model.AHContact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHContact
 * @generated
 */
public class AHContactCacheModel implements CacheModel<AHContact>,
    Externalizable {
    public long contactId;
    public String forename;
    public String surname;
    public String tel;
    public String mobile;
    public String fax;
    public String email;
    public String www;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{contactId=");
        sb.append(contactId);
        sb.append(", forename=");
        sb.append(forename);
        sb.append(", surname=");
        sb.append(surname);
        sb.append(", tel=");
        sb.append(tel);
        sb.append(", mobile=");
        sb.append(mobile);
        sb.append(", fax=");
        sb.append(fax);
        sb.append(", email=");
        sb.append(email);
        sb.append(", www=");
        sb.append(www);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHContact toEntityModel() {
        AHContactImpl ahContactImpl = new AHContactImpl();

        ahContactImpl.setContactId(contactId);

        if (forename == null) {
            ahContactImpl.setForename(StringPool.BLANK);
        } else {
            ahContactImpl.setForename(forename);
        }

        if (surname == null) {
            ahContactImpl.setSurname(StringPool.BLANK);
        } else {
            ahContactImpl.setSurname(surname);
        }

        if (tel == null) {
            ahContactImpl.setTel(StringPool.BLANK);
        } else {
            ahContactImpl.setTel(tel);
        }

        if (mobile == null) {
            ahContactImpl.setMobile(StringPool.BLANK);
        } else {
            ahContactImpl.setMobile(mobile);
        }

        if (fax == null) {
            ahContactImpl.setFax(StringPool.BLANK);
        } else {
            ahContactImpl.setFax(fax);
        }

        if (email == null) {
            ahContactImpl.setEmail(StringPool.BLANK);
        } else {
            ahContactImpl.setEmail(email);
        }

        if (www == null) {
            ahContactImpl.setWww(StringPool.BLANK);
        } else {
            ahContactImpl.setWww(www);
        }

        ahContactImpl.resetOriginalValues();

        return ahContactImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        contactId = objectInput.readLong();
        forename = objectInput.readUTF();
        surname = objectInput.readUTF();
        tel = objectInput.readUTF();
        mobile = objectInput.readUTF();
        fax = objectInput.readUTF();
        email = objectInput.readUTF();
        www = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(contactId);

        if (forename == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(forename);
        }

        if (surname == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(surname);
        }

        if (tel == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tel);
        }

        if (mobile == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mobile);
        }

        if (fax == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fax);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (www == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(www);
        }
    }
}
