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

import de.fraunhofer.fokus.oefit.adhoc.model.AHRegion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHRegion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHRegion
 * @generated
 */
public class AHRegionCacheModel implements CacheModel<AHRegion>, Externalizable {
    public long regionId;
    public int zip;
    public String city;
    public String country;
    public int permissions;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{regionId=");
        sb.append(regionId);
        sb.append(", zip=");
        sb.append(zip);
        sb.append(", city=");
        sb.append(city);
        sb.append(", country=");
        sb.append(country);
        sb.append(", permissions=");
        sb.append(permissions);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHRegion toEntityModel() {
        AHRegionImpl ahRegionImpl = new AHRegionImpl();

        ahRegionImpl.setRegionId(regionId);
        ahRegionImpl.setZip(zip);

        if (city == null) {
            ahRegionImpl.setCity(StringPool.BLANK);
        } else {
            ahRegionImpl.setCity(city);
        }

        if (country == null) {
            ahRegionImpl.setCountry(StringPool.BLANK);
        } else {
            ahRegionImpl.setCountry(country);
        }

        ahRegionImpl.setPermissions(permissions);

        ahRegionImpl.resetOriginalValues();

        return ahRegionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        regionId = objectInput.readLong();
        zip = objectInput.readInt();
        city = objectInput.readUTF();
        country = objectInput.readUTF();
        permissions = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(regionId);
        objectOutput.writeInt(zip);

        if (city == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(city);
        }

        if (country == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(country);
        }

        objectOutput.writeInt(permissions);
    }
}
