package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHRegion;

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
    public String zip;
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

        if (zip == null) {
            ahRegionImpl.setZip(StringPool.BLANK);
        } else {
            ahRegionImpl.setZip(zip);
        }

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
        zip = objectInput.readUTF();
        city = objectInput.readUTF();
        country = objectInput.readUTF();
        permissions = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(regionId);

        if (zip == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(zip);
        }

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
