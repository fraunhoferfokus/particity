package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.particity.model.AHCategories;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHCategories in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHCategories
 * @generated
 */
public class AHCategoriesCacheModel implements CacheModel<AHCategories>,
    Externalizable {
    public long catId;
    public String name;
    public String descr;
    public int type;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{catId=");
        sb.append(catId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", descr=");
        sb.append(descr);
        sb.append(", type=");
        sb.append(type);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHCategories toEntityModel() {
        AHCategoriesImpl ahCategoriesImpl = new AHCategoriesImpl();

        ahCategoriesImpl.setCatId(catId);

        if (name == null) {
            ahCategoriesImpl.setName(StringPool.BLANK);
        } else {
            ahCategoriesImpl.setName(name);
        }

        if (descr == null) {
            ahCategoriesImpl.setDescr(StringPool.BLANK);
        } else {
            ahCategoriesImpl.setDescr(descr);
        }

        ahCategoriesImpl.setType(type);

        ahCategoriesImpl.resetOriginalValues();

        return ahCategoriesImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        catId = objectInput.readLong();
        name = objectInput.readUTF();
        descr = objectInput.readUTF();
        type = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
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

        objectOutput.writeInt(type);
    }
}
