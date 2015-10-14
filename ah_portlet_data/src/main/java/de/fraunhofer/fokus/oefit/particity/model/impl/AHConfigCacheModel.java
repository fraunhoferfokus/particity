package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHConfig
 * @generated
 */
public class AHConfigCacheModel implements CacheModel<AHConfig>, Externalizable {
    public String name;
    public String value;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{name=");
        sb.append(name);
        sb.append(", value=");
        sb.append(value);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHConfig toEntityModel() {
        AHConfigImpl ahConfigImpl = new AHConfigImpl();

        if (name == null) {
            ahConfigImpl.setName(StringPool.BLANK);
        } else {
            ahConfigImpl.setName(name);
        }

        if (value == null) {
            ahConfigImpl.setValue(StringPool.BLANK);
        } else {
            ahConfigImpl.setValue(value);
        }

        ahConfigImpl.resetOriginalValues();

        return ahConfigImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        name = objectInput.readUTF();
        value = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (value == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(value);
        }
    }
}
