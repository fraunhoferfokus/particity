package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;

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
