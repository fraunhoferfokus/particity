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
package de.fraunhofer.fokus.oefit.adhoc.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHRegionPK implements Comparable<AHRegionPK>, Serializable {
    public long regionId;
    public int zip;
    public String city;
    public String country;

    public AHRegionPK() {
    }

    public AHRegionPK(long regionId, int zip, String city, String country) {
        this.regionId = regionId;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int compareTo(AHRegionPK pk) {
        if (pk == null) {
            return -1;
        }

        int value = 0;

        if (regionId < pk.regionId) {
            value = -1;
        } else if (regionId > pk.regionId) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        if (zip < pk.zip) {
            value = -1;
        } else if (zip > pk.zip) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = city.compareTo(pk.city);

        if (value != 0) {
            return value;
        }

        value = country.compareTo(pk.country);

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHRegionPK)) {
            return false;
        }

        AHRegionPK pk = (AHRegionPK) obj;

        if ((regionId == pk.regionId) && (zip == pk.zip) &&
                (city.equals(pk.city)) && (country.equals(pk.country))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (String.valueOf(regionId) + String.valueOf(zip) +
        String.valueOf(city) + String.valueOf(country)).hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(20);

        sb.append(StringPool.OPEN_CURLY_BRACE);

        sb.append("regionId");
        sb.append(StringPool.EQUAL);
        sb.append(regionId);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("zip");
        sb.append(StringPool.EQUAL);
        sb.append(zip);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("city");
        sb.append(StringPool.EQUAL);
        sb.append(city);

        sb.append(StringPool.COMMA);
        sb.append(StringPool.SPACE);
        sb.append("country");
        sb.append(StringPool.EQUAL);
        sb.append(country);

        sb.append(StringPool.CLOSE_CURLY_BRACE);

        return sb.toString();
    }
}
