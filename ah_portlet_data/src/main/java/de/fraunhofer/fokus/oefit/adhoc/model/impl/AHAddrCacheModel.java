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

import de.fraunhofer.fokus.oefit.adhoc.model.AHAddr;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHAddr in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHAddr
 * @generated
 */
public class AHAddrCacheModel implements CacheModel<AHAddr>, Externalizable {
    public long addrId;
    public String street;
    public String number;
    public String coordLat;
    public String coordLon;
    public long regionId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{addrId=");
        sb.append(addrId);
        sb.append(", street=");
        sb.append(street);
        sb.append(", number=");
        sb.append(number);
        sb.append(", coordLat=");
        sb.append(coordLat);
        sb.append(", coordLon=");
        sb.append(coordLon);
        sb.append(", regionId=");
        sb.append(regionId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHAddr toEntityModel() {
        AHAddrImpl ahAddrImpl = new AHAddrImpl();

        ahAddrImpl.setAddrId(addrId);

        if (street == null) {
            ahAddrImpl.setStreet(StringPool.BLANK);
        } else {
            ahAddrImpl.setStreet(street);
        }

        if (number == null) {
            ahAddrImpl.setNumber(StringPool.BLANK);
        } else {
            ahAddrImpl.setNumber(number);
        }

        if (coordLat == null) {
            ahAddrImpl.setCoordLat(StringPool.BLANK);
        } else {
            ahAddrImpl.setCoordLat(coordLat);
        }

        if (coordLon == null) {
            ahAddrImpl.setCoordLon(StringPool.BLANK);
        } else {
            ahAddrImpl.setCoordLon(coordLon);
        }

        ahAddrImpl.setRegionId(regionId);

        ahAddrImpl.resetOriginalValues();

        return ahAddrImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        addrId = objectInput.readLong();
        street = objectInput.readUTF();
        number = objectInput.readUTF();
        coordLat = objectInput.readUTF();
        coordLon = objectInput.readUTF();
        regionId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(addrId);

        if (street == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(street);
        }

        if (number == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(number);
        }

        if (coordLat == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(coordLat);
        }

        if (coordLon == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(coordLon);
        }

        objectOutput.writeLong(regionId);
    }
}
