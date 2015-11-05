package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHCatEntries in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntries
 * @generated
 */
public class AHCatEntriesCacheModel implements CacheModel<AHCatEntries>,
    Externalizable {
    public long itemId;
    public long catId;
    public String name;
    public String descr;
    public long parentId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{itemId=");
        sb.append(itemId);
        sb.append(", catId=");
        sb.append(catId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", descr=");
        sb.append(descr);
        sb.append(", parentId=");
        sb.append(parentId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHCatEntries toEntityModel() {
        AHCatEntriesImpl ahCatEntriesImpl = new AHCatEntriesImpl();

        ahCatEntriesImpl.setItemId(itemId);
        ahCatEntriesImpl.setCatId(catId);

        if (name == null) {
            ahCatEntriesImpl.setName(StringPool.BLANK);
        } else {
            ahCatEntriesImpl.setName(name);
        }

        if (descr == null) {
            ahCatEntriesImpl.setDescr(StringPool.BLANK);
        } else {
            ahCatEntriesImpl.setDescr(descr);
        }

        ahCatEntriesImpl.setParentId(parentId);

        ahCatEntriesImpl.resetOriginalValues();

        return ahCatEntriesImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        itemId = objectInput.readLong();
        catId = objectInput.readLong();
        name = objectInput.readUTF();
        descr = objectInput.readUTF();
        parentId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(itemId);
        objectOutput.writeLong(catId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (descr == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(descr);
        }

        objectOutput.writeLong(parentId);
    }
}
