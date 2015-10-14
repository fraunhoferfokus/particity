package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHAddr;

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
    public float coordLat;
    public float coordLon;
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

        ahAddrImpl.setCoordLat(coordLat);
        ahAddrImpl.setCoordLon(coordLon);
        ahAddrImpl.setRegionId(regionId);

        ahAddrImpl.resetOriginalValues();

        return ahAddrImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        addrId = objectInput.readLong();
        street = objectInput.readUTF();
        number = objectInput.readUTF();
        coordLat = objectInput.readFloat();
        coordLon = objectInput.readFloat();
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

        objectOutput.writeFloat(coordLat);
        objectOutput.writeFloat(coordLon);
        objectOutput.writeLong(regionId);
    }
}
