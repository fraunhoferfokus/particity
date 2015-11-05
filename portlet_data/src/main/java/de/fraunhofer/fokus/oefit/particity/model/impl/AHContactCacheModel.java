package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHContact;

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
