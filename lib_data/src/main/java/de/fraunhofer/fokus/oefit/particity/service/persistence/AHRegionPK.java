package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHRegionPK implements Comparable<AHRegionPK>, Serializable {
    public long regionId;
    public String zip;
    public String city;
    public String country;

    public AHRegionPK() {
    }

    public AHRegionPK(long regionId, String zip, String city, String country) {
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
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

        value = zip.compareTo(pk.zip);

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

        if ((regionId == pk.regionId) && (zip.equals(pk.zip)) &&
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
